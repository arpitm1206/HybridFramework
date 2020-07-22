package com.components;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.objectRepository.PayablesLocators;
import com.utility.BaseClass;
import com.utility.ReadData;

public class PayablesComponent2 extends BaseClass {

	PayablesLocators payableLoc = new PayablesLocators();
	ReadData readData = new ReadData();
	BaseComponent basecomp = new BaseComponent();
	public Logger log = Logger.getLogger(PayablesComponent2.class);
	String totalBalance = null;
	String invoiceAmmount = null;
	
	public void launchApplication() throws Exception
	{
		String day = null;
		day =  todaysDay();
		try	
		{
			basecomp.LaunchApp();
			basecomp.loginOracle();
			basecomp.clickOnInstant();
			//Assert.assertEquals(false, true);
			basecomp.selectSlot(day);
			basecomp.lanchDemoApp();
		}
		catch(Exception e)
		{
			readData.fullScreenCapture();
		}
	}
	/** This method will select the payables module from the list of modules
	 * Author : Arpitha Makavalli Koppalu
	 * Date : 29/06/2020
	 * return type : HashMap
	 * @throws Exception 
	 */
	public HashMap<String, Boolean> selectPayableModuleFromList() throws Exception {
		HashMap<String, Boolean> assertions = new HashMap<String, Boolean>();

		try {

			waitSD(2000);
			waitForElement(payableLoc.burgerIcon, 3);
			waitSD(2000);
			click(payableLoc.burgerIcon);
			waitSD(2000);
			System.out.println("*******Payables is present inside the module lists*******");
			waitForElement(payableLoc.burgerIconPayables, 3);
			waitSD(2000);
			click(payableLoc.burgerIconPayables);
			waitSD(2000);
			waitForElement(payableLoc.burgerIconInvoice, 2);
			waitSD(2000);
			click(payableLoc.burgerIconInvoice);
			waitSD(2000);
			waitForElement(payableLoc.invoicePageEle, 2);
			if( verifyField(payableLoc.invoicePageEle) ) {
				System.out.println("***********Invoice Page is Displayed**************");
				assertions.put("Invoice Page is Displayed", true);
			} else {
				assertions.put("Invoice Page is Displayed", false);
			}							
		}
		catch(Exception e ) {
			e.printStackTrace();
			readData.fullScreenCapture();
		}
		return assertions;
	}

