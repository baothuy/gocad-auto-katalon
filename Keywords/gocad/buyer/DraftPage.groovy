package gocad.buyer

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import katalon.fw.lib.BasePage
import internal.GlobalVariable

public class DraftPage extends BasePage<DraftPage>{

	def rowOfProject = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr")}
	def projectIdCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[1]")}
	def projectNameCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[2]")}
	def partsCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[3]/span")}
	def imagesCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[4]")}
	def statusCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[5]/span")}
	def actionViewCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[7]//button[1]")}
	def actionMoreCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[7]//button[2]")}
	def row = { String row -> return "//thead/following::tr[$row]/"}
	
	String contentDraftPage = "The folder Draft shows your projects and part calculations that have not yet been placed as order."

	public DraftPage clickViewAction(String projectId) {
		WebUI.click(actionViewCol(projectId))
		return this
	}

	public DraftPage clickArchiveAction(String projectId) {
		WebUI.mouseOver(actionMoreCol(projectId))
		WebUI.click(xpath("//span[text()='Archive']"))
		return this
	}

	public DraftPage clickPaging(String paging) {
		WebUI.click(xpath("//input[@id='rc_select_21']/ancestor::div[@class='ant-select-selector']"))
		WebUI.click(xpath("//div[contains(@class, 'ant-select-item') and @title='$paging']"))
		return this
	}

	public DraftPage clickDownCirclePartColumn(String projectId) {
		WebUI.click(partsCol(projectId))
		return this
	}

	public DraftPage verifyPartNameOnDetailPartColumn(String expectedResult) {
		String partName = WebUI.getText(xpath("//*[@class='ant-card-body']/div[contains(@class,'part-name')]"))
		WebUI.verifyEqual(partName, expectedResult)
		return this
	}

	public DraftPage verifyMaterialOnDetailPartColumn(String expectedResult) {
		String material = WebUI.getText(xpath("//*[@class='ant-card-body']/div/label"))
		WebUI.verifyEqual(material, expectedResult)
		return this
	}

	public DraftPage verifyPriceOnDetailPartColumn(String expectedResult) {
		String price = WebUI.getText(xpath("//*[@class='ant-card-body']//span[contains(text(),'€')]"))
		WebUI.verifyEqual(price, expectedResult)
		return this
	}

	public DraftPage verifyProjectName(String projectId, String expectedResult) {
		String projectName = WebUI.getText(projectNameCol(projectId))
		WebUI.verifyEqual(projectName, expectedResult)
		return this
	}

	public DraftPage verifyStatus(String projectId, String expectedResult) {
		String status = WebUI.getText(statusCol(projectId))
		WebUI.verifyEqual(status, expectedResult)
		return this
	}

	public DraftPage verifyProjectNotVisible(String projectId) {
		WebUI.verifyElementNotVisible(projectIdCol(projectId))
		return this
	}

	public String getProjectName(String projectId) {
		String projectName = WebUI.getText(projectNameCol(projectId))
		return projectName
	}

	public DraftPage verifyToastMessageWhenArchivedProject(String projectName) {
		def actualTitle = WebUI.getText(xpath("//*[@class='ant-notification-notice-message']"))
		def actualMessage = WebUI.getText(xpath("//*[@class='ant-notification-notice-description']"))
		def expectedTitle = "Archived!"
		def expectedMessage = "The project \'$projectName\' has been archived."
		WebUI.verifyEqual(actualTitle, expectedTitle)
		WebUI.verifyEqual(actualMessage, expectedMessage)
		return this
	}

	public DraftPage clickCloseToastMessage() {
		WebUI.waitForElementVisible(xpath("//*[@aria-label='close']/ancestor::a"), 5)
		WebUI.click(xpath("//*[@aria-label='close']/ancestor::a"))
		return this
	}

	public DraftPage verifyUIVisible() {
		WebUI.verifyElementVisible(xpath("//h5[text()='Draft']"))
		WebUI.verifyElementVisible(xpath("//h5[text()='Draft']/following::i[text()='$contentDraftPage']"))
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
