package com.comcast.crm.grouptest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.baseclassimp.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepository.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.LoginPage;
import com.comcast.crm.objectrepository.OrganizationInformationPage;
import com.comcast.crm.objectrepository.OrganizationPage;

import junit.framework.Assert;

public class CreateOrgTest extends BaseClass
{
	@Test(groups = {"smokeTest"})
	public void CreateOrgWithNameTest() throws EncryptedDocumentException, IOException
	{
		
		// Getting data from Excel
		UtilityClassObject.getTest().log(Status.INFO, "Reading Data from excel");
		
		String OrgName = eu.getDataFromExcel("Org", 10, 2)+ju.getRandomNum();
		
		// Creating Objects for ObjectRepository
		HomePage hp = new HomePage(driver);
		OrganizationPage op = new OrganizationPage(driver);
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);

		
		// Navigating to Org page and Creating new Org
		hp.getOrganizationsMod().click();  // OrgMod
		op.getCreateOrgBt().click();  // Creating new Org Button
		
		// Entering data and Saving
		cop.CreateOrg(OrgName);
		UtilityClassObject.getTest().log(Status.INFO, OrgName+" >>> Created");
		
		// Validating Header msg
		String Titleinfo = oip.getOrgHeaderIP().getText();
		
		boolean Header = Titleinfo.contains(OrgName);
		Assert.assertEquals(true, Header);
		
		// Verify orgName
		String ActualOrg = oip.getOrgNameIP().getText();
		boolean Org = ActualOrg.equals(OrgName);
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(Org);
		soft.assertAll();
	}
	
	@Test(groups = {"regressionTest"})
	public void createOrgWithIndustryType() throws EncryptedDocumentException, IOException
	{	
		UtilityClassObject.getTest().log(Status.INFO, "Read data from Excel");
		// Getting data from Excel
		String OrgName = eu.getDataFromExcel("Org", 4, 2)+ju.getRandomNum();
		String Industry = eu.getDataFromExcel("Org", 4, 3);
		String Type = eu.getDataFromExcel("Org", 4, 4);
		
		// Creating Objects for ObjectRepository
		HomePage hp = new HomePage(driver);
		OrganizationPage op = new OrganizationPage(driver);
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		
		hp.getOrganizationsMod().click();
		op.getCreateOrgBt().click();
		
		// Entering data 
		cop.CreateOrg(OrgName, Industry, Type);
		
		// Validate Industy and Type
		SoftAssert soft = new SoftAssert();
		String IndustryV = oip.getIndustryDDIP().getText();
		boolean Ind = IndustryV.equals(Industry);
		soft.assertTrue(Ind);
		// Type Validation
		String TyV = oip.getTypeDDIP().getText();
		boolean Ty = TyV.equals(Type);
		soft.assertTrue(Ty);
		soft.assertAll();
		
	}
	
	@Test(groups = {"regressionTest"})
	public void createWithPhoneNum() throws EncryptedDocumentException, IOException
	{
		UtilityClassObject.getTest().log(Status.INFO, "Read data from Excel");
		// Getting data from Excel
		String OrgName = eu.getDataFromExcel("Org", 7, 2)+ju.getRandomNum();
		String Phone = eu.getDataFromExcel("Org", 7, 3);
		
		// Creating Objects for ObjectRepository
		HomePage hp = new HomePage(driver);
		OrganizationPage op = new OrganizationPage(driver);
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
	
		// Creating new Organization
		hp.getOrganizationsMod().click();
		op.getCreateOrgBt().click();
		// Entering data
		cop.CreateOrg(OrgName, Phone);
		
		// verify Phone number
		String PhV = oip.getPhoneTxtIP().getText();
		boolean Ph = PhV.trim().equals(Phone);
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(Ph);
		soft.assertAll();
	}

}
