import gocad.buyer.AccountSettingsPage
import gocad.buyer.CheckoutPage
import gocad.buyer.DraftPage
import gocad.buyer.ReviewPage
import gocad.common.AddProjectPopup
import gocad.common.CopyPartPopup
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.SignInPage
import gocad.common.SelectMaterialPopup
import katalon.fw.lib.Page
import katalon.utility.CommonUtility

println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> Get company Name on Settings page'
Page.nav(LeftNavBar).clickSettings()
String companyName = Page.nav(AccountSettingsPage).getCompanyName()

println '>> User buyer add project'
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

println '>> Upload file part on Data upload page'
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
	Page.nav(ManufacturingInformationPage).clickProvideOwnMaterialCB(provideOwnProduct)
											.inputQuantity(quantityNum)
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
	 
	 Page.nav(ManufacturingInformationPage).clickProvideOwnMaterialCB(provideOwnProduct)
	 										.inputQuantity(quantityNum)
											.selectSurfaceTreatment(surfaceTreatment)
											.selectSurfaceQuality(quality)
											.inputComment(comment)
}

println '>> click Calculate and move to Review page'
Page.nav(ManufacturingInformationPage).clickCalculate()
									.clickReview()							

println '>> click checkout button'
List<String> tablePartReview = Page.nav(ReviewPage).getTablePartReview(partName)
String unitPrice = tablePartReview[4]
String netPrice = tablePartReview[5]
Page.nav(ReviewPage).clickCheckout()

println '>> Verify information Address Information show correctly'
println '>> Click View part information'
Page.nav(CheckoutPage).clickMoreOption(partName)
					  .clickCopy()
					  
println '>> Verify data on View page show correctly'
Page.nav(CopyPartPopup).verifyMaterialValue(material)
						  .verifyQuantityValue(quantityNum)
						  .verifyThreadValue(threadNum)
						  .verifyTolerancesNumberValue(tolerancesNum)
						  .verifyTolerancesToggleValue(tolerancesToggle)
						  .verifySurfaceTreatmentValue(surfaceTreatment)
						  .verifySurfaceQualityValue(quality)
						  .verifyAdditionalCommentsValue(comment)
						  .verifyUnitPriceValue(unitPrice)
						  .verifyNetPriceValue(netPrice)
						  
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
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()