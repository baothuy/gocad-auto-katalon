import gocad.buyer.AccountSettingsPage
import gocad.buyer.AddressInformationPopup
import gocad.buyer.CheckoutPage
import gocad.buyer.ReviewPage
import gocad.buyer.DraftPage
import gocad.common.AddProjectPopup
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.MySignInPage
import gocad.common.SelectMaterialPopup
import katalon.fw.lib.Page
import katalon.utility.CommonUtility
import katalon.utility.FileHelper


println '>> FPA004 Verify buyer accept offer with offer calculated manually will confirm offer successfully'
println '>> Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>> User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> Get company Name on Settings page'
Page.nav(LeftNavBar).clickSettings()
String companyName = Page.nav(AccountSettingsPage).getCompanyName()

println '>> User buyer add project'
Page.nav(LeftNavBar).clickAddProject()

println '>> Open add project popup and add new project name'
Page.nav(AddProjectPopup).inputProjectName("$projectName").clickOKButton()
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
	Page.nav(ManufacturingInformationPage).inputQuantity(quantityNum)
											.inputThread(threadNum)
											.inputTolerances(tolerancesNum)
											.clickToggleTolerances(tolerancesToggle)
											.selectSurfaceTreatment(surfaceTreatment)
											.selectSurfaceQuality(quality)
											.inputComment(comment)
}
else
{
	Page.nav(ManufacturingInformationPage).uploadFilePDFTesting(filePDF)
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
									.clickContinueToOfferOverview()

println '>> click checkout button'
Page.nav(ReviewPage).clickCheckout()

println '>> Verify information Address Information show correctly'
println '>> Click Edit address'
Page.nav(CheckoutPage).clickEditAddress()

println '>> Input edit information successfully'
Page.nav(AddressInformationPopup).inputFirstNameBillingAddress(billingAddressChanged[0])
								.inputLastNameBillingAddress(billingAddressChanged[1])
								.inputHouseNumberBillingAddress(billingAddressChanged[2])
								.inputStreetBillingAddress(billingAddressChanged[3])
								.selectStateBillingAddress(billingAddressChanged[4])
								.inputZIPCodeBillingAddress(billingAddressChanged[5])
								.inputCityBillingAddress(billingAddressChanged[6])
								.inputFirstNameShippingAddress(shippingAddressChanged[0])
								.inputLastNameShippingAddress(shippingAddressChanged[1])
								.inputHouseNumberShippingAddress(shippingAddressChanged[2])
								.inputStreetShippingAddress(shippingAddressChanged[3])
								.selectStateShippingAddress(shippingAddressChanged[4])
								.inputZIPCodeShippingAddress(shippingAddressChanged[5])
								.inputCityShippingAddress(shippingAddressChanged[6])
								.clickOK()
List<String> listBillingAddress = [billingAddressChanged[0] + " " + billingAddressChanged[1], billingAddressChanged[2], billingAddressChanged[3], billingAddressChanged[4], billingAddressChanged[5], billingAddressChanged[6]]
List<String> listShippingAddress = [shippingAddressChanged[0] + " " + shippingAddressChanged[1], shippingAddressChanged[2], shippingAddressChanged[3], shippingAddressChanged[4], shippingAddressChanged[5], shippingAddressChanged[6]]
Page.nav(CheckoutPage).sleep(1)
					.refreshPage()
println '>> Verify after update show correctly on checkout page'
Page.nav(ReviewPage).clickCheckout()
Page.nav(CheckoutPage).verifyBillingAddress(listBillingAddress)
						.verifyShippingAddress(listShippingAddress)
						
println '>> Click Edit address'
Page.nav(CheckoutPage).clickEditAddress()

println '>> Re update old information successfully'
Page.nav(AddressInformationPopup).inputFirstNameBillingAddress(billingAddress[0])
								.inputLastNameBillingAddress(billingAddress[1])
								.inputStreetBillingAddress(billingAddress[2])
								.inputHouseNumberBillingAddress(billingAddress[3])
								.selectStateBillingAddress(billingAddress[4])
								.inputZIPCodeBillingAddress(billingAddress[5])
								.inputCityBillingAddress(billingAddress[6])
								.inputFirstNameShippingAddress(shippingAddress[0])
								.inputLastNameShippingAddress(shippingAddress[1])
								.inputStreetShippingAddress(shippingAddress[2])
								.inputHouseNumberShippingAddress(shippingAddress[3])
								.selectStateShippingAddress(shippingAddress[4])
								.inputZIPCodeShippingAddress(shippingAddress[5])
								.inputCityShippingAddress(shippingAddress[6])
								.clickOK()
								
println '>>  Clear data'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()