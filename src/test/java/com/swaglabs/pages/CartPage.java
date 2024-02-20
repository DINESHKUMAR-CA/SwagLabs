package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BaseTest {
	
	WebDriver driver;
	
	public CartPage(WebDriver IDriver) {
		
		this.driver = IDriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="shopping_cart_container") WebElement cartIcon;
	@FindBy(name="checkout") WebElement checkoutBtn;
	
	public void navigatingToCart() {
		cartIcon.click();
		checkoutBtn.click();
	}
}
