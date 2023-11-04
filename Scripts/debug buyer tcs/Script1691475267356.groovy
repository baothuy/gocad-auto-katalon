import gocad.buyer.DraftPage
import gocad.buyer.ReviewPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.SignInPage
import katalon.fw.lib.Page



println '>> FPA002 Verify seller accept offers successfully when project larger than Threshold'
println '>> Random project name'
//def projectName = CommonUtility.generateRandomProjectName(10)
//
println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickViewAction('7162')

Page.nav(ReviewPage).clickManufacturingInformationProcess()

println '>> input and verify after update Bulk Pricing'
Page.nav(ManufacturingInformationPage).inputBulkPricing("3", "160")
									  .sleep(1)
									  .clickAcceptChangeBulkPricing()
									  .verifyBulkPricingValue("3", "160")
						
