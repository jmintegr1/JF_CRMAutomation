package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;  
	ContactsPage contactsPage; 

	
	public ContactsPageTest() { //Need this constructor with super keyword so calls super class constructor (TestBase)
		super();  
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{ 
		initialization();   //below initialized the 3 reference objects above
		testUtil = new TestUtil(); 
		contactsPage = new ContactsPage();
		loginPage = new LoginPage(); 
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.swithToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabe() {
		Assert.assertTrue(contactsPage.verfifyContactsLabel(), "contacts label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest() {
		contactsPage.selectContactsByName("Nav Smith");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest() { //By using having flexible method in ContactsPage we can check mark as many names here in ContactsPageTest

		contactsPage.selectContactsByName("Nav Smith");
		contactsPage.selectContactsByName("Test Run ");
        
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown() {   //***TC should be separated & independent of each other. Because if don't fully shut down a browser after executing it 
		driver.quit();        //and continue to run subsequent TCs continuously and not delete cookies or caches then it has determinately affect on the browser
	}                        

}
