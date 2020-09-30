package com.ta.xero.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowerUtil {
	private WebDriver driver;
	
	public WebDriver launchBrowser(String sBrowserName) {
		switch (sBrowserName) {
		case "ch":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		default:
			break;
		}
		return driver;
	}
	
	public void initElement(Object page) {
		PageFactory.initElements(driver, page);
	}
	
	public WebElement findBy(By by) {
		return driver.findElement(by);
	}
	
	public void gotoPage(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public void explicitWaitFunc(WebElement ele, int iTime) {
		WebDriverWait wait1 = new WebDriverWait(driver, iTime);
		wait1.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void explicitWaitFunc(WebElement ele) {
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void loginToWebSite() throws Exception{
		gotoPage("https://login.xero.com/identity/user/login/");
	
		explicitWaitFunc(driver.findElement(By.id("xl-form-email")));
		
		driver.findElement(By.id("xl-form-email")).click();
		driver.findElement(By.id("xl-form-email")).clear();
		driver.findElement(By.id("xl-form-email")).sendKeys("xyzxiaoyan@163.com");
		driver.findElement(By.id("xl-form-password")).clear();
		driver.findElement(By.id("xl-form-password")).sendKeys("xyz12345");
		driver.findElement(By.id("xl-form-submit")).click();
	} 
	
	public void loginToWebSite(String sUserName , String sPassword) throws Exception{

		Thread.sleep(1000);
		driver.get("https://login.xero.com/identity/user/login/");
		
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		WebElement emailElement = driver.findElement(By.id("xl-form-email"));
		explicitWaitFunc(emailElement);	
	
		driver.findElement(By.id("xl-form-email")).click();
		driver.findElement(By.id("xl-form-email")).clear();
		driver.findElement(By.id("xl-form-email")).sendKeys(sUserName);
		driver.findElement(By.id("xl-form-password")).clear();
		driver.findElement(By.id("xl-form-password")).sendKeys(sPassword);
		driver.findElement(By.id("xl-form-submit")).click();
	} 
	
	public void printListOfWebElements(List<WebElement> liWebElements) {
		for(int count = 0; count<liWebElements.size();count++) {
			System.out.print(liWebElements.get(count).getText()+"\t");
		}
		System.out.println();
	}
	
	public void tearDownBrowser() {
		driver.quit();
	}
	
	public void userFunctionClickElement(WebElement ele) {
		ele.click();
	}
	
	public void ufClearElement(WebElement ele) {
		ele.clear();
	}
	
	public void ufSendKeys(WebElement ele, String text) {
		ele.sendKeys(text);
	}
}
