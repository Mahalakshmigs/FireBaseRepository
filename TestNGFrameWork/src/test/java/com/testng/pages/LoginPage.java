package com.testng.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testng.base.BasePage;

public class LoginPage extends BasePage {
	WebDriver driver;
	
	/*
	 * Framework: Page Object Model 
	 * Design Pattern : PageFactory 
	 */

	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	//driver.findElement(By.)
	@FindBy(id="email_field")
	WebElement emailid;
	
	@FindBy(id="password_field")
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	WebElement loginButton;
	
	public void enterintoUsername(String email) {
		emailid.sendKeys(email);
	}
	
	public void enterintoPassword(String strpassword) {
		password.sendKeys(strpassword);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
}