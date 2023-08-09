import gocad.buyer.DraftPage
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import katalon.fw.lib.Page

'1. User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

//'get Company Name on setting'
//Page.nav(LeftNavBar).clickSettings()
//String companyName = Page.nav(SettingsPage).getCompanyName()
//println "companyName: $companyName"

'debug. select project'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickAction('Project 578X4cNyl7')

//Page.nav(ConfirmedOffersPageOfBuyer).verifyHighlightOnList('684')
//									.verifyProjectName('684', 'Project um20Zq7NMu')
//									.verifyDeliveryDate('684', '09/26/2023')
//									.verifyOrderNumber('684')
//									.verifyGrossTotal('684', '375,30 €')
//									.verifyStatus('684', "Order confirmed")