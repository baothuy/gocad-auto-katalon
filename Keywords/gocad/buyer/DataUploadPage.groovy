package gocad.buyer

import com.kms.katalon.core.configuration.RunConfiguration
import java.io.File
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import katalon.fw.lib.BasePage

public class DataUploadPage extends BasePage<DataUploadPage> {

	public DataUploadPage clickOpenFileUpload() {
		WebUI.click(xpath('//span[@class="ant-upload ant-upload-btn"]'))
		return this
	}
	
	public String getIdProject() {
		WebUI.waitForElementVisible(xpath('//div[text()="Data upload"]'), 5)
		String url = WebUI.getUrl()
		println "url: $url"
		// Extract the number using regular expressions
		def number = url =~ /\d+/
		String extractedNumber = Integer.parseInt(number[0]).toString()
		println "Number: " + extractedNumber
		return extractedNumber
	}

	public DataUploadPage uploadFileTesting(String fileName) {
		WebUI.waitForElementVisible(xpath('//input[@type="file"]'), 5)
		def path = RunConfiguration.getProjectDir() + "/Data/FileTesting/$fileName"
		WebUI.uploadFile(xpath('//input[@type="file"]'), path)
		refreshUntilTextPresent("Quantity", GlobalVariable.sleepLargeTime, GlobalVariable.smallSleepTime)
		return this
	}
}
