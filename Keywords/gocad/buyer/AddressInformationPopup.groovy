package gocad.buyer

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import gocad.common.FunctionCommon
import katalon.fw.lib.BasePage
import katalon.fw.lib.Page




public class AddressInformationPopup extends BasePage<AddressInformationPopup>{

	//Billing Address
	public AddressInformationPopup inputFirstNameBillingAddress(String input){
		clearTextAndSendKeysByActions(id("billingAddress_firstName"), input)
		return this
	}

	public AddressInformationPopup inputLastNameBillingAddress(String input){
		clearTextAndSendKeysByActions(id("billingAddress_lastName"), input)
		return this
	}
	
	public AddressInformationPopup inputEmailBillingAddress(String input){
		clearTextAndSendKeysByActions(id("billingAddress_email"), input)
		return this
	}
	
	public AddressInformationPopup inputPhoneBillingAddress(String input){
		clearTextAndSendKeysByActions(id("billingAddress_phone"), input)
		return this
	}

	public AddressInformationPopup inputSearchBillingAddress(String houseNumber, String street, String city, String zipCode, String country) {
		String address = Page.nav(FunctionCommon).formatAddress(houseNumber, street, city, zipCode, country)
		clearTextAndSendKeysByActions(xpath("//*[@id='billingAddress']//input[@name='billingAddress_searchAddress']"), address)
		WebUI.click(xpath("//*[@class='rc-virtual-list']//div[text()='$address']/span"))
		return this
	}

	public AddressInformationPopup inputStreetBillingAddress(String input){
		clearTextAndSendKeysByActions(id("billingAddress_streetName"), input)
		return this
	}

	public AddressInformationPopup inputHouseNumberBillingAddress(String input){
		clearTextAndSendKeysByActions(id("billingAddress_houseNumber"), input)
		return this
	}

	public AddressInformationPopup selectStateBillingAddress(String input){
		clearTextAndSendKeysByActions(xpath("//*[@class='sub-l' and text()='Billing Address']/parent::div/div[@class='row']/div[9]//input"), input)
		WebUI.click(xpath("//*[@class='rc-virtual-list']//div[@title='$input']"))
		return this
	}

	public AddressInformationPopup selectCountryBillingAddress(String input){
		clearTextAndSendKeysByActions(id("basic_billingAddress_country"), input)
		WebUI.click(xpath("//*[@class='rc-virtual-list']//div[@title='$input']"))
		return this
	}

	public AddressInformationPopup inputZIPCodeBillingAddress(String input){
		clearTextAndSendKeysByActions(id("billingAddress_postCode"), input)
		return this
	}

	public AddressInformationPopup selectCityBillingAddress(String input){
		clearTextAndSendKeysByActions(id("basic_billingAddress_city"), input)
		WebUI.click(xpath("//*[@class='rc-virtual-list']//div[@title='$input']"))
		return this
	}

	//Shipping Address
	public AddressInformationPopup inputFirstNameShippingAddress(String input){
		clearTextAndSendKeysByActions(id("shippingAddress_firstName"), input)
		return this
	}

	public AddressInformationPopup inputLastNameShippingAddress(String input){
		clearTextAndSendKeysByActions(id("shippingAddress_lastName"), input)
		return this
	}
	
	public AddressInformationPopup inputEmailShippingAddress(String input){
		clearTextAndSendKeysByActions(id("shippingAddress_email"), input)
		return this
	}
	
	public AddressInformationPopup inputPhoneShippingAddress(String input){
		clearTextAndSendKeysByActions(id("shippingAddress_phone"), input)
		return this
	}

	public AddressInformationPopup inputSearchShippingAddress(String houseNumber, String street, String city, String zipCode, String country) {
		String address = Page.nav(FunctionCommon).formatAddress(houseNumber, street, city, zipCode, country)
		clearTextAndSendKeysByActions(xpath("//*[@id='shippingAddress']//input[@name='shippingAddress_searchAddress']"), address)
		WebUI.click(xpath("//*[@class='rc-virtual-list']//div[text()='$address']/span"))
		return this
	}

	public AddressInformationPopup inputStreetShippingAddress(String input){
		clearTextAndSendKeysByActions(id("shippingAddress_streetName"), input)
		return this
	}

	public AddressInformationPopup inputHouseNumberShippingAddress(String input){
		clearTextAndSendKeysByActions(id("shippingAddress_houseNumber"), input)
		return this
	}

	public AddressInformationPopup selectStateShippingAddress(String input){
		clearTextAndSendKeysByActions(xpath("//*[@class='sub-l' and text()='Shipping Address']/parent::div/div[@class='row']/div[9]//input"), input)
		WebUI.click(xpath("//*[@id='shippingAddress_state_list']/following::*[@class='rc-virtual-list']//div[@title='$input']"))
		return this
	}

