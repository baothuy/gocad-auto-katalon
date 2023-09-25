package gocad.buyer

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage




public class CuttingLayersPopup extends BasePage<CuttingLayersPopup>{
	
	public CuttingLayersPopup clickLabelNameLayers(String layerName) {
		WebUI.click(xpath("//span[@class='ant-tree-title']//*[normalize-space(text()) = '$layerName']"))
		return this
	}
	
	public CuttingLayersPopup clickLabelAllLayers() {
		WebUI.click(xpath("//span[@class='ant-tree-title' and text() = 'All layers']"))
		return this
	}
	
	public CuttingLayersPopup clickCheckboxNameLayers(String layerName, String check) {
		String contentClass = WebUI.getAttribute(xpath("//span[@class='ant-tree-title']//*[normalize-space(text()) = '$layerName']/ancestor::span/preceding-sibling::span[1]"), "class")
		String isChecked = contentClass.contains("checked")
		boolean isYes = check.equals("true")
		if(Boolean.parseBoolean(isChecked) != isYes) {
			WebUI.click(xpath("//span[@class='ant-tree-title']//*[normalize-space(text()) = '$layerName']/ancestor::span/preceding-sibling::span[1]/span"))
		}
		return this
	}
	
	public CuttingLayersPopup clickCheckboxAllLayers(String check) {
		String contentClass = WebUI.getAttribute(xpath("//span[@class='ant-tree-title' and text() = 'All layers']/ancestor::span/preceding-sibling::span[1]"), "class")
		String isChecked = contentClass.contains("checked")
		boolean isYes = check.equals("true")
		if(Boolean.parseBoolean(isChecked) != isYes) {
			WebUI.click(xpath("//span[@class='ant-tree-title' and text() = 'All layers']/ancestor::span/preceding-sibling::span[1]/span"))
		}
		return this
	}
	
	public CuttingLayersPopup clickOKButton() {
		WebUI.click(xpath("//*[text()='OK']"))
		return this
	}
	
	public CuttingLayersPopup clickCancelButton() {
		WebUI.click(xpath("//*[text()='Cancel']"))
		return this
	}
}
