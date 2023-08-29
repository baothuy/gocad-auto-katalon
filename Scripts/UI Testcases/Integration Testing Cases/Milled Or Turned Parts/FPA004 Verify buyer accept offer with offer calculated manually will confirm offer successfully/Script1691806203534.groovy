import gocad.common.AddProjectPopup
import gocad.buyer.ConfirmedOffersPageOfBuyer
import gocad.common.DataUploadPage
import gocad.common.ManufacturingInformationPage
import gocad.buyer.ReceivedOffersPage
import gocad.buyer.RequestOfferPopup
import gocad.buyer.ReviewPage
import gocad.common.SelectMaterialPopup
import gocad.buyer.AccountSettingsPage
import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.seller.ConfirmedOffersPageOfSeller
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
Page.nav(DataUploadPage).uploadFileTesting('Milled / Turned Parts', fileName)

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
	Page.nav(ManufacturingInformationPage).inputQuantity(quantityNum)
											.inputThread(threadNum)
											.inputTolerances(tolerancesNum)
											.clickToggleTolerances(tolerancesToggle)
											.selectSurfaceTreatment(surfaceTreatment)
											.selectSurfaceQuality(quality)
											.inputComment(comment)
}
else
{
	Page.nav(ManufacturingInformationPage).uploadFilePDFTesting(filePDF)
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
	 
	 Page.nav(ManufacturingInformationPage).inputQuantity(quantityNum)
											 .selectSurfaceTreatment(surfaceTreatment)
											 .selectSurfaceQuality(quality)
											 .inputComment(comment)
}

println '>> click Calculate and move to Review page'
Page.nav(ManufacturingInformationPage).clickCalculate()
									  .clickContinueToOfferOverview()

println '>> Click Checkout button on Review Page'
//List<String> tablePart = Page.nav(ReviewPage).getTablePartReview(fileName)
Page.nav(ReviewPage).clickRequestOffer()

println '>> Input infor and get infor Request Offer popup'
String orderDate = Page.nav(DateTimeUtility).getCurrentDateTime()
Page.nav(RequestOfferPopup).clickOK()

println '>> Get info Detail offer after click OK on Request Offer Popup'
List<String> listShippingInfo = Page.nav(DetailOffer).getShippingInfo()
List<String> listBillingAddress = Page.nav(DetailOffer).getBillingAddress()
List<String> listShippingAddress = Page.nav(DetailOffer).getShippingAddress()
List<String> tablePart = Page.nav(DetailOffer).getTablePartReview(fileName)
String deliveryDate = listShippingInfo[3]

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
Page.nav(DetailOffer).verifyBillingAddress(listBillingAddress)
						.verifyShippingAddress(listShippingAddress)
						.verifyShippingInfo(listShippingInfo)
						

println '>> Input change unit price'
Page.nav(DetailOffer).inputUnitPrice(unitPriceChanged).clickAcceptChangeUnitPrice().clickCloseToastMessage()

println '>> get Information on Detail page after change unit price'
List<String> listOrderSummaryChanged = Page.nav(DetailOffer).getOrderSummary()
List<String> listBillingAddressChanged = Page.nav(DetailOffer).getBillingAddress()
List<String> listShippingAddressChanged = Page.nav(DetailOffer).getShippingAddress()
List<String> tablePartChanged = Page.nav(DetailOffer).getTablePartReview(fileName)
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
Page.nav(DetailOffer).verifyBillingAddress(listBillingAddressChanged)
					 .verifyShippingAddress(listShippingAddressChanged)
					 .verifyOrderSummary(listOrderSummaryChanged)
					 .verifyTablePartReview(fileName, tablePartChanged)
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
  
Page.nav(DetailOffer).verifyBillingAddress(listBillingAddressChanged)
					 .verifyShippingAddress(listShippingAddressChanged)
					 .verifyOrderSummary(listOrderSummaryChanged)
					 .verifyTablePartReview(fileName, tablePartChanged)
					 .verifyShippingInfo(listShippingInfo)
					 .clickAcceptOffer()
					 .clickOKConfirmPopup()
 
println '>> Verify information show on list Confirmed Offers of buyer'
Page.nav(LeftNavBar).clickConfirmedOffers()
Page.nav(ConfirmedOffersPageOfBuyer).verifyProjectName(projectId, projectName)
									.verifyDeliveryDate(projectId, deliveryDate)
									.verifyOrderNumber(projectId)
									.verifyGrossTotal(projectId, grossTotal)
									.verifyStatus(projectId, "Order confirmed")
									.clickAction(projectId)

println '>> Verify information show on detail Confirmed Offers of buyer page'
Page.nav(DetailOffer).verifyBillingAddress(listBillingAddressChanged)
					 .verifyShippingAddress(listShippingAddressChanged)
					 .verifyOrderSummary(listOrderSummaryChanged)
					 .verifyTablePartReview(fileName, tablePartChanged)
					 .verifyShippingInfo(listShippingInfo)

println '>> Seller click Logout button'
Page.nav(LeftNavBar).clickLogout()
 
println '>> Seller Login system to check offers of buyer'
Page.nav(MySignInPage).enterCredentialAsSeller().clickSignIn().verifySuccessfullySignInAsSeller()
					 
println '>> Verify information show on list'
Page.nav(LeftNavBar).clickConfirmedOffers()
Page.nav(ConfirmedOffersPageOfSeller).verifyHighlightOnList(projectId)
									 .verifyProjectName(projectId, projectName)
									 .verifyCompanyName(projectId, companyName)
									 .verifyOrderNumber(projectId)
									 .verifyOrderDate(projectId, orderDate)
									 .verifyNetTotal(projectId, netTotal)
									 .verifyStatus(projectId, "Order confirmed")

println '>> Go confirmed offers deltail of buyer checkout'
Page.nav(ConfirmedOffersPageOfSeller).clickAction(projectId)

println '>> Verify information show on detail Confirmed Offers of buyer page'
Page.nav(DetailOffer).verifyBillingAddress(listBillingAddressChanged)
					 .verifyShippingAddress(listShippingAddressChanged)
					 .verifyOrderSummary(listOrderSummaryChanged)
					 .verifyTablePartReview(fileName, tablePartChanged)
					 .verifyShippingInfo(listShippingInfo)


