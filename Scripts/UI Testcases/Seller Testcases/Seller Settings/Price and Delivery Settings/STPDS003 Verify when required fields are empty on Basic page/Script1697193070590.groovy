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
										   
println '>> Verify when required fields are empty'
Page.nav(PriceAndDeliverySettingsBasicPage).verifyShowErrorWhenDeliveryTimeEconomyEmpty("Delivery time economy is required.")
											.verifyShowErrorWhenDeliveryTimeStandardEmpty("Delivery time standard is required.")
											.verifyShowErrorWhenDeliveryTimeFastEmpty("Delivery time fast is required.")
											.verifyShowErrorWhenSurchargeEconomyEmpty("Surcharge economy is required.")
											.verifyShowErrorWhenSurchargeStandardEmpty("Surcharge standard is required.")
											.verifyShowErrorWhenSurchargeFastEmpty("Surcharge fast is required.")
											.verifyShowErrorWhenPartPriceManualThresholdEmpty("Part Price Manual Threshold is required.")
											.verifyShowErrorWhenProjectPriceAutoThresholdEmpty("Project Price Auto Threshold is required.")
											.verifyShowErrorWhenDeliverySurchargeEmpty("Price surcharge for standard delivery is required.")
											.verifyShowErrorWhenNumberMaximumCalculationEmpty("Number of free calculations for a newly registered customer is required.")
											.verifyShowErrorWhenOfferValidityEmpty("Offer Validity (Days) is required.")