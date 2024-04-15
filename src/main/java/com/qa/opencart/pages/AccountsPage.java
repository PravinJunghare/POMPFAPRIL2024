package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;
import com.qa.openkart.constants.AppConstant;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	private By logoutLink = By.linkText("Logout");
	private By accHeaders = By.xpath("//div[@id='content']//h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("#search button");

	public String getAccPageTitle() {
		// String title = driver.getTitle();
		String title = eleUtil.waitForTitleContainsAndFetch(AppConstant.DEFAULT_MEDIUM_TIMEOUT, AppConstant.ACCOUNTS_PAGE_TITLE_VALUE);
		System.out.println("Acc page Title is " + title);
		return title;
	}

	public String getAccPageUrl() {
		String url = eleUtil.waitForURLContainsAndFetch(AppConstant.DEFAULT_SHORT_TIMEOUT,AppConstant.ACCOUNTS_PAGE_URL_FRACTION_VALUE);
		System.out.println("Acc page Url is " + url);
		return url;
	}

	public boolean isLogoutLinkExist() {
		return eleUtil.waitForElementVisible(logoutLink, AppConstant.DEFAULT_SHORT_TIMEOUT).isDisplayed();
	}

	public boolean isSearchExist() {
		return eleUtil.waitForElementVisible(search, AppConstant.DEFAULT_MEDIUM_TIMEOUT).isDisplayed();
	}

	public List<String> getAccountPageHeadersList() {

		List<WebElement> accHeaderslist = eleUtil.waitForElementsVisible(accHeaders, AppConstant.DEFAULT_MEDIUM_TIMEOUT);
		List<String> accHeaderValList = new ArrayList<String>();

		for (WebElement e : accHeaderslist) {
			String text = e.getText();
			accHeaderValList.add(text);
		}
		return accHeaderValList;
	}

}
