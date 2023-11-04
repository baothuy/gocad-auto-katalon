import gocad.common.AddProjectPopup
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.common.ManufacturingInformationPage
import gocad.seller.MyProjectsPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility

println '>> User Seller signs in to administration page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller add project'
Page.nav(LeftNavBar).clickMyProjects()
Page.nav(MyProjectsPage).clickAddProject()

println '>> Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>> Open add project popup and input project name'
Page.nav(AddProjectPopup).inputProjectName("$projectName").clickOKButton()

String projectId = Page.nav(DataUploadPage).getIdProject()
println "projectId: $projectId"

println '>> Upload file part on Data upload page'
Page.nav(DataUploadPage).uploadFileTesting(workflow, fileName1)

println '>> Continues file part on Data upload page'
Page.nav(ManufacturingInformationPage).clickAddPart()
Page.nav(DataUploadPage).uploadFileTesting(workflow, fileName2)
Page.nav(ManufacturingInformationPage).clickCalculate()

println '>> Back to draft page check data on list Draft page'
Page.nav(LeftNavBar).clickMyProjects()
Page.nav(MyProjectsPage).verifyProjectName(projectId, projectName)
					.verifyStatus(projectId, 'Draft')
					.clickArchiveAction(projectId)
					.sleep(1)