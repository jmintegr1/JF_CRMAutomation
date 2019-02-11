package com.crm.qa.util;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 20; //Since  pageLoadTimeout & implicitlyWait is long in Base class, it is long here well 
	public static long IMPLICIT_WAIT = 10;
	
	
	public void swithToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	
	

}
