package gocad.common

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import gocad.buyer.ConfirmedOffersPageOfBuyer
import internal.GlobalVariable
import katalon.fw.lib.BasePage




public class DetailOffer extends BasePage<DetailOffer>{

	def partCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[2]")}
	def fileCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[3]//a")}
	def materialCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[4]")}
	def quantityCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[5]")}
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

	public DetailOffer clickCancelPopup() {
		WebUI.click(xpath("//span[text()='Cancel']/parent::button"))
		return this
	}

	public DetailOffer clickOKConfirmPopup() {
		WebUI.click(xpath("//span[text()='OK']/parent::button"))
		WebUI.delay(GlobalVariable.smallSleepTime)
		return this
	}
	
	public DetailOffer verifyOrderStatus(String projectId, String expectedResult) {
		String status = WebUI.getText(xpath("//*[text()='$projectId']/following-sibling::span/span[2]"))
		WebUI.verifyEqual(status, expectedResult)
		return this
	}
	
	public ConfirmedOffersPageOfBuyer verifyOrderNumber(String projectId) {
		String actualResult = WebUI.getText(xpath("//p[text()='Order Number']/parent::div"))
		String expectedResult = "GOCAD"+ projectId
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public ConfirmedOffersPageOfBuyer verifyNumberOfParts(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//p[text()='Number of parts']/parent::div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public ConfirmedOffersPageOfBuyer verifyDeliveryOption(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//p[text()='Delivery Option']/parent::div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public ConfirmedOffersPageOfBuyer verifyDeliveryDate(String expectedResult) {
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
		List<String> actualBillingAddress = [fullName, houseNumber, street, state, zipCode, city]
		println "actualBillingAddress: $actualBillingAddress"
		WebUI.verifyEqual(actualBillingAddress, expectedResult)
		return this
	}
	
	public DetailOffer verifyOrderSummary(List<String> expectedResult) {
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
		println "orderSummary Confirmed page: $orderSummary"
		WebUI.verifyEqual(orderSummary, expectedResult)
		return this
	}
	
	public ConfirmedOffersPageOfBuyer verifyCustomerInfo(List<String> expectedResult) {
		String nameCostumer = WebUI.getText(xpath("//*[text()='Customer Info']/ancestor::div[@class='ant-card-head']/following-sibling::div//span[@aria-label='user']/following-sibling::label"))
		String email = WebUI.getText(xpath("//*[text()='Customer Info']/ancestor::div[@class='ant-card-head']/following-sibling::div//span[@aria-label='mail']/following-sibling::label"))
		String phone = WebUI.getText(xpath("//*[text()='Customer Info']/ancestor::div[@class='ant-card-head']/following-sibling::div//span[@aria-label='phone']/following-sibling::label"))
		String companyName = WebUI.getText(xpath("//*[text()='Customer Info']/ancestor::div[@class='ant-card-head']/following-sibling::div//span[@aria-label='home']/following-sibling::label"))
		List<String> customerInfo = [nameCostumer, email, phone, companyName]
		println "customerInfo: $customerInfo"
		return this
	}
}
