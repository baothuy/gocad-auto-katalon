package gocad.common

import katalon.fw.lib.BasePage
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI




public class ToastMessage extends BasePage<ToastMessage>{
	
	public ToastMessage verifyToastMessage(String expectedTitle, String expectedMessage) {
		def actualTitle = WebUI.getText(xpath("//*[@class='ant-notification-notice-message']"))
		def actualMessage = WebUI.getText(xpath("//*[@class='ant-notification-notice-description']"))
		WebUI.verifyEqual(actualTitle, expectedTitle)
		WebUI.verifyEqual(actualMessage, expectedMessage)
		return this
	}
}
