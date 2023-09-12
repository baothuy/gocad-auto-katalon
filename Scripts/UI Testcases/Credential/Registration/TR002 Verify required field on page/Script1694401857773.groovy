import katalon.fw.lib.Page
import gocad.common.MySignInPage
import gocad.common.RegistrationPage

println '>> User click Registration tab'
Page.nav(MySignInPage).openBrowser().changeLanguage().clickRegistrationTab()

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
Page.nav(RegistrationPage).verifyShowErrorWhenInputEmail("Email is required.")
							.verifyShowErrorWhenInputPassword("Password is required.")
							.verifyShowErrorWhenInputConfirmPassword("Passwords do NOT match")
							.verifyShowErrorWhenInputFirstName("First Name is required.")
							.verifyShowErrorWhenInputLastName("Last Name is required.")
							.verifyShowErrorWhenInputPhone("Phone is required.")
							.verifyShowErrorWhenInputCompanyName("Company Name is required.")
							.sleep(1)
							
							