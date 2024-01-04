package gocad.common

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import gocad.seller.SendOfferPage
import internal.GlobalVariable
import katalon.fw.lib.BasePage

public class InboxChat extends BasePage<InboxChat>{

	public InboxChat clickCloseButton() {
		WebUI.switchToFrame(xpath("//*[@id='widgetPopupFrame']"), 5)
		WebUI.click(xpath("//button[@aria-label='Close']"))
		WebUI.switchToDefaultContent()
		return this
	}
	
	public InboxChat clickLetsChat() {
		String xpathChat = "Let's chat"
		WebUI.switchToFrame(xpath("//*[@id='widgetPopupFrame']"), 5)
		WebUI.click(xpath('//button[text()=' + "'" + xpathChat + "']"))
		WebUI.switchToDefaultContent()
		return this
	}
	
	public InboxChat verifyInboxChatVisible() {
		List<String> findObjects = findTestObjects("//*[@id='widgetPopupFrame']")
	    (findObjects.size() != 0) ? WebUI.verifyElementPresent(xpath("//*[@id='widgetPopupFrame']"), 5) : "Empty"		
		return this
	}
	
	public InboxChat minimizeInboxChatWhenVisible() {
		List<String> findObjects = findTestObjects("//*[@id='widgetPopupFrame']")
		String xpathChat = "\"Let's chat\""
		if(findObjects.size() != 0){
			//click let chat
			WebUI.switchToFrame(xpath("//*[@id='widgetPopupFrame']"), 5)
			WebUI.click(xpath("//button[text()=$xpathChat]"))
			WebUI.switchToDefaultContent()
			//click minimize popup
			WebUI.switchToFrame(xpath("//*[@id='widgetMessengerFrame']"), 5)
			WebUI.click(xpath("//button[@aria-label='Minimize']"))
			WebUI.switchToDefaultContent()
		}
		return this
	}
	
	public InboxChat closeInboxChatWhenVisible() {
		List<String> findObjects = findTestObjects("//*[@id='widgetPopupFrame']")
		if(findObjects.size() != 0){
			//click close
			WebUI.switchToFrame(xpath("//*[@id='widgetPopupFrame']"), 5)
			WebUI.click(xpath("//button[@aria-label='Close']"))
			WebUI.switchToDefaultContent()
		}
		return this
	}
}
