import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.seller.MaterialSettingsPage
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller go to material settings'
Page.nav(LeftNavBar).clickMaterials()

println '>> Verify show error when empty'
Page.nav(MaterialSettingsPage).clickEditSurchargeRawMaterialButton()
								.inputSurchargeRound("")
								.inputSurchargeRectangular("")
								.verifyShowErrorWhenSurchargeRoundEmpty("Surcharge raw material round is required.")
								.verifyShowErrorWhenSurchargeRectangularEmpty("Surcharge raw material rectangular is required.")
								
println '>> Verify can update value successfully'
Page.nav(MaterialSettingsPage).inputSurchargeRound(round)
								.inputSurchargeRectangular(rectangular)
								.clickAcceptChangeSurchargeRawMaterialButton()
								.verifyToastMessage("Update success!", "")