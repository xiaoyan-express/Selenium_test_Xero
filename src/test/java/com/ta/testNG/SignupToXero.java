package com.ta.testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ta.demo_selenium_test.TestBaseForXERO;
import com.ta.pageObject.POSignUpToXero;

public class SignupToXero extends TestBaseForXERO {

	POSignUpToXero oPoSignUpToXero;
	@BeforeMethod
	public void triggerDependency() throws Exception {
		//BroUtil.launchBrowser("ch");
		oPoSignUpToXero = new POSignUpToXero(driver);
	}
	@AfterMethod
	public void quitBrowser() {
		BroUtil.tearDownBrowser();
	}
	
	@Test
	public void signupToXero() throws Exception {
		oPoSignUpToXero.signUpToXero();
		//oPoSignUpToXero.verifySignupResult();
	}
}
