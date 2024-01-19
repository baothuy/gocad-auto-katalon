package gocad.common

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import katalon.fw.lib.BasePage

public class SignInPage extends BasePage<SignInPage> {

	public SignInPage enterCredentialAsSeller () {
		WebUI.navigateToUrl(GlobalVariable.myUrl)
		WebUI.waitForElementPresent(id('basic_username'), 60)
		WebUI.sendKeys(id('basic_username'), GlobalVariable.seller_mail)
		WebUI.setEncryptedText(id('basic_password'), GlobalVariable.seller_pass)
		return this
	}

	public SignInPage enterCredentialAsBuyer () {
		WebUI.navigateToUrl(GlobalVariable.myUrl)
		WebUI.waitForElementPresent(id('basic_username'), 60)
		WebUI.sendKeys(id('basic_username'), GlobalVariable.buyer_mail)
		WebUI.setEncryptedText(id('basic_password'), GlobalVariable.buyer_pass)
		return this
	}

	public SignInPage enterCredential(String user_name, String password) {
		WebUI.navigateToUrl(GlobalVariable.myUrl)
		WebUI.waitForElementPresent(id('basic_username'), 60)
		WebUI.sendKeys(id('basic_username'), user_name)
		WebUI.sendKeys(id('basic_password'), password)
		return this
	}

	public SignInPage openBrowser () {
		WebUI.navigateToUrl(GlobalVariable.myUrl)
		return this
	}

	public SignInPage inputEmail (String email) {
		clearTextAndSendKeysByActions(id('basic_username'), email)
		return this
	}

	public SignInPage inputPassword (String password) {
		clearTextAndSendKeysByActions(id('basic_password'), password)
		return this
	}

	public SignInPage clickSignIn () {
		WebUI.click(byType("submit"))
		return this
	}

	public SignInPage verifyAfterInputWrongAccount () {
		WebUI.delay(GlobalVariable.smallSleepTime)
		String message = WebUI.getText(xpath('//div[@class="alert alert-danger alert-dismissible fade show"]'))
		String inputExpected = "Invalid email or password. Please try again."
		WebUI.verifyEqual(message, inputExpected)
		return this
	}

	public SignInPage verifyShowErrorWhenInputField () {
		List<String> findObjectEmail = findTestObjects("//*[@id='basic_username_help']/div")
		List<String> findObjectPassword = findTestObjects("//*[@id='basic_password_help']/div")
		if (findObjectEmail.size() != 0) {
			String messageEmail = WebUI.getText(xpath("//*[@id='basic_username_help']/div"))
			WebUI.verifyEqual(messageEmail, "E-mail is required.")
		}
		else if (findObjectPassword.size() != 0) {
			String messagePass = WebUI.getText(xpath("//*[@id='basic_password_help']/div"))
			WebUI.verifyEqual(messagePass, "Password is required.")
		}
		return this
	}

	public SignInPage verifyShowErrorWhenInputPassword (String inputExpected) {
		String message = WebUI.getText(xpath('//*[@id="basic_password_help"]/div'))
		WebUI.verifyEqual(message, inputExpected)
		return this
	}

	public SignInPage verifySuccessfullySignInAsSeller () {
		WebUI.delay(GlobalVariable.smallSleepTime)
		List<String> findObjects = findTestObjects("//a[text()='Open inquiries']")
		if (findObjects.size() == 0) {
			WebUI.click(xpath("//button[@class='btn']"))
			WebUI.waitForElementPresent(xpath("//span[text()='English']"), 5)
			WebUI.click(xpath("//span[text()='English']"))
			WebUI.delay(1)
		}
		WebUI.verifyTextPresent('Dashboard', false)
		return this
	}

	public SignInPage verifySuccessfullySignInAsBuyer () {
		WebUI.delay(GlobalVariable.smallSleepTime)
		List<String> findObjects = findTestObjects("//a[text()='Draft']")
		if (findObjects.size() == 0) {
			WebUI.click(xpath("//button[@class='btn']"))
			WebUI.waitForElementPresent(xpath("//span[text()='English']"), 5)
			WebUI.click(xpath("//span[text()='English']"))
			WebUI.delay(1)
		}
		WebUI.verifyTextPresent('Draft', false)
		return this
	}

	public SignInPage changeLanguage () {
		WebUI.click(xpath("//button[@class='btn']"))
		WebUI.waitForElementPresent(xpath("//span[text()='English']"), 5)
		WebUI.click(xpath("//span[text()='English']"))
		WebUI.delay(1)
		return this
	}

	public SignInPage clickRegistrationTab () {
		WebUI.click(xpath("//span[text()='Registration']/parent::button"))
		return this
	}

	public SignInPage verifyUIVisible () {
		//change language button
		WebUI.verifyElementVisible(xpath("//button[@class='btn']"))
		//2 tab login and registration
		WebUI.verifyElementVisible(xpath("//*[text()='Login']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Registration']"))
		// 2 field email and password
		WebUI.verifyElementVisible(id("basic_username"))
		WebUI.verifyElementVisible(id("basic_password"))
		//forgot password link
		WebUI.verifyElementVisible(xpath("//a[text()='Forgot your password?']"))
		//sign in button
		WebUI.verifyElementVisible(byType("submit"))
		return this
	}
}