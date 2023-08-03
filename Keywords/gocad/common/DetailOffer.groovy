package gocad.common

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import katalon.fw.lib.BasePage




public class DetailOffer extends BasePage<DetailOffer>{
	
	public DetailOffer clickAcceptAndSendOffer() {
		WebUI.click(xpath("//span[text()='Accept And Send Offer ']/parent::button"))
		return this
	}
	
	public DetailOffer clickCancelPopup() {
		WebUI.click(xpath("//span[text()='Cancel']/parent::button"))
		return this
	}
	
	public DetailOffer clickOKConfirmPopup() {
		WebUI.click(xpath("//span[text()='OK']/parent::button"))
		WebUI.delay(GlobalVariable.smallSleepTime)
		return this
	}
}
