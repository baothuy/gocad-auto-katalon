import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.common.ToastMessage
import gocad.seller.PriceAndDeliverySettingsBasicPage
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller go to Price And Delivery Settings settings'
Page.nav(LeftNavBar).clickPriceAndDeliverySettings()

println '>> Verify UI page'
Page.nav(PriceAndDeliverySettingsBasicPage).inputDeliveryTimeEconomy(deliveryTimeEconomy)
										   .inputDeliveryTimeStandard(deliveryTimeStandard)
										   .inputDeliveryTimeFast(deliveryTimeFast)
										   .inputSurchargeEconomy(surchargeEconomy)
										   .inputSurchargeStandard(surchargeStandard)
										   .inputSurchargeFast(surchargeFast)
										   .inputPartPriceManualThreshold(partPriceManualThreshold)
										   .inputProjectPriceAutoThreshold(projectPriceAutoThreshold)
										   .inputPriceDeliverySurcharge(priceDeliverySurcharge)
										   .selectAutomaticCalculationToggle(status)
										   .inputNumberFreeCalculation(numberFreeCalculation)
										   .inputOfferValidity(offerValidity)
										   .clickSaveChangesButton()

println '>> Verify Toast Message'
Page.nav(ToastMessage).verifyToastMessage("Update success!", "")										   