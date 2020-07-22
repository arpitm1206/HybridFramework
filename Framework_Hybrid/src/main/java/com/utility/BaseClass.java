package com.utility;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass
{

	public static ExtentReports extent_Reports;
	public static ExtentHtmlReporter extent_HTMLreporter;
	public static ExtentTest extent_Test;

	static boolean flag;
	//static boolean status;

	static Alert alertdialoge;
	static boolean b = true;
	public Logger log = Logger.getLogger(BaseClass.class);
	public static ReadData readData = new ReadData();
	public static WebDriver driver = null;
	public static Properties prop = new Properties();
	public static String currently_Executing_Class_Name=null;

	public static ITestResult previous_Test_resultStatus;


	public void openBrowser() throws Exception 
	{
		try {
			PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\test\\resources\\lib\\log4j.properties");

			FileInputStream configfile = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\lib\\config.properties");

			prop.load(configfile);
			String browserName = prop.getProperty("browser");

			if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", 
						System.getProperty("user.dir")
						+ "\\src\\test\\resources\\drivers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir")
						+ "\\src\\test\\resources\\drivers\\IEDriverServer_Win32_3.9.0\\IEDriverServer.exe");	
				driver = new InternetExplorerDriver();

			} else if (browserName.equalsIgnoreCase("chrome")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
						+ "\\src\\test\\resources\\drivers\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver(options);
			}
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			log.info("Opened the URL "+prop.getProperty("url"));
		} catch (RuntimeException e) {
			log.fatal("Unable to Open the given URL " + e.getMessage());
		}
	}


	public void click(By locator) throws Exception
	{
		try {
			driver.findElement(locator).click();
			log.info("Clicked on "+locator);
			extent_Test.log(Status.PASS, "Clicked on "+locator);

		} catch (Exception e) {
			log.error("Unable to click on "+locator);
			extent_Test.log(Status.INFO, "Unable to click on "+locator);
		}
	}
	public void submit(By locator) throws Exception
	{
		try {
			driver.findElement(locator).submit();
			log.info("Clicked on "+locator);
			extent_Test.log(Status.PASS, "Submitted for : "+locator);
		} catch (Exception e) {
			log.error("Unable to click on "+locator);
			extent_Test.log(Status.INFO, "Unable to sublit for : "+locator);
		}
	}


	public void type(By locator, String data) throws Exception {
		try {
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(data);
			extent_Test.log(Status.PASS, "Entered the value "+ data+" in the Textbox :"+locator);

			log.info("Entered the value "+ data+" in the Textbox :"+locator);
			extent_Test.log(Status.PASS, "Entered the value "+ data+" in the Textbox :"+locator);
		} catch (RuntimeException localRuntimeException) {
			log.fatal("Unable to Enter the value in the Textbox :"+locator);
			extent_Test.log(Status.FAIL, "Unable to enter the value "+ data+" in the Textbox :"+locator);
		}
	}

	public void select(By locator, String data) throws Exception {
		try {
			new Select(driver.findElement(locator)).selectByVisibleText(data);
			//	Select s = new Select(driver.findElement(locator));
			//	s.selectByVisibleText(data);
			log.info("Selected the value form the field :"+locator);
			extent_Test.log(Status.PASS, "Selected the value form the field :"+locator);
		} catch (RuntimeException e) {
			log.info("Unable to select the value form the field :"+locator);
			extent_Test.log(Status.FAIL, "Unable to select the value form the field :"+locator);

		}
	}
	public void select(By locator, int no) throws Exception {
		try {
			new Select(driver.findElement(locator)).selectByIndex(no);
			//Select dropdown = new Select(driver.findElement(locator));
			//dropdown.selectByIndex(no);
			log.info("Selected the value form the field :"+locator);
			extent_Test.log(Status.PASS, "Selected the value form the field :"+locator);
		} catch (RuntimeException e) {
			log.info("Unable to select the value form the field :"+locator);
			extent_Test.log(Status.FAIL, "Unable to select the value form the field :"+locator);
		}
	}


	public void switchwindow_TAB(int index) throws Exception
	{
		try {
			Set<String> str = driver.getWindowHandles();
			Object[] windowName = str.toArray();
			driver.switchTo().window(windowName[index].toString());
			driver.manage().window().maximize();
			log.info("Switched to the window with index no::"+index);
			extent_Test.log(Status.PASS, "Switched to the window with index no::"+index);
		} catch (RuntimeException localRuntimeException) {
			log.info("Unable to switch to the window with index no::"+index);
			extent_Test.log(Status.FAIL, "Unable to switch to the window with index no::"+index);

		}

	} 

	public void closeTabOrChildWindow()
	{
		try {
			driver.close();
			log.info("Closed the window or Tab:::");
			extent_Test.log(Status.PASS, "Closed the window or Tab:::");
		} catch (Exception e) 
		{
			log.error("Unable to close the window or Tab:::");
			extent_Test.log(Status.FAIL, "Unable to close the window or Tab:::");
		}
	}

	public void switchframe(WebElement elem) throws Exception
	{
		try {
			driver.switchTo().frame(elem);
			log.info("Switched to the frame::"+elem);
			extent_Test.log(Status.PASS, "Switched to the frame::"+elem);

		} catch (RuntimeException localRuntimeException) {
			log.info("Unable to switch to the frame::"+elem);
			extent_Test.log(Status.FAIL, "Unable to switch to the frame::"+elem);

		}

	}
	public void switchToDefaultFrame() throws Exception {
		try {
			driver.switchTo().defaultContent();
			log.info("Switch back to default from frame:::");
			extent_Test.log(Status.PASS, "Switch back to default from frame:::");
		} catch (Exception e) {
			log.info("Unable to switch back to default from frame:::");
			extent_Test.log(Status.FAIL, "Unable to switch back to default from frame:::");
		}

	}




	public void waitForElement(By locator, int timer) throws Exception{
		try{

			for (int i = 0; i < timer; i++) {
				try{
					waitSD(2000);
					driver.findElement(locator).isDisplayed();
					System.out.println("Element is available :"+locator);
					extent_Test = extent_Test.log(Status.INFO, "Element is available :"+locator);
					break;
				}catch (RuntimeException localRuntimeException) { 
					Thread.sleep(1000);
					System.out.println("Waiting for........"+locator);
					extent_Test = extent_Test.log(Status.INFO, "Element is not available :"+locator);
				} 
			}
		}catch (RuntimeException localRuntimeException) {
			System.out.println("Waited for the element :"+locator);
		}
	}

	public boolean verifyField(By loc)  
	{	
		boolean status = false;
		try{

			status=driver.findElement(loc).isDisplayed();
			log.info("Element is available :"+loc);
			extent_Test.log(Status.INFO, "Element is available :"+loc);
		}catch(Exception e){
			log.error("Element is not available :"+loc);
			extent_Test.log(Status.INFO, "Element is available :"+loc);
		}
		return status;
	}

	public int totalitemsdropdownlist(WebElement elem)  {
		List<WebElement> dropdown_values = null;
		try {
			Select dropdownfield = new Select(elem);
			dropdown_values = dropdownfield.getOptions();

		} catch (RuntimeException localRuntimeException) {
			log.error("Unable to find items in given locator:::"+elem);
			extent_Test.log(Status.FAIL, "Unable to find items in given locator:::"+elem);
		}
		return dropdown_values.size();
	}

	public static boolean verifyElementIsEnabled(By loc) 
	{
		boolean status = false;
		try
		{
			status = driver.findElement(loc).isEnabled();

			System.out.println("Element is present in expected state"+loc+"Pass");
			extent_Test.log(Status.PASS, "Element is present in expected state"+loc+"Pass");

		}
		catch (RuntimeException localRuntimeException)
		{
			System.out.println("Element not found:"+loc+"Fail");
			extent_Test.log(Status.FAIL, "Element not found:"+loc+"Fail");
			//    readData.addStepDetails("Verify Element", "Element should be present", "Element not found: " + localRuntimeException.getMessage(), "FAIL","N");
			localRuntimeException.getMessage();
		}
		return status;
	}

	public  String getAlertMessageText()
	{
		String str1 = null;
		try{
			alertdialoge = driver.switchTo().alert();
			flag=true;
			str1=alertdialoge.getText();			
			return str1;
		}catch(Exception e){
			// readData.addStepDetails("Verify Popup message", "Popup message should be available", "Alert is not present", "FAIL","Y");
		}
		return str1;
	}


	public void pressEnterKey()
	{
		try
		{
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			log.info("Pressed ENTER button");
			extent_Test.log(Status.PASS, "Pressed ENTER button");
		}
		catch(Exception e)
		{
			System.out.println(e);
			log.error("Unable to press on ENTER button");
			extent_Test.log(Status.FAIL, "Unable to press on ENTER button");

		}
	}
	public void pressPageDownKey()
	{
		try
		{
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			waitSD(2000);
			log.info("Pressed PAGERDOWN button");
			extent_Test.log(Status.PASS, "Pressed PAGERDOWN button");
		}
		catch(Exception e)
		{
			System.out.println(e);
			log.error("Unable to press on PAGERDOWN button");
			extent_Test.log(Status.FAIL, "Unable to press on PAGERDOWN button");

		}
	}
	public void pressPageUPKey()
	{
		try
		{
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_PAGE_UP);
			r.keyRelease(KeyEvent.VK_PAGE_UP);
			log.info("Pressed PAGEUP button");
			extent_Test.log(Status.PASS, "Pressed PAGEUP button");
		}
		catch(Exception e)
		{
			System.out.println(e);
			log.error("Unable to press on PAGEUP button");
			extent_Test.log(Status.FAIL, "Unable to press on PAGEUP button");

		}
	}
    
	public void pressCntrAltV()
	    {
	        try
	        {
	            Robot r = new Robot();
	            r.keyPress(KeyEvent.VK_CONTROL);
	            r.keyPress(KeyEvent.VK_ALT);
	            r.keyPress(KeyEvent.VK_V);
	            r.keyRelease(KeyEvent.VK_V);
	            r.keyRelease(KeyEvent.VK_ALT);
	            r.keyRelease(KeyEvent.VK_CONTROL);
	            log.info("pressed on CNTR+ALT+V button");
	        }
	        catch(Exception e)
	        {
	            System.out.println(e);
	            log.error("Unable to press on CNTR+ALT+V button");


	        }
	    }


	public void pressMKey()
	{
		try
		{
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_M);
			r.keyRelease(KeyEvent.VK_M);
			log.info("Pressed M button");
		}
		catch(Exception e)
		{
			System.out.println(e);
			log.error("Unable to press on M button");

		}
	}

	public void pressTABKey()
	{
		try
		{
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			log.info("Pressed TAB button");
			extent_Test.log(Status.PASS, "Pressed TAB button");
		}
		catch(Exception e)
		{
			System.out.println(e);
			log.error("Unable to press on TAB button");
			extent_Test.log(Status.FAIL, "Unable to press on TAB button");

		}
	}



	public void VerifyText(WebElement elem, String paramString2)
	{
		try
		{
			String selectedOption = new Select(elem).getFirstSelectedOption().getText();
			if (selectedOption.trim().equalsIgnoreCase(paramString2))
			{
				System.out.println("Text was found :"+paramString2+"Pass");
				extent_Test.log(Status.PASS, "Text was found :"+paramString2+"Pass");
				//  readData.addStepDetails("Verify Element", "Element "+paramString2+" should be available", "Element "+paramString2+" was found in DOM", "PASS","N");
			}
			else
			{
				System.out.println("Text was not found :"+paramString2+"Fail");
				extent_Test.log(Status.FAIL, "Text was not found :"+paramString2+"Fail");
				//  readData.addStepDetails("Verify Element", "Element "+paramString2+" should be available", "Element "+paramString2+" is not found", "FAIL","N");
			}
		}
		catch (RuntimeException localRuntimeException)
		{
			System.out.println(localRuntimeException.getMessage());
		}
	}

	public String getToolTipText(WebElement elem,String paramString1) {
		String tooltip = null;
		try{
			if (elem != null)
			{
				tooltip = elem.getAttribute(paramString1);  
				extent_Test.log(Status.PASS, "Tool tip msg :: "+tooltip);
			}
		}
		catch (RuntimeException localRuntimeException) {
			System.out.println("Error in Getting tool tip text:"+localRuntimeException.getMessage()+"Fail");
			extent_Test.log(Status.FAIL, "Error in Getting tool tip text:"+localRuntimeException.getMessage()+"Fail");
			localRuntimeException.getMessage();
		}
		return tooltip;
	}
	public static void verifyListItems(WebElement elem)
	{
		try{
			Select listBox = new Select(elem);
			List<WebElement> allItems = listBox.getOptions();
			for (WebElement item:allItems){
				System.out.println("Item is available in list:"+item);
				extent_Test.log(Status.PASS, "Item is available in list:"+item);
			}
		}catch (Exception e){
			System.out.println("Issue While Selecting Value in Drop Down Object :"+elem);
			extent_Test.log(Status.FAIL, "Issue While Selecting Value in Drop Down Object :"+elem);
		}
	}

	public static String defaultdropdownselecteditem(WebElement elem)
	{
		String text=null;

		try {
			Select dropdownfield = new Select(elem);
			text = dropdownfield.getFirstSelectedOption().getText();
			System.out.println(text.trim());
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return text;

	}

	public String alldropdownlistvalues(WebElement elem) 
	{
		Select dropdownfield = new Select(elem);
		List<WebElement> dropdownfield_values = dropdownfield.getOptions();

		String allvalues = "";
		for (int i = 0; i < dropdownfield_values.size(); i++) {
			String currentvalue = dropdownfield_values.get(i).getText();
			String concatvalue = allvalues + currentvalue + ",";
			allvalues = concatvalue;
		}

		return allvalues.substring(0, allvalues.length() - 1);
	}

	public String getdate(String format)
	{
		SimpleDateFormat df = new SimpleDateFormat(format);
		Date d=new Date();
		String date = df.format(d);
		System.out.println(date);
		return date;
	}

	public String getattributevalue(By elem, String requiredattribute) throws Exception
	{
		String attribute = null;
		try{
			attribute = driver.findElement(elem).getAttribute(requiredattribute);
			log.error("Attribute Value for "+elem+ " is :"+attribute);
			extent_Test.log(Status.PASS, "Attribute Value for "+elem+ " is :"+attribute);
		}catch(RuntimeException localRuntimeException)
		{
			System.out.println(localRuntimeException.getMessage());
			log.error("Unable to get the attribute Value for "+elem);
			extent_Test.log(Status.FAIL, "Unable to get the attribute Value for "+elem);

		}
		return attribute;
	}

	public void alertaction(String action) 
	{

		try {
			if (action.equals("ok")) {
				alertdialoge= driver.switchTo().alert();
				flag=true;
				alertdialoge.accept();
			} else if (action.equals("cancel")) {
				alertdialoge=driver.switchTo().alert();
				flag=true;
				alertdialoge.dismiss();
			}
		} catch (Exception e) {
			System.out.println("Error in performing action on Alert box:" + action + "Fail");
			extent_Test.log(Status.FAIL, "Error in performing action on Alert box:" + action + "Fail");
		}

	}

	public  String getTheText(By locator) throws Exception
	{
		waitForElement(locator, 10);
		String text= driver.findElement(locator).getText();
		System.out.println("The text is :"+text);
		return text;
	}

	public int totallinnks(WebElement elem) 
	{
		return elem.findElements(By.tagName("a")).size();
	}

	public void dragAndDrop(By question, By target)
	{
		WebElement e1=driver.findElement(question);
		WebElement e2=driver.findElement(target);
		Actions a=new Actions(driver);
		a.dragAndDrop(e1, e2).build().perform();
	}

	public boolean verifyElementExist(By loc)
	{
		boolean blnStatus = false;
		WebDriverWait localWebDriverWait = new WebDriverWait(driver, 60);
		try
		{
			localWebDriverWait.until(ExpectedConditions.presenceOfElementLocated(loc ));
			System.out.println("Element is available:"+loc+"Pass");
			extent_Test.log(Status.PASS, "Element is available:"+loc+"Pass");
			blnStatus = true;

		}
		catch (RuntimeException localRuntimeException)
		{
			System.out.println("Error in finding Element:"+localRuntimeException.getMessage() +"Fail");
			extent_Test.log(Status.FAIL, "Error in finding Element:"+localRuntimeException.getMessage() +"Fail");
		}
		return blnStatus;
	}

	public void Mousehover(WebElement elem)
	{
		try
		{
			Actions action = new Actions(driver);
			action.moveToElement(elem).build().perform();
		}
		catch (RuntimeException localRuntimeException)
		{
			System.out.println("Error in Hover on element"+localRuntimeException.getMessage()+"fail");
			extent_Test.log(Status.FAIL, "Error in Hover on element"+localRuntimeException.getMessage()+"fail");

		}
	}


	public void waitSD(int ms)
	{
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());;
		}
	}

	public void quiteDriver()
	{
		try {
			Thread.sleep(2000);
			driver.quit();
			log.info("Closed the driver:::");
			extent_Test.log(Status.PASS, "Closed the driver:::");

		} catch (Exception e)
		{
			log.fatal("Unable to close the driver:::");
			extent_Test.log(Status.FAIL, "Unable to close the driver:::");
		}
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws Exception
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			extent_Test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report

			extent_Test.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(readData.screenShotPath).build());
			previous_Test_resultStatus = result;
		}
		else if (result.getStatus()==ITestResult.SUCCESS){

			extent_Test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
			previous_Test_resultStatus = result;
		}
		else if(result.getStatus() == ITestResult.SKIP) {
			extent_Test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName()); 
			previous_Test_resultStatus = result;
		}
	}
	@BeforeClass
	public void beforeClass()
	{
		currently_Executing_Class_Name = this.getClass().getName();
	    System.out.println("Currently executing class is:::"+currently_Executing_Class_Name);
	    
	}
	@AfterClass
	public void closeBrowser() 
	{
		quiteDriver();
	}


	@BeforeSuite
	public void setExtent_Reports()
	{
		extent_HTMLreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Extent_report/extentreport_"+readData.ONLY_DATE_FORMAT_NOW.format(new Date())+"/extentreport_"+readData.DATE_FORMAT_NOW.format(new Date())+".html");

		extent_HTMLreporter.config().setDocumentTitle("Extent Report");
		extent_HTMLreporter.config().setReportName("EA Fussion Application TestReport");
		extent_HTMLreporter.config().setTheme(Theme.DARK);

		extent_Reports =new ExtentReports();
		extent_Reports.attachReporter(extent_HTMLreporter);
		extent_Reports.setSystemInfo("Environment", "Test");
		extent_Reports.setSystemInfo("Application Name", "EA Fussion");
		extent_Reports.setSystemInfo("Browser", "Chrome");
	}

	@AfterSuite
	public void end_ExtentReport() 
	{
		try 
		{
			extent_Reports.flush();
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	
	public void clearTextBoxData(By locator) throws Exception {
		try {
			driver.findElement(locator).clear();
			log.info("cleared the data in the Textbox :"+locator);
		} catch (RuntimeException localRuntimeException) {
			log.fatal("Unable to clear the data in the Textbox :"+locator);		}
	}

	public void pressDownKey()
	{
		try
		{
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			log.info("Pressed Down button");
			extent_Test.log(Status.PASS, "Pressed Down button");
		}
		catch(Exception e)
		{
			System.out.println(e);
			log.error("Unable to press on Down button");
			extent_Test.log(Status.FAIL, "Unable to press on Down button");

		}
	}


	////////////////////////////////////////////////////////////////////////////////////////////
	/** This method will find the multiple elements for the written xpath
	 * Author : Arpitha Makavalli Koppalu
	 * Date : 29/06/2020
	 * return type : List<WebElement> 
	 */

	public List<WebElement> FindMultipleWebElements(By elem) {

		List<WebElement> listOfElements = null;
		try {
			listOfElements = driver.findElements(elem);
			log.error("List of Web elements are : "+listOfElements);
			extent_Test.log(Status.INFO, "List of Web elements are : "+listOfElements);
		} catch (Exception e) {
			System.out.println(e);
			log.error("List of Web elements are : "+listOfElements);
			extent_Test.log(Status.INFO, "List of Web elements are : "+listOfElements);
		}
		return listOfElements;
	}

	/** This method will return the today's day
	 * Author : Arpitha Makavalli Koppalu
	 * Date : 29/06/2020
	 * return type : String 
	 */

	public String todaysDay() {


		long millis=System.currentTimeMillis();  
		java.util.Date date=new java.util.Date(millis); 
		String day = date.toString().split(" ")[0];	

		switch(day) {
		case "Mon" : day = "Monday";
		break;
		case "Tue" : day = "Tuesday";
		break;
		case "Wed" : day = "Wednesday";
		break;
		case "Thu" : day = "Thursday";
		break;
		case "Fri" : day = "Friday";
		break;
		case "Sat" : day = "Saturday";
		break;
		case "Sun" : day = "Sunday";
		break;
		}	
		System.out.println("Todays day is:::"+day);

		return day; 

	}

	/** This method will scroll till the element gets visible
	 * Author : Arpitha Makavalli Koppalu
	 * Date : 29/06/2020
	 * return type : void 
	 */
	public void scrollToView(By element) {
		try {
			waitSD(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(element));
			waitSD(2000);
			log.error("Scrolled till "+element);
			extent_Test.log(Status.PASS, "Scrolled till "+element);
		} catch(Exception e) {
			log.error("Unable to Scroll till "+element);
			extent_Test.log(Status.FAIL, "Unable to Scroll till "+element);
		}
	}
}
