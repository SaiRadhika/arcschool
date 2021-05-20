package com.arc.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.arc.pageObjects.HomePageObjects;
import com.arc.pageObjects.LoginPageObjects;
import com.arc.testBase.BaseClass;



public class LoginPageTest extends BaseClass{
	LoginPageObjects LoginPage;
	HomePageObjects HomePage;
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initializtion();
		LoginPage=new LoginPageObjects();
		HomePage=new HomePageObjects();
	}
	
	
	@Test(priority = 1,enabled=false)
	public void LoginPageTitleTest()
	{
		String Title=LoginPage.checkLoginPageTitle();
		Assert.assertEquals("Arc Skoru | Sustainability performance platform", Title);
	}
	
	
	@Test(priority = 2)
	public void LoginIntoApplicationTest()
	{
		HomePage=LoginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		String HTitle=HomePage.checkHomePageTitle();
		Assert.assertEquals("Arc dashboard", HTitle);
	}
	@AfterMethod
	public void tearDown()
	{
		closeBrowser();
	}

}
