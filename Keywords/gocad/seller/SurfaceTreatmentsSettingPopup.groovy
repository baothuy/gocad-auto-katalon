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

public class SurfaceTreatmentsSettingPopup extends BasePage<SurfaceTreatmentsSettingPopup>{

	public SurfaceTreatmentsSettingPopup clickOKButton() {
		WebUI.click(xpath("//span[text()='OK']/parent::button"))
		return this
	}

	public SurfaceTreatmentsSettingPopup clickCancelButton() {
		WebUI.click(xpath("//span[text()='Cancel']/parent::button"))
		return this
	}

	public SurfaceTreatmentsSettingPopup clickCloseButton() {
		WebUI.click(xpath("//button[@aria-label='Close']"))
		return this
	}

	public SurfaceTreatmentsSettingPopup selectStatusToggle(String value) {
		String isChecked = WebUI.getAttribute(id("basic_active"), "aria-checked")
		boolean isActive = value.equals("Active")
		if(Boolean.parseBoolean(isChecked) != isActive) {
			WebUI.click(id("basic_active"))
		}
		return this
	}
	
	public SurfaceTreatmentsSettingPopup inputLocalizedNamesEnglish(String input) {
		clearTextAndSendKeysByActions(id("basic_localizations_0_name"), input)
		return this
	}
	
	public SurfaceTreatmentsSettingPopup inputLocalizedNamesGerman(String input) {
		clearTextAndSendKeysByActions(id("basic_localizations_1_name"), input)
		return this
	}
	
	public SurfaceTreatmentsSettingPopup inputLocalizedNamesItalian(String input) {
		clearTextAndSendKeysByActions(id("basic_localizations_2_name"), input)
		return this
	}
	
	public SurfaceTreatmentsSettingPopup inputLocalizedNamesCzech(String input) {
		clearTextAndSendKeysByActions(id("basic_localizations_3_name"), input)
		return this
	}

	public SurfaceTreatmentsSettingPopup inputAbbr(String input) {
		clearTextAndSendKeysByActions(id("basic_abbr"), input)
		return this
	}

	public SurfaceTreatmentsSettingPopup inputPricePerArea(String input) {
		clearTextAndSendKeysByActions(id("basic_pricePerArea"), input)
		return this
	}

	public SurfaceTreatmentsSettingPopup inputPricePerKilo(String input) {
		clearTextAndSendKeysByActions(id("basic_pricePerKilo"), input)
		return this
	}

	public SurfaceTreatmentsSettingPopup inputSetupCost(String input) {
		clearTextAndSendKeysByActions(id("basic_setupCost"), input)
		return this
	}

	public SurfaceTreatmentsSettingPopup inputMinOrder(String input) {
		clearTextAndSendKeysByActions(id("basic_minOrder"), input)
		return this
	}

	public SurfaceTreatmentsSettingPopup inputDeliveryWeek(String input) {
		clearTextAndSendKeysByActions(id("basic_deliveryWeek"), input)
		return this
	}

	public SurfaceTreatmentsSettingPopup inpuTransportationCost(String input) {
		clearTextAndSendKeysByActions(id("basic_transportationCost"), input)
		return this
	}
	
	//visible
	
	public SurfaceTreatmentsSettingPopup verifyInputLocalizedNamesEnglishVisible() {
		WebUI.verifyElementVisible(id("basic_localizations_0_name"))
		return this
	}
	
	public SurfaceTreatmentsSettingPopup verifyInputLocalizedNamesGermanVisible() {
		WebUI.verifyElementVisible(id("basic_localizations_1_name"))
		return this
	}
	
	public SurfaceTreatmentsSettingPopup verifyInputLocalizedNamesItalianVisible() {
		WebUI.verifyElementVisible(id("basic_localizations_2_name"))
		return this
	}
	
	public SurfaceTreatmentsSettingPopup verifyInputLocalizedNamesCzechVisible() {
		WebUI.verifyElementVisible(id("basic_localizations_3_name"))
		return this
	}

	public SurfaceTreatmentsSettingPopup verifyInputAbbrVisible() {
		WebUI.verifyElementVisible(id("basic_abbr"))
		return this
	}

	public SurfaceTreatmentsSettingPopup verifyInputPricePerAreaVisible() {
		WebUI.verifyElementVisible(id("basic_pricePerArea"))
		return this
	}

	public SurfaceTreatmentsSettingPopup verifyInputPricePerKiloVisible() {
		WebUI.verifyElementVisible(id("basic_pricePerKilo"))
		return this
	}

	public SurfaceTreatmentsSettingPopup verifyInputSetupCostVisible() {
		WebUI.verifyElementVisible(id("basic_setupCost"))
		return this
	}

	public SurfaceTreatmentsSettingPopup verifyInputMinOrderVisible() {
		WebUI.verifyElementVisible(id("basic_minOrder"))
		return this
	}

	public SurfaceTreatmentsSettingPopup verifyInputDeliveryWeekVisible() {
		WebUI.verifyElementVisible(id("basic_deliveryWeek"))
		return this
	}

	public SurfaceTreatmentsSettingPopup verifyInpuTransportationCost() {
		WebUI.verifyElementVisible(id("basic_transportationCost"))
		return this
	}
	
	public SurfaceTreatmentsSettingPopup verifySelectStatusToggleVisible() {
		WebUI.verifyElementVisible(id("basic_active"))
		return this
	}
	
	public SurfaceTreatmentsSettingPopup verifyOKButtonVisible() {
		WebUI.verifyElementVisible(xpath("//span[text()='OK']/parent::button"))
		return this
	}
	
	public SurfaceTreatmentsSettingPopup verifyCancelButtonVisible() {
		WebUI.verifyElementVisible(xpath("//span[text()='Cancel']/parent::button"))
		return this
	}
}
