package com.arc.testCases.Project;

import java.io.File;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class BuildingPageTest extends BaseClass {

	private static Logger log = LoggerHelper.getLogger(BuildingPageTest.class);

	@Test(dependsOnGroups = "LoginMethodTCGroup", enabled = true, groups = {
			"Reboot" }, priority = 5, description = "Verify Manage-->Agreements should show the project agreement.")
	public void Building_Agreement_Display() {
		log.info("Building_Agreement_Display method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		System.out.println(data.getCellData("Reboot", "BuildingProjectID", 2));
		BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(data.getCellData("Reboot", 0, 2));
		HomePage.closeProjectSearchTextBox();
		BuildingPage.ClickonAgreementInManage();
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
			"Reboot" }, enabled = true, priority = 6, description = "Verify able to download the agreement successfully.")
	public void Building_Agreement_Download() {
		log.info("Building_Agreement_Download method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		System.out.println(data.getCellData("Reboot", 0, 2));
		BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(data.getCellData("Reboot", 0, 2));
		HomePage.closeProjectSearchTextBox();
		BuildingPage.ClickonAgreementInManage();
		CommonMethod.ClikOnAgreementRegistrationDownloadLink();
		// BuildingPage.ClikOnAgreementDownloadLink();
		long FileLength = CommonMethod.CheckDownloadedFile();
		if (FileLength > 0) {
			log.info("Size of the downloaded file is ... " + FileLength);
			CommonMethod.DeleteAllFiles();
			DownloadFolder.delete();
			log.info("Building_Agreement_Download method completed ");
			Assert.assertTrue(FileLength > 0);
		} else {
			log.info("Size of the downloaded file is ... " + FileLength);
			log.info("Building_Agreement_Download method completed ");
			Assert.assertTrue(false);
		}

	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, enabled = true, priority = 7, description = "Verify if performance certificates is purchased, able to download the invoice and receipt successfully from Manage-->Billing tab.")
	public void Building_PerformanceCertificate_Download_Invoice_Receipt() {

		log.info("Building_PerformanceCertificate_Download_Invoice_Receipt method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		System.out.println(data.getCellData("Reboot", 2, 2));
		BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(data.getCellData("Reboot", 2, 2));
		// BuildingPage=ProjectPage.clickOnFirstProject();
		HomePage.closeProjectSearchTextBox();
		BuildingPage.ClickonBillingInManage();
		CommonMethod.ClikOnBillingDownloadForSubScriptionLink();
		// BuildingPage.ClikOnBillingDownloadForSubScriptionLink();
		boolean flag = CommonMethod.CheckReceiptAndInvoiceFile();
		if (flag == true) {
			CommonMethod.DeleteAllFiles();
			DownloadFolder.delete();
			log.info("Building_PerformanceCertificate_Download_Invoice_Receipt method completed ");
			Assert.assertTrue(flag);
		} else {
			CommonMethod.DeleteAllFiles();
			DownloadFolder.delete();
			log.info("Building_PerformanceCertificate_Download_Invoice_Receipt method completed ");
			Assert.assertTrue(false);
		}

	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, enabled = true, priority = 8, description = "Verify if leed id project, able to download the registration invoice and receipt successfully from Manage-->Billing tab.")
	public void Building_LEEDIDProject_Download_Invoice() {

		log.info("Building_LEEDIDProject_Download_Invoice method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		System.out.println(data.getCellData("Reboot", 3, 2));
		BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(data.getCellData("Reboot", 3, 2));
		// BuildingPage=ProjectPage.clickOnFirstProject();
		HomePage.closeProjectSearchTextBox();
		BuildingPage.ClickonBillingInManage();
		CommonMethod.ClikOnBillingDownloadForRegistrationLink();
		// BuildingPage.ClikOnBillingDownloadForRegistrationLink();
		long FileLength = CommonMethod.CheckDownloadedFile();
		if (FileLength > 0) {
			CommonMethod.DeleteAllFiles();
			DownloadFolder.delete();
			log.info("Building_LEEDIDProject_Download_Invoice method completed ");
			Assert.assertTrue(FileLength > 0);
		} else {
			CommonMethod.DeleteAllFiles();
			DownloadFolder.delete();
			log.info("Building_LEEDIDProject_Download_Invoice method completed ");
			Assert.assertTrue(false);
		}

	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, enabled = true, priority = 9, description = "Verify if project submitted for recertification, billing--> Invoice and receipt are downloaded successfully.")
	public void Building_Recertification_Download_Invoice() {

		log.info("Building_Recertification_Download_Invoice method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		System.out.println(data.getCellData("Reboot", 14, 2));
		BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(data.getCellData("Reboot", 14, 2));
		HomePage.closeProjectSearchTextBox();
		BuildingPage.ClickonBillingInManage();
		CommonMethod.ClikOnBillingDownloadForRecertificationLink();
		// BuildingPage.ClikOnBillingDownloadForRegistrationLink();
		long FileLength = CommonMethod.CheckDownloadedFile();
		if (FileLength > 0) {
			CommonMethod.DeleteAllFiles();
			DownloadFolder.delete();
			log.info("Building_Recertification_Download_Invoice method completed ");
			Assert.assertTrue(FileLength > 0);
		} else {
			CommonMethod.DeleteAllFiles();
			DownloadFolder.delete();
			log.info("Building_Recertification_Download_Invoice method completed ");
			Assert.assertTrue(false);
		}
	}

	// Verify Manage-->Teams should show team members added to the project.

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, enabled = true, priority = 10, description = "Verify able to add a team-member successfully.")
	public void Building_Team_Add_Member() {

		log.info("Building_Team_Add_Member method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		log.info(data.getCellData("Reboot", 0, 2));
		BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(data.getCellData("Reboot", 0, 2));
		HomePage.closeProjectSearchTextBox();
		BuildingPage.ClickonTeamInManage();
		String username = data.getCellData("Reboot", 15, 2);
		boolean emailexist = CommonMethod.Team_checkEmailExistOrNot(username);
		log.info(username + "-----------existence is----" + emailexist);
		if (emailexist == false) {
			CommonMethod.Team_Add_Member(username);
			boolean UserNamePresent = CommonMethod.Team_checkEmailExistOrNot(username);
			if (UserNamePresent) {
				log.info(username + "  exists in the team member");
				log.info("Building_Team_Add_Member method completed .......................");
				Assert.assertTrue(true);
			} else {
				log.info(username + "  does not exist in the team member");
				log.info("Building_Team_Add_Member method completed .......................");
				Assert.assertTrue(false);
			}
		} else {
			log.info("First deleting the email and then will add the same email...");
			CommonMethod.Team_Delete_Member(username);
			CommonMethod.Team_Add_Member(username);
			boolean UserNamePresent = CommonMethod.Team_checkEmailExistOrNot(username);
			if (UserNamePresent) {
				log.info(username + "  exists in the team member");
				log.info("Building_Team_Add_Member method completed .......................");
				Assert.assertTrue(true);
			} else {
				log.info(username + "  does not exist in the team member");
				log.info("Building_Team_Add_Member method completed .......................");
				Assert.assertTrue(false);
			}
		}

	}

	// Verify Manage-->It should allow to delete member from the added list

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, dependsOnMethods = "Building_Team_Add_Member", enabled = true, priority = 11, description = "Verify able to delete  team-member successfully.")
	public void Building_Team_Delete_Member() {

		log.info("Building_Team_Delete_Member method started .......................");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		log.info(data.getCellData("Reboot", 0, 2));
		BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(data.getCellData("Reboot", 0, 2));
		HomePage.closeProjectSearchTextBox();
		BuildingPage.ClickonTeamInManage();
		String username = data.getCellData("Reboot", 15, 2);
		CommonMethod.Team_Delete_Member(username);
		boolean emailexist = CommonMethod.Team_checkEmailExistOrNot(username);
		if (!emailexist) {
			log.info(username + "  does not exist as team member");
			log.info("Building_Team_Delete_Member method completed.......................");
			Assert.assertTrue(true);
		} else {
			log.info(username + " still exist as team member");
			log.info("Building_Team_Delete_Member method completed.......................");
			Assert.assertTrue(false);

		}

	}

	// ************************************Regression
	// Test************************************************************

	// --> Verify in Overview tab, Under Actions- clicking on Add a meter should
	// redirect to 'meters and surveys' and opens up 'Add Energy data' pop-up
	// window.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 450, enabled = true, description = "Verify in Overview tab, Under Actions- clicking on Add a meter should redirect to 'meters and surveys' and opens up 'Add Energy data' pop-up window.")
	public void Buildings_Overview_Actions_AddMeter() {

		log.info("Buildings_Overview_Actions_AddMeter method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000040293");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011060";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			flag = BuildingPage.CheckAddEnergyDataModelWindow();
		}
		if (flag) {
			log.info("Buildings_Overview_Actions_AddMeter method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Overview_Actions_AddMeter method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// --> Verify in Overview tab, Under Actions- clicking on 'Building Settings'
	// should redirect to 'meters and surveys' and highlights up 'Building settings'
	// tab

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 451, enabled = true, description = "Verify in Overview tab, Under Actions- clicking on 'Building Settings' should redirect to 'meters and surveys' and highlights up 'Building settings' tab")
	public void Buildings_Overview_Actions_BuildingSetting() {

		log.info("Buildings_Overview_Actions_BuildingSetting method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011060";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			flag = BuildingPage.ClickOnBuildingSetting();
		}
		if (flag) {
			log.info("Buildings_Overview_Actions_BuildingSetting method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Overview_Actions_BuildingSetting method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// --> Verify in Overview tab, Under Actions- clicking on 'Send A Survey' should
	// redirect to 'meters and surveys' and highlights up 'Transportation Survey'

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 452, enabled = true, description = "Verify in Overview tab, Under Actions- clicking on 'Send A Survey' should redirect to 'meters and surveys' and highlights up 'Transportation Survey")
	public void Buildings_Overview_Actions_SendASurvey() {

		log.info("Buildings_Overview_Actions_SendASurvey method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011060";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			flag = BuildingPage.CheckSendASurvey();
		}
		if (flag) {
			log.info("Buildings_Overview_Actions_SendASurvey method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Overview_Actions_SendASurvey method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// --> Verify in Overview tab, Under Actions- clicking on 'Update Apps to
	// collect data' should redirect to Manage--> 'Apps' .

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 453, enabled = true, description = "Verify in Overview tab, Under Actions- clicking on 'Update Apps to collect data' should redirect to Manage--> 'Apps' .")
	public void Buildings_Overview_Actions_UpdateAppsToCollectData() {

		log.info("Buildings_Overview_Actions_UpdateAppsToCollectData method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011060";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			flag = BuildingPage.CheckUpdateAppsToCollectData();
		}
		if (flag) {
			log.info("Buildings_Overview_Actions_UpdateAppsToCollectData method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Overview_Actions_UpdateAppsToCollectData method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// --> Verify in Overview tab, Under Actions- clicking on 'Get Certified' should
	// redirect to Project Tools--> 'Leed Certification' .

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 454, enabled = true, description = "Verify in Overview tab, Under Actions- clicking on 'Get Certified' should redirect to Project Tools--> 'Leed Certification' .")
	public void Buildings_Overview_Actions_GetNotified() {

		log.info("Buildings_Overview_Actions_GetNotified method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011060";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			flag = BuildingPage.CheckGetNotified();
		}
		if (flag) {
			log.info("Buildings_Overview_Actions_GetNotified method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Overview_Actions_GetNotified method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// --> Verify in Overview Tab, By default Top RHS dropdown should show 'Last 12
	// months'

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 455, enabled = true, description = "Verify in Overview Tab, By default Top RHS dropdown should show 'Last 12 months'")
	public void Buildings_Overview_RHS_ShowLast12Months() {

		log.info("Buildings_Overview_RHS_ShowLast12Months method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011060";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			flag = BuildingPage.CheckRHS_ShowLast12Months();
		}
		if (flag) {
			log.info("Buildings_Overview_RHS_ShowLast12Months method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Overview_RHS_ShowLast12Months method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// --> If Last 12 months is selected in dropdown- Under Scores and Metrics-->
	// Arc Scores should show date window as per the following- End Date- with
	// respect to the current date - last month end date || Start date- one year
	// prior to the end date.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 456, enabled = true, description = "If Last 12 months is selected in dropdown- Under Scores and Metrics--> Arc Scores should show date window as per the following- End Date- with respect to the current date - last month end date || Start date- one year prior to the end date.")
	public void Buildings_Overview_RHS_Last12Months_DateRange() {

		log.info("Buildings_Overview_RHS_Last12Months_DateRange method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000012103";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			flag = BuildingPage.CheckRHS_Last12Months_DateRange();
		}
		if (flag) {
			log.info("Buildings_Overview_RHS_Last12Months_DateRange method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Overview_RHS_Last12Months_DateRange method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// --> If End of calendar is selected in dropdown- Under Scores and Metrics-->
	// Arc Scores should show date window as per the following- End Date- with
	// respect to the current date - last month end date || Start date- one year
	// prior to the end date.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 457, enabled = true, description = "If 'End of calendar' is selected in dropdown- Under Scores and Metrics--> Arc Scores should show date window as per the following- End Date- with respect to the current date - last month end date || Start date- one year prior to the end date.")
	public void Buildings_Overview_RHS_EndOfCalender_DateRange() {

		log.info("Buildings_Overview_RHS_EndOfCalender_DateRange method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Private2");
		// ProjectBuildingID = "8000011060";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			flag = BuildingPage.CheckRHS_EndOfCalender_DateRange();
		}
		if (flag) {
			log.info("Buildings_Overview_RHS_EndOfCalender_DateRange method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Overview_RHS_EndOfCalender_DateRange method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// --> If Custom Date Range is selected in dropdown- Under Scores and Metrics-->
	// Arc Scores should show date window as per the following- End Date- with
	// respect to the current date - last month end date || Start date- one year
	// prior to the end date.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 458, enabled = true, description = "If 'Custom Date Range' is selected in dropdown- Under Scores and Metrics--> Arc Scores should show date window as per the following- End Date- with respect to the current date - last month end date || Start date- one year prior to the end date.")
	public void Buildings_Overview_RHS_CustomDateRange() {

		log.info("Buildings_Overview_RHS_CustomDateRange method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Perf3");
		// ProjectBuildingID = "8000040359";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			flag = BuildingPage.CheckRHS_CustomDateRange();
		}
		if (flag) {
			log.info("Buildings_Overview_RHS_CustomDateRange method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Overview_RHS_CustomDateRange method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify in Overview Tab, RHS-- all partner apps show up with linear scrolling.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 459, enabled = false, description = "Verify in Overview Tab, RHS-- all partner apps show up with linear scrolling.")
	public void Buildings_Overview_RHS_All_Partners_App() {

		log.info("Buildings_Overview_RHS_All_Partners_App method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011146";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			flag = BuildingPage.CheckRHS_All_Partners_App();
		}
		if (flag) {
			log.info("Buildings_Overview_RHS_All_Partners_App method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Overview_RHS_All_Partners_App method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// --> Verify in Arc Scores- Just above score- we have dropdown' Total' .
	// Selecting each category from that dropdown should allow to change the graph
	// with respect to the category selected.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 460, enabled = true, description = "Verify in Arc Scores- Just above score- we have dropdown' Total' . Selecting each category from that dropdown should allow to change the graph with respect to the category selected.")
	public void Buildings_Overview_Total_Dropdown_ZeroScore() {

		log.info("Buildings_Overview_Total_Dropdown_ZeroScore method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011146";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			flag = BuildingPage.CheckTotalDropDownWithZeroScore();
		}
		if (flag) {
			log.info("Buildings_Overview_Total_Dropdown_ZeroScore method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Overview_Total_Dropdown_ZeroScore method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// --> Verify Current Arc Scores racetrack should be blank with 0 scores and
	// will show Project address at the bottom of the racetrack.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 461, enabled = true, description = "Verify Current Arc Scores racetrack should be blank with 0 scores and will show Project address at the bottom of the racetrack.")
	public void Buildings_Overview_RaceTrack_ZeroScore() {

		log.info("Buildings_Overview_RaceTrack_ZeroScore method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011146";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			flag = BuildingPage.CheckRaceTrackWithZeroScore();
		}
		if (flag) {
			log.info("Buildings_Overview_RaceTrack_ZeroScore method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Overview_RaceTrack_ZeroScore method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify Current Arc Scores Top right corner has dropdown- 'Graphic' should
	// show Racetrack and 'Table view' should show Tabular view of each category.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 462, enabled = true, description = "Verify Current Arc Scores Top right corner has dropdown- 'Graphic' should show Racetrack and 'Table view' should show Tabular view of each category.")
	public void Buildings_Overview_GraphicDropDown_ZeroScore() {

		log.info("Buildings_Overview_GraphicDropDown_ZeroScore method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011454";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			flag = BuildingPage.CheckGraphicDropDownWithZeroScore();
		}
		if (flag) {
			log.info("Buildings_Overview_GraphicDropDown_ZeroScore method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Overview_GraphicDropDown_ZeroScore method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify 'LEED Pandemic Response Options'- clicking on Learn more link navgates
	// the user to -
	// "https://www.arcskoru.com/managing-occupancy-arc-leed-certification-during-covid-19"

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 463, enabled = true, description = "Verify 'LEED Pandemic Response Options'- clicking on Learn more link navgates the user to - \"https://www.arcskoru.com/managing-occupancy-arc-leed-certification-during-covid-19\"")
	public void Buildings_Overview_LEEDPandemicResponseOptions() {
		log.info("Buildings_Overview_LEEDPandemicResponseOptions method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011146";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			flag = BuildingPage.CheckLEEDPandemicResponseOptions();
		}
		if (flag) {
			log.info("Buildings_Overview_LEEDPandemicResponseOptions method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Overview_LEEDPandemicResponseOptions method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify Scope 1 and 2 emissions- graphs are blank with 0 MTCO2e.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 464, enabled = true, description = "Verify Scope 1 and 2 emissions- graphs are blank with 0 MTCO2e. ")
	public void Buildings_Overview_Scope1And2emissions_ZeroScore() {
		log.info("Buildings_Overview_Scope1And2emissions_ZeroScore method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011146";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			flag = BuildingPage.CheckScope1And2emissions_ZeroScore();
		}
		if (flag) {
			log.info("Buildings_Overview_Scope1And2emissions_ZeroScore method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Overview_Scope1And2emissions_ZeroScore method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify Arc Improvement Scores show values for all performance categories-
	// 0/100

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 465, enabled = true, description = "Verify Arc Improvement Scores show values for all performance categories- 0/100  ")
	public void Buildings_Overview_ArcImprovement_ZeroScores() {
		log.info("Buildings_Overview_ArcImprovement_ZeroScores method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000040359";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			flag = BuildingPage.CheckArcImprovementWithZeroScores();
		}
		if (flag) {
			log.info("Buildings_Overview_ArcImprovement_ZeroScores method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Overview_ArcImprovement_ZeroScores method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify Transportation GHG emissions graph are blank with 0 lbs.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 466, enabled = true, description = "Verify Transportation GHG emissions graph are blank with 0 lbs.")
	public void Buildings_Overview_Transportation_GHGEmission_ZeroScores() {
		log.info("Buildings_Overview_Transportation_GHGEmission_ZeroScores method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011194";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			flag = BuildingPage.CheckTransportation_GHGEmission_ZeroScores();
		}
		if (flag) {
			log.info("Buildings_Overview_Transportation_GHGEmission_ZeroScores method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Overview_Transportation_GHGEmission_ZeroScores method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify Building Settings-->Operating hours tab-- clicking on 'Add Row' adds a
	// new line item.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 467, enabled = true, description = "Verify Building Settings-->Operating hours tab-- clicking on 'Add Row' adds a new line item.")
	public void Buildings_MeterSurvey_OperatingHours_AddRow() {
		log.info("Buildings_MeterSurvey_OperatingHours_AddRow method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011194";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			String UserName = HomePage.getCurrentProfileUserName();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_OperatingHoursTab();
			flag = BuildingPage.BuildingSetting_OperatingHours_AddRow(UserName);
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_OperatingHours_AddRow method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_OperatingHours_AddRow method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Operating hours tab -->Verify Clicking on effective date
	// opens up calendar and allows to select dates successfully.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 468, enabled = true, description = "Building Settings-->Operating hours tab -->Verify Clicking on effective date opens up calendar and allows to select dates successfully.")
	public void Buildings_MeterSurvey_OperatingHours_SelectEffectiveDate() {
		log.info("Buildings_MeterSurvey_OperatingHours_SelectEffectiveDate method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011194";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_OperatingHoursTab();
			flag = BuildingPage.BuildingSetting_SelectEffectiveDate();
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_OperatingHours_SelectEffectiveDate method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_OperatingHours_SelectEffectiveDate method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify Operating hours field by selecting hours from the dropdown.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 469, enabled = true, description = "Verify Operating hours field by selecting hours from the dropdown.")
	public void Buildings_MeterSurvey_OperatingHours_SelectHours() {
		log.info("Buildings_MeterSurvey_OperatingHours_SelectHours method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011375";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_OperatingHoursTab();
			flag = BuildingPage.BuildingSetting_SelectOperatingHours();
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_OperatingHours_SelectHours method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_OperatingHours_SelectHours method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Operating hours tab --> Verify clicking on 'Upload'
	// button opens up with four options- 'Computer
	// File', 'Dropbox, OneDrive,Google Drive.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_MeterSurvey_OperatingHours_SelectHours", priority = 469, enabled = true, description = "Verify clicking on 'Upload' button opens up with four options- 'Computer File', 'Dropbox, OneDrive,Google Drive. ")
	public void Buildings_MeterSurvey_OperatingHours_CheckUploadOprions() {
		log.info("Buildings_MeterSurvey_OperatingHours_CheckUploadOprions method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011558";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_OperatingHoursTab();
			flag = BuildingPage.BuildingSetting_CheckUploadOprions();
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_OperatingHours_CheckUploadOprions method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_OperatingHours_CheckUploadOprions method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Operating Hours-> Verify able to upload file successfully using
	// Documentation dropdown using Computer upload option.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_MeterSurvey_OperatingHours_CheckUploadOprions", priority = 470, enabled = true, description = "Building -> Operating Hours-> Verify able to upload file successfully using Documentation dropdown using Computer upload option.")
	public void Buildings_MeterSurvey_OperatingHours_ValidateDocument() {

		log.info("Buildings_MeterSurvey_OperatingHours_ValidateDocument method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011558";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_OperatingHoursTab();
			flag = BuildingPage.OperatingHours_ValidateDocument();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_OperatingHours_ValidateDocument method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_OperatingHours_ValidateDocument method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Operating hours tab - >verify delete button allows you to
	// delete line item.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 471, enabled = true, description = "Building Settings-->Operating hours tab ->verify delete button allows you to delete line item.")
	public void Buildings_MeterSurvey_OperatingHours_CheckDeleteRow() {
		log.info("Buildings_MeterSurvey_OperatingHours_CheckDeleteRow method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Private2");
		// ProjectBuildingID = "8000038714";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_OperatingHoursTab();
			flag = BuildingPage.BuildingSetting_Ohours_CheckDelete();
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_OperatingHours_CheckDeleteRow method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_OperatingHours_CheckDeleteRow method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Operating hours tab - >Verify filter and reset
	// functionalities.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 472, enabled = true, description = "Building Settings-->Operating hours tab ->Verify filter and reset functionalities.")
	public void Buildings_MeterSurvey_OperatingHours_CheckFilterAndReset() {
		log.info("Buildings_MeterSurvey_OperatingHours_CheckFilterAndReset method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Perf3");
		// ProjectBuildingID = "1000103746";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_OperatingHoursTab();
			flag = BuildingPage.BuildingSetting_CheckFilterAndReset();
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_OperatingHours_CheckFilterAndReset method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_OperatingHours_CheckFilterAndReset method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Operating hours tab - > Verify comments and activity..

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 473, enabled = true, description = " Building Settings-->Operating hours tab - > Verify comments and activity.")
	public void Buildings_MeterSurvey_OperatingHours_Comments_Activity() {

		log.info("Buildings_MeterSurvey_OperatingHours_Comments_Activity method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Perf3");
		// ProjectBuildingID="8000011194";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_OperatingHoursTab();
			flag = BuildingPage.BuildingSetting_CheckCommentAndActivity(data.getCellData("Building", 1, 2),
					ProfileUserName);
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_OperatingHours_Comments_Activity method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_OperatingHours_Comments_Activity method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Gross Floor Area tab-- Verify clicking on 'Add Row' adds
	// a new line item.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 474, enabled = true, description = " Building Settings-->Gross Floor Area tab-- Verify clicking on 'Add Row' adds a new line item.")
	public void Buildings_MeterSurvey_GrossFloorArea_AddRow() {
		log.info("Buildings_MeterSurvey_GrossFloorArea_AddRow method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011299";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			String UserName = HomePage.getCurrentProfileUserName();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_GrossFloorAreaTab();
			flag = BuildingPage.BuildingSetting_GrossFloorArea_AddRow(UserName);
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_GrossFloorArea_AddRow method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_GrossFloorArea_AddRow method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Gross Floor Area tab-- -->Verify Clicking on effective
	// date opens up calendar and allows to select dates successfully.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 475, enabled = true, description = "Building Settings-->Gross Floor Area tab-- -->Verify Clicking on effective date opens up calendar and allows to select dates successfully.")
	public void Buildings_MeterSurvey_GrossFloorArea_SelectEffectiveDate() {
		log.info("Buildings_MeterSurvey_GrossFloorArea_SelectEffectiveDate method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011299";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_GrossFloorAreaTab();
			flag = BuildingPage.BuildingSetting_GrossFloorArea_SelectEffectiveDate();
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_GrossFloorArea_SelectEffectiveDate method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_GrossFloorArea_SelectEffectiveDate method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Gross Floor Area tab-- -->Verify Gross Area field allows
	// to add only numeric value.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 476, enabled = true, description = "Building Settings-->Gross Floor Area tab-- -->Verify Gross Area field allows to add only numeric value.")
	public void Buildings_MeterSurvey_GrossFloorArea_GrossAreaField_AllowNumericOnly() {
		log.info(
				"Buildings_MeterSurvey_GrossFloorArea_GrossAreaField_AllowNumericOnly method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011299";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_GrossFloorAreaTab();
			flag = BuildingPage.BuildingSetting_GrossAreaField_AllowNumericOnly();
		}
		if (flag) {
			log.info(
					"Buildings_MeterSurvey_GrossFloorArea_GrossAreaField_AllowNumericOnly method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_MeterSurvey_GrossFloorArea_GrossAreaField_AllowNumericOnly method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Gross Floor Area tab - >Verify Unit field gives two
	// options- IP units(Square feet) and SI units(Square meters) to select from.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 477, enabled = true, description = "Building Settings-->GrossFloorArea tab ->Verify Unit field gives two options- IP units(Square feet) and SI units(Square meters) to select from.")
	public void Buildings_MeterSurvey_GrossFloorArea_CheckUnits() {
		log.info("Buildings_MeterSurvey_GrossFloorArea_CheckUnits method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000038699";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_GrossFloorAreaTab();
			flag = BuildingPage.BuildingSetting_CheckAddRowWithBothUnits();
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_GrossFloorArea_CheckUnits method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_GrossFloorArea_CheckUnits method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Gross Floor Area tab --> Verify clicking on 'Upload'
	// button opens up with four options- 'Computer
	// File', 'Dropbox, OneDrive,Google Drive.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_MeterSurvey_GrossFloorArea_CheckUnits", priority = 479, enabled = true, description = "Building Settings-->Gross Floor Area tab -> Verify clicking on 'Upload' button opens up with four options- 'Computer File', 'Dropbox, OneDrive,Google Drive. ")
	public void Buildings_MeterSurvey_GrossFloorArea_CheckUploadOprions() {
		log.info("Buildings_MeterSurvey_GrossFloorArea_CheckUploadOprions method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000038699";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_GrossFloorAreaTab();
			flag = BuildingPage.BuildingSetting_GrossFloorArea_CheckUploadOprions();
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_GrossFloorArea_CheckUploadOprions method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_GrossFloorArea_CheckUploadOprions method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Gross Floor Area-> Verify able to upload file successfully using
	// Documentation dropdown using Computer upload option.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_MeterSurvey_GrossFloorArea_CheckUploadOprions", priority = 479, enabled = true, description = "Building -> Gross Floor Area-> Verify able to upload file successfully using Documentation dropdown using Computer upload option.")
	public void Buildings_MeterSurvey_GrossFloorArea_ValidateDocument() {

		log.info("Buildings_MeterSurvey_GrossFloorArea_ValidateDocument method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011558";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_GrossFloorAreaTab();
			flag = BuildingPage.GrossFloorArea_ValidateDocument();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_GrossFloorArea_ValidateDocument method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_GrossFloorArea_ValidateDocument method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Gross Floor Area tab - >verify delete button allows you
	// to delete line item.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 480, enabled = true, description = "Building Settings-->Gross Floor Area tab ->verify delete button allows you to delete line item.")
	public void Buildings_MeterSurvey_GrossFloorArea_CheckDeleteRow() {
		log.info("Buildings_MeterSurvey_GrossFloorArea_CheckDeleteRow method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000038714";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_GrossFloorAreaTab();
			flag = BuildingPage.BuildingSetting_GrossFloor_CheckDelete();
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_GrossFloorArea_CheckDeleteRow method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_GrossFloorArea_CheckDeleteRow method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Gross Floor Area tab - >Verify filter and reset
	// functionalities.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 481, enabled = true, description = "Building Settings-->Gross Floor Area tab - >Verify filter and reset functionalities.")
	public void Buildings_MeterSurvey_GrossFloorArea_CheckFilterAndReset() {
		log.info("Buildings_MeterSurvey_GrossFloorArea_CheckFilterAndReset method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Perf3");
		// ProjectBuildingID = "8000038714";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_GrossFloorAreaTab();
			flag = BuildingPage.BuildingSetting_GrossFloorArea_CheckFilterAndReset();
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_GrossFloorArea_CheckFilterAndReset method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_GrossFloorArea_CheckFilterAndReset method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Gross Floor Area tab - > Verify comments and activity..

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 482, enabled = true, description = " Building Settings-->Gross Floor Area tab - > Verify comments and activity.")
	public void Buildings_MeterSurvey_GrossFloorArea_Comments_Activity() {

		log.info("Buildings_MeterSurvey_GrossFloorArea_Comments_Activity method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Perf3");
		// ProjectBuildingID="8000011194";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_GrossFloorAreaTab();
			flag = BuildingPage.BuildingSetting_GrossFloorAreaCheckCommentAndActivity(
					data.getCellData("Building", 6, 2), ProfileUserName);
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_GrossFloorArea_Comments_Activity method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_GrossFloorArea_Comments_Activity method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Occupant tab - >Verify Occupants tab by clicking on 'Add
	// Occupancy data' button
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 484, enabled = true, description = "Building Settings-->Occupant tab - >Verify Occupants tab by clicking on 'Add Occupancy data' button.")
	public void Buildings_MeterSurvey_Occupant_AddOccupancyData() {
		log.info("Buildings_MeterSurvey_Occupant_AddOccupancyData method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000038738";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			flag = BuildingPage.BuildingSetting_OccupantTab_AddOccupancyData();
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_Occupant_AddOccupancyData method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_Occupant_AddOccupancyData method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Occupant tab-- -->Verify Clicking on effective date opens
	// up calendar and allows to select dates successfully.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 486, enabled = true, description = "Building Settings-->Occupant tab-- -->Verify Clicking on effective date opens up calendar and allows to select dates successfully.")
	public void Buildings_MeterSurvey_Occupant_SelectEffectiveDate() {
		log.info("Buildings_MeterSurvey_Occupant_SelectEffectiveDate method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000038738";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			flag = BuildingPage.BuildingSetting_Occupant_SelectEffectiveDate();
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_Occupant_SelectEffectiveDate method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_Occupant_SelectEffectiveDate method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Occupant tab-- -->Verify Regular building occupants(daily
	// average) field by adding numeric value.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 490, enabled = true, description = "Building Settings-->Occupant tab-- -->Verify Regular building occupants(daily average) field by adding numeric value.")
	public void Buildings_MeterSurvey_Occupant_RegularBuildingField_AllowNumericOnly() {
		log.info(
				"Buildings_MeterSurvey_Occupant_RegularBuildingField_AllowNumericOnly method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000038738";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			flag = BuildingPage.BuildingSetting_Occupant_RegularBuildingField_AllowNumericOnly();
		}
		if (flag) {
			log.info(
					"Buildings_MeterSurvey_Occupant_RegularBuildingField_AllowNumericOnly method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_MeterSurvey_Occupant_RegularBuildingField_AllowNumericOnly method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Occupant tab-- -->Verify Days per week with visitors
	// field by adding numeric value.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 492, enabled = true, description = "Building Settings-->Occupant tab-- -->Verify Days per week with visitors field by adding numeric value.")
	public void Buildings_MeterSurvey_Occupant_DaysPerWeekWithVisitorField_AllowNumericOnly() {
		log.info(
				"Buildings_MeterSurvey_Occupant_DaysPerWeekWithVisitorField_AllowNumericOnly method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000038738";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			flag = BuildingPage.BuildingSetting_Occupant_DaysPerWeekWithVisitorField();
		}
		if (flag) {
			log.info(
					"Buildings_MeterSurvey_Occupant_DaysPerWeekWithVisitorField_AllowNumericOnly method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_MeterSurvey_Occupant_DaysPerWeekWithVisitorField_AllowNumericOnly method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Occupant tab-- -->Verify 'Days per week with visitors'
	// has a limit to not allow value greater than 7.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 494, enabled = true, description = "Building Settings-->Occupant tab-- -->Verify 'Days per week with visitors' has a limit to not allow value greater than 7.")
	public void Buildings_MeterSurvey_Occupant_DaysPerWeekWithVisitor_NotAllowMoreThan7() {
		log.info(
				"Buildings_MeterSurvey_Occupant_DaysPerWeekWithVisitor_NotAllowMoreThan7 method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000038738";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			flag = BuildingPage.BuildingSetting_Occupant_DaysPerWeekWithVisitor_NotAllowMoreThan7();
		}
		if (flag) {
			log.info(
					"Buildings_MeterSurvey_Occupant_DaysPerWeekWithVisitor_NotAllowMoreThan7 method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_MeterSurvey_Occupant_DaysPerWeekWithVisitor_NotAllowMoreThan7 method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Occupant tab-- -->Verify 'Number of visitors each day'
	// field by adding numeric value..
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 496, enabled = true, description = "Building Settings-->Occupant tab-- -->Verify 'Number of visitors each day' field by adding numeric value.")
	public void Buildings_MeterSurvey_Occupant_NoOfVisitorEachDayField_AllowNumericOnly() {
		log.info(
				"Buildings_MeterSurvey_Occupant_NoOfVisitorEachDayField_AllowNumericOnly method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000038738";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			flag = BuildingPage.BuildingSetting_Occupant_NoOfVisitorEachDayField();
		}
		if (flag) {
			log.info(
					"Buildings_MeterSurvey_Occupant_NoOfVisitorEachDayField_AllowNumericOnly method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_MeterSurvey_Occupant_NoOfVisitorEachDayField_AllowNumericOnly method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Occupant tab-- -->Verify 'Duration of visit(in hours/day)
	// field by adding numeric value in hours:minutes format or by selecting hrs/min
	// using drop down.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 498, enabled = true, description = "Building Settings-->Occupant tab-- -->Verify 'Duration of visit(in hours/day) field by adding numeric value in hours:minutes format or by selecting hrs/min using drop down.")
	public void Buildings_MeterSurvey_Occupant_SelectDurationOfVisit() {
		log.info("Buildings_MeterSurvey_Occupant_SelectDurationOfVisit method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000038738";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			flag = BuildingPage.BuildingSetting_Occupant_SelectDurationOfVisit();
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_Occupant_SelectDurationOfVisit method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_Occupant_SelectDurationOfVisit method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Occupant tab-- -->Validate Weekly operating hours shows
	// the hrs entered in 'Operating hrs' field.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 500, dependsOnMethods = "Buildings_MeterSurvey_Occupant_SelectDurationOfVisit", enabled = true, description = "Building Settings-->Occupant tab-- -->Validate Weekly operating hours shows the hrs entered in 'Operating hrs' field.")
	public void Buildings_MeterSurvey_Occupant_CheckWeeklyOperatingHours() {
		log.info("Buildings_MeterSurvey_Occupant_CheckWeeklyOperatingHours method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_NonLEED4");
		// ProjectBuildingID = "8000011341";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_OperatingHoursTab();
			flag = BuildingPage.BuildingSetting_Occupant_CheckWeeklyOperatingHours();
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_Occupant_CheckWeeklyOperatingHours method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_Occupant_CheckWeeklyOperatingHours method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Occupant tab-- -->Validate 'Add Occupany window' visitors
	// are calculated based on the calculation-
	// (Days per week with visitors* no of visitors each day *duration of
	// visit)/operating hours

	// Building Settings-->Occupant tab-- -->Validate total daily occupancy is sum
	// of Visitors and Regular building occupants.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 501, dependsOnMethods = "Buildings_MeterSurvey_Occupant_SelectDurationOfVisit", enabled = true, description = "Building Settings-->Occupant tab-- -->Validate 'Add Occupany window' visitors are calculated based on the calculation-(Days per week with visitors* no of visitors each day *duration of visit)/operating hours  and Total Daily Occupancy")
	public void Buildings_MeterSurvey_Occupant_VisitorsDailyAverage_TotalDailyOccupancy() {
		log.info(
				"Buildings_MeterSurvey_Occupant_VisitorsDailyAverage_TotalDailyOccupancy method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_NonLEED4");
		// ProjectBuildingID = "8000012217";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			flag = BuildingPage.BuildingSetting_Occupant_VisitorsDailyAverage_TotalDailyOccupancy();
		}
		if (flag) {
			log.info(
					"Buildings_MeterSurvey_Occupant_VisitorsDailyAverage_TotalDailyOccupancy method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_MeterSurvey_Occupant_VisitorsDailyAverage_TotalDailyOccupancy method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Occupant tab-- -->Validate total daily occupancy is sum
	// of Visitors and Regular building occupants.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 502, enabled = false, description = "Building Settings-->Occupant tab-- -->Validate total daily occupancy is sum of Visitors and Regular building occupants.")
	public void Buildings_MeterSurvey_Occupant_CheckTotalDailyOccupancy() {
		log.info("Buildings_MeterSurvey_Occupant_CheckTotalDailyOccupancy method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_NonLEED4");
		// ProjectBuildingID = "8000012174";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			flag = BuildingPage.BuildingSetting_Occupant_CheckTotalDailyOccupancy();
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_Occupant_CheckTotalDailyOccupancy method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_Occupant_CheckTotalDailyOccupancy method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Occupant tab-- --> Add one record with Effective Date,
	// Regular Building Occupants, Days per week with Visitors, No. of Visitors each
	// day, and Duration of Visit
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 503, enabled = true, description = "Building Settings-->Occupant tab-- --> Add one record with Effective Date, Regular Building Occupants, Days per week with Visitors, No. of Visitors each day, and Duration of Visit")
	public void Buildings_MeterSurvey_Occupant_AddOneRecord() {
		log.info("Buildings_MeterSurvey_Occupant_AddOneRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011373";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			flag = BuildingPage.BuildingSetting_Occupant_AddOneRecord();
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_Occupant_AddOneRecord method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_Occupant_AddOneRecord method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Occupant tab --> Verify clicking on 'Upload'
	// button opens up with four options- 'Computer
	// File', 'Dropbox, OneDrive,Google Drive.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_MeterSurvey_Occupant_AddOneRecord", priority = 503, enabled = true, description = "Building Settings-->Occupant tab -> Verify clicking on 'Upload' button opens up with four options- 'Computer File', 'Dropbox, OneDrive,Google Drive. ")
	public void Buildings_MeterSurvey_Occupant_CheckUploadOprions() {
		log.info("Buildings_MeterSurvey_Occupant_CheckUploadOprions method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000038699";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_OccupantTab();
			flag = BuildingPage.BuildingSetting_Occupant_CheckUploadOprions();
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_Occupant_CheckUploadOprions method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_Occupant_CheckUploadOprions method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Occupant-> Verify able to upload file successfully using
	// Documentation dropdown using Computer upload option.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_MeterSurvey_Occupant_CheckUploadOprions", priority = 503, enabled = true, description = "Building -> Occupant-> Verify able to upload file successfully using Documentation dropdown using Computer upload option.")
	public void Buildings_MeterSurvey_Occupant_ValidateDocument() {

		log.info("Buildings_MeterSurvey_Occupant_ValidateDocument method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011558";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_OccupantTab();
			flag = BuildingPage.Occupant_ValidateDocument();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_Occupant_ValidateDocument method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_Occupant_ValidateDocument method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Occupant tab - > Verify comments and activity..

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 504, enabled = true, description = " Building Settings-->Occupant tab - > Verify comments and activity.")
	public void Buildings_MeterSurvey_Occupant_Comments_Activity() {

		log.info("Buildings_MeterSurvey_Occupant_Comments_Activity method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Perf3");
		// ProjectBuildingID="8000011194";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			flag = BuildingPage.BuildingSetting_Occupant_CheckCommentAndActivity(data.getCellData("Building", 7, 2),
					ProfileUserName);
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_Occupant_Comments_Activity method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_Occupant_Comments_Activity method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Operational Days tab - > Validate Operational days, by
	// default the value is present as '313' and the value is editable.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 506, enabled = true, description = "Building Settings-->Operational Days tab - > Validate Operational days, by default the value is present as '313' and the value is editable.")
	public void Buildings_MeterSurvey_OperationalDays_DefaultValue313() {

		log.info("Buildings_MeterSurvey_OperationalDays_DefaultValue313 method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000012182");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011389";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_OperationalDaysTab();
			flag = BuildingPage.BuildingSetting_ODays_CheckDefaultValue313();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_OperationalDays_DefaultValue313 method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_OperationalDays_DefaultValue313 method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Operational Days tab --> Verify clicking on 'Upload'
	// button opens up with four options- 'Computer
	// File', 'Dropbox, OneDrive,Google Drive.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_MeterSurvey_GrossFloorArea_CheckUnits", priority = 507, enabled = true, description = "Building Settings-->Operational Days tab -> Verify clicking on 'Upload' button opens up with four options- 'Computer File', 'Dropbox, OneDrive,Google Drive. ")
	public void Buildings_OperationalDays_CheckUploadOprions() {
		log.info("Buildings_OperationalDays_CheckUploadOprions method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000038699";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_OperationalDaysTab();
			flag = BuildingPage.OperationalDays_CheckUploadOprions();
		}
		if (flag) {
			log.info("Buildings_OperationalDays_CheckUploadOprions method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_OperationalDays_CheckUploadOprions method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Operational Days Tab-> Verify able to upload file successfully
	// using Documentation dropdown using Computer upload option.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_OperationalDays_CheckUploadOprions", priority = 507, enabled = true, description = "Building -> Operational Days Tab-> Verify able to upload file successfully using Documentation dropdown using Computer upload option.")
	public void Buildings_OperationalDays_ValidateDocument() {

		log.info("Buildings_OperationalDays_ValidateDocument method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011558";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_OperationalDaysTab();
			flag = BuildingPage.OperationalDays_ValidateDocument();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_OperationalDays_ValidateDocument method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_OperationalDays_ValidateDocument method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Operational Days tab - > Validate Operational days,
	// default row item field is editable and allows to add new row.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 508, enabled = true, description = "Building Settings-->Operational Days tab - > Validate Operational days, default row item field is editable and allows to add new row.")
	public void Buildings_MeterSurvey_OperationalDays_AddNewRow() {

		log.info("Buildings_MeterSurvey_OperationalDays_AddNewRow method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011389";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_OperationalDaysTab();
			flag = BuildingPage.BuildingSetting_ODays_AddNewRow();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_OperationalDays_AddNewRow method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_OperationalDays_AddNewRow method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Operational Days tab - > Verify comments and activity..

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 507, enabled = true, description = " Building Settings-->Operational Days tab - > Verify comments and activity.")
	public void Buildings_MeterSurvey_OperationalDays_Comments_Activity() {

		log.info("Buildings_MeterSurvey_OperationalDays_Comments_Activity method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011361";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_OperationalDaysTab();
			flag = BuildingPage.BuildingSetting_OperationalDays_CheckCommentAndActivity(
					data.getCellData("Building", 9, 2), ProfileUserName);
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_OperationalDays_Comments_Activity method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_MeterSurvey_OperationalDays_Comments_Activity method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Emissions Factor tab - > Validate emission factor-
	// Standard emission factor radio button is selected.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 512, enabled = true, description = "Building Settings-->Emissions Factor tab - > Validate emission factor- Standard emission factor radio button is selected.")
	public void Buildings_MeterSurvey_EmissionsFactor_StandardEmissionsFactor() {

		log.info(
				"Buildings_MeterSurvey_EmissionsFactor_StandardEmissionsFactor method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011346";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_EmissionsFactorTab();
			flag = BuildingPage.BuildingSetting_EmissionFactor_StandardEmission();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info(
					"Buildings_MeterSurvey_EmissionsFactor_StandardEmissionsFactor method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_MeterSurvey_EmissionsFactor_StandardEmissionsFactor method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Emissions Factor tab - > Validate emission factor- Custom
	// emission factor allows to add row item with effective date, value and
	// documents.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 513, enabled = true, description = "Building Settings-->Emissions Factor tab - > Validate emission factor- Custom emission factor allows to add row item with effective date, value and documents.")
	public void Buildings_MeterSurvey_EmissionsFactor_CustomEmissionsFactor() {

		log.info(
				"Buildings_MeterSurvey_EmissionsFactor_CustomEmissionsFactor method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011346";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_EmissionsFactorTab();
			String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";
			File f = new File(UploadPath);
			flag = BuildingPage.BuildingSetting_EmissionFactor_CustomEmission(UploadPath);
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info(
					"Buildings_MeterSurvey_EmissionsFactor_CustomEmissionsFactor method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_MeterSurvey_EmissionsFactor_CustomEmissionsFactor method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Emission Factor tab --> Verify clicking on 'Upload'
	// button opens up with four options- 'Computer
	// File', 'Dropbox, OneDrive,Google Drive.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_MeterSurvey_EmissionsFactor_CustomEmissionsFactor", priority = 513, enabled = true, description = "Building Settings-->Emissions Factor -> Verify clicking on 'Upload' button opens up with four options- 'Computer File', 'Dropbox, OneDrive,Google Drive. ")
	public void Buildings_MeterSurvey_EmissionsFactor_CheckUploadOprions() {
		log.info("Buildings_MeterSurvey_EmissionsFactor_CheckUploadOprions method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000038699";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_EmissionsFactorTab();
			flag = BuildingPage.BuildingSetting_EmissionsFactor_CheckUploadOprions();
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_EmissionsFactor_CheckUploadOprions method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_EmissionsFactor_CheckUploadOprions method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Emissions Factor-> Verify able to upload file successfully using
	// Documentation dropdown using Computer upload option.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_MeterSurvey_EmissionsFactor_CheckUploadOprions", priority = 513, enabled = true, description = "Building -> Emissions Factor-> Verify able to upload file successfully using Documentation dropdown using Computer upload option.")
	public void Buildings_MeterSurvey_EmissionsFactor_ValidateDocument() {

		log.info("Buildings_MeterSurvey_EmissionsFactor_ValidateDocument method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011558";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_EmissionsFactorTab();
			flag = BuildingPage.EmissionsFactor_ValidateDocument();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_EmissionsFactor_ValidateDocument method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_EmissionsFactor_ValidateDocument method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings-->Emissions Factor tab - > Verify comments and activity..

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 514, enabled = true, description = " Building Settings-->Emissions Factor tab - > Verify comments and activity.")
	public void Buildings_MeterSurvey_EmissionsFactor_Comments_Activity() {

		log.info("Buildings_MeterSurvey_EmissionsFactor_Comments_Activity method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011361";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.ClickOnBuildingSetting();
			BuildingPage.ClickOnBuildingSetting_EmissionsFactorTab();
			flag = BuildingPage.BuildingSetting_EmissionsFactor_CheckCommentAndActivity(
					data.getCellData("Building", 11, 2), ProfileUserName);
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_MeterSurvey_EmissionsFactor_Comments_Activity method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_MeterSurvey_EmissionsFactor_Comments_Activity method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings--> Energy --> Validate unit type present in dropdown are-
	// kwh,mwh,mbtu,kbtu,GJ

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 520, enabled = true, description = "Building Settings--> Energy -->Validate unit type present in dropdown are- kwh,mwh,mbtu,kbtu,GJ")
	public void Buildings_Energy_ValidateUnitType() {

		log.info("Buildings_Energy_ValidateUnitType method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000012218";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			flag = BuildingPage.Energy_ValidateUnitType();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Energy_ValidateUnitType method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Energy_ValidateUnitType method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings--> Energy --> Validate for Energy meter- Add new meter-
	// Should populate values by default as -"Type- Electricity", "Unit type- kwh"
	// and "Fuel source- purchased from grid.", Just add 'meter name'.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 521, enabled = true, description = "Building Settings--> Energy -->Add new meter- Should populate values by default as -\"Type- Electricity\", \"Unit type- kwh\" and \"Fuel source- purchased from grid.\"")
	public void Buildings_Energy_AddNewMeter_DefaultValues() {

		log.info("Buildings_Energy_AddNewMeter_DefaultValues method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011454";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			flag = BuildingPage.Energy_AddNewMeter_DefaultValues();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Energy_AddNewMeter_DefaultValues method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Energy_AddNewMeter_DefaultValues method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Building Settings--> Energy --> Validate Type, Unit and Fuel source selected
	// value shows in Meter details tab..Click on Add button should add a new meter.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 522, enabled = true, description = "Building Settings--> Energy -->Validate Type, Unit and Fuel source selected. value shows in Meter details tab..\n Click on Add button should add a new meter.")
	public void Buildings_Energy_AddNewMeter_ValidateTypeUnitFuelSourceInDetailsTab() {

		log.info(
				"Buildings_Energy_AddNewMeter_ValidateTypeUnitFuelSourceInDetailsTab method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011380";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			flag = BuildingPage.Energy_ValidateTypeUnitFuelSourceInDetailsTab();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info(
					"Buildings_Energy_AddNewMeter_ValidateTypeUnitFuelSourceInDetailsTab method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_Energy_AddNewMeter_ValidateTypeUnitFuelSourceInDetailsTab method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings--> Energy --> Verify if Start date is greater than end
	// date, gives Overlapping dates error.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_Energy_AddNewMeter_ValidateTypeUnitFuelSourceInDetailsTab", priority = 524, enabled = true, description = "Building Settings--> Energy -->Verify if Start date is greater than end date, gives Overlapping dates error..")
	public void Buildings_Energy_CheckOverlappingDates() {

		log.info("Buildings_Energy_CheckOverlappingDates method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011454";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			flag = BuildingPage.Energy_ValidateOverlappingDate();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Energy_CheckOverlappingDates method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Energy_CheckOverlappingDates method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings--> Energy --> Verify Clicking on add row allows to add
	// start date,end date and reading.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_Energy_AddNewMeter_ValidateTypeUnitFuelSourceInDetailsTab", priority = 525, enabled = true, description = "Building Settings--> Energy -->Building Settings--> Energy --> Verify Clicking on add row allows to add start date,end date, reading, cost and documents.")
	public void Buildings_Energy_AddRecord() {

		log.info("Buildings_Energy_AddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011389";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			flag = BuildingPage.Energy_AddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Energy_AddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Energy_AddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings--> Energy --> Validate documents added in the row item are
	// displayed under Documents tab.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_Energy_AddRecord", priority = 526, enabled = true, description = "Building Settings--> Energy -->Validate documents added in the row item are displayed under Documents tab.")
	public void Buildings_Energy_ValidateDocument() {

		log.info("Buildings_Energy_ValidateDocument method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000012199";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			flag = BuildingPage.Energy_ValidateDocument();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Energy_ValidateDocument method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Energy_ValidateDocument method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings--> Energy --> Verify Energy score gets generated if valid
	// Energy data is added and building settings is present for the project.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_Energy_AddRecord", priority = 526, enabled = true, description = "Building Settings--> Energy -->Verify Energy score gets generated if valid Energy data is added and building settings is present for the project.")
	public void Buildings_Energy_CheckScore() {

		log.info("Buildings_Energy_CheckScore method started......................... ");
		boolean flag = false;
		int Score = 0;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011389";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			Score = BuildingPage.getEnergyScore();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (Score > 0) {
			log.info("Buildings_Energy_CheckScore method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Energy_CheckScore method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings--> Energy --> Verify when adding new meter and type is
	// selected as 'other fuel' , Fuel Source options get changed to Natural gas.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 528, enabled = true, description = "Building Settings--> Energy --> Verify when adding new meter and type is selected as 'other fuel' , Fuel Source options get changed to Natural gas.")
	public void Buildings_Energy_CheckOtherFuelType() {

		log.info("Buildings_Energy_CheckOtherFuelType method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Private2");
		// ProjectBuildingID="8000011397";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			CommonMethod.switchToShowOverviewFrame();
			BuildingPage.CheckAddEnergyDataModelWindow();
			flag = BuildingPage.EnergyCheckOtherFuelType();

		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Energy_CheckOtherFuelType method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Energy_CheckOtherFuelType method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings--> Energy --> Verify for type 'Fuel type' by adding all the
	// options from the dropdown.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 529, enabled = false, description = "Building Settings--> Energy --> Verify for type 'Fuel type' by adding all the options from the dropdown.")
	public void Buildings_Energy_AddWithOtherFuelsType() {

		log.info("Buildings_Energy_AddWithOtherFuelsType method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Private2");
		// ProjectBuildingID = "8000011390";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			flag = BuildingPage.Energy_AddWithOtherFuelsType();

		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Energy_AddWithOtherFuelsType method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Energy_AddWithOtherFuelsType method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings--> Energy --> Verify Delete button allows you to delete
	// line item.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 529, dependsOnMethods = "Buildings_Energy_AddRecord", enabled = true, description = "Building Settings--> Energy --> Verify Delete button allows you to delete line item.")
	public void Buildings_Energy_DeleteRow() {

		log.info("Buildings_Energy_DeleteRow method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011389";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			flag = BuildingPage.Energy_DeleteRow();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Energy_DeleteRow method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Energy_DeleteRow method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings--> Water --> Validate for Water meter- Add new meter-
	// Should populate values by default as -"Type- Water", "Unit type- gal" and
	// "Fuel source- municipality supplied potable water.", Just add 'meter name'
	// and click on Add button should add a new meter.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 534, enabled = true, description = "Building Settings--> Water -->Validate for Water meter- Add new meter- Should populate values by default as -\"Type- Water\", \"Unit type- gal\" and \"Fuel source- municipality supplied potable water.\", Just add 'meter name'.")
	public void Buildings_Water_AddNewMeter_DefaultValues() {

		log.info("Buildings_Water_AddNewMeter_DefaultValues method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011412";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			flag = BuildingPage.Water_AddNewMeter_DefaultValues();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Water_AddNewMeter_DefaultValues method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Water_AddNewMeter_DefaultValues method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings--> Water --> Validate unit type present in dropdown are-
	// gal,kgal,mgal,cf,ccf,kcf,mcf,l,cu,gal(UK),kgal(UK),mgal(UK),cgal(UK),cgal(US),kcm

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 535, enabled = true, description = "Building Settings--> Water -->Validate unit type present in dropdown are- gal,kgal,mgal,cf,ccf,kcf,mcf,l,cu,gal(UK),kgal(UK),mgal(UK),cgal(UK),cgal(US),kcm")
	public void Buildings_Water_ValidateUnitType() {

		log.info("Buildings_Water_ValidateUnitType method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011412";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			flag = BuildingPage.Water_ValidateUnitType();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Water_ValidateUnitType method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Water_ValidateUnitType method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings--> Water --> Validate Type, Unit and Fuel source selected
	// value shows in Meter details tab..Click on Add button should add a new meter.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 536, enabled = true, description = "Building Settings--> Energy -->Validate Type, Unit and Fuel source selected. value shows in Meter details tab..\n Click on Add button should add a new meter.")
	public void Buildings_Water_ValidateTypeUnitFuelSourceInDetailsTab() {

		log.info("Buildings_Water_ValidateTypeUnitFuelSourceInDetailsTab method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011412";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			flag = BuildingPage.Water_ValidateTypeUnitFuelSourceInDetailsTab();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Water_ValidateTypeUnitFuelSourceInDetailsTab method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Water_ValidateTypeUnitFuelSourceInDetailsTab method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings--> Water --> Verify if Start date is greater than end
	// date, gives Overlapping dates error.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_Water_ValidateTypeUnitFuelSourceInDetailsTab", priority = 537, enabled = true, description = "Building Settings--> Water -->Verify if Start date is greater than end date, gives Overlapping dates error..")
	public void Buildings_Water_CheckOverlappingDates() {

		log.info("Buildings_Water_CheckOverlappingDates method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011412";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			flag = BuildingPage.Water_ValidateOverlappingDate();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Water_CheckOverlappingDates method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Water_CheckOverlappingDates method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings--> Water --> Verify Clicking on add row allows to add
	// start date,end date, reading, cost and documents.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_Water_ValidateTypeUnitFuelSourceInDetailsTab", priority = 538, enabled = true, description = "Building Settings--> Water --> Verify Clicking on add row allows to add start date,end date, reading, cost and documents.")
	public void Buildings_Water_AddRecord() {

		log.info("Buildings_Water_AddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011412";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			flag = BuildingPage.Water_AddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Water_AddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Water_AddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings--> Water --> Validate documents added in the row item are
	// displayed under Documents tab.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_Water_AddRecord", priority = 538, enabled = true, description = "Building Settings--> Water -->Validate documents added in the row item are displayed under Documents tab.")
	public void Buildings_Water_ValidateDocument() {

		log.info("Buildings_Water_ValidateDocument method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011428";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			flag = BuildingPage.Water_ValidateDocument();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Water_ValidateDocument method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Water_ValidateDocument method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings--> Water --> Verify Water score gets generated if valid
	// Water data is added and building settings is present for the project.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_Water_AddRecord", priority = 538, enabled = true, description = "Building Settings--> Water -->Verify Water score gets generated if valid Water data is added and building settings is present for the project.")
	public void Buildings_Water_CheckScore() {

		log.info("Buildings_Water_CheckScore method started......................... ");
		int Score = 0;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011389";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			Score = BuildingPage.getWaterScore();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (Score > 0) {
			log.info("Buildings_Water_CheckScore method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Water_CheckScore method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings--> Water --> Verify Delete button allows you to delete
	// line item.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 539, enabled = false, description = "Building Settings--> Water --> Verify Delete button allows you to delete line item.")
	public void Buildings_Water_DeleteRow() {

		log.info("Buildings_Water_DeleteRow method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011389";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			flag = BuildingPage.Water_DeleteRow();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Water_DeleteRow method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Water_DeleteRow method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings--> Waste --> Verify if Start date is greater than end
	// date, gives Overlapping dates error.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 545, enabled = true, description = "Building Settings--> Waste  -->  Verify if Start date is greater than end date, gives Overlapping dates error.")
	public void Buildings_Waste_CheckOverlappingDates() {

		log.info("Buildings_Waste_CheckOverlappingDates method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011412";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnWaste_Data();
			flag = BuildingPage.WasteData_ValidateOverlappingDate();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Waste_CheckOverlappingDates method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Waste_CheckOverlappingDates method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Building Settings--> Waste --> Verify Clicking on add row allows to add
	// with Diverted value greater than Generated Value

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 546, enabled = true, description = "Building Settings--> Waste  --> Verify Clicking on add row allows to add  start date,end date, Generated, Diverted, Units, Source and documents.")
	public void Buildings_Waste_CheckValidation_DivertedValueGenerated() {

		log.info("Buildings_Waste_CheckValidation_DivertedValueGenerated method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011412";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnWaste_Data();
			flag = BuildingPage.WasteData_CheckValidation_DivertedValueGenerated();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Waste_CheckValidation_DivertedValueGenerated method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Waste_CheckValidation_DivertedValueGenerated method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings--> Waste --> Verify Clicking on add row allows to add
	// start date,end date, Generated, Diverted, Units, Source and documents.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 547, enabled = true, description = "Building Settings--> Waste  --> Verify Clicking on add row allows to add  start date,end date, Generated, Diverted, Units")
	public void Buildings_Waste_AddRecord() {

		log.info("Buildings_Waste_AddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011412";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnWaste_Data();
			flag = BuildingPage.WasteData_AddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Waste_AddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Waste_AddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings--> Waste --> Validate documents added in the row item are
	// displayed under Documents tab.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_Waste_AddRecord", priority = 548, enabled = true, description = "Building Settings--> Water -->Validate documents added in the row item are displayed under Documents tab.")
	public void Buildings_Waste_ValidateDocument() {

		log.info("Buildings_Waste_ValidateDocument method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011428";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			flag = BuildingPage.Waste_ValidateDocument();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Waste_ValidateDocument method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Waste_ValidateDocument method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building Settings--> Waste --> Verify Water score gets generated if valid
	// Water data is added and building settings is present for the project.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_Water_AddRecord", priority = 550, enabled = true, description = "Building Settings--> Waste -->Verify Waste score gets generated if valid Waste data is added and building settings is present for the project.")
	public void Buildings_Waste_CheckScore() {

		log.info("Buildings_Waste_CheckScore method started......................... ");
		int Score = 0;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011389";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			Score = BuildingPage.getWasteScore();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (Score > 0) {
			log.info("Buildings_Waste_CheckScore method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Waste_CheckScore method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	/// ************************************** Transportation
	/// ************************************************

	// Building -> Transportation -Verify "For your project X responses will
	// generate score" message is displayed below transport bar.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 559, enabled = true, description = "Building -> Transportation ->Verify \"For your project X responses will generate score\" message is displayed below transport bar..")
	public void Buildings_Transportation_CheckMessageBelowTransportBar() {

		log.info("Buildings_Transportation_CheckMessageBelowTransportBar method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011487";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			flag = BuildingPage.Transportation_CheckMessageBelowTransportBar();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Transportation_CheckMessageBelowTransportBar method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Transportation_CheckMessageBelowTransportBar method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Transportation Validate Survey Tools and Resources Dropdown- Copy
	// survey link allows to copy the survey in fourteen languages. The User should
	// see a copied text in Green.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 560, enabled = true, description = "Building -> Transportation Validate Survey Tools and Resources Dropdown- Copy survey link allows to copy the survey in fourteen languages. The User should see a copied text in Green.")
	public void Buildings_Transportation_CopySurveyLink() {

		log.info("Buildings_Transportation_CopySurveyLink method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011502";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			flag = BuildingPage.Transportation_CopySurveylink();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Transportation_CopySurveyLink method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Transportation_CopySurveyLink method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Transportation-> Open a new tab and paste the copied content from
	// above test case and fill the survey.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 561, dependsOnMethods = "Buildings_Transportation_CopySurveyLink", enabled = true, description = "Building -> Transportation -> Open a new tab and paste the copied content from above test case and fill the survey.")
	public void Buildings_Transportation_OpenSurveyLinkInNewTab() {

		log.info("Buildings_Transportation_OpenSurveyLinkInNewTab method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011959";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			flag = BuildingPage.Transportation_OpenSurveyLinkInNewTab();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Transportation_OpenSurveyLinkInNewTab method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Transportation_OpenSurveyLinkInNewTab method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Transportation-> Validate Survey Page- Survey shows project name
	// and address just below the Arc logo.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 562, dependsOnMethods = "Buildings_Transportation_OpenSurveyLinkInNewTab", enabled = true, description = "Building -> Transportation -> Validate Survey Page- Survey shows project name and address just below the Arc logo.")
	public void Buildings_Transportation_SurveyPage_ProjectNameAndAddress() {

		log.info("Buildings_Transportation_SurveyPage_ProjectNameAndAddress method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011502";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			String ProjectAddress = BuildingPage.getProjectAddress();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			flag = BuildingPage.Transportation_SurveyPage_ProjectNameAndAddress(ProjectAddress);
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info(
					"Buildings_Transportation_SurveyPage_ProjectNameAndAddress method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_Transportation_SurveyPage_ProjectNameAndAddress method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Transportation-> Validate clicking on Question 1. Route-1-Select
	// Travel method open up the section to add modes of transport.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 563, dependsOnMethods = "Buildings_Transportation_OpenSurveyLinkInNewTab", enabled = true, description = "Building -> Transportation -> Validate clicking on Question 1. Route-1-Select Travel method open up the section to add modes of transport.")
	public void Buildings_Transportation_ValidateRoute_1_Questions() {

		log.info("Buildings_Transportation_ValidateRoute_1_Questions method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011428";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			flag = BuildingPage.Transportation_ValidateRoute_1_Questions();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Transportation_ValidateRoute_1_Questions method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Transportation_ValidateRoute_1_Questions method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Transportation-> Validate Question-2, For Slider user gets the
	// option to select from Extremely Unsatisfied, Very Unsatisfied, the option in
	// Question 3 are changed to "We're sorry to hear that. Please select the
	// options below that significantly reduce your satisfaction:"

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 564, dependsOnMethods = "Buildings_Transportation_OpenSurveyLinkInNewTab", enabled = true, description = "Building -> Transportation -> Validate Question-2, For Slider user gets the option to select from Extremely Unsatisfied, Very Unsatisfied, the option in Question 3 are changed to \"We're sorry to hear that. Please select the options below that significantly reduce your satisfaction:\"")
	public void Buildings_Transportation_ValidateRoute_2_Questions() {

		log.info("Buildings_Transportation_ValidateRoute_2_Questions method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011428";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			flag = BuildingPage.Transportation_ValidateRoute_2_Questions();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Transportation_ValidateRoute_2_Questions method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Transportation_ValidateRoute_2_Questions method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Transportation-> Fill all the details and select "Extremely
	// Unsatisfied" and submit the survey.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_Transportation_OpenSurveyLinkInNewTab", priority = 565, enabled = false, description = "Building -> Transportation -> Fill all the details and select \"Extremely Unsatisfied\" and submit the survey.")
	public void Buildings_Transportation_SubmitSurveyWithExtremelyUnsatisfied() {

		log.info(
				"Buildings_Transportation_SubmitSurveyWithExtremelyUnsatisfied method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011428";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			flag = BuildingPage.Transportation_SubmitSurveyWithExtremelyUnsatisfied();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info(
					"Buildings_Transportation_SubmitSurveyWithExtremelyUnsatisfied method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_Transportation_SubmitSurveyWithExtremelyUnsatisfied method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Transportation-> Fill all the details and submit the survey with
	// each slider options.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_Transportation_OpenSurveyLinkInNewTab", priority = 567, enabled = true, description = "Building -> Transportation -> Fill all the details and submit the survey with each slider options.")
	public void Buildings_Transportation_SubmitSurveyWithEachSliderOptions() {

		log.info("Buildings_Transportation_SubmitSurveyWithEachSliderOptions method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Private2");
		// ProjectBuildingID="8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			flag = BuildingPage.Transportation_SubmitSurveyWithEachSliderOptions();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info(
					"Buildings_Transportation_SubmitSurveyWithEachSliderOptions method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_Transportation_SubmitSurveyWithEachSliderOptions method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Transportation-> Fill all the details and submit the survey with
	// 2 route details

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_Transportation_OpenSurveyLinkInNewTab", priority = 569, enabled = true, description = "Building -> Transportation -> Fill all the details and submit the survey with each slider options.")
	public void Buildings_Transportation_SubmitSurveyWith2Routes() {

		log.info("Buildings_Transportation_SubmitSurveyWith2Routes method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Private2");
		// ProjectBuildingID="8000011488";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			flag = BuildingPage.Transportation_SubmitSurveyWith2Routes();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Transportation_SubmitSurveyWith2Routes method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Transportation_SubmitSurveyWith2Routes method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Transportation-> Fill all the details and submit the survey with
	// each slider options.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_Transportation_OpenSurveyLinkInNewTab", priority = 569, enabled = false, description = "Building -> Transportation -> Fill all the details and submit the survey with each slider options.")
	public void Buildings_Transportation_SubmitSurveyInFrenchLanguage() {

		log.info("Buildings_Transportation_SubmitSurveyInFrenchLanguage method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011428";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			flag = BuildingPage.Transportation_SubmitSurveyInFrench();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Transportation_SubmitSurveyInFrenchLanguage method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Transportation_SubmitSurveyInFrenchLanguage method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Transportation-> Fill all the details and submit the survey with
	// each .

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_Transportation_OpenSurveyLinkInNewTab", priority = 571, enabled = true, description = "Building -> Transportation -> Fill all the details and submit the survey with each slider options.")
	public void Buildings_Transportation_SubmitSurveyAllLanguage() {

		log.info("Buildings_Transportation_SubmitSurveyAllLanguage method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			flag = BuildingPage.Transportation_SubmitSurveyInAllLanguage();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Transportation_SubmitSurveyAllLanguage method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Transportation_SubmitSurveyAllLanguage method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Transportation-> Export Survey Result exports all the submitted
	// survey.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_Transportation_SubmitSurveyAllLanguage", priority = 572, enabled = true, description = "Building -> Transportation ->  Export Survey Result exports all the submitted survey..")
	public void Buildings_Transportation_ExportSurveyResults() {

		log.info("Buildings_Transportation_ExportSurveyResults method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011471";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			flag = BuildingPage.Transportation_ExportSurveyResults();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Transportation_ExportSurveyResults method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Transportation_ExportSurveyResults method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Transportation-> Verify for the above test case- X is calculated
	// as = (Number of Response/total occupancy)*100

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 573, enabled = true, description = "Building -> Transportation -> Verify for the above test case- X is calculated as = (Number of Response/total occupancy)*100")
	public void Buildings_Transportation_ResponsePercentage() {

		log.info("Buildings_Transportation_ResponsePercentage method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011568";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			flag = BuildingPage.Transportation_ResponsePercentage();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Transportation_ResponsePercentage method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Transportation_ResponsePercentage method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE - Occupant Satisfaction Survey -> Validate in HE- Survey bar
	// shows the same percentage as transportation Survey bar.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 580, enabled = true, description = "Building -> HE - Occupant Satisfaction Survey -> Validate in HE-  Survey bar shows the same percentage as transportation Survey bar.")
	public void Buildings_HE_OccupantSurvey_CheckBarPercentage() {

		log.info("Buildings_HE_OccupantSurvey_CheckBarPercentage method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011487";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_OccupantSatisfactionSurvey();
			flag = BuildingPage.HE_OccupantSatisfactionSurvey_ResponsePercentage();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_OccupantSurvey_CheckBarPercentage method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_OccupantSurvey_CheckBarPercentage method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE - Occupant Satisfaction Survey -> Validate Survey Tools and
	// Resources Dropdown- Copy survey link allows to copy the survey in fourteen
	// languages. The User should see a copied text in Green.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 581, enabled = true, description = "Building -> HE - Occupant Satisfaction Survey -> Validate Survey Tools and Resources Dropdown- Copy survey link allows to copy the survey in fourteen languages. The User should see a copied text in Green.")
	public void Buildings_HE_OccupantSurvey_CopySurveyLink() {

		log.info("Buildings_HE_OccupantSurvey_CopySurveyLink method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011502";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_OccupantSatisfactionSurvey();
			flag = BuildingPage.HE_OccupantSurvey_CopySurveylink();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_OccupantSurvey_CopySurveyLink method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_OccupantSurvey_CopySurveyLink method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- Carbon Dioxide -> --> Verify if Start date is greater than
	// end
	// date, gives Overlapping dates error.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 582, enabled = true, description = "Building--> HE -CarbonDioxide -->Verify if Start date is greater than end date, gives Overlapping dates error..")
	public void Buildings_HE_CarbonDioxide_CheckOverlappingDates() {

		log.info("Buildings_HE_CarbonDioxide_CheckOverlappingDates method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000040530");
		// System.setProperty("BuildingProject_Test1_Name","Auto-Building-PNWUA");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_CarbonDioxide();
			flag = BuildingPage.HE_ValidateOverlappingDate();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_CarbonDioxide_CheckOverlappingDates method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_CarbonDioxide_CheckOverlappingDates method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Building -> HE- Carbon Dioxide -> Verify Clicking on add row allows to add
	// start date,end date, reading, and documents.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 583, enabled = true, description = "Building -> HE- Carbon Dioxide ->   Verify Clicking on add row allows to add start date,end date, reading, and documents.")
	public void Buildings_HE_CarbonDioxide_AddRecord() {

		log.info("Buildings_HE_CarbonDioxide_AddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_CarbonDioxide();
			flag = BuildingPage.HE_AddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_CarbonDioxide_AddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_CarbonDioxide_AddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- Carbon Dioxide -> --> Validate documents added in the row
	// item are
	// displayed under Documents tab.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_HE_CarbonDioxide_AddRecord", priority = 584, enabled = true, description = "Building -->HE- Carbon Dioxide -->Validate documents added in the row item are displayed under Documents tab.")
	public void Buildings_HE_CarbonDiOxide_ValidateDocument() {

		log.info("Buildings_HE_CarbonDiOxide_ValidateDocument method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011462";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_CarbonDioxide();
			flag = BuildingPage.HE_ValidateDocument("Carbon Dioxide");
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_CarbonDiOxide_ValidateDocument method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_CarbonDiOxide_ValidateDocument method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- Carbon Dioxide -> --> Verify Delete button allows you to
	// delete line item.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_HE_CarbonDioxide_AddRecord", priority = 585, enabled = true, description = "Building -->HE- Carbon Dioxide -->Verify Delete button allows you to delete line item..")
	public void Buildings_HE_CarbonDiOxide_DeleteRecord() {

		log.info("Buildings_HE_CarbonDiOxide_DeleteRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_CarbonDioxide();
			flag = BuildingPage.HE_DeleteRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_CarbonDiOxide_DeleteRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_CarbonDiOxide_DeleteRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- TVOC -> --> Verify if Start date is greater than end
	// date, gives Overlapping dates error.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 586, enabled = true, description = "Building --> TVOC -->Verify if Start date is greater than end date, gives Overlapping dates error..")
	public void Buildings_HE_TVOC_CheckOverlappingDates() {

		log.info("Buildings_HE_TVOC_CheckOverlappingDates method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_TVOC();
			flag = BuildingPage.HE_ValidateOverlappingDate();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_TVOC_CheckOverlappingDates method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_TVOC_CheckOverlappingDates method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Building -> HE- TVOC -> Verify Clicking on add row allows to add start
	// date,end date, reading, and documents.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 587, enabled = true, description = "Building -> HE- TVOC ->   Verify Clicking on add row allows to add start date,end date, reading, and documents.")
	public void Buildings_HE_TVOC_AddRecord() {

		log.info("Buildings_HE_TVOC_AddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_TVOC();
			flag = BuildingPage.HE_AddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_TVOC_AddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_TVOC_AddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- TVOC -> --> Validate documents added in the row item are
	// displayed under Documents tab.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_HE_TVOC_AddRecord", priority = 588, enabled = true, description = "Building -->HE- TVOC -->Validate documents added in the row item are displayed under Documents tab.")
	public void Buildings_HE_TVOC_ValidateDocument() {

		log.info("Buildings_HE_TVOC_ValidateDocument method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_TVOC();
			flag = BuildingPage.HE_ValidateDocument("Total Volatile Organic Compounds");
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_TVOC_ValidateDocument method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_TVOC_ValidateDocument method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- TVOC -> --> Verify Delete button allows you to delete line
	// item.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_HE_TVOC_AddRecord", priority = 589, enabled = true, description = "Building -->HE- TVOC -->Verify Delete button allows you to delete line item..")
	public void Buildings_HE_TVOC_DeleteRecord() {

		log.info("Buildings_HE_TVOC_DeleteRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_TVOC();
			flag = BuildingPage.HE_DeleteRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_TVOC_DeleteRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_TVOC_DeleteRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- PM2.5 -> --> Verify if Start date is greater than end
	// date, gives Overlapping dates error.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 590, enabled = true, description = "Building --> HE-- PM2.5 -->Verify if Start date is greater than end date, gives Overlapping dates error..")
	public void Buildings_HE_PM2_5_CheckOverlappingDates() {

		log.info("Buildings_HE_PM2_5_CheckOverlappingDates method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_PM2_5();
			flag = BuildingPage.HE_ValidateOverlappingDate();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_PM2_5_CheckOverlappingDates method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_PM2_5_CheckOverlappingDates method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Building -> HE- PM2.5 -> Verify Clicking on add row allows to add start
	// date,end date, reading, and documents.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 591, enabled = true, description = "Building -> HE- PM2.5 ->   Verify Clicking on add row allows to add start date,end date, reading, and documents.")
	public void Buildings_HE_PM2_5_AddRecord() {

		log.info("Buildings_HE_PM2_5_AddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_PM2_5();
			flag = BuildingPage.HE_AddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_PM2_5_AddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_PM2_5_AddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- PM2.5 -> --> Validate documents added in the row item are
	// displayed under Documents tab.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_HE_PM2_5_AddRecord", priority = 592, enabled = true, description = "Building -->HE- PM2.5 -->Validate documents added in the row item are displayed under Documents tab.")
	public void Buildings_HE_PM2_5_ValidateDocument() {

		log.info("Buildings_HE_PM2_5_ValidateDocument method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_PM2_5();
			flag = BuildingPage.HE_ValidateDocument("Atmospheric Particulate Matter (PM2.5)");
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_PM2_5_ValidateDocument method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_PM2_5_ValidateDocument method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- PM2.5 -> --> Verify Delete button allows you to delete line
	// item.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_HE_PM2_5_AddRecord", priority = 593, enabled = true, description = "Building -->HE- PM2.5 -->Verify Delete button allows you to delete line item..")
	public void Buildings_HE_PM2_5_DeleteRecord() {

		log.info("Buildings_HE_PM2_5_DeleteRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_PM2_5();
			flag = BuildingPage.HE_DeleteRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_PM2_5_DeleteRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_PM2_5_DeleteRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- Ozone -> --> Verify if Start date is greater than end
	// date, gives Overlapping dates error.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 595, enabled = true, description = "Building --> HE-Ozone -->Verify if Start date is greater than end date, gives Overlapping dates error..")
	public void Buildings_HE_Ozone_CheckOverlappingDates() {

		log.info("Buildings_HE_Ozone_CheckOverlappingDates method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_Ozone();
			flag = BuildingPage.HE_ValidateOverlappingDate();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Ozone_CheckOverlappingDates method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Ozone_CheckOverlappingDates method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Building -> HE- Ozone -> Verify Clicking on add row allows to add start
	// date,end date, reading, and documents.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 596, enabled = true, description = "Building -> HE- Ozone ->   Verify Clicking on add row allows to add start date,end date, reading, and documents.")
	public void Buildings_HE_Ozone_AddRecord() {

		log.info("Buildings_HE_Ozone_AddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_Ozone();
			flag = BuildingPage.HE_AddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Ozone_AddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Ozone_AddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- Ozone -> --> Validate documents added in the row item are
	// displayed under Documents tab.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_HE_Ozone_AddRecord", priority = 597, enabled = true, description = "Building -->HE-Ozone -->Validate documents added in the row item are displayed under Documents tab.")
	public void Buildings_HE_Ozone_ValidateDocument() {

		log.info("Buildings_HE_Ozone_ValidateDocument method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_Ozone();
			flag = BuildingPage.HE_ValidateDocument("Ozone");
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Ozone_ValidateDocument method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Ozone_ValidateDocument method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE-Ozone -> --> Verify Delete button allows you to delete line
	// item.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_HE_Ozone_AddRecord", priority = 598, enabled = true, description = "Building -->HE-Ozone -->Verify Delete button allows you to delete line item..")
	public void Buildings_HE_Ozone_DeleteRecord() {

		log.info("Buildings_HE_Ozone_DeleteRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_Ozone();
			flag = BuildingPage.HE_DeleteRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Ozone_DeleteRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Ozone_DeleteRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- CarbonMonoxide -> --> Verify if Start date is greater than
	// end
	// date, gives Overlapping dates error.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 600, enabled = true, description = "Building --> HE-CarbonMonoxide -->Verify if Start date is greater than end date, gives Overlapping dates error..")
	public void Buildings_HE_CarbonMonoxide_CheckOverlappingDates() {

		log.info("Buildings_HE_CarbonMonoxide_CheckOverlappingDates method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_CarbonMonoxide();
			flag = BuildingPage.HE_ValidateOverlappingDate();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_CarbonMonoxide_CheckOverlappingDates method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_CarbonMonoxide_CheckOverlappingDates method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Building -> HE- Carbon Monoxide -> Verify Clicking on add row allows to add
	// start
	// date,end date, reading, and documents.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 601, enabled = true, description = "Building -> HE- Carbon Monoxide ->   Verify Clicking on add row allows to add start date,end date, reading, and documents.")
	public void Buildings_HE_CarbonMonoxide_AddRecord() {

		log.info("Buildings_HE_CarbonMonoxide_AddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_CarbonMonoxide();
			flag = BuildingPage.HE_AddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_CarbonMonoxide_AddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_CarbonMonoxide_AddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- Carbon Monoxide -> --> Validate documents added in the row
	// item are
	// displayed under Documents tab.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_HE_CarbonMonoxide_AddRecord", priority = 602, enabled = true, description = "Building -->HE-Carbon Monoxide -->Validate documents added in the row item are displayed under Documents tab.")
	public void Buildings_HE_CarbonMonoxide_ValidateDocument() {

		log.info("Buildings_HE_CarbonMonoxide_ValidateDocument method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_CarbonMonoxide();
			flag = BuildingPage.HE_ValidateDocument("Carbon Monoxide");
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_CarbonMonoxide_ValidateDocument method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_CarbonMonoxide_ValidateDocument method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE-Carbon Monoxide -> --> Verify Delete button allows you to
	// delete line
	// item.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_HE_CarbonMonoxide_AddRecord", priority = 603, enabled = true, description = "Building -->HE-Ozone -->Verify Delete button allows you to delete line item..")
	public void Buildings_HE_CarbonMonoxide_DeleteRecord() {

		log.info("Buildings_HE_CarbonMonoxide_DeleteRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_CarbonMonoxide();
			flag = BuildingPage.HE_DeleteRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_CarbonMonoxide_DeleteRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_CarbonMonoxide_DeleteRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- Acetaldehyde -> --> Verify if Start date is greater than end
	// date, gives Overlapping dates error.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 604, enabled = true, description = "Building --> HE-Acetaldehyde -->Verify if Start date is greater than end date, gives Overlapping dates error..")
	public void Buildings_HE_Acetaldehyde_CheckOverlappingDates() {

		log.info("Buildings_HE_Acetaldehyde_CheckOverlappingDates method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_AcetalDehyde();
			flag = BuildingPage.HE_ValidateOverlappingDate();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Acetaldehyde_CheckOverlappingDates method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Acetaldehyde_CheckOverlappingDates method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Building -> HE- Acetaldehyde -> Verify Clicking on add row allows to add
	// start
	// date,end date, reading, and documents.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 605, enabled = true, description = "Building -> HE- Acetaldehyde ->   Verify Clicking on add row allows to add start date,end date, reading, and documents.")
	public void Buildings_HE_Acetaldehyde_AddRecord() {

		log.info("Buildings_HE_Acetaldehyde_AddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_AcetalDehyde();
			flag = BuildingPage.HE_AddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Acetaldehyde_AddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Acetaldehyde_AddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- Acetaldehyde -> --> Validate documents added in the row item
	// are
	// displayed under Documents tab.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_HE_Acetaldehyde_AddRecord", priority = 606, enabled = true, description = "Building -->HE-Acetaldehyde -->Validate documents added in the row item are displayed under Documents tab.")
	public void Buildings_HE_Acetaldehyde_ValidateDocument() {

		log.info("Buildings_HE_Acetaldehyde_ValidateDocument method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_AcetalDehyde();
			flag = BuildingPage.HE_ValidateDocument("Acetaldehyde");
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Acetaldehyde_ValidateDocument method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Acetaldehyde_ValidateDocument method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE-Acetaldehyde -> --> Verify Delete button allows you to delete
	// line
	// item.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_HE_Acetaldehyde_AddRecord", priority = 607, enabled = true, description = "Building -->HE-Acetaldehyde -->Verify Delete button allows you to delete line item..")
	public void Buildings_HE_Acetaldehyde_DeleteRecord() {

		log.info("Buildings_HE_Acetaldehyde_DeleteRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_AcetalDehyde();
			flag = BuildingPage.HE_DeleteRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Acetaldehyde_DeleteRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Acetaldehyde_DeleteRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- Benzene -> --> Verify if Start date is greater than end
	// date, gives Overlapping dates error.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 610, enabled = true, description = "Building --> HE-Benzene -->Verify if Start date is greater than end date, gives Overlapping dates error..")
	public void Buildings_HE_Benzene_CheckOverlappingDates() {

		log.info("Buildings_HE_Benzene_CheckOverlappingDates method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_Benzene();
			flag = BuildingPage.HE_ValidateOverlappingDate();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Benzene_CheckOverlappingDates method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Benzene_CheckOverlappingDates method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Building -> HE- Benzene -> Verify Clicking on add row allows to add start
	// date,end date, reading, and documents.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 611, enabled = true, description = "Building -> HE- Benzene ->   Verify Clicking on add row allows to add start date,end date, reading, and documents.")
	public void Buildings_HE_Benzene_AddRecord() {

		log.info("Buildings_HE_Benzene_AddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_Benzene();
			flag = BuildingPage.HE_AddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Benzene_AddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Benzene_AddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- Benzene -> --> Validate documents added in the row item are
	// displayed under Documents tab.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_HE_Benzene_AddRecord", priority = 612, enabled = true, description = "Building -->HE-Benzene -->Validate documents added in the row item are displayed under Documents tab.")
	public void Buildings_HE_Benzene_ValidateDocument() {

		log.info("Buildings_HE_Benzene_ValidateDocument method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_Benzene();
			flag = BuildingPage.HE_ValidateDocument("Benzene");
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Benzene_ValidateDocument method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Benzene_ValidateDocument method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE-Benzene -> --> Verify Delete button allows you to delete line
	// item.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_HE_Benzene_AddRecord", priority = 613, enabled = true, description = "Building -->HE-Benzene -->Verify Delete button allows you to delete line item..")
	public void Buildings_HE_Benzene_DeleteRecord() {

		log.info("Buildings_HE_Benzene_DeleteRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_Benzene();
			flag = BuildingPage.HE_DeleteRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Benzene_DeleteRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Benzene_DeleteRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- Styrene -> --> Verify if Start date is greater than end
	// date, gives Overlapping dates error.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 615, enabled = true, description = "Building --> HE-Styrene -->Verify if Start date is greater than end date, gives Overlapping dates error..")
	public void Buildings_HE_Styrene_CheckOverlappingDates() {

		log.info("Buildings_HE_Styrene_CheckOverlappingDates method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_Styrene();
			flag = BuildingPage.HE_ValidateOverlappingDate();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Styrene_CheckOverlappingDates method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Styrene_CheckOverlappingDates method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Building -> HE- Styrene -> Verify Clicking on add row allows to add start
	// date,end date, reading, and documents.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 616, enabled = true, description = "Building -> HE- Styrene ->   Verify Clicking on add row allows to add start date,end date, reading, and documents.")
	public void Buildings_HE_Styrene_AddRecord() {

		log.info("Buildings_HE_Styrene_AddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_Styrene();
			flag = BuildingPage.HE_AddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Styrene_AddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Styrene_AddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- Styrene -> --> Validate documents added in the row item are
	// displayed under Documents tab.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_HE_Styrene_AddRecord", priority = 617, enabled = true, description = "Building -->HE-Styrene -->Validate documents added in the row item are displayed under Documents tab.")
	public void Buildings_HE_Styrene_ValidateDocument() {

		log.info("Buildings_HE_Styrene_ValidateDocument method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_Styrene();
			flag = BuildingPage.HE_ValidateDocument("Styrene");
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Styrene_ValidateDocument method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Styrene_ValidateDocument method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE-Styrene -> --> Verify Delete button allows you to delete line
	// item.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_HE_Styrene_AddRecord", priority = 618, enabled = true, description = "Building -->HE-Styrene -->Verify Delete button allows you to delete line item..")
	public void Buildings_HE_Styrene_DeleteRecord() {

		log.info("Buildings_HE_Styrene_DeleteRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_Styrene();
			flag = BuildingPage.HE_DeleteRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Styrene_DeleteRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Styrene_DeleteRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- Toluene -> --> Verify if Start date is greater than end
	// date, gives Overlapping dates error.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 620, enabled = true, description = "Building --> HE-Toluene -->Verify if Start date is greater than end date, gives Overlapping dates error..")
	public void Buildings_HE_Toluene_CheckOverlappingDates() {

		log.info("Buildings_HE_Toluene_CheckOverlappingDates method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_Toluene();
			flag = BuildingPage.HE_ValidateOverlappingDate();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Toluene_CheckOverlappingDates method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Toluene_CheckOverlappingDates method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Building -> HE- Toluene -> Verify Clicking on add row allows to add start
	// date,end date, reading, and documents.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 621, enabled = true, description = "Building -> HE- Toluene ->   Verify Clicking on add row allows to add start date,end date, reading, and documents.")
	public void Buildings_HE_Toluene_AddRecord() {

		log.info("Buildings_HE_Toluene_AddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_Toluene();
			flag = BuildingPage.HE_AddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Toluene_AddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Toluene_AddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- Toluene -> --> Validate documents added in the row item are
	// displayed under Documents tab.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_HE_Toluene_AddRecord", priority = 622, enabled = true, description = "Building -->HE-Toluene -->Validate documents added in the row item are displayed under Documents tab.")
	public void Buildings_HE_Toluene_ValidateDocument() {

		log.info("Buildings_HE_Toluene_ValidateDocument method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_Toluene();
			flag = BuildingPage.HE_ValidateDocument("Toluene");
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Toluene_ValidateDocument method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Toluene_ValidateDocument method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE-Toluene -> --> Verify Delete button allows you to delete line
	// item.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_HE_Toluene_AddRecord", priority = 623, enabled = true, description = "Building -->HE-Toluene -->Verify Delete button allows you to delete line item..")
	public void Buildings_HE_Toluene_DeleteRecord() {

		log.info("Buildings_HE_Toluene_DeleteRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_Toluene();
			flag = BuildingPage.HE_DeleteRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Toluene_DeleteRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Toluene_DeleteRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- Naphthalene -> --> Verify if Start date is greater than end
	// date, gives Overlapping dates error.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 625, enabled = true, description = "Building --> HE-Naphthalene -->Verify if Start date is greater than end date, gives Overlapping dates error..")
	public void Buildings_HE_Naphthalene_CheckOverlappingDates() {

		log.info("Buildings_HE_Naphthalene_CheckOverlappingDates method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_Naphthalene();
			flag = BuildingPage.HE_ValidateOverlappingDate();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Naphthalene_CheckOverlappingDates method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Naphthalene_CheckOverlappingDates method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Building -> HE- Naphthalene -> Verify Clicking on add row allows to add start
	// date,end date, reading, and documents.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 626, enabled = true, description = "Building -> HE- Naphthalene ->   Verify Clicking on add row allows to add start date,end date, reading, and documents.")
	public void Buildings_HE_Naphthalene_AddRecord() {

		log.info("Buildings_HE_Naphthalene_AddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_Naphthalene();
			flag = BuildingPage.HE_AddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Naphthalene_AddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Naphthalene_AddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- Naphthalene -> --> Validate documents added in the row item
	// are
	// displayed under Documents tab.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_HE_Naphthalene_AddRecord", priority = 627, enabled = true, description = "Building -->HE-Naphthalene -->Validate documents added in the row item are displayed under Documents tab.")
	public void Buildings_HE_Naphthalene_ValidateDocument() {

		log.info("Buildings_HE_Naphthalene_ValidateDocument method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_Naphthalene();
			flag = BuildingPage.HE_ValidateDocument("Naphthalene");
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Naphthalene_ValidateDocument method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Naphthalene_ValidateDocument method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE-Naphthalene -> --> Verify Delete button allows you to delete
	// line
	// item.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_HE_Naphthalene_AddRecord", priority = 628, enabled = true, description = "Building -->HE-Naphthalene -->Verify Delete button allows you to delete line item..")
	public void Buildings_HE_Naphthalene_DeleteRecord() {

		log.info("Buildings_HE_Naphthalene_DeleteRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_Naphthalene();
			flag = BuildingPage.HE_DeleteRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Naphthalene_DeleteRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Naphthalene_DeleteRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- Dichlorobenzene -> --> Verify if Start date is greater than
	// end
	// date, gives Overlapping dates error.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 630, enabled = true, description = "Building --> HE-Dichlorobenzene -->Verify if Start date is greater than end date, gives Overlapping dates error..")
	public void Buildings_HE_Dichlorobenzene_CheckOverlappingDates() {

		log.info("Buildings_HE_Dichlorobenzene_CheckOverlappingDates method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_Dichlorobenzene();
			flag = BuildingPage.HE_ValidateOverlappingDate();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Dichlorobenzene_CheckOverlappingDates method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Dichlorobenzene_CheckOverlappingDates method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Building -> HE- Dichlorobenzene -> Verify Clicking on add row allows to add
	// start
	// date,end date, reading, and documents.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 631, enabled = true, description = "Building -> HE- Dichlorobenzene ->   Verify Clicking on add row allows to add start date,end date, reading, and documents.")
	public void Buildings_HE_Dichlorobenzene_AddRecord() {

		log.info("Buildings_HE_Dichlorobenzene_AddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_Dichlorobenzene();
			flag = BuildingPage.HE_AddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Dichlorobenzene_AddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Dichlorobenzene_AddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- Dichlorobenzene -> --> Validate documents added in the row
	// item are
	// displayed under Documents tab.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_HE_Dichlorobenzene_AddRecord", priority = 632, enabled = true, description = "Building -->HE-Dichlorobenzene -->Validate documents added in the row item are displayed under Documents tab.")
	public void Buildings_HE_Dichlorobenzene_ValidateDocument() {

		log.info("Buildings_HE_Dichlorobenzene_ValidateDocument method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_Dichlorobenzene();
			flag = BuildingPage.HE_ValidateDocument("Dichlorobenzene");
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Dichlorobenzene_ValidateDocument method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Dichlorobenzene_ValidateDocument method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE-Dichlorobenzene -> --> Verify Delete button allows you to
	// delete line
	// item.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_HE_Dichlorobenzene_AddRecord", priority = 633, enabled = true, description = "Building -->HE-Dichlorobenzene -->Verify Delete button allows you to delete line item..")
	public void Buildings_HE_Dichlorobenzene_DeleteRecord() {

		log.info("Buildings_HE_Dichlorobenzene_DeleteRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_Dichlorobenzene();
			flag = BuildingPage.HE_DeleteRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Dichlorobenzene_DeleteRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Dichlorobenzene_DeleteRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- Xylenes-total -> --> Verify if Start date is greater than end
	// date, gives Overlapping dates error.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 635, enabled = true, description = "Building --> HE-Xylenes-total -->Verify if Start date is greater than end date, gives Overlapping dates error..")
	public void Buildings_HE_XylenesTotal_CheckOverlappingDates() {

		log.info("Buildings_HE_XylenesTotal_CheckOverlappingDates method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_XyleneTotal();
			flag = BuildingPage.HE_ValidateOverlappingDate();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_XylenesTotal_CheckOverlappingDates method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_XylenesTotal_CheckOverlappingDates method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Building -> HE- Xylenes-total -> Verify Clicking on add row allows to add
	// start
	// date,end date, reading, and documents.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 636, enabled = true, description = "Building -> HE- Xylenes-total ->   Verify Clicking on add row allows to add start date,end date, reading, and documents.")
	public void Buildings_HE_XylenesTotal_AddRecord() {

		log.info("Buildings_HE_XylenesTotal_AddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_XyleneTotal();
			flag = BuildingPage.HE_AddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_XylenesTotal_AddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_XylenesTotal_AddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- Xylenes-total -> --> Validate documents added in the row item
	// are
	// displayed under Documents tab.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_HE_XylenesTotal_AddRecord", priority = 637, enabled = true, description = "Building -->HE-Xylenes-total -->Validate documents added in the row item are displayed under Documents tab.")
	public void Buildings_HE_XylenesTotal_ValidateDocument() {

		log.info("Buildings_HE_XylenesTotal_ValidateDocument method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_XyleneTotal();
			flag = BuildingPage.HE_ValidateDocument("Xylenes-total");
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_XylenesTotal_ValidateDocument method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_XylenesTotal_ValidateDocument method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE-Xylenes-total -> --> Verify Delete button allows you to delete
	// line
	// item.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_HE_XylenesTotal_AddRecord", priority = 638, enabled = true, description = "Building -->HE-Xylenes-total -->Verify Delete button allows you to delete line item..")
	public void Buildings_HE_XylenesTotal_DeleteRecord() {

		log.info("Buildings_HE_XylenesTotal_DeleteRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_XyleneTotal();
			flag = BuildingPage.HE_DeleteRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_XylenesTotal_DeleteRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_XylenesTotal_DeleteRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- Formaldehyde -> --> Verify if Start date is greater than end
	// date, gives Overlapping dates error.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 640, enabled = true, description = "Building --> HE-Formaldehyde -->Verify if Start date is greater than end date, gives Overlapping dates error..")
	public void Buildings_HE_Formaldehyde_CheckOverlappingDates() {

		log.info("Buildings_HE_Formaldehyde_CheckOverlappingDates method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_Formaldehyde();
			flag = BuildingPage.HE_ValidateOverlappingDate();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Formaldehyde_CheckOverlappingDates method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Formaldehyde_CheckOverlappingDates method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Building -> HE- Formaldehyde -> Verify Clicking on add row allows to add
	// start
	// date,end date, reading, and documents.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 641, enabled = true, description = "Building -> HE- Formaldehyde ->   Verify Clicking on add row allows to add start date,end date, reading, and documents.")
	public void Buildings_HE_Formaldehyde_AddRecord() {

		log.info("Buildings_HE_Formaldehyde_AddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_Formaldehyde();
			flag = BuildingPage.HE_AddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Formaldehyde_AddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Formaldehyde_AddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE- Formaldehyde -> --> Validate documents added in the row item
	// are
	// displayed under Documents tab.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_HE_Formaldehyde_AddRecord", priority = 642, enabled = true, description = "Building -->HE-Formaldehyde -->Validate documents added in the row item are displayed under Documents tab.")
	public void Buildings_HE_Formaldehyde_ValidateDocument() {

		log.info("Buildings_HE_Formaldehyde_ValidateDocument method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_Formaldehyde();
			flag = BuildingPage.HE_ValidateDocument("Formaldehyde");
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Formaldehyde_ValidateDocument method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Formaldehyde_ValidateDocument method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> HE-Formaldehyde -> --> Verify Delete button allows you to delete
	// line
	// item.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_HE_Formaldehyde_AddRecord", priority = 643, enabled = true, description = "Building -->HE-Formaldehyde -->Verify Delete button allows you to delete line item..")
	public void Buildings_HE_Formaldehyde_DeleteRecord() {

		log.info("Buildings_HE_Formaldehyde_DeleteRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011522";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnHE_Formaldehyde();
			flag = BuildingPage.HE_DeleteRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_HE_Formaldehyde_DeleteRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_HE_Formaldehyde_DeleteRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> --> Go to Survey Tools and Resources- Send
	// Survey- Copy link and paste it to another browser.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 650, enabled = true, description = "Re-Entry -->FMS -> Go to Survey Tools and Resources- Send Survey- Copy link and paste it to another browser..")
	public void Buildings_ReEntry_FMS_OpenSurveyLinkInNewTab() {

		log.info("Buildings_ReEntry_FMS_OpenSurveyLinkInNewTab method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011570";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_FMS();
			flag = BuildingPage.ReEntry_FMS_OpenSurveyLinkInNewTab();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_OpenSurveyLinkInNewTab method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_OpenSurveyLinkInNewTab method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> In F & M survey, If question 1 Is a specific
	// individual responsible for the development and implementation of infectious
	// disease control policies, plans, and procedures for this facility?" is
	// selected as Yes, gives option to upload file, paste link and Enter 'Contact
	// information'

	@Test(groups = {"BuildingsRegression","FMSSurvey"}, dependsOnGroups = "LoginMethodTCGroup", priority = 655, dependsOnMethods = "Buildings_ReEntry_FMS_OpenSurveyLinkInNewTab", enabled = true, description = "Re-Entry -->FMS ->In F & M survey, If question 1  Is a specific individual responsible for the development and implementation of infectious disease control policies, plans, and procedures for this facility?\" is selected as Yes, gives option to upload file, paste link and Enter 'Contact information'")
	public void Buildings_ReEntry_FMS_Question1_WithYesOption() {

		log.info("Buildings_ReEntry_FMS_Question1_WithYesOption method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000012104");
		// System.setProperty("BuildingProject_Test1_Name","Auto-Building-JHKAN");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011609";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			// BuildingPage.ClickOnMetersAndSurveyMenu();
			// BuildingPage.ClickOnReEntry_FMS();
			flag = BuildingPage.ReEntry_FMS_Question1_WithYesOption();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Question1_WithYesOption method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Question1_WithYesOption method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> In F & M survey, If question 1 Is a specific
	// individual responsible for the development and implementation of infectious
	// disease control policies, plans, and procedures for this facility?" is
	// selected as Yes, gives option to upload file, paste link and Enter 'Contact
	// information'

	@Test(groups =  {"BuildingsRegression","FMSSurvey"}, dependsOnGroups = "LoginMethodTCGroup", priority = 656, dependsOnMethods = "Buildings_ReEntry_FMS_OpenSurveyLinkInNewTab", enabled = true, description = "Re-Entry -->FMS ->In F & M survey, If question 1  Is a specific individual responsible for the development and implementation of infectious disease control policies, plans, and procedures for this facility?\" is selected as Yes, gives option to upload file, paste link and Enter 'Contact information'")
	public void Buildings_ReEntry_FMS_Question2_WithYesOption() {

		log.info("Buildings_ReEntry_FMS_Question2_WithYesOption method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011463";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			// BuildingPage.ClickOnMetersAndSurveyMenu();
			// BuildingPage.ClickOnReEntry_FMS();
			flag = BuildingPage.ReEntry_FMS_Question2_WithYesOption();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Question2_WithYesOption method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Question2_WithYesOption method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> In F & M survey, If 3. Are there processes or
	// mechanisms used by the individual or group to ensure accountability for
	// implementation and effectiveness of infection control strategies?" is
	// selected as Yes, Upload File, add link and Submit.

	@Test(groups =  {"BuildingsRegression","FMSSurvey"}, dependsOnGroups = "LoginMethodTCGroup", priority = 657, dependsOnMethods = "Buildings_ReEntry_FMS_OpenSurveyLinkInNewTab", enabled = true, description = "Building -> Re-Entry -->FMS -> In F & M survey, If 3. Are there processes or mechanisms used by the individual or group to ensure accountability for implementation and effectiveness of infection control strategies?\" is selected as Yes, Upload File, add link and Submit.")
	public void Buildings_ReEntry_FMS_Question3_WithYesOption() {

		log.info("Buildings_ReEntry_FMS_Question3_WithYesOption method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011463";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			// BuildingPage.ClickOnMetersAndSurveyMenu();
			// BuildingPage.ClickOnReEntry_FMS();
			flag = BuildingPage.ReEntry_FMS_Question3_WithYesOption();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Question3_WithYesOption method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Question3_WithYesOption method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> In F & M survey, If 4.Does the facility or
	// venue have infectious disease control policies, plans, and procedures?" Able
	// to select 'Yes', 'No' ,'Not Applicable' options successfully.

	@Test(groups =  {"BuildingsRegression","FMSSurvey"}, dependsOnGroups = "LoginMethodTCGroup", priority = 658, dependsOnMethods = "Buildings_ReEntry_FMS_OpenSurveyLinkInNewTab", enabled = true, description = "Building -> Re-Entry -->FMS -> In F & M survey, If 4.Does the facility or venue have infectious disease control policies, plans, and procedures?\" Able to select 'Yes', 'No' ,'Not Applicable' options successfully.")
	public void Buildings_ReEntry_FMS_Question4_WithYes_NO_NA_Option() {

		log.info("Buildings_ReEntry_FMS_Question4_WithYes_NO_NA_Option method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011611";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			// BuildingPage.ClickOnMetersAndSurveyMenu();
			// BuildingPage.ClickOnReEntry_FMS();
			flag = BuildingPage.ReEntry_FMS_Question4_WithYes_NO_NA_Option();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Question4_WithYes_NO_NA_Option method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Question4_WithYes_NO_NA_Option method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> Verify 'CDC guideline' redirects to the
	// following link- "https://stg.app.arconline.io/assets/pdf/CDC%20Guidance.pdf"

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 659, dependsOnMethods = "Buildings_ReEntry_FMS_OpenSurveyLinkInNewTab", enabled = true, description = "Building -> Re-Entry -->FMS -> Verify 'CDC guideline' redirects to the following link- \"https://stg.app.arconline.io/assets/pdf/CDC%20Guidance.pdf")
	public void Buildings_ReEntry_FMS_Question5_CheckCDC_GuideLine() {

		log.info("Buildings_ReEntry_FMS_Question5_CheckCDC_GuideLine method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011463";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			// BuildingPage.ClickOnMetersAndSurveyMenu();
			// BuildingPage.ClickOnReEntry_FMS();
			flag = BuildingPage.ReEntry_FMS_Question5_CheckCDC_GuideLine();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Question5_CheckCDC_GuideLine method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Question5_CheckCDC_GuideLine method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> Verify USGBC credits link redirects to
	// "https://www.usgbc.org/credits/safety-first-136-v4.1?return=/credits/Existing%20Buildings/v4.1"

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 660, dependsOnMethods = "Buildings_ReEntry_FMS_OpenSurveyLinkInNewTab", enabled = true, description = "Building -> Re-Entry -->FMS -> Verify USGBC credits link redirects to \"https://www.usgbc.org/credits/safety-first-136-v4.1?return=/credits/Existing%20Buildings/v4.1\"")
	public void Buildings_ReEntry_FMS_Question5_Check_USGBC_CreditLink() {

		log.info("Buildings_ReEntry_FMS_Question5_Check_USGBC_CreditLink method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011463";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			// BuildingPage.ClickOnMetersAndSurveyMenu();
			// BuildingPage.ClickOnReEntry_FMS();
			flag = BuildingPage.ReEntry_FMS_Question5_USGBC_CreditLink();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Question5_Check_USGBC_CreditLink method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Question5_Check_USGBC_CreditLink method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Building -> Re-Entry -->FMS -> In F & M survey, If "5. Are the policies,
	// plans, and procedures aligned with one of more authorities (e.g. government,
	// academic institution)?" is selected as Yes, upload file. enter url and
	// submit.

	@Test(groups =  {"BuildingsRegression","FMSSurvey"}, dependsOnGroups = "LoginMethodTCGroup", priority = 661, dependsOnMethods = "Buildings_ReEntry_FMS_OpenSurveyLinkInNewTab", enabled = true, description = "Building -> Re-Entry -->FMS -> In F & M survey, If \"5. Are the policies, plans, and procedures aligned with one of more authorities (e.g. government, academic institution)?\" is selected as Yes, upload file. enter url and submit.")
	public void Buildings_ReEntry_FMS_Question5_WithYesOption() {

		log.info("Buildings_ReEntry_FMS_Question5_WithYesOption method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011463";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			// BuildingPage.ClickOnMetersAndSurveyMenu();
			// BuildingPage.ClickOnReEntry_FMS();
			flag = BuildingPage.ReEntry_FMS_Question5_WithYesOption();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Question5_WithYesOption method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Question5_WithYesOption method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> In F & M survey, If "6. Do the infection
	// control plans or policies for this facility include:" is selected as Yes,
	// upload file. enter url and
	// submit.

	@Test(groups =  {"BuildingsRegression","FMSSurvey"}, dependsOnGroups = "LoginMethodTCGroup", priority = 662, dependsOnMethods = "Buildings_ReEntry_FMS_OpenSurveyLinkInNewTab", enabled = true, description = "Building -> Re-Entry -->FMS -> In F & M survey, If \"6. Do the infection control plans or policies for this facility include:\" is selected as Yes, upload file. enter url and submit.")
	public void Buildings_ReEntry_FMS_Question6_WithYesOption() {

		log.info("Buildings_ReEntry_FMS_Question6_WithYesOption method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011463";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			// BuildingPage.ClickOnMetersAndSurveyMenu();
			// BuildingPage.ClickOnReEntry_FMS();
			flag = BuildingPage.ReEntry_FMS_Question6_WithYesOption();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Question6_WithYesOption method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Question6_WithYesOption method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> In F & M survey, If "Hand washing and
	// disinfection to address disease transmission (e.g. Safety First: Green
	// Cleaning)" is selected as Yes, upload file. enter url and
	// submit.

	@Test(groups =  {"BuildingsRegression","FMSSurvey"}, dependsOnGroups = "LoginMethodTCGroup", priority = 663, dependsOnMethods = "Buildings_ReEntry_FMS_OpenSurveyLinkInNewTab", enabled = true, description = "Building -> Re-Entry -->FMS -> In F & M survey, If \"Hand washing and disinfection to address disease transmission (e.g. Safety First: Green Cleaning)\" is selected as Yes, upload file. enter url and submit.")
	public void Buildings_ReEntry_FMS_Question7_WithYesOption() {

		log.info("Buildings_ReEntry_FMS_Question7_WithYesOption method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011463";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			// BuildingPage.ClickOnMetersAndSurveyMenu();
			// BuildingPage.ClickOnReEntry_FMS();
			flag = BuildingPage.ReEntry_FMS_Question7_WithYesOption();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Question7_WithYesOption method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Question7_WithYesOption method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Building -> Re-Entry -->FMS -> In F & M survey, If "Providing PPE and
	// encouraging the proper use by facility management staff and contractors
	// (e.g., masks, gloves, etc.) is selected as Yes, upload file. enter url and
	// submit.

	@Test(groups =  {"BuildingsRegression","FMSSurvey"}, dependsOnGroups = "LoginMethodTCGroup", priority = 664, dependsOnMethods = "Buildings_ReEntry_FMS_OpenSurveyLinkInNewTab", enabled = true, description = "Building -> Re-Entry -->FMS -> In F & M survey, If \"Providing PPE and encouraging the proper use by facility management staff and contractors (e.g., masks, gloves, etc.)\" is selected as Yes, upload file. enter url and submit.")
	public void Buildings_ReEntry_FMS_Question8_WithYesOption() {

		log.info("Buildings_ReEntry_FMS_Question8_WithYesOption method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011463";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			// BuildingPage.ClickOnMetersAndSurveyMenu();
			// BuildingPage.ClickOnReEntry_FMS();
			flag = BuildingPage.ReEntry_FMS_Question8_WithYesOption();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Question8_WithYesOption method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Question8_WithYesOption method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> In F & M survey, If "Occupant screening (e.g.
	// symptom or temperature checks)" is selected as Yes, upload file. enter url
	// and
	// submit.

	@Test(groups =  {"BuildingsRegression","FMSSurvey"}, dependsOnGroups = "LoginMethodTCGroup", priority = 665, dependsOnMethods = "Buildings_ReEntry_FMS_OpenSurveyLinkInNewTab", enabled = true, description = "Building -> Re-Entry -->FMS -> In F & M survey, If \"Occupant screening (e.g. symptom or temperature checks)\" is selected as Yes, upload file. enter url and submit.")
	public void Buildings_ReEntry_FMS_Question9_WithYesOption() {

		log.info("Buildings_ReEntry_FMS_Question9_WithYesOption method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011463";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			// BuildingPage.ClickOnMetersAndSurveyMenu();
			// BuildingPage.ClickOnReEntry_FMS();
			flag = BuildingPage.ReEntry_FMS_Question9_WithYesOption();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Question9_WithYesOption method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Question9_WithYesOption method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> In F & M survey, If "Paid sick leave (facility
	// or venue staff, contractor)" is selected as Yes, gives the option checkbox-
	// 'Facility or Venue staff' & 'Contractors' and upload file. enter url and
	// submit.

	@Test(groups =  {"BuildingsRegression","FMSSurvey"}, dependsOnGroups = "LoginMethodTCGroup", priority = 666, dependsOnMethods = "Buildings_ReEntry_FMS_OpenSurveyLinkInNewTab", enabled = true, description = "Building -> Re-Entry -->FMS -> In F & M survey, If \"Paid sick leave (facility or venue staff, contractor)\" is selected as Yes, gives the option checkbox- 'Facility or Venue staff' &  'Contractors' and   upload file. enter url and submit.")
	public void Buildings_ReEntry_FMS_Question10_WithYesOption() {

		log.info("Buildings_ReEntry_FMS_Question10_WithYesOption method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011463";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			// BuildingPage.ClickOnMetersAndSurveyMenu();
			// BuildingPage.ClickOnReEntry_FMS();
			flag = BuildingPage.ReEntry_FMS_Question10_WithYesOption();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Question10_WithYesOption method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Question10_WithYesOption method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> In F & M survey, If "Health Insurance" is
	// selected as Yes, gives the option checkbox- 'Facility or Venue staff' &
	// 'Contractors' and upload file. enter url and
	// submit.

	@Test(groups =  {"BuildingsRegression","FMSSurvey"}, dependsOnGroups = "LoginMethodTCGroup", priority = 667, dependsOnMethods = "Buildings_ReEntry_FMS_OpenSurveyLinkInNewTab", enabled = true, description = "Building -> Re-Entry -->FMS -> In F & M survey, If \"Health Insurance\" is selected as Yes, gives the option checkbox- 'Facility or Venue staff' &  'Contractors' and   upload file. enter url and submit.")
	public void Buildings_ReEntry_FMS_Question11_WithYesOption() {

		log.info("Buildings_ReEntry_FMS_Question11_WithYesOption method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011463";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			// BuildingPage.ClickOnMetersAndSurveyMenu();
			// BuildingPage.ClickOnReEntry_FMS();
			flag = BuildingPage.ReEntry_FMS_Question11_WithYesOption();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Question11_WithYesOption method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Question11_WithYesOption method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> In F & M survey, If "Social distancing" is
	// selected as Yes and upload file. enter url and
	// submit.

	@Test(groups =  {"BuildingsRegression","FMSSurvey"}, dependsOnGroups = "LoginMethodTCGroup", priority = 668, dependsOnMethods = "Buildings_ReEntry_FMS_OpenSurveyLinkInNewTab", enabled = true, description = "Building -> Re-Entry -->FMS -> In F & M survey, If \"Social distancing\" is selected as Yes,  and  upload file. enter url and submit.")
	public void Buildings_ReEntry_FMS_Question12_WithYesOption() {

		log.info("Buildings_ReEntry_FMS_Question12_WithYesOption method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011463";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			// BuildingPage.ClickOnMetersAndSurveyMenu();
			// BuildingPage.ClickOnReEntry_FMS();
			flag = BuildingPage.ReEntry_FMS_Question12_WithYesOption();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Question12_WithYesOption method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Question12_WithYesOption method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> In F & M survey, If "HVAC System Operation" is
	// selected as Yes, and upload file. enter url and
	// submit.

	@Test(groups =  {"BuildingsRegression","FMSSurvey"}, dependsOnGroups = "LoginMethodTCGroup", priority = 669, dependsOnMethods = "Buildings_ReEntry_FMS_OpenSurveyLinkInNewTab", enabled = true, description = "Building -> Re-Entry -->FMS -> In F & M survey, If \"HVAC System Operation\" is selected as Yes,  and  upload file. enter url and submit.")
	public void Buildings_ReEntry_FMS_Question13_WithYesOption() {

		log.info("Buildings_ReEntry_FMS_Question13_WithYesOption method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011463";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			// BuildingPage.ClickOnMetersAndSurveyMenu();
			// BuildingPage.ClickOnReEntry_FMS();
			flag = BuildingPage.ReEntry_FMS_Question13_WithYesOption();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Question13_WithYesOption method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Question13_WithYesOption method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> In F & M survey, If "HVAC Increase Outdoor Air
	// Quality" is selected as Yes, and upload file. enter url and
	// submit.

	@Test(groups =  {"BuildingsRegression","FMSSurvey"}, dependsOnGroups = "LoginMethodTCGroup", priority = 670, dependsOnMethods = "Buildings_ReEntry_FMS_OpenSurveyLinkInNewTab", enabled = true, description = "Building -> Re-Entry -->FMS -> In F & M survey, If \"HVAC Increase Outdoor Air Quality\" is selected as Yes,  and  upload file. enter url and submit.")
	public void Buildings_ReEntry_FMS_Question14_WithYesOption() {

		log.info("Buildings_ReEntry_FMS_Question14_WithYesOption method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011463";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			// BuildingPage.ClickOnMetersAndSurveyMenu();
			// BuildingPage.ClickOnReEntry_FMS();
			flag = BuildingPage.ReEntry_FMS_Question14_WithYesOption();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Question14_WithYesOption method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Question14_WithYesOption method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> In F & M survey, If "HVAC Increase ventilation
	// rates" is selected as Yes, and upload file. enter url and
	// submit.

	@Test(groups =  {"BuildingsRegression","FMSSurvey"}, dependsOnGroups = "LoginMethodTCGroup", priority = 671, dependsOnMethods = "Buildings_ReEntry_FMS_OpenSurveyLinkInNewTab", enabled = true, description = "Building -> Re-Entry -->FMS -> In F & M survey, If \"HVAC Increase ventilation rates\" is selected as Yes,  and  upload file. enter url and submit.")
	public void Buildings_ReEntry_FMS_Question15_WithYesOption() {

		log.info("Buildings_ReEntry_FMS_Question15_WithYesOption method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011463";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			// BuildingPage.ClickOnMetersAndSurveyMenu();
			// BuildingPage.ClickOnReEntry_FMS();
			flag = BuildingPage.ReEntry_FMS_Question15_WithYesOption();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Question15_WithYesOption method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Question15_WithYesOption method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> In F & M survey, If "HVAC Enhance Filtration"
	// is selected as Yes, and upload file. enter url and
	// submit.

	@Test(groups =  {"BuildingsRegression","FMSSurvey"}, dependsOnGroups = "LoginMethodTCGroup", priority = 672, dependsOnMethods = "Buildings_ReEntry_FMS_OpenSurveyLinkInNewTab", enabled = true, description = "Building -> Re-Entry -->FMS -> In F & M survey, If \"HVAC Enhance Filtration\" is selected as Yes,  and  upload file. enter url and submit.")
	public void Buildings_ReEntry_FMS_Question16_WithYesOption() {

		log.info("Buildings_ReEntry_FMS_Question16_WithYesOption method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011463";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			// BuildingPage.ClickOnMetersAndSurveyMenu();
			// BuildingPage.ClickOnReEntry_FMS();
			flag = BuildingPage.ReEntry_FMS_Question16_WithYesOption();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Question16_WithYesOption method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Question16_WithYesOption method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> In F & M survey, If "Elevator management (e.g.
	// occupancy limits, targeted cleaning)?" is selected as Yes, and upload file.
	// enter url and
	// submit.

	@Test(groups =  {"BuildingsRegression","FMSSurvey"}, dependsOnGroups = "LoginMethodTCGroup", priority = 673, dependsOnMethods = "Buildings_ReEntry_FMS_OpenSurveyLinkInNewTab", enabled = true, description = "Building -> Re-Entry -->FMS -> In F & M survey, If \"Elevator management (e.g. occupancy limits, targeted cleaning)?\" is selected as Yes,  and  upload file. enter url and submit.")
	public void Buildings_ReEntry_FMS_Question17_WithYesOption() {

		log.info("Buildings_ReEntry_FMS_Question17_WithYesOption method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011463";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			// BuildingPage.ClickOnMetersAndSurveyMenu();
			// BuildingPage.ClickOnReEntry_FMS();
			flag = BuildingPage.ReEntry_FMS_Question17_WithYesOption();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Question17_WithYesOption method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Question17_WithYesOption method ends with false here ........... ");
			Assert.assertTrue(false);
		}

	}
	// Building -> Re-Entry -->FMS -> In F & M survey, If "Potable water system
	// management (e.g. flush out, testing)?" is selected as Yes, and upload file.
	// enter url and
	// submit.

	@Test(groups =  {"BuildingsRegression","FMSSurvey"}, dependsOnGroups = "LoginMethodTCGroup", priority = 674, dependsOnMethods = "Buildings_ReEntry_FMS_OpenSurveyLinkInNewTab", enabled = true, description = "Building -> Re-Entry -->FMS -> In F & M survey, If \"Potable water system management (e.g. flush out, testing)?\" is selected as Yes,  and  upload file. enter url and submit.")
	public void Buildings_ReEntry_FMS_Question18_WithYesOption() {

		log.info("Buildings_ReEntry_FMS_Question18_WithYesOption method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011463";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			// BuildingPage.ClickOnMetersAndSurveyMenu();
			// BuildingPage.ClickOnReEntry_FMS();
			flag = BuildingPage.ReEntry_FMS_Question18_WithYesOption();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Question18_WithYesOption method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Question18_WithYesOption method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> In F & M survey, If "IAQ assessment or
	// commissioning process focused on systems and procedures related to infection
	// control?" is selected as Yes, and upload file. enter url and
	// submit.

	@Test(groups =  {"BuildingsRegression","FMSSurvey"}, dependsOnGroups = "LoginMethodTCGroup", priority = 675, dependsOnMethods = "Buildings_ReEntry_FMS_OpenSurveyLinkInNewTab", enabled = true, description = "Building -> Re-Entry -->FMS -> In F & M survey, If \"IAQ assessment or commissioning process focused on systems and procedures related to infection control?\" is selected as Yes,  and  upload file. enter url and submit.")
	public void Buildings_ReEntry_FMS_Question19_WithYesOption() {

		log.info("Buildings_ReEntry_FMS_Question19_WithYesOption method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000012142");
		// System.setProperty("BuildingProject_Test1_Name","Auto-Building-UTCGJ");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011463";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			// BuildingPage.ClickOnMetersAndSurveyMenu();
			// BuildingPage.ClickOnReEntry_FMS();
			flag = BuildingPage.ReEntry_FMS_Question19_WithYesOption();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Question19_WithYesOption method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Question19_WithYesOption method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> Verify for 'facility and management Survey' -
	// Survey tools and resources- Export survey results downloads report
	// successfully.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 676, dependsOnMethods = "Buildings_ReEntry_FMS_OpenSurveyLinkInNewTab", enabled = true, description = " Building -> Re-Entry -->FMS ->  Verify for 'facility and management Survey' - Survey tools and resources- Export survey results  in excel successfully.")
	public void Buildings_ReEntry_FMS_ExportSurveyResult() {

		log.info("Buildings_ReEntry_FMS_ExportSurveyResult method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040359";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_FMS();
			flag = BuildingPage.ReEntry_FMS_ExportSurveyResults();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_ExportSurveyResult method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_ExportSurveyResult method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS - > Submit all questions with YES with
	// Upload/Link and check score. Expected Score - 100

	@Test(groups = "BuildingsRegression", dependsOnGroups = {"LoginMethodTCGroup","FMSSurvey"}, priority = 680, dependsOnMethods = "Buildings_ReEntry_FMS_OpenSurveyLinkInNewTab", enabled = true, description = "Building -> Re-Entry -->FMS - > Submit all questions with YES with Upload/Link and check score.   Expected Score - 100")
	public void Buildings_ReEntry_FMS_Score_Scenario1() {

		log.info("Buildings_ReEntry_FMS_Score_Scenario1 method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000012085";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnProjectTools_ReEntry();
			flag = BuildingPage.ReEntry_FMS_Score_Scenario1();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Score_Scenario1 method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Score_Scenario1 method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> Submit all questions with NO and check score.
	// Expected Score - 0

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 681, enabled = true, description = "Building -> Re-Entry -->FMS -> Submit all questions with NO and check score.   Expected Score - 0")
	public void Buildings_ReEntry_FMS_Score_Scenario2() {

		log.info("Buildings_ReEntry_FMS_Score_Scenario2 method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000012142");
		// System.setProperty("BuildingProject_Test1_Name","Auto-Building-UTCGJ");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000040359";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			// BuildingPage.ClickOnMetersAndSurveyMenu();
			// BuildingPage.ClickOnReEntry_FMS();
			flag = BuildingPage.ReEntry_FMS_Score_Scenario2();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Score_Scenario2 method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Score_Scenario2 method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> Verify for 'facility and management Survey' -
	// Survey tools and resources- Export survey results (All questions with NO
	// option) successfully..

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 681, dependsOnMethods = {
			"Buildings_ReEntry_FMS_OpenSurveyLinkInNewTab",
			"Buildings_ReEntry_FMS_Score_Scenario2" }, enabled = true, description = " Building -> Re-Entry -->FMS ->  Verify for 'facility and management Survey' - Survey tools and resources- Export survey results (All questions with NO option) in excel successfully..")
	public void Buildings_ReEntry_FMS_ExportSurveyResultWithNoOption() {

		log.info("Buildings_ReEntry_FMS_ExportSurveyResultWithNoOption method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000012104");
		// System.setProperty("BuildingProject_Test1_Name","Auto-Building-JHKAN");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000012104";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_FMS();
			flag = BuildingPage.ReEntry_FMS_ExportSurveyResults();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_ExportSurveyResultWithNoOption method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_ExportSurveyResultWithNoOption method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Building -> Re-Entry -->FMS -> Submit all questions with NA and check score.
	// Expected Score - 0

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 682, enabled = true, description = "Building -> Re-Entry -->FMS -> Submit all questions with NA and check score.   Expected Score - 0")
	public void Buildings_ReEntry_FMS_Score_Scenario3() {

		log.info("Buildings_ReEntry_FMS_Score_Scenario3 method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000012142");
		// System.setProperty("BuildingProject_Test1_Name","Auto-Building-UTCGJ");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000040359";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			// BuildingPage.ClickOnMetersAndSurveyMenu();
			// BuildingPage.ClickOnReEntry_FMS();
			flag = BuildingPage.ReEntry_FMS_Score_Scenario3();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Score_Scenario3 method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Score_Scenario3 method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> Submit all questions with YES without
	// Link/Upload and check score. Expected Score - 52

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 683, enabled = true, description = "Building -> Re-Entry -->FMS -> Submit all questions with YES without Link/Upload and check score.  Expected Score - 52")
	public void Buildings_ReEntry_FMS_Score_Scenario4() {

		log.info("Buildings_ReEntry_FMS_Score_Scenario4 method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000012142");
		// System.setProperty("BuildingProject_Test1_Name","Auto-Building-UTCGJ");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000012085";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			// BuildingPage.ClickOnMetersAndSurveyMenu();
			// BuildingPage.ClickOnReEntry_FMS();
			flag = BuildingPage.ReEntry_FMS_Score_Scenario4();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Score_Scenario4 method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Score_Scenario4 method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> Submit only 2nd and 3rd question with YES &
	// Upload/Link, Rest all question with NA. Expected Score - 0

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 684, enabled = true, description = "Building -> Re-Entry -->FMS -> Submit only 2nd and 3rd question with YES &  Upload/Link, Rest all question with NA.  Expected Score - 0")
	public void Buildings_ReEntry_FMS_Score_Scenario5() {

		log.info("Buildings_ReEntry_FMS_Score_Scenario5 method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000012142");
		// System.setProperty("BuildingProject_Test1_Name","Auto-Building-UTCGJ");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000012085";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			flag = BuildingPage.ReEntry_FMS_Score_Scenario5();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Score_Scenario5 method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Score_Scenario5 method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> Submit 1st question with YES & Upload/Link,
	// Rest all question with NA. Expected Score - 100

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 685, enabled = true, description = "Building -> Re-Entry -->FMS -> Submit 1st question with YES &  Upload/Link, Rest all question with NA.  Expected Score - 100")
	public void Buildings_ReEntry_FMS_Score_Scenario6() {

		log.info("Buildings_ReEntry_FMS_Score_Scenario6 method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011311";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			flag = BuildingPage.ReEntry_FMS_Score_Scenario6();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Score_Scenario6 method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Score_Scenario6 method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> Submit Question 1-10 with YES & Upload/Link,
	// question 11-19 with NA. Expected Score - 100

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 686, enabled = true, description = "Building -> Re-Entry -->FMS -> Submit Question 1-10 with YES &  Upload/Link, question 11-19 with NA.  Expected Score - 100")
	public void Buildings_ReEntry_FMS_Score_Scenario7() {

		log.info("Buildings_ReEntry_FMS_Score_Scenario7 method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011311";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			flag = BuildingPage.ReEntry_FMS_Score_Scenario7();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Score_Scenario7 method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Score_Scenario7 method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> Submit Question 1-10 with YES & Upload/Link,
	// question 11-19 with NO. Expected Score - 45

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 686, enabled = true, description = "Building -> Re-Entry -->FMS -> Submit Question 1-10 with YES &  Upload/Link, question 11-19 with NO.  Expected Score - 45")
	public void Buildings_ReEntry_FMS_Score_Scenario8() {

		log.info("Buildings_ReEntry_FMS_Score_Scenario8 method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011311";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			flag = BuildingPage.ReEntry_FMS_Score_Scenario8();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Score_Scenario8 method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Score_Scenario8 method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> Submit Question 1-10 with NO, question 11-15
	// with NA, question 16-19 with YES without Link/upload. Expected Score - 35

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 687, enabled = true, description = "Building -> Re-Entry -->FMS ->  Submit Question 1-10 with NO, question 11-15 with NA, question 16-19 with YES without Link/upload.  Expected Score - 35")
	public void Buildings_ReEntry_FMS_Score_Scenario9() {

		log.info("Buildings_ReEntry_FMS_Score_Scenario9 method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011312";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			flag = BuildingPage.ReEntry_FMS_Score_Scenario9();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Score_Scenario9 method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Score_Scenario9 method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->FMS -> Verify for 'facility and management Survey' -
	// Survey tools and resources- Clicking on 'Arc Re-entry guilde' downloads the
	// Arc Guide to Rentry.pdf file.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 688, enabled = true, description = "Building -> Re-Entry -->FMS -> Verify for 'facility and management Survey' - Survey tools and resources- Clicking on 'Arc Re-entry guilde' downloads the Arc Guide to Rentry.pdf file.")
	public void Buildings_ReEntry_FMS_Download_ArcGuideToReEntry() {

		log.info("Buildings_ReEntry_FMS_Download_ArcGuideToReEntry method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000040293");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000012104";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_FMS();
			flag = BuildingPage.ReEntry_FMS_DownloadArcGuideToReEntry();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_FMS_Download_ArcGuideToReEntry method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_FMS_Download_ArcGuideToReEntry method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Building -> Re-Entry -->Occupant Survey -> Verify able to select any
	// combination of Scope and Group, Add optional name field and copy Survey link-
	// paste to another tab, survey page loads successfully.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 690, enabled = true, description = "Building -> Re-Entry -->Occupant Survey -> Verify able to select any combination of Scope and Group,  Add optional  name field  and copy Survey link- paste to another tab, survey page loads successfully. ")
	public void Buildings_ReEntry_OccupantSurvey_OpenSurveyPageInNewTab() {

		log.info("Buildings_ReEntry_OccupantSurvey_OpenSurveyPageInNewTab method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000012106");
		// System.setProperty("BuildingProject_Test1_Name","Auto-Building-YYZYT");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000039885";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_OccupantSurvey();
			flag = BuildingPage.ReEntry_OccupantSurvey_OpenSurvey_NewTab("Common Space", "Management");
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_OccupantSurvey_OpenSurveyPageInNewTab method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_ReEntry_OccupantSurvey_OpenSurveyPageInNewTab method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->Occupant Survey -> Verify Survey page shows correct
	// project name and project address

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 691, dependsOnMethods = "Buildings_ReEntry_OccupantSurvey_OpenSurveyPageInNewTab", enabled = true, description = "Building -> Re-Entry -->Occupant Survey -> Verify Survey page shows correct project name and project address")
	public void Buildings_ReEntry_OccupantSurvey_CheckProjectAddress() {

		log.info("Buildings_ReEntry_OccupantSurvey_CheckProjectAddress method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000040263");
		// System.setProperty("BuildingProject_Test1_Name","Auto-Building-TIFTE");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000039886";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			// String ProjectAddress = BuildingPage.getProjectAddress();
			// String ProjectAddress=data.getCellData("ProjectRegistration", 3, 2);
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_OccupantSurvey();
			BuildingPage.ReEntry_OccupantSurvey_OpenSurvey_NewTab("Common Space", "Management");
			flag = BuildingPage.OccupantSurvey_SurveyPage_ProjectNameAndAddress();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_OccupantSurvey_CheckProjectAddress method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_OccupantSurvey_CheckProjectAddress method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->Occupant Survey -> Verify Survey page shows correct
	// project name and project address. Scope - 'Common', Group-'Management.

	@Test(groups = { "BuildingsRegression",
			"OccupantSurvey" }, dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_ReEntry_OccupantSurvey_OpenSurveyPageInNewTab", priority = 692, enabled = true, description = "Building -> Re-Entry -->Occupant Survey -> Verify Survey page shows correct project name and project address. Scope - 'Common', Group-'Management'.")
	public void Buildings_ReEntry_OccupantSurvey_Check_Common_Management() {

		log.info("Buildings_ReEntry_OccupantSurvey_Check_Common_Management method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000012143");
		// System.setProperty("BuildingProject_Test1_Name","Auto-Building-ESATJ");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011463";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_OccupantSurvey();
			BuildingPage.ReEntry_OccupantSurvey_OpenSurvey_NewTab("Common Space", "Management");
			BuildingPage.OccupantSurvey_SubmitSurveyWithCommonSpace_Management();
			flag = BuildingPage.OccupantSurveyVerify("Common", "Management", "Never");
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info(
					"Buildings_ReEntry_OccupantSurvey_Check_Common_Management method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_ReEntry_OccupantSurvey_Check_Common_Management method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->Occupant Survey -> Verify Survey page shows correct
	// project name and project address. Scope - 'Common', Group-'Tenant.

	@Test(groups = { "BuildingsRegression",
			"OccupantSurvey" }, dependsOnGroups = "LoginMethodTCGroup", priority = 693, dependsOnMethods = "Buildings_ReEntry_OccupantSurvey_OpenSurveyPageInNewTab", enabled = true, description = "Building -> Re-Entry -->Occupant Survey -> Verify Survey page shows correct project name and project address. Scope - 'Common', Group-'Tenant'.")
	public void Buildings_ReEntry_OccupantSurvey_Check_Common_Tenant() {

		log.info("Buildings_ReEntry_OccupantSurvey_Check_Common_Tenant method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1_Name","Auto-Building-RJNWI");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011463";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_OccupantSurvey();
			BuildingPage.ReEntry_OccupantSurvey_OpenSurvey_NewTab("Common Space", "Tenant");
			BuildingPage.OccupantSurvey_SubmitSurveyWithCommonSpace_Tenant();
			flag = BuildingPage.OccupantSurveyVerify("Common", "Tenant", "Rarely");
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_OccupantSurvey_Check_Common_Tenant method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_OccupantSurvey_Check_Common_Tenant method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->Occupant Survey -> Verify Survey page shows correct
	// project name and project address. Scope - 'Common', Group-'Visitor.

	@Test(groups = { "BuildingsRegression",
			"OccupantSurvey" }, dependsOnGroups = "LoginMethodTCGroup", priority = 694, dependsOnMethods = "Buildings_ReEntry_OccupantSurvey_OpenSurveyPageInNewTab", enabled = true, description = "Building -> Re-Entry -->Occupant Survey -> Verify Survey page shows correct project name and project address. Scope - 'Common', Group-'Visitor'.")
	public void Buildings_ReEntry_OccupantSurvey_Check_Common_Visitor() {

		log.info("Buildings_ReEntry_OccupantSurvey_Check_Common_Visitor method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1_Name","Auto-Building-RJNWI");
		// System.setProperty("BuildingProject_Test1","8000011609");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011463";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_OccupantSurvey();
			BuildingPage.ReEntry_OccupantSurvey_OpenSurvey_NewTab("Common Space", "Visitor");
			BuildingPage.OccupantSurvey_SubmitSurveyWithCommonSpace_Visitor();
			flag = BuildingPage.OccupantSurveyVerify("Common", "Visitor", "Sometimes");
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_OccupantSurvey_Check_Common_Visitor method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_OccupantSurvey_Check_Common_Visitor method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->Occupant Survey -> Verify Survey page shows correct
	// project name and project address. Scope - 'Tenant', Group-'Management.

	@Test(groups = { "BuildingsRegression",
			"OccupantSurvey" }, dependsOnGroups = "LoginMethodTCGroup", priority = 695, dependsOnMethods = "Buildings_ReEntry_OccupantSurvey_OpenSurveyPageInNewTab", enabled = true, description = "Building -> Re-Entry -->Occupant Survey -> Verify Survey page shows correct project name and project address. Scope - 'Tenant', Group-'Management'.")
	public void Buildings_ReEntry_OccupantSurvey_Check_Tenant_Management() {

		log.info("Buildings_ReEntry_OccupantSurvey_Check_Tenant_Management method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1_Name","Auto-Building-RJNWI");
		// System.setProperty("BuildingProject_Test1","8000040261");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011463";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_OccupantSurvey();
			BuildingPage.ReEntry_OccupantSurvey_OpenSurvey_NewTab("Tenant Space", "Management");
			BuildingPage.OccupantSurvey_SubmitSurveyWithTenantSpace_Management();
			flag = BuildingPage.OccupantSurveyVerify("Tenant", "Management", "Usually");
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info(
					"Buildings_ReEntry_OccupantSurvey_Check_Tenant_Management method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_ReEntry_OccupantSurvey_Check_Tenant_Management method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Building -> Re-Entry -->Occupant Survey -> Verify Survey page shows correct
	// project name and project address. Scope - 'Tenant', Group-'Tenant.

	@Test(groups = { "BuildingsRegression",
			"OccupantSurvey" }, dependsOnGroups = "LoginMethodTCGroup", priority = 696, dependsOnMethods = "Buildings_ReEntry_OccupantSurvey_OpenSurveyPageInNewTab", enabled = true, description = "Building -> Re-Entry -->Occupant Survey -> Verify Survey page shows correct project name and project address. Scope - 'Tenant', Group-'Tenant'.")
	public void Buildings_ReEntry_OccupantSurvey_Check_Tenant_Tenant() {

		log.info("Buildings_ReEntry_OccupantSurvey_Check_Tenant_Tenant method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000011959");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011463";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_OccupantSurvey();
			BuildingPage.ReEntry_OccupantSurvey_OpenSurvey_NewTab("Tenant Space", "Tenant");
			BuildingPage.OccupantSurvey_SubmitSurveyWithTenantSpace_Tenant();
			flag = BuildingPage.OccupantSurveyVerify("Tenant", "Tenant", "Always");
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_OccupantSurvey_Check_Tenant_Tenant method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_OccupantSurvey_Check_Tenant_Tenant method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->Occupant Survey -> Verify Survey page shows correct
	// project name and project address. Scope - 'Tenant', Group-'Visitor.

	@Test(groups = { "BuildingsRegression",
			"OccupantSurvey" }, dependsOnGroups = "LoginMethodTCGroup", priority = 697, dependsOnMethods = "Buildings_ReEntry_OccupantSurvey_OpenSurveyPageInNewTab", enabled = true, description = "Building -> Re-Entry -->Occupant Survey -> Verify Survey page shows correct project name and project address. Scope - 'Tenant', Group-'Visitor'.")
	public void Buildings_ReEntry_OccupantSurvey_Check_Tenant_Visitor() {

		log.info("Buildings_ReEntry_OccupantSurvey_Check_Tenant_Visitor method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000011959");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011463";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_OccupantSurvey();
			BuildingPage.ReEntry_OccupantSurvey_OpenSurvey_NewTab("Tenant Space", "Visitor");
			BuildingPage.OccupantSurvey_SubmitSurveyWithTenantSpace_Visitor();
			flag = BuildingPage.OccupantSurveyVerify("Tenant", "Visitor", "Rarely");
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_OccupantSurvey_Check_Tenant_Visitor method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_OccupantSurvey_Check_Tenant_Visitor method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->Occupant Survey -> Verify Survey page shows correct
	// project name and project address. Scope - 'Whole', Group-'Management.

	@Test(groups = { "BuildingsRegression",
			"OccupantSurvey" }, dependsOnGroups = "LoginMethodTCGroup", priority = 698, dependsOnMethods = "Buildings_ReEntry_OccupantSurvey_OpenSurveyPageInNewTab", enabled = true, description = "Building -> Re-Entry -->Occupant Survey -> Verify Survey page shows correct project name and project address. Scope - 'Whole', Group-'Management.")
	public void Buildings_ReEntry_OccupantSurvey_Check_Whole_Management() {

		log.info("Buildings_ReEntry_OccupantSurvey_Check_Whole_Management method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000011959");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011463";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_OccupantSurvey();
			BuildingPage.ReEntry_OccupantSurvey_OpenSurvey_NewTab("Whole Space", "Management");
			BuildingPage.OccupantSurvey_SubmitSurveyWithWholeSpace_Management();
			flag = BuildingPage.OccupantSurveyVerify("Whole", "Management", "Sometimes");
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_OccupantSurvey_Check_Whole_Management method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_ReEntry_OccupantSurvey_Check_Whole_Management method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->Occupant Survey -> Verify Survey page shows correct
	// project name and project address. Scope - 'Whole', Group-'Tenant.

	@Test(groups = { "BuildingsRegression",
			"OccupantSurvey" }, dependsOnGroups = "LoginMethodTCGroup", priority = 699, dependsOnMethods = "Buildings_ReEntry_OccupantSurvey_OpenSurveyPageInNewTab", enabled = true, description = "Building -> Re-Entry -->Occupant Survey -> Verify Survey page shows correct project name and project address. Scope - 'Whole', Group-'Tenant.")
	public void Buildings_ReEntry_OccupantSurvey_Check_Whole_Tenant() {

		log.info("Buildings_ReEntry_OccupantSurvey_Check_Whole_Tenant method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000011959");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011463";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_OccupantSurvey();
			BuildingPage.ReEntry_OccupantSurvey_OpenSurvey_NewTab("Whole Space", "Tenant");
			BuildingPage.OccupantSurvey_SubmitSurveyWithWholeSpace_Tenant();
			flag = BuildingPage.OccupantSurveyVerify("Whole", "Tenant", "Usually");
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_OccupantSurvey_Check_Whole_Tenant method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_OccupantSurvey_Check_Whole_Tenant method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->Occupant Survey -> Verify Survey page shows correct
	// project name and project address. Scope - 'Whole', Group-'Visitor.

	@Test(groups = { "BuildingsRegression",
			"OccupantSurvey" }, dependsOnGroups = "LoginMethodTCGroup", priority = 700, dependsOnMethods = "Buildings_ReEntry_OccupantSurvey_OpenSurveyPageInNewTab", enabled = true, description = "Building -> Re-Entry -->Occupant Survey -> Verify Survey page shows correct project name and project address. Scope - 'Whole', Group-'Visitor.")
	public void Buildings_ReEntry_OccupantSurvey_Check_Whole_Visitor() {

		log.info("Buildings_ReEntry_OccupantSurvey_Check_Whole_Visitor method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000011959");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID = "8000011463";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_OccupantSurvey();
			BuildingPage.ReEntry_OccupantSurvey_OpenSurvey_NewTab("Whole Space", "Visitor");
			BuildingPage.OccupantSurvey_SubmitSurveyWithWholeSpace_Visitor();
			flag = BuildingPage.OccupantSurveyVerify("Whole", "Visitor", "Always");
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_OccupantSurvey_Check_Whole_Visitor method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_OccupantSurvey_Check_Whole_Visitor method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->Occupant Survey -> Verify all slider questions i.e.
	// Ques 1,3,4,5,6,7,8,9 are required questions and if unanswered, user gets an
	// error message in red as - 'Required question. Use the slider to make a
	// selection'

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 701, enabled = true, description = "Building -> Re-Entry -->Occupant Survey -> Verify all slider questions i.e. Ques 1,3,4,5,6,7,8,9 are required questions and if unanswered, user gets an error message in red as -  'Required question. Use the slider to make a selection'")
	public void Buildings_ReEntry_Occupant_ValidationMessage() {

		log.info("Buildings_ReEntry_Occupant_ValidationMessage method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000012185");
		// System.setProperty("BuildingProject_Test1_Name","Auto-Building-YYZYT");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000012104";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_OccupantSurvey();
			BuildingPage.ReEntry_OccupantSurvey_OpenSurvey_NewTab("Whole Space", "Visitor");
			flag = BuildingPage.OccupantSurvey_CheckValidationMessage();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_Occupant_ValidationMessage method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_Occupant_ValidationMessage method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Building -> Re-Entry -->Occupant Survey -> Export Survey result and validate
	// the excel data.

	@Test(groups = "BuildingsRegression", dependsOnGroups = { "LoginMethodTCGroup",
			"OccupantSurvey" }, priority = 702, enabled = true, description = "Building -> Re-Entry -->Occupant Survey -> Export Survey result and validate the excel data.")
	public void Buildings_ReEntry_Occupant_ExportSurveyResult() {

		log.info("Buildings_ReEntry_Occupant_ExportSurveyResult method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000040527");
		// System.setProperty("BuildingProject_Test1_Name","Auto-Building-TPFAH");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040527";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_OccupantSurvey();
			flag = BuildingPage.ReEntry_Occupant_ExportSurveyResults();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_Occupant_ExportSurveyResult method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_Occupant_ExportSurveyResult method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->Relative Humidity -> Verify in Performance sub tab-
	// Investigate,Acceptable, Good lets you submit response based on logic that the
	// values in Investigate+Acceptable+good contribute to 100%.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 703, enabled = true, description = "Building -> Re-Entry -->Relative Humidity -> Verify in Performance sub tab- Investigate,Acceptable, Good lets you submit response based on logic that the values in Investigate+Acceptable+good contribute to 100%.")
	public void Buildings_ReEntry_RelativeHumadity_PerformanceAddRecord() {

		log.info("Buildings_ReEntry_RelativeHumadity_PerformanceAddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		//System.setProperty("BuildingProject_Test1", "8000040509");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040527";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_RelativeHumidity();
			flag = BuildingPage.ReEntry_PerformanceAddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_RelativeHumadity_PerformanceAddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_ReEntry_RelativeHumadity_PerformanceAddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->Relative Humidity ->Performance Tab-> Validate able
	// to upload documentation.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_ReEntry_RelativeHumadity_PerformanceAddRecord", priority = 704, enabled = true, description = "Building -> Re-Entry -->Relative Humidity ->Performance Tab-> Validate able to upload documentation.")
	public void Buildings_ReEntry_RelativeHumadity_PerformanceUploadDocument() {

		log.info(
				"Buildings_ReEntry_RelativeHumadity_PerformanceUploadDocument method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000040528");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040530";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_RelativeHumidity();
			flag = BuildingPage.ReEntry_UploadDocument();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info(
					"Buildings_ReEntry_RelativeHumadity_PerformanceUploadDocument method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_ReEntry_RelativeHumadity_PerformanceUploadDocument method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->Relative Humidity ->Spatial Coverage-> Validate in
	// Spatial coverage-able to add effective at and reading not greater than 100.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 705, enabled = true, description = "Building -> Re-Entry -->Relative Humidity ->Spatial Coverage-> Validate in Spatial coverage-able to add effective at and reading not greater than 100.")
	public void Buildings_ReEntry_RelativeHumadity_SpatialCoverage_ValidateReading() {

		log.info(
				"Buildings_ReEntry_RelativeHumadity_SpatialCoverage_ValidateReading method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040527";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_RelativeHumidity();
			BuildingPage.clickOnReEntrySpatialCoverageTab();
			flag = BuildingPage.SpatialCoverage_ValidateReading();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info(
					"Buildings_ReEntry_RelativeHumadity_SpatialCoverage_ValidateReading method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_ReEntry_RelativeHumadity_SpatialCoverage_ValidateReading method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->Relative Humidity -> Spatial Coverage -> Enter
	// Effective date, Reading and save the record.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 706, enabled = true, description = "Building -> Re-Entry -->Relative Humidity -> Spatial Coverage -> Enter Effective date, Reading and save the record.")
	public void Buildings_ReEntry_RelativeHumadity_SpatialCoverage_AddRecord() {

		log.info(
				"Buildings_ReEntry_RelativeHumadity_SpatialCoverage_AddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040530";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_RelativeHumidity();
			BuildingPage.clickOnReEntrySpatialCoverageTab();
			flag = BuildingPage.SpatialCoverageAddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info(
					"Buildings_ReEntry_RelativeHumadity_SpatialCoverage_AddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_ReEntry_RelativeHumadity_SpatialCoverage_AddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->Relative Humidity ->Temporal Coverage -> Validate in
	// Temporal coverage-able to add effective at and reading not greater than 100.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 707, enabled = true, description = "Building -> Re-Entry -->Relative Humidity ->Temporal Coverage -> Validate in Temporal coverage-able to add effective at and reading not greater than 100.")
	public void Buildings_ReEntry_RelativeHumadity_TemporalCoverage_ValidateReading() {

		log.info(
				"Buildings_ReEntry_RelativeHumadity_TemporalCoverage_ValidateReading method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040527";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_RelativeHumidity();
			BuildingPage.clickOnReEntryTemporalCoverageTab();
			flag = BuildingPage.TemporalCoverage_ValidateReading();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info(
					"Buildings_ReEntry_RelativeHumadity_TemporalCoverage_ValidateReading method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_ReEntry_RelativeHumadity_TemporalCoverage_ValidateReading method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->Relative Humidity ->Temporal Coverage-> Enter
	// Effective date, Reading and save the record.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 708, enabled = true, description = "Building -> Re-Entry -->Relative Humidity ->Temporal Coverage-> Enter Effective date, Reading and save the record.")
	public void Buildings_ReEntry_RelativeHumadity_TemporalCoverage_AddRecord() {

		log.info(
				"Buildings_ReEntry_RelativeHumadity_TemporalCoverage_AddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040530";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_RelativeHumidity();
			BuildingPage.clickOnReEntryTemporalCoverageTab();
			flag = BuildingPage.TemporalCoverageAddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info(
					"Buildings_ReEntry_RelativeHumadity_TemporalCoverage_AddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_ReEntry_RelativeHumadity_TemporalCoverage_AddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
//--- Re Entry Carbon Dioxide

	// Building -> Re-Entry -->Carbon Dioxide -> Verify in Performance sub tab-
	// Investigate,Acceptable, Good lets you submit response based on logic that the
	// values in Investigate+Acceptable+good contribute to 100%.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 710, enabled = true, description = "Building -> Re-Entry -->Carbon Dioxide -> Verify in Performance sub tab- Investigate,Acceptable, Good lets you submit response based on logic that the values in Investigate+Acceptable+good contribute to 100%.")
	public void Buildings_ReEntry_CarbonDioxide_PerformanceAddRecord() {

		log.info("Buildings_ReEntry_CarbonDioxide_PerformanceAddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000040528");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040527";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_CarbonDioxide();
			flag = BuildingPage.ReEntry_PerformanceAddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_CarbonDioxide_PerformanceAddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_CarbonDioxide_PerformanceAddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->Carbon Dioxide ->Spatial Coverage-> Validate in
	// Spatial coverage-able to add effective at and reading not greater than 100.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 711, enabled = true, description = "Building -> Re-Entry -->Carbon Dioxide ->Spatial Coverage-> Validate in Spatial coverage-able to add effective at and reading not greater than 100.")
	public void Buildings_ReEntry_CarbonDioxide_SpatialCoverage_ValidateReading() {

		log.info(
				"Buildings_ReEntry_CarbonDioxide_SpatialCoverage_ValidateReading method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040527";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_CarbonDioxide();
			BuildingPage.clickOnReEntrySpatialCoverageTab();
			flag = BuildingPage.SpatialCoverage_ValidateReading();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info(
					"Buildings_ReEntry_CarbonDioxide_SpatialCoverage_ValidateReading method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_ReEntry_CarbonDioxide_SpatialCoverage_ValidateReading method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->CarbonDioxide -> Spatial Coverage -> Enter Effective
	// date, Reading and save the record.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 712, enabled = true, description = "Building -> Re-Entry -->CarbonDioxide -> Spatial Coverage -> Enter Effective date, Reading and save the record.")
	public void Buildings_ReEntry_CarbonDioxide_SpatialCoverage_AddRecord() {

		log.info("Buildings_ReEntry_CarbonDioxide_SpatialCoverage_AddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040530";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_CarbonDioxide();
			BuildingPage.clickOnReEntrySpatialCoverageTab();
			flag = BuildingPage.SpatialCoverageAddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info(
					"Buildings_ReEntry_CarbonDioxide_SpatialCoverage_AddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_ReEntry_CarbonDioxide_SpatialCoverage_AddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->Carbon Dioxide ->Spatial Coverage Tab-> Validate able
	// to upload documentation.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_ReEntry_CarbonDioxide_SpatialCoverage_AddRecord", priority = 713, enabled = true, description = "Building -> Re-Entry -->Carbon Dioxide ->Spatial Coverage Tab-> Validate able to upload documentation.")
	public void Buildings_ReEntry_CarbonDioxide_SpatialCoverageUploadDocument() {

		log.info(
				"Buildings_ReEntry_CarbonDioxide_SpatialCoverageUploadDocument method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000040528");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040530";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_CarbonDioxide();
			BuildingPage.clickOnReEntrySpatialCoverageTab();
			flag = BuildingPage.ReEntry_UploadDocument();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info(
					"Buildings_ReEntry_CarbonDioxide_SpatialCoverageUploadDocument method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_ReEntry_CarbonDioxide_SpatialCoverageUploadDocument method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Building -> Re-Entry -->Carbon Dioxide ->Temporal Coverage -> Validate in
	// Temporal coverage-able to add effective at and reading not greater than 100.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 714, enabled = true, description = "Building -> Re-Entry -->Carbon Dioxide ->Temporal Coverage -> Validate in Temporal coverage-able to add effective at and reading not greater than 100.")
	public void Buildings_ReEntry_CarbonDioxide_TemporalCoverage_ValidateReading() {

		log.info(
				"Buildings_ReEntry_CarbonDioxide_TemporalCoverage_ValidateReading method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040527";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_CarbonDioxide();
			BuildingPage.clickOnReEntryTemporalCoverageTab();
			flag = BuildingPage.TemporalCoverage_ValidateReading();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info(
					"Buildings_ReEntry_CarbonDioxide_TemporalCoverage_ValidateReading method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_ReEntry_CarbonDioxide_TemporalCoverage_ValidateReading method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->Relative Humidity ->Temporal Coverage-> Enter
	// Effective date, Reading and save the record.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 715, enabled = true, description = "Building -> Re-Entry -->Relative Humidity ->Temporal Coverage-> Enter Effective date, Reading and save the record.")
	public void Buildings_ReEntry_CarbonDioxide_TemporalCoverage_AddRecord() {

		log.info("Buildings_ReEntry_CarbonDioxide_TemporalCoverage_AddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040530";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_CarbonDioxide();
			BuildingPage.clickOnReEntryTemporalCoverageTab();
			flag = BuildingPage.TemporalCoverageAddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info(
					"Buildings_ReEntry_CarbonDioxide_TemporalCoverage_AddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_ReEntry_CarbonDioxide_TemporalCoverage_AddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// --- Re Entry TVOC

	// Building -> Re-Entry -->TVOC -> Verify in Performance sub tab-
	// Investigate,Acceptable, Good lets you submit response based on logic that the
	// values in Investigate+Acceptable+good contribute to 100%.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 717, enabled = true, description = "Building -> Re-Entry -->TVOC -> Verify in Performance sub tab- Investigate,Acceptable, Good lets you submit response based on logic that the values in Investigate+Acceptable+good contribute to 100%.")
	public void Buildings_ReEntry_TVOC_PerformanceAddRecord() {

		log.info("Buildings_ReEntry_TVOC_PerformanceAddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000040528");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040527";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_TVOC();
			flag = BuildingPage.ReEntry_PerformanceAddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_TVOC_PerformanceAddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_TVOC_PerformanceAddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->TVOC ->Spatial Coverage-> Validate in
	// Spatial coverage-able to add effective at and reading not greater than 100.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 718, enabled = true, description = "Building -> Re-Entry -->TVOC ->Spatial Coverage-> Validate in Spatial coverage-able to add effective at and reading not greater than 100.")
	public void Buildings_ReEntry_TVOC_SpatialCoverage_ValidateReading() {

		log.info("Buildings_ReEntry_TVOC_SpatialCoverage_ValidateReading method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040527";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_TVOC();
			BuildingPage.clickOnReEntrySpatialCoverageTab();
			flag = BuildingPage.SpatialCoverage_ValidateReading();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_TVOC_SpatialCoverage_ValidateReading method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_TVOC_SpatialCoverage_ValidateReading method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->TVOC -> Spatial Coverage -> Enter Effective
	// date, Reading and save the record.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 719, enabled = true, description = "Building -> Re-Entry -->TVOC -> Spatial Coverage -> Enter Effective date, Reading and save the record.")
	public void Buildings_ReEntry_TVOC_SpatialCoverage_AddRecord() {

		log.info("Buildings_ReEntry_TVOC_SpatialCoverage_AddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040530";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_TVOC();
			BuildingPage.clickOnReEntrySpatialCoverageTab();
			flag = BuildingPage.SpatialCoverageAddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_TVOC_SpatialCoverage_AddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_TVOC_SpatialCoverage_AddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->TVOC ->Temporal Coverage -> Validate in
	// Temporal coverage-able to add effective at and reading not greater than 100.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 720, enabled = true, description = "Building -> Re-Entry -->TVOC ->Temporal Coverage -> Validate in Temporal coverage-able to add effective at and reading not greater than 100.")
	public void Buildings_ReEntry_TVOC_TemporalCoverage_ValidateReading() {

		log.info("Buildings_ReEntry_TVOC_TemporalCoverage_ValidateReading method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040527";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_TVOC();
			BuildingPage.clickOnReEntryTemporalCoverageTab();
			flag = BuildingPage.TemporalCoverage_ValidateReading();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_TVOC_TemporalCoverage_ValidateReading method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_ReEntry_TVOC_TemporalCoverage_ValidateReading method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->TVOC ->Temporal Coverage-> Enter
	// Effective date, Reading and save the record.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 721, enabled = true, description = "Building -> Re-Entry -->TVOC ->Temporal Coverage-> Enter Effective date, Reading and save the record.")
	public void Buildings_ReEntry_TVOC_TemporalCoverage_AddRecord() {

		log.info("Buildings_ReEntry_TVOC_TemporalCoverage_AddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040530";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_TVOC();
			BuildingPage.clickOnReEntryTemporalCoverageTab();
			flag = BuildingPage.TemporalCoverageAddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_TVOC_TemporalCoverage_AddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_TVOC_TemporalCoverage_AddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Building -> Re-Entry -->TVOC ->Temporal Coverage Tab-> Validate able
	// to upload documentation.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_ReEntry_TVOC_TemporalCoverage_AddRecord", priority = 722, enabled = true, description = "Building -> Re-Entry -->TVOC ->Temporal Coverage Tab-> Validate able to upload documentation.")
	public void Buildings_ReEntry_TVOC_TemporalCoverageUploadDocument() {

		log.info("Buildings_ReEntry_TVOC_TemporalCoverageUploadDocument method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000040528");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040530";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_TVOC();
			BuildingPage.clickOnReEntryTemporalCoverageTab();
			flag = BuildingPage.ReEntry_UploadDocument();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_TVOC_TemporalCoverageUploadDocument method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_TVOC_TemporalCoverageUploadDocument method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// --- Re Entry PM 1.0

	// Building -> Re-Entry -->PM 1.0 -> Verify in Performance sub tab-
	// Investigate,Acceptable, Good lets you submit response based on logic that the
	// values in Investigate+Acceptable+good contribute to 100%.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 723, enabled = true, description = "Building -> Re-Entry -->PM 1.0 -> Verify in Performance sub tab- Investigate,Acceptable, Good lets you submit response based on logic that the values in Investigate+Acceptable+good contribute to 100%.")
	public void Buildings_ReEntry_PM_1_0_PerformanceAddRecord() {

		log.info("Buildings_ReEntry_PM_1_0_PerformanceAddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000040528");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040527";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_PM_1_0();
			flag = BuildingPage.ReEntry_PerformanceAddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_PM_1_0_PerformanceAddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_PM_1_0_PerformanceAddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->PM 1.0 ->Spatial Coverage-> Validate in
	// Spatial coverage-able to add effective at and reading not greater than 100.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 724, enabled = true, description = "Building -> Re-Entry -->PM 1.0 ->Spatial Coverage-> Validate in Spatial coverage-able to add effective at and reading not greater than 100.")
	public void Buildings_ReEntry_PM_1_0_SpatialCoverage_ValidateReading() {

		log.info("Buildings_ReEntry_PM_1_0_SpatialCoverage_ValidateReading method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040527";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_PM_1_0();
			BuildingPage.clickOnReEntrySpatialCoverageTab();
			flag = BuildingPage.SpatialCoverage_ValidateReading();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info(
					"Buildings_ReEntry_PM_1_0_SpatialCoverage_ValidateReading method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_ReEntry_PM_1_0_SpatialCoverage_ValidateReading method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->PM 1.0 -> Spatial Coverage -> Enter Effective
	// date, Reading and save the record.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 725, enabled = true, description = "Building -> Re-Entry -->PM 1.0 -> Spatial Coverage -> Enter Effective date, Reading and save the record.")
	public void Buildings_ReEntry_PM_1_0_SpatialCoverage_AddRecord() {

		log.info("Buildings_ReEntry_PM_1_0_SpatialCoverage_AddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040530";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_PM_1_0();
			BuildingPage.clickOnReEntrySpatialCoverageTab();
			flag = BuildingPage.SpatialCoverageAddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_PM_1_0_SpatialCoverage_AddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_PM_1_0_SpatialCoverage_AddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->PM 1.0 ->Temporal Coverage -> Validate in
	// Temporal coverage-able to add effective at and reading not greater than 100.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 726, enabled = true, description = "Building -> Re-Entry -->PM 1.0 ->Temporal Coverage -> Validate in Temporal coverage-able to add effective at and reading not greater than 100.")
	public void Buildings_ReEntry_PM_1_0_TemporalCoverage_ValidateReading() {

		log.info("Buildings_ReEntry_PM_1_0_TemporalCoverage_ValidateReading method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040527";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_PM_1_0();
			BuildingPage.clickOnReEntryTemporalCoverageTab();
			flag = BuildingPage.TemporalCoverage_ValidateReading();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info(
					"Buildings_ReEntry_PM_1_0_TemporalCoverage_ValidateReading method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_ReEntry_PM_1_0_TemporalCoverage_ValidateReading method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->PM 1.0 ->Temporal Coverage-> Enter
	// Effective date, Reading and save the record.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 727, enabled = true, description = "Building -> Re-Entry -->PM 1.0 ->Temporal Coverage-> Enter Effective date, Reading and save the record.")
	public void Buildings_ReEntry_PM_1_0_TemporalCoverage_AddRecord() {

		log.info("Buildings_ReEntry_PM_1_0_TemporalCoverage_AddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040530";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_PM_1_0();
			BuildingPage.clickOnReEntryTemporalCoverageTab();
			flag = BuildingPage.TemporalCoverageAddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_PM_1_0_TemporalCoverage_AddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_PM_1_0_TemporalCoverage_AddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Building -> Re-Entry -->PM 1.0 ->Temporal Coverage Tab-> Validate able
	// to upload documentation.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_ReEntry_PM_1_0_TemporalCoverage_AddRecord", priority = 728, enabled = true, description = "Building -> Re-Entry -->TVOC ->Temporal Coverage Tab-> Validate able to upload documentation.")
	public void Buildings_ReEntry_PM_1_0_TemporalCoverageUploadDocument() {

		log.info("Buildings_ReEntry_PM_1_0_TemporalCoverageUploadDocument method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000040528");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040530";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_PM_1_0();
			BuildingPage.clickOnReEntryTemporalCoverageTab();
			flag = BuildingPage.ReEntry_UploadDocument();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_PM_1_0_TemporalCoverageUploadDocument method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_ReEntry_PM_1_0_TemporalCoverageUploadDocument method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// --- Re Entry PM 2.5

	// Building -> Re-Entry -->PM 2.5 -> Verify in Performance sub tab-
	// Investigate,Acceptable, Good lets you submit response based on logic that the
	// values in Investigate+Acceptable+good contribute to 100%.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 730, enabled = true, description = "Building -> Re-Entry -->PM 2.5 -> Verify in Performance sub tab- Investigate,Acceptable, Good lets you submit response based on logic that the values in Investigate+Acceptable+good contribute to 100%.")
	public void Buildings_ReEntry_PM_2_5_PerformanceAddRecord() {

		log.info("Buildings_ReEntry_PM_2_5_PerformanceAddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000040528");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040527";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_PM_2_5();
			flag = BuildingPage.ReEntry_PerformanceAddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_PM_2_5_PerformanceAddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_PM_2_5_PerformanceAddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->PM 2.5 ->Spatial Coverage-> Validate in
	// Spatial coverage-able to add effective at and reading not greater than 100.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 731, enabled = true, description = "Building -> Re-Entry -->PM 2.5 ->Spatial Coverage-> Validate in Spatial coverage-able to add effective at and reading not greater than 100.")
	public void Buildings_ReEntry_PM_2_5_SpatialCoverage_ValidateReading() {

		log.info("Buildings_ReEntry_PM_2_5_SpatialCoverage_ValidateReading method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040527";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_PM_2_5();
			BuildingPage.clickOnReEntrySpatialCoverageTab();
			flag = BuildingPage.SpatialCoverage_ValidateReading();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info(
					"Buildings_ReEntry_PM_2_5_SpatialCoverage_ValidateReading method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_ReEntry_PM_2_5_SpatialCoverage_ValidateReading method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->PM 2.5 -> Spatial Coverage -> Enter Effective
	// date, Reading and save the record.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 732, enabled = true, description = "Building -> Re-Entry -->PM 2.5 -> Spatial Coverage -> Enter Effective date, Reading and save the record.")
	public void Buildings_ReEntry_PM_2_5_SpatialCoverage_AddRecord() {

		log.info("Buildings_ReEntry_PM_2_5_SpatialCoverage_AddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040530";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_PM_2_5();
			BuildingPage.clickOnReEntrySpatialCoverageTab();
			flag = BuildingPage.SpatialCoverageAddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_PM_2_5_SpatialCoverage_AddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_PM_2_5_SpatialCoverage_AddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->PM 2.5 ->Temporal Coverage -> Validate in
	// Temporal coverage-able to add effective at and reading not greater than 100.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 733, enabled = true, description = "Building -> Re-Entry -->PM 2.5 ->Temporal Coverage -> Validate in Temporal coverage-able to add effective at and reading not greater than 100.")
	public void Buildings_ReEntry_PM_2_5_TemporalCoverage_ValidateReading() {

		log.info("Buildings_ReEntry_PM_2_5_TemporalCoverage_ValidateReading method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040527";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_PM_2_5();
			BuildingPage.clickOnReEntryTemporalCoverageTab();
			flag = BuildingPage.TemporalCoverage_ValidateReading();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info(
					"Buildings_ReEntry_PM_2_5_TemporalCoverage_ValidateReading method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_ReEntry_PM_2_5_TemporalCoverage_ValidateReading method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->PM 2.5 ->Temporal Coverage-> Enter
	// Effective date, Reading and save the record.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 734, enabled = true, description = "Building -> Re-Entry -->PM 2.5 ->Temporal Coverage-> Enter Effective date, Reading and save the record.")
	public void Buildings_ReEntry_PM_2_5_TemporalCoverage_AddRecord() {

		log.info("Buildings_ReEntry_PM_2_5_TemporalCoverage_AddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040530";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_PM_2_5();
			BuildingPage.clickOnReEntryTemporalCoverageTab();
			flag = BuildingPage.TemporalCoverageAddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_PM_2_5_TemporalCoverage_AddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_PM_2_5_TemporalCoverage_AddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Building -> Re-Entry -->PM 2.5 ->Temporal Coverage Tab-> Validate able
	// to upload documentation.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_ReEntry_PM_2_5_TemporalCoverage_AddRecord", priority = 735, enabled = true, description = "Building -> Re-Entry -->TVOC ->Temporal Coverage Tab-> Validate able to upload documentation.")
	public void Buildings_ReEntry_PM_2_5_TemporalCoverageUploadDocument() {

		log.info("Buildings_ReEntry_PM_2_5_TemporalCoverageUploadDocument method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000040528");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040530";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_PM_2_5();
			BuildingPage.clickOnReEntryTemporalCoverageTab();
			flag = BuildingPage.ReEntry_UploadDocument();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_PM_2_5_TemporalCoverageUploadDocument method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_ReEntry_PM_2_5_TemporalCoverageUploadDocument method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// --- Re Entry PM 10

	// Building -> Re-Entry -->PM 10 -> Verify in Performance sub tab-
	// Investigate,Acceptable, Good lets you submit response based on logic that the
	// values in Investigate+Acceptable+good contribute to 100%.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 736, enabled = true, description = "Building -> Re-Entry -->PM 10 -> Verify in Performance sub tab- Investigate,Acceptable, Good lets you submit response based on logic that the values in Investigate+Acceptable+good contribute to 100%.")
	public void Buildings_ReEntry_PM_10_PerformanceAddRecord() {

		log.info("Buildings_ReEntry_PM_10_PerformanceAddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000040528");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040527";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_PM_10();
			flag = BuildingPage.ReEntry_PerformanceAddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_PM_10_PerformanceAddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_PM_10_PerformanceAddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->PM 10 ->Spatial Coverage-> Validate in
	// Spatial coverage-able to add effective at and reading not greater than 100.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 737, enabled = true, description = "Building -> Re-Entry -->PM 10 ->Spatial Coverage-> Validate in Spatial coverage-able to add effective at and reading not greater than 100.")
	public void Buildings_ReEntry_PM_10_SpatialCoverage_ValidateReading() {

		log.info("Buildings_ReEntry_PM_10_SpatialCoverage_ValidateReading method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040527";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_PM_10();
			BuildingPage.clickOnReEntrySpatialCoverageTab();
			flag = BuildingPage.SpatialCoverage_ValidateReading();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_PM_10_SpatialCoverage_ValidateReading method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_ReEntry_PM_10_SpatialCoverage_ValidateReading method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->PM 10 -> Spatial Coverage -> Enter Effective
	// date, Reading and save the record.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 738, enabled = true, description = "Building -> Re-Entry -->PM 10 -> Spatial Coverage -> Enter Effective date, Reading and save the record.")
	public void Buildings_ReEntry_PM_10_SpatialCoverage_AddRecord() {

		log.info("Buildings_ReEntry_PM_10_SpatialCoverage_AddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040530";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_PM_10();
			BuildingPage.clickOnReEntrySpatialCoverageTab();
			flag = BuildingPage.SpatialCoverageAddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_PM_10_SpatialCoverage_AddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_PM_10_SpatialCoverage_AddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->PM 10 ->Temporal Coverage -> Validate in
	// Temporal coverage-able to add effective at and reading not greater than 100.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 739, enabled = true, description = "Building -> Re-Entry -->PM 10 ->Temporal Coverage -> Validate in Temporal coverage-able to add effective at and reading not greater than 100.")
	public void Buildings_ReEntry_PM_10_TemporalCoverage_ValidateReading() {

		log.info("Buildings_ReEntry_PM_10_TemporalCoverage_ValidateReading method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040527";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_PM_10();
			BuildingPage.clickOnReEntryTemporalCoverageTab();
			flag = BuildingPage.TemporalCoverage_ValidateReading();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info(
					"Buildings_ReEntry_PM_10_TemporalCoverage_ValidateReading method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"Buildings_ReEntry_PM_10_TemporalCoverage_ValidateReading method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Building -> Re-Entry -->PM 10 ->Temporal Coverage-> Enter
	// Effective date, Reading and save the record.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 740, enabled = true, description = "Building -> Re-Entry -->PM 10 ->Temporal Coverage-> Enter Effective date, Reading and save the record.")
	public void Buildings_ReEntry_PM_10_TemporalCoverage_AddRecord() {

		log.info("Buildings_ReEntry_PM_10_TemporalCoverage_AddRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040530";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_PM_10();
			BuildingPage.clickOnReEntryTemporalCoverageTab();
			flag = BuildingPage.TemporalCoverageAddRecord();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_PM_10_TemporalCoverage_AddRecord method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_PM_10_TemporalCoverage_AddRecord method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Building -> Re-Entry -->PM 10 ->Temporal Coverage Tab-> Validate able
	// to upload documentation.

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Buildings_ReEntry_PM_10_TemporalCoverage_AddRecord", priority = 741, enabled = true, description = "Building -> Re-Entry -->TVOC ->Temporal Coverage Tab-> Validate able to upload documentation.")
	public void Buildings_ReEntry_PM_10_TemporalCoverageUploadDocument() {

		log.info("Buildings_ReEntry_PM_10_TemporalCoverageUploadDocument method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_Test1","8000040528");
		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
		// ProjectBuildingID="8000040530";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.ClickOnReEntry_PM_10();
			BuildingPage.clickOnReEntryTemporalCoverageTab();
			flag = BuildingPage.ReEntry_UploadDocument();
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_ReEntry_PM_10_TemporalCoverageUploadDocument method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_ReEntry_PM_10_TemporalCoverageUploadDocument method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
	
	//-----------------------------------------------Performance Sections -------------------------------
	
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 0, enabled = false, description = "Building -> Re-Entry -->TVOC ->Temporal Coverage Tab-> Validate able to upload documentation.")
	public void Buildings_Performance_EnergyScoreTest() {

		log.info("Buildings_Performance_EnergyScoreTest method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_5","8000040528");
		String ProjectBuildingID = System.getProperty("BuildingProject_5");
		 ProjectBuildingID="8000040582";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.Energy_AddNewMeter("kWh","Purchased from Grid");
			BuildingPage.clickOnEnergyMeter();
			
			//BuildingPage.Energy_AddRecords("BaseLine", 2);
			BuildingPage.Energy_AddRecords("Performance", 16);
			
			//BuildingPage.Energy_AddRecords("BaseLine", 9);
			//BuildingPage.Energy_AddRecords("Performance", 5);
			//BuildingPage.ClickOnBuildingSetting();
			//BuildingPage.ClickOnBuildingSetting_GrossFloorAreaTab();
			
			//CommonMethod.switchToDefaultContent();
			//BuildingPage.ClickOnPerformanceMenu();
			flag=BuildingPage.Energy_ValidateImprovementScore();
			//BuildingPage.ClickOnPerformanceMenu();
		
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Performance_EnergyScoreTest method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Performance_EnergyScoreTest method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}
	
	
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 0, enabled = false, description = "Building -> Re-Entry -->TVOC ->Temporal Coverage Tab-> Validate able to upload documentation.")
	public void Buildings_Performance_WaterScoreTest() {

		log.info("Buildings_Performance_WaterScoreTest method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("BuildingProject_5","8000040528");
		String ProjectBuildingID = System.getProperty("BuildingProject_5");
		 ProjectBuildingID="8000040582";
		if (!ProjectBuildingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			BuildingPage = ProjectPage.SearchAndClickOnBuildingProject(ProjectBuildingID);
			HomePage.closeProjectSearchTextBox();
			BuildingPage.ClickOnMetersAndSurveyMenu();
			BuildingPage.Water_AddNewMeter("gal","Municipality supplied potable water");
			BuildingPage.clickOnWaterMeter();
			
			BuildingPage.Energy_AddRecords("BaseLine", 10);
			BuildingPage.Energy_AddRecords("Performance", 9);
			
			//BuildingPage.Energy_AddRecords("BaseLine", 9);
			//BuildingPage.Energy_AddRecords("Performance", 5);
			//BuildingPage.ClickOnBuildingSetting();
			//BuildingPage.ClickOnBuildingSetting_GrossFloorAreaTab();
			
			//CommonMethod.switchToDefaultContent();
			//BuildingPage.ClickOnPerformanceMenu();
			flag=BuildingPage.Energy_ValidateImprovementScore();
			//BuildingPage.ClickOnPerformanceMenu();
		
		} else {
			log.info("Building Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Buildings_Performance_WaterScoreTest method ends with true here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Performance_WaterScoreTest method ends with false here ........... ");
			Assert.assertTrue(false);
		}
	}

}