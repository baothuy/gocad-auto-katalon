package gocad.seller

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import gocad.common.DataUploadPage
import internal.GlobalVariable
import katalon.fw.lib.BasePage




public class MaterialSettingsPage extends BasePage<MaterialSettingsPage>{

	def idCol = { String materialName -> return xpath("//*[text()='$materialName']/parent::tr/td[1]")}
	def materialGroupCol = { String materialName -> return xpath("//*[text()='$materialName']/parent::tr/td[2]/button")}
	def cuttingParamsCol = { String materialName -> return xpath("//*[text()='$materialName']/parent::tr/td[3]")}
	def materialNameCol = { String materialName -> return xpath("//*[text()='$materialName']/parent::tr/td[4]")}
	def numberCol = { String materialName -> return xpath("//*[text()='$materialName']/parent::tr/td[5]")}
	def densityCol = { String materialName -> return xpath("//*[text()='$materialName']/parent::tr/td[6]")}
	def pricePerKiloCol = { String materialName -> return xpath("//*[text()='$materialName']/parent::tr/td[7]")}
	def statusCol = { String materialName -> return xpath("//*[text()='$materialName']/parent::tr/td[8]//span[normalize-space(text()) != '']")}
	def editActionCol = { String materialName -> return xpath("//*[text()='$materialName']/parent::tr/td[9]/button")}
	def row = { String row -> return "//*[@class='ant-table-tbody']/tr[$row]"}
	def rowByStatus = { String status -> return "(//span[normalize-space(text()) = '$status']/ancestor::tr)[1]"}

	public MaterialSettingsPage clickEditSurchargeRawMaterialButton() {
		WebUI.click(xpath("(//span[@aria-label='edit']/parent::button)[1]"))
		return this
	}

	public MaterialSettingsPage clickAcceptChangeSurchargeRawMaterialButton() {
		WebUI.click(xpath("//span[@aria-label='check']/parent::button"))
		return this
	}

	public MaterialSettingsPage clickCloseChangeSurchargeRawMaterialButton() {
		WebUI.click(xpath("//span[@aria-label='close']/parent::button"))
		return this
	}

	public MaterialSettingsPage clickNewMaterialButton() {
		WebUI.click(xpath("//span[text()='New Material']"))
		return this
	}

	public MaterialSettingsPage clickCSVImportButton() {
		WebUI.click(xpath("//span[text()='  CSV Import']"))
		return this
	}

	public MaterialSettingsPage clickCSVExportButton() {
		WebUI.click(xpath("//span[text()='CSV Export']"))
		return this
	}

	public MaterialSettingsPage inputSearchMaterial(String input) {
		clearTextAndSendKeysByActions(xpath("//input[@placeholder='Search material']"), input)
		return this
	}

	public MaterialSettingsPage inputSurchargeRound(String input) {
		clearTextAndSendKeysByActions(id("outerDiameterShape"), input)
		return this
	}

	public MaterialSettingsPage inputSurchargeRectangular(String input) {
		clearTextAndSendKeysByActions(id("lwhsShape"), input)
		return this
	}
	
	public MaterialSettingsPage uploadFileTesting(String fileName) {
		def path = RunConfiguration.getProjectDir() + "/Data/FileTesting/$fileName"
		println "path: $path"
		WebUI.uploadFile(xpath("//input[@type='file']"), path)
		WebUI.waitForElementPresent(xpath("//*[@for='materialId']"), GlobalVariable.sleepLargeTime)
		return this
	}

	public MaterialSettingsPage removeContentSearch() {
		WebUI.click(xpath("//*[@aria-label='close-circle']"))
		return this
	}

	public MaterialSettingsPage clickEditButton(String materialName) {
		WebUI.click(editActionCol(materialName))
		return this
	}

	public MaterialSettingsPage verifyMaterialGroupVisibleOnList(String materialName) {
		WebUI.click(materialGroupCol(materialName))
		return this
	}

