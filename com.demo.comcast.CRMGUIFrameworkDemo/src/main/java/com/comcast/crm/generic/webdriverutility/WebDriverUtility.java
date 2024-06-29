package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility 
{
	// Maximize window
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();		
	}
	// Implicitlywait
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	//Explicitlywait
	public void waitForElement(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	// Switch to tab based on partial Url
	public void switchToTabBasedOnURl(WebDriver driver, String partialurl)
	{
		Set<String> Winids = driver.getWindowHandles();
		Iterator<String> i = Winids.iterator();
		while(i.hasNext())
		{
			String win = i.next();
			driver.switchTo().window(win);
			String currentUrl = driver.getCurrentUrl();
			if(currentUrl.contains(partialurl))
				break;
		}
	}
	
	//switch to tab based on Title
	
	public void switchToTabBasedOnTitle(WebDriver driver, String Title) 
	{
		Set<String> Winids = driver.getWindowHandles();
		Iterator<String> i = Winids.iterator();
		while(i.hasNext())
		{
			String win = i.next();
			driver.switchTo().window(win);
			String currentUrl = driver.getTitle();
			if(currentUrl.contains(Title))
				break;
		}
	}
	// Switching to Frame
	public void switchToFrameIndex(WebDriver driver, int Index)
	{
		driver.switchTo().frame(Index);
	}
	
	public void switchToFrameElement(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	// Switching to Alert
	public void switchTOAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	// Select Class
	public void selectDDByIndex(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	public void selectDDByVT(WebElement element, String Vtext)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(Vtext);
	}
	
	// Actions class
	public void mouseMoveOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	
	
	
	
	
	
	
	
	
	
}
