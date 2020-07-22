package com.testScripts;

import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.components.RequisitionComponents;
import com.objectRepository.RequistionLocators;
import com.utility.BaseClass;
import com.utility.TestUtil;

public class RequisitionScript extends BaseClass {
	
	RequistionLocators Reqloc = new RequistionLocators();
	RequisitionComponents Rcomp = new RequisitionComponents();
	public Logger log = Logger.getLogger(PayablessScript2.class);	

	// @Guice
	@Test(description = "launchApplication"/* , dataProviderClass=TestUtil.class,dataProvider="dp" */, priority = 0)
	public void launchApplication() throws Exception {

		extent_Test = extent_Reports.createTest("launchApplication");

		Rcomp.launchApplication();
		
	}

	@Test(description = "RequisitionProcess",dataProviderClass=TestUtil.class,dataProvider="dp", priority = 1)
	public void RequisitionProcess(Hashtable<String,String> data) throws Exception {
		
		String itemid = data.get("Item ID");
		String itemname = data.get("ItemName");
		String supplierid = data.get("SupplierID");
		String suppliername = data.get("SupplierName");

		extent_Test = extent_Reports.createTest("RequisitionProcess");

		 if(previous_Test_resultStatus.getStatus() == ITestResult.SUCCESS )
		 {
	
			 Rcomp.ProcurementLaunch();
			 Rcomp.RequisitionLaunch();
			 
			 Rcomp.RequisitionDataFillingitem(itemid,itemname);
			 Rcomp.RequisitionDataFillingsupplier(supplierid,suppliername);
			 
			 Rcomp.RequisitionPurchase();
			 
			 Rcomp.RequisitionID();
			 
			 Rcomp.ManageRequisition();
			 Rcomp.ProcessRequisition();
			 
			 Rcomp.VerifyRequisition();
			 
			 
		
		 }	else { 
		throw new SkipException(":::::SKIPPED:::::: "); 
		}

	}

	/*@Test(description = "RequisitionDataUpdating", dataProviderClass=TestUtil.class,dataProvider="dp" , priority = 2)
	public void RequisitionDataUpdating(Hashtable<String,String> data) throws Exception {

		extent_Test = extent_Reports.createTest("RequisitionDataUpdating");

		 if(previous_Test_resultStatus.getStatus() == ITestResult.SUCCESS ) {
			 
			 
			 	String itemid = data.get("Item ID");
				String itemname = data.get("ItemName");
				String supplierid = data.get("SupplierID");
				String suppliername = data.get("SupplierName");
						

		
			 Rcomp.RequisitionDataFillingitem(itemid,itemname);
			 Rcomp.RequisitionDataFillingsupplier(supplierid,suppliername);
			 
			 Rcomp.RequisitionPurchase();
			 
			 Rcomp.RequisitionID();
			 
			 Rcomp.ManageRequisition();
			 Rcomp.ProcessRequisition();
			 
			 Rcomp.VerifyRequisition();
		
		 }else { 
		throw new SkipException(":::::SKIPPED:::::: "); }
		 

	}


	@Test(description = "RequisitionPurchase",  retryAnalyzer = com.utility.iRetryAnalyzer.class, priority = 3)
	public void RequisitionPurchase() throws Exception {

		extent_Test = extent_Reports.createTest("RequisitionPurchase");

		 if(previous_Test_resultStatus.getStatus() == ITestResult.SUCCESS ) 
		 {
			 Rcomp.RequisitionPurchase();
			 
			 Rcomp.RequisitionID();
			 
		 }else { 
		throw new SkipException(":::::SKIPPED:::::: "); 
		 
		 }
	}

	@Test(description = "ProcessRequisition", priority = 4)
	public void ProcessRequisition() throws Exception {

		extent_Test = extent_Reports.createTest("ProcessRequisition");
		
		if(previous_Test_resultStatus.getStatus() == ITestResult.SUCCESS ) {
	
			Rcomp.ManageRequisition();
			Rcomp.ProcessRequisition();
		
		}else { 
		throw new SkipException(":::::SKIPPED:::::: "); 
		}
		

	}

	@Test(description = "VerifyRequisition", priority = 5)
	public void VerifyRequisition() throws Exception {

		extent_Test = extent_Reports.createTest("VerifyRequisition");
		
		
		 if(previous_Test_resultStatus.getStatus() == ITestResult.SUCCESS ) 
		 {	 
			 Rcomp.VerifyRequisition();
		   }else {
		throw new	SkipException(":::::SKIPPED:::::: "); 
		}
*/

	

}
