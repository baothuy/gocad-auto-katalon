package gocad.common

import java.text.DecimalFormat

import org.openqa.selenium.Keys

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import katalon.fw.lib.BasePage
import katalon.utility.CommonUtility

public class ManufacturingInformationPage extends BasePage<ManufacturingInformationPage> {

	List<String> sheetMetalPartFileAllow = GlobalVariable.sheetMetalPartFileAllow
	List<String> milledPartFileAllow = GlobalVariable.milledPartFileAllow
	def commonText = "These parts cannot be automatically calculated. You can request a manual offer by the seller. All parts that could not automatically be calculated are bundled in this separate list."
	def contentManualSystemError = "${commonText}\nReason: There is a system error. Please contact the administrator. ($GlobalVariable.seller_mail)"
	def contentManualAutomaticCalSettingOff = "${commonText}\nReason: The quotation function is currently disabled. You can request a manual quote here."
	def contentManualCannotCalPart = "${commonText}\nReason: For this part no calculation could be executed. You can request a manual quote here."
	def contentManualPriceExceedThreshold = "${commonText}\nReason: This part has exceeded the pricing limits for online order. You can request a manual quote here."
	def contentManualSmallTolerance = "${commonText}\nReason: This tolerance requirement for this part are too high for online ordering. You can request a manual quote here."
	def contentManualCannotManufacturePart = "${commonText}\nReason: Not all process steps to manufacture this part could be identified. You can request a manual quote here."
	def contentManualCalError = "${commonText}\nReason: A technical error has occured when calculating this part. You can request a manual quote here."

	def commonTextForSeller = "These parts cannot be automatically calculated. Please prepare a quote for this request manually and enter it in the text field below \"Unit price\""
	def contentManualSystemErrorForSeller = "${commonTextForSeller}\nReason: There is a system error. Please contact the administrator. (support@gocad.de)"
	def contentManualAutomaticCalSettingOffForSeller = "${commonTextForSeller}\nReason: The quotation function is currently disabled. You can reactivate it in the \"price and delivery settings\"."
	def contentManualCannotCalPartForSeller = "${commonTextForSeller}\nReason: For this part no calculation could be executed. Please contact support@gocad.de."
	def contentManualPriceExceedThresholdForSeller = "${commonTextForSeller}\nReason: The pricing limits should not apply in \"self-calculation\""
	def contentManualSmallToleranceForSeller = "${commonTextForSeller}\nReason: This tolerance requirement for this part are very high. The automatic price quote is possible, but a critical check of the processed calculation is necessary."
	def contentManualCannotManufacturePartForSeller = "${commonTextForSeller}\nReason: Only for XX % of the part, manufacturing process steps could be identified. Please check the calculation."
	def contentManualCalErrorForSeller = "${commonTextForSeller}\nReason: A technical error has occured when calculating this part. Please contact support@gocad.de"
	def contentAlert = "All parts will be manufactured according to industry norms. If there are specifics for the manufacturing process, that need to be considered, please upload a PDF-drawing to the affected part."

	public ManufacturingInformationPage clickAddPart() {
		WebUI.click(xpath('//span[text()=" Add part"]'))
		return this
	}

	public ManufacturingInformationPage clickImagePart() {
		WebUI.click(xpath('//img[@class="ant-image-img"]/following-sibling::div/span'))
		return this
	}

	public ManufacturingInformationPage clickDownloadImage() {
		WebUI.click(xpath('//a[@class="text-decoration-none"]'))
		return this
	}

	public ManufacturingInformationPage clickDeletePart() {
		WebUI.click(xpath('//span[contains(text(),"Delete")]'))
		return this
	}

	public ManufacturingInformationPage clickCopyPart() {
		WebUI.click(xpath('//span[contains(text(),"Copy")]'))
		return this
	}

	public ManufacturingInformationPage clickMoreOption() {
		WebUI.click(xpath('//span[@role="img" and @aria-label="more"]/parent::button'))
		return this
	}

	public ManufacturingInformationPage clickMovePart() {
		WebUI.click(xpath('//span[contains(text(),"Move")]'))
		return this
	}

	public ManufacturingInformationPage clickOK() {
		WebUI.click(xpath('//span[contains(text(),"OK")]'))
		return this
	}

	public ManufacturingInformationPage clickPleaseSelectMaterial() {
		WebUI.click(xpath("//label[@for='materialId']/parent::div/following::a"))
		return this
	}

	public ManufacturingInformationPage clickManufacturingInformationReport() {
		WebUI.click(xpath("//span[text()=' Manufacturing information']/parent::button"))
		return this
	}

	public ManufacturingInformationPage clickProcessingReport() {
		WebUI.click(xpath("//span[text()=' Processing report']/parent::button"))
		return this
	}

	public ManufacturingInformationPage clickEmissionReport() {
		WebUI.click(xpath("//span[text()=' Emission report']/parent::button"))
		return this
	}

	public ManufacturingInformationPage clickCostsReport() {
		WebUI.click(xpath("//span[text()=' Costs report']/parent::button"))
		return this
	}

