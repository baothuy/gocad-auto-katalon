import gocad.buyer.AccountSettingsPage
import gocad.buyer.ChangePasswordPopup
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import katalon.fw.lib.Page

println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredential(email, currentPassword).changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> Click Settings nav menu'
Page.nav(LeftNavBar).clickSettings()

println '>> Click change password button'
Page.nav(AccountSettingsPage).clickChangePasswordButton()

println '>> Verify UI Change password popup and input value'
Page.nav(ChangePasswordPopup).verifyUIVisible()
								.inputCurrentPassword(currentPassword)
								.inputNewPassword(newPassword)
								.inputConfirmNewPassword(confirmPassword)
								.clickOKButton()

println '>> Verify content message after change password'
Page.nav(AccountSettingsPage).verifyToastMessageWhenChangePassword()

println '>> Get email and logout'
Page.nav(LeftNavBar).clickLogout()

println '>> Login with old password will show error'
Page.nav(SignInPage).changeLanguage()
						.inputEmail(email)
						.inputPassword(currentPassword)						
						.clickSignIn()
						.verifyAfterInputWrongAccount()
						
println '>> Login with new password will sign in successfully'
Page.nav(SignInPage).inputEmail(email)
						.inputPassword(newPassword)						
						.clickSignIn()
						
println '>> Click Settings nav menu'
Page.nav(LeftNavBar).clickSettings()
						
println '>> Click change password button'
Page.nav(AccountSettingsPage).clickChangePasswordButton()

println '>> Change password back to old password'
Page.nav(ChangePasswordPopup).inputCurrentPassword(newPassword)
							.inputNewPassword(currentPassword)
							.inputConfirmNewPassword(currentPassword)
							.clickOKButton()
							.sleep(2)