package com.comcast.crm.listnerutility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.baseclassimp.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public  class ListImpClass implements ITestListener , ISuiteListener
{
	public ExtentReports report;
	public static ExtentTest test;
	
		
	@Override
	public void onStart(ISuite suite) 
	{
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_'at'_hh_mm_ss_a");
		String time = sdf.format(dt);
		System.out.println("Report Config");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report"+time+".html");
		spark.config().setDocumentTitle("Comcast CMR Test suite report");
		spark.config().setReportName("Comcast CMR report");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows 10");
	}
	
	@Override
	public void onFinish(ISuite arg0) 
	{
		System.out.println("Report backup");
		report.flush();
	}
	@Override
	public void onFinish(ITestContext arg0) {
		
	}
	
	@Override
	public void onStart(ITestContext arg0) {
		
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) 
	{
		
		String TestName = result.getMethod().getMethodName();
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_'at'_hh_mm_ss_a");
		String time = sdf.format(dt);
		TakesScreenshot ts = (TakesScreenshot) UtilityClassObject.getDriver();
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filepath,TestName+"_"+time);
		test.log(Status.FAIL, TestName+" >>>>> Fail");	
	}
	
	@Override
	public void onTestSkipped(ITestResult res) {	
	}
	
	@Override
	public void onTestStart(ITestResult res) 
	{
		String methodName = res.getMethod().getMethodName();
		test = report.createTest(methodName);
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, res.getMethod().getMethodName()+" >>>>> Started");
		
	}
	
	@Override
	public void onTestSuccess(ITestResult res) {
		test.log(Status.PASS, res.getMethod().getMethodName()+" >>>>> Pass");
	}
}
