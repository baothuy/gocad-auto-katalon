import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.seller.MyProjectsPage
import katalon.fw.lib.Page



println '>> User seller signs in page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> Click search data project added at previous step'
Page.nav(LeftNavBar).clickMyProjects()

println '>> Get data first row to go detail verify UI'
List<String> dataRow = Page.nav(MyProjectsPage).getDataRow("1")
String projectId = dataRow[0]

println '>> Verify UI Requested Offers page'
Page.nav(MyProjectsPage).verifyUIVisible()
						.verifyStatus(projectId, "Draft")
						.verifyViewActionVisible(projectId)
						.verifyMoreActionVisible(projectId)
						.verifyArchiveActionVisible(projectId)