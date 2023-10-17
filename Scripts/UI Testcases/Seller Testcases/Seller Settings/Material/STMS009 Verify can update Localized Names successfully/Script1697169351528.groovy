import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.common.ToastMessage
import gocad.seller.MaterialGroupPopup
import gocad.seller.MaterialSettingsPage
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller go to material settings'
Page.nav(LeftNavBar).clickMaterials()

println '>> Verify UI material settings'
Page.nav(MaterialSettingsPage).clickMaterialGroupButton(materialName)

String materialGroup = Page.nav(MaterialSettingsPage).getMaterialGroup(materialName)

Page.nav(MaterialGroupPopup).inputLocalizedNamesEnglish(english)
							.inputLocalizedNamesGerman(german)
							.inputLocalizedNamesItalian(italian)
							.inputLocalizedNamesCzech(czech)
							.inputCuttingParams(cuttingParams)
							.clickOKButton()

Page.nav(ToastMessage).verifyToastMessage("Success!", "Material group - $materialGroup")