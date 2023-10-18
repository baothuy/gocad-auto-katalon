import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.seller.MaterialSettingsPage
import gocad.seller.MaterialGroupPopup
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller go to material settings'
Page.nav(LeftNavBar).clickMaterials()

println '>> Click Material Group Button'
Page.nav(MaterialSettingsPage).clickMaterialGroupButton(materialName)

println '>> Verify UI material group'
Page.nav(MaterialGroupPopup).verifyInputLocalizedNamesEnglishVisible()
							.verifyInputLocalizedNamesGermanVisible()
							.verifyInputLocalizedNamesItalianVisible()
							.verifyInputLocalizedNamesCzechVisible()
							.verifyInputCuttingParamsVisible()
							.verifyOKButtonVisible()
							.verifyCancelButtonVisible()