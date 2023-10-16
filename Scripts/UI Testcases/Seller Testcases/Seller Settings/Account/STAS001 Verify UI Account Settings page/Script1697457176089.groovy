import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.seller.AccountSettingsLeftNavMenu
import gocad.seller.AccountSettingsPage
import gocad.seller.LegalInformationSettingsPage
import gocad.seller.PaymentDetailsSettingsPage
import gocad.seller.TermsOfPaymentSettingsPage
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller go to Price And Delivery Settings settings'
Page.nav(LeftNavBar).clickAccount()

Page.nav(AccountSettingsPage).verifyUIAccountVisible()

Page.nav(AccountSettingsLeftNavMenu).clickLegalInformation()

Page.nav(LegalInformationSettingsPage).verifyUILegalInformationVisible()

Page.nav(AccountSettingsLeftNavMenu).clickPaymentDetails()

Page.nav(PaymentDetailsSettingsPage).verifyUIPaymentDetailsVisible()

Page.nav(AccountSettingsLeftNavMenu).clickTermsOfPayment()

Page.nav(TermsOfPaymentSettingsPage).verifyUITermsOfPaymentVisible()