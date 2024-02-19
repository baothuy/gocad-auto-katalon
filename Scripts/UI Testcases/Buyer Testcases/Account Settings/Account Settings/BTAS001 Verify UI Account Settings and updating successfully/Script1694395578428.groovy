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
							
							
println '>> Input additional information'
Page.nav(AccountSettingsPage).inputVATNumber(vatNumberChanged)

println '>> Input billing/shipping address information'
Page.nav(AccountSettingsPage).inputFirstNameBillingAddress(billingAddressChanged[0])
								.inputLastNameBillingAddress(billingAddressChanged[1])
								.inputEmailBillingAddress(billingAddressChanged[2])
								.inputPhoneBillingAddress(billingAddressChanged[3])
								.inputSearchBillingAddress(billingAddressChanged[5], billingAddressChanged[4], billingAddressChanged[8], billingAddressChanged[9], billingAddressChanged[6])
								.inputFirstNameShippingAddress(shippingAddressChanged[0])
								.inputLastNameShippingAddress(shippingAddressChanged[1])
								.inputEmailShippingAddress(shippingAddressChanged[2])
								.inputPhoneShippingAddress(shippingAddressChanged[3])
								.inputSearchShippingAddress(shippingAddressChanged[5], shippingAddressChanged[4], shippingAddressChanged[8], shippingAddressChanged[9], shippingAddressChanged[6])
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
								.verifyEmailBillingAddressValue(billingAddressChanged[2])
								.verifyPhoneBillingAddressValue(billingAddressChanged[3])
								.verifyStreetBillingAddressValue(billingAddressChanged[4])
								.verifyHouseNumberBillingAddressValue(billingAddressChanged[5])
								.verifyCountryBillingAddressValue(billingAddressChanged[6])
								.verifyStateBillingAddressValue(billingAddressChanged[7])								
								.verifyCityBillingAddressValue(billingAddressChanged[8])
								.verifyZIPCodeBillingAddressValue(billingAddressChanged[9])
								.verifyFirstNameShippingAddressValue(shippingAddressChanged[0])
								.verifyLastNameShippingAddressValue(shippingAddressChanged[1])
								.verifyEmailShippingAddressValue(shippingAddressChanged[2])
								.verifyPhoneShippingAddressValue(shippingAddressChanged[3])
								.verifyStreetShippingAddressValue(shippingAddressChanged[4])
								.verifyHouseNumberShippingAddressValue(shippingAddressChanged[5])								
								.verifyCountryShippingAddressValue(shippingAddressChanged[6])
								.verifyStateShippingAddressValue(shippingAddressChanged[7])								
								.verifyCityShippingAddressValue(shippingAddressChanged[8])	
								.verifyZIPCodeShippingAddressValue(shippingAddressChanged[9])
								
println '>> Input old data contact information'
Page.nav(AccountSettingsPage).inputFirstNameContact(contact[0])
							.inputLastNameContact(contact[1])
							.inputGenderContact(contact[2])
							.inputCompanyNameContact(contact[3])
							.inputPhoneContact(contact[4])
							.inputFaxContact(contact[5])
							
println '>> Input old data additional information'
Page.nav(AccountSettingsPage).inputVATNumber(vatNumber)
							
println '>> Input old data billing/shipping address information'
Page.nav(AccountSettingsPage).inputFirstNameBillingAddress(billingAddress[0])
								.inputLastNameBillingAddress(billingAddress[1])
								.inputEmailBillingAddress(billingAddress[2])
								.inputPhoneBillingAddress(billingAddress[3])
								.inputSearchBillingAddress(billingAddress[5], billingAddress[4], billingAddress[8], billingAddress[9], billingAddress[6])
								.inputFirstNameShippingAddress(shippingAddress[0])
								.inputLastNameShippingAddress(shippingAddress[1])
								.inputEmailShippingAddress(shippingAddress[2])
								.inputPhoneShippingAddress(shippingAddress[3])
								.inputSearchShippingAddress(shippingAddress[5], shippingAddress[4], shippingAddress[8], shippingAddress[9], shippingAddress[6])
								.clickSaveChangesButton()
								.verifyToastMessageWhenSaveChange()
								.sleep(1)