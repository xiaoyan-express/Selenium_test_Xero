package com.ta.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ta.demo_selenium_test.TestBaseForXERO;

public class POLogout extends TestBaseForXERO{

	public POLogout(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"header\"]/header/div/ol[2]/li[5]/button/div/abbr")
	WebElement userInfoElement;
	@FindBy(xpath = "//div[@class='xrh-dropdown-layout xrh-addon--dropdown xrh-dropdown-is-open xrh-dropdown-is-opening xrh-dropdown-positionright']//a[@class='xrh-verticalmenuitem--body'][contains(text(),'Log out')]")
	WebElement logoutElement;
	
	public void logout() throws Exception {
		BroUtil.loginToWebSite();
		BroUtil.explicitWaitFunc(userInfoElement);
		BroUtil.userFunctionClickElement(userInfoElement);
		BroUtil.userFunctionClickElement(logoutElement);
		
	}
	public void verifyLogoutResult() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://login.xero.com/");
	}
}
