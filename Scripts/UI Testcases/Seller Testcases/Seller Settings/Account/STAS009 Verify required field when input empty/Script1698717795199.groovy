import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.common.ToastMessage
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
Page.nav(BulkPricingPage).inputQuantityRefOne(quantityRefOne)
						 .inputQuantityRefTwo(quantityRefTwo)
						 .inputQuantityRefThree(quantityRefThree)
						 .clickSaveChanges()
						 
						 
println '>> Verify show error field Bulk Pricing Settings'
Page.nav(BulkPricingPage).verifyShowErrorBelowQuantityRefOne("Quantity ref 1 is required.")
						 .verifyShowErrorBelowQuantityRefTwo("Quantity ref 2 is required.")
						 .verifyShowErrorBelowQuantityRefThree("Quantity ref 3 is required.")
