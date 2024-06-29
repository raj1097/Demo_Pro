package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage 
{
	WebDriver driver;
	public OrganizationInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgHeaderIP;
	
	@FindBy(id = "dtlview_Organization Name")
	private WebElement OrgNameIP;
	
	@FindBy (id = "dtlview_Industry")
	private WebElement IndustryDDIP;
	
	@FindBy (id = "dtlview_Type")
	private WebElement TypeDDIP;
	
	@FindBy (id = "mouseArea_Phone")
	private WebElement PhoneTxtIP;
	
	
	public WebElement getOrgHeaderIP() {
		return OrgHeaderIP;
	}

	public WebElement getOrgNameIP() {
		return OrgNameIP;
	}

	public WebElement getIndustryDDIP() {
		return IndustryDDIP;
	}

	public WebElement getTypeDDIP() {
		return TypeDDIP;
	}
	
	public WebElement getPhoneTxtIP() {
		return PhoneTxtIP;
	}
	
	
	
	

}
