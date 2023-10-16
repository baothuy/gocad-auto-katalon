import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.seller.PriceAndDeliverySettingsLeftNavMenu
import gocad.seller.PriceAndDeliverySettingsSMFPage
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller go to Price And Delivery Settings settings'
Page.nav(LeftNavBar).clickPriceAndDeliverySettings()

Page.nav(PriceAndDeliverySettingsLeftNavMenu).clickSheetMetalFormula()

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