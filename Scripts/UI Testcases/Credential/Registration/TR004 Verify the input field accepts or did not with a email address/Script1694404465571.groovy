import katalon.fw.lib.Page
import gocad.common.MySignInPage
import gocad.common.RegistrationPage

println '>> User click Registration tab'
Page.nav(MySignInPage).openBrowser().changeLanguage().clickRegistrationTab()

println '>> Input empty on Registration page'
Page.nav(RegistrationPage).inputEmail(email)
							.clickRegistrationButton()

							
println '>> Input empty on Registration page'
Page.nav(RegistrationPage).verifyShowErrorWhenInputEmail(expectedError)
							
							