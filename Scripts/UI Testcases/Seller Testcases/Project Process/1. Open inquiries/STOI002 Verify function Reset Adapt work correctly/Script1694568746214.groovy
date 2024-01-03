import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.seller.OpenInquiriesPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility


println '>> User seller signs in page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

Page.nav(LeftNavBar).clickOpenInquiries()

List<String> orderInfor = Page.nav(OpenInquiriesPage).getDataRowByStatus("New request")
String projectId = orderInfor[0]
String unitPriceChanged = CommonUtility.randomNumber(100)

Page.nav(OpenInquiriesPage).clickAction(projectId)

Page.nav(DetailOffer).inputUnitPrice(unitPriceChanged)						
						.clickAcceptChangeUnitPrice()
						.clickCloseToastMessage()
						.clickUndo()
						.clickAcceptChangeUnitPrice()
						.clickCloseToastMessage()
						.inputUnitPrice(unitPriceChanged)
						.clickAcceptChangeUnitPrice()
						.clickCloseToastMessage()
						.clickResetAdapt()
						.clickCloseToastMessage()
						