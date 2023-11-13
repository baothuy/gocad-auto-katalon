package gocad.buyer

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import gocad.common.CopyPartPopup
import katalon.fw.lib.BasePage


public class PaymentMethodPopup extends BasePage<PaymentMethodPopup>{

	public PaymentMethodPopup inputCardNumber(String text) {
		WebUI.switchToFrame(xpath("//*[@name='embedded-checkout']"), 5)
		WebUI.setText(id("cardNumber"), text)
		WebUI.switchToDefaultContent()
		return this
	}

	public PaymentMethodPopup inputCardExpiry(String text) {
		WebUI.switchToFrame(xpath("//*[@name='embedded-checkout']"), 5)
		WebUI.setText(id("cardExpiry"), text)
		WebUI.switchToDefaultContent()
		return this
	}

	public PaymentMethodPopup inputCardCvc(String text) {
		WebUI.switchToFrame(xpath("//*[@name='embedded-checkout']"), 5)
		WebUI.setText(id("cardCvc"), text)
		WebUI.switchToDefaultContent()
		return this
	}

	public PaymentMethodPopup inputBillingName(String text) {
		WebUI.switchToFrame(xpath("//*[@name='embedded-checkout']"), 5)
		WebUI.setText(id("billingName"), text)
		WebUI.switchToDefaultContent()
		return this
	}

	public PaymentMethodPopup selectCountry(String text) {
		WebUI.switchToFrame(xpath("//*[@name='embedded-checkout']"), 5)
		WebUI.click(id("billingCountry"))
		WebUI.switchToDefaultContent()
		return this
	}
	
	public PaymentMethodPopup clickClosePopup() {
		WebUI.click(xpath("//*[@aria-label='close']/parent::span"))
		return this
	}
}
