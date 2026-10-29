package com.testng.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testng.base.BaseTest;
import com.testng.pages.LoginPage;
import com.testng.utilities.ScreenshotUtility;

// Test contains the testcases
public class LoginTest extends BaseTest {
	WebDriver driver;
	LoginPage loginpage;
	ScreenshotUtility screenshot = new ScreenshotUtility();
	String mthdname;
	Actions actions;
	
	@BeforeMethod
	// Launch the application
	public void launch() {
		driver = launchapplication();
		loginpage = new LoginPage(driver);
		
	}
   
	// Launch the application with username alone
	@Test
	public void loginWithUserNameAlone() {
		loginpage.enterUsernameField("admin123@gmail.com");
		mthdname = Thread.currentThread().getStackTrace()[1].getMethodName();
		screenshot.takescreenshot(driver,mthdname);
		loginpage.clickLoginButton();
		driver.switchTo().alert().accept();
	}
	
	// Launch the application with invalid password 
	@Test
	public void loginWithPasswordAlone() {
		loginpage.enterPasswordField("admin123");
		mthdname = Thread.currentThread().getStackTrace()[1].getMethodName();
		screenshot.takescreenshot(driver,mthdname);
		loginpage.clickLoginButton();
		driver.switchTo().alert().accept();
	}
		
	// Launch the application with invalid username and password
	@Test
	public void loginWithInvalidCredentials() {
		loginpage.enterUsernameField("admin1234@gmail.com");
		loginpage.enterPasswordField("admin1234");
		mthdname = Thread.currentThread().getStackTrace()[1].getMethodName();
		screenshot.takescreenshot(driver,mthdname);
		loginpage.clickLoginButton();
				
	}
	
	// Launch the application with valid username and passowrd
	@Test
	public void loginWithValidCredentials() {
		loginpage.enterUsernameField("admin123@gmail.com");
		loginpage.enterPasswordField("admin123");
		mthdname = Thread.currentThread().getStackTrace()[1].getMethodName();
		screenshot.takescreenshot(driver,mthdname);
		loginpage.clickLoginButton();
	}
	
	@AfterMethod
	public void teardown() {
		//screenshot.takescreenshot(driver);
		closebrowser();
		
	}
}
