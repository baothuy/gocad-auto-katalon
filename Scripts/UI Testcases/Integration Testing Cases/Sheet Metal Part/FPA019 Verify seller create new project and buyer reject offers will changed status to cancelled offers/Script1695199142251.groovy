import gocad.buyer.CancelledOffersPageOfBuyer
import gocad.buyer.ReceivedOffersPage
import gocad.common.AddProjectPopup
import gocad.common.DataUploadPage
import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.MySignInPage
import gocad.common.SelectMaterialPopup
import gocad.seller.AccountSettingsPage
import gocad.seller.CancelledOffersPageOfSeller
import gocad.seller.MyProjectsPage
import gocad.seller.SendOfferPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility
import katalon.utility.DateTimeUtility

println '>> FPA008 Verify seller create new project and buyer accept offers will changed status to comfirmed offers'
println '>> Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>>  User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>>  get company name of seller'
Page.nav(LeftNavBar).clickAccount()
String companyName = Page.nav(AccountSettingsPage).getCompanyName()

Page.nav(LeftNavBar).clickMyProjects()

Page.nav(MyProjectsPage).clickAddProject()

println '>>  Open add project popup and add new project name'
Page.nav(AddProjectPopup).inputProjectName("$projectName").clickOKButton()
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
										.inputThickness(partName, thicknessNum)
										.inputQuantity(quantityNum)
										.selectSurfaceTreatment(surfaceTreatment)
										.selectRollingDirection(rollingDirection)
										.clickDeburringCheckbox(deburring)
										.inputCountersink(countersinkNum)
										.inputThread(threadNum)
										.inputComment(comment)
										.inputDeliveryDate(deliveryDate)

println '>> click Calculate and move to Review page'
Page.nav(ManufacturingInformationPage).clickCalculate()
									  .clickContinueToOfferOverview()
									  
println '>> Select information on checkout page'
Page.nav(SendOfferPage).inputCustomer(customerEmail)
						.selectShippingOption(shippingOption)
						.inputPackagingAndShippingComments(packagingAndShippingComments)
									  
println '>> Get information Checkout page'
String orderNumber = "GOCAD" + projectId
String numberOfParts = '1'
String packagingAndShippingComments = Page.nav(SendOfferPage).getPackagingAndShippingComments()
String shippingOption = Page.nav(SendOfferPage).getShippingOptions()
String netTotal = Page.nav(SendOfferPage).getNetTotal()
String grossTotal = Page.nav(SendOfferPage).getGrossTotal()
List<String> listOrderSummary = Page.nav(SendOfferPage).getOrderSummary()
List<String> listBillingAddress = Page.nav(SendOfferPage).getBillingAddress()
List<String> listShippingAddress = Page.nav(SendOfferPage).getShippingAddress()
String orderDate = Page.nav(DateTimeUtility).getCurrentDateTime()

println '>> Click Checkout button on Checkout Page'
Page.nav(SendOfferPage).clickSendOffer()

println '>> Seller click Logout button'
Page.nav(LeftNavBar).clickLogout()
  
println '>> User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().clickSignIn().verifySuccessfullySignInAsBuyer()
  
println '>> Go to Received Offers list page, verify infor and go detail of offers'
Page.nav(LeftNavBar).clickReceivedOffers()
String expectedFormatDeliveryDate = DateTimeUtility.changeDateFormat(deliveryDate, "yyyy-MM-dd", "MM/dd/yyyy")
println "expectedFormatDeliveryDate: $expectedFormatDeliveryDate"
Page.nav(ReceivedOffersPage).verifyHighlightOnList(projectId)
							 .verifyProjectName(projectId, projectName)
							 .verifyDeliveryDate(projectId, expectedFormatDeliveryDate)
							 .verifyOrderNumber(projectId)
							 .verifyGrossTotal(projectId, grossTotal)
							 .verifyStatus(projectId, "Offer adapted")
							 .clickAction(projectId)
   
Page.nav(DetailOffer).verifyOrderStatus("Offer adapted")
					  .verifyBillingAddress(listBillingAddress)
					  .verifyShippingAddress(listShippingAddress)
					  .verifyOrderSummary(listOrderSummary)
					  .clickRejectOffer()
					  .clickOKConfirmPopup()
  
println '>> Verify information show on list Cancelled Offers of buyer'
Page.nav(LeftNavBar).clickCancelledOffers()
Page.nav(CancelledOffersPageOfBuyer).verifyProjectName(projectId, projectName)
									 .verifyDeliveryDate(projectId, expectedFormatDeliveryDate)
									 .verifyOrderNumber(projectId)
									 .verifyGrossTotal(projectId, grossTotal)
									 .verifyStatus(projectId, "Offer rejected")
									 .clickAction(projectId)
 
println '>> Verify information show on detail Cancelled Offers of buyer page'
Page.nav(DetailOffer).verifyOrderStatus("Offer rejected")
					 .verifyBillingAddress(listBillingAddress)
					 .verifyShippingAddress(listShippingAddress)
					 .verifyOrderSummary(listOrderSummary)
 
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
 
println '>> Go Cancelled Offers deltail of buyer checkout'
Page.nav(CancelledOffersPageOfSeller).clickAction(projectId)
 
println '>> Verify information show on detail Cancelled Offers of buyer page'
Page.nav(DetailOffer).verifyOrderStatus("Offer rejected")
					 .verifyBillingAddress(listBillingAddress)
					 .verifyShippingAddress(listShippingAddress)
					 .verifyOrderSummary(listOrderSummary)