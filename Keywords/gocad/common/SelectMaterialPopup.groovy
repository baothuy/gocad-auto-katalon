package gocad.common
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import katalon.fw.lib.BasePage

public class SelectMaterialPopup extends BasePage<SelectMaterialPopup>{

	public SelectMaterialPopup clickMaterialGroup(String materialGroup) {
		scrollToAndClick(xpath("//div[@class='ant-space-item']//*[text()='$materialGroup']"))
		return this
	}
	
	public SelectMaterialPopup clickThickness(String thickness) {
		scrollToAndClick(xpath("//div[contains(@class,'filter-thickness')]//span[text()='$thickness mm']"))
		return this
	}

	public SelectMaterialPopup inputSearchMaterial(String materialName) {
		clearTextAndSendKeysByActions(xpath("//input[@placeholder='Search material']"), materialName)
		return this
	}

	public SelectMaterialPopup clickClearSearchMaterial() {
		WebUI.click(xpath("//span[@class='ant-input-clear-icon']"))
		return this
	}

	public SelectMaterialPopup selectMaterialName(String materialName) {
		WebUI.click(xpath("//div[@class='material-list']//div[text()='$materialName']/parent::div[@class='row material-item']"))
		return this
	}

	public String getNumberPartCol(String materialName) {
		String numberPart = WebUI.getText(xpath("//div[text()='$materialName']/parent::div[@class='row material-item']/div[4]"))
		return numberPart
	}

	public String getMaterialAndNumber(String materialName) {
//		String numberPart = WebUI.getText(xpath("//div[text()='$materialName']/parent::div[@class='row material-item']/div[4]"))
//		String material = materialName +"/"+ numberPart
		String material = materialName
		return material
	}

	public SelectMaterialPopup clickCloseSearchMaterialPopup() {
		WebUI.click(xpath("//span[@class='ant-modal-close-x']"))
		return this
	}
}
