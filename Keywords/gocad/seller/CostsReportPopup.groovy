package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage




public class CostsReportPopup extends BasePage<CostsReportPopup>{
	
	public CostsReportPopup verifyUIVisible() {
		WebUI.verifyElementVisible(xpath("//*[text()='Raw Material']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Set-up']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Laser']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Deburring']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Thread']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Countersinks']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Programming']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Laser marking']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Surface Treatment']"))
		return this
	}
	
	public CostsReportPopup clickClosePopup() {
		WebUI.click(xpath("//span[@class='ant-modal-close-x']/parent::button"))
		return this
	}
}
