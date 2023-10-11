package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage




public class TermsOfPaymentSettingsPage extends BasePage<TermsOfPaymentSettingsPage>{
	
	public PaymentDetailsSettingsPage clickSaveChangesButton() {
		WebUI.click(xpath("//span[text()='Save Changes']/parent::button"))
		return this
	}
	
	public PaymentDetailsSettingsPage inputPaymentTarget(String input) {
		clearTextAndSendKeysByActions(id("basic_paymentTarget"), input)
		return this
	}
}
