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
	
	public void takescreenshot(WebDriver driver,String mthdname) {
		
		// Java Interface "TakeScreenshot" takes screenshots 
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		String filepath = "screenshots\\screenshots.jpeg";
	
		int dotIndex = filepath.lastIndexOf(".");
		String baseName = filepath.substring(0, dotIndex);
		String extension = filepath.substring(dotIndex);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy_HH-mm-ss");
		String timestamp = LocalDateTime.now().format(formatter);
		String newFileName = baseName + "-" + timestamp +"-"+mthdname+extension;
		System.out.println(newFileName);
		
		//File destFile = new File(filepath);
		File destFile = new File(newFileName);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
