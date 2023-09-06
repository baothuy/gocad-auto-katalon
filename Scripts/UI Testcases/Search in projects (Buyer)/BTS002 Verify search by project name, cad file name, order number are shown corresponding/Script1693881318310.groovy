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
String orderNumber = "GOCAD"+ projectId

println '>> Click Search In Projects button'
Page.nav(LeftNavBar).clickSearchInProjects()

println '>> Verify search by project name added at previous step'
Page.nav(SearchInProjectsPopup).inputSearchTextField(projectName)
								.clickSearch()
								.verifyProjectNameVisibleInList(projectId, projectName)
								.clearSearchText()

println '>> Verify search by file name added at previous step'
Page.nav(SearchInProjectsPopup).inputSearchTextField(fileName)
								.clickSearch()
								.verifyFileNameVisibleInList(projectId, fileName)
								.clearSearchText()
								
println '>> Verify search by order number added at previous step'
Page.nav(SearchInProjectsPopup).inputSearchTextField(orderNumber)
								.clickSearch()
								.verifyOrderNumberVisibleInList(projectId, orderNumber)
								.clearSearchText()
								
println '>> Verify search by status'
Page.nav(SearchInProjectsPopup).selectStatus(status)
								.clickSearch()
								.verifyStatusVisibleInList(projectId, status)
								.clearSearchStatus()

String previousDate = DateTimeUtility.plusDays(-1, "yyyy-MM-dd")
String currentDate = DateTimeUtility.currentDay("yyyy-MM-dd")	
println "previousDate: $previousDate"
println "currentDate: $currentDate"				

println '>> Verify search by delivery date'
Page.nav(SearchInProjectsPopup).inputStartDate(previousDate)
								.inputEndDate(currentDate)
								.clickSearch()
								.verifyDeliveryDateVisibleInList(projectId, currentDate)
								.clearSearchDate()
								
println '>> Verify search by Mark as Unread'
Page.nav(SearchInProjectsPopup).clickCheckBoxUnread("true")
								.clickSearch()
								.verifyHighlightOnList(projectId)
																
println '>> Clear data'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickArchiveAction(projectId)