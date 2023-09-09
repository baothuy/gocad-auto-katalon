package gocad.buyer

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage
import katalon.utility.CommonUtility


public class ConfirmedOffersPageOfBuyer extends BasePage<ConfirmedOffersPageOfBuyer>{

	def rowOfProject = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr")}
	def projectIdCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[1]")}
	def projectNameCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[2]")}
	def deliveryDateCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[5]")}
	def orderNumberCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[6]")}
	def grossTotalCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[7]")}
	def statusCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[8]//span[2]")}
	def actionCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[10]/a")}
	def row = { String row -> return "//thead/following::tr[$row]/"}
	def contentConfirmedOffersPage = "The folder Confirmed Requests shows all projects that have been approved and are in progress."
	
	public ConfirmedOffersPageOfBuyer clickAction(String projectId) {
		WebUI.click(actionCol(projectId))
		return this
	}

	public ConfirmedOffersPageOfBuyer verifyHighlightOnList(String projectId) {
		String backgroundColor = WebUI.getCSSValue(rowOfProject(projectId), 'background-color')
		String rgbaToHex = CommonUtility.rgbaToHex(backgroundColor)
		WebUI.verifyEqual(rgbaToHex, "#FFF8E6")
		return this
	}

	public ConfirmedOffersPageOfBuyer verifyProjectName(String projectId, String expectedResult) {
		String projectName = WebUI.getText(projectNameCol(projectId))
		WebUI.verifyEqual(projectName, expectedResult)
		return this
	}

	public ConfirmedOffersPageOfBuyer verifyDeliveryDate(String projectId, String expectedResult) {
		String deliveryDate = WebUI.getText(deliveryDateCol(projectId)).trim()
		WebUI.verifyEqual(deliveryDate, expectedResult)
		return this
	}

	public ConfirmedOffersPageOfBuyer verifyOrderNumber(String projectId) {
		String orderNumber = WebUI.getText(orderNumberCol(projectId))
		String expectedResult = "GOCAD"+ projectId
		WebUI.verifyEqual(orderNumber, expectedResult)
		return this
	}


	public ConfirmedOffersPageOfBuyer verifyGrossTotal(String projectId, String expectedResult) {
		String grossTotal = WebUI.getText(grossTotalCol(projectId)).trim()
		WebUI.verifyEqual(grossTotal, expectedResult)
		return this
	}

	public ConfirmedOffersPageOfBuyer verifyStatus(String projectId, String expectedResult) {
		String status = WebUI.getText(statusCol(projectId))
		WebUI.verifyEqual(status, expectedResult)
		return this
	}
	
	public ConfirmedOffersPageOfBuyer verifyUIVisible() {
		WebUI.verifyElementVisible(xpath("//h5[text()='Confirmed Offers']"))
		WebUI.verifyElementVisible(xpath("//h5[text()='Confirmed Offers']/following::i[text()='$contentConfirmedOffersPage']"))
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
