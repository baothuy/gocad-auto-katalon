import gocad.seller.ArchivedProjectsPage
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import katalon.fw.lib.Page

println '>> User seller signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> Click search data project added at previous step'
Page.nav(LeftNavBar).clickArchivedProjects()

println '>> Click search data project added at previous step'
Page.nav(ArchivedProjectsPage).verifyUIVisible()