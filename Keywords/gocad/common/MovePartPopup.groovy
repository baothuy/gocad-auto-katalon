package gocad.common

import org.openqa.selenium.Keys

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import katalon.fw.lib.BasePage

public class MovePartPopup extends BasePage<MovePartPopup> {

	List<String> sheetMetalPartFileAllow = GlobalVariable.sheetMetalPartFileAllow
	List<String> milledPartFileAllow = GlobalVariable.milledPartFileAllow

	public MovePartPopup clickImagePart() {
		WebUI.click(xpath('//img[@class="ant-image-img"]/following-sibling::div/span'))
		return this
	}

	public MovePartPopup clickDownloadImage() {
		WebUI.click(xpath('//a[@class="text-decoration-none"]'))
		return this
	}

	public MovePartPopup clickOK() {
		WebUI.click(xpath('//span[text()="OK"]'))
		return this
	}

	public MovePartPopup clickCancel() {
		WebUI.click(xpath('//span[text()="Cancel"]'))
		return this
	}

	public MovePartPopup clickSelectProject() {
		WebUI.click(xpath('//span[text()="Cancel"]'))
		return this
	}

	public MovePartPopup inputProjectToMove(String projectName) {
		WebUI.sendKeys(xpath("//*[@class='ant-input-prefix']/following::input[@type='search']"), projectName + Keys.ENTER)
		return this
	}

	public MovePartPopup verifyPDFFileVisibleAfterCalculated(String fileName) {
		String href = WebUI.getAttribute(xpath("//a[@class='text-decoration-none' and @title='$fileName']/parent::label/following-sibling::label/a"), "href")
		WebUI.verifyElementVisible(xpath("//a[@href='$href']"))
		return this
	}

	public MovePartPopup clickPDFFileToDownload(String fileName) {
		WebUI.click(xpath("//a[@class='text-decoration-none' and contains(@title, 'pdf')]"))
		return this
	}

	public MovePartPopup clickPartFileToDownload(String fileName) {
		WebUI.click(xpath("//a[@class='text-decoration-none' and contains(@title, '$fileName')]"))
		return this
	}

	public MovePartPopup verifyMaterialValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Material']/following-sibling::div")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MovePartPopup verifyQuantityValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Quantity']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MovePartPopup verifyThreadValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Thread (Quantity)']/following-sibling::div")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MovePartPopup verifyThreadCuttingValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Thread Cutting']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MovePartPopup verifyTolerancesNumberValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Tolerances and fits with less than 1/10mm or IT 1 - IT 10 (Number)']/following-sibling::div")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MovePartPopup verifyTolerancesToggleValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Tolerance requirement with smaller 1/100mm or IT 1 - IT 5']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MovePartPopup verifySurfaceTreatmentValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Surface Treatment']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MovePartPopup verifyRollingDirectionValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Rolling Direction']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MovePartPopup verifyLaserMarkingValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Laser marking']/following-sibling::label")).trim()
		println "LaserMarkingValue: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MovePartPopup verifyCountersinkValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Countersink']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MovePartPopup verifyThicknessValue(String partName, String expectedResult) {
		for (int i = 0; i < sheetMetalPartFileAllow.size(); i++) {
			def isContains = partName.contains(sheetMetalPartFileAllow[i])
			println "isContains: $isContains"
			if (isContains) {
				String actualResult = WebUI.getText(xpath("//*[text()='Thickness (mm)']/following-sibling::label")).trim()
				WebUI.verifyEqual(actualResult, expectedResult)
				println "actualResult: $actualResult"
			}
		}
		return this
	}

	public MovePartPopup verifyCuttingLayersValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Cutting layers']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MovePartPopup verifyDeburringValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Deburring']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MovePartPopup verifyPartAccordingToTheDrawingValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Part according to the drawing']/following-sibling::label")).trim()
		def actualResultCon = (actualResult == "No") ? "false" : "true"
		WebUI.verifyEqual(actualResultCon, expectedResult)
		return this
	}

	public MovePartPopup verifySurfaceQualityValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Surface Quality']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MovePartPopup verifyAdditionalCommentsValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Additional Comments']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MovePartPopup verifyUnitPriceValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Unit price']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MovePartPopup verifyNetPriceValue(String expectedResult) {
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

	public MovePartPopup verifyShowErrorIncompatibleFile() {
		WebUI.verifyElementVisible(xpath("//div[text()='There is problem when calculating the request. Please contact the admin.']"))
		return this
	}

	public MovePartPopup verifyCanPreviewPartFile() {
		WebUI.click(xpath('//img[@class="ant-image-img"]/following-sibling::div/span'))
		waitUntilElementInvisibleWithWebDriverWait(xpath("//div[@class='ant-modal-mask']/following::div[@class='icon-loading']"), 10)
		WebUI.verifyElementVisible(xpath("//div[@class='ant-modal-body']/*[@class='classmateCloudFrame']"))
		return this
	}

	public MovePartPopup clickClosePreviewPartFilePopup() {
		waitUntilElementVisibleWithWebDriverWait(xpath("//div[@class='ant-modal-mask']/following::button[@class='ant-modal-close']"), 10)
		WebUI.click(xpath("//div[@class='ant-modal-mask']/following::button[@class='ant-modal-close']"))
		return this
	}

	public MovePartPopup verifyLinkPartVisible(String fileName) {
		WebUI.verifyElementVisible(xpath("//span[text()='$fileName']"))
		return this
	}

	public MovePartPopup verifyNamePartVisible(String fileName) {
		WebUI.verifyElementVisible(xpath("//span[text()='$fileName']"))
		return this
	}

	public MovePartPopup verifyNameWorkflowVisible(String workflow) {
		WebUI.verifyElementVisible(xpath("//label[text()='$workflow']"))
		return this
	}

	public MovePartPopup verifyContentAlertManualCalculateVisible() {
		WebUI.verifyElementVisible(xpath("//*[@class='ant-alert-message']"))
		def contentAlertActual = WebUI.getText(xpath("//*[@class='ant-alert-message']"))
		def expectedResult = "These parts cannot be automatically calculated. You can request a manual offer by the seller. All parts that could not automatically be calculated are bundled in this separate list."
		WebUI.verifyEqual(contentAlertActual, expectedResult)
		return this
	}
}
