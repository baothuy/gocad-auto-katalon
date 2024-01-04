import gocad.buyer.ArchivedProjectsPage
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import katalon.fw.lib.Page

println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> Click search data project added at previous step'
Page.nav(LeftNavBar).clickArchivedProjects()

println '>> Click search data project added at previous step'
Page.nav(ArchivedProjectsPage).verifyUIVisible()