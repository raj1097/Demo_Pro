package com.comcast.crm.baseclassimp;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepository.ContactInformationPage;
import com.comcast.crm.objectrepository.ContactsPage;
import com.comcast.crm.objectrepository.CreatingNewContactPage;
import com.comcast.crm.objectrepository.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.LoginPage;
import com.comcast.crm.objectrepository.OrganizationInformationPage;
import com.comcast.crm.objectrepository.OrganizationPage;

public class BaseClass2 
{
	public WebDriver driver;
	// Utility Object creation
	public DataBaseUtility du = new DataBaseUtility();
	public FileUtility fu = new FileUtility();
	public ExcelUtility eu = new ExcelUtility();
	public JavaUtility ju = new JavaUtility();
	public WebDriverUtility wu = new WebDriverUtility();
	
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS() throws SQLException
	{
		du.getDataBaseConnection();
		System.out.println("======Db connected======");
	}
	
	@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBC(String browser) throws IOException
	{
		String Browser = browser;				//fu.getDataFromPropertiesFile("browser");
		if(Browser.equalsIgnoreCase("chrome"))
			driver=new ChromeDriver();
		else if (Browser.equalsIgnoreCase("edge"))
			driver=new EdgeDriver();
		else if(Browser.contentEquals("firefox"))
			driver =new FirefoxDriver();
		else if(Browser.equalsIgnoreCase("IED"))
			driver= new InternetExplorerDriver();
		else
			driver=new ChromeDriver();
		System.out.println("====Launch Browser====");
	}
	
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBM() throws IOException
	{
		LoginPage lp = new LoginPage(driver);
		String Url = fu.getDataFromPropertiesFile("url");
		String UN  = fu.getDataFromPropertiesFile("username");
		String PW  = fu.getDataFromPropertiesFile("password");
		lp.getloginOperation(Url, UN, PW);
		System.out.println("==Login to Application==");
	}
	
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAM()
	{
		HomePage hp = new HomePage(driver);
		hp.getSignOutOperation(driver);
		System.out.println("==Logout from Application==");
	}
	
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC()
	{
		driver.quit();
		System.out.println("====Close Browser====");
	}
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAS() throws SQLException
	{
		du.closeDbConnection();
		System.out.println("====Connection closed=====");
	}
	

}
