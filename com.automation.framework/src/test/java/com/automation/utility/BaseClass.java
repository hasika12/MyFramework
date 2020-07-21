package com.automation.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	
	public ExtentReports report;
	public ExtentTest logger;
	
	
	@BeforeSuite
	public void setupSuite()
	{
		// these logs will not be generated in extent reports, will only be genereated in testng reports
		Reporter.log("Settingup reports and test started", true);
		
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/TestReports/Cogmento"+Helper.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Settingup is done and test can be started", true);
		
	}
	
	@BeforeMethod
	public void setup()
	{
		Reporter.log("Trying to start the browser", true);
		
		driver = BrowserFactory.launchApplication(driver, config.getBrowser(), config.getSITurl());
		
		Reporter.log("Browser and application is up and running", true);
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Helper.captureScreenshot(driver);
			try {
				logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (IOException e) {
				System.out.println("Unable to take the screenshot==> "+e.getMessage());
			}
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			try {
				logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (IOException e) {
				System.out.println("Unable to take the screenshot==> "+e.getMessage());
			}
		}
		
		report.flush();//Writes test information from the started reporters to their output view •extent-html-formatter: flush output to HTML file

		BrowserFactory.quitBrowser(driver);
	}
	
	


}
