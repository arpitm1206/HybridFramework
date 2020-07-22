package com.components;

import org.apache.poi.ss.usermodel.Cell;
import org.testng.Assert;

import com.google.common.base.CharMatcher;
import com.objectRepository.BaseLocators;
import com.objectRepository.RequistionLocators;
import com.utility.BaseClass;


public class RequisitionComponents extends BaseClass {

	BaseLocators loc=new BaseLocators();
	RequistionLocators Reqloc = new RequistionLocators();
	BaseComponent basecomp=new BaseComponent();

	static String str1;
	static String str2;



	public void launchApplication()throws Exception
	{
		String day = null;
		day =  todaysDay();

		try	
		{
			basecomp.LaunchApp();
			basecomp.loginOracle();
			basecomp.clickOnInstant();
			basecomp.selectSlot("dupthursday");
			basecomp.lanchDemoApp();


			readData.fullScreenCapture();
		}
		catch(Exception e)
		{
			readData.fullScreenCapture();
		}
	}
	public void ProcurementLaunch() throws Exception
	{

		try
		{


			waitForElement(Reqloc.ProcurementTab, 3);
			click(Reqloc.ProcurementTab);		

			waitForElement(Reqloc.PurchaseRequistions,3);
			click(Reqloc.PurchaseRequistions);		

			waitSD(3000);

			readData.fullScreenCapture();

		} 
		catch (Exception e) {
			readData.fullScreenCapture();		
		}

	}		

	public void RequisitionLaunch() throws Exception
	{
		try
		{
			waitForElement(Reqloc.MoreTasksDropdown,3);
			click(Reqloc.MoreTasksDropdown);
			waitSD(3000);

			waitForElement(Reqloc.RequisitionLine,2);
			click(Reqloc.RequisitionLine);

			waitSD(3000);
			readData.fullScreenCapture();
		} 
		catch (Exception e) 
		{
			readData.fullScreenCapture();		
		}
	}


	public void RequisitionDataFillingitem(String itemid, String itemname) throws Exception	
	{
		try {

			//String excelSheetPath="C:\\Users\\saikn\\Desktop\\Framework_Hybrid\\data.xlsx";
			/*
			 * Cell item_id= readData.readTestDataFile(excelSheetPath, "Sheet1", 1, 2); Cell
			 * item_name = readData.readTestDataFile(excelSheetPath, "Sheet1", 1, 3);
			 */

			waitForElement(Reqloc.itemTextBox, 2);

			click(Reqloc.itemTextBox);

			waitForElement(Reqloc.itemid, 2);

			type(Reqloc.itemid,itemid);
			click(Reqloc.itemsearch);

			waitForElement(Reqloc.itemDescription,2);
			if(getTheText(Reqloc.itemDescription) == itemname.toString());
			{
				click(Reqloc.itemDescription);
				click(Reqloc.itemsubmit);
				waitSD(10000);
			}

			readData.fullScreenCapture();
		}
		catch (Exception e) {
			readData.fullScreenCapture();		
		}
	}

	public void RequisitionDataFillingsupplier(String supplierid,String suppliername) throws Exception	
	{
		try {
			waitForElement(Reqloc.suppliertextbox,3);
			waitSD(5000);
			click(Reqloc.suppliertextbox);

			waitForElement(Reqloc.supplierid, 3);
			type(Reqloc.supplierid,supplierid.toString());

			click(Reqloc.suppliersearchbtn);
			waitSD(3000);

			waitForElement(Reqloc.suppliernumber,3);
			if(getTheText(Reqloc.suppliernumber) == suppliername.toString());
			{
				click(Reqloc.suppliernumber);
				click(Reqloc.itemsubmit);
				waitSD(3000);
			}

			readData.fullScreenCapture();
		}catch (Exception e) {
			readData.fullScreenCapture();		
		}
	}

	public void RequisitionPurchase() throws Exception	
	{
		try {

			waitForElement(Reqloc.AddtoCartbtn,2);
			verifyElementIsEnabled(Reqloc.AddtoCartbtn);

			waitSD(3000);
			click(Reqloc.AddtoCartbtn);

			waitForElement(Reqloc.AddtoCartbtn,2);
			verifyElementIsEnabled(Reqloc.Donebtn);
			click(Reqloc.Donebtn);
			waitSD(5000);

			waitForElement(Reqloc.ShoppingCartbtn, 2);
			verifyElementIsEnabled(Reqloc.ShoppingCartbtn);
			click(Reqloc.ShoppingCartbtn);	
			waitSD(15000);

			waitForElement(Reqloc.SubmitCartbtn, 2);
			click(Reqloc.SubmitCartbtn);
			waitSD(5000);

			readData.fullScreenCapture();

		}	catch (Exception e) {
			readData.fullScreenCapture();		
		}
	}
	/*
	 * String str1 = getAlertMessageText(); System.out.println(str1); String str2 =
	 * CharMatcher.inRange('0', '9').retainFrom(str1); System.out.println(str2);
	 * //alert1.getDigitfromAlertMessageText();
	 */			

