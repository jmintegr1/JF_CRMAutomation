package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {  //Both reference variables defined right after class and inside the constructor
	
	public static WebDriver driver; ////Make it public so it can be used in Child class as well    |   Gets initialized once line 42 is written.. means inside child class so I can use it as well 
	public static Properties prop; //Prop is short for Properties which is getting Initialized below in Try Catch block
	public static EventFiringWebDriver e_driver;
	
	public TestBase(){  //Gets called by all PageTest classes constructors with "super" keyword 
		try {
			prop = new Properties();   //The property (class/global variable) is getting initialized here
			FileInputStream ip = new FileInputStream("/Users/jewellmehedi/Documents/eclipse-workspace/FreeCRMPRO_Automation/JF_CRMAutomation/src/main/java/com/crm/qa/config/config.properties"); 
			prop.load(ip);
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		} catch (IOException e) {
			    e.printStackTrace();
		}	
	}
	
	
		public static void initialization() throws InterruptedException {
			
			String browserName = prop.getProperty("browser");   //Prop assist in reading properties
			if (browserName.contains("chrome")) { // If using equals, you have to ensure that the String is matching exactly, even a space before the text "chrome" will be counted as a character
				//System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
			     //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver"); // System.getPropert("user.dir") you will need to get you the current space you are in, eg. the Project level.
				// This way you are ensuring if anyone wants to run this test on their environment, they don't have to have the ChromeDriver in their local environment, as long there is FF driver then they can run it.
				driver = new ChromeDriver(); //Refer to WebDriver as driver; variable above.. line 18
			}
		
			else if(browserName.contains("FF")) {
			// else if (browserName.equals("FF")) { // By putting contains() method in above line of code, you are looking at any string value, as long as it CONTAINS the value "FF", it'll find it and run it.
				System.setProperty("webdriver.gecko.driver", "/Users/jewellmehedi/Downloads/geckodriver");
				driver = new FirefoxDriver(); 	
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
			
			driver.get(prop.getProperty("url"));  //Advantage of prop is we can use prop inside the initialization() method  
			//because we defined prop at the global level
			
		}
		
		public static void initializationXX() throws InterruptedException{  
			String browserName = prop.getProperty("browser");
			System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");   
			driver = new ChromeDriver();  //This line initialize above driver variable line 19 gets initialized, now I can use it inside child class
		
//		e_driver = new EventFiringWebDriver(driver);
//		//Now create object of EvenListenerHandler to register it with EventFiringWebDriver  
//		eventListener = new WebEventListener();
//		e_driver.register(eventListener);
//		driver = e_driver;
		
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));  //Advantage of prop is we can use prop inside the initialization() method  
		//because we defined prop at the global level

		}	
}
