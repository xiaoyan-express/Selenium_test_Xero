package com.ta.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ta.demo_selenium_test.TestBaseForXERO;

public class POUploadProfileImage extends TestBaseForXERO {

	public POUploadProfileImage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"header\"]/header/div/ol[2]/li[5]/button/div/abbr")
	WebElement userInfoElement;
	@FindBy(xpath = "//img[@class='xrh-avatar']")
	WebElement userImageElement;
	@FindBy(xpath = "//span[@class='xrh-verticalmenuitem--subheading']")
	WebElement editProfilElement;
	
	@FindBy(id = "button-1041-btnInnerEl")
	WebElement uploadImagElement;
	
	@FindBy(xpath = "//iframe[@name='sandbox-2']")
	WebElement iframeElement;
	@FindBy(xpath = "//*[@id=\"filefield-1174-button\"]")
	WebElement browseElement;
	
	String pathOfString = "/Users/xyz/Desktop/seleniumLogo.jpg";
	@FindBy(id = "button-1178-btnInnerEl")
	WebElement uploadElement;
	
	@FindBy(xpath = "//img[@class='your-logo']")
	WebElement uploadedImageElement;
	
	public void editProfile() throws Exception {
		//BroUtil.loginToWebSite();
		BroUtil.explicitWaitFunc(userInfoElement);
		BroUtil.userFunctionClickElement(userInfoElement);
		BroUtil.explicitWaitFunc(editProfilElement);
		BroUtil.userFunctionClickElement(editProfilElement);
		
		BroUtil.explicitWaitFunc(uploadImagElement);
		BroUtil.userFunctionClickElement(uploadImagElement);
		
		driver.switchTo().frame(iframeElement);
		Thread.sleep(5000);
		BroUtil.explicitWaitFunc(browseElement);
		BroUtil.ufSendKeys(browseElement, pathOfString);
		
		BroUtil.explicitWaitFunc(uploadElement);
		BroUtil.userFunctionClickElement(uploadElement);
		
		driver.switchTo().defaultContent();
		
	}
	public void verifyUploadResult() {
		BroUtil.explicitWaitFunc(uploadImagElement);
		Assert.assertEquals(uploadedImageElement.isDisplayed(), true);
	}
	
}
