import gocad.buyer.AddProjectPopup
import gocad.buyer.DataUploadPage
import gocad.buyer.LeftNavBar
import gocad.buyer.ManufacturingInformationPage
import gocad.buyer.SelectMaterialPopup
import gocad.buyer.DraftPage
import gocad.common.MySignInPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility


'1. User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

'2. User buyer add project'
Page.nav(LeftNavBar).clickAddProject()

'3. Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

'4. Open add project popup and input project name'
Page.nav(AddProjectPopup).inputProjectName("$projectName").clickOKButton()

'5. Upload file part on Data upload page'
Page.nav(DataUploadPage).uploadFileTesting(fileName)

'6. Select material'
Page.nav(ManufacturingInformationPage).clickPleaseSelectMaterial()
Page.nav(SelectMaterialPopup).clickMaterialGroup("All").selectMaterialName("Al2Cl3")

'7. Input required field'
Page.nav(ManufacturingInformationPage).inputQuantity(quantityNum)
										.inputThread(threadNum)
										.inputTolerances(tolerancesNum)
										.clickToggleTolerances(tolerancesToggle)
										.selectSurfaceTreatment(surfaceTreatment)
										.selectSurfaceQuality(quality)
										.inputComment(comment)
										.clickCalculate()
										.clickContinueToOfferOverview()

'debug. select project'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickAction('Project hEAJbCppg8')
