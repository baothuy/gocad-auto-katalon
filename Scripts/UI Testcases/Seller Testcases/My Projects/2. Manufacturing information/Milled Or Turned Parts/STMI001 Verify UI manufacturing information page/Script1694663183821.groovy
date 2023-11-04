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
Page.nav(AddProjectPopup).inputProjectName("$projectName").clickOKButton()

String projectId = Page.nav(DataUploadPage).getIdProject()
println "projectId: $projectId"

println '>>  Upload file part on Data upload page'
Page.nav(DataUploadPage).uploadFileTesting('Milled / Turned Parts', partName)

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
										.verifyCanPreviewPartFile()
										.clickClosePreviewPartFilePopup()
										.verifyLinkPartVisible(partName)
										.verifyNameWorkflowVisible('Milled / Turned Parts')
										.verifySelectMaterialVisible()
										.verifyProvideOwnMaterialCBVisible()
										.verifyQuantityInputVisible()
										.verifySurfaceTreatmentSelectVisible()
										.verifyTooltipTolerancesVisible()
										.verifyThreadInputVisible()
										.verifyTolerancesFitsInputVisible()
										.verifyTolerancesToggleVisible()
										.verifySurfaceQualitySelectVisible()
										.verifyCommentInputVisible()
										.verifyDeliveryDateInputVisible()
										.verifyContinueToOfferOverviewButtonVisible()
										
println '>>  Clear data'
Page.nav(LeftNavBar).clickMyProjects()
Page.nav(MyProjectsPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()
										