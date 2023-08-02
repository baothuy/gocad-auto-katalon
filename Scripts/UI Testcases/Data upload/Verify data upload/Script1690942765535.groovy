import gocad.buyer.AddProjectPopup
import gocad.buyer.DataUploadPage
import gocad.buyer.LeftNavBar
import gocad.common.MySignInPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility

'1. User buyer signs in to administration page'
Page.nav(MySignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

'2. User buyer add project'
Page.nav(LeftNavBar).clickAddProject()

'3. Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

'4. Open add project popup and input project name'
Page.nav(AddProjectPopup).inputProjectName("$projectName").clickOKButton()

'5. Upload file part on Data upload page'
Page.nav(DataUploadPage).uploadFileTesting(fileName)