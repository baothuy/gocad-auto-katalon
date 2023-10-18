import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.common.ToastMessage
import gocad.seller.AccountSettingsLeftNavMenu
import gocad.seller.LegalInformationSettingsPage
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> click Account'
Page.nav(LeftNavBar).clickAccount()

println '>> click Legal Information'
Page.nav(AccountSettingsLeftNavMenu).clickLegalInformation()

println '>> input field'
Page.nav(LegalInformationSettingsPage).inputLegal(legal)
									  .inputVatId(vatId)
									  .inputTaxNumber(taxNumber)
									  .clickSaveChangesButton()
									  
println '>> verify Toast Message'
Page.nav(ToastMessage).verifyToastMessage("Success!", "Updated Account")