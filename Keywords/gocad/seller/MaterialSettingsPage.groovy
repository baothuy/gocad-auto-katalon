package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage




public class MaterialSettingsPage extends BasePage<MaterialSettingsPage>{

	def idCol = { String materialName -> return xpath("//*[text()='$materialName']/parent::tr/td[1]")}
	def materialGroupCol = { String materialName -> return xpath("//*[text()='$materialName']/parent::tr/td[2]/button")}
	def cuttingParamsCol = { String materialName -> return xpath("//*[text()='$materialName']/parent::tr/td[3]")}
	def name = { String materialName -> return xpath("//*[text()='$materialName']/parent::tr/td[4]")}
	def number = { String materialName -> return xpath("//*[text()='$materialName']/parent::tr/td[5]")}
	def density = { String materialName -> return xpath("//*[text()='$materialName']/parent::tr/td[6]")}
	def pricePerKilo = { String materialName -> return xpath("//*[text()='$materialName']/parent::tr/td[7]")}
	def status = { String materialName -> return xpath("//*[text()='$materialName']/parent::tr/td[8]//span[normalize-space(text()) != '']")}
	def editAction = { String materialName -> return xpath("//*[text()='$materialName']/parent::tr/td[9]/button")}

	public MaterialSettingsPage clickEditSurchargeRawMaterialButton() {
		WebUI.click(xpath("(//span[@aria-label='edit']/parent::button)[1]"))
		return this
	}

	public MaterialSettingsPage clickAcceptChangeSurchargeRawMaterialButton() {
		WebUI.click(xpath("//span[@aria-label='edit']/parent::button"))
		return this
	}

	public MaterialSettingsPage clickCloseChangeSurchargeRawMaterialButton() {
		WebUI.click(xpath("//span[@aria-label='close']/parent::button"))
		return this
	}

	public MaterialSettingsPage clickNewMaterialButton() {
		WebUI.click(xpath("//span[text()='New Material']"))
		return this
	}

	public MaterialSettingsPage clickCSVImportButton() {
		WebUI.click(xpath("//span[text()=' CSV Import']"))
		return this
	}

	public MaterialSettingsPage clickCSVExportButton() {
		WebUI.click(xpath("//span[text()='CSV Export']"))
		return this
	}

	public MaterialSettingsPage inputSearchMaterial(String input) {
		clearTextAndSendKeysByActions(xpath("//input[@placeholder='Search material']"), input)
		return this
	}

	public MaterialSettingsPage removeContentSearch() {
		WebUI.click(xpath("//*[@aria-label='close-circle']"))
		return this
	}

	public MaterialSettingsPage clickEditButton(String materialName) {
		WebUI.click(editAction(materialName))
		return this
	}
}
