package com.wirisQuestionsClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClassToOpenBrowser 
{

	public WebDriver driver;

	ReadConfigData read=new ReadConfigData();//Object for TestData
	
@Parameters("Browsers")
@BeforeClass
public void launchBrowser(String Browser) 
	{
	if(Browser.equalsIgnoreCase("chrome1"))
	{
	System.setProperty(read.getChromeKey(),read.getChromeValue());
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	}
	
	else if(Browser.equalsIgnoreCase("chrome2")) 
	{
	System.setProperty(read.getChromeKey(),read.getChromeValue());
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
}
