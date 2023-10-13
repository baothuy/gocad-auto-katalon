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
										 
Page.nav(ToastMessage).verifyToastMessage("Update success!", "")