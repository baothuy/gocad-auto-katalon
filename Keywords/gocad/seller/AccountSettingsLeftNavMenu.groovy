package gocad.seller

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

import internal.GlobalVariable
import katalon.fw.lib.BasePage

public class AccountSettingsLeftNavMenu extends BasePage<AccountSettingsLeftNavMenu>{
	
	public AccountSettingsLeftNavMenu clickAccount() {
		WebUI.click(xpath("//span[text()='Account']/parent::button"))
		return this
	}
	
	public AccountSettingsLeftNavMenu clickLegalInformation() {
		WebUI.click(xpath("//span[text()='Legal Information']/parent::button"))
		return this
	}
	
	public AccountSettingsLeftNavMenu clickPaymentDetails() {
		WebUI.click(xpath("//span[text()='Payment Details']/parent::button"))
		return this
	}
	
	public AccountSettingsLeftNavMenu clickTermsOfPayment() {
		WebUI.click(xpath("//span[text()='Terms of Payment']/parent::button"))
		return this
	}
	
	public AccountSettingsLeftNavMenu clickBulkPricing() {
		WebUI.click(xpath("//span[text()='Bulk pricing']/parent::button"))
		return this
	}
}
