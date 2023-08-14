package gocad.common

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import katalon.fw.lib.BasePage
import katalon.fw.lib.Page
import katalon.utility.DateTimeUtility

public class DetailOffer extends BasePage<DetailOffer>{

	def partCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[2]")}
	def fileCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[3]//a")}
	def materialCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[4]")}
	def quantityCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[5]")}
	def unitPriceInputCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[6]//input[@id='unitPrice']")}
	def unitPriceCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[6]")}
	def partPriceTotalCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[7]")}
	def CO2EmissionCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[9]")}
	def actionView = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[10]")}
	def actionMore = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[10]//button")}

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
		WebUI.click(xpath("//*[@aria-label='undo']"))
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

	public DetailOffer inputUnitPrice(String unitPrice) {
		clearTextAndSendKeysByActions(xpath("//*[@class='ant-input-number-input']"), unitPrice)
		return this
	}

	public DetailOffer verifyOrderStatus(String projectId, String expectedResult) {
		String status = WebUI.getText(xpath("//*[text()='$projectId']/following-sibling::span/span[2]"))
		WebUI.verifyEqual(status, expectedResult)
		return this
	}

	public DetailOffer verifyOrderNumber(String projectId) {
		String actualResult = WebUI.getText(xpath("//p[text()='Order Number']/parent::div"))
		String expectedResult = "GOCAD"+ projectId
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
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public DetailOffer verifyBillingAddress(List<String> expectedResult) {
		String fullName = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='Full Name']/ancestor::tr/following-sibling::tr[1]/td[1]"))
		String houseNumber = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='House number']/ancestor::tr/following-sibling::tr[1]/td[2]"))
		String street = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='Street']/ancestor::tr/following-sibling::tr[1]/td[3]"))
		String state = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='State']/ancestor::tr/following-sibling::tr[1]/td[1]"))
		String zipCode = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='ZIP Code']/ancestor::tr/following-sibling::tr[1]/td[2]"))
		String city = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='City']/ancestor::tr/following-sibling::tr[1]/td[3]"))
		List<String> actualBillingAddress = [fullName, houseNumber, street, state, zipCode, city]
		println "actualBillingAddress: $actualBillingAddress"
		WebUI.verifyEqual(actualBillingAddress, expectedResult)
		return this
	}

	public DetailOffer verifyShippingAddress(List<String> expectedResult) {
		String fullName = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='Full Name']/ancestor::tr/following-sibling::tr[1]/td[1]"))
		String houseNumber = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='House number']/ancestor::tr/following-sibling::tr[1]/td[2]"))
		String street = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='Street']/ancestor::tr/following-sibling::tr[1]/td[3]"))
		String state = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='State']/ancestor::tr/following-sibling::tr[1]/td[1]"))
		String zipCode = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='ZIP Code']/ancestor::tr/following-sibling::tr[1]/td[2]"))
		String city = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='City']/ancestor::tr/following-sibling::tr[1]/td[3]"))
		List<String> actualShippingAddress = [fullName, houseNumber, street, state, zipCode, city]
		println "actualShippingAddress: $actualShippingAddress"
		WebUI.verifyEqual(actualShippingAddress, expectedResult)
		return this
	}

	public DetailOffer verifyTablePartReview(String partName, List<String> expectedResult ) {
		String partNameCol = WebUI.getText(partCol(partName))
		String material = WebUI.getText(materialCol(partName))
		String quantity = WebUI.getText(quantityCol(partName))
		String unitPrice = WebUI.getText(unitPriceCol(partName))
		String totalPartPrice = WebUI.getText(partPriceTotalCol(partName))
		List<String> findTestObjects = findTestObjects("//*[@aria-label='message']")
		println "findTestObjects: $findTestObjects"
		String CO2Emission = WebUI.getText(CO2EmissionCol(partName))
		String comment
		if (findTestObjects.size() != 0) {
			WebUI.mouseOver(xpath("//*[@aria-label='message']"))
			comment = WebUI.getText(xpath("//*[@role='tooltip']/div[2]/div"))
		}
		else
		{
			comment = ""
			
		}
		List<String> actualResult = [partNameCol, material, quantity, unitPrice, totalPartPrice, comment, CO2Emission]
		println "tablePart info: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public DetailOffer verifyOrderSummary(List<String> expectedResult) {
		String totalPartPrice = WebUI.getText(xpath("//label[text()='Total Part Price']/following-sibling::label"))
		List<String> surfaceTreatmentSurchargeObject = findTestObjects("//label[text()='Surface Treatment Surcharge']/following-sibling::label")
		def surfaceTreatmentSurcharge = (surfaceTreatmentSurchargeObject.size() != 0) ? WebUI.getText(xpath("//label[text()='Surface Treatment Surcharge']/following-sibling::label")) : "Empty"
		String expressSurchargeValue = WebUI.getText(xpath("//label[text()='Express Surcharge']/following-sibling::label"))
		String expressSurcharge = expressSurchargeValue == "00.0 €" ? "-- €" : expressSurchargeValue
		String packagingCost = WebUI.getText(xpath("//label[text()='Packaging Cost']/following-sibling::label"))
		String shippingCosts = WebUI.getText(xpath("//label[text()='Shipping costs']/following-sibling::label"))
		String netTotal = WebUI.getText(xpath("//*[text()='NET Total']/following-sibling::label"))
		String vat = WebUI.getText(xpath("//label[text()='VAT (19%)']/following-sibling::label"))
		String grossTotal = WebUI.getText(xpath("//*[text()='GROSS Total']/following-sibling::label"))
		List<String> orderSummary = [totalPartPrice, surfaceTreatmentSurcharge, expressSurcharge, packagingCost, shippingCosts, netTotal, vat, grossTotal]
		println "orderSummary: $orderSummary"
		WebUI.verifyEqual(orderSummary, expectedResult)
		return this
	}

	public DetailOffer verifyCustomerInfo(List<String> expectedResult) {
		String nameCostumer = WebUI.getText(xpath("//*[text()='Customer Info']/ancestor::div[@class='ant-card-head']/following-sibling::div//span[@aria-label='user']/following-sibling::label"))
		String email = WebUI.getText(xpath("//*[text()='Customer Info']/ancestor::div[@class='ant-card-head']/following-sibling::div//span[@aria-label='mail']/following-sibling::label"))
		String phone = WebUI.getText(xpath("//*[text()='Customer Info']/ancestor::div[@class='ant-card-head']/following-sibling::div//span[@aria-label='phone']/following-sibling::label"))
		String companyName = WebUI.getText(xpath("//*[text()='Customer Info']/ancestor::div[@class='ant-card-head']/following-sibling::div//span[@aria-label='home']/following-sibling::label"))
		List<String> customerInfo = [nameCostumer, email, phone, companyName]
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
		def shippingOptions = (shippingOptionsObject.size() != 0) ? WebUI.getText(xpath("//div[@class='text-muted']")) : "Empty"
		
		List<String> shippingInfo = [orderNumber, numberOfPart, deliveryOption, formatDeliveryDate, packagingAndShippingComments, shippingOptions, shippingOptionsContent]
		
		println "shippingInfo: $shippingInfo"
		WebUI.verifyEqual(shippingInfo, expectedResult)
		return this
	}

	public List<String> getOrderSummary() {
		String totalPartPrice = WebUI.getText(xpath("//label[text()='Total Part Price']/following-sibling::label"))
		String surfaceTreatmentSurcharge = WebUI.getText(xpath("//label[text()='Surface Treatment Surcharge']/following-sibling::label"))
		String expressSurchargeValue = WebUI.getText(xpath("//label[text()='Express Surcharge']/following-sibling::label"))
		String expressSurcharge = expressSurchargeValue == "00.0 €" ? "-- €" : expressSurchargeValue
		String packagingCost = WebUI.getText(xpath("//label[text()='Packaging Cost']/following-sibling::label"))
		String shippingCosts = WebUI.getText(xpath("//label[text()='Shipping costs']/following-sibling::label"))
		String netTotal = WebUI.getText(xpath("//*[text()='NET Total']/following-sibling::label"))
		String vat = WebUI.getText(xpath("//label[text()='VAT (19%)']/following-sibling::label"))
		String grossTotal = WebUI.getText(xpath("//*[text()='GROSS Total']/following-sibling::label"))
		List<String> orderSummary = [totalPartPrice, surfaceTreatmentSurcharge, expressSurcharge, packagingCost, shippingCosts, netTotal, vat, grossTotal]
		return orderSummary
	}

	//Billing Address
	public List<String> getBillingAddress() {
		String fullName = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='Full Name']/ancestor::tr/following-sibling::tr[1]/td[1]"))
		String houseNumber = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='House number']/ancestor::tr/following-sibling::tr[1]/td[2]"))
		String street = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='Street']/ancestor::tr/following-sibling::tr[1]/td[3]"))
		String state = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='State']/ancestor::tr/following-sibling::tr[1]/td[1]"))
		String zipCode = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='ZIP Code']/ancestor::tr/following-sibling::tr[1]/td[2]"))
		String city = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='City']/ancestor::tr/following-sibling::tr[1]/td[3]"))
		List<String> billingAddress = [fullName, houseNumber, street, state, zipCode, city]
		return billingAddress
	}
	//Shipping Address
	public List<String> getShippingAddress() {
		String fullName = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='Full Name']/ancestor::tr/following-sibling::tr[1]/td[1]"))
		String houseNumber = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='House number']/ancestor::tr/following-sibling::tr[1]/td[2]"))
		String street = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='Street']/ancestor::tr/following-sibling::tr[1]/td[3]"))
		String state = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='State']/ancestor::tr/following-sibling::tr[1]/td[1]"))
		String zipCode = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='ZIP Code']/ancestor::tr/following-sibling::tr[1]/td[2]"))
		String city = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='City']/ancestor::tr/following-sibling::tr[1]/td[3]"))
		List<String> billingAddress = [fullName, houseNumber, street, state, zipCode, city]
		return billingAddress
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
		List<String> shippingInfo = [orderNumber, numberOfPart, deliveryOption, formatDeliveryDate, packagingAndShippingComments, shippingOptions, shippingOptionsContent]
		println "final get shippingInfo: $shippingInfo"
		return shippingInfo
	}

	public List<String> getTablePartReview(String partName) {
		String partNameCol = WebUI.getText(partCol(partName))
		String material = WebUI.getText(materialCol(partName))
		String quantity = WebUI.getText(quantityCol(partName))
		List<String> unitPriceObject = findTestObjects("//div[text()='$partName']/ancestor::tr/td[6]//input[@id='unitPrice']")
		println "unitPriceObject: $unitPriceObject"
		def unitPrice = (unitPriceObject.size() == 0) ? WebUI.getText(unitPriceCol(partName)) : (WebUI.getAttribute(unitPriceInputCol(partName), "value") + " €")
		String totalPartPrice = WebUI.getText(partPriceTotalCol(partName))
		WebUI.mouseOver(xpath("//*[@aria-label='message']"))
		String comment = WebUI.getText(xpath("//*[@role='tooltip']/div[2]/div"))
		String CO2Emission = WebUI.getText(CO2EmissionCol(partName))
		List<String> result = [partNameCol, material, quantity, unitPrice, totalPartPrice, comment, CO2Emission]
		println "getTablePartReview: $result"
		return result
	}
}
