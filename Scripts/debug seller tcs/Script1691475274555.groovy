import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.seller.AssignJobPopup
import gocad.seller.OpenJobsPage
import gocad.seller.SearchJobs
import katalon.fw.lib.Page


println '>> User buyer signs in page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

Page.nav(LeftNavBar).clickOpenJobs()

Page.nav(SearchJobs).inputEmail("thuyautomation0@gmail.com")
					.inputStartDate("2024-03-01")
					.inputEndDate("2024-03-31")
					.selectSortBy("Name")

Page.nav(OpenJobsPage).clickFirstJobsToAssign()
						.clickAssign()

Page.nav(AssignJobPopup).inputDeliveryDate("2024-06-01")
						.clickAcceptChange()
						.inputSupplierPrice("60")
						.clickAcceptChange()
						
Page.nav(AssignJobPopup).selectAssignType("supplier_group")
						.selectSupplierGroup("Supplier Group 2")
						
Page.nav(AssignJobPopup).selectAssignType("supplier")
						.selectSupplier("Company Supplier1")
						.clickCancel()
						



