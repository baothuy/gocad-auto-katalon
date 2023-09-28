package gocad.buyer

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import gocad.common.ManufacturingInformationPage
import katalon.fw.lib.BasePage
import katalon.utility.CommonUtility


public class CheckoutPage extends BasePage<CheckoutPage>{

	def partCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[2]")}
	def materialCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[4]")}
	def quantityCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[5]")}
	def unitPriceCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[6]")}
	def partPriceTotalCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[7]")}
	def CO2EmissionCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[9]")}
	def actionMore = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[10]//button")}
	def expectedContentTooltips = "Surchage to fulfill minimum order value and transport costs for surface treatment"
	def expectedAlertContent = "After the final approval of the offer by the seller, you will receive a confirmation via e-mail"

	public CheckoutPage clickCheckboxAgreeTermsAndConditions() {
		WebUI.click(xpath("//*[@id='agreeTermConditions']"))
		return this
	}

	public CheckoutPage clickFilePDFDownload() {
		WebUI.click(xpath("//*[text()='Preview Offer']"))
		return this
	}

	public CheckoutPage clickPlaceYourOrder() {
		WebUI.click(xpath("//*[text()='Place your order']"))
		return this
	}

	public CheckoutPage clickEditAddress() {
		WebUI.click(xpath("//*[@aria-label='edit']/parent::button"))
		return this
	}

	public CheckoutPage clickMoreOption(String partName) {
		WebUI.click(actionMore(partName))
		return this
	}

	public CheckoutPage clickView() {
		WebUI.click(xpath("//*[contains(text(),'View')]"))
		return this
	}

	public CheckoutPage clickCopy() {
		WebUI.click(xpath("//*[contains(text(),'Copy')]"))
		return this
	}

	public CheckoutPage selectDeliveryOption(String deliveryOption) {
		WebUI.click(xpath("//input[@id='deliveryOption']/parent::span/parent::div"))
		WebUI.click(xpath("//div[contains(@class, 'ant-select-item') and contains(@title,'$deliveryOption')]"))
		return this
	}

	public CheckoutPage selectShippingOption(String shippingOptions) {
		WebUI.click(xpath("//input[@id='shippingOption']/parent::span/parent::div"))
		WebUI.click(xpath("//div[contains(@class, 'ant-select-item') and contains(@title,'$shippingOptions')]"))
		return this
	}

	public CheckoutPage inputPackagingAndShippingComments(String text) {
		WebUI.setText(xpath("//textarea[@id='shippingComment']"), text)
		return this
	}

