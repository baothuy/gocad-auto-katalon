package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage
import katalon.utility.CommonUtility


public class OpenInquiriesPage extends BasePage<OpenInquiriesPage>{

	def rowOfProject = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr")}
	def projectIdCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[1]")}
	def projectNameCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[2]")}
	def companyNameCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[3]")}
	def orderNumberCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[4]")}
	def orderDateCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[5]")}
	def netTotalCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[6]")}
	def statusCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[7]//span[2]")}
	def actionCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[8]/a")}

	public OpenInquiriesPage clickAction(String projectId) {
		WebUI.click(actionCol(projectId))
		return this
	}

	public OpenInquiriesPage verifyHighlightOnList(String projectId) {
		String backgroundColor = WebUI.getCSSValue(rowOfProject(projectId), 'background-color')
		String rgbaToHex = CommonUtility.rgbaToHex(backgroundColor)
		println "colorActual: $rgbaToHex"
		WebUI.verifyEqual(rgbaToHex, "#FFF8E6")
		return this
	}

	public OpenInquiriesPage verifyProjectName(String projectId, String expectedResult) {
		String projectName = WebUI.getText(projectNameCol(projectId))
		WebUI.verifyEqual(projectName, expectedResult)
		return this
	}

	public OpenInquiriesPage verifyCompanyName(String projectId, String expectedResult) {
		String companyName = WebUI.getText(companyNameCol(projectId))
		println "companyName: $companyName"
		WebUI.verifyEqual(companyName, expectedResult)
		return this
	}

	public OpenInquiriesPage verifyOrderNumber(String projectId) {
		String orderNumber = WebUI.getText(orderNumberCol(projectId))
		String expectedResult = "GOCAD"+ projectId
		println "orderNumber: $orderNumber"
		WebUI.verifyEqual(orderNumber, expectedResult)
		return this
	}

	public OpenInquiriesPage verifyOrderDate(String projectId, String expectedResult) {
		String orderDate = WebUI.getText(orderDateCol(projectId))
		println "orderDate: $orderDate"
		WebUI.verifyEqual(orderDate, expectedResult)
		return this
	}

	public OpenInquiriesPage verifyNetTotal(String projectId, String expectedResult) {
		String netTotal = WebUI.getText(netTotalCol(projectId))
		println "netTotal: $netTotal"
		WebUI.verifyEqual(netTotal, expectedResult)
		return this
	}

	public OpenInquiriesPage verifyStatus(String projectId, String expectedResult) {
		String status = WebUI.getText(statusCol(projectId))
		println "status: $status"
		WebUI.verifyEqual(status, expectedResult)
		return this
	}
}
