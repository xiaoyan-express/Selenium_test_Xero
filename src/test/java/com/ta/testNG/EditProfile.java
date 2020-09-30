package com.ta.testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ta.demo_selenium_test.TestBaseForXERO;
import com.ta.pageObject.POLoginToXERO;
import com.ta.pageObject.POUploadProfileImage;

public class EditProfile extends TestBaseForXERO {

	POLoginToXERO oLoginToXERO;
	POUploadProfileImage oPoUploadProfileImage;
	
	@BeforeMethod
	public void triggerDependency() throws Exception {
		BroUtil.loginToWebSite();
		oPoUploadProfileImage = new POUploadProfileImage(driver);
	}

	@AfterMethod
	public void quitBrowser() {
		BroUtil.tearDownBrowser();
	}
	
	@Test
	public void uploadProfileImage() throws Exception {
		oPoUploadProfileImage.editProfile();
		oPoUploadProfileImage.verifyUploadResult();
	}
}
