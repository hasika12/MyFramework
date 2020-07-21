package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties prop;
	
	
	//as soon as we create an obj for this class the constructor(ConfigDataProvider) will be called automatically and will load this file
	public ConfigDataProvider()
	{
		File src = new File("./Config/config.properties");
		
		try
		{
		FileInputStream fis = new FileInputStream(src);
		
		prop = new Properties();
		
		prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Not able to load config file===>" + e.getMessage());
		}
	}
	
	
	
	public String getDataFromConfig(String keyToSearch)
	{
		return prop.getProperty(keyToSearch);
	}
	
	public String getBrowser()
	{
		return prop.getProperty("browser");
	}
	
	public String getSITurl()
	{
		return prop.getProperty("sitURL");
	}

}
