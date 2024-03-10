package gocad.seller

import org.openqa.selenium.Keys

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import gocad.common.ManufacturingInformationPage
import katalon.fw.lib.BasePage




public class OpenJobsPage extends BasePage<OpenJobsPage>{

	public OpenJobsPage clickSelectJobs(String partName) {
		WebUI.click(xpath("(//span[text()='$partName']/preceding-sibling::span)[1]"))
		return this
	}
	
	public OpenJobsPage clickFirstJobsToAssign() {
		WebUI.click(xpath("(//*[@class='ant-space-item']//input[@type='checkbox'])[1]"))
		return this
	}

	public OpenJobsPage clickAssign() {
		WebUI.click(xpath("//span[text()='Assign']/parent::button"))
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
	
	public AssignJobPopup inputNoteToSupplier(String input) {
		WebUI.click(xpath("(//*[text()='Note to supplier']/following::div[@class='textarea-inline']//span)[1]"))
		WebUI.sendKeys(xpath("//*[@id='form-inline-sellerNote_sellerNote']"), input)
		WebUI.click(xpath("//*[text()='Save']/parent::button"))
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
	
	public AssignJobPopup clickViewProject() {
		WebUI.click(xpath("(//*[text()='Click to view project'])[1]"))
		return this
	}
	
	public ManufacturingInformationPage verifyManufacturingInformationReportButtonVisible() {
		WebUI.verifyElementVisible(xpath("(//span[text()=' Manufacturing information']/parent::button)[1]"))
		return this
	}

	public ManufacturingInformationPage verifyProcessingReportButtonVisible() {
		WebUI.verifyElementVisible(xpath("(//span[text()=' Processing report']/parent::button)[1]"))
		return this
	}

	public ManufacturingInformationPage verifyEmissionReportButtonVisible() {
		WebUI.verifyElementVisible(xpath("(//span[text()=' Emission report']/parent::button)[1]"))
		return this
	}
	
	public ManufacturingInformationPage clickDownloadImage() {
		WebUI.click(xpath('(//a[@class="text-decoration-none"])[1]'))
		return this
	}
}
