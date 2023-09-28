package gocad.buyer

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage


public class RequestOfferPopup extends BasePage<RequestOfferPopup>{

	String contentAlert = "Unfortunately, an automatic price calculation is not possible for this component. You are welcome to request an offer here. We'll get back to you within 48 hours."

	public RequestOfferPopup clickOK() {
		WebUI.click(xpath("//span[text()='OK']"))
		return this
	}

	public RequestOfferPopup clickCancel() {
		WebUI.click(xpath("//span[text()='Cancel']"))
		return this
	}

	public RequestOfferPopup inputDeliveryDate(String expectedInput) {
		WebUI.sendKeys(id('deliveryDate'),expectedInput)
		return this
	}

	public String getDeliveryDate() {
		String deliveryDate = WebUI.getAttribute(id('deliveryDate'), "title")
		return deliveryDate
	}

	public RequestOfferPopup inputFirstName(String expectedInput) {
		WebUI.sendKeys(id('billingAddress_firstName'), expectedInput)
		return this
	}

	public RequestOfferPopup inputLastName(String expectedInput) {
		WebUI.sendKeys(id('billingAddress_lastName'), expectedInput)
		return this
	}

	public RequestOfferPopup inputStreet(String expectedInput) {
		WebUI.sendKeys(id('billingAddress_streetName'),expectedInput)
		return this
	}

	public RequestOfferPopup inputHouseNumber(String expectedInput) {
		WebUI.sendKeys(id('billingAddress_houseNumber'),expectedInput)
		return this
	}

	public RequestOfferPopup selectState(String expectedInput) {
		WebUI.click(xpath("//*[@class='ant-select-selector']"))
		WebUI.click(xpath("//div[contains(@class, 'ant-select-item') and contains(@title,'$expectedInput')]"))
		return this
	}

	public RequestOfferPopup inputZipCode(String expectedInput) {
		WebUI.sendKeys(id('billingAddress_postCode'),expectedInput)
		return this
	}

	public RequestOfferPopup inputCity(String expectedInput) {
		WebUI.sendKeys(id('billingAddress_city'),expectedInput)
		return this
	}

	public RequestOfferPopup selectCountry(String expectedInput) {
		WebUI.click(xpath("//*[@class='ant-select-selector']"))
		WebUI.click(xpath("//div[contains(@class, 'ant-select-item') and contains(@title,'$expectedInput')]"))
		return this
	}

	public RequestOfferPopup verifyContentAlert() {
		String actualResult = WebUI.getText(xpath("//*[@class='ant-modal-header']/following::div[@class='ant-alert-description']"))
		WebUI.verifyEqual(actualResult, contentAlert)
		return this
	}

	public RequestOfferPopup verifyBillingAddressValue(List<String> billingAddressExpected) {
		String firstName = WebUI.getAttribute(xpath("//*[@id='billingAddress_firstName']"), 'value')
		String lastName = WebUI.getAttribute(xpath("//*[@id='billingAddress_lastName']"), 'value')
		String name = (firstName + " " + lastName).replace(",", "")
		String streetName = WebUI.getAttribute(xpath("//*[@id='billingAddress_streetName']"), 'value')
		String houseNumber = WebUI.getAttribute(xpath("//*[@id='billingAddress_houseNumber']"), 'value')
		String state = WebUI.getAttribute(xpath("//*[@class='sub-l' and text()='Billing Address']/parent::div/div[@class='row']/div[6]//span[@class='ant-select-selection-item']"), 'title')
		String postCode = WebUI.getAttribute(xpath("//*[@id='billingAddress_postCode']"), 'value')
		String city = WebUI.getAttribute(xpath("//*[@id='billingAddress_city']"), 'value')
		String country = WebUI.getAttribute(xpath("//*[@class='sub-l' and text()='Billing Address']/parent::div/div[@class='row']/div[9]//span[@class='ant-select-selection-item']"), 'value')
		List<String> billingAddressActual = [name, houseNumber, streetName, state, postCode, city]
		WebUI.verifyEqual(billingAddressActual, billingAddressExpected)
		return this
	}

	public RequestOfferPopup verifyUIVisableOnRequestOfferPopup() {
		WebUI.verifyElementVisible(xpath("//*[text()='Request Offer']"))
		WebUI.verifyElementVisible(xpath("//*[@for='deliveryDate' and @title='Please specify your desired delivery date']"))
		WebUI.verifyElementVisible(id('deliveryDate'))
		WebUI.verifyElementVisible(id('billingAddress_firstName'))
		WebUI.verifyElementVisible(id('billingAddress_streetName'))
		WebUI.verifyElementVisible(id('billingAddress_houseNumber'))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-select-selector']"))
		WebUI.verifyElementVisible(id('billingAddress_postCode'))
		WebUI.verifyElementVisible(id('billingAddress_city'))
		return this
	}
}
