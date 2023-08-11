import gocad.buyer.AddProjectPopup
import gocad.buyer.ConfirmedOffersPageOfBuyer
import gocad.buyer.DataUploadPage
import gocad.buyer.ManufacturingInformationPage
import gocad.buyer.ReceivedOffersPage
import gocad.buyer.RequestOfferPopup
import gocad.buyer.ReviewPage
import gocad.buyer.SelectMaterialPopup
import gocad.buyer.SettingsPage
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

'Get company Name on Settings page'
Page.nav(LeftNavBar).clickSettings()
String companyName = Page.nav(SettingsPage).getCompanyName()

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
List<String> tablePart = Page.nav(ReviewPage).getTablePartReview(fileName)
Page.nav(ReviewPage).clickRequestOffer()

'Input infor and get infor Request Offer popup'
String deliveryDate = Page.nav(RequestOfferPopup).getDeliveryDate()
println "deliveryDate: $deliveryDate"
String orderDate = Page.nav(DateTimeUtility).getCurrentDateTime()
Page.nav(RequestOfferPopup).clickOK()

'11. Buyer click Logout button'
Page.nav(LeftNavBar).clickLogout()

'12. Seller Login system to check offers of buyer'
Page.nav(MySignInPage).enterCredentialAsSeller().clickSignIn().verifySuccessfullySignInAsSeller()

'12. Seller go detail offers of buyer checkout'
Page.nav(OpenInquiriesPage).clickAction(projectId)

'Input change unit price'
Page.nav(DetailOffer).inputUnitPrice(unitPriceChanged).clickAcceptChangeUnitPrice().clickCloseToastMessage()

'get Information on Detail page after change unit price'
List<String> listOrderSummary = Page.nav(DetailOffer).getOrderSummary()
List<String> listBillingAddress = Page.nav(DetailOffer).getBillingAddress()
List<String> listShippingAddress = Page.nav(DetailOffer).getShippingAddress()
List<String> tablePartChanged = Page.nav(DetailOffer).getTablePartReview(fileName)
String netTotal = listOrderSummary[5]
String grossTotal = listOrderSummary[7]

'13. Seller click accept and send offers to buyer'
Page.nav(DetailOffer).clickSendAdaptedOffer().clickOKConfirmPopup()

'14. Seller go sent offers'
Page.nav(LeftNavBar).clickSentOffers()

'Verify after send adapted offers to buyer on seller page'
Page.nav(SentOffersPage).verifyProjectName(projectId, projectName)
						.verifyCompanyName(projectId, companyName)
						.verifyOrderNumber(projectId)
						.verifyOrderDate(projectId, orderDate)
						.verifyNetTotal(projectId, netTotal)
						.verifyStatus(projectId, "Offer adapted")
						.clickAction(projectId)

'Verify value on detail page'
Page.nav(DetailOffer).verifyBillingAddress(listBillingAddress)
					 .verifyShippingAddress(listShippingAddress)
					 .verifyOrderSummary(listOrderSummary)
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
							.verifyGrossTotal(projectId, grossTotal)
							.verifyStatus(projectId, "Offer adapted")
							.clickAction(projectId)
  
Page.nav(DetailOffer).verifyBillingAddress(listBillingAddress)
					 .verifyShippingAddress(listShippingAddress)
					 .verifyOrderSummary(listOrderSummary)
					 .verifyTablePartReview(fileName, tablePartChanged)
					 .clickAcceptOffer()
					 .clickOKConfirmPopup()
 
'Verify information show on list Confirmed Offers of buyer'
Page.nav(LeftNavBar).clickConfirmedOffers()
Page.nav(ConfirmedOffersPageOfBuyer).verifyProjectName(projectId, projectName)
									.verifyDeliveryDate(projectId, deliveryDate)
									.verifyOrderNumber(projectId)
									.verifyGrossTotal(projectId, grossTotal)
									.verifyStatus(projectId, "Order confirmed")
									.clickAction(projectId)

'Verify information show on detail Confirmed Offers of buyer page'
Page.nav(DetailOffer).verifyBillingAddress(listBillingAddress)
					 .verifyShippingAddress(listShippingAddress)
					 .verifyOrderSummary(listOrderSummary)
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
									 .verifyNetTotal(projectId, netTotal)
									 .verifyStatus(projectId, "Order confirmed")

'Go confirmed offers deltail of buyer checkout'
Page.nav(ConfirmedOffersPageOfSeller).clickAction(projectId)

'Verify information show on detail Confirmed Offers of buyer page'
Page.nav(DetailOffer).verifyBillingAddress(listBillingAddress)
					 .verifyShippingAddress(listShippingAddress)
					 .verifyOrderSummary(listOrderSummary)
					 .verifyTablePartReview(fileName, tablePartChanged)


