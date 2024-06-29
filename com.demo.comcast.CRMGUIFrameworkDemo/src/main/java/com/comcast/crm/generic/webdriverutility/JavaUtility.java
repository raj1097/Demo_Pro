package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility 
{
	// Random Number
	public int getRandomNum()
	{
		Random ran = new Random();
		int Randomnum = ran.nextInt(5000);
		
		return Randomnum;
	}
	// System Date
	public String getSystemDateYYYYMMDD()
	{
		Date dt = new Date();
		SimpleDateFormat sdm = new SimpleDateFormat("YYYY-MM-dd");
		String SysDate = sdm.format(dt);
	
		return SysDate;
	}
	
	// Required Date from Current Date
	public String getRequiredDate(int Days)
	{
		Date dt = new Date();
		SimpleDateFormat sdm = new SimpleDateFormat("YYYY-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.add(Calendar.DAY_OF_MONTH, Days);
		String RequiredDate = sdm.format(cal.getTime());
		
		return RequiredDate;
		
	}
	
	
}
