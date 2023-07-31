package gocad.buyer

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import katalon.fw.lib.BasePage

public class LeftNavBar extends BasePage<LeftNavBar> {
	public LeftNavBar clickAddProject() {
		WebUI.click(xpath('//span[text()=" Add Project"]'))
	}

	public LeftNavBar clickSearchInProjects() {
		WebUI.click(xpath('//span[text()="Search in projects"]'))
	}

	public LeftNavBar clickDraft() {
		WebUI.click(xpath('//a[text()="Draft"]'))
	}

	public LeftNavBar clickRequestedOffers() {
		WebUI.click(xpath('//a[text()="Requested Offers"]'))
	}

	public LeftNavBar clickReceivedOffers() {
		WebUI.click(xpath('//a[text()="Received Offers"]'))
	}

	public LeftNavBar clickConfirmedOffers() {
		WebUI.click(xpath('//a[text()="Confirmed Offers"]'))
	}

	public LeftNavBar clickCancelledOffers() {
		WebUI.click(xpath('//a[text()="Cancelled Offers"]'))
	}

	public LeftNavBar clickSettings() {
		WebUI.click(link('Settings'))
	}

	public LeftNavBar clickChangeLanguage() {
		WebUI.click(xpath('//object[@type="image/svg+xml"]'))
	}

	public LeftNavBar clickLogout() {
		WebUI.click(link('Log out'))
	}
}
