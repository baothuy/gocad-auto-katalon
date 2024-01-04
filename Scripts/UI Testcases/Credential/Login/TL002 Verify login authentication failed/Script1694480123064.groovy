import gocad.common.LeftNavBar
import gocad.common.SignInPage
import internal.GlobalVariable
import katalon.fw.lib.Page


println '>> Login with wrong email or password'
Page.nav(SignInPage).openBrowser()
						.changeLanguage()
						.inputEmail(email)
						.inputPassword(password)
						.clickSignIn()

switch(inputExpected)	
{
	case "errorSystem":
		println '>> Verify when input error email or password'
		Page.nav(SignInPage).verifyAfterInputWrongAccount()
		break;
	case "errorUI":
		println '>> Verify when input error email or password'
		Page.nav(SignInPage).verifyShowErrorWhenInputField()
		break;
}											

