import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.common.ToastMessage
import gocad.seller.PriceAndDeliverySettingsLeftNavMenu
import gocad.seller.PriceAndDeliverySettingsSMFPage
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller go to Price And Delivery Settings settings'
Page.nav(LeftNavBar).clickPriceAndDeliverySettings()

Page.nav(PriceAndDeliverySettingsLeftNavMenu).clickSheetMetalFormula()

Page.nav(PriceAndDeliverySettingsSMFPage).inputTransportAdditions(transportAdditions)
										 .inputDistributionTimeAdditions(distributionTimeAdditions)
										 .inputPersonalTimeAdditions(personalTimeAdditions)
										 .inputTechnicalDiscussions(technicalDiscussions)
										 .inputGeneralAdmin(generalAdmin)
										 .inputGeneralSales(generalSales)
										 .inputMargin(margin)
										 .inputMaterialAdditions(materialAdditions)
										 .inputManufacturingAdditions(manufacturingAdditions)
										 
Page.nav(PriceAndDeliverySettingsSMFPage).verifyShowErrorWhenTransportAdditionsError("Transport Additions is required.")
										 .verifyShowErrorWhenDistributionTimeAdditionsError("Distribution Time Additions is required.")
										 .verifyShowErrorWhenPersonalTimeAdditionsError("Persional Time Additions is required.")
										 .verifyShowErrorWhenTechnicalDiscussionsError("Technical Discussions is required.")
										 .verifyShowErrorWhenGeneralAdminError("General Admin is required.")
										 .verifyShowErrorWhenGeneralSalesError("General Sales is required.")
										 .verifyShowErrorWhenMarginError("Margin is required.")
										 .verifyShowErrorWhenMaterialAdditionsError("Material Additions is required.")
										 .verifyShowErrorWhenManufacturingAdditionsError("Manufacturing Addition is required.")