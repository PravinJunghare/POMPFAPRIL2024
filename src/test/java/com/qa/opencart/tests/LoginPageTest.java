package com.qa.opencart.tests;

import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class LoginPageTest extends BaseTest {

	@Test
	public void loginPageTitleTest()
	{
		String actualTitle=loginPage.getLoginPageTitle();
		org.testng.Assert.assertEquals(actualTitle,"Account Login");
	}
	@Test
	public void loginPageUrlTest()
	{
		String actualUrl=loginPage.getLoginUrl();
		org.testng.Assert.assertTrue(actualUrl.contains("route=account/login"));
	}
	
	@Test
	public void forgortPasswordLinkTest()
	{
		org.testng.Assert.assertTrue(loginPage.isForgotPasswordlinkExits());
	}
	
	
	@Test
	public void loginTest()
	{
		loginPage.doLogin("pravinjunghare01@yahoo.com", "Test@1234");
	}
	
	
	
}