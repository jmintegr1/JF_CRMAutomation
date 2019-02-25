package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.mongodb.MapReduceCommand.OutputType;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 20; //Since  pageLoadTimeout & implicitlyWait is long in Base class, it is long here well 
	public static long IMPLICIT_WAIT = 10;
	
	public static String TESTDATA_SHEET_PATH = "/Users/jewellmehedi/eclipse-workspace/JFreeCRM_POM/src/main/java/com/crm/qa/testdatasheet/FreeCRMPROTestData.xlsx";
	                                                         //Path from X-cel Sheet, right click properties..                  
	static Workbook book;
	static Sheet sheet;
	
	
	public void swithToFrame() {//SwithToFrame method used for VerfifyHomePageTitleTest() & verifyContactsLinkTest() method in HomePageTest cuz it is in different panel
		driver.switchTo().frame("mainpanel");   
	}
	
	
//		public static Object[][] getTestData(String sheetName){
//		FileInputStream file = null;
//		try {
//			file = new FileInputStream(TESTDATA_SHEET_PATH);
//		}catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		try {
//			book = WorkbookFactory.create(file);
//		} catch (InvalidFormatException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		//sheet = book.getSheet(sheetName);
		//Object[][] data = new Object(sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		//for(int i = 0; i <sheet.getLastRowNum(); i++) {
			//for(int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				//data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				//return data;
		
//		public static void takeScreenShotAtEndOfTest() throws IOException{
//			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			String currentDir = System.getProperty("user.drive");
//			
//			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
//			
//		}
//	
	}
	

