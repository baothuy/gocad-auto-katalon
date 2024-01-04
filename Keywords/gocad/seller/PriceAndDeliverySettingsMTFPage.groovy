package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage




public class PriceAndDeliverySettingsMTFPage extends BasePage<PriceAndDeliverySettingsMTFPage>{

	public PriceAndDeliverySettingsMTFPage clickSaveChangesButton() {
		WebUI.click(xpath("//span[text()='Save Changes']/parent::button"))
		return this
	}

	public PriceAndDeliverySettingsMTFPage clickPreviewPricesButton() {
		WebUI.click(xpath("//span[text()='Preview Prices']/parent::button"))
		return this
	}

	public PriceAndDeliverySettingsMTFPage inputFactorManual(String input) {
		clearTextAndSendKeysByActions(id("basic_factorManual"), input)
		return this
	}

	public PriceAndDeliverySettingsMTFPage inputProgrammingHourRate(String input) {
		clearTextAndSendKeysByActions(id("basic_programmingHourRate"), input)
		return this
	}

	public PriceAndDeliverySettingsMTFPage inputGeneralAdminAdditions(String input) {
		clearTextAndSendKeysByActions(id("basic_generalAdminAdditions"), input)
		return this
	}

	public PriceAndDeliverySettingsMTFPage inputGeneralSalesAdditions(String input) {
		clearTextAndSendKeysByActions(id("basic_generalSalesAdditions"), input)
		return this
	}

	public PriceAndDeliverySettingsMTFPage inputFaultyPartsRiskAdditions(String input) {
		clearTextAndSendKeysByActions(id("basic_faultyPartsRiskAdditions"), input)
		return this
	}

	public PriceAndDeliverySettingsMTFPage inputMarginValue(String input) {
		clearTextAndSendKeysByActions(xpath("//label[@for='basic_marginValue']/parent::div/following::input[@id='basic_marginValue']"), input)
		return this
	}

	public PriceAndDeliverySettingsMTFPage inputMarginSurfaceTreat(String input) {
		clearTextAndSendKeysByActions(id("basic_marginSurfaceTreat"), input)
		return this
	}

	public PriceAndDeliverySettingsMTFPage inputRawMaterialAdditions(String input) {
		clearTextAndSendKeysByActions(id("basic_rawMaterialAdditions"), input)
		return this
	}

	public PriceAndDeliverySettingsMTFPage inputProcessCostAdditions(String input) {
		clearTextAndSendKeysByActions(id("basic_processCostAdditions"), input)
		return this
	}

	public PriceAndDeliverySettingsMTFPage inputInBetweenTemperingCost(String input) {
		clearTextAndSendKeysByActions(id("basic_inBetweenTemperingCost"), input)
		return this
	}

	//visible

	public PriceAndDeliverySettingsMTFPage verifySaveChangesButtonVisible() {
		WebUI.verifyElementVisible(xpath("//span[text()='Save Changes']/parent::button"))
		return this
	}

	public PriceAndDeliverySettingsMTFPage verifyPreviewPricesButtonVisible() {
		WebUI.verifyElementVisible(xpath("//span[text()='Preview Prices']/parent::button"))
		return this
	}

	public PriceAndDeliverySettingsMTFPage verifyInputFactorManualVisible() {
		WebUI.verifyElementVisible(id("basic_factorManual"))
		return this
	}

	public PriceAndDeliverySettingsMTFPage verifyInputProgrammingHourRateVisible() {
		WebUI.verifyElementVisible(id("basic_programmingHourRate"))
		return this
	}

	public PriceAndDeliverySettingsMTFPage verifyInputGeneralAdminAdditionsVisible() {
		WebUI.verifyElementVisible(id("basic_generalAdminAdditions"))
		return this
	}

	public PriceAndDeliverySettingsMTFPage verifyInputGeneralSalesAdditionsVisible() {
		WebUI.verifyElementVisible(id("basic_generalSalesAdditions"))
		return this
	}

	public PriceAndDeliverySettingsMTFPage verifyInputFaultyPartsRiskAdditionsVisible() {
		WebUI.verifyElementVisible(id("basic_faultyPartsRiskAdditions"))
		return this
	}

	public PriceAndDeliverySettingsMTFPage verifyInputMarginValueVisible() {
		WebUI.verifyElementVisible(xpath("//label[@for='basic_marginValue']/parent::div/following::input[@id='basic_marginValue']"))
		return this
	}

	public PriceAndDeliverySettingsMTFPage verifyInputMarginSurfaceTreatVisible() {
		WebUI.verifyElementVisible(id("basic_marginSurfaceTreat"))
		return this
	}

	public PriceAndDeliverySettingsMTFPage verifyInputRawMaterialAdditionsVisible() {
		WebUI.verifyElementVisible(id("basic_rawMaterialAdditions"))
		return this
	}

	public PriceAndDeliverySettingsMTFPage verifyInputProcessCostAdditionsVisible() {
		WebUI.verifyElementVisible(id("basic_processCostAdditions"))
		return this
	}

	public PriceAndDeliverySettingsMTFPage verifyInputInBetweenTemperingCostVisible() {
		WebUI.verifyElementVisible(id("basic_inBetweenTemperingCost"))
		return this
	}

	public PriceAndDeliverySettingsMTFPage verifyShowErrorWhenFactorManualError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_factorManual_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public PriceAndDeliverySettingsMTFPage verifyShowErrorWhenProgrammingHourRateError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_programmingHourRate_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public PriceAndDeliverySettingsMTFPage verifyShowErrorWhenGeneralAdminAdditionsError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_generalAdminAdditions_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public PriceAndDeliverySettingsMTFPage verifyShowErrorWhenGeneralSalesAdditionsError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_generalSalesAdditions_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public PriceAndDeliverySettingsMTFPage verifyShowErrorWhenFaultyPartsRiskAdditionsError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_faultyPartsRiskAdditions_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public PriceAndDeliverySettingsMTFPage verifyShowErrorWhenMarginValueError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_marginValue_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public PriceAndDeliverySettingsMTFPage verifyShowErrorWhenMarginSurfaceTreatError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_marginSurfaceTreat_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public PriceAndDeliverySettingsMTFPage verifyShowErrorWhenRawMaterialAdditionsError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_rawMaterialAdditions_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public PriceAndDeliverySettingsMTFPage verifyShowErrorWhenProcessCostAdditionsError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_processCostAdditions_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public PriceAndDeliverySettingsMTFPage verifyShowErrorWhenInBetweenTemperingCostError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_inBetweenTemperingCost_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
}
