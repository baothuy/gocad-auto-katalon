import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.seller.OpenInquiriesPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility



println '>> User seller signs in page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> Click search data project added at previous step'
Page.nav(LeftNavBar).clickOpenInquiries()

println '>> Verify UI Requested Offers page'
Page.nav(OpenInquiriesPage).verifyUIVisible()
							.clickPaginationOption("50")
							.sleep(5)

println '>> Get data first row to go detail verify UI'
List<String> dataRow = Page.nav(OpenInquiriesPage).getDataRowByStatus(status)
String projectId = dataRow[0]

String randNumber =  CommonUtility.randomNumber(100)
println "randNumber: $randNumber"

Page.nav(OpenInquiriesPage).clickAction(projectId)
Page.nav(DetailOffer).inputUnitPrice(randNumber).clickAcceptChangeUnitPrice().clickCloseToastMessage()
					.verifyUIVisible()
					.verifyViewButtonVisible()
					.verifyRejectOfferButtonVisible()
					.verifyResetAdaptButtonVisible(dataRow[6])
					.verifyAcceptAndSendOfferButtonVisible()
					.verifyContentAlertManuallyVisible("Open Inquiries")