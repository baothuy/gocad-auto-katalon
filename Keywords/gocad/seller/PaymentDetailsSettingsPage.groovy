package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage




public class PaymentDetailsSettingsPage extends BasePage<PaymentDetailsSettingsPage>{

	public PaymentDetailsSettingsPage clickSaveChangesButton() {
		WebUI.click(xpath("//span[text()='Save Changes']/parent::button"))
		return this
	}

	public PaymentDetailsSettingsPage inputBankName(String input) {
		clearTextAndSendKeysByActions(id("basic_bankName"), input)
		return this
	}

	public PaymentDetailsSettingsPage inputIBAN(String input) {
		clearTextAndSendKeysByActions(id("basic_iban"), input)
		return this
	}

	public PaymentDetailsSettingsPage inputBIC(String input) {
		clearTextAndSendKeysByActions(id("basic_bic"), input)
		return this
	}
	
	public PaymentDetailsSettingsPage verifyUIPaymentDetailsVisible() {
		//button Legal Information
		WebUI.verifyElementVisible(xpath("//span[text()='Payment Details']"))
		//field input
		WebUI.verifyElementVisible(id("basic_bankName"))
		WebUI.verifyElementVisible(id("basic_iban"))
		WebUI.verifyElementVisible(id("basic_bic"))
		//button save change
		WebUI.verifyElementVisible(xpath("//span[text()='Save Changes']"))
		return this
	}
}
