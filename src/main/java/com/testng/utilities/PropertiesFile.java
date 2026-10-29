package com.testng.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
 
	FileInputStream  fileinput;
	String value = null;
	
	public String getProperty(String key) {
		
		//Step 1 : file path
		String filepath = "properties\\application.properties";
		
		//step2 :Create a file input stream
		try {
			fileinput = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Step 3 : create properties file object
		Properties prop = new Properties();
		
		try {
			prop.load(fileinput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		value =(String)prop.get(key);
		return value;
		
	}
 
 
}
