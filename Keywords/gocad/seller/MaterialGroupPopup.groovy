package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage



public class MaterialGroupPopup extends BasePage<MaterialGroupPopup>{
	
	public MaterialGroupPopup inputLocalizedNamesEnglish(String input) {
		clearTextAndSendKeysByActions(id("basic_localizations_0_name"), input)
		return this
	}
	
	public MaterialGroupPopup inputLocalizedNamesGerman(String input) {
		clearTextAndSendKeysByActions(id("basic_localizations_1_name"), input)
		return this
	}
	
	public MaterialGroupPopup inputLocalizedNamesItalian(String input) {
		clearTextAndSendKeysByActions(id("basic_localizations_2_name"), input)
		return this
	}
	
	public MaterialGroupPopup inputCuttingParams(String input) {
		clearTextAndSendKeysByActions(id("basic_cuttingParams"), input)
		return this
	}
	
	public MaterialGroupPopup clickOKButton() {
		WebUI.click(xpath("//span[text()='OK']/parent::button"))
		return this
	}
	
	public MaterialGroupPopup clickCancelButton() {
		WebUI.click(xpath("//span[text()='Cancel']/parent::button"))
		return this
	}
	
	public MaterialSettingsPopup clickCloseButton() {
		WebUI.click(xpath("//button[@aria-label='Close']"))
		return this
	}
}

