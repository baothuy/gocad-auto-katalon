import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

import gocad.common.DetailOffer
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.seller.OpenInquiriesPage
import katalon.fw.lib.Page

'1. User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

'debug. select project'
Page.nav(LeftNavBar).clickOpenInquiries()
Page.nav(OpenInquiriesPage).clickAction("808")
  
println 'Input change unit price'
List<String> listshippinginfo = Page.nav(DetailOffer).getShippingInfo()
Page.nav(DetailOffer).verifyShippingInfo(listshippinginfo)
					