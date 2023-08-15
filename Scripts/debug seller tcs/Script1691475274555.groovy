import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.MySignInPage
import gocad.seller.MyProjectsPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility


println '>> FPA002 Verify seller accept offers successfully when project larger than Threshold'
println '>> Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>> User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>>  User buyer add project'
Page.nav(LeftNavBar).clickMyProjects()

Page.nav(MyProjectsPage).clickAction('985')

Page.nav(ManufacturingInformationPage).inputDeliveryDate(deliveryDate).clickContinueToOfferOverview()

