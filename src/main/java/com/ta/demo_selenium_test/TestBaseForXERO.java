package com.ta.demo_selenium_test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBaseForXERO {

	public static BrowserUtilityForXERO BroUtil = new BrowserUtilityForXERO();
	public WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest logger;

	String pathString = System.getProperty("user.dir") + "/extentReport/reportBrowser.html";
	
	@BeforeSuite
	public void launchingTheBrowser() throws Exception {
		reports = new ExtentReports(pathString);
		//driver = BroUtil.launchBrowser("ch");
		this.driver = BroUtil.launchBrowser("ch");
	}
	
	@AfterSuite
	public void closingTest() {
		BroUtil.tearDownBrowser();
		reports.flush();
	}
	

	
}
