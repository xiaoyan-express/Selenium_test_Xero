package com.ta.testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ta.demo_selenium_test.TestBaseForXERO;
import com.ta.pageObject.POSignUpFreeTrial;

public class SignupFreeTrial extends TestBaseForXERO {

	POSignUpFreeTrial oPoSignUpFreeTrial;
	@BeforeMethod
	public void triggerDependency() throws Exception {
		//BroUtil.launchBrowser("ch");
		oPoSignUpFreeTrial = new POSignUpFreeTrial(driver);
	}
	@AfterMethod
	public void quitBrowser() {
		BroUtil.tearDownBrowser();
	}
	
	@Test
	public void signupFreeTrial() throws Exception {
		oPoSignUpFreeTrial.signUpFreeTrial();
		oPoSignUpFreeTrial.verifyFreeTrialSignUpResult();
	}
}