	public ManufacturingInformationPage clickProvideOwnMaterialCB(String value) {
		String contentClass = WebUI.getAttribute(xpath("//input[@id='materialProvided']/parent::span"), "class")
		String isChecked = contentClass.contains("checked")
		boolean isYes = value.equals("true")
		if(Boolean.parseBoolean(isChecked) != isYes) {
			WebUI.click(xpath('//span[text()="Provide own material"]'))
		}
		return this
	}

	public ManufacturingInformationPage clickPartAccordingToTheDrawingCB(String value) {
		String contentClass = WebUI.getAttribute(xpath("//input[@id='partAccordingToTheDrawing']/parent::span"), "class")
		String isChecked = contentClass.contains("checked")
		boolean isYes = value.equals("true")
		if(Boolean.parseBoolean(isChecked) != isYes) {
			WebUI.click(xpath('//span[text()="Please manufacture the part according to the drawing"]'))
		}
		return this
	}

	public ManufacturingInformationPage inputQuantity(String number) {
		clearTextAndSendKeysByActions(xpath('//*[@id="quantity"]'), number)
		return this
	}

	public ManufacturingInformationPage inputThread(String number) {
		clearTextAndSendKeysByActions(xpath('//*[@id="numberOfThreads"]'), number)
		return this
	}

	public ManufacturingInformationPage clickSelectLayers() {
		WebUI.click(xpath("//div[@class='pointer']"))
		return this
	}

	public ManufacturingInformationPage inputCountersink(String number) {
		clearTextAndSendKeysByActions(xpath('//*[@id="countersink"]'), number)
		return this
	}

	public ManufacturingInformationPage selectThickness(String partName, String value) {
		for (int i = 0; i < sheetMetalPartFileAllow.size(); i++) {
			def isContains = partName.contains(sheetMetalPartFileAllow[i])
			println "isContains: $isContains"
			if (isContains) {
				WebUI.click(xpath("//*[text()='Thickness']/parent::div/following-sibling::div//div[@class='ant-select-selector']"))
				WebUI.click(xpath("//*[@id='thickness_list']/following-sibling::div[@class='rc-virtual-list']//div[text()='$value']"))
			}
		}
		return this
	}

	public ManufacturingInformationPage selectSurfaceTreatment(String surfaceTreatment) {
		WebUI.click(xpath("//input[@id='surfaceTreatmentIds']/ancestor::div[contains(@class, 'ant-select-in-form-item')]"))
		List<String> surfaceTreatmentObject = findTestObjects("//div[contains(@class, 'ant-select-item-option-content') and text()='$surfaceTreatment']/parent::div")
		(surfaceTreatmentObject.size() != 0) ? WebUI.click(xpath("//div[contains(@class, 'ant-select-item-option-content') and text()='$surfaceTreatment']/parent::div")) : "Empty"
		//WebUI.click(xpath("//span[@class='ant-steps-icon']/span[text()='2']"))
		WebUI.click(xpath("//div[text()='Manufacturing']/ancestor::div[@class='ant-steps-item-container']"))
		return this
	}

	public ManufacturingInformationPage removeSelectSurfaceTreatment(String surfaceTreatment) {
		List<String> surfaceTreatmentObject = findTestObjects("//span[contains(@class, 'ant-select-selection-item-content') and text()='$surfaceTreatment']/following::span[@class='ant-select-selection-item-remove']")
		(surfaceTreatmentObject.size() != 0) ? WebUI.click(xpath("//span[contains(@class, 'ant-select-selection-item-content') and text()='$surfaceTreatment']/following::span[@class='ant-select-selection-item-remove']")) : ""
		return this
	}

	public ManufacturingInformationPage inputComment(String text) {
		clearTextAndSendKeysByActions(xpath('//*[@id="additionalComments"]'), text)
		return this
	}

	public ManufacturingInformationPage inputBulkPricing(String line, String input) {
		WebUI.click(xpath("(//div[@class='ant-card-body']//*[@class='text-input-value'])[$line]"))
		String oldValue = WebUI.getAttribute(xpath("//*[@id='form-inline-quantity_quantity']"),"value")
		clearTextAndSendKeysByActionsBackSpace(xpath("//*[@id='form-inline-quantity_quantity']"), oldValue, input)
		return this
	}

	public ManufacturingInformationPage clickAcceptChangeBulkPricing() {
		WebUI.click(xpath("//*[@aria-label='check']"))
		return this
	}

	public ManufacturingInformationPage clickAcceptChangeUnitPricing() {
		WebUI.click(xpath("//*[@aria-label='check']"))
		return this
	}

	public ManufacturingInformationPage uploadFilePDFTesting(String workshop, String fileName) {
		WebUI.waitForElementClickable(xpath("//span[text()='Calculate']/parent::button"), 15)
		def path = RunConfiguration.getProjectDir() + "/Data/FileTesting/$fileName"
		if (workshop == "Milled / Turned Parts" & fileName != "") {
			WebUI.uploadFile(xpath("//span[@class='ant-upload']/input"), path)
			waitForElementDisplay(xpath("//label[@title='Thread (Quantity)']/parent::div/following-sibling::div//div[@class='b-robot']/div/*[@class='check']"))
		}
		else if (workshop == "Sheet Metal Part" & fileName != "") {
			WebUI.uploadFile(xpath("//span[@class='ant-upload']/input"), path)
		}
		return this
	}
	
