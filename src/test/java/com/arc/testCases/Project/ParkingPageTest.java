package com.arc.testCases.Project;

import java.io.File;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class ParkingPageTest extends BaseClass{
	
	private static Logger log = LoggerHelper.getLogger(ParkingPageTest.class);

	@Test(dependsOnGroups = "LoginMethodTCGroup", enabled = true, priority = 9)
	public void Parking_Agreement_Display() {
		log.info("Parking_Agreement_Display method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		// BuildingPage=ProjectPage.clickOnFirstProject();
		// System.out.println(data.getCellData("Reboot", 6, 2));
		ParkingPage = ProjectPage.SearchAndClickOnParkingProject(data.getCellData("Reboot", 11, 2));
		ParkingPage.ClickonAgreementInManage();
		HomePage.closeProjectSearchTextBox();
		boolean flag = CommonMethod.CheckAgreementDisplay();

		if (flag) {
			log.info("Parking_Agreement_Display method completed ");
			Assert.assertTrue(true);
		} else {
			log.info("Parking_Agreement_Display method completed ");
			Assert.assertTrue(false);
		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Parking_Agreement_Display", enabled = true, priority = 9)
	public void Parking_Agreement_Download() {
		log.info("Parking_Agreement_Download method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		// BuildingPage=ProjectPage.clickOnFirstProject();
		// System.out.println(data.getCellData("Reboot", 0, 2));
		ParkingPage = ProjectPage.SearchAndClickOnParkingProject(data.getCellData("Reboot", 11, 2));
		ParkingPage.ClickonAgreementInManage();
		HomePage.closeProjectSearchTextBox();
		CommonMethod.ClikOnAgreementRegistrationDownloadLink();
		// BuildingPage.ClikOnAgreementDownloadLink();
		long FileLength = CommonMethod.CheckDownloadedFile();
		if (FileLength > 0) {
			for (File file : DownloadFolder.listFiles()) {
				file.delete();
			}
			DownloadFolder.delete();
			log.info("Parking_Agreement_Download method completed ");
			Assert.assertTrue(FileLength > 0);
		} else {
			log.info("Parking_Agreement_Download method completed ");
			Assert.assertTrue(false);
		}

	}

	@Test(dependsOnGroups = "LoginMethodTCGroup",enabled = true, priority = 9)
	public void Parking_LEEDID_Project_Download_Invoice() {
		
			log.info("Parking_LEEDID_Project_Download_Invoice method started ");
			HomePage.setHomePageApplication();
			ProjectPage = HomePage.clickOnProject();
			System.out.println(data.getCellData("Reboot", 8, 2));
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(data.getCellData("Reboot", 12, 2));
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

}
