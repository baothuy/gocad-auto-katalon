import gocad.common.BulkPricingPage
import gocad.buyer.SettingsLeftNavMenu
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.common.ToastMessage
import katalon.fw.lib.Page

println '>> User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> Click Settings nav menu'
Page.nav(LeftNavBar).clickSettings()

println '>> Click Bulk Pricing Settings nav menu'
Page.nav(SettingsLeftNavMenu).clickBulkPricing()

println '>> Verify UI Bulk Pricing Settings'
Page.nav(BulkPricingPage).inputQuantityRefOne(quantityRefOne)
						 .inputQuantityRefTwo(quantityRefTwo)
						 .inputQuantityRefThree(quantityRefThree)
						 .clickSaveChanges()
						 
println '>> Verify message after updated'
Page.nav(ToastMessage).verifyToastMessage("Success!", "Updated Account")