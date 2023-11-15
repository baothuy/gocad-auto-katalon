import gocad.buyer.CheckoutPage
import gocad.buyer.ConfirmedOffersPageOfBuyer
import gocad.buyer.PaymentMethodPopup
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

Page.nav(LeftNavBar).clickConfirmedOffers()
Page.nav(ConfirmedOffersPageOfBuyer).clickPayButton('13880')

//Page.nav(ReviewPage).clickManufacturingInformationProcess()

//println '>> input and verify after update Bulk Pricing'
//Page.nav(ManufacturingInformationPage).selectThickness(partName, "1").sleep(1)

//Page.nav(ReviewPage).clickCheckout()

//Page.nav(CheckoutPage).clickCheckboxAgreeTermsAndConditions()
//									.clickPlaceYourOrder()

Page.nav(PaymentMethodPopup).inputCardNumber(cardNumber)
							.inputCardCvc(cardCvc)
							.inputCardExpiry(cardExpiry)
							.inputBillingName(billingName)
							.clickPayButton()
							.sleep(2)
						
