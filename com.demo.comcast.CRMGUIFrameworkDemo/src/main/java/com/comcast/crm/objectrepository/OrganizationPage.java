package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage 
{
	WebDriver driver;
	public OrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[contains(@title,'Create Organization...')]")
	private WebElement CreateOrgBt;
	
	@FindBy(name = "search_text")
	private WebElement SearchBar;
	
	@FindBy(name = "submit")
	private WebElement SearchBt;
	
	@FindBy(id = "bas_searchfield")
	private WebElement InDD;
	
	
	public WebElement getCreateOrgBt() 
	{
		return CreateOrgBt;
	}
	
	public WebElement getSearchBar()
	{
		return SearchBar;
	}
	
	public WebElement getSearchBt()
	{
		return SearchBt;
	}
	
	public WebElement getInDD()
	{
		return InDD;
	}
	
}
