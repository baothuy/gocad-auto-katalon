package gocad.buyer

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import katalon.fw.lib.BasePage

public class LeftNavBar extends BasePage<LeftNavBar> {
	public LeftNavBar clickAddProject() {
		WebUI.click(xpath('//span[text()=" Add Project"]'))
		return this
	}

	public LeftNavBar clickSearchInProjects() {
		WebUI.click(xpath('//span[text()="Search in projects"]'))
		return this
	}

	public LeftNavBar clickDraft() {
		WebUI.click(xpath('//a[text()="Draft"]'))
		return this
	}

	public LeftNavBar clickRequestedOffers() {
		WebUI.click(xpath('//a[text()="Requested Offers"]'))
		return this
	}

	public LeftNavBar clickReceivedOffers() {
		WebUI.click(xpath('//a[text()="Received Offers"]'))
		return this
	}

	public LeftNavBar clickConfirmedOffers() {
		WebUI.click(xpath('//a[text()="Confirmed Offers"]'))
		return this
	}

	public LeftNavBar clickCancelledOffers() {
		WebUI.click(xpath('//a[text()="Cancelled Offers"]'))
		return this
	}

	public LeftNavBar clickSettings() {
		WebUI.click(link('Settings'))
		return this
	}

	public LeftNavBar clickChangeLanguage() {
		WebUI.click(xpath('//object[@type="image/svg+xml"]'))
		return this
	}

	public LeftNavBar clickLogout() {
		WebUI.click(link('Log out'))
		return this
	}
}
