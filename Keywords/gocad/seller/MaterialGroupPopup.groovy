package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage



public class MaterialGroupPopup extends BasePage<MaterialGroupPopup>{

	public MaterialGroupPopup inputLocalizedNamesEnglish(String input) {
		clearTextAndSendKeysByActions(id("basic_localizations_1_name"), input)
		return this
	}
	
	public MaterialGroupPopup verifyInputLocalizedNamesEnglishVisible() {
		WebUI.verifyElementVisible(id("basic_localizations_1_name"))
		return this
	}
	
	public MaterialGroupPopup verifyInputLocalizedNamesEnglishValue(String expectedResult) {
		String actualResult = WebUI.getAttribute(id("basic_localizations_1_name"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MaterialGroupPopup inputLocalizedNamesGerman(String input) {
		clearTextAndSendKeysByActions(id("basic_localizations_0_name"), input)
		return this
	}
	
	public MaterialGroupPopup verifyInputLocalizedNamesGermanVisible(){
		WebUI.verifyElementVisible(id("basic_localizations_0_name"))
		return this
	}
	
	public MaterialGroupPopup verifyInputLocalizedNamesGermanValue(String expectedResult) {
		String actualResult = WebUI.getAttribute(id("basic_localizations_0_name"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MaterialGroupPopup inputLocalizedNamesItalian(String input) {
		clearTextAndSendKeysByActions(id("basic_localizations_2_name"), input)
		return this
	}
	
	public MaterialGroupPopup verifyInputLocalizedNamesItalianVisible() {
		WebUI.verifyElementVisible(id("basic_localizations_2_name"))
		return this
	}
	
	public MaterialGroupPopup verifyInputLocalizedNamesItalianValue(String expectedResult) {
		String actualResult = WebUI.getAttribute(id("basic_localizations_2_name"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public MaterialGroupPopup inputLocalizedNamesCzech(String input) {
		clearTextAndSendKeysByActions(id("basic_localizations_3_name"), input)
		return this
	}
	
	public MaterialGroupPopup verifyInputLocalizedNamesCzechVisible() {
		WebUI.verifyElementVisible(id("basic_localizations_3_name"))
		return this
	}
	
	public MaterialGroupPopup verifyInputLocalizedNamesCzechValue(String expectedResult) {
		String actualResult = WebUI.getAttribute(id("basic_localizations_3_name"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MaterialGroupPopup inputCuttingParams(String input) {
		clearTextAndSendKeysByActions(id("basic_cuttingParams"), input)
		return this
	}
	
	public MaterialGroupPopup verifyInputCuttingParamsVisible() {
		WebUI.verifyElementVisible(id("basic_cuttingParams"))
		return this
	}

	public MaterialGroupPopup clickOKButton() {
		WebUI.click(xpath("//span[text()='OK']/parent::button"))
		return this
	}
	
	public MaterialGroupPopup verifyOKButtonVisible() {
		WebUI.verifyElementVisible(xpath("//span[text()='OK']/parent::button"))
		return this
	}

	public MaterialGroupPopup clickCancelButton() {
		WebUI.click(xpath("//span[text()='Cancel']/parent::button"))
		return this
	}
	
	public MaterialGroupPopup verifyCancelButtonVisible() {
		WebUI.verifyElementVisible(xpath("//span[text()='Cancel']/parent::button"))
		return this
	}

	public MaterialGroupPopup clickCloseButton() {
		WebUI.click(xpath("//button[@aria-label='Close']"))
		return this
	}
	
	public MaterialGroupPopup verifyToastMessage(String expectedTitle, String expectedMessage) {
		def actualTitle = WebUI.getText(xpath("//*[@class='ant-notification-notice-message']"))
		def actualMessage = WebUI.getText(xpath("//*[@class='ant-notification-notice-description']"))
		WebUI.verifyEqual(actualTitle, expectedTitle)
		WebUI.verifyEqual(actualMessage, expectedMessage)
		return this
	}
}

