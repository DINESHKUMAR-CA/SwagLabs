package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BaseTest {
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver IDriver) {
		
		this.driver = IDriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first-name") WebElement userFirstName;
	@FindBy(name="lastName") WebElement userLastName;
	@FindBy(id="postal-code") WebElement postalcode;
	@FindBy(name="continue") WebElement proceed;
	
	public void userInformations(String firstName, String lastName, String zipcode) {
		
		userFirstName.sendKeys(firstName);
		userLastName.sendKeys(lastName);
		postalcode.sendKeys(zipcode);
		proceed.click();
	}
}
