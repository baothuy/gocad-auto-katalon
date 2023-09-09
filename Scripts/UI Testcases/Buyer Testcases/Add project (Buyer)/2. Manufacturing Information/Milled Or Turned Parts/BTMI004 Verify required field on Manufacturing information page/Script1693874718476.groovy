import gocad.buyer.DraftPage
import gocad.common.AddProjectPopup
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.MySignInPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility

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

println '>> Input required field is empty and verify'
Page.nav(ManufacturingInformationPage).inputQuantity(' ')
									  .inputThread(' ')
									  .inputTolerances(' ')
									  .clickCalculate()
									  .verifyErrorWhenQuantityEmpty()
									  .verifyErrorWhenMaterialEmpty()
									  .verifyErrorWhenThreadEmpty()
									  .verifyErrorWhenTolerancesEmpty()
									  
println '>>  User buyer add project'
Page.nav(LeftNavBar).clickDraft()

println '>>  Clear data'
Page.nav(DraftPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()
