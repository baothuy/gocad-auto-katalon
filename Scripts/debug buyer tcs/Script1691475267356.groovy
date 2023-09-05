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

Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickViewAction('1716')

println '>> Verify file part can download successfully'
Page.nav(ReviewPage).clickCheckout()

println '>> Click Edit address'
Page.nav(CheckoutPage).clickEditAddress()

println '>> Input edit information successfully'
Page.nav(AddressInformationPopup).inputFirstNameBillingAddress(billingAddressChanged[0])
								.inputLastNameBillingAddress(billingAddressChanged[1])
								.inputHouseNumberBillingAddress(billingAddressChanged[2])
								.inputStreetBillingAddress(billingAddressChanged[3])
								.selectStateBillingAddress(billingAddressChanged[4])
								.inputZIPCodeBillingAddress(billingAddressChanged[5])
								.inputCityBillingAddress(billingAddressChanged[6])
								.inputFirstNameShippingAddress(shippingAddressChanged[0])
								.inputLastNameShippingAddress(shippingAddressChanged[1])
								.inputHouseNumberShippingAddress(shippingAddressChanged[2])
								.inputStreetShippingAddress(shippingAddressChanged[3])
								.selectStateShippingAddress(shippingAddressChanged[4])
								.inputZIPCodeShippingAddress(shippingAddressChanged[5])
								.inputCityShippingAddress(shippingAddressChanged[6])
								.clickOK()
List<String> listBillingAddress = [billingAddressChanged[0] + " " + billingAddressChanged[1], billingAddressChanged[2], billingAddressChanged[3], billingAddressChanged[4], billingAddressChanged[5], billingAddressChanged[6]]
List<String> listShippingAddress = [shippingAddressChanged[0] + " " + shippingAddressChanged[1], shippingAddressChanged[2], shippingAddressChanged[3], shippingAddressChanged[4], shippingAddressChanged[5], shippingAddressChanged[6]]
Page.nav(CheckoutPage).sleep(1)
					.refreshPage()
println '>> Verify after update show correctly on checkout page'
Page.nav(ReviewPage).clickCheckout()
Page.nav(CheckoutPage).verifyBillingAddress(listBillingAddress)
						.verifyShippingAddress(listShippingAddress)
						
println '>> Click Edit address'
Page.nav(CheckoutPage).clickEditAddress()

println '>> Re update old information successfully'
Page.nav(AddressInformationPopup).inputFirstNameBillingAddress(billingAddress[0])
								.inputLastNameBillingAddress(billingAddress[1])
								.inputStreetBillingAddress(billingAddress[2])
								.inputHouseNumberBillingAddress(billingAddress[3])
								.selectStateBillingAddress(billingAddress[4])
								.inputZIPCodeBillingAddress(billingAddress[5])
								.inputCityBillingAddress(billingAddress[6])
								.inputFirstNameShippingAddress(shippingAddress[0])
								.inputLastNameShippingAddress(shippingAddress[1])
								.inputStreetShippingAddress(shippingAddress[2])
								.inputHouseNumberShippingAddress(shippingAddress[3])
								.selectStateShippingAddress(shippingAddress[4])
								.inputZIPCodeShippingAddress(shippingAddress[5])
								.inputCityShippingAddress(shippingAddress[6])
								.clickOK()