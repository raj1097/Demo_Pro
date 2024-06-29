package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	
	WebDriver driver;
	public HomePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText =  "Organizations")
	private WebElement OrganizationsMod;
	
	@FindBy(xpath = "//td[@class='tabUnSelected']/a[contains(.,'Contacts')]")
	private WebElement ContactsMod;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdminBt;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement SignOutlink;
	
	
	
	public WebElement getOrganizationsMod()
	{
		return OrganizationsMod;
	}
	
	public WebElement getContactsMod()
	{
		return ContactsMod;
	}
	
	public void getSignOutOperation(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(AdminBt).perform();
		SignOutlink.click();
	}

}
