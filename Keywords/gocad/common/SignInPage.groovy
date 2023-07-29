package gocad.common

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import katalon.fw.lib.BasePage

public class MySignInPage extends BasePage<MySignInPage> {

	public MySignInPage enterCredentialAsSeller () {
		WebUI.navigateToUrl(GlobalVariable.myUrl)
		WebUI.waitForElementPresent(id('basic_username'), 60)
		WebUI.sendKeys(id('basic_username'), GlobalVariable.seller_mail)
		WebUI.setEncryptedText(id('basic_password'), GlobalVariable.seller_pass)
		return this
	}

	public MySignInPage enterCredentialAsBuyer () {
		WebUI.navigateToUrl(GlobalVariable.myUrl)
		WebUI.waitForElementPresent(id('basic_username'), 60)
		WebUI.sendKeys(id('basic_username'), GlobalVariable.buyer_mail)
		WebUI.setEncryptedText(id('basic_password'), GlobalVariable.buyer_pass)
		return this
	}

	public MySignInPage enterCredential(String user_name, String password) {
		WebUI.navigateToUrl(GlobalVariable.myUrl)
		WebUI.sendKeys(id('basic_username'), user_name)
		WebUI.setEncryptedText(id('basic_password'), password)
		return this
	}

	public MySignInPage clickSignIn () {
		WebUI.click(byType("submit"))
		return this
	}

	public MySignInPage verifySuccessfullySignInAsSeller () {
		WebUI.delay(5)
		WebUI.verifyTextPresent('Dashboard', false)
		return this
	}

	public MySignInPage verifySuccessfullySignInAsBuyer () {
		WebUI.verifyTextPresent('Draft', false)
		return this
	}
	
	public MySignInPage changeLanguage () {
		WebUI.click(xpath("//button[@class='btn']"))
		return this
	}
}