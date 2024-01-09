import gocad.buyer.CheckoutPage
import gocad.buyer.DraftPage
import gocad.buyer.ReviewPage
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import katalon.fw.lib.Page





println '>> FPA002 Verify seller accept offers successfully when project larger than Threshold'
println '>> Random project name'
//def projectName = CommonUtility.generateRandomProjectName(10)
//
println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

Page.nav(LeftNavBar).clickDraft()

Page.nav(DraftPage).clickViewAction("29548")

Page.nav(ReviewPage).clickCheckout()

List<String> getBillingAddress = Page.nav(CheckoutPage).getBillingAddress()
println "getBillingAddress: $getBillingAddress"

List<String> getShippingAddress = Page.nav(CheckoutPage).getShippingAddress()
println "getBillingAddress: $getShippingAddress"

						