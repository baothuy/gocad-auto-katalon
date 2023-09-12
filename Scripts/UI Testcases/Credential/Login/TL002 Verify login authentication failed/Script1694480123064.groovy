import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import internal.GlobalVariable
import katalon.fw.lib.Page


println '>> Login with wrong email or password'
Page.nav(MySignInPage).openBrowser()
						.changeLanguage()
						.inputEmail(email)
						.inputPassword(password)
						.clickSignIn()

switch(inputExpected)	
{
	case "errorSystem":
		println '>> Verify when input error email or password'
		Page.nav(MySignInPage).verifyAfterInputAccount()
		break;
	case "errorUI":
		println '>> Verify when input error email or password'
		Page.nav(MySignInPage).verifyShowErrorWhenInputField()
		break;
}											

