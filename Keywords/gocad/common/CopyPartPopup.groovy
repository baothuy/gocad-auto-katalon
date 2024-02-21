package gocad.common

import org.openqa.selenium.Keys

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import katalon.fw.lib.BasePage
import katalon.utility.CommonUtility

public class CopyPartPopup extends BasePage<CopyPartPopup> {

	List<String> sheetMetalPartFileAllow = GlobalVariable.sheetMetalPartFileAllow
	List<String> milledPartFileAllow = GlobalVariable.milledPartFileAllow

	public CopyPartPopup clickImagePart() {
		WebUI.click(xpath('//img[@class="ant-image-img"]/following-sibling::div/span'))
		return this
	}

	public CopyPartPopup clickDownloadImage() {
		WebUI.click(xpath('//a[@class="text-decoration-none"]'))
		return this
	}

	public CopyPartPopup clickOK() {
		WebUI.click(xpath('//span[text()="OK"]'))
		return this
	}

	public CopyPartPopup clickCancel() {
		WebUI.click(xpath('//span[text()="Cancel"]'))
		return this
	}

	public CopyPartPopup clickSelectProject() {
		WebUI.click(xpath('//span[text()="Cancel"]'))
		return this
	}

	public CopyPartPopup inputProjectToCopy(String projectName) {
		clearTextAndSendKeysByActions(xpath("//*[@class='ant-modal-body']//*[@class='ant-input-prefix']/following::input[@type='search']"), projectName)
		WebUI.click(xpath("//*[@class='rc-virtual-list']//div[@title='$projectName']"))
		return this
	}

	public CopyPartPopup verifyPDFFileVisibleAfterCalculated(String fileName) {
		String href = WebUI.getAttribute(xpath("//a[@class='text-decoration-none' and @title='$fileName']/parent::label/following-sibling::label/a"), "href")
		WebUI.verifyElementVisible(xpath("//a[@href='$href']"))
		return this
	}

	public CopyPartPopup clickPDFFileToDownload(String fileName) {
		WebUI.click(xpath("//a[@class='text-decoration-none' and contains(@title, 'pdf')]"))
		return this
	}

	public CopyPartPopup clickPartFileToDownload(String fileName) {
		WebUI.click(xpath("//a[@class='text-decoration-none' and contains(@title, '$fileName')]"))
		return this
	}

