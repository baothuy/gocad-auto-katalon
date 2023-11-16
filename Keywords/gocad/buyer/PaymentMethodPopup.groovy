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
	
	public PaymentMethodPopup clickPayButton() {
		WebUI.switchToFrame(xpath("//*[@name='embedded-checkout']"), 5)
		waitUntilElementVisibleWithWebDriverWait(xpath("//*[@class='SubmitButton-TextContainer']/parent::button"), 5)
		scrollToAndClick(xpath("//*[@class='SubmitButton-TextContainer']/parent::button"))
		WebUI.waitForElementNotPresent(xpath("//*[@name='embedded-checkout']"), 50)
		WebUI.switchToDefaultContent()
		return this
	}
	
	public PaymentMethodPopup clickClosePopup() {
		WebUI.click(xpath("//*[@aria-label='close']/parent::span"))
		return this
	}
	
	public PaymentMethodPopup verifyErrorCardInform(String expectedResult) {
		WebUI.switchToFrame(xpath("//*[@name='embedded-checkout']"), 5)
		waitUntilElementVisibleWithWebDriverWait(xpath("//*[@class='FormFieldGroup']//*[contains(@role, 'alert')]"), 10)
		String actualResult = WebUI.getText(xpath("//*[@class='FormFieldGroup']//*[contains(@role, 'alert')]"))
		WebUI.verifyEqual(actualResult, expectedResult)
		WebUI.switchToDefaultContent()
		return this
	}
	
	public PaymentMethodPopup verifyErrorConfirmPayment(String expectedResult) {
		WebUI.switchToFrame(xpath("//*[@name='embedded-checkout']"), 5)
		String actualResult = WebUI.getText(xpath("//*[contains(@class,'ConfirmPaymentButton-Error')]"))
		WebUI.verifyEqual(actualResult, expectedResult)
		WebUI.switchToDefaultContent()
		return this
	}
	
	public PaymentMethodPopup verifyCardNumberEmpty() {
		WebUI.switchToFrame(xpath("//*[@name='embedded-checkout']"), 5)
		WebUI.verifyElementPresent(xpath("//*[@id='cardNumber' and contains(@class, 'Input--empty')]"), 5)
		WebUI.switchToDefaultContent()
		return this
	}
	
	public PaymentMethodPopup verifyExpiryDateEmpty() {
		WebUI.switchToFrame(xpath("//*[@name='embedded-checkout']"), 5)
		WebUI.verifyElementPresent(xpath("//*[@id='cardExpiry' and contains(@class, 'Input--empty')]"), 5)
		WebUI.switchToDefaultContent()
		return this
	}
	
	public PaymentMethodPopup verifyCardCvcEmpty() {
		WebUI.switchToFrame(xpath("//*[@name='embedded-checkout']"), 5)
		WebUI.verifyElementPresent(xpath("//*[@id='cardCvc' and contains(@class, 'Input--empty')]"), 5)
		WebUI.switchToDefaultContent()
		return this
	}
	
	public PaymentMethodPopup verifyBillingNameEmpty() {
		WebUI.switchToFrame(xpath("//*[@name='embedded-checkout']"), 5)
		WebUI.verifyElementPresent(xpath("//*[@id='billingName' and contains(@class, 'Input--empty')]"), 5)
		WebUI.switchToDefaultContent()
		return this
	}
}
