package com.testScripts;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.components.GeneralAccounting_Components;
import com.utility.BaseClass;
import com.utility.TestUtil;

public class GeneralAccounting_Script extends BaseClass
{
	GeneralAccounting_Components gaComp=new GeneralAccounting_Components();

	@Test(description="Selecting GeneralAccounting Module . . .",priority = 1)
	public void selecting_GeneralAccounting_Module() throws Exception
	{
		extent_Test=extent_Reports.createTest("Selecting GeneralAccounting Module");
		gaComp.launchApplication();
		gaComp.selectYourModule();	

	}
	@Test(description="Creating journal. . .",priority = 2, dataProviderClass=TestUtil.class,dataProvider="dp")
	public void create_Journal(Hashtable<String,String> data) throws Exception 
	{
		extent_Test=extent_Reports.createTest("Click on create journal");
		if(previous_Test_resultStatus.getStatus()==ITestResult.SUCCESS)
		{
			String batch_No = data.get("Batch no");
			String batch_Description = data.get("Batch Description");
			String balance_Type = data.get("Balance Type");
			String journal = data.get("Journal");
			String journal_Description = data.get("Journal Description");	
			String Ledger = data.get("Ledger");
			String debit_Amount = data.get("debit amount");
			String credit_amount = data.get("Credit amount");


			gaComp.clickOnJournalsTask();
			//Assert.assertEquals(false, true);
			extent_Test=extent_Reports.createTest("Creating journal");
			gaComp.create_Journal(batch_No,batch_Description,balance_Type,journal,journal_Description,Ledger,debit_Amount,credit_amount);
			
			extent_Test=extent_Reports.createTest("Manage journal");
			gaComp.verifying_Created_Journal();

		}
		else
		{
			throw new SkipException("::::Skipped::::");
		}

	}
}






	