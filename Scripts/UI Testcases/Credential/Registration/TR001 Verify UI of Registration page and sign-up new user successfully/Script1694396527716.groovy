import gocad.common.SignInPage
import gocad.common.RegistrationPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility

println '>> User click Registration tab'
Page.nav(SignInPage).openBrowser().changeLanguage().clickRegistrationTab()

String randomEmail = CommonUtility.mergeRandomEmail(email, 5)
println '>> Verify page Registration UI Visible'
Page.nav(RegistrationPage).verifyUIVisible()
							.inputEmail(randomEmail)
							.inputPassword(password)
							.inputConfirmPassword(confirmPassword)
							.inputFirstName(firstName)
							.inputLastName(lastName)
							.inputPhone(phone)
							.inputCompanyName(companyName)
							.inputVatNumber(vatNumber)
							.clickRegistrationButton()
							.verifyRegisterSuccessfully()
							


							
							