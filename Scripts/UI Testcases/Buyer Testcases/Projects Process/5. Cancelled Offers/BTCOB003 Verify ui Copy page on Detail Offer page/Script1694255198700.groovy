import gocad.buyer.CancelledOffersPageOfBuyer
import gocad.common.CopyPartPopup
import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import katalon.fw.lib.Page



println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> User go to Cancelled Offers page'
Page.nav(LeftNavBar).clickCancelledOffers()

println '>> Verify UI Cancelled Offers page'
Page.nav(CancelledOffersPageOfBuyer).verifyUIVisible()

println '>> Get data first row to go detail offer'
List<String> dataRow = Page.nav(CancelledOffersPageOfBuyer).getDataRow("1")
String projectId = dataRow[0]
Page.nav(CancelledOffersPageOfBuyer).clickAction(projectId)

println '>> Get data first row to go detail offer'
Page.nav(DetailOffer).clickMoreAction()
					 .clickCopyAction()
					 					 
Page.nav(CopyPartPopup).verifyUICopyPopupVisible()