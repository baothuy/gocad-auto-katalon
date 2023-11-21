import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.seller.MaterialSettingsPage
import gocad.seller.MaterialSettingsPopup
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller go to material settings'
Page.nav(LeftNavBar).clickMaterials()

println '>> Click New material button'
Page.nav(MaterialSettingsPage).clickNewMaterialButton()

println '>> Click Ok button'
Page.nav(MaterialSettingsPopup).clickOKButton()

println '>> Verify show error when empty'
Page.nav(MaterialSettingsPopup).verifyShowErrorWhenMaterialGroupEmpty('Material Group is required.')
								.verifyShowErrorWhenNameEmpty('Name is required.')
								.verifyShowErrorWhenNumberEmpty('Number is required.')
								.verifyShowErrorWhenDensityEmpty('Density is required.')
								.verifyShowErrorWhenPricePerKiloEmpty('Price per Kilo is required.')