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
										 
Page.nav(PriceAndDeliverySettingsMTFPage).verifyShowErrorWhenFactorManualError("Factor manual is required.")
										 .verifyShowErrorWhenProgrammingHourRateError("Programming hour rate is required.")
										 .verifyShowErrorWhenGeneralAdminAdditionsError("General admin additions is required.")
										 .verifyShowErrorWhenGeneralSalesAdditionsError("General sales additions is required.")
										 .verifyShowErrorWhenFaultyPartsRiskAdditionsError("Faulty parts risk additions is required.")
										 .verifyShowErrorWhenMarginValueError("Margin is required.")
										 .verifyShowErrorWhenMarginSurfaceTreatError("Margin surface treat is required.")
										 .verifyShowErrorWhenRawMaterialAdditionsError("Raw material additions is required.")
										 .verifyShowErrorWhenProcessCostAdditionsError("Process cost additions is required.")
										 .verifyShowErrorWhenInBetweenTemperingCostError("In Between Tempering Cost is required.")