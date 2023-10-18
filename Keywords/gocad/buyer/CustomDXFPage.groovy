package gocad.buyer

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import gocad.seller.PaymentDetailsSettingsPage
import gocad.seller.PriceAndDeliverySettingsBasicPage
import katalon.fw.lib.BasePage





public class CustomDXFPage extends BasePage<CustomDXFPage>{

	public String sumValue(List<String> values) {
		double sum = 0
		values.each { value -> sum += value.toDouble() }
		String total = sum.toString()
		return total
	}

	public CustomDXFPage clickNextStepButton() {
		WebUI.click(xpath("//*[text()='Next step']/parent::button"))
		return this
	}

	public CustomDXFPage inputFileName(String input) {
		clearTextAndSendKeysByActions(id("fileName"), input)
		return this
	}

	//round

	public CustomDXFPage inputExternalDiameter(String input) {
		clearTextAndSendKeysByActions(id("externalDiameter"), input)
		return this
	}

	public CustomDXFPage inputInsideDiameter(String input) {
		clearTextAndSendKeysByActions(id("insideDiameter"), input)
		return this
	}

	public CustomDXFPage inputNumberOfHoles(String input) {
		clearTextAndSendKeysByActions(id("numberOfHoles"), input)
		return this
	}

	public CustomDXFPage inputDiameterBoltCircle(String input) {
		clearTextAndSendKeysByActions(id("diameterBoltCircle"), input)
		return this
	}

	public CustomDXFPage inputDiameterHoles(String input) {
		clearTextAndSendKeysByActions(id("diameterHoles"), input)
		return this
	}

	//Rectangle gasket

	public CustomDXFPage inputOuterWidth(String input) {
		clearTextAndSendKeysByActions(id("outerWidth"), input)
		return this
	}

	public CustomDXFPage inputOuterHeight(String input) {
		clearTextAndSendKeysByActions(id("outerHeight"), input)
		return this
	}

	public CustomDXFPage inputInnerWidth(String input) {
		clearTextAndSendKeysByActions(id("innerWidth"), input)
		return this
	}

	public CustomDXFPage inputInnerHeight(String input) {
		clearTextAndSendKeysByActions(id("innerHeight"), input)
		return this
	}

	public CustomDXFPage inputOuterRadius(String input) {
		clearTextAndSendKeysByActions(id("outerRadius"), input)
		return this
	}

	public CustomDXFPage inputInnerRadius(String input) {
		clearTextAndSendKeysByActions(id("innerRadius"), input)
		return this
	}

	//Oval gasket

	public CustomDXFPage inputWebThickness(String input) {
		clearTextAndSendKeysByActions(id("webThickness"), input)
		return this
	}

	//Elongated/round gasket (all existed)
	//Rectangle panel

	public CustomDXFPage inputWidth(String input) {
		clearTextAndSendKeysByActions(id("width"), input)
		return this
	}

	public CustomDXFPage inputHeight(String input) {
		clearTextAndSendKeysByActions(id("height"), input)
		return this
	}

	//Rectangle rounded panel

	public CustomDXFPage inputRadius(String input) {
		clearTextAndSendKeysByActions(id("radius"), input)
		return this
	}

	//Rectangle rounded top panel (all existed)
	//Circle panel

	public CustomDXFPage inputDiameter(String input) {
		clearTextAndSendKeysByActions(id("diameter"), input)
		return this
	}

	//Ellipse panel (all existed)
	//Half Circle panel (all existed)
	//Octagon

	public CustomDXFPage inputCornerLength(String input) {
		clearTextAndSendKeysByActions(id("cornerLength"), input)
		return this
	}

	//Trapez

	public CustomDXFPage inputShorterEdgeLength(String input) {
		clearTextAndSendKeysByActions(id("shorterEdgeLength"), input)
		return this
	}

	//Isosceles trapezoid

	public CustomDXFPage inputTopWidth(String input) {
		clearTextAndSendKeysByActions(id("topWidth"), input)
		return this
	}

	public CustomDXFPage inputBottomWidth(String input) {
		clearTextAndSendKeysByActions(id("bottomWidth"), input)
		return this
	}

	//Visible

	public CustomDXFPage verifyInputFileNameVisible() {
		WebUI.verifyElementVisible(id("fileName"))
		return this
	}

	//round

	public CustomDXFPage verifyInputExternalDiameterVisible() {
		WebUI.verifyElementVisible(id("externalDiameter"))
		return this
	}

	public CustomDXFPage verifyInputInsideDiameterVisible() {
		WebUI.verifyElementVisible(id("insideDiameter"))
		return this
	}

	public CustomDXFPage verifyInputNumberOfHolesVisible() {
		WebUI.verifyElementVisible(id("numberOfHoles"))
		return this
	}

	public CustomDXFPage verifyInputDiameterBoltCircleVisible() {
		WebUI.verifyElementVisible(id("diameterBoltCircle"))
		return this
	}

	public CustomDXFPage verifyInputDiameterHolesVisible() {
		WebUI.verifyElementVisible(id("diameterHoles"))
		return this
	}

	//Rectangle gasket

	public CustomDXFPage verifyInputOuterWidthVisible() {
		WebUI.verifyElementVisible(id("outerWidth"))
		return this
	}

	public CustomDXFPage verifyInputOuterHeightVisible() {
		WebUI.verifyElementVisible(id("outerHeight"))
		return this
	}

	public CustomDXFPage verifyInputInnerWidthVisible() {
		WebUI.verifyElementVisible(id("innerWidth"))
		return this
	}

	public CustomDXFPage verifyInputInnerHeightVisible() {
		WebUI.verifyElementVisible(id("innerHeight"))
		return this
	}

