import gocad.buyer.CustomDXFLeftNavMenu
import gocad.buyer.CustomDXFPage
import gocad.buyer.DraftPage
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.SelectMaterialPopup
import gocad.common.SignInPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility

println '>>  User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>>  User buyer add project'
Page.nav(LeftNavBar).clickNewProject()

println '>>  Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>>  Click edit project name and input project name'
Page.nav(DataUploadPage).clickEditProjectName(projectName)
String projectId = Page.nav(DataUploadPage).getIdProject()
println "projectId: $projectId"

println '>>  Upload file part on Data upload page'
Page.nav(DataUploadPage).uploadFileTesting('Sheet Metal Part', partName)

println '>> 1. Cases input required field is empty and verify'
Page.nav(ManufacturingInformationPage).inputQuantity(' ')
									  .inputThread(' ')
									  .inputCountersink(' ')
									  .clickCalculate()
									  .verifyErrorWhenQuantityEmpty()
									  .verifyErrorWhenMaterialEmpty()
									  .verifyErrorWhenThreadCuttingEmpty()
									  .verifyErrorWhenCountersinkEmpty()
									  .verifyErrorWhenThicknessEmpty()
									  
println '>> 2. When selected Laser marking is Yes then <Add technical drawing> is required field'
Page.nav(ManufacturingInformationPage).refreshPage()
println '>> Select material'
Page.nav(ManufacturingInformationPage).clickPleaseSelectMaterial()
Page.nav(SelectMaterialPopup).clickMaterialGroup(materialGroup).inputSearchMaterial(materialName)
Page.nav(SelectMaterialPopup).selectMaterialName(materialName)

Page.nav(ManufacturingInformationPage).selectLaserMarking(laserMarking)
										.clickCalculate()
										.verifyErrorBelowAddTechnicalDrawing("Required")
										
										
println '>> 3. When selected Surface Treatment is Powder coating then <Add technical drawing> is required field'
Page.nav(ManufacturingInformationPage).refreshPage()
println '>> Select material'
Page.nav(ManufacturingInformationPage).clickPleaseSelectMaterial()
Page.nav(SelectMaterialPopup).clickMaterialGroup(materialGroup).inputSearchMaterial(materialName)
Page.nav(SelectMaterialPopup).selectMaterialName(materialName)

Page.nav(ManufacturingInformationPage).selectSurfaceTreatment(surfaceTreatment)
										.clickCalculate()
										.verifyErrorBelowAddTechnicalDrawing("Required")
										
println '>> 4. When added by Configure Design have <Number of holes (pcs)> the Upload technical drawing is required field'
Page.nav(ManufacturingInformationPage).refreshPage()
println '>> Remove old part'
Page.nav(ManufacturingInformationPage).clickMoreOption().clickDeletePart().clickOK()

println '>> click Workflow'
Page.nav(DataUploadPage).clickCustomDXF()
						
println '>> click Circle Panel Shape'
Page.nav(CustomDXFLeftNavMenu).clickCirclePanelShape()

println '>> input field'
Page.nav(CustomDXFPage).inputFileName(fileName)
					   .inputDiameter(diameter)
					   .inputNumberOfHoles(numberOfHoles)
					   .clickNextStepButton()
					   .sleep(1)
					   
println '>> Select material'
Page.nav(ManufacturingInformationPage).clickPleaseSelectMaterial()
Page.nav(SelectMaterialPopup).clickMaterialGroup(materialGroup).inputSearchMaterial(materialName)
Page.nav(SelectMaterialPopup).selectMaterialName(materialName)

Page.nav(ManufacturingInformationPage).clickCalculate()
										.verifyErrorBelowAddTechnicalDrawing("Required")
									  
println '>>  User buyer add project '
Page.nav(LeftNavBar).clickDraft()

println '>>  Clear data'
Page.nav(DraftPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()

