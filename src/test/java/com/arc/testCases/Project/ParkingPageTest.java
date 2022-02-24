package com.arc.testCases.Project;

import java.io.File;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class ParkingPageTest extends BaseClass {

	private static Logger log = LoggerHelper.getLogger(ParkingPageTest.class);

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, enabled = true, priority = 35, description = "Verify Manage-->Agreements should show the project agreement.")
	public void Parking_Agreement_Display() {
		log.info("Parking_Agreement_Display method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		// BuildingPage=ProjectPage.clickOnFirstProject();
		// System.out.println(data.getCellData("Reboot", 6, 2));
		ParkingPage = ProjectPage.SearchAndClickOnParkingProject(data.getCellData("Reboot", 12, 2));
		HomePage.closeProjectSearchTextBox();
		ParkingPage.ClickonAgreementInManage();
		boolean flag = CommonMethod.CheckAgreementDisplay();

		if (flag) {
			log.info("Parking_Agreement_Display method completed ");
			Assert.assertTrue(true);
		} else {
			log.info("Parking_Agreement_Display method completed ");
			Assert.assertTrue(false);
		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Parking_Agreement_Display", groups = {
			"Reboot" }, enabled = true, priority = 36, description = "Verify able to download the agreement successfully.")
	public void Parking_Agreement_Download() {
		log.info("Parking_Agreement_Download method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		ParkingPage = ProjectPage.SearchAndClickOnParkingProject(data.getCellData("Reboot", 12, 2));
		HomePage.closeProjectSearchTextBox();
		ParkingPage.ClickonAgreementInManage();
		CommonMethod.ClikOnAgreementRegistrationDownloadLink();
		long FileLength = CommonMethod.CheckDownloadedFile();
		if (FileLength > 0) {
			CommonMethod.DeleteAllFiles();
			DownloadFolder.delete();
			log.info("Parking_Agreement_Download method completed ");
			Assert.assertTrue(FileLength > 0);
		} else {
			log.info("Parking_Agreement_Download method completed ");
			Assert.assertTrue(false);
		}

	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, enabled = true, priority = 37, description = "Verify if leed id project, able to download the registration invoice and receipt successfully from Manage-->Billing tab.")
	public void Parking_LEEDID_Project_Download_Invoice() {

		log.info("Parking_LEEDID_Project_Download_Invoice method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		log.info(data.getCellData("Reboot", 8, 2));
		ParkingPage = ProjectPage.SearchAndClickOnParkingProject(data.getCellData("Reboot", 13, 2));
		HomePage.closeProjectSearchTextBox();
		ParkingPage.ClickonBillingInManage();
		CommonMethod.ClikOnBillingDownloadForRegistrationLink();
		long FileLength = CommonMethod.CheckDownloadedFile();
		if (FileLength > 0) {
			for (File file : DownloadFolder.listFiles()) {
				file.delete();
			}
			DownloadFolder.delete();
			log.info("Parking_LEEDID_Project_Download_Invoice method completed ");
			Assert.assertTrue(FileLength > 0);
		} else {
			log.info("Parking_LEEDID_Project_Download_Invoice method completed ");
			Assert.assertTrue(false);
		}
	}

	// Verify Manage-->Teams should show team members added to the project.

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, enabled = true, priority = 38, description = "Verify able to add a team-member successfully.")
	public void Parking_Team_Add_Member() {

		log.info("Parking_Team_Add_Member method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		log.info(data.getCellData("Reboot", 13, 2));
		ParkingPage = ProjectPage.SearchAndClickOnParkingProject(data.getCellData("Reboot", 13, 2));
		HomePage.closeProjectSearchTextBox();
		ParkingPage.ClickonTeamInManage();
		String username = data.getCellData("Reboot", 15, 2);
		boolean emailexist = CommonMethod.Team_checkEmailExistOrNot(username);
		log.info(username + "-----------existence is----" + emailexist);
		if (emailexist == false) {
			CommonMethod.Team_Add_Member(username);
			boolean UserNamePresent = CommonMethod.Team_checkEmailExistOrNot(username);
			if (UserNamePresent) {
				log.info(username + "  exists in the team member");
				log.info("Parking_Team_Add_Member method completed .......................");
				Assert.assertTrue(true);
			} else {
				log.info(username + "  does not exist in the team member");
				log.info("Parking_Team_Add_Member method completed .......................");
				Assert.assertTrue(false);
			}
		} else {
			log.info("First deleting the email and then will add the same email...");
			CommonMethod.Team_Delete_Member(username);
			CommonMethod.Team_Add_Member(username);
			boolean UserNamePresent = CommonMethod.Team_checkEmailExistOrNot(username);
			if (UserNamePresent) {
				log.info(username + "  exists in the team member");
				log.info("Parking_Team_Add_Member method completed .......................");
				Assert.assertTrue(true);
			} else {
				log.info(username + "  does not exist in the team member");
				log.info("Parking_Team_Add_Member method completed .......................");
				Assert.assertTrue(false);
			}
		}
	}

	// Verify Manage-->It should allow to delete member from the added list

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, dependsOnMethods = "Parking_Team_Add_Member", enabled = true, priority = 39, description = "Verify able to remove a team-member successfully.")
	public void Parking_Team_Delete_Member() {

		log.info("Parking_Team_Delete_Member method started .......................");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		log.info(data.getCellData("Reboot", 13, 2));
		ParkingPage = ProjectPage.SearchAndClickOnParkingProject(data.getCellData("Reboot", 13, 2));
		HomePage.closeProjectSearchTextBox();
		ParkingPage.ClickonTeamInManage();
		String username = data.getCellData("Reboot", 15, 2);
		CommonMethod.Team_Delete_Member(username);
		boolean emailexist = CommonMethod.Team_checkEmailExistOrNot(username);
		if (!emailexist) {
			log.info(username + "  does not exist as team member");
			log.info("Parking_Team_Delete_Member method completed.......................");
			Assert.assertTrue(true);
		} else {
			log.info(username + " still exist as team member");
			log.info("Parking_Team_Delete_Member method completed.......................");
			Assert.assertTrue(false);
		}

	}
}