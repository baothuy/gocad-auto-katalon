package gocad.common

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage

public class AddProjectPopup extends BasePage<AddProjectPopup> {
	public AddProjectPopup inputProjectName(String projectname) {
		WebUI.sendKeys(id('basic_name'), projectname)
		return this
	}

	public AddProjectPopup clickOKButton() {
		WebUI.waitForElementPresent(xpath('//span[text()="OK"]'), 5)
		WebUI.click(xpath('//span[text()="OK"]'))
		return this
	}

	public AddProjectPopup clickCancelButton() {
		WebUI.click(xpath('//span[text()="Cancel"]'))
		return this
	}
}
