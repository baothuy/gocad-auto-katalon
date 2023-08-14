package gocad.buyer

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import katalon.fw.lib.BasePage

public class ReviewPage extends BasePage<ReviewPage>{

	def imagePartCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[1]")}
	def partCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[2]")}
	def fileCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[3]//a")}
	def materialCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[4]")}
	def quantityCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[5]//input[@id='quantity']")}
	def unitPriceCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[6]")}
	def partPriceTotalCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[7]")}
	def CO2EmissionCol = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[9]")}
	def actionView = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[10]")}
	def actionMore = { String partName -> return xpath("//div[text()='$partName']/ancestor::tr/td[10]//button")}

	public ReviewPage clickCheckout() {
		WebUI.click(xpath("//span[text()='Check out']"))
		return this
	}

	public ReviewPage clickRequestOffer() {
		WebUI.click(xpath("//span[text()='Request Offer']"))
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

	public ReviewPage verifyImagePartClickable(String partName) {
		WebUI.verifyElementClickable(imagePartCol(partName))
		return this
	}

	public ReviewPage verifyPartName(String partName) {
		String actualResult = WebUI.getText(partCol(partName))
		WebUI.verifyEqual(actualResult, partName)
		return this
	}

	public ReviewPage verifyFileClickable(String partName) {
		WebUI.verifyElementClickable(fileCol(partName))
		return this
	}

	public ReviewPage verifyFiles(String partName) {
		WebUI.mouseOver(fileCol(partName))
		String actualResult = WebUI.getText(xpath("//div[@role='tooltip' and text()='$partName']"))
		WebUI.verifyEqual(actualResult, partName)
		return this
	}

	public ReviewPage verifyMaterial(String partName, String expectedResult) {
		String actualResult = WebUI.getText(materialCol(partName))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ReviewPage verifyQuantity(String partName, String expectedResult) {
		String actualResult = WebUI.getAttribute(quantityCol(partName), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ReviewPage verifyUnitPrice(String partName, String expectedResult) {
		String actualResult = WebUI.getText(unitPriceCol(partName))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ReviewPage verifyPartPriceTotal(String partName, String expectedResult) {
		String actualResult = WebUI.getText(partPriceTotalCol(partName)).trim()
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ReviewPage verifyCO2EmissionCol(String partName, String expectedResult) {
		String actualResult = WebUI.getText(CO2EmissionCol(partName))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public List<String> getTablePartReview(String partName) {
		String partNameCol = WebUI.getText(partCol(partName))
		String material = WebUI.getText(materialCol(partName))
		String quantity = WebUI.getAttribute(quantityCol(partName), "value")
		String unitPrice = WebUI.getText(unitPriceCol(partName))
		String totalPartPrice = WebUI.getText(partPriceTotalCol(partName))
		List<String> findTestObjects = findTestObjects("//*[@aria-label='message']")
		String CO2Emission = WebUI.getText(CO2EmissionCol(partName))
		String comment
		println "findTestObjects: $findTestObjects"
		if (findTestObjects.size() != 0) { 
			WebUI.mouseOver(xpath("//*[@aria-label='message']"))
			comment = WebUI.getText(xpath("//*[@role='tooltip']/div[2]/div"))
		} 
		else
		{
			comment = ""
			
		}
		List<String> actualResult = [partNameCol, material, quantity, unitPrice, totalPartPrice, comment, CO2Emission]
		println "getTablePartReview: $actualResult"
		return actualResult
	}
}
