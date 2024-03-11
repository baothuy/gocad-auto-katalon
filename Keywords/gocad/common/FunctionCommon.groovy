package gocad.common

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import katalon.fw.lib.BasePage
import katalon.utility.CommonUtility




public class FunctionCommon extends BasePage<FunctionCommon>{

	List<String> sheetMetalPartFileAllow = GlobalVariable.sheetMetalPartFileAllow
	List<String> milledPartFileAllow = GlobalVariable.milledPartFileAllow
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
	public List<String> getBillingAddressCheckoutPage() {
		String email = WebUI.getAttribute(xpath("//*[text()='Billing Address']/following-sibling::div[@class='row']//input[@id='billingAddress_email']"), "value")
		String phone = WebUI.getAttribute(xpath("//*[text()='Billing Address']/following-sibling::div[@class='row']//input[@id='billingAddress_phone']"), "value")
		String houseNumber = WebUI.getAttribute(xpath("//*[text()='Billing Address']/following-sibling::div[@class='row']//input[@id='billingAddress_houseNumber']"), "value")
		String street = WebUI.getAttribute(xpath("//*[text()='Billing Address']/following-sibling::div[@class='row']//input[@id='billingAddress_streetName']"), "value")
		String country = WebUI.getAttribute(xpath("//*[text()='Billing Address']/following-sibling::div[@class='row']//input[@id='billingAddress_country']"), "value")
		String zipCode = WebUI.getAttribute(xpath("//*[text()='Billing Address']/following-sibling::div[@class='row']//input[@id='billingAddress_postCode']"), "value")
		String city = WebUI.getAttribute(xpath("//*[text()='Billing Address']/following-sibling::div[@class='row']//input[@id='billingAddress_city']"), "value")
		List<String> billingAddress = [
			email,
			phone,
			street,
			houseNumber,
			country,
			city,
			zipCode
		]
		return billingAddress
	}

	//Shipping Address
	public List<String> getShippingAddressCheckoutPage() {
		String email = WebUI.getAttribute(xpath("//*[text()='Shipping Address']/following-sibling::div[@class='row']//input[@id='shippingAddress_email']"), "value")
		String phone = WebUI.getAttribute(xpath("//*[text()='Shipping Address']/following-sibling::div[@class='row']//input[@id='shippingAddress_phone']"), "value")
		String houseNumber = WebUI.getAttribute(xpath("//*[text()='Shipping Address']/following-sibling::div[@class='row']//input[@id='shippingAddress_houseNumber']"), "value")
		String street = WebUI.getAttribute(xpath("//*[text()='Shipping Address']/following-sibling::div[@class='row']//input[@id='shippingAddress_streetName']"), "value")
		String country = WebUI.getAttribute(xpath("//*[text()='Shipping Address']/following-sibling::div[@class='row']//input[@id='shippingAddress_country']"), "value")
		String zipCode = WebUI.getAttribute(xpath("//*[text()='Shipping Address']/following-sibling::div[@class='row']//input[@id='shippingAddress_postCode']"), "value")
		String city = WebUI.getAttribute(xpath("//*[text()='Shipping Address']/following-sibling::div[@class='row']//input[@id='shippingAddress_city']"), "value")
		List<String> shippingAddress = [
			email,
			phone,
			street,
			houseNumber,
			country,
			city,
			zipCode
		]
		return shippingAddress
	}

	//Billing Address
	public List<String> getBillingAddressDetailOffer() {
		String address = WebUI.getText(xpath("//*[text()='Billing Address']/following-sibling::div/div[1]"))
		String houseNumber = CommonUtility.substringUseRegExp(address, /\b(\d+\s*[a-zA-Z]?)\b/, 1)
		String street = CommonUtility.substringUseRegExp(address, /^([^0-9]+)(?:\s+\S+)*,/, 1)
		String zipCode = CommonUtility.substringUseRegExp(address, /\b(\d{5})\b/, 1)
		String city = CommonUtility.substringUseRegExp(address, /\b([A-Za-z]+)\s*,/, 1)
		String country = CommonUtility.substringUseRegExp(address, /(\b[A-Za-z]+)\s*$/, 1)
		String email = WebUI.getText(xpath("//*[text()='Billing Address']/following-sibling::div/div[2]"))
		String phone = WebUI.getText(xpath("//*[text()='Billing Address']/following-sibling::div/div[3]"))
		List<String> billingAddress = [
			email,
			phone,
			street,
			houseNumber,
			country,
			city,
			zipCode
		]
		return billingAddress
	}

