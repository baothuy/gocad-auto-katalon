package katalon.utility

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths

import org.apache.commons.io.FileUtils
import org.apache.pdfbox.Loader
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


public class FileHelper {
	String path;

	public FileHelper(String path) {
		this.path = path;
	}

	private static String readFile(String fileName) {
		try {
			String downloadFolderPath = getDownloadLocationPath()
			return FileUtils.readFileToString(new File(downloadFolderPath + fileName), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String readDetailContentFile(String fileName) {
		String downloadFolderPath = getDownloadLocationPath() + fileName
		PDDocument document = Loader.loadPDF(new File(downloadFolderPath))
		try {
			PDFTextStripper pdfTextStripper = new PDFTextStripper()
			String extractedText = pdfTextStripper.getText(document)
			println "extractedText: $extractedText"
			return extractedText
		}
		finally {
			document.close()
		}
		return this
	}

	public FileHelper verifyFileDownloaded(String fileName) {
		println "fileName: $fileName"
		// Define the path where the file will be downloaded
		String downloadFolderPath = getDownloadLocationPath()
		println "downloadFolderPath: $downloadFolderPath"
		// Clear the downloaded file before verify
		Files.deleteIfExists(Paths.get(downloadFolderPath, fileName))
		// Wait for the file to be downloaded
		boolean isDownloaded = false
		int timeoutInSeconds = 60 // Maximum wait time
		int pollingIntervalInMillis = 1000 // Polling interval
		long endTime = System.currentTimeMillis() + timeoutInSeconds * 1000
		while (System.currentTimeMillis() < endTime) {
			if (Files.exists(Paths.get(downloadFolderPath, fileName))) {
				isDownloaded = true
				break
			}
		}
		// Verify the download
		if (isDownloaded) {
			println "File downloaded successfully."
			String actualResult = "File downloaded successfully."
			WebUI.verifyEqual(actualResult, "File downloaded successfully.")
		}
		else {
			println "File download failed."
			String actualResult = "File download failed."
			WebUI.verifyEqual(actualResult, "File downloaded successfully.")
		}
		return this
	}

	public static String getDownloadLocationPath() {
		return System.getProperty("user.home") + "${File.separator}Downloads${File.separator}"
	}
}
