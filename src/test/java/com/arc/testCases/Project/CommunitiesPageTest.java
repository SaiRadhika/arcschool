package com.arc.testCases.Project;

import java.io.File;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class CommunitiesPageTest extends BaseClass{

	private static Logger log = LoggerHelper.getLogger(CommunitiesPageTest.class);

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups={"Reboot"}, enabled = true, priority = 8, description = "Verify Manage-->Agreements should show the project agreement.")
	public void Communities_Agreement_Display() {
		log.info("Communities_Agreement_Display method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(data.getCellData("Reboot", 10, 2));
		CommunitiesPage.ClickonAgreementInManage();
		HomePage.closeProjectSearchTextBox();
		boolean flag = CommonMethod.CheckAgreementDisplay();

		if (flag) {
			log.info("Communities_Agreement_Display method completed ");
			Assert.assertTrue(true);
		} else {
			log.info("Communities_Agreement_Display method completed ");
			Assert.assertTrue(false);
		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Agreement_Display", groups={"Reboot"}, enabled = true, priority = 8, description = "Verify able to download the agreement successfully.")
	public void Communities_Agreement_Download() {
		log.info("Communities_Agreement_Download method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		// BuildingPage=ProjectPage.clickOnFirstProject();
		// System.out.println(data.getCellData("Reboot", 0, 2));
		CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(data.getCellData("Reboot", 10, 2));
		CommunitiesPage.ClickonAgreementInManage();
		HomePage.closeProjectSearchTextBox();
		CommonMethod.ClikOnAgreementRegistrationDownloadLink();
		// BuildingPage.ClikOnAgreementDownloadLink();
		long FileLength = CommonMethod.CheckDownloadedFile();
		if (FileLength > 0) {
			for (File file : DownloadFolder.listFiles()) {
				file.delete();
			}
			DownloadFolder.delete();
			log.info("Communities_Agreement_Download method completed ");
			Assert.assertTrue(FileLength > 0);
		} else {
			log.info("Communities_Agreement_Download method completed ");
			Assert.assertTrue(false);
		}

	}
	
	@Test(dependsOnGroups = "LoginMethodTCGroup",groups={"Reboot"}, enabled = true, priority = 8, description = "Verify if leed id project, able to download the registration invoice and receipt successfully from Manage-->Billing tab.")
	public void Community_LEEDIDProject_Download_Invoice() {
		
			log.info("Community_LEEDIDProject_Download_Invoice method started ");
			HomePage.setHomePageApplication();
			ProjectPage = HomePage.clickOnProject();
			System.out.println(data.getCellData("Reboot", 11, 2));
			CommunitiesPage=ProjectPage.SearchAndClickOnCommunitiesProject(data.getCellData("Reboot", 11, 2));
			CommunitiesPage.ClickonBillingInManage();
			HomePage.closeProjectSearchTextBox();
			CommonMethod.ClikOnBillingDownloadForRegistrationLink();
			long FileLength = CommonMethod.CheckDownloadedFile();
			if(FileLength>0)
			{
				for(File file:DownloadFolder.listFiles())
				{
					file.delete();
				}
				DownloadFolder.delete();
				log.info("Community_LEEDIDProject_Download_Invoice method completed ");
				Assert.assertTrue(FileLength>0);
			}
			else 
			{
				for(File file:DownloadFolder.listFiles())
				{
					file.delete();
				}
				DownloadFolder.delete();
				log.info("Community_LEEDIDProject_Download_Invoice method completed ");
				Assert.assertTrue(false);
			}
	}
	
	// Verify Manage-->Teams should show team members added to the project.

		@Test(dependsOnGroups = "LoginMethodTCGroup", groups = { "Reboot" }, enabled = true, priority = 8, description = "Verify able to add a team-member successfully.")
		public void Community_Team_Add_Member() {

			log.info("Community_Team_Add_Member method started ");
			HomePage.setHomePageApplication();
			ProjectPage = HomePage.clickOnProject();
			System.out.println(data.getCellData("Reboot", 11, 2));
			CommunitiesPage=ProjectPage.SearchAndClickOnCommunitiesProject(data.getCellData("Reboot", 11, 2));
			CommunitiesPage.ClickonTeamInManage();
			HomePage.closeProjectSearchTextBox();
			System.out.println();
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
					log.info("Community_Team_Add_Member method completed .......................");
					Assert.assertTrue(true);
				}
				else
				{
					log.info(username+ "  does not exist in the team member");
					log.info("Community_Team_Add_Member method completed .......................");
					Assert.assertTrue(false);
				}
			}
			else
			{
				log.info(username+"  is not added successfully");
				log.info("Community_Team_Add_Member method completed .......................");
				Assert.assertTrue(false);
			}
			

		}

		// Verify Manage-->It should allow to delete member from the added list

		@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
				"Reboot" }, dependsOnMethods = "Community_Team_Add_Member", enabled = true, priority = 8, description = "Verify able to remove a team-member successfully.")
		public void Community_Team_Delete_Member() {

			log.info("Community_Team_Delete_Member method started .......................");
			HomePage.setHomePageApplication();
			ProjectPage = HomePage.clickOnProject();
			System.out.println(data.getCellData("Reboot", 11, 2));
			CommunitiesPage=ProjectPage.SearchAndClickOnCommunitiesProject(data.getCellData("Reboot", 11, 2));
			CommunitiesPage.ClickonTeamInManage();
			HomePage.closeProjectSearchTextBox();
			System.out.println();
			String username = data.getCellData("Reboot", 15, 2);
				boolean flag = CommonMethod.Team_Delete_Member(username);
				if (flag) {
					boolean emailexist = CommonMethod.Team_checkEmailExistOrNot(username);
					if(!emailexist)
					{
						log.info(username+"  does not exist as team member");
						log.info("Community_Team_Delete_Member method completed.......................");
						Assert.assertTrue(true);
					}
					else
					{
						log.info(username+" still exist as team member");
						log.info("Community_Team_Delete_Member method completed.......................");
						Assert.assertTrue(false);
					}
				} 
				else {
					log.info(username+" is not deleted successfully .......................");
					Assert.assertTrue(false);
				
			}

		}
}
