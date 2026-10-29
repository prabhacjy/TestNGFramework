package com.testng.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import com.testng.base.BasePage;

public class SwitchToPage extends BasePage {

	protected WebDriver driver;
	Actions actions;
	
	public SwitchToPage(WebDriver driver) {
		//this.driver = driver;
		//PageFactory.initElements(driver,this);
		super(driver);
		this.driver = driver;

	}
	
	@FindBy(xpath="//button[contains(text(),'Switch To')]")
	WebElement switchtotb;
	public void moveToSwitchToTab() throws InterruptedException {
		Thread.sleep(5000);
		actions = new Actions(driver);
		actions.moveToElement(switchtotb).build().perform();
	}
	
	@FindBy(xpath="//a[text()='Alert']")
	WebElement alert;
	public void clickAlertOption() {
		alert.click();
	}

	@FindBy(xpath="//button[text()='Window Alert']")
	WebElement windowalert;
	public void clickWindowAlert() {
		windowalert.click();
		driver.switchTo().alert().accept();
	}
	
	@FindBy(xpath="//button[text()='Promt Alert']")
	WebElement promptalert;
	public void clickPromptAlert() throws InterruptedException {
		promptalert.click();
		driver.switchTo().alert().sendKeys("prabha");
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
	}
	
	@FindBy(xpath="//a[text()='Windows']")
	WebElement windows;
	public void clickWindowsOption() {
		windows.click();
	}
	
	@FindBy(xpath="//button[contains(text(),'Tab')]")
	WebElement openNewTab;
	public void openNewTab() throws InterruptedException {
		
		openNewTab.click();
		
		Set<String> windowHandles = driver.getWindowHandles(); // stores the values(current page id and new tab(google id))
        String currentHandle = driver.getWindowHandle(); // stores the id of the current session page     
        
        System.out.println("Current Handle"+currentHandle);
        
        for(String handle: windowHandles) {
         System.out.println(handle);
         driver.switchTo().window(handle);
        }
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        
        String newTabHandle = driver.getWindowHandle();
        System.out.println("newTabHandle"+newTabHandle);
        driver.findElement(By.name("q")).sendKeys("Selenium");
        Thread.sleep(2000);
        
        driver.switchTo().window(currentHandle);
        System.out.println(driver.getTitle());
	}
	
	@FindBy(xpath="//button[contains(text(),'Window')]")
	WebElement openNewWindow;
	public void clickOpenNewWindow() throws InterruptedException {
		openNewWindow.click();
		// Calling the collections set to get the idies of current session and new opened window (google) id
		Set<String> windowHandleswinbutton = driver.getWindowHandles();
        // printing the current home page session id
		String currentHandlewinbutton = driver.getWindowHandle();
		System.out.println("Current Handle"+currentHandlewinbutton);
        for(String handlewinbutton: windowHandleswinbutton) {
        	System.out.println(handlewinbutton);
        	driver.switchTo().window(handlewinbutton);
        	
        }
        System.out.println(driver.getTitle());
        String newWindowTabHandle = driver.getWindowHandle();
        System.out.println("newWindowTabHandle"+newWindowTabHandle);
        driver.findElement(By.name("q")).sendKeys("Java");
        Thread.sleep(2000);
        
        driver.switchTo().window(currentHandlewinbutton);
        System.out.println(driver.getTitle());
  
	}
	

	@FindBy(xpath="//a[text()='Tabs']")
    WebElement tabs;
	public void clickSwitchToTabsDropDown() {
		tabs.click();
	}
	
	@FindBy(xpath="//button[text()='London']")
	WebElement london;
	public void clickSwitchToTabsLondon() {
		london.click();
	}
	
	@FindBy(xpath="//button[text()='Paris']")
	WebElement paris;
	public void clickSwitchToTabsParis() {
		paris.click();
	}
	
	@FindBy(xpath="//button[text()='Tokyo']")
	WebElement tokyo;
	public void clickSwitchToTabsTokyo() {
		tokyo.click(); 
	}
}
