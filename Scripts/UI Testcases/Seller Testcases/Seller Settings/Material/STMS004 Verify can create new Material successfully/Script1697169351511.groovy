import gocad.common.ConfirmPopup
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.common.ToastMessage
import gocad.seller.MaterialSettingsPage
import gocad.seller.MaterialSettingsPopup
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller go to material settings'
Page.nav(LeftNavBar).clickMaterials()

println '>> Click New material button'
Page.nav(MaterialSettingsPage).clickNewMaterialButton()


Page.nav(MaterialSettingsPopup).selectMaterialGroup(materialGroup)
								.inputName(materialName)
								.inputNumber(number)
								.inputDensity(density)
								.inputPricePerKilo(pricePerKilo)
								.selectStatusToggle(status)
								.clickOKButton()

Page.nav(ToastMessage)//.verifyToastMessage("Success!", materialGroup + " - " + materialName)
						.clickCloseToastMessage()

Page.nav(MaterialSettingsPopup).clickCloseButton()

Page.nav(MaterialSettingsPage).clickMoreButton(materialName)
								.clickDeleteButton()

Page.nav(ConfirmPopup).clickOK()

Page.nav(ToastMessage)//.verifyToastMessage("Success!", materialGroup + " - " + materialName)
						.clickCloseToastMessage()