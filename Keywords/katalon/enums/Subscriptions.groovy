package katalon.enums

public enum Subscriptions {

	KSE_PERUSER_ANNUAL("kse_per-user_annual"),
	KSE_PERUSER_MONTHLY("kse_per-user_monthly"),
	KRE_FLOATING_ANNUAL("kre_floating_annual"),
	KRE_FlOATING_MONTHLY("kre_floating_monthly"),
	PLATFORM_ANNUAL("testops_platform_annual"),
	PLATFORM_MONTHLY("testops_platform_monthly"),
	TESTCLOUD_MONTHLY("testcloud_session_web_monthly"),
	TESTCLOUD_ANNUAL("testcloud_session_web_annual"),

	String code

	Subscriptions(String code) {
		this.code = code
	}

	public String getCode() {
		return code;
	}
}
