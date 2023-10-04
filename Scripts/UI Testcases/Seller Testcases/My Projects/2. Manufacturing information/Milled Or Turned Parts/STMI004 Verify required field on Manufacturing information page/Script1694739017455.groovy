import gocad.common.AddProjectPopup
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.MySignInPage
import gocad.seller.MyProjectsPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility

println '>> User Seller signs in page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller add project'
Page.nav(LeftNavBar).clickMyProjects()
Page.nav(MyProjectsPage).clickAddProject()

println '>> Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>> Open add project popup and input project name'
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
Page.nav(LeftNavBar).clickMyProjects()

println '>>  Clear data'
Page.nav(MyProjectsPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()

