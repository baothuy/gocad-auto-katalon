package gocad.common

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

	public DataUploadPage uploadFileTesting(String workflow, String fileName) {
		WebUI.waitForElementVisible(xpath('//*[@class="ant-card-body"]'), 5)
		WebUI.click(xpath("//p[text()='$workflow']/ancestor::div[@class='ant-card-body']"))
		def path = RunConfiguration.getProjectDir() + "/Data/FileTesting/$fileName"
		WebUI.uploadFile(xpath("//div[@class='mt-5']//span[@class='ant-upload ant-upload-btn']/input[@type='file']"), path)
		refreshUntilTextPresent("Quantity", GlobalVariable.sleepLargeTime, GlobalVariable.smallSleepTime)
		return this
	}

	public DataUploadPage clickWorkflow(String workflow) {
		WebUI.waitForElementVisible(xpath('//*[@class="ant-card-body"]'), 5)
		WebUI.click(xpath("//p[text()='$workflow']/ancestor::div[@class='ant-card-body']"))
		return this
	}

	public DataUploadPage verifyUIDataUploadPage(String projectName) {
		WebUI.verifyElementVisible(xpath("//span[text()='$projectName']"))
		WebUI.verifyElementVisible(xpath("//div[text()='Data upload']/parent::div/preceding-sibling::div//*[text()='1']"))
		WebUI.verifyElementVisible(xpath("//div[text()='Manufacturing information']/parent::div/preceding-sibling::div//*[text()='2']"))
		WebUI.verifyElementVisible(xpath("//div[text()='Review']/parent::div/preceding-sibling::div//*[text()='3']"))
		WebUI.verifyElementVisible(xpath("//div[text()='Checkout']/parent::div/preceding-sibling::div//*[text()='4']"))
		WebUI.verifyElementVisible(xpath("//div[text()='Completed']/parent::div/preceding-sibling::div//*[text()='5']"))
		WebUI.verifyElementVisible(xpath("//span[@role='img']/*[@data-icon='inbox']"))
		WebUI.verifyElementVisible(xpath("//p[text()='Upload CAD file']"))
		WebUI.verifyElementVisible(xpath("//p[text()='You can upload a CAD file. Supported formats are: STEP, JT, SolidWorks, Solid Edge, Autodesk Inventor, Siemens NX, CATIA V5, Creo Parametric']"))
		return this
	}
}