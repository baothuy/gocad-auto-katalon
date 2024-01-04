import gocad.common.AddProjectPopup
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.SignInPage
import gocad.common.SelectMaterialPopup
import gocad.seller.MyProjectsPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility


println '>> User Seller signs in page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller add project'
Page.nav(LeftNavBar).clickMyProjects()
Page.nav(MyProjectsPage).clickNewProject()

println '>>  Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>>  Click edit project name and input project name'
Page.nav(DataUploadPage).clickEditProjectName(projectName)
println "projectName: $projectName"
String projectId = Page.nav(DataUploadPage).getIdProject()

println '>>  Upload file part on Data upload page'
Page.nav(DataUploadPage).uploadFileTesting('Sheet Metal Part', partName)

println '>> Select material'
Page.nav(ManufacturingInformationPage).clickPleaseSelectMaterial()
Page.nav(SelectMaterialPopup).clickMaterialGroup(materialGroup).inputSearchMaterial(materialName)
String material = Page.nav(SelectMaterialPopup).getMaterialAndNumber(materialName)
println "material = $material"
Page.nav(SelectMaterialPopup).selectMaterialName(materialName)

println '>> Input required field'
Page.nav(ManufacturingInformationPage).uploadFilePDFTesting('Sheet Metal Part', filePDF)
										.clickProvideOwnMaterialCB(provideOwnProduct)
										.selectThickness(partName, thicknessNum)
										.inputQuantity(quantityNum)
										.selectSurfaceTreatment(surfaceTreatment)
										.selectLaserMarking(laserMarking)
										.selectDeburring(deburring)
										.inputCountersink(countersinkNum)
										.inputThread(threadNum)
										.inputComment(comment)

println '>> click Calculate button'
Page.nav(ManufacturingInformationPage).clickCalculate()

println '>> get Net Price Value'
String netPrice = Page.nav(ManufacturingInformationPage).getNetPriceValue()

println '>> click Delete button'
Page.nav(ManufacturingInformationPage).clickMoreOption()
									  .clickDeletePart()
									  .clickOK()
									  .sleep(2)
									  
println '>> After delete will go page Data upload page'
Page.nav(DataUploadPage).verifyUIDataUploadPageOfSeller(projectName)

println '>>  Clear data'
Page.nav(LeftNavBar).clickMyProjects()
Page.nav(MyProjectsPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()
	