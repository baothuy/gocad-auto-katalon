import gocad.buyer.CustomDXFLeftNavMenu
import gocad.buyer.CustomDXFPage
import gocad.buyer.DraftPage
import gocad.common.AddProjectPopup
import gocad.common.DataUploadPage
import gocad.common.LeftNavBar
import gocad.common.ManufacturingInformationPage
import gocad.common.SignInPage
import katalon.fw.lib.Page
import katalon.utility.CommonUtility

println '>> User buyer signs in to administration page'
Page.nav(SignInPage).enterCredentialAsBuyer().changeLanguage().clickSignIn().verifySuccessfullySignInAsBuyer()

println '>> User buyer add project'
Page.nav(LeftNavBar).clickNewProject()

println '>> Random project name'
def projectName = CommonUtility.generateRandomProjectName(10)

println '>> Open add project popup and input project name'
Page.nav(DataUploadPage).clickEditProjectName(projectName)
String projectId = Page.nav(DataUploadPage).getIdProject()
println "projectId: $projectId"

println '>> click Workflow'
Page.nav(DataUploadPage).clickCustomDXF()
						
println '>> click Rectangle Shape'
Page.nav(CustomDXFLeftNavMenu).clickRectangleGasketShape()

println '>> input field "Outer width (Mm)" smaller than "Outer height (Mm)" and versa'
Page.nav(CustomDXFPage).inputFileName(fileName)
					   .inputOuterWidth("150")
					   .inputOuterHeight("160")
					   .inputInnerWidth("100")
					   .inputInnerHeight("120")
					   .inputOuterRadius("5")
					   .inputInnerRadius("3")
					   .sleep(1)

println '>> Verify error when empty field'
Page.nav(CustomDXFPage).verifyErrorWhenInputOuterHeight("Outer height (mm) must be less than 150")
					   
println '>> input field "Inner width (Mm)" equal or larger than "Outer width (Mm)"'
Page.nav(CustomDXFPage).inputFileName(fileName)
					  .inputOuterWidth("150")
					  .inputOuterHeight("140")
					  .inputInnerWidth("160")
					  .inputInnerHeight("120")
					  .inputOuterRadius("5")
					  .inputInnerRadius("3")
					  .sleep(1)
   
println '>> Verify error when empty field'
Page.nav(CustomDXFPage).verifyErrorWhenInputInnerWidth("Inner width (mm) must be less than 150")
	
				  
println '>> input field "Inner height (Mm)" larger than "Outer height (Mm)"'
Page.nav(CustomDXFPage).inputFileName(fileName)
						.inputOuterWidth("150")
						.inputOuterHeight("140")
						.inputInnerWidth("130")
						.inputInnerHeight("150")
						.inputOuterRadius("5")
						.inputInnerRadius("3")
						.sleep(1)
	 
println '>> Verify error when empty field'
Page.nav(CustomDXFPage).verifyErrorWhenInputInnerHeight("Inner height (mm) must be less than 140")
						
println '>> input field "Outer radius (Mm)" larger than (Outer height (Mm))/2'
Page.nav(CustomDXFPage).inputFileName(fileName)
						.inputOuterWidth("150")
						.inputOuterHeight("140")
						.inputInnerWidth("130")
						.inputInnerHeight("130")
						.inputOuterRadius("75")
						.inputInnerRadius("3")
						.sleep(1)
	 
println '>> Verify error when empty field'
Page.nav(CustomDXFPage).verifyErrorWhenInputOuterRadius("The outer radius should less than 70mm")
					   
println '>> input field "Radius (Mm)" larger than (Inner height (Mm))/2'
Page.nav(CustomDXFPage).inputFileName(fileName)
						.inputOuterWidth("150")
						.inputOuterHeight("140")
						.inputInnerWidth("130")
						.inputInnerHeight("130")
						.inputOuterRadius("70")
						.inputInnerRadius("66")
						.sleep(1)
	 
println '>> Verify error when empty field'
Page.nav(CustomDXFPage).verifyErrorWhenInputInnerRadius("The inner radius should less than 65mm")
									  
println '>>  Clear data'
Page.nav(LeftNavBar).clickDraft()
Page.nav(DraftPage).clickArchiveAction(projectId)
					.clickCloseToastMessage()