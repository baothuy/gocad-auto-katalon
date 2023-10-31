import gocad.common.BulkPricingPage
import katalon.fw.lib.Page

import gocad.buyer.SettingsLeftNavMenu
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import katalon.fw.lib.Page

println '>> User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> Click Settings nav menu'
Page.nav(LeftNavBar).clickSettings()

println '>> Click Bulk Pricing Settings nav menu'
Page.nav(SettingsLeftNavMenu).clickBulkPricing()

println '>> Fill in field Bulk Pricing Settings'
Page.nav(BulkPricingPage).inputQuantityRefOne(quantityRefOne)
						 .inputQuantityRefTwo(quantityRefTwo)
						 .inputQuantityRefThree(quantityRefThree)
						 .clickSaveChanges()
						 
						 
println '>> Verify show error field Bulk Pricing Settings'
Page.nav(BulkPricingPage).verifyShowErrorBelowQuantityRefOne("Quantity ref 1 is required.")
						 .verifyShowErrorBelowQuantityRefTwo("Quantity ref 2 is required.")
						 .verifyShowErrorBelowQuantityRefThree("Quantity ref 3 is required.")