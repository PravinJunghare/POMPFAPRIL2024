package com.qa.opencart.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {
	WebDriver driver;
	DriverFactory df;
	protected LoginPage loginPage;
	protected AccountsPage accountsPage;

	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		driver = df.initDriver("chrome");
		loginPage= new LoginPage(driver);
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}


