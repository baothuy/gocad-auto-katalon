package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage

public class JobsBoardPage extends BasePage<JobsBoardPage>{

	public JobsBoardPage clickUnassign(String partName) {
		WebUI.click(xpath("(//div[text()='$partName']/ancestor::div[@class='ant-space-item']//span[text()='Unassign']/parent::button)[1]"))
		return this
	}
}
