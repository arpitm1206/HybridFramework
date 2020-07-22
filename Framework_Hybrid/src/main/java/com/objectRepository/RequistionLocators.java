package com.objectRepository;

import org.openqa.selenium.By;

public class RequistionLocators {

	
	//Procurement Locators
	public By ProcurementTab=By.xpath("//a[text()='Procurement']");
	public By PurchaseRequistions=By.xpath("//a[text()='Purchase Requisitions']");
	public By PurchaseOrders=By.xpath("//a[text()='Purchase Orders']");
	
	//vision home page
	public By visionicon=By.xpath("//a[@id='pt1:_UISmmLink']");
	//public By PurchaseRequistions=By.xpath("//a[@id='pt1:nv_itemNode_my_information_purchase_requisitions']");
	//public By PurchaseOrders=By.xpath("//a[@id='_FOpt1:nv_itemNode_procurement_PurchaseOrders']");
	
	
	//Requisition Locators
	public By MoreTasksDropdown=By.xpath("//a[text()='More Tasks']");
	public By RequisitionLine=By.xpath("//td[contains(text(),'Enter Requisition Line')]");

	public By itemTextBox=By.xpath("//a[@title='Search: Item']");
	public By itemid=By.xpath("(//td[@class='xhw']//table[@class='x1a']//span[@class='x1u']//input[@class='x25'])[1]");
			//+ "//input[@id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTsr1:1:pt1:AP1:s3:ItemI1:0:itemNumberId::_afrLovInternalQueryId:value00::content']");
	public By itemsearch=By.xpath("//button[text()='Search']");
	public By itemDescription=By.xpath("(//td[@class='x12z']/following-sibling::td//span)[2]");
	//public By itemname=By.xpath("//span[text()='Alliance Business Software']");
	public By itemsubmit=By.xpath("(//td[@class='x1vo']//button[text()='OK'])[1]");
			//+ "//button[@id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTsr1:1:pt1:AP1:s3:ItemI1:0:itemNumberId::lovDialogId::ok']");
												 
	
	public By suppliertextbox=By.xpath("//a[@title='Search: Supplier']");
	public By supplierid=By.xpath("(//table[@class='x1a']//span[@class='x1u']//input[@class='x25'])[1]");
			//+ "input[@id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTsr1:1:pt1:AP1:s3:ItemI1:0:vendorNameId::_afrLovInternalQueryId:value00::content']");
	public By suppliersearchbtn=By.xpath("(//td[@class='x1ue']//td[@class='x1ud']//button[text()='Search'])[1]");
		//	+ "button[@id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTsr1:1:pt1:AP1:s3:ItemI1:0:vendorNameId::_afrLovInternalQueryId::search']");
	public By suppliernumber=By.xpath("(//td[@class='x12z']/following-sibling::td//span)[2]");
	//public By suppliernamespan=By.xpath("//span[text()='1255']");
	public By suppliersubmit=By.xpath("//button[@id='pt1:_FOr1:1:_FONSr2:0:_FOTsr1:1:pt1:AP1:s3:ItemI1:0:vendorNameId::lovDialogId::ok']");
			//+ "td[@class='x1vo']//button[text()='OK'])[2]");
			//+ "button[@id='pt1:_FOr1:1:_FONSr2:0:_FOTsr1:1:pt1:AP1:s3:ItemI1:0:vendorNameId::lovDialogId::ok']");
	
	public By AddtoCartbtn= By.xpath("//span[text()='Add to Cart']");
	public By Donebtn= By.xpath("//span[text()='Done']");
	public By ShoppingCartbtn= By.xpath("//a[@id='pt1:_FOr1:1:_FONSr2:0:_FOTsr1:0:SP4:r1:0:pt1:cl2']");
	public By SubmitCartbtn= By.xpath("//button[text()='Submit']");
	//public By Alertid= By.xpath("//div[@id='pt1:_FOr1:1:_FONSr2:0:_FOTsr1:0:SP4:panelGroupLayout2']");
	public By Alertid= By.xpath("//div[@id='pt1:_FOr1:1:_FONSr2:0:_FOTsr1:0:SP4:panelGroupLayout2']/div");
	public By Alertsubmit= By.xpath("//button[@accesskey='K']");
	
	public By ManageRequisitions= By.xpath("//a[text()='Manage Requisitions']");
	public By RequisitionsSearch= By.xpath("//input[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pt1:r1:0:ap1:r1:0:q1:value20::content']");
	public By SubmitRequisitionsSearch= By.xpath("//button[text()='Search']");
	public By SpanApproved= By.xpath("//span[text()='Approved']");
	public By Homebtn= By.xpath("//a[@id='pt1:_UIShome']");
	
	public By Taskbtn= By.xpath("//img[@title='Tasks']");
	
	public By ProcessRequisitions= By.xpath("//a[text()='Process Requisitions']");
	public By ProcessRequisitionsSearchbox= By.xpath("//input[@id='pt1:_FOr1:1:_FONSr2:0:MAt2:0:pt1:r1:0:AP1:q1:value10::content']");
	public By ProcessRequisitionsSearchbtn= By.xpath("//button[text()='Search']");
	public By ProcessRequisitionsResult= By.xpath("//a[@id='pt1:_FOr1:1:_FONSr2:0:MAt2:0:pt1:r1:0:AP1:AT5:_ATp:srchTab:0:drilldowncl']");
	public By ProcessRequisitionsFirstResult= By.xpath("//td[text()='1']");
	public By DocumentBuilderhbtn= By.xpath("//button[text()='Add to Document Builder']");
	public By DocumentBuilderhbtnsubmit= By.xpath("//button[@id='pt1:_FOr1:1:_FONSr2:0:MAt2:0:pt1:r1:0:AP1:AT5:cb1']");
	public By createbtn= By.xpath("//button[text()='Create']");
	
	
	public By CreateAlert2= By.xpath("//div[@class='x1sy']");
	public By createbtnsub= By.xpath("//button[@id='d1::msgDlg::cancel']");
	public By createbtnsubmit= By.xpath("//a[@accesskey='m']"); //@class='xx3' and 
	
	
	public By ManageOrders= By.xpath("//a[text()='Manage Orders']");
	public By orderserachbox = By.xpath("//input[@id='pt1:_FOr1:1:_FONSr2:0:MAt4:0:pt1:Purch1:0:AP1:r1:0:q1:value40::content']");
													  
	public By searchbtn	= By.xpath("//button[@id='pt1:_FOr1:1:_FONSr2:0:MAt4:0:pt1:Purch1:0:AP1:r1:0:q1::search']");
	public By DoneOrderbtn	= By.xpath("//a[@accesskey='o']");
	public By openstatus = By.xpath("//span[text()='Open']");
	public By subbtn = By.xpath("//a[@accesskey='m']");
	//button[@id='d1::msgDlg::cancel']
	
	public By signoutdropdown = By.xpath("//a[@id='pt1:_UIScmil1u']");
	public By signout = By.xpath("//a[text()='Sign Out']");
	

}
