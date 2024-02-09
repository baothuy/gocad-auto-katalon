package gocad.buyer

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage
import katalon.fw.lib.Page
import katalon.utility.FunctionCommon


public class AccountSettingsPage extends BasePage<AccountSettingsPage>{

	//Contact
	public AccountSettingsPage inputFirstNameContact(String input){
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

	//Addition infor
	public AccountSettingsPage inputVATNumber(String input){
		clearTextAndSendKeysByActions(id("basic_vatId"), input)
		return this
	}

	//Billing Address
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

	public AccountSettingsPage inputSearchBillingAddress(String houseNumber, String street, String city, String zipCode, String country){
		String address = Page.nav(FunctionCommon).formatAddress(houseNumber, street, city, zipCode, country)
		clearTextAndSendKeysByActions(xpath("//*[@id='billingAddress']//input[@name='billingAddress_searchAddress']"), address)
		WebUI.click(xpath("//*[@class='rc-virtual-list']//div[text()='$address']/span"))
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
		clearTextAndSendKeysByActions(id("basic_billingAddress_state"), input)
		WebUI.click(xpath("//*[@class='rc-virtual-list']//div[@title='$input']"))
		return this
	}

	public AccountSettingsPage inputZIPCodeBillingAddress(String input){
		clearTextAndSendKeysByActions(id("basic_billingAddress_postCode"), input)
		return this
	}

	public AccountSettingsPage selectCityBillingAddress(String input){
		clearTextAndSendKeysByActions(id("basic_billingAddress_city"), input)
		WebUI.click(xpath("//*[@class='rc-virtual-list']//div[@title='$input']"))
		return this
	}

	public AccountSettingsPage selectCountryBillingAddress(String input){
		clearTextAndSendKeysByActions(id("basic_billingAddress_country"), input)
		WebUI.click(xpath("//*[@class='rc-virtual-list']//div[@title='$input']"))
		return this
	}

	//Shipping Address
	public AccountSettingsPage inputFirstNameShippingAddress(String input){
		clearTextAndSendKeysByActions(id("basic_shippingAddress_firstName"), input)
		return this
	}

	public AccountSettingsPage inputLastNameShippingAddress(String input){
		clearTextAndSendKeysByActions(id("basic_shippingAddress_lastName"), input)
		return this
	}

	public AccountSettingsPage inputEmailShippingAddress(String input){
		clearTextAndSendKeysByActions(id("basic_shippingAddress_email"), input)
		return this
	}

	public AccountSettingsPage inputPhoneShippingAddress(String input){
		clearTextAndSendKeysByActions(id("basic_shippingAddress_phone"), input)
		return this
	}

	public AccountSettingsPage inputSearchShippingAddress(String houseNumber, String street, String city, String zipCode, String country){
		String address = Page.nav(FunctionCommon).formatAddress(houseNumber, street, city, zipCode, country)
		clearTextAndSendKeysByActions(xpath("//*[@id='shippingAddress']//input[@name='shippingAddress_searchAddress']"), address)
		WebUI.click(xpath("//*[@class='rc-virtual-list']//div[text()='$address']/span"))
		return this
	}

	public AccountSettingsPage inputStreetShippingAddress(String input){
		clearTextAndSendKeysByActions(id("basic_shippingAddress_streetName"), input)
		return this
	}

	public AccountSettingsPage inputHouseNumberShippingAddress(String input){
		clearTextAndSendKeysByActions(id("basic_shippingAddress_houseNumber"), input)
		return this
	}

	public AccountSettingsPage selectStateShippingAddress(String input){
		clearTextAndSendKeysByActions(id("basic_shippingAddress_state"), input)
		WebUI.click(xpath("//*[@id='basic_shippingAddress_state_list']/following::*[@class='rc-virtual-list']//div[@title='$input']"))
		return this
	}

	public AccountSettingsPage inputZIPCodeShippingAddress(String input){
		clearTextAndSendKeysByActions(id("basic_shippingAddress_postCode"), input)
		return this
	}

	public AccountSettingsPage selectCityShippingAddress(String input){
		clearTextAndSendKeysByActions(id("basic_shippingAddress_city"), input)
		WebUI.click(xpath("//*[@id='basic_shippingAddress_city_list']/following::*[@class='rc-virtual-list']//div[@title='$input']"))
		return this
	}

	public AccountSettingsPage selectCountryShippingAddress(String input){
		clearTextAndSendKeysByActions(id("basic_shippingAddress_country"), input)
		WebUI.click(xpath("//*[@id='basic_shippingAddress_country_list']/following::*[@class='rc-virtual-list']//div[@title='$input']"))
		return this
	}

	public AccountSettingsPage clickChangePasswordButton() {
		WebUI.click(xpath("//span[text()='Change password']"))
		return this
	}

	public AccountSettingsPage clickSaveChangesButton() {
		WebUI.click(xpath("//span[text()='Save Changes']"))
		return this
	}

	public String getCompanyName() {
		String companyName = WebUI.getAttribute(xpath("//*[@id='basic_companyName']"), 'value')
		return companyName
	}

	public List<String> getBillingAddress() {
		List<String> billingAddress = Page.nav(FunctionCommon).getBillingAddressAccountSettings()
		return billingAddress
	}

	public List<String> getShippingAddress() {
		List<String> shippingAddress = Page.nav(FunctionCommon).getShippingAddressAccountSettings()
		return shippingAddress
	}

	public List<String> getCustomerInfo() {
		String firstName = WebUI.getAttribute(xpath("//*[@id='basic_firstName']"), 'value')
		String lastName = WebUI.getAttribute(xpath("//*[@id='basic_lastName']"), 'value')
		String name = (firstName + " " + lastName).replace(",", "")
		String email = WebUI.getAttribute(xpath("//*[@class='truncate']"), 'title')
		String phone = WebUI.getAttribute(xpath("//*[@id='basic_phone']"), 'value')
		String companyName = WebUI.getAttribute(xpath("//*[@id='basic_companyName']"), 'value')
		List<String> customerInfo = [
			name,
			email,
			phone,
			companyName
		]
		return customerInfo
	}

	public AccountSettingsPage verifyToastMessageWhenChangePassword() {
		def actualTitle = WebUI.getText(xpath("//*[@class='ant-notification-notice-message']"))
		def actualMessage = WebUI.getText(xpath("//*[@class='ant-notification-notice-description']"))
		def expectedTitle = "Success!"
		def expectedMessage = "Password is changed!"
		WebUI.verifyEqual(actualTitle, expectedTitle)
		WebUI.verifyEqual(actualMessage, expectedMessage)
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

	//Shipping address
	public AccountSettingsPage verifyShowErrorWhenFirstNameShippingAddressEmpty() {
		String firstName = WebUI.getText(xpath("//*[@id='basic_shippingAddress_firstName_help']/div"))
		String expectedResult = "Firstname is required."
		WebUI.verifyEqual(firstName, expectedResult)
		return this
	}

	public AccountSettingsPage verifyShowErrorWhenLastNameShippingAddressEmpty() {
		String lastName = WebUI.getText(xpath("//*[@id='basic_shippingAddress_lastName_help']/div"))
		String expectedResult = "Lastname is required."
		WebUI.verifyEqual(lastName, expectedResult)
		return this
	}

	public AccountSettingsPage verifyShowErrorWhenHouseNumberShippingAddressEmpty() {
		String houseNumber = WebUI.getText(xpath("//*[@id='basic_shippingAddress_houseNumber_help']/div"))
		String expectedResult = "House number is required."
		WebUI.verifyEqual(houseNumber, expectedResult)
		return this
	}

	public AccountSettingsPage verifyShowErrorWhenStreetShippingAddressEmpty() {
		String street = WebUI.getText(xpath("//*[@id='basic_shippingAddress_streetName_help']/div"))
		String expectedResult = "Street is required."
		WebUI.verifyEqual(street, expectedResult)
		return this
	}

	public AccountSettingsPage verifyShowErrorWhenZIPCodeShippingAddressEmpty() {
		String zipCode = WebUI.getText(xpath("//*[@id='basic_shippingAddress_postCode_help']/div"))
		String expectedResult = "ZIP Code is required."
		WebUI.verifyEqual(zipCode, expectedResult)
		return this
	}

	public AccountSettingsPage verifyShowErrorWhenCityShippingAddressEmpty() {
		String city = WebUI.getText(xpath("//*[@id='basic_shippingAddress_city_help']/div"))
		String expectedResult = "City is required."
		WebUI.verifyEqual(city, expectedResult)
		return this
	}

	public AccountSettingsPage verifyUIVisible() {
		//button account
		WebUI.verifyElementVisible(xpath("//span[text()='Account']"))
		//contact person
		WebUI.verifyElementVisible(xpath("//*[text()='Contact person']"))
		WebUI.verifyElementVisible(xpath("//*[@id='basic_firstName']"))
		WebUI.verifyElementVisible(xpath("//*[@id='basic_lastName']"))
		WebUI.verifyElementVisible(xpath("//span[text()='Change password']"))
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
		WebUI.verifyElementVisible(id("basic_billingAddress_country"))
		WebUI.verifyElementVisible(xpath("//*[@id='basic_billingAddress_postCode']"))
		WebUI.verifyElementVisible(xpath("//*[@id='basic_billingAddress_city']"))
		WebUI.verifyElementVisible(id("basic_billingAddress_state"))
		//shipping address
		WebUI.verifyElementVisible(xpath("//*[@id='basic_shippingAddress_firstName']"))
		WebUI.verifyElementVisible(xpath("//*[@id='basic_shippingAddress_lastName']"))
		WebUI.verifyElementVisible(xpath("//*[@id='basic_shippingAddress_email']"))
		WebUI.verifyElementVisible(xpath("//*[@id='basic_shippingAddress_phone']"))
		WebUI.verifyElementVisible(xpath("//*[@id='basic_shippingAddress_streetName']"))
		WebUI.verifyElementVisible(xpath("//*[@id='basic_shippingAddress_houseNumber']"))
		WebUI.verifyElementVisible(id("basic_shippingAddress_country"))
		WebUI.verifyElementVisible(xpath("//*[@id='basic_shippingAddress_postCode']"))
		WebUI.verifyElementVisible(xpath("//*[@id='basic_shippingAddress_city']"))
		WebUI.verifyElementVisible(id("basic_shippingAddress_state"))
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
		String actualResult = WebUI.getAttribute(id("basic_billingAddress_state"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public AccountSettingsPage verifyZIPCodeBillingAddressValue(String expectedResult){
		String actualResult = WebUI.getAttribute(id("basic_billingAddress_postCode"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public AccountSettingsPage verifyCityBillingAddressValue(String expectedResult){
		String actualResult = WebUI.getAttribute(id("basic_billingAddress_city"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public AccountSettingsPage verifyCountryBillingAddressValue(String expectedResult){
		String actualResult = WebUI.getAttribute(id("basic_billingAddress_country"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	//Shipping Address
	public AccountSettingsPage verifyFirstNameShippingAddressValue(String expectedResult){
		String actualResult = WebUI.getAttribute(id("basic_shippingAddress_firstName"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public AccountSettingsPage verifyLastNameShippingAddressValue(String expectedResult){
		String actualResult = WebUI.getAttribute(id("basic_shippingAddress_lastName"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public AccountSettingsPage verifyEmailShippingAddressValue(String expectedResult){
		String actualResult = WebUI.getAttribute(id("basic_shippingAddress_email"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public AccountSettingsPage verifyPhoneShippingAddressValue(String expectedResult){
		String actualResult = WebUI.getAttribute(id("basic_shippingAddress_phone"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public AccountSettingsPage verifyStreetShippingAddressValue(String expectedResult){
		String actualResult = WebUI.getAttribute(id("basic_shippingAddress_streetName"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public AccountSettingsPage verifyHouseNumberShippingAddressValue(String expectedResult){
		String actualResult = WebUI.getAttribute(id("basic_shippingAddress_houseNumber"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public AccountSettingsPage verifyStateShippingAddressValue(String expectedResult){
		String actualResult = WebUI.getAttribute(id("basic_shippingAddress_state"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public AccountSettingsPage verifyZIPCodeShippingAddressValue(String expectedResult){
		String actualResult = WebUI.getAttribute(id("basic_shippingAddress_postCode"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public AccountSettingsPage verifyCityShippingAddressValue(String expectedResult){
		String actualResult = WebUI.getAttribute(id("basic_shippingAddress_city"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public AccountSettingsPage verifyCountryShippingAddressValue(String expectedResult){
		String actualResult = WebUI.getAttribute(id("basic_shippingAddress_country"), "value")
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

	public AccountSettingsPage verifyToastMessageWhenSaveChange() {
		def actualTitle = WebUI.getText(xpath("//*[@class='ant-notification-notice-message']"))
		def actualMessage = WebUI.getText(xpath("//*[@class='ant-notification-notice-description']"))
		def expectedTitle = "Success!"
		def expectedMessage = "Update success"
		WebUI.verifyEqual(actualTitle, expectedTitle)
		WebUI.verifyEqual(actualMessage, expectedMessage)
		return this
	}
}
