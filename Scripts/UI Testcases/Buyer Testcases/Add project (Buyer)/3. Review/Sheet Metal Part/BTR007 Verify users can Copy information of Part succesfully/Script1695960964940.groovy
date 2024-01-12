import gocad.buyer.AccountSettingsPage
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


println '>>  User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>>  User buyer add project'
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
String unitPrice = Page.nav(ManufacturingInformationPage).getUnitPriceValue()
String netPrice = Page.nav(ManufacturingInformationPage).getNetPriceValue()
Page.nav(ManufacturingInformationPage).clickReview()

println '>> Verify UI Visible'
Page.nav(ReviewPage).clickMoreOption(partName)
					.clickCopyPart()
					
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
						.inputProjectToCopy(projectName)
						.clickOK()
						.verifyToastMessageWhenCopyProject(partName, projectName)

println '>>  Clear data'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()
					.clickArchiveAction(projectId2)
					.clickCloseToastMessage()