package com.wirisQuestionsClasses;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigData 
{

	Properties pro;
	//Constructor for initializing all data when creating objects without calling method
	public ReadConfigData() 
		{
		File src=new File("./TestData/Config.properties");
		try {
		FileInputStream input=new FileInputStream(src);
		pro=new Properties();
		pro.load(input);
		} 
		catch (Exception e) {e.printStackTrace();}
		}
	
	    //Chrome Key
		public String getChromeKey() 
		{
			String chromeKey=pro.getProperty("ChromeKey");
			return chromeKey;
		}
		
		//Chrome Value
		public String getChromeValue() 
		{
			String chromeValue=pro.getProperty("ChromeValue");
			return chromeValue;
		}
		
		//Author user name 1
		public String getAuthor1UserName() 
		{
			String userName=pro.getProperty("authorUN");
			return userName;
		}
		
		//Author password
		public String getAuthorPassWord() 
		{
			String password=pro.getProperty("authorPWD");
			return password;
		}
		
		//Author QA4 login url
		public String getAuthorQa4LoginUrl() 
		{
			String loginUrl=pro.getProperty("authorQa4LoginURL");
			return loginUrl;
		}
		
		//Wiris QA4 Link
		public String getWirisQa4Link() 
		{
			String wirisLink=pro.getProperty("wirisQa4Link");
			return wirisLink;
		}
		
		//Author user name 2
		public String getAuthor2UserName() 
		{
			String userName2=pro.getProperty("author2UN");
			return userName2;
		}
		
		//Author production login url
		public String getAuthorProdLoginUrl() 
		{
			String loginUrlProd=pro.getProperty("authorProdLoginURL");
			return loginUrlProd;
		}
				
		//Wiris production Link
		public String getWirisProdLink() 
		{
			String wirisLinkProd=pro.getProperty("wirisProdLink");
			return wirisLinkProd;
		}
		
	
}
