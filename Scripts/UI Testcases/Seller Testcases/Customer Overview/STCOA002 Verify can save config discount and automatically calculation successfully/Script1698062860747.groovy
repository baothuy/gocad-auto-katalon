import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.common.ToastMessage
import gocad.seller.CustomerOverviewDetailPage
import gocad.seller.CustomerOverviewPage
import katalon.fw.lib.Page

println '>> User seller signs in page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> Click search data project added at previous step'
Page.nav(LeftNavBar).clickCustomerOverview()

println '>> Verify UI Requested Offers page'
List<String> dataRow = Page.nav(CustomerOverviewPage).getDataRow("1")
String customerId = dataRow[0]
Page.nav(CustomerOverviewPage).clickAction(customerId)

Page.nav(CustomerOverviewDetailPage).inputDiscount(discountChanged)
									.clickToggleAutomaticallyCalculation(automaticallyCalculationChanged)
									.clickSaveButton()
									
Page.nav(ToastMessage).verifyToastMessage("Success!", "")
					  .clickCloseToastMessage()

Page.nav(CustomerOverviewDetailPage).inputDiscount(discount)
									.clickToggleAutomaticallyCalculation(automaticallyCalculation)
									.clickSaveButton()
									
Page.nav(ToastMessage).verifyToastMessage("Success!", "")
						.clickCloseToastMessage()