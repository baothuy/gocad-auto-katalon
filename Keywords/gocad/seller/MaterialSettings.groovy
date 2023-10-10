package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage




public class MaterialSettings extends BasePage<MaterialSettings>{
	
	def idCol = { String materialName -> return xpath("//*[text()='$materialName']/parent::tr/td[1]")}
	def materialGroupCol = { String materialName -> return xpath("//*[text()='$materialName']/parent::tr/td[2]/button")}
	def cuttingParamsCol = { String materialName -> return xpath("//*[text()='$materialName']/parent::tr/td[3]")}
	def name = { String materialName -> return xpath("//*[text()='$materialName']/parent::tr/td[4]")}
	def number = { String materialName -> return xpath("//*[text()='$materialName']/parent::tr/td[5]")}
	def density = { String materialName -> return xpath("//*[text()='$materialName']/parent::tr/td[6]")}
	def pricePerKilo = { String materialName -> return xpath("//*[text()='$materialName']/parent::tr/td[7]")}
	def status = { String materialName -> return xpath("//*[text()='$materialName']/parent::tr/td[8]//span[normalize-space(text()) != '']")}
	def editAction = { String materialName -> return xpath("//*[text()='$materialName']/parent::tr/td[9]/button")}
	
	public MaterialSettings clickEditSurchargeRawMaterialButton() {
		WebUI.click(xpath("(//span[@aria-label='edit']/parent::button)[1]"))
		return this
	}
	
	public MaterialSettings clickAcceptChangeSurchargeRawMaterialButton() {
		WebUI.click(xpath("//span[@aria-label='edit']/parent::button"))
		return this
	}
	
	public MaterialSettings clickCloseChangeSurchargeRawMaterialButton() {
		WebUI.click(xpath("//span[@aria-label='close']/parent::button"))
		return this
	}
	
	public MaterialSettings clickNewMaterialButton() {
		WebUI.click(xpath("//span[text()='New Material']"))
		return this
	}
	
	public MaterialSettings clickCSVImportButton() {
		WebUI.click(xpath("//span[text()=' CSV Import']"))
		return this
	}
	
	public MaterialSettings clickCSVExportButton() {
		WebUI.click(xpath("//span[text()='CSV Export']"))
		return this
	}
	
	public MaterialSettings inputSearchMaterial(String input) {
		clearTextAndSendKeysByActions(xpath("//input[@placeholder='Search material']"), input)
		return this
	}
	
	public MaterialSettings removeContentSearch() {
		WebUI.click(xpath("//*[@aria-label='close-circle']"))
		return this
	}
	
	public MaterialSettings clickEditButton(String materialName) {
		WebUI.click(editAction(materialName))
		return this
	}
}
