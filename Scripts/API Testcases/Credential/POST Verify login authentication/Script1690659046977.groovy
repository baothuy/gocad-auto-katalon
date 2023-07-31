import gocad.services.LoginService
import katalon.fw.lib.Page
import internal.GlobalVariable

'User login to get token'
Page.nav(LoginService).loginWithEncryptedPwd(GlobalVariable.seller_mail, GlobalVariable.seller_pass).verifyStatusCode(200).getToken()

'User login to get token'
Page.nav(LoginService).loginWithEncryptedPwd(GlobalVariable.buyer_mail, GlobalVariable.buyer_pass).verifyStatusCode(200).getToken()

'User login with wrong account'
Page.nav(LoginService).initRequestObject()
						.setUrl("https://api.dev.gocad.de/authenticate")
						.setJsonContentTypeHeader()
						.setPayLoad('{\"password\":\"password\",\"username\":\"account\"}')
						.sendPostRequest()
						.verifyStatusCode(403)