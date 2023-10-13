import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import gocad.seller.MaterialSettingsPage
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller go to material settings'
Page.nav(LeftNavBar).clickMaterials()

println '>> Verify show error when empty'
Page.nav(MaterialSettingsPage).clickCSVImportButton()
								.uploadFileTesting(fileName)
								.verifyToastMessage("Import success!", "Done!")
								