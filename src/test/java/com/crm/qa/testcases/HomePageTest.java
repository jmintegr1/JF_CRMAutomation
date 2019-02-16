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

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;  //Create TestUtil Object then import it from com.crm.qa.util
	ContactsPage contactsPage; //Create contactsPage reference and initialize @ line 29

	
	public HomePageTest() {
		super();  //Calls super class constructor (TestBase)
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{ 
		initialization();   //below initialized the 3 reference objects above
		testUtil = new TestUtil(); 
		contactsPage = new ContactsPage();
		loginPage = new LoginPage(); 
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}
	
	@Test(priority=1)
	public void verfifyHomePageTitleTest() {     //For Test method always write Test at the end, so prefix or suffix communicates clearly whoever is reading it
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home page title not matched"); //With assertion we can write one more variable, pass a string message as well 
	}                                                 //This string message will ONLY be displayed during reporting if assertion is failing
	
	@Test(priority=2)  //Jewell Mehedi element is available on particular frame, so right click to page source then you'll see frame name is on "mainpanel" so we 
	public void verifyUserNameTest() {   //have to switch to that frame.
		testUtil.swithToFrame(); //Will call method from TestUtil class and switch to the frame then verifying verifyCorrectUserName method from HomePage  
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		testUtil.swithToFrame(); //This element is also on different frame so use swithToFrame from TestUtil class as well 
		contactsPage = homePage.clickOnContactsLink(); //Since this is returning ContactsPage object I will store it inside it
	}
	
	@AfterMethod
	public void tearDown() {   //***TC should be separated & independent of each other. Because if don't fully shut down a browser after executing it 
		driver.quit();        //and continue to run subsequent TCs continuously and not delete cookies or caches then it has determinately affect on the browser
	}                        //1. Before each TC -- launch the browser & login 
	                        //2. @Test -- execute TC
	                       //3. After each TC -- closer the browser
	
}
