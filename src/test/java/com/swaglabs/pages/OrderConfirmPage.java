package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmPage {

	WebDriver driver;
	
	public OrderConfirmPage(WebDriver IDriver) {
		this.driver = IDriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="finish") WebElement finishBtn;
	@FindBy(name="back-to-products") WebElement backToHomeBtn;
	
	public void completingOrder() {
		
		finishBtn.click();
		backToHomeBtn.click();
	}
}

