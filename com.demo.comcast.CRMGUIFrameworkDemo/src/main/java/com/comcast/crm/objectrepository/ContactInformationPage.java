package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage 
{
	
	WebDriver driver;
	public ContactInformationPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ConHeaderIP;
	
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement OrgNameCIP;
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement SupStDtIP;
	
	@FindBy(id = "dtlview_Support End Date")
	private WebElement SupEndDtIP;
	
	
	public WebElement getConHeaderIP() 
	{
		return ConHeaderIP;
	}
	public WebElement getOrgNameCIP()
	{
		return OrgNameCIP;
	}
	public WebElement getSupStDtIP() {
		return SupStDtIP;
	}
	public WebElement getSupEndDtIP() {
		return SupEndDtIP;
	}
	
	
}
