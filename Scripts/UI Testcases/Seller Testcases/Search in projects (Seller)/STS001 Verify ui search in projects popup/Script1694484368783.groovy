import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.seller.SearchInProjectsPopup
import katalon.fw.lib.Page

println '>> User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> Click search data project added at previous step'
Page.nav(LeftNavBar).clickSearchInProjects()

println '>> Click search data project added at previous step'
Page.nav(SearchInProjectsPopup).verifyUIVisible()