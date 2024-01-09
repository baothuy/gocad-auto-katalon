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
Page.nav(CompliancesSettingsPage).clickAddComplianceButton()
									.inputName(name)
									.clickOKButton()
									
Page.nav(ToastMessage).verifyToastMessage("Update success!","")

Page.nav(CompliancesSettingsPage).clickMoreButton(name)
									.clickDeleteButton()

Page.nav(ConfirmPopup).verifyTitleConfirmPopup("Delete Compliance")
						.verifyContentConfirmPopup("Are you sure to delete this compliance? The compliance will not be restored.")
						.clickOK()
						.sleep(2)
						
Page.nav(ToastMessage).verifyToastMessage("Deleted","Deleted successfully.")