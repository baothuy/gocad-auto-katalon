import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.seller.SearchInProjectsPopup
import katalon.fw.lib.Page

println '>> User seller signs in to administration page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> Click search data project added at previous step'
Page.nav(LeftNavBar).clickSearchInProjects()

println '>> Click search data project added at previous step'
Page.nav(SearchInProjectsPopup).verifyUIVisible()