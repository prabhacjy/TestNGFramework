package com.testng.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testng.base.BaseTest;
import com.testng.pages.LoginPage;
import com.testng.pages.SwitchToPage;
import com.testng.utilities.ScreenshotUtility;

public class SwitchToTest extends BaseTest {
	
	WebDriver driver;
	LoginPage loginpage;
	SwitchToPage switchtopage;
	ScreenshotUtility screenshot = new ScreenshotUtility();
	String mthdname;
	
	@BeforeMethod
	public void launch() throws InterruptedException {
		driver = launchapplication();
		loginpage = new LoginPage(driver);
        loginpage.enterUsernameField("admin123@gmail.com");
		loginpage.enterPasswordField("admin123");
		loginpage.clickLoginButton();
		Thread.sleep(2000);
		switchtopage = new SwitchToPage(driver);
	}
	
	@Test
	public void performMoveToSwitchToTab() throws InterruptedException{
		Thread.sleep(5000);
		switchtopage.moveToSwitchToTab();
		mthdname = Thread.currentThread().getStackTrace()[1].getMethodName();
		screenshot.takescreenshot(driver,mthdname);
	}
	
	@Test
	public void clickAlertSwitchToDropDown() throws InterruptedException {
		Thread.sleep(1000);
		switchtopage.moveToSwitchToTab();
		
		switchtopage.clickAlertOption();
	
		switchtopage.clickWindowAlert();
		
		switchtopage.clickPromptAlert();
		mthdname = Thread.currentThread().getStackTrace()[1].getMethodName();
		screenshot.takescreenshot(driver,mthdname);
	}
	
	@Test
	public void clickWindowsSwitchToDropDowm() throws InterruptedException {
		Thread.sleep(1000);
		switchtopage.moveToSwitchToTab();
		Thread.sleep(1000);
		mthdname = Thread.currentThread().getStackTrace()[1].getMethodName();
		screenshot.takescreenshot(driver,mthdname);
		switchtopage.clickWindowsOption();
		switchtopage.openNewTab();
		mthdname = Thread.currentThread().getStackTrace()[1].getMethodName();
		screenshot.takescreenshot(driver,mthdname);
		switchtopage.clickOpenNewWindow();
	}
	
	@Test
	public void clickTabsSwitchToDropDown() throws InterruptedException {
		Thread.sleep(1000);
		switchtopage.moveToSwitchToTab();
		Thread.sleep(1000);
		switchtopage.clickSwitchToTabsDropDown();
		switchtopage.clickSwitchToTabsLondon();
		switchtopage.clickSwitchToTabsParis();
		switchtopage.clickSwitchToTabsTokyo();
		mthdname = Thread.currentThread().getStackTrace()[1].getMethodName();
		screenshot.takescreenshot(driver,mthdname);
	}
	
	@AfterMethod
	public void teardown() {
		//screenshot.takescreenshot(driver);
		closebrowser();
		
	}
	
}
