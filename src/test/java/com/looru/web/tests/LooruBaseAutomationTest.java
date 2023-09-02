package com.looru.web.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.b2b.test.base.B2BBaseAutomationTest;
import com.b2b.utils.B2BBaseTestListener;

@Listeners(B2BBaseTestListener.class)
public abstract class LooruBaseAutomationTest extends B2BBaseAutomationTest {

	private static final Logger log = Logger.getLogger(LooruBaseAutomationTest.class);

	@BeforeSuite
	@Parameters({ "siteURL", "language", "browser" })
	public void initAutomation(String siteURL, String language, String browser) {
		this.loadProjectConfigFiles();
		this.initTestAutomation(siteURL, language, browser, false, false);

		log.debug("Site URL :{} " + loginURL);
	}

}
