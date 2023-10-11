package gocad.seller
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import katalon.fw.lib.BasePage


public class AccountSettingsPage extends BasePage<AccountSettingsPage>{

	public String getCompanyName() {
		String companyName = WebUI.getAttribute(xpath("//*[@id='basic_companyName']"), 'value')
		return companyName
	}

	public AccountSettingsPage inputFirstName(String input) {
		clearTextAndSendKeysByActions(id("basic_firstName"), input)
		return this
	}

	public AccountSettingsPage inputLastName(String input){
		clearTextAndSendKeysByActions(id("basic_lastName"), input)
		return this
	}

	public AccountSettingsPage inputGender(String input){
		WebUI.click(xpath("//span[text()='$input']"))
		return this
	}

	public AccountSettingsPage inputCompanyName(String input){
		clearTextAndSendKeysByActions(id("basic_companyName"), input)
		return this
	}

	public AccountSettingsPage inputPhone(String input){
		clearTextAndSendKeysByActions(id("basic_phone"), input)
		return this
	}

	public AccountSettingsPage inputFax(String input){
		clearTextAndSendKeysByActions(id("basic_fax"), input)
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

	public AccountSettingsPage inputStreetBillingAddress(String input){
		clearTextAndSendKeysByActions(id("basic_billingAddress_streetName"), input)
		return this
	}

	public AccountSettingsPage inputHouseNumberBillingAddress(String input){
		clearTextAndSendKeysByActions(id("basic_billingAddress_houseNumber"), input)
		return this
	}

	public AccountSettingsPage selectStateBillingAddress(String input){
		WebUI.click(xpath("//*[@class='sub-l' and text()='Billing Address']/parent::div/div[@class='row']/div[6]//span[@class='ant-select-selection-item']"))
		WebUI.click(xpath("//*[@id='basic_billingAddress_state_list']/following-sibling::div//div[@title='$input']"))
		return this
	}

	public AccountSettingsPage inputZIPCodeBillingAddress(String input){
		clearTextAndSendKeysByActions(id("basic_billingAddress_postCode"), input)
		return this
	}

	public AccountSettingsPage inputCityBillingAddress(String input){
		clearTextAndSendKeysByActions(id("basic_billingAddress_city"), input)
		return this
	}
}
