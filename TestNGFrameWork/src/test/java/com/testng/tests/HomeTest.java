package com.testng.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testng.base.BaseTest;
import com.testng.pages.HomePage;
import com.testng.pages.LoginPage;
import com.testng.utilities.PropertiesFile;
import com.testng.utilities.ScreenshotUtility;

public class HomeTest extends BaseTest{
	
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	ScreenshotUtility screenshot;
	String methodName;
	
	@BeforeMethod
	public void launch() {
		driver = launchapplication();
		screenshot = new ScreenshotUtility();
		loginpage=new LoginPage(driver);
		
		homepage = new HomePage(driver);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		screenshot.takescreenshot(driver, methodName);
	}
	
	@Test
	public void homePageTestcase() {
		//loginpage.enterintoUsername("admin123@gmail.com");
		//loginpage.enterintoPassword("admin123");
		loginpage.enterintoUsername(PropertiesFile.getProperty("username"));
		loginpage.enterintoPassword(PropertiesFile.getProperty("password"));
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		screenshot.takescreenshot(driver, methodName);
		loginpage.clickLogin();
		homepage.clickHome();

	}
	
	@AfterMethod
	public void teardown() {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		screenshot.takescreenshot(driver, methodName);
		closebrowser();
	}

}