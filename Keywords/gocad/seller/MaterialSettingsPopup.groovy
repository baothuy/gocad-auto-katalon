package gocad.seller

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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
	
}
