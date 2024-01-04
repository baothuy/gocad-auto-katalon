package gocad.services.seller

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable
import katalon.fw.lib.BaseService

public class MaterialSettingsService extends BaseService<MaterialSettingsService>{
	static String exportUrl = GlobalVariable.myApi + "/materials/export";

	public MaterialSettingsService exportCSV () {
		initRequestObject().setBearerAuthorizationHeader().get(exportUrl)
		return this
	}
}