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
										   
println '>> Verify when required fields are Error'
Page.nav(PriceAndDeliverySettingsBasicPage).verifyShowErrorWhenDeliveryTimeEconomyError("Delivery time economy is required.")
											.verifyShowErrorWhenDeliveryTimeStandardError("Delivery time standard is required.")
											.verifyShowErrorWhenDeliveryTimeFastError("Delivery time fast is required.")
											.verifyShowErrorWhenSurchargeEconomyError("Surcharge economy is required.")
											.verifyShowErrorWhenSurchargeStandardError("Surcharge standard is required.")
											.verifyShowErrorWhenSurchargeFastError("Surcharge fast is required.")
											.verifyShowErrorWhenPartPriceManualThresholdError("Part Price Manual Threshold is required.")
											.verifyShowErrorWhenProjectPriceAutoThresholdError("Project Price Auto Threshold is required.")
											.verifyShowErrorWhenDeliverySurchargeError("Price surcharge for standard delivery is required.")
											.verifyShowErrorWhenNumberMaximumCalculationError("Number of free calculations for a newly registered customer is required.")
											.verifyShowErrorWhenOfferValidityError("Offer Validity (Days) is required.")