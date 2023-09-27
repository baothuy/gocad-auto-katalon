import gocad.buyer.AccountSettingsPage
import gocad.buyer.CancelledOffersPageOfBuyer
import gocad.buyer.ReceivedOffersPage
import gocad.buyer.RequestOfferPopup
import gocad.buyer.RequestedOffersPage
import gocad.buyer.ReviewPage
import gocad.common.AddProjectPopup
import gocad.common.DataUploadPage
import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.MySignInPage
import gocad.common.SelectMaterialPopup
import gocad.seller.CancelledOffersPageOfSeller
import gocad.seller.OpenInquiriesPage
import gocad.seller.SentOffersPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility
import katalon.utility.DateTimeUtility

println '>> FPA004 Verify buyer accept offer with offer calculated manually will confirm offer successfully'
println '>> Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>> User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> Get company Name on Settings page'
Page.nav(LeftNavBar).clickSettings()
String companyName = Page.nav(AccountSettingsPage).getCompanyName()

println '>> User buyer add project'
Page.nav(LeftNavBar).clickAddProject()

println '>> Open add project popup and add new project name'
Page.nav(AddProjectPopup).inputProjectName("$projectName").clickOKButton()
String projectId = Page.nav(DataUploadPage).getIdProject()
println "projectId: $projectId"

println '>> Upload file part on Data upload page'
Page.nav(DataUploadPage).uploadFileTesting('Milled / Turned Parts', partName)

String material
if (filePDF == "")
{
	println '>> Select material'
	Page.nav(ManufacturingInformationPage).clickPleaseSelectMaterial()
	Page.nav(SelectMaterialPopup).clickMaterialGroup(materialGroup).inputSearchMaterial(materialName)
	material = Page.nav(SelectMaterialPopup).getMaterialAndNumber(materialName)
	println "material = $material"
	Page.nav(SelectMaterialPopup).selectMaterialName(materialName)
	
	println '>> Input required field'
	Page.nav(ManufacturingInformationPage).clickProvideOwnMaterialCB(provideOwnProduct)
											.inputQuantity(quantityNum)
											.inputThread(threadNum)
											.inputTolerances(tolerancesNum)
											.clickToggleTolerances(tolerancesToggle)
											.selectSurfaceTreatment(surfaceTreatment)
											.selectSurfaceQuality(quality)
											.inputComment(comment)
}
else
{
	Page.nav(ManufacturingInformationPage).uploadFilePDFTesting('Milled / Turned Parts', filePDF)
	 String getMaterialName = Page.nav(ManufacturingInformationPage).getMaterialWhenUploadFilePDF()
	 String getMaterialGroup = Page.nav(ManufacturingInformationPage).getMaterialGroupWhenUploadFilePDF()
	 
	 if (getMaterialName == null) {
		Page.nav(ManufacturingInformationPage).clickPleaseSelectMaterial()
		Page.nav(SelectMaterialPopup).clickMaterialGroup(materialGroup).inputSearchMaterial(materialName)
		material = Page.nav(SelectMaterialPopup).getMaterialAndNumber(materialName)
		println "material = $material"
		Page.nav(SelectMaterialPopup).selectMaterialName(materialName)
	 }
	 else {
		Page.nav(ManufacturingInformationPage).clickPleaseSelectMaterial()
		Page.nav(SelectMaterialPopup).clickMaterialGroup(getMaterialGroup).inputSearchMaterial(getMaterialName)
		material = Page.nav(SelectMaterialPopup).getMaterialAndNumber(getMaterialName)
		Page.nav(SelectMaterialPopup).clickCloseSearchMaterialPopup()
	 }
	 
	 Page.nav(ManufacturingInformationPage).clickProvideOwnMaterialCB(provideOwnProduct)
	 										 .inputQuantity(quantityNum)
											 .selectSurfaceTreatment(surfaceTreatment)
											 .selectSurfaceQuality(quality)
											 .inputComment(comment)
}

println '>> click Calculate and move to Review page'
Page.nav(ManufacturingInformationPage).clickCalculate()
									  .clickContinueToOfferOverview()

println '>> Click Checkout button on Review Page'
//List<String> tablePart = Page.nav(ReviewPage).getTablePartReview(partName)
Page.nav(ReviewPage).clickRequestOffer()

println '>> Input infor and get infor Request Offer popup'
String orderDate = Page.nav(DateTimeUtility).getCurrentDateTime()
Page.nav(RequestOfferPopup).clickOK()

println '>> Get info Detail offer after click OK on Request Offer Popup'
List<String> listShippingInfo = Page.nav(DetailOffer).getShippingInfo()
List<String> listBillingAddress = Page.nav(DetailOffer).getBillingAddress()
List<String> listShippingAddress = Page.nav(DetailOffer).getShippingAddress()
List<String> tablePart = Page.nav(DetailOffer).getTablePartReview(partName)
//List<String> listOrderSummary = Page.nav(DetailOffer).getOrderSummary()
String deliveryDate = listShippingInfo[3]
//String grossTotalDefault = listOrderSummary[7]

