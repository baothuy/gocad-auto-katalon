import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.common.ToastMessage
import gocad.seller.PriceAndDeliverySettingsLeftNavMenu
import gocad.seller.PriceAndDeliverySettingsMTFPage
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller go to Price And Delivery Settings settings'
Page.nav(LeftNavBar).clickPriceAndDeliverySettings()

Page.nav(PriceAndDeliverySettingsLeftNavMenu).clickMillingAndTurningFormula()

Page.nav(PriceAndDeliverySettingsMTFPage).inputFactorManual(factorManual)
										 .inputProgrammingHourRate(programmingHourRate)
										 .inputGeneralAdminAdditions(generalAdminAdditions)
										 .inputGeneralSalesAdditions(generalSalesAdditions)
										 .inputFaultyPartsRiskAdditions(faultyPartsRiskAdditions)
										 .inputMarginValue(marginValue)
										 .inputMarginSurfaceTreat(marginSurfaceTreat)
										 .inputRawMaterialAdditions(rawMaterialAdditions)
										 .inputProcessCostAdditions(processCostAdditions)
										 .inputInBetweenTemperingCost(inBetweenTemperingCost)
										 .clickSaveChangesButton()
										 
Page.nav(PriceAndDeliverySettingsMTFPage).verifyShowErrorWhenFactorManualEmpty("Factor manual is required.")
										 .verifyShowErrorWhenProgrammingHourRateEmpty("Programming hour rate is required.")
										 .verifyShowErrorWhenGeneralAdminAdditionsEmpty("General admin additions is required.")
										 .verifyShowErrorWhenGeneralSalesAdditionsEmpty("General sales additions is required.")
										 .verifyShowErrorWhenFaultyPartsRiskAdditionsEmpty("Faulty parts risk additions is required.")
										 .verifyShowErrorWhenMarginValueEmpty("Margin is required.")
										 .verifyShowErrorWhenMarginSurfaceTreatEmpty("Margin surface treat is required.")
										 .verifyShowErrorWhenRawMaterialAdditionsEmpty("Raw material additions is required.")
										 .verifyShowErrorWhenProcessCostAdditionsEmpty("Process cost additions is required.")
										 .verifyShowErrorWhenInBetweenTemperingCostEmpty("In Between Tempering Cost is required.")