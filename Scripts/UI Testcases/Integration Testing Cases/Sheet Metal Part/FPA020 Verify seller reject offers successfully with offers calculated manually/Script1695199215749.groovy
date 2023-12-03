import gocad.buyer.AccountSettingsPage
import gocad.buyer.CancelledOffersPageOfBuyer
import gocad.buyer.RequestOfferPopup
import gocad.buyer.RequestedOffersPage
import gocad.buyer.ReviewPage
import gocad.common.AddProjectPopup
import gocad.common.DataUploadPage
import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.SignInPage
import gocad.common.SelectMaterialPopup
import gocad.seller.CancelledOffersPageOfSeller
import gocad.seller.OpenInquiriesPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility
import katalon.utility.DateTimeUtility

println '>> FPA003 Verify seller reject offers successfully when project larger than Threshold'
println '>> Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> Get company Name on Settings page'
Page.nav(LeftNavBar).clickSettings()
String companyName = Page.nav(AccountSettingsPage).getCompanyName()

println '>> User buyer add project'
Page.nav(LeftNavBar).clickAddProject()

println '>> Open add project popup and add new project name'
Page.nav(DataUploadPage).clickEditProjectName(projectName)
String projectId = Page.nav(DataUploadPage).getIdProject()
println "projectId: $projectId"

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
										.clickProvideOwnMaterialCB(provideOwnProduct)
										.selectThickness(partName, thicknessNum)
										.inputQuantity(quantityNum)
										.selectSurfaceTreatment(surfaceTreatment)
										.selectLaserMarking(laserMarking)
										.selectDeburring(deburring)
										.inputCountersink(countersinkNum)
										.inputThread(threadNum)
										.inputComment(comment)

println '>> click Calculate and move to Review page'
Page.nav(ManufacturingInformationPage).clickCalculate()
									  .clickReview()

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
String deliveryDate = listShippingInfo[3]
//List<String> listOrderSummary = Page.nav(DetailOffer).getOrderSummary()
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
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

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

println '>> Seller click accept and send offers to buyer'
Page.nav(DetailOffer).clickRejectOffer().clickOKConfirmPopup()

println '>> get Information on Detail page after change unit price'
List<String> listBillingAddressChanged = Page.nav(DetailOffer).getBillingAddress()
List<String> listShippingAddressChanged = Page.nav(DetailOffer).getShippingAddress()
List<String> tablePartChanged = Page.nav(DetailOffer).getTablePartReview(partName)
List<String> listOrderSummary = Page.nav(DetailOffer).getOrderSummary()
String netTotal = listOrderSummary[5]
String grossTotal = listOrderSummary[7]

println '>> Seller go Cancelled Offers of buyer checkout'
Page.nav(LeftNavBar).clickCancelledOffers()

println '>> Verify information show on list'
Page.nav(CancelledOffersPageOfSeller).verifyProjectName(projectId, projectName)
									 .verifyCompanyName(projectId, companyName)
									 .verifyOrderNumber(projectId)
									 .verifyOrderDate(projectId, orderDate)
									 .verifyNetTotal(projectId, netTotal)
									 .verifyStatus(projectId, "Offer rejected")
									 .clickAction(projectId)

println '>> Verify detail of offer'
Page.nav(DetailOffer).verifyOrderStatus("Offer rejected")
					 .verifyBillingAddress(listBillingAddressChanged)
					 .verifyShippingAddress(listShippingAddressChanged)
					 .verifyOrderSummary(listOrderSummary)
					 .verifyTablePartReview(partName, tablePartChanged)
					 .verifyShippingInfo(listShippingInfo)
					 
println '>> Seller click Logout button'
Page.nav(LeftNavBar).clickLogout()

println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> Verify information show on list Offer rejected of buyer'
Page.nav(LeftNavBar).clickCancelledOffers()
Page.nav(CancelledOffersPageOfBuyer).verifyHighlightOnList(projectId)
									.verifyProjectName(projectId, projectName)
									.verifyDeliveryDate(projectId, deliveryDate)
									.verifyOrderNumber(projectId)
									.verifyGrossTotal(projectId, grossTotal)
									.verifyStatus(projectId, "Offer rejected")
									.clickAction(projectId)

println '>> Verify information show on detail Offer rejected of buyer page'
Page.nav(DetailOffer).verifyOrderStatus("Offer rejected")
					 .verifyBillingAddress(listBillingAddressChanged)
					 .verifyShippingAddress(listShippingAddressChanged)
					 .verifyOrderSummary(listOrderSummary)
					 .verifyTablePartReview(partName, tablePartChanged)
					 .verifyShippingInfo(listShippingInfo)
