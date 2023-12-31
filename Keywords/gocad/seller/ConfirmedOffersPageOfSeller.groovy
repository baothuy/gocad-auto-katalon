package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage
import katalon.utility.CommonUtility
import internal.GlobalVariable


public class ConfirmedOffersPageOfSeller extends BasePage<ConfirmedOffersPageOfSeller>{

	def rowOfProject = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr")}
	def projectIdCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[1]")}
	def projectNameCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[2]")}
	def companyNameCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[3]")}
	def orderNumberCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[4]")}
	def orderDateCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[5]")}
	def netTotalCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[6]")}
	def statusCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[7]//span[normalize-space(text()) != '']")}
	def actionCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[9]/a")}
	def row = { String row -> return "//*[@class='ant-table-tbody']/tr[$row]/"}
	def contentPage = "The folder Confirmed Requests shows all projects that have been approved and are in progress."

	public ConfirmedOffersPageOfSeller clickAction(String projectId) {
		WebUI.click(actionCol(projectId))
		return this
	}

	public ConfirmedOffersPageOfSeller verifyHighlightOnList(String projectId) {
		String backgroundColor = WebUI.getCSSValue(rowOfProject(projectId), 'background-color')
		String rgbaToHex = CommonUtility.rgbaToHex(backgroundColor)
		println "colorActual: $rgbaToHex"
		WebUI.verifyEqual(rgbaToHex, "#FFF8E6")
		return this
	}

	public ConfirmedOffersPageOfSeller verifyProjectName(String projectId, String expectedResult) {
		String projectName = WebUI.getText(projectNameCol(projectId))
		WebUI.verifyEqual(projectName, expectedResult)
		return this
	}

	public ConfirmedOffersPageOfSeller verifyCompanyName(String projectId, String expectedResult) {
		String companyName = WebUI.getText(companyNameCol(projectId))
		println "companyName: $companyName"
		WebUI.verifyEqual(companyName, expectedResult)
		return this
	}

	public ConfirmedOffersPageOfSeller verifyOrderNumber(String projectId) {
		String orderNumber = WebUI.getText(orderNumberCol(projectId))
		String expectedResult = GlobalVariable.prefixOrderNumber+ projectId
		println "orderNumber: $orderNumber"
		WebUI.verifyEqual(orderNumber, expectedResult)
		return this
	}

	public ConfirmedOffersPageOfSeller verifyOrderDate(String projectId, String expectedResult) {
		String orderDate = WebUI.getText(orderDateCol(projectId))
		println "orderDate: $orderDate"
		WebUI.verifyEqual(orderDate, expectedResult)
		return this
	}

	public ConfirmedOffersPageOfSeller verifyNetTotal(String projectId, String expectedResult) {
		String netTotal = WebUI.getText(netTotalCol(projectId))
		println "netTotal: $netTotal"
		WebUI.verifyEqual(netTotal, expectedResult)
		return this
	}

	public ConfirmedOffersPageOfSeller verifyStatus(String projectId, String expectedResult) {
		String status = WebUI.getText(statusCol(projectId))
		println "status: $status"
		WebUI.verifyEqual(status, expectedResult)
		return this
	}

	public List<String> getDataRow(String rowNumber) {
		String id = WebUI.getText(xpath(row(rowNumber) + "td[1]"))
		String projectName = WebUI.getText(xpath(row(rowNumber) + "td[2]//a"))
		String companyName = WebUI.getText(xpath(row(rowNumber) + "td[3]"))
		String orderNumber = WebUI.getText(xpath(row(rowNumber) + "td[4]"))
		String orderDate = WebUI.getText(xpath(row(rowNumber) + "td[5]"))
		String NETTotal = WebUI.getText(xpath(row(rowNumber) + "td[6]/div"))
		String status = WebUI.getText(xpath(row(rowNumber) + "td[7]//span[normalize-space(text()) != '']"))
		List<String> dataRow = [id, projectName, companyName, orderNumber, orderDate, NETTotal, status]
		return dataRow
	}

	public ConfirmedOffersPageOfSeller verifyUIVisible() {
		WebUI.verifyElementVisible(xpath("//h5[text()='Confirmed']"))
		WebUI.verifyElementVisible(xpath("//h5[text()='Confirmed']/following::i[text()='$contentPage']"))
		//header table visible
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Id']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Project Name']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Company']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Order Number']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Order date']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='NET Total']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Status']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[text()='Action']"))
		WebUI.verifyElementVisible(xpath("//ul[contains(@class,'ant-table-pagination')]"))
		return this
	}
}
