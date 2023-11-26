import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.SignInPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility



println '>> FPA002 Verify seller accept offers successfully when project larger than Threshold'
println '>> Random project name'
//def projectName = CommonUtility.generateRandomProjectName(10)
//
println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>>  User buyer add project'
Page.nav(LeftNavBar).clickAddProject()

println '>>  Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

Page.nav(DataUploadPage).clickEditProjectName(projectName).sleep(3)

//println '>>  Open add project popup and input project name'
//Page.nav(AddProjectPopup).inputProjectName("$projectName").clickOKButton()


						