import gocad.buyer.AccountSettingsPage
import gocad.buyer.DraftPage
import gocad.buyer.RequestOfferPopup
import gocad.buyer.RequestedOffersPage
import gocad.buyer.ReviewPage
import gocad.common.AddProjectPopup
import gocad.common.DataUploadPage
import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.SignInPage
import gocad.common.SelectMaterialPopup
import gocad.common.ViewPartPopup
import katalon.fw.lib.Page
import katalon.utility.CommonUtility


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
Page.nav(LeftNavBar).clickAddProject()

println '>> Open add project popup and add new project name'
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

println '>> click Calculate button'
Page.nav(ManufacturingInformationPage).clickCalculate()
String unitPrice = Page.nav(ManufacturingInformationPage).getUnitPriceValue()
String netPrice = Page.nav(ManufacturingInformationPage).getNetPriceValue()
Page.nav(ManufacturingInformationPage).clickContinueToOfferOverview()

println '>> Verify UI Visible'
Page.nav(ReviewPage)//.verifyImagePartClickable(partName)
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
					.verifyRequestOfferButtonVisible(partName)
				
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
					
String CO2Emission = Page.nav(ReviewPage).getCO2EmissionValue(partName)	
List<String> tablePart = [partName, material, quantityNum, unitPrice, netPrice, comment, CO2Emission]

println '>> Verify value on Request Offer Popup show correctly'
Page.nav(ReviewPage).clickRequestOffer()

Page.nav(RequestOfferPopup).verifyUIVisableOnRequestOfferPopup()
							.verifyContentAlert()
							.verifyBillingAddressValue(listBillingAddress)
							.clickCancel()

println '>>  Clear data'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()
