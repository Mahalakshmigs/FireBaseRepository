package com.testng.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
	
	static FileInputStream fileinput;
	static String value=null;
	
	public static String getProperty(String key) {
		
		//1. file path
		String filepath  = "properties\\application.properties";
		
		//2. Create a fileinputStream 
		 try {
			fileinput = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		 
		 
		//3. Properties file Object 
		 Properties prop = new Properties();
		 
		 try {
			prop.load(fileinput);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		 //read the value by passing the key
		value=(String) prop.get(key);
		return value;
		
	}
	
	

}