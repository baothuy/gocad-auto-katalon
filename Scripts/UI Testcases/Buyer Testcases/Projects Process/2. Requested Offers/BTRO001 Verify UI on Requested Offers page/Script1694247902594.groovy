import gocad.buyer.RequestedOffersPage
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.common.DetailOffer
import katalon.fw.lib.Page



println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> User go to Requested Offers page'
Page.nav(LeftNavBar).clickRequestedOffers()

println '>> Verify UI Requested Offers page'
Page.nav(RequestedOffersPage).verifyUIVisible()
							.clickPaginationOption(numberPage)
							.sleep(5)
							

println '>> Get data first row to go detail verify UI'
List<String> dataRow = Page.nav(RequestedOffersPage).getDataRowByStatus(status)
String projectId = dataRow[0]

Page.nav(RequestedOffersPage).clickAction(projectId)
Page.nav(DetailOffer).verifyUIVisible()
					.verifyViewButtonVisible()
					.verifyCopyButtonVisible()
					.verifyContentAlertManuallyVisible("Requested Offers")