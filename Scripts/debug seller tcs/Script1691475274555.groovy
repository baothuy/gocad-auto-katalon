import gocad.buyer.AddressInformationPopup
import gocad.buyer.ReviewPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.SignInPage
import gocad.seller.MyProjectsPage
import gocad.seller.SendOfferPage
import katalon.fw.lib.Page


println '>> User buyer signs in page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

Page.nav(LeftNavBar).clickMyProjects()

Page.nav(MyProjectsPage).clickViewAction("2830")

Page.nav(ManufacturingInformationPage).clickReview()



