package com.ta.extentReport;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.ta.demo_selenium_test.TestBaseForXERO;
import com.ta.pageObject.POLoginToXEROWithDateProvider;

public class LoginWithTestDataAndExtentReport extends TestBaseForXERO {

	static int count = 0;
	POLoginToXEROWithDateProvider oLoginToXEROWithDataProvider;
	

	
	@Test
	public void LoginToWebsite() throws Exception {
		oLoginToXEROWithDataProvider.loginToWebSite();
		oLoginToXEROWithDataProvider.verifyLoginSucessfully();
	}
	
	@Test(dataProvider = "loginToXeroTestData")
	public void loginToWebsiteWithTestData(String username, String password, String xpathString) throws Exception {
		count++;
		logger = reports.startTest("loginToXeroWithTestData_" + count);
		oLoginToXEROWithDataProvider.loginToWebSiteWithTestData(username, password);
		logger.log(LogStatus.INFO, "Login button clicked");
		BroUtil.explicitWaitFunc(driver.findElement(By.xpath(xpathString.trim())));
		Assert.assertEquals(driver.findElement(By.xpath(xpathString.trim())).isDisplayed(), true);
		
		TakesScreenshot tss = (TakesScreenshot) driver;
		File sourceFile = tss.getScreenshotAs(OutputType.FILE);
		
		String pathOfScreenshotString = 
				System.getProperty("user.dir") + "/screenshot/screenshot_" + "loginToXeroWithTestData_" + count + ".png";
		File destnationFile = new File(pathOfScreenshotString);
		FileUtils.copyFile(sourceFile, destnationFile);
		
		logger.log(LogStatus.INFO, "Test case is passed.");
		logger.log(LogStatus.PASS, logger.addScreenCapture(pathOfScreenshotString));
		reports.endTest(logger);
		
		
	}
	
	@DataProvider(name = "loginToXeroTestData")
	public Object[][] testDataForLogin() throws Exception {
		return readExcelAndReturnObject(System.getProperty("user.dir") + "/resources/testData/testDataForXeroLogin2.xls");
	}
	
	public Object[][] readExcelAndReturnObject(String fileString)throws Exception {
		HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(fileString));
		//td_userpass
		HSSFSheet myExcelSheet = myExcelBook.getSheet("testDataForLogin");
		HSSFRow row1 = myExcelSheet.getRow(0);
		System.out.println(myExcelSheet.getPhysicalNumberOfRows());
		int iCountCol =row1.getLastCellNum();
		int iCountRow = myExcelSheet.getPhysicalNumberOfRows();
		Object[][] excelData= new Object[iCountRow][iCountCol]; 
		for(int countRow = 0; countRow < iCountRow; countRow++) {
			for(int countCol = 0; countCol < iCountCol; countCol++) {
			
				HSSFRow tempRow = myExcelSheet.getRow(countRow);
				String sTemp;
				try {
				sTemp=tempRow.getCell(countCol).getStringCellValue();
				}catch(Exception a) {
					sTemp=Double.toString(tempRow.getCell(countCol).getNumericCellValue());
				}
				excelData[countRow][countCol] = sTemp;
			}
			
		}		
		return excelData;
	}
}
