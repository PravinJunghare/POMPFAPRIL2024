package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void loginPageTitleTest()
	{
		String actualTitle=loginPage.getLoginPageTitle();
		org.testng.Assert.assertEquals(actualTitle,"Account Login");
	}
	@Test(priority = 2)
	public void loginPageUrlTest()
	{
		String actualUrl=loginPage.getLoginUrl();
		org.testng.Assert.assertTrue(actualUrl.contains("route=account/login"));
	}
	
	@Test(priority = 3)
	public void forgortPasswordLinkTest()
	{
		Assert.assertTrue(loginPage.isForgotPasswordlinkExits());
	}
	
	
	@Test(priority = 4)
	public void loginTest()
	{
		accountsPage= loginPage.doLogin("pravinjunghare01@gmail.com", "Test@1234");
		Assert.assertTrue( accountsPage.isLogoutLinkExist());
		
		
	}
	
	
	
}