	public MaterialSettingsPage verifyIdValue(String materialName, String expectedResult) {
		String actualResult = WebUI.getText(idCol(materialName))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MaterialSettingsPage verifyMaterialGroupValue(String materialName, String expectedResult) {
		String actualResult = WebUI.getText(materialGroupCol(materialName))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MaterialSettingsPage verifyCuttingParamsValue(String materialName, String expectedResult) {
		String actualResult = WebUI.getText(cuttingParamsCol(materialName))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MaterialSettingsPage verifyMaterialNameValue(String materialName) {
		String actualResult = WebUI.getText(materialNameCol(materialName))
		WebUI.verifyEqual(actualResult, materialName)
		return this
	}

	public MaterialSettingsPage verifyNumberValue(String materialName, String expectedResult) {
		String actualResult = WebUI.getText(numberCol(materialName))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MaterialSettingsPage verifyDensityValue(String materialName, String expectedResult) {
		String actualResult = WebUI.getText(densityCol(materialName))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MaterialSettingsPage verifyPricePerKiloValue(String materialName, String expectedResult) {
		String actualResult = WebUI.getText(pricePerKiloCol(materialName))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MaterialSettingsPage verifyStatusValue(String materialName, String expectedResult) {
		String actualResult = WebUI.getText(statusCol(materialName))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public MaterialSettingsPage verifyToastMessage(String expectedTitle, String expectedMessage) {
		def actualTitle = WebUI.getText(xpath("//*[@class='ant-notification-notice-message']"))
		def actualMessage = WebUI.getText(xpath("//*[@class='ant-notification-notice-description']"))
		WebUI.verifyEqual(actualTitle, expectedTitle)
		WebUI.verifyEqual(actualMessage, expectedMessage)
		return this
	}
	
	public MaterialSettingsPage verifyShowErrorWhenSurchargeRoundEmpty(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='outerDiameterShape_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public MaterialSettingsPage verifyShowErrorWhenSurchargeRectangularEmpty(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='lwhsShape_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public List<String> getDataRow(String rowNumber) {
		String id = WebUI.getText(xpath(row(rowNumber) + "/td[1]"))
		String materialGroup = WebUI.getText(xpath(row(rowNumber) + "/td[2]/button"))
		String cuttingParams = WebUI.getText(xpath(row(rowNumber) + "/td[3]"))
		String materialName = WebUI.getText(xpath(row(rowNumber) + "/td[4]"))
		String number = WebUI.getText(xpath(row(rowNumber) + "/td[5]"))
		String density = WebUI.getText(xpath(row(rowNumber) + "/td[6]"))
		String pricePerKilo = WebUI.getText(xpath(row(rowNumber) + "/td[7]"))
		String status = WebUI.getText(xpath(row(rowNumber) + "/td[8]//span[normalize-space(text()) != '']"))
		List<String> dataRow = [id, materialGroup, cuttingParams, materialName, number, density, pricePerKilo, status]
		println "dataRow: $dataRow"
		return dataRow
	}

	public List<String> getDataRowByStatus(String status) {
		String id = WebUI.getText(xpath(rowByStatus(status) + "/td[1]"))
		String materialGroup = WebUI.getText(xpath(rowByStatus(status) + "/td[2]/button"))
		String cuttingParams = WebUI.getText(xpath(rowByStatus(status) + "/td[3]"))
		String materialName = WebUI.getText(xpath(rowByStatus(status) + "/td[4]"))
		String number = WebUI.getText(xpath(rowByStatus(status) + "/td[5]"))
		String density = WebUI.getText(xpath(rowByStatus(status) + "/td[6]"))
		String pricePerKilo = WebUI.getText(xpath(rowByStatus(status) + "/td[7]"))
		List<String> dataRow = [id, materialGroup, cuttingParams, materialName, number, density, pricePerKilo]
		return dataRow
	}

	public MaterialSettingsPage verifyUIVisible() {
		WebUI.verifyElementVisible(xpath("(//span[@aria-label='edit']/parent::button)[1]"))
		WebUI.verifyElementVisible(xpath("//span[@aria-label='edit']/parent::button"))
		WebUI.verifyElementVisible(xpath("//span[text()='New Material']"))
		WebUI.verifyElementVisible(xpath("//span[text()='  CSV Import']"))
		WebUI.verifyElementVisible(xpath("//span[text()='CSV Export']"))
		WebUI.verifyElementVisible(xpath("//input[@placeholder='Search material']"))
		WebUI.verifyElementVisible(id("outerDiameterShape"))
		WebUI.verifyElementVisible(id("lwhsShape"))
		WebUI.verifyElementVisible(xpath("//*[text()='Id']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Material Group']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Cutting Params']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Name']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Number']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Density']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Price per Kilo']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Status']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Action']"))
		return this
	}
}
