import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.common.ToastMessage
import gocad.seller.AccountSettingsLeftNavMenu
import gocad.seller.TermsOfPaymentSettingsPage
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> click Account'
Page.nav(LeftNavBar).clickAccount()

println '>> click Terms Of Payment'
Page.nav(AccountSettingsLeftNavMenu).clickTermsOfPayment()

println '>> input field'
Page.nav(TermsOfPaymentSettingsPage).inputPaymentTarget(paymentTarget)
									  .clickSaveChangesButton()
									  
println '>> verify Toast Message'
Page.nav(ToastMessage).verifyToastMessage("Success!", "Updated Account")