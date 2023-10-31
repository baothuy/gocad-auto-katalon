package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import gocad.buyer.ReviewPage
import katalon.fw.lib.BasePage


public class EmissionReportPopup extends BasePage<EmissionReportPopup>{
	
	public EmissionReportPopup verifyUIVisible() {
		WebUI.verifyElementVisible(xpath("//*[text()='Overall Emission for all parts:']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Emission for set-up:']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Emission per unit:']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Emission per unit (material):']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Emission per unit (machining):']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Emission per unit (additions):']"))
		return this
	}
	
	public EmissionReportPopup clickClosePopup() {
		WebUI.click(xpath("//span[@class='ant-modal-close-x']/parent::button"))
		return this
	}
}
