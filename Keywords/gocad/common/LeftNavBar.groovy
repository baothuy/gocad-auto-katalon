package gocad.common

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
		WebUI.click(xpath('//a[text()="Requested"]'))
		return this
	}

	public LeftNavBar clickReceivedOffers() {
		WebUI.click(xpath('//a[text()="Received"]'))
		return this
	}

	public LeftNavBar clickOpenInquiries() {
		WebUI.click(xpath('//a[text()="Open inquiries"]'))
		return this
	}

	public LeftNavBar clickSentOffers() {
		WebUI.click(xpath('//a[text()="Sent"]'))
		return this
	}

	public LeftNavBar clickConfirmedOffers() {
		WebUI.click(xpath('//a[text()="Confirmed"]'))
		return this
	}

	public LeftNavBar clickCancelledOffers() {
		WebUI.click(xpath('//a[text()="Cancelled"]'))
		return this
	}

	public LeftNavBar clickSettings() {
		WebUI.click(link('Settings'))
		return this
	}

	public LeftNavBar clickArchivedProjects() {
		WebUI.click(link('Archived Projects'))
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

	public LeftNavBar clickMyProjects() {
		WebUI.click(xpath('//a[text()="My Projects"]'))
		return this
	}

	public LeftNavBar clickCustomerOverview() {
		WebUI.click(xpath('//a[text()="Customer Overview"]'))
		return this
	}

	public LeftNavBar clickMaterials() {
		WebUI.click(link('Materials'))
		return this
	}

	public LeftNavBar clickMachines() {
		WebUI.click(link('Machines'))
		return this
	}

	public LeftNavBar clickSurfaceTreatments() {
		WebUI.click(link('Surface Treatments'))
		return this
	}

	public LeftNavBar clickPriceAndDeliverySettings() {
		WebUI.click(link('Price and Delivery Settings'))
		return this
	}

	public LeftNavBar clickAccount() {
		WebUI.click(link('Account'))
		return this
	}

	public String getEmail() {
		String email = WebUI.getAttribute(xpath("//*[@class='truncate']"), "title")
		return email
	}
}
