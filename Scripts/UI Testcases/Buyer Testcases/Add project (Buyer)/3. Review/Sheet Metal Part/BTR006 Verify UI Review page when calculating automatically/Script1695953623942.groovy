import gocad.buyer.AccountSettingsPage
import gocad.buyer.DraftPage
import gocad.buyer.ReviewPage
import gocad.common.AddProjectPopup
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.SignInPage
import gocad.common.SelectMaterialPopup
import gocad.common.ViewPartPopup
import katalon.fw.lib.Page
import katalon.utility.CommonUtility
import katalon.utility.FileHelper


println '>> FPA004 Verify buyer accept offer with offer calculated manually will confirm offer successfully'
println '>> Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> Get company Name on Settings page'
Page.nav(LeftNavBar).clickSettings()
String companyName = Page.nav(AccountSettingsPage).getCompanyName()
List<String> listBillingAddress = Page.nav(AccountSettingsPage).getBillingAddress()
List<String> listShippingAddress = Page.nav(AccountSettingsPage).getShippingAddress()
List<String> listCustomerInfo = Page.nav(AccountSettingsPage).getCustomerInfo()

println '>> User buyer add project'
Page.nav(LeftNavBar).clickNewProject()

println '>> Open add project popup and add new project name'
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
Page.nav(ManufacturingInformationPage).uploadFilePDFTesting('Sheet Metal Part', filePDF)
							.inputFieldSMPShop(provideOwnProduct, partName, thicknessNum, quantityNum, surfaceTreatment, laserMarking, deburring, countersinkNum, threadNum, comment)

println '>> click Calculate button'
Page.nav(ManufacturingInformationPage).clickCalculate()
String unitPrice = Page.nav(ManufacturingInformationPage).getUnitPriceValue()
String netPrice = Page.nav(ManufacturingInformationPage).getNetPriceValue()
Page.nav(ManufacturingInformationPage).clickReview()

println '>> Verify UI Visible'
Page.nav(ReviewPage).verifyImagePartClickable(partName)
					.verifyContentAlertAutomaticCalculateVisible()
					.verifyPartNameVisible(partName)
					.verifyFileVisible(partName)
					.verifyFileClickable(partName)
					.verifyMaterialVisible(partName)
					.verifyQuantityVisible(partName)
					.verifyUnitPriceVisible(partName)
					.verifyTotalPartPriceVisible(partName)
					.verifyCO2EmissionVisible(partName)					
					.verifyActionMoreVisible(partName)
					.clickMoreOption(partName)
					.verifyActionViewVisible()
					.verifyActionCopyVisible()
					.verifyActionMoveVisible()
					.verifySurfaceTreatmentSurchargeAndTotalVisible()
					.verifyCheckoutButtonVisible(partName)
					
//println '>> Verify file part can download successfully'
//Page.nav(ReviewPage).clickPartFile(partName)
//Page.nav(FileHelper).verifyFileDownloaded(partName)
				
println '>> Verify value on Review Page show correctly'
Page.nav(ReviewPage).verifyPartNameValue(partName)
					.verifyMaterialValue(partName, material)
					.verifyQuantityValue(partName, quantityNum)
					.verifyUnitPriceValue(partName, unitPrice)
					.verifyPartPriceTotalValue(partName, netPrice)
					.verifyCommentValue(partName, comment)

println '>> Verify data on View page show correctly'
Page.nav(ReviewPage).clickMoreOption(partName)
					.clickView(partName)
Page.nav(ViewPartPopup).verifyMaterialValue(material)
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
						.clickClosePopup()

println '>>  Clear data'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()