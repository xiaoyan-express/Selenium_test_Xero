package com.ta.xero.pages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ta.xero.util.BrowerUtil;

public class XeroPageTestSuite {
	private BrowerUtil browserObject;
	
	@BeforeMethod
	public void setup() {
		browserObject = new BrowerUtil();
		browserObject.launchBrowser("ch");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		browserObject.tearDownBrowser();
	}
	
	@Test(priority = 0)
	public void xeroLoginPageTest() throws Exception {
		LoginToXeroPage page = new LoginToXeroPage(browserObject);
		page.loginToWebSite();
		page.verifyLoginResult();
	}
	
	@Test(priority = 1)
	public void xeroLogoutPageTest() throws Exception {
		LogoutXeroPage page = new LogoutXeroPage(browserObject);
		page.logout();
		page.verifyLogoutResult();
	}
}
