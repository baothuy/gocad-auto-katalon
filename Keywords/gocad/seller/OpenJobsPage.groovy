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

	public OpenJobsPage inputDeliveryDate(String deliveryDate) {
		WebUI.click(xpath("(//*[@class='ant-table-tbody']//span[@aria-label='edit'])[1]"))
		WebUI.sendKeys(xpath("//input[@id='form-inline-adaptDeliveryDateForSupplier_adaptDeliveryDateForSupplier']"), deliveryDate + Keys.RETURN)
		return this
	}

	public OpenJobsPage inputSupplierPrice(String price) {
		WebUI.click(xpath("(//*[@class='ant-table-tbody']//span[@aria-label='edit'])[2]"))
		clearTextAndSendKeysByActions(xpath("//*[@id='form-inline-unitPrice']"), price)
		return this
	}

	public OpenJobsPage inputNoteToSupplier(String input) {
		WebUI.click(xpath("(//*[text()='Note to supplier']/following::div[@class='textarea-inline']//span)[1]"))
		WebUI.sendKeys(xpath("//*[@id='form-inline-sellerNote_sellerNote']"), input)
		WebUI.click(xpath("//*[text()='Save']/parent::button"))
		return this
	}

	public OpenJobsPage clickAcceptChange() {
		WebUI.click(xpath("//*[@aria-label='check']/parent::button"))
		return this
	}

	public OpenJobsPage clickCloseChange() {
		WebUI.click(xpath("//*[@aria-label='close']/parent::button"))
		return this
	}

	public OpenJobsPage clickViewProject(String projectName) {
		WebUI.click(xpath("(//a[text()='$projectName'])[1]"))
		return this
	}

	public OpenJobsPage verifyManufacturingInformationReportButtonVisible() {
		WebUI.verifyElementVisible(xpath("(//span[text()=' Manufacturing information']/parent::button)[1]"))
		return this
	}

	public OpenJobsPage verifyProcessingReportButtonVisible() {
		WebUI.verifyElementVisible(xpath("(//span[text()=' Processing report']/parent::button)[1]"))
		return this
	}

	public OpenJobsPage verifyEmissionReportButtonVisible() {
		WebUI.verifyElementVisible(xpath("(//span[text()=' Emission report']/parent::button)[1]"))
		return this
	}

	public OpenJobsPage clickDownloadImage() {
		WebUI.click(xpath('(//a[@class="text-decoration-none"])[1]'))
		return this
	}
}
