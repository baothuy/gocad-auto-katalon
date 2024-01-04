import katalon.fw.lib.Page
import gocad.common.SignInPage
import gocad.common.RegistrationPage

println '>> User click Registration tab'
Page.nav(SignInPage).openBrowser().changeLanguage().clickRegistrationTab()

println '>> Input empty on Registration page'
Page.nav(RegistrationPage).inputPassword(password)
							
println '>> Input empty on Registration page'
Page.nav(RegistrationPage).verifyShowErrorWhenInputPassword("Password must contain at least 8 characters, at least 1 uppercase letter, 1 lowercase letter")
							
							