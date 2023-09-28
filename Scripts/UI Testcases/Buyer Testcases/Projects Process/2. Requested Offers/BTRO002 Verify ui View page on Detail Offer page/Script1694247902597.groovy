import gocad.buyer.RequestedOffersPage
import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.common.ViewPartPopup
import katalon.fw.lib.Page



println '>> User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> User go to Requested Offers page'
Page.nav(LeftNavBar).clickRequestedOffers()

println '>> Verify UI Requested Offers page'
Page.nav(RequestedOffersPage).verifyUIVisible()

println '>> Get data first row to go detail offer'
List<String> dataRow = Page.nav(RequestedOffersPage).getDataRow("1")
String projectId = dataRow[0]
Page.nav(RequestedOffersPage).clickAction(projectId)

println '>> Get data first row to go detail offer'
Page.nav(DetailOffer).clickMoreAction()
					 .clickViewAction()
					 					 
Page.nav(ViewPartPopup).verifyUIViewPopupVisible()