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

	@Test(dependsOnGroups = "LoginMethodTCGroup", enabled = true, priority = 8)
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

	@Test(dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Agreement_Display", enabled = true, priority = 8)
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
	
	@Test(dependsOnGroups = "LoginMethodTCGroup",enabled = true, priority = 8)
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
}
