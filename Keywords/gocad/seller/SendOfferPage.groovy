package gocad.seller

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import gocad.buyer.CheckoutPage
import katalon.fw.lib.BasePage

public class SendOfferPage extends BasePage<SendOfferPage>{

	def partCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[2]")}
	def materialCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[4]")}
	def thicknessCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[5]")}
	def quantityCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[6]")}
	def unitPriceCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[7]")}
	def partPriceTotalCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[8]")}
	def CO2EmissionCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[10]")}
	def actionView = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[11]")}
	def actionMore = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[11]//button")}
	def expectedContentTooltips = "Surchage to fulfill minimum order value and transport costs for surface treatment"
	def expectedAlertContent = "After the final approval of the offer by the seller, you will receive a confirmation via e-mail"

	public SendOfferPage clickSendOffer() {
		WebUI.click(xpath('//*[text()="Send Offer"]'))
		return this
	}

	public SendOfferPage clickEditAddress() {
		WebUI.click(xpath("//*[@aria-label='edit']/parent::button"))
		return this
	}
	
	public SendOfferPage clickMoreOption(String partName) {
		WebUI.click(actionMore(partName))
		return this
	}

	public SendOfferPage clickView() {
		WebUI.click(xpath("//*[contains(text(),'View')]"))
		return this
	}
	
	public SendOfferPage clickCopy() {
		WebUI.click(xpath("//*[contains(text(),'Copy')]"))
		return this
	}

	public SendOfferPage inputCustomer(String text) {
		WebUI.setText(xpath("//input[@id='email']"), text)
		WebUI.click(xpath("//div[contains(@class, 'ant-select-item ant-select-item-option')]//span[text()='$text']"))
		return this
	}
	
