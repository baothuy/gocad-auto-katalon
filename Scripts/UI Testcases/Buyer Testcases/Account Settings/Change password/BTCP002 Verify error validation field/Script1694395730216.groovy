import gocad.buyer.AccountSettingsPage
import gocad.buyer.ChangePasswordPopup
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import katalon.fw.lib.Page

println '>> User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

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
									 .verifyErrorConfirmNewPasswordField("Confirm password is required.")
	break;		
							 
	case "wrongPassword":
		println '>> Verify error in field'
		Page.nav(ChangePasswordPopup).verifyErrorCurrentPasswordField("Current password must contain at least 8 characters, at least 1 uppercase letter, 1 lowercase letter, 1 number and 1 special character")
	break;
	
	case "notMatch":
		println '>> Verify error in field'
		Page.nav(ChangePasswordPopup).verifyErrorConfirmNewPasswordField("Confirm password do not match")
	break;
}