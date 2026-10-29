package com.testng.utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {
	
	public void takescreenshot(WebDriver driver, String methodName) {
		//WebDriver is a interface
		//We have a interface which take screenshot
		//Typecasting WebDriver interface to TakeScreenshot, inorder to use getscreenshot method
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		String timeStamp1 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		
		//String filepath = "screenshots\\screenshot.jpeg";
		String filepath = "screenshots\\ " +   methodName + timeStamp1 +".jpeg";
		
		File destFile = new File(filepath);
		
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}