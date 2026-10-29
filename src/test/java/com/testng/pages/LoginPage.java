package com.testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testng.base.BasePage;

//Page contains the find elements and methods to perform actions init

public class LoginPage extends BasePage {
	
	//WebDriver driver;
	
	//driver.findElement - to find elements we need the driver since the annotation @Test doesn't have
	//driver to provide the driver we need the constructor for this page "LoginPage" that accepts the
    //WebDriver 
	
	public LoginPage(WebDriver driver) {
		//this.driver = driver;
		//PageFactory.initElements(driver,this);
		super(driver); // instead of above two steps the driver is initialized in parent BasePage
		// The framework is the page object model 
		// The Design pattern is PageFactory
	}
	
	
	@FindBy(id="email_field")
	WebElement email;
	
	@FindBy(id="password_field")
	WebElement password;
	
	@FindBy(xpath="//button[text () = 'Login to Account']")
	WebElement loginbutton;
	
	public void enterUsernameField(String username) {
		email.sendKeys(username);
	}
	
	public void enterPasswordField(String passwrd) {
		password.sendKeys(passwrd);
	}
	
	public void clickLoginButton() {
		loginbutton.click();
	}

}
