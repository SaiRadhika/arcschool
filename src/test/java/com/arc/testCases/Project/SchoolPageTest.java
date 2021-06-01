package com.arc.testCases.Project;

import java.io.File;

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
import com.arc.PageObject.Project.SchoolPageObject;
import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class SchoolPageTest extends BaseClass{
	
	
	/*
	 * LoginPageObjects LoginPage; HomePageObjects HomePage; ProjectPageObjects
	 * ProjectPage; BuildingPageObject BuildingPage; SchoolPageObject SchoolPage;
	 */
	
	private static Logger log= LoggerHelper.getLogger(SchoolPageTest.class);
	
	/*
	 * public SchoolPageTest() { super();
	 * log.info("SchoolPageTest constructor is called"); }
	 */

	/*
	 * @BeforeMethod
	 * 
	 * @Parameters("browserName") public void setup(String browserName)
	 * 
	 * { log.info("Setup method of SchoolPageTest class started ");
	 * initializtion(browserName); LoginPage = new LoginPageObjects(); HomePage =
	 * new HomePageObjects(); ProjectPage = new ProjectPageObjects(); SchoolPage=new
	 * SchoolPageObject(); HomePage = LoginPage.login(prop.getProperty("email"),
	 * prop.getProperty("password")); ProjectPage = HomePage.clickOnProject();
	 * SchoolPage=ProjectPage.clickOnFirstSchool();
	 * 
	 * log.info("Setup method of SchoolPageTest class completed "); }
	 */
	@Test(dependsOnGroups = "LoginMethodTCGroup", enabled = true, priority = 5)
	public void School_Agreement_Display() {
		
			log.info("School_Agreement_Display method started ");
			HomePage.setHomePageApplication();
			ProjectPage=HomePage.clickOnProject();
			SchoolPage=new SchoolPageObject();
			SchoolPage=ProjectPage.SearchAndClickOnSchoolProject(data.getCellData("Reboot", 1, 2));
			SchoolPage.ClickonAgreementInManage();
			HomePage.closeProjectSearchTextBox();
			boolean flag = CommonMethod.CheckAgreementDisplay();
			//boolean flag = SchoolPage.CheckAgreementDisplay();
			if(flag)
			{
				log.info("School_Agreement_Display method completed ");
				Assert.assertTrue(true);
			}
			else
			{
				log.info("School_Agreement_Display method completed ");
				Assert.assertTrue(false);
			}
				
			
		

	}
	
	@Test(dependsOnGroups = "LoginMethodTCGroup",dependsOnMethods = "School_Agreement_Display", enabled = true, priority = 5)
	public void School_Agreement_Download() {
		
			log.info("School_Agreement_Download method started ");
			HomePage.setHomePageApplication();
			ProjectPage=HomePage.clickOnProject();
			SchoolPage=new SchoolPageObject();
			SchoolPage=ProjectPage.SearchAndClickOnSchoolProject(data.getCellData("Reboot", 1, 2));
			SchoolPage.ClickonAgreementInManage();
			HomePage.closeProjectSearchTextBox();
			CommonMethod.ClikOnAgreementRegistrationDownloadLink();
			//SchoolPage.ClikOnAgreementRegistrationDownloadLink();
			long FileLength = CommonMethod.CheckDownloadedFile();
			if(FileLength>0)
			{
				for(File file:DownloadFolder.listFiles())
				{
					file.delete();
				}
				DownloadFolder.delete();
				log.info("School_Agreement_Download method completed ");
				Assert.assertTrue(FileLength>0);
			}
			else
			{
				log.info("School_Agreement_Download method completed ");
				Assert.assertTrue(false);
			}
	}
	
	
	@Test(dependsOnGroups = "LoginMethodTCGroup",enabled = true, priority = 5)
	public void School_PerformanceCertificate_Download_Invoice_Receipt() {
		
			log.info("School_PerformanceCertificate_Download_Invoice_Receipt method started ");
			HomePage.setHomePageApplication();
			ProjectPage = HomePage.clickOnProject();
			SchoolPage=new SchoolPageObject();
			System.out.println(data.getCellData("Reboot", 4, 2));
			SchoolPage=ProjectPage.SearchAndClickOnSchoolProject(data.getCellData("Reboot", 4, 2));
			//BuildingPage=ProjectPage.clickOnFirstProject();
			SchoolPage.ClickonBillingInManage();
			HomePage.closeProjectSearchTextBox();
			
			CommonMethod.ClikOnBillingDownloadForSubScriptionLink();
			//SchoolPage.ClikOnBillingDownloadForSubScriptionLink();
			boolean FileLength = CommonMethod.CheckDownloadedForTwoFile();
			if(FileLength==true)
			{
				for(File file:DownloadFolder.listFiles())
				{
					file.delete();
				}
				DownloadFolder.delete();
				log.info("School_PerformanceCertificate_Download_Invoice_Receipt method completed ");
				Assert.assertTrue(FileLength);
			}
			else 
			{
				for(File file:DownloadFolder.listFiles())
				{
					file.delete();
				}
				DownloadFolder.delete();
				log.info("School_PerformanceCertificate_Download_Invoice_Receipt method completed ");
				Assert.assertTrue(false);
			}
				
			
		

	}
	
	
	@Test(dependsOnGroups = "LoginMethodTCGroup",enabled = true, priority = 5)
	public void School_LEEDProject_DownloadInvoice() {
		
			log.info("School_LEEDProject_DownloadInvoice method started ");
			HomePage.setHomePageApplication();
			ProjectPage = HomePage.clickOnProject();
			SchoolPage=new SchoolPageObject();
			System.out.println(data.getCellData("Reboot", 5, 2));
			SchoolPage=ProjectPage.SearchAndClickOnSchoolProject(data.getCellData("Reboot", 5, 2));
			//BuildingPage=ProjectPage.clickOnFirstProject();
			SchoolPage.ClickonBillingInManage();
			HomePage.closeProjectSearchTextBox();
			
			CommonMethod.ClikOnBillingDownloadForRegistrationLink();
			//SchoolPage.ClikOnBillingDownloadForRegistrationLink();
			long FileLength = CommonMethod.CheckDownloadedFile();
			if(FileLength>0)
			{
				for(File file:DownloadFolder.listFiles())
				{
					file.delete();
				}
				DownloadFolder.delete();
				log.info("School_LEEDProject_DownloadInvoice method completed ");
				Assert.assertTrue(FileLength>0);
			}
			else 
			{
				for(File file:DownloadFolder.listFiles())
				{
					file.delete();
				}
				DownloadFolder.delete();
				log.info("School_LEEDProject_DownloadInvoice method completed ");
				Assert.assertTrue(false);
			}
				
			
		

	}
	
	
	
	/*
	 * @AfterMethod public void tearDown() {
	 * log.info("tearDown method of BuildingPageTest class started ");
	 * closeBrowser();
	 * log.info("tearDown method of BuildingPageTest class completed "); }
	 */
	

}
