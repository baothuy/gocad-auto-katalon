package gocad.buyer

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import katalon.fw.lib.BasePage




public class CustomDXFLeftNavMenu extends BasePage<CustomDXFLeftNavMenu>{

	public CustomDXFLeftNavMenu clickRoundShape() {
		WebUI.click(xpath("//*[@alt='Round']"))
		return this
	}

	public CustomDXFLeftNavMenu clickRectangleGasketShape() {
		WebUI.click(xpath("//*[@alt='Rectangle gasket']"))
		return this
	}

	public CustomDXFLeftNavMenu clickOvalGasketShape() {
		WebUI.click(xpath("//*[@alt='Oval gasket']"))
		return this
	}

	public CustomDXFLeftNavMenu clickElongatedRoundGasketShape() {
		WebUI.click(xpath("//*[@alt='Elongated/round gasket']"))
		return this
	}

	public CustomDXFLeftNavMenu clickRectanglePanelShape() {
		WebUI.click(xpath("//*[@alt='Rectangle panel']"))
		return this
	}

	public CustomDXFLeftNavMenu clickRectangleRoundedPanelShape() {
		WebUI.click(xpath("//*[@alt='Rectangle rounded panel']"))
		return this
	}

	public CustomDXFLeftNavMenu clickRectangleRoundedTopPanelShape() {
		WebUI.click(xpath("//*[@alt='Rectangle rounded top panel']"))
		return this
	}

	public CustomDXFLeftNavMenu clickCirclePanelShape() {
		WebUI.click(xpath("//*[@alt='Circle panel']"))
		return this
	}

	public CustomDXFLeftNavMenu clickEllipsePanelShape() {
		WebUI.click(xpath("//*[@alt='Ellipse panel']"))
		return this
	}

	public CustomDXFLeftNavMenu clickHalfCirclePanelShape() {
		WebUI.click(xpath("//*[@alt='Half Circle panel']"))
		return this
	}

	public CustomDXFLeftNavMenu clickOctagonPanelShape() {
		WebUI.click(xpath("//*[@alt='Octagon']"))
		return this
	}

	public CustomDXFLeftNavMenu clickTrapezPanelShape() {
		WebUI.click(xpath("//*[@alt='Trapez']"))
		return this
	}

	public CustomDXFLeftNavMenu clickIsoscelesTrapezoidPanelShape() {
		WebUI.click(xpath("//*[@alt='Isosceles trapezoid']"))
		return this
	}
}
