package com.comcast.crm.objectrepository;

import javax.management.loading.PrivateClassLoader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage 
{
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "accountname")
	private WebElement OrgNameTxtF;
	
	@FindBy(xpath = "//input[@value=\"Cancel  \"]/preceding-sibling::input")
	private WebElement SaveBt;
	
	@FindBy (name = "industry")
	private WebElement IndustryDD;
	
	@FindBy (name = "accounttype")
	private WebElement TypeDD;
	
	@FindBy (id = "phone")
	private WebElement PhoneTxtF;
	
	
	public WebElement getOrgNameTxtF() {
		return OrgNameTxtF;
	}

	public WebElement getSaveBt() {
		return SaveBt;
	}

	public WebElement getIndustryDD() {
		return IndustryDD;
	}

	public WebElement getTypeDD() {
		return TypeDD;
	}
	
	public WebElement getPhoneTxtF() {
		return PhoneTxtF;
	}
	
	
	public void CreateOrg(String OrgName)
	{
		OrgNameTxtF.sendKeys(OrgName);
		SaveBt.click();
	}
	
	public void CreateOrg(String OrgName, String Industry, String Type)
	{
		OrgNameTxtF.sendKeys(OrgName);
		Select sel = new Select(IndustryDD);
		sel.selectByVisibleText(Industry);
		Select sel2 = new Select(TypeDD);
		sel2.selectByVisibleText(Type);
		SaveBt.click();
	}
	
	public void CreateOrg(String OrgName, String Phone)
	{
		OrgNameTxtF.sendKeys(OrgName);
		PhoneTxtF.sendKeys(Phone);
		SaveBt.click();
	}
	
	
	
	


}