	//Shipping Address
	public List<String> getShippingAddressDetailOffer() {
		String address = WebUI.getText(xpath("//*[text()='Shipping Address']/following-sibling::div/div[1]"))
		String houseNumber = CommonUtility.substringUseRegExp(address, /\b(\d+\s*[a-zA-Z]?)\b/, 1)
		String street = CommonUtility.substringUseRegExp(address, /^([^0-9]+)(?:\s+\S+)*,/, 1)
		String zipCode = CommonUtility.substringUseRegExp(address, /\b(\d{5})\b/, 1)
		String city = CommonUtility.substringUseRegExp(address, /\b([A-Za-z]+)\s*,/, 1)
		String country = CommonUtility.substringUseRegExp(address, /(\b[A-Za-z]+)\s*$/, 1)
		String email = WebUI.getText(xpath("//*[text()='Shipping Address']/following-sibling::div/div[2]"))
		String phone = WebUI.getText(xpath("//*[text()='Shipping Address']/following-sibling::div/div[3]"))
		List<String> billingAddress = [
			email,
			phone,
			street,
			houseNumber,
			country,
			city,
			zipCode
		]
		return billingAddress
	}

	//Account Settings
	//Billing address
	public List<String> getBillingAddressAccountSettings() {
		String email = WebUI.getAttribute(xpath("//*[@id='basic_billingAddress_email']"), 'value')
		String phone = WebUI.getAttribute(xpath("//*[@id='basic_billingAddress_phone']"), 'value')
		String streetName = WebUI.getAttribute(xpath("//*[@id='basic_billingAddress_streetName']"), 'value')
		String houseNumber = WebUI.getAttribute(xpath("//*[@id='basic_billingAddress_houseNumber']"), 'value')
		String country = WebUI.getAttribute(xpath("//*[@id='basic_billingAddress_country']"), 'value')
		String city = WebUI.getAttribute(xpath("//*[@id='basic_billingAddress_city']"), 'value')
		String postCode = WebUI.getAttribute(xpath("//*[@id='basic_billingAddress_postCode']"), 'value')
		List<String> billingAddress = [
			email,
			phone,
			streetName,
			houseNumber,
			country,
			city,
			postCode
		]
		return billingAddress
	}

	//Shipping address
	public List<String> getShippingAddressAccountSettings() {
		String email = WebUI.getAttribute(xpath("//*[@id='basic_shippingAddress_email']"), 'value')
		String phone = WebUI.getAttribute(xpath("//*[@id='basic_shippingAddress_phone']"), 'value')
		String streetName = WebUI.getAttribute(xpath("//*[@id='basic_shippingAddress_streetName']"), 'value')
		String houseNumber = WebUI.getAttribute(xpath("//*[@id='basic_shippingAddress_houseNumber']"), 'value')
		String country = WebUI.getAttribute(xpath("//*[@id='basic_shippingAddress_country']"), 'value')
		String city = WebUI.getAttribute(xpath("//*[@id='basic_shippingAddress_city']"), 'value')
		String postCode = WebUI.getAttribute(xpath("//*[@id='basic_shippingAddress_postCode']"), 'value')
		List<String> billingAddress = [
			email,
			phone,
			streetName,
			houseNumber,
			country,
			city,
			postCode
		]
		return billingAddress
	}

	//Request Offer
	//Shipping address
	public List<String> getShippingAddressRequestOfferPopup() {
		String email = WebUI.getAttribute(xpath("//*[@id='billingAddress_email']"), 'value')
		String phone = WebUI.getAttribute(xpath("//*[@id='billingAddress_phone']"), 'value')
		String streetName = WebUI.getAttribute(xpath("//*[@id='billingAddress_streetName']"), 'value')
		String houseNumber = WebUI.getAttribute(xpath("//*[@id='billingAddress_houseNumber']"), 'value')
		String country = WebUI.getAttribute(xpath("//*[@id='billingAddress_country']"), 'value')
		String city = WebUI.getAttribute(id("billingAddress_city"), 'value')
		String postCode = WebUI.getAttribute(xpath("//*[@id='billingAddress_postCode']"), 'value')
		List<String> billingAddress = [
			email,
			phone,
			streetName,
			houseNumber,
			country,
			city,
			postCode
		]
		return billingAddress
	}

