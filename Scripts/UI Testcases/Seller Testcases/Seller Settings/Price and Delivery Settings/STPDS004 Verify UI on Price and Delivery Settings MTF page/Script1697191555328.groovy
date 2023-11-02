import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.seller.PriceAndDeliverySettingsLeftNavMenu
import gocad.seller.PriceAndDeliverySettingsMTFPage
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller go to Price And Delivery Settings settings'
Page.nav(LeftNavBar).clickPriceAndDeliverySettings()

println '>> click Milling And Turning Formula'
Page.nav(PriceAndDeliverySettingsLeftNavMenu).clickMillingAndTurningFormula()
		
println '>> verify UI visible'
Page.nav(PriceAndDeliverySettingsMTFPage).verifyInputFactorManualVisible()
										 .verifyInputProgrammingHourRateVisible()
										 .verifyInputGeneralAdminAdditionsVisible()
										 .verifyInputGeneralSalesAdditionsVisible()
										 .verifyInputFaultyPartsRiskAdditionsVisible()
										 .verifyInputMarginValueVisible()
										 //.verifyInputMarginSurfaceTreatVisible()
										 .verifyInputRawMaterialAdditionsVisible()
										 .verifyInputProcessCostAdditionsVisible()
										 .verifyInputInBetweenTemperingCostVisible()
										 .verifyPreviewPricesButtonVisible()
										 .verifySaveChangesButtonVisible()