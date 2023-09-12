import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import internal.GlobalVariable
import katalon.fw.lib.Page

'0. Verify UI Visible'
Page.nav(MySignInPage).openBrowser().changeLanguage().verifyUIVisible()

'1. User buyer signs in as a buyer page'
Page.nav(MySignInPage).enterCredentialAsBuyer().clickSignIn().verifySuccessfullySignInAsBuyer()

'2. User buyer logout'
Page.nav(LeftNavBar).clickLogout()

'3. User seller signs in as a seller page'
Page.nav(MySignInPage).enterCredentialAsSeller().clickSignIn().verifySuccessfullySignInAsSeller()

'4. User seller logout'
Page.nav(LeftNavBar).clickLogout()

'5. User buyer signs in to administration page with uppercases'
Page.nav(MySignInPage).openBrowser().inputEmail(email).inputPassword(password).clickSignIn().verifySuccessfullySignInAsBuyer()