import gocad.buyer.AddressInformationPopup
import gocad.buyer.AccountSettingsPage
import gocad.buyer.CheckoutPage
import gocad.buyer.DraftPage
import gocad.buyer.ReviewPage
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import katalon.fw.lib.Page



println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> User go to draft page'
Page.nav(LeftNavBar).clickDraft()

println '>> Verify UI draft page'
Page.nav(DraftPage).verifyUIVisible()