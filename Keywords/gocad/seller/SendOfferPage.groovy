package gocad.seller

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage

public class SendOfferPage extends BasePage<SendOfferPage>{
	
	def partCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[2]")}
	def materialCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[4]")}
	def quantityCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[5]")}
	def unitPriceCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[6]")}
	def partPriceTotalCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[7]")}
	def CO2EmissionCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[9]")}
	def actionView = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[10]")}
	def actionMore = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[10]//button")}

	public SendOfferPage clickSendOffer() {
		WebUI.click(xpath('//*[text()="Send Offer"]'))
		return this
	}
	
	public SendOfferPage inputCustomer(String text) {
		WebUI.setText(xpath("//input[@id='email']"), text)
		WebUI.click(xpath("//div[contains(@class, 'ant-select-item ant-select-item-option')]//span[text()='$text']"))
		return this
	}

	public SendOfferPage selectShippingOption(String shippingOptions) {
		WebUI.click(xpath("//input[@id='shippingOption']/parent::span/parent::div"))
		WebUI.click(xpath("//div[contains(@class, 'ant-select-item') and contains(@title,'$shippingOptions')]"))
		return this
	}

	public SendOfferPage inputPackagingAndShippingComments(String text) {
		WebUI.setText(xpath("//textarea[@id='shippingComment']"), text)
		return this
	}

	public String getShippingOptions() {
		String shippingOptions = WebUI.getAttribute(xpath("//input[@id='shippingOption']/parent::span/parent::div/span[2]"), "title")
		return shippingOptions
	}

	public String getPackagingAndShippingComments() {
		String text = WebUI.getText(xpath("//textarea[@id='shippingComment']"))
		return text
	}

	public String getCompanyName() {
		String companyName = WebUI.getText(xpath("//*[text()='Company Name']/ancestor::div[@class='row']/div[4]"))
		return companyName
	}

	//Billing Address
	public List<String> getBillingAddress() {
		String fullName = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following::div[1]//*[text()='Full name']/parent::div/span[2]"))
		String houseNumber = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following::div[1]//*[text()='House number']/parent::div/span[2]"))
		String street = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following::div[1]//*[text()='Street']/parent::div/span[2]"))
		String state = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following::div[1]//*[text()='State']/parent::div/span[2]"))
		String zipCode = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following::div[1]//*[text()='ZIP Code']/parent::div/span[2]"))
		String city = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following::div[1]//*[text()='City']/parent::div/span[2]"))
		List<String> billingAddress = [fullName, houseNumber, street, state, zipCode, city]
		return billingAddress
	}
	//Shipping Address
	public List<String> getShippingAddress() {
		String fullName = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following::div[1]//*[text()='Full name']/parent::div/span[2]"))
		String houseNumber = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following::div[1]//*[text()='House number']/parent::div/span[2]"))
		String street = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following::div[1]//*[text()='Street']/parent::div/span[2]"))
		String state = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following::div[1]//*[text()='State']/parent::div/span[2]"))
		String zipCode = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following::div[1]//*[text()='ZIP Code']/parent::div/span[2]"))
		String city = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following::div[1]//*[text()='City']/parent::div/span[2]"))
		List<String> billingAddress = [fullName, houseNumber, street, state, zipCode, city]
		return billingAddress
	}

	public SendOfferPage verifyMaterial(String partName, String expectedResult) {
		String actualResult = WebUI.getText(materialCol(partName))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public SendOfferPage verifyQuantity(String partName, String expectedResult) {
		String actualResult = WebUI.getText(quantityCol(partName))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public SendOfferPage verifyUnitPrice(String partName, String expectedResult) {
		String actualResult = WebUI.getText(unitPriceCol(partName))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public SendOfferPage verifyPartPriceTotal(String partName, String expectedResult) {
		String actualResult = WebUI.getText(partPriceTotalCol(partName))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public SendOfferPage verifyCO2EmissionCol(String partName, String expectedResult) {
		String actualResult = WebUI.getText(CO2EmissionCol(partName))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public List<String> getOrderSummary() {
		String totalPartPrice = WebUI.getText(xpath("//label[text()='Total Part Price']/following-sibling::label"))
		List<String> surfaceTreatmentSurchargeObject = findTestObjects("//label[text()='Surface Treatment Surcharge']/following-sibling::label")
		def surfaceTreatmentSurcharge = (surfaceTreatmentSurchargeObject.size() != 0) ? WebUI.getText(xpath("//label[text()='Surface Treatment Surcharge']/following-sibling::label")) : "Empty"
		String expressSurcharge = WebUI.getText(xpath("//label[text()='Express Surcharge']/following-sibling::label"))
		String packagingCost = WebUI.getText(xpath("//label[text()='Packaging Cost']/following-sibling::label"))
		String shippingCosts = WebUI.getText(xpath("//label[text()='Shipping costs']/following-sibling::label"))
		String netTotal = WebUI.getText(xpath("//*[text()='NET Total']/following-sibling::label"))
		String vat = WebUI.getText(xpath("//label[text()='VAT (19%)']/following-sibling::label"))
		String grossTotal = WebUI.getText(xpath("//*[text()='GROSS Total']/following-sibling::label"))
		List<String> orderSummary = [totalPartPrice, surfaceTreatmentSurcharge, expressSurcharge, packagingCost, shippingCosts, netTotal, vat, grossTotal]
		return orderSummary
	}

	public String getNetTotal() {
		String netTotal = WebUI.getText(xpath("//*[text()='NET Total']/following-sibling::label"))
		return netTotal
	}

	public String getGrossTotal() {
		String grossTotal = WebUI.getText(xpath("//*[text()='GROSS Total']/following-sibling::label"))
		return grossTotal
	}
}
