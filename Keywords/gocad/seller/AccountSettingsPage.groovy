package gocad.seller
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import katalon.fw.lib.BasePage


public class AccountSettingsPage extends BasePage<AccountSettingsPage>{

	public String getCompanyName() {
		String companyName = WebUI.getAttribute(xpath("//*[@id='basic_companyName']"), 'value')
		return companyName
	}

	public AccountSettingsPage clickSaveChangesButton() {
		WebUI.click(xpath("//span[text()='Save Changes']"))
		return this
	}

	public AccountSettingsPage inputFirstNameContact(String input) {
		clearTextAndSendKeysByActions(id("basic_firstName"), input)
		return this
	}

	public AccountSettingsPage inputLastNameContact(String input){
		clearTextAndSendKeysByActions(id("basic_lastName"), input)
		return this
	}

	public AccountSettingsPage inputGenderContact(String input){
		WebUI.click(xpath("//span[text()='$input']"))
		return this
	}

	public AccountSettingsPage inputCompanyNameContact(String input){
		clearTextAndSendKeysByActions(id("basic_companyName"), input)
		return this
	}

	public AccountSettingsPage inputPhoneContact(String input){
		clearTextAndSendKeysByActions(id("basic_phone"), input)
		return this
	}

	public AccountSettingsPage inputFaxContact(String input){
		clearTextAndSendKeysByActions(id("basic_fax"), input)
		return this
	}

	public AccountSettingsPage inputWebsiteContact(String input){
		clearTextAndSendKeysByActions(id("basic_website"), input)
		return this
	}

	public AccountSettingsPage inputFirstNameBillingAddress(String input){
		clearTextAndSendKeysByActions(id("basic_billingAddress_firstName"), input)
		return this
	}

	public AccountSettingsPage inputLastNameBillingAddress(String input){
		clearTextAndSendKeysByActions(id("basic_billingAddress_lastName"), input)
		return this
	}

	public AccountSettingsPage inputEmailBillingAddress(String input){
		clearTextAndSendKeysByActions(id("basic_billingAddress_email"), input)
		return this
	}

	public AccountSettingsPage inputPhoneBillingAddress(String input){
		clearTextAndSendKeysByActions(id("basic_billingAddress_phone"), input)
		return this
	}

	public AccountSettingsPage inputStreetBillingAddress(String input){
		clearTextAndSendKeysByActions(id("basic_billingAddress_streetName"), input)
		return this
	}

	public AccountSettingsPage inputHouseNumberBillingAddress(String input){
		clearTextAndSendKeysByActions(id("basic_billingAddress_houseNumber"), input)
		return this
	}

	public AccountSettingsPage selectStateBillingAddress(String input){
		clearTextAndSendKeysByActions(xpath("//*[@class='sub-l' and text()='Billing Address']/parent::div/div[@class='row']/div[9]//input"), input)
		WebUI.click(xpath("//*[@class='rc-virtual-list']//div[@title='$input']"))
		return this
	}

	public AccountSettingsPage inputZIPCodeBillingAddress(String input){
		clearTextAndSendKeysByActions(id("basic_billingAddress_postCode"), input)
		return this
	}

	public AccountSettingsPage selectCityBillingAddress(String input){
		clearTextAndSendKeysByActions(xpath("//*[@class='sub-l' and text()='Billing Address']/parent::div/div[@class='row']/div[10]//input"), input)
		WebUI.click(xpath("//*[@class='rc-virtual-list']//div[@title='$input']"))
		return this
	}

	public AccountSettingsPage selectCountryBillingAddress(String input){
		List<String> findObject = findTestObjects("//*[@class='sub-l' and text()='Billing Address']/parent::div/div[@class='row']/div[8]//span[@class='ant-select-selection-item']")
		(findObject.size() != 0) ? WebUI.click(xpath("//*[@class='sub-l' and text()='Billing Address']/parent::div/div[@class='row']/div[8]//span[@class='ant-select-selection-item']")) : WebUI.click(xpath("//*[@class='sub-l' and text()='Billing Address']/parent::div/div[@class='row']//input[@id='billingAddress_country']/parent::span"))
		clearTextAndSendKeysByActions(xpath("//*[@class='sub-l' and text()='Billing Address']/parent::div/div[@class='row']/div[8]//input"), input)
		WebUI.click(xpath("//*[@class='rc-virtual-list']//div[@title='$input']"))
		return this
	}

