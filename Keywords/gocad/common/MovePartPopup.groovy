package gocad.common

import java.nio.file.Files
import java.nio.file.Paths
import org.openqa.selenium.WebDriver

import org.openqa.selenium.Keys

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage
import katalon.utility.CommonUtility

public class MovePartPopup extends BasePage<MovePartPopup> {


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

	public MovePartPopup inputProjectToCopy(String projectName) {
		WebUI.setText(xpath("//*[@class='ant-input-prefix']/following::input[@type='search']"), projectName)
		WebUI.click(xpath("//*[@class='rc-virtual-list']//div[@title='$projectName']"))
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
		String formattedSum = "${String.format("%.2f", expectedResult)} €"
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

	public MovePartPopup verifyToastMessageWhenCopyProject(String fileName, String projectName) {
		def actualTitle = WebUI.getText(xpath("//*[@class='ant-notification-notice-message']"))
		def actualMessage = WebUI.getText(xpath("//*[@class='ant-notification-notice-description']"))
		def expectedTitle = ""
		def expectedMessage = "$fileName copied to \"$projectName\""
		WebUI.verifyEqual(actualTitle, expectedTitle)
		WebUI.verifyEqual(actualMessage, expectedMessage)
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
