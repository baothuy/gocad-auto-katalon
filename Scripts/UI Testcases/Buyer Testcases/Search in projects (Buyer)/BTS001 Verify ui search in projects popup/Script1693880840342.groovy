import gocad.buyer.DraftPage
import gocad.buyer.SearchInProjectsPopup
import gocad.common.AddProjectPopup
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility

println '>> User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> Click search data project added at previous step'
Page.nav(LeftNavBar).clickSearchInProjects()

println '>> Click search data project added at previous step'
Page.nav(SearchInProjectsPopup).verifyUIVisible()