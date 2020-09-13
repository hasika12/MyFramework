package com.automation.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.pages.CogmentoLoginPage;
import com.automation.pages.CogmentoLogoutPage;
import com.automation.utility.BaseClass;
import com.automation.utility.BrowserFactory;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;

public class LoginTest extends BaseClass {
	

	
	@Test(priority=1)
	public void loginApp() throws Exception
	{
			
		/*PageFactory is a class which has initElements as a method. 
		 * with this method it will initialize all the elements present in CogmentoLoginPage
		it will return the object of the same class*/
		
		logger = report.createTest("Login to Cogmento");
		
		CogmentoLoginPage loginpg =PageFactory.initElements(driver, CogmentoLoginPage.class);
		CogmentoLogoutPage logoutpg = PageFactory.initElements(driver, CogmentoLogoutPage.class);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		logger.info("Launching the application");
		
		loginpg.loginToCogmento(excel.getStringData("LoginData", 0, 0), excel.getStringData("LoginData", 0, 1));
		
		logger.pass("Login done successfully");
		
		//Helper.captureScreenshot(driver);
		
		Assert.assertEquals(driver.getTitle(), "Cogmento CRM");
		
		Thread.sleep(5000);
		
		logoutpg.LnkSettings.click();
		
		Thread.sleep(5000);
		
		logoutpg.LnkLogout.click();
		
	}
	
	@Test(priority=2)
	public void loginApp1()
	{
		logger=report.createTest("Logout");
		
		logger.fail("Logout Failed");
	}

}
