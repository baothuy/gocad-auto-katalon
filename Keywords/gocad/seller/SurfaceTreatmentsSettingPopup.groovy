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
}
