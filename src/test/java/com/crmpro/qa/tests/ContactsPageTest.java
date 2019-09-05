/*
 * 
 * @Author: JewellM
 * 
 */





package com.crmpro.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
	
	String sheetName = "contacts";

	
	public ContactsPageTest() { //Need this constructor with super keyword so it calls super class constructor from (TestBase)
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
		Assert.assertTrue(contactsPage.verfifyContactsLabel());
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
	
	@DataProvider
	public Object[][] getCRMPROTestData() {
		Object data [][] = TestUtil.getTestData(sheetName); //If we have 100 rows of data in excel sheet, it will be stored in data[][]
		return data;
	}
	
	@Test(priority=4, dataProvider="getCRMPROTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company) {
		homePage.clickOnNewContactLink();
		 //Once @DataProvider from above is set and we brought it to this TC via getCRMPROTestData then we don't need hard to code as shown below
		//contactsPage.createNewContact("Mr.", "VeryWeaktoStrong", "Goggins", "Seal");  //Problem is this is hard coded, so if we have to create 100 contacts tomorrow 
	   //with different sort of data or different negative testing.. values so we'll use: Data Driven Approach 
		contactsPage.createNewContact(title, firstName, lastName, company);
	}
	
	@AfterMethod
	public void tearDown() {   //***TC should be separated & independent of each other. Because if it didn't fully shut down a browser after executing it 
		driver.quit();        //and continue to run subsequent TCs therefore did not delete cookies or caches then it can determinately affect on the browser
		
	}                        
}
