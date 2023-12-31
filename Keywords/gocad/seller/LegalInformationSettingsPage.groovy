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

public class LegalInformationSettingsPage extends BasePage<LegalInformationSettingsPage>{

	public LegalInformationSettingsPage clickSaveChangesButton() {
		WebUI.click(xpath("//span[text()='Save Changes']/parent::button"))
		return this
	}

	public LegalInformationSettingsPage inputLegal(String input) {
		clearTextAndSendKeysByActions(id("basic_legal"), input)
		return this
	}

	public LegalInformationSettingsPage inputVatId(String input) {
		clearTextAndSendKeysByActions(id("basic_vatId"), input)
		return this
	}

	public LegalInformationSettingsPage inputTaxNumber(String input) {
		clearTextAndSendKeysByActions(id("basic_taxNumber"), input)
		return this
	}

	public LegalInformationSettingsPage verifyUILegalInformationVisible() {
		//button Legal Information
		WebUI.verifyElementVisible(xpath("//span[text()='Legal Information']"))
		//field input
		WebUI.verifyElementVisible(id("basic_legal"))
		WebUI.verifyElementVisible(id("basic_vatId"))
		WebUI.verifyElementVisible(id("basic_taxNumber"))
		//button save change
		WebUI.verifyElementVisible(xpath("//span[text()='Save Changes']"))
		return this
	}
}
