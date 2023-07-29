import gocad.common.MySignInPage
import katalon.fw.lib.Page

'1. User signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()