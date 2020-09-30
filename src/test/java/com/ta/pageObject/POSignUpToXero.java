package com.ta.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.google.gson.internal.bind.TreeTypeAdapter;
import com.ta.demo_selenium_test.TestBaseForXERO;

public class POSignUpToXero extends TestBaseForXERO {

	public  POSignUpToXero(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='FirstName']")
	WebElement firstNameInputElement;
	@FindBy(xpath = "//input[@name='LastName']")
	WebElement lastNameInputElement;
	@FindBy(xpath = "//input[@name='EmailAddress']")
	WebElement emailAddressElement;
	@FindBy(xpath = "//input[@name='PhoneNumber']")
	WebElement phoneNumberElement;
	@FindBy(xpath = "//select[@name='LocationCode']//option[contains(text(),'United States')]")
	WebElement countryElement;
	
	@FindBy(tagName = "iframe")
	WebElement iframeElement;
	@FindBy(id = "recaptcha-anchor")
	WebElement notRobotElement;
	
	@FindBy(xpath = "//input[@name='TermsAccepted']")
	WebElement termsAcceptedElement;
	@FindBy(xpath = "//span[@class='g-recaptcha-submit']")
	WebElement getStartedElement;
	
	@FindBy(xpath = "/html/body/main/div[1]/div/div/div[1]/div/div/div[2]/h1")
	WebElement checkYourBoxElement;

	
	public void signUpToXero() throws Exception{
		driver.get("https://www.xero.com/us/signup/");
		driver.manage().window().maximize();
		
		BroUtil.explicitWaitFunc(firstNameInputElement);
		BroUtil.ufClearElement(firstNameInputElement);
		BroUtil.ufSendKeys(firstNameInputElement, "Xiaoyan");
		BroUtil.ufClearElement(lastNameInputElement);
		BroUtil.ufSendKeys(lastNameInputElement, "Zhang");
		BroUtil.ufSendKeys(emailAddressElement, "xyzxiaoyan@163.com");
		BroUtil.ufSendKeys(phoneNumberElement, "4087591096");
		BroUtil.userFunctionClickElement(countryElement);
		driver.switchTo().frame(iframeElement);
		Thread.sleep(3000);
		BroUtil.userFunctionClickElement(notRobotElement);
		driver.switchTo().defaultContent();
		BroUtil.userFunctionClickElement(termsAcceptedElement);
		BroUtil.userFunctionClickElement(getStartedElement);
		Thread.sleep(5000);
		
	}
	public void verifySignupResult() {
		Assert.assertEquals(checkYourBoxElement.isDisplayed(), true);
	}
}
