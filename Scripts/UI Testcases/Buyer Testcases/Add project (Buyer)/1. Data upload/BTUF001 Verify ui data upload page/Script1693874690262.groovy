import gocad.buyer.DraftPage
import gocad.common.AddProjectPopup
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility

println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> User buyer add project'
Page.nav(LeftNavBar).clickNewProject()

println '>> Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>> Open add project popup and input project name'
Page.nav(DataUploadPage).clickEditProjectName(projectName)

println '>> Verify ui data upload page'
Page.nav(DataUploadPage).verifyUIDataUploadPageOfBuyer(projectName)

String projectId = Page.nav(DataUploadPage).getIdProject()
println "projectId: $projectId"

println '>> Back to draft page check data on list Draft page'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).verifyProjectName(projectId, projectName)
					.verifyStatus(projectId, 'Draft')
					.clickArchiveAction(projectId)
					.sleep(1)
					
