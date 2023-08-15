import gocad.buyer.DataUploadPage
import gocad.buyer.DraftPage
import gocad.buyer.ManufacturingInformationPage
import gocad.buyer.ReviewPage
import gocad.buyer.SelectMaterialPopup
import gocad.common.LeftNavBar
import gocad.common.MySignInPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility


println '>> FPA002 Verify seller accept offers successfully when project larger than Threshold'
println '>> Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>> User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>>  User buyer add project'
Page.nav(LeftNavBar).clickDraft()

Page.nav(DraftPage).clickAction('Project z71ewwkyEL')

println '>> Click get infor and Checkout button on Review Page'
List<String> tablePart = Page.nav(ReviewPage).getTablePartReview(fileName)
println "tablePart: $tablePart"
Page.nav(ReviewPage).clickCheckout()