package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import katalon.fw.lib.BasePage
import katalon.utility.CommonUtility


public class OpenInquiriesPage extends BasePage<OpenInquiriesPage>{

	def rowOfProject = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr")}
	def projectIdCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[1]")}
	def projectNameCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[2]")}
	def companyNameCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[3]")}
	def orderNumberCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[4]")}
	def orderDateCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[5]")}
	def netTotalCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[6]")}
	def statusCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[7]//span[normalize-space(text()) != '']")}
	def actionCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[8]/a")}
	def row = { String row -> return "//*[@class='ant-table-tbody']/tr[$row]"}
	def rowByStatus = { String status -> return "(//span[normalize-space(text()) = '$status']/ancestor::tr)[1]"}
	def contentPage = "The folder Open Inquiries shows your projects and part calculations that have not yet been sent to the customer."

	public OpenInquiriesPage clickAction(String projectId) {
		WebUI.click(actionCol(projectId))
		return this
	}
	
	public OpenInquiriesPage clickPaginationOption(String numberPage) {
		WebUI.click(xpath("//*[@class='ant-pagination-options']//div[@class='ant-select-selector']"))
		WebUI.click(xpath("//*[@class='ant-pagination-options']//following::div[@class='rc-virtual-list']//div[text()='$numberPage / page']"))
		return this
	}

	public OpenInquiriesPage verifyHighlightOnList(String projectId) {
		String backgroundColor = WebUI.getCSSValue(rowOfProject(projectId), 'background-color')
		String rgbaToHex = CommonUtility.rgbaToHex(backgroundColor)
		println "colorActual: $rgbaToHex"
		WebUI.verifyEqual(rgbaToHex, "#FFF8E6")
		return this
	}

	public OpenInquiriesPage verifyProjectName(String projectId, String expectedResult) {
		String projectName = WebUI.getText(projectNameCol(projectId))
		WebUI.verifyEqual(projectName, expectedResult)
		return this
	}

	public OpenInquiriesPage verifyCompanyName(String projectId, String expectedResult) {
		String companyName = WebUI.getText(companyNameCol(projectId))
		println "companyName: $companyName"
		WebUI.verifyEqual(companyName, expectedResult)
		return this
	}

	public OpenInquiriesPage verifyOrderNumber(String projectId) {
		String orderNumber = WebUI.getText(orderNumberCol(projectId))
		String expectedResult = GlobalVariable.prefixOrderNumber+ projectId
		println "orderNumber: $orderNumber"
		WebUI.verifyEqual(orderNumber, expectedResult)
		return this
	}

	public OpenInquiriesPage verifyOrderDate(String projectId, String expectedResult) {
		String orderDate = WebUI.getText(orderDateCol(projectId))
		println "orderDate: $orderDate"
		WebUI.verifyEqual(orderDate, expectedResult)
		return this
	}

	public OpenInquiriesPage verifyNetTotal(String projectId, String expectedResult) {
		String netTotal = WebUI.getText(netTotalCol(projectId))
		println "netTotal: $netTotal"
		WebUI.verifyEqual(netTotal, expectedResult)
		return this
	}

	public OpenInquiriesPage verifyStatus(String projectId, String expectedResult) {
		String status = WebUI.getText(statusCol(projectId))
		println "status: $status"
		WebUI.verifyEqual(status, expectedResult)
		return this
	}

	public List<String> getDataRow(String rowNumber) {
		String id = WebUI.getText(xpath(row(rowNumber) + "/td[1]"))
		String projectName = WebUI.getText(xpath(row(rowNumber) + "/td[2]//a"))
		String companyName = WebUI.getText(xpath(row(rowNumber) + "/td[3]"))
		String orderNumber = WebUI.getText(xpath(row(rowNumber) + "/td[4]"))
		String orderDate = WebUI.getText(xpath(row(rowNumber) + "/td[5]"))
		String NETTotal = WebUI.getText(xpath(row(rowNumber) + "/td[6]/div"))
		String status = WebUI.getText(xpath(row(rowNumber) + "/td[7]//span[normalize-space(text()) != '']"))
		List<String> dataRow = [id, projectName, companyName, orderNumber, orderDate, NETTotal, status]
		return dataRow
	}

	public List<String> getDataRowByStatus(String status) {
		String id = WebUI.getText(xpath(rowByStatus(status) + "/td[1]"))
		String projectName = WebUI.getText(xpath(rowByStatus(status) + "/td[2]//a"))
		String companyName = WebUI.getText(xpath(rowByStatus(status) + "/td[3]"))
		String orderNumber = WebUI.getText(xpath(rowByStatus(status) + "/td[4]"))
		String orderDate = WebUI.getText(xpath(rowByStatus(status) + "/td[5]"))
		String NETTotal = WebUI.getText(xpath(rowByStatus(status) + "/td[6]/div"))
		List<String> dataRow = [id, projectName, companyName, orderNumber, orderDate, NETTotal, status]
		return dataRow
	}

	public OpenInquiriesPage verifyUIVisible() {
		WebUI.verifyElementVisible(xpath("//h5[text()='Open inquiries']"))
		WebUI.verifyElementVisible(xpath("//h5[text()='Open inquiries']/following::i[text()='$contentPage']"))
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
