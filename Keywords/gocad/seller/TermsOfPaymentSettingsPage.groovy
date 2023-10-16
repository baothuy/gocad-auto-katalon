package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage




public class TermsOfPaymentSettingsPage extends BasePage<TermsOfPaymentSettingsPage>{

	public TermsOfPaymentSettingsPage clickSaveChangesButton() {
		WebUI.click(xpath("//span[text()='Save Changes']/parent::button"))
		return this
	}

	public TermsOfPaymentSettingsPage inputPaymentTarget(String input) {
		clearTextAndSendKeysByActions(id("basic_paymentTarget"), input)
		return this
	}
	
	public TermsOfPaymentSettingsPage verifyUITermsOfPaymentVisible() {
		//button Terms of Payment
		WebUI.verifyElementVisible(xpath("//span[text()='Terms of Payment']"))
		//field input
		WebUI.verifyElementVisible(id("basic_paymentTarget"))
		//button save change
		WebUI.verifyElementVisible(xpath("//span[text()='Save Changes']"))
		return this
	}
	
	public TermsOfPaymentSettingsPage verifyShowErrorWhenPaymentTargetEmpty() {
		String firstName = WebUI.getText(xpath("//*[@id='basic_paymentTarget_help']/div"))
		String expectedResult = "Targets for payments is required."
		WebUI.verifyEqual(firstName, expectedResult)
		return this
	}
}
