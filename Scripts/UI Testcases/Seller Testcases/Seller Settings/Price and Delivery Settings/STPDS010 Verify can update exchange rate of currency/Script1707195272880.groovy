import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.common.ToastMessage
import gocad.seller.PriceAndDeliverySettingsCurrency
import gocad.seller.PriceAndDeliverySettingsLeftNavMenu
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller go to Price And Delivery Settings settings'
Page.nav(LeftNavBar).clickPriceAndDeliverySettings()

println '>> click Sheet Metal Formula'
Page.nav(PriceAndDeliverySettingsLeftNavMenu).clickCurrency()

Page.nav(PriceAndDeliverySettingsCurrency).clickEditButton(isoCode)
											.inputExchangeRate(exchangeRateChanged)
											.clickAcceptChangeButton()

Page.nav(ToastMessage).verifyToastMessage("Success!", "Exchange Rate!")
											.refreshPage()
											
println '>> click Sheet Metal Formula'
Page.nav(PriceAndDeliverySettingsLeftNavMenu).clickCurrency()
											
Page.nav(PriceAndDeliverySettingsCurrency).verifyExchangeRateValue(isoCode, exchangeRateChanged)

Page.nav(PriceAndDeliverySettingsCurrency).clickEditButton(isoCode)
											.inputExchangeRate(exchangeRate)
											.clickAcceptChangeButton()