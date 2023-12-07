import gocad.common.LeftNavBar
import gocad.common.SignInPage
import gocad.seller.MaterialSettingsPage
import katalon.fw.lib.Page

println '>> User Seller signs in to administration page'
Page.nav(SignInPage).enterCredentialAsSeller().changeLanguage().clickSignIn().verifySuccessfullySignInAsSeller()

println '>> User Seller go to material settings'
Page.nav(LeftNavBar).clickMaterials()

println '>> Search material button'
Page.nav(MaterialSettingsPage).inputSearchMaterial(materialGroup)

println '>> Get data row'
List<String> dataRow = Page.nav(MaterialSettingsPage).getDataRow('1')
String materialNameRow = dataRow[3]

println '>> Verify search data'
Page.nav(MaterialSettingsPage).verifyIdValue(materialNameRow, dataRow[0])
								.verifyMaterialGroupValue(materialNameRow, materialGroup)
								.verifyCuttingParamsValue(materialNameRow, dataRow[2])
								.verifyMaterialNameValue(materialNameRow)
								.verifyNumberValue(materialNameRow, dataRow[4])
								.verifyDensityValue(materialNameRow, dataRow[5])
								.verifyPricePerKiloValue(materialNameRow, dataRow[6])
								.verifyShopTypeValue(materialNameRow, dataRow[7])
								.verifyStatusValue(materialNameRow, dataRow[8])								
								
println '>> Search material button'
Page.nav(MaterialSettingsPage).inputSearchMaterial(materialName)

println '>> Get data row'
List<String> dataRowOne = Page.nav(MaterialSettingsPage).getDataRow('1')

println '>> Verify search data'
Page.nav(MaterialSettingsPage).verifyIdValue(materialName, dataRowOne[0])
								.verifyMaterialGroupValue(materialName, dataRowOne[1])
								.verifyCuttingParamsValue(materialName, dataRowOne[2])
								.verifyMaterialNameValue(materialName)
								.verifyNumberValue(materialName, dataRowOne[4])
								.verifyDensityValue(materialName, dataRowOne[5])
								.verifyPricePerKiloValue(materialName, dataRowOne[6])
								.verifyShopTypeValue(materialName, dataRowOne[7])
								.verifyStatusValue(materialName, dataRowOne[8])