package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	//So let's say now we want to click on check box for Nav Smith	
	
	//driver.findElement(By.xpath("//a[text()='Nav Smith']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	//This find by parent sibling and child approach is not optimal since it is ONLY specific for "Nav Smith". Let's say tomorrow I have to select on "Test Run" or many others then I have 
	//create another @ (at the rate) find by so if I have to select 100 contacts then I have to write 100 @ so in this case we want to use PAGE FACTORY. So we'll write our code
	//directly here line 

	
	//Initializing the Page Objects above
	public ContactsPage() {  //***IQ: How will you initialize your Page Factory? 
	PageFactory.initElements(driver, this);   //Using the above class name ContactsPage and method below.. 
	}	                     //Ans: We use a method called PageFactory dot init Element means (initialize elements) with driver and "this" (means point to current class "ContactsPage" object's)
	                                          // all its variables will get initialized
		
	public boolean verfifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name) { //This '"+name+"' prevents from hard coding and keeps it flexible to get around the problem of above 
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']"
				+ "//input[@name='contact_id']")).click();
		//By using this flexible method now we can check mark as many names as there can be in ContactsPageTest
	}

}