import gocad.buyer.CheckoutPage
import gocad.buyer.CustomDXFLeftNavMenu
import gocad.buyer.CustomDXFPage
import gocad.buyer.PublicSitePage
import gocad.buyer.ReviewPage
import gocad.common.ManufacturingInformationPage
import gocad.common.SelectMaterialPopup
import gocad.common.SignInPage
import katalon.fw.lib.Page
import katalon.utility.DateTimeUtility
import katalon.utility.DateTimeUtility as GlobalVariable

Page.nav(SignInPage).openPublicSiteBrowser().sleep(5)
Page.nav(PublicSitePage).changeLanguage()
Page.nav(PublicSitePage).switchToFrame()

println '>> click Circle Panel Shape'
Page.nav(CustomDXFLeftNavMenu).clickCirclePanelShape().sleep(1)

println '>> input field'
Page.nav(CustomDXFPage).inputFileName(fileName)
					   .inputDiameter(diameter)
					   .inputNumberOfHoles(numberOfHoles)
					   .clickNextStepButton()
					   .sleep(1)

println '>> Select material'
Page.nav(ManufacturingInformationPage).clickPleaseSelectMaterial()
Page.nav(SelectMaterialPopup).clickMaterialGroup(materialGroup).inputSearchMaterial(materialName)
String material = Page.nav(SelectMaterialPopup).getMaterialAndNumber(materialName)
println "material = $material"
Page.nav(SelectMaterialPopup).selectMaterialName(materialName)

println '>> Input required field'
Page.nav(ManufacturingInformationPage).uploadFilePDFTesting('Sheet Metal Part', filePDF)
							.inputFieldSMPShopPublic(partName, thicknessNum, quantityNum, comment)

println '>> click Calculate and move to Review page'
Page.nav(ManufacturingInformationPage).clickCalculate()
									  .clickReview()
									  
println '>> Verify UI after calculated manually of request'
Page.nav(ManufacturingInformationPage).verifyCanPreviewPartFileOnSMP()
										  .clickClosePreviewPartFilePopup()
										  .verifyMaterialValue(material)
										  .verifyLinkPartVisible(partName)
										  .verifyQuantityValue(quantityNum)
										  .verifyThicknessValue(partName, thicknessNum)
										  //.verifySurfaceTreatmentValue(surfaceTreatment)
										  .verifyAdditionalCommentsValue(comment)
										  .verifyBulkPricingVisible()
										  .verifyEditButtonVisible()
										  .clickMoreOption()
										  .verifyDeleteButtonVisible()
										  .verifyCopyButtonVisible()
										  .verifyMoveButtonVisible()
										  .verifyUnitPriceValue(unitPrice)
																			  
println '>> click Move to Review page'
Page.nav(ManufacturingInformationPage).clickReview()

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
String orderDate = Page.nav(DateTimeUtility).getCurrentDateTime()

println '>> Click Checkout button on Checkout Page'
Page.nav(CheckoutPage).clickCheckboxAgreeTermsAndConditions()
					  .clickPlaceYourOrder()
					  
Page.nav(PublicSitePage).switchToDefaultContent()