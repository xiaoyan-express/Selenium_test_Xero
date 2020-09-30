package com.ta.testNG;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.ta.demo_selenium_test.TestBaseForXERO;
import com.ta.pageObject.POForgotPassword;

public class ForgotPassword extends TestBaseForXERO {

	POForgotPassword oForgotPassword;
	
	@Test
	public void forgotPassword() throws Exception {
		oForgotPassword = new POForgotPassword(driver);
		oForgotPassword.resetPassword();
		oForgotPassword.verifyResult();
	}
}
