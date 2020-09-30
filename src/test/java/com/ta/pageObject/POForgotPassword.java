package com.ta.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ta.demo_selenium_test.TestBaseForXERO;

public class POForgotPassword extends TestBaseForXERO {

	public POForgotPassword(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Email")
	WebElement emailElement;
	@FindBy(id = "submit-reset-password")
	WebElement sendLinkElement;

	
	public void resetPassword() throws Exception {
		driver.get("https://identity.xero.com/account/forgot-password");
		driver.manage().window().maximize();
		
		BroUtil.explicitWaitFunc(emailElement);
		BroUtil.ufSendKeys(emailElement, "xyzxiaoyan@163.com");
		BroUtil.userFunctionClickElement(sendLinkElement);
		Thread.sleep(5000);
	}
	public void verifyResult() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://identity.xero.com/account/success/");
	}
}
