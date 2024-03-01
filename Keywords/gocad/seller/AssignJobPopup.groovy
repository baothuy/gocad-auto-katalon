package gocad.seller

import org.openqa.selenium.Keys

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage




public class AssignJobPopup extends BasePage<AssignJobPopup>{

	public AssignJobPopup clickAssign() {
		WebUI.click(xpath("//span[text()='Assign']/parent::button"))
		return this
	}

	public AssignJobPopup clickCancel() {
		WebUI.click(xpath("//span[text()='Cancel']/parent::button"))
		return this
	}
	
	public AssignJobPopup clickAcceptChange() {
		WebUI.click(xpath("//*[@aria-label='check']/parent::button"))
		return this
	}
	
	public AssignJobPopup clickCloseChange() {
		WebUI.click(xpath("//*[@aria-label='close']/parent::button"))
		return this
	}
	
	public AssignJobPopup selectAssignType(String type) {
		//2 type supplier and supplier_group
		WebUI.click(xpath("//*[@value='$type']/parent::span"))
		return this
	}
	
	public AssignJobPopup selectSupplierGroup(String supplierGroup) {
		WebUI.click(xpath("//*[@value='supplier_group']/ancestor::div[@class='ant-space-item']//child::div[@class='ant-select-selector']"))
		WebUI.click(xpath("//*[@id='rc_select_5_list']/following-sibling::div[@class='rc-virtual-list']//div[text()='$supplierGroup']"))
		return this
	}
	
	public AssignJobPopup selectSupplier(String supplier) {
		WebUI.click(xpath("//*[@value='supplier']/ancestor::div[@class='ant-space-item']//child::div[@class='ant-select-selector']"))
		WebUI.click(xpath("rc_select_6_list']/following-sibling::div[@class='rc-virtual-list']//div[text()='$supplier']"))
		return this
	}
	
	public AssignJobPopup inputDeliveryDate(String deliveryDate) {
		WebUI.click(xpath("(//*[@class='ant-table-tbody']//span[@aria-label='edit'])[1]"))
		WebUI.sendKeys(xpath("//input[@id='form-inline-adaptDeliveryDateForSupplier_adaptDeliveryDateForSupplier']"), deliveryDate + Keys.RETURN)
		return this
	}
	
	public AssignJobPopup inputSupplierPrice(String price) {
		WebUI.click(xpath("(//*[@class='ant-table-tbody']//span[@aria-label='edit'])[2]"))
		clearTextAndSendKeysByActions(xpath("//*[@id='form-inline-unitPrice']"), price)
		return this
	}
}
