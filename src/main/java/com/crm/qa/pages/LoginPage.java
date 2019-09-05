package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {                 //Created PAGE LIBRARY for LoginPage 
	
	//Page Factory - OR (Object Repository):
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;  
	
	
	@FindBy (xpath = "//a[contains(text(), 'Sign Up')]")
	WebElement SignupBtn;
	
	@FindBy (xpath ="//img[contains (@class, 'img-responsive') ]")       //5 page factory or page object repositories defined
	WebElement crmLogo;                                              
	
	
	//Now Initializing elements (Page Objects) W/ help of Page Factory 
	public LoginPage() { 
		PageFactory.initElements(driver, this); //This driver coming from TestBase class cuz it's public there @ the global level
	}  
		  //***IQ: How will you initialize your Page Factory? 
		 //Ans: We use a method called PageFactory initElements() It means (initialize elements) with driver and "this", which (means point to current class "LoginPage" object's)
	    // all its variables will get initialized w/ this driver
	
	
	//Actions (features):
	public String validateLoginPageTitle(){  //Non-static
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);	
		loginBtn.submit();
		
		return new HomePage();  //Login page is the landing page of HomePage.. so it's returning HP
		
	}
}
