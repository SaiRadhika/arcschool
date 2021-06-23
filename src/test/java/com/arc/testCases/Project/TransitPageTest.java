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

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups={"Reboot"}, enabled = true, priority = 7)
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

	@Test(dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Transit_Agreement_Display", groups={"Reboot"}, enabled = true, priority = 7)
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
			for (File file : DownloadFolder.listFiles()) {
				file.delete();
			}
			DownloadFolder.delete();
			log.info("Transit_Agreement_Download method completed ");
			Assert.assertTrue(FileLength > 0);
		} else {
			log.info("Transit_Agreement_Download method completed ");
			Assert.assertTrue(false);
		}

	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", enabled = false,  groups={"Reboot"},priority = 7)
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

		long FileLength = CommonMethod.CheckDownloadedFile();
		if (FileLength > 0) {
			for (File file : DownloadFolder.listFiles()) {
				System.out.println(file.getPath());
				System.out.println(System.getProperty("user.dir") + "\\" + file.getPath());
				DownloadedFilePath = System.getProperty("user.dir") + "\\" + file.getPath();
				TransitPage.ClickonCreditFormUpLoadButton();
				
				System.out.println("Path to upload credit form is .. "+DownloadedFilePath);
				CommonMethod.UploadFile(DownloadedFilePath);
				boolean flag = TransitPage.CreditFormuploadStatus();
				if (flag) {
					
					log.info("Transit_Credits_Download_Upload_Document method completed ");
					Assert.assertTrue(flag);
				}

				else {
					log.info("Transit_Credits_Download_Upload_Document method completed ");
					Assert.assertTrue(false);
				}
				
				for (File file1 : DownloadFolder.listFiles()) {

					file1.delete();
				}
				DownloadFolder.delete();

			}
			
			// TransitPage.ClickonUpLoadButton(DownloadedFilePath);
			
		}
		else {
			log.info("Transit_Credits_Download_Upload_Document method completed ");
			Assert.assertTrue(false);
		}
	}
	
	
	@Test(dependsOnGroups = "LoginMethodTCGroup", groups={"Reboot"},enabled = false, priority = 7)
	public void Transit_File_Upload_Remove() {
		log.info("Transit_File_Upload_Remove method started ");
		String DownloadedFilePath = "";
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		TransitPage = ProjectPage.SearchAndClickOnTransitProject(data.getCellData("Reboot", 8, 2));
		TransitPage.AllActionSubMenu();
		HomePage.closeProjectSearchTextBox();
		
		TransitPage.ClickonActionName("Site Development - Protect or Restore Habitat");
		TransitPage.ClickonFileUpLoadUsingComputerButton();
		String UploadPath=System.getProperty("user.dir")+"\\"+"UploadDocument";
		System.out.println("Path to upload File upload is .. "+UploadPath);
		File upload=new File(UploadPath);
		for(File f: upload.listFiles())
		{
			String filepath=f.getPath();
			System.out.println(filepath);
			
			CommonMethod.UploadFile(filepath);
			boolean flag = TransitPage.FileuploadStatus();
			System.out.println("Flag is....................."+flag);
			boolean deleted=false;
			if (flag) {
				
				deleted=TransitPage.ClickonFileDeleButton(f.getName());
				System.out.println("deleted is....................."+deleted);
				if(deleted)
				{				
				log.info("Transit_File_Upload_Remove method ends...... ");
				Assert.assertTrue(true);
				}
				else
				{
					log.info("Transit_File_Upload_Remove method ends...... ");
					Assert.assertTrue(false);
				}
			}

			else {
				
				Assert.assertTrue(false);
			}
		}
		
	}
	
	@Test(dependsOnGroups = "LoginMethodTCGroup", groups={"Reboot"},enabled = true, priority = 7)
	public void Transit_LEEDIDProject_Download_Invoice() {
		
			log.info("Transit_LEEDIDProject_Download_Invoice method started ");
			HomePage.setHomePageApplication();
			ProjectPage = HomePage.clickOnProject();
			System.out.println(data.getCellData("Reboot", 9, 2));
			TransitPage=ProjectPage.SearchAndClickOnTransitProject(data.getCellData("Reboot", 9, 2));
			TransitPage.ClickonBillingInManage();
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
				log.info("Transit_LEEDIDProject_Download_Invoice method completed ");
				Assert.assertTrue(FileLength>0);
			}
			else 
			{
				for(File file:DownloadFolder.listFiles())
				{
					file.delete();
				}
				DownloadFolder.delete();
				log.info("Transit_LEEDIDProject_Download_Invoice method completed ");
				Assert.assertTrue(false);
			}
	}
	
	
	// Verify Manage-->Teams should show team members added to the project.

		@Test(dependsOnGroups = "LoginMethodTCGroup", groups = { "Reboot" }, enabled = true, priority = 7)
		public void Transit_Team_Add_Member() {

			log.info("Transit_Team_Add_Member method started ");
			HomePage.setHomePageApplication();
			ProjectPage = HomePage.clickOnProject();
			System.out.println(data.getCellData("Reboot", 9, 2));
			TransitPage=ProjectPage.SearchAndClickOnTransitProject(data.getCellData("Reboot", 9, 2));
			TransitPage.ClickonTeamInManage();
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
					log.info("Transit_Team_Add_Member method completed .......................");
					Assert.assertTrue(true);
				}
				else
				{
					log.info(username+ "  does not exist in the team member");
					log.info("Transit_Team_Add_Member method completed .......................");
					Assert.assertTrue(false);
				}
			}
			else
			{
				log.info(username+"  is not added successfully");
				log.info("Transit_Team_Add_Member method completed .......................");
				Assert.assertTrue(false);
			}
			

		}

		// Verify Manage-->It should allow to delete member from the added list

		@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
				"Reboot" }, dependsOnMethods = "Transit_Team_Add_Member", enabled = true, priority = 7)
		public void Transit_Team_Delete_Member() {

			log.info("Transit_Team_Delete_Member method started .......................");
			HomePage.setHomePageApplication();
			ProjectPage = HomePage.clickOnProject();
			System.out.println(data.getCellData("Reboot", 9, 2));
			TransitPage=ProjectPage.SearchAndClickOnTransitProject(data.getCellData("Reboot", 9, 2));
			TransitPage.ClickonTeamInManage();
			HomePage.closeProjectSearchTextBox();
			System.out.println();
			String username = data.getCellData("Reboot", 15, 2);
				boolean flag = CommonMethod.Team_Delete_Member(username);
				if (flag) {
					boolean emailexist = CommonMethod.Team_checkEmailExistOrNot(username);
					if(!emailexist)
					{
						log.info(username+"  does not exist as team member");
						log.info("Transit_Team_Delete_Member method completed.......................");
						Assert.assertTrue(true);
					}
					else
					{
						log.info(username+" still exist as team member");
						log.info("Transit_Team_Delete_Member method completed.......................");
						Assert.assertTrue(false);
					}
				} 
				else {
					log.info(username+" is not deleted successfully .......................");
					Assert.assertTrue(false);
				
			}

		}

}
