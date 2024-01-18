import gocad.buyer.CheckoutPage
import gocad.buyer.CompletedCheckoutPage
import gocad.buyer.ConfirmedOffersPageOfBuyer
import gocad.buyer.PaymentMethodPopup
import gocad.buyer.ReviewPage
import gocad.common.AddProjectPopup
import gocad.common.DataUploadPage
import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.SelectMaterialPopup
import gocad.common.SignInPage
import gocad.seller.ConfirmedOffersPageOfSeller
import katalon.fw.lib.Page
import katalon.utility.CommonUtility
import katalon.utility.DateTimeUtility
import internal.GlobalVariable

println '>> FPA001 Verify automatically confirmed offers when the project smaller than Threshold'
println '>> Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>>  User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>>  User buyer add project'
Page.nav(LeftNavBar).clickNewProject()

println '>>  Open add project popup and add new project name'
Page.nav(DataUploadPage).clickEditProjectName(projectName)
String projectId = Page.nav(DataUploadPage).getIdProject()
println "projectId: $projectId"

println '>>  Upload file part on Data upload page'
Page.nav(DataUploadPage).uploadFileTesting('Milled / Turned Parts', partName)

String material
if (filePDF == "")
{
	println '>> Select material'
	Page.nav(ManufacturingInformationPage).clickPleaseSelectMaterial()
	Page.nav(SelectMaterialPopup).clickMaterialGroup(materialGroup).inputSearchMaterial(materialName)
	material = Page.nav(SelectMaterialPopup).getMaterialAndNumber(materialName)
	println "material = $material"
	Page.nav(SelectMaterialPopup).selectMaterialName(materialName)
	
	println '>> Input required field'
	Page.nav(ManufacturingInformationPage).inputFieldMTPShop(quantityNum, compliances, threadNum, tolerancesNum, quality, comment)
}
else
{
	Page.nav(ManufacturingInformationPage).uploadFilePDFTesting('Milled / Turned Parts', filePDF)
	 String getMaterialName = Page.nav(ManufacturingInformationPage).getMaterialWhenUploadFilePDF()
	 String getMaterialGroup = Page.nav(ManufacturingInformationPage).getMaterialGroupWhenUploadFilePDF()
	 
	 if (getMaterialName == null) {
		Page.nav(ManufacturingInformationPage).clickPleaseSelectMaterial()
		Page.nav(SelectMaterialPopup).clickMaterialGroup(materialGroup).inputSearchMaterial(materialName)
		material = Page.nav(SelectMaterialPopup).getMaterialAndNumber(materialName)
		println "material = $material"
		Page.nav(SelectMaterialPopup).selectMaterialName(materialName)
	 }
	 else {
		Page.nav(ManufacturingInformationPage).clickPleaseSelectMaterial()
		Page.nav(SelectMaterialPopup).clickMaterialGroup(getMaterialGroup).inputSearchMaterial(getMaterialName)
		material = Page.nav(SelectMaterialPopup).getMaterialAndNumber(getMaterialName)
		Page.nav(SelectMaterialPopup).clickCloseSearchMaterialPopup()
	 }
	 
	 Page.nav(ManufacturingInformationPage).inputFieldMTPShop(quantityNum, "", "", "", quality, comment)
}

println '>> click Calculate and move to Review page'
Page.nav(ManufacturingInformationPage).clickCalculate()
									  .clickReview()

println '>> Click get infor and Checkout button on Review Page'
List<String> tablePart = Page.nav(ReviewPage).getTablePartReview(partName)
println "tablePart: $tablePart"
Page.nav(ReviewPage).clickCheckout()

println '>> Select information on checkout page'
Page.nav(CheckoutPage).selectDeliveryOption(deliveryOption)
					  .selectShippingOption(shippingOption)

println '>> Get information Checkout page'
String orderNumber = GlobalVariable.prefixOrderNumber + projectId
String numberOfParts = '1'
String deliveryOption = Page.nav(CheckoutPage).getDeliveryOption()
String deliveryDate = Page.nav(CheckoutPage).getDeliveryDate()
String packagingAndShippingComments = Page.nav(CheckoutPage).getPackagingAndShippingComments()
String shippingOption = Page.nav(CheckoutPage).getShippingOptions()
String companyName = Page.nav(CheckoutPage).getCompanyName()
String netTotal = Page.nav(CheckoutPage).getNetTotal()
String grossTotal = Page.nav(CheckoutPage).getGrossTotal()
List<String> listOrderSummary = Page.nav(CheckoutPage).getOrderSummary()
List<String> listBillingAddress = Page.nav(CheckoutPage).getBillingAddress()
List<String> listShippingAddress = Page.nav(CheckoutPage).getShippingAddress()
String orderDate = Page.nav(DateTimeUtility).getCurrentDateTime()

println '>> Click Checkout button on Checkout Page'
Page.nav(CheckoutPage).clickCheckboxAgreeTermsAndConditions()
					  .clickPlaceYourOrder()
	
println '>> Appear Payment Method Popup'
Page.nav(PaymentMethodPopup).inputCardNumber(cardNumber)
							.inputCardExpiry(cardExpiry)
							.inputCardCvc(cardCvc)
							.inputBillingName(billingName)
							.selectCountry(country)
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
