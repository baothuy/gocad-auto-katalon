package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import katalon.fw.lib.BasePage

public class MyProjectsPage extends BasePage<MyProjectsPage>{

	def rowOfProject = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr")}
	def projectIdCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[1]")}
	def projectNameCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[2]")}
	def partsCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[3]/span")}
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

	public MyProjectsPage clickCloseToastMessage() {
		WebUI.waitForElementVisible(xpath("//*[@aria-label='close']/ancestor::a"), 5)
		WebUI.click(xpath("//*[@aria-label='close']/ancestor::a"))
		return this
	}

	public MyProjectsPage clickDownCirclePartColumn(String projectId) {
		WebUI.click(partsCol(projectId))
		return this
	}

	public MyProjectsPage verifyPartNameOnDetailPartColumn(String expectedResult) {
		String partName = WebUI.getText(xpath("//*[@class='ant-card-body']/div[contains(@class,'part-name')]"))
		WebUI.verifyEqual(partName, expectedResult)
		return this
	}

	public MyProjectsPage verifyMaterialOnDetailPartColumn(String expectedResult) {
		String material = WebUI.getText(xpath("//*[@class='ant-card-body']/div/label"))
		WebUI.verifyEqual(material, expectedResult)
		return this
	}

	public MyProjectsPage verifyPriceOnDetailPartColumn(String expectedResult) {
		String price = WebUI.getText(xpath("//*[@class='ant-card-body']//*[contains(text(),'$GlobalVariable.currency')]"))
		WebUI.verifyEqual(price, expectedResult)
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
