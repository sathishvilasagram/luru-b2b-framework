package com.looru.web.pages;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.base.B2BBaseAutomationPage;
import com.b2b.support.B2BPageFactory;

public class LooruBaseAutomationPage extends B2BBaseAutomationPage {
	

	private static final Logger log = LogManager.getLogger(LooruBaseAutomationPage.class);

	public static String TEST_FILE_PATH = null;


	public LooruBaseAutomationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log.debug("in looru base");
		if (TEST_FILE_PATH == null) {
			TEST_FILE_PATH = getTestFilePath();

			log.debug("In Constructor " + TEST_FILE_PATH);
		}
		log.debug("middle in looru base");
		B2BPageFactory.initElements(driver, this);
		log.debug("end in looru base");
	}

	public void hardWait(int seconds) {
		try {
		
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	public boolean getAddedContentText(List<WebElement> element, String contentName) {
		log.info("Starting of getAddedContentTexts method");

		for (WebElement e : element) {
			System.out.println(e.getText());
			if (e.getText().equalsIgnoreCase(contentName)) {
				return true;
			}
		}

		log.info("Ending of getAddedContentTexts method");
		return false;
	}

	public void deleteInputFields(WebElement element) {
		if (!System.getProperty("os.name").contains("Mac")) {
			element.sendKeys(Keys.CONTROL + "a");
			element.sendKeys(Keys.DELETE);
		} else {
			element.sendKeys(Keys.COMMAND + "a");
			element.sendKeys(Keys.DELETE);

		}
	}

	public WebElement webElementWithReplacement(WebElement webElement, String replaceText) {
		log.info("Starting of webElementWithReplacement method");

		String el = webElement.toString();
		String xpath = el.substring(el.indexOf("//"), el.length() - 1);
		WebElement ele = driver.findElement(By.xpath(xpath.replaceAll("\\$\\{.+\\}", replaceText)));
		log.info("Ending of webElementWithReplacement method");

		return ele;
	}

}


