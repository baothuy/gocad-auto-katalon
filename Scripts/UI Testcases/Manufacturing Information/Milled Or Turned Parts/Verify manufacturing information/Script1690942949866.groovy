import gocad.buyer.DraftPage
import gocad.common.LeftNavBar
import gocad.buyer.ManufacturingInformationPage
import gocad.buyer.SelectMaterialPopup
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
//Page.nav(DataUploadPage).uploadFileTestingForMTP(fileName)

'debug. select project'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickAction('Project LFjb7oYebV')

'6. Select material and get CO2 Emission'
Page.nav(ManufacturingInformationPage).clickPleaseSelectMaterial()
Page.nav(SelectMaterialPopup).clickMaterialGroup(materialGroup).inputSearchMaterial(materialName)
String CO2Emission = Page.nav(SelectMaterialPopup).getCO2EmissionCol(materialName)
println "CO2Emission = $CO2Emission"
Page.nav(SelectMaterialPopup).selectMaterialName(materialName)

'7. Input required field'
Page.nav(ManufacturingInformationPage).inputQuantity(quantityNum)
										.inputThread(threadNum)
										.inputTolerances(tolerancesNum)
										.clickToggleTolerances(tolerancesToggle)
										.selectSurfaceTreatment(surfaceTreatment)
										.selectSurfaceQuality(quality)
										.inputComment(comment)
										.clickCalculate()
										
'8. Verify info after Calculate'
materialCombine = materialName + "/" + CO2Emission
Page.nav(ManufacturingInformationPage).verifyMaterial(materialCombine)
										.verifyQuantity(quantityNum)
										.verifyThread(threadNum)
										.verifyTolerancesNumber(tolerancesNum)
										.verifyTolerancesToggle(tolerancesToggle)
										.verifySurfaceTreatment(surfaceTreatment)
										.verifySurfaceQuality(quality)
										.verifyAdditionalComments(comment)
										