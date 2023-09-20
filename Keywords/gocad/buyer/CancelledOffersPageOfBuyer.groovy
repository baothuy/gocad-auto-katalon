package gocad.buyer

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage
import katalon.utility.CommonUtility


public class CancelledOffersPageOfBuyer extends BasePage<CancelledOffersPageOfBuyer>{

	def rowOfProject = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr")}
	def projectIdCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[1]")}
	def projectNameCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[2]")}
	def deliveryDateCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[5]")}
	def orderNumberCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[6]")}
	def grossTotalCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[7]")}
	def statusCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[8]//span[normalize-space(text()) != '']")}
	def actionCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[10]/a")}
	def row = { String row -> return "//thead/following::tr[$row]/"}
	def contentCancelledOffersPage = "The folder Cancelled Orders contains projects which have been cancelled either by you or by us."

	public CancelledOffersPageOfBuyer clickAction(String projectId) {
		WebUI.click(actionCol(projectId))
		return this
	}

	public CancelledOffersPageOfBuyer verifyHighlightOnList(String projectId) {
		String backgroundColor = WebUI.getCSSValue(rowOfProject(projectId), 'background-color')
		String rgbaToHex = CommonUtility.rgbaToHex(backgroundColor)
		println "colorActual: $rgbaToHex"
		WebUI.verifyEqual(rgbaToHex, "#FFF8E6")
		return this
	}

	public CancelledOffersPageOfBuyer verifyProjectName(String projectId, String expectedResult) {
		String projectName = WebUI.getText(projectNameCol(projectId))
		WebUI.verifyEqual(projectName, expectedResult)
		return this
	}

	public CancelledOffersPageOfBuyer verifyDeliveryDate(String projectId, String expectedResult) {
		String deliveryDate = WebUI.getText(deliveryDateCol(projectId)).trim()
		println "deliveryDate: $deliveryDate"
		WebUI.verifyEqual(deliveryDate, expectedResult)
		return this
	}

	public CancelledOffersPageOfBuyer verifyOrderNumber(String projectId) {
		String orderNumber = WebUI.getText(orderNumberCol(projectId))
		String expectedResult = "GOCAD"+ projectId
		println "orderNumber: $orderNumber"
		WebUI.verifyEqual(orderNumber, expectedResult)
		return this
	}


	public CancelledOffersPageOfBuyer verifyGrossTotal(String projectId, String expectedResult) {
		String grossTotal = WebUI.getText(grossTotalCol(projectId)).trim()
		println "grossTotal: $grossTotal"
		WebUI.verifyEqual(grossTotal, expectedResult)
		return this
	}

	public CancelledOffersPageOfBuyer verifyStatus(String projectId, String expectedResult) {
		String status = WebUI.getText(statusCol(projectId))
		println "status: $status"
		WebUI.verifyEqual(status, expectedResult)
		return this
	}

	public CancelledOffersPageOfBuyer verifyUIVisible() {
		WebUI.verifyElementVisible(xpath("//h5[text()='Cancelled Offers']"))
		WebUI.verifyElementVisible(xpath("//h5[text()='Cancelled Offers']/following::i[text()='$contentCancelledOffersPage']"))
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

	public List<String> getDataRow(String rowNumber) {
		String id = WebUI.getText(xpath(row(rowNumber) + "td[1]"))
		String projectName = WebUI.getText(xpath(row(rowNumber) + "td[2]//a"))
		String deliveryDate = WebUI.getText(xpath(row(rowNumber) + "td[5]/div"))
		String orderNumber = WebUI.getText(xpath(row(rowNumber) + "td[6]"))
		String grossTotal = WebUI.getText(xpath(row(rowNumber) + "td[7]/div"))
		String status = WebUI.getText(xpath(row(rowNumber) + "td[8]//span[normalize-space(text()) != '']"))
		List<String> dataRow = [id, projectName, deliveryDate, orderNumber, grossTotal, status]
		return dataRow
	}
}