	//alertaction("ok");

	public void RequisitionID() throws Exception
	{
		try 
		{
			waitForElement(Reqloc.Alertid,2);
			str1 =	CharMatcher.inRange('0', '9').retainFrom(getTheText(Reqloc.Alertid));	

			System.out.println(str1);

			//readData.writeTestDataFile(excelSheetPath, "Sheet1", 1, 6, str1);


			waitForElement(Reqloc.Alertsubmit,2);
			click(Reqloc.Alertsubmit);
			waitSD(3000);

			readData.fullScreenCapture();

		}catch (Exception e) {
			readData.fullScreenCapture();		
		}
	}

	public void ManageRequisition() throws Exception
	{
		try 
		{

			/*
			 * waitForElement(Reqloc.ManageRequisitions, 15);
			 * 
			 * click(Reqloc.ManageRequisitions); waitSD(3000);
			 * //type(Reqloc.RequisitionsSearch,str2);
			 * click(Reqloc.SubmitRequisitionsSearch); click(Reqloc.SpanApproved);
			 */
			click(Reqloc.Homebtn);

			waitSD(5000);

			/*
			 * waitForElement(Reqloc.visionicon, 15); click(Reqloc.visionicon);
			 * waitSD(3000);
			 */

			waitForElement(Reqloc.ProcurementTab, 2);
			click(Reqloc.ProcurementTab);

			waitSD(5000);

			waitForElement(Reqloc.PurchaseOrders, 2);
			click(Reqloc.PurchaseOrders);
			waitSD(3000);

			waitForElement(Reqloc.Taskbtn,2);
			click(Reqloc.Taskbtn);
			waitSD(3000);


			readData.fullScreenCapture();
		}catch (Exception e) {
			readData.fullScreenCapture();		
		}

	}

	public void ProcessRequisition() throws Exception
	{
		try 
		{
			waitForElement(Reqloc.ProcessRequisitions,2);
			click(Reqloc.ProcessRequisitions);
			waitSD(3000);

			waitForElement(Reqloc.ProcessRequisitionsSearchbox,2);
			type(Reqloc.ProcessRequisitionsSearchbox,str1);
			waitSD(3000);

			waitForElement(Reqloc.ProcessRequisitionsSearchbtn,2);
			click(Reqloc.ProcessRequisitionsSearchbtn);


			waitForElement(Reqloc.ProcessRequisitionsFirstResult, 3);

			click(Reqloc.ProcessRequisitionsFirstResult);
			waitSD(3000);

			waitForElement(Reqloc.DocumentBuilderhbtn, 2);
			waitSD(3000);
			click(Reqloc.DocumentBuilderhbtn);

			waitSD(3000);
			waitForElement(Reqloc.DocumentBuilderhbtnsubmit, 2);
			click(Reqloc.DocumentBuilderhbtnsubmit);

			readData.fullScreenCapture();

		}catch (Exception e) {

			readData.fullScreenCapture();		
		}

	}



	public void VerifyRequisition() throws Exception
	{
		try 
		{

			waitForElement(Reqloc.createbtn, 2);

			pressPageDownKey();
			pressPageDownKey();
			waitSD(5000);
			click(Reqloc.createbtn);
			waitSD(5000);

			str2 =
					CharMatcher.inRange('0', '9').retainFrom(getTheText(Reqloc.CreateAlert2));	
			System.out.println(str2);

			//readData.writeTestDataFile(excelSheetPath, "Sheet1", 1, 7, str2);

			click(Reqloc.createbtnsub);

			waitSD(5000);

			waitForElement(Reqloc.createbtnsubmit,3);
			click(Reqloc.createbtnsubmit);
			waitSD(2000);

			waitForElement(Reqloc.Taskbtn,2);
			click(Reqloc.Taskbtn);
			waitSD(2000);

			waitForElement(Reqloc.ManageOrders,2);
			click(Reqloc.ManageOrders);
			waitSD(3000);

			waitForElement(Reqloc.orderserachbox,2);
			type(Reqloc.orderserachbox,str2);
			waitSD(2000);
			click(Reqloc.searchbtn);
			waitSD(3000);

			waitForElement(Reqloc.Homebtn, 2);
			click(Reqloc.Homebtn);

			readData.fullScreenCapture();

		} catch (Exception e) {
			readData.fullScreenCapture();		

		}	}
}
