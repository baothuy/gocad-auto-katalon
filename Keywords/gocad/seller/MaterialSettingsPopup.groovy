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
		//WebUI.click(xpath("//div[contains(@class, 'ant-select-in-form-item')]"))
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

	public MaterialSettingsPopup inputPricePerKilo(String value) {
		clearTextAndSendKeysByActions(id("basic_pricePerKilo"), value)
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

	public MaterialSettingsPopup selectShopType(String type) {
		WebUI.click(xpath("//input[@id='basic_shopType']/ancestor::div[contains(@class, 'ant-select-in-form-item')]"))
		List<String> shopTypeObject = findTestObjects("//div[contains(@class, 'ant-select-item-option-content') and text()='$type']/parent::div")
		(shopTypeObject.size() != 0) ? WebUI.click(xpath("//div[contains(@class, 'ant-select-item-option-content') and text()='$type']/parent::div")) : "Empty"
		return this
	}
	
	public MaterialSettingsPopup selectCompliances(String compliances) {
		WebUI.click(xpath("//input[@id='basic_complianceIds']/ancestor::div[contains(@class, 'ant-select-in-form-item')]"))
		List<String> shapeTypeObject = findTestObjects("//div[contains(@class, 'ant-select-item-option-content') and text()='$compliances']/parent::div")
		(shapeTypeObject.size() != 0) ? WebUI.click(xpath("//div[contains(@class, 'ant-select-item-option-content') and text()='$compliances']/parent::div")) : "Empty"
		WebUI.click(id("basic_name"))
		return this
	}
	
	public MaterialSettingsPopup inputThickness(String thickness) {
		clearTextAndSendKeysByActions(xpath("//p[text()='Thickness']/following-sibling::form//input"), thickness)
		return this
	}
	
	public MaterialSettingsPopup inputPricePerKiloInThickness(String value) {
		clearTextAndSendKeysByActions(xpath("//label[@for='pricePerKilo']/parent::div/following::input"), value)
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
	
	public MaterialSettingsPopup inputLink(String value) {
		clearTextAndSendKeysByActions(id("basic_link"), value)
		return this
	}
	
	public MaterialSettingsPopup inputSynonym(String value) {
		clearTextAndSendKeysByActions(id("basic_synonym"), value)
		return this
	}
	
	public MaterialSettingsPopup clickAddNewThickness(String thickness) {
		WebUI.click(xpath("//p[text()='Thickness']/following-sibling::form//span[text()='Add New']"))
		return this
	}
	
	public MaterialSettingsPopup selectShapeType(String type) {
		WebUI.click(xpath("//input[@id='shapeType']/ancestor::div[contains(@class, 'ant-select-in-form-item')]"))
		List<String> shapeTypeObject = findTestObjects("//div[contains(@class, 'ant-select-item-option-content') and text()='$type']/parent::div")
		(shapeTypeObject.size() != 0) ? WebUI.click(xpath("//div[contains(@class, 'ant-select-item-option-content') and text()='$type']/parent::div")) : "Empty"
		return this
	}
	
	public MaterialSettingsPopup clickAddNewRawMaterial() {
		WebUI.click(xpath("//p[text()='Raw Material']/following-sibling::form//span[text()='Add New']"))
		return this
	}
	
	public MaterialSettingsPopup verifyMaterialGroupValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@for='basic_groupId']/parent::div/following-sibling::div//span[@class='ant-select-selection-item']"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public MaterialSettingsPopup verifyNameValue(String expectedResult) {
		String actualResult = WebUI.getAttribute(id("basic_name"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public MaterialSettingsPopup verifyNumberValue(String expectedResult) {
		String actualResult = WebUI.getAttribute(id("basic_number"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public MaterialSettingsPopup verifyDensityValue(String expectedResult) {
		String actualResult = WebUI.getAttribute(id("basic_density"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public MaterialSettingsPopup verifyPricePerKiloValue(String expectedResult) {
		String actualResult = WebUI.getAttribute(id("basic_pricePerKilo"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public MaterialSettingsPopup verifyCompliancesValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@for='basic_complianceIds']/parent::div/following-sibling::div//span[@class='ant-select-selection-item-content']"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public MaterialSettingsPopup verifyShopTypeValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@for='basic_shopType']/parent::div/following-sibling::div//span[@class='ant-select-selection-item']"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public MaterialSettingsPopup verifyLinkValue(String expectedResult) {
		String actualResult = WebUI.getAttribute(id("basic_link"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public MaterialSettingsPopup verifySynonymValue(String expectedResult) {
		String actualResult = WebUI.getAttribute(id("basic_synonym"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public MaterialSettingsPopup verifyStatusValue(String expectedResult) {
		String isChecked = WebUI.getAttribute(id("basic_active"), "aria-checked")
		println "isChecked: $isChecked"
		def actualResult = (isChecked == "true") ? "Active" : "Inactive" 
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
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
	
	public MaterialSettingsPopup verifyThicknessValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//th[text()='Thickness']/ancestor::thead/following-sibling::tbody//td[1]"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public MaterialSettingsPopup verifyTypeValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//th[text()='Type']/ancestor::thead/following-sibling::tbody//td[1]"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public MaterialSettingsPopup verifyDiameterValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//th[text()='Diameter']/ancestor::thead/following-sibling::tbody//td[2]"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public MaterialSettingsPopup verifyHeightValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//th[text()='Height']/ancestor::thead/following-sibling::tbody//td[3]"))
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
		WebUI.verifyElementVisible(xpath("//label[text()='Shop type']"))
		WebUI.verifyElementVisible(xpath("//input[@id='basic_shopType']/parent::span"))
		WebUI.verifyElementVisible(xpath("//label[text()='Link']"))
		WebUI.verifyElementVisible(xpath("//input[@id='basic_link']"))
		WebUI.verifyElementVisible(xpath("//label[text()='Synonym']"))
		WebUI.verifyElementVisible(xpath("//input[@id='basic_synonym']"))
		WebUI.verifyElementVisible(xpath("//span[text()='OK']/parent::button"))
		WebUI.verifyElementVisible(xpath("//span[text()='Cancel']/parent::button"))
		return this
	}
	
	public MaterialSettingsPopup verifyUIEditVisible() {
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
		WebUI.verifyElementVisible(xpath("//label[text()='Shop type']"))
		WebUI.verifyElementVisible(xpath("//input[@id='basic_shopType']/parent::span"))
		WebUI.verifyElementVisible(xpath("//label[text()='Link']"))
		WebUI.verifyElementVisible(xpath("//input[@id='basic_link']"))
		WebUI.verifyElementVisible(xpath("//label[text()='Synonym']"))
		WebUI.verifyElementVisible(xpath("//input[@id='basic_synonym']"))
		WebUI.verifyElementVisible(xpath("//label[text()='Type']"))
		WebUI.verifyElementVisible(xpath("//input[@id='shapeType']/parent::span"))
		WebUI.verifyElementVisible(xpath("//label[text()='Diameter']"))
		WebUI.verifyElementVisible(id("diameter"))
		WebUI.verifyElementVisible(xpath("//label[text()='Height']"))
		WebUI.verifyElementVisible(id("height"))
		WebUI.verifyElementVisible(xpath("//*[text()='Raw Material']/following::label[text()='Price per Kilo']"))
		WebUI.verifyElementVisible(id("pricePerKilo"))
		WebUI.verifyElementVisible(xpath("//span[text()='Add New']"))
		WebUI.verifyElementVisible(xpath("//span[text()='OK']/parent::button"))
		WebUI.verifyElementVisible(xpath("//span[text()='Cancel']/parent::button"))
		WebUI.verifyElementVisible(xpath("//th[text()='Type']"))
		WebUI.verifyElementVisible(xpath("//th[text()='Diameter']"))
		WebUI.verifyElementVisible(xpath("//th[text()='Height']"))
		WebUI.verifyElementVisible(xpath("//th[text()='Price per Kilo']"))
		WebUI.verifyElementVisible(xpath("//th[text()='Action']"))
		return this
	}
}
