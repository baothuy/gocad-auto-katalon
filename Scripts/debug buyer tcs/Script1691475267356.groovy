import gocad.buyer.CheckoutPage
import gocad.buyer.DraftPage
import gocad.buyer.ReviewPage
import gocad.common.CopyPartPopup
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import katalon.fw.lib.Page



println '>> User Seller signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> User Seller go to Price And Delivery Settings settings'
Page.nav(LeftNavBar).clickDraft()

Page.nav(DraftPage).clickViewAction("35331")

//Page.nav(ReviewPage).clickMoreOption("step-testing.step")
//						.clickCopyPart()

Page.nav(ReviewPage).clickCheckout()

Page.nav(CheckoutPage).clickMoreOption("step-testing.step")
						.clickCopy()
						
println '>> select project to copy'
Page.nav(CopyPartPopup).inputProjectToCopy("Auto Generate Prj zgV4JG4Jzu")
						  .clickOK()
						  .verifyToastMessageWhenCopyProject("step-testing.step", "Auto Generate Prj zgV4JG4Jzu")
						