package gocad.seller

import org.openqa.selenium.Keys

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage
import katalon.utility.CommonUtility
import katalon.utility.DateTimeUtility






public class SearchInProjectsPopup extends BasePage<SearchInProjectsPopup>{

	def idCol = { String projectId -> return xpath("//div[@class='ant-modal-content']//tr[@data-row-key='project-$projectId']/td[1]")}
	def projectNameCol = { String projectId -> return xpath("//div[@class='ant-modal-content']//tr[@data-row-key='project-$projectId']/td[2]//a")}
	def companyNameCol = { String projectId -> return xpath("//div[@class='ant-modal-content']//tr[@data-row-key='project-$projectId']/td[3]")}
	def orderNumberCol = { String projectId -> return xpath("//div[@class='ant-modal-content']//tr[@data-row-key='project-$projectId']/td[4]")}
	def orderDateCol = { String projectId -> return xpath("//div[@class='ant-modal-content']//tr[@data-row-key='project-$projectId']/td[5]")}
	def NETTotalCol = { String projectId -> return xpath("//div[@class='ant-modal-content']//tr[@data-row-key='project-$projectId']/td[6]/div")}
	def statusCol = { String projectId -> return xpath("//div[@class='ant-modal-content']//tr[@data-row-key='project-$projectId']/td[7]//span[normalize-space(text()) != '']")}
	def actionCol = { String projectId -> return xpath("//div[@class='ant-modal-content']//tr[@data-row-key='project-$projectId']/td[8]/a")}
	def rowOfProject = { String projectId -> return xpath("//div[@class='ant-modal-content']//tr[@data-row-key='project-$projectId']")}
	def row = { String row -> return "//div[@class='ant-modal-content']//*[@class='ant-table-tbody']/tr[$row]"}

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
		WebUI.sendKeys(xpath("//input[@placeholder='Start date']"), date + Keys.RETURN)
		return this
	}

	public SearchInProjectsPopup inputEndDate(String date) {
		WebUI.sendKeys(xpath("//input[@placeholder='End date']"), date + Keys.RETURN)
		return this
	}

	public SearchInProjectsPopup clickCheckBoxUnread(String check) {
		String text = WebUI.getAttribute(xpath("//*[@id='unread']/parent::span"), "class")
		String isStatusCheck = text.contains("checked")
		boolean isChecked = check.equals("checked")
		if(Boolean.parseBoolean(isStatusCheck) != isChecked) {
			WebUI.click(xpath("//*[@id='unread']/parent::span"))
		}
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
		WebUI.click(xpath("//span[@class='ant-select-selection-item-remove']/child::span[@aria-label='close']"))
		return this
	}

	public SearchInProjectsPopup clearSearchDate() {
		WebUI.click(xpath("//span[@class='ant-picker-clear']/span[@aria-label='close-circle']"))
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

	public SearchInProjectsPopup verifyHaveRowVisibleInList(String rowNumber) {
		WebUI.verifyElementVisible(xpath(row(rowNumber)))
		return this
	}

	public SearchInProjectsPopup verifyProjectNameVisibleInList(String projectId, String expectedProjectName) {
		String actualProjectName = WebUI.getText(projectNameCol(projectId))
		WebUI.verifyEqual(actualProjectName, expectedProjectName)
		return this
	}

	public SearchInProjectsPopup verifyCompanyNameVisibleInList(String projectId, String expectedCompanyName) {
		String actualProjectName = WebUI.getText(companyNameCol(projectId))
		WebUI.verifyEqual(actualProjectName, expectedCompanyName)
		return this
	}

	public SearchInProjectsPopup verifyOrderNumberVisibleInList(String projectId, String orderNumber) {
		String actualOrderNumber = WebUI.getText(orderNumberCol(projectId))
		WebUI.verifyEqual(actualOrderNumber, orderNumber)
		return this
	}

	public SearchInProjectsPopup verifyOrderDateVisibleInList(String projectId, String date) {
		String newDay = DateTimeUtility.changeDateFormat(date, "yyyy-MM-dd", "MM/dd/yyyy")
		String actualDate = WebUI.getText(orderDateCol(projectId)).trim()
		WebUI.verifyEqual(actualDate, newDay)
		return this
	}

	public SearchInProjectsPopup verifyNETTotalVisibleInList(String projectId, String total) {
		String actualStatus = WebUI.getText(NETTotalCol(projectId))
		WebUI.verifyEqual(actualStatus, total)
		return this
	}

	public SearchInProjectsPopup verifyStatusVisibleInList(String projectId, String status) {
		String actualStatus = WebUI.getText(statusCol(projectId))
		WebUI.verifyEqual(actualStatus, status)
		return this
	}

	public SearchInProjectsPopup verifyHighlightOnList(String projectId) {
		String backgroundColor = WebUI.getCSSValue(rowOfProject(projectId), 'background-color')
		String rgbaToHex = CommonUtility.rgbaToHex(backgroundColor)
		WebUI.verifyEqual(rgbaToHex, "#FFF8E6")
		return this
	}

	public SearchInProjectsPopup verifyUIVisible() {
		WebUI.verifyElementVisible(xpath("//*[@id='text']"))
		WebUI.verifyElementVisible(xpath("//div[@class='ant-select-selector']//span[text()='Status']"))
		WebUI.verifyElementVisible(xpath("//input[@placeholder='Start date']"))
		WebUI.verifyElementVisible(xpath("//input[@placeholder='End date']"))
		WebUI.verifyElementVisible(xpath("//span[contains(@class,'ant-checkbox')]"))
		WebUI.verifyElementVisible(xpath("//span[text()='Mark as Unread']"))
		WebUI.verifyElementVisible(xpath("//span[text()='Search']"))
		//header table visible
		WebUI.verifyElementVisible(xpath("//div[@class='ant-modal-content']//thead[@class='ant-table-thead']/tr/th[@aria-label='Id']"))
		WebUI.verifyElementVisible(xpath("//div[@class='ant-modal-content']//thead[@class='ant-table-thead']/tr/th[@aria-label='Project Name']"))
		WebUI.verifyElementVisible(xpath("//div[@class='ant-modal-content']//thead[@class='ant-table-thead']/tr/th[@aria-label='Company']"))
		WebUI.verifyElementVisible(xpath("//div[@class='ant-modal-content']//thead[@class='ant-table-thead']/tr/th[@aria-label='Order Number']"))
		WebUI.verifyElementVisible(xpath("//div[@class='ant-modal-content']//thead[@class='ant-table-thead']/tr/th[@aria-label='Order date']"))
		WebUI.verifyElementVisible(xpath("//div[@class='ant-modal-content']//thead[@class='ant-table-thead']/tr/th[@aria-label='NET Total']"))
		WebUI.verifyElementVisible(xpath("//div[@class='ant-modal-content']//thead[@class='ant-table-thead']/tr/th[@aria-label='Status']"))
		WebUI.verifyElementVisible(xpath("//div[@class='ant-modal-content']//thead[@class='ant-table-thead']/tr/th[text()='Action']"))
		return this
	}
}
