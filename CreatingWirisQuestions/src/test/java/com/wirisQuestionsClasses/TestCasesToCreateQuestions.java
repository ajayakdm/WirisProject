package com.wirisQuestionsClasses;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestCasesToCreateQuestions 
{

	public WebDriver  driver;
	public AllElementsAddress page;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest extentTest;
	ReadConfigData readConfig;
	
	@BeforeClass
	public void beforeClass() 
	{
		Date d=new Date();
	//	String name="Wiris Report id-3406" +" "+d.toString()+".html";
		htmlReporter=new ExtentHtmlReporter("./ExecutionList/CourseId-3723(2)(Prod).html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation");
		htmlReporter.config().setReportName("Automation Test Result for ID 3723(Prod)");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent =new ExtentReports();
		extent.setSystemInfo("Course ID", "3723(Prod)");
		extent.setSystemInfo("Browser", "Chrome");
		extent.attachReporter(htmlReporter);
		
	}
	
	@AfterClass
	public void afterClass()
	{
		//driver.quit();
		extent.flush();
	}
	@Test
	public  void loginAuth() 
	{
		readConfig=new ReadConfigData();
		System.setProperty(readConfig.getChromeKey(), readConfig.getChromeValue());
		
		driver=new ChromeDriver();//launching browser chrome
		driver.manage().window().maximize();
		
		driver.get(readConfig.getAuthorProdLoginUrl());//launching Author url
		
		AllElementsAddress  page=new AllElementsAddress(driver);
		
		//Logging in as author
		page.setUn(readConfig.getAuthor1UserName());//Enter user name
		page.setPwd(readConfig.getAuthorPassWord());//Enter password
		page.clickOnSignInBtn();//clicking on sign in button
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleIs("List View Authoring"));
		
		extentTest=extent.createTest("loginAuth");
		extentTest.log(Status.INFO, "Executing the test case......");
		extentTest.log(Status.PASS,"Author logged in into production server succesfully");
		extentTest.log(Status.PASS,"Author Username : "+readConfig.getAuthor1UserName());
		extentTest.log(Status.PASS,"Course ID is : 3723");
		
		System.err.println("Author Username : "+readConfig.getAuthor1UserName());
		
	}
	
	@Test
	public void wirisAssessment() throws Exception 
	{	  
		  page=new AllElementsAddress(driver);
		  String parentWin = driver.getWindowHandle();
		  XSSFWorkbook wb=new XSSFWorkbook("./TestData/ConceptIDs.xlsx"); 
		
		  XSSFSheet sheet=wb.getSheet("Sheet10"); //Importing concept id's
		  
		  String link=readConfig.getWirisProdLink();//Copying wris link in new tab
		 
		  int rowCount=sheet.getPhysicalNumberOfRows();
		  
		  System.out.println(rowCount);
		 
		  extentTest=extent.createTest("Assessment");
		  extentTest.log(Status.INFO, "Executing the test case......");
		  extentTest.log(Status.INFO, MarkupHelper.createLabel("Completed concept id's for course id 3723 are as follows...", ExtentColor.GREEN));
		 
		  int i=1;
		  while(i<=rowCount) 
		  {
		  Thread.sleep(4000);
		 // String s=sheet.getRow(i).getCell(1).getStringCellValue();  
		  double doub=sheet.getRow(i).getCell(1).getNumericCellValue(); 
		  int conceptId=(int)doub;
		  String str=Integer.toString(conceptId);
		  System.out.println(conceptId);
		  String c=link.replace("276910", str);
		  System.out.println(c);
		  Robot r=new Robot();
		  r.keyPress(KeyEvent.VK_CONTROL);
		  r.keyPress(KeyEvent.VK_T);
		  r.keyRelease(KeyEvent.VK_T);
		  r.keyRelease(KeyEvent.VK_CONTROL);
		  Thread.sleep(4000);
		  Set<String> allWindows = driver.getWindowHandles();
		  for(String curWindow : allWindows)
		  	{
		      driver.switchTo().window(curWindow);
		  	}
		  //Thread.sleep(2000);
		  driver.navigate().to(c);
		//  Thread.sleep(4000);
		  
		//  Alert alert=driver.switchTo().alert();
		//  alert.accept();
		
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  Thread.sleep(2000);
		  page.clickOnEditContent();
		  Thread.sleep(4000);
		  page.clickOnSaveButton();
		  JavascriptExecutor js = (JavascriptExecutor)driver;
	      js.executeScript("window.scrollBy(350,0)");   
			Thread.sleep(4000);
		  System.out.println("Clicked on Link " +i); 
		  extentTest.log(Status.INFO, MarkupHelper.createLabel(str, ExtentColor.ORANGE));
		
		  i++;
		  driver.close();
	      }
		  driver.switchTo().window(parentWin);
    }
	
}
