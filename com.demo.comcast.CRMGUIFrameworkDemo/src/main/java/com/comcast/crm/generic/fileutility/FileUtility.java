package com.comcast.crm.generic.fileutility;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility 
{
	public String getDataFromPropertiesFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("./configAppData/commondata.properties");
		Properties pr = new Properties();
		pr.load(fis);
		String Data = pr.getProperty(key);
		return Data;
	}

}
