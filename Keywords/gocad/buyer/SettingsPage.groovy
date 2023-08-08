package gocad.buyer

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage


public class SettingsPage extends BasePage<SettingsPage>{
	
	public String getCompanyName() {
		String companyName = WebUI.getAttribute(xpath("//*[@id='basic_companyName']"), 'value')
		return companyName
	}
}
