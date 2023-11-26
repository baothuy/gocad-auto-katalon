import gocad.buyer.CheckoutPage
import gocad.buyer.ConfirmedOffersPageOfBuyer
import gocad.buyer.PaymentMethodPopup
import gocad.buyer.ReviewPage
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import katalon.fw.lib.Page
import katalon.utility.FileHelper




println '>> FPA002 Verify seller accept offers successfully when project larger than Threshold'
println '>> Random project name'
//def projectName = CommonUtility.generateRandomProjectName(10)
//
println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

Page.nav(LeftNavBar).clickConfirmedOffers()

println '>>  User buyer add project'
Page.nav(ConfirmedOffersPageOfBuyer).clickPayButton('16855')

println '>> Appear Payment Method Popup'
Page.nav(PaymentMethodPopup).inputCardNumber(cardNumber)
							.inputCardExpiry(cardExpiry)
							.inputCardCvc(cardCvc)
							.inputBillingName(billingName)
							.selectCountry(country)
							.clickPayButton()
							.sleep(2)

						