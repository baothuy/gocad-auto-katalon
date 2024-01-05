package gocad.buyer

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage
import katalon.utility.CommonUtility
import internal.GlobalVariable


public class RequestedOffersPage extends BasePage<RequestedOffersPage>{

	def rowOfProject = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr")}
	def projectIdCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[1]")}
	def projectNameCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[2]")}
	def deliveryDateCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[5]")}
	def orderNumberCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[6]")}
	def grossTotalCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[7]")}
	def statusCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[8]//span[normalize-space(text()) != '']")}
	def actionCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[10]/a")}
	def row = { String row -> return "//thead/following::tr[$row]"}
	def rowByStatus = { String status -> return "(//span[normalize-space(text()) = '$status']/ancestor::tr)[1]"}
	def contentRequestedOffersPage = "The folder Requested Offers shows all your projects where you have placed an order or requested a quotation. The current status of the project can be seen in the column \"status\"."

	public RequestedOffersPage clickAction(String projectId) {
		WebUI.click(actionCol(projectId))
		return this
	}
	
	public RequestedOffersPage clickPaginationOption(String numberPage) {
		List<String> findObj = findTestObjects("//*[@class='ant-pagination-options']//div[@class='ant-select-selector']")
		if (findObj.size() != 0)
		{
			WebUI.click(xpath("//*[@class='ant-pagination-options']//div[@class='ant-select-selector']"))
			WebUI.click(xpath("//*[@class='ant-pagination-options']//following::div[@class='rc-virtual-list']//div[text()='$numberPage / page']"))
		}
		return this
	}

	public RequestedOffersPage verifyHighlightOnList(String projectId) {
		String backgroundColor = WebUI.getCSSValue(rowOfProject(projectId), 'background-color')
		String rgbaToHex = CommonUtility.rgbaToHex(backgroundColor)
		println "colorActual: $rgbaToHex"
		WebUI.verifyEqual(rgbaToHex, GlobalVariable.highlightListColor)
		return this
	}

	public RequestedOffersPage verifyProjectName(String projectId, String expectedResult) {
		String projectName = WebUI.getText(projectNameCol(projectId))
		WebUI.verifyEqual(projectName, expectedResult)
		return this
	}

	public RequestedOffersPage verifyDeliveryDate(String projectId, String expectedResult) {
		String deliveryDate = WebUI.getText(deliveryDateCol(projectId)).trim()
		println "deliveryDate: $deliveryDate"
		WebUI.verifyEqual(deliveryDate, expectedResult)
		return this
	}

	public RequestedOffersPage verifyOrderNumber(String projectId) {
		String orderNumber = WebUI.getText(orderNumberCol(projectId))
		String expectedResult = GlobalVariable.prefixOrderNumber+ projectId
		println "orderNumber: $orderNumber"
		WebUI.verifyEqual(orderNumber, expectedResult)
		return this
	}


	public RequestedOffersPage verifyGrossTotal(String projectId, String expectedResult) {
		String grossTotal = WebUI.getText(grossTotalCol(projectId)).trim()
		println "grossTotal: $grossTotal"
		WebUI.verifyEqual(grossTotal, expectedResult)
		return this
	}

	public RequestedOffersPage verifyStatus(String projectId, String expectedResult) {
		String status = WebUI.getText(statusCol(projectId))
		println "status: $status"
		WebUI.verifyEqual(status, expectedResult)
		return this
	}

	public List<String> getDataRow(String rowNumber) {
		String id = WebUI.getText(xpath(row(rowNumber) + "/td[1]"))
		String projectName = WebUI.getText(xpath(row(rowNumber) + "/td[2]//a"))
		String deliveryDate = WebUI.getText(xpath(row(rowNumber) + "/td[5]/div"))
		String orderNumber = WebUI.getText(xpath(row(rowNumber) + "/td[6]"))
		String grossTotal = WebUI.getText(xpath(row(rowNumber) + "/td[7]/div"))
		String status = WebUI.getText(xpath(row(rowNumber) + "/td[8]//span[normalize-space(text()) != '']"))
		List<String> dataRow = [id, projectName, deliveryDate, orderNumber, grossTotal, status]
		return dataRow
	}
	
	public List<String> getDataRowByStatus(String status) {
		String id = WebUI.getText(xpath(rowByStatus(status) + "/td[1]"))
		String projectName = WebUI.getText(xpath(rowByStatus(status) + "/td[2]//a"))
		String deliveryDate = WebUI.getText(xpath(rowByStatus(status) + "/td[5]/div"))
		String orderNumber = WebUI.getText(xpath(rowByStatus(status) + "/td[6]"))
		String grossTotal = WebUI.getText(xpath(rowByStatus(status) + "/td[7]/div"))
		List<String> dataRow = [id, projectName, deliveryDate, orderNumber, grossTotal, status]
		return dataRow
	}

	public RequestedOffersPage verifyUIVisible() {
		WebUI.verifyElementVisible(xpath("//h5[text()='Requested']"))
		WebUI.verifyElementVisible(xpath("//h5[text()='Requested']/following::i[text()='$contentRequestedOffersPage']"))
		//header table visible
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Id']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Project Name']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[text()='Parts']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Delivery Date']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Order Number']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='GROSS Total']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Status']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Created at']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[text()='Action']"))
		WebUI.verifyElementVisible(xpath("//ul[contains(@class,'ant-table-pagination')]"))
		return this
	}
}
