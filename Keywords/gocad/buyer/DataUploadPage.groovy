package gocad.buyer

import com.kms.katalon.core.configuration.RunConfiguration
import java.io.File
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import katalon.fw.lib.BasePage

public class DataUploadPage extends BasePage<DataUploadPage> {

	public DataUploadPage clickOpenFileUpload() {
		WebUI.click(xpath('//span[@class="ant-upload ant-upload-btn"]'))
	}

	public DataUploadPage uploadFileTesting(String fileName) {
		WebUI.waitForElementVisible(xpath('//input[@type="file"]'), 5)
		def path = RunConfiguration.getProjectDir() + "/Data/FileTesting/$fileName"
		WebUI.uploadFile(xpath('//input[@type="file"]'), path)
		refreshUntilTextPresent("Quantity", GlobalVariable.sleepLargeTime, GlobalVariable.smallSleepTime)
		return this
	}
}
