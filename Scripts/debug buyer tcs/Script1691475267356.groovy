import gocad.buyer.DataUploadPage
import gocad.buyer.DraftPage
import gocad.buyer.ManufacturingInformationPage
import gocad.buyer.ReviewPage
import gocad.buyer.SelectMaterialPopup
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility


println '>> FPA002 Verify seller accept offers successfully when project larger than Threshold'
println '>> Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>> User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>>  User buyer add project'
Page.nav(LeftNavBar).clickDraft()

Page.nav(DraftPage).clickAction('Project z71ewwkyEL')

//println '>> Upload file part on Data upload page'
//Page.nav(DataUploadPage).uploadFileTesting('Milled / Turned Parts', fileName)
//
//if (filePDF == "")
//{
//	println '>> Select material'
//	Page.nav(ManufacturingInformationPage).clickPleaseSelectMaterial()
//	Page.nav(SelectMaterialPopup).clickMaterialGroup(materialGroup).selectMaterialName(materialName)
//	
//	println '>> Input required field'
//	Page.nav(ManufacturingInformationPage).inputQuantity(quantityNum)
//											.inputThread(threadNum)
//											.inputTolerances(tolerancesNum)
//											.clickToggleTolerances(tolerancesToggle)
//											.selectSurfaceTreatment(surfaceTreatment)
//											.selectSurfaceQuality(quality)
//											.inputComment(comment)
//}
//else
//{
//	Page.nav(ManufacturingInformationPage).inputQuantity(quantityNum)
//										  .selectSurfaceTreatment(surfaceTreatment)
//										  .selectSurfaceQuality(quality)
//										  .uploadFilePDFTesting(filePDF)
//										  .inputComment(comment)
//}
//
//println '>> click Calculate and move to Review page'
//Page.nav(ManufacturingInformationPage).clickCalculate()
//									  .clickContinueToOfferOverview()

println '>> Click get infor and Checkout button on Review Page'
List<String> tablePart = Page.nav(ReviewPage).getTablePartReview(fileName)
println "tablePart: $tablePart"
Page.nav(ReviewPage).clickCheckout()