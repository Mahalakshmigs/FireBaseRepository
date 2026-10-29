package com.testng.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.testng.utilities.PropertiesFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
//	PropertiesFile properties = new PropertiesFile();
	
	public WebDriver launchapplication() {
		
		if(driver==null) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String applicationurl = "";
			try {
				applicationurl = PropertiesFile.getProperty("url");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//	String applicationurl = properties.getProperty("url");
		//	String applicationurl = PropertiesFile.getProperty("url");
			
			driver.get(applicationurl);
			}
		 return driver;
	}
	
	public void closebrowser() {
		driver.close();
		driver=null;
	}

}