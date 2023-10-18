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

println '>> click Material Group Button'
Page.nav(MaterialSettingsPage).clickMaterialGroupButton(materialName)

println '>> get Material Group'
String materialGroup = Page.nav(MaterialSettingsPage).getMaterialGroup(materialName)

println '>> input field'
Page.nav(MaterialGroupPopup).inputLocalizedNamesEnglish(english)
							.inputLocalizedNamesGerman(german)
							.inputLocalizedNamesItalian(italian)
							.inputLocalizedNamesCzech(czech)
							.inputCuttingParams(cuttingParams)
							.clickOKButton()
							
println '>> Verify Toast message'
Page.nav(ToastMessage).verifyToastMessage("Success!", "Material group - $materialGroup")