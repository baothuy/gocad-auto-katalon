package gocad.buyer

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage




public class ChangePasswordPopup extends BasePage<ChangePasswordPopup>{
	
	public ChangePasswordPopup clickOKButton() {
		WebUI.click(xpath("//span[text()='OK']/parent::button"))
		return this
	}
	
	public ChangePasswordPopup clickCancelButton() {
		WebUI.click(xpath("//span[text()='Cancel']/parent::button"))
		return this
	}
	
	public ChangePasswordPopup inputCurrentPassword(String expectedInput) {
		clearTextAndSendKeysByActions(id("basic_password"), expectedInput)
		return this
	}
	
	public ChangePasswordPopup inputNewPassword(String expectedInput) {
		clearTextAndSendKeysByActions(id("basic_newPassword"), expectedInput)
		return this
	}
	
	public ChangePasswordPopup inputConfirmNewPassword(String expectedInput) {
		clearTextAndSendKeysByActions(id("basic_confirmNewPassword"), expectedInput)
		return this
	}
	
	public ChangePasswordPopup verifyUIVisible() {
		WebUI.verifyElementVisible(id("basic_password"))
		WebUI.verifyElementVisible(id("basic_newPassword"))
		WebUI.verifyElementVisible(id("basic_confirmNewPassword"))
		WebUI.verifyElementVisible(xpath("//span[text()='OK']/parent::button"))
		WebUI.verifyElementVisible(xpath("//span[text()='Cancel']/parent::button"))
		return this
	}
	
	public ChangePasswordPopup verifyErrorCurrentPasswordField(String expectedResult) {
		String actualError = WebUI.getText(xpath("//div[@id='basic_password_help']/div"))
		WebUI.verifyEqual(actualError, expectedResult)
		return this
	}
	
	public ChangePasswordPopup verifyErrorNewPasswordField(String expectedResult) {
		String actualError = WebUI.getText(xpath("//div[@id='basic_newPassword_help']/div"))
		WebUI.verifyEqual(actualError, expectedResult)
		return this
	}
	
	public ChangePasswordPopup verifyErrorConfirmNewPasswordField(String expectedResult) {
		String actualError = WebUI.getText(xpath("//div[@id='basic_confirmNewPassword_help']/div"))
		WebUI.verifyEqual(actualError, expectedResult)
		return this
	}
}
