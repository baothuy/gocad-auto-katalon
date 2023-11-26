import gocad.buyer.CheckoutPage
import gocad.buyer.DraftPage
import gocad.buyer.ReviewPage
import gocad.common.SignInPage
import katalon.fw.lib.Page
import katalon.utility.FileHelper




println '>> FPA002 Verify seller accept offers successfully when project larger than Threshold'
println '>> Random project name'
//def projectName = CommonUtility.generateRandomProjectName(10)
//
println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>>  User buyer add project'
Page.nav(DraftPage).clickViewAction('16838')

Page.nav(ReviewPage).clickCheckout()

Page.nav(CheckoutPage).clickPreviewOfferToDownload()

String projectName = 'Auto Generate Prj kXrASs5vnB'

Page.nav(FileHelper).verifyFileDownloaded(projectName +'.pdf')


						