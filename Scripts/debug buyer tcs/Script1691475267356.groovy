import gocad.buyer.CheckoutPage
import gocad.buyer.DraftPage
import gocad.buyer.ReviewPage
import gocad.common.SignInPage
import katalon.fw.lib.Page



println '>> FPA002 Verify seller accept offers successfully when project larger than Threshold'
println '>> Random project name'
//def projectName = CommonUtility.generateRandomProjectName(10)
//
println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

//Page.nav(LeftNavBar).clickConfirmedOffers()
//List<String> dataRow = Page.nav(ConfirmedOffersPageOfBuyer).getDataRowByPaymentStatus()
//String projectId = dataRow[0]
//Page.nav(ConfirmedOffersPageOfBuyer).clickPayButton(projectId)

Page.nav(DraftPage).clickViewAction('15986')

Page.nav(ReviewPage).clickCheckout()

Page.nav(CheckoutPage).verifySurchargeForMinimumOrderValue('26,40 €', '42,49 €')

						