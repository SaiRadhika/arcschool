package com.arc.testCases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.arc.pageObjects.HomePageObjects;
import com.arc.pageObjects.LoginPageObjects;
import com.arc.pageObjects.building.ProjectPageObjects;
import com.arc.testBase.BaseClass;

public class HomePageTest extends BaseClass{
	
		LoginPageObjects LoginPage;
		HomePageObjects HomePage;
		ProjectPageObjects ProjectPage;
		public HomePageTest()
		{
			super();
		}
		
		@BeforeMethod
		public void setup()
		{
			initializtion();
			LoginPage=new LoginPageObjects();			
			HomePage=new HomePageObjects();
			HomePage=LoginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		}
		
		@Test
		public void CheckClickOnProjectsMenu()
		{
			ProjectPage=HomePage.clickOnProject();
			boolean flag=ProjectPage.CheckProjectLabel();
			Assert.assertTrue(flag);
		}
		
		@AfterMethod
		public void tearDown()
		{
			closeBrowser();
		}

}
