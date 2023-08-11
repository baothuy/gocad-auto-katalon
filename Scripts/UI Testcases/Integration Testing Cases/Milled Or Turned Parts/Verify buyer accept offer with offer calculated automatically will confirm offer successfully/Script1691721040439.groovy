import gocad.buyer.AddProjectPopup
import gocad.buyer.CheckoutPage
import gocad.buyer.ConfirmedOffersPageOfBuyer
import gocad.buyer.DataUploadPage
import gocad.buyer.ManufacturingInformationPage
import gocad.buyer.ReceivedOffersPage
import gocad.buyer.ReviewPage
import gocad.buyer.SelectMaterialPopup
import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.seller.ConfirmedOffersPageOfSeller
import gocad.seller.OpenInquiriesPage
import gocad.seller.SentOffersPage
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

'8. Click get infor and Checkout button on Review Page'
List<String> tablePart = Page.nav(ReviewPage).getTablePartReview(fileName)
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
List<String> listBillingAddress = Page.nav(CheckoutPage).getBillingAddress()
List<String> listShippingAddress = Page.nav(CheckoutPage).getShippingAddress()
String orderDate = Page.nav(DateTimeUtility).getCurrentDateTime()

'10. Click Checkout button on Checkout Page'
Page.nav(CheckoutPage).clickCheckboxAgreeTermsAndConditions()
					  .clickPlaceYourOrder()
					  
'18. Seller click Logout button'
Page.nav(LeftNavBar).clickLogout()
					  
'Seller Login system to check offers of buyer'
Page.nav(MySignInPage).enterCredentialAsSeller().clickSignIn().verifySuccessfullySignInAsSeller()
  
'Seller go detail offers of buyer checkout'
Page.nav(OpenInquiriesPage).clickAction(projectId)
  
'Input change unit price'
Page.nav(DetailOffer).inputUnitPrice(unitPriceChanged).clickAcceptChangeUnitPrice()

'get Information on Detail page after change unit price'
List<String> listOrderSummaryChanged = Page.nav(DetailOffer).getOrderSummary()
List<String> listBillingAddressChanged = Page.nav(DetailOffer).getBillingAddress()
List<String> listShippingAddressChanged = Page.nav(DetailOffer).getShippingAddress()
List<String> tablePartChanged = Page.nav(DetailOffer).getTablePartReview(fileName)
String netTotalChanged = listOrderSummaryChanged[5]
String grossTotalChanged = listOrderSummaryChanged[7]
 
'Seller click accept and send offers to buyer'
Page.nav(DetailOffer).clickSendAdaptedOffer().clickOKConfirmPopup()
 
'Seller go sent offers'
Page.nav(LeftNavBar).clickSentOffers()
 
'Verify after send adapted offers to buyer on seller page'
Page.nav(SentOffersPage).verifyProjectName(projectId, projectName)
						 .verifyCompanyName(projectId, companyName)
						 .verifyOrderNumber(projectId)
						 .verifyOrderDate(projectId, orderDate)
						 .verifyNetTotal(projectId, netTotalChanged)
						 .verifyStatus(projectId, "Offer adapted")
						 .clickAction(projectId)
 
'Verify value on detail page'
Page.nav(DetailOffer).verifyBillingAddress(listBillingAddressChanged)
					 .verifyShippingAddress(listShippingAddressChanged)
					 .verifyOrderSummary(listOrderSummaryChanged)
					 .verifyTablePartReview(fileName, tablePartChanged)
 
 '18. Seller click Logout button'
 Page.nav(LeftNavBar).clickLogout()
  
 '1. User buyer signs in to administration page'
 Page.nav(MySignInPage).enterCredentialAsBuyer().clickSignIn().verifySuccessfullySignInAsBuyer()
  
 'Go to Received Offers list page, verify infor and go detail of offers'
 Page.nav(LeftNavBar).clickReceivedOffers()
 Page.nav(ReceivedOffersPage).verifyHighlightOnList(projectId)
							 .verifyProjectName(projectId, projectName)
							 .verifyDeliveryDate(projectId, deliveryDate)
							 .verifyOrderNumber(projectId)
							 .verifyGrossTotal(projectId, grossTotalChanged)
							 .verifyStatus(projectId, "Offer adapted")
							 .clickAction(projectId)
   
 Page.nav(DetailOffer).verifyBillingAddress(listBillingAddressChanged)
					  .verifyShippingAddress(listShippingAddressChanged)
					  .verifyOrderSummary(listOrderSummaryChanged)
					  .verifyTablePartReview(fileName, tablePartChanged)
					  .clickAcceptOffer()
					  .clickOKConfirmPopup()
  
 'Verify information show on list Confirmed Offers of buyer'
 Page.nav(LeftNavBar).clickConfirmedOffers()
 Page.nav(ConfirmedOffersPageOfBuyer).verifyProjectName(projectId, projectName)
									 .verifyDeliveryDate(projectId, deliveryDate)
									 .verifyOrderNumber(projectId)
									 .verifyGrossTotal(projectId, grossTotalChanged)
									 .verifyStatus(projectId, "Order confirmed")
									 .clickAction(projectId)
 
'Verify information show on detail Confirmed Offers of buyer page'
Page.nav(DetailOffer).verifyBillingAddress(listBillingAddressChanged)
					 .verifyShippingAddress(listShippingAddressChanged)
					 .verifyOrderSummary(listOrderSummaryChanged)
					 .verifyTablePartReview(fileName, tablePartChanged)
 
'Seller click Logout button'
Page.nav(LeftNavBar).clickLogout()
  
'Seller Login system to check offers of buyer'
Page.nav(MySignInPage).enterCredentialAsSeller().clickSignIn().verifySuccessfullySignInAsSeller()
					  
'Verify information show on list'
Page.nav(LeftNavBar).clickConfirmedOffers()
Page.nav(ConfirmedOffersPageOfSeller).verifyHighlightOnList(projectId)
									  .verifyProjectName(projectId, projectName)
									  .verifyCompanyName(projectId, companyName)
									  .verifyOrderNumber(projectId)
									  .verifyOrderDate(projectId, orderDate)
									  .verifyNetTotal(projectId, netTotalChanged)
									  .verifyStatus(projectId, "Order confirmed")
 
'Go confirmed offers deltail of buyer checkout'
Page.nav(ConfirmedOffersPageOfSeller).clickAction(projectId)
 
'Verify information show on detail Confirmed Offers of buyer page'
Page.nav(DetailOffer).verifyBillingAddress(listBillingAddressChanged)
					 .verifyShippingAddress(listShippingAddressChanged)
					 .verifyOrderSummary(listOrderSummaryChanged)
					 .verifyTablePartReview(fileName, tablePartChanged)