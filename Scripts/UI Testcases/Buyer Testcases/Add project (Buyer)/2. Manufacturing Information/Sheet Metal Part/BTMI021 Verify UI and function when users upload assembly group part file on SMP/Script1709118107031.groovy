import gocad.buyer.DraftPage
import gocad.common.ConfirmPopup
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.SignInPage
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

println '>> Verify UI after upload assembly file'
Page.nav(ManufacturingInformationPage).verifyUIAssemblyGroupPart(partName)

println '>> Verify function preview assembly file'
Page.nav(ManufacturingInformationPage).clickPreviewAssembly()
										.clickClosePreviewPartFilePopup()
										
println '>> Verify function download assembly file'
Page.nav(ManufacturingInformationPage).clickDownloadAssemblyFile(partName)
Page.nav(FileHelper).verifyFileDownloaded(partName)

println '>> Verify function Request Quote For Complete Assembly assembly file'
Page.nav(ManufacturingInformationPage).clickRequestQuoteForCompleteAssembly()
Page.nav(ConfirmPopup).verifyTitleConfirmPopup("Confirm")
						.verifyContentConfirmPopupAssembly("You are about to request a quotation for the entire assembly group. All the individual pieces will be combined into the file of the assembly group. This step cannot be reversed. We will provide a manual quote for this assembly group. Please upload the technical drawing that we have all necessary information. Please confirm, that you want to request a quote for the whole assembly group?")
						.clickOK()
						.sleep(3)

Page.nav(ManufacturingInformationPage).verifyNamePartVisible(partName)
										.verifyPartImageVisible()
										.verifyCanPreviewPartFileOnSMP()
										.clickClosePreviewPartFilePopup()

println '>>  Clear data'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()