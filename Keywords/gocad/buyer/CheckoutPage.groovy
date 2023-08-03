package gocad.buyer

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import katalon.fw.lib.BasePage
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

public class CheckoutPage extends BasePage<CheckoutPage>{
	
	public CheckoutPage clickCheckboxAgreeTermsAndConditions() {
		WebUI.click(xpath('//*[@id="agreeTermConditions"]'))
		return this
	}
	
	public CheckoutPage clickPlaceYourOrder() {
		WebUI.click(xpath('//*[text()="Place your order"]'))
		return this
	}
}
