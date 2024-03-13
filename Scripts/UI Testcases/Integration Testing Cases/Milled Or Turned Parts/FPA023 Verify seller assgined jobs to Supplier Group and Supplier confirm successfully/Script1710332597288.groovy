import gocad.buyer.AccountSettingsPage
import gocad.buyer.CheckoutPage
import gocad.buyer.PaymentMethodPopup
import gocad.buyer.ReviewPage
import gocad.common.ConfirmPopup
import gocad.common.DataUploadPage
import gocad.common.FunctionCommon
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.SelectMaterialPopup
import gocad.common.SignInPage
import gocad.seller.AssignJobPopup
import gocad.seller.OpenJobsPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility

println '>> Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>>  User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> Get company Name on Settings page'
Page.nav(LeftNavBar).clickSettings()
String customerInfo = Page.nav(AccountSettingsPage).getCustomerInfo()
String fullName = customerInfo[0]
String email = customerInfo[1]
String companyName = customerInfo[3]

println '>>  User buyer add project'
Page.nav(LeftNavBar).clickNewProject()

println '>>  Open add project popup and add new project name'
Page.nav(DataUploadPage).clickEditProjectName(projectName)
String projectId = Page.nav(DataUploadPage).getIdProject()
println "projectId: $projectId"

println '>>  Upload file part on Data upload page'
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
	Page.nav(ManufacturingInformationPage).inputFieldMTPShop(quantityNum, compliances, threadNum, tolerancesNum, quality, comment)
	
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
	 
	 Page.nav(ManufacturingInformationPage).inputFieldMTPShop(quantityNum, "", "", "", quality, comment)
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

println '>> Get information Checkout page'
String deliveryDate = Page.nav(CheckoutPage).getDeliveryDate()
String unitPrice = Page.nav(CheckoutPage).getUnitPriceCol()
String netTotal = Page.nav(CheckoutPage).getNetTotal()

println '>> Click Checkout button on Checkout Page'
Page.nav(CheckoutPage).clickCheckboxAgreeTermsAndConditions()
					  .clickPlaceYourOrder()
	
println '>> Appear Payment Method Popup'
Page.nav(PaymentMethodPopup).inputCardNumber(cardNumber)
							.inputCardExpiry(cardExpiry)
							.inputCardCvc(cardCvc)
							.inputBillingName(billingName)
							.selectCountry(country)
							.clickPayButton()
							.sleep(2)					  
						
println '>>  Buyer click Logout button'
Page.nav(LeftNavBar).clickLogout()

println '>>  Seller Login system to check offers of buyer'
Page.nav(SignInPage).enterCredentialAsSeller().clickSignIn().verifySuccessfullySignInAsSeller()

println '>>  Seller go Open Jobs page'
Page.nav(LeftNavBar).clickOpenJobs()

println '>>  Verify info in Open Jobs page'
Page.nav(FunctionCommon).verifyFieldMTPShop(materialName, quality, threadNum, tolerancesNum, projectId)
						.verifyBuyerName(fullName, projectId)
						.verifyCompanyName(companyName, projectId)
						.verifyEmail(email, projectId)
						.verifyDeliveryDateForBuyer(deliveryDate, projectId)
						.verifyQuantityValue(quantityNum, projectId)
						.verifyUnitPriceForBuyer(unitPrice, projectId)
						.verifyNETTotalForBuyer(netTotal, projectId)
						.verifyAdditionalCommentsValue(comment, projectId)

println '>>  Select job to assign'
Page.nav(FunctionCommon).clickFirstJobsToAssign(projectId)

println '>>  click assign'
Page.nav(OpenJobsPage).clickAssign()

println '>>  select supplier to assign'
Page.nav(AssignJobPopup).selectAssignType(supplierType)
						.selectSupplier(supplierName)
						.clickAssign()

println '>>  Login as supplier'
Page.nav(SignInPage).enterCredentialAsSupplier().changeLanguage().clickSignIn().verifySuccessfullySignInAsSupplier()

println '>>  Seller go Jobs Board page'
Page.nav(LeftNavBar).clickJobsBoard()

println '>>  Seller go Jobs Board page'
Page.nav(FunctionCommon).clickAcceptJob()
Page.nav(ConfirmPopup).verifyTitleConfirmPopup("Accept")
						.verifyContentConfirmPopup("Are you sure accept this job?")
						.clickOK()
						
println '>>  Seller go Finished Jobs to verify'
Page.nav(LeftNavBar).clickFinishedJobs()

println '>>  Verify info in Running Jobs page'
Page.nav(FunctionCommon).verifyFieldMTPShop(materialName, quality, threadNum, tolerancesNum, projectId)
						.verifyBuyerName(fullName, projectId)
						.verifyCompanyName(companyName, projectId)
						.verifyEmail(email, projectId)
						.verifyDeliveryDateForBuyer(deliveryDate, projectId)
						.verifyQuantityValue(quantityNum, projectId)
						.verifyUnitPriceForBuyer(unitPrice, projectId)
						.verifyNETTotalForBuyer(netTotal, projectId)
						.verifyAdditionalCommentsValue(comment, projectId)	
						.clickMarkAsFinished(projectId)
						
Page.nav(ConfirmPopup).verifyTitleConfirmPopup("Accept")
						.verifyContentConfirmPopup("Are you sure accept this job?")
						.clickOK()

println '>>  Verify info in Running Jobs page'
Page.nav(ConfirmPopup).verifyTitleConfirmPopup("Mark as finished")
						.verifyContentConfirmPopup("Are you sure finish this job?")
						.clickOK()

println '>>  Seller go Confirmed Jobs to verify'
Page.nav(LeftNavBar).clickConfirmedJobs()

println '>>  Verify info in Confirmed Jobs page'
Page.nav(FunctionCommon).verifyFieldMTPShop(materialName, quality, threadNum, tolerancesNum, projectId)
						.verifyBuyerName(fullName, projectId)
						.verifyCompanyName(companyName, projectId)
						.verifyEmail(email, projectId)
						.verifyDeliveryDateForBuyer(deliveryDate, projectId)
						.verifyQuantityValue(quantityNum, projectId)
						.verifyUnitPriceForBuyer(unitPrice, projectId)
						.verifyNETTotalForBuyer(netTotal, projectId)
						.verifyAdditionalCommentsValue(comment, projectId)
						.clickConfirm(projectId)
						
println '>>  Login as seller'
Page.nav(SignInPage).enterCredentialAsSeller().clickSignIn().verifySuccessfullySignInAsSeller()

println '>>  Seller go Confirmed Jobs to verify'
Page.nav(LeftNavBar).clickConfirmedJobs()

println '>>  Verify info in Confirmed Jobs page'
Page.nav(FunctionCommon).verifyFieldMTPShop(materialName, quality, threadNum, tolerancesNum, projectId)
						.verifyBuyerName(fullName, projectId)
						.verifyCompanyName(companyName, projectId)
						.verifyEmail(email, projectId)
						.verifyDeliveryDateForBuyer(deliveryDate, projectId)
						.verifyQuantityValue(quantityNum, projectId)
						.verifyUnitPriceForBuyer(unitPrice, projectId)
						.verifyNETTotalForBuyer(netTotal, projectId)
						.verifyAdditionalCommentsValue(comment, projectId)
						.clickConfirm(projectId)