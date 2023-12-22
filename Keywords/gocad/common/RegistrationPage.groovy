package gocad.common

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage


public class RegistrationPage extends BasePage<RegistrationPage>{

	public RegistrationPage inputEmail(String input) {
		clearTextAndSendKeysByActions(id("basic_email"), input)
		return this
	}

	public RegistrationPage inputPassword(String input) {
		clearTextAndSendKeysByActions(id("basic_password"), input)
		return this
	}

	public RegistrationPage inputConfirmPassword(String input) {
		clearTextAndSendKeysByActions(id("basic_confirmPassword"), input)
		return this
	}

	public RegistrationPage inputFirstName(String input) {
		clearTextAndSendKeysByActions(id("basic_firstName"), input)
		return this
	}

	public RegistrationPage inputLastName(String input) {
		clearTextAndSendKeysByActions(id("basic_lastName"), input)
		return this
	}

	public RegistrationPage inputPhone(String input) {
		clearTextAndSendKeysByActions(id("basic_phone"), input)
		return this
	}

	public RegistrationPage inputCompanyName(String input) {
		clearTextAndSendKeysByActions(id("basic_companyName"), input)
		return this
	}
	
	public RegistrationPage inputVatNumber(String input) {
		clearTextAndSendKeysByActions(id("basic_vatId"), input)
		return this
	}

	public RegistrationPage clickRegistrationButton() {
		WebUI.click(xpath("//*[text()='Registration']/parent::button[@type='submit']"))
		return this
	}

	public RegistrationPage verifyUIVisible() {
		WebUI.verifyElementVisible(id("basic_email"))
		WebUI.verifyElementVisible(id("basic_password"))
		WebUI.verifyElementVisible(id("basic_confirmPassword"))
		WebUI.verifyElementVisible(id("basic_firstName"))
		WebUI.verifyElementVisible(id("basic_lastName"))
		WebUI.verifyElementVisible(id("basic_phone"))
		WebUI.verifyElementVisible(id("basic_companyName"))
		WebUI.verifyElementVisible(xpath("//*[text()='Registration']/parent::button[@type='submit']"))
		return this
	}

	public RegistrationPage verifyRegisterSuccessfully() {
		WebUI.delay(2)
		String getUrlSuccess = WebUI.getUrl()
		WebUI.verifyElementVisible(xpath("//h5[text()='Almost there! Please check your email inbox.']"))
		WebUI.verifyElementVisible(xpath("//p[text()='There you will find a new email with a confirmation link.']"))
		WebUI.verifyElementVisible(xpath("//p[text()='Please click on the link to complete the registration.']"))
		return this
	}

	public RegistrationPage verifyShowErrorAlert(String inputExpected) {
		String actualError = WebUI.getText(xpath("//*[@class='ant-alert-message']"))
		WebUI.verifyEqual(actualError, inputExpected)
		return this
	}

	public RegistrationPage verifyShowErrorWhenInputEmail(String inputExpected) {
		List<String> findObject = findTestObjects("//*[@id='basic_email_help']/div")
		String actualError = findObject ? WebUI.getText(xpath("//*[@id='basic_email_help']/div")) : ""
		WebUI.verifyEqual(actualError, inputExpected)
		return this
	}

	public RegistrationPage verifyShowErrorWhenInputPassword(String inputExpected) {
		String actualError = WebUI.getText(xpath("//*[@id='basic_password_help']/div"))
		WebUI.verifyEqual(actualError, inputExpected)
		return this
	}

	public RegistrationPage verifyShowErrorWhenInputConfirmPassword(String inputExpected) {
		String actualError = WebUI.getText(xpath("//*[@id='basic_confirmPassword_help']/div"))
		WebUI.verifyEqual(actualError, inputExpected)
		return this
	}

	public RegistrationPage verifyShowErrorWhenInputFirstName(String inputExpected) {
		String actualError = WebUI.getText(xpath("//*[@id='basic_firstName_help']/div"))
		WebUI.verifyEqual(actualError, inputExpected)
		return this
	}

	public RegistrationPage verifyShowErrorWhenInputLastName(String inputExpected) {
		String actualError = WebUI.getText(xpath("//*[@id='basic_lastName_help']/div"))
		WebUI.verifyEqual(actualError, inputExpected)
		return this
	}

	public RegistrationPage verifyShowErrorWhenInputPhone(String inputExpected) {
		String actualError = WebUI.getText(xpath("//*[@id='basic_phone_help']/div"))
		WebUI.verifyEqual(actualError, inputExpected)
		return this
	}

	public RegistrationPage verifyShowErrorWhenInputCompanyName(String inputExpected) {
		String actualError = WebUI.getText(xpath("//*[@id='basic_companyName_help']/div"))
		WebUI.verifyEqual(actualError, inputExpected)
		return this
	}
	
	public RegistrationPage verifyShowErrorWhenInputVatNumber(String inputExpected) {
		String actualError = WebUI.getText(xpath("//*[@id='basic_vatId_help']/div"))
		WebUI.verifyEqual(actualError, inputExpected)
		return this
	}
}
