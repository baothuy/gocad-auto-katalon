import gocad.buyer.DraftPage
import gocad.common.DataUploadPage
import gocad.common.ManufacturingInformationPage
import gocad.buyer.ReviewPage
import gocad.buyer.SelectMaterialPopup
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import katalon.fw.lib.Page

//'All param on this flow'
//'Random project name'
//def projectName = CommonUtility.generateRandomProjectName(10)

'1. User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

//'2. User buyer add project'
//Page.nav(LeftNavBar).clickAddProject()
//
//'3. Open add project popup and add new project name'
//Page.nav(AddProjectPopup).inputProjectName("$projectName").clickOKButton()
//String projectId = Page.nav(DataUploadPage).getIdProject()
//println "projectId: $projectId"

'debug. select project'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickAction('Project 578X4cNyl7')

'4. Upload file part on Data upload page'
Page.nav(DataUploadPage).uploadFileTesting('Milled / Turned Parts', fileName)

'5. Select material and get CO2 Emission'
Page.nav(ManufacturingInformationPage).clickPleaseSelectMaterial()
Page.nav(SelectMaterialPopup).clickMaterialGroup(materialGroup).inputSearchMaterial(materialName)
String material = Page.nav(SelectMaterialPopup).getMaterialAndNumber(materialName)
println "material = $material"
Page.nav(SelectMaterialPopup).selectMaterialName(materialName)

'6. Input required field'
Page.nav(ManufacturingInformationPage).inputQuantity(quantityNum)
										.inputThread(threadNum)
										.inputTolerances(tolerancesNum)
										.clickToggleTolerances(tolerancesToggle)
										//.selectSurfaceTreatment(surfaceTreatment)
										.selectSurfaceQuality(quality)
										.inputComment(comment)
										.clickCalculate()
										
'7. Calculate Net total and click Continue To Offer Overview'
String netTotal = Page.nav(ManufacturingInformationPage).calculateNetPrice(unitPrice,quantityNum)
Page.nav(ManufacturingInformationPage).clickContinueToOfferOverview()
										
'8. Verify value after navigate to Review page'
Page.nav(ReviewPage).verifyImagePartClickable(fileName)
					.verifyPartName(fileName)
					.verifyFileClickable(fileName)
					.verifyFiles(fileName)
					.verifyMaterial(fileName, material)
					.verifyQuantity(fileName, quantityNum)
					.verifyUnitPrice(fileName, unitPrice)
					.verifyPartPriceTotal(fileName, netTotal)
					