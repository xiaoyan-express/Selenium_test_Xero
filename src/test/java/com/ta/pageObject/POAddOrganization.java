package com.ta.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ta.demo_selenium_test.TestBaseForXERO;

public class POAddOrganization extends TestBaseForXERO {

	public POAddOrganization(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='xrh-appbutton--text']")
	WebElement selfElement;
	@FindBy(xpath = "//a[contains(text(),'My Xero')]")
	WebElement myXeroElement;
	@FindBy(xpath = "//h2[contains(text(),'Organizations')]")
	WebElement organizationElement;
	
	@FindBy(xpath = "//*[@id=\"ext-gen1042\"]")
	WebElement addOrganizationElement;
	
	
	public void addAnotherOrganizationTrailVersion() throws Exception {

		String sUserName = "gopala.anumanchipalli@gmail.com";
		String sPassword = "password12";
		BroUtil.loginToWebSite(sUserName, sPassword);
		BroUtil.explicitWaitFunc(selfElement);
		BroUtil.userFunctionClickElement(selfElement);
		BroUtil.userFunctionClickElement(myXeroElement);
		
		BroUtil.explicitWaitFunc(organizationElement);
		BroUtil.explicitWaitFunc(addOrganizationElement);
		BroUtil.userFunctionClickElement(addOrganizationElement);
		
		
	}
}
