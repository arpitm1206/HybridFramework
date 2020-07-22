package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;


public class TestUtil extends BaseClass 
{

	public static String screenshotPath;
	public static String screenshotName;
	public static Properties prop = new Properties();	
	public static String path = null;
	public static ExcelReader excel = null;
	public static String actualSheetName = null;


	@DataProvider(name="dp")
	public Object[][] getData() throws IOException {

		FileInputStream configfile = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\lib\\config.properties");		
		prop.load(configfile);
		if(currently_Executing_Class_Name.contains("GeneralAccounting_Script"))
		{
			path = prop.getProperty("createJournal_sheetPath");
			actualSheetName = prop.getProperty("createJournal_sheetName");
		}
		
		if(currently_Executing_Class_Name.contains("PayablessScript2"))
		{
			path = prop.getProperty("createInVoice_sheetPath");
			actualSheetName = prop.getProperty("createInVoice_sheetName");
		}
		if(currently_Executing_Class_Name.contains("RequisitionScript"))
		{
			path = prop.getProperty("createRequisition_sheetPath");
			actualSheetName = prop.getProperty("createRequisition_sheetName");
		}

		excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\"+path+".xlsx");
		int rows = excel.getRowCount(actualSheetName);
		int cols = excel.getColumnCount(actualSheetName);
		Object[][] data = new Object[rows - 1][1];
		Hashtable<String,String> table = null;

		List<String> sheetNames = excel.getSheetName();

		for(String sheetName : sheetNames) {
			if(sheetName.equalsIgnoreCase(actualSheetName)) {

				for (int rowNum = 2; rowNum <= rows; rowNum++) { 

					table = new Hashtable<String,String>();

					for (int colNum = 0; colNum < cols; colNum++) {

						// data[0][0]
						table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
						data[rowNum - 2][0] = table;
					}
				}
			} else {
				System.out.println("Unable to find the Sheet : " +sheetName);
			}
		}	

		return data;
	}


	/*public static boolean isTestRunnable(String testName, ExcelReader excel){

		String sheetName="Sheet1";
		int rows = excel.getRowCount(sheetName);
		boolean status = false;

		for(int rNum=2; rNum<=rows; rNum++){

			String testCase = excel.getCellData(sheetName, "TCID", rNum);

			if(testCase.equalsIgnoreCase(testName)){

				String runmode = excel.getCellData(sheetName, "Runmode", rNum);

				if(runmode.equalsIgnoreCase("Y")) {
					status = true;

				}  else {
					status = false;
				}
			}
			return status;
		}
		return status;

	}*/

}
