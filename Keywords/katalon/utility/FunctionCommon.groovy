package katalon.utility

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import katalon.fw.lib.BasePage




public class FunctionCommon extends BasePage<FunctionCommon>{

	def partCol = { String partName -> return "//div[text()='$partName']/ancestor::tr/td[1]"}
	def fileCol = { String partName -> return "//div[text()='$partName']/ancestor::tr/td[2]//a"}
	def materialCol = { String partName -> return "//div[text()='$partName']/ancestor::tr/td[3]"}
	def thicknessCol = { String partName -> return "//div[text()='$partName']/ancestor::tr/td[4]"}
	def quantityCol = { String partName -> return "//div[text()='$partName']/ancestor::tr/td[5]"}
	def unitPriceCol = { String partName -> return "//div[text()='$partName']/ancestor::tr/td[6]"}
	def partPriceTotalCol = { String partName -> return "//div[text()='$partName']/ancestor::tr/td[7]"}
	def CO2EmissionCol = { String partName -> return "//div[text()='$partName']/ancestor::tr/td[9]"}
	def actionMore = { String partName -> return "//div[text()='$partName']/ancestor::tr/td[10]//button"}

	//Billing Address
	public List<String> getBillingAddressCheckoutPage() {
		String firstName = WebUI.getAttribute(xpath("//*[text()='Billing Address']/following-sibling::div[@class='row']//input[@id='billingAddress_firstName']"), "value")
		String lastName = WebUI.getAttribute(xpath("//*[text()='Billing Address']/following-sibling::div[@class='row']//input[@id='billingAddress_lastName']"), "value")
		String fullName = firstName + " " + lastName
		String email = WebUI.getAttribute(xpath("//*[text()='Billing Address']/following-sibling::div[@class='row']//input[@id='billingAddress_email']"), "value")
		String phone = WebUI.getAttribute(xpath("//*[text()='Billing Address']/following-sibling::div[@class='row']//input[@id='billingAddress_phone']"), "value")
		String houseNumber = WebUI.getAttribute(xpath("//*[text()='Billing Address']/following-sibling::div[@class='row']//input[@id='billingAddress_houseNumber']"), "value")
		String street = WebUI.getAttribute(xpath("//*[text()='Billing Address']/following-sibling::div[@class='row']//input[@id='billingAddress_streetName']"), "value")
		String country = WebUI.getAttribute(xpath("//*[text()='Billing Address']/following-sibling::div[@class='row']//input[@id='billingAddress_country']/parent::span/following-sibling::span"), "title")
		String state = WebUI.getAttribute(xpath("//*[text()='Billing Address']/following-sibling::div[@class='row']//input[@id='billingAddress_state']"), "value")
		String zipCode = WebUI.getAttribute(xpath("//*[text()='Billing Address']/following-sibling::div[@class='row']//input[@id='billingAddress_postCode']"), "value")
		String city = WebUI.getAttribute(xpath("//*[text()='Billing Address']/following-sibling::div[@class='row']//input[@id='billingAddress_city']"), "value")
		List<String> billingAddress = [
			fullName,
			email,
			phone,
			street,
			houseNumber,
			country,
			state,
			city,
			zipCode
		]
		return billingAddress
	}

	//Shipping Address
	public List<String> getShippingAddressCheckoutPage() {
		String firstName = WebUI.getAttribute(xpath("//*[text()='Shipping Address']/following-sibling::div[@class='row']//input[@id='shippingAddress_firstName']"), "value")
		String lastName = WebUI.getAttribute(xpath("//*[text()='Shipping Address']/following-sibling::div[@class='row']//input[@id='shippingAddress_lastName']"), "value")
		String fullName = firstName + " " + lastName
		String email = WebUI.getAttribute(xpath("//*[text()='Shipping Address']/following-sibling::div[@class='row']//input[@id='shippingAddress_email']"), "value")
		String phone = WebUI.getAttribute(xpath("//*[text()='Shipping Address']/following-sibling::div[@class='row']//input[@id='shippingAddress_phone']"), "value")
		String houseNumber = WebUI.getAttribute(xpath("//*[text()='Shipping Address']/following-sibling::div[@class='row']//input[@id='shippingAddress_houseNumber']"), "value")
		String street = WebUI.getAttribute(xpath("//*[text()='Shipping Address']/following-sibling::div[@class='row']//input[@id='shippingAddress_streetName']"), "value")
		String country = WebUI.getAttribute(xpath("//*[text()='Shipping Address']/following-sibling::div[@class='row']//input[@id='shippingAddress_country']/parent::span/following-sibling::span"), "title")
		String state = WebUI.getAttribute(xpath("//*[text()='Shipping Address']/following-sibling::div[@class='row']//input[@id='shippingAddress_state']"), "value")
		String zipCode = WebUI.getAttribute(xpath("//*[text()='Shipping Address']/following-sibling::div[@class='row']//input[@id='shippingAddress_postCode']"), "value")
		String city = WebUI.getAttribute(xpath("//*[text()='Shipping Address']/following-sibling::div[@class='row']//input[@id='shippingAddress_city']"), "value")
		List<String> shippingAddress = [
			fullName,
			email,
			phone,
			street,
			houseNumber,
			country,
			state,
			city,
			zipCode
		]
		return shippingAddress
	}

