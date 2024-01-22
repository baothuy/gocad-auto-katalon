import gocad.common.LeftNavBar
import gocad.common.SignInPage
import internal.GlobalVariable
import katalon.fw.lib.Page

'0. Verify UI Visible'
Page.nav(SignInPage).openBrowser().changeLanguage().verifyUIVisible()

'1. User buyer signs in as a buyer page'
Page.nav(SignInPage).enterCredentialAsBuyer().clickSignIn().verifySuccessfullySignInAsBuyer()

'2. User buyer logout'
Page.nav(LeftNavBar).clickLogout()

'3. User seller signs in as a seller page'
Page.nav(SignInPage).enterCredentialAsSeller().clickSignIn().verifySuccessfullySignInAsSeller()

'4. User seller logout'
Page.nav(LeftNavBar).clickLogout()

'5. User buyer signs in to administration page with uppercases'
Page.nav(SignInPage).openBrowser().inputEmail(email).inputPassword(password).clickSignIn().verifySuccessfullySignInAsSeller()