	public ManufacturingInformationPage inputFieldSMPShop(String provideOwnProduct, String partName, String thicknessNum, 
		String quantityNum, String surfaceTreatment, String laserMarking, String deburring, String countersinkNum, String threadNum, String comment) {
		clickProvideOwnMaterialCB(provideOwnProduct)
		.selectThickness(partName, thicknessNum)
		.inputQuantity(quantityNum)
		.selectSurfaceTreatment(surfaceTreatment)
		.selectLaserMarking(laserMarking)
		.selectDeburring(deburring)
		.inputCountersink(countersinkNum)
		.inputThread(threadNum)
		.inputComment(comment)
		return this
	}
	
	public ManufacturingInformationPage inputFieldMTPShop(String provideOwnProduct, String quantityNum, String threadNum, 
		String tolerancesNum, String tolerancesToggle,String surfaceTreatment, String quality, String comment) {
		clickProvideOwnMaterialCB(provideOwnProduct)
		.inputQuantity(quantityNum)
		.inputThread(threadNum)
		.inputTolerances(tolerancesNum)
		.clickToggleTolerances(tolerancesToggle)
		.selectSurfaceTreatment(surfaceTreatment)
		.selectSurfaceQuality(quality)
		.inputComment(comment)
		return this
	}

	public String getMaterialWhenUploadFilePDF() {
		String material = WebUI.getText(xpath("//div[@id='materialId']/a"))
		def pattern = /(.*?)\s*\(.+\)/
		String newGetMaterial = CommonUtility.substringUseRegExp(material,pattern,1)
		println "material name: $material"
		return newGetMaterial
	}

	public String getMaterialGroupWhenUploadFilePDF() {
		String materialGroup = WebUI.getText(xpath("//div[@id='materialId']/a"))
		def pattern = /(.+)\s+\((.+)\)/
		String newGetMaterialGroup = CommonUtility.substringUseRegExp(materialGroup,pattern,2)
		println "material group: $materialGroup"
		return newGetMaterialGroup
	}

	public ManufacturingInformationPage clickCalculate() {
		List<String> objectSave = findTestObjects("//span[text()='Save']/parent::button")
		if (objectSave.size() == 0) {
			WebUI.click(xpath('//span[text()="Calculate"]/parent::button'))
			WebUI.waitForElementVisible(xpath("//label[text()='Unit price']"), 10)
		}
		else {
			WebUI.click(xpath("//span[text()='Save']/parent::button"))
			WebUI.waitForElementVisible(xpath("//label[text()='Unit price']"), 10)
		}
		return this
	}

	public ManufacturingInformationPage clickAddTechnicalDrawing() {
		WebUI.click(xpath('//button[@title="Upload technical drawing"]'))
		return this
	}

	public ManufacturingInformationPage inputUnitPrice(String text) {
		clearTextAndSendKeysByActions(xpath('//*[@id="unitPrice"]'), text)
		return this
	}

	public ManufacturingInformationPage clickReview() {
		WebUI.click(xpath('//span[text()="Review "]/parent::button'))
		return this
	}

	public ManufacturingInformationPage clickManufacturingInformationProcess() {
		WebUI.click(xpath("//span[@class='ant-steps-icon']/span[text()='2']"))
		return this
	}

	public ManufacturingInformationPage clickEdit() {
		WebUI.click(xpath('//span[text()="Edit"]/parent::button'))
		return this
	}

	public ManufacturingInformationPage clickCancel() {
		WebUI.click(xpath('//span[text()="Cancel"]'))
		return this
	}
	//Data upload > Milled / Turned Parts
	public ManufacturingInformationPage inputTolerances(String number) {
		clearTextAndSendKeysByActions(xpath('//*[@id="numberOfFits"]'), number)
		return this
	}

	public ManufacturingInformationPage clickToggleTolerances(String value) {
		String isChecked = WebUI.getAttribute(xpath("//*[@id='hasTolerances']"), "aria-checked")
		boolean isYes = value.equals("Yes")
		if(Boolean.parseBoolean(isChecked) != isYes) {
			WebUI.click(xpath("//*[@id='hasTolerances']"))
		}
		return this
	}

	public ManufacturingInformationPage selectSurfaceQuality(String quality) {
		WebUI.click(xpath("//*[text()='Surface Quality']/parent::div/following::div[@class='ant-select-selector']"))
		WebUI.click(xpath("//*[@class='rc-virtual-list']//div[@title='$quality']"))
		return this
	}

	public ManufacturingInformationPage inputDeliveryDate(String deliveryDate) {
		WebUI.sendKeys(xpath("//input[@id='deliveryDate']"), deliveryDate + Keys.RETURN)
		return this
	}

	public ManufacturingInformationPage selectRollingDirection(String name) {
		WebUI.click(xpath("//*[text()='Rolling Direction']/parent::div/following::div[@class='ant-select-selector']"))
		WebUI.click(xpath("//*[@class='rc-virtual-list']//div[@title='$name']"))
		return this
	}

