package com.automation.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pages.CogmentoLoginPage;
import com.automation.pages.CogmentoLogoutPage;
import com.automation.utility.BaseClass;
import com.automation.utility.Helper;

public class LogoutTest extends BaseClass{
	
	
	
	@Test
	public void logout() throws Exception
	{
		CogmentoLogoutPage logoutpg = PageFactory.initElements(driver, CogmentoLogoutPage.class);
		CogmentoLoginPage loginpg =  PageFactory.initElements(driver, CogmentoLoginPage.class);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		loginpg.loginToCogmento(excel.getStringData("LoginData", 0, 0), excel.getStringData("LoginData", 0, 1));
		
		Thread.sleep(5000);
		
		Assert.assertEquals(driver.getTitle(), "Cogmento CRM");
		
		logoutpg.LnkSettings.click();
		
		Thread.sleep(5000);
		
		logoutpg.LnkLogout.click();
	}
	

}
