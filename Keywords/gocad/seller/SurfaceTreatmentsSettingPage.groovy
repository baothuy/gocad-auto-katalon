package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage


public class SurfaceTreatmentsSettingPage extends BasePage<SurfaceTreatmentsSettingPage>{

	def idCol = { String method -> return xpath("//*[text()='$method']/parent::tr/td[1]")}
	def ABBRCol = { String method -> return xpath("//*[text()='$method']/parent::tr/td[2]/button")}
	def methodCol = { String method -> return xpath("//*[text()='$method']/parent::tr/td[3]")}
	def pricePerAreaCol = { String method -> return xpath("//*[text()='$method']/parent::tr/td[4]")}
	def pricePerKgCol = { String method -> return xpath("//*[text()='$method']/parent::tr/td[5]")}
	def setupCostCol = { String method -> return xpath("//*[text()='$method']/parent::tr/td[6]")}
	def minOrder = { String method -> return xpath("//*[text()='$method']/parent::tr/td[7]")}
	def deliveryWeek = { String method -> return xpath("//*[text()='$method']/parent::tr/td[8]")}
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
}
