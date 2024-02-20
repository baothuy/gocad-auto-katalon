import gocad.buyer.SettingsLeftNavMenu
import gocad.common.AddProjectPopup
import gocad.common.BulkPricingPage
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.SignInPage
import gocad.common.SelectMaterialPopup
import gocad.seller.AccountSettingsLeftNavMenu
import gocad.seller.MyProjectsPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility
import katalon.utility.DateTimeUtility

println '>> User Seller signs in page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> click Account settings'
Page.nav(LeftNavBar).clickAccount()

println '>> click Legal Information settings'
Page.nav(AccountSettingsLeftNavMenu).clickBulkPricing()

println '>> input Bulk Pricing Settings value'
Page.nav(BulkPricingPage).inputQuantityRefOne(quantityRefOne)
						 .inputQuantityRefTwo(quantityRefTwo)
						 .inputQuantityRefThree(quantityRefThree)
						 .clickSaveChanges()

println '>> User Seller add project'
Page.nav(LeftNavBar).clickMyProjects()
Page.nav(MyProjectsPage).clickNewProject()

println '>> Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>> Open add project popup and input project name'
Page.nav(DataUploadPage).clickEditProjectName(projectName)

String projectId = Page.nav(DataUploadPage).getIdProject()
println "projectId: $projectId"

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
	Page.nav(ManufacturingInformationPage).inputFieldMTPShop(quantityNum, threadNum, tolerancesNum, quality, comment)
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

String deliveryDate = DateTimeUtility.next30Days("yyyy-MM-dd")
println '>> click Calculate button'
Page.nav(ManufacturingInformationPage).inputDeliveryDate(deliveryDate)
										.clickCalculate()
										
println '>> Verify Bulk Pricing changed the same when updated'
Page.nav(ManufacturingInformationPage).verifyBulkPricingValue("1", quantityRefOne)
									  .verifyBulkPricingValue("2", quantityRefTwo)
									  .verifyBulkPricingValue("3", quantityRefThree)

println '>>  Clear data'
Page.nav(LeftNavBar).clickMyProjects()
Page.nav(MyProjectsPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()
					
println '>> Click Settings nav menu'
Page.nav(LeftNavBar).clickAccount()

println '>> click Legal Information settings'
Page.nav(AccountSettingsLeftNavMenu).clickBulkPricing()

println '>> input Bulk Pricing Settings'
Page.nav(BulkPricingPage).inputQuantityRefOne("5")
						 .inputQuantityRefTwo("20")
						 .inputQuantityRefThree("100")
						 .clickSaveChanges()
						 .sleep(1)