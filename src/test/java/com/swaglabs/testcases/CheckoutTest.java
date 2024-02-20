package com.swaglabs.testcases;

import org.testng.annotations.Test;

import com.swaglabs.pages.BaseTest;
import com.swaglabs.pages.CartPage;
import com.swaglabs.pages.CheckoutPage;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.pages.ProductPage;
import com.swaglabs.utility.ReadExcelFile;

public class CheckoutTest extends BaseTest {
	
	String excelFileName = System.getProperty("user.dir") + "\\TestData\\SwagLabsPortalData.xlsx";
	
	@Test
	public void proceedNext() throws InterruptedException {
		
		LoginPage page = new LoginPage(driver);
		String personname = ReadExcelFile.getCellValue(excelFileName, "LoginData", 1, 0);
		String userpwd = ReadExcelFile.getCellValue(excelFileName, "LoginData", 1, 1);
		page.loginToPortal(personname, userpwd);
		
		ProductPage pp = new ProductPage(driver);
		pp.productToCart();
		
		CartPage cPage = new CartPage(driver);
		cPage.navigatingToCart();
		
		CheckoutPage cp = new CheckoutPage(driver);
		String userFirstname = ReadExcelFile.getCellValue(excelFileName, "UserInfo", 1, 0);
		String userLastname = ReadExcelFile.getCellValue(excelFileName, "UserInfo", 1, 1);
		String userZipcode = ReadExcelFile.getCellValue(excelFileName, "UserInfo", 1, 2);
		cp.userInformations(userFirstname,userLastname, userZipcode);
		Thread.sleep(5000);
	}
}
