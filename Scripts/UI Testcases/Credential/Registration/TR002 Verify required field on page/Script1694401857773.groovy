import katalon.fw.lib.Page
import gocad.common.SignInPage
import gocad.common.RegistrationPage

println '>> User click Registration tab'
Page.nav(SignInPage).openBrowser().changeLanguage().clickRegistrationTab()

println '>> Input empty on Registration page'
Page.nav(RegistrationPage).inputEmail("")
							.inputPassword("")
							.inputConfirmPassword("")
							.inputFirstName("")
							.inputLastName("")
							.inputPhone("")
							.inputCompanyName("")
							.clickRegistrationButton()
							
println '>> Input empty on Registration page'
Page.nav(RegistrationPage).verifyShowErrorWhenInputEmail("E-mail is required.")
							.verifyShowErrorWhenInputPassword("Password is required.")
							.verifyShowErrorWhenInputConfirmPassword("Confirm password do not match")
							.verifyShowErrorWhenInputFirstName("Firstname is required.")
							.verifyShowErrorWhenInputLastName("Lastname is required.")
							.verifyShowErrorWhenInputPhone("Phone is required.")
							.verifyShowErrorWhenInputCompanyName("Company is required.")
							.sleep(1)
							
							