	public HashMap<String, Boolean> createInvoice(String invoiceNumber, String invoiceAmmountData, String businessUnitValue, String supplierValue, String accountType) throws Exception {
		HashMap<String, Boolean> assertions = new HashMap<String, Boolean>();

		try {
			waitSD(2000);
			verifyField(payableLoc.taskBtn);
			waitSD(3000);
			click(payableLoc.taskBtn);
			waitSD(2000);
			waitForElement(payableLoc.createInvoiceLnk, 2);
			waitSD(3000);
			verifyField(payableLoc.createInvoiceLnk);
			waitSD(2000);
			click(payableLoc.createInvoiceLnk);	
			waitSD(3000);
			waitForElement(payableLoc.createInvoicePage, 2);
			waitSD(3000);
			if( verifyField(payableLoc.createInvoicePage) ) {
				System.out.println("***********Create Invoice Page is Displayed**************");
				assertions.put(" Create Invoice Page is Displayed", true);
			} else {
				assertions.put("Create Invoice Page is Displayed", false);
			}

			System.out.println("************* Filling the values in Invoice Header ****************");
			System.out.println("************* Selecting Business Unit Value *************");
			waitSD(7000);
			waitForElement(payableLoc.businessUnitDropDownbtn, 3);
			waitSD(3000);
			click(payableLoc.businessUnitDropDownbtn);
			waitSD(3000);
			click(payableLoc.businessUnitSearchtBtn);
			waitSD(3000);
			waitForElement(payableLoc.searchAndSelectBusinessUnitName, 3);
			waitSD(3000);
			type(payableLoc.searchAndSelectBusinessUnitName , businessUnitValue);
			waitSD(3000);
			click(payableLoc.searchAndSelectBusinessUnitSearchtBtn);
			waitSD(3000);
			waitForElement(payableLoc.businessUnitOption, 3);
			click(payableLoc.businessUnitOption);
			waitSD(3000);
			click(payableLoc.searchAndSelectBusinessUnitOKBtn);

			System.out.println("************* Selecting Supplier Value *************");

			waitSD(5000);
			click(payableLoc.searchIconSupplier);
			waitForElement(payableLoc.searchAndSelectSupplierTextBox, 3);
			waitSD(3000);
			type(payableLoc.searchAndSelectSupplierTextBox , supplierValue);
			waitSD(3000);
			click(payableLoc.searchAndSelectSupplierSearchBtn);
			waitSD(3000);
			waitForElement(payableLoc.supplierOption, 3);
			waitSD(3000);
			click(payableLoc.supplierOption);
			waitSD(3000);
			click(payableLoc.searchAndSelectSupplierOKBtn);	
			waitSD(5000);
			waitForElement(payableLoc.createInvoicePage, 3);

			System.out.println("************* Entering the value for Invoice Number Text Box *************");
			waitSD(4000);
			type(payableLoc.numberTextBox , invoiceNumber);
			waitSD(5000);

			System.out.println("************* Entering the values for Invoie Ammount Text Box *************");
			waitSD(3000);
			type(payableLoc.amountTextBox , invoiceAmmountData);
			invoiceAmmount = getattributevalue(payableLoc.amountTextBox, "value");
			System.out.println("***********Invoice ammount : "+invoiceAmmount);		

			waitSD(3000);
			totalBalance = getTheText(payableLoc.totalAmmount);
			System.out.println("******The total balance present before distributing the ammount : "+totalBalance+"**********");

			System.out.println("************* Filling the values in Lines Header ****************");

			if( !getattributevalue(payableLoc.linesExpandBtn,"aria-expanded").equals(true) ) {
				click(payableLoc.linesExpandBtn);				
			}

			System.out.println("************* Selecting the Distribution Account type *************");
			waitSD(3000);
			waitForElement(payableLoc.searchDistributionCombinationID, 3);
			waitSD(3000);
			scrollToView(payableLoc.searchDistributionCombinationID);
			waitSD(3000);
			click(payableLoc.searchDistributionCombinationID);
			waitSD(3000);
			waitForElement(payableLoc.distributionCombPopup,3);
			waitSD(5000);
			click(payableLoc.searchAccountDropDown);
			waitSD(3000);
			waitForElement(payableLoc.searchInAcountDropDown,3);
			waitSD(3000);
			click(payableLoc.searchInAcountDropDown);
			waitSD(3000);
			waitForElement(payableLoc.searchAndSelectAccountValue,3);
			waitSD(3000);
			type(payableLoc.searchAndSelectAccountValue, accountType);
			waitSD(3000);
			click(payableLoc.searchAndSelectAccountSearchtBtn);
			waitSD(3000);
			waitForElement(payableLoc.accountOption,3);
			click(payableLoc.accountOption);
			waitSD(3000);
			click(payableLoc.searchAdnSelectAccountOKBtn);
			waitSD(3000);
			waitForElement(payableLoc.distributionCombPopup,3);
			waitSD(2000);
			click(payableLoc.distributionCombinationPopupOkBtn);
			waitSD(3000);

			System.out.println("************* Entering the value for Ammount Text Box *************");

			waitForElement(payableLoc.lineAmmountTextBox,3);
			type(payableLoc.lineAmmountTextBox , invoiceAmmountData);
		} catch(Exception e ) {
			e.printStackTrace();
			readData.fullScreenCapture();
		}
		return assertions;
	}

