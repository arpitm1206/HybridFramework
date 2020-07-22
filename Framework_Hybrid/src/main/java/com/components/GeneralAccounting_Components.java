package com.components;

import org.apache.poi.ss.usermodel.Cell;
import org.testng.Assert;

import com.objectRepository.GeneralAccounting_Locators;
import com.utility.BaseClass;

public class GeneralAccounting_Components extends BaseClass
{
	String batch_No_for_Manage_Journal;
	BaseComponent basecomp=new BaseComponent();
	GeneralAccounting_Locators loc=new GeneralAccounting_Locators();


	//==========================These are the methods which are used in this class only===========================

	public void select_DebitAccount_Options() throws Exception
	{
		try {
			waitSD(3000);

			if(verifyElementExist(loc.selectAccount_DebitAMT_PopUp_Account))
			{
				waitSD(1000);
				click(loc.selectAccount_DebitAMT_PopUp_Account);
				//waitSD(1000);
				click(loc.selectAccount_DebitAMT_PopUp_Account);
				waitSD(4000);
			}
		}
		catch (Exception e)
		{
			readData.fullScreenCapture();
		}
	}
	public void select_CreditAccount_Options() throws Exception
	{
		try {
			waitSD(3000);

			if(verifyElementExist(loc.SelectAccount_CreditAMT_PopUp_Account))
			{
				waitSD(1000);
				click(loc.SelectAccount_CreditAMT_PopUp_Account);
				//waitSD(1000);
				click(loc.SelectAccount_CreditAMT_PopUp_Account);
				waitSD(4000);
			}
		}
		catch (Exception e)
		{
			readData.fullScreenCapture();
		}
	}
	public void selecting_Cash_Option_for_DebitAccount() throws Exception
	{
		try {
			if(verifyElementExist(loc.select_Cash_Opton_From_AccountPopUp))
			{
				waitSD(2000);
				click(loc.select_Cash_Opton_From_AccountPopUp);
				waitSD(4000);

				if(verifyField(loc.select_PopUp_OK_Button_for_DebitAccount))
				{
					click(loc.select_PopUp_OK_Button_for_DebitAccount);
				}
			}
			waitSD(4000);
		}
		catch (Exception e) 
		{
			readData.fullScreenCapture();
		}
	}
	public void selecting_ShortTermInvestment_Option_for_CreditAccount() throws Exception
	{
		try {
			if(verifyElementExist(loc.select_Account_OptionAs_Short_Term_Investment_for_CredicAccount_from_PopUP))
			{
				waitSD(2000);
				click(loc.select_Account_OptionAs_Short_Term_Investment_for_CredicAccount_from_PopUP);
				waitSD(4000);

				if(verifyField(loc.select_PopUp_OK_Button_for_CreditAccount))
				{
					waitSD(2000);
					click(loc.select_PopUp_OK_Button_for_CreditAccount);
				}
			}
			waitSD(4000);
		}
		catch (Exception e) 
		{
			readData.fullScreenCapture();
		}
	}



	//==========================================================================================
	public void launchApplication()throws Exception
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
	public void selectYourModule() throws Exception
	{
		try 
		{
			while(true)
			{
				boolean generalAccounting_module_availability_Status=

						verifyField(loc.selecting_GeneralAccounting_Module_in_Vision_Homepage);
				System.out.println("Availability status of General Acoounting module in the menu:::"+generalAccounting_module_availability_Status);
				if(generalAccounting_module_availability_Status)
				{
					click(loc.selecting_GeneralAccounting_Module_in_Vision_Homepage);
					readData.fullScreenCapture();
					break;
				}
				else if(generalAccounting_module_availability_Status==false)
				{
					waitSD(2000);
					click(loc.visionPage_Navigate_Button);
					readData.fullScreenCapture();
				}
			}

			if(verifyField(loc.generalAccounting_Journals))
			{
				click(loc.generalAccounting_Journals);
				readData.fullScreenCapture();
			}


		}
		catch (Exception e)
		{
			readData.fullScreenCapture();
		}
	}
	public void clickOnJournalsTask() throws Exception
	{
		try 
		{
			boolean taskIcon_Status=verifyElementExist(loc.tasks);
			if(taskIcon_Status==false)
			{
				waitForElement(loc.tasks, 5);
				if(verifyField(loc.tasks))
				{
					taskIcon_Status=true;
				}
			}
			//waitSD(2000);
			System.out.println("Task Icon availability status:::"+taskIcon_Status);
			if(taskIcon_Status)
			{
				waitSD(2000);
				click(loc.tasks);
				readData.fullScreenCapture();
				if(verifyElementExist(loc.create_Journal))
				{
					waitSD(2000);
					click(loc.create_Journal);
					readData.fullScreenCapture();
				}
			}

		} 
		catch (Exception e)
		{
			readData.fullScreenCapture();
		}
	}


