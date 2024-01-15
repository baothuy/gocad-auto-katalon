package gocad.common

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import katalon.fw.lib.BasePage
import katalon.utility.CommonUtility

public class ViewPartPopup extends BasePage<ViewPartPopup> {

	List<String> sheetMetalPartFileAllow = GlobalVariable.sheetMetalPartFileAllow
	List<String> milledPartFileAllow = GlobalVariable.milledPartFileAllow

	public ViewPartPopup clickImagePart() {
		WebUI.click(xpath('//img[@class="ant-image-img"]/following-sibling::div/span'))
		return this
	}

	public ViewPartPopup clickDownloadImage() {
		WebUI.click(xpath('//a[@class="text-decoration-none"]'))
		return this
	}

	public ViewPartPopup clickOK() {
		WebUI.click(xpath('//span[text()="OK"]'))
		return this
	}

	public ViewPartPopup clickCancel() {
		WebUI.click(xpath('//span[text()="Cancel"]'))
		return this
	}

	public ViewPartPopup clickSelectProject() {
		WebUI.click(xpath('//span[text()="Cancel"]'))
		return this
	}

	public ViewPartPopup inputProjectToCopy(String projectName) {
		WebUI.setText(xpath("//*[@class='ant-input-prefix']/following::input[@type='search']"), projectName)
		WebUI.click(xpath("//*[@class='rc-virtual-list']//div[@title='$projectName']"))
		return this
	}

	public ViewPartPopup verifyPDFFileVisibleAfterCalculated(String fileName) {
		String href = WebUI.getAttribute(xpath("//a[@class='text-decoration-none' and @title='$fileName']/parent::label/following-sibling::label/a"), "href")
		WebUI.verifyElementVisible(xpath("//a[@href='$href']"))
		return this
	}

	public ViewPartPopup clickPDFFileToDownload(String fileName) {
		WebUI.click(xpath("//a[@class='text-decoration-none' and contains(@title, 'pdf')]"))
		return this
	}

	public ViewPartPopup clickPartFileToDownload(String fileName) {
		WebUI.click(xpath("//a[@class='text-decoration-none' and contains(@title, '$fileName')]"))
		return this
	}

