package com.ta.xero.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ta.xero.util.BrowerUtil;

public class LoginToXeroPage {
	BrowerUtil browerObject;
	
	By emailFieldElement = By.id("xl-form-email");
	
	By passwordFieldElement = By.id("xl-form-password");
	
	By loginButtonElement = By.id("xl-form-submit");
	
	By dashboardElement = By.xpath("//a[@name='navigation-menu/dashboard']");
	
	public LoginToXeroPage(BrowerUtil browerObject) {
		this.browerObject = browerObject;
		
		browerObject.gotoPage("https://login.xero.com/identity/user/login/");
	}
	
	public void loginToWebSite() throws Exception {
		browerObject.explicitWaitFunc(browerObject.findBy(emailFieldElement));			
		browerObject.ufClearElement(browerObject.findBy(emailFieldElement));	
		browerObject.ufSendKeys(browerObject.findBy(emailFieldElement), "xyzxiaoyan@163.com");
		browerObject.ufClearElement(browerObject.findBy(passwordFieldElement));	
		browerObject.ufSendKeys(browerObject.findBy(passwordFieldElement), "xyz12345");		
		browerObject.userFunctionClickElement(browerObject.findBy(loginButtonElement));
		
		browerObject.explicitWaitFunc(browerObject.findBy(dashboardElement));
	} 
	
	public void verifyLoginResult() {
		WebElement dashboard = browerObject.findBy(dashboardElement);
		browerObject.explicitWaitFunc(dashboard);
		Assert.assertEquals(dashboard.isDisplayed(), true);
	}
}
