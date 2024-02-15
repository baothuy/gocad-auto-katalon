package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import katalon.fw.lib.BasePage





public class ManufacturingInformationReport extends BasePage<ManufacturingInformationReport>{

	public ManufacturingInformationReport clickEdit() {
		WebUI.click(xpath("//div[@class='ant-modal-content']//span[text()='Edit']/parent::button"))
		return this
	}

	public ManufacturingInformationReport clickSave() {
		WebUI.click(xpath("//div[@class='ant-modal-content']//span[text()='Save']/parent::button"))
		return this
	}

	public ManufacturingInformationReport clickPreview() {
		WebUI.click(xpath("//div[@class='ant-modal-content']//span[text()='Preview']/parent::button"))
		return this
	}

	public ManufacturingInformationReport clickCancel() {
		WebUI.click(xpath("//div[@class='ant-modal-content']//span[text()='Cancel']/parent::button"))
		return this
	}

	public ManufacturingInformationReport inputSetupSaw(String input) {
		clearTextAndSendKeysByActions(id("basic_setup_SAW_adaptTr"), input)
		return this
	}

	public ManufacturingInformationReport inputSetupInterimDeburring(String input) {
		clearTextAndSendKeysByActions(id("basic_setup_IDE_adaptTr"), input)
		return this
	}

	public ManufacturingInformationReport inputSetup3AxisMillingMachine(String input) {
		clearTextAndSendKeysByActions(id("basic_setup_M3M_adaptTr"), input)
		return this
	}

	public ManufacturingInformationReport inputSetupRoundingMachine(String input) {
		clearTextAndSendKeysByActions(id("basic_setup_RDM_adaptTr"), input)
		return this
	}

	public ManufacturingInformationReport inputProgramming3AxisMillingMachine(String input) {
		clearTextAndSendKeysByActions(id("basic_programming_M3M_adaptTime"), input)
		return this
	}

	public ManufacturingInformationReport inputProcessSaw(String input) {
		clearTextAndSendKeysByActions(id("basic_process_SAW_adaptTe"), input)
		return this
	}

	public ManufacturingInformationReport inputProcessInterimDeburring(String input) {
		clearTextAndSendKeysByActions(id("basic_process_IDE_adaptTe"), input)
		return this
	}

	public ManufacturingInformationReport inputProcess3AxisMillingMachine(String input) {
		clearTextAndSendKeysByActions(id("basic_process_M3M_adaptTe"), input)
		return this
	}

	public ManufacturingInformationReport inputProcessRoundingMachine(String input) {
		clearTextAndSendKeysByActions(id("basic_process_RDM_adaptTe"), input)
		return this
	}

	public ManufacturingInformationReport inputDiscount(String input) {
		WebUI.scrollToElement(xpath("//*[@title='Discount']/parent::div/following::input"), 0)
		clearTextAndSendKeysByActions(xpath("//*[@title='Discount']/parent::div/following::input"), input)
		return this
	}

	public ManufacturingInformationReport clickResetValue(String section, String machineName) {
		scrollToAndClick(xpath("//div[text()='$section']/parent::div//child::div[text()='$machineName']/following::div[2]//button"))
		return this
	}

	public ManufacturingInformationReport verifyMachinesVisible(String section, String machineName) {
		WebUI.verifyElementVisible(xpath("//div[text()='$section']/parent::div//child::div[text()='$machineName']"))
		return this
	}

	public ManufacturingInformationReport verifyTimeMachines(String section, String machineName, String expectedResult) {
		WebUI.getText(xpath("//div[text()='$section']/parent::div//child::div[text()='$machineName']/following-sibling::div[1]"))
		return this
	}

	public ManufacturingInformationReport verifySurfaceTreatmentsVisible(String section, String materialName) {
		WebUI.verifyElementVisible(xpath("//div[text()='$section']/parent::div//child::div[text()='$materialName']"))
		return this
	}

	public ManufacturingInformationReport verifyEditButtonVisible() {
		WebUI.verifyElementVisible(xpath("//div[@class='ant-modal-content']//span[text()='Edit']/parent::button"))
		return this
	}

	public ManufacturingInformationReport verifyCancelButtonVisible() {
		WebUI.verifyElementVisible(xpath("//div[@class='ant-modal-content']//span[text()='Cancel']/parent::button"))
		return this
	}

	public ManufacturingInformationReport verifyUnitPriceOnManufacturingReportPage(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Unit price']/ancestor::h5/span"))
		String conExpectedResult = expectedResult + " " + GlobalVariable.currency
		WebUI.verifyEqual(actualResult, conExpectedResult)
		return this
	}

	public String getUnitPriceValue() {
		String unitPrice = WebUI.getText(xpath("//*[text()='Unit price']/ancestor::h5/span"))
		return unitPrice
	}

	public ManufacturingInformationReport verifyUICommonVisible() {
		//title
		WebUI.verifyElementVisible(xpath("//*[@class='ant-modal-content']//*[text()='Manufacturing information']"))
		//Material section
		WebUI.verifyElementVisible(xpath("//*[@class='ant-modal-content']//*[text()='Material']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-modal-content']//*[text()='Blank dimension']"))
		WebUI.verifyElementVisible(xpath("(//*[@class='ant-modal-content']//*[@class='mini-group'])[1]//*[text()='Unit price']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-modal-content']//*[text()='Raw Part Type']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-modal-content']//*[text()='Length']"))
		//Set-up section head
		WebUI.verifyElementVisible(xpath("//div[text()='Set-up']/parent::div/div[2]/div[text()='Machines']"))
		WebUI.verifyElementVisible(xpath("//div[text()='Set-up']/parent::div/div[2]/div[text()='Time']"))
		WebUI.verifyElementVisible(xpath("//div[text()='Set-up']/parent::div/div[2]/div[text()='Price']"))
		//Programming time section head
		WebUI.verifyElementVisible(xpath("//div[text()='Programming time']/parent::div/div[2]/div[text()='Machines']"))
		WebUI.verifyElementVisible(xpath("//div[text()='Programming time']/parent::div/div[2]/div[text()='Time']"))
		WebUI.verifyElementVisible(xpath("//div[text()='Programming time']/parent::div/div[2]/div[text()='Price']"))
		//Processing time section head
		WebUI.verifyElementVisible(xpath("//div[text()='Processing time']/parent::div/div[2]/div[text()='Machines']"))
		WebUI.verifyElementVisible(xpath("//div[text()='Processing time']/parent::div/div[2]/div[text()='Time']"))
		WebUI.verifyElementVisible(xpath("//div[text()='Processing time']/parent::div/div[2]/div[text()='Price']"))
		//Discount
		WebUI.verifyElementVisible(xpath("//*[@class='ant-modal-content']//*[text()='Discount']"))
		//Unit price
		WebUI.verifyElementVisible(xpath("//*[text()='Unit price']/ancestor::h5/span"))
		return this
	}
}
