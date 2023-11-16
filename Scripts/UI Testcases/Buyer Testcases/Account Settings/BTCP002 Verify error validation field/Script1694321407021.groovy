import gocad.buyer.AccountSettingsPage
import gocad.buyer.ChangePasswordPopup
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import katalon.fw.lib.Page

println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> Click Settings nav menu'
Page.nav(LeftNavBar).clickSettings()

println '>> Click change password button'
Page.nav(AccountSettingsPage).clickChangePasswordButton()

println '>> Input value in field'
Page.nav(ChangePasswordPopup).inputCurrentPassword(currentPassword)
								.inputNewPassword(newPassword)
								.inputConfirmNewPassword(confirmPassword)
								.clickOKButton()

								
switch (expectedResult) {
	
	case "Empty":
		println '>> Verify error in field'
		Page.nav(ChangePasswordPopup).verifyErrorCurrentPasswordField("Current password is required.")
									 .verifyErrorNewPasswordField("New password is required.")
									 .verifyErrorConfirmNewPasswordField("Confirm Password is required.")
	break;
	
	case "wrongPassword":
	println '>> Verify error in field'
	Page.nav(ChangePasswordPopup).verifyErrorCurrentPasswordField("Incorrect password.")
	break;
	
	case "notMatch":
	println '>> Verify error in field'
	Page.nav(ChangePasswordPopup).verifyErrorConfirmNewPasswordField("Passwords do NOT match")
	break;
}