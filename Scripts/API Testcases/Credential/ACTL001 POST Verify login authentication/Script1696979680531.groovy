import gocad.services.common.LoginService
import internal.GlobalVariable
import katalon.fw.lib.Page

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