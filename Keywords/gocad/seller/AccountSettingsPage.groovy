package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage




public class AccountSettingsPage extends BasePage<AccountSettingsPage>{
	
	public String getCompanyName() {
		String companyName = WebUI.getAttribute(xpath("//*[@id='basic_companyName']"), 'value')
		return companyName
	}
}
