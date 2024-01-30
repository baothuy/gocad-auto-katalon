package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage




public class CustomerOverviewPage extends BasePage<CustomerOverviewPage>{

	def rowOfCustomerId = { String customerId -> return xpath("//td[text()='$customerId']/parent::tr")}
	def customerIdCol = { String customerId -> return xpath("//td[text()='$customerId']/parent::tr/td[1]")}
	def fullNameCol = { String customerId -> return xpath("//td[text()='$customerId']/parent::tr/td[2]")}
	def emailCol = { String customerId -> return xpath("//td[text()='$customerId']/parent::tr/td[3]")}
	def companyCol = { String customerId -> return xpath("//td[text()='$customerId']/parent::tr/td[4]")}
	def partNumberCol = { String customerId -> return xpath("//td[text()='$customerId']/parent::tr/td[5]")}
	def orderTotalCol = { String customerId -> return xpath("//td[text()='$customerId']/parent::tr/td[6]")}
	def calculationCol = { String customerId -> return xpath("//td[text()='$customerId']/parent::tr/td[7]")}
	def discountCol = { String customerId -> return xpath("//td[text()='$customerId']/parent::tr/td[8]")}
	def registrationDateCol = { String customerId -> return xpath("//td[text()='$customerId']/parent::tr/td[9]")}
	def loginEnabledCol = { String customerId -> return xpath("//td[text()='$customerId']/parent::tr/td[10]/span")}
	def actionCol = { String customerId -> return xpath("//td[text()='$customerId']/parent::tr/td[11]/a")}
	def row = { String row -> return "//*[@class='ant-table-tbody']/tr[$row]/"}
	def rowEmail = { String email -> return "//td[text()='$email']/parent::tr/"}

	public CustomerOverviewPage clickAction(String customerId) {
		WebUI.click(actionCol(customerId))
		return this
	}

	public List<String> getDataRow(String rowNumber) {
		String id = WebUI.getText(xpath(row(rowNumber) + "td[1]"))
		String fullName = WebUI.getText(xpath(row(rowNumber) + "td[2]"))
		String email = WebUI.getText(xpath(row(rowNumber) + "td[3]"))
		String company = WebUI.getText(xpath(row(rowNumber) + "td[4]"))
		String partNumber = WebUI.getText(xpath(row(rowNumber) + "td[5]"))
		String orderTotal = WebUI.getText(xpath(row(rowNumber) + "td[6]"))
		String calculation = WebUI.getText(xpath(row(rowNumber) + "td[7]"))
		String discount = WebUI.getText(xpath(row(rowNumber) + "td[8]"))
		String registrationDate = WebUI.getText(xpath(row(rowNumber) + "td[9]"))
		String loginEnable = WebUI.getText(xpath(row(rowNumber) + "td[10]/span"))
		List<String> dataRow = [id, fullName, email, company, partNumber, orderTotal, calculation, discount, registrationDate, loginEnable]
		return dataRow
	}
	
	public List<String> getDataRowByEmail(String email) {
		String id = WebUI.getText(xpath(rowEmail(email) + "td[1]"))
		String fullName = WebUI.getText(xpath(rowEmail(email) + "td[2]"))
		String company = WebUI.getText(xpath(rowEmail(email) + "td[4]"))
		String partNumber = WebUI.getText(xpath(rowEmail(email) + "td[5]"))
		String orderTotal = WebUI.getText(xpath(rowEmail(email) + "td[6]"))
		String calculation = WebUI.getText(xpath(rowEmail(email) + "td[7]"))
		String discount = WebUI.getText(xpath(rowEmail(email) + "td[8]"))
		String registrationDate = WebUI.getText(xpath(rowEmail(email) + "td[9]"))
		String loginEnable = WebUI.getText(xpath(rowEmail(email) + "td[10]/span"))
		List<String> dataRow = [id, fullName, company, partNumber, orderTotal, calculation, discount, registrationDate, loginEnable]
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
