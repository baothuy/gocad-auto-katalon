import gocad.buyer.DraftPage
import gocad.buyer.RequestOfferPopup
import gocad.buyer.ReviewPage
import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.seller.OpenInquiriesPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility

println '>> All param on this flow'
println '>> Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>>  User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>>  User buyer add project'
Page.nav(LeftNavBar).clickDraft()

Page.nav(DraftPage).clickAction('Project lay10193fG')

Page.nav(ReviewPage).clickRequestOffer()

Page.nav(RequestOfferPopup).clickOK()

println '>> Get info Detail offer after click OK on Request Offer Popup'
List<String> listShippingInfo = Page.nav(DetailOffer).getShippingInfo()
List<String> tablePart = Page.nav(DetailOffer).getTablePartReview(fileName)

println '>> Buyer click Logout button'
Page.nav(LeftNavBar).clickLogout()

println '>> Seller Login system to check offers of buyer'
Page.nav(MySignInPage).enterCredentialAsSeller().clickSignIn().verifySuccessfullySignInAsSeller()

Page.nav(OpenInquiriesPage).clickAction('848')

println '>> Input change unit price'
Page.nav(DetailOffer).inputUnitPrice(unitPriceChanged).clickAcceptChangeUnitPrice().clickCloseToastMessage()