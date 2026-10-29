package com.testng.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testng.base.BaseTest;
import com.testng.pages.HomePage;
import com.testng.pages.LoginPage;
import com.testng.utilities.ScreenshotUtility;

public class HomeTest extends BaseTest{
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	ScreenshotUtility screenshot = new ScreenshotUtility();
	String mthdname;
	
	
	@BeforeMethod
	public void launch() {
		driver = launchapplication();
		loginpage = new LoginPage(driver);
        loginpage.enterUsernameField("admin123@gmail.com");
		loginpage.enterPasswordField("admin123");
		loginpage.clickLoginButton();
		homepage = new HomePage(driver);
	}
	
	
	@Test
	public void clickHomeTab() throws InterruptedException {
	   Thread.sleep(2000);
		

	   homepage.clickHomeTab();
	   homepage.enterNameField("Sample");
	   homepage.enterLastName("Lastname");
	   homepage.enterPostalAddress("48 Sample address1");
	   homepage.enterPersonalAdrress("48 Sample address2");
	   homepage.clickGender();
	   homepage.selectCityDropDown("NEW DELHI");
	   homepage.selectCourseDropDown("mba");
	   homepage.selectDistrictDropDown(1);
	   homepage.selectStateDropDown(2);
	   homepage.enterPinCode("1234");
	   homepage.enterEmailID("admin123@gmail.com");
	   Thread.sleep(2000);
	   mthdname = Thread.currentThread().getStackTrace()[1].getMethodName();
	   screenshot.takescreenshot(driver,mthdname);
	   homepage.clickSubmitButton();
	}
	
	@AfterMethod
	public void teardown() {
		//screenshot.takescreenshot(driver,mthdname);
		closebrowser();
	}
	
}