	public ManufacturingInformationPage selectLaserMarking(String value) {
		WebUI.click(xpath("//*[text()='Laser marking']/parent::div/following-sibling::div//div[@class='ant-select-selector']"))
		WebUI.click(xpath("//*[@id='laserMarking_list']/following-sibling::div[@class='rc-virtual-list']//div[@title='$value']"))
		return this
	}

	public ManufacturingInformationPage selectDeburring(String value) {
		WebUI.click(xpath("//*[text()='Deburring']/parent::div/following-sibling::div//div[@class='ant-select-selector']"))
		WebUI.click(xpath("//*[@id='deburringType_list']/following-sibling::div[@class='rc-virtual-list']//div[@title='$value']"))
		return this
	}

	public ManufacturingInformationPage verifyPDFFileVisibleAfterCalculated(String fileName) {
		String href = WebUI.getAttribute(xpath("//a[@class='text-decoration-none' and @title='$fileName']"), "href")
		WebUI.verifyElementVisible(xpath("//a[@href='$href']"))
		return this
	}

	public ManufacturingInformationPage verifyAlertSMPVisible() {
		String actualContent = WebUI.getText(xpath("//*[@class='ant-alert-message']"))
		WebUI.verifyEqual(actualContent, contentAlert)
		return this
	}

