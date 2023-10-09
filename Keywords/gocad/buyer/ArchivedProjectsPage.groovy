package gocad.buyer

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import katalon.fw.lib.BasePage




public class ArchivedProjectsPage extends BasePage<ArchivedProjectsPage>{

	def rowOfProject = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr")}
	def projectIdCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[1]")}
	def projectNameCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[2]")}
	def partsCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[3]/span")}
	def imagesCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[4]")}
	def statusCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[5]//span[normalize-space(text()) != '']")}
	def actionViewCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[7]//button[1]")}
	def actionMoreCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[7]//button[2]")}
	def row = { String row -> return "//thead/following::tr[$row]/"}

	public ArchivedProjectsPage clickViewAction(String projectId) {
		WebUI.click(actionViewCol(projectId))
		return this
	}

	public ArchivedProjectsPage clickDeleteAction(String projectId) {
		WebUI.mouseOver(actionMoreCol(projectId))
		WebUI.click(xpath("//span[text()='Delete']"))
		return this
	}

	public ArchivedProjectsPage clickUnarchiveAction(String projectId) {
		WebUI.mouseOver(actionMoreCol(projectId))
		WebUI.click(xpath("//span[text()='Unarchive']"))
		return this
	}

	public ArchivedProjectsPage clickPaging(String paging) {
		WebUI.click(xpath("//input[@id='rc_select_21']/ancestor::div[@class='ant-select-selector']"))
		WebUI.click(xpath("//div[contains(@class, 'ant-select-item') and @title='$paging']"))
		return this
	}

	public ArchivedProjectsPage clickDownCirclePartColumn(String projectId) {
		WebUI.click(partsCol(projectId))
		return this
	}

	public List<String> getDataRow(String rowNumber) {
		String id = WebUI.getText(xpath(row(rowNumber) + "td[1]"))
		String projectName = WebUI.getText(xpath(row(rowNumber) + "td[2]//a"))
		String status = WebUI.getText(xpath(row(rowNumber) + "td[5]//span[normalize-space(text()) != '']"))
		List<String> dataRow = [id, projectName, status]
		return dataRow
	}

	public ArchivedProjectsPage verifyPartNameOnDetailPartColumn(String expectedResult) {
		String partName = WebUI.getText(xpath("//*[@class='ant-card-body']/div[contains(@class,'part-name')]"))
		WebUI.verifyEqual(partName, expectedResult)
		return this
	}

	public ArchivedProjectsPage verifyMaterialOnDetailPartColumn(String expectedResult) {
		String material = WebUI.getText(xpath("//*[@class='ant-card-body']/div/label"))
		WebUI.verifyEqual(material, expectedResult)
		return this
	}

	public ArchivedProjectsPage verifyPriceOnDetailPartColumn(String expectedResult) {
		String price = WebUI.getText(xpath("//*[@class='ant-card-body']//span[contains(text(),'$GlobalVariable.currency')]"))
		WebUI.verifyEqual(price, expectedResult)
		return this
	}

	public ArchivedProjectsPage verifyProjectName(String projectId, String expectedResult) {
		String projectName = WebUI.getText(projectNameCol(projectId))
		WebUI.verifyEqual(projectName, expectedResult)
		return this
	}

	public ArchivedProjectsPage verifyStatus(String projectId, String expectedResult) {
		String status = WebUI.getText(statusCol(projectId))
		WebUI.verifyEqual(status, expectedResult)
		return this
	}

	public ArchivedProjectsPage verifyProjectNotVisible(String projectId) {
		WebUI.verifyElementNotVisible(projectIdCol(projectId))
		return this
	}

	public String getProjectName(String projectId) {
		String projectName = WebUI.getText(projectNameCol(projectId))
		return projectName
	}

	public ArchivedProjectsPage verifyToastMessageWhenDeletedProject(String projectName) {
		def actualTitle = WebUI.getText(xpath("//*[@class='ant-notification-notice-message']"))
		def actualMessage = WebUI.getText(xpath("//*[@class='ant-notification-notice-description']"))
		def expectedTitle = "Deleted!"
		def expectedMessage = "The project has been successfully deleted."
		WebUI.verifyEqual(actualTitle, expectedTitle)
		WebUI.verifyEqual(actualMessage, expectedMessage)
		return this
	}

	public ArchivedProjectsPage verifyToastMessageWhenUnarchivedProject(String projectName) {
		def actualTitle = WebUI.getText(xpath("//*[@class='ant-notification-notice-message']"))
		def actualMessage = WebUI.getText(xpath("//*[@class='ant-notification-notice-description']"))
		def expectedTitle = "Unarchived"
		def expectedMessage = "The project \'$projectName\' has been unarchived."
		WebUI.verifyEqual(actualTitle, expectedTitle)
		WebUI.verifyEqual(actualMessage, expectedMessage)
		return this
	}

	public ArchivedProjectsPage clickCloseToastMessage() {
		WebUI.waitForElementVisible(xpath("//*[@aria-label='close']/ancestor::a"), 5)
		WebUI.click(xpath("//*[@aria-label='close']/ancestor::a"))
		return this
	}

	public ArchivedProjectsPage verifyUIVisible() {
		WebUI.verifyElementVisible(xpath("//h5[text()='Archived Projects']"))
		//header table visible
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Id']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Project Name']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[text()='Parts']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Status']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Created at']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[text()='Action']"))
		return this
	}
}
