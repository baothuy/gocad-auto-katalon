import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.common.ToastMessage
import gocad.seller.AccountSettingsPage
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller go to Price And Delivery Settings settings'
Page.nav(LeftNavBar).clickAccount()

Page.nav(AccountSettingsPage).inputFirstNameContact(contactChanged[0])
							.inputLastNameContact(contactChanged[1])
							.inputGenderContact(contactChanged[2])
							.inputCompanyNameContact(contactChanged[3])
							.inputPhoneContact(contactChanged[4])
							.inputFaxContact(contactChanged[5])
							.inputWebsiteContact(contactChanged[6])
							
println '>> Input billing/shipping address information'
Page.nav(AccountSettingsPage).inputFirstNameBillingAddress(billingAddressChanged[0])
								.inputLastNameBillingAddress(billingAddressChanged[1])
								.inputEmailBillingAddress(billingAddressChanged[2])
								.inputPhoneBillingAddress(billingAddressChanged[3])
								.inputSearchBillingAddress(billingAddressChanged[4], billingAddressChanged[5], billingAddressChanged[8], billingAddressChanged[9], billingAddressChanged[6])								
								.clickSaveChangesButton()

println '>> verify Toast Message'
Page.nav(ToastMessage).verifyToastMessage("Success!", "Updated Account")

Page.nav(AccountSettingsPage).sleep(1)
							 .refreshPage()
							 
println '>> Verify contact information'
Page.nav(AccountSettingsPage).verifyFirstNameContactValue(contactChanged[0])
							 .verifyLastNameContactValue(contactChanged[1])
							 .verifyGenderContactValue(contactChanged[2])
							 .verifyCompanyNameContactValue(contactChanged[3])
							 .verifyPhoneContactValue(contactChanged[4])
							 .verifyFaxContactValue(contactChanged[5])
							 .verifyWebsiteContactValue(contactChanged[6])
							 
println '>> Verify billing/shipping address information'
Page.nav(AccountSettingsPage).verifyFirstNameBillingAddressValue(billingAddressChanged[0])
								.verifyLastNameBillingAddressValue(billingAddressChanged[1])
								.verifyEmailBillingAddressValue(billingAddressChanged[2])
								.verifyPhoneBillingAddressValue(billingAddressChanged[3])
								.verifyStreetBillingAddressValue(billingAddressChanged[5])
								.verifyHouseNumberBillingAddressValue(billingAddressChanged[4])
								.verifyCountryBillingAddressValue(billingAddressChanged[6])
								.verifyStateBillingAddressValue(billingAddressChanged[7])								
								.verifyCityBillingAddressValue(billingAddressChanged[8])
								.verifyZIPCodeBillingAddressValue(billingAddressChanged[9])
							 
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
								.inputEmailBillingAddress(billingAddress[2])
								.inputPhoneBillingAddress(billingAddress[3])
								.inputSearchBillingAddress(billingAddress[4], billingAddress[5], billingAddress[8], billingAddress[9], billingAddress[6])								
								.clickSaveChangesButton()
							 
println '>> verify Toast Message'
Page.nav(ToastMessage).verifyToastMessage("Success!", "Updated Account")
 					  .sleep(1)