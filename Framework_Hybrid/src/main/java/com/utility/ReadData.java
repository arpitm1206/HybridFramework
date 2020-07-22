package     com.utility;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
/*import com.itextpdf.text.Document;
	import com.itextpdf.text.Font;
	import com.itextpdf.text.PageSize;
	import com.itextpdf.text.pdf.PdfWriter;*/
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData
{

	public static  final SimpleDateFormat DATE_FORMAT_NOW = new SimpleDateFormat("yyyy_MMdd_hhmmss");
	public static  final SimpleDateFormat ONLY_DATE_FORMAT_NOW = new SimpleDateFormat("yyyy_MMdd");

	public static long testStepTempTime;
	//public  List<String> testStepElapsedTimeList = new ArrayList();
	//public static List<String> testCaseElapsedTimeList = new ArrayList();
	public static File snapShotFolder;
	public static List<String> classes= new ArrayList <String>();
	public static List<String> methods= new ArrayList <String>();
	public static List<String> errorDes= new ArrayList <String>();
	public static List<String> ScreenShots= new ArrayList <String>();
	public  List<String> snapShotPathList = new ArrayList();
	public  String screenShotPath = null;
	public static String fileName;
	
	public void fullScreenCapture() throws Exception
	{
		try {
			snapShotFolder=new File(System.getProperty("user.dir") + "\\" + "SnapShots"+"\\"+"SnapShots_"+ONLY_DATE_FORMAT_NOW.format(new Date()));				

			 fileName = "SnapShot_" + DATE_FORMAT_NOW.format(new Date()) + ".png";

			if(BaseClass.flag)
			{
				BufferedImage f = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));     		 
				ImageIO.write(f, "png", new File(snapShotFolder+"/"+fileName));
				BaseClass.flag=false;
			}
			else
			{
				File f=((TakesScreenshot)BaseClass.driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(f, new File(snapShotFolder+"/"+fileName));
			}

			screenShotPath=snapShotFolder+"/"+fileName;
			ScreenShots.add(screenShotPath);

			//      ImageIO.write(screenFullImage, format, new File(snapShotFolder+"//"+ fileName));
			snapShotPathList.add(fileName);

		} catch (IOException ex) {
			System.err.println(ex);
		}
	}

	public  Cell readTestDataFile(String filePath,String sheetName,int rowno,int cellno) throws Exception
	{
		Cell cell=null;
		try{

			File file =    new File(filePath);
			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = null;
			String fileExtensionName = filePath.substring(filePath.indexOf("."));

			if(fileExtensionName.equals(".xlsx"))
			{
				workbook = new XSSFWorkbook(inputStream);
			}
			else if(fileExtensionName.equals(".xls"))
			{
				workbook = new HSSFWorkbook(inputStream);
			}

			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rowno);
			cell=   row.getCell(cellno);
			return cell;

		}
		catch (Exception e) 
		{
			System.out.println("Unable to read data:::");
			return cell;
		}
	}
}