	public CustomDXFPage verifyInputOuterRadiusVisible() {
		WebUI.verifyElementVisible(id("outerRadius"))
		return this
	}

	public CustomDXFPage verifyInputInnerRadiusVisible() {
		WebUI.verifyElementVisible(id("innerRadius"))
		return this
	}

	//Oval gasket

	public CustomDXFPage verifyInputWebThicknessVisible() {
		WebUI.verifyElementVisible(id("webThickness"))
		return this
	}

	//Elongated/round gasket (all existed)
	//Rectangle panel

	public CustomDXFPage verifyInputWidthVisible() {
		WebUI.verifyElementVisible(id("width"))
		return this
	}

	public CustomDXFPage verifyInputHeightVisible() {
		WebUI.verifyElementVisible(id("height"))
		return this
	}

	//Rectangle rounded panel

	public CustomDXFPage verifyInputRadiusVisible() {
		WebUI.verifyElementVisible(id("radius"))
		return this
	}

	//Rectangle rounded top panel (all existed)
	//Circle panel

	public CustomDXFPage verifyInputDiameterVisible() {
		WebUI.verifyElementVisible(id("diameter"))
		return this
	}

	//Ellipse panel (all existed)
	//Half Circle panel (all existed)
	//Octagon

	public CustomDXFPage verifyInputCornerLengthVisible() {
		WebUI.verifyElementVisible(id("cornerLength"))
		return this
	}

	//Trapez

	public CustomDXFPage verifyInputShorterEdgeLengthVisible() {
		WebUI.verifyElementVisible(id("shorterEdgeLength"))
		return this
	}

	//Isosceles trapezoid

	public CustomDXFPage verifyInputTopWidthVisible() {
		WebUI.verifyElementVisible(id("topWidth"))
		return this
	}

	public CustomDXFPage verifyInputBottomWidthVisible() {
		WebUI.verifyElementVisible(id("bottomWidth"))
		return this
	}

	//Error

	public CustomDXFPage verifyErrorWhenInputFileName(String expectedResult) {
		String actualResult = WebUI.getText(id("fileName_help"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	//round

	public CustomDXFPage verifyErrorWhenInputExternalDiameter(String expectedResult) {
		String actualResult = WebUI.getText(id("externalDiameter_help"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CustomDXFPage verifyErrorWhenInputInsideDiameter(String expectedResult) {
		String actualResult = WebUI.getText(id("insideDiameter_help"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CustomDXFPage verifyErrorWhenInputNumberOfHoles(String expectedResult) {
		String actualResult = WebUI.getText(id("numberOfHoles_help"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CustomDXFPage verifyErrorWhenInputDiameterBoltCircle(String expectedResult) {
		String actualResult = WebUI.getText(id("diameterBoltCircle_help"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CustomDXFPage verifyErrorWhenInputDiameterHoles(String expectedResult) {
		String actualResult = WebUI.getText(id("diameterHoles_help"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	//Rectangle gasket

	public CustomDXFPage verifyErrorWhenInputOuterWidth(String expectedResult) {
		String actualResult = WebUI.getText(id("outerWidth_help"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CustomDXFPage verifyErrorWhenInputOuterHeight(String expectedResult) {
		String actualResult = WebUI.getText(id("outerHeight_help"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CustomDXFPage verifyErrorWhenInputInnerWidth(String expectedResult) {
		String actualResult = WebUI.getText(id("innerWidth_help"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CustomDXFPage verifyErrorWhenInputInnerHeight(String expectedResult) {
		String actualResult = WebUI.getText(id("innerHeight_help"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CustomDXFPage verifyErrorWhenInputOuterRadius(String expectedResult) {
		String actualResult = WebUI.getText(id("outerRadius_help"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CustomDXFPage verifyErrorWhenInputInnerRadius(String expectedResult) {
		String actualResult = WebUI.getText(id("innerRadius_help"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	//Oval gasket

	public CustomDXFPage verifyErrorWhenInputWebThickness(String expectedResult) {
		String actualResult = WebUI.getText(id("webThickness_help"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	//Elongated/round gasket (all existed)
	//Rectangle panel

	public CustomDXFPage verifyErrorWhenInputWidth(String expectedResult) {
		String actualResult = WebUI.getText(id("width_help"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CustomDXFPage verifyErrorWhenInputHeight(String expectedResult) {
		String actualResult = WebUI.getText(id("height_help"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	//Rectangle rounded panel

	public CustomDXFPage verifyErrorWhenInputRadius(String expectedResult) {
		String actualResult = WebUI.getText(id("radius_help"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	//Rectangle rounded top panel (all existed)
	//Circle panel

	public CustomDXFPage verifyErrorWhenInputDiameter(String expectedResult) {
		String actualResult = WebUI.getText(id("diameter_help"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	//Ellipse panel (all existed)
	//Half Circle panel (all existed)
	//Octagon

	public CustomDXFPage verifyErrorWhenInputCornerLength(String expectedResult) {
		String actualResult = WebUI.getText(id("cornerLength_help"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	//Trapez

	public CustomDXFPage verifyErrorWhenInputShorterEdgeLength(String expectedResult) {
		String actualResult = WebUI.getText(id("shorterEdgeLength_help"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	//Isosceles trapezoid

	public CustomDXFPage verifyErrorWhenInputTopWidth(String expectedResult) {
		String actualResult = WebUI.getText(id("topWidth_help"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CustomDXFPage verifyErrorWhenInputBottomWidth(String expectedResult) {
		String actualResult = WebUI.getText(id("bottomWidth_help"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
}
