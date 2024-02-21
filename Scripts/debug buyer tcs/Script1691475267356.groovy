import gocad.buyer.CheckoutPage
import gocad.buyer.DraftPage
import gocad.buyer.ReviewPage
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import katalon.fw.lib.Page



println '>> User Seller signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

Page.nav(LeftNavBar).clickDraft()

Page.nav(DraftPage).clickViewAction("29548")

Page.nav(ReviewPage).clickCheckout()

List<String> getBillingAddress = Page.nav(CheckoutPage).getBillingAddress()
println "getBillingAddress: $getBillingAddress"

List<String> getShippingAddress = Page.nav(CheckoutPage).getShippingAddress()
println "getBillingAddress: $getShippingAddress"

Page.nav(CheckoutPage).clickMoreOption("step-testing.step")
						.clickCopy()
						
println '>> select project to copy'
Page.nav(CopyPartPopup).inputProjectToCopy("Auto Generate Prj zgV4JG4Jzu")
						  .clickOK()
						  .verifyToastMessageWhenCopyProject("step-testing.step", "Auto Generate Prj zgV4JG4Jzu")
						