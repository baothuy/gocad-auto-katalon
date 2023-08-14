import gocad.buyer.DataUploadPage
import gocad.buyer.DraftPage
import gocad.buyer.ManufacturingInformationPage
import gocad.buyer.SelectMaterialPopup
import gocad.common.LeftNavBar
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
Page.nav(DraftPage).clickAction('Project 578X4cNyl7')

'5. Upload file part on Data upload page'
Page.nav(DataUploadPage).uploadFileTesting('Milled / Turned Parts', fileName)

'6. Select material and get number part'
Page.nav(ManufacturingInformationPage).clickPleaseSelectMaterial()
Page.nav(SelectMaterialPopup).clickMaterialGroup(materialGroup).inputSearchMaterial(materialName)
String material = Page.nav(SelectMaterialPopup).getMaterialAndNumber(materialName)
println "material = $material"
Page.nav(SelectMaterialPopup).selectMaterialName(materialName)

'7. Input required field'
Page.nav(ManufacturingInformationPage).inputQuantity(quantityNum)
										.inputThread(threadNum)
										.inputTolerances(tolerancesNum)
										.clickToggleTolerances(tolerancesToggle)
										//.selectSurfaceTreatment(surfaceTreatment)
										.selectSurfaceQuality(quality)
										.inputComment(comment)
										.clickCalculate()
																				
'8. Verify info after Calculate'
String netTotal = Page.nav(ManufacturingInformationPage).calculateNetPrice(unitPrice, quantityNum)
Page.nav(ManufacturingInformationPage).verifyMaterial(material)
										.verifyQuantity(quantityNum)
										.verifyThread(threadNum)
										.verifyTolerancesNumber(tolerancesNum)
										.verifyTolerancesToggle(tolerancesToggle)
										//.verifySurfaceTreatment(surfaceTreatment)
										.verifySurfaceQuality(quality)
										.verifyAdditionalComments(comment)
										.verifyNetPrice(netTotal)
										