package com.arc.testCases.Building;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.arc.pageObjects.HomePageObjects;
import com.arc.pageObjects.LoginPageObjects;
import com.arc.pageObjects.building.ProjectPageObjects;
import com.arc.testBase.BaseClass;

public class ProjectPageTest extends BaseClass{

	LoginPageObjects LoginPage;
	HomePageObjects HomePage;
	ProjectPageObjects ProjectPage;
	
	
	public ProjectPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initializtion();
		LoginPage=new LoginPageObjects();
		HomePage=new HomePageObjects();
		ProjectPage=new ProjectPageObjects();
		HomePage=LoginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		ProjectPage=HomePage.clickOnProject();
	}
	
	@Test
	public void CheckProjectListed()
	{
		int ProjectCount;
		
			ProjectCount = ProjectPage.CheckNumberOfProjects();
			//System.out.println(ProjectCount);
			Assert.assertTrue(ProjectCount>1);
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		closeBrowser();
	}
}
