import gocad.common.AddProjectPopup
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.MySignInPage
import gocad.buyer.DraftPage
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

String projectId = Page.nav(DataUploadPage).getIdProject()
println "projectId: $projectId"

println '>> Upload file part on Data upload page'
Page.nav(DataUploadPage).uploadFileTesting(workflow, fileName1)

println '>> Continues file part on Data upload page'
Page.nav(ManufacturingInformationPage).clickAddPart()
Page.nav(DataUploadPage).uploadFileTesting(workflow, fileName2)
Page.nav(ManufacturingInformationPage).clickCalculate()

println '>> Back to draft page check data on list Draft page'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).verifyProjectName(projectId, projectName)
					.verifyStatus(projectId, 'Draft')
					.clickArchiveAction(projectId)
					.sleep(1)