	public CopyPartPopup verifyMaterialValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Material']/following-sibling::div")).trim()		
		def pattern = /^(.*?)\/[0-9.]+$/
		actualResult = CommonUtility.substringUseRegExp(actualResult, pattern, 1)
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CopyPartPopup verifyQuantityValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Quantity']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CopyPartPopup verifyThreadValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Thread (Quantity)']/following-sibling::div")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CopyPartPopup verifyThreadCuttingValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Thread Cutting']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CopyPartPopup verifyTolerancesNumberValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Tolerances and fits with less than 1/10mm or IT 1 - IT 10 (Number)']/following-sibling::div")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CopyPartPopup verifyTolerancesToggleValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Tolerance requirement with smaller 1/100mm or IT 1 - IT 5']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CopyPartPopup verifySurfaceTreatmentValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Surface Treatment']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CopyPartPopup verifyRollingDirectionValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Rolling Direction']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CopyPartPopup verifyLaserMarkingValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Laser marking']/following-sibling::label")).trim()
		println "LaserMarkingValue: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CopyPartPopup verifyCountersinkValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Countersink']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CopyPartPopup verifyThicknessValue(String partName, String expectedResult) {
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

	public CopyPartPopup verifyCuttingLayersValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Cutting layers']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CopyPartPopup verifyDeburringValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Deburring']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CopyPartPopup verifyPartAccordingToTheDrawingValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Part according to the drawing']/following-sibling::label")).trim()
		def actualResultCon = (actualResult == "No") ? "false" : "true"
		WebUI.verifyEqual(actualResultCon, expectedResult)
		return this
	}

	public CopyPartPopup verifySurfaceQualityValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Surface Quality']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CopyPartPopup verifyAdditionalCommentsValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Additional Comments']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CopyPartPopup verifyUnitPriceValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Unit price']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CopyPartPopup verifyNetPriceValue(String expectedResult) {
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

	public CopyPartPopup verifyShowErrorIncompatibleFile() {
		WebUI.verifyElementVisible(xpath("//div[text()='There is problem when calculating the request. Please contact the admin.']"))
		return this
	}

	public CopyPartPopup verifyCanPreviewPartFile() {
		WebUI.click(xpath('//img[@class="ant-image-img"]/following-sibling::div/span'))
		waitUntilElementInvisibleWithWebDriverWait(xpath("//div[@class='ant-modal-mask']/following::div[@class='icon-loading']"), 10)
		WebUI.verifyElementVisible(xpath("//div[@class='ant-modal-body']/*[@class='classmateCloudFrame']"))
		return this
	}

	public CopyPartPopup clickClosePreviewPartFilePopup() {
		waitUntilElementVisibleWithWebDriverWait(xpath("//div[@class='ant-modal-mask']/following::button[@class='ant-modal-close']"), 10)
		WebUI.click(xpath("//div[@class='ant-modal-mask']/following::button[@class='ant-modal-close']"))
		return this
	}

	public CopyPartPopup clickClosePopup() {
		WebUI.click(xpath("//*[@aria-label='close']/parent::span"))
		return this
	}

	public CopyPartPopup verifyLinkPartVisible(String fileName) {
		WebUI.verifyElementVisible(xpath("//span[text()='$fileName']"))
		return this
	}

	public CopyPartPopup verifyNamePartVisible(String fileName) {
		WebUI.verifyElementVisible(xpath("//span[text()='$fileName']"))
		return this
	}

	public CopyPartPopup verifyNameWorkflowVisible(String workflow) {
		WebUI.verifyElementVisible(xpath("//label[text()='$workflow']"))
		return this
	}

	public CopyPartPopup verifyToastMessageWhenCopyProject(String fileName, String projectName) {
		def actualTitle = WebUI.getText(xpath("//*[@class='ant-notification-notice-message']"))
		def actualMessage = WebUI.getText(xpath("//*[@class='ant-notification-notice-description']"))
		def expectedTitle = ""
		def expectedMessage = "$fileName copied to \"$projectName\""
		WebUI.verifyEqual(actualTitle, expectedTitle)
		WebUI.verifyEqual(actualMessage, expectedMessage)
		return this
	}

	public CopyPartPopup verifyContentAlertManualCalculateVisible() {
		WebUI.verifyElementVisible(xpath("//*[@class='ant-alert-message']"))
		def contentAlertActual = WebUI.getText(xpath("//*[@class='ant-alert-message']"))
		def expectedResult = "These parts cannot be automatically calculated. You can request a manual offer by the seller. All parts that could not automatically be calculated are bundled in this separate list."
		WebUI.verifyEqual(contentAlertActual, expectedResult)
		return this
	}

	public CopyPartPopup verifyUICopyPopupVisible() {
		// input partname
		WebUI.verifyElementVisible(xpath("//*[@class='input-inline-api']"))
		// file download file cad and pdf
		WebUI.verifyElementVisible(xpath("//*[text()='Material']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Quantity']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Thread (Quantity)']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Tolerances and fits with less than 1/10mm or IT 1 - IT 10 (Number)']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Surface Quality']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Additional Comments']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Unit price']"))
		WebUI.verifyElementVisible(xpath("//*[text()='NET Total']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Unit price']"))
		WebUI.verifyElementVisible(xpath("//*[text()='NET Total']"))
		//input project name and button
		WebUI.verifyElementVisible(xpath("//input[@placeholder='Type project name']"))
		WebUI.verifyElementVisible(xpath("//*[text()='OK']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Cancel']"))
		return this
	}
}