	public HashMap<String, Boolean> validateInvoiceAmmount() throws Exception {
		HashMap<String, Boolean> assertions = new HashMap<String, Boolean>();
		try {
			waitSD(3000);
			System.out.println("************Validating the total ammount of the Invoice****************");
			waitSD(3000);
			scrollToView(payableLoc.totalAmmount);
			totalBalance = getTheText(payableLoc.totalAmmount);
			waitSD(3000);
			scrollToView(payableLoc.invoiceActionDropDown);
			waitSD(3000);
			//waitSD(5000);
			click(payableLoc.invoiceActionDropDown);
			pressDownKey();
			pressDownKey();
			pressDownKey();
			pressEnterKey();		
			waitSD(5000);

			List<WebElement> popup = FindMultipleWebElements(payableLoc.warningPopuop);

			if(popup.size() > 0) {
				waitSD(3000);
				click(payableLoc.continueButton);
				waitSD(5000);
				click(payableLoc.invoiceActionDropDown);
				pressDownKey();
				pressDownKey();
				pressDownKey();
				pressEnterKey();		
				waitSD(2000);
			} else {
				click(payableLoc.invoiceActionDropDown);
				pressDownKey();
				pressDownKey();
				pressDownKey();
				pressEnterKey();
			}

			scrollToView(payableLoc.totalAmmount);
			totalBalance = getTheText(payableLoc.totalAmmount);
			waitSD(3000);

			System.out.println("******The total balance present after Clicked on Validate : "+totalBalance+"**********");

			if (!(invoiceAmmount.equals(totalBalance))) {

				System.out.println("******Total Ammount is not in sink before updating the invoice ammount");
				waitSD(3000);
				scrollToView(payableLoc.invoiceActionDropDown);
				waitSD(3000);
				type(payableLoc.amountTextBox , totalBalance);
				invoiceAmmount = getattributevalue(payableLoc.amountTextBox, "value");
				System.out.println("***********Invoice ammount After Update: "+invoiceAmmount);
				waitSD(3000);
				click(payableLoc.invoiceActionDropDown);
				pressDownKey();
				pressDownKey();
				pressDownKey();
				pressEnterKey();		
				waitSD(3000);	

				if(popup.size() > 0) {
					waitSD(3000);
					click(payableLoc.continueButton);
					waitSD(3000);
					click(payableLoc.invoiceActionDropDown);
					pressDownKey();
					pressDownKey();
					pressDownKey();
					pressEnterKey();	
					waitSD(3000);
				}
			}
			scrollToView(payableLoc.invoiceActionDropDown);
			waitSD(3000);
			click(payableLoc.invoiceActionDropDown);
			pressDownKey();
			pressDownKey();
			pressDownKey();
			pressEnterKey();
			waitSD(3000);
			click(payableLoc.invoiceActionDropDown);
			pressDownKey();
			pressDownKey();
			pressDownKey();
			pressEnterKey();	
			waitSD(3000);
			scrollToView(payableLoc.saveAndCloseInvoiceBtn);
			waitSD(2000);
			click(payableLoc.saveAndCloseInvoiceBtn);
			waitSD(3000);	
		}
		catch(Exception e ) {
			e.printStackTrace();
			readData.fullScreenCapture();
		}
		return assertions;
	}

	public HashMap<String, Boolean> manageInvoice(String invoiceNumber) throws Exception {

		HashMap<String, Boolean> assertions = new HashMap<String, Boolean>();

		try {

			waitForElement(payableLoc.invoicePageEle, 3);
			if( verifyField(payableLoc.invoicePageEle) ) {
				System.out.println("***********Invoice Page is Displayed**************");
				assertions.put("Invoice Page is Displayed", true);
			} else {
				assertions.put("Invoice Page is Displayed", false);
			}

			verifyField(payableLoc.taskBtn);
			click(payableLoc.taskBtn);
			click(payableLoc.manageInvoicesLnk);
			waitForElement(payableLoc.manageInvoicePage, 3);
			type(payableLoc.invoiceNumberTextBox , invoiceNumber);
			click(payableLoc.invoiceNumberSearch);

			for( int i = 0; i < FindMultipleWebElements(payableLoc.listOfSearchResultsInvoiceNumber).size(); i++) {
				String invoiceNumberInList = FindMultipleWebElements(payableLoc.listOfSearchResultsInvoiceNumber).get(i).getText();
				if(invoiceNumberInList.equals(invoiceNumber)) {
					System.out.println("****** Invoice Created Successfully ********");
				} else {
					System.out.println("****** Invoice Not Created *****************");
				}
			}
			waitSD(3000);
			if(	verifyField(payableLoc.searchResultsValidateText) || getTheText(payableLoc.searchResultsValidateText).equals("Validated")) {
				System.out.println("Invoice Created and Validated Successfully");
			} else {
				System.out.println("Invoice Created but invoice ammount is not Validated properly");
			}		

			waitSD(3000);
			click(payableLoc.doneButton);
			waitSD(2000);
			/*scrollToView(payableLoc.homeIcon);
			waitForElement(payableLoc.homeIcon, 2);
			click(payableLoc.homeIcon);*/

		} catch(Exception e ) {
			e.printStackTrace();
			readData.fullScreenCapture();
		}
		return assertions;
	}
}