import gocad.common.AddProjectPopup
import gocad.common.CopyPartPopup
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.SignInPage
import gocad.common.SelectMaterialPopup
import gocad.seller.MyProjectsPage
import gocad.seller.SendOfferPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility
import katalon.utility.DateTimeUtility


println '>> User Seller signs in page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller add project'
Page.nav(LeftNavBar).clickMyProjects()
Page.nav(MyProjectsPage).clickAddProject()

println '>>  Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)
def projectName2 = CommonUtility.generateRandomProjectName(10)

println '>>  Click edit project name and input project name'
Page.nav(DataUploadPage).clickEditProjectName(projectName)
println "projectName: $projectName"
String projectId = Page.nav(DataUploadPage).getIdProject()

println '>> User Seller add project'
Page.nav(LeftNavBar).clickMyProjects()
Page.nav(MyProjectsPage).clickAddProject()
Page.nav(DataUploadPage).clickEditProjectName(projectName2)
println "projectName2: $projectName2"
String projectId2 = Page.nav(DataUploadPage).getIdProject()
println "projectId: $projectId"

String deliveryDate = DateTimeUtility.next30Days("yyyy-MM-dd")

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
										.inputDeliveryDate(deliveryDate)

println '>> click Calculate button'
Page.nav(ManufacturingInformationPage).clickCalculate()
									.inputUnitPrice(unitPrice)
									.clickAcceptChangeUnitPricing()
									.clickContinueToOfferOverview()

println '>> click checkout button'
List<String> tablePartReview = Page.nav(SendOfferPage).getTablePartReview(partName)
String unitPrice = tablePartReview[3]
String netPrice = tablePartReview[4]

println '>> Verify information Address Information show correctly'
println '>> Click View part information'
Page.nav(SendOfferPage).clickMoreOption(partName)
					  .clickCopy()
					  
println '>> Verify data on View page show correctly'
Page.nav(CopyPartPopup).verifyMaterialValue(material)
						.verifyQuantityValue(quantityNum)						
						.verifyLaserMarkingValue(laserMarking)
						.verifyCountersinkValue(countersinkNum)
						.verifyThicknessValue(partName, thicknessNum)
						.verifySurfaceTreatmentValue(surfaceTreatment)
						.verifyCuttingLayersValue(cuttingLayers)
						.verifyDeburringValue(deburring)
						.verifyThreadCuttingValue(threadNum)
						.verifyAdditionalCommentsValue(comment)
						.verifyUnitPriceValue(unitPrice)
						.verifyNetPriceValue(netPrice)
						  
println '>> select project to copy'
Page.nav(CopyPartPopup).inputProjectToCopy(projectName)
						.clickOK()
						.verifyToastMessageWhenCopyProject(partName, projectName)
						
println '>>  Verify part information after copied to another project'
Page.nav(LeftNavBar).clickMyProjects()
Page.nav(MyProjectsPage).clickDownCirclePartColumn(projectId)
					  .verifyPartNameOnDetailPartColumn(partName)
					  .verifyMaterialOnDetailPartColumn(material)
					  .verifyPriceOnDetailPartColumn(netPrice)
						  
println '>>  Clear data'
Page.nav(MyProjectsPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()