package gocad.seller

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage





public class MachineSettingsLeftNavMenu extends BasePage<MachineSettingsLeftNavMenu>{
	
	public MachineSettingsLeftNavMenu clickMillingAndTurningTab () {
		WebUI.click(xpath("//*[text()='Milling And Turning']/parent::button"))
		return this
	}
	
	public MachineSettingsLeftNavMenu clickSheetMetalTab () {
		WebUI.click(xpath("//*[text()='Sheet Metal']/parent::button"))
		return this
	}
}
