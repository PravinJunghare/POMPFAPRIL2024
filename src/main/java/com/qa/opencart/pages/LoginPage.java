package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	// 1.Private By locators
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@type='submit']");
	private By forgotPasswordLink = By.linkText("Forgotten Password");

	// 2.page constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3.public methods/action

	public String getLoginPageTitle() {
		String title = driver.getTitle();
		System.out.println("loginpage title is" + title);
		return title;
	}

	public String getLoginUrl() {
		String url = driver.getCurrentUrl();
		System.out.println("loginpage title is" + url);
		return url;
	}

	public boolean isForgotPasswordlinkExits() {
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}

	public void doLogin(String un, String pwd) {
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
	}

}