	//Order Summary
	public List<String> getOrderSummary() {
		String totalPartPrice = WebUI.getText(xpath("//label[text()='Total Part Price']/following-sibling::label")).trim()
		List<String> surfaceTreatmentSurchargeObject = findTestObjects("//label[text()='Surface Treatment Surcharge']/following-sibling::label")
		def surfaceTreatmentSurcharge = (surfaceTreatmentSurchargeObject.size() != 0) ? WebUI.getText(xpath("//label[text()='Surface Treatment Surcharge']/following-sibling::label")) : "Empty"
		String expressSurchargeValue = WebUI.getText(xpath("//label[text()='Express Surcharge']/following-sibling::label")).trim()
		String expressSurcharge = expressSurchargeValue == "00.0 $GlobalVariable.currency" ? "-- $GlobalVariable.currency" : expressSurchargeValue
		String packagingCost = WebUI.getText(xpath("//label[text()='Packaging Cost']/following-sibling::label")).trim()
		String shippingCosts = WebUI.getText(xpath("//label[text()='Shipping costs']/following-sibling::label")).trim()
		String netTotal = WebUI.getText(xpath("//*[text()='NET Total']/following-sibling::label")).trim()
		List<String> vatObject = findTestObjects("//*[contains(@class,'summary-price')]//*[contains(text(),'VAT')]/following-sibling::label")
		def vat = (vatObject.size() != 0) ? WebUI.getText(xpath("//*[contains(@class,'summary-price')]//*[contains(text(),'VAT')]/following-sibling::label")) : "-- $GlobalVariable.currency"
		String grossTotal = WebUI.getText(xpath("//*[text()='GROSS Total']/following-sibling::label")).trim()
		List<String> orderSummary = [
			totalPartPrice,
			surfaceTreatmentSurcharge,
			expressSurcharge,
			packagingCost,
			shippingCosts,
			netTotal,
			vat,
			grossTotal
		]
		return orderSummary
	}

	public String formatAddress(String houseNumber, String street, String city, String zipCode, String country) {
		String address = "$street $houseNumber, $city, $country"
		return address
	}

	public List<String> getTablePartReview(String partName) {
		String partNameCol = WebUI.getText(xpath(partCol(partName)))
		String material = WebUI.getText(xpath(materialCol(partName)))
		String thickness = WebUI.getText(xpath(thicknessCol(partName)))
		List<String> findQuanTestObjects = findTestObjects("//input[@id='quantity']")
		String quantity
		if (findQuanTestObjects.size() != 0) {
			quantity = WebUI.getAttribute(xpath(quantityCol(partName) + "//input[@id='quantity']"), "value")
		}
		else {
			quantity = WebUI.getText(xpath(quantityCol(partName)))
		}
		String unitPrice
		List<String> findUnitTestObjects = findTestObjects("//input[@id='unitPrice']")
		if (findUnitTestObjects.size() != 0) {
			unitPrice = WebUI.getAttribute(xpath(unitPriceCol(partName) + "//input[@id='unitPrice']"), "value") + " $GlobalVariable.currency"
		}
		else {
			unitPrice = WebUI.getText(xpath(unitPriceCol(partName)))
		}
		String totalPartPrice = WebUI.getText(xpath(partPriceTotalCol(partName)))
		List<String> findTestObjects = findTestObjects("//*[@aria-label='message']")
		String CO2Emission = WebUI.getText(xpath(CO2EmissionCol(partName)))
		String comment
		println "findTestObjects: $findTestObjects"
		if (findTestObjects.size() != 0) {
			WebUI.mouseOver(xpath("//*[@aria-label='message']"))
			comment = WebUI.getText(xpath("//*[@role='tooltip']/div[2]/div"))
		}
		else {
			comment = ""
		}
		List<String> actualResult = [
			partNameCol,
			material,
			thickness,
			quantity,
			unitPrice,
			totalPartPrice,
			comment,
			CO2Emission
		]
		return actualResult
	}

	//Manufacturer
	public FunctionCommon clickSelectJobs(String partName, String projectId) {
		WebUI.click(xpath("(//a[text()='$projectId']/ancestor::div[@class='ant-space-item']//span[text()='$partName'])[1]"))
		return this
	}

