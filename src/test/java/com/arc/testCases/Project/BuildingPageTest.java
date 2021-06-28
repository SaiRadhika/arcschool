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
	private static Logger log = LoggerHelper.getLogger(BuildingPageTest.class);

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
	@Test(dependsOnGroups = "LoginMethodTCGroup", enabled = true, groups = { "Reboot" }, priority = 4, description = "Verify Manage-->Agreements should show the project agreement.")
	public void Building_Agreement_Display() {
		log.info("Building_Agreement_Display method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		System.out.println(data.getCellData("Reboot", "BuildingProjectID", 2));
		BuildingPage = ProjectPage.SearchAndClickOnProject(data.getCellData("Reboot", 0, 2));
		BuildingPage.ClickonAgreementInManage();
		HomePage.closeProjectSearchTextBox();
		boolean flag = CommonMethod.CheckAgreementDisplay();
		// boolean flag = BuildingPage.CheckAgreementDisplay();
		if (flag) {
			log.info("Building_Agreement_Display method completed ");
			Assert.assertTrue(true);
		} else {
			log.info("Building_Agreement_Display method completed ");
			Assert.assertTrue(false);
		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Building_Agreement_Display", groups = {
			"Reboot" }, enabled = true, priority = 4, description = "Verify able to download the agreement successfully.")
	public void Building_Agreement_Download() {
		log.info("Building_Agreement_Download method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		System.out.println(data.getCellData("Reboot", 0, 2));
		BuildingPage = ProjectPage.SearchAndClickOnProject(data.getCellData("Reboot", 0, 2));
		BuildingPage.ClickonAgreementInManage();
		HomePage.closeProjectSearchTextBox();
		CommonMethod.ClikOnAgreementRegistrationDownloadLink();
		// BuildingPage.ClikOnAgreementDownloadLink();
		long FileLength = CommonMethod.CheckDownloadedFile();
		if (FileLength > 0) {
			log.info("Size of the downloaded file is ... " + FileLength);
			for (File file : DownloadFolder.listFiles()) {
				file.delete();
			}
			DownloadFolder.delete();
			log.info("Building_Agreement_Download method completed ");
			Assert.assertTrue(FileLength > 0);
		} else {
			log.info("Size of the downloaded file is ... " + FileLength);
			log.info("Building_Agreement_Download method completed ");
			Assert.assertTrue(false);
		}

	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = { "Reboot" }, enabled = true, priority = 4, description = "Verify if performance certificates is purchased, able to download the invoice and receipt successfully from Manage-->Billing tab.")
	public void Building_PerformanceCertificate_Download_Invoice_Receipt() {

		log.info("Building_PerformanceCertificate_Download_Invoice_Receipt method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		System.out.println(data.getCellData("Reboot", 2, 2));
		BuildingPage = ProjectPage.SearchAndClickOnProject(data.getCellData("Reboot", 2, 2));
		// BuildingPage=ProjectPage.clickOnFirstProject();
		BuildingPage.ClickonBillingInManage();
		HomePage.closeProjectSearchTextBox();
		CommonMethod.ClikOnBillingDownloadForSubScriptionLink();
		// BuildingPage.ClikOnBillingDownloadForSubScriptionLink();
		boolean FileLength = CommonMethod.CheckDownloadedForTwoFile();
		if (FileLength == true) {
			for (File file : DownloadFolder.listFiles()) {
				file.delete();
			}
			DownloadFolder.delete();
			log.info("Building_PerformanceCertificate_Download_Invoice_Receipt method completed ");
			Assert.assertTrue(FileLength);
		} else {
			for (File file : DownloadFolder.listFiles()) {
				file.delete();
			}
			DownloadFolder.delete();
			log.info("Building_PerformanceCertificate_Download_Invoice_Receipt method completed ");
			Assert.assertTrue(false);
		}

	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = { "Reboot" }, enabled = true, priority = 4, description = "Verify if leed id project, able to download the registration invoice and receipt successfully from Manage-->Billing tab.")
	public void Building_LEEDIDProject_Download_Invoice() {

		log.info("Building_LEEDIDProject_Download_Invoice method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		System.out.println(data.getCellData("Reboot", 3, 2));
		BuildingPage = ProjectPage.SearchAndClickOnProject(data.getCellData("Reboot", 3, 2));
		// BuildingPage=ProjectPage.clickOnFirstProject();
		BuildingPage.ClickonBillingInManage();
		HomePage.closeProjectSearchTextBox();
		System.out.println();

		CommonMethod.ClikOnBillingDownloadForRegistrationLink();
		// BuildingPage.ClikOnBillingDownloadForRegistrationLink();
		long FileLength = CommonMethod.CheckDownloadedFile();
		if (FileLength > 0) {
			for (File file : DownloadFolder.listFiles()) {
				file.delete();
			}
			DownloadFolder.delete();
			log.info("Building_LEEDIDProject_Download_Invoice method completed ");
			Assert.assertTrue(FileLength > 0);
		} else {
			for (File file : DownloadFolder.listFiles()) {
				file.delete();
			}
			DownloadFolder.delete();
			log.info("Building_LEEDIDProject_Download_Invoice method completed ");
			Assert.assertTrue(false);
		}

	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = { "Reboot" }, enabled = true, priority = 4, description = "Verify if project submitted for recertification, billing--> Invoice and receipt are downloaded successfully.")
	public void Building_Recertification_Download_Invoice() {

		log.info("Building_Recertification_Download_Invoice method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		System.out.println(data.getCellData("Reboot", 14, 2));
		BuildingPage = ProjectPage.SearchAndClickOnProject(data.getCellData("Reboot", 14, 2));
		// BuildingPage=ProjectPage.clickOnFirstProject();
		BuildingPage.ClickonBillingInManage();
		HomePage.closeProjectSearchTextBox();
		System.out.println();

		CommonMethod.ClikOnBillingDownloadForRecertificationLink();
		// BuildingPage.ClikOnBillingDownloadForRegistrationLink();
		long FileLength = CommonMethod.CheckDownloadedFile();
		if (FileLength > 0) {
			for (File file : DownloadFolder.listFiles()) {
				file.delete();
			}
			DownloadFolder.delete();
			log.info("Building_Recertification_Download_Invoice method completed ");
			Assert.assertTrue(FileLength > 0);
		} else {
			for (File file : DownloadFolder.listFiles()) {
				file.delete();
			}
			DownloadFolder.delete();
			log.info("Building_Recertification_Download_Invoice method completed ");
			Assert.assertTrue(false);
		}
	}
	
	// Verify Manage-->Teams should show team members added to the project.

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = { "Reboot" }, enabled = true, priority = 4, description = "Verify able to add a team-member successfully.")
	public void Building_Team_Add_Member() {

		log.info("Building_Team_Add_Member method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		System.out.println(data.getCellData("Reboot", 0, 2));
		BuildingPage = ProjectPage.SearchAndClickOnProject(data.getCellData("Reboot", 0, 2));
		BuildingPage.ClickonTeamInManage();
		HomePage.closeProjectSearchTextBox();
		String username = data.getCellData("Reboot", 15, 2);
		boolean emailexist = CommonMethod.Team_checkEmailExistOrNot(username);
		System.out.println(username + "-----------existence is----" + emailexist);
		boolean flag = false;
		flag = CommonMethod.Team_Add_Member(username);
		if(flag)
		{
			log.info(username+"  added successfully");
			boolean UserNamePresent = CommonMethod.Team_checkEmailExistOrNot(username);
			if(UserNamePresent)
			{
				log.info(username+ "  exists in the team member");
				log.info("Building_Team_Add_Member method completed .......................");
				Assert.assertTrue(true);
			}
			else
			{
				log.info(username+ "  does not exist in the team member");
				log.info("Building_Team_Add_Member method completed .......................");
				Assert.assertTrue(false);
			}
		}
		else
		{
			log.info(username+"  is not added successfully");
			log.info("Building_Team_Add_Member method completed .......................");
			Assert.assertTrue(false);
		}
		

	}

	// Verify Manage-->It should allow to delete member from the added list

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, dependsOnMethods = "Building_Team_Add_Member", enabled = true, priority = 4, description = "Verify able to delete  team-member successfully.")
	public void Building_Team_Delete_Member() {

		log.info("Building_Team_Delete_Member method started .......................");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		System.out.println(data.getCellData("Reboot", 0, 2));
		BuildingPage = ProjectPage.SearchAndClickOnProject(data.getCellData("Reboot", 0, 2));
		BuildingPage.ClickonTeamInManage();
		HomePage.closeProjectSearchTextBox();
		System.out.println();
		String username = data.getCellData("Reboot", 15, 2);
			boolean flag = CommonMethod.Team_Delete_Member(username);
			if (flag) {
				boolean emailexist = CommonMethod.Team_checkEmailExistOrNot(username);
				if(!emailexist)
				{
					log.info(username+"  does not exist as team member");
					log.info("Building_Team_Delete_Member method completed.......................");
					Assert.assertTrue(true);
				}
				else
				{
					log.info(username+" still exist as team member");
					log.info("Building_Team_Delete_Member method completed.......................");
					Assert.assertTrue(false);
				}
			} 
			else {
				log.info(username+" is not deleted successfully .......................");
				Assert.assertTrue(false);
			
		}

	}
}