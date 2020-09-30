package com.ta.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ta.demo_selenium_test.TestBaseForXERO;

public class POSignUpFreeTrial extends TestBaseForXERO {

	public POSignUpFreeTrial(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='btn btn-primary global-ceiling-bar-btn at-element-marker']")
	WebElement freeTrialElement;
	@FindBy(xpath = "//a[contains(text(),'accountant or bookkeeper')]")
	WebElement accountantOrBookkeepereElement;
	@FindBy(xpath = "//h2[contains(text(),'Xero partner program signup form')]")
	WebElement partnerSignupTagElement;
	
	@FindBy(xpath = "//input[@name='field_First_Name__c']")
	WebElement firstNameElement;
	@FindBy(xpath = "//input[@name='field_Last_Name__c']")
	WebElement lastNameElement;
	@FindBy(xpath = "//input[@name='field_Email__c']")
	WebElement EmailElement;
	@FindBy(xpath = "//input[@name='field_Phone__c']")
	WebElement phoneElement;
	@FindBy(xpath = "//a[@class='btn btn-primary next']")
	WebElement nextButtonElement;
	
	
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement goToInboxElement;
	
	public void signUpFreeTrial() {
		driver.get("https://www.xero.com/us/");
		driver.manage().window().maximize();
		
		BroUtil.explicitWaitFunc(freeTrialElement);
		BroUtil.userFunctionClickElement(freeTrialElement);
		BroUtil.explicitWaitFunc(accountantOrBookkeepereElement);
		BroUtil.userFunctionClickElement(accountantOrBookkeepereElement);
		//Assert.assertEquals(partnerSignupTagElement.isDisplayed(), true);
		
		
		
	}
	
	public void verifyFreeTrialSignUpResult() {
		Assert.assertEquals(partnerSignupTagElement.getText(), "Xero partner program signup form");
	}
}
