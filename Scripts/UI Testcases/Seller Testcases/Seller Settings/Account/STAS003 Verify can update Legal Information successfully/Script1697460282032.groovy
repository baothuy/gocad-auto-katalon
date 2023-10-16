import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.common.ToastMessage
import gocad.seller.AccountSettingsLeftNavMenu
import gocad.seller.LegalInformationSettingsPage
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller go to Price And Delivery Settings settings'
Page.nav(LeftNavBar).clickAccount()

Page.nav(AccountSettingsLeftNavMenu).clickLegalInformation()

Page.nav(LegalInformationSettingsPage).inputLegal(legal)
									  .inputVatId(vatId)
									  .inputTaxNumber(taxNumber)
									  .clickSaveChangesButton()
									  
Page.nav(ToastMessage).verifyToastMessage("Success!", "Updated Account")