package com.testng.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testng.base.BaseTest;
import com.testng.pages.LoginPage;
import com.testng.utilities.PropertiesFile;
import com.testng.utilities.ScreenshotUtility;

public class LoginTest extends BaseTest {
	WebDriver driver;
	LoginPage loginpage;
	ScreenshotUtility screenshot;
	String methodName;
	
	@BeforeMethod
	public void launch() {
		driver = launchapplication();
		loginpage=new LoginPage(driver);
		screenshot = new ScreenshotUtility();
		//curently returns the method name is returned
		//getStackTrace is holding all chain of methods currently executing
		//information about the chain of methods currently involved in execution
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		screenshot.takescreenshot(driver, methodName);
	}
	
	
	@Test
	public void loginwithvalidCredentials() {
		//loginpage.enterintoUsername("admin123@gmail.com");
		//loginpage.enterintoPassword("admin123");
		loginpage.enterintoUsername(PropertiesFile.getProperty("username"));
		loginpage.enterintoPassword(PropertiesFile.getProperty("password"));
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		screenshot.takescreenshot(driver, methodName);
		loginpage.clickLogin();
	}
	
	@Test
	public void loginwithInvalidCredentials() {
		//loginpage.enterintoUsername("admin12345@gmail.com");
		//loginpage.enterintoPassword("admin123");
		loginpage.enterintoUsername(PropertiesFile.getProperty("invalidusername"));
		loginpage.enterintoPassword(PropertiesFile.getProperty("invalidpassword"));
	//	loginpage.clickLogin();
	//	Alert alert = driver.switchTo().alert();
	//	alert.accept();
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		screenshot.takescreenshot(driver, methodName);
		loginpage.clickLogin();
	}

	
	@Test
	public void loginwithNoPassword() {
		loginpage.enterintoUsername("admin12345@gmail.com");
		loginpage.clickLogin();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		screenshot.takescreenshot(driver, methodName);
		
		
	}
	
	@AfterMethod
	public void teardown() {
	//	screenshot.takescreenshot(driver);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		screenshot.takescreenshot(driver, methodName);
		closebrowser();
	}
}