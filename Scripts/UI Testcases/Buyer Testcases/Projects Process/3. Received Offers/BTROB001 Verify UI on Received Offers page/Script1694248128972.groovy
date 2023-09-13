import gocad.buyer.ReceivedOffersPage
import gocad.buyer.RequestedOffersPage
import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import katalon.fw.lib.Page



println '>> User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> User go to Received Offers page'
Page.nav(LeftNavBar).clickReceivedOffers()

println '>> Verify UI Received Offers page'
Page.nav(ReceivedOffersPage).verifyUIVisible()

println '>> Get data first row to go detail verify UI'
List<String> dataRow = Page.nav(ReceivedOffersPage).getDataRow("1")
String projectId = dataRow[0]

Page.nav(ReceivedOffersPage).clickAction(projectId)
Page.nav(DetailOffer).verifyUIVisible()
					.verifyViewButtonVisible()
					.verifyCopyButtonVisible()
					.verifyDeclineButtonVisible()
					.verifyOrderStatus("Offer adapted")
					.verifyContentAlertManuallyVisible("Received Offers")