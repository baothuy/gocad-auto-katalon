package gocad.seller

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import katalon.fw.lib.BasePage

public class CustomerOverviewDetailPage extends BasePage<ConfirmedOffersPageOfSeller>{

	def rowOfProject = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr")}
	def projectIdCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[1]")}
	def projectNameCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[2]")}
	def companyNameCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[3]")}
	def orderNumberCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[4]")}
	def orderDateCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[5]")}
	def netTotalCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[6]")}
	def statusCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[7]//span[normalize-space(text()) != '']")}
	def actionCol = { String projectId -> return xpath("//td[text()='$projectId']/parent::tr/td[8]/a")}
	def row = { String row -> return "//*[@class='ant-table-tbody']/tr[$row]/"}
	
	public CustomerOverviewDetailPage clickToggleAutomaticallyCalculation(String value) {
		String isChecked = WebUI.getAttribute(xpath("//*[@id='calculationEnabled']"), "aria-checked")
		boolean isYes = value.equals("Yes")
		if(Boolean.parseBoolean(isChecked) != isYes) {
			WebUI.click(xpath("//*[@id='calculationEnabled']"))
		}
		return this
	}
	
	public CustomerOverviewDetailPage inputDiscount(String input) {
		clearTextAndSendKeysByActions(id("discount"), input)
		return this
	}
	
	public CustomerOverviewDetailPage clickSaveButton() {
		WebUI.click(xpath("//span[text()='Save']/parent::button"))
		return this
	}

	public CustomerOverviewDetailPage verifyFullName(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//span[text()='Full Name']/following-sibling::span"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public CustomerOverviewDetailPage verifyEmail(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//span[text()='E-mail']/following-sibling::span"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public CustomerOverviewDetailPage verifyCompany(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//span[text()='Company']/following-sibling::span"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CustomerOverviewDetailPage verifyDiscount(String expectedResult) {
		String actualResult = WebUI.getAttribute(id("discount"), "value")
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CustomerOverviewDetailPage verifyPartNumber(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//div[@class='ant-space-item']//p[text()='Parts (Number)']/following-sibling::label"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CustomerOverviewDetailPage verifyOrderTotal(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//div[@class='ant-space-item']//p[text()='Order (Total)']/following-sibling::label"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CustomerOverviewDetailPage verifyCalculationsNumber(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//div[@class='ant-space-item']//p[text()='Calculations (Number)']/following-sibling::label"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}

	public CustomerOverviewDetailPage verifyUIVisible() {
		WebUI.verifyElementVisible(xpath("//h3[text()='Customer Detail']"))

		//contact
		WebUI.verifyElementVisible(xpath("//*[text()='Contact']"))
		WebUI.verifyElementVisible(xpath("//span[text()='Full Name']"))
		WebUI.verifyElementVisible(xpath("//span[text()='E-mail']"))
		WebUI.verifyElementVisible(xpath("//span[text()='Company']"))
		WebUI.verifyElementVisible(xpath("//span[text()='Phone']"))
		//Billing address
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Billing Address']/parent::div/div/p[text()='Contact person']"))
		//Shipping address
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Shipping Address']/parent::div/div/p[text()='Contact person']"))
		//Discount
		WebUI.verifyElementVisible(xpath("//*[text()='Discount']"))
		WebUI.verifyElementVisible(id("discount"))
		//Automatically Calculation
		WebUI.verifyElementVisible(xpath("//*[text()='Automatically Calculation']"))
		WebUI.verifyElementVisible(xpath("//*[text()='Save']/parent::button"))
		//Box
		WebUI.verifyElementVisible(xpath("//div[@class='ant-space-item']//p[text()='Parts (Number)']"))
		WebUI.verifyElementVisible(xpath("//div[@class='ant-space-item']//p[text()='Order (Total)']"))
		WebUI.verifyElementVisible(xpath("//div[@class='ant-space-item']//p[text()='Calculations (Number)']"))
		//header table visible
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Id']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Project Name']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Status']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[text()='Action']"))
		WebUI.verifyElementVisible(xpath("//ul[contains(@class,'ant-table-pagination')]"))
		return this
	}
}
