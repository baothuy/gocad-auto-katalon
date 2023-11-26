import gocad.buyer.AddressInformationPopup
import gocad.buyer.ReviewPage
import gocad.common.AddProjectPopup
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.SignInPage
import gocad.common.SelectMaterialPopup
import gocad.seller.MyProjectsPage
import gocad.seller.SendOfferPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility
import katalon.utility.DateTimeUtility


println '>> User Seller signs in page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller add project'
Page.nav(LeftNavBar).clickMyProjects()
Page.nav(MyProjectsPage).clickAddProject()

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
	Page.nav(ManufacturingInformationPage).clickProvideOwnMaterialCB(provideOwnProduct)
											.inputQuantity(quantityNum)
											.inputThread(threadNum)
											.inputTolerances(tolerancesNum)
											.clickToggleTolerances(tolerancesToggle)
											.selectSurfaceTreatment(surfaceTreatment)
											.selectSurfaceQuality(quality)
											.inputComment(comment)
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
	 
	 Page.nav(ManufacturingInformationPage).clickProvideOwnMaterialCB(provideOwnProduct)
	 										.inputQuantity(quantityNum)
											 .selectSurfaceTreatment(surfaceTreatment)
											 .selectSurfaceQuality(quality)
											 .inputComment(comment)
											 .inputDeliveryDate(deliveryDate)
}

println '>> click Calculate and move to Review page'
Page.nav(ManufacturingInformationPage).clickCalculate()
									.clickContinueToOfferOverview()

println '>> Verify information Address Information show correctly'
println '>> Click Edit address'
Page.nav(SendOfferPage).clickEditAddress()

println '>> Input edit information successfully'
Page.nav(AddressInformationPopup).inputFirstNameBillingAddress(billingAddressChanged[0])
								.inputLastNameBillingAddress(billingAddressChanged[1])
								.inputHouseNumberBillingAddress(billingAddressChanged[2])
								.inputStreetBillingAddress(billingAddressChanged[3])
								.selectCountryBillingAddress(billingAddressChanged[7])
								.selectStateBillingAddress(billingAddressChanged[4])
								.inputZIPCodeBillingAddress(billingAddressChanged[5])
								.selectCityBillingAddress(billingAddressChanged[6])							
								.inputFirstNameShippingAddress(shippingAddressChanged[0])
								.inputLastNameShippingAddress(shippingAddressChanged[1])
								.inputHouseNumberShippingAddress(shippingAddressChanged[2])
								.inputStreetShippingAddress(shippingAddressChanged[3])
								.selectCountryShippingAddress(shippingAddressChanged[7])
								.selectStateShippingAddress(shippingAddressChanged[4])
								.inputZIPCodeShippingAddress(shippingAddressChanged[5])
								.selectCityShippingAddress(shippingAddressChanged[6])								
								.clickOK()
List<String> listBillingAddress = [billingAddressChanged[0] + " " + billingAddressChanged[1], billingAddressChanged[2], billingAddressChanged[3], billingAddressChanged[4], billingAddressChanged[5], billingAddressChanged[6]]
List<String> listShippingAddress = [shippingAddressChanged[0] + " " + shippingAddressChanged[1], shippingAddressChanged[2], shippingAddressChanged[3], shippingAddressChanged[4], shippingAddressChanged[5], shippingAddressChanged[6]]
Page.nav(SendOfferPage).sleep(1)
					.refreshPage()
println '>> Verify after update show correctly on checkout page'
Page.nav(ManufacturingInformationPage).clickContinueToOfferOverview()
Page.nav(SendOfferPage).verifyBillingAddress(listBillingAddress)
						.verifyShippingAddress(listShippingAddress)
						
println '>> Click Edit address'
Page.nav(SendOfferPage).clickEditAddress()

println '>> Re update old information successfully'
Page.nav(AddressInformationPopup).inputFirstNameBillingAddress(billingAddress[0])
								.inputLastNameBillingAddress(billingAddress[1])
								.inputStreetBillingAddress(billingAddress[2])
								.inputHouseNumberBillingAddress(billingAddress[3])
								.selectCountryBillingAddress(billingAddress[7])
								.selectStateBillingAddress(billingAddress[4])
								.inputZIPCodeBillingAddress(billingAddress[5])
								.selectCityBillingAddress(billingAddress[6])
								.inputFirstNameShippingAddress(shippingAddress[0])
								.inputLastNameShippingAddress(shippingAddress[1])
								.inputStreetShippingAddress(shippingAddress[2])
								.inputHouseNumberShippingAddress(shippingAddress[3])
								.selectCountryShippingAddress(shippingAddress[7])
								.selectStateShippingAddress(shippingAddress[4])
								.inputZIPCodeShippingAddress(shippingAddress[5])
								.selectCityShippingAddress(shippingAddress[6])
								.clickOK()
								
println '>>  Clear data'
Page.nav(LeftNavBar).clickMyProjects()
Page.nav(MyProjectsPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()