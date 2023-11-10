package katalon.utility

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import katalon.fw.lib.BasePage




public class FunctionCommon extends BasePage<FunctionCommon>{
	
	def partCol = { String partName -> return "//div[text()='$partName']/ancestor::tr/td[2]"}
	def fileCol = { String partName -> return "//div[text()='$partName']/ancestor::tr/td[3]//a"}
	def materialCol = { String partName -> return "//div[text()='$partName']/ancestor::tr/td[4]"}
	def thicknessCol = { String partName -> return "//div[text()='$partName']/ancestor::tr/td[5]"}
	def quantityCol = { String partName -> return "//div[text()='$partName']/ancestor::tr/td[6]"}
	def unitPriceCol = { String partName -> return "//div[text()='$partName']/ancestor::tr/td[7]"}
	def partPriceTotalCol = { String partName -> return "//div[text()='$partName']/ancestor::tr/td[8]"}
	def CO2EmissionCol = { String partName -> return "//div[text()='$partName']/ancestor::tr/td[10]"}
	def actionMore = { String partName -> return "//div[text()='$partName']/ancestor::tr/td[11]//button"}
	
	//Billing Address
	public List<String> getBillingAddress() {
		String fullName = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='Full Name']/ancestor::tr/following-sibling::tr[1]/td[1]"))
		String houseNumber = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='House number']/ancestor::tr/following-sibling::tr[1]/td[2]"))
		String street = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='Street']/ancestor::tr/following-sibling::tr[1]/td[3]"))
		String state = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='State, Province, or Region']/ancestor::tr/following-sibling::tr[1]/td[1]"))
		String zipCode = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='ZIP Code']/ancestor::tr/following-sibling::tr[1]/td[2]"))
		String city = WebUI.getText(xpath("//*[text()='Billing Address']/parent::div/following-sibling::div//*[text()='City']/ancestor::tr/following-sibling::tr[1]/td[3]"))
		List<String> billingAddress = [fullName, houseNumber, street, state, zipCode, city]
		return billingAddress
	}
	
	//Shipping Address
	public List<String> getShippingAddress() {
		String fullName = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='Full Name']/ancestor::tr/following-sibling::tr[1]/td[1]"))
		String houseNumber = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='House number']/ancestor::tr/following-sibling::tr[1]/td[2]"))
		String street = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='Street']/ancestor::tr/following-sibling::tr[1]/td[3]"))
		String state = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='State, Province, or Region']/ancestor::tr/following-sibling::tr[1]/td[1]"))
		String zipCode = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='ZIP Code']/ancestor::tr/following-sibling::tr[1]/td[2]"))
		String city = WebUI.getText(xpath("//*[text()='Shipping Address']/parent::div/following-sibling::div//*[text()='City']/ancestor::tr/following-sibling::tr[1]/td[3]"))
		List<String> billingAddress = [fullName, houseNumber, street, state, zipCode, city]
		return billingAddress
	}
	
	//Order Summary
	public List<String> getOrderSummary() {
		String totalPartPrice = WebUI.getText(xpath("//label[text()='Total Part Price']/following-sibling::label"))
		List<String> surfaceTreatmentSurchargeObject = findTestObjects("//label[text()='Surface Treatment Surcharge']/following-sibling::label")
		def surfaceTreatmentSurcharge = (surfaceTreatmentSurchargeObject.size() != 0) ? WebUI.getText(xpath("//label[text()='Surface Treatment Surcharge']/following-sibling::label")) : "Empty"
		String expressSurchargeValue = WebUI.getText(xpath("//label[text()='Express Surcharge']/following-sibling::label"))
		String expressSurcharge = expressSurchargeValue == "00.0 $GlobalVariable.currency" ? "-- $GlobalVariable.currency" : expressSurchargeValue
		String packagingCost = WebUI.getText(xpath("//label[text()='Packaging Cost']/following-sibling::label"))
		String shippingCosts = WebUI.getText(xpath("//label[text()='Shipping costs']/following-sibling::label"))
		String netTotal = WebUI.getText(xpath("//*[text()='NET Total']/following-sibling::label"))
		String vat = WebUI.getText(xpath("//label[text()='VAT (19%)']/following-sibling::label"))
		String grossTotal = WebUI.getText(xpath("//*[text()='GROSS Total']/following-sibling::label"))
		List<String> orderSummary = [totalPartPrice, surfaceTreatmentSurcharge, expressSurcharge, packagingCost, shippingCosts, netTotal, vat, grossTotal]
		return orderSummary
	}
	
	public List<String> getTablePartReview(String partName) {
		String partNameCol = WebUI.getText(xpath(partCol(partName)))
		String material = WebUI.getText(xpath(materialCol(partName)))
		String thickness = WebUI.getText(xpath(thicknessCol(partName)))
		List<String> findQuanTestObjects = findTestObjects("//input[@id='quantity']")
		String quantity
		if (findQuanTestObjects.size() != 0) { quantity = WebUI.getAttribute(xpath(quantityCol(partName) + "//input[@id='quantity']"), "value")}
		else { quantity = WebUI.getText(xpath(quantityCol(partName)))}
		String unitPrice
		List<String> findUnitTestObjects = findTestObjects("//input[@id='unitPrice']")
		if (findUnitTestObjects.size() != 0) { unitPrice = WebUI.getAttribute(xpath(unitPriceCol(partName) + "//input[@id='unitPrice']"), "value") + " $GlobalVariable.currency"}
		else { unitPrice = WebUI.getText(xpath(unitPriceCol(partName)))}
		String totalPartPrice = WebUI.getText(xpath(partPriceTotalCol(partName)))
		List<String> findTestObjects = findTestObjects("//*[@aria-label='message']")
		String CO2Emission = WebUI.getText(xpath(CO2EmissionCol(partName)))
		String comment
		println "findTestObjects: $findTestObjects"
		if (findTestObjects.size() != 0) {
			WebUI.mouseOver(xpath("//*[@aria-label='message']"))
			comment = WebUI.getText(xpath("//*[@role='tooltip']/div[2]/div"))
		}
		else { comment = ""}
		List<String> actualResult = [partNameCol, material, thickness, quantity, unitPrice, totalPartPrice, comment, CO2Emission]
		return actualResult
	}
	
}
