import gocad.buyer.ConfirmedOffersPageOfBuyer
import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.common.ViewPartPopup
import katalon.fw.lib.Page



println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> User go to Confirmed Offers page'
Page.nav(LeftNavBar).clickConfirmedOffers()

println '>> Verify UI Confirmed Offers page'
Page.nav(ConfirmedOffersPageOfBuyer).verifyUIVisible()

println '>> Get data first row to go detail offer'
List<String> dataRow = Page.nav(ConfirmedOffersPageOfBuyer).getDataRow("1")
String projectId = dataRow[0]
Page.nav(ConfirmedOffersPageOfBuyer).clickAction(projectId)

println '>> Get data first row to go detail offer'
Page.nav(DetailOffer).clickMoreAction()
					 .clickViewAction()
					 					 
Page.nav(ViewPartPopup).verifyUIViewPopupVisible()