import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.seller.AccountSettingsLeftNavMenu
import gocad.seller.AccountSettingsPage
import gocad.seller.LegalInformationSettingsPage
import gocad.seller.PaymentDetailsSettingsPage
import gocad.seller.TermsOfPaymentSettingsPage
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> click Account settings'
Page.nav(LeftNavBar).clickAccount()

println '>> verify UI Account Visible'
Page.nav(AccountSettingsPage).verifyUIAccountVisible()

println '>> click Legal Information settings'
Page.nav(AccountSettingsLeftNavMenu).clickLegalInformation()

println '>> verify UI Legal Information Visible'
Page.nav(LegalInformationSettingsPage).verifyUILegalInformationVisible()

println '>> click Payment Details settings'
Page.nav(AccountSettingsLeftNavMenu).clickPaymentDetails()

println '>> verify UI Payment Details Visible'
Page.nav(PaymentDetailsSettingsPage).verifyUIPaymentDetailsVisible()

println '>> click Terms Of Payment settings'
Page.nav(AccountSettingsLeftNavMenu).clickTermsOfPayment()

println '>> verify UI Terms Of Payment Visible'
Page.nav(TermsOfPaymentSettingsPage).verifyUITermsOfPaymentVisible()