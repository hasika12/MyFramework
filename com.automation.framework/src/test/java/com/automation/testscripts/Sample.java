package com.automation.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;



public class Sample {
	
WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@Test
	public void test1()
	{
		
		
		
		DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
		
		dc.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		
		System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
		driver = new InternetExplorerDriver(dc);
		
		
	}

}
