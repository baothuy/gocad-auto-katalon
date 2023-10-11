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
	
	public PriceAndDeliverySettingsBasicPage inputNumberFreeCalculation(String input) {
		clearTextAndSendKeysByActions(id("basic_maximumCalculation"), input)
		return this
	}
	
	public PriceAndDeliverySettingsBasicPage inputOfferValidity(String input) {
		clearTextAndSendKeysByActions(id("basic_expiredDays"), input)
		return this
	}
}
