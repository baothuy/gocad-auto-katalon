package gocad.buyer

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.DecimalFormat

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import katalon.fw.lib.BasePage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility
import katalon.utility.DateTimeUtility
import katalon.utility.FunctionCommon


public class CheckoutPage extends BasePage<CheckoutPage>{

	def partCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[2]")}
	def materialCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[4]")}
	def quantityCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[6]")}
	def unitPriceCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[7]")}
	def partPriceTotalCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[8]")}
	def CO2EmissionCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[10]")}
	def actionMore = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[11]//button")}
	def expectedContentTooltips = "Surchage to fulfill minimum order value and transport costs for surface treatment"
	def expectedAlertContent = "After the final approval of the offer by the seller, you will receive a confirmation via e-mail"
	def tooltipsSurchargeMinimumPrice = "In our shop, the minimum order value is 80 € (250 € for FAST delivery) on the overall basket size, excluding packaging and delivery cost."

	public CheckoutPage clickCheckboxAgreeTermsAndConditions() {
		WebUI.click(xpath("//*[@id='agreeTermConditions']"))
		return this
	}

	public CheckoutPage clickPreviewOfferToDownload() {
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
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']/following-sibling::div[@class='row']//input[@id='billingAddress_firstName']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']/following-sibling::div[@class='row']//input[@id='billingAddress_lastName']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']/following-sibling::div[@class='row']//input[@id='billingAddress_houseNumber']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']/following-sibling::div[@class='row']//input[@id='billingAddress_streetName']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']/following-sibling::div[@class='row']//input[@id='billingAddress_state']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']/following-sibling::div[@class='row']//input[@id='billingAddress_country']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']/following-sibling::div[@class='row']//input[@id='billingAddress_postCode']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']/following-sibling::div[@class='row']//input[@id='billingAddress_city']"))

		//Shipping address
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']/following-sibling::div[@class='row']//input[@id='shippingAddress_firstName']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']/following-sibling::div[@class='row']//input[@id='shippingAddress_lastName']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']/following-sibling::div[@class='row']//input[@id='shippingAddress_houseNumber']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']/following-sibling::div[@class='row']//input[@id='shippingAddress_streetName']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']/following-sibling::div[@class='row']//input[@id='shippingAddress_state']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']/following-sibling::div[@class='row']//input[@id='shippingAddress_country']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']/following-sibling::div[@class='row']//input[@id='shippingAddress_postCode']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']/following-sibling::div[@class='row']//input[@id='shippingAddress_city']"))				

		//checkbox address
		WebUI.verifyElementVisible(xpath("//span[text()='The shipping address is the same as my billing address']"))

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
		WebUI.verifyElementVisible(xpath("//*[text()='GROSS Total']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Preview Offer']"))
		WebUI.verifyElementPresent(xpath("//*[@id='agreeTermConditions']"),5)
		WebUI.verifyElementPresent(xpath("//*[text()='Place your order']"),5)

		//Content alert
		String alertContent = WebUI.getText(xpath("//*[@class='ant-alert-description']//li"))
		WebUI.verifyEqual(alertContent, expectedAlertContent)
		return this
	}

	public String getDeliveryDate() {
		String deliveryOption = WebUI.getText(xpath("//input[@id='deliveryOption']/parent::span/following-sibling::span"))
		def dateMatch = (deliveryOption =~ /-(\s*(\d+)\s*)/)
		def extractedNumberWorkingDays = (dateMatch[0][2]) as int
		println "extractedDays: $extractedNumberWorkingDays"
		String deliveryDate = DateTimeUtility.getDeliveryWorkingDate(extractedNumberWorkingDays)
		return deliveryDate
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
		String companyName = WebUI.getText(xpath("//*[text()='Company Name']/ancestor::div[@class='row mb-2']/div[2]"))
		return companyName
	}

	//Billing Address
	public List<String> getBillingAddress() {
		List<String> billingAddress = Page.nav(FunctionCommon).getBillingAddressCheckoutPage()
		return billingAddress
	}
	//Shipping Address
	public List<String> getShippingAddress() {
		List<String> shippingAddress = Page.nav(FunctionCommon).getShippingAddressCheckoutPage()
		return shippingAddress
	}

	public List<String> getOrderSummary() {
		List<String> orderSummary = Page.nav(FunctionCommon).getOrderSummary()
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

	public CheckoutPage verifyBillingAddress(List<String> expectedResult) {
		List<String> actualBillingAddress = Page.nav(FunctionCommon).getBillingAddress()
		println "actualBillingAddress: $actualBillingAddress"
		WebUI.verifyEqual(actualBillingAddress, expectedResult)
		return this
	}

	public CheckoutPage verifyShippingAddress(List<String> expectedResult) {
		List<String> actualShippingAddress = Page.nav(FunctionCommon).getShippingAddress()
		println "actualShippingAddress: $actualShippingAddress"
		WebUI.verifyEqual(actualShippingAddress, expectedResult)
		return this
	}

	public CheckoutPage verifySurchargeForMinimumOrderValue(String totalPartPrice, String surfaceTreatmentPrice) {
		String actualSurcharge = WebUI.getText(xpath("//label[text()='Surcharge for minimum order value']/following-sibling::label"))
		def decimalFormat = new DecimalFormat("###,##0.00")
		def numberTotalPartPrice = totalPartPrice.replace(" $GlobalVariable.currency", "").replaceAll(/[^\d.,]/, '').replace('.', '').replace(',', '.').toDouble()
		def numberSurfaceTreatmentPrice = (surfaceTreatmentPrice == "") ? "0".toDouble() : surfaceTreatmentPrice.replace(" $GlobalVariable.currency", "").replaceAll(/[^\d.,]/, '').replace('.', '').replace(',', '.').toDouble()
		def expectedSurcharge = 80 - numberTotalPartPrice - numberSurfaceTreatmentPrice
		String convertExpectedSurcharge = decimalFormat.format(expectedSurcharge).replace('.', ',') + " $GlobalVariable.currency"
		WebUI.verifyEqual(actualSurcharge, convertExpectedSurcharge)
		return this
	}

	public CheckoutPage verifySurchargeTooltipsVisible() {
		WebUI.mouseOver(xpath("//label[text()='Surcharge for minimum order value']/span"))
		WebUI.verifyElementVisible(xpath("//*[text()='$tooltipsSurchargeMinimumPrice']"))
		return this
	}
}
