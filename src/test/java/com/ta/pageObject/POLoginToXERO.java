package com.ta.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ta.demo_selenium_test.TestBaseForXERO;

public class POLoginToXERO extends TestBaseForXERO {

	public POLoginToXERO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "xl-form-email")
	WebElement emailFieldElement;
	@FindBy(id = "xl-form-password")
	WebElement passwordFieldElement;
	@FindBy(id = "xl-form-submit")
	WebElement loginButtonElement;
	@FindBy(xpath = "//a[@name='navigation-menu/dashboard']")
	WebElement dashboardElement;

	
	public void loginToWebSite() throws Exception{
		System.out.println("driver is" + driver);
		driver.get("https://login.xero.com/identity/user/login/");
		
		driver.manage().window().maximize();
	
		BroUtil.explicitWaitFunc(emailFieldElement);			
		BroUtil.ufClearElement(emailFieldElement);	
		BroUtil.ufSendKeys(emailFieldElement, "xyzxiaoyan@163.com");
		BroUtil.ufClearElement(passwordFieldElement);	
		BroUtil.ufSendKeys(passwordFieldElement, "xyz12345");		
		BroUtil.userFunctionClickElement(loginButtonElement);
		
		BroUtil.explicitWaitFunc(dashboardElement);
	} 
	public void verifyLoginResult() {
		BroUtil.explicitWaitFunc(dashboardElement);
		Assert.assertEquals(dashboardElement.isDisplayed(), true);
	}
	
	
}
