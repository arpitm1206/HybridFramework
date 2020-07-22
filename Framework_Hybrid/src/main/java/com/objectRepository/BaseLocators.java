package com.objectRepository;

import org.openqa.selenium.By;

public class BaseLocators
{
	//Login Page locators
	public By username=By.xpath("//input[@id='sso_username']");
	public By password=By.xpath("//input[@id='ssopassword']");
	public By signin=By.xpath("//input[contains(@value,'Sign in')]");
	
	public By I_Accept=By.xpath("//span[text()='I Accept']");
	
	//Oracle home page locators
	public By instant=By.xpath("//a[text()='Instant']");
	
	//Slot selecting Page locators
	public By Fusion_Apps=By.xpath("//section[@id='R629789109123908870']//b[text()='Fusion Apps']");
	
	public By Slot_Friday_Saturday_Sunday_Monday=By.xpath("//section[@id='R629789109123908870']//a[text()='zoqe']");
	public By Slot_Tuesday=By.xpath("//section[@id='R629789109123908870']//a[text()='zoqa']");
	public By Slot_Wednesday=By.xpath("//section[@id='R629789109123908870']//a[text()='zoqc']");
	public By Slot_Thursday=By.xpath("//section[@id='R629789109123908870']//a[text()='zoqd']");
	public By Slot_DupThursday=By.xpath("//section[@id='R629789109123908870']//a[text()='zoqf']");

	
	//Launching demo page app locators
	public By login_Password_For_LaunchDemoApp=By.xpath("//span[@id='P15_ENVIRONMENT_AAI_PASSWORD']");
	public By launchDemo=By.xpath("//a[@id='LAUNCHPAD']");
	
	//Login to Oracle Cloud page locators
	public By ERP_and_SCM_Cloud_Login=By.xpath("//a[text()='ERP and SCM Cloud Login']");
	
	//Sign in Oracle Application Cloud Page locators
	public By userID_signin_Oracle_Cloud=By.xpath("//input[@id='userid']");
	public By Password_signin_Oracle_Cloud=By.xpath("//input[@id='password']");
	public By signin_Oracle_Cloud_Button=By.xpath("//button[contains(text(),'Sign In ')]");
      
}
