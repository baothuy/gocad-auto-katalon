package gocad.buyer

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage
import katalon.utility.CommonUtility


public class ReceivedOffersPage extends BasePage<ReceivedOffersPage>{

	def rowOfProject = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr")}
	def projectIdCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[1]")}
	def projectNameCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[2]")}
	def deliveryDateCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[5]")}
	def orderNumberCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[6]")}
	def grossTotalCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[7]")}
	def statusCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[8]//span[2]")}
	def actionCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[10]/a")}

	public ReceivedOffersPage clickAction(String projectId) {
		WebUI.click(actionCol(projectId))
		return this
	}

	public ReceivedOffersPage verifyHighlightOnList(String projectId) {
		String backgroundColor = WebUI.getCSSValue(rowOfProject(projectId), 'background-color')
		String rgbaToHex = CommonUtility.rgbaToHex(backgroundColor)
		println "colorActual: $rgbaToHex"
		WebUI.verifyEqual(rgbaToHex, "#FFF8E6")
		return this
	}

	public ReceivedOffersPage verifyProjectName(String projectId, String expectedResult) {
		String projectName = WebUI.getText(projectNameCol(projectId))
		WebUI.verifyEqual(projectName, expectedResult)
		return this
	}

	public ReceivedOffersPage verifyDeliveryDate(String projectId, String expectedResult) {
		String deliveryDate = WebUI.getText(deliveryDateCol(projectId)).trim()
		println "deliveryDate: $deliveryDate"
		WebUI.verifyEqual(deliveryDate, expectedResult)
		return this
	}

	public ReceivedOffersPage verifyOrderNumber(String projectId) {
		String orderNumber = WebUI.getText(orderNumberCol(projectId))
		String expectedResult = "GOCAD"+ projectId
		println "orderNumber: $orderNumber"
		WebUI.verifyEqual(orderNumber, expectedResult)
		return this
	}


	public ReceivedOffersPage verifyGrossTotal(String projectId, String expectedResult) {
		String grossTotal = WebUI.getText(grossTotalCol(projectId)).trim()
		println "grossTotal: $grossTotal"
		WebUI.verifyEqual(grossTotal, expectedResult)
		return this
	}

	public ReceivedOffersPage verifyStatus(String projectId, String expectedResult) {
		String status = WebUI.getText(statusCol(projectId))
		println "status: $status"
		WebUI.verifyEqual(status, expectedResult)
		return this
	}
}
