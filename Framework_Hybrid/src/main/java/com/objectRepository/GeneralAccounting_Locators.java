package com.objectRepository;

import org.openqa.selenium.By;

public class GeneralAccounting_Locators 
{
	public By homeIcon = By.xpath("//*[name()='svg'][@aria-label='Home']");
	
	//Vision page locators
	public By visionPage_Navigate_Button=By.xpath("//div[@id='clusters-right-nav']");
	public By selecting_GeneralAccounting_Module_in_Vision_Homepage=By.xpath("//a[text()='General Accounting']");
	public By generalAccounting_Journals=By.xpath("//div[@id='itemNode_general_accounting_journals']");

	//Journal Task menu page locators
	public By tasks=By.xpath("//div[@title='Tasks']");
	public By create_Journal=By.xpath("//a[@id='pt1:_FOr1:1:_FONSr2:0:_FOTRaT:0:RAtl2']");
	public By manage_Journals=By.xpath("//a[@id='pt1:_FOr1:1:_FONSr2:0:_FOTRaT:0:RAtl1']");

	//Create Journal page locators
	public By Journal_Batch	=By.xpath("//input[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pt1:ap1:showLessBatchName::content']");
	public By batch_Description	=By.xpath("//textarea[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pt1:ap1:showLessBatchDescription::content']");
	public By journal=By.xpath("//input[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pt1:ap1:showLessJournalName::content']");
	public By journal_Description=By.xpath("//textarea[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pt1:ap1:showLessJournalDescription::content']");
	public By ledger=By.xpath("//input[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pt1:ap1:showLessLedgerCLOV:sis1:is1::content']");
	public By category=By.xpath("//input[@id='pt1:_FOr1:0:_FONSr2:0:MAnt2:0:pt1:ap1:sis3:userJeCategoryNameInputSearch1::content']");
	//public By catagory_Dropdown_Button_Press=By.xpath("//a[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pt1:ap1:sis3:userJeCategoryNameInputSearch1::btn']");
	//public By catagory_Manual_Option_select=By.xpath("//tr[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pt1:ap1:sis3:userJeCategoryNameInputSearch1::item68']//td[text()='Manual']");

	//Select Account Debit Account Search and Pop-Up locators
    public By Accounting_Date=By.xpath("//span[@id='pt1:_FOr1:0:_FONSr2:0:MAnt2:0:pt1:ap1:DefaultEffectiveDate1::content']");
	public By selectAccount_DebitAMT_search_icon=By.xpath("//a[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pt1:ap1:jeLineAppTable:_ATp:t3:0:accountKBIMG']");

	public By selectAccount_DebitAMT_PopUp_Account=By.xpath("//a[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pt1:ap1:jeLineAppTable:_ATp:t3:0:accountSPOP_query:value20::lovIconId']");
    public By select_Cash_Opton_From_AccountPopUp=By.xpath("//span[text()='Cash']");
    public By account_textBox_in_popUp=By.xpath("//input[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pt1:ap1:jeLineAppTable:_ATp:t3:0:accountSPOP_query:value20::content']");
    public By select_PopUp_OK_Button_for_DebitAccount=By.xpath("//button[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pt1:ap1:jeLineAppTable:_ATp:t3:0:accountSEl']");
    public By debit_Amt=By.xpath("//input[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pt1:ap1:jeLineAppTable:_ATp:t3:0:EnteredDr::content']");
    public By debit_textbox=By.xpath("//input[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pt1:ap1:jeLineAppTable:_ATp:t3:0:accountCS::content']");
    //Select Account Credit Account Search and Pop-Up locators
   // public By Credit_textBox=By.xpath("//div[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pt1:ap1:jeLineAppTable:_ATp:t3:1:j_id113']");
    public By Credit_textBox=By.xpath("//span[text()='2']");

    public By selectAccount_CriditAMT_search_icon=By.xpath("//img[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pt1:ap1:jeLineAppTable:_ATp:t3:1:accountKBIMG::icon']");
	
    public By SelectAccount_CreditAMT_PopUp_Account=By.xpath("//a[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pt1:ap1:jeLineAppTable:_ATp:t3:1:accountSPOP_query:value20::lovIconId']");
    public By select_Account_OptionAs_Short_Term_Investment_for_CredicAccount_from_PopUP=
    		By.xpath("//span[text()='Short Term Investment']");
    public By select_PopUp_OK_Button_for_CreditAccount=
    		By.xpath("//button[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pt1:ap1:jeLineAppTable:_ATp:t3:1:accountSEl']");

    public By credit_Amt=By.xpath("//input[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pt1:ap1:jeLineAppTable:_ATp:t3:1:EnteredCr::content']");
    public By save_Button=By.xpath("//span[text()='Save']");
    public By complete_Button=By.xpath("//span[text()='Complete']");
    public By post_Button=By.xpath("//span[text()='Post']");
    public By cancle_Button=By.xpath("//div[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pt1:ap1:commandToolbarButton5']");
    
    //locators for the page Manage Journal in Task
    public By manageJournal_Search_Expand=By.xpath("//a[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:2:pt1:ap1:queryP::_afrDscl']");
    public By journalBatch_in_ManageJournal=By.xpath("//input[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:2:pt1:ap1:queryP:value10::content']");
    public By manageJournal_AccountingPeriod_textBox=By.xpath("//input[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:2:pt1:ap1:queryP:value20::content']");
    public By search_Button_in_ManageJournal=By.xpath("//button[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:2:pt1:ap1:queryP::search']");
    public By verifying_Created_Journal_By_Using_JournalBatch_LinkText=
    		By.xpath("//a[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:2:pt1:ap1:AT1:_ATp:t1:13:commandLink4']");
    
    public By Done_button_in_ManageJournal=By.xpath("//span[@class='x1qd' and text()='o']");



}
