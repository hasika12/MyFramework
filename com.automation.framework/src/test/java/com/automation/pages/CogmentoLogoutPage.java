package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CogmentoLogoutPage {
	
	WebDriver driver;
	
	public CogmentoLogoutPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
			
	@FindBy(how=How.XPATH, using="(//i[@class='settings icon'])[1]")
	public WebElement LnkSettings;
	
	@FindBy(how=How.XPATH, using="//*[text()='Log Out']")
	public WebElement LnkLogout;
	
	

}
