import gocad.buyer.DraftPage
import gocad.buyer.SelectMaterialPopup
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.MySignInPage
import katalon.fw.lib.Page

'1. User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

//'2. User buyer add project'
//Page.nav(LeftNavBar).clickAddProject()
//
//'3. Random project name'
//def projectName = CommonUtility.generateRandomProjectName(10)
//
//'4. Open add project popup and input project name'
//Page.nav(AddProjectPopup).inputProjectName("$projectName").clickOKButton()
//
//'5. Upload file part on Data upload page'
//Page.nav(DataUploadPage).uploadFileTesting('Milled / Turned Parts', fileName)

'debug. select project'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickAction('1347')

'5. Upload file part on Data upload page'
Page.nav(DataUploadPage).uploadFileTesting('Milled / Turned Parts', fileName)

'6. Select material and get number part'
Page.nav(ManufacturingInformationPage).clickPleaseSelectMaterial()
Page.nav(SelectMaterialPopup).clickMaterialGroup(materialGroup).inputSearchMaterial(materialName)
String material = Page.nav(SelectMaterialPopup).getMaterialAndNumber(materialName)

if (filePDF == "")
{
	println '>> Select material'
	Page.nav(ManufacturingInformationPage).clickPleaseSelectMaterial()
	Page.nav(SelectMaterialPopup).clickMaterialGroup(materialGroup).selectMaterialName(materialName)
	
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
	Page.nav(ManufacturingInformationPage).inputQuantity(quantityNum)
										  .selectSurfaceTreatment(surfaceTreatment)
										  .selectSurfaceQuality(quality)
										  .uploadFilePDFTesting(filePDF)
										  .inputComment(comment)
}

println '>> click Calculate and move to Review page'
Page.nav(ManufacturingInformationPage).clickCalculate()
									  .clickContinueToOfferOverview()
										