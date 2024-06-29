package com.comcast.crm.listnerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImpClass implements IRetryAnalyzer
{

	@Override
	public boolean retry(ITestResult arg0) 
	{
		int count =0, limitCount=5;
		for(int i=count;i<=limitCount;i++)
		{
			count++;
			return true;
		}
		
		return false;
	}
}
