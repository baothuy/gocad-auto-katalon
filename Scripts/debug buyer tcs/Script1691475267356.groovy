import gocad.buyer.DraftPage
import gocad.buyer.ReviewPage
import gocad.common.CopyPartPopup
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

println '>>  User buyer add project'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickDownCirclePartColumn('1525')
					.verifyPartNameOnDetailPartColumn('16-110_10_01_01-001_Platte.step')
					.verifyMaterialOnDetailPartColumn('EN AW-5754 / AlMg3/3.3535')
					.verifyPriceOnDetailPartColumn('190,48 €')


//Page.nav(DraftPage).clickViewAction('1525')
//
//Page.nav(ReviewPage).clickManufacturingInformationProcess()
//
//println '>> click Calculate button'
//Page.nav(ManufacturingInformationPage).clickMoreOption()
//										.clickCopyPart()
//										
//println '>> select project to copy'
//Page.nav(CopyPartPopup).inputProjectToCopy('Auto Generate Prj QHURNhCe6P')
//						.clickOK()
//						.verifyToastMessageWhenCopyProject('16-110_10_01_01-001_Platte.step', 'Auto Generate Prj QHURNhCe6P')