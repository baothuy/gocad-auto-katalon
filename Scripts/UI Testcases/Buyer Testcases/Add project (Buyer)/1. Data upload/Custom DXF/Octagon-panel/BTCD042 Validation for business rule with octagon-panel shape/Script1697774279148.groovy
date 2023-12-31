import gocad.buyer.CustomDXFLeftNavMenu
import gocad.buyer.CustomDXFPage
import gocad.buyer.DraftPage
import gocad.common.AddProjectPopup
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
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
String projectId = Page.nav(DataUploadPage).getIdProject()
println "projectId: $projectId"

println '>> click Workflow'
Page.nav(DataUploadPage).clickWorkflow('Sheet Metal Part')
						.clickCustomDXF()
						
println '>> click Octagon Panel Shape'
Page.nav(CustomDXFLeftNavMenu).clickOctagonPanelShape()

println '>> input " width (Mm)" smaller than " height (Mm)" and versa'
Page.nav(CustomDXFPage).inputFileName(fileName)
					   .inputWidth("250")
					   .inputHeight("300")
					   .inputCornerLength("60")
					   .clickNextStepButton()
					   .sleep(1)

println '>> Verify error when empty field'
Page.nav(CustomDXFPage).verifyErrorWhenInputHeight("Height (mm) must be less than or equal to 250")			

println '>> Input "Length of corner (Mm)" larger than (Height (Mm))/2'
Page.nav(CustomDXFPage).inputFileName(fileName)
					   .inputWidth("250")
					   .inputHeight("150")
					   .inputCornerLength("76")
					   .clickNextStepButton()
					   .sleep(1)

println '>> Verify error when empty field'
Page.nav(CustomDXFPage).verifyErrorWhenInputCornerLength("The length of the corner should be less than or equal 75mm")
									  
println '>>  Clear data'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()