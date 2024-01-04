package gocad.buyer

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage




public class SettingsLeftNavMenu extends BasePage<SettingsLeftNavMenu>{
	
	public SettingsLeftNavMenu clickAccount() {
		WebUI.click(xpath("//span[text()='Account']/parent::button"))
		return this
	}
	
	public SettingsLeftNavMenu clickBulkPricing() {
		WebUI.click(xpath("//span[text()='Bulk pricing']/parent::button"))
		return this
	}
}
