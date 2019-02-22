package com.crmpro.qa.tests;


import org.testng.Assert;                        
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

	public class LoginPageTest extends TestBase {    
	LoginPage loginPage; //Created an object first @ line 23 then took the variable & brought to class level, this 
	HomePage homePage;  //provides the flexibility to use it through out the program 
	
	public LoginPageTest() {
		super();  //Calls super class constructor (TestBase)
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{ 
		initialization(); //Method is called from parent (TestBase)
		loginPage = new LoginPage(); ////By Instantiating loginPage here  we can access all functions/methods from LoginPage class, we have to cuz
	    //LoginPage is non-static 
		//After above then it will come in Setup method then initialize by method below, then we don't get Null pointer exception cuz the properties are defined in Parent class.	
	}
	
	//Created object of LoginPage above so can access of all functions & methods of LoginPage class
	@Test(priority = 1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO  - CRM software for customer relationship management, sales, and support"); //Assert helps to validate what is the actual page title 
	}                               //We get title by being logged out, page source 
	
	@Test(priority = 2)
	public void crmLogoImageTest(){
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
		             //If flag condition is true then our assertion will pass or it will fail 
	}
	
	@Test(priority = 3)
	public void loginTest(){ //We didn't hard code it, that's why we store this info in config properties and by LoginPageTest class "extends" TestBase, can access login info
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}                            //Prop helps to get login info from config properties which is initialized in TestBase which is inherited by Extends

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		
	}

}
