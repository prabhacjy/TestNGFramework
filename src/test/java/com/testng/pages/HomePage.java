package com.testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.testng.base.BasePage;

public class HomePage extends BasePage {
	
	//WebDriver driver;
	
	public HomePage(WebDriver driver) {
		//this.driver = driver;
		//PageFactory.initElements(driver,this);
		super(driver);
	}
	
	@FindBy(xpath="//a[text()='Home']")
	WebElement home;
	public void clickHomeTab() {
		home.click();
	}
	
	
	@FindBy(id="name")
	WebElement name;
	public void enterNameField(String nam) {
		name.sendKeys(nam);
	}
	
	@FindBy(id="lname")
	WebElement lastname;
	public void enterLastName(String lstname) {
		lastname.sendKeys(lstname);
	}
	
	@FindBy(id="postaladdress")
	WebElement postaladdr;
	public void enterPostalAddress(String addr) {
		postaladdr.sendKeys(addr);
	}
	
	@FindBy(id="personaladdress")
	WebElement personaladdr;
	public void enterPersonalAdrress(String persnladdr) {
		personaladdr.sendKeys(persnladdr);
	}
	
	@FindBy(xpath="//input[@value='female']")
	WebElement gender;
	public void clickGender() {
		gender.click();
	}
	
	@FindBy(id="city")
	WebElement citydropdown;
	
	public void selectCityDropDown(String cityval) {
		Select city = new Select(citydropdown);
		city.selectByVisibleText(cityval); 
	}
	
	@FindBy(name="course")
	WebElement coursedropdown;
	public void selectCourseDropDown(String courseval) {
		Select course = new Select(coursedropdown);
	    course.selectByValue(courseval);
	}
	
	@FindBy(id="district")
	WebElement districtdropdown;
	public void selectDistrictDropDown(int distrct) {
		Select district = new Select(districtdropdown);
		district.selectByIndex(distrct);
	}
	
	@FindBy(id="state")
	WebElement statedropdown;
	public void selectStateDropDown(int stateval) {
		Select state = new Select(statedropdown);
		state.selectByIndex(stateval);
	}
	
	@FindBy(id="pincode")
	WebElement pincode;
	public void enterPinCode(String pincod) {
		pincode.sendKeys(pincod);
	}
	
	@FindBy(id="emailid")
	WebElement emailid;
	public void enterEmailID(String emailidval) {
		emailid.sendKeys(emailidval);
	}
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submit;
	public void clickSubmitButton() {
		submit.click();
	}

}
