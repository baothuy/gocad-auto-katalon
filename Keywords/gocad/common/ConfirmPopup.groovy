package gocad.common

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage




public class ConfirmPopup extends BasePage<ConfirmPopup>{
	
	public ConfirmPopup clickOK() {
		WebUI.click(text("OK"))
		return this
	}
	
	public ConfirmPopup clickCancel() {
		WebUI.click(text("Cancel"))
		return this
	}
	
	public ConfirmPopup clickClose() {
		WebUI.click(text("Close"))
		return this
	}
	
	public ConfirmPopup verifyTitleConfirmPopup(String title) {
		String actualTitle = WebUI.getText(xpath("//*[@class='ant-modal-title']"))
		WebUI.verifyEqual(actualTitle, title)
		return this
	}
	
	public ConfirmPopup verifyContentConfirmPopup(String content) {
		String actualContent = WebUI.getText(xpath("//*[@class='ant-modal-body']"))
		WebUI.verifyEqual(actualContent, content)
		return this
	}
	
}
