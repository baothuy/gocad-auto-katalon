import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.seller.OpenInquiriesPage
import katalon.fw.lib.Page

'1. User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

'debug. select project'
Page.nav(LeftNavBar).clickOpenInquiries()
Page.nav(OpenInquiriesPage).clickAction("759")

'Input change unit price'
Page.nav(DetailOffer).inputUnitPrice(unitPriceChanged).clickAcceptChangeUnitPrice().clickCloseToastMessage()

List<String> tablePartChanged = Page.nav(DetailOffer).getTablePartReview(fileName)
println "tablePartChanged: $tablePartChanged"