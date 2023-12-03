import gocad.seller.MyProjectsPage
import gocad.common.AddProjectPopup
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.SignInPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility

println '>> User Seller signs in page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller add project'
Page.nav(LeftNavBar).clickMyProjects()
Page.nav(MyProjectsPage).clickAddProject()

println '>> Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>> Open add project popup and input project name'
Page.nav(DataUploadPage).clickEditProjectName(projectName)

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
										.verifyLaserMarkingSelectVisible()
										.verifyDeburringVisible()
										.verifyLaserMarkingSelectVisible()
										.verifyCommentInputVisible()
										.verifyReviewButtonVisible()
										
println '>>  Clear data'
Page.nav(LeftNavBar).clickMyProjects()
Page.nav(MyProjectsPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()
										