	public CheckoutPage verifyMaterial(String partName, String expectedResult) {
		String actualResult = WebUI.getText(materialCol(partName))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CheckoutPage verifyQuantity(String partName, String expectedResult) {
		String actualResult = WebUI.getText(quantityCol(partName))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CheckoutPage verifyUnitPrice(String partName, String expectedResult) {
		String actualResult = WebUI.getText(unitPriceCol(partName))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CheckoutPage verifyPartPriceTotal(String partName, String expectedResult) {
		String actualResult = WebUI.getText(partPriceTotalCol(partName))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CheckoutPage verifyCO2EmissionCol(String partName, String expectedResult) {
		String actualResult = WebUI.getText(CO2EmissionCol(partName))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CheckoutPage verifyProcessReviewtHighLighted() {
		String colorTwo = WebUI.getCSSValue(xpath("//div[text()='Checkout']/parent::div/preceding-sibling::div//*[text()='4']"), "background")
		String pattern = /(rgb\(\d+,\s*\d+,\s*\d+\))/
		String rgbValue = CommonUtility.substringUseRegExp(colorTwo, pattern,1)
		String rgbToHex = CommonUtility.rgbToHex(rgbValue)
		WebUI.verifyEqual(rgbToHex, "#FFCB3D")
		return this
	}

	public CheckoutPage verifyUICheckoutVisible(String partName) {
		//Company name
		WebUI.verifyElementVisible(xpath("//*[text()='Company Name']"))

		//Billing address
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']/parent::div/following::div[1]//*[text()='Full name']/parent::div/span[1]"))
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']/parent::div/following::div[1]//*[text()='House number']/parent::div/span[1]"))
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']/parent::div/following::div[1]//*[text()='Street']/parent::div/span[1]"))
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']/parent::div/following::div[1]//*[text()='State']/parent::div/span[1]"))
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']/parent::div/following::div[1]//*[text()='ZIP Code']/parent::div/span[1]"))
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']/parent::div/following::div[1]//*[text()='City']/parent::div/span[1]"))

		//Shipping address
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']/parent::div/following::div[1]//*[text()='Full name']/parent::div/span[1]"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']/parent::div/following::div[1]//*[text()='House number']/parent::div/span[1]"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']/parent::div/following::div[1]//*[text()='Street']/parent::div/span[1]"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']/parent::div/following::div[1]//*[text()='State']/parent::div/span[1]"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']/parent::div/following::div[1]//*[text()='ZIP Code']/parent::div/span[1]"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']/parent::div/following::div[1]//*[text()='City']/parent::div/span[1]"))

		//button Edit address
		WebUI.verifyElementVisible(xpath("//*[@aria-label='edit']/parent::button"))

		//label Automatically calculated
		WebUI.verifyElementVisible(xpath("//*[text()='Automatically calculated']"))

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
		WebUI.verifyElementVisible(xpath("//*[text()='Delivery Option']"))
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
		WebUI.verifyElementVisible(xpath("//*[text()='I agree with the Terms and Conditions and the privacy settings']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Place your order']"))

		//Content alert
		String alertContent = WebUI.getText(xpath("//*[@class='ant-alert-description']//li"))
		WebUI.verifyEqual(alertContent, expectedAlertContent)
		return this
	}

	public String getDeliveryDate() {
		String deliveryOption = WebUI.getText(xpath("//input[@id='deliveryOption']/parent::span/following-sibling::span"))
		String regex = "\\d{2}/\\d{2}/\\d{4}"
		def dateMatch = deliveryOption =~ regex
		String extractedDate = dateMatch[0]
		return extractedDate
	}

	public String getDeliveryOption() {
		String text = WebUI.getText(xpath("//input[@id='deliveryOption']/parent::span/following-sibling::span"))
		String deliveryOption = text.split('-')[0].trim()
		return deliveryOption
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
		String companyName = WebUI.getText(xpath("//*[text()='Company Name']/ancestor::div[@class='row']/div[2]"))
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

	//Billing Address
	public CheckoutPage verifyBillingAddress(List<String> listBillingAddressExpected) {
		String fullName = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following::div[1]//*[text()='Full name']/parent::div/span[2]"))
		String houseNumber = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following::div[1]//*[text()='House number']/parent::div/span[2]"))
		String street = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following::div[1]//*[text()='Street']/parent::div/span[2]"))
		String state = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following::div[1]//*[text()='State']/parent::div/span[2]"))
		String zipCode = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following::div[1]//*[text()='ZIP Code']/parent::div/span[2]"))
		String city = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following::div[1]//*[text()='City']/parent::div/span[2]"))
		List<String> billingAddressActual = [fullName, houseNumber, street, state, zipCode, city]
		WebUI.verifyEqual(billingAddressActual, listBillingAddressExpected)
		return this
	}
	//Shipping Address
	public CheckoutPage verifyShippingAddress(List<String> listShippingAddress) {
		String fullName = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following::div[1]//*[text()='Full name']/parent::div/span[2]"))
		String houseNumber = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following::div[1]//*[text()='House number']/parent::div/span[2]"))
		String street = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following::div[1]//*[text()='Street']/parent::div/span[2]"))
		String state = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following::div[1]//*[text()='State']/parent::div/span[2]"))
		String zipCode = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following::div[1]//*[text()='ZIP Code']/parent::div/span[2]"))
		String city = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following::div[1]//*[text()='City']/parent::div/span[2]"))
		List<String> shippingAddressActual = [fullName, houseNumber, street, state, zipCode, city]
		WebUI.verifyEqual(shippingAddressActual, listShippingAddress)
		return this
	}
}
