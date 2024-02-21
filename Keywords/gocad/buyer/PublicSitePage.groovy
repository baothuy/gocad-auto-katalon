package gocad.buyer

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import gocad.common.SignInPage
import katalon.fw.lib.BasePage





public class PublicSitePage extends BasePage<PublicSitePage> {
	
	public PublicSitePage clickNewProject() {
		WebUI.click(xpath("//*[text()='New Project']/parent::button"))
		return this
	}
	
	public PublicSitePage changeLanguage () {
		WebUI.switchToFrame(xpath("//*[@id='public-site']"), 10)		 
		WebUI.click(xpath("//button[@class='btn']"))
		WebUI.delay(1)
		WebUI.waitForElementPresent(xpath("//span[text()='English']"), 5)
		WebUI.click(xpath("//span[text()='English']"))
		WebUI.delay(1)
		WebUI.switchToDefaultContent()
		return this
	}
	
	public PublicSitePage switchToFrame() {
		WebUI.switchToFrame(xpath("//*[@id='public-site']"), 5)	
		return this
	}
	
	public PublicSitePage switchToDefaultContent() {
		WebUI.switchToDefaultContent()
		return this
	}
}
