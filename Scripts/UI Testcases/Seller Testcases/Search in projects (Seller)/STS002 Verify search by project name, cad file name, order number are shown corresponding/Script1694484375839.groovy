import gocad.buyer.DraftPage
import gocad.seller.SearchInProjectsPopup
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.seller.OpenInquiriesPage
import katalon.fw.lib.Page
import katalon.utility.DateTimeUtility

println '>> User seller signs in page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> Click Open inquiries menu to find project in list'
Page.nav(LeftNavBar).clickOpenInquiries()
List<String> dataRow = Page.nav(OpenInquiriesPage).getDataRow("1")
println "dataRow: $dataRow"

println '>> Click Search In Projects button'
Page.nav(LeftNavBar).clickSearchInProjects()

println '>> Verify search by project name added at previous step'
String projectId = dataRow[0]
String projectName = dataRow[1]
String statusRow = dataRow[6]
Page.nav(SearchInProjectsPopup).inputSearchTextField(projectName)
								.clickSearch()
								.verifyProjectNameVisibleInList(projectId, projectName)
								.clearSearchText()

println '>> Verify search by file name added at previous step'
Page.nav(SearchInProjectsPopup).inputSearchTextField(partName)
								.clickSearch()
								.verifyHaveRowVisibleInList("1")
								.clearSearchText()
								
println '>> Verify search by status'
Page.nav(SearchInProjectsPopup).selectStatus(statusRow)
								.clickSearch()
								.verifyStatusVisibleInList(projectId, statusRow)
								.clearSearchStatus()
								
println '>> Verify search by another status'
Page.nav(SearchInProjectsPopup).selectStatus(status)
								.clickSearch()

List<String> dataRowSearchByStatus = Page.nav(SearchInProjectsPopup).getDataRow("1")	
println "dataRowSearchByStatus: $dataRowSearchByStatus"											
Page.nav(SearchInProjectsPopup).verifyStatusVisibleInList(dataRowSearchByStatus[0], dataRowSearchByStatus[6])
								.clearSearchStatus()
								
println '>> Verify search by Mark as Unread'
Page.nav(SearchInProjectsPopup).clickCheckBoxUnread("checked")
								.clickSearch()
								
List<String> dataRowSearchByCheckUnread = Page.nav(SearchInProjectsPopup).getDataRow("1")
println "dataRowSearchByCheckUnread: $dataRowSearchByCheckUnread"
Page.nav(SearchInProjectsPopup).verifyHighlightOnList(dataRowSearchByCheckUnread[0])
								.clickCheckBoxUnread("uncheck")
								
								
String startDate = DateTimeUtility.plusDays(-1, "yyyy-MM-dd")
String endDate = DateTimeUtility.next30Days("yyyy-MM-dd")	
println "previousDate: $startDate"
println "endDate: $endDate"	

println '>> Verify search by order date'
Page.nav(SearchInProjectsPopup).inputStartDate(startDate)
								.inputEndDate(endDate)
								.clickSearch()
								
List<String> dataRowSearchByDate = Page.nav(SearchInProjectsPopup).getDataRow("1")
println "dataRowSearchByDate: $dataRowSearchByDate"

Page.nav(SearchInProjectsPopup).verifyHaveRowVisibleInList("1")
								.clearSearchDate()