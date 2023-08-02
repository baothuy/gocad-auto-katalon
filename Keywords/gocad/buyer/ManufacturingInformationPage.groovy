package gocad.buyer

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import katalon.fw.lib.BasePage
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class ManufacturingInformationPage extends BasePage<ManufacturingInformationPage> {

	public ManufacturingInformationPage clickAddPart() {
		WebUI.click(xpath('//span[text()=" Add part"]'))
		return this
	}

	public ManufacturingInformationPage clickImagePart() {
		WebUI.click(xpath('//img[@class="ant-image-img"]'))
		return this
	}

	public ManufacturingInformationPage clickDownloadImage() {
		WebUI.click(xpath('//a[@class="text-decoration-none"]'))
		return this
	}

	public ManufacturingInformationPage clickDeletePart() {
		WebUI.click(xpath('//span[text()="Delete"]'))
		return this
	}

	public ManufacturingInformationPage clickCopyPart() {
		WebUI.click(xpath('//span[text()=" Copy"]'))
		return this
	}

	public ManufacturingInformationPage clickMoreOption() {
		WebUI.click(xpath('//span[@role="img" and @aria-label="more"]'))
		return this
	}

	public ManufacturingInformationPage clickMovePart() {
		WebUI.click(xpath('//span[text()="Move"]'))
		return this
	}

	public ManufacturingInformationPage clickPleaseSelectMaterial() {
		WebUI.click(xpath('//*[@id="materialId"]/a'))
		return this
	}

	public ManufacturingInformationPage clickProvideOwnMaterialCB() {
		WebUI.click(xpath('//span[text()="Provide own material (From customer)"]'))
		return this
	}

	public ManufacturingInformationPage inputQuantity(String number) {
		clearTextAndSendKeysByActions(xpath('//*[@id="quantity"]'), number)
		return this
	}

	public ManufacturingInformationPage selectSurfaceTreatment(String surfaceTreatment) {
		WebUI.click(xpath("//div[contains(@class, 'ant-select-in-form-item')]"))
		WebUI.click(xpath("//div[contains(@class, 'ant-select-item ant-select-item-option') and @title='$surfaceTreatment']"))
		WebUI.click(xpath("//div[contains(@class, 'ant-select-in-form-item')]"))
		return this
	}

	public ManufacturingInformationPage inputComment(String text) {
		WebUI.sendKeys(xpath('//*[@id="additionalComments"]'), text)
		return this
	}

	public ManufacturingInformationPage clickCalculate() {
		WebUI.click(xpath('//span[text()="Calculate"]/parent::button'))
		return this
	}

	public ManufacturingInformationPage clickAddTechnicalDrawing() {
		WebUI.click(xpath('//button[@title="Add technical drawing"]'))
		return this
	}

	public ManufacturingInformationPage clickContinueToOfferOverview() {
		WebUI.click(xpath('//span[text()="Continue to offer overview "]'))
		return this
	}

	public ManufacturingInformationPage clickEdit() {
		WebUI.click(xpath('//span[text()="Edit"]'))
		return this
	}

	public ManufacturingInformationPage clickCancel() {
		WebUI.click(xpath('//span[text()="Cancel"]'))
		return this
	}
	//Data upload > Milled / Turned Parts
	public ManufacturingInformationPage inputThread(String number) {
		clearTextAndSendKeysByActions(xpath('//*[@id="numberOfThreads"]'), number)
		return this
	}

	public ManufacturingInformationPage inputTolerances(String number) {
		clearTextAndSendKeysByActions(xpath('//*[@id="numberOfFits"]'), number)
		return this
	}

	public ManufacturingInformationPage clickToggleTolerances(String value) {
		String isChecked = WebUI.getAttribute(xpath("//*[@id='hasTolerances']"), "aria-checked")
		boolean isYes = value.equals("Yes")
		println "isYes: $isYes & isChecked: $isChecked"
		if(Boolean.parseBoolean(isChecked) != isYes) {
			println "touched"
			WebUI.click(xpath("//*[@id='hasTolerances']"))
		}
		return this
	}

	public ManufacturingInformationPage selectSurfaceQuality(String quality) {
		WebUI.click(xpath("//*[text()='Surface Quality']/parent::div/following::div[@class='ant-select-selector']"))
		//WebUI.click(xpath("//*[text()='Surface Quality']/parent::div/following::div[@class='ant-form-item-control-input']"))
		WebUI.click(xpath("//*[@class='rc-virtual-list']//div[@title='$quality']"))
		return this
	}
	
	public ManufacturingInformationPage verifyMaterial(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Material']/following-sibling::div")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public ManufacturingInformationPage verifyQuantity(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Quantity']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public ManufacturingInformationPage verifyThread(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Thread (Quantity)']/following-sibling::div")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public ManufacturingInformationPage verifyTolerancesNumber(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Tolerances and fits with less than 1/10mm or IT 1 - IT 10 (Number)']/following-sibling::div")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public ManufacturingInformationPage verifyTolerancesToggle(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Tolerance requirement with smaller 1/100mm or IT 1 - IT 5']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public ManufacturingInformationPage verifySurfaceTreatment(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Surface Treatment']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public ManufacturingInformationPage verifySurfaceQuality(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Surface Quality']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public ManufacturingInformationPage verifyAdditionalComments(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[text()='Additional Comments']/following-sibling::label")).trim()
		println "actualResult: $actualResult"
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
}
