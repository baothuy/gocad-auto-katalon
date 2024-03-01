package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys
import katalon.fw.lib.BasePage


public class SearchJobs extends BasePage<SearchJobs>{
	
	public SearchJobs inputEmail(String email) {
		clearTextAndSendKeysByActions(id("email"), email)
		return this
	}
	
	//yyyy-MM-dd
	public SearchJobs inputStartDate(String date) {
		WebUI.sendKeys(xpath("//input[@placeholder='Start date']"), date + Keys.RETURN)
		return this
	}

	public SearchJobs inputEndDate(String date) {
		WebUI.sendKeys(xpath("//input[@placeholder='End date']"), date + Keys.RETURN)
		return this
	}
	
	public SearchJobs selectSortBy(String value) {
		WebUI.click(xpath("//label[@for='sortProperty']/parent::div/following::div[@class='ant-select-selector']"))
		WebUI.click(xpath("//*[@id='sortProperty_list']/following-sibling::div[@class='rc-virtual-list']//div[text()='$value']"))
		return this
	}
}
