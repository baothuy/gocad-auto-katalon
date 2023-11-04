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
Page.nav(AccountSettingsPage).inputFirstNameContact(contactChanged[0])
							.inputLastNameContact(contactChanged[1])
							.inputGenderContact(contactChanged[2])
							.inputCompanyNameContact(contactChanged[3])
							.inputPhoneContact(contactChanged[4])
							.inputFaxContact(contactChanged[5])

println '>> Input billing/shipping address information'
Page.nav(AccountSettingsPage).inputFirstNameBillingAddress(billingAddressChanged[0])
								.inputLastNameBillingAddress(billingAddressChanged[1])
								.inputHouseNumberBillingAddress(billingAddressChanged[2])
								.inputStreetBillingAddress(billingAddressChanged[3])
								.selectCountryBillingAddress(billingAddressChanged[7])
								.selectStateBillingAddress(billingAddressChanged[4])
								.inputZIPCodeBillingAddress(billingAddressChanged[5])
								.selectCityBillingAddress(billingAddressChanged[6])
								.inputFirstNameShippingAddress(shippingAddressChanged[0])
								.inputLastNameShippingAddress(shippingAddressChanged[1])
								.inputHouseNumberShippingAddress(shippingAddressChanged[2])
								.inputStreetShippingAddress(shippingAddressChanged[3])
								.selectCountryShippingAddress(shippingAddressChanged[7])
								.selectStateShippingAddress(shippingAddressChanged[4])
								.inputZIPCodeShippingAddress(shippingAddressChanged[5])
								.selectCityShippingAddress(shippingAddressChanged[6])	
								.clickSaveChangesButton()
								.verifyToastMessageWhenSaveChange()
								
Page.nav(AccountSettingsPage).sleep(1)
								.refreshPage()
								
println '>> Verify contact information'
Page.nav(AccountSettingsPage).verifyFirstNameContactValue(contactChanged[0])
							.verifyLastNameContactValue(contactChanged[1])
							.verifyGenderContactValue(contactChanged[2])
							.verifyCompanyNameContactValue(contactChanged[3])
							.verifyPhoneContactValue(contactChanged[4])
							.verifyFaxContactValue(contactChanged[5])

println '>> Verify billing/shipping address information'
Page.nav(AccountSettingsPage).verifyFirstNameBillingAddressValue(billingAddressChanged[0])
								.verifyLastNameBillingAddressValue(billingAddressChanged[1])
								.verifyHouseNumberBillingAddressValue(billingAddressChanged[2])
								.verifyStreetBillingAddressValue(billingAddressChanged[3])
								.verifyStateBillingAddressValue(billingAddressChanged[4])
								.verifyZIPCodeBillingAddressValue(billingAddressChanged[5])
								.verifyCityBillingAddressValue(billingAddressChanged[6])
								.verifyCountryBillingAddressValue(billingAddressChanged[7])
								.verifyFirstNameShippingAddressValue(shippingAddressChanged[0])
								.verifyLastNameShippingAddressValue(shippingAddressChanged[1])
								.verifyHouseNumberShippingAddressValue(shippingAddressChanged[2])
								.verifyStreetShippingAddressValue(shippingAddressChanged[3])
								.verifyStateShippingAddressValue(shippingAddressChanged[4])
								.verifyZIPCodeShippingAddressValue(shippingAddressChanged[5])
								.verifyCityShippingAddressValue(shippingAddressChanged[6])
								.verifyCountryShippingAddressValue(shippingAddressChanged[7])
								
println '>> Input old data contact information'
Page.nav(AccountSettingsPage).inputFirstNameContact(contact[0])
							.inputLastNameContact(contact[1])
							.inputGenderContact(contact[2])
							.inputCompanyNameContact(contact[3])
							.inputPhoneContact(contact[4])
							.inputFaxContact(contact[5])
							
println '>> Input old data billing/shipping address information'
Page.nav(AccountSettingsPage).inputFirstNameBillingAddress(billingAddress[0])
								.inputLastNameBillingAddress(billingAddress[1])
								.inputHouseNumberBillingAddress(billingAddress[2])
								.inputStreetBillingAddress(billingAddress[3])
								.selectCountryBillingAddress(billingAddress[7])
								.selectStateBillingAddress(billingAddress[4])
								.inputZIPCodeBillingAddress(billingAddress[5])
								.selectCityBillingAddress(billingAddress[6])
								.inputFirstNameShippingAddress(shippingAddress[0])
								.inputLastNameShippingAddress(shippingAddress[1])
								.inputHouseNumberShippingAddress(shippingAddress[2])
								.inputStreetShippingAddress(shippingAddress[3])
								.selectCountryShippingAddress(shippingAddress[7])
								.selectStateShippingAddress(shippingAddress[4])
								.inputZIPCodeShippingAddress(shippingAddress[5])
								.selectCityShippingAddress(shippingAddress[6])
								.clickSaveChangesButton()
								.verifyToastMessageWhenSaveChange()
								.sleep(1)