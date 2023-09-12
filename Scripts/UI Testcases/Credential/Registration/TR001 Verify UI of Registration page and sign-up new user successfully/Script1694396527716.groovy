import katalon.fw.lib.Page

import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

import gocad.common.MySignInPage
import gocad.common.RegistrationPage

println '>> User click Registration tab'
Page.nav(MySignInPage).openBrowser().changeLanguage().clickRegistrationTab()

println '>> Verify page Registration UI Visible'
Page.nav(RegistrationPage).verifyUIVisible()


							
							