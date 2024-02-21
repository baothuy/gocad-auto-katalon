import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.seller.CustomerOverviewDetailPage
import gocad.seller.CustomerOverviewPage
import katalon.fw.lib.Page

println '>> User seller signs in page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> Click search data project added at previous step'
Page.nav(LeftNavBar).clickCustomerOverview()

println '>> Verify UI Requested Offers page'
Page.nav(CustomerOverviewPage).verifyUIVisible()

println '>> Get data first row to go detail verify UI'
Page.nav(CustomerOverviewPage).inputSearch(email)
List<String> dataRow = Page.nav(CustomerOverviewPage).getDataRowByEmail(email)
String customerId = dataRow[0]

Page.nav(CustomerOverviewPage).clickAction(customerId)
									
Page.nav(CustomerOverviewDetailPage).verifyUIVisible()
									.verifyFullName(dataRow[1])
									.verifyDiscount(dataRow[5])
									.verifyPartNumber(dataRow[2])
									.verifyOrderTotal(dataRow[3])
									.verifyCalculationsNumber(dataRow[4])
