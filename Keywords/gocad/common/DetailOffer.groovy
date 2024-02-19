package gocad.common

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import katalon.fw.lib.BasePage
import katalon.fw.lib.Page
import katalon.utility.DateTimeUtility
import katalon.utility.FileHelper
import katalon.utility.FunctionCommon

public class DetailOffer extends BasePage<DetailOffer>{

	def partCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[2]")}
	def fileCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[3]//a")}
	def materialCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[4]")}
	def quantityCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[5]")}
	def unitPriceInputCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[6]//input[@id='unitPrice']")}
	def unitPriceCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[6]")}
	def partPriceTotalCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[7]")}
	def CO2EmissionCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[9]")}
	def actionMore = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[10]//button")}
	def contentRequestedOffersAlertManually = "These parts cannot be automatically calculated. You can request a manual offer by the seller. All parts that could not automatically be calculated are bundled in this separate list."
	def contentReceivedOffersAlertManually = "These parts could not be automatically calculated. You have received an offer by your supplier. Please check the offer and approve or decline it."
	def contentOpenInquiriesAlertManually = "For these parts, your customer has not seen a price and he requested a manual quotation. The reason that for this part no automatic price has been shown to the customer can be e.g. that there are specific tolerances that need to be manually checked. Please check the parts and the automatically calculated price and adapt the price accordingly. You can then send out the offer to your customer by clicking on \"Send offer\"."
	def contentSentOffersAlertManually = ""
	def expectedContentTooltips = "Surchage to fulfill minimum order value and transport costs for surface treatment"
	def tooltipsSurchargeMinimumPrice = "In our shop, the minimum order value is 80 $GlobalVariable.currency (250 $GlobalVariable.currency for FAST delivery) on the overall basket size, excluding packaging and delivery cost."

	public DetailOffer clickAcceptAndSendOffer() {
		WebUI.click(xpath("//span[text()='Accept And Send Offer ']/parent::button"))
		return this
	}

	public DetailOffer clickSendAdaptedOffer() {
		WebUI.click(xpath("//span[text()='Send Adapted Offer ']/parent::button"))
		return this
	}

	public DetailOffer clickAcceptOffer() {
		WebUI.click(xpath("//span[text()='Accept Offer']/parent::button"))
		return this
	}

	public DetailOffer clickRejectOffer() {
		WebUI.click(xpath("//span[text()='Reject Offer']/parent::button"))
		return this
	}

	public DetailOffer clickResetAdapt() {
		WebUI.click(xpath("//span[text()='Reset Adapt']/parent::button"))
		return this
	}

	public DetailOffer clickCancelPopup() {
		WebUI.click(xpath("//span[text()='Cancel']/parent::button"))
		return this
	}

	public DetailOffer clickOKConfirmPopup() {
		WebUI.click(xpath("//span[text()='OK']/parent::button"))
		//WebUI.delay(GlobalVariable.smallSleepTime)
		return this
	}

	public DetailOffer clickUndo() {
		WebUI.click(xpath("//*[@id='adaptForm']//span[@aria-label='undo']"))
		return this
	}

	public DetailOffer clickCloseToastMessage() {
		WebUI.waitForElementVisible(xpath("//*[@aria-label='close']/ancestor::a"), 5)
		WebUI.click(xpath("//*[@aria-label='close']/ancestor::a"))
		return this
	}

	public DetailOffer clickAcceptChangeUnitPrice() {
		WebUI.click(xpath("//*[@aria-label='check']"))
		return this
	}

	public DetailOffer clickMoreAction() {
		WebUI.mouseOver(xpath("//*[@aria-label='more']/parent::button"))
		return this
	}

	public DetailOffer clickDeclineAction() {
		WebUI.click(xpath("//*[text()='Decline']"))
		return this
	}

	public DetailOffer clickAcceptAction() {
		WebUI.click(xpath("//*[text()='Accept']"))
		return this
	}

	public DetailOffer clickViewAction() {
		WebUI.click(xpath("//*[text()='View']"))
		return this
	}

	public DetailOffer clickCopyAction() {
		WebUI.click(xpath("//span[@aria-label='copy']/following::span[text()='Copy']"))
		return this
	}

	public DetailOffer inputUnitPrice(String unitPrice) {
		clearTextAndSendKeysByActions(xpath("//*[@class='ant-input-number-input']"), unitPrice)
		return this
	}

