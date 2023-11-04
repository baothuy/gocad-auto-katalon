import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.seller.PriceAndDeliverySettingsLeftNavMenu
import gocad.seller.PriceAndDeliverySettingsSMFPage
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller go to Price And Delivery Settings settings'
Page.nav(LeftNavBar).clickPriceAndDeliverySettings()

println '>> click Sheet Metal Formula'
Page.nav(PriceAndDeliverySettingsLeftNavMenu).clickSheetMetalFormula()

println '>> verify UI Visible'
Page.nav(PriceAndDeliverySettingsSMFPage).verifySaveChangesButtonVisible()
										 .verifyPreviewPricesButtonVisible()
										 .verifyInputTransportAdditionsVisible()
										 .verifyInputDistributionTimeAdditionsVisible()
										 .verifyInputPersonalTimeAdditionsVisible()
										 .verifyInputTechnicalDiscussionsVisible()
										 .verifyInputGeneralAdminVisible()
										 .verifyInputGeneralSalesVisible()
										 .verifyInputMarginVisible()
										 .verifyInputMaterialAdditionsVisible()
										 .verifyInputManufacturingAdditionsVisible()