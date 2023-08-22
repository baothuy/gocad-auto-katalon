import gocad.buyer.DraftPage
import gocad.buyer.ReviewPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.MySignInPage
import gocad.common.SelectMaterialPopup
import katalon.fw.lib.Page
import katalon.utility.CommonUtility


println '>> FPA002 Verify seller accept offers successfully when project larger than Threshold'
println '>> Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>> User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>>  User buyer add project'
Page.nav(LeftNavBar).clickDraft()

Page.nav(DraftPage).clickAction('1376')

Page.nav(ReviewPage).clickManufacturingInformationProcess()

//Page.nav(ManufacturingInformationPage).clickEdit()

//String material = Page.nav(ManufacturingInformationPage).getMaterialWhenUploadFilePDF()
//String materialGroup = Page.nav(ManufacturingInformationPage).getMaterialGroupWhenUploadFilePDF()
//println "material: $material"
//println "materialGroup: $materialGroup"

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

//println '>> Calculate netPrice value'
//String netPrice = Page.nav(ManufacturingInformationPage).calculateNetPrice(unitPrice)
if (filePDF == ""){
	println '>> Verify UI after calculated manually of request'
	Page.nav(ManufacturingInformationPage).verifyCanPreviewPartFile()
											.verifyNameWorkflowVisible('Milled / Turned Parts')
											.verifyMaterial(material)
											.verifyQuantity(quantityNum)
											.verifyThread(threadNum)
											.verifyTolerancesNumber(tolerancesNum)
											.verifyTolerancesToggle(tolerancesToggle)
											.verifySurfaceTreatment(surfaceTreatment)
											.verifySurfaceQuality(quality)
											.verifyAdditionalComments(comment)
	//										.verifyUnitPrice(unitPrice)
	//										.verifyNetPrice(netPrice)
}
else {
	println '>> Verify UI after calculated manually of request'
	
	Page.nav(ManufacturingInformationPage).verifyCanPreviewPartFile()
											.verifyPDFFileVisibleAfterCalculated(fileName)
											.verifyMaterial(material)
											.verifyQuantity(quantityNum)
											.verifySurfaceTreatment(surfaceTreatment)
											.verifySurfaceQuality(quality)
											.verifyAdditionalComments(comment)
	//										.verifyUnitPrice(unitPrice)
	//										.verifyNetPrice(netPrice)
}