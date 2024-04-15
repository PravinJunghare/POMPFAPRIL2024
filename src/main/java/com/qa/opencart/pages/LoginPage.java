package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;
import com.qa.openkart.constants.AppConstant;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	// 1.Private By locators
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@type='submit']");
	private By forgotPasswordLink = By.linkText("Forgotten Password");

	// 2.page constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3.public methods/action

	public String getLoginPageTitle() {
		// String title = driver.getTitle();
		//String title = eleUtil.waitForTitleContainsAndFetch(10, "Account Login");
		String title = eleUtil.waitForTitleContainsAndFetch(AppConstant.DEFAULT_MEDIUM_TIMEOUT, AppConstant.ACCOUNTS_PAGE_TITLE_VALUE);
		System.out.println("loginpage title is" + title);
		return title;
	}

	public String getLoginUrl() {
		// String url = driver.getCurrentUrl();
		//String url = eleUtil.waitForURLContainsAndFetch(10, "route=account/login");
		String url = eleUtil.waitForURLContainsAndFetch(AppConstant.DEFAULT_MEDIUM_TIMEOUT,AppConstant.ACCOUNTS_PAGE_URL_FRACTION_VALUE);
		System.out.println("loginpage url is" + url);
		return url;
	}

	public boolean isForgotPasswordlinkExits() {
		// return driver.findElement(forgotPasswordLink).isDisplayed();
		return eleUtil.waitForElementVisible(forgotPasswordLink, AppConstant.DEFAULT_MEDIUM_TIMEOUT).isDisplayed();
	}

	public AccountsPage doLogin(String un, String pwd) {
		// driver.findElement(emailId).sendKeys(un);
		// driver.findElement(password).sendKeys(pwd);
		// driver.findElement(loginBtn).click();

		eleUtil.waitForElementVisible(emailId, AppConstant.DEFAULT_MEDIUM_TIMEOUT).sendKeys(un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		// After clicking on login button moving to Accounts page methods responsibility
		// to return next landing page object
		return new AccountsPage(driver);
	}

}
