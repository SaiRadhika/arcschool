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

	@Test(dependsOnGroups = "LoginMethodTCGroup", enabled = true, priority = 7)
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

	@Test(dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Transit_Agreement_Display", enabled = true, priority = 7)
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

	@Test(dependsOnGroups = "LoginMethodTCGroup", enabled = true, priority = 7)
	public void Transit_Credits_Download_Upload_Document() {
		log.info("Transit_Credits_Download_Upload_Document method started ");
		String DownloadedFilePath = "";
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		TransitPage = ProjectPage.SearchAndClickOnTransitProject(data.getCellData("Reboot", 8, 2));
		TransitPage.AllActionSubMenu();
		HomePage.closeProjectSearchTextBox();
		
		TransitPage.ClickonActionName("Site Development - Protect or Restore Habitat");
		TransitPage.ClickonDownLoadButton();

		long FileLength = CommonMethod.CheckDownloadedFile();
		if (FileLength > 0) {
			for (File file : DownloadFolder.listFiles()) {
				System.out.println(file.getPath());
				System.out.println(System.getProperty("user.dir") + "\\" + file.getPath());
				DownloadedFilePath = System.getProperty("user.dir") + "\\" + file.getPath();
				TransitPage.ClickonUpLoadButton();
				CommonMethod.UploadFile(DownloadedFilePath);
				boolean flag = TransitPage.uploadStatus();
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
	
	@Test(dependsOnGroups = "LoginMethodTCGroup",enabled = true, priority = 7)
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

}
