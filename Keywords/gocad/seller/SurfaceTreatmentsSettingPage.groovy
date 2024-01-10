package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage


public class SurfaceTreatmentsSettingPage extends BasePage<SurfaceTreatmentsSettingPage>{

	def idCol = { String method -> return xpath("//*[text()='$method']/parent::tr/td[1]")}
	def ABBRCol = { String method -> return xpath("//*[text()='$method']/parent::tr/td[2]")}
	def methodCol = { String method -> return xpath("//*[text()='$method']/parent::tr/td[3]")}
	def pricePerAreaCol = { String method -> return xpath("//*[text()='$method']/parent::tr/td[4]")}
	def pricePerKgCol = { String method -> return xpath("//*[text()='$method']/parent::tr/td[5]")}
	def setupCostCol = { String method -> return xpath("//*[text()='$method']/parent::tr/td[6]")}
	def minOrderCol = { String method -> return xpath("//*[text()='$method']/parent::tr/td[7]")}
	def deliveryWeekCol = { String method -> return xpath("//*[text()='$method']/parent::tr/td[8]")}
	def materialGroup = { String method -> return xpath("//*[text()='$method']/parent::tr/td[9]")}
	def status = { String method -> return xpath("//*[text()='$method']/parent::tr/td[10]//span[normalize-space(text()) != '']")}
	def editAction = { String method -> return xpath("//*[text()='$method']/parent::tr/td[11]/button")}

	public SurfaceTreatmentsSettingPage clickEditButton(String method) {
		WebUI.click(editAction(method))
		return this
	}
	
	public SurfaceTreatmentsSettingPage verifyUIPage() {
		WebUI.verifyElementVisible(xpath("//*[@class='ant-table-thead']//th[@aria-label='Id']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-table-thead']//th[@aria-label='ABBR']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-table-thead']//th[@aria-label='Method']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-table-thead']//th[@aria-label='Price per Area']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-table-thead']//th[@aria-label='Price per Kg']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-table-thead']//th[@aria-label='Setup Cost']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-table-thead']//th[@aria-label='Min Order']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-table-thead']//th[@aria-label='Delivery Week']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-table-thead']//th[text()='Material Group']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-table-thead']//th[text()='Status']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-table-thead']//th[text()='Action']"))
		WebUI.verifyElementVisible(xpath("//ul[contains(@class,'ant-table-pagination')]"))
		return this
	}
	
	public SurfaceTreatmentsSettingPage verifyAfterDataUpdated(String abbr, String method, String pricePerArea, String pricePerKg, String setupCost, String minOrder, String deliveryWeek) {
		String actualAbbr = WebUI.getText(ABBRCol(method)) 
		String actualMethod = WebUI.getText(methodCol(method))
		String actualPricePerAreaCol = WebUI.getText(pricePerAreaCol(method))
		String actualPricePerKgCol = WebUI.getText(pricePerKgCol(method))
		String actualSetupCostCol = WebUI.getText(setupCostCol(method))
		String actualMinOrder = WebUI.getText(minOrderCol(method))
		String actualDeliveryWeek = WebUI.getText(deliveryWeekCol(method))
		WebUI.verifyEqual(actualAbbr, abbr)
		WebUI.verifyEqual(actualMethod, method)
		WebUI.verifyEqual(actualPricePerAreaCol, pricePerArea)
		WebUI.verifyEqual(actualPricePerKgCol, pricePerKg)
		WebUI.verifyEqual(actualSetupCostCol, setupCost)
		WebUI.verifyEqual(actualMinOrder, minOrder)
		WebUI.verifyEqual(actualDeliveryWeek, deliveryWeek)
		return this
	}
	
	public SurfaceTreatmentsSettingPage verifyMethodValue(String method) {
		String actualMethod = WebUI.getText(methodCol(method))
		WebUI.verifyEqual(actualMethod, method)
		return this
	}
}