	//Billing Address
	public List<String> getBillingAddress() {
		String fullName = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='Full Name']/ancestor::tr/following-sibling::tr[1]/td[1]"))
		String houseNumber = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='House number']/ancestor::tr/following-sibling::tr[1]/td[2]"))
		String street = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='Street']/ancestor::tr/following-sibling::tr[1]/td[3]"))
		String state = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='State, Province, or Region']/ancestor::tr/following-sibling::tr[1]/td[1]"))
		String zipCode = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='ZIP Code']/ancestor::tr/following-sibling::tr[1]/td[2]"))
		String city = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='City']/ancestor::tr/following-sibling::tr[1]/td[3]"))
		String country = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='Country']/ancestor::tr/following-sibling::tr[1]/td[1]"))
		String email = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='E-mail']/ancestor::tr/following-sibling::tr[1]/td[2]"))
		String phone = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='Phone']/ancestor::tr/following-sibling::tr[1]/td[3]"))
		List<String> billingAddress = [
			fullName,
			email,
			phone,
			street,
			houseNumber,
			country,
			state,
			city,
			zipCode
		]
		return billingAddress
	}

	//Shipping Address
	public List<String> getShippingAddress() {
		String fullName = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='Full Name']/ancestor::tr/following-sibling::tr[1]/td[1]"))
		String houseNumber = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='House number']/ancestor::tr/following-sibling::tr[1]/td[2]"))
		String street = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='Street']/ancestor::tr/following-sibling::tr[1]/td[3]"))
		String state = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='State, Province, or Region']/ancestor::tr/following-sibling::tr[1]/td[1]"))
		String zipCode = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='ZIP Code']/ancestor::tr/following-sibling::tr[1]/td[2]"))
		String city = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='City']/ancestor::tr/following-sibling::tr[1]/td[3]"))
		String country = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='Country']/ancestor::tr/following-sibling::tr[1]/td[1]"))
		String email = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='E-mail']/ancestor::tr/following-sibling::tr[1]/td[2]"))
		String phone = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='Phone']/ancestor::tr/following-sibling::tr[1]/td[3]"))
		List<String> billingAddress = [
			fullName,
			email,
			phone,
			street,
			houseNumber,
			country,
			state,
			city,
			zipCode
		]
		return billingAddress
	}

	//Account Settings
	//Billing address
	public List<String> getBillingAddressAccountSettings() {
		String firstName = WebUI.getAttribute(xpath("//*[@id='basic_billingAddress_firstName']"), 'value')
		String lastName = WebUI.getAttribute(xpath("//*[@id='basic_billingAddress_lastName']"), 'value')
		String name = (firstName + " " + lastName).replace(",", "")
		String email = WebUI.getAttribute(xpath("//*[@id='basic_billingAddress_email']"), 'value')
		String phone = WebUI.getAttribute(xpath("//*[@id='basic_billingAddress_phone']"), 'value')
		String streetName = WebUI.getAttribute(xpath("//*[@id='basic_billingAddress_streetName']"), 'value')
		String houseNumber = WebUI.getAttribute(xpath("//*[@id='basic_billingAddress_houseNumber']"), 'value')
		String country = WebUI.getAttribute(xpath("//*[@class='sub-l' and text()='Billing Address']/parent::div/div[@class='row']/div[8]//span[@class='ant-select-selection-item']"), 'title')
		String state = WebUI.getAttribute(xpath("//*[@class='sub-l' and text()='Billing Address']/parent::div/div[@class='row']/div[9]//input"), 'value')
		String city = WebUI.getAttribute(xpath("//*[@class='sub-l' and text()='Billing Address']/parent::div/div[@class='row']/div[10]//input"), 'value')
		String postCode = WebUI.getAttribute(xpath("//*[@id='basic_billingAddress_postCode']"), 'value')
		List<String> billingAddress = [
			name,
			email,
			phone,
			streetName,
			houseNumber,
			country,
			state,
			city,
			postCode
		]
		return billingAddress
	}

	//Shipping address
	public List<String> getShippingAddressAccountSettings() {
		String firstName = WebUI.getAttribute(xpath("//*[@id='basic_shippingAddress_firstName']"), 'value')
		String lastName = WebUI.getAttribute(xpath("//*[@id='basic_shippingAddress_lastName']"), 'value')
		String name = (firstName + " " + lastName).replace(",", "")
		String email = WebUI.getAttribute(xpath("//*[@id='basic_shippingAddress_email']"), 'value')
		String phone = WebUI.getAttribute(xpath("//*[@id='basic_shippingAddress_phone']"), 'value')
		String streetName = WebUI.getAttribute(xpath("//*[@id='basic_shippingAddress_streetName']"), 'value')
		String houseNumber = WebUI.getAttribute(xpath("//*[@id='basic_shippingAddress_houseNumber']"), 'value')
		String country = WebUI.getAttribute(xpath("//*[@class='sub-l' and text()='Shipping Address']/parent::div/div[@class='row']/div[8]//span[@class='ant-select-selection-item']"), 'title')
		String state = WebUI.getAttribute(xpath("//*[@class='sub-l' and text()='Shipping Address']/parent::div/div[@class='row']/div[9]//input"), 'value')
		String city = WebUI.getAttribute(xpath("//*[@class='sub-l' and text()='Shipping Address']/parent::div/div[@class='row']/div[10]//input"), 'value')
		String postCode = WebUI.getAttribute(xpath("//*[@id='basic_shippingAddress_postCode']"), 'value')
		List<String> billingAddress = [
			name,
			email,
			phone,
			streetName,
			houseNumber,
			country,
			state,
			city,
			postCode
		]
		return billingAddress
	}

	//Order Summary
	public List<String> getOrderSummary() {
		String totalPartPrice = WebUI.getText(xpath("//label[text()='Total Part Price']/following-sibling::label"))
		List<String> surfaceTreatmentSurchargeObject = findTestObjects("//label[text()='Surface Treatment Surcharge']/following-sibling::label")
		def surfaceTreatmentSurcharge = (surfaceTreatmentSurchargeObject.size() != 0) ? WebUI.getText(xpath("//label[text()='Surface Treatment Surcharge']/following-sibling::label")) : "Empty"
		String expressSurchargeValue = WebUI.getText(xpath("//label[text()='Express Surcharge']/following-sibling::label"))
		String expressSurcharge = expressSurchargeValue == "00.0 $GlobalVariable.currency" ? "-- $GlobalVariable.currency" : expressSurchargeValue
		String packagingCost = WebUI.getText(xpath("//label[text()='Packaging Cost']/following-sibling::label"))
		String shippingCosts = WebUI.getText(xpath("//label[text()='Shipping costs']/following-sibling::label"))
		String netTotal = WebUI.getText(xpath("//*[text()='NET Total']/following-sibling::label"))
		String vat = WebUI.getText(xpath("//*[contains(@class,'summary-price')]//*[contains(text(),'VAT')]/following-sibling::label"))
		String grossTotal = WebUI.getText(xpath("//*[text()='GROSS Total']/following-sibling::label"))
		List<String> orderSummary = [
			totalPartPrice,
			surfaceTreatmentSurcharge,
			expressSurcharge,
			packagingCost,
			shippingCosts,
			netTotal,
			vat,
			grossTotal
		]
		return orderSummary
	}

	public List<String> getTablePartReview(String partName) {
		String partNameCol = WebUI.getText(xpath(partCol(partName)))
		String material = WebUI.getText(xpath(materialCol(partName)))
		//String thickness = WebUI.getText(xpath(thicknessCol(partName)))
		List<String> findQuanTestObjects = findTestObjects("//input[@id='quantity']")
		String quantity
		if (findQuanTestObjects.size() != 0) {
			quantity = WebUI.getAttribute(xpath(quantityCol(partName) + "//input[@id='quantity']"), "value")
		}
		else {
			quantity = WebUI.getText(xpath(quantityCol(partName)))
		}
		String unitPrice
		List<String> findUnitTestObjects = findTestObjects("//input[@id='unitPrice']")
		if (findUnitTestObjects.size() != 0) {
			unitPrice = WebUI.getAttribute(xpath(unitPriceCol(partName) + "//input[@id='unitPrice']"), "value") + " $GlobalVariable.currency"
		}
		else {
			unitPrice = WebUI.getText(xpath(unitPriceCol(partName)))
		}
		String totalPartPrice = WebUI.getText(xpath(partPriceTotalCol(partName)))
		List<String> findTestObjects = findTestObjects("//*[@aria-label='message']")
		String CO2Emission = WebUI.getText(xpath(CO2EmissionCol(partName)))
		String comment
		println "findTestObjects: $findTestObjects"
		if (findTestObjects.size() != 0) {
			WebUI.mouseOver(xpath("//*[@aria-label='message']"))
			comment = WebUI.getText(xpath("//*[@role='tooltip']/div[2]/div"))
		}
		else {
			comment = ""
		}
		List<String> actualResult = [
			partNameCol,
			material,
			quantity,
			unitPrice,
			totalPartPrice,
			comment,
			CO2Emission
		]
		return actualResult
	}
}
