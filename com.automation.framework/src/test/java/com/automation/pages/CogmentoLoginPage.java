package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CogmentoLoginPage {
	
	WebDriver driver;
	
	//ldriver will come from main test case
	//we will store that ldriver to our driver in this page
	//this constructor will help us to intialize the webdriver 
	public CogmentoLoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(how=How.XPATH, using="//*[@name='email']")
	public WebElement EdtEmailID;
	
	@FindBy(how=How.NAME, using="password")
	public WebElement EdtPwd;
	
	@FindBy(how=How.XPATH, using="//*[text()='Login']")
	public WebElement BtnLogin;
	
	public void loginToCogmento(String uid, String pwd)
	{
		EdtEmailID.sendKeys(uid);
		EdtPwd.sendKeys(pwd);
		BtnLogin.click();
		
		
	}
	
	

}
