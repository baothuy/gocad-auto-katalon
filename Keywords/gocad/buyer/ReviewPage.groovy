package gocad.buyer

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import gocad.common.ManufacturingInformationPage
import katalon.fw.lib.BasePage
import katalon.utility.CommonUtility

public class ReviewPage extends BasePage<ReviewPage>{

	def imagePartCol = { String partName -> return xpath("//*[text()='$partName']/ancestor::tr/td[1]//img")}
	def partCol = { String partName -> return xpath("//*[text()='$partName']/ancestor::tr/td[2]")}
	def fileCol = { String partName -> return xpath("//*[text()='$partName']/ancestor::tr/td[3]//a")}
	def materialCol = { String partName -> return xpath("//*[text()='$partName']/ancestor::tr/td[4]")}
	def quantityCol = { String partName -> return xpath("//*[text()='$partName']/ancestor::tr/td[5]//input[@id='quantity']")}
	def unitPriceCol = { String partName -> return xpath("//*[text()='$partName']/ancestor::tr/td[6]")}
	def partPriceTotalCol = { String partName -> return xpath("//*[text()='$partName']/ancestor::tr/td[7]")}
	def commentCol = { String partName -> return xpath("//*[text()='$partName']/ancestor::tr/td[8]/span")}
	def CO2EmissionCol = { String partName -> return xpath("//*[text()='$partName']/ancestor::tr/td[9]")}
	def actionMore = { String partName -> return xpath("//*[text()='$partName']/ancestor::tr/td[10]//button")}
	def contentAlertManually = "These parts cannot be automatically calculated. You can request a manual offer by the seller. All parts that could not automatically be calculated are bundled in this separate list."
	def contentAlertAutomatically = "Please check and confirm your order. You can see the bulk pricing when clicking on the information button for each part. You can adapt the quantity here if required."
	def expectedContentTooltips = "Surcharge to fulfill minimum order value of general order as well as special costs for the following surface treatment options (minimum order value and transport costs)"

	public ReviewPage clickPartFile(String partName) {
		WebUI.click(fileCol(partName))
		return this
	}

	public ReviewPage clickCheckout() {
		WebUI.click(xpath("//span[text()='Check out']"))
		return this
	}

	public ReviewPage clickRequestOffer() {
		WebUI.click(xpath("//span[text()='Request Offer']"))
		return this
	}