	public SendOfferPage clickFilePDFDownload() {
		WebUI.click(xpath("//*[text()='Preview Offer']"))
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
		String fullName = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='Full Name']/ancestor::tr/following-sibling::tr[1]/td[1]"))
		String houseNumber = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='House number']/ancestor::tr/following-sibling::tr[1]/td[2]"))
		String street = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='Street']/ancestor::tr/following-sibling::tr[1]/td[3]"))
		String state = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='State, Province, or Region']/ancestor::tr/following-sibling::tr[1]/td[1]"))
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
		String state = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='State, Province, or Region']/ancestor::tr/following-sibling::tr[1]/td[1]"))
		String zipCode = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='ZIP Code']/ancestor::tr/following-sibling::tr[1]/td[2]"))
		String city = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='City']/ancestor::tr/following-sibling::tr[1]/td[3]"))
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

	public SendOfferPage verifyBillingAddress(List<String> expectedResult) {
		String fullName = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='Full Name']/ancestor::tr/following-sibling::tr[1]/td[1]"))
		String houseNumber = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='House number']/ancestor::tr/following-sibling::tr[1]/td[2]"))
		String street = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='Street']/ancestor::tr/following-sibling::tr[1]/td[3]"))
		String state = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='State, Province, or Region']/ancestor::tr/following-sibling::tr[1]/td[1]"))
		String zipCode = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='ZIP Code']/ancestor::tr/following-sibling::tr[1]/td[2]"))
		String city = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='City']/ancestor::tr/following-sibling::tr[1]/td[3]"))
		List<String> actualBillingAddress = [fullName, houseNumber, street, state, zipCode, city]
		println "actualBillingAddress: $actualBillingAddress"
		WebUI.verifyEqual(actualBillingAddress, expectedResult)
		return this
	}

	public SendOfferPage verifyShippingAddress(List<String> expectedResult) {
		String fullName = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='Full Name']/ancestor::tr/following-sibling::tr[1]/td[1]"))
		String houseNumber = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='House number']/ancestor::tr/following-sibling::tr[1]/td[2]"))
		String street = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='Street']/ancestor::tr/following-sibling::tr[1]/td[3]"))
		String state = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='State, Province, or Region']/ancestor::tr/following-sibling::tr[1]/td[1]"))
		String zipCode = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='ZIP Code']/ancestor::tr/following-sibling::tr[1]/td[2]"))
		String city = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='City']/ancestor::tr/following-sibling::tr[1]/td[3]"))
		List<String> actualShippingAddress = [fullName, houseNumber, street, state, zipCode, city]
		println "actualShippingAddress: $actualShippingAddress"
		WebUI.verifyEqual(actualShippingAddress, expectedResult)
		return this
	}
	
	public List<String> getTablePartReview(String partName) {
		String partNameCol = WebUI.getText(partCol(partName))
		String material = WebUI.getText(materialCol(partName))
		String quantity = WebUI.getAttribute(quantityCol(partName), "value")
		String unitPrice = WebUI.getText(unitPriceCol(partName))
		String totalPartPrice = WebUI.getText(partPriceTotalCol(partName))
		List<String> findTestObjects = findTestObjects("//*[@aria-label='message']")
		String CO2Emission = WebUI.getText(CO2EmissionCol(partName))
		String comment
		println "findTestObjects: $findTestObjects"
		if (findTestObjects.size() != 0) {
			WebUI.mouseOver(xpath("//*[@aria-label='message']"))
			comment = WebUI.getText(xpath("//*[@role='tooltip']/div[2]/div"))
		}
		else {
			comment = ""
		}
		List<String> actualResult = [partNameCol, material, quantity, unitPrice, totalPartPrice, comment, CO2Emission]
		println "getTablePartReview: $actualResult"
		return actualResult
	}

	public SendOfferPage verifyUISendOfferPageVisible(String partName) {
		//Customer
		WebUI.verifyElementVisible(xpath("//*[text()='Customer']"))
		WebUI.verifyElementVisible(xpath("//input[@id='email']"))

		//Billing address
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']/parent::div/following::div[1]//*[text()='Full Name']/parent::div/span[1]"))
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']/parent::div/following::div[1]//*[text()='House number']/parent::div/span[1]"))
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']/parent::div/following::div[1]//*[text()='Street']/parent::div/span[1]"))
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']/parent::div/following::div[1]//*[text()='State, Province, or Region']/parent::div/span[1]"))
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']/parent::div/following::div[1]//*[text()='ZIP Code']/parent::div/span[1]"))
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']/parent::div/following::div[1]//*[text()='City']/parent::div/span[1]"))

		//Shipping address
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']/parent::div/following::div[1]//*[text()='Full Name']/parent::div/span[1]"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']/parent::div/following::div[1]//*[text()='House number']/parent::div/span[1]"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']/parent::div/following::div[1]//*[text()='Street']/parent::div/span[1]"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']/parent::div/following::div[1]//*[text()='State, Province, or Region']/parent::div/span[1]"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']/parent::div/following::div[1]//*[text()='ZIP Code']/parent::div/span[1]"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']/parent::div/following::div[1]//*[text()='City']/parent::div/span[1]"))

		//button Edit address
		WebUI.verifyElementVisible(xpath("//*[@aria-label='edit']/parent::button"))

		//table information of part
		WebUI.verifyElementVisible(xpath("//*[@class='ant-table-thead']//th[text()='Part name']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-table-thead']//th[text()='Files']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-table-thead']//th[text()='Material']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-table-thead']//th[text()='Quantity']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-table-thead']//th[text()='Unit price']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-table-thead']//th[text()='Part Price Total']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-table-thead']//th[text()='CO2 Emission']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-table-thead']//th[text()='Action']"))
		//button more
		WebUI.verifyElementVisible(actionMore(partName))

		//Order summary
		WebUI.verifyElementVisible(xpath("//*[text()='Order Summary']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping options']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Packaging and Shipping Comments']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Total Part Price']"))
		List<String> findObject = findTestObjects("//*[text()='Surface Treatment Surcharge']")
		if (findObject.size() != 0) {
			WebUI.verifyElementVisible(xpath("//*[text()='Surface Treatment Surcharge']"))
			WebUI.mouseOver(xpath("//*[text()='Surface Treatment Surcharge']"))
			WebUI.verifyElementVisible(xpath("//*[text()='$expectedContentTooltips']"))
		}
		WebUI.verifyElementVisible(xpath("//*[text()='Express Surcharge']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Packaging Cost']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping costs']"))
		WebUI.verifyElementVisible(xpath("//*[text()='NET Total']"))
		WebUI.verifyElementVisible(xpath("//*[text()='VAT (19%)']"))
		WebUI.verifyElementVisible(xpath("//*[text()='GROSS Total']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Preview Offer']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Send Offer']"))

		//Content alert
		String alertContent = WebUI.getText(xpath("//*[@class='ant-alert-description']//li"))
		WebUI.verifyEqual(alertContent, expectedAlertContent)
		return this
	}
}
