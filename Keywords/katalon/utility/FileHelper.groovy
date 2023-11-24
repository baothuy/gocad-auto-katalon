package katalon.utility

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths

import org.apache.commons.io.FileUtils
import org.apache.pdfbox.Loader
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


public class FileHelper {
	String path;

	public FileHelper(String path) {
		this.path = path;
	}

	private static String readFile(String fileName) {
		try {
			//String downloadFolderPath = System.getProperty("user.home") + "\\Downloads\\"
			//windown
			//String downloadFolderPath = "C:\\katalon\\studio\\configuration\\resources\\tools\\TestOps\\downloads"
			//linux
			String downloadFolderPath = "/opt/katalonstudio/configuration/resources/tools/TestOps/downloads"
			return FileUtils.readFileToString(new File(downloadFolderPath + fileName), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String readDetailContentFile(String fileName) {
		// Define the path where the file will be downloaded
		//String downloadFolderPath = System.getProperty("user.home") + "\\Downloads\\" + fileName
		String downloadFolderPath = "C:\\katalon\\studio\\configuration\\resources\\tools\\TestOps\\downloads" + fileName
		PDDocument document = Loader.loadPDF(new File(downloadFolderPath))
		try {
			// Create a PDFTextStripper object
			PDFTextStripper pdfTextStripper = new PDFTextStripper()
			// Extract text from the PDF
			String extractedText = pdfTextStripper.getText(document)
			println "extractedText: $extractedText"
			return extractedText
		}
		finally { document.close() }
		return this
	}

	public FileHelper verifyFileDownloaded(String fileName) {
		println "fileName: $fileName"
		// Define the path where the file will be downloaded
		//String downloadFolderPath = System.getProperty("user.home") + "\\Downloads\\"
		String downloadFolderPath = "/opt/katalonstudio/configuration/resources/tools/TestOps/downloads"
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
}
