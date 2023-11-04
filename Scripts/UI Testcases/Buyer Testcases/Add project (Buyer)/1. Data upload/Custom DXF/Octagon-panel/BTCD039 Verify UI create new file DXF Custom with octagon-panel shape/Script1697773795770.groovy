import gocad.buyer.CustomDXFLeftNavMenu
import gocad.buyer.CustomDXFPage
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
Page.nav(LeftNavBar).clickAddProject()

println '>> Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>> Open add project popup and input project name'
Page.nav(AddProjectPopup).inputProjectName("$projectName").clickOKButton()
String projectId = Page.nav(DataUploadPage).getIdProject()
println "projectId: $projectId"

println '>> click Workflow'
Page.nav(DataUploadPage).clickWorkflow('Sheet Metal Part')
						.clickCustomDXF()
						
println '>> click Octagon Panel Shape'
Page.nav(CustomDXFLeftNavMenu).clickOctagonPanelShape()

println '>> verify UI Visible'
Page.nav(CustomDXFPage).verifyInputFileNameVisible()
						.verifyInputWidthVisible()
						.verifyInputHeightVisible()
						.verifyInputCornerLengthVisible()
						
println '>>  Clear data'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()
					   