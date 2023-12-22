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
						
println '>> click Round Shape'
Page.nav(CustomDXFLeftNavMenu).clickRoundShape()

println '>> input field'
Page.nav(CustomDXFPage).inputFileName(fileName)
					   .inputExternalDiameter(externalDiameter)
					   .inputInsideDiameter(insideDiameter)
					   .inputNumberOfHoles(numberOfHoles)
					   .inputDiameterBoltCircle(diameterBoltCircle)
					   .inputDiameterHoles(diameterHoles)
					   .sleep(1)

println '>> Verify error when empty field'
Page.nav(CustomDXFPage).verifyErrorWhenInputFileName("Required")
					   .verifyErrorWhenInputExternalDiameter("Required")
					   .verifyErrorWhenInputInsideDiameter("Required")
					   .verifyErrorWhenInputNumberOfHoles("Required")
					   .verifyErrorWhenInputDiameterBoltCircle("Required")
					   .verifyErrorWhenInputDiameterHoles("Required")
									  
println '>>  Clear data'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()