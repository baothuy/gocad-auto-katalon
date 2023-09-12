import katalon.fw.lib.Page
import gocad.common.MySignInPage
import gocad.common.RegistrationPage

println '>> User click Registration tab'
Page.nav(MySignInPage).openBrowser().changeLanguage().clickRegistrationTab()

println '>> Input empty on Registration page'
Page.nav(RegistrationPage).inputPassword(password)
							.inputConfirmPassword(confirmPassword)
							
println '>> Input empty on Registration page'
Page.nav(RegistrationPage).verifyShowErrorWhenInputConfirmPassword("Passwords do NOT match")
							
							