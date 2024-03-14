import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.common.ToastMessage
import gocad.seller.SurfaceTreatmentsSettingPage
import gocad.seller.SurfaceTreatmentsSettingPopup
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller go to surface treatment settings'
Page.nav(LeftNavBar).clickSurfaceTreatments()

println '>> click Edit Button'
Page.nav(SurfaceTreatmentsSettingPage).clickEditButton(method)

println '>> input field'
Page.nav(SurfaceTreatmentsSettingPopup).inputLocalizedNamesGerman(german)
										.inputLocalizedNamesEnglish(englishChanged)
										.inputLocalizedNamesItalian(italian)
										.inputLocalizedNamesCzech(czech)
										.inputLocalizedNamesHungarian(hungarian)
										.inputAbbr(abbr)
										.inputPricePerArea(pricePerArea)
										.inputPricePerKilo(pricePerKilo)
										.inputSetupCost(setupCost)
										.inputMinOrder(minOrder)
										.inputDeliveryWeek(deliveryWeek)
										.inpuTransportationCost(transportationCost)
										.selectStatusToggle(status)
										.clickOKButton()

println '>> verify Toast Message'
Page.nav(ToastMessage).verifyToastMessage("Update success!", "Surface treatment - Soft annealing abc")
						.refreshPage()
						.sleep(2)
						
println '>> verify data after updated'
//Page.nav(SurfaceTreatmentsSettingPage).verifyAfterDataUpdated(abbr, method, pricePerArea, pricePerKilo, setupCost, minOrder, deliveryWeek)
Page.nav(SurfaceTreatmentsSettingPage).verifyMethodValue(englishChanged)
						
println '>> click Edit Button'
Page.nav(SurfaceTreatmentsSettingPage).clickEditButton(englishChanged)

println '>> input field again'
Page.nav(SurfaceTreatmentsSettingPopup).inputLocalizedNamesEnglish(method)
										.clickOKButton()
