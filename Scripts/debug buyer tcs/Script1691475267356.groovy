import gocad.buyer.AddressInformationPopup
import gocad.buyer.DraftPage
import gocad.buyer.ReviewPage
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import katalon.fw.lib.Page



println '>> User Seller signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> User Seller go to Price And Delivery Settings settings'
Page.nav(LeftNavBar).clickDraft()

Page.nav(DraftPage).clickViewAction("36663")

//Page.nav(ReviewPage).clickMoreOption("step-testing.step")
//						.clickCopyPart()

Page.nav(ReviewPage).clickCheckout()

Page.nav(AddressInformationPopup).clickCheckBoxCloneTheSameAddress("false")
								.sleep(3)
						