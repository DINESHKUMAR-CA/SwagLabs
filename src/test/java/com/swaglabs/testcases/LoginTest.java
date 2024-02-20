package com.swaglabs.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.swaglabs.pages.BaseTest;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.utility.ReadExcelFile;

public class LoginTest extends BaseTest {
	
	String excelFileName = System.getProperty("user.dir") +"\\TestData\\SwagLabsPortalData.xlsx";
	
	@Test(priority = 1, dataProvider ="LoginDataProvider")
	public void verifyLogin(String personname, String userpwd) throws IOException {
		
		LoginPage page = new LoginPage(driver);
		page.loginToPortal(personname, userpwd);
		System.out.println("The personnname is: "+ personname + " & The user password is: "+userpwd );
		
		if(personname.equals("visual_user") && userpwd.equals("secret_sauce")) {
			System.out.println("Woohoooo!! The test is passed");
			page.loggingOutFromPortal();
		}
		else {
			captureScreenshot(driver, "VerifyLogin");
		}
	}
	
	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider() {
		
		int totalRows = ReadExcelFile.getRowCount(excelFileName, "LoginData");
		int totalColumns = ReadExcelFile.getColCount(excelFileName, "LoginData");
		
		String data[][] = new String[totalRows - 1][totalColumns];
		
		for(int i=1; i<totalRows; i++) {
			for(int j=0; j<totalColumns; j++) {
				
				data[i-1][j] = ReadExcelFile.getCellValue(excelFileName, "LoginData", i, j);
			}
		}
		return data;
	}
	
}
