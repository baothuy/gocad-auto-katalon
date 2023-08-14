package gocad.buyer

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage




public class CompletedCheckoutPage extends BasePage<CompletedCheckoutPage>{

	public CompletedCheckoutPage clickBackToProject() {
		WebUI.click(xpath("//*[text()='Back to project']"))
		return this
	}

	public CompletedCheckoutPage verifyUICompletedPage() {
		WebUI.verifyElementVisible(xpath("//*[@data-icon='check-circle']"))
		WebUI.verifyElementVisible(text("Successfully checkout!"))
		WebUI.verifyElementVisible(xpath("//*[text()='Back to project']"))
		WebUI.verifyElementVisible(text('Your project has been transferred to the folder "Requested Orders".'))
		WebUI.verifyElementVisible(text('Your request will be checked by us. You will receive an order confirmation as soon as the project is approved by us.'))
		return this
	}
}
