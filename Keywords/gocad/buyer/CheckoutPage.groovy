package gocad.buyer

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import katalon.fw.lib.BasePage
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

public class CheckoutPage extends BasePage<CheckoutPage>{

	def partCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[2]")}
	def materialCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[4]")}
	def quantityCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[5]")}
	def unitPriceCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[6]")}
	def partPriceTotalCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[7]")}
	def CO2EmissionCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[9]")}
	def actionView = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[10]")}
	def actionMore = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[10]//button")}

	public CheckoutPage clickCheckboxAgreeTermsAndConditions() {
		WebUI.click(xpath('//*[@id="agreeTermConditions"]'))
		return this
	}

	public CheckoutPage clickPlaceYourOrder() {
		WebUI.click(xpath('//*[text()="Place your order"]'))
		return this
	}

	public CheckoutPage selectDeliveryOption(String deliveryOption) {
		WebUI.click(xpath("//input[@id='deliveryOption']/parent::span/parent::div"))
		WebUI.click(xpath("//div[contains(@class, 'ant-select-item') and @title='$deliveryOption']"))
		return this
	}
	
	public CheckoutPage selectShippingOption(String shippingOptions) {
		WebUI.click(xpath("//input[@id='shippingOption']/parent::span/parent::div"))
		WebUI.click(xpath("//div[contains(@class, 'ant-select-item') and @title='$shippingOptions']"))
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

	public ReviewPage verifyMaterial(String partName, String expectedResult) {
		String actualResult = WebUI.getText(materialCol(partName))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ReviewPage verifyQuantity(String partName, String expectedResult) {
		String actualResult = WebUI.getText(quantityCol(partName))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ReviewPage verifyUnitPrice(String partName, String expectedResult) {
		String actualResult = WebUI.getText(unitPriceCol(partName))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ReviewPage verifyPartPriceTotal(String partName, String expectedResult) {
		String actualResult = WebUI.getText(partPriceTotalCol(partName))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ReviewPage verifyCO2EmissionCol(String partName, String expectedResult) {
		String actualResult = WebUI.getText(CO2EmissionCol(partName))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public String getNetTotal() {
		String netTotal = WebUI.getText(xpath("//*[text()='NET Total']/following-sibling::label"))
		return netTotal
	}

	public String getGrossTotal() {
		String netTotal = WebUI.getText(xpath("//*[text()='GROSS Total']/following-sibling::label"))
		return netTotal
	}
}
