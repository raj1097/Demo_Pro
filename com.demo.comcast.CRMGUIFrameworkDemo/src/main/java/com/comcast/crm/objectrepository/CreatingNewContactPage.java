package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage 
{
	WebDriver driver;
	public CreatingNewContactPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name = "lastname")
	private WebElement LastNameTxtF;
	
	@FindBy (xpath = "//input[@value=\"Cancel  \"]/preceding-sibling::input")
	private WebElement SaveBt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement SelectOrgBt;
	
	@FindBy(name = "support_start_date")
	private WebElement SupStDate;
	
	@FindBy(name = "support_end_date")
	private WebElement SupEndDate;
	
	public WebElement getLastNameTxtF()
	{
		return LastNameTxtF;
	}
	
	public WebElement getSaveBt()
	{
		return SaveBt;
	}
	
	public WebElement getSelectOrgBt()
	{
		return SelectOrgBt;
	}
	
	public WebElement getSupStDate()
	{
		return SupStDate;
	}
	
	public WebElement getSupEndDate()
	{
		return SupEndDate;
	}

}
