package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgChildWinInContactMod 
{
	
	WebDriver driver;
	public OrgChildWinInContactMod(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "search_txt")
	private WebElement SearchBar;
	
	@FindBy(name = "search")
	private WebElement SearchBt;
	
	@FindBy(xpath = "//a[contains(text(),'Organization Name')]/ancestor::tbody/descendant::td/a[@id='1']")
	private WebElement OrgNamelPW;
	
	
	public WebElement getSearchBar() {
		return SearchBar;
	}

	public WebElement getSearchBt() {
		return SearchBt;
	}

	public WebElement getOrgNamelPW() {
		return OrgNamelPW;
	}
}
