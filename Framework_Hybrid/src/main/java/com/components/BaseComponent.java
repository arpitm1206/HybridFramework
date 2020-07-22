package com.components;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;

import com.objectRepository.BaseLocators;
import com.utility.BaseClass;

public class BaseComponent extends BaseClass
{
	BaseLocators loc=new BaseLocators();

	public void LaunchApp() throws Exception
	{
		try {
			openBrowser();
			readData.fullScreenCapture();
		} catch (Exception e) {
			readData.fullScreenCapture();		
		}
	}

	public void loginOracle() throws Exception
	{
		try {
			//Cell username=readData.readTestDataFile("C:\\\\Users\\\\musara\\\\eclipse-workspace\\\\Framework_Hybrid\\\\src\\\\test\\\\resources\\\\TestData\\\\FBCredentials.xlsx", "Sheet1", 2, 0);
			//Cell password=readData.readTestDataFile("C:\\\\Users\\\\musara\\\\eclipse-workspace\\\\Framework_Hybrid\\\\src\\\\test\\\\resources\\\\TestData\\\\FBCredentials.xlsx", "Sheet1", 2, 1);

			String username=prop.getProperty("username");
			String password=prop.getProperty("password");
			type(loc.username,username);
			type(loc.password, password);
			click(loc.signin);
			readData.fullScreenCapture();


			if(verifyField(loc.I_Accept))
			{
				if(verifyElementIsEnabled(loc.I_Accept))
				{
					click(loc.I_Accept);
					readData.fullScreenCapture();
				}
			}
		} 
		catch (Exception e)
		{
			readData.fullScreenCapture();
		}
	}
	public void clickOnInstant() throws Exception
	{
		try {
			// waitForElement(loc.instant, 1);
			if(verifyField(loc.instant))
			{
				if(verifyElementIsEnabled(loc.instant))
				{
					click(loc.instant);
					readData.fullScreenCapture();
				}
			}
		} catch (Exception e) 
		{
			readData.fullScreenCapture();
		}
	}
	public void selectSlot(String todays_day) throws Exception
	{
		try 
		{
			pressPageDownKey();
			pressPageDownKey();

			if(verifyField(loc.Fusion_Apps))
			{
				if(todays_day.equalsIgnoreCase("Friday")|todays_day.equalsIgnoreCase("Saturday")
						|todays_day.equalsIgnoreCase("Sunday")|todays_day.equalsIgnoreCase("Monday"))
				{
					waitSD(1000);
					click(loc.Slot_Friday_Saturday_Sunday_Monday);
				}
				if(todays_day.equalsIgnoreCase("Tuesday"))
				{
					waitSD(1000);
					click(loc.Slot_Tuesday);
				}
				if(todays_day.equalsIgnoreCase("Wednesday"))
				{
					waitSD(1000);
					click(loc.Slot_Wednesday);
				}
				if(todays_day.equalsIgnoreCase("Thursday"))
				{
					waitSD(1000);
					click(loc.Slot_Thursday);
				}
				if(todays_day.equalsIgnoreCase("dupthursday"))
                {
                    click(loc.Slot_DupThursday);
                }
			}
			readData.fullScreenCapture();
		}
		catch (Exception e)
		{
			System.out.println("Error in selecting the Slot:::::"); 
			readData.fullScreenCapture();

		}
	}

	public void lanchDemoApp() throws Exception
	{
		String login_Password;
		try {
			//Swifting to next tab(Environment Details	)
			switchwindow_TAB(1);
			if( verifyField(loc.login_Password_For_LaunchDemoApp))
			{
				login_Password=getTheText(loc.login_Password_For_LaunchDemoApp);
				System.out.println("Login password for LaunchDemoApp is:::"+login_Password);
				click(loc.launchDemo);
				readData.fullScreenCapture();
				//Swifting to next tab(Login to Oracle Cloud page)
				switchwindow_TAB(2);
				if(verifyField(loc.ERP_and_SCM_Cloud_Login))
				{
					if(verifyElementIsEnabled(loc.ERP_and_SCM_Cloud_Login))
					{
						click(loc.ERP_and_SCM_Cloud_Login);
						readData.fullScreenCapture();

						//Swifting to next tab(Sign in Oracle Application Cloud)
						switchwindow_TAB(3);
						readData.fullScreenCapture();

						if(verifyField(loc.userID_signin_Oracle_Cloud))
						{
							Cell userID=null;
							if(currently_Executing_Class_Name.contains("RequisitionScript"))
							{
								 userID=readData.readTestDataFile(System.getProperty("user.dir") +"\\src\\test\\resources\\TestData\\GA_Journal_TestData.xlsx",
											"GrlAcct_CeateJournal_credential",3, 0);
							}
							else
							{
							 userID=readData.readTestDataFile(System.getProperty("user.dir") +"\\src\\test\\resources\\TestData\\GA_Journal_TestData.xlsx",
									"GrlAcct_CeateJournal_credential",2, 0);
							}
							type(loc.userID_signin_Oracle_Cloud, userID.toString());
							type(loc.Password_signin_Oracle_Cloud, login_Password);                           
							click(loc.signin_Oracle_Cloud_Button);
						}

					}
				}
			}

			readData.fullScreenCapture();
		}
		catch (Exception e) 
		{
			readData.fullScreenCapture();
		}
	}
}

