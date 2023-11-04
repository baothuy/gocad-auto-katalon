import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.seller.MaterialSettingsPage
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller go to material settings'
Page.nav(LeftNavBar).clickMaterials()

println '>> Click New material button'
Page.nav(MaterialSettingsPage).clickNewMaterialButton()