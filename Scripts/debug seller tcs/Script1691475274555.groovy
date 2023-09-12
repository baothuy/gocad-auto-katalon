import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.MySignInPage
import gocad.seller.OpenInquiriesPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility

println '>> User buyer signs in page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

Page.nav(LeftNavBar).clickOpenInquiries()

List<String> abc = Page.nav(OpenInquiriesPage).getDataRow("1")
println "row: $abc"


