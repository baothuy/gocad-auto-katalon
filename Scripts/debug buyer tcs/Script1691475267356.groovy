import gocad.buyer.ReceivedOffersPage
import gocad.common.ConfirmPopup
import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.common.ToastMessage
import gocad.seller.OpenInquiriesPage
import katalon.fw.lib.Page



println '>> User Seller signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> User Seller go to Price And Delivery Settings settings'
Page.nav(LeftNavBar).clickReceivedOffers()

List<String> getDataPrj = Page.nav(ReceivedOffersPage).getDataRow("1")

Page.nav(ReceivedOffersPage).clickAction(getDataPrj[0])

Page.nav(DetailOffer).clickAcceptOffer()

Page.nav(ConfirmPopup).verifyTitleConfirmPopup("Confirm Order")
						.verifyContentConfirmPopup("Do you want to send the order confirmation?")
						.clickOK()

Page.nav(ToastMessage).verifyToastMessage("Update!","project.status.ROLE_BUYER.f_BUYER_APPROVED")
						.clickCloseToastMessage()
						