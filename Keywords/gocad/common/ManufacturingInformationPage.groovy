package gocad.common

import java.nio.file.Files
import java.nio.file.Paths
import org.openqa.selenium.WebDriver

import org.openqa.selenium.Keys

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage
import katalon.utility.CommonUtility

public class ManufacturingInformationPage extends BasePage<ManufacturingInformationPage> {

	List<String> sheetMetalPartFileAllow = [".dxf", ".dwg"]
	List<String> milledPartFileAllow = [".step", ".stp"]
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
		WebUI.click(xpath('//*[@id="materialId"]/a'))
		return this
	}

	public ManufacturingInformationPage clickProvideOwnMaterialCB(String value) {
		String contentClass = WebUI.getAttribute(xpath("//input[@id='materialProvided']/parent::span"), "class")
		String isChecked = contentClass.contains("checked")
		boolean isYes = value.equals("true")
		if(Boolean.parseBoolean(isChecked) != isYes) {
			WebUI.click(xpath('//span[text()="Provide own material (From customer)"]'))
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
	
	public ManufacturingInformationPage selectNameLayers(String layerName) {
		WebUI.click(xpath("//a[text()='All layers']"))
		WebUI.click(xpath("//span[@class='ant-tree-title']//*[normalize-space(text()) = '$layerName']"))
		return this
	}
	
	public ManufacturingInformationPage selectAllLayers(String layer) {
		WebUI.click(xpath("//a[text()='All layers']"))
		WebUI.click(xpath("//span[@class='ant-tree-title' and text() = 'All layers']"))
		return this
	}

	public ManufacturingInformationPage inputCountersink(String number) {
		clearTextAndSendKeysByActions(xpath('//*[@id="countersink"]'), number)
		return this
	}

	public ManufacturingInformationPage inputThickness(String partName, String number) {
		for (int i = 0; i < sheetMetalPartFileAllow.size(); i++) {
			def isContains = sheetMetalPartFileAllow.contains(sheetMetalPartFileAllow[i])
			if (isContains) clearTextAndSendKeysByActions(xpath('//*[@id="thickness"]'), number)
		}
		return this
	}

	public ManufacturingInformationPage selectSurfaceTreatment(String surfaceTreatment) {
		WebUI.click(xpath("//div[contains(@class, 'ant-select-in-form-item')]"))
		List<String> surfaceTreatmentObject = findTestObjects("//div[contains(@class, 'ant-select-item-option-content') and text()='$surfaceTreatment']/parent::div")
		println "size:" + surfaceTreatmentObject.size()
		(surfaceTreatmentObject.size() != 0) ? WebUI.click(xpath("//div[contains(@class, 'ant-select-item-option-content') and text()='$surfaceTreatment']/parent::div")) : "Empty"
		WebUI.click(xpath("//div[contains(@class, 'ant-select-in-form-item')]"))
		return this
	}

	public ManufacturingInformationPage inputComment(String text) {
		WebUI.sendKeys(xpath('//*[@id="additionalComments"]'), text)
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
		WebUI.click(xpath('//span[text()="Calculate"]/parent::button'))
		WebUI.waitForElementVisible(xpath("//label[text()='Unit price']"), 10)
		return this
	}

	public ManufacturingInformationPage clickAddTechnicalDrawing() {
		WebUI.click(xpath('//button[@title="Add technical drawing"]'))
		return this
	}

	public ManufacturingInformationPage clickContinueToOfferOverview() {
		WebUI.click(xpath('//span[text()="Continue to offer overview "]/parent::button'))
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

	public ManufacturingInformationPage clickDeburringCheckbox(String value) {
		String contentClass = WebUI.getAttribute(xpath("//input[@id='deburring']/parent::span"), "class")
		String isChecked = contentClass.contains("checked")
		boolean isYes = value.equals("true")
		if(Boolean.parseBoolean(isChecked) != isYes) {
			WebUI.click(xpath('//span[text()="Deburring"]'))
		}
		return this
	}

	public ManufacturingInformationPage verifyPDFFileVisibleAfterCalculated(String fileName) {
		String href = WebUI.getAttribute(xpath("//a[@class='text-decoration-none' and @title='$fileName']"), "href")
		WebUI.verifyElementVisible(xpath("//a[@href='$href']"))
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
		String unitPrice = WebUI.getText(xpath("//*[text()='Unit price']/following-sibling::label")).trim()
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
		println "verifySurfaceTreatmentValue: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
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

	public ManufacturingInformationPage verifyCountersinkValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Countersink']/following-sibling::label")).trim()
		println "CountersinkValue: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ManufacturingInformationPage verifyThicknessValue(String partName, String expectedResult) {
		for (int i = 0; i < sheetMetalPartFileAllow.size(); i++) {
			def isContains = partName.contains(sheetMetalPartFileAllow[i])
			if(isContains) {
				String actualResult = WebUI.getText(xpath("//*[text()='Thickness (mm)']/following-sibling::label")).trim()
				println "ThicknessValue: $actualResult"
				WebUI.verifyEqual(actualResult, expectedResult)
			}
		}
		return this
	}

	public ManufacturingInformationPage verifyCuttingLayersValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Cutting layers']/following-sibling::label")).trim()
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ManufacturingInformationPage verifyDeburringCheckboxValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Deburring']/following-sibling::label")).trim()
		String actualResultCompare = (actualResult == "Yes")  ? "true" : "false"
		WebUI.verifyEqual(actualResultCompare, expectedResult)
		return this
	}

	public ManufacturingInformationPage verifyAdditionalCommentsValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Additional Comments']/following-sibling::label")).trim()
		println "AdditionalCommentsValue: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public ManufacturingInformationPage verifyUnitPriceValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Unit price']/following-sibling::label")).trim()
		println "UnitPriceValue: $actualResult"
		String convertExpectedResult = expectedResult + " €"
		WebUI.verifyEqual(actualResult, convertExpectedResult)
		return this
	}

	public ManufacturingInformationPage verifyNetPriceValue(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='NET Total']/following-sibling::h6")).trim()
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public String calculateNetPrice(String unitPrice, String quantity) {
		def numericValue = unitPrice.replaceAll(/[^\d.,]/, '').replace(',', '.').toDouble()
		def expectedResult = quantity.toDouble() * numericValue
		String formattedSum = "${String.format("%.2f", expectedResult)} €"
		String newExpectedResult = formattedSum.replace('.', ',')
		return newExpectedResult
	}

	public ManufacturingInformationPage verifyShowErrorIncompatibleFile() {
		WebUI.verifyElementVisible(xpath("//div[text()='There is problem when calculating the request. Please contact the admin.']"))
		return this
	}

	public ManufacturingInformationPage verifyProcessAddProjectHighLighted() {
		String colorTwo = WebUI.getCSSValue(xpath("//div[text()='Manufacturing information']/parent::div/preceding-sibling::div//*[text()='2']"), "background")
		String pattern = /(rgb\(\d+,\s*\d+,\s*\d+\))/
		String rgbValue = CommonUtility.substringUseRegExp(colorTwo, pattern,1)
		String rgbToHex = CommonUtility.rgbToHex(rgbValue)
		WebUI.verifyEqual(rgbToHex, "#FFCB3D")
		return this
	}

	public ManufacturingInformationPage verifyAddTechnicalDrawingButtonVisible() {
		WebUI.verifyElementVisible(xpath('//button[@title="Add technical drawing"]'))
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

	public ManufacturingInformationPage verifyContinueToOfferOverviewButtonVisible() {
		WebUI.verifyElementVisible(xpath('//span[text()="Continue to offer overview "]'))
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
		for (int i = 0; i < sheetMetalPartFileAllow.size(); i++)
		{
			def isContains = partName.contains(sheetMetalPartFileAllow[i])
			if(isContains) WebUI.verifyElementVisible(xpath('//*[@id="thickness"]'))
		}
		return this
	}

	public ManufacturingInformationPage verifyCountersinkInputVisible() {
		WebUI.verifyElementVisible(xpath('//*[@id="countersink"]'))
		return this
	}

	public ManufacturingInformationPage verifyRollingDirectionSelectVisible() {
		WebUI.verifyElementClickable(xpath('//*[@id="rollingDirection"]'))
		WebUI.verifyElementVisible(xpath('//*[@id="rollingDirection"]/parent::span/following::span[@title="Egal"]'))
		return this
	}

	public ManufacturingInformationPage verifyDeburringCheckboxVisible() {
		WebUI.verifyElementVisible(xpath("//input[@id='deburring']/parent::span"))
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

	public ManufacturingInformationPage verifyProvideOwnMaterialCBVisible() {
		WebUI.verifyElementVisible(xpath('//span[text()="Provide own material (From customer)"]'))
		return this
	}

	public ManufacturingInformationPage verifySelectMaterialVisible() {
		WebUI.verifyElementVisible(xpath('//*[@id="materialId"]/a'))
		return this
	}

	public ManufacturingInformationPage verifyPartImageVisible() {
		WebUI.verifyElementVisible(xpath("//img[@class='ant-image-img']"))
		return this
	}

	public ManufacturingInformationPage verifyCuttingLayersVisible(String partName) {
		for (int i = 0; i < sheetMetalPartFileAllow.size(); i++)
		{
			def isContains = partName.contains(sheetMetalPartFileAllow[i])
			if (isContains) WebUI.verifyElementVisible(xpath("//*[text()='All layers]"))
		}
		return this
	}

	public ManufacturingInformationPage verifyUnfoldingPreviewVisible(String partName) {
		for (int i = 0; i < milledPartFileAllow.size(); i++)
		{
			def isContains = partName.contains(sheetMetalPartFileAllow[i])
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
		waitUntilElementInvisibleWithWebDriverWait(xpath("//div[@class='ant-modal-mask']/following::div[@class='icon-loading']"), 10)
		WebUI.verifyElementVisible(xpath("//div[@class='ant-modal-body']/*[@class='classmateCloudFrame']"))
		return this
	}

	public ManufacturingInformationPage verifyCanViewUnfoldingPreview(String partName) {
		for (int i = 0; i < milledPartFileAllow.size(); i++)
		{
			def isContains = partName.contains(milledPartFileAllow[i])
			if(isContains)
			{
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
		waitUntilElementVisibleWithWebDriverWait(xpath("//div[@class='ant-modal-mask']/following::button[@class='ant-modal-close']"), 10)
		WebUI.click(xpath("//div[@class='ant-modal-mask']/following::button[@class='ant-modal-close']"))
		return this
	}

	public ManufacturingInformationPage verifyLinkPartVisible(String fileName) {
		WebUI.verifyElementVisible(xpath("//span[text()='$fileName']"))
		return this
	}

	public ManufacturingInformationPage verifyNamePartVisible(String fileName) {
		WebUI.verifyElementVisible(xpath("//span[text()='$fileName']"))
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

	public ManufacturingInformationPage verifyErrorWhenTolerancesEmpty() {
		def errorEmpty = WebUI.getText(xpath("//*[text()='Tolerances / fits (Number)']/parent::div/following::div[@id='numberOfFits_help']/div"))
		def expectedResult = "Tolerances / fits (Number) is required."
		WebUI.verifyEqual(errorEmpty, expectedResult)
		return this
	}

	public ManufacturingInformationPage verifyContentAlertManualCalculateVisible() {
		WebUI.verifyElementVisible(xpath("//*[@class='ant-alert-message']"))
		def contentAlertActual = WebUI.getText(xpath("//*[@class='ant-alert-message']"))
		def expectedResult = "These parts cannot be automatically calculated. All parts that could not automatically be calculated are bundled in this separate list. Please prepare a quote for this request manually and enter it in the text field below \"Unit price\""
		WebUI.verifyEqual(contentAlertActual, expectedResult)
		return this
	}
}
