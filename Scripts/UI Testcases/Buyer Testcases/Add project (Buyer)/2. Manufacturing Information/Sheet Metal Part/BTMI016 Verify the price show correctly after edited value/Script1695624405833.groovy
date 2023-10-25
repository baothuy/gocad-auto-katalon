import gocad.buyer.DraftPage
import gocad.common.AddProjectPopup
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.MySignInPage
import gocad.common.SelectMaterialPopup
import katalon.fw.lib.Page
import katalon.utility.CommonUtility
import katalon.utility.FileHelper

println '>>  User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>>  User buyer add project'
Page.nav(LeftNavBar).clickAddProject()

println '>>  Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>>  Open add project popup and input project name'
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

println '>> Calculate netPrice value'
String netPrice = Page.nav(ManufacturingInformationPage).calculateNetPrice(unitPrice,quantityNum)

println '>> Verify UI after calculated manually of request'
Page.nav(ManufacturingInformationPage).verifyMaterialValue(material)
										.verifyQuantityValue(quantityNum)
										.verifyThreadValueOnSMP(threadNum)
										.verifyRollingDirectionValue(rollingDirection)
										.verifyCountersinkValue(countersinkNum)
										.verifyThicknessValue(partName, thicknessNum)
										.verifySurfaceTreatmentValue(surfaceTreatment)
										.verifyCuttingLayersValue(partName, cuttingLayers)
										.verifyDeburringValue(deburring)
										.verifyAdditionalCommentsValue(comment)
										.verifyUnitPriceValue(unitPrice)
										.verifyNetPriceValue(netPrice)
										
println '>> click Edit button'
Page.nav(ManufacturingInformationPage).clickEdit()
																				
println '>> Select material'
Page.nav(ManufacturingInformationPage).clickPleaseSelectMaterial()
Page.nav(SelectMaterialPopup).clickMaterialGroup(materialGroup).inputSearchMaterial(materialNameChanged)
material = Page.nav(SelectMaterialPopup).getMaterialAndNumber(materialNameChanged)
println "material = $material"
Page.nav(SelectMaterialPopup).selectMaterialName(materialNameChanged)

println '>> Input required field'
Page.nav(ManufacturingInformationPage).uploadFilePDFTesting('Sheet Metal Part', filePDF)
										.clickProvideOwnMaterialCB(provideOwnProductChanged)
										.inputThickness(partName, thicknessNumChanged)
										.inputQuantity(quantityNumChanged)
										.RemoveSelectSurfaceTreatment(surfaceTreatment)
										.selectSurfaceTreatment(surfaceTreatmentChanged)
										.selectRollingDirection(rollingDirectionChanged)
										.selectDeburring(deburringChanged)
										.inputCountersink(countersinkNumChanged)
										.inputThread(threadNumChanged)
										.inputComment(comment)
										
println '>> click Calculate button'
Page.nav(ManufacturingInformationPage).clickCalculate()

println '>> Calculate netPrice value'
String netPriceChanged = Page.nav(ManufacturingInformationPage).calculateNetPrice(unitPriceChanged, quantityNumChanged)

println '>> Verify UI after calculated manually of request'
Page.nav(ManufacturingInformationPage).verifyMaterialValue(material)
										.verifyQuantityValue(quantityNumChanged)
										.verifyThreadValueOnSMP(threadNumChanged)
										.verifyRollingDirectionValue(rollingDirectionChanged)
										.verifyCountersinkValue(countersinkNumChanged)
										.verifyThicknessValue(partName, thicknessNumChanged)
										.verifySurfaceTreatmentValue(surfaceTreatmentChanged)
										.verifyCuttingLayersValue(partName, cuttingLayers)
										.verifyDeburringValue(deburringChanged)
										.verifyAdditionalCommentsValue(comment)
										.verifyUnitPriceValue(unitPriceChanged)
										.verifyNetPriceValue(netPriceChanged)

println '>>  Clear data'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()
	