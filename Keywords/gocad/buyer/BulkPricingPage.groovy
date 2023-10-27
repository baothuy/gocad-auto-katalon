package gocad.buyer

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage




public class BulkPricingPage extends BasePage<BulkPricingPage>{
	
	public BulkPricingPage clickSaveChanges() {
		WebUI.click(xpath("//span[text()='Save Changes']/parent::button"))
		return this
	}
	
	public BulkPricingPage inputQuantityRefOne(String input){
		clearTextAndSendKeysByActions(id("basic_quantityRef1"), input)
		return this
	}
	
	public BulkPricingPage inputQuantityRefTwo(String input){
		clearTextAndSendKeysByActions(id("basic_quantityRef2"), input)
		return this
	}
	
	public BulkPricingPage inputQuantityRefThree(String input){
		clearTextAndSendKeysByActions(id("basic_quantityRef3"), input)
		return this
	}
	
	public BulkPricingPage verifyQuantityRefOneVisible(){
		WebUI.verifyElementVisible(id("basic_quantityRef1"))
		return this
	}
	
	public BulkPricingPage verifyQuantityRefTwoVisible(){
		WebUI.verifyElementVisible(id("basic_quantityRef2"))
		return this
	}
	
	public BulkPricingPage verifyQuantityRefThreeVisible(){
		WebUI.verifyElementVisible(id("basic_quantityRef3"))
		return this
	}
	
	public BulkPricingPage verifySaveChangesButtonVisible() {
		WebUI.verifyElementVisible(xpath("//span[text()='Save Changes']/parent::button"))
		return this
	}
	
	public BulkPricingPage verifyShowErrorBelowQuantityRefOne(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_quantityRef1_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public BulkPricingPage verifyShowErrorBelowQuantityRefTwo(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_quantityRef2_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
	
	public BulkPricingPage verifyShowErrorBelowQuantityRefThree(String expectedResult) {
		String actualResult = WebUI.getText(xpath("//*[@id='basic_quantityRef3_help']/div"))
		WebUI.verifyEqual(actualResult, expectedResult)
		return this
	}
}
