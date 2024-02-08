import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.common.ToastMessage
import gocad.seller.MachineSettingsPage
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller go to Price And Delivery Settings settings'
Page.nav(LeftNavBar).clickMachines()

println '>> click Machine Name and save changes'
Page.nav(MachineSettingsPage).clickMachineName(machineName)
							 .clickSaveChangesButton()
							 .sleep(1)
	
println '>> verify Toast Message'
Page.nav(ToastMessage).verifyToastMessage("Update success!", "")