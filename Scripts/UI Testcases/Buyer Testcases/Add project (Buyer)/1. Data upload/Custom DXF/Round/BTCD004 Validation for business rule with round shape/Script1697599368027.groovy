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
						
println '>> click Round Shape'
Page.nav(CustomDXFLeftNavMenu).clickRoundShape()

println '>> input field'
Page.nav(CustomDXFPage).inputFileName(fileName)
					   .inputExternalDiameter("100")
					   .inputInsideDiameter("200")
					   .inputNumberOfHoles("0")
					   .inputDiameterBoltCircle("0")
					   .inputDiameterHoles("0")
					   .sleep(1)

println '>> Verify error when empty field'
Page.nav(CustomDXFPage).verifyErrorWhenInputInsideDiameter("Inside diameter (mm) must be less than 100")
					   
println '>> input field'
Page.nav(CustomDXFPage).inputFileName(fileName)
						  .inputExternalDiameter("250")
						  .inputInsideDiameter("190")
						  .inputNumberOfHoles("1")
						  .inputDiameterBoltCircle("100")
						  .inputDiameterHoles("1")
						  .sleep(1)
   
println '>> Error: The diameter bolt circle should great than ${ Inside diameter + Diameter holes }'
Page.nav(CustomDXFPage).verifyErrorWhenInputDiameterBoltCircle("The diameter bolt circle should great than 191mm")
						  
println '>> input field'
Page.nav(CustomDXFPage).inputFileName(fileName)
						.inputExternalDiameter("250")
						.inputInsideDiameter("190")
						.inputNumberOfHoles("1")
						.inputDiameterBoltCircle("252")
						.inputDiameterHoles("5")
						.sleep(1)
	 
println '>> Error: The diameter bolt circle should beetween ${ External diameter - Diameter holes }'
Page.nav(CustomDXFPage).verifyErrorWhenInputDiameterBoltCircle("The diameter bolt circle should between 195mm - 245mm")					
									  
println '>>  Clear data'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()