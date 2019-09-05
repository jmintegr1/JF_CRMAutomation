package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectBase {     //Ibrahim's example of how real environment does it:  as they use two different classes like TestBase or PageObjectBase. 
	                             //One to call all the Pages & to call and one of TC to call what data needed, NOT all data is being called from single class like TestBase
	protected WebDriver driver;
	//protected Actions action;
	
	public PageObjectBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//action = new Actions(driver);
	}

}
