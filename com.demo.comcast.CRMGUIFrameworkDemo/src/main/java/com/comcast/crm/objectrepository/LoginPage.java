package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility
{
	WebDriver driver;
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "user_name")
	private WebElement UserNameTxtF;
	
	@FindBy(name = "user_password")
	private WebElement PasswordTxtF;
	
	@FindAll({@FindBy(id = "submitButton"), @FindBy(xpath = "//input[@type='submit']")})
	private WebElement LoginBt;
	
//	@FindBy(id = "submitButton")
//	private WebElement LoginBt;

	public WebElement getUserNameTxtF() {
		return UserNameTxtF;
	}

	public WebElement getPasswordTxtF() {
		return PasswordTxtF;
	}

	public WebElement getLoginBt() {
		return LoginBt;
	}
	
	public void getloginOperation(String url ,String username, String password)
	{
		waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get(url);
		UserNameTxtF.sendKeys(username);
		PasswordTxtF.sendKeys(password);
		LoginBt.click();
	}
	
	

}
