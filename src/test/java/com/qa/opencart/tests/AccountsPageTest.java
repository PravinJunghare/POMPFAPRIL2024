package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class AccountsPageTest extends BaseTest {

	// Special Precondition for AccPage Class
	@BeforeClass
	public void accPageSetup() {
		accountsPage = loginPage.doLogin("pravinjunghare01@gmail.com", "Test@1234");
	}

	@Test
	public void accPageTitletest() {
		String acttitle = accountsPage.getAccPageTitle();

		Assert.assertEquals(acttitle, "My Account");
	}

	@Test
	public void accountsPageUrlTest() {
		String actUrl = accountsPage.getAccPageUrl();
		Assert.assertTrue(actUrl.contains("route=account/account"));
	}

	@Test
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accountsPage.isLogoutLinkExist());
	}

	@Test
	public void accountHeaderTest() {
		List<String> actualAccHeaderList = accountsPage.getAccountPageHeadersList();
		System.out.println(actualAccHeaderList);
		Assert.assertEquals(actualAccHeaderList.size(), 4);

	}

}
