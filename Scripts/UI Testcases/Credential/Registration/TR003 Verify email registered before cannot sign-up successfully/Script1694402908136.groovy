import katalon.fw.lib.Page
import gocad.common.MySignInPage
import gocad.common.RegistrationPage

println '>> User click Registration tab'
Page.nav(MySignInPage).openBrowser().changeLanguage().clickRegistrationTab()

println '>> Input empty on Registration page'
Page.nav(RegistrationPage).inputEmail(email)
							.inputPassword(password)
							.inputConfirmPassword(confirmPassword)
							.inputFirstName(firstName)
							.inputLastName(lastName)
							.inputPhone(phone)
							.inputCompanyName(companyName)
							.clickRegistrationButton()
							
println '>> Input empty on Registration page'
Page.nav(RegistrationPage).verifyShowErrorAlert("The user already exists.")
							
							