	public AccountSettingsPage verifyUIAccountVisible() {
		//button account
		WebUI.verifyElementVisible(xpath("//span[text()='Account']"))
		//contact person
		WebUI.verifyElementVisible(xpath("//*[text()='Contact info']"))
		WebUI.verifyElementVisible(xpath("//*[@id='basic_firstName']"))
		WebUI.verifyElementVisible(xpath("//*[@id='basic_lastName']"))
		//contact info
		WebUI.verifyElementVisible(xpath("//*[text()='Contact info']"))
		WebUI.verifyElementVisible(xpath("//span[text()='Male']"))
		WebUI.verifyElementVisible(xpath("//span[text()='Female']"))
		WebUI.verifyElementVisible(xpath("//*[@id='basic_companyName']"))
		WebUI.verifyElementVisible(xpath("//*[@id='basic_phone']"))
		WebUI.verifyElementVisible(xpath("//*[@id='basic_fax']"))
		//billing address
		WebUI.verifyElementVisible(xpath("//*[@id='basic_billingAddress_firstName']"))
		WebUI.verifyElementVisible(xpath("//*[@id='basic_billingAddress_lastName']"))
		WebUI.verifyElementVisible(xpath("//*[@id='basic_billingAddress_email']"))
		WebUI.verifyElementVisible(xpath("//*[@id='basic_billingAddress_phone']"))
		WebUI.verifyElementVisible(xpath("//*[@id='basic_billingAddress_streetName']"))
		WebUI.verifyElementVisible(xpath("//*[@id='basic_billingAddress_houseNumber']"))
		WebUI.verifyElementVisible(xpath("//*[@id='basic_billingAddress_country']"))
		WebUI.verifyElementVisible(xpath("//*[@id='basic_billingAddress_state']"))
		WebUI.verifyElementVisible(xpath("//*[@id='basic_billingAddress_city']"))
		WebUI.verifyElementVisible(xpath("//*[@id='basic_billingAddress_postCode']"))

		//button save change
		WebUI.verifyElementVisible(xpath("//span[text()='Save Changes']"))
		return this
	}

