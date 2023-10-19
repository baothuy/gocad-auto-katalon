import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.seller.CancelledOffersPageOfSeller
import katalon.fw.lib.Page



println '>> User seller signs in page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> Click search data project added at previous step'
Page.nav(LeftNavBar).clickCancelledOffers()

println '>> Verify UI Requested Offers page'
Page.nav(CancelledOffersPageOfSeller).verifyUIVisible()

println '>> Get data first row to go detail verify UI'
List<String> dataRow = Page.nav(CancelledOffersPageOfSeller).getDataRow("1")
String projectId = dataRow[0]

Page.nav(CancelledOffersPageOfSeller).verifyStatus(projectId, "Offer rejected")
									.clickAction(projectId)
									
Page.nav(DetailOffer).verifyUIVisible()
						.verifyOrderStatus("Offer rejected")
						.verifyViewButtonVisible()