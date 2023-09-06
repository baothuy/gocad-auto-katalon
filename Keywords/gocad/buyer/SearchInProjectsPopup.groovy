package gocad.buyer

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage
import katalon.utility.CommonUtility






public class SearchInProjectsPopup extends BasePage<SearchInProjectsPopup>{

	def idCol = { String projectId -> return xpath("//div[@class='ant-modal-content']//tr[@data-row-key='project-$projectId']/td[1]")}
	def projectNameCol = { String projectId -> return xpath("//div[@class='ant-modal-content']//tr[@data-row-key='project-$projectId']/td[2]//a")}
	def partsCol = { String projectId -> return xpath("//div[@class='ant-modal-content']//tr[@data-row-key='project-$projectId']/td[3]")}
	def imagePartCol = { String projectId -> return xpath("//div[@class='ant-modal-content']//tr[@data-row-key='project-$projectId']/td[4]")}
	def deliveryDateCol = { String projectId -> return xpath("//div[@class='ant-modal-content']//tr[@data-row-key='project-$projectId']/td[5]/div")}
	def orderNumberCol = { String projectId -> return xpath("//div[@class='ant-modal-content']//tr[@data-row-key='project-$projectId']/td[6]")}
	def grossTotalCol = { String projectId -> return xpath("//div[@class='ant-modal-content']//tr[@data-row-key='project-$projectId']/td[7]/div")}
	def statusCol = { String projectId -> return xpath("//div[@class='ant-modal-content']//tr[@data-row-key='project-$projectId']/td[8]/span/span")}
	def createAtCol = { String projectId -> return xpath("//div[@class='ant-modal-content']//tr[@data-row-key='project-$projectId']/td[9]")}
	def actionCol = { String projectId -> return xpath("//div[@class='ant-modal-content']//tr[@data-row-key='project-$projectId']/td[10]")}
	def rowOfProject = { String projectId -> return xpath("//div[@class='ant-modal-content']//tr[@data-row-key='project-$projectId']")}
	def row = { String row -> return "//div[@class='ant-modal-content']//thead/following::tr[$row]/"}

	public SearchInProjectsPopup inputSearchTextField(String text) {
		WebUI.sendKeys(id("text"), text)
		return this
	}

	public SearchInProjectsPopup selectStatus(String status) {
		WebUI.click(xpath("//div[contains(@class, 'ant-select-in-form-item')]"))
		WebUI.click(xpath("//div[@class='rc-virtual-list']//div[@title='$status']"))
		return this
	}
	//yyyy-MM-dd
	public SearchInProjectsPopup inputStartDate(String date) {
		WebUI.sendKeys(xpath("//input[@placeholder='Start date']"), date)
		return this
	}

	public SearchInProjectsPopup inputEndDate(String date) {
		WebUI.sendKeys(xpath("//input[@placeholder='End date']"), date)
		return this
	}

	public SearchInProjectsPopup clickCheckBoxUnread(String check) {
		(check == "true") ? WebUI.click(xpath("//input[@id='unread']")) : "false"
		return this
	}

	public SearchInProjectsPopup clickSearch() {
		WebUI.click(xpath("//span[text()='Search']"))
		return this
	}

	public SearchInProjectsPopup clickCloseSearchPopup() {
		WebUI.click(xpath("//*[@class='ant-modal-close-x']"))
		return this
	}

	public SearchInProjectsPopup clearSearchText() {
		WebUI.click(xpath("//*[contains(@placeholder,'Search by')]/following::span[@class='ant-input-suffix']//span[@aria-label='close-circle']"))
		return this
	}

	public SearchInProjectsPopup clearSearchStatus() {
		WebUI.click(xpath("//div[@class='ant-select-selector']/following::span[@class='ant-select-clear']/span[@aria-label='close-circle']"))
		return this
	}

	public SearchInProjectsPopup clearSearchDate() {
		WebUI.click(xpath("//span[@class='ant-picker-clear']/span[@aria-label='close-circle']"))
		return this
	}

