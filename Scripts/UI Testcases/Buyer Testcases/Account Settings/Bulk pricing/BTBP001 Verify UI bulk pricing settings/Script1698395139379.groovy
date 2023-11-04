import gocad.common.BulkPricingPage
import gocad.buyer.SettingsLeftNavMenu
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.common.ToastMessage
import katalon.fw.lib.Page

println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> Click Settings nav menu'
Page.nav(LeftNavBar).clickSettings()

println '>> Click Bulk Pricing Settings nav menu'
Page.nav(SettingsLeftNavMenu).clickBulkPricing()

println '>> input Bulk Pricing Settings value'
Page.nav(BulkPricingPage).verifyQuantityRefOneVisible()
						 .verifyQuantityRefTwoVisible()
						 .verifyQuantityRefThreeVisible()
						 .verifySaveChangesButtonVisible()
