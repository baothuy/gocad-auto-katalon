import gocad.common.MySignInPage
import katalon.fw.lib.Page

'2. User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()