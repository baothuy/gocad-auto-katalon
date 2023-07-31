import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import gocad.common.MySignInPage
import gocad.buyer.LeftNavBar
import katalon.fw.lib.Page

'1. User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

'2. User buyer logout'
Page.nav(LeftNavBar).clickLogout()

'3. User seller signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsSeller().clickSignIn().verifySuccessfullySignInAsSeller()

'4. User seller logout'
Page.nav(LeftNavBar).clickLogout()

'5. User buyer signs in to administration page with wrong account or password'
Page.nav(MySignInPage).openBrowser().changeLanguage().inputEmail("account").inputPassword("password").clickSignIn().verifyAfterInputWrongAccount()