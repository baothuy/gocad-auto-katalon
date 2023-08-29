package gocad.buyer

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage


public class AccountSettingsPage extends BasePage<AccountSettingsPage>{

	public String getCompanyName() {
		String companyName = WebUI.getAttribute(xpath("//*[@id='basic_companyName']"), 'value')
		return companyName
	}

	public List<String> getBillingAddress() {
		String firstName = WebUI.getAttribute(xpath("//*[@id='basic_billingAddress_firstName']"), 'value')
		String lastName = WebUI.getAttribute(xpath("//*[@id='basic_billingAddress_lastName']"), 'value')
		String name = (firstName + " " + lastName).replace(",", "")
		String streetName = WebUI.getAttribute(xpath("//*[@id='basic_billingAddress_streetName']"), 'value')
		String houseNumber = WebUI.getAttribute(xpath("//*[@id='basic_billingAddress_houseNumber']"), 'value')
		String state = WebUI.getAttribute(xpath("//*[@class='sub-l' and text()='Billing Address']/parent::div/div[@class='row']/div[6]//span[@class='ant-select-selection-item']"), 'title')
		String postCode = WebUI.getAttribute(xpath("//*[@id='basic_billingAddress_postCode']"), 'value')
		String city = WebUI.getAttribute(xpath("//*[@id='basic_billingAddress_city']"), 'value')
		String country = WebUI.getAttribute(xpath("//*[@class='sub-l' and text()='Billing Address']/parent::div/div[@class='row']/div[9]//span[@class='ant-select-selection-item']"), 'value')
		List<String> billingAddress = [name, houseNumber, streetName, state, postCode, city]
		return billingAddress
	}
	
	public List<String> getShippingAddress() {
		String firstName = WebUI.getAttribute(xpath("//*[@id='basic_shippingAddress_firstName']"), 'value')
		String lastName = WebUI.getAttribute(xpath("//*[@id='basic_shippingAddress_lastName']"), 'value')
		String name = (firstName + " " + lastName).replace(",", "")
		String streetName = WebUI.getAttribute(xpath("//*[@id='basic_shippingAddress_streetName']"), 'value')
		String houseNumber = WebUI.getAttribute(xpath("//*[@id='basic_shippingAddress_houseNumber']"), 'value')
		String state = WebUI.getAttribute(xpath("//*[@class='sub-l' and text()='Shipping Address']/parent::div/div[@class='row']/div[6]//span[@class='ant-select-selection-item']"), 'title')
		String postCode = WebUI.getAttribute(xpath("//*[@id='basic_shippingAddress_postCode']"), 'value')
		String city = WebUI.getAttribute(xpath("//*[@id='basic_shippingAddress_city']"), 'value')
		String country = WebUI.getAttribute(xpath("//*[@class='sub-l' and text()='Shipping Address']/parent::div/div[@class='row']/div[9]//span[@class='ant-select-selection-item']"), 'value')
		List<String> shippingAddress = [name, houseNumber, streetName, state, postCode, city]
		return shippingAddress
	}
	
	public List<String> getCustomerInfo() {
		String firstName = WebUI.getAttribute(xpath("//*[@id='basic_firstName']"), 'value')
		String lastName = WebUI.getAttribute(xpath("//*[@id='basic_lastName']"), 'value')
		String name = (firstName + " " + lastName).replace(",", "")
		String email = WebUI.getAttribute(xpath("//*[@class='truncate']"), 'title')
		String phone = WebUI.getAttribute(xpath("//*[@id='basic_phone']"), 'value')
		String companyName = WebUI.getAttribute(xpath("//*[@id='basic_companyName']"), 'value')
		List<String> customerInfo = [name, email, phone, companyName]
		return customerInfo
	}
}
