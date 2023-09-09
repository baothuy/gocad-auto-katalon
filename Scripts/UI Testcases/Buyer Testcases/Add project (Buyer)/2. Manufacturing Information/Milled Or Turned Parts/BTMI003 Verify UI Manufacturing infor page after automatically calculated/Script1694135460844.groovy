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

println '>>  User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>>  User buyer add project'
Page.nav(LeftNavBar).clickAddProject()

println '>>  Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>>  Open add project popup and input project name'
Page.nav(AddProjectPopup).inputProjectName("$projectName").clickOKButton()
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

println '>> click Calculate button'
Page.nav(ManufacturingInformationPage).clickCalculate()

println '>> Calculate netPrice value'
String netPrice = Page.nav(ManufacturingInformationPage).calculateNetPrice(unitPrice,quantityNum)
if (filePDF == ""){
	println '>> Verify UI after calculated manually of request'
	Page.nav(ManufacturingInformationPage).verifyCanPreviewPartFile()
											.clickClosePreviewPartFilePopup()
											.verifyMaterialValue(material)
											.verifyQuantityValue(quantityNum)
											.verifyThreadValue(threadNum)
											.verifyTolerancesNumberValue(tolerancesNum)
											.verifyTolerancesToggleValue(tolerancesToggle)
											.verifySurfaceTreatmentValue(surfaceTreatment)
											.verifySurfaceQualityValue(quality)
											.verifyAdditionalCommentsValue(comment)
											.verifyDeleteButtonVisible()
											.verifyEditButtonVisible()
											.clickMoreOption()
											.verifyCopyButtonVisible()
											.verifyMoveButtonVisible()
											.verifyUnitPriceValue(unitPrice)
											.verifyNetPriceValue(netPrice)
}
else {
	println '>> Verify UI after calculated manually of request'
	Page.nav(ManufacturingInformationPage).verifyCanPreviewPartFile()
											.clickClosePreviewPartFilePopup()
											.verifyPDFFileVisibleAfterCalculated(partName)
											.verifyMaterialValue(material)
											.verifyQuantityValue(quantityNum)
											.verifySurfaceTreatmentValue(surfaceTreatment)
											.verifySurfaceQualityValue(quality)
											.verifyAdditionalCommentsValue(comment)
											.verifyDeleteButtonVisible()
											.verifyEditButtonVisible()
											.clickMoreOption()
											.verifyCopyButtonVisible()
											.verifyMoveButtonVisible()
											.verifyUnitPriceValue(unitPrice)
											.verifyNetPriceValue(netPrice)
}

println '>>  Verify can download succesfully'
Page.nav(ManufacturingInformationPage).clickPartFileToDownload(partName)
Page.nav(FileHelper).verifyFileDownloaded(partName)

println '>>  Clear data'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()
	