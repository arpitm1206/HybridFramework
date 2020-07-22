package com.testScripts;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map.Entry;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;
import com.components.BaseComponent;
import com.components.PayablesComponent2;
import com.utility.BaseClass;
import com.utility.TestUtil;

//@Guice
public class PayablessScript2 extends BaseClass {

	PayablesComponent2 payableComp = new PayablesComponent2();
	public Logger log = Logger.getLogger(PayablessScript2.class);	
	BaseClass baseclass = new BaseClass();
	//BaseComponent comp=new BaseComponent();
	HashMap<String, Boolean> scriptAssertion;

	@Test(priority = 1)
	public void aaplicationLaunch() throws Exception {

		extent_Test=extent_Reports.createTest("Launching the application");
		/*String day = null;
		day = baseclass.todaysDay();
		comp.LaunchApp();
		comp.selectSlot(day);
		comp.lanchDemoApp();*/
		payableComp.launchApplication();

		extent_Test=extent_Reports.createTest("Selecting payable  module from module list");
		scriptAssertion = payableComp.selectPayableModuleFromList();
		for (Entry<String, Boolean> entry : scriptAssertion.entrySet()) {
			log.assertLog(entry.getValue(), entry.getKey());
		}
	}	

	@Test(priority = 2 , description="Create invoice" , dataProviderClass=TestUtil.class,dataProvider="dp" )
	public void createInvoiceFlow(Hashtable<String,String> data) throws Exception {

		extent_Test=extent_Reports.createTest("Create invoice");
		if(previous_Test_resultStatus.getStatus()==ITestResult.SUCCESS) {
			String businessUnitValue = data.get("Business Unit");
			String supplierValue = data.get("Supplier");
			String invoiceNumber = data.get("InvoiceNumber");
			String invoiceAmmountData = data.get("Amount");
			String accountType = data.get("AccountType");		

			scriptAssertion = payableComp.createInvoice(invoiceNumber , invoiceAmmountData , businessUnitValue , supplierValue , accountType);		
			for (Entry<String, Boolean> entry : scriptAssertion.entrySet()) {
				log.assertLog(entry.getValue(), entry.getKey());
			}

			extent_Test=extent_Reports.createTest("Validating Invoice annount");
			scriptAssertion = payableComp.validateInvoiceAmmount();
			for (Entry<String, Boolean> entry : scriptAssertion.entrySet()) {
				log.assertLog(entry.getValue(), entry.getKey());
			}	


			extent_Test=extent_Reports.createTest("Manage Invoice");
			scriptAssertion = payableComp.manageInvoice(invoiceNumber);
			for (Entry<String, Boolean> entry : scriptAssertion.entrySet()) {
				log.assertLog(entry.getValue(), entry.getKey());
			}	
		} else {
			throw new SkipException("::::Skipped::::");
		}
	}	
}
