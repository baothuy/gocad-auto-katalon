package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage




public class PriceAndDeliverySettingsSMFPage extends BasePage<PriceAndDeliverySettingsSMFPage>{

	public PriceAndDeliverySettingsSMFPage clickSaveChangesButton() {
		WebUI.click(xpath("//span[text()='Save Changes']/parent::button"))
		return this
	}

	public PriceAndDeliverySettingsSMFPage clickPreviewPricesButton() {
		WebUI.click(xpath("//span[text()='Preview Prices']/parent::button"))
		return this
	}

	public PriceAndDeliverySettingsSMFPage inputTransportAdditions(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalTransportAdditions"), input)
		return this
	}

	public PriceAndDeliverySettingsSMFPage inputDistributionTimeAdditions(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalDistributionTimeAdditions"), input)
		return this
	}

	public PriceAndDeliverySettingsSMFPage inputPersonalTimeAdditions(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalPersonalTimeAdditions"), input)
		return this
	}

	public PriceAndDeliverySettingsSMFPage inputTechnicalDiscussions(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalTechnicalDiscussions"), input)
		return this
	}

	public PriceAndDeliverySettingsSMFPage inputGeneralAdmin(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalGeneralAdmin"), input)
		return this
	}

	public PriceAndDeliverySettingsSMFPage inputGeneralSales(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalGeneralSales"), input)
		return this
	}

	public PriceAndDeliverySettingsSMFPage inputMargin(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalMargin"), input)
		return this
	}

	public PriceAndDeliverySettingsSMFPage inputMaterialAdditions(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalMaterialAdditions"), input)
		return this
	}

	public PriceAndDeliverySettingsSMFPage inputManufacturingAdditions(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalManufacturingAdditions"), input)
		return this
	}
	
	public PriceAndDeliverySettingsSMFPage inputCostPerHoleThreshold(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalCostPerHoleThreshold"), input)
		return this
	}
	
	public PriceAndDeliverySettingsSMFPage inputCostPerHoleUnderThreshold(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalCostPerHoleUnderThreshold"), input)
		return this
	}
	
	public PriceAndDeliverySettingsSMFPage inputCostPerHoleOverThreshold(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalCostPerHoleOverThreshold"), input)
		return this
	}

	//Visible

	public PriceAndDeliverySettingsSMFPage verifySaveChangesButtonVisible() {
		WebUI.verifyElementVisible(xpath("//span[text()='Save Changes']/parent::button"))
		return this
	}

	public PriceAndDeliverySettingsSMFPage verifyPreviewPricesButtonVisible() {
		WebUI.verifyElementVisible(xpath("//span[text()='Preview Prices']/parent::button"))
		return this
	}

	public PriceAndDeliverySettingsSMFPage verifyInputTransportAdditionsVisible() {
		WebUI.verifyElementVisible(id("basic_sheetMetalTransportAdditions"))
		return this
	}

	public PriceAndDeliverySettingsSMFPage verifyInputDistributionTimeAdditionsVisible() {
		WebUI.verifyElementVisible(id("basic_sheetMetalDistributionTimeAdditions"))
		return this
	}

	public PriceAndDeliverySettingsSMFPage verifyInputPersonalTimeAdditionsVisible() {
		WebUI.verifyElementVisible(id("basic_sheetMetalPersonalTimeAdditions"))
		return this
	}

	public PriceAndDeliverySettingsSMFPage verifyInputTechnicalDiscussionsVisible() {
		WebUI.verifyElementVisible(id("basic_sheetMetalTechnicalDiscussions"))
		return this
	}

	public PriceAndDeliverySettingsSMFPage verifyInputGeneralAdminVisible() {
		WebUI.verifyElementVisible(id("basic_sheetMetalGeneralAdmin"))
		return this
	}

	public PriceAndDeliverySettingsSMFPage verifyInputGeneralSalesVisible() {
		WebUI.verifyElementVisible(id("basic_sheetMetalGeneralSales"))
		return this
	}

	public PriceAndDeliverySettingsSMFPage verifyInputMarginVisible() {
		WebUI.verifyElementVisible(id("basic_sheetMetalMargin"))
		return this
	}

	public PriceAndDeliverySettingsSMFPage verifyInputMaterialAdditionsVisible() {
		WebUI.verifyElementVisible(id("basic_sheetMetalMaterialAdditions"))
		return this
	}

	public PriceAndDeliverySettingsSMFPage verifyInputManufacturingAdditionsVisible() {
		WebUI.verifyElementVisible(id("basic_sheetMetalManufacturingAdditions"))
		return this
	}
	
	//Error message
	
	public PriceAndDeliverySettingsSMFPage verifyShowErrorWhenTransportAdditionsError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_sheetMetalTransportAdditions_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public PriceAndDeliverySettingsSMFPage verifyShowErrorWhenDistributionTimeAdditionsError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_sheetMetalDistributionTimeAdditions_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public PriceAndDeliverySettingsSMFPage verifyShowErrorWhenPersonalTimeAdditionsError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_sheetMetalPersonalTimeAdditions_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public PriceAndDeliverySettingsSMFPage verifyShowErrorWhenTechnicalDiscussionsError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_sheetMetalTechnicalDiscussions_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public PriceAndDeliverySettingsSMFPage verifyShowErrorWhenGeneralAdminError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_sheetMetalGeneralAdmin_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public PriceAndDeliverySettingsSMFPage verifyShowErrorWhenGeneralSalesError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_sheetMetalGeneralSales_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public PriceAndDeliverySettingsSMFPage verifyShowErrorWhenMarginError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_sheetMetalMargin_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public PriceAndDeliverySettingsSMFPage verifyShowErrorWhenMaterialAdditionsError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_sheetMetalMaterialAdditions_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public PriceAndDeliverySettingsSMFPage verifyShowErrorWhenManufacturingAdditionsError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_sheetMetalManufacturingAdditions_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

}
