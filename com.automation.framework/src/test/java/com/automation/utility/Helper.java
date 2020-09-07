package com.automation.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	
	//Alerts, multipleWindows, syncIssues etc...
	
	public static String captureScreenshot(WebDriver driver)
	{
		TakesScreenshot ts = (TakesScreenshot)driver; //TakesScreenshot is an interface, for interface we cannot create
													  // an object, so we need to type cast it forcefully to driver reference				
		
		String screenshotPath = System.getProperty("user.dir")+"/Screenshots/Cogmento-"+ getCurrentDateTime() + ".png";
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		
		
		try {
			FileHandler.copy(src, new File(screenshotPath));
			} catch (Exception e) {
			System.out.println("Unable to capture screenshot==>"+e.getMessage());
			}
		
		return screenshotPath;
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy HH_mm_ss");
		
		Date currentDate = new Date();
		
		return customformat.format(currentDate);
	}
	
	public void handleFrames()
	{
		
	}

}
