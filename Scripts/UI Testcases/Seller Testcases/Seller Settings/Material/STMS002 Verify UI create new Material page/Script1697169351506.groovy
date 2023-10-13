import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.seller.MaterialSettingsPage
import gocad.seller.MaterialSettingsPopup
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller go to material settings'
Page.nav(LeftNavBar).clickMaterials()

println '>> Verify UI material settings'
Page.nav(MaterialSettingsPage).clickNewMaterialButton()

Page.nav(MaterialSettingsPopup).verifyUIVisible()