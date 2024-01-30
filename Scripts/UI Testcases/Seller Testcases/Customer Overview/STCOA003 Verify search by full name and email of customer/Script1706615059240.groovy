import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.seller.CustomerOverviewDetailPage
import gocad.seller.CustomerOverviewPage
import katalon.fw.lib.Page

println '>> User seller signs in page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> Click search data project added at previous step'
Page.nav(LeftNavBar).clickCustomerOverview()

println '>> Input search by Full name'
Page.nav(CustomerOverviewPage).inputSearch(fullName)

println '>> Get data first row'
List<String> dataRowFullName = Page.nav(CustomerOverviewPage).getDataRow("1")

String actualFullName = dataRowFullName[1]
WebUI.verifyEqual(fullName, actualFullName)

println '>> Input search by email'
Page.nav(CustomerOverviewPage).inputSearch(email)

println '>> Get data first row'
List<String> dataRow = Page.nav(CustomerOverviewPage).getDataRow("1")

String actualEmail = dataRow[2]
WebUI.verifyEqual(email, actualEmail)