	public FunctionCommon clickFirstJobsToAssign(String projectId) {
		WebUI.click(xpath("(//a[text()='$projectId']/ancestor::div[@class='ant-space-item']//input[@type='checkbox'])[1]"))
		return this
	}

	public FunctionCommon inputDeliveryDate(String deliveryDate, String projectId) {
		WebUI.click(xpath("(//a[text()='$projectId']/ancestor::div[@class='ant-space-item']//*[text()='For supplier']/following::label[text()='Delivery Date']/following-sibling::div//span[@aria-label='edit'])[1]"))
		WebUI.sendKeys(xpath("//input[@id='form-inline-adaptDeliveryDateForSupplier_adaptDeliveryDateForSupplier']"), deliveryDate + Keys.RETURN)
		return this
	}

	public FunctionCommon inputSupplierPrice(String price, String projectId) {
		WebUI.click(xpath("(//a[text()='$projectId']/ancestor::div[@class='ant-space-item']//*[text()='For supplier']/following::label[text()='Adapt price']/following-sibling::label//span[@aria-label='edit'])[1]"))
		clearTextAndSendKeysByActions(xpath("//*[@id='form-inline-unitPrice']"), price)
		return this
	}

	public FunctionCommon inputNoteToSupplier(String input, String projectId) {
		WebUI.click(xpath("(//a[text()='$projectId']/ancestor::div[@class='ant-space-item']//*[text()='Note to supplier']/following::div[@class='textarea-inline']//span)[1]"))
		WebUI.sendKeys(xpath("//*[@id='form-inline-sellerNote_sellerNote']"), input)
		WebUI.click(xpath("//*[text()='Save']/parent::button"))
		return this
	}

	public FunctionCommon clickAcceptChange() {
		WebUI.click(xpath("//*[@aria-label='check']/parent::button"))
		return this
	}

	public FunctionCommon clickCloseChange() {
		WebUI.click(xpath("//*[@aria-label='close']/parent::button"))
		return this
	}

	public FunctionCommon clickViewProject(String projectName) {
		WebUI.click(xpath("(//a[text()='$projectName'])[1]"))
		return this
	}

	public FunctionCommon verifyManufacturingInformationReportButtonVisible() {
		WebUI.verifyElementVisible(xpath("(//span[text()=' Manufacturing information']/parent::button)[1]"))
		return this
	}

	public FunctionCommon verifyProcessingReportButtonVisible() {
		WebUI.verifyElementVisible(xpath("(//span[text()=' Processing report']/parent::button)[1]"))
		return this
	}

	public FunctionCommon verifyEmissionReportButtonVisible() {
		WebUI.verifyElementVisible(xpath("(//span[text()=' Emission report']/parent::button)[1]"))
		return this
	}

	public FunctionCommon clickDownloadImage() {
		WebUI.click(xpath('(//a[@class="text-decoration-none"])[1]'))
		return this
	}

	public FunctionCommon verifyMaterialValue(String expectedResult, String projectId) {
		String actualResult = WebUI.getText(xpath("(//a[text()='$projectId']/ancestor::div[@class='ant-space-item']//*[text()='Material']/following-sibling::div)[1]")).trim()
		def pattern = /^(.*?)\/[0-9.]+$/
		actualResult = CommonUtility.substringUseRegExp(actualResult, pattern, 1)
		println "MaterialValue: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public FunctionCommon verifyQuantityValue(String expectedResult, String projectId) {
		String actualResult = WebUI.getText(xpath("(//a[text()='$projectId']/ancestor::div[@class='ant-space-item']//*[text()='Quantity']/following-sibling::label)[1]")).trim()
		println "QuantityValue: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public FunctionCommon verifyThreadValue(String expectedResult, String projectId) {
		String actualResult = WebUI.getText(xpath("(//a[text()='$projectId']/ancestor::div[@class='ant-space-item']//*[text()='Thread (Quantity)']/following-sibling::div)[1]")).trim()
		println "ThreadValue: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public FunctionCommon verifyThreadValueOnSMP(String expectedResult, String projectId) {
		String actualResult = WebUI.getText(xpath("(//a[text()='$projectId']/ancestor::div[@class='ant-space-item']//*[text()='Thread Cutting']/following-sibling::label)[1]")).trim()
		println "ThreadValue: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public FunctionCommon verifyTolerancesNumberValue(String expectedResult, String projectId) {
		String actualResult = WebUI.getText(xpath("(//a[text()='$projectId']/ancestor::div[@class='ant-space-item']//*[text()='Tolerances and fits with less than 1/10mm or IT 1 - IT 10 (Number)']/following-sibling::div)[1]")).trim()
		println "TolerancesNumberValue: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public FunctionCommon verifyTolerancesToggleValue(String expectedResult, String projectId) {
		String actualResult = WebUI.getText(xpath("(//a[text()='$projectId']/ancestor::div[@class='ant-space-item']//*[text()='Tolerance requirement with smaller 1/100mm or IT 1 - IT 5']/following-sibling::label)[1]")).trim()
		println "TolerancesToggleValue: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public FunctionCommon verifySurfaceTreatmentValue(String expectedResult, String projectId) {
		String actualResult = WebUI.getText(xpath("(//a[text()='$projectId']/ancestor::div[@class='ant-space-item']//*[text()='Surface Treatment']/following-sibling::label)[1]")).trim()
		String conActualResult = (actualResult == "None") ? "" : actualResult
		println "verifySurfaceTreatmentValue: $conActualResult"
		WebUI.verifyEqual(conActualResult, expectedResult)
		return this
	}

