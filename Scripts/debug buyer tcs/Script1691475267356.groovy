import gocad.buyer.CuttingLayersPopup
import gocad.buyer.DraftPage
import gocad.buyer.ReviewPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.MySignInPage
import katalon.fw.lib.Page



println '>> FPA002 Verify seller accept offers successfully when project larger than Threshold'
println '>> Random project name'
//def projectName = CommonUtility.generateRandomProjectName(10)
//
println '>> User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickViewAction('975')
Page.nav(ReviewPage).clickManufacturingInformationProcess()
Page.nav(ManufacturingInformationPage).clickEdit()

println '>> Verify UI of the page'
Page.nav(ManufacturingInformationPage).clickSelectLayers()

Page.nav(CuttingLayersPopup).clickLabelAllLayers()
							//.clickCheckboxAllLayers("false")
							.clickCheckboxNameLayers("Bemaßung", "false")
							.sleep(1)
							.clickOKButton()