	public DetailOffer verifyOrderStatus(String expectedResult) {
		String status = WebUI.getText(xpath("//h4/following::span/child::span[normalize-space(text()) != '']"))
		WebUI.verifyEqual(status, expectedResult)
		return this
	}

	public DetailOffer verifyOrderNumber(String projectId) {
		String actualResult = WebUI.getText(xpath("//p[text()='Order Number']/parent::div"))
		String expectedResult = GlobalVariable.prefixOrderNumber+ projectId
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public DetailOffer verifyNumberOfParts(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//p[text()='Number of parts']/parent::div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public DetailOffer verifyDeliveryOption(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//p[text()='Delivery Option']/parent::div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public DetailOffer verifyDeliveryDate(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//p[text()='Delivery Date']/parent::div"))
		String newActualResult  = DateTimeUtility.changeDateFormat(actualResult)
		WebUI.verifyEqual(newActualResult, expectedResult)
		return this
	}

	public DetailOffer verifyBillingAddress(List<String> expectedResult) {
		List<String> actualBillingAddress = Page.nav(FunctionCommon).getBillingAddressDetailOffer()
		println "actualBillingAddress: $actualBillingAddress"
		WebUI.verifyEqual(actualBillingAddress, expectedResult)
		return this
	}

	public DetailOffer verifyShippingAddress(List<String> expectedResult) {
		List<String> actualShippingAddress = Page.nav(FunctionCommon).getShippingAddressDetailOffer()
		println "actualShippingAddress: $actualShippingAddress"
		WebUI.verifyEqual(actualShippingAddress, expectedResult)
		return this
	}

	public DetailOffer verifyTablePartReview(String partName, List<String> expectedResult ) {
		List<String> actualResult = Page.nav(FunctionCommon).getTablePartReview(partName)
		println "tablePart info: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public DetailOffer verifyThichnessValue(String partName, String expectedResult ) {
		List<String> findTestObjects = findTestObjects("//*[@class='ant-table-thead']//th[text()='Thickness (mm)']")
		if (findTestObjects.size() != 0) {
			String thicknessAct = WebUI.getText(thicknessCol(partName))
			WebUI.verifyEqual(thicknessAct, expectedResult)
		}
		return this
	}

	public DetailOffer verifyOrderSummary(List<String> expectedResult) {
		List<String> orderSummary = Page.nav(FunctionCommon).getOrderSummary()
		println "orderSummary: $orderSummary"
		WebUI.verifyEqual(orderSummary, expectedResult)
		return this
	}

	public DetailOffer verifySurchargeForMinimumOrderValue(String totalPartPrice, String surfaceTreatmentPrice) {
		String actualSurcharge = WebUI.getText(xpath("//label[text()='Surcharge for minimum order value']/following-sibling::label"))
		String expectedSurcharge = 80 - totalPartPrice - surfaceTreatmentPrice
		WebUI.verifyEqual(actualSurcharge, expectedSurcharge)
		return this
	}

	public DetailOffer verifySurchargeTooltipsVisible() {
		WebUI.mouseOver(xpath("//label[text()='Surcharge for minimum order value']/span"))
		WebUI.verifyElementVisible(xpath("//*[text()='$tooltipsSurchargeMinimumPrice']"))
		return this
	}

	public DetailOffer verifyPaidStampVisible() {
		WebUI.verifyElementVisible(xpath("//div[@class='paid-stamp']"))
		return this
	}

	public DetailOffer verifyCustomerInfo(List<String> expectedResult) {
		String nameCostumer = WebUI.getText(xpath("//*[text()='Customer Info']/ancestor::div[@class='ant-card-head']/following-sibling::div//span[@aria-label='user']/following-sibling::label"))
		String email = WebUI.getText(xpath("//*[text()='Customer Info']/ancestor::div[@class='ant-card-head']/following-sibling::div//span[@aria-label='mail']/following-sibling::label"))
		List<String> testObjPhone = findTestObjects("//*[text()='Customer Info']/ancestor::div[@class='ant-card-head']/following-sibling::div//span[@aria-label='phone']/following-sibling::label")
		def phone = (testObjPhone.size() != 0) ? WebUI.getText(xpath("//*[text()='Customer Info']/ancestor::div[@class='ant-card-head']/following-sibling::div//span[@aria-label='phone']/following-sibling::label")) : ""
		String companyName = WebUI.getText(xpath("//*[text()='Customer Info']/ancestor::div[@class='ant-card-head']/following-sibling::div//span[@aria-label='home']/following-sibling::label"))
		List<String> customerInfo = [
			nameCostumer,
			email,
			phone,
			companyName
		]
		println "customerInfo: $customerInfo"
		WebUI.verifyEqual(customerInfo, expectedResult)
		return this
	}

	public DetailOffer verifyShippingInfo(List<String> expectedResult) {
		String orderNumber = WebUI.getText(xpath("//p[text()='Order Number']/following-sibling::label"))
		String numberOfPart = WebUI.getText(xpath("//p[text()='Number of parts']/following-sibling::label"))
		String deliveryOption = WebUI.getText(xpath("//p[text()='Delivery Option']/following-sibling::label"))
		String deliveryDate = WebUI.getText(xpath("//p[text()='Delivery Date']/following-sibling::label"))
		String formatDeliveryDate = DateTimeUtility.changeDateFormat(deliveryDate)

		String Comments = WebUI.getText(xpath("//p[text()='Packaging and Shipping Comments']/following-sibling::label"))
		def packagingAndShippingComments = (Comments == 'Empty') ? "" : Comments

		List<String> shippingOptionsContentObject = findTestObjects("//p[text()='Shipping options']/following-sibling::label")
		def shippingOptionsContent = (shippingOptionsContentObject.size() != 0) ? WebUI.getText(xpath("//p[text()='Shipping options']/following-sibling::label")) : "Empty"

		List<String> shippingOptionsObject = findTestObjects("//div[@class='text-muted']")
		def shippingOptions = (shippingOptionsObject.size() != 0) ? WebUI.getText(xpath("//div[@class='text-muted']")) : "Standard shipping"

		List<String> shippingInfo = [
			orderNumber,
			numberOfPart,
			deliveryOption,
			formatDeliveryDate,
			packagingAndShippingComments,
			shippingOptions,
			shippingOptionsContent
		]

		println "shippingInfo: $shippingInfo"
		WebUI.verifyEqual(shippingInfo, expectedResult)
		return this
	}

	public List<String> getOrderSummary() {
		List<String> orderSummary = Page.nav(FunctionCommon).getOrderSummary()
		return orderSummary
	}

	//Billing Address
	public List<String> getBillingAddressDetailOffer() {
		List<String> billingAddress = Page.nav(FunctionCommon).getBillingAddressDetailOffer()
		return billingAddress
	}
	//Shipping Address
	public List<String> getShippingAddressDetailOffer() {
		List<String> shippingAddress = Page.nav(FunctionCommon).getShippingAddressDetailOffer()
		return shippingAddress
	}

	public List<String> getShippingInfo() {
		String orderNumber = WebUI.getText(xpath("//p[text()='Order Number']/following-sibling::label"))
		String numberOfPart = WebUI.getText(xpath("//p[text()='Number of parts']/following-sibling::label"))
		String deliveryOption = WebUI.getText(xpath("//p[text()='Delivery Option']/following-sibling::label"))
		String deliveryDate = WebUI.getText(xpath("//p[text()='Delivery Date']/following-sibling::label"))
		String formatDeliveryDate = DateTimeUtility.changeDateFormat(deliveryDate)
		String Comments = WebUI.getText(xpath("//p[text()='Packaging and Shipping Comments']/following-sibling::label"))
		def packagingAndShippingComments = (Comments == 'Empty') ? "" : Comments
		List<String> findShippingOptionsContentObject = findTestObjects("//p[text()='Shipping options']/following-sibling::label")
		def shippingOptionsContent = (findShippingOptionsContentObject.size() != 0) ? WebUI.getText(xpath("//p[text()='Shipping options']/following-sibling::label")) : "Empty"
		List<String> findShippingOptionsObject = findTestObjects("//div[@class='text-muted']")
		def shippingOptions = (findShippingOptionsObject.size() != 0) ? WebUI.getText(xpath("//div[@class='text-muted']")) : "Standard shipping"
		List<String> shippingInfo = [
			orderNumber,
			numberOfPart,
			deliveryOption,
			formatDeliveryDate,
			packagingAndShippingComments,
			shippingOptions,
			shippingOptionsContent
		]
		println "final get shippingInfo: $shippingInfo"
		return shippingInfo
	}

	public List<String> getTablePartReview(String partName) {
		List<String> actualResult = Page.nav(FunctionCommon).getTablePartReview(partName)
		println "getTablePartReview: $actualResult"
		return actualResult
	}

	public DetailOffer verifyPDFPreviewOffer(String fileName, String expectedText) {
		String contentFile = FileHelper.readDetailContentFile(fileName)
		String actualResult = contentFile.contains(expectedText)
		println "actualResult: $actualResult"
		if (contentFile.contains(expectedText)) {
			println "Desired content $expectedText found in PDF."
		} else {
			println "Desired content $expectedText not found in PDF."
		}
		WebUI.verifyEqual(actualResult, "true")
		return this
	}

	public DetailOffer verifyAcceptOfferButtonNotVisible() {
		List<String> findTestObjects = findTestObjects("//*[text()='Accept Offer']")
		(findTestObjects.size() == 0) ? WebUI.verifyEqual("true","true") : WebUI.verifyEqual("true","false")
		return this
	}

	public DetailOffer verifyAcceptButtonVisible() {
		WebUI.verifyElementVisible(xpath("//*[text()='Accept']"))
		return this
	}

	public DetailOffer verifyTextLineThroughVisible() {
		WebUI.verifyElementVisible(xpath("//*[contains(@class,'text-decoration-line-through')]"))
		return this
	}

	public DetailOffer verifyAcceptOfferButtonVisible() {
		WebUI.verifyElementVisible(xpath("//*[text()='Accept Offer']"))
		return this
	}

	public DetailOffer verifyTextLineThroughNotVisible() {
		List<String> findTestObjects = findTestObjects("//*[contains(@class,'text-decoration-line-through')]")
		(findTestObjects.size() == 0) ? WebUI.verifyEqual("true","true") : WebUI.verifyEqual("true","false")
		return this
	}

	public DetailOffer verifyViewButtonVisible() {
		WebUI.verifyElementVisible(xpath("//*[text()='View']"))
		return this
	}

	public DetailOffer verifyCopyButtonVisible() {
		WebUI.verifyElementVisible(xpath("//*[text()='Copy']"))
		return this
	}

	public DetailOffer verifyDeclineButtonVisible() {
		WebUI.verifyElementVisible(xpath("//*[text()='Decline']"))
		return this
	}

	public DetailOffer verifyRejectOfferButtonVisible() {
		WebUI.verifyElementVisible(xpath("//*[text()='Reject Offer']"))
		return this
	}

	public DetailOffer verifyAcceptAndSendOfferButtonVisible() {
		List<String> findNumberPrefix = findTestObjects("//span[@class='ant-input-number-prefix']/span[@aria-label='line']")
		(findNumberPrefix.size() == 0) ? WebUI.verifyElementVisible(xpath("//*[text()='Send Adapted Offer ']")) : WebUI.verifyElementVisible(xpath("//*[text()='Accept And Send Offer ']"))
		return this
	}

	public DetailOffer verifySendAdaptedOfferButtonVisible() {
		List<String> findNumberPrefix = findTestObjects("//span[@class='ant-input-number-prefix']/span[contains(@aria-label, 'arrow')]")
		(findNumberPrefix.size() != 0) ? WebUI.verifyElementVisible(xpath("//*[text()='Send Adapted Offer ']")) : WebUI.verifyElementVisible(xpath("//*[text()='Accept And Send Offer ']"))
		return this
	}

	public DetailOffer verifyResetAdaptButtonVisible(String status) {
		if(status == "New request") {
			List<String> findNumberPrefix = findTestObjects("//span[@class='ant-input-number-prefix']/span[contains(@aria-label, 'arrow')]")
			(findNumberPrefix.size() != 0) ? WebUI.verifyElementVisible(xpath("//*[text()='Reset Adapt']")) : ""
		}
		return this
	}

	public DetailOffer verifyContentAlertManuallyVisible(String pageName) {
		List<String> findObject = findTestObjects("//h6[text()='Manually calculated']/following-sibling::div/child::span[@aria-label='info-circle']")
		if(findObject.size() != 0) {
			WebUI.verifyElementVisible(xpath("//*[text()='Manually calculated']"))
			WebUI.verifyElementVisible(xpath("//*[@class='ant-alert-message']"))
			String messageAlert = WebUI.getText(xpath("//*[@class='ant-alert-message']"))
			String actualStatus = WebUI.getText(xpath("//h4/following::span/child::span[normalize-space(text()) != '']"))
			switch (pageName) {
				case "Requested Offers":
					WebUI.verifyEqual(messageAlert, contentRequestedOffersAlertManually)
					WebUI.verifyEqual(actualStatus, "Request for quotation")
					break;

				case "Received Offers":
					WebUI.verifyEqual(messageAlert, contentReceivedOffersAlertManually)
					WebUI.verifyEqual(actualStatus, "Offer adapted")
					break;

				case "Open Inquiries":
					WebUI.verifyEqual(messageAlert, contentOpenInquiriesAlertManually)
					WebUI.verifyEqual(actualStatus, "Request for quotation")
					break;

				case "Sent Offers":
					WebUI.verifyEqual(messageAlert, contentSentOffersAlertManually)
					WebUI.verifyEqual(actualStatus, "Offer adapted")
					break;
			}
		}
		return this
	}

	public DetailOffer verifyUIVisible() {
		//project name
		WebUI.verifyElementVisible(xpath("//h4"))
		//status
		WebUI.verifyElementVisible(xpath("//h4/following::span/child::span[normalize-space(text()) != '']"))
		//Shipping information
		WebUI.verifyElementVisible(xpath("//*[text()='Order Number']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Number of parts']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Delivery Option']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Delivery Date']"))
		//Billing address
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='Full Name']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='House number']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='Street']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='State, Province, or Region']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='ZIP Code']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='City']"))

		//Shipping address
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='Full Name']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='House number']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='Street']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='State, Province, or Region']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='ZIP Code']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='City']"))

		//button More, View
		WebUI.verifyElementVisible(xpath("//*[@aria-label='more']/parent::button"))
		WebUI.mouseOver(xpath("//*[@aria-label='more']/parent::button"))

		//table information of part
		WebUI.verifyElementVisible(xpath("//*[@class='ant-table-thead']//th[text()='Part name']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-table-thead']//th[text()='Files']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-table-thead']//th[text()='Material']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-table-thead']//th[text()='Quantity']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-table-thead']//th[text()='Unit price']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-table-thead']//th[text()='Part Price Total']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-table-thead']//th[text()='CO2 Emission']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-table-thead']//th[text()='Action']"))

		//Order summary
		List<String> findObjectOrder = findTestObjects("//*[text()='Total Part Price']")
		if (findObjectOrder.size() != 0) {
			WebUI.verifyElementVisible(xpath("//*[text()='Order Summary']"))
			WebUI.verifyElementVisible(xpath("//*[text()='Total Part Price']"))
			List<String> findObject = findTestObjects("//*[text()='Surface Treatment Surcharge']")
			if (findObject.size() != 0) {
				WebUI.verifyElementVisible(xpath("//*[text()='Surface Treatment Surcharge']"))
			}
			WebUI.verifyElementVisible(xpath("//*[text()='Express Surcharge']"))
			WebUI.verifyElementVisible(xpath("//*[text()='Packaging Cost']"))
			WebUI.verifyElementVisible(xpath("//*[text()='Packaging and Shipping Comments']"))
			WebUI.verifyElementVisible(xpath("//*[text()='Shipping costs']"))
			WebUI.verifyElementVisible(xpath("//*[text()='NET Total']"))
			WebUI.verifyElementVisible(xpath("//*[text()='GROSS Total']"))
			WebUI.verifyElementVisible(xpath("//*[text()='Preview Offer']"))
		}
		//Customer infor
		WebUI.verifyElementVisible(xpath("//*[@class='ant-space-item']//span[@aria-label='user']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-space-item']//span[@aria-label='mail']"))
		List<String> findObjectPhone = findTestObjects("//*[@class='ant-space-item']//span[@aria-label='phone']")
		(findObjectPhone.size() != 0) ? WebUI.verifyElementVisible(xpath("//*[@class='ant-space-item']//span[@aria-label='phone']")) : ""
		WebUI.verifyElementVisible(xpath("//*[@class='ant-space-item']//span[@aria-label='home']"))
		return this
	}
}
