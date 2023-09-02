package com.looru.web.pages;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.b2b.base.B2BBaseAutomationPage;
import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;

public class SalesforceLoginPage extends B2BBaseAutomationPage {

	@B2BFindBy(xpath = "{loginPage.btnSalesforce.xpath}")
	private WebElement btnSalesforce;
	
	@B2BFindBy(xpath = "{loginPage.imgSalesforce.xpath}")
	private WebElement imgSales;	
	
	@B2BFindBy(xpath = "{loginPage.txtUsername.xpath}")
	private WebElement txtUsername;
	
	@B2BFindBy(xpath = "{loginPage.txtPassword.xpath}")
	private WebElement txtPassword;
	
	@B2BFindBy(xpath = "{loginPage.txtPassword.xpath}")
	private WebElement btnLogin;
	
	public SalesforceLoginPage(WebDriver driver) {
		super(driver);
		
		B2BPageFactory.initElements(driver, this);

	}
	
	private static final Logger log = Logger.getLogger(SalesforceLoginPage.class.getName());

		
	public void clickOnSalesforceButton() {
		log.info("Starting clickOnSalesforceButton method");

		this.btnSalesforce.click();
		
		log.info("Ending clickOnSalesforceButton method");

	}
	
	public boolean isSalesforeceImageDisplayed() {
		
	
	return imgSales.isDisplayed();
	}
	public void setUsername(String username) {
		log.info("Starting setUsername method");

		this.txtUsername.sendKeys(username);
		
		log.info("Ending setUsername method");

	}
	
	public void setPassword(String password) {
		log.info("Starting setPassword method");

		this.txtPassword.sendKeys(password);;
		
		log.info("Ending setPassword method");

	}
	
	public void clickOnLoginButton() {
		log.info("Starting clickOnLoginButton method");

		this.explicitWait(btnLogin);
		this.clickOnWebElement(btnLogin);
		this.btnLogin.click();
		
		log.info("Ending clickOnLoginButton method");

	}

	
	}

