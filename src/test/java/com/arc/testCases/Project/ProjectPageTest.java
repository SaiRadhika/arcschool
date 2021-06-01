package com.arc.testCases.Project;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.PageObject.HomePageObjects;
import com.arc.PageObject.LoginPageObjects;
import com.arc.PageObject.Project.ProjectPageObjects;
import com.arc.commonMethods.LoggerHelper;

import com.arc.testBase.BaseClass;

public class ProjectPageTest extends BaseClass {
	/*
	 * LoginPageObjects LoginPage; HomePageObjects HomePage; ProjectPageObjects
	 * ProjectPage;
	 */
	private static Logger log= LoggerHelper.getLogger(ProjectPageTest.class);
	
	/*
	 * public ProjectPageTest() { super();
	 * log.info("ProjectPageTest constructor is called"); }
	 */

	@BeforeMethod
	@Parameters("browserName")
	public void setup(String browserName)
	
	 {
		log.info("Setup method of ProjectPageTest class started ");
		initializtion(browserName);
		LoginPage = new LoginPageObjects();
		HomePage = new HomePageObjects();
		ProjectPage = new ProjectPageObjects();
		HomePage = LoginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		ProjectPage = HomePage.clickOnProject();
		log.info("Setup method of ProjectPageTest class completed ");
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", priority = 3)
	public void CheckProjectListing() {
		log.info("CheckProjectListing method started ");
			int ProjectCount;

			ProjectCount = ProjectPage.CheckNumberOfProjects();
			// System.out.println(ProjectCount);
			Assert.assertTrue(ProjectCount > 1);
			log.info("CheckProjectListing method completed ");
			/*
			 * e.printStackTrace();
			 * com.arc.commonMethods.CommonMethod.takeScreenshotTest("CheckProjectListed");
			 */
		

	}

	@AfterMethod
	public void tearDown() {
		log.info("tearDown method of ProjectPageTest class started ");
		closeBrowser();
		log.info("tearDown method of ProjectPageTest class completed ");
	}
}
