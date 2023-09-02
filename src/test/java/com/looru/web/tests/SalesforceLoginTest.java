package com.looru.web.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.looru.web.pages.SalesforceLoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class SalesforceLoginTest extends LooruBaseAutomationTest {

	private WebDriver driver = null;
	SalesforceLoginPage loginPage = null;

	private static final Logger logger = Logger.getLogger(SalesforceLoginTest.class.getName());
   
	
	@BeforeClass
	@Parameters({ "siteURL", "browser","language" })
	public void initClass(String siteURL, String browser,String language) throws Exception {
		logger.info("Starting of initClass method");
        this.driver=super.getWebDriver(WebDriversEnum.LOGIN_WEB_DRIVER);
		this.loginPage = new SalesforceLoginPage(this.driver);
		driver.get(siteURL);

		logger.info("Starting of initClass method");

	}

	@Test(priority = 1, description = "Verify User can login to the site")
	@Description("Test Description:Verify User can login to the site")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify User can login to the site")
	public void testLoginToSiteUI() throws InterruptedException {
		logger.info("Startitng of testLoginToSiteUI method");

		try {
			loginPage.clickOnSalesforceButton();
			
			Assert.assertTrue(loginPage.isSalesforeceImageDisplayed());
			
			loginPage.setUsername(testDataProp.getProperty("text.user.name"));
			loginPage.setPassword(testDataProp.getProperty("text.password"));
			loginPage.clickOnLoginButton();			
			
		} catch (Exception e) {
			 Assert.fail("Exception occured while testing LoginTosite: " +	e.getMessage());
			logger.error("Error occured while testing the LoginTosite   ", e);
		}

		logger.info("Ending of testLoginToSiteUI method");
	}	
	
	@AfterClass
	public void quitDriver() {
		logger.info("Starting of quitDriver method");

		try {
			
			if (this.driver != null) {
				this.quitDriver(this.driver, WebDriversEnum.LOGIN_WEB_DRIVER);
				logger.debug("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		logger.info("Ending of quitDriver method");
	}

}
