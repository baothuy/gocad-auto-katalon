package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage




public class OpenJobsPage extends BasePage<OpenJobsPage>{

	public OpenJobsPage clickSelectJobs(String partName) {
		WebUI.click(xpath("(//span[text()='$partName']/preceding-sibling::span)[1]"))
		return this
	}

	public OpenJobsPage clickAssign() {
		WebUI.click(xpath("//span[text()='Assign']/parent::button"))
		return this
	}
}
