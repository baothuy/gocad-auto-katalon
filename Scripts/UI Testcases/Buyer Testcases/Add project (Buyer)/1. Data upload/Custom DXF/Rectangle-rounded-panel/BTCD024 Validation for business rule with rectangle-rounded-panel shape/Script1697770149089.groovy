import gocad.buyer.CustomDXFLeftNavMenu
import gocad.buyer.CustomDXFPage
import gocad.buyer.DraftPage
import gocad.common.AddProjectPopup
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.MySignInPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility

println '>> User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

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
						
println '>> click Rectangle Rounded Panel Shape'
Page.nav(CustomDXFLeftNavMenu).clickRectangleRoundedPanelShape()

println '>> input " width (Mm)" smaller than " height (Mm)" and versa'
Page.nav(CustomDXFPage).inputFileName(fileName)
					   .inputWidth("250")
					   .inputHeight("300")
					   .inputRadius("71")
					   .clickNextStepButton()
					   .sleep(1)

println '>> Verify error when empty field'
Page.nav(CustomDXFPage).verifyErrorWhenInputHeight("The height must be smaller than or equal the width.")		

println '>> input field  Input "Radius (Mm)" larger than (Height (Mm))/2'
Page.nav(CustomDXFPage).inputFileName(fileName)
						.inputWidth("150")
						.inputHeight("140")
						.inputRadius("71")
						.sleep(1)
	 
println '>> Verify error when empty field'
Page.nav(CustomDXFPage).verifyErrorWhenInputInnerRadius("The radius should less than 70mm")
									  
println '>>  Clear data'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()