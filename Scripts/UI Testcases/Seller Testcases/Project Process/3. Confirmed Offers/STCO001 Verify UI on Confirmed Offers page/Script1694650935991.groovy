import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.seller.ConfirmedOffersPageOfSeller
import katalon.fw.lib.Page



println '>> User seller signs in page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> Click search data project added at previous step'
Page.nav(LeftNavBar).clickConfirmedOffers()

println '>> Verify UI Requested Offers page'
Page.nav(ConfirmedOffersPageOfSeller).verifyUIVisible()

println '>> Get data first row to go detail verify UI'
List<String> dataRow = Page.nav(ConfirmedOffersPageOfSeller).getDataRow("1")
String projectId = dataRow[0]

Page.nav(ConfirmedOffersPageOfSeller).verifyStatus(projectId, "Order confirmed")
									.clickAction(projectId)
									
Page.nav(DetailOffer).verifyUIVisible()
						.verifyOrderStatus("Order confirmed")
						.verifyViewButtonVisible()
						.verifyContentAlertManuallyVisible("Confirmed Offers")