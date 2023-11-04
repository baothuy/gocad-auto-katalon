import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.seller.PriceAndDeliverySettingsBasicPage
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller go to Price And Delivery Settings settings'
Page.nav(LeftNavBar).clickPriceAndDeliverySettings()

println '>> Verify UI page'
Page.nav(PriceAndDeliverySettingsBasicPage).verifyUIPage()