import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.common.ToastMessage
import gocad.common.ConfirmPopup
import gocad.seller.OpenInquiriesPage
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller go to Price And Delivery Settings settings'
Page.nav(LeftNavBar).clickOpenInquiries()

List<String> getDataPrj = Page.nav(OpenInquiriesPage).getDataRowByStatus("New request")

Page.nav(OpenInquiriesPage).clickAction(getDataPrj[0])

Page.nav(DetailOffer).clickSendAdaptedOffer()

Page.nav(ConfirmPopup).verifyTitleConfirmPopup("Confirm Order")
						.verifyContentConfirmPopup("Please confirm sending the adapted offer!")
						.clickOK()

Page.nav(ToastMessage).verifyToastMessage("Update!","Offer adapted")
						.clickCloseToastMessage()