	public ReviewPage clickView(String partName) {
		WebUI.click(xpath('//span[text()="View"]'))
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

	public ReviewPage verifyProcessReviewtHighLighted() {
		String colorTwo = WebUI.getCSSValue(xpath("//div[text()='Review']/parent::div/preceding-sibling::div//*[text()='3']"), "background")
		String pattern = /(rgb\(\d+,\s*\d+,\s*\d+\))/
		String rgbValue = CommonUtility.substringUseRegExp(colorTwo, pattern,1)
		String rgbToHex = CommonUtility.rgbToHex(rgbValue)
		WebUI.verifyEqual(rgbToHex, "#FFCB3D")
		return this
	}

	public ReviewPage verifyContentAlertManualCalculateVisible() {
		WebUI.verifyElementVisible(xpath("//*[text()='Manually calculated']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-alert-message']"))
		def contentAlertActual = WebUI.getText(xpath("//*[@class='ant-alert-message']"))
		def expectedResult = contentAlertManually
		WebUI.verifyEqual(contentAlertActual, expectedResult)
		return this
	}

	public ReviewPage verifyContentAlertAutomaticCalculateVisible() {
		WebUI.verifyElementVisible(xpath("//*[text()='Automatically calculated']"))
		WebUI.verifyElementVisible(xpath("//*[@class='ant-alert-message']"))
		def contentAlertActual = WebUI.getText(xpath("//*[@class='ant-alert-message']"))
		def expectedResult = contentAlertAutomatically
		WebUI.verifyEqual(contentAlertActual, expectedResult)
		return this
	}

	public ReviewPage verifyImagePartClickable(String partName) {
		WebUI.verifyElementClickable(imagePartCol(partName))
		return this
	}

	public ReviewPage verifyPartNameValue(String partName) {
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

	public ReviewPage verifyMaterialValue(String partName, String expectedResult) {
		String actualResult = WebUI.getText(materialCol(partName))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ReviewPage verifyQuantityValue(String partName, String expectedResult) {
		String actualResult = WebUI.getAttribute(quantityCol(partName), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ReviewPage verifyUnitPriceValue(String partName, String expectedResult) {
		String actualResult = WebUI.getText(unitPriceCol(partName))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ReviewPage verifyPartPriceTotalValue(String partName, String expectedResult) {
		String actualResult = WebUI.getText(partPriceTotalCol(partName)).trim()
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ReviewPage verifyCommentValue(String partName, String expectedResult) {
		String actualResult
		List<String> findTestObjects = findTestObjects("//*[@aria-label='message']")
		if (findTestObjects.size() != 0) {
			WebUI.click(commentCol(partName))
			actualResult = WebUI.getText(xpath("//*[text()='Additional Comments']/parent::div[@role='tooltip']/div/div"))
		}
		else {
			actualResult = ""
		}
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ReviewPage verifyCO2EmissionValue(String partName, String expectedResult) {
		String actualResult = WebUI.getText(CO2EmissionCol(partName))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public String getCO2EmissionValue(String partName) {
		String CO2Emission = WebUI.getText(CO2EmissionCol(partName))
		return CO2Emission
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
		else {
			comment = ""
		}
		List<String> actualResult = [partNameCol, material, quantity, unitPrice, totalPartPrice, comment, CO2Emission]
		println "getTablePartReview: $actualResult"
		return actualResult
	}

	public ReviewPage clickManufacturingInformationProcess() {
		WebUI.click(xpath("//span[@class='ant-steps-icon']/span[text()='2']"))
		return this
	}

	public ReviewPage verifyPartNameVisible(String partName) {
		WebUI.verifyElementVisible(partCol(partName))
		return this
	}

	public ReviewPage verifyFileVisible(String partName) {
		WebUI.verifyElementVisible(fileCol(partName))
		return this
	}

	public ReviewPage verifyMaterialVisible(String partName) {
		WebUI.verifyElementVisible(materialCol(partName))
		return this
	}

	public ReviewPage verifyQuantityVisible(String partName) {
		WebUI.verifyElementVisible(quantityCol(partName))
		return this
	}

	public ReviewPage verifyUnitPriceVisible(String partName) {
		WebUI.verifyElementVisible(unitPriceCol(partName))
		return this
	}

	public ReviewPage verifyTotalPartPriceVisible(String partName) {
		WebUI.verifyElementVisible(partPriceTotalCol(partName))
		return this
	}

	public ReviewPage verifyCO2EmissionVisible(String partName) {
		WebUI.verifyElementVisible(CO2EmissionCol(partName))
		return this
	}

	public ReviewPage verifyActionViewVisible() {
		WebUI.verifyElementVisible(xpath("//span[text()='View']"))
		return this
	}

	public ReviewPage verifyActionMoreVisible(String partName) {
		WebUI.verifyElementVisible(actionMore(partName))
		return this
	}

	public ReviewPage verifyActionCopyVisible() {
		WebUI.verifyElementVisible(xpath("//span[text()='Copy']"))
		return this
	}

	public ReviewPage verifyActionMoveVisible() {
		WebUI.verifyElementVisible(xpath("//span[text()='Move']"))
		return this
	}

	public ReviewPage verifyRequestOfferButtonVisible(String partName) {
		WebUI.verifyElementVisible(xpath("//span[text()='Request Offer']"))
		return this
	}

	public ReviewPage verifyCheckoutButtonVisible(String partName) {
		WebUI.verifyElementVisible(xpath("//span[text()='Check out']"))
		return this
	}

	public ReviewPage verifySurfaceTreatmentSurchargeAndTotalVisible() {
		List<String> findObject = findTestObjects("//*[text()='Surface Treatment Surcharge']")
		if (findObject.size() != 0) {
			WebUI.verifyElementVisible(xpath("//*[text()='Surface Treatment Surcharge']"))
			WebUI.click(xpath("//*[text()='Surface Treatment Surcharge']"))
			WebUI.verifyElementVisible(xpath("//*[text()='$expectedContentTooltips']"))
			WebUI.verifyElementVisible(xpath("//*[text()='All Parts Total']"))
			WebUI.verifyElementVisible(xpath("//*[text()='NET Total']"))
			WebUI.click(xpath("//*[text()='NET Total']"))
		}
		else {
			WebUI.verifyElementVisible(xpath("//*[text()='Total:']"))
		}
		return this
	}
}
