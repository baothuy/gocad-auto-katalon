import gocad.common.AddProjectPopup
import gocad.buyer.CancelledOffersPageOfBuyer
import gocad.buyer.CheckoutPage
import gocad.buyer.CompletedCheckoutPage
import gocad.common.DataUploadPage
import gocad.common.ManufacturingInformationPage
import gocad.buyer.ReceivedOffersPage
import gocad.buyer.RequestedOffersPage
import gocad.buyer.ReviewPage
import gocad.common.SelectMaterialPopup
import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.seller.CancelledOffersPageOfSeller
import gocad.seller.OpenInquiriesPage
import gocad.seller.SentOffersPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility
import katalon.utility.DateTimeUtility
import internal.GlobalVariable

println '>> FPA005 Verify buyer accept offer with offer calculated automatically will confirm offer successfully'
println '>> Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> User buyer add project'
Page.nav(LeftNavBar).clickNewProject()

println '>> Open add project popup and add new project name'
Page.nav(DataUploadPage).clickEditProjectName(projectName)
String projectId = Page.nav(DataUploadPage).getIdProject()

println '>> Upload file part on Data upload page'
Page.nav(DataUploadPage).uploadFileTesting('Sheet Metal Part', partName)

println '>> Select material'
Page.nav(ManufacturingInformationPage).clickPleaseSelectMaterial()
Page.nav(SelectMaterialPopup).clickMaterialGroup(materialGroup).inputSearchMaterial(materialName)
String material = Page.nav(SelectMaterialPopup).getMaterialAndNumber(materialName)
println "material = $material"
Page.nav(SelectMaterialPopup).selectMaterialName(materialName)

println '>> Input required field'
Page.nav(ManufacturingInformationPage).uploadFilePDFTesting('Sheet Metal Part', filePDF)
							.inputFieldSMPShop(provideOwnProduct, partName, thicknessNum, quantityNum, surfaceTreatment, laserMarking, deburring, countersinkNum, threadNum, comment)

println '>> click Calculate and move to Review page'
Page.nav(ManufacturingInformationPage).clickCalculate()
									  .clickReview()

println '>> Click get infor and Checkout button on Review Page'
List<String> tablePart = Page.nav(ReviewPage).getTablePartReview(partName)
println "tablePart: $tablePart"
Page.nav(ReviewPage).clickCheckout()

println '>> Select information on checkout page'
Page.nav(CheckoutPage).selectDeliveryOption(deliveryOption)
					  .selectShippingOption(shippingOption)
					  .inputPackagingAndShippingComments(packagingAndShippingComments)

println '>> Get information Checkout page'
String orderNumber = GlobalVariable.prefixOrderNumber + projectId
String numberOfParts = '1'
String deliveryOption = Page.nav(CheckoutPage).getDeliveryOption()
String deliveryDate = Page.nav(CheckoutPage).getDeliveryDate()
String packagingAndShippingComments = Page.nav(CheckoutPage).getPackagingAndShippingComments()
String shippingOption = Page.nav(CheckoutPage).getShippingOptions()
String companyName = Page.nav(CheckoutPage).getCompanyName()
String netTotal = Page.nav(CheckoutPage).getNetTotal()
String grossTotal = Page.nav(CheckoutPage).getGrossTotal()
List<String> listOrderSummary = Page.nav(CheckoutPage).getOrderSummary()
List<String> listBillingAddress = Page.nav(CheckoutPage).getBillingAddress()
List<String> listShippingAddress = Page.nav(CheckoutPage).getShippingAddress()
//List<String> listShippingInfo = [orderNumber, numberOfParts, deliveryOption, deliveryDate, packagingAndShippingComments, shippingOption]
String orderDate = Page.nav(DateTimeUtility).getCurrentDateTime()

println '>> Click Checkout button on Checkout Page'
Page.nav(CheckoutPage).clickCheckboxAgreeTermsAndConditions()
					  .clickPlaceYourOrder()
					  
println '>> Click back to project to get shipping info'
Page.nav(CompletedCheckoutPage).clickBackToProject()
List<String> listShippingInfo = Page.nav(DetailOffer).getShippingInfo()

println '>> Verify offer appear on List Requested Offers'
Page.nav(LeftNavBar).clickRequestedOffers()
Page.nav(RequestedOffersPage).verifyProjectName(projectId, projectName)
							 .verifyDeliveryDate(projectId, deliveryDate)
							 .verifyOrderNumber(projectId)
							 .verifyGrossTotal(projectId, grossTotal)
							 .verifyStatus(projectId, "Offer sent")
							 .clickAction(projectId)
							 
Page.nav(DetailOffer).verifyOrderStatus("Offer sent")
					 .verifyBillingAddress(listBillingAddress)
 					 .verifyShippingAddress(listShippingAddress)
					 .verifyOrderSummary(listOrderSummary)
					 .verifyTablePartReview(partName, tablePart)
					 .verifyShippingInfo(listShippingInfo)
					  					  
println '>> Seller click Logout button'
Page.nav(LeftNavBar).clickLogout()
					  
println '>> Seller Login system to check offers of buyer'
Page.nav(SignInPage).enterCredentialAsSeller().clickSignIn().verifySuccessfullySignInAsSeller()
  
println '>> Seller go detail offers of buyer checkout'
Page.nav(OpenInquiriesPage).verifyProjectName(projectId, projectName)
						 	.verifyCompanyName(projectId, companyName)
							.verifyOrderNumber(projectId)
							.verifyOrderDate(projectId, orderDate)
							.verifyNetTotal(projectId, netTotal)
							.verifyStatus(projectId, "New request")
							.clickAction(projectId)
  
