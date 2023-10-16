package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage




public class PriceAndDeliverySettingsBasicPage extends BasePage<PriceAndDeliverySettingsBasicPage>{

	public PriceAndDeliverySettingsBasicPage clickSaveChangesButton() {
		WebUI.click(xpath("//span[text()='Save Changes']/parent::button"))
		return this
	}

	public PriceAndDeliverySettingsBasicPage inputDeliveryTimeEconomy(String input) {
		clearTextAndSendKeysByActions(id("basic_deliveryTimeEconomy"), input)
		return this
	}

	public PriceAndDeliverySettingsBasicPage inputDeliveryTimeStandard(String input) {
		clearTextAndSendKeysByActions(id("basic_deliveryTimeStandard"), input)
		return this
	}

	public PriceAndDeliverySettingsBasicPage inputDeliveryTimeFast(String input) {
		clearTextAndSendKeysByActions(id("basic_deliveryTimeFast"), input)
		return this
	}

	public PriceAndDeliverySettingsBasicPage inputSurchargeEconomy(String input) {
		clearTextAndSendKeysByActions(id("basic_surchargeEconomy"), input)
		return this
	}

	public PriceAndDeliverySettingsBasicPage inputSurchargeStandard(String input) {
		clearTextAndSendKeysByActions(id("basic_surchargeStandard"), input)
		return this
	}

	public PriceAndDeliverySettingsBasicPage inputSurchargeFast(String input) {
		clearTextAndSendKeysByActions(id("basic_surchargeFast"), input)
		return this
	}

	public PriceAndDeliverySettingsBasicPage inputPartPriceManualThreshold(String input) {
		clearTextAndSendKeysByActions(id("basic_partPriceManualThreshold"), input)
		return this
	}

	public PriceAndDeliverySettingsBasicPage inputProjectPriceAutoThreshold(String input) {
		clearTextAndSendKeysByActions(id("basic_projectPriceAutoThreshold"), input)
		return this
	}

	public PriceAndDeliverySettingsBasicPage inputPriceDeliverySurcharge(String input) {
		clearTextAndSendKeysByActions(id("basic_deliverySurcharge"), input)
		return this
	}

	public PriceAndDeliverySettingsBasicPage selectAutomaticCalculationToggle(String value) {
		String isChecked = WebUI.getAttribute(id("basic_automaticCalculation"), "aria-checked")
		boolean isActive = value.equals("Active")
		if(Boolean.parseBoolean(isChecked) != isActive) {
			WebUI.click(id("basic_automaticCalculation"))
		}
		return this
	}

	public PriceAndDeliverySettingsBasicPage inputNumberFreeCalculation(String input) {
		clearTextAndSendKeysByActions(id("basic_maximumCalculation"), input)
		return this
	}

	public PriceAndDeliverySettingsBasicPage inputOfferValidity(String input) {
		clearTextAndSendKeysByActions(id("basic_expiredDays"), input)
		return this
	}

	public PriceAndDeliverySettingsBasicPage verifyShowErrorWhenDeliveryTimeEconomyError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_deliveryTimeEconomy_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public PriceAndDeliverySettingsBasicPage verifyShowErrorWhenDeliveryTimeStandardError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_deliveryTimeStandard_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public PriceAndDeliverySettingsBasicPage verifyShowErrorWhenDeliveryTimeFastError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_deliveryTimeFast_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public PriceAndDeliverySettingsBasicPage verifyShowErrorWhenSurchargeEconomyError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_surchargeEconomy_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public PriceAndDeliverySettingsBasicPage verifyShowErrorWhenSurchargeStandardError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_surchargeStandard_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public PriceAndDeliverySettingsBasicPage verifyShowErrorWhenSurchargeFastError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_surchargeFast_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public PriceAndDeliverySettingsBasicPage verifyShowErrorWhenPartPriceManualThresholdError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_partPriceManualThreshold_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public PriceAndDeliverySettingsBasicPage verifyShowErrorWhenProjectPriceAutoThresholdError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_projectPriceAutoThreshold_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public PriceAndDeliverySettingsBasicPage verifyShowErrorWhenDeliverySurchargeError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_deliverySurcharge_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public PriceAndDeliverySettingsBasicPage verifyShowErrorWhenNumberMaximumCalculationError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_maximumCalculation_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public PriceAndDeliverySettingsBasicPage verifyShowErrorWhenOfferValidityError(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_expiredDays_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public PriceAndDeliverySettingsBasicPage verifyUIPage() {
		WebUI.verifyElementVisible(id("basic_deliveryTimeEconomy"))
		WebUI.verifyElementVisible(id("basic_deliveryTimeStandard"))
		WebUI.verifyElementVisible(id("basic_deliveryTimeFast"))
		WebUI.verifyElementVisible(id("basic_surchargeEconomy"))
		WebUI.verifyElementVisible(id("basic_surchargeStandard"))
		WebUI.verifyElementVisible(id("basic_surchargeFast"))
		WebUI.verifyElementVisible(id("basic_partPriceManualThreshold"))
		WebUI.verifyElementVisible(id("basic_projectPriceAutoThreshold"))
		WebUI.verifyElementVisible(id("basic_deliverySurcharge"))
		WebUI.verifyElementVisible(id("basic_expiredDays"))
		WebUI.verifyElementVisible(id("basic_maximumCalculation"))
		WebUI.verifyElementVisible(xpath("//span[text()='Save Changes']/parent::button"))
		return this
	}
}
