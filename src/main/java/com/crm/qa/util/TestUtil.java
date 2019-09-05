package com.crm.qa.util;

import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{    //This class makes is Data Driven!
	
	public static long PAGE_LOAD_TIMEOUT = 20; //Since  pageLoadTimeout & implicitlyWait is long in Base class, it is long here as well 
	public static long IMPLICIT_WAIT = 10;
	
	public static String TESTDATA_SHEET_PATH = "Users/jewellmehedi/Documents/eclipse-workspace/FreeCRMPRO_Automation/JF_CRMAutomation/src/main/java/com/crm/qa/testdatasheet/FreeCRMPROTestData.xlsx";
	                                                         //Path from X-cel Sheet, right click properties..                  
	static Workbook book;
	static Sheet sheet;///Users/jewellmehedi/Documents/eclipse-workspace/FreeCRMPRO_Automation/JF_CRMAutomation/src/main/java/com/crm/qa/config/config.properties   
	
	
	public void swithToFrame() {//SwithToFrame method used to VerfifyHomePageTitleTest() & verifyContactsLinkTest() method in HomePageTest cuz it is in different panel
		driver.switchTo().frame("mainpanel");   
	}


	public static Object[][] getTestData(String sheetName) {
		return null;
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
	

