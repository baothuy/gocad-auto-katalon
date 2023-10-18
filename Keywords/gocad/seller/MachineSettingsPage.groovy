package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage




public class MachineSettingsPage extends BasePage<MachineSettingsPage>{
	
	public MachineSettingsPage clickMachineName (String machine) {
		scrollToAndClick(xpath("//span[@class='ant-collapse-header-text' and text()='$machine']/ancestor::div[@class='ant-collapse-item']"))
		return this
	}
	
	public MachineSettingsPage clickSaveChangesButton () {
		WebUI.click(xpath("//span[text()='Save Changes']"))
		return this
	}
}
