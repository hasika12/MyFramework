package com.automation.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.automation.pages.CogmentoLoginPage;
import com.automation.utility.BaseClass;
import com.automation.utility.BrowserFactory;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;

public class LoginTest extends BaseClass {
	

	
	@Test(priority=1)
	public void loginApp()
	{
			
		/*PageFactory is a class which has initElements as a method. 
		 * with this method it will initialize all the elements present in CogmentoLoginPage
		it will return the object of the same class*/
		
		logger = report.createTest("Login to Cogmento");
		
		CogmentoLoginPage loginpg =PageFactory.initElements(driver, CogmentoLoginPage.class);
		
		logger.info("Launching the application");
		
		loginpg.loginToCogmento(excel.getStringData("LoginData", 0, 0), excel.getStringData("LoginData", 0, 1));
		
		logger.pass("Login done successfully");
		
		//Helper.captureScreenshot(driver);
		
	}
	
	@Test(priority=2)
	public void loginApp1()
	{
		logger=report.createTest("Logout");
		
		logger.fail("Logout Failed");
	}

}
