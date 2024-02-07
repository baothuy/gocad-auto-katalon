import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.seller.OpenInquiriesPage
import internal.GlobalVariable
import katalon.fw.lib.Page
import katalon.utility.CommonUtility


println '>> User seller signs in page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

Page.nav(LeftNavBar).clickOpenInquiries()
Page.nav(OpenInquiriesPage).clickPaginationOption('100')

List<String> orderInfor = Page.nav(OpenInquiriesPage).getDataRowByStatus("New request")
String projectId = orderInfor[0]

Page.nav(OpenInquiriesPage).clickAction(projectId)

Page.nav(DetailOffer)
						.sleep(2)
						.refreshPage()

Page.nav(DetailOffer).verifyShippingCost(shippingCost + ",00 " + GlobalVariable.currency)
						