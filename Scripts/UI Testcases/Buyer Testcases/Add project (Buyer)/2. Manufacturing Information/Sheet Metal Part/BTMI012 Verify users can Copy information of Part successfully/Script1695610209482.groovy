import gocad.buyer.DraftPage
import gocad.common.AddProjectPopup
import gocad.common.CopyPartPopup
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.SignInPage
import gocad.common.SelectMaterialPopup
import katalon.fw.lib.Page
import katalon.utility.CommonUtility

println '>>  User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>>  User buyer add project'
Page.nav(LeftNavBar).clickNewProject()

println '>>  Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)
def projectName2 = CommonUtility.generateRandomProjectName(10)

println '>>  Click edit project name and input project name'
Page.nav(DataUploadPage).clickEditProjectName(projectName)
println "projectName: $projectName"
String projectId = Page.nav(DataUploadPage).getIdProject()

println '>>  User buyer add another project'
Page.nav(LeftNavBar).clickNewProject()
Page.nav(DataUploadPage).clickEditProjectName(projectName2)
println "projectName2: $projectName2"
String projectId2 = Page.nav(DataUploadPage).getIdProject()

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

println '>> click Copy button'
Page.nav(ManufacturingInformationPage).clickMoreOption()
									  .clickCopyPart()
										
println '>> select project to copy'
Page.nav(CopyPartPopup).inputProjectToCopy(projectName)
						.clickOK()
						.verifyToastMessageWhenCopyProject(partName, projectName)

println '>>  Verify part information after copied to another project'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickDownCirclePartColumn(projectId)
					.verifyPartNameOnDetailPartColumn(partName)
					.verifyMaterialOnDetailPartColumn(material)
					.verifyPriceOnDetailPartColumn(netPrice)

println '>>  Clear data'
Page.nav(DraftPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()
					.clickArchiveAction(projectId2)
					.clickCloseToastMessage()
	