import katalon.fw.lib.Page
import gocad.common.SignInPage
import gocad.common.RegistrationPage

println '>> User click Registration tab'
Page.nav(SignInPage).openBrowser().changeLanguage().clickRegistrationTab()

println '>> Input empty on Registration page'
Page.nav(RegistrationPage).inputPassword(password)
							.inputConfirmPassword(confirmPassword)
							
println '>> Input empty on Registration page'
Page.nav(RegistrationPage).verifyShowErrorWhenInputConfirmPassword("Confirm password do not match")
							
							