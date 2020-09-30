package com.ta.xero.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.ta.xero.util.BrowerUtil;

public class LogoutXeroPage {
	BrowerUtil browerObject;
	
	@FindBy(xpath = "//*[@id=\"header\"]/header/div/ol[2]/li[5]/button/div/abbr")
	WebElement userInfoElement;
	
	@FindBy(xpath = "//div[@class='xrh-dropdown-layout xrh-addon--dropdown xrh-dropdown-is-open xrh-dropdown-is-opening xrh-dropdown-positionright']//a[@class='xrh-verticalmenuitem--body'][contains(text(),'Log out')]")
	WebElement logoutElement;
	
	public LogoutXeroPage(BrowerUtil browerObject) {
		this.browerObject = browerObject;
	}
	
	public void logout() throws Exception {
		browerObject.loginToWebSite();
		
		// Initialize Page Factory.
		// This can only be done after visit the page
		this.browerObject.initElement(this);
		browerObject.explicitWaitFunc(userInfoElement);
		
		browerObject.userFunctionClickElement(userInfoElement);
		browerObject.userFunctionClickElement(logoutElement);
	}
	
	public void verifyLogoutResult() {
		Assert.assertEquals(browerObject.getCurrentUrl(), "https://login.xero.com/");
	}
}
