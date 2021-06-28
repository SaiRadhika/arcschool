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

public class SchoolPageTest extends BaseClass {

	/*
	 * LoginPageObjects LoginPage; HomePageObjects HomePage; ProjectPageObjects
	 * ProjectPage; BuildingPageObject BuildingPage; SchoolPageObject SchoolPage;
	 */

	private static Logger log = LoggerHelper.getLogger(SchoolPageTest.class);

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
	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = { "Reboot" }, enabled = true, priority = 5, description = "Verify Manage-->Agreements should show the project agreement.")
	public void School_Agreement_Display() {

		log.info("School_Agreement_Display method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		SchoolPage = new SchoolPageObject();
		SchoolPage = ProjectPage.SearchAndClickOnSchoolProject(data.getCellData("Reboot", 1, 2));
		SchoolPage.ClickonAgreementInManage();
		HomePage.closeProjectSearchTextBox();
		boolean flag = CommonMethod.CheckAgreementDisplay();
		// boolean flag = SchoolPage.CheckAgreementDisplay();
		if (flag) {
			log.info("School_Agreement_Display method completed ");
			Assert.assertTrue(true);
		} else {
			log.info("School_Agreement_Display method completed ");
			Assert.assertTrue(false);
		}

	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "School_Agreement_Display", groups = {
			"Reboot" }, enabled = true, priority = 5, description = "Verify able to download the agreement successfully.")
	public void School_Agreement_Download() {

		log.info("School_Agreement_Download method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		SchoolPage = new SchoolPageObject();
		SchoolPage = ProjectPage.SearchAndClickOnSchoolProject(data.getCellData("Reboot", 1, 2));
		SchoolPage.ClickonAgreementInManage();
		HomePage.closeProjectSearchTextBox();
		CommonMethod.ClikOnAgreementRegistrationDownloadLink();
		// SchoolPage.ClikOnAgreementRegistrationDownloadLink();
		long FileLength = CommonMethod.CheckDownloadedFile();
		if (FileLength > 0) {
			for (File file : DownloadFolder.listFiles()) {
				file.delete();
			}
			DownloadFolder.delete();
			log.info("School_Agreement_Download method completed ");
			Assert.assertTrue(FileLength > 0);
		} else {
			log.info("School_Agreement_Download method completed ");
			Assert.assertTrue(false);
		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = { "Reboot" }, enabled = true, priority = 5, description = "Verify if performance certificates is purchased, able to download the invoice and receipt successfully from Manage-->Billing tab.")
	public void School_PerformanceCertificate_Download_Invoice_Receipt() {

		log.info("School_PerformanceCertificate_Download_Invoice_Receipt method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		SchoolPage = new SchoolPageObject();
		System.out.println(data.getCellData("Reboot", 4, 2));
		SchoolPage = ProjectPage.SearchAndClickOnSchoolProject(data.getCellData("Reboot", 4, 2));
		// BuildingPage=ProjectPage.clickOnFirstProject();
		SchoolPage.ClickonBillingInManage();
		HomePage.closeProjectSearchTextBox();

		CommonMethod.ClikOnBillingDownloadForSubScriptionLink();
		// SchoolPage.ClikOnBillingDownloadForSubScriptionLink();
		boolean FileLength = CommonMethod.CheckDownloadedForTwoFile();
		if (FileLength == true) {
			for (File file : DownloadFolder.listFiles()) {
				file.delete();
			}
			DownloadFolder.delete();
			log.info("School_PerformanceCertificate_Download_Invoice_Receipt method completed ");
			Assert.assertTrue(FileLength);
		} else {
			for (File file : DownloadFolder.listFiles()) {
				file.delete();
			}
			DownloadFolder.delete();
			log.info("School_PerformanceCertificate_Download_Invoice_Receipt method completed ");
			Assert.assertTrue(false);
		}

	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = { "Reboot" }, enabled = true, priority = 5, description = "Verify if leed id project, able to download the registration invoice and receipt successfully from Manage-->Billing tab.")
	public void School_LEEDProject_DownloadInvoice() {

		log.info("School_LEEDProject_DownloadInvoice method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		SchoolPage = new SchoolPageObject();
		System.out.println(data.getCellData("Reboot", 5, 2));
		SchoolPage = ProjectPage.SearchAndClickOnSchoolProject(data.getCellData("Reboot", 5, 2));
		// BuildingPage=ProjectPage.clickOnFirstProject();
		SchoolPage.ClickonBillingInManage();
		HomePage.closeProjectSearchTextBox();

		CommonMethod.ClikOnBillingDownloadForRegistrationLink();
		// SchoolPage.ClikOnBillingDownloadForRegistrationLink();
		long FileLength = CommonMethod.CheckDownloadedFile();
		if (FileLength > 0) {
			for (File file : DownloadFolder.listFiles()) {
				file.delete();
			}
			DownloadFolder.delete();
			log.info("School_LEEDProject_DownloadInvoice method completed ");
			Assert.assertTrue(FileLength > 0);
		} else {
			for (File file : DownloadFolder.listFiles()) {
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

	// Verify Manage-->Teams should show team members added to the project.

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = { "Reboot" }, enabled = true, priority = 5, description = "Verify able to add a team-member successfully.")
	public void School_Team_Add_Member() {

		log.info("School_Team_Add_Member method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		System.out.println(data.getCellData("Reboot", 0, 2));
		SchoolPage = ProjectPage.SearchAndClickOnSchoolProject(data.getCellData("Reboot", 1, 2));
		SchoolPage.ClickonTeamInManage();
		HomePage.closeProjectSearchTextBox();
		System.out.println();
		String username = data.getCellData("Reboot", 15, 2);
		boolean emailexist = CommonMethod.Team_checkEmailExistOrNot(username);
		System.out.println(username + "-----------existence is----" + emailexist);
		boolean flag = false;
		flag = CommonMethod.Team_Add_Member(username);
		if (flag) {
			log.info(username + "  added successfully");
			boolean UserNamePresent = CommonMethod.Team_checkEmailExistOrNot(username);
			if (UserNamePresent) {
				log.info(username + "  exists in the team member");
				log.info("School_Team_Add_Member method completed .......................");
				Assert.assertTrue(true);
			} else {
				log.info(username + "  does not exist in the team member");
				log.info("School_Team_Add_Member method completed .......................");
				Assert.assertTrue(false);
			}
		} else {
			log.info(username + "  is not added successfully");
			log.info("School_Team_Add_Member method completed .......................");
			Assert.assertTrue(false);
		}

	}

	// Verify Manage-->It should allow to delete member from the added list

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, dependsOnMethods = "School_Team_Add_Member", enabled = true, priority = 5, description = "Verify able to remove a team-member successfully.")
	public void School_Team_Delete_Member() {

		log.info("School_Team_Delete_Member method started .......................");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		System.out.println(data.getCellData("Reboot", 1, 2));
		SchoolPage = ProjectPage.SearchAndClickOnSchoolProject(data.getCellData("Reboot", 1, 2));
		SchoolPage.ClickonTeamInManage();
		HomePage.closeProjectSearchTextBox();
		System.out.println();
		String username = data.getCellData("Reboot", 15, 2);
		boolean flag = CommonMethod.Team_Delete_Member(username);
		if (flag) {
			boolean emailexist = CommonMethod.Team_checkEmailExistOrNot(username);
			if (!emailexist) {
				log.info(username + "  does not exist as team member");
				log.info("School_Team_Delete_Member method completed.......................");
				Assert.assertTrue(true);
			} else {
				log.info(username + " still exist as team member");
				log.info("School_Team_Delete_Member method completed.......................");
				Assert.assertTrue(false);
			}
		} else {
			log.info(username + " is not deleted successfully .......................");
			Assert.assertTrue(false);

		}

	}
}
