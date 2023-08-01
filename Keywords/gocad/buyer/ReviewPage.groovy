package gocad.buyer

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import katalon.fw.lib.BasePage

public class ReviewPage extends BasePage<ReviewPage>{
	
	def partCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[1]")}
	def materialCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[4]")}
	def quantityCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[5]")}
	def unitPriceCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[6]")}
	def partPriceTotalCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[7]")}
	def CO2EmissionCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[9]")}
	def actionView = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[10]")}
	def actionMore = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[10]//button")}
	
	public ReviewPage clickCheckout() {
		WebUI.click(xpath("//span[text()='Check out']"))
		return this
	}
	
	public ReviewPage clickView(String partName) {
		WebUI.click(actionView(partName))
		return this
	}
	
	public ReviewPage clickMoreOption(String partName) {
		WebUI.click(actionMore(partName))
		return this
	}
	
	public ReviewPage clickCopyPart() {
		WebUI.click(xpath('//span[text()="Copy"]'))
		return this
	}
	
	public ReviewPage clickMovePart() {
		WebUI.click(xpath('//span[text()="Move"]'))
		return this
	}
}
