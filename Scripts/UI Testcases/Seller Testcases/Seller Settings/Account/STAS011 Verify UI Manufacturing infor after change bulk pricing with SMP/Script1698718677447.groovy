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
Page.nav(MyProjectsPage).clickAddProject()

println '>> Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>> Open add project popup and input project name'
Page.nav(AddProjectPopup).inputProjectName("$projectName").clickOKButton()

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
Page.nav(ManufacturingInformationPage).uploadFilePDFTesting('Sheet Metal Part', filePDF)
										.clickProvideOwnMaterialCB(provideOwnProduct)
										.inputThickness(partName, thicknessNum)
										.inputQuantity(quantityNum)
										.selectSurfaceTreatment(surfaceTreatment)
										.selectLaserMarking(laserMarking)
										.selectDeburring(deburring)
										.inputCountersink(countersinkNum)
										.inputThread(threadNum)										
										.inputComment(comment)
										
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