package com.arc.testCases.Project;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.PageObject.HomePageObjects;
import com.arc.PageObject.LoginPageObjects;
import com.arc.PageObject.Project.BuildingPageObject;
import com.arc.PageObject.Project.ProjectPageObjects;
import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class BuildingPageTest extends BaseClass {
	
	/*
	 * LoginPageObjects LoginPage; HomePageObjects HomePage; ProjectPageObjects
	 * ProjectPage; BuildingPageObject BuildingPage;
	 */
	private static Logger log= LoggerHelper.getLogger(BuildingPageTest.class);
	
	/*
	 * public BuildingPageTest() { super();
	 * log.info("BuildingPageTest constructor is called"); }
	 */

	/*
	 * @BeforeMethod
	 * 
	 * @Parameters("browserName") public void setup(String browserName)
	 * 
	 * { log.info("Setup method of BuildingPageTest class started ");
	 * initializtion(browserName); LoginPage = new LoginPageObjects(); HomePage =
	 * new HomePageObjects(); ProjectPage = new ProjectPageObjects();
	 * BuildingPage=new BuildingPageObject(); HomePage =
	 * LoginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	 * ProjectPage = HomePage.clickOnProject();
	 * BuildingPage=ProjectPage.clickOnFirstProject();
	 * //BuildingPage=ProjectPage.SearchAndClickOnProject(data.getCellData("Reboot",
	 * 0, 2));
	 * 
	 * log.info("Setup method of BuildingPageTest class completed "); }
	 */
	@Test(dependsOnGroups = "LoginMethodTCGroup", enabled = true, priority = 4)
	public void Building_Agreement_Display() {
			log.info("Building_Agreement_Display method started ");
			HomePage.setHomePageApplication();
		    ProjectPage = HomePage.clickOnProject();
		    System.out.println(data.getCellData("Reboot", 0, 2));
		    BuildingPage=ProjectPage.SearchAndClickOnProject(data.getCellData("Reboot", 0, 2));			
			BuildingPage.ClickonAgreementInManage();
			HomePage.closeProjectSearchTextBox();
			boolean flag = CommonMethod.CheckAgreementDisplay();
			//boolean flag = BuildingPage.CheckAgreementDisplay();
			if(flag)
			{
				log.info("Building_Agreement_Display method completed ");
				Assert.assertTrue(true);
			}
			else
			{
				log.info("Building_Agreement_Display method completed ");
				Assert.assertTrue(false);
			}
	}
	
	
	@Test(dependsOnGroups = "LoginMethodTCGroup",dependsOnMethods = "Building_Agreement_Display", enabled = true, priority = 4)
	public void Building_Agreement_Download() {
			log.info("Building_Agreement_Download method started ");
			HomePage.setHomePageApplication();
		    ProjectPage = HomePage.clickOnProject();
		    System.out.println(data.getCellData("Reboot", 0, 2));
		    BuildingPage=ProjectPage.SearchAndClickOnProject(data.getCellData("Reboot", 0, 2));			
			BuildingPage.ClickonAgreementInManage();
			HomePage.closeProjectSearchTextBox();
			CommonMethod.ClikOnAgreementRegistrationDownloadLink();
			//BuildingPage.ClikOnAgreementDownloadLink();
			long FileLength = CommonMethod.CheckDownloadedFile();
			if(FileLength>0)
			{
				log.info("Size of the downloaded file is ... "+FileLength);
				for(File file:DownloadFolder.listFiles())
				{
					file.delete();
				}
				DownloadFolder.delete();
				log.info("Building_Agreement_Download method completed ");
				Assert.assertTrue(FileLength>0);
			}
			else
			{
				log.info("Size of the downloaded file is ... "+FileLength);
				log.info("Building_Agreement_Download method completed ");
				Assert.assertTrue(false);
			}
				
			
		

	}
	
	@Test(dependsOnGroups = "LoginMethodTCGroup",enabled = true, priority = 4)
	public void Building_PerformanceCertificate_Download_Invoice_Receipt() {
		
			log.info("Building_PerformanceCertificate_Download_Invoice_Receipt method started ");
			HomePage.setHomePageApplication();
			ProjectPage = HomePage.clickOnProject();
			System.out.println(data.getCellData("Reboot", 2, 2));
			BuildingPage=ProjectPage.SearchAndClickOnProject(data.getCellData("Reboot", 2, 2));
			//BuildingPage=ProjectPage.clickOnFirstProject();
			BuildingPage.ClickonBillingInManage();
			HomePage.closeProjectSearchTextBox();
			CommonMethod.ClikOnBillingDownloadForSubScriptionLink();
			//BuildingPage.ClikOnBillingDownloadForSubScriptionLink();
			boolean FileLength = CommonMethod.CheckDownloadedForTwoFile();
			if(FileLength==true)
			{
				for(File file:DownloadFolder.listFiles())
				{
					file.delete();
				}
				DownloadFolder.delete();
				log.info("Building_PerformanceCertificate_Download_Invoice_Receipt method completed ");
				Assert.assertTrue(FileLength);
			}
			else 
			{
				for(File file:DownloadFolder.listFiles())
				{
					file.delete();
				}
				DownloadFolder.delete();
				log.info("Building_PerformanceCertificate_Download_Invoice_Receipt method completed ");
				Assert.assertTrue(false);
			}
				
			
		

	}
	@Test(dependsOnGroups = "LoginMethodTCGroup",enabled = true, priority = 4)
	public void Building_LEEDIDProject_Download_Invoice() {
		
			log.info("Building_LEEDIDProject_Download_Invoice method started ");
			HomePage.setHomePageApplication();
			ProjectPage = HomePage.clickOnProject();
			System.out.println(data.getCellData("Reboot", 3, 2));
			BuildingPage=ProjectPage.SearchAndClickOnProject(data.getCellData("Reboot", 3, 2));
			//BuildingPage=ProjectPage.clickOnFirstProject();
			BuildingPage.ClickonBillingInManage();
			HomePage.closeProjectSearchTextBox();
			System.out.println();
			
			CommonMethod.ClikOnBillingDownloadForRegistrationLink();
			//BuildingPage.ClikOnBillingDownloadForRegistrationLink();
			long FileLength = CommonMethod.CheckDownloadedFile();
			if(FileLength>0)
			{
				for(File file:DownloadFolder.listFiles())
				{
					file.delete();
				}
				DownloadFolder.delete();
				log.info("Building_LEEDIDProject_Download_Invoice method completed ");
				Assert.assertTrue(FileLength>0);
			}
			else 
			{
				for(File file:DownloadFolder.listFiles())
				{
					file.delete();
				}
				DownloadFolder.delete();
				log.info("Building_LEEDIDProject_Download_Invoice method completed ");
				Assert.assertTrue(false);
			}
	

	
}
	
	
	
	@Test(dependsOnGroups = "LoginMethodTCGroup",enabled = true, priority = 4)
	public void Building_Recertification_Download_Invoice() {
		
			log.info("Building_Recertification_Download_Invoice method started ");
			HomePage.setHomePageApplication();
			ProjectPage = HomePage.clickOnProject();
			System.out.println(data.getCellData("Reboot", 14, 2));
			BuildingPage=ProjectPage.SearchAndClickOnProject(data.getCellData("Reboot", 14, 2));
			//BuildingPage=ProjectPage.clickOnFirstProject();
			BuildingPage.ClickonBillingInManage();
			HomePage.closeProjectSearchTextBox();
			System.out.println();
			
			CommonMethod.ClikOnBillingDownloadForRecertificationLink();
			//BuildingPage.ClikOnBillingDownloadForRegistrationLink();
			long FileLength = CommonMethod.CheckDownloadedFile();
			if(FileLength>0)
			{
				for(File file:DownloadFolder.listFiles())
				{
					file.delete();
				}
				DownloadFolder.delete();
				log.info("Building_Recertification_Download_Invoice method completed ");
				Assert.assertTrue(FileLength>0);
			}
			else 
			{
				for(File file:DownloadFolder.listFiles())
				{
					file.delete();
				}
				DownloadFolder.delete();
				log.info("Building_Recertification_Download_Invoice method completed ");
				Assert.assertTrue(false);
			}
	
}
}