package com.comcast.crm.grouptest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.baseclassimp.BaseClass;
import com.comcast.crm.baseclassimp.BaseClass2;
import com.comcast.crm.objectrepository.ContactInformationPage;
import com.comcast.crm.objectrepository.ContactsPage;
import com.comcast.crm.objectrepository.CreatingNewContactPage;
import com.comcast.crm.objectrepository.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.LoginPage;
import com.comcast.crm.objectrepository.OrgChildWinInContactMod;
import com.comcast.crm.objectrepository.OrganizationInformationPage;
import com.comcast.crm.objectrepository.OrganizationPage;

public class CreateContactTest extends BaseClass
{
	@Test(groups = {"smokeTest"})
	public void CreateContactWithMandatoryTest() throws EncryptedDocumentException, IOException {
		// Creating objects for POM
		HomePage hp = new HomePage(driver);
		ContactsPage cp = new ContactsPage(driver);
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ContactInformationPage cip = new ContactInformationPage(driver);

		// Getting data from Excel
		String LastName = eu.getDataFromExcel("Contact", 1, 2) + ju.getRandomNum();

		// Creating new Contact
		hp.getContactsMod().click();
		cp.getCreateNewConBt().click();

		// Entering data
		ccp.getLastNameTxtF().sendKeys(LastName);
		ccp.getSaveBt().click();

		// Validating Header msg
		String Titleinfo = cip.getConHeaderIP().getText();
		boolean Header = Titleinfo.contains(LastName);
		Assert.assertTrue(Header);
		
	}

	@Test(groups = {"regressionTest"})
	public void createContactWithOrg() throws EncryptedDocumentException, IOException {
		// Getting data from Excel

		String OrgName = eu.getDataFromExcel("Contact", 7, 2) + ju.getRandomNum();
		String LastName = eu.getDataFromExcel("Contact", 7, 3) + ju.getRandomNum();

		// Creating Objects for Object repository
		HomePage hp = new HomePage(driver);
		OrganizationPage op = new OrganizationPage(driver);
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		ContactsPage cp = new ContactsPage(driver);
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ContactInformationPage cip = new ContactInformationPage(driver);
		OrgChildWinInContactMod ocp = new OrgChildWinInContactMod(driver);

		// Script

		// Creating new Organization

		hp.getOrganizationsMod().click();
		op.getCreateOrgBt().click();
		cop.CreateOrg(OrgName);

		String Titleinfo = oip.getOrgHeaderIP().getText();
		// Validating Header msg
		
		boolean Header = Titleinfo.contains(OrgName);
		Assert.assertEquals(true, Header);
		
		// Verify orgName
		String ActualOrg = driver.findElement(By.id("dtlview_Organization Name")).getText();
		boolean Org = ActualOrg.equals(OrgName);
		SoftAssert soft= new SoftAssert();
		soft.assertTrue(Org);

		// Creating new Contact
		hp.getContactsMod().click();
		cp.getCreateNewConBt().click();

		// Entering data
		ccp.getLastNameTxtF().sendKeys(LastName);
		ccp.getSelectOrgBt().click();

		// switching to child window
		wu.switchToTabBasedOnURl(driver, "module=Accounts&action");
		// Child window operations

		ocp.getSearchBar().sendKeys(OrgName);

		ocp.getSearchBt().click();
		driver.findElement(By.xpath("//a[text()='" + OrgName + "']")).click();

		// switching back to parent window
		wu.switchToTabBasedOnTitle(driver, "module=Contacts&action");

		ccp.getSaveBt().click();
		String Titleinfo1 = cip.getConHeaderIP().getText();
		String OrgV = cip.getOrgNameCIP().getText();

		// Validating Header msg
		boolean Header1 = Titleinfo1.contains(LastName);
		Assert.assertEquals(true, Header1);
		// Validating Orgname
		boolean Org1 = OrgV.trim().equals(OrgName);
		System.out.println(OrgV+"\t"+OrgName);
		soft.assertTrue(Org1);
		soft.assertAll();
	}

	@Test(groups = {"regressionTest"})
	public void createContactWithStartAndEndDate() throws EncryptedDocumentException, IOException {

		// Getting data from Excel and Java utility
		String LastName = eu.getDataFromExcel("Contact", 1, 2) + ju.getRandomNum();
		// Date
		String StartDate = ju.getSystemDateYYYYMMDD(); // Current Date
		String EndDate = ju.getRequiredDate(30); // Required End Date

		// Creating Objects for Object repository
		HomePage hp = new HomePage(driver);
		ContactsPage cp = new ContactsPage(driver);
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ContactInformationPage cip = new ContactInformationPage(driver);

		// Creating new Contact
		hp.getContactsMod().click();
		cp.getCreateNewConBt().click();

		// Entering data
		ccp.getLastNameTxtF().sendKeys(LastName);
		// Clearing dates
		ccp.getSupStDate().clear();
		ccp.getSupEndDate().clear();
		// Parsing Dates
		ccp.getSupStDate().sendKeys(StartDate);
		ccp.getSupEndDate().sendKeys(EndDate);
		ccp.getSaveBt().click();

		String StartV = cip.getSupStDtIP().getText();
		String EndV = cip.getSupEndDtIP().getText();

		// Validating dates
		boolean StDate = StartV.equals(StartDate);
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(StDate);
		
		boolean EdDate = EndV.equals(EndDate);
		soft.assertTrue(EdDate);
	}

}
