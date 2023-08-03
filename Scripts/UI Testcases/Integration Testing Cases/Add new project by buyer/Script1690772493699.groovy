import gocad.buyer.AddProjectPopup
import gocad.buyer.CheckoutPage
import gocad.buyer.DataUploadPage
import gocad.buyer.ManufacturingInformationPage
import gocad.buyer.ReviewPage
import gocad.buyer.SelectMaterialPopup
import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.seller.OpenInquiriesPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility

'All param on this flow'
'Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

'1. User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

'2. User buyer add project'
Page.nav(LeftNavBar).clickAddProject()

'3. Open add project popup and add new project name'
Page.nav(AddProjectPopup).inputProjectName("$projectName").clickOKButton()
String projectId = Page.nav(DataUploadPage).getIdProject()
println "projectId: $projectId"

'4. Upload file part on Data upload page'
Page.nav(DataUploadPage).uploadFileTesting(fileName)

'6. Select material'
Page.nav(ManufacturingInformationPage).clickPleaseSelectMaterial()
Page.nav(SelectMaterialPopup).clickMaterialGroup(materialGroup).selectMaterialName(materialName)

'7. Input required field'
Page.nav(ManufacturingInformationPage).inputQuantity(quantityNum)
										.inputThread(threadNum)
										.inputTolerances(tolerancesNum)
										.clickToggleTolerances(tolerancesToggle)
										.selectSurfaceTreatment(surfaceTreatment)
										.selectSurfaceQuality(quality)
										.inputComment(comment)
										.clickCalculate()
										.clickContinueToOfferOverview()

'8. Click Checkout button on Review Page'
Page.nav(ReviewPage).clickCheckout()

'9. Click Checkout button on Checkout Page'
Page.nav(CheckoutPage).clickCheckboxAgreeTermsAndConditions()
						.clickPlaceYourOrder()
						
'10. Buyer click Logout button'
Page.nav(LeftNavBar).clickLogout()

'11. Seller Login system to check offers of buyer'
Page.nav(MySignInPage).enterCredentialAsSeller().clickSignIn().verifySuccessfullySignInAsSeller()

'12. Seller go detail offers of buyer checkout'
Page.nav(OpenInquiriesPage).clickAction(projectId)

'13. Seller click accept and send offers to buyer'
Page.nav(DetailOffer).clickAcceptAndSendOffer().clickOKConfirmPopup()
