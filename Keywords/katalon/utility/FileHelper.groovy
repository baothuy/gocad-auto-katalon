package katalon.utility

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths

import org.apache.commons.io.FileUtils
import org.apache.pdfbox.Loader
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper


public class FileHelper {
	String path;

	public FileHelper(String path) {
		this.path = path;
	}

	private static String readFile(String fileName) {
		try {
			String downloadFolderPath = System.getProperty("user.home") + "\\Downloads\\"
			return FileUtils.readFileToString(new File(downloadFolderPath + fileName), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String readDetailContentFile(String fileName) {
		// Define the path where the file will be downloaded
		String downloadFolderPath = System.getProperty("user.home") + "\\Downloads\\" + fileName
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
		// Define the path where the file will be downloaded
		String downloadFolderPath = System.getProperty("user.home") + "\\Downloads\\"
		String expectedFileName = "$fileName"
		// Clear the downloaded file before verify
		Files.deleteIfExists(Paths.get(downloadFolderPath, expectedFileName))
		// Wait for the file to be downloaded
		boolean isDownloaded = false
		int timeoutInSeconds = 60 // Maximum wait time
		int pollingIntervalInMillis = 1000 // Polling interval
		long endTime = System.currentTimeMillis() + timeoutInSeconds * 1000
		while (System.currentTimeMillis() < endTime) {
			if (Files.exists(Paths.get(downloadFolderPath, expectedFileName))) {
				isDownloaded = true
				break
			}
		}
		// Verify the download
		if (isDownloaded) { println "File downloaded successfully." }
		else { println "File download failed." }
		return this
	}
}
