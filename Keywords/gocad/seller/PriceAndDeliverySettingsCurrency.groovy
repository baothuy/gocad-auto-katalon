package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage




public class PriceAndDeliverySettingsCurrency extends BasePage<PriceAndDeliverySettingsCurrency>{
	
	def isoCode = {String isoCode -> return xpath("//*[@class='ant-table-tbody']/tr[@data-row-key='currency-$isoCode']/td[1]")}
	def symbol = {String isoCode -> return xpath("//*[@class='ant-table-tbody']/tr[@data-row-key='currency-$isoCode']/td[2]")}
	def exchangeRate = {String isoCode -> return xpath("//*[@class='ant-table-tbody']/tr[@data-row-key='currency-$isoCode']/td[3]")}
	def actionEdit = {String isoCode -> return xpath("//*[@class='ant-table-tbody']/tr[@data-row-key='currency-$isoCode']/td[4]/button")}

	public PriceAndDeliverySettingsCurrency clickEditButton(String isoCode) {
		WebUI.click(actionEdit(isoCode))
		return this
	}
	
	public PriceAndDeliverySettingsCurrency clickAcceptChangeButton() {
		WebUI.click(xpath("//span[@aria-label='check']/parent::button"))
		return this
	}
	
	public PriceAndDeliverySettingsCurrency clickCancelChangeButton() {
		WebUI.click(xpath("//span[@aria-label='close']/parent::button"))
		return this
	}
	
	public PriceAndDeliverySettingsCurrency inputExchangeRate(String input) {
		clearTextAndSendKeysByActions(id("exchangeRate"), input)
		return this
	}
	
	public PriceAndDeliverySettingsCurrency verifyExchangeRateValue(String isoCode, String expectedResult) {
		String actualResult = WebUI.getText(exchangeRate(isoCode))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
}