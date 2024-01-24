import gocad.buyer.CheckoutPage
import gocad.buyer.RequestedOffersPage
import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import katalon.fw.lib.Page





println '>> FPA002 Verify seller accept offers successfully when project larger than Threshold'
println '>> Random project name'
//def projectName = CommonUtility.generateRandomProjectName(10)
//
println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

Page.nav(LeftNavBar).clickRequestedOffers()

Page.nav(RequestedOffersPage).clickAction("31373")

List<String> getBillingAddress = Page.nav(DetailOffer).getBillingAddressDetailOffer()
println "getBillingAddress: $getBillingAddress"



						