import gocad.buyer.AddressInformationPopup
import gocad.buyer.CompletedCheckoutPage
import gocad.common.DataUploadPage
import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.SelectMaterialPopup
import gocad.common.SignInPage
import gocad.seller.MyProjectsPage
import gocad.seller.SendOfferPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility
import katalon.utility.DateTimeUtility


println '>> User Seller signs in page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller add project'
Page.nav(LeftNavBar).clickMyProjects()
Page.nav(MyProjectsPage).clickNewProject()

println '>> Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>> Open add project popup and input project name'
Page.nav(DataUploadPage).clickEditProjectName(projectName)

String projectId = Page.nav(DataUploadPage).getIdProject()
println "projectId: $projectId"

println '>> Upload file part on Data upload page'
Page.nav(DataUploadPage).uploadFileTesting('Milled / Turned Parts', partName)

String deliveryDate = DateTimeUtility.next30Days("yyyy-MM-dd")

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
											.inputDeliveryDate(deliveryDate)
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
											 .inputDeliveryDate(deliveryDate)
}

println '>> click Calculate and move to Review page'
Page.nav(ManufacturingInformationPage).clickCalculate()
									.clickReview()

println '>> Verify information Address Information show correctly'
println '>> Click Edit address'
Page.nav(SendOfferPage).inputCustomer(email)

println '>> Input edit information successfully'
Page.nav(AddressInformationPopup).inputFirstNameBillingAddress(billingAddressChanged[0])
								.inputLastNameBillingAddress(billingAddressChanged[1])
								.inputEmailBillingAddress(billingAddressChanged[2])
								.inputPhoneBillingAddress(billingAddressChanged[3])
								.inputStreetBillingAddress(billingAddressChanged[4])
								.inputHouseNumberBillingAddress(billingAddressChanged[5])
								.selectCountryBillingAddress(billingAddressChanged[6])
								.selectStateBillingAddress(billingAddressChanged[7])								
								.selectCityBillingAddress(billingAddressChanged[8])
								.inputZIPCodeBillingAddress(billingAddressChanged[9])
								.inputFirstNameShippingAddress(shippingAddressChanged[0])
								.inputLastNameShippingAddress(shippingAddressChanged[1])
								.inputEmailShippingAddress(shippingAddressChanged[2])
								.inputPhoneShippingAddress(shippingAddressChanged[3])
								.inputStreetShippingAddress(shippingAddressChanged[4])
								.inputHouseNumberShippingAddress(shippingAddressChanged[5])								
								.selectCountryShippingAddress(shippingAddressChanged[6])
								.selectStateShippingAddress(shippingAddressChanged[7])								
								.selectCityShippingAddress(shippingAddressChanged[8])	
								.inputZIPCodeShippingAddress(shippingAddressChanged[9])								

Page.nav(SendOfferPage).clickSendOffer()
List<String> listBillingAddress = [billingAddressChanged[0] + " " + billingAddressChanged[1], billingAddressChanged[2], billingAddressChanged[3], billingAddressChanged[4], billingAddressChanged[5], billingAddressChanged[6], billingAddressChanged[7], billingAddressChanged[8], billingAddressChanged[9]]
List<String> listShippingAddress = [shippingAddressChanged[0] + " " + shippingAddressChanged[1], shippingAddressChanged[2], shippingAddressChanged[3], shippingAddressChanged[4], shippingAddressChanged[5], shippingAddressChanged[6], shippingAddressChanged[7], shippingAddressChanged[8], shippingAddressChanged[9]]

println '>> Verify after update show correctly on checkout page'
Page.nav(CompletedCheckoutPage).clickBackToProject()
Page.nav(DetailOffer).verifyBillingAddress(listBillingAddress)
						.verifyShippingAddress(listShippingAddress)
								
//println '>>  Clear data'
//Page.nav(LeftNavBar).clickMyProjects()
//Page.nav(MyProjectsPage).clickArchiveAction(projectId)
//					.clickCloseToastMessage()