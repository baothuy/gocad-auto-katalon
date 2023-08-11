import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.seller.OpenInquiriesPage
import katalon.fw.lib.Page

'1. User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

'debug. select project'
Page.nav(LeftNavBar).clickOpenInquiries()
Page.nav(OpenInquiriesPage).clickAction("766")

List<String> expectedResult = ['GOCAD766','1','ECONOMY','08/26/2023','Packaging and Shipping Comments','Standard shipping']

'Input change unit price'
Page.nav(DetailOffer).verifyShippingOptionsContent("Standard shipping")
					 .verifyShippingInfo(expectedResult)