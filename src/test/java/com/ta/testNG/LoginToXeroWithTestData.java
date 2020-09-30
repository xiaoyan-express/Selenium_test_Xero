package com.ta.testNG;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ta.demo_selenium_test.TestBaseForXERO;
import com.ta.pageObject.POLoginToXERO;
import com.ta.pageObject.POLoginToXEROWithDateProvider;

public class LoginToXeroWithTestData extends TestBaseForXERO {

	POLoginToXERO oLoginToXERO;
	POLoginToXEROWithDateProvider oLoginToXEROWithDataProvider;
	
	@BeforeMethod
	public void triggerDependency() throws Exception {
		BroUtil.launchingTheBrowser();
	}
	
	@AfterMethod
	public void tearDown( ) {
		BroUtil.tearDownBrowser();
	}
	
	@Test
	public void loginToWebsite() throws Exception {
		oLoginToXERO = new POLoginToXERO(driver);
		oLoginToXERO.loginToWebSite();
	}
	
	@Test(dataProvider = "loginToXeroTestData")
	public void loginToWebsiteWithTestData(String username, String password) throws Exception {
		oLoginToXEROWithDataProvider = new POLoginToXEROWithDateProvider(driver);
		oLoginToXEROWithDataProvider.loginToWebSiteWithTestData(username, password);
	}
	
	@DataProvider(name = "loginToXeroTestData")
	public Object[][] testDataForLogin() throws Exception {
		return readExcelAndReturnObject(System.getProperty("user.dir") + "/resources/testData/testDataForXeroLogin.xls");
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