	public ManufacturingInformationPage verifyBulkPricingValue(String line, String expectedResult) {
		String actualResult = WebUI.getText(xpath("(//div[@class='ant-card-body']//*[@class='text-input-value'])[$line]")).trim()
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ManufacturingInformationPage clickPDFFileToDownload(String fileName) {
		WebUI.click(xpath("//a[@class='text-decoration-none' and contains(@title, 'pdf')]"))
		return this
	}

	public ManufacturingInformationPage clickPartFileToDownload(String fileName) {
		WebUI.click(xpath("//a[@class='text-decoration-none' and contains(@title, '$fileName')]"))
		return this
	}

	public String getUnitPriceValue() {
		List<String> findObject = findTestObjects("//*[text()='Unit price']/following-sibling::label")
		def unitPrice = (findObject.size() != 0) ? WebUI.getText(xpath("//*[text()='Unit price']/following-sibling::label")).trim() : WebUI.getAttribute(xpath("//*[@id='unitPrice']"), "value")
		println "unitPrice func: $unitPrice"
		return unitPrice
	}

	public String getNetPriceValue() {
		String netPrice = WebUI.getText(xpath("//*[text()='NET Total']/following-sibling::h6")).trim()
		return netPrice
	}

	public ManufacturingInformationPage verifyMaterialValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Material']/following-sibling::div")).trim()
		println "MaterialValue: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ManufacturingInformationPage verifyQuantityValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Quantity']/following-sibling::label")).trim()
		println "QuantityValue: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ManufacturingInformationPage verifyThreadValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Thread (Quantity)']/following-sibling::div")).trim()
		println "ThreadValue: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ManufacturingInformationPage verifyThreadValueOnSMP(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Thread Cutting']/following-sibling::label")).trim()
		println "ThreadValue: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ManufacturingInformationPage verifyTolerancesNumberValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Tolerances and fits with less than 1/10mm or IT 1 - IT 10 (Number)']/following-sibling::div")).trim()
		println "TolerancesNumberValue: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ManufacturingInformationPage verifyTolerancesToggleValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Tolerance requirement with smaller 1/100mm or IT 1 - IT 5']/following-sibling::label")).trim()
		println "TolerancesToggleValue: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ManufacturingInformationPage verifySurfaceTreatmentValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Surface Treatment']/following-sibling::label")).trim()
		String conActualResult = (actualResult == "None") ? "" : actualResult
		println "verifySurfaceTreatmentValue: $conActualResult"
		WebUI.verifyEqual(conActualResult, expectedResult)
		return this
	}

	public ManufacturingInformationPage verifySurfaceQualityValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Surface Quality']/following-sibling::label")).trim()
		println "SurfaceQualityValue: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ManufacturingInformationPage verifyRollingDirectionValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Rolling Direction']/following-sibling::label")).trim()
		println "RollingDirectionValue: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ManufacturingInformationPage verifyLaserMarkingValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Laser marking']/following-sibling::label")).trim()
		println "LaserMarkingValue: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ManufacturingInformationPage verifyCountersinkValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Countersink']/following-sibling::label")).trim()
		println "CountersinkValue: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ManufacturingInformationPage verifyThicknessValue(String partName, String expectedResult) {
		for (int i = 0; i < sheetMetalPartFileAllow.size(); i++) {
			def isContains = partName.contains(sheetMetalPartFileAllow[i])
			println "isContains: $isContains"
			if (isContains) {
				String actualResult = WebUI.getText(xpath("//*[text()='Thickness']/parent::p")).trim()
				def pattern = /(\d+(?:\.\d+)?)/
				String newActualResult = CommonUtility.substringUseRegExp(actualResult,pattern,0)
				WebUI.verifyEqual(newActualResult, expectedResult)
				println "Thickness: $newActualResult"
			}
		}
		return this
	}

	public ManufacturingInformationPage verifyCuttingLayersValue(String partName, String expectedResult) {
		for (int i = 0; i < sheetMetalPartFileAllow.size(); i++) {
			def isContains = partName.contains(sheetMetalPartFileAllow[i])
			if(isContains) {
				String actualResult = WebUI.getText(xpath("//*[text()='Cutting layers']/following-sibling::label")).trim()
				WebUI.verifyEqual(actualResult, expectedResult)
			}
		}
		return this
	}

	public ManufacturingInformationPage verifyDeburringValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Deburring']/following-sibling::label")).trim()
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ManufacturingInformationPage verifyPartAccordingToTheDrawingValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Part according to the drawing']/following-sibling::label")).trim()
		def actualResultCon = (actualResult == "No") ? "false" : "true"
		WebUI.verifyEqual(actualResultCon, expectedResult)
		return this
	}

	public ManufacturingInformationPage verifyAdditionalCommentsValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Additional Comments']/following-sibling::label")).trim()
		println "AdditionalCommentsValue: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ManufacturingInformationPage verifyUnitPriceValue(String expectedResult) {
		List<String> findObject = findTestObjects("//*[text()='Unit price']/following-sibling::label")
		def actualResult = (findObject.size() != 0) ? WebUI.getText(xpath("//*[text()='Unit price']/following-sibling::label")).trim() : (WebUI.getAttribute(xpath("//*[@id='unitPrice']"), "value") + " $GlobalVariable.currency")
		println "unitPrice func: $actualResult"
		String convertExpectedResult = expectedResult + " $GlobalVariable.currency"
		WebUI.verifyEqual(actualResult, convertExpectedResult)
		return this
	}

	public ManufacturingInformationPage verifyNetPriceValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='NET Total']/following-sibling::h6")).trim()
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public String calculateNetPrice(String unitPrice, String quantity) {
		String formattedSum
		String newExpectedResult
		def decimalFormat = new DecimalFormat("###,##0.00")
		if(unitPrice.contains(".")) {
			def numericValue = unitPrice.replaceAll(/[^\d.,]/, '').replace('.', '').replace(',', '.').toDouble()
			def expectedResult = quantity.toDouble() * numericValue
			formattedSum = decimalFormat.format(expectedResult)
			newExpectedResult = "$formattedSum $GlobalVariable.currency"
		}
		else {
			def numericValue = unitPrice.replaceAll(/[^\d.,]/, '').replace(',', '.').toDouble()
			def expectedResult = quantity.toDouble() * numericValue
			formattedSum = decimalFormat.format(expectedResult).replace('.', ',')
			newExpectedResult = "$formattedSum $GlobalVariable.currency"
		}
		return newExpectedResult
	}

	public ManufacturingInformationPage verifyShowErrorIncompatibleFile() {
		WebUI.verifyElementPresent(xpath("//*[@aria-label='codepen']"), 5)
		return this
	}

	public ManufacturingInformationPage verifyProcessAddProjectHighLighted() {
		String colorTwo = WebUI.getCSSValue(xpath("//div[text()='Manufacturing']/parent::div/preceding-sibling::div//*[text()='2']/parent::span"), "color")
		println "colorTwo: $colorTwo"
		String pattern = /(rgba\(\d+,\s*\d+,\s*\d+,\s*\d+\))/
		String rgbValue = CommonUtility.substringUseRegExp(colorTwo, pattern,1)
		println "rgbValue: $rgbValue"
		String rgbToHex = CommonUtility.rgbToHex(rgbValue)
		println "rgbToHex: $rgbToHex"
		WebUI.verifyEqual(rgbToHex, GlobalVariable.highlightColor)
		return this
	}

	public ManufacturingInformationPage verifyAddTechnicalDrawingButtonVisible() {
		WebUI.verifyElementVisible(xpath('//button[@title="Upload technical drawing"]'))
		return this
	}

	public ManufacturingInformationPage verifyAddPartButtonVisible() {
		WebUI.verifyElementVisible(xpath('//span[text()=" Add part"]'))
		return this
	}

	public ManufacturingInformationPage verifyCalculateButtonVisible() {
		WebUI.verifyElementVisible(xpath('//span[text()="Calculate"]/parent::button'))
		return this
	}

	public ManufacturingInformationPage verifyMoreButtonVisible() {
		WebUI.verifyElementVisible(xpath("//*[@aria-label='more']"))
		return this
	}

	public ManufacturingInformationPage verifyDeleteButtonVisible() {
		WebUI.verifyElementVisible(xpath('//span[contains(text(),"Delete")]/parent::li'))
		return this
	}

	public ManufacturingInformationPage verifyEditButtonVisible() {
		WebUI.verifyElementVisible(xpath('//span[contains(text(),"Edit")]/parent::button'))
		return this
	}

	public ManufacturingInformationPage verifyCopyButtonVisible() {
		WebUI.verifyElementVisible(xpath('//span[contains(text(),"Copy")]/parent::li'))
		return this
	}

	public ManufacturingInformationPage verifyMoveButtonVisible() {
		WebUI.verifyElementVisible(xpath('//span[contains(text(),"Move")]/parent::li'))
		return this
	}

	public ManufacturingInformationPage verifyReviewButtonVisible() {
		WebUI.verifyElementVisible(xpath('//span[text()="Review "]'))
		return this
	}

	public ManufacturingInformationPage verifyManufacturingInformationReportButtonVisible() {
		WebUI.verifyElementVisible(xpath("//span[text()=' Manufacturing information']/parent::button"))
		return this
	}

	public ManufacturingInformationPage verifyProcessingReportButtonVisible() {
		WebUI.verifyElementVisible(xpath("//span[text()=' Processing report']/parent::button"))
		return this
	}

	public ManufacturingInformationPage verifyEmissionReportButtonVisible() {
		WebUI.verifyElementVisible(xpath("//span[text()=' Emission report']/parent::button"))
		return this
	}

	public ManufacturingInformationPage verifySurfaceQualitySelectVisible() {
		WebUI.verifyElementVisible(xpath("//*[text()='Surface Quality']/parent::div/following::div[@class='ant-select-selector']"))
		return this
	}

	public ManufacturingInformationPage verifyTolerancesToggleVisible() {
		WebUI.verifyElementVisible(xpath("//*[@id='hasTolerances']"))
		return this
	}

	public ManufacturingInformationPage verifyTolerancesFitsInputVisible() {
		WebUI.verifyElementVisible(xpath('//*[@id="numberOfFits"]'))
		return this
	}

	public ManufacturingInformationPage verifyThicknessInputVisible(String partName) {
		for (int i = 0; i < sheetMetalPartFileAllow.size(); i++) {
			def isContains = partName.contains(sheetMetalPartFileAllow[i])
			if(isContains) WebUI.verifyElementPresent(id("thickness"), 5)
		}
		return this
	}

	public ManufacturingInformationPage verifyCostsReportButtonVisible() {
		WebUI.verifyElementVisible(xpath("//span[text()=' Costs report']/parent::button"))
		return this
	}

	public ManufacturingInformationPage verifyUndoButtonVisible() {
		WebUI.verifyElementVisible(xpath("//span[@aria-label='undo']/parent::button"))
		return this
	}

	public ManufacturingInformationPage verifyAcceptUnitPriceButtonVisible() {
		WebUI.verifyElementVisible(xpath("//span[@aria-label='check']/parent::button"))
		return this
	}

	public ManufacturingInformationPage verifyCountersinkInputVisible() {
		WebUI.verifyElementVisible(xpath('//*[@id="countersink"]'))
		return this
	}

	public ManufacturingInformationPage verifyRollingDirectioVisible() {
		WebUI.verifyElementClickable(xpath('//*[@id="rollingDirection"]'))
		WebUI.verifyElementVisible(xpath('//*[@id="rollingDirection"]/parent::span/following::span[@title="Egal"]'))
		return this
	}

	public ManufacturingInformationPage verifyLaserMarkingSelectVisible() {
		WebUI.verifyElementClickable(xpath('//*[@id="laserMarking"]'))
		WebUI.verifyElementVisible(xpath('//*[@id="laserMarking"]/parent::span/following::span[@title="No"]'))
		return this
	}

	public ManufacturingInformationPage verifyDeburringVisible() {
		WebUI.verifyElementVisible(xpath("//input[@id='deburringType']/parent::span"))
		return this
	}

	public ManufacturingInformationPage verifyCommentInputVisible() {
		WebUI.verifyElementVisible(xpath('//*[@id="additionalComments"]'))
		return this
	}

	public ManufacturingInformationPage verifyThreadInputVisible() {
		WebUI.verifyElementVisible(xpath('//*[@id="numberOfThreads"]'))
		return this
	}

	public ManufacturingInformationPage verifySurfaceTreatmentSelectVisible() {
		WebUI.verifyElementVisible(xpath("//*[text()='Surface Treatment']/parent::div/following::div[@class='ant-select-selector']"))
		return this
	}

	public ManufacturingInformationPage verifyQuantityInputVisible() {
		WebUI.verifyElementVisible(xpath('//*[@id="quantity"]'))
		return this
	}

	public ManufacturingInformationPage verifyUnitPriceInputVisible() {
		WebUI.verifyElementVisible(xpath('//*[@id="unitPrice"]'))
		return this
	}

	public ManufacturingInformationPage verifyProvideOwnMaterialCBVisible() {
		WebUI.verifyElementVisible(xpath('//span[text()="Provide own material"]'))
		return this
	}

	public ManufacturingInformationPage verifySelectMaterialVisible() {
		WebUI.verifyElementVisible(xpath("//label[@for='materialId']/parent::div/following::a"))
		return this
	}

	public ManufacturingInformationPage verifyPartImageVisible() {
		WebUI.verifyElementVisible(xpath("//img[@class='ant-image-img']"))
		return this
	}

	public ManufacturingInformationPage verifyCuttingLayersVisible(String partName) {
		for (int i = 0; i < sheetMetalPartFileAllow.size(); i++) {
			def isContains = partName.contains(sheetMetalPartFileAllow[i])
			if (isContains) WebUI.verifyElementVisible(xpath("//*[text()='All layers']"))
		}
		return this
	}

	public ManufacturingInformationPage verifyUnfoldingPreviewVisible(String partName) {
		for (int i = 0; i < milledPartFileAllow.size(); i++) {
			def isContains = partName.contains(milledPartFileAllow[i])
			if (isContains) WebUI.verifyElementVisible(xpath("//*[text()='Unfolding Preview']"))
		}
		return this
	}

	public ManufacturingInformationPage verifyDeliveryDateInputVisible() {
		WebUI.verifyElementVisible(id("deliveryDate"))
		return this
	}

	public ManufacturingInformationPage verifyCanPreviewPartFile() {
		WebUI.click(xpath('//img[@class="ant-image-img"]/following-sibling::div/span'))
		List<String> findObject = findTestObjects("//div[@class='ant-modal-mask']/following::div[@class='icon-loading']")
		(findObject != 0) ? waitUntilElementInvisibleWithWebDriverWait(xpath("//div[@class='ant-modal-mask']/following::div[@class='icon-loading']"), 10) : ""
		WebUI.verifyElementVisible(xpath("//div[@class='ant-modal-body']/*[@class='classmateCloudFrame']"))
		return this
	}

	public ManufacturingInformationPage verifyCanViewUnfoldingPreview(String partName) {
		for (int i = 0; i < milledPartFileAllow.size(); i++) {
			def isContains = partName.contains(milledPartFileAllow[i])
			if(isContains) {
				WebUI.click(xpath("//*[text()='Unfolding Preview']"))
				waitUntilElementInvisibleWithWebDriverWait(xpath("//div[@class='ant-modal-mask']/following::div[@class='icon-loading']"), 10)
				WebUI.verifyElementPresent(xpath("//div[@class='ant-modal-body']"),5)
			}
		}
		return this
	}

	public ManufacturingInformationPage verifyCanPreviewPartFileOnSMP() {
		WebUI.click(xpath('//img[@class="ant-image-img"]/following-sibling::div/span'))
		waitUntilElementInvisibleWithWebDriverWait(xpath("//div[@class='ant-modal-mask']/following::div[@class='icon-loading']"), 10)
		WebUI.verifyElementPresent(xpath("//div[@class='ant-modal-body']"), 10)
		return this
	}

	public ManufacturingInformationPage clickClosePreviewPartFilePopup() {
		List<String> findObject = findTestObjects("//div[@class='ant-modal-mask']/following::button[@class='ant-modal-close']")
		if(findObject.size() != 0) {
			waitUntilElementVisibleWithWebDriverWait(xpath("//div[@class='ant-modal-mask']/following::button[@class='ant-modal-close']"), 10)
			WebUI.click(xpath("//div[@class='ant-modal-mask']/following::button[@class='ant-modal-close']"))
		}
		return this
	}

	public ManufacturingInformationPage verifyLinkPartVisible(String fileName) {
		WebUI.verifyElementVisible(xpath("//a[text()='$fileName']"))
		return this
	}

	public ManufacturingInformationPage verifyNamePartVisible(String fileName) {
		WebUI.verifyElementVisible(xpath("//a[text()='$fileName']"))
		return this
	}

	public ManufacturingInformationPage verifyNameWorkflowVisible(String workflow) {
		WebUI.verifyElementVisible(xpath("//label[text()='$workflow']"))
		return this
	}

	public ManufacturingInformationPage verifyTooltipTolerancesVisible() {
		WebUI.verifyElementVisible(xpath("//span[@aria-label='info-circle']"))
		WebUI.mouseOver(xpath("//span[@aria-label='info-circle']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Please enter the number of threads and tolerances in the component here. For a more detailed description, please refer to the attached graphic on the right.']"))
		return this
	}

	public ManufacturingInformationPage verifyBulkPricingVisible() {
		WebUI.verifyElementVisible(xpath("//*[text()='Bulk pricing']/parent::div"))
		return this
	}

	public ManufacturingInformationPage verifyErrorWhenQuantityEmpty() {
		def errorEmpty = WebUI.getText(xpath("//*[text()='Quantity']/parent::div/following::div[@id='quantity_help']/div"))
		def expectedResult = "Quantity is required."
		WebUI.verifyEqual(errorEmpty, expectedResult)
		return this
	}

	public ManufacturingInformationPage verifyErrorWhenMaterialEmpty() {
		def errorEmpty = WebUI.getText(xpath("//*[text()='Material']/parent::div/following::div[@id='materialId_help']/div"))
		def expectedResult = "Material is required."
		WebUI.verifyEqual(errorEmpty, expectedResult)
		return this
	}

	public ManufacturingInformationPage verifyErrorWhenThreadEmpty() {
		def errorEmpty = WebUI.getText(xpath("//*[text()='Thread (Quantity)']/parent::div/following::div[@id='numberOfThreads_help']/div"))
		def expectedResult = "Thread (Quantity) is required."
		WebUI.verifyEqual(errorEmpty, expectedResult)
		return this
	}

	public ManufacturingInformationPage verifyErrorWhenThreadCuttingEmpty() {
		def errorEmpty = WebUI.getText(xpath("//*[text()='Thread Cutting']/parent::div/following::div[@id='numberOfThreads_help']/div"))
		def expectedResult = "Thread Cutting is required."
		WebUI.verifyEqual(errorEmpty, expectedResult)
		return this
	}

	public ManufacturingInformationPage verifyErrorWhenCountersinkEmpty() {
		def errorEmpty = WebUI.getText(xpath("//*[text()='Countersink']/parent::div/following::div[@id='countersink_help']/div"))
		def expectedResult = "Countersink is required."
		WebUI.verifyEqual(errorEmpty, expectedResult)
		return this
	}

	public ManufacturingInformationPage verifyErrorWhenThicknessEmpty() {
		def errorEmpty = WebUI.getText(xpath("//*[text()='Thickness']/parent::div/following::div[@id='thickness_help']/div"))
		def expectedResult = "Thickness is required."
		WebUI.verifyEqual(errorEmpty, expectedResult)
		return this
	}

	public ManufacturingInformationPage verifyErrorWhenTolerancesEmpty() {
		def errorEmpty = WebUI.getText(xpath("//*[text()='Tolerances / fits (Number)']/parent::div/following::div[@id='numberOfFits_help']/div"))
		def expectedResult = "Tolerances / fits (Number) is required."
		WebUI.verifyEqual(errorEmpty, expectedResult)
		return this
	}

	public ManufacturingInformationPage verifyErrorBelowAddTechnicalDrawing(String expectedResult) {
		def errorEmpty = WebUI.getText(xpath("//*[@class='pt-2']/div[@class='helper-text']"))
		WebUI.verifyEqual(errorEmpty, expectedResult)
		return this
	}

	public ManufacturingInformationPage verifyContentAlertManualCalculateVisibleForBuyer(String code) {
		WebUI.verifyElementVisible(xpath("//span[@aria-label='info-circle']/following::div[@class='ant-alert-message']"))
		def contentAlertActual = WebUI.getText(xpath("//span[@aria-label='info-circle']/following::div[@class='ant-alert-message']"))
		switch (code) {
			case "SYSTEM_ERROR":
				def expectedResult = contentManualSystemError
				WebUI.verifyEqual(contentAlertActual, expectedResult)
				break;

			case "AUTOMATIC_CALCULATION_SETTING_OFF":
				def expectedResult = contentManualAutomaticCalSettingOff
				WebUI.verifyEqual(contentAlertActual, expectedResult)
				break;

			case "CANNOT_CALCULATE_PART":
				def expectedResult = contentManualCannotCalPart
				WebUI.verifyEqual(contentAlertActual, expectedResult)
				break;

			case "PRICE_EXCEED_THRESHOLD":
				def expectedResult = contentManualPriceExceedThreshold
				WebUI.verifyEqual(contentAlertActual, expectedResult)
				break;

			case "SMALL_TOLERANCES":
				def expectedResult = contentManualSmallTolerance
				WebUI.verifyEqual(contentAlertActual, expectedResult)
				break;

			case "CANNOT_MANUFACTURE_PART":
				def expectedResult = contentManualCannotManufacturePart
				WebUI.verifyEqual(contentAlertActual, expectedResult)
				break;

			case "CALCULATION_ERROR":
				def expectedResult = contentManualCalError
				WebUI.verifyEqual(contentAlertActual, expectedResult)
				break;
		}
		return this
	}

	public ManufacturingInformationPage verifyContentAlertManualCalculateVisibleForSeller(String code) {
		WebUI.verifyElementVisible(xpath("//span[@aria-label='info-circle']/following::div[@class='ant-alert-message']"))
		def contentAlertActual = WebUI.getText(xpath("//span[@aria-label='info-circle']/following::div[@class='ant-alert-message']"))
		switch (code) {
			case "SYSTEM_ERROR":
				def expectedResult = contentManualSystemErrorForSeller
				WebUI.verifyEqual(contentAlertActual, expectedResult)
				break;

			case "AUTOMATIC_CALCULATION_SETTING_OFF":
				def expectedResult = contentManualAutomaticCalSettingOffForSeller
				WebUI.verifyEqual(contentAlertActual, expectedResult)
				break;

			case "CANNOT_CALCULATE_PART":
				def expectedResult = contentManualCannotCalPartForSeller
				WebUI.verifyEqual(contentAlertActual, expectedResult)
				break;

			case "PRICE_EXCEED_THRESHOLD":
				def expectedResult = contentManualPriceExceedThresholdForSeller
				WebUI.verifyEqual(contentAlertActual, expectedResult)
				break;

			case "SMALL_TOLERANCES":
				def expectedResult = contentManualSmallToleranceForSeller
				WebUI.verifyEqual(contentAlertActual, expectedResult)
				break;

			case "CANNOT_MANUFACTURE_PART":
				def expectedResult = contentManualCannotManufacturePartForSeller
				WebUI.verifyEqual(contentAlertActual, expectedResult)
				break;

			case "CALCULATION_ERROR":
				def expectedResult = contentManualCalErrorForSeller
				WebUI.verifyEqual(contentAlertActual, expectedResult)
				break;
		}
		return this
	}
}
