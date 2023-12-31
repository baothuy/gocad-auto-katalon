import gocad.common.AddProjectPopup
import gocad.buyer.CheckoutPage
import gocad.buyer.CompletedCheckoutPage
import gocad.buyer.ConfirmedOffersPageOfBuyer
import gocad.common.DataUploadPage
import gocad.common.ManufacturingInformationPage
import gocad.buyer.ReviewPage
import gocad.common.SelectMaterialPopup
import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.seller.ConfirmedOffersPageOfSeller
import gocad.seller.OpenInquiriesPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility
import katalon.utility.DateTimeUtility
import internal.GlobalVariable

println '>> FPA002 Verify seller accept offers successfully when project larger than Threshold'
println '>> Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> User buyer add project'
Page.nav(LeftNavBar).clickNewProject()

println '>> Open add project popup and add new project name'
Page.nav(DataUploadPage).clickEditProjectName(projectName)
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
						
println '>> Buyer click Logout button'
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

println '>> Seller click accept and send offers to buyer'
Page.nav(DetailOffer).clickAcceptAndSendOffer().clickOKConfirmPopup()

println '>> Seller go confirmed offers of buyer checkout'
Page.nav(LeftNavBar).clickConfirmedOffers()

println '>> Verify information show on list'
Page.nav(ConfirmedOffersPageOfSeller).verifyProjectName(projectId, projectName)
									 .verifyCompanyName(projectId, companyName)
									 .verifyOrderNumber(projectId)
									 .verifyOrderDate(projectId, orderDate)
									 .verifyNetTotal(projectId, netTotal)
									 .verifyStatus(projectId, "Order confirmed")
									 .clickAction(projectId)

println '>> Verify detail of offer'
Page.nav(DetailOffer).verifyOrderStatus("Order confirmed")
					 .verifyBillingAddress(listBillingAddress)
					 .verifyShippingAddress(listShippingAddress)
					 .verifyOrderSummary(listOrderSummary)
					 .verifyTablePartReview(partName, tablePart)
					 .verifyShippingInfo(listShippingInfo)
					 
println '>> Seller click Logout button'
Page.nav(LeftNavBar).clickLogout()

println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> Verify information show on list Confirmed Offers of buyer'
Page.nav(LeftNavBar).clickConfirmedOffers()
Page.nav(ConfirmedOffersPageOfBuyer).verifyHighlightOnList(projectId)
									.verifyProjectName(projectId, projectName)
									.verifyDeliveryDate(projectId, deliveryDate)
									.verifyOrderNumber(projectId)
									.verifyGrossTotal(projectId, grossTotal)
									.verifyStatus(projectId, "Order confirmed")
									.clickAction(projectId)

println '>> Verify information show on detail Confirmed Offers of buyer page'
Page.nav(DetailOffer).verifyOrderStatus("Order confirmed")
					 .verifyBillingAddress(listBillingAddress)
					 .verifyShippingAddress(listShippingAddress)
					 .verifyOrderSummary(listOrderSummary)
					 .verifyTablePartReview(partName, tablePart)
					 .verifyShippingInfo(listShippingInfo)
