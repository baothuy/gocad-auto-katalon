package gocad.common
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
	
	public String getNumberPartCol(String materialName) {
		String numberPart = WebUI.getText(xpath("//div[contains(text(),'$materialName')]/parent::div[@class='row material-item']/div[2]"))
		return numberPart
	}
	
	public String getMaterialAndNumber(String materialName) {
		String numberPart = WebUI.getText(xpath("//div[contains(text(),'$materialName')]/parent::div[@class='row material-item']/div[2]"))
		String material = materialName +"/"+ numberPart
		return material
	}
	
	public SelectMaterialPopup clickCloseSearchMaterialPopup() {
		WebUI.click(xpath("//span[@class='ant-modal-close-x']"))
		return this
	}
}
