package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {                 //We created PAGE LIBRARY for LoginPage 
	
	//Page Factory - OR (Object Repository):
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath="//button[contains(text(),'Sign Up']")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;                                           //5 page factory or page object repositories defined
	
	
	//Initializing all the Page Objects above
	public LoginPage() {  //***IQ: How will you initialize your Page Factory? 
		
		PageFactory.initElements(driver, this); //Ans: We use a method called PageFactory dot init Element means (initialize elements) with driver and "this" (means point to current class "LoginPage" object's)
	}                                          // all its variables will get initialized
	
	
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
		loginBtn.click();
		
		return new HomePage();
		
	}

}
