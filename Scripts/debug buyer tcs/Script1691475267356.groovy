import gocad.buyer.CheckoutPage
import gocad.buyer.DraftPage
import gocad.buyer.ReviewPage
import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.seller.ConfirmedOffersPageOfSeller
import katalon.fw.lib.Page
import katalon.utility.DateTimeUtility

'1. User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

//'get Company Name on setting'
//Page.nav(LeftNavBar).clickSettings()
//String companyName = Page.nav(SettingsPage).getCompanyName()
//println "companyName: $companyName"

'debug. select project'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickAction('Project fsBcBRYyDT')

'8. Click get infor and Checkout button on Review Page'
List<String> tablePart = Page.nav(ReviewPage).getTablePartReview(fileName)
println "tablePart: $tablePart"
Page.nav(ReviewPage).clickCheckout()

//Page.nav(ReviewPage).clickCheckout()
//Page.nav(CheckoutPage).selectDeliveryOption(deliveryOption)
//					  .selectShippingOption(shippingOption)
//					  .inputShippingComment(shippingComment)

//String deliveryDate = Page.nav(CheckoutPage).getDeliveryDate()
//String companyName = Page.nav(CheckoutPage).getCompanyName()
//String netTotal = Page.nav(CheckoutPage).getNetTotal()
//String grossTotal = Page.nav(CheckoutPage).getGrossTotal()
//List<String> listOrderSummary = Page.nav(CheckoutPage).getOrderSummary()
//println "listOrderSummary: $listOrderSummary"
//List<String> listBillingAddress = Page.nav(CheckoutPage).getBillingAddress()
//List<String> listShippingAddress = Page.nav(CheckoutPage).getShippingAddress()
//String orderDate = Page.nav(DateTimeUtility).getCurrentDateTime()
//
//'10. Click Checkout button on Checkout Page'
//Page.nav(CheckoutPage).clickCheckboxAgreeTermsAndConditions()
//					  .clickPlaceYourOrder()
//
//  '12. Buyer click Logout button'
//  Page.nav(LeftNavBar).clickLogout()
//  
//  '13. Seller Login system to check offers of buyer'
//  Page.nav(MySignInPage).enterCredentialAsSeller().clickSignIn().verifySuccessfullySignInAsSeller()
//  
//  '14. Seller go confirmed offers of buyer checkout'
//  Page.nav(LeftNavBar).clickConfirmedOffers()
//  
//  '16. Go confirmed offers deltail of buyer checkout'
//  Page.nav(ConfirmedOffersPageOfSeller).clickAction('713')
//  
//  '17. Verify detail of offer'
//  Page.nav(DetailOffer).verifyBillingAddress(listBillingAddress)
//					   .verifyShippingAddress(listShippingAddress)
//					   .verifyOrderSummary(listOrderSummary)
					  