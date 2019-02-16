package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {  //Both reference variables defined right after class and inside constructor
	
	public static WebDriver driver; //Gets initialized once line 43 is written.. means inside child class I use it as well 
	public static Properties prop; //Define this property 
	
	
	public TestBase(){  //Gets called by all PageTest classes constructors with "super" keyword 
		try {
			prop = new Properties();   //This property above is getting initialized here
			FileInputStream ip = new FileInputStream("/Users/jewellmehedi/eclipse-workspace/JFreeCRM_POMTest/src/main/java/com/crm/qa"
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
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));  //Advantage of prop, can use prop inside the initialization method  
		//because we defined prop at the global level	
		
	}
	
}
