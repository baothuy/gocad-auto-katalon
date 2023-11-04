import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.seller.AccountSettingsLeftNavMenu
import gocad.common.BulkPricingPage
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> click Account settings'
Page.nav(LeftNavBar).clickAccount()

println '>> click Legal Information settings'
Page.nav(AccountSettingsLeftNavMenu).clickBulkPricing()

println '>> input Bulk Pricing Settings value'
Page.nav(BulkPricingPage).verifyQuantityRefOneVisible()
						 .verifyQuantityRefTwoVisible()
						 .verifyQuantityRefThreeVisible()
						 .verifySaveChangesButtonVisible()
