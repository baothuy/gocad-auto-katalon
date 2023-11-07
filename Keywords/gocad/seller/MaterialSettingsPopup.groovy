package gocad.seller

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import gocad.buyer.AccountSettingsPage
import katalon.fw.lib.BasePage




public class MaterialSettingsPopup extends BasePage<MaterialSettingsPopup>{

	public MaterialSettingsPopup clickOKButton() {
		WebUI.click(xpath("//span[text()='OK']/parent::button"))
		return this
	}

	public MaterialSettingsPopup clickCancelButton() {
		WebUI.click(xpath("//span[text()='Cancel']/parent::button"))
		return this
	}

	public MaterialSettingsPopup clickAddNewButton() {
		WebUI.click(xpath("//span[text()='Add New']/parent::button"))
		return this
	}

	public MaterialSettingsPopup clickCloseButton() {
		WebUI.click(xpath("//button[@aria-label='Close']"))
		return this
	}

	public MaterialSettingsPopup selectMaterialGroup(String materialGroup) {
		WebUI.click(xpath("//input[@id='basic_groupId']/ancestor::div[contains(@class, 'ant-select-in-form-item')]"))
		List<String> materialGroupObject = findTestObjects("//div[contains(@class, 'ant-select-item-option-content') and text()='$materialGroup']/parent::div")
		(materialGroupObject.size() != 0) ? WebUI.click(xpath("//div[contains(@class, 'ant-select-item-option-content') and text()='$materialGroup']/parent::div")) : "Empty"
		WebUI.click(xpath("//div[contains(@class, 'ant-select-in-form-item')]"))
		return this
	}

	public MaterialSettingsPopup inputName(String name) {
		clearTextAndSendKeysByActions(id("basic_name"), name)
		return this
	}

	public MaterialSettingsPopup inputNumber(String number) {
		clearTextAndSendKeysByActions(id("basic_number"), number)
		return this
	}

	public MaterialSettingsPopup inputDensity(String density) {
		clearTextAndSendKeysByActions(id("basic_density"), density)
		return this
	}

	public MaterialSettingsPopup inputPricePerKilo(String density) {
		clearTextAndSendKeysByActions(id("basic_pricePerKilo"), density)
		return this
	}

	public MaterialSettingsPopup selectStatusToggle(String value) {
		String isChecked = WebUI.getAttribute(id("basic_active"), "aria-checked")
		boolean isActive = value.equals("Active")
		if(Boolean.parseBoolean(isChecked) != isActive) {
			WebUI.click(id("basic_active"))
		}
		return this
	}

	public MaterialSettingsPopup selectShapeType(String type) {
		WebUI.click(xpath("//input[@id='shapeType']/ancestor::div[contains(@class, 'ant-select-in-form-item')]"))
		List<String> shapeTypeObject = findTestObjects("//div[contains(@class, 'ant-select-item-option-content') and text()='$type']/parent::div")
		(shapeTypeObject.size() != 0) ? WebUI.click(xpath("//div[contains(@class, 'ant-select-item-option-content') and text()='$type']/parent::div")) : "Empty"
		WebUI.click(xpath("//div[contains(@class, 'ant-select-in-form-item')]"))
		return this
	}

	public MaterialSettingsPopup inputDiameter(String diameter) {
		clearTextAndSendKeysByActions(id("diameter"), diameter)
		return this
	}

	public MaterialSettingsPopup inputWidth(String width) {
		clearTextAndSendKeysByActions(id("width"), width)
		return this
	}

	public MaterialSettingsPopup inputHeight(String height) {
		clearTextAndSendKeysByActions(id("height"), height)
		return this
	}

	public MaterialSettingsPopup inputLength(String length) {
		clearTextAndSendKeysByActions(id("length"), length)
		return this
	}

	public MaterialSettingsPopup verifyShowErrorWhenMaterialGroupEmpty(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_groupId_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MaterialSettingsPopup verifyShowErrorWhenNameEmpty(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_name_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MaterialSettingsPopup verifyShowErrorWhenNumberEmpty(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_number_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MaterialSettingsPopup verifyShowErrorWhenDensityEmpty(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_density_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MaterialSettingsPopup verifyShowErrorWhenPricePerKiloEmpty(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_pricePerKilo_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MaterialSettingsPopup verifyShowErrorWhenThicknessEmpty(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='value_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public MaterialSettingsPopup verifyUIVisible() {
		WebUI.verifyElementVisible(xpath("//label[text()='Material Group']"))
		WebUI.verifyElementVisible(xpath("//input[@id='basic_groupId']/parent::span"))
		WebUI.verifyElementVisible(xpath("//label[text()='Name']"))
		WebUI.verifyElementVisible(id("basic_name"))
		WebUI.verifyElementVisible(xpath("//label[text()='Number']"))
		WebUI.verifyElementVisible(id("basic_number"))
		WebUI.verifyElementVisible(xpath("//label[text()='Density']"))
		WebUI.verifyElementVisible(id("basic_density"))
		WebUI.verifyElementVisible(xpath("//label[text()='Price per Kilo']"))
		WebUI.verifyElementVisible(id("basic_pricePerKilo"))
		WebUI.verifyElementVisible(xpath("//label[text()='Status']"))
		WebUI.verifyElementVisible(id("basic_active"))
		WebUI.verifyElementVisible(xpath("//label[text()='Type']"))
		WebUI.verifyElementVisible(xpath("//input[@id='shapeType']/parent::span"))
		WebUI.verifyElementVisible(xpath("//label[text()='Diameter']"))
		WebUI.verifyElementVisible(id("diameter"))
		WebUI.verifyElementVisible(xpath("//label[text()='Height']"))
		WebUI.verifyElementVisible(id("height"))
		//		WebUI.verifyElementVisible(xpath("//label[text()='Length']"))
		//		WebUI.verifyElementVisible(id("length"))
		WebUI.verifyElementVisible(xpath("//span[text()='Add New']"))
		WebUI.verifyElementVisible(xpath("//span[text()='OK']/parent::button"))
		WebUI.verifyElementVisible(xpath("//span[text()='Cancel']/parent::button"))
		WebUI.verifyElementVisible(xpath("//th[text()='Type']"))
		WebUI.verifyElementVisible(xpath("//th[text()='Diameter']"))
		WebUI.verifyElementVisible(xpath("//th[text()='Height']"))
		//		WebUI.verifyElementVisible(xpath("//th[text()='Length']"))
		WebUI.verifyElementVisible(xpath("//th[text()='Action']"))
		return this
	}
}