	public AddressInformationPopup selectCountryShippingAddress(String input){
		clearTextAndSendKeysByActions(xpath("//*[@class='sub-l' and text()='Shipping Address']/parent::div/div[@class='row']/div[8]//input"), input)
		WebUI.click(xpath("//*[@id='shippingAddress_country_list']/following::*[@class='rc-virtual-list']//div[@title='$input']"))
		return this
	}

	public AddressInformationPopup inputZIPCodeShippingAddress(String input){
		clearTextAndSendKeysByActions(id("shippingAddress_postCode"), input)
		return this
	}

	public AddressInformationPopup selectCityShippingAddress(String input){
		clearTextAndSendKeysByActions(id("basic_shippingAddress_city"), input)
		WebUI.click(xpath("//*[@id='shippingAddress_city_list']/following::*[@class='rc-virtual-list']//div[@title='$input']"))
		return this
	}

	public AddressInformationPopup clickCheckBoxCloneTheSameAddress() {
		WebUI.click(xpath("//span[text()='The shipping address is the same as my billing address']/preceding-sibling::span"))
		return this
	}

	public AddressInformationPopup clickOK() {
		WebUI.click(xpath("//span[text()='OK']"))
		return this
	}

	public AddressInformationPopup clickCancel() {
		WebUI.click(xpath("//span[text()='Cancel']"))
		return this
	}

	public AddressInformationPopup verifyUIAddressInformationVisible(){
		//Billing Address
		WebUI.verifyElementVisible(id("billingAddress_firstName"))
		WebUI.verifyElementVisible(id("billingAddress_lastName"))
		WebUI.verifyElementVisible(id("billingAddress_streetName"))
		WebUI.verifyElementVisible(id("billingAddress_houseNumber"))
		WebUI.verifyElementVisible(xpath("//*[@class='sub-l' and text()='Billing Address']/parent::div/div[@class='row']/div[6]//span[@class='ant-select-selection-item']"))
		WebUI.verifyElementVisible(id("billingAddress_postCode"))
		WebUI.verifyElementVisible(id("billingAddress_city"))

		//Shiping Address
		WebUI.verifyElementVisible(id("shippingAddress_firstName"))
		WebUI.verifyElementVisible(id("shippingAddress_lastName"))
		WebUI.verifyElementVisible(id("shippingAddress_streetName"))
		WebUI.verifyElementVisible(id("shippingAddress_houseNumber"))
		WebUI.verifyElementVisible(xpath("//*[@class='sub-l' and text()='Shipping Address']/parent::div/div[@class='row']/div[6]//span[@class='ant-select-selection-item']"))
		WebUI.verifyElementVisible(id("shippingAddress_postCode"))
		WebUI.verifyElementVisible(id("shippingAddress_city"))

		//button and checkbox
		WebUI.verifyElementVisible(xpath("//span[text()='The shipping address is the same as my billing address']/preceding-sibling::span"))
		WebUI.verifyElementVisible(xpath("//span[text()='OK']"))
		WebUI.verifyElementVisible(xpath("//span[text()='Cancel']"))
		return this
	}

	public AddressInformationPopup verifyBillingAddress(List<String> expectedResult) {
		String firstName = WebUI.getAttribute(id("billingAddress_firstName"), "value")
		String lastName = WebUI.getAttribute(id("billingAddress_lastName"), "value")
		String name = firstName + " " + lastName
		String houseNumber = WebUI.getAttribute(id("billingAddress_houseNumber"), "value")
		String street = WebUI.getAttribute(id("billingAddress_streetName"), "value")
		String state = WebUI.getAttribute(id("billingAddress_state"), "value")
		String zipCode = WebUI.getAttribute(id("billingAddress_postCode"), "value")
		String city = WebUI.getAttribute(id("billingAddress_city"), "value")
		List<String> actualBillingAddress = [
			name,
			houseNumber,
			street,
			state,
			zipCode,
			city
		]
		println "actualBillingAddress: $actualBillingAddress"
		WebUI.verifyEqual(actualBillingAddress, expectedResult)
		return this
	}

	public AddressInformationPopup verifyShippingAddress(List<String> expectedResult) {
		String firstName = WebUI.getAttribute(id("shippingAddress_firstName"), "value")
		String lastName = WebUI.getAttribute(id("shippingAddress_lastName"), "value")
		String name = firstName + " " + lastName
		String houseNumber = WebUI.getAttribute(id("shippingAddress_houseNumber"), "value")
		String street = WebUI.getAttribute(id("shippingAddress_streetName"), "value")
		String state = WebUI.getAttribute(id("shippingAddress_state"), "value")
		String zipCode = WebUI.getAttribute(id("shippingAddress_postCode"), "value")
		String city = WebUI.getAttribute(id("shippingAddress_city"), "value")
		List<String> actualShippingAddress = [
			name,
			houseNumber,
			street,
			state,
			zipCode,
			city
		]
		println "actualShippingAddress: $actualShippingAddress"
		WebUI.verifyEqual(actualShippingAddress, expectedResult)
		return this
	}

