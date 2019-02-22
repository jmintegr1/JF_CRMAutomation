package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;   //We created PAGE LIBRARY for HomePage 

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(texgt(), 'User: jmintegr1')]") //input[@placeholder='Username']  //Hard coded here but later  I can pass it from configuration file 
	WebElement userNameLabel; 
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	

	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	//Initializing all the Page Objects above
	public HomePage() {  //***IQ: How will you initialize your Page Factory? 
		
		PageFactory.initElements(driver, this);  //Ans: We create a constructor of HomePage here and use a method called PageFactory dot init Element means 
		                                        //(initialize elements) with driver and "this" (means point to current class "LoginPage" object's) then all its variables will get initialized
	}                                          
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickDealsLink() {
		dealsLink.click();
		return new DealsPage();	
	}
	
	public TasksPage clickTaskLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
}
