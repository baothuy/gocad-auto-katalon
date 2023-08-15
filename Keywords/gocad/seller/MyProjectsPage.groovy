package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage

public class MyProjectsPage extends BasePage<MyProjectsPage>{
	
	def rowOfProject = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr")}
	def projectIdCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[1]")}
	def projectNameCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[2]")}
	def partsDropdownCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[3]")}
	def partsImageCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[4]")}
	def statusCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[5]")}
	def createAtCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[6]")}
	def actionCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[7]/a")}

	public MyProjectsPage clickAddProject() {
		WebUI.click(xpath("//span[text()=' Add Project']/parent::button"))
		return this
	}
	
	public MyProjectsPage clickAction(String projectId) {
		WebUI.click(actionCol(projectId))
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
}
