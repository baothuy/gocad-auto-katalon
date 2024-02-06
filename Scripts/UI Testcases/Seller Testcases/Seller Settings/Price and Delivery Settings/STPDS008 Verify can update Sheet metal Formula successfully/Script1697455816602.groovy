import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.common.ToastMessage
import gocad.seller.PriceAndDeliverySettingsLeftNavMenu
import gocad.seller.PriceAndDeliverySettingsSMFPage
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller go to Price And Delivery Settings settings'
Page.nav(LeftNavBar).clickPriceAndDeliverySettings()

println '>> click Sheet Metal Formula'
Page.nav(PriceAndDeliverySettingsLeftNavMenu).clickSheetMetalFormula()

println '>> input field'
Page.nav(PriceAndDeliverySettingsSMFPage).inputTransportAdditions(transportAdditions)
										 .inputDistributionTimeAdditions(distributionTimeAdditions)
										 .inputPersonalTimeAdditions(personalTimeAdditions)
										 .inputTechnicalDiscussions(technicalDiscussions)
										 .inputGeneralAdmin(generalAdmin)
										 .inputGeneralSales(generalSales)
										 .inputMargin(margin)
										 .inputMaterialAdditions(materialAdditions)
										 .inputManufacturingAdditions(manufacturingAdditions)
										 .inputCostPerHoleThreshold(costPerHoleThreshold)
										 .inputCostPerHoleUnderThreshold(costPerHoleUnderThreshold)
										 .inputCostPerHoleOverThreshold(costPerHoleOverThreshold)
										 .clickSaveChangesButton()
										 
println '>> verify Toast Message'
Page.nav(ToastMessage).verifyToastMessage("Update success!", "")