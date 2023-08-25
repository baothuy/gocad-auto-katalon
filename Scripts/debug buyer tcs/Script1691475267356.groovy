import gocad.buyer.DraftPage
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

String projName = Page.nav(DraftPage).getProjectName('1371')

Page.nav(DraftPage).clickArchiveAction('1371')
					.verifyToastMessageWhenArchivedProject(projName)