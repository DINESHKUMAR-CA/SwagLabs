package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BaseTest {
	
	WebDriver driver;
	
	public ProductPage(WebDriver IDriver) {
		
		this.driver = IDriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(@id,\"labs-backpack\")]") WebElement addToCart;
	
	public void productToCart() {
		addToCart.click();
	}
}
