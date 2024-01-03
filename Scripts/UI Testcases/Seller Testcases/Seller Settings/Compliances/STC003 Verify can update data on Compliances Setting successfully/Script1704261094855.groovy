import gocad.common.ConfirmPopup
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.common.ToastMessage
import gocad.seller.CompliancesSettingsPage
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller go to material settings'
Page.nav(LeftNavBar).clickCompliances()

println '>> Verify UI Compliances settings'
Page.nav(CompliancesSettingsPage).clickEditButton(name)
									.inputName(nameChanged)
									.clickOKButton()
									
Page.nav(ToastMessage).verifyToastMessage("Update success!","")

Page.nav(CompliancesSettingsPage).clickEditButton(nameChanged)
									.inputName(name)
									.clickOKButton()
									
Page.nav(ToastMessage).verifyToastMessage("Update success!","")

