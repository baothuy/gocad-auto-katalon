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
Page.nav(DraftPage).clickViewAction('740')
//Page.nav(ReviewPage).clickManufacturingInformationProcess()
//Page.nav(ManufacturingInformationPage).clickEdit()

println '>> Verify UI of the page'
Page.nav(ManufacturingInformationPage).verifyProcessAddProjectHighLighted()
										.verifyAddPartButtonVisible()
										.verifyCalculateButtonVisible()
										.clickMoreOption()
										.verifyDeleteButtonVisible()
										.verifyCopyButtonVisible()
										.verifyMoveButtonVisible()
										.verifyAddTechnicalDrawingButtonVisible()
										.verifyNamePartVisible(partName)
										.verifyPartImageVisible()
										.verifyCanPreviewPartFileOnSMP()
										.clickClosePreviewPartFilePopup()
										.verifyUnfoldingPreviewVisible(partName)
										.verifyCanViewUnfoldingPreview(partName)
										.clickClosePreviewPartFilePopup()
										.verifyLinkPartVisible(partName)
										.verifyNameWorkflowVisible('Sheet Metal Part')
										.verifySelectMaterialVisible()
										.verifyProvideOwnMaterialCBVisible()
										.verifyQuantityInputVisible()
										.verifySurfaceTreatmentSelectVisible()
										.verifyCuttingLayersVisible(partName)
										.verifyThreadInputVisible()
										.verifyThicknessInputVisible(partName)
										.verifyCountersinkInputVisible()
										.verifyRollingDirectionSelectVisible()
										.verifyDeburringCheckboxVisible()
										.verifyCommentInputVisible()
										.verifyContinueToOfferOverviewButtonVisible()

