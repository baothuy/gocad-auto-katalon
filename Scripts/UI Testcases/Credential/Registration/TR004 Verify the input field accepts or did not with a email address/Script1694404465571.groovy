import katalon.fw.lib.Page
import gocad.common.SignInPage
import gocad.common.RegistrationPage

println '>> User click Registration tab'
Page.nav(SignInPage).openBrowser().changeLanguage().clickRegistrationTab()

println '>> Input empty on Registration page'
Page.nav(RegistrationPage).inputEmail(email)
							.clickRegistrationButton()

							
println '>> Input empty on Registration page'
Page.nav(RegistrationPage).verifyShowErrorWhenInputEmail(expectedError)
							
							