	public AddressInformationPopup verifyShowErrorWhenFirstNameBillingAddressEmpty() {
		String firstName = WebUI.getText(xpath("//*[@id='billingAddress_firstName_help']/div"))
		String expectedResult = "Firstname is required."
		WebUI.verifyEqual(firstName, expectedResult)
		return this
	}

	public AddressInformationPopup verifyShowErrorWhenLastNameBillingAddressEmpty() {
		String lastName = WebUI.getText(xpath("//*[@id='billingAddress_lastName_help']/div"))
		String expectedResult = "Lastname is required."
		WebUI.verifyEqual(lastName, expectedResult)
		return this
	}
	
	public AddressInformationPopup verifyShowErrorWhenEmailBillingAddressEmpty() {
		String lastName = WebUI.getText(xpath("//*[@id='billingAddress_email_help']/div"))
		String expectedResult = "E-mail is required."
		WebUI.verifyEqual(lastName, expectedResult)
		return this
	}

	public AddressInformationPopup verifyShowErrorWhenHouseNumberBillingAddressEmpty() {
		String houseNumber = WebUI.getText(xpath("//*[@id='billingAddress_houseNumber_help']/div"))
		String expectedResult = "House number is required."
		WebUI.verifyEqual(houseNumber, expectedResult)
		return this
	}

	public AddressInformationPopup verifyShowErrorWhenStateBillingAddressEmpty() {
		String houseNumber = WebUI.getText(xpath("//*[@id='billingAddress_state_help']/div"))
		String expectedResult = "State is required."
		WebUI.verifyEqual(houseNumber, expectedResult)
		return this
	}

	public AddressInformationPopup verifyShowErrorWhenStreetBillingAddressEmpty() {
		String street = WebUI.getText(xpath("//*[@id='billingAddress_streetName_help']/div"))
		String expectedResult = "Street is required."
		WebUI.verifyEqual(street, expectedResult)
		return this
	}

	public AddressInformationPopup verifyShowErrorWhenZIPCodeBillingAddressEmpty() {
		String zipCode = WebUI.getText(xpath("//*[@id='billingAddress_postCode_help']/div"))
		String expectedResult = "ZIP Code is required."
		WebUI.verifyEqual(zipCode, expectedResult)
		return this
	}

	public AddressInformationPopup verifyShowErrorWhenCityBillingAddressEmpty() {
		String city = WebUI.getText(xpath("//*[@id='billingAddress_city_help']/div"))
		String expectedResult = "City is required."
		WebUI.verifyEqual(city, expectedResult)
		return this
	}

	//Shipping address
	public AddressInformationPopup verifyShowErrorWhenFirstNameShippingAddressEmpty() {
		String firstName = WebUI.getText(xpath("//*[@id='shippingAddress_firstName_help']/div"))
		String expectedResult = "Firstname is required."
		WebUI.verifyEqual(firstName, expectedResult)
		return this
	}

	public AddressInformationPopup verifyShowErrorWhenLastNameShippingAddressEmpty() {
		String lastName = WebUI.getText(xpath("//*[@id='shippingAddress_lastName_help']/div"))
		String expectedResult = "Lastname is required."
		WebUI.verifyEqual(lastName, expectedResult)
		return this
	}
	
	public AddressInformationPopup verifyShowErrorWhenEmailShippingAddressEmpty() {
		String lastName = WebUI.getText(xpath("//*[@id='shippingAddress_email_help']/div"))
		String expectedResult = "E-mail is required."
		WebUI.verifyEqual(lastName, expectedResult)
		return this
	}

	public AddressInformationPopup verifyShowErrorWhenHouseNumberShippingAddressEmpty() {
		String houseNumber = WebUI.getText(xpath("//*[@id='shippingAddress_houseNumber_help']/div"))
		String expectedResult = "House number is required."
		WebUI.verifyEqual(houseNumber, expectedResult)
		return this
	}

	public AddressInformationPopup verifyShowErrorWhenStateShippingAddressEmpty() {
		String houseNumber = WebUI.getText(xpath("//*[@id='shippingAddress_state_help']/div"))
		String expectedResult = "State is required."
		WebUI.verifyEqual(houseNumber, expectedResult)
		return this
	}

	public AddressInformationPopup verifyShowErrorWhenStreetShippingAddressEmpty() {
		String street = WebUI.getText(xpath("//*[@id='shippingAddress_streetName_help']/div"))
		String expectedResult = "Street is required."
		WebUI.verifyEqual(street, expectedResult)
		return this
	}

	public AddressInformationPopup verifyShowErrorWhenZIPCodeShippingAddressEmpty() {
		String zipCode = WebUI.getText(xpath("//*[@id='shippingAddress_postCode_help']/div"))
		String expectedResult = "ZIP Code is required."
		WebUI.verifyEqual(zipCode, expectedResult)
		return this
	}

	public AddressInformationPopup verifyShowErrorWhenCityShippingAddressEmpty() {
		String city = WebUI.getText(xpath("//*[@id='shippingAddress_city_help']/div"))
		String expectedResult = "City is required."
		WebUI.verifyEqual(city, expectedResult)
		return this
	}
}
