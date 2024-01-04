import gocad.buyer.AccountSettingsPage
import gocad.buyer.ChangePasswordPopup
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import katalon.fw.lib.Page

println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> Click Settings nav menu'
Page.nav(LeftNavBar).clickSettings()

println '>> Verify UI account settings page'
Page.nav(AccountSettingsPage).verifyUIVisible()

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
								.clickSaveChangesButton()
								
println '>> Verify error on account settings page'
Page.nav(AccountSettingsPage).verifyShowErrorWhenFirstNameContactEmpty()
							.verifyShowErrorWhenLastNameContactEmpty()
							.verifyShowErrorWhenCompanyNameContactEmpty()
							.verifyShowErrorWhenFirstNameBillingAddressEmpty()
							.verifyShowErrorWhenLastNameBillingAddressEmpty()
							.verifyShowErrorWhenHouseNumberBillingAddressEmpty()
							.verifyShowErrorWhenStreetBillingAddressEmpty()
							.verifyShowErrorWhenZIPCodeBillingAddressEmpty()
							.sleep(1)