	public void create_Journal(String batch_No, String batch_Description, String balance_Type,
			String journal, String journal_Description, String Ledger, String debit_Amount,String credit_amount) throws Exception
	{
		try 
		{
			batch_No_for_Manage_Journal=batch_No;			
			/*
			 * String excelSheetPath=
			 * "C:\\Users\\musara\\eclipse-workspace\\Framework_Hybrid\\src\\test\\resources\\TestData\\GA_Journal_TestData.xlsx";
			 * batch_Name= readData.readTestDataFile(excelSheetPath,
			 * "GrlAcct_CreateJournal_TestData", 1, 0); Cell batch_Description=
			 * readData.readTestDataFile(excelSheetPath, "GrlAcct_CreateJournal_TestData",
			 * 1, 1); Cell journal= readData.readTestDataFile(excelSheetPath,
			 * "GrlAcct_CreateJournal_TestData", 1, 4); Cell journal_description=
			 * readData.readTestDataFile(excelSheetPath, "GrlAcct_CreateJournal_TestData",
			 * 1, 5); Cell ledger= readData.readTestDataFile(excelSheetPath,
			 * "GrlAcct_CreateJournal_TestData", 1, 6); Cell category=
			 * readData.readTestDataFile(excelSheetPath, "GrlAcct_CreateJournal_TestData",
			 * 1,7);
			 */
			
			if(verifyField(loc.Journal_Batch))
			{
				if(verifyElementIsEnabled(loc.Journal_Batch))
				{
					type(loc.Journal_Batch, batch_No);
					type(loc.batch_Description, batch_Description);
					type(loc.journal, journal);

					type(loc.journal_Description, journal_Description);
					pressPageDownKey();
					type(loc.ledger, Ledger);
					waitSD(1000);
					pressEnterKey();
					pressTABKey();
					//if(verifyField(loc.Accounting_Date))
				//	{
						pressTABKey();
					//}

					//type(loc.category, category.toString());

					pressMKey();
					waitSD(2000);
					for(int i=1;i<=5;i++)
					{
						pressDownKey();
					}
					pressEnterKey();
					waitSD(2000);
					click(loc.selectAccount_DebitAMT_search_icon);
					waitSD(3000);

					//pop-Up actions
					select_DebitAccount_Options();
					selecting_Cash_Option_for_DebitAccount();

					//entering Debit amount				
					waitSD(5000);
					//Cell debit_amount= readData.readTestDataFile(excelSheetPath, "GrlAcct_CreateJournal_TestData", 1,8);
					type(loc.debit_Amt,debit_Amount);

					waitSD(4000);					
					click(loc.Credit_textBox);
					waitSD(3000);
					if(verifyElementExist(loc.selectAccount_CriditAMT_search_icon))
					{
						waitSD(2000);
						click(loc.selectAccount_CriditAMT_search_icon);
						waitSD(4000);
						select_CreditAccount_Options();
						selecting_ShortTermInvestment_Option_for_CreditAccount();

						waitSD(5000);
						//Cell credit_amount= readData.readTestDataFile(excelSheetPath, "GrlAcct_CreateJournal_TestData", 1,9);
						type(loc.credit_Amt,credit_amount);

					}

					waitSD(3000);
					click(loc.save_Button);
					waitSD(2000);
					click(loc.complete_Button);
					waitSD(4000);
					click(loc.cancle_Button);
				}
			}
		} 
		catch (Exception e)
		{
			readData.fullScreenCapture();
		}
	}

	public void verifying_Created_Journal() throws Exception
	{
		try
		{
			if(verifyElementExist(loc.tasks))
			{
				click(loc.tasks);
				readData.fullScreenCapture();
				if(verifyElementExist(loc.manage_Journals))
				{
					waitSD(2000);
					click(loc.manage_Journals);
					readData.fullScreenCapture();
					waitSD(3000);
					//String search_Expand_status=getattributevalue(loc.search_Button_in_ManageJournal,"class");
					//System.out.println("Search expand Status:::"+search_Expand_status);
					//if(search_Expand_status==false)
					//{
					//waitSD(2000);
					click(loc.manageJournal_Search_Expand);
					//}
					if(verifyElementExist(loc.journalBatch_in_ManageJournal))
					{
						waitSD(2000);
						type(loc.journalBatch_in_ManageJournal, batch_No_for_Manage_Journal);
						waitSD(2000);
						clearTextBoxData(loc.manageJournal_AccountingPeriod_textBox);
						waitSD(2000);
						click(loc.search_Button_in_ManageJournal);
						waitSD(2000);

						if(verifyElementExist(loc.verifying_Created_Journal_By_Using_JournalBatch_LinkText))
						{
							String compare_JournalBatch=getTheText(loc.verifying_Created_Journal_By_Using_JournalBatch_LinkText);

							if(compare_JournalBatch.equals(batch_No_for_Manage_Journal))
							{
								System.out.println("YOUR JOURNAL is SUCCESFULLY CREATED with Batch No::::::::::"+compare_JournalBatch);
								waitSD(2000);
							}

						}
						waitSD(4000);
						click(loc.Done_button_in_ManageJournal);
						waitSD(2000);
                       /* scrollToView(loc.homeIcon);
                    	waitSD(2000);
						click(loc.homeIcon);*/

					}
				}
			}
		}
		catch(Exception e)
		{
			readData.fullScreenCapture();

		}
	}
	public void close_Driver() throws Exception
	{
		try 
		{
			quiteDriver();	
		} 
		catch (Exception e) 
		{
			readData.fullScreenCapture();
		}
	}


}
