import gocad.buyer.AddProjectPopup
import gocad.buyer.CancelledOffersPageOfBuyer
import gocad.buyer.CheckoutPage
import gocad.buyer.DataUploadPage
import gocad.buyer.ManufacturingInformationPage
import gocad.buyer.ReviewPage
import gocad.buyer.SelectMaterialPopup
import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.seller.CancelledOffersPageOfSeller
import gocad.seller.OpenInquiriesPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility
import katalon.utility.DateTimeUtility

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
Page.nav(DataUploadPage).uploadFileTestingForMTP(fileName)

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

'Select information on checkout page'
Page.nav(CheckoutPage).selectDeliveryOption(deliveryOption)
					  .selectShippingOption(shippingOption)

'9. Get information Checkout page'
String deliveryDate = Page.nav(CheckoutPage).getDeliveryDate()
String companyName = Page.nav(CheckoutPage).getCompanyName()
String netTotal = Page.nav(CheckoutPage).getNetTotal()
String grossTotal = Page.nav(CheckoutPage).getGrossTotal()
List<String> listOrderSummary = Page.nav(CheckoutPage).getOrderSummary()
println "listOrderSummary: $listOrderSummary"
List<String> listBillingAddress = Page.nav(CheckoutPage).getBillingAddress()
List<String> listShippingAddress = Page.nav(CheckoutPage).getShippingAddress()
String orderDate = Page.nav(DateTimeUtility).getCurrentDateTime()

'10. Click Checkout button on Checkout Page'
Page.nav(CheckoutPage).clickCheckboxAgreeTermsAndConditions()
						.clickPlaceYourOrder()
						
'11. Buyer click Logout button'
Page.nav(LeftNavBar).clickLogout()

'12. Seller Login system to check offers of buyer'
Page.nav(MySignInPage).enterCredentialAsSeller().clickSignIn().verifySuccessfullySignInAsSeller()

'12. Seller go detail offers of buyer checkout'
Page.nav(OpenInquiriesPage).clickAction(projectId)

'13. Seller click accept and send offers to buyer'
Page.nav(DetailOffer).clickRejectOffer().clickOKConfirmPopup()

'14. Seller go confirmed offers of buyer checkout'
Page.nav(LeftNavBar).clickCancelledOffers()

'15. Verify information show on list'
Page.nav(CancelledOffersPageOfSeller).verifyProjectName(projectId, projectName)
									 .verifyCompanyName(projectId, companyName)
									 .verifyOrderNumber(projectId)
									 .verifyOrderDate(projectId, orderDate)
									 .verifyNetTotal(projectId, netTotal)
									 .verifyStatus(projectId, "Offer rejected")
									 .clickAction(projectId)

'16. Verify detail of offer'
Page.nav(DetailOffer).verifyBillingAddress(listBillingAddress)
					 .verifyShippingAddress(listShippingAddress)
					 .verifyOrderSummary(listOrderSummary)
					 
'17. Seller click Logout button'
Page.nav(LeftNavBar).clickLogout()

'18. User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().clickSignIn().verifySuccessfullySignInAsBuyer()

'19. Verify information show on list Confirmed Offers of buyer'
Page.nav(LeftNavBar).clickCancelledOffers()
Page.nav(CancelledOffersPageOfBuyer).verifyHighlightOnList(projectId)
									.verifyProjectName(projectId, projectName)
									.verifyDeliveryDate(projectId, deliveryDate)
									.verifyOrderNumber(projectId)
									.verifyGrossTotal(projectId, grossTotal)
									.verifyStatus(projectId, "Offer rejected")
									.clickAction(projectId)

'20. Verify information show on detail Confirmed Offers of buyer page'
Page.nav(DetailOffer).verifyBillingAddress(listBillingAddress)
					 .verifyShippingAddress(listShippingAddress)
					 .verifyOrderSummary(listOrderSummary)
