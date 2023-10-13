import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.common.ToastMessage
import gocad.seller.SurfaceTreatmentsSettingPage
import gocad.seller.SurfaceTreatmentsSettingPopup
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller go to surface treatment settings'
Page.nav(LeftNavBar).clickSurfaceTreatments()

Page.nav(SurfaceTreatmentsSettingPage).clickEditButton(method)

Page.nav(SurfaceTreatmentsSettingPopup).inputLocalizedNamesEnglish(english)
										.inputLocalizedNamesGerman(german)
										.inputLocalizedNamesItalian(italian)
										.inputLocalizedNamesCzech(czech)
										.inputAbbr(abbr)
										.inputPricePerArea(pricePerArea)
										.inputPricePerKilo(pricePerKilo)
										.inputSetupCost(setupCost)
										.inputMinOrder(minOrder)
										.inputDeliveryWeek(deliveryWeek)
										.inpuTransportationCost(transportationCost)
										.selectStatusToggle(status)
										.clickOKButton()
										
Page.nav(ToastMessage).verifyToastMessage("Update success!", "Surface treatment - Soft annealing")