import gocad.buyer.DraftPage
import gocad.common.AddProjectPopup
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.MySignInPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility

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
										
println '>>  Clear data'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()
										