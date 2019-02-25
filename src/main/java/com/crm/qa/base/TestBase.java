package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;     
import java.io.IOException;
import java.util.EventListener;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {  //Both reference variables defined right after class and inside constructor
	
	public static WebDriver driver; ////Make it public so use in Child class as well    |   Gets initialized once line 43 is written.. means inside child class I use it as well 
	public static Properties prop; //Porp is short for Properties which is getting Initialized below in Try Catch block 
	public TestBase(){  //Gets called by all PageTest classes constructors with "super" keyword 
		try {
			prop = new Properties();   //This property above is getting initialized here
			FileInputStream ip = new FileInputStream("/Users/jewellmehedi/eclipse-workspace/JFreeCRM_POM/src/main/java/com/crm/qa"
					+ "/config/config.properties"); 
			prop.load(ip);	
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		} catch (IOException e) {
			    e.printStackTrace();
		}	
	}
	
	
		//public static void initialization() throws InterruptedException{
		//String browserName = prop.getProperty("browser");   //Prop assist in reading properties
		
		/*if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
			driver = new ChromeDriver(); //Refers to WebDriver driver; variable above.. line 17
		
		
		/*else if(browserName.equals("FF")) {
				System.setProperty("webdriver.gecko.driver", "/Users/jewellmehedi/Downloads/geckodriver");
				driver = new FirefoxDriver(); 	
		}*/
		
		public static void initialization() throws InterruptedException{
		String browserName = prop.getProperty("browser");
		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
		driver = new ChromeDriver();  //This line initialize above driver variable line 17 gets initialized, now I use it inside child class
		
		//e_driver = new EventFiringWebDriver(driver);
//		e_driver = new EventFiringWebDriver(driver);
//		//Now create object of EvenListenerHandler to register it with EventFiringWebDriver 
//		e_driver.register(eventListener);
//		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));  //Advantage of prop, can use prop inside the initialization() method  
		//because we defined prop at the global level
		
		
	}
	
}
