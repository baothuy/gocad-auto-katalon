import gocad.buyer.DraftPage
import gocad.buyer.SearchInProjectsPopup
import gocad.common.AddProjectPopup
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility
import katalon.utility.DateTimeUtility

println '>> User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> User buyer add project'
Page.nav(LeftNavBar).clickAddProject()

println '>> Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>> Open add project popup and input project name'
Page.nav(AddProjectPopup).inputProjectName("$projectName").clickOKButton()

String projectId = Page.nav(DataUploadPage).getIdProject()
println "projectId: $projectId"
//String orderNumber = "GOCAD"+ projectId

println '>> Upload file part on Data upload page'
Page.nav(DataUploadPage).uploadFileTesting(workflow, partName)

println '>> Click Search In Projects button'
Page.nav(LeftNavBar).clickDraft()
Page.nav(LeftNavBar).clickSearchInProjects()

println '>> Verify search by project name added at previous step'
Page.nav(SearchInProjectsPopup).inputSearchTextField(projectName)
								.clickSearch()
								.verifyProjectNameVisibleInList(projectId, projectName)
								.clearSearchText()

println '>> Verify search by file name added at previous step'
Page.nav(SearchInProjectsPopup).inputSearchTextField(partName)
								.clickSearch()
								.verifyFileNameVisibleInList(projectId, partName)
								.clearSearchText()
								
//println '>> Verify search by order number added at previous step'
//Page.nav(SearchInProjectsPopup).inputSearchTextField(orderNumber)
//								.clickSearch()
//								.verifyOrderNumberVisibleInList(projectId, orderNumber)
//								.clearSearchText()
								
println '>> Verify search by status'
Page.nav(SearchInProjectsPopup).selectStatus("Draft")
								.clickSearch()
								.verifyStatusVisibleInList(projectId, "Draft")
								.clearSearchStatus()
								
println '>> Verify search by another status'
Page.nav(SearchInProjectsPopup).selectStatus(status)
								.clickSearch()

List<String> dataRow = Page.nav(SearchInProjectsPopup).getDataRow("1")	
println "dataRow: $dataRow"											
Page.nav(SearchInProjectsPopup).verifyStatusVisibleInList(dataRow[0], dataRow[5])
								.clearSearchStatus()

String startDate = DateTimeUtility.plusDays(-1, "yyyy-MM-dd")
String currentDate = DateTimeUtility.currentDay("yyyy-MM-dd")	
println "previousDate: $startDate"
println "currentDate: $currentDate"				

println '>> Verify search by delivery date'
Page.nav(SearchInProjectsPopup).inputStartDate(startDate)
								.inputEndDate(currentDate)
								.clickSearch()
								
List<String> dataRowSearchByDate = Page.nav(SearchInProjectsPopup).getDataRow("1")
println "dataRowSearchByDate: $dataRowSearchByDate"

Page.nav(SearchInProjectsPopup).verifyDeliveryDateVisibleInList(dataRowSearchByDate[0], currentDate)
								.clearSearchDate()
								
println '>> Verify search by Mark as Unread'
Page.nav(SearchInProjectsPopup).clickCheckBoxUnread("true")
								.clickSearch()
								
List<String> dataRowSearchByCheckUnread = Page.nav(SearchInProjectsPopup).getDataRow("1")
println "dataRowSearchByCheckUnread: $dataRowSearchByCheckUnread"
Page.nav(SearchInProjectsPopup).verifyHighlightOnList(dataRowSearchByCheckUnread[0])
								.clickCloseSearchPopup()
																
println '>> Clear data'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickArchiveAction(projectId)