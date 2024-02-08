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
Page.nav(DataUploadPage).clickCustomDXF()
						
println '>> click Elongated Round Shape'
Page.nav(CustomDXFLeftNavMenu).clickElongatedRoundGasketShape()

println '>> input "Outer width (Mm)" smaller than "Outer height (Mm)" and versa'
Page.nav(CustomDXFPage).inputFileName(fileName)
					   .inputOuterWidth("250")
					   .inputOuterHeight("300")
					   .inputWebThickness("50")
					   .clickNextStepButton()
					   .sleep(1)

println '>> Verify error when empty field'
Page.nav(CustomDXFPage).verifyErrorWhenInputOuterHeight("The outer height must be smaller than the outer width.")
					  
println '>> input "Web thickness (Mm)" larger than (Outer height (Mm))/2'
Page.nav(CustomDXFPage).inputFileName(fileName)
						 .inputOuterWidth("250")
						 .inputOuterHeight("170")
						 .inputWebThickness("86")
						 .clickNextStepButton()
						 .sleep(1)
  
println '>> Verify error when empty field'
Page.nav(CustomDXFPage).verifyErrorWhenInputWebThickness("The web thickness should less than 85mm")
									  
println '>>  Clear data'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()