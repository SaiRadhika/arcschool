package com.arc.testCases.Project;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class TransitPageTest extends BaseClass {

	private static Logger log = LoggerHelper.getLogger(TransitPageTest.class);

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, enabled = true, priority = 23, description = "Verify Manage-->Agreements should show the project agreement.")
	public void Transit_Agreement_Display() {
		log.info("Transit_Agreement_Display method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		// BuildingPage=ProjectPage.clickOnFirstProject();
		// System.out.println(data.getCellData("Reboot", 6, 2));
		TransitPage = ProjectPage.SearchAndClickOnTransitProject(data.getCellData("Reboot", 8, 2));
		TransitPage.ClickonAgreementInManage();
		HomePage.closeProjectSearchTextBox();
		boolean flag = CommonMethod.CheckAgreementDisplay();

		if (flag) {
			log.info("Transit_Agreement_Display method completed ");
			Assert.assertTrue(true);
		} else {
			log.info("Transit_Agreement_Display method completed ");
			Assert.assertTrue(false);
		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Transit_Agreement_Display", groups = {
			"Reboot" }, enabled = true, priority = 24, description = "Verify able to download the agreement successfully.")
	public void Transit_Agreement_Download() {
		log.info("Transit_Agreement_Download method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		// BuildingPage=ProjectPage.clickOnFirstProject();
		// System.out.println(data.getCellData("Reboot", 0, 2));
		TransitPage = ProjectPage.SearchAndClickOnTransitProject(data.getCellData("Reboot", 8, 2));
		TransitPage.ClickonAgreementInManage();
		HomePage.closeProjectSearchTextBox();
		CommonMethod.ClikOnAgreementRegistrationDownloadLink();
		// BuildingPage.ClikOnAgreementDownloadLink();
		long FileLength = CommonMethod.CheckDownloadedFile();
		if (FileLength > 0) {
			CommonMethod.DeleteAllFiles();
			DownloadFolder.delete();
			log.info("Transit_Agreement_Download method completed ");
			Assert.assertTrue(FileLength > 0);
		} else {
			log.info("Transit_Agreement_Download method completed ");
			Assert.assertTrue(false);
		}

	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", enabled = true, groups = {
			"Reboot" }, priority = 25, description = "Verify able to download and upload credit form file successfully under any credit.")
	public void Transit_CreditForm_Download_Upload_Document() {
		log.info("Transit_Credits_Download_Upload_Document method started ");
		String DownloadedFilePath = "";
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		TransitPage = ProjectPage.SearchAndClickOnTransitProject(data.getCellData("Reboot", 8, 2));
		TransitPage.AllActionSubMenu();
		HomePage.closeProjectSearchTextBox();
		TransitPage.ClickonActionName("Site Development - Protect or Restore Habitat");
		TransitPage.ClickonCreditFormDownLoadButton();
		boolean downloadFlag = false;
		long FileLength = CommonMethod.CheckDownloadedFile();
		if (FileLength > 0) {
			downloadFlag = true;
			log.info("Credit form Downloaded successfully..............");
			for (File file : DownloadFolder.listFiles()) {
				log.info(file.getPath());
				log.info(System.getProperty("user.dir") + "/" + file.getPath());
				DownloadedFilePath = System.getProperty("user.dir") + "/" + file.getPath();
				log.info("Path to upload credit form is .. " + DownloadedFilePath);

				boolean uploadflag = TransitPage.CheckCreditFormupload(DownloadedFilePath);
				if (uploadflag) {
					log.info("Credit form uploaded successfully..............");

				} else {
					log.info("Credit form is not uploaded successfully..............");
				}

				CommonMethod.DeleteAllFiles();
				DownloadFolder.delete();

				if (downloadFlag == true && uploadflag == true) {
					log.info("Transit_Credits_Download_Upload_Document method completed ");
					Assert.assertTrue(true);
				}

				else {
					log.info("Transit_Credits_Download_Upload_Document method completed ");
					Assert.assertTrue(false);
				}

			}

			// TransitPage.ClickonUpLoadButton(DownloadedFilePath);

		} else {
			log.info("Credit Form is not downloaded successfully.....");
			log.info("Transit_Credits_Download_Upload_Document method completed ");
			Assert.assertTrue(false);
		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, enabled = true, priority = 26, description = "Verify able to upload and Remove file with option Upload Using Computer")
	public void Transit_File_Upload_Remove() {
		log.info("Transit_File_Upload_Remove method started ");
		String DownloadedFilePath = "";
		boolean deletedflag = false;
		boolean uploadflag=false;
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		TransitPage = ProjectPage.SearchAndClickOnTransitProject(data.getCellData("Reboot", 8, 2));
		TransitPage.AllActionSubMenu();
		HomePage.closeProjectSearchTextBox();
		TransitPage.ClickonActionName("Site Development - Protect or Restore Habitat");
		// TransitPage.ClickonFileUpLoadUsingComputerButton();
		String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";
		File f = new File(UploadPath);
		boolean FileExisted = TransitPage.CheckFileUploadedStatus(f.getName());		
		if (FileExisted == false) {
			uploadflag = TransitPage.CheckFileUploadUsingComputer(UploadPath);
			if (uploadflag) {
				log.info("File upload using Computer completed successfully..............");
				deletedflag = TransitPage.ClickonFileDeleButton(f.getName());
				if (deletedflag) {
					log.info("File deleted successfully...... ");
				} else {
					log.info("Unable to delete File...... ");
				}
			}
			else
			{
				log.info("Unable to upload file File using Computer ..............");
				uploadflag=false;				
			}

		} else {
			log.info("File is already uloaded, Firstly deleteing the File and then perform the Test Cases...");
			CommonMethod.RefreshPagewaitForPageLoaded(driver);
			deletedflag = TransitPage.ClickonFileDeleButton(f.getName());
			if (deletedflag) {
				log.info("File deleted successfully...... ");
			} else {
				log.info("Unable to delete File...... ");
			}
			uploadflag = TransitPage.CheckFileUploadUsingComputer(UploadPath);
			if (uploadflag) {
				log.info("File upload using Computer completed successfully..............");
				deletedflag = TransitPage.ClickonFileDeleButton(f.getName());
				if (deletedflag) {
					log.info("File deleted successfully...... ");
				} else {
					log.info("Unable to delete File...... ");
				}
			}
			
		}

		if (uploadflag == true && deletedflag == true) {
			log.info("Transit_File_Upload_Remove method completed ");
			Assert.assertTrue(true);
		}

		else {
			log.info("Transit_File_Upload_Remove method completed ");
			Assert.assertTrue(false);
		}

	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, enabled = true, priority = 27, description = "Verify if leed id project, able to download the registration invoice and receipt successfully from Manage-->Billing tab.")
	public void Transit_LEEDIDProject_Download_Invoice() {

		log.info("Transit_LEEDIDProject_Download_Invoice method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		System.out.println(data.getCellData("Reboot", 9, 2));
		TransitPage = ProjectPage.SearchAndClickOnTransitProject(data.getCellData("Reboot", 9, 2));
		TransitPage.ClickonBillingInManage();
		HomePage.closeProjectSearchTextBox();
		CommonMethod.ClikOnBillingDownloadForRegistrationLink();
		long FileLength = CommonMethod.CheckDownloadedFile();
		if (FileLength > 0) {
			for (File file : DownloadFolder.listFiles()) {
				file.delete();
			}
			DownloadFolder.delete();
			log.info("Transit_LEEDIDProject_Download_Invoice method completed ");
			Assert.assertTrue(FileLength > 0);
		} else {
			for (File file : DownloadFolder.listFiles()) {
				file.delete();
			}
			DownloadFolder.delete();
			log.info("Transit_LEEDIDProject_Download_Invoice method completed ");
			Assert.assertTrue(false);
		}
	}

	// Verify Manage-->Teams should show team members added to the project.

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, enabled = true, priority = 28, description = "Verify able to add a team-member successfully.")
	public void Transit_Team_Add_Member() {

		log.info("Transit_Team_Add_Member method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		log.info(data.getCellData("Reboot", 9, 2));
		TransitPage = ProjectPage.SearchAndClickOnTransitProject(data.getCellData("Reboot", 9, 2));
		TransitPage.ClickonTeamInManage();
		HomePage.closeProjectSearchTextBox();
		String username = data.getCellData("Reboot", 15, 2);
		boolean emailexist = CommonMethod.Team_checkEmailExistOrNot(username);
		log.info(username + "-----------existence is----" + emailexist);
		if (emailexist == false) {
			CommonMethod.Team_Add_Member(username);
			boolean UserNamePresent = CommonMethod.Team_checkEmailExistOrNot(username);
			if (UserNamePresent) {
				log.info(username + "  exists in the team member");
				log.info("Transit_Team_Add_Member method completed .......................");
				Assert.assertTrue(true);
			} else {
				log.info(username + "  does not exist in the team member");
				log.info("Transit_Team_Add_Member method completed .......................");
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
			"Reboot" }, dependsOnMethods = "Transit_Team_Add_Member", enabled = true, priority = 29, description = "Verify able to remove a team-member successfully.")
	public void Transit_Team_Delete_Member() {

		log.info("Transit_Team_Delete_Member method started .......................");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		log.info(data.getCellData("Reboot", 9, 2));
		TransitPage = ProjectPage.SearchAndClickOnTransitProject(data.getCellData("Reboot", 9, 2));
		HomePage.closeProjectSearchTextBox();
		TransitPage.ClickonTeamInManage();
		String username = data.getCellData("Reboot", 15, 2);
		CommonMethod.Team_Delete_Member(username);
		boolean emailexist = CommonMethod.Team_checkEmailExistOrNot(username);
		if (!emailexist) {
			log.info(username + "  does not exist as team member");
			log.info("Transit_Team_Delete_Member method completed.......................");
			Assert.assertTrue(true);
		} else {
			log.info(username + " still exist as team member");
			log.info("Transit_Team_Delete_Member method completed.......................");
			Assert.assertTrue(false);
		}

	}

}
