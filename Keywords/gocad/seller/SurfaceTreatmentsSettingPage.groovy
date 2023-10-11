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
	def materialGroup = { String method -> return xpath("//*[text()='$method']/parent::tr/td98]")}
	def status = { String method -> return xpath("//*[text()='$method']/parent::tr/td[9]//span[normalize-space(text()) != '']")}
	def editAction = { String method -> return xpath("//*[text()='$method']/parent::tr/td[10]/button")}

	public SurfaceTreatmentsSettingPage clickEditButton(String materialName) {
		WebUI.click(editAction(materialName))
		return this
	}
}