	public ViewPartPopup verifyMaterialValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Material']/following-sibling::div")).trim()
		println "actualResult: $actualResult"
		def pattern = /^(.*?)\/[0-9.]+$/
		String newActualResult = CommonUtility.substringUseRegExp(actualResult, pattern, 1)
		WebUI.verifyEqual(newActualResult, expectedResult)
		return this
	}

	public ViewPartPopup verifyQuantityValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Quantity']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ViewPartPopup verifyThreadValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Thread (Quantity)']/following-sibling::div")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ViewPartPopup verifyThreadCuttingValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Thread Cutting']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ViewPartPopup verifyTolerancesNumberValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Tolerances and fits with less than 1/10mm or IT 1 - IT 10 (Number)']/following-sibling::div")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ViewPartPopup verifyTolerancesToggleValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Tolerance requirement with smaller 1/100mm or IT 1 - IT 5']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ViewPartPopup verifySurfaceTreatmentValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Surface Treatment']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ViewPartPopup verifyRollingDirectionValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Rolling Direction']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ViewPartPopup verifyLaserMarkingValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Laser marking']/following-sibling::label")).trim()
		println "LaserMarkingValue: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ViewPartPopup verifyCountersinkValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Countersink']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ViewPartPopup verifyThicknessValue(String partName, String expectedResult) {
		for (int i = 0; i < sheetMetalPartFileAllow.size(); i++) {
			def isContains = partName.contains(sheetMetalPartFileAllow[i])
			println "isContains: $isContains"
			if (isContains) {
				String actualResult = WebUI.getText(xpath("//*[@class='ant-modal-content']//*[text()='Thickness']/parent::p")).trim()
				def pattern = /(\d+(?:\.\d+)?)/
				String newActualResult = CommonUtility.substringUseRegExp(actualResult,pattern,0)
				WebUI.verifyEqual(newActualResult, expectedResult)
				println "newActualResult: $newActualResult"
			}
		}
		return this
	}

	public ViewPartPopup verifyCuttingLayersValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Cutting layers']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ViewPartPopup verifyDeburringValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Deburring']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ViewPartPopup verifyPartAccordingToTheDrawingValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Part according to the drawing']/following-sibling::label")).trim()
		def actualResultCon = (actualResult == "No") ? "false" : "true"
		WebUI.verifyEqual(actualResultCon, expectedResult)
		return this
	}

	public ViewPartPopup verifySurfaceQualityValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Surface Quality']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ViewPartPopup verifyAdditionalCommentsValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Additional Comments']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ViewPartPopup verifyUnitPriceValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Unit price']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ViewPartPopup verifyNetPriceValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='NET Total']/following-sibling::h6")).trim()
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public String calculateNetPrice(String unitPrice, String quantity) {
		def numericValue = unitPrice.replaceAll(/[^\d.,]/, '').replace(',', '.').toDouble()
		def expectedResult = quantity.toDouble() * numericValue
		String formattedSum = "${String.format("%.2f", expectedResult)} $GlobalVariable.currency"
		String newExpectedResult = formattedSum.replace('.', ',')
		return newExpectedResult
	}

	public ViewPartPopup verifyShowErrorIncompatibleFile() {
		WebUI.verifyElementVisible(xpath("//div[text()='There is problem when calculating the request. Please contact the admin.']"))
		return this
	}

	public ViewPartPopup verifyCanPreviewPartFile() {
		WebUI.click(xpath('//img[@class="ant-image-img"]/following-sibling::div/span'))
		waitUntilElementInvisibleWithWebDriverWait(xpath("//div[@class='ant-modal-mask']/following::div[@class='icon-loading']"), 10)
		WebUI.verifyElementVisible(xpath("//div[@class='ant-modal-body']/*[@class='classmateCloudFrame']"))
		return this
	}

	public ViewPartPopup clickClosePreviewPartFilePopup() {
		waitUntilElementVisibleWithWebDriverWait(xpath("//div[@class='ant-modal-mask']/following::button[@class='ant-modal-close']"), 10)
		WebUI.click(xpath("//div[@class='ant-modal-mask']/following::button[@class='ant-modal-close']"))
		return this
	}

	public ViewPartPopup clickClosePopup() {
		WebUI.click(xpath("//*[@aria-label='close']/parent::span"))
		return this
	}

	public ViewPartPopup verifyLinkPartVisible(String fileName) {
		WebUI.verifyElementVisible(xpath("//span[text()='$fileName']"))
		return this
	}

	public ViewPartPopup verifyNamePartVisible(String fileName) {
		WebUI.verifyElementVisible(xpath("//span[text()='$fileName']"))
		return this
	}

	public ViewPartPopup verifyNameWorkflowVisible(String workflow) {
		WebUI.verifyElementVisible(xpath("//label[text()='$workflow']"))
		return this
	}

	public ViewPartPopup verifyToastMessageWhenCopyProject(String fileName, String projectName) {
		def actualTitle = WebUI.getText(xpath("//*[@class='ant-notification-notice-message']"))
		def actualMessage = WebUI.getText(xpath("//*[@class='ant-notification-notice-description']"))
		def expectedTitle = ""
		def expectedMessage = "$fileName copied to \"$projectName\""
		WebUI.verifyEqual(actualTitle, expectedTitle)
		WebUI.verifyEqual(actualMessage, expectedMessage)
		return this
	}

	public ViewPartPopup verifyContentAlertManualCalculateVisible() {
		WebUI.verifyElementVisible(xpath("//*[@class='ant-alert-message']"))
		def contentAlertActual = WebUI.getText(xpath("//*[@class='ant-alert-message']"))
		def expectedResult = "These parts cannot be automatically calculated. You can request a manual offer by the seller. All parts that could not automatically be calculated are bundled in this separate list."
		WebUI.verifyEqual(contentAlertActual, expectedResult)
		return this
	}

	public ViewPartPopup verifyUIViewPopupVisible() {
		// information part
		WebUI.verifyElementVisible(xpath("//*[text()='Material']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Quantity']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Thread (Quantity)']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Tolerances and fits with less than 1/10mm or IT 1 - IT 10 (Number)']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Surface Quality']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Additional Comments']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Unit price']"))
		WebUI.verifyElementVisible(xpath("//*[text()='NET Total']"))
		return this
	}
}