println '>> Verify data detail offers after buyer requested offer'
Page.nav(LeftNavBar).clickRequestedOffers()

Page.nav(RequestedOffersPage).verifyProjectName(projectId, projectName)
							.verifyDeliveryDate(projectId, deliveryDate)
							.verifyOrderNumber(projectId)
							//.verifyGrossTotal(projectId, grossTotalDefault)
							.verifyStatus(projectId, "Request for quotation")
							.clickAction(projectId)
							
Page.nav(DetailOffer).verifyOrderStatus("Request for quotation")
						.verifyBillingAddress(listBillingAddress)
						.verifyShippingAddress(listShippingAddress)
						.verifyShippingInfo(listShippingInfo)

println '>> Buyer click Logout button'
Page.nav(LeftNavBar).clickLogout()

println '>> Seller Login system to check offers of buyer'
Page.nav(MySignInPage).enterCredentialAsSeller().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> Seller go detail offers of buyer checkout'
Page.nav(OpenInquiriesPage).verifyProjectName(projectId, projectName)
							.verifyCompanyName(projectId, companyName)
							.verifyOrderNumber(projectId)
							.verifyOrderDate(projectId, orderDate)
							.verifyStatus(projectId, "Request for quotation")
							.clickAction(projectId)

println '>> Verify value on detail page'
Page.nav(DetailOffer).verifyOrderStatus("Request for quotation")
						.verifyBillingAddress(listBillingAddress)
						.verifyShippingAddress(listShippingAddress)
						.verifyShippingInfo(listShippingInfo)
						

println '>> Input change unit price'
Page.nav(DetailOffer).inputUnitPrice(unitPriceChanged).clickAcceptChangeUnitPrice().clickCloseToastMessage()

println '>> get Information on Detail page after change unit price'
List<String> listOrderSummaryChanged = Page.nav(DetailOffer).getOrderSummary()
List<String> listBillingAddressChanged = Page.nav(DetailOffer).getBillingAddress()
List<String> listShippingAddressChanged = Page.nav(DetailOffer).getShippingAddress()
List<String> tablePartChanged = Page.nav(DetailOffer).getTablePartReview(partName)
String netTotal = listOrderSummaryChanged[5]
String grossTotal = listOrderSummaryChanged[7]

println '>> Seller click accept and send offers to buyer'
Page.nav(DetailOffer).clickSendAdaptedOffer().clickOKConfirmPopup()

println '>> Seller go sent offers'
Page.nav(LeftNavBar).clickSentOffers()

println '>> Verify after send adapted offers to buyer on seller page'
Page.nav(SentOffersPage).verifyProjectName(projectId, projectName)
						.verifyCompanyName(projectId, companyName)
						.verifyOrderNumber(projectId)
						.verifyOrderDate(projectId, orderDate)
						.verifyNetTotal(projectId, netTotal)
						.verifyStatus(projectId, "Offer adapted")
						.clickAction(projectId)

println '>> Verify value on detail page Offer adapted'
Page.nav(DetailOffer).verifyOrderStatus("Offer adapted")
					 .verifyBillingAddress(listBillingAddressChanged)
					 .verifyShippingAddress(listShippingAddressChanged)
					 .verifyOrderSummary(listOrderSummaryChanged)
					 .verifyTablePartReview(partName, tablePartChanged)
					 .verifyShippingInfo(listShippingInfo)

println '>> Seller click Logout button'
Page.nav(LeftNavBar).clickLogout()
 
println '>> User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().clickSignIn().verifySuccessfullySignInAsBuyer()
 
println '>> Go to Received Offers list page, verify infor and go detail of offers'
Page.nav(LeftNavBar).clickReceivedOffers()
Page.nav(ReceivedOffersPage).verifyHighlightOnList(projectId)
							.verifyProjectName(projectId, projectName)
							.verifyDeliveryDate(projectId, deliveryDate)
							.verifyOrderNumber(projectId)
							.verifyGrossTotal(projectId, grossTotal)
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
									.verifyGrossTotal(projectId, grossTotal)
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
Page.nav(MySignInPage).enterCredentialAsSeller().clickSignIn().verifySuccessfullySignInAsSeller()
					 
println '>> Verify information show on list'
Page.nav(LeftNavBar).clickCancelledOffers()
Page.nav(CancelledOffersPageOfSeller).verifyHighlightOnList(projectId)
									 .verifyProjectName(projectId, projectName)
									 .verifyCompanyName(projectId, companyName)
									 .verifyOrderNumber(projectId)
									 .verifyOrderDate(projectId, orderDate)
									 .verifyNetTotal(projectId, netTotal)
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