	public List<String> getDataRow(String rowNumber) {
		String id = WebUI.getText(xpath(row(rowNumber) + "td[1]"))
		String projectName = WebUI.getText(xpath(row(rowNumber) + "td[2]//a"))
		String deliveryDate = WebUI.getText(xpath(row(rowNumber) + "td[5]/div"))
		String orderNumber = WebUI.getText(xpath(row(rowNumber) + "td[6]"))
		String grossTotal = WebUI.getText(xpath(row(rowNumber) + "td[7]/div"))
		String status = WebUI.getText(xpath(row(rowNumber) + "td[8]/span/span"))
		List<String> dataRow = [id, projectName, deliveryDate, orderNumber, grossTotal, status]
		return dataRow
	}

	public SearchInProjectsPopup verifyProjectNameVisibleInList(String projectId, String expectedProjectName) {
		String actualProjectName = WebUI.getText(projectNameCol(projectId))
		WebUI.verifyEqual(actualProjectName, expectedProjectName)
		return this
	}
	
	public SearchInProjectsPopup verifyFileNameVisibleInList(String projectId, String expectedFileName) {
		String actualFileName = WebUI.getText(imagePartCol(projectId))
		WebUI.verifyEqual(actualFileName, expectedFileName)
		return this
	}
	
	public SearchInProjectsPopup verifyOrderNumberVisibleInList(String projectId, String orderNumber) {
		String actualOrderNumber = WebUI.getText(orderNumberCol(projectId))
		WebUI.verifyEqual(actualOrderNumber, orderNumber)
		return this
	}
	
	public SearchInProjectsPopup verifyStatusVisibleInList(String projectId, String status) {
		String actualStatus = WebUI.getText(statusCol(projectId))
		WebUI.verifyEqual(actualStatus, status)
		return this
	}
	
	public SearchInProjectsPopup verifyDeliveryDateVisibleInList(String projectId, String date) {
		String actualDate = WebUI.getText(deliveryDateCol(projectId))
		WebUI.verifyEqual(actualDate, date)
		return this
	}
	
	public ConfirmedOffersPageOfBuyer verifyHighlightOnList(String projectId) {
		String backgroundColor = WebUI.getCSSValue(rowOfProject(projectId), 'background-color')
		String rgbaToHex = CommonUtility.rgbaToHex(backgroundColor)
		WebUI.verifyEqual(rgbaToHex, "#FFF8E6")
		return this
	}

	public SearchInProjectsPopup verifyUIVisible() {
		WebUI.verifyElementVisible(id("text"))
		WebUI.verifyElementVisible(xpath("//div[@class='ant-select-selector']//span[text()='Status']"))
		WebUI.verifyElementVisible(xpath("//input[@placeholder='Start date']"))
		WebUI.verifyElementVisible(xpath("//input[@placeholder='End date']"))
		WebUI.verifyElementVisible(xpath("//span[contains(@class,'ant-checkbox')]"))
		WebUI.verifyElementVisible(xpath("//span[text()='Mark as Unread']"))
		WebUI.verifyElementVisible(xpath("//span[text()='Search']"))
		//header table visible
		WebUI.verifyElementVisible(xpath("//div[@class='ant-modal-content']//thead[@class='ant-table-thead']/tr/th[@aria-label='Id']"))
		WebUI.verifyElementVisible(xpath("//div[@class='ant-modal-content']//thead[@class='ant-table-thead']/tr/th[@aria-label='Project Name']"))
		WebUI.verifyElementVisible(xpath("//div[@class='ant-modal-content']//thead[@class='ant-table-thead']/tr/th[text()='Parts']"))
		WebUI.verifyElementVisible(xpath("//div[@class='ant-modal-content']//thead[@class='ant-table-thead']/tr/th[@aria-label='Delivery Date']"))
		WebUI.verifyElementVisible(xpath("//div[@class='ant-modal-content']//thead[@class='ant-table-thead']/tr/th[@aria-label='Order Number']"))
		WebUI.verifyElementVisible(xpath("//div[@class='ant-modal-content']//thead[@class='ant-table-thead']/tr/th[@aria-label='GROSS Total']"))
		WebUI.verifyElementVisible(xpath("//div[@class='ant-modal-content']//thead[@class='ant-table-thead']/tr/th[@aria-label='Status']"))
		WebUI.verifyElementVisible(xpath("//div[@class='ant-modal-content']//thead[@class='ant-table-thead']/tr/th[@aria-label='Created at']"))
		WebUI.verifyElementVisible(xpath("//div[@class='ant-modal-content']//thead[@class='ant-table-thead']/tr/th[text()='Action']"))
		return this
	}
}
