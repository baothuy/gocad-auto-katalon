import gocad.buyer.DraftPage
import gocad.common.AddProjectPopup
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.SignInPage
import gocad.common.SelectMaterialPopup
import katalon.fw.lib.Page
import katalon.utility.CommonUtility
import katalon.utility.FileHelper

println '>>  User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>>  User buyer add project'
Page.nav(LeftNavBar).clickNewProject()

println '>>  Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>>  Click edit project name and input project name'
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
	 
	 Page.nav(ManufacturingInformationPage).inputFieldMTPShop(quantityNum, "", "", quality, comment)
}

println '>> click Calculate button'
Page.nav(ManufacturingInformationPage).clickCalculate()

println '>> Calculate netPrice value'
String netPrice = Page.nav(ManufacturingInformationPage).calculateNetPrice(unitPrice,quantityNum)

println '>> Verify UI after calculated automatically of request'
Page.nav(ManufacturingInformationPage).verifyMaterialValue(material)
										.verifyQuantityValue(quantityNum)
										//.verifySurfaceTreatmentValue(surfaceTreatment)
										.verifySurfaceQualityValue(quality)
										.verifyAdditionalCommentsValue(comment)											
										.verifyUnitPriceValue(unitPrice)
										.verifyNetPriceValue(netPrice)

println '>>  Click edit'
Page.nav(ManufacturingInformationPage).clickEdit()

if (filePDF == "")
{
		println '>> Select material'
		Page.nav(ManufacturingInformationPage).clickPleaseSelectMaterial()
		Page.nav(SelectMaterialPopup).clickMaterialGroup(materialGroupChanged).inputSearchMaterial(materialNameChanged)
		material = Page.nav(SelectMaterialPopup).getMaterialAndNumber(materialNameChanged)
		println "material = $material"
		Page.nav(SelectMaterialPopup).selectMaterialName(materialNameChanged)
		
		println '>> Input required field'
		Page.nav(ManufacturingInformationPage).clickProvideOwnMaterialCB(provideOwnProductChanged)
												.inputQuantity(quantityNumChanged)
												.inputThread(threadNumChanged)
												.inputTolerances(tolerancesNumChanged)
												.clickToggleTolerances(tolerancesToggle)
												.removeSelectSurfaceTreatment(surfaceTreatment)
												.selectSurfaceTreatment(surfaceTreatmentChanged)
												.selectSurfaceQuality(qualityChanged)
												.inputComment(comment)
}
else
{
	Page.nav(ManufacturingInformationPage).uploadFilePDFTesting('Milled / Turned Parts', filePDF)
	 String getMaterialName = Page.nav(ManufacturingInformationPage).getMaterialWhenUploadFilePDF()
	 String getMaterialGroup = Page.nav(ManufacturingInformationPage).getMaterialGroupWhenUploadFilePDF()
	 
	 if (getMaterialName == null) {
		Page.nav(ManufacturingInformationPage).clickPleaseSelectMaterial()
		Page.nav(SelectMaterialPopup).clickMaterialGroup(materialGroup).inputSearchMaterial(materialNameChanged)
		material = Page.nav(SelectMaterialPopup).getMaterialAndNumber(materialNameChanged)
		println "material = $material"
		Page.nav(SelectMaterialPopup).selectMaterialName(materialNameChanged)
	 }
	 else {
		Page.nav(ManufacturingInformationPage).clickPleaseSelectMaterial()
		Page.nav(SelectMaterialPopup).clickMaterialGroup(getMaterialGroup).inputSearchMaterial(getMaterialName)
		material = Page.nav(SelectMaterialPopup).getMaterialAndNumber(getMaterialName)
		Page.nav(SelectMaterialPopup).clickCloseSearchMaterialPopup()
	 }
	 
	 Page.nav(ManufacturingInformationPage).clickProvideOwnMaterialCB(provideOwnProductChanged)
	 										.inputQuantity(quantityNumChanged)
	 										.removeSelectSurfaceTreatment(surfaceTreatment)
											 .selectSurfaceTreatment(surfaceTreatmentChanged)
											 .selectSurfaceQuality(qualityChanged)
											 .inputComment(comment)
}

println '>> click Calculate button'
Page.nav(ManufacturingInformationPage).clickCalculate()

println '>> Calculate netPrice value'
String netPriceChanged = Page.nav(ManufacturingInformationPage).calculateNetPrice(unitPriceChanged,quantityNumChanged)

println '>> Verify UI after calculated automatically of request'
Page.nav(ManufacturingInformationPage).verifyMaterialValue(material)
										.verifyQuantityValue(quantityNumChanged)
										.verifySurfaceTreatmentValue(surfaceTreatmentChanged)
										.verifySurfaceQualityValue(qualityChanged)
										.verifyAdditionalCommentsValue(comment)
										.verifyUnitPriceValue(unitPriceChanged)
										.verifyNetPriceValue(netPriceChanged)

println '>>  Clear data'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()
	