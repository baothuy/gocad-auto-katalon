package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage




public class CustomerOverviewPage extends BasePage<CustomerOverviewPage>{

	def rowOfCustomerId = { String customerId -> return xpath("//td[text()='$customerId']/parent::tr")}
	def customerIdCol = { String customerId -> return xpath("//td[text()='$customerId']/parent::tr/td[1]")}
	def fullNameCol = { String customerId -> return xpath("//td[text()='$customerId']/parent::tr/td[2]")}
	def partNumberCol = { String customerId -> return xpath("//td[text()='$customerId']/parent::tr/td[3]")}
	def orderTotalCol = { String customerId -> return xpath("//td[text()='$customerId']/parent::tr/td[4]")}
	def calculationCol = { String customerId -> return xpath("//td[text()='$customerId']/parent::tr/td[5]")}
	def discountCol = { String customerId -> return xpath("//td[text()='$customerId']/parent::tr/td[6]")}
	def registrationDateCol = { String customerId -> return xpath("//td[text()='$customerId']/parent::tr/td[7]")}
	def actionCol = { String customerId -> return xpath("//td[text()='$customerId']/parent::tr/td[8]/a")}
	def row = { String row -> return "//*[@class='ant-table-tbody']/tr[$row]/"}

	public CustomerOverviewPage clickAction(String customerId) {
		WebUI.click(actionCol(customerId))
		return this
	}

	public List<String> getDataRow(String rowNumber) {
		String id = WebUI.getText(xpath(row(rowNumber) + "td[1]"))
		String fullName = WebUI.getText(xpath(row(rowNumber) + "td[2]"))
		String partNumber = WebUI.getText(xpath(row(rowNumber) + "td[3]"))
		String orderTotal = WebUI.getText(xpath(row(rowNumber) + "td[4]"))
		String calculation = WebUI.getText(xpath(row(rowNumber) + "td[5]"))
		String discount = WebUI.getText(xpath(row(rowNumber) + "td[6]"))
		String registrationDate = WebUI.getText(xpath(row(rowNumber) + "td[7]"))
		List<String> dataRow = [id, fullName, partNumber, orderTotal, calculation, discount, registrationDate]
		return dataRow
	}

	public CustomerOverviewPage verifyUIVisible() {
		WebUI.verifyElementVisible(xpath("//h3[text()='Customers']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Id']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Full Name']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Parts (Number)']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Order (Total)']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Calculations (Number)']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Discount']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[@aria-label='Registration Date']"))
		WebUI.verifyElementVisible(xpath("//thead[@class='ant-table-thead']/tr/th[text()='Action']"))
		WebUI.verifyElementVisible(xpath("//ul[contains(@class,'ant-table-pagination')]"))
		return this
	}
}
