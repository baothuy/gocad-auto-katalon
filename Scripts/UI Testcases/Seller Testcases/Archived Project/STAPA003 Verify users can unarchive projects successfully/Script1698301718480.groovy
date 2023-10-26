import gocad.seller.ArchivedProjectsPage
import gocad.common.ConfirmPopup
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import katalon.fw.lib.Page

println '>> User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> Click search data project added at previous step'
Page.nav(LeftNavBar).clickArchivedProjects()

println '>> get first data row to delete'
List<String> dataRow = Page.nav(ArchivedProjectsPage).getDataRow("1")

println '>> click unarchive projects'
Page.nav(ArchivedProjectsPage).clickUnarchiveAction(dataRow[0])						

println '>> Verify message after unarchive projects'
Page.nav(ArchivedProjectsPage).verifyToastMessageWhenUnarchivedProject(dataRow[1])