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

Page.nav(SurfaceTreatmentsSettingPage).verifyUIPage()
										.clickEditButton(method)

Page.nav(SurfaceTreatmentsSettingPopup).verifyInputLocalizedNamesEnglishVisible()
										.verifyInputLocalizedNamesGermanVisible()
										.verifyInputLocalizedNamesItalianVisible()
										.verifyInputLocalizedNamesCzechVisible()
										.verifyInputAbbrVisible()
										.verifyInputPricePerAreaVisible()
										.verifyInputPricePerKiloVisible()
										.verifyInputSetupCostVisible()
										.verifyInputMinOrderVisible()
										.verifyInputDeliveryWeekVisible()
										.verifyInpuTransportationCost()
										.verifySelectStatusToggleVisible()
										.verifyOKButtonVisible()
										.verifyCancelButtonVisible()									