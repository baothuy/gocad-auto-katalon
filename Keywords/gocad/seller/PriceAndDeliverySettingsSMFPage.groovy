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
	
	public PriceAndDeliverySettingsBasicPage inputTransportAdditions(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalTransportAdditions"), input)
		return this
	}
	
	public PriceAndDeliverySettingsBasicPage inputDistributionTimeAdditions(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalDistributionTimeAdditions"), input)
		return this
	}
	
	public PriceAndDeliverySettingsBasicPage inputPersonalTimeAdditions(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalPersonalTimeAdditions"), input)
		return this
	}
	
	public PriceAndDeliverySettingsBasicPage inputTechnicalDiscussions(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalTechnicalDiscussions"), input)
		return this
	}
	
	public PriceAndDeliverySettingsBasicPage inputGeneralAdmin(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalGeneralAdmin"), input)
		return this
	}
	
	public PriceAndDeliverySettingsBasicPage inputGeneralSales(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalGeneralSales"), input)
		return this
	}
	
	public PriceAndDeliverySettingsBasicPage inputMargin(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalMargin"), input)
		return this
	}
	
	public PriceAndDeliverySettingsBasicPage inputMaterialAdditions(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalMaterialAdditions"), input)
		return this
	}
	
	public PriceAndDeliverySettingsBasicPage inputManufacturingAdditions(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalManufacturingAdditions"), input)
		return this
	}
	
	public PriceAndDeliverySettingsBasicPage inputProgrammingTimeInHr(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalProgrammingTimeInHr"), input)
		return this
	}
	
	public PriceAndDeliverySettingsBasicPage inputProgrammingRate(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalProgrammingRate"), input)
		return this
	}
	
	public PriceAndDeliverySettingsBasicPage inputPaletChangeTimeInHr(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalPaletChangeTimeInHr"), input)
		return this
	}
	
	public PriceAndDeliverySettingsBasicPage inputMachineSetupTimeInHr(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalMachineSetupTimeInHr"), input)
		return this
	}
	
	public PriceAndDeliverySettingsBasicPage inputLaserMachineRate(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalLaserMachineRate"), input)
		return this
	}
	
	public PriceAndDeliverySettingsBasicPage inputClearingMachineRate(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalClearingMachineRate"), input)
		return this
	}
	
	public PriceAndDeliverySettingsBasicPage inputMachineHourRateThreads(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalMachineHourRateThreads"), input)
		return this
	}
	
	public PriceAndDeliverySettingsBasicPage inputMachineHourRateCounterSink(String input) {
		clearTextAndSendKeysByActions(id("basic_sheetMetalMachineHourRateCounterSink"), input)
		return this
	}
}
