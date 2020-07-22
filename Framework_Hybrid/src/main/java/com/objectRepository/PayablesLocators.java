package com.objectRepository;

import org.openqa.selenium.By;

public class PayablesLocators {


	//Home Page Locators
	public By rightNavigationBtn = By.xpath("//div[@id='clusters-right-nav']");
	public By tabContainerListOfOptions= By.xpath("//div[@class='flat-tabs-container']//a[contains(@id,'groupNode_')]");
	public By payablesEle = By.xpath("//a[@id='groupNode_payables']");
	public By invoiceEle = By.xpath("//div[@id='itemNode_payables_payables_invoices']//a[@id='itemNode_payables_payables_invoices_0']");
	public By homeIcon = By.xpath("//*[name()='svg'][@aria-label='Home']");

	//Burger icon locators
	public By burgerIcon = By.xpath("//a[@title='Navigator']//*[@id='pt1:_UISmmLink::icon']");
	public By burgerIconPayables = By.xpath("//div[@id='pt1:_UISnvr:0:nvgpgl2_groupNode_payables']");
	public By burgerIconInvoice = By.xpath("//span[text()='Invoices']");
	public By burgerIconPayablesView = By.xpath("//div[@id='pt1:_UISnvr:0:nvgpgl2_groupNode_payables']/../..");
	

	//Invoice Page Locators
	public By invoicePageEle = By.xpath("//span[text()='Invoices']");
	public By taskBtn = By.xpath("//div[@title='Tasks']");
	public By createInvoiceLnk = By.xpath("//a[text()='Create Invoice']");
	public By manageInvoicesLnk = By.xpath("//a[text()='Manage Invoices']");


	//Create Invoice Page -Invoice Header-Locators
	public By createInvoicePage = By.xpath("//h1[text()='Create Invoice: ']");
	public By searchIconSupplier = By.xpath("//a[@title='Search: Supplier']");
	public By businessUnitDropDownbtn = By.xpath("//a[@title='Search: Business Unit']");
	public By supplierTextBox = By.xpath("//label[text()=' Supplier']/preceding-sibling::input");
	public By businessUnitSearchtBtn = By.xpath("//a[text()='Search...']");
	public By searchAndSelectBusinessUnitName = By.xpath("//label[text()=' Name']/preceding-sibling::input");	
	public By searchAndSelectBusinessUnitSearchtBtn = By.xpath("//button[text()='Search']");
	public By numberTextBox = By.xpath("//input[contains(@id,'FONSr2:0:MAnt2:1:pm1:r1:0:ap1:r2:0:i2::content')]");
	public By amountTextBox = By.xpath("//input[contains(@id,'FONSr2:0:MAnt2:1:pm1:r1:0:ap1:r2:0:i3::content')]");
	public By businessUnitOption = By.xpath("//div[contains(@id,'afrLovInternalTableId::db')]//span[text()='US1 Business Unit']");
	public By searchAndSelectBusinessUnitOKBtn = By.xpath("//button[contains(@id,'DialogId::ok')]");


	//Supplier Popup Locators	
	public By searchAndSelectSupplierTextBox = By.xpath("//label[text()=' Supplier']/preceding-sibling::input");
	public By searchAndSelectSupplierSearchBtn = By.xpath("//button[text()='Search']");
	public By supplierOption = By.xpath("//span[text()='Dell Inc.']");
	public By searchAndSelectSupplierOKBtn = By.xpath("//button[contains(@id,'lovDialogId::ok')]");

	//Create Invoice Page -Line-Locators
	public By linesExpandBtn = By.xpath("//h1[text()='Lines']/../../preceding-sibling::td/a");
	public By lineAmmountTextBox = By.xpath("//label[text()='Amount']/preceding-sibling::input[contains(@id,'pm1:r1:0:ap1:at2:_ATp:ta2:0:i26::content')]");
	public By searchDistributionCombinationID = By.xpath("//label[text()='Distribution Combination ID']/../../following-sibling::td/a[@title='Select: Distribution Combination ID']");
	public By invoiceActionDropDown = By.xpath("//a[text()='Invoice Actions']");
	public By validateEle = By.xpath("//td[text()='Validate']/..");
	public By totalAmmount = By.xpath("//span[text()='Total']/../following-sibling::div//img/../following-sibling::td/span");
	public By outOfBalanceImg = By.xpath("//span[text()='Total']/../following-sibling::div//img[@alt='Out of Balance ']");
	public By saveAndCloseInvoiceBtn = By.xpath("//span[contains(text(),'ave and Close')]");



	//Distribution combination Search popuop loactors
	public By distributionCombPopup = By.xpath("//div[text()='Distribution Combination ID']");
	public By searchAccountDropDown = By.xpath("//a[@title='Search: Account']");
	public By searchInAcountDropDown = By.xpath("//a[contains(@id,'dropdownPopup::popupsearch')]");
	public By searchAndSelectAccountValue = By.xpath("//label[text()=' Value']/preceding-sibling::input");
	public By accountOption = By.xpath("//span[text()='64220']");
	public By searchAdnSelectAccountOKBtn = By.xpath("//button[contains(@id,'lovDialogId::ok')]");
	public By distributionCombinationPopupOkBtn = By.xpath("//button[@accesskey='k']/span");
	public By waringPopupYesBtn = By.xpath("//button[@accesskey='Y']");
	public By searchAndSelectAccountSearchtBtn = By.xpath("//button[text()='Search']");


	//Duplicate Warning Msg Locators
	public By warningPopuop = By.xpath("//td[contains(@id,'pm1:r1:0:ap1:d36::contentContainer')]");
	public By continueButton = By.xpath("//button[text()='Continue']");

	//Manage Invoice Page Locators
	public By manageInvoicePage = By.xpath("//h1[text()='Manage Invoices']");
	public By invoiceNumberTextBox = By.xpath("//label[text()=' Invoice Number']/preceding-sibling::input");
	public By invoiceNumberSearch = By.xpath("//button[text()='Search']");
	public By listOfSearchResultsInvoiceNumber = By.xpath("//table[@summary='Search Results']//tr[@class='xep']//td[2][@class='xeq x1of']/span/a");
	public By doneButton = By.xpath("//a[@accesskey='o']");
	public By searchResultsValidateText = By.xpath("//table[@summary='Search Results']//tr[@class='xep']//span/a[text()='Validated']");
	
	
}
