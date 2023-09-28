import gocad.buyer.RequestedOffersPage
import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.seller.OpenInquiriesPage
import katalon.fw.lib.Page



println '>> User seller signs in page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> Click search data project added at previous step'
Page.nav(LeftNavBar).clickOpenInquiries()

println '>> Verify UI Requested Offers page'
Page.nav(OpenInquiriesPage).verifyUIVisible()

println '>> Get data first row to go detail verify UI'
List<String> dataRow = Page.nav(OpenInquiriesPage).getDataRow("1")
String projectId = dataRow[0]

Page.nav(OpenInquiriesPage).clickAction(projectId)
Page.nav(DetailOffer).verifyUIVisible()
						.verifyViewButtonVisible()
						.verifyRejectOfferButtonVisible()
						.verifyAcceptAndSendOfferButtonVisible()
						.verifyContentAlertManuallyVisible("Open Inquiries")