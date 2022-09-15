package com.wirisQuestionsClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllElementsAddress 
{

public WebDriver driver;
	
/*
 * public AuthorPage(WebDriver driver) { this.driver=driver;
 * PageFactory.initElements(driver, this); }
 */

public AllElementsAddress(WebDriver driver) 
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

	@FindBy(id="userName")
	WebElement userNameTb;
	public void setUn(String un) 
	{
		userNameTb.sendKeys(un);
	}
	@FindBy(id="passwd")
	WebElement passTb;
	public void setPwd(String pwd) 
	{
		passTb.sendKeys(pwd);
	}
	
	@FindBy(xpath="//*[@id=\"LoginForm\"]/div[3]/input")
	WebElement signInBtn;
	public void clickOnSignInBtn() 
	{
		signInBtn.click();
	}
	
	@FindBy(className ="editicon")
	WebElement editContent;
	public void clickOnEditContent() 
	{
		editContent.click();
	}
	@FindBy(className ="savebutton")
	WebElement saveBtn;
	public void clickOnSaveButton() 
	{
		saveBtn.click();
	}
	
	@FindBy(xpath="//*[@id=\"AuthoringContainer\"]/div[1]/div/span[2]/span[4]")
	WebElement logoutMenu;
	public void clickOnlogoutMenu()
	{
		logoutMenu.click();
	}
	
	@FindBy(className="headerRightBox")
	WebElement logoutBtn;
	public void clickOnLogoutButton()
	{
		logoutBtn.click();
	}
	
	@FindBy(xpath="/html/body/div[2]/div[1]/div[1]")
	WebElement childWin;
	public void closeChildWin()
	{
		childWin.click();
	}
	
}
