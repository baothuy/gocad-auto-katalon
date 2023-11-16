import gocad.buyer.CheckoutPage
import gocad.buyer.ConfirmedOffersPageOfBuyer
import gocad.buyer.PaymentMethodPopup
import gocad.buyer.ReviewPage
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import katalon.fw.lib.Page


println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

Page.nav(LeftNavBar).clickConfirmedOffers()
List<String> dataRow = Page.nav(ConfirmedOffersPageOfBuyer).getDataRowByPaymentStatus()
String projectId = dataRow[0]
Page.nav(ConfirmedOffersPageOfBuyer).clickPayButton(projectId)

Page.nav(PaymentMethodPopup).inputCardNumber(cardNumber)
							.inputCardCvc(cardCvc)
							.inputCardExpiry(cardExpiry)
							.inputBillingName(billingName)
							.clickPayButton()
							.sleep(5)
						
switch (expectedResult) {
	
	case "incorrect_cvc":
	println '>> Verify error'
	Page.nav(PaymentMethodPopup).verifyErrorCardInform("Your card's security code is incorrect.")
	break;
	
	case "expired_card":
	println '>> Verify error'
	Page.nav(PaymentMethodPopup).verifyErrorCardInform("Your card has expired.")
	break;
	
	case "processing_error":
	println '>> Verify error'
	Page.nav(PaymentMethodPopup).verifyErrorConfirmPayment("An error occurred while processing your payment. Try again later or with a different payment method.")
	break;
	
	case "incorrect_number":
	println '>> Verify error'
	Page.nav(PaymentMethodPopup).verifyErrorCardInform("Your card number is invalid.")
	break;
	
	case "insufficient_funds":
	println '>> Verify error'
	Page.nav(PaymentMethodPopup).verifyErrorCardInform("Your credit card was declined because of insufficient funds. Try paying with a debit card instead.")
	break;
	
	case "decline_after_attaching":
	println '>> Verify error'
	Page.nav(PaymentMethodPopup).verifyErrorCardInform("Your credit card was declined. Try paying with a debit card instead.")
	break;
	
	case "missing_cardNumber":
	println '>> Verify error'
	Page.nav(PaymentMethodPopup).verifyCardNumberEmpty()
	break;
	
	case "missing_expiry":
	println '>> Verify error'
	Page.nav(PaymentMethodPopup).verifyExpiryDateEmpty()
	break;
	
	case "missing_cvc":
	println '>> Verify error'
	Page.nav(PaymentMethodPopup).verifyCardCvcEmpty()
	break;
	
	case "missing_billingName":
	println '>> Verify error'
	Page.nav(PaymentMethodPopup).verifyBillingNameEmpty()
	break;
							 
}