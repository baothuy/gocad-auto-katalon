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
								.selectCompliances(compliances)
								.selectShopType(shopType)
								.selectStatusToggle(status)
								.clickOKButton()
								
println '>> Verify create New material Success'
Page.nav(ToastMessage).verifyToastMessage("Success!", "Material" + " - " + materialName)
						.clickCloseToastMessage()
						
println '>> Verify create thickness material success'
Page.nav(MaterialSettingsPopup).inputThickness(thickness)
								.inputPricePerKiloInThickness(pricePerKiloThickness)
								.clickAddNewThickness()
								.verifyThicknessValue(thickness)
								
println '>> Verify create raw material success'
Page.nav(MaterialSettingsPopup).selectShapeType(shapeType)
								.inputDiameter(diameter)
								.inputHeight(height)
								.clickAddNewRawMaterial()
								.verifyThicknessValue(thickness)
								.verifyTypeValue(shapeType)
								.verifyDiameterValue(diameter)
								.verifyHeightValue(height)

println '>> close popup create new material'
Page.nav(MaterialSettingsPopup).clickCloseButton()

Page.nav(MaterialSettingsPage).inputSearchMaterial(materialName)

Page.nav(MaterialSettingsPage).clickMoreButton(materialName)
								.clickDeleteButton()

Page.nav(ConfirmPopup).verifyTitleConfirmPopup("Delete Order")
						.verifyContentConfirmPopup("Are you sure to delete this material? The material will not be restored.")
						.clickOK()

Page.nav(ToastMessage).verifyToastMessage("Deleted", "Deleted successfully.")
						.clickCloseToastMessage()