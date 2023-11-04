import gocad.buyer.ReceivedOffersPage
import gocad.common.CopyPartPopup
import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import katalon.fw.lib.Page



println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> User go to Received Offers page'
Page.nav(LeftNavBar).clickReceivedOffers()

println '>> Verify UI Received Offers page'
Page.nav(ReceivedOffersPage).verifyUIVisible()

println '>> Get data first row to go detail offer'
List<String> dataRow = Page.nav(ReceivedOffersPage).getDataRow("1")
String projectId = dataRow[0]
Page.nav(ReceivedOffersPage).clickAction(projectId)

println '>> Get data first row to go detail offer'
Page.nav(DetailOffer).clickMoreAction()
					 .clickCopyAction()
					 					 
Page.nav(CopyPartPopup).verifyUICopyPopupVisible()