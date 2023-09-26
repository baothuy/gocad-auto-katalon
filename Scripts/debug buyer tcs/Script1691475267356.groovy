import gocad.buyer.CuttingLayersPopup
import gocad.buyer.DraftPage
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.common.ManufacturingInformationPage
import katalon.fw.lib.Page



println '>> FPA002 Verify seller accept offers successfully when project larger than Threshold'
println '>> Random project name'
//def projectName = CommonUtility.generateRandomProjectName(10)
//
println '>> User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickViewAction('1033')
//Page.nav(ReviewPage).clickManufacturingInformationProcess()
//Page.nav(ManufacturingInformationPage).clickEdit()

println '>>  Upload file part on Data upload page'
Page.nav(DataUploadPage).uploadFileTesting('Sheet Metal Part', partName)

Page.nav(ManufacturingInformationPage).verifyAddPartButtonVisible()