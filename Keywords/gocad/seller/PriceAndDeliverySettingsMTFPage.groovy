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
	
	public PriceAndDeliverySettingsBasicPage inputFactorManual(String input) {
		clearTextAndSendKeysByActions(id("basic_factorManual"), input)
		return this
	}
	
	public PriceAndDeliverySettingsBasicPage inputProgrammingHourRate(String input) {
		clearTextAndSendKeysByActions(id("basic_programmingHourRate"), input)
		return this
	}
	
	public PriceAndDeliverySettingsBasicPage inputGeneralAdminAdditions(String input) {
		clearTextAndSendKeysByActions(id("basic_generalAdminAdditions"), input)
		return this
	}
	
	public PriceAndDeliverySettingsBasicPage inputGeneralSalesAdditions(String input) {
		clearTextAndSendKeysByActions(id("basic_generalSalesAdditions"), input)
		return this
	}
	
	public PriceAndDeliverySettingsBasicPage inputFaultyPartsRiskAdditions(String input) {
		clearTextAndSendKeysByActions(id("basic_faultyPartsRiskAdditions"), input)
		return this
	}
	
	public PriceAndDeliverySettingsBasicPage inputMarginValue(String input) {
		clearTextAndSendKeysByActions(id("basic_marginValue"), input)
		return this
	}
	
	public PriceAndDeliverySettingsBasicPage inputMarginSurfaceTreat(String input) {
		clearTextAndSendKeysByActions(id("basic_marginSurfaceTreat"), input)
		return this
	}
	
	public PriceAndDeliverySettingsBasicPage inputRawMaterialAdditions(String input) {
		clearTextAndSendKeysByActions(id("basic_rawMaterialAdditions"), input)
		return this
	}
	
	public PriceAndDeliverySettingsBasicPage inputProcessCostAdditions(String input) {
		clearTextAndSendKeysByActions(id("basic_processCostAdditions"), input)
		return this
	}
	
	public PriceAndDeliverySettingsBasicPage inputInBetweenTemperingCost(String input) {
		clearTextAndSendKeysByActions(id("basic_inBetweenTemperingCost"), input)
		return this
	}
}
