import gocad.common.AddProjectPopup
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.MovePartPopup
import gocad.common.MySignInPage
import gocad.common.SelectMaterialPopup
import gocad.seller.MyProjectsPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility

println '>> User Seller signs in page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>>  User buyer add project'
Page.nav(LeftNavBar).clickMyProjects()
Page.nav(MyProjectsPage).clickAddProject()

println '>>  Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)
def projectName2 = CommonUtility.generateRandomProjectName(10)

println '>>  Open add project popup and input project name'
Page.nav(AddProjectPopup).inputProjectName("$projectName").clickOKButton()
println "projectName: $projectName"
String projectId = Page.nav(DataUploadPage).getIdProject()

println '>>  User buyer add another project'
Page.nav(LeftNavBar).clickMyProjects()
Page.nav(LeftNavBar).clickAddProject()
Page.nav(AddProjectPopup).inputProjectName("$projectName2").clickOKButton()
println "projectName2: $projectName2"
String projectId2 = Page.nav(DataUploadPage).getIdProject()

println '>>  Upload file part on Data upload page'
Page.nav(DataUploadPage).uploadFileTesting('Milled / Turned Parts', partName)

String material
if (filePDF == "")
{
	println '>> Select material'
	Page.nav(ManufacturingInformationPage).clickPleaseSelectMaterial()
	Page.nav(SelectMaterialPopup).clickMaterialGroup(materialGroup).inputSearchMaterial(materialName)
	material = Page.nav(SelectMaterialPopup).getMaterialAndNumber(materialName)
	println "material = $material"
	Page.nav(SelectMaterialPopup).selectMaterialName(materialName)
	
	println '>> Input required field'
	Page.nav(ManufacturingInformationPage).inputQuantity(quantityNum)
											.inputThread(threadNum)
											.inputTolerances(tolerancesNum)
											.clickToggleTolerances(tolerancesToggle)
											.selectSurfaceTreatment(surfaceTreatment)
											.selectSurfaceQuality(quality)
											.inputComment(comment)
}
else
{
	Page.nav(ManufacturingInformationPage).uploadFilePDFTesting('Milled / Turned Parts', filePDF)
	 String getMaterialName = Page.nav(ManufacturingInformationPage).getMaterialWhenUploadFilePDF()
	 String getMaterialGroup = Page.nav(ManufacturingInformationPage).getMaterialGroupWhenUploadFilePDF()
	 
	 if (getMaterialName == null) {
		Page.nav(ManufacturingInformationPage).clickPleaseSelectMaterial()
		Page.nav(SelectMaterialPopup).clickMaterialGroup(materialGroup).inputSearchMaterial(materialName)
		material = Page.nav(SelectMaterialPopup).getMaterialAndNumber(materialName)
		println "material = $material"
		Page.nav(SelectMaterialPopup).selectMaterialName(materialName)
	 }
	 else {
		Page.nav(ManufacturingInformationPage).clickPleaseSelectMaterial()
		Page.nav(SelectMaterialPopup).clickMaterialGroup(getMaterialGroup).inputSearchMaterial(getMaterialName)
		material = Page.nav(SelectMaterialPopup).getMaterialAndNumber(getMaterialName)
		Page.nav(SelectMaterialPopup).clickCloseSearchMaterialPopup()
	 }
	 
	 Page.nav(ManufacturingInformationPage).inputQuantity(quantityNum)
											 .selectSurfaceTreatment(surfaceTreatment)
											 .selectSurfaceQuality(quality)
											 .inputComment(comment)
}

println '>> click Calculate button'
Page.nav(ManufacturingInformationPage).clickCalculate()

println '>> get Net Price Value'
String netPrice = Page.nav(ManufacturingInformationPage).getNetPriceValue()

println '>> click Move button'
Page.nav(ManufacturingInformationPage).clickMoreOption()
									  .clickMovePart()
										
println '>> select project to move'
Page.nav(MovePartPopup).inputProjectToMove(projectName)
						.clickOK()

println '>>  Verify part information after copied to another project'
Page.nav(LeftNavBar).clickMyProjects()
Page.nav(MyProjectsPage).clickDownCirclePartColumn(projectId)
					.verifyPartNameOnDetailPartColumn(partName)
					.verifyMaterialOnDetailPartColumn(material)
					.verifyPriceOnDetailPartColumn(netPrice)

println '>>  Clear data'
Page.nav(MyProjectsPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()
					.clickArchiveAction(projectId2)
					.clickCloseToastMessage()
	