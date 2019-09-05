package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;   //We created PAGE LIBRARY for HomePage 

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'User: Jewell Mehedi')]") //input[@placeholder='Username']  //Hard coded here but  I can also pass it from configuration file 
	@CacheLookup //In Cache Memory where it will hold the data to speed up
	
	//***How will you improve your script performance?
	//CacheLookup - Is a Selenium annotation that will store a particular user label name or element in a Cache, in a dedicated memory. So whenever we are interacting with this element, instead of the 
	//page, it will get that particular element from the Cache. So it speeds up framework as well as the performance of the script. It speeds up because the elements does not have 
	//to be retrieved from HTML Dom, it can just pull it from Cache.
	 
	//When there is refresh and things changes or elements changes and we depend on Cache Memory (CM) then we'll get = StaleElemntException. That's why we use Cache Lookup when we are sure that particular 
	//element will NOT change. 
	
	WebElement userNameLabel; 

	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(), 'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	

	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	//Initializing all the Page Objects above
	public HomePage() {                            //***IQ: How will you initialize your Page Factory? 
		
		PageFactory.initElements(driver, this);  //Ans: We create a constructor of the page we want to initialize (here HomePage) and use a class called PageFactory.initElements() method which means 
		                                        //(initialize elements) with driver, and "this" (means point to current class "HomePage" object's) then all its variables will get initialized
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
	
//	public TasksPage clickTaskLink() {  //Ibrahim's example for..
//		tasksLink.click();
//		return new TasksPage();
//	}
	
	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform(); //When used Action classes we have to use .build().perform(); 
		newContactLink.click();
		
		
	}
	
}
