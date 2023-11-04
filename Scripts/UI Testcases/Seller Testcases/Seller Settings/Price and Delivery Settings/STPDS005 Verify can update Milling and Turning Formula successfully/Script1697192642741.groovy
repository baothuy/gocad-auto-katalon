import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.common.ToastMessage
import gocad.seller.PriceAndDeliverySettingsLeftNavMenu
import gocad.seller.PriceAndDeliverySettingsMTFPage
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller go to Price And Delivery Settings settings'
Page.nav(LeftNavBar).clickPriceAndDeliverySettings()

println '>> click Milling And Turning Formula'
Page.nav(PriceAndDeliverySettingsLeftNavMenu).clickMillingAndTurningFormula()

println '>> inpun field'
Page.nav(PriceAndDeliverySettingsMTFPage).inputFactorManual(factorManual)
										 .inputProgrammingHourRate(programmingHourRate)
										 .inputGeneralAdminAdditions(generalAdminAdditions)
										 .inputGeneralSalesAdditions(generalSalesAdditions)
										 .inputFaultyPartsRiskAdditions(faultyPartsRiskAdditions)
										 .inputMarginValue(marginValue)
										 //.inputMarginSurfaceTreat(marginSurfaceTreat)
										 .inputRawMaterialAdditions(rawMaterialAdditions)
										 .inputProcessCostAdditions(processCostAdditions)
										 .inputInBetweenTemperingCost(inBetweenTemperingCost)
										 .clickSaveChangesButton()

println '>> verify Toast Message'
Page.nav(ToastMessage).verifyToastMessage("Update success!", "")