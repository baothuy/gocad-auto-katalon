import gocad.buyer.AddressInformationPopup
import gocad.buyer.AccountSettingsPage
import gocad.buyer.CheckoutPage
import gocad.buyer.DraftPage
import gocad.buyer.ReviewPage
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import katalon.fw.lib.Page



println '>> FPA002 Verify seller accept offers successfully when project larger than Threshold'
println '>> Random project name'
//def projectName = CommonUtility.generateRandomProjectName(10)
//
println '>> User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()
Page.nav(LeftNavBar).clickSettings()
String companyName = Page.nav(AccountSettingsPage).getCompanyName()
List<String> listBillingAddress = Page.nav(AccountSettingsPage).getBillingAddress()
List<String> listShippingAddress = Page.nav(AccountSettingsPage).getShippingAddress()
List<String> listCustomerInfo = Page.nav(AccountSettingsPage).getCustomerInfo()

Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickViewAction('1716')

println '>> Verify file part can download successfully'
Page.nav(ReviewPage).clickCheckout()

println '>> Verify file part can download successfully'
Page.nav(CheckoutPage).clickEditAddress()
Page.nav(AddressInformationPopup).inputFirstNameBillingAddress("")
								.inputLastNameBillingAddress("")
								.inputStreetBillingAddress("")
								.inputHouseNumberBillingAddress("")
								.inputZIPCodeBillingAddress("")
								.inputCityBillingAddress("")
								.inputFirstNameShippingAddress("")
								.inputLastNameShippingAddress("")
								.inputStreetShippingAddress("")
								.inputHouseNumberShippingAddress("")
								.inputZIPCodeShippingAddress("")
								.inputCityShippingAddress("")
								.verifyShowErrorWhenFirstNameBillingAddressEmpty()
								.verifyShowErrorWhenLastNameBillingAddressEmpty()
								.verifyShowErrorWhenHouseNumberBillingAddressEmpty()
								.verifyShowErrorWhenStreetBillingAddressEmpty()
								.verifyShowErrorWhenZIPCodeBillingAddressEmpty()
								.verifyShowErrorWhenCityBillingAddressEmpty()
								.verifyShowErrorWhenFirstNameShippingAddressEmpty()
								.verifyShowErrorWhenLastNameShippingAddressEmpty()
								.verifyShowErrorWhenHouseNumberShippingAddressEmpty()
								.verifyShowErrorWhenStreetShippingAddressEmpty()
								.verifyShowErrorWhenZIPCodeShippingAddressEmpty()
								.verifyShowErrorWhenCityShippingAddressEmpty()