import gocad.common.DetailOffer
import gocad.common.MySignInPage
import gocad.seller.OpenInquiriesPage
import katalon.fw.lib.Page

'11. Seller Login system to check offers of buyer'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

'12. Seller go detail offers of buyer checkout'
Page.nav(OpenInquiriesPage).clickAction('549')

'13. Seller click accept and send offers to buyer'
Page.nav(DetailOffer).clickAcceptAndSendOffer().clickOKConfirmPopup()