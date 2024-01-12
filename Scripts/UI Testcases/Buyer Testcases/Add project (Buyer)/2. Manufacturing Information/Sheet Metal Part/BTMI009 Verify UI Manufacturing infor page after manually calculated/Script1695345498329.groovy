import gocad.buyer.DraftPage
import gocad.common.AddProjectPopup
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.SignInPage
import gocad.common.SelectMaterialPopup
import katalon.fw.lib.Page
import katalon.utility.CommonUtility
import katalon.utility.FileHelper

println '>>  User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

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
Page.nav(ManufacturingInformationPage).uploadFilePDFTesting('Sheet Metal Part', filePDF)
							.inputFieldSMPShop(provideOwnProduct, partName, thicknessNum, quantityNum, surfaceTreatment, laserMarking, deburring, countersinkNum, threadNum, comment)

println '>> click Calculate button'
Page.nav(ManufacturingInformationPage).clickCalculate()

println '>> Verify UI after calculated manually of request'
Page.nav(ManufacturingInformationPage).verifyCanPreviewPartFileOnSMP()
										.clickClosePreviewPartFilePopup()
										.verifyContentAlertManualCalculateVisibleForBuyer(codeManual)
										.verifyMaterialValue(material)
										.verifyLinkPartVisible(partName)
										.verifyQuantityValue(quantityNum)
										.verifyThreadValueOnSMP(threadNum)
										.verifyLaserMarkingValue(laserMarking)
										.verifyCountersinkValue(countersinkNum)
										.verifyThicknessValue(partName, thicknessNum)
										.verifySurfaceTreatmentValue(surfaceTreatment)
										.verifyCuttingLayersValue(partName, cuttingLayers)
										.verifyDeburringValue(deburring)
										.verifyAdditionalCommentsValue(comment)
										.verifyEditButtonVisible()
										.clickMoreOption()
										.verifyDeleteButtonVisible()
										.verifyCopyButtonVisible()
										.verifyMoveButtonVisible()

if (filePDF != ""){
	Page.nav(ManufacturingInformationPage).verifyPDFFileVisibleAfterCalculated(filePDF)
}

println '>>  Clear data'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()