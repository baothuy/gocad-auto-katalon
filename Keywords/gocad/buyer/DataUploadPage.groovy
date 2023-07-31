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
	
	public DataUploadPage uploadFileTesting() {
		WebUI.delay(GlobalVariable.smallSleepTime)
		//String path = 'D:\\Automation Project\\gocad-automation-katalon\\Data\\FileTestingauto_Platte.step'
		String path = RunConfiguration.getProjectDir() + '/Data/FileTesting/auto_Platte.step'
		WebUI.uploadFile(xpath('//input[@type="file"]'), path)
		return this
	}

}
