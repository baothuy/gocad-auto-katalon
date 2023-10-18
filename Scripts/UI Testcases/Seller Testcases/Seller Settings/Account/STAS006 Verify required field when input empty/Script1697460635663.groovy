import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.seller.AccountSettingsLeftNavMenu
import gocad.seller.AccountSettingsPage
import gocad.seller.LegalInformationSettingsPage
import gocad.seller.PaymentDetailsSettingsPage
import gocad.seller.TermsOfPaymentSettingsPage
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> click Account'
Page.nav(LeftNavBar).clickAccount()

println '>> Input contact information'
Page.nav(AccountSettingsPage).inputFirstNameContact("")
							.inputLastNameContact("")
							.inputCompanyNameContact("")
							
println '>> Input billing/shipping address information'
Page.nav(AccountSettingsPage).inputFirstNameBillingAddress("")
								.inputLastNameBillingAddress("")
								.inputHouseNumberBillingAddress("")
								.inputStreetBillingAddress("")
								.inputZIPCodeBillingAddress("")
								.inputCityBillingAddress("")
								
println '>> Verify error on account settings page'
Page.nav(AccountSettingsPage).verifyShowErrorWhenFirstNameContactEmpty()
							.verifyShowErrorWhenLastNameContactEmpty()
							.verifyShowErrorWhenCompanyNameContactEmpty()
							.verifyShowErrorWhenFirstNameBillingAddressEmpty()
							.verifyShowErrorWhenLastNameBillingAddressEmpty()
							.verifyShowErrorWhenHouseNumberBillingAddressEmpty()
							.verifyShowErrorWhenStreetBillingAddressEmpty()
							.verifyShowErrorWhenZIPCodeBillingAddressEmpty()
							.verifyShowErrorWhenCityBillingAddressEmpty()
							.sleep(1)							

println '>> click Terms Of Payment'
Page.nav(AccountSettingsLeftNavMenu).clickTermsOfPayment()

println '>> verify show error'
Page.nav(TermsOfPaymentSettingsPage).inputPaymentTarget("")
									.verifyShowErrorWhenPaymentTargetEmpty()
									.sleep(1)