import gocad.buyer.AccountSettingsPage
import gocad.buyer.CheckoutPage
import gocad.buyer.DraftPage
import gocad.buyer.ReviewPage
import gocad.common.AddProjectPopup
import gocad.common.CopyPartPopup
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.MySignInPage
import gocad.common.SelectMaterialPopup
import katalon.fw.lib.Page
import katalon.utility.CommonUtility

println '>> User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> Get company Name on Settings page'
Page.nav(LeftNavBar).clickSettings()
String companyName = Page.nav(AccountSettingsPage).getCompanyName()

println '>> User buyer add project'
Page.nav(LeftNavBar).clickAddProject()

println '>>  Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)
def projectName2 = CommonUtility.generateRandomProjectName(10)

println '>>  Open add project popup and input project name'
Page.nav(AddProjectPopup).inputProjectName("$projectName").clickOKButton()
println "projectName: $projectName"
String projectId = Page.nav(DataUploadPage).getIdProject()

println '>>  User buyer add another project'
Page.nav(LeftNavBar).clickAddProject()
Page.nav(AddProjectPopup).inputProjectName("$projectName2").clickOKButton()
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
										.inputThickness(partName, thicknessNum)
										.inputQuantity(quantityNum)
										.selectSurfaceTreatment(surfaceTreatment)
										.selectLaserMarking(laserMarking)
										.selectDeburring(deburring)
										.inputCountersink(countersinkNum)
										.inputThread(threadNum)
										.inputComment(comment)

println '>> click Calculate button'
Page.nav(ManufacturingInformationPage).clickCalculate()
									.clickContinueToOfferOverview()

println '>> click checkout button'
List<String> tablePartReview = Page.nav(ReviewPage).getTablePartReview(partName)
String unitPrice = tablePartReview[3]
String netPrice = tablePartReview[4]
Page.nav(ReviewPage).clickCheckout()

println '>> Verify information Address Information show correctly'
println '>> Click View part information'
Page.nav(CheckoutPage).clickMoreOption(partName)
					  .clickCopy()
					  
println '>> Verify data on View page show correctly'
Page.nav(CopyPartPopup).verifyMaterialValue(material)
						.verifyQuantityValue(quantityNum)						
						.verifyRollingDirectionValue(rollingDirection)
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
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickDownCirclePartColumn(projectId)
					  .verifyPartNameOnDetailPartColumn(partName)
					  .verifyMaterialOnDetailPartColumn(material)
					  .verifyPriceOnDetailPartColumn(netPrice)
						  
println '>>  Clear data'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()