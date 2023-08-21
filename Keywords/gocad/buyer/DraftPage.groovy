package gocad.buyer

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import katalon.fw.lib.BasePage
import internal.GlobalVariable

public class DraftPage extends BasePage<DraftPage>{

	def rowOfProject = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr")}
	def projectIdCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[1]")}
	def projectNameCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[2]")}
	def partsCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[3]")}
	def imagesCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[4]")}
	def statusCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[5]/span")}
	def actionCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[7]/a")}

	public DraftPage clickAction(String projectId) {
		WebUI.click(actionCol(projectId))
		return this
	}
	
	public DraftPage clickPaging(String paging) {
		WebUI.click(xpath("//input[@id='rc_select_21']/ancestor::div[@class='ant-select-selector']"))
		WebUI.click(xpath("//div[contains(@class, 'ant-select-item') and @title='$paging']"))
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
}