	//Billing Address
	public AccountSettingsPage verifyFirstNameBillingAddressValue(String expectedResult){
		String actualResult = WebUI.getAttribute(id("basic_billingAddress_firstName"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public AccountSettingsPage verifyLastNameBillingAddressValue(String expectedResult){
		String actualResult = WebUI.getAttribute(id("basic_billingAddress_lastName"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public AccountSettingsPage verifyEmailBillingAddressValue(String expectedResult){
		String actualResult = WebUI.getAttribute(id("basic_billingAddress_email"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public AccountSettingsPage verifyPhoneBillingAddressValue(String expectedResult){
		String actualResult = WebUI.getAttribute(id("basic_billingAddress_phone"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public AccountSettingsPage verifyStreetBillingAddressValue(String expectedResult){
		String actualResult = WebUI.getAttribute(id("basic_billingAddress_streetName"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public AccountSettingsPage verifyHouseNumberBillingAddressValue(String expectedResult){
		String actualResult = WebUI.getAttribute(id("basic_billingAddress_houseNumber"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public AccountSettingsPage verifyStateBillingAddressValue(String expectedResult){
		String actualResult = WebUI.getAttribute(xpath("//*[@class='sub-l' and text()='Billing Address']/parent::div/div[@class='row']/div[9]//input"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public AccountSettingsPage verifyZIPCodeBillingAddressValue(String expectedResult){
		String actualResult = WebUI.getAttribute(id("basic_billingAddress_postCode"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public AccountSettingsPage verifyCityBillingAddressValue(String expectedResult){
		String actualResult = WebUI.getAttribute(xpath("//*[@class='sub-l' and text()='Billing Address']/parent::div/div[@class='row']/div[10]//input"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public AccountSettingsPage verifyCountryBillingAddressValue(String expectedResult){
		String actualResult = WebUI.getAttribute(xpath("//*[@class='sub-l' and text()='Billing Address']/parent::div/div[@class='row']/div[8]//span[@class='ant-select-selection-item']"), "title")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	//Contact
	public AccountSettingsPage verifyFirstNameContactValue(String expectedResult){
		String actualResult = WebUI.getAttribute(id("basic_firstName"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public AccountSettingsPage verifyLastNameContactValue(String expectedResult){
		String actualResult = WebUI.getAttribute(id("basic_lastName"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public AccountSettingsPage verifyGenderContactValue(String expectedResult){
		String actualResult = WebUI.getAttribute(xpath("//*[@class='ant-radio-button ant-radio-button-checked']/input"), "value")
		def titleCaseActualResult = actualResult.split(" ").collect { it.toLowerCase().capitalize() }.join(" ")
		WebUI.verifyEqual(titleCaseActualResult, expectedResult)
		return this
	}

	public AccountSettingsPage verifyCompanyNameContactValue(String expectedResult){
		String actualResult = WebUI.getAttribute(id("basic_companyName"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public AccountSettingsPage verifyPhoneContactValue(String expectedResult){
		String actualResult = WebUI.getAttribute(id("basic_phone"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public AccountSettingsPage verifyFaxContactValue(String expectedResult){
		String actualResult = WebUI.getAttribute(id("basic_fax"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public AccountSettingsPage verifyWebsiteContactValue(String expectedResult){
		String actualResult = WebUI.getAttribute(id("basic_website"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	//contact verify error
	public AccountSettingsPage verifyShowErrorWhenFirstNameContactEmpty() {
		String firstName = WebUI.getText(xpath("//*[@id='basic_firstName_help']/div"))
		String expectedResult = "Firstname is required."
		WebUI.verifyEqual(firstName, expectedResult)
		return this
	}

	public AccountSettingsPage verifyShowErrorWhenLastNameContactEmpty() {
		String lastName = WebUI.getText(xpath("//*[@id='basic_lastName_help']/div"))
		String expectedResult = "Lastname is required."
		WebUI.verifyEqual(lastName, expectedResult)
		return this
	}

	public AccountSettingsPage verifyShowErrorWhenCompanyNameContactEmpty() {
		String lastName = WebUI.getText(xpath("//*[@id='basic_companyName_help']/div"))
		String expectedResult = "Company is required."
		WebUI.verifyEqual(lastName, expectedResult)
		return this
	}

	//billing address verify error
	public AccountSettingsPage verifyShowErrorWhenFirstNameBillingAddressEmpty() {
		String firstName = WebUI.getText(xpath("//*[@id='basic_billingAddress_firstName_help']/div"))
		String expectedResult = "Firstname is required."
		WebUI.verifyEqual(firstName, expectedResult)
		return this
	}

	public AccountSettingsPage verifyShowErrorWhenLastNameBillingAddressEmpty() {
		String lastName = WebUI.getText(xpath("//*[@id='basic_billingAddress_lastName_help']/div"))
		String expectedResult = "Lastname is required."
		WebUI.verifyEqual(lastName, expectedResult)
		return this
	}

	public AccountSettingsPage verifyShowErrorWhenHouseNumberBillingAddressEmpty() {
		String houseNumber = WebUI.getText(xpath("//*[@id='basic_billingAddress_houseNumber_help']/div"))
		String expectedResult = "House number is required."
		WebUI.verifyEqual(houseNumber, expectedResult)
		return this
	}

	public AccountSettingsPage verifyShowErrorWhenStreetBillingAddressEmpty() {
		String street = WebUI.getText(xpath("//*[@id='basic_billingAddress_streetName_help']/div"))
		String expectedResult = "Street is required."
		WebUI.verifyEqual(street, expectedResult)
		return this
	}

	public AccountSettingsPage verifyShowErrorWhenZIPCodeBillingAddressEmpty() {
		String zipCode = WebUI.getText(xpath("//*[@id='basic_billingAddress_postCode_help']/div"))
		String expectedResult = "ZIP Code is required."
		WebUI.verifyEqual(zipCode, expectedResult)
		return this
	}

	public AccountSettingsPage verifyShowErrorWhenCityBillingAddressEmpty() {
		String city = WebUI.getText(xpath("//*[@id='basic_billingAddress_city_help']/div"))
		String expectedResult = "City is required."
		WebUI.verifyEqual(city, expectedResult)
		return this
	}
}
