package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
	WebDriver driver;
	
	public LogoutPage(WebDriver IDriver) {
		
		this.driver = IDriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="react-burger-menu-btn")
	WebElement burgerMenu;
	
	@FindBy(id="logout_sidebar_link")
	WebElement logoutBtn;
	
	public void logingOutFromPortal() {
		burgerMenu.click();
		logoutBtn.click();
	}
}
