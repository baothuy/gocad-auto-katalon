import gocad.buyer.AccountSettingsPage
import gocad.buyer.DraftPage
import gocad.buyer.RequestOfferPopup
import gocad.buyer.RequestedOffersPage
import gocad.buyer.ReviewPage
import gocad.common.AddProjectPopup
import gocad.common.DataUploadPage
import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.SignInPage
import gocad.common.SelectMaterialPopup
import gocad.common.ViewPartPopup
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
List<String> listBillingAddress = Page.nav(AccountSettingsPage).getBillingAddress()
List<String> listShippingAddress = Page.nav(AccountSettingsPage).getShippingAddress()
List<String> listCustomerInfo = Page.nav(AccountSettingsPage).getCustomerInfo()

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
	Page.nav(ManufacturingInformationPage).inputFieldMTPShop(quantityNum, threadNum, tolerancesNum, quality, comment)
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
String unitPrice = Page.nav(ManufacturingInformationPage).getUnitPriceValue()
String netPrice = Page.nav(ManufacturingInformationPage).getNetPriceValue()
Page.nav(ManufacturingInformationPage).clickReview()

println '>> Verify UI Visible'
Page.nav(ReviewPage)//.verifyImagePartClickable(partName)
					.verifyPartNameVisible(partName)
					.verifyFileVisible(partName)
					.verifyFileClickable(partName)
					.verifyMaterialVisible(partName)
					.verifyQuantityVisible(partName)
					.verifyUnitPriceVisible(partName)
					.verifyTotalPartPriceVisible(partName)
					.verifyCO2EmissionVisible(partName)					
					.verifyActionMoreVisible(partName)
					.clickMoreOption(partName)
					.verifyActionViewVisible()
					.verifyActionCopyVisible()
					.verifyActionMoveVisible()
					.verifyRequestOfferButtonVisible(partName)
				
println '>> Verify value on Review Page show correctly'
Page.nav(ReviewPage).verifyPartNameValue(partName)
					.verifyMaterialValue(partName, material)
					.verifyQuantityValue(partName, quantityNum)
					.verifyUnitPriceValue(partName, unitPrice)
					.verifyPartPriceTotalValue(partName, netPrice)
					.verifyCommentValue(partName, comment)

println '>> Verify data on View page show correctly'
Page.nav(ReviewPage).clickMoreOption(partName)
					.clickView(partName)
Page.nav(ViewPartPopup).verifyMaterialValue(material)
						.verifyQuantityValue(quantityNum)
						.verifyThreadValue(threadNum)
						.verifyTolerancesNumberValue(tolerancesNum)
						//.verifyTolerancesToggleValue(*)
						//.verifySurfaceTreatmentValue(surfaceTreatment)
						.verifySurfaceQualityValue(quality)
						.verifyAdditionalCommentsValue(comment)
						.verifyUnitPriceValue(unitPrice)
						.verifyNetPriceValue(netPrice)
						.clickClosePopup()
					
String CO2Emission = Page.nav(ReviewPage).getCO2EmissionValue(partName)	
List<String> tablePart = [partName, material, quantityNum, unitPrice, netPrice, comment, CO2Emission]

println '>> Verify value on Request Offer Popup show correctly'
Page.nav(ReviewPage).clickRequestOffer()

Page.nav(RequestOfferPopup).verifyUIVisableOnRequestOfferPopup()
							.verifyContentAlert()
							.verifyBillingAddressValue(listBillingAddress)
							.clickCancel()
							
println '>>  Clear data'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()