println '>> Input change unit price'
Page.nav(DetailOffer).inputUnitPrice(unitPriceChanged).clickAcceptChangeUnitPrice().clickCloseToastMessage()
 
println '>> Seller click accept and send offers to buyer'
Page.nav(DetailOffer).clickSendAdaptedOffer().clickOKConfirmPopup().clickCloseToastMessage()

println '>> get Information on Detail page after change unit price'
List<String> listOrderSummaryChanged = Page.nav(DetailOffer).getOrderSummary()
List<String> listBillingAddressChanged = Page.nav(DetailOffer).getBillingAddress()
List<String> listShippingAddressChanged = Page.nav(DetailOffer).getShippingAddress()
List<String> tablePartChanged = Page.nav(DetailOffer).getTablePartReview(partName)
String netTotalChanged = listOrderSummaryChanged[5]
String grossTotalChanged = listOrderSummaryChanged[7]
 
println '>> Seller go sent offers'
Page.nav(LeftNavBar).clickSentOffers()
 
println '>> Verify after send adapted offers to buyer on seller page'
Page.nav(SentOffersPage).verifyProjectName(projectId, projectName)
						 .verifyCompanyName(projectId, companyName)
						 .verifyOrderNumber(projectId)
						 .verifyOrderDate(projectId, orderDate)
						 .verifyNetTotal(projectId, netTotalChanged)
						 .verifyStatus(projectId, "Offer adapted")
						 .clickAction(projectId)
 
println '>> Verify value on detail page'
Page.nav(DetailOffer).verifyOrderStatus("Offer adapted")
					 .verifyBillingAddress(listBillingAddressChanged)
					 .verifyShippingAddress(listShippingAddressChanged)
					 .verifyOrderSummary(listOrderSummaryChanged)
					 .verifyTablePartReview(partName, tablePartChanged)
					 .verifyShippingInfo(listShippingInfo)
 
println '>> Seller click Logout button'
Page.nav(LeftNavBar).clickLogout()
  
println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().clickSignIn().verifySuccessfullySignInAsBuyer()
  
println '>> Go to Received Offers list page, verify infor and go detail of offers'
Page.nav(LeftNavBar).clickReceivedOffers()
Page.nav(ReceivedOffersPage).verifyHighlightOnList(projectId)
							 .verifyProjectName(projectId, projectName)
							 .verifyDeliveryDate(projectId, deliveryDate)
							 .verifyOrderNumber(projectId)
							 .verifyGrossTotal(projectId, grossTotalChanged)
							 .verifyStatus(projectId, "Offer adapted")
							 .clickAction(projectId)
   
Page.nav(DetailOffer).verifyOrderStatus("Offer adapted")
					  .verifyBillingAddress(listBillingAddressChanged)
					  .verifyShippingAddress(listShippingAddressChanged)
					  .verifyOrderSummary(listOrderSummaryChanged)
					  .verifyTablePartReview(partName, tablePartChanged)
					  .verifyShippingInfo(listShippingInfo)
					  .clickRejectOffer()
					  .clickOKConfirmPopup()
  
println '>> Verify information show on list Rejected Offers of buyer'
Page.nav(LeftNavBar).clickCancelledOffers()
Page.nav(CancelledOffersPageOfBuyer).verifyProjectName(projectId, projectName)
									 .verifyDeliveryDate(projectId, deliveryDate)
									 .verifyOrderNumber(projectId)
									 .verifyGrossTotal(projectId, grossTotalChanged)
									 .verifyStatus(projectId, "Offer rejected")
									 .clickAction(projectId)
 
println '>> Verify information show on detail Rejected Offers of buyer page'
Page.nav(DetailOffer).verifyOrderStatus("Offer rejected")
					 .verifyBillingAddress(listBillingAddressChanged)
					 .verifyShippingAddress(listShippingAddressChanged)
					 .verifyOrderSummary(listOrderSummaryChanged)
					 .verifyTablePartReview(partName, tablePartChanged)
					 .verifyShippingInfo(listShippingInfo)
 
println '>> Seller click Logout button'
Page.nav(LeftNavBar).clickLogout()
  
println '>> Seller Login system to check offers of buyer'
Page.nav(SignInPage).enterCredentialAsSeller().clickSignIn().verifySuccessfullySignInAsSeller()
					  
println '>> Verify information show on list'
Page.nav(LeftNavBar).clickCancelledOffers()
Page.nav(CancelledOffersPageOfSeller).verifyHighlightOnList(projectId)
									  .verifyProjectName(projectId, projectName)
									  .verifyCompanyName(projectId, companyName)
									  .verifyOrderNumber(projectId)
									  .verifyOrderDate(projectId, orderDate)
									  .verifyNetTotal(projectId, netTotalChanged)
									  .verifyStatus(projectId, "Offer rejected")
 
println '>> Go Rejected Offers deltail of buyer checkout'
Page.nav(CancelledOffersPageOfSeller).clickAction(projectId)
 
println '>> Verify information show on detail Rejected Offers of buyer page'
Page.nav(DetailOffer).verifyOrderStatus("Offer rejected")
					 .verifyBillingAddress(listBillingAddressChanged)
					 .verifyShippingAddress(listShippingAddressChanged)
					 .verifyOrderSummary(listOrderSummaryChanged)
					 .verifyTablePartReview(partName, tablePartChanged)
					 .verifyShippingInfo(listShippingInfo)