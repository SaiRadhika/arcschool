package com.arc.testCases;

import java.io.File;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.arc.PageObject.HomePageObjects;
import com.arc.PageObject.LoginPageObjects;
import com.arc.PageObject.Project.ProjectPageObjects;
import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;

import com.arc.testBase.BaseClass;

public class HomePageTest extends BaseClass {

	/*
	 * LoginPageObjects LoginPage; HomePageObjects HomePage; ProjectPageObjects
	 * ProjectPage;
	 */

	private static Logger log = LoggerHelper.getLogger(HomePageTest.class);

	public HomePageTest() {
		//super();
		log.info("HomePageTest constructor is called");
	}

	/*
	 * @BeforeMethod
	 * 
	 * @Parameters("browserName") public void setup(String browserName)
	 * 
	 * { log.info("Setup method of HomePageTest class started ");
	 * initializtion(browserName); LoginPage=new LoginPageObjects(); HomePage=new
	 * HomePageObjects(); HomePage=LoginPage.login(prop.getProperty("email"),
	 * prop.getProperty("password"));
	 * log.info("Setup method of HomePageTest class completed "); }
	 */

	/*
	 * @Test( dependsOnGroups = "LoginMethodTCGroup", enabled = false) public void
	 * CheckAfterOnProjectsMenu() {
	 * log.info("CheckAfterOnProjectsMenu method started ");
	 * ProjectPage=HomePage.clickOnProject(); boolean
	 * flag=ProjectPage.CheckProjectLabel(); Assert.assertTrue(flag);
	 * log.info("CheckAfterOnProjectsMenu method completed ");
	 * 
	 * 
	 * e.printStackTrace(); com.arc.commonMethods.CommonMethod.takeScreenshotTest(
	 * "CheckClickOnProjectsMenu");
	 * 
	 * 
	 * }
	 */

	@Test(dependsOnGroups = "LoginMethodTCGroup", priority = 2)
	public void EssentialUser_Download_Invoice() {

		HomePage.setHomePageApplication();
		log.info("EssentialUser_Download_Invoice method started ");
		boolean flag=HomePage.ProfileBillingInvoice();
		
		if(flag)
		{
			boolean FilesDownloaded = CommonMethod.CheckDownloadedForTwoFile();
			if(FilesDownloaded==true)
			{
				for(File file:DownloadFolder.listFiles())
				{
					file.delete();
				}
				DownloadFolder.delete();
				log.info("EssentialUser_Download_Invoice method completed ");
				Assert.assertTrue(FilesDownloaded);
			}
			else 
			{
				for(File file:DownloadFolder.listFiles())
				{
					file.delete();
				}
				DownloadFolder.delete();
				log.info("EssentialUser_Download_Invoice method completed ");
				Assert.assertTrue(false);
			}
				
			
		}
		else
		{
			log.info("EssentialUser_Download_Invoice method completed ");
			Assert.assertTrue(false);
		}
		
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", priority = 100)
	public void Logout_Test() {

		
		log.info("Logout_Test method started ");
		HomePage.setHomePageApplication();
		String Title=HomePage.checkSignOut();
		System.out.println(Title);
		Assert.assertEquals(Title,"Arc Skoru | Sustainability performance platform" );
		
		
	}

	/*
	 * @AfterMethod public void tearDown() {
	 * log.info("tearDown method of HomePageTest class started "); closeBrowser();
	 * log.info("tearDown method of HomePageTest class completed "); }
	 */

}
