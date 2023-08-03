package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage


public class OpenInquiriesPage extends BasePage<OpenInquiriesPage>{
	
	def projectIdCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[1]")}
	def projectNameCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[2]")}
	def companyNameCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[3]")}
	def orderNumberCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[4]")}
	def orderDateCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[5]")}
	def netTotalCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[6]")}
	def statusCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[7]")}
	def actionCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[8]/a")}
	
	public OpenInquiriesPage clickAction(String projectId) {
		WebUI.click(actionCol(projectId))
		return this
	}
}
