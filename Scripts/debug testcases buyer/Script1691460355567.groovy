import gocad.buyer.CheckoutPage
import gocad.buyer.DraftPage
import gocad.buyer.ReviewPage
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
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
Page.nav(DraftPage).clickAction('Project VBRhBe6kug')

'8. Click Checkout button on Review Page'
Page.nav(ReviewPage).clickCheckout()

'9. Get information Checkout page'
String deliveryDate = Page.nav(CheckoutPage).getDeliveryDate()
String companyName = Page.nav(CheckoutPage).getCompanyName()
String netTotal = Page.nav(CheckoutPage).getNetTotal()
List<String> listBillingAddress = Page.nav(CheckoutPage).getBillingAddress()
List<String> listShippingAddress = Page.nav(CheckoutPage).getShippingAddress()
String orderDate = Page.nav(DateTimeUtility).getCurrentDateTime()
println "delivery Option: $deliveryDate"
println "companyName: $companyName"
println "netTotal: $netTotal"
println "listBilingAddress: $listBillingAddress"
println "listShippingAddress: $listShippingAddress"
println "orderDate: $orderDate"