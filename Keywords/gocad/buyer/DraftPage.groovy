package gocad.buyer

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import katalon.fw.lib.BasePage
import internal.GlobalVariable

public class DraftPage extends BasePage<DraftPage>{

	def projectRow = { String projectName -> return "//a[text()='$projectName']/ancestor::tr/td[2]"}
	def Action = { String projectName -> return xpath("//a[text()='$projectName']/ancestor::tr/td[7]/a")}

	public DraftPage clickAction(String projectName) {
		WebUI.click(Action(projectName))
		return this
	}
	
	public DraftPage clickPaging(String paging) {
		WebUI.click(xpath("//input[@id='rc_select_21']/ancestor::div[@class='ant-select-selector']"))
		WebUI.click(xpath("//div[contains(@class, 'ant-select-item') and @title='$paging']"))
		return this
	}
}
