package com.ta.testNG;

import org.testng.annotations.Test;

import com.ta.demo_selenium_test.TestBaseForXERO;
import com.ta.pageObject.POLogout;

public class LogoutXero extends TestBaseForXERO {

	POLogout oLogout;
	
	@Test
	public void logoutXero() throws Exception {
		oLogout = new POLogout(driver);
		oLogout.logout();
		oLogout.verifyLogoutResult();
	}
}
