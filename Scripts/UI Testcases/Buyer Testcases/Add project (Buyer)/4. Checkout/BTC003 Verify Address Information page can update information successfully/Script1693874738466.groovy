import gocad.buyer.AccountSettingsPage
import gocad.buyer.AddressInformationPopup
import gocad.buyer.CheckoutPage
import gocad.buyer.CompletedCheckoutPage
import gocad.buyer.DraftPage
import gocad.buyer.PaymentMethodPopup
import gocad.buyer.ReviewPage
import gocad.common.DataUploadPage
import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.SelectMaterialPopup
import gocad.common.SignInPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility



println '>> FPA004 Verify buyer accept offer with offer calculated manually will confirm offer successfully'
println '>> Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> Get company Name on Settings page'
Page.nav(LeftNavBar).clickSettings()
String companyName = Page.nav(AccountSettingsPage).getCompanyName()

println '>> User buyer add project'
Page.nav(LeftNavBar).clickNewProject()

println '>> Open add project popup and add new project name'
Page.nav(DataUploadPage).clickEditProjectName(projectName)
String projectId = Page.nav(DataUploadPage).getIdProject()
println "projectId: $projectId"

println '>> Upload file part on Data upload page'
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
	 
	 Page.nav(ManufacturingInformationPage).inputQuantity(quantityNum)
											 .selectSurfaceTreatment(surfaceTreatment)
											 .selectSurfaceQuality(quality)
											 .inputComment(comment)
}

println '>> click Calculate and move to Review page'
Page.nav(ManufacturingInformationPage).clickCalculate()
									.clickReview()

println '>> click checkout button'
Page.nav(ReviewPage).clickCheckout()

println '>> Verify information Address Information show correctly'
println '>> Input edit information successfully'
Page.nav(AddressInformationPopup).inputFirstNameBillingAddress(billingAddressChanged[0])
								.inputLastNameBillingAddress(billingAddressChanged[1])
								.inputEmailBillingAddress(billingAddressChanged[2])
								.inputPhoneBillingAddress(billingAddressChanged[3])
								.inputSearchBillingAddress(billingAddressChanged[5], billingAddressChanged[4], billingAddressChanged[8], billingAddressChanged[9], billingAddressChanged[6])
								.inputFirstNameShippingAddress(shippingAddressChanged[0])
								.inputLastNameShippingAddress(shippingAddressChanged[1])
								.inputEmailShippingAddress(shippingAddressChanged[2])
								.inputPhoneShippingAddress(shippingAddressChanged[3])
								.inputSearchBillingAddress(shippingAddressChanged[5], shippingAddressChanged[4], shippingAddressChanged[8], shippingAddressChanged[9], shippingAddressChanged[6])
									
														
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
							.sleep(2)
							
List<String> listBillingAddress = [billingAddressChanged[0] + " " + billingAddressChanged[1], billingAddressChanged[2], billingAddressChanged[3], billingAddressChanged[4], billingAddressChanged[5], billingAddressChanged[6], billingAddressChanged[7], billingAddressChanged[8], billingAddressChanged[9]]
List<String> listShippingAddress = [shippingAddressChanged[0] + " " + shippingAddressChanged[1], shippingAddressChanged[2], shippingAddressChanged[3], shippingAddressChanged[4], shippingAddressChanged[5], shippingAddressChanged[6], shippingAddressChanged[7], shippingAddressChanged[8], shippingAddressChanged[9]]

println '>> Verify after update show correctly on checkout page'
Page.nav(DetailOffer).verifyBillingAddress(listBillingAddress)
						.verifyShippingAddress(listShippingAddress)												