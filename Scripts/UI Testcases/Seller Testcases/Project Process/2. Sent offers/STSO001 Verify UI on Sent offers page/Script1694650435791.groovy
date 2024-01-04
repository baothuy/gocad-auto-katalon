import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.seller.SentOffersPage
import katalon.fw.lib.Page



println '>> User seller signs in page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> Click search data project added at previous step'
Page.nav(LeftNavBar).clickSentOffers()

println '>> Verify UI Requested Offers page'
Page.nav(SentOffersPage).verifyUIVisible()

println '>> Get data first row to go detail verify UI'
List<String> dataRow = Page.nav(SentOffersPage).getDataRow("1")
String projectId = dataRow[0]
println "projectId: $projectId"

Page.nav(SentOffersPage).clickAction(projectId)
Page.nav(DetailOffer).verifyUIVisible()
						.verifyOrderStatus("Offer adapted")
						.verifyViewButtonVisible()
						.verifyContentAlertManuallyVisible("Sent Offers")