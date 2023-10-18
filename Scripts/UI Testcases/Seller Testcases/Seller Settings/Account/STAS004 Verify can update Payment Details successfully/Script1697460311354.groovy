import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.common.ToastMessage
import gocad.seller.AccountSettingsLeftNavMenu
import gocad.seller.PaymentDetailsSettingsPage
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> click Account'
Page.nav(LeftNavBar).clickAccount()

println '>> click Payment Details'
Page.nav(AccountSettingsLeftNavMenu).clickPaymentDetails()

println '>> input field'
Page.nav(PaymentDetailsSettingsPage).inputBankName(bankName)
									  .inputIBAN(iban)
									  .inputBIC(bic)
									  .clickSaveChangesButton()

println '>> verify Toast Message'
Page.nav(ToastMessage).verifyToastMessage("Success!", "Updated Account")