	public FunctionCommon verifySurfaceQualityValue(String expectedResult, String projectId) {
		String actualResult = WebUI.getText(xpath("(//a[text()='$projectId']/ancestor::div[@class='ant-space-item']//*[text()='Surface Quality']/following-sibling::label)[1]")).trim()
		println "SurfaceQualityValue: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public FunctionCommon verifyRollingDirectionValue(String expectedResult, String projectId) {
		String actualResult = WebUI.getText(xpath("(//a[text()='$projectId']/ancestor::div[@class='ant-space-item']//*[text()='Rolling Direction']/following-sibling::label)[1]")).trim()
		println "RollingDirectionValue: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public FunctionCommon verifyLaserMarkingValue(String expectedResult, String projectId) {
		String actualResult = WebUI.getText(xpath("(//a[text()='$projectId']/ancestor::div[@class='ant-space-item']//*[text()='Laser marking']/following-sibling::label)[1]")).trim()
		println "LaserMarkingValue: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public FunctionCommon verifyCountersinkValue(String expectedResult, String projectId) {
		String actualResult = WebUI.getText(xpath("(//a[text()='$projectId']/ancestor::div[@class='ant-space-item']//*[text()='Countersink']/following-sibling::label)[1]")).trim()
		println "CountersinkValue: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public FunctionCommon verifyThicknessValue(String partName, String expectedResult, String projectId) {
		for (int i = 0; i < sheetMetalPartFileAllow.size(); i++) {
			def isContains = partName.contains(sheetMetalPartFileAllow[i])
			println "isContains: $isContains"
			if (isContains) {
				String actualResult = WebUI.getText(xpath("(//a[text()='$projectId']/ancestor::div[@class='ant-space-item']//*[text()='Thickness']/following-sibling::label)[1]")).trim()
				def pattern = /(\d+(?:\.\d+)?)/
				String newActualResult = CommonUtility.substringUseRegExp(actualResult,pattern,0)
				WebUI.verifyEqual(newActualResult, expectedResult)
				println "Thickness: $newActualResult"
			}
		}
		return this
	}

	public FunctionCommon verifyCuttingLayersValue(String partName, String expectedResult, String projectId) {
		for (int i = 0; i < sheetMetalPartFileAllow.size(); i++) {
			def isContains = partName.contains(sheetMetalPartFileAllow[i])
			if(isContains) {
				String actualResult = WebUI.getText(xpath("(//a[text()='$projectId']/ancestor::div[@class='ant-space-item']//*[text()='Cutting layers']/following-sibling::label)[1]")).trim()
				WebUI.verifyEqual(actualResult, expectedResult)
			}
		}
		return this
	}

	public FunctionCommon verifyDeburringValue(String expectedResult, String projectId) {
		String actualResult = WebUI.getText(xpath("(//a[text()='$projectId']/ancestor::div[@class='ant-space-item']//*[text()='Deburring']/following-sibling::label)[1]")).trim()
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public FunctionCommon verifyAdditionalCommentsValue(String expectedResult, String projectId) {
		String actualResult = WebUI.getText(xpath("(//a[text()='$projectId']/ancestor::div[@class='ant-space-item']//*[text()='Buyer additional comments']/following-sibling::label)[1]")).trim()
		println "AdditionalCommentsValue: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
}
