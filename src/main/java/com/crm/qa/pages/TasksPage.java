package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TasksPage extends PageObjectBase {  //Ibrahim's example of how real world environment does it:  as they use two different pages like TestBase or  
	                                        //Study like David Goggins.... 
	public TasksPage(WebDriver driver) {
		super(driver);
	}

	@FindBy()
	WebElement a;
	
	@FindBy()
	WebElement b;
	
	@FindBy()
	WebElement c;
	
	@FindBy()
	WebElement d;
	
	public void sendsomething() {
		a.sendKeys("Send Something");
	}
	
	public void dosomething() {
		b.click();
	}

}
