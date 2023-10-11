package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage





public class PriceAndDeliverySettingsLeftNavMenu extends BasePage<PriceAndDeliverySettingsLeftNavMenu>{
	
	public PriceAndDeliverySettingsLeftNavMenu clickBasic() {
		WebUI.click(xpath("//span[text()='Basic']/parent::button"))
		return this
	}
	
	public PriceAndDeliverySettingsLeftNavMenu clickMillingAndTurningFormula() {
		WebUI.click(xpath("//span[text()='Milling and Turning Formula']/parent::button"))
		return this
	}
	
	public PriceAndDeliverySettingsLeftNavMenu clickSheetMetalFormula() {
		WebUI.click(xpath("//span[text()='Sheet metal Formula']/parent::button"))
		return this
	}
}
