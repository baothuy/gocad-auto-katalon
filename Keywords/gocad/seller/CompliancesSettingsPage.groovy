package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage


public class CompliancesSettingsPage extends BasePage<CompliancesSettingsPage>{
	
	def idCol = { String name -> return xpath("//*[text()='$name']/parent::tr/td[1]")}
	def nameCol = { String name -> return xpath("//*[text()='$name']/parent::tr/td[2]/button")}
	def editActionCol = { String name -> return xpath("//*[text()='$name']/parent::tr/td[3]//span[text()=' Edit']")}
	def moreActionCol = { String name -> return xpath("//*[text()='$name']/parent::tr/td[3]//button[2]")}
	
	public CompliancesSettingsPage clickEditButton(String name) {
		WebUI.click(editActionCol(name))
		return this
	}
	
	public CompliancesSettingsPage clickMoreButton(String name) {
		WebUI.click(moreActionCol(name))
		return this
	}
	
	public CompliancesSettingsPage clickDeleteButton() {
		WebUI.click(xpath("//*[text()='Delete']"))
		return this
	}
	
	public CompliancesSettingsPage clickAddComplianceButton() {
		WebUI.click(xpath("//span[text()='Add compliance']"))
		return this
	}
	
	public CompliancesSettingsPage inputName(String name) {
		clearTextAndSendKeysByActions(xpath("//input[@id='basic_name']"), name)
		return this
	}
	
	public CompliancesSettingsPage clickOKButton() {
		WebUI.click(xpath("//span[text()='OK']"))
		return this
	}
	
	public CompliancesSettingsPage clickCancelButton() {
		WebUI.click(xpath("//span[text()='Cancel']"))
		return this
	}
	
	public CompliancesSettingsPage verifyUIVisible() {
		WebUI.verifyElementVisible(xpath("//span[text()='Add compliance']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Id']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Name']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Action']"))
		return this
	}
}
