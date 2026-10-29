package com.testng.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	protected String mthdname;
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	} 
	public void explicitWait(WebElement element, int timeout) {
		
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
		}
	
	public void fluentWait(WebElement element, int timeout) {
		FluentWait<WebDriver> fluwait = new FluentWait<WebDriver>(driver);
		fluwait.withTimeout(timeout, TimeUnit.SECONDS);
		fluwait.pollingEvery(200, TimeUnit.MICROSECONDS);
		fluwait.until(ExpectedConditions.visibilityOf(element));
		}
	   
	
}
