package gocad.buyer
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import katalon.fw.lib.BasePage

public class SelectMaterialPopup extends BasePage<SelectMaterialPopup>{
	
	public SelectMaterialPopup clickMaterialGroup(String materialGroup) {
		WebUI.click(xpath("//span[text()='$materialGroup']"))
		return this
	}
	
	public SelectMaterialPopup inputSearchMaterial(String materialName) {
		WebUI.sendKeys(xpath("//input[@placeholder='Search material']"), materialName)
		return this
	}
	
	public SelectMaterialPopup clickClearSearchMaterial() {
		WebUI.click(xpath("//span[@class='ant-input-clear-icon']"))
		return this
	}
	
	public SelectMaterialPopup selectMaterialName(String materialName) {
		WebUI.click(xpath("//div[contains(text(),'$materialName')]/parent::div[@class='row material-item']"))
		return this
	}
	
	public String getCO2EmissionCol(String materialName) {
		String CO2Emission = WebUI.getText(xpath("//div[contains(text(),'$materialName')]/parent::div[@class='row material-item']/div[2]"))
		return CO2Emission
	}
	
	public SelectMaterialPopup clickCloseSearchMaterialPopup() {
		WebUI.click(xpath("//span[@class='ant-modal-close-x']"))
		return this
	}
}
