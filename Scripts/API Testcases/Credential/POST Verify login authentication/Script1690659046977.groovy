import gocad.services.LoginService
import katalon.fw.lib.Page
import internal.GlobalVariable

'User login to get token'
Page.nav(LoginService).loginWithEncryptedPwd(GlobalVariable.seller_mail, GlobalVariable.seller_pass).verifyStatusCode(200).getToken()
