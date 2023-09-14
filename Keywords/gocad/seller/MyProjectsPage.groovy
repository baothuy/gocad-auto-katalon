package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage

public class MyProjectsPage extends BasePage<MyProjectsPage>{

	def rowOfProject = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr")}
	def projectIdCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[1]")}
	def projectNameCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[2]")}
	def partsDropdownCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[3]")}
	def partsImageCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[4]")}
	def statusCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[5]//span[normalize-space(text()) != '']")}
	def createAtCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[6]")}
	def actionViewCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[7]//button[1]")}
	def actionMoreCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[7]//button[2]")}
	def row = { String row -> return "//*[@class='ant-table-tbody']/tr[$row]"}

	public MyProjectsPage clickAddProject() {
		WebUI.click(xpath("//span[text()=' Add Project']/parent::button"))
		return this
	}

	public MyProjectsPage clickViewAction(String projectId) {
		WebUI.click(actionViewCol(projectId))
		return this
	}

	public MyProjectsPage clickArchiveAction(String projectId) {
		WebUI.click(actionMoreCol(projectId))
		WebUI.click(xpath("//*[text()='Archive']"))
		return this
	}

	public MyProjectsPage verifyProjectName(String projectId, String expectedResult) {
		String projectName = WebUI.getText(projectNameCol(projectId))
		WebUI.verifyEqual(projectName, expectedResult)
		return this
	}

	public MyProjectsPage verifyStatus(String projectId, String expectedResult) {
		String status = WebUI.getText(statusCol(projectId))
		WebUI.verifyEqual(status, expectedResult)
		return this
	}

	public MyProjectsPage verifyViewActionVisible(String projectId) {
		WebUI.verifyElementVisible(actionViewCol(projectId))
		return this
	}

	public MyProjectsPage verifyMoreActionVisible(String projectId) {
		WebUI.verifyElementVisible(actionMoreCol(projectId))
		return this
	}

	public MyProjectsPage verifyArchiveActionVisible(String projectId) {
		WebUI.click(actionMoreCol(projectId))
		WebUI.verifyElementVisible(xpath("//*[text()='Archive']"))
		return this
	}

	public List<String> getDataRow(String rowNumber) {
		String id = WebUI.getText(xpath(row(rowNumber) + "/td[1]"))
		String projectName = WebUI.getText(xpath(row(rowNumber) + "/td[2]"))
		String status = WebUI.getText(xpath(row(rowNumber) + "/td[5]//span[normalize-space(text()) != '']"))
		List<String> dataRow = [id, projectName, status]
		return dataRow
	}

	public MyProjectsPage verifyUIVisible() {
		WebUI.verifyElementVisible(xpath("//h4[text()='My Projects']"))
		WebUI.verifyElementVisible(xpath("//*[text()=' Add Project']/parent::button"))
		//header table visible
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Id']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Project Name']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[text()='Parts']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Status']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Created at']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[text()='Action']"))
		WebUI.verifyElementVisible(xpath("//ul[contains(@class,'ant-table-pagination')]"))
		return this
	}
}
