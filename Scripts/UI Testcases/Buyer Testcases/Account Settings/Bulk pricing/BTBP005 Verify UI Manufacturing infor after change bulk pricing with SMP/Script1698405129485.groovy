import gocad.common.BulkPricingPage
import gocad.buyer.DraftPage
import gocad.buyer.SettingsLeftNavMenu
import gocad.common.AddProjectPopup
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.SignInPage
import gocad.common.SelectMaterialPopup
import katalon.fw.lib.Page
import katalon.utility.CommonUtility


println '>>  User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> Click Settings nav menu'
Page.nav(LeftNavBar).clickSettings()

println '>> Click Bulk Pricing Settings nav menu'
Page.nav(SettingsLeftNavMenu).clickBulkPricing()

println '>> input Bulk Pricing Settings'
Page.nav(BulkPricingPage).inputQuantityRefOne(quantityRefOne)
						 .inputQuantityRefTwo(quantityRefTwo)
						 .inputQuantityRefThree(quantityRefThree)
						 .clickSaveChanges()

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

println '>> Select material'
Page.nav(ManufacturingInformationPage).clickPleaseSelectMaterial()
Page.nav(SelectMaterialPopup).clickMaterialGroup(materialGroup).inputSearchMaterial(materialName)
String material = Page.nav(SelectMaterialPopup).getMaterialAndNumber(materialName)
println "material = $material"
Page.nav(SelectMaterialPopup).selectMaterialName(materialName)

println '>> Input required field'
Page.nav(ManufacturingInformationPage).inputFieldMTPShop(provideOwnProduct, quantityNum, threadNum, tolerancesNum, tolerancesToggle, surfaceTreatment, quality, comment)

println '>> click Calculate button'
Page.nav(ManufacturingInformationPage).clickCalculate()


println '>> Verify Bulk Pricing changed the same when updated'
Page.nav(ManufacturingInformationPage).verifyBulkPricingValue("1", quantityRefOne)
									  .verifyBulkPricingValue("2", quantityRefTwo)
									  .verifyBulkPricingValue("3", quantityRefThree)

println '>>  Clear data'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()
					
println '>> Click Settings nav menu'
Page.nav(LeftNavBar).clickSettings()

println '>> Click Bulk Pricing Settings nav menu'
Page.nav(SettingsLeftNavMenu).clickBulkPricing()

println '>> input Bulk Pricing Settings'
Page.nav(BulkPricingPage).inputQuantityRefOne("5")
						 .inputQuantityRefTwo("20")
						 .inputQuantityRefThree("100")
						 .clickSaveChanges()
						 .sleep(1)
	