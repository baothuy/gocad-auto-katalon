import gocad.buyer.ReceivedOffersPage
import gocad.common.ConfirmPopup
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

println '>> Get data first row to go detail'
List<String> dataRow = Page.nav(ReceivedOffersPage).getDataRow("1")
String projectId = dataRow[0]
Page.nav(ReceivedOffersPage).clickAction(projectId)

println '>> click Decline action'
Page.nav(DetailOffer).clickMoreAction()
					.clickDeclineAction()
					.clickOKConfirmPopup()

println '>> Verify UI after click decline'
Page.nav(DetailOffer).clickMoreAction()
					.verifyAcceptButtonVisible()
					.verifyTextLineThroughVisible()
					.verifyAcceptOfferButtonNotVisible()
					
println '>> click Accept action again'
Page.nav(DetailOffer).clickMoreAction()
					.clickAcceptAction()
					.clickOKConfirmPopup()
					
println '>> Verify UI after click decline'
Page.nav(DetailOffer).clickMoreAction()
					.verifyDeclineButtonVisible()
					.verifyTextLineThroughNotVisible()
					.verifyAcceptOfferButtonVisible()
					
					
					