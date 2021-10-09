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

		log.info("Buildings_Overview_RHS_Last12Months_ARC_Score method started......................... ");
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
			flag = BuildingPage.CheckRHS_Last12Months_DateRange();
		}
		if (flag) {
			log.info("Buildings_Overview_RHS_Last12Months_ARC_Score method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Overview_RHS_Last12Months_ARC_Score method ends here ........... ");
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

		String ProjectBuildingID = System.getProperty("BuildingProject_Test1");
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
	public void Buildings_Overview_RHS_CustomeDateRange() {

		log.info("Buildings_Overview_RHS_CustomeDateRange method started......................... ");
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
			flag = BuildingPage.CheckRHS_CustomDateRange();
		}
		if (flag) {
			log.info("Buildings_Overview_RHS_CustomeDateRange method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_Overview_RHS_CustomeDateRange method ends here ........... ");
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
		// ProjectBuildingID = "8000011146";
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
		// ProjectBuildingID = "8000011146";
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

	// Verify clicking on 'Upload' button opens up with four options- 'Computer
	// File', 'Dropbox, OneDrive,Google Drive.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 469, enabled = true, description = "Verify clicking on 'Upload' button opens up with four options- 'Computer File', 'Dropbox, OneDrive,Google Drive. ")
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
		// ProjectBuildingID = "8000011056";
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

	// Verify Operating hours field by selecting hours from the dropdown.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 470, enabled = true, description = "Verify Operating hours field by selecting hours from the dropdown.")
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
		// ProjectBuildingID = "8000011055";
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

	// Building Settings-->Operating hours tab - >Verify filter and reset
	// functionalities.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 471, enabled = true, description = "Building Settings-->Operating hours tab ->Verify filter and reset functionalities.")
	public void Buildings_MeterSurvey_OperatingHours_CheckFilterAndReset() {
		log.info("Buildings_MeterSurvey_OperatingHours_CheckFilterAndReset method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Private2");
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

	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 472, enabled = true, description = " Building Settings-->Operating hours tab - > Verify comments and activity.")
	public void Buildings_MeterSurvey_OperatingHours_Comments_Activity() {

		log.info("Buildings_MeterSurvey_OperatingHours_Comments_Activity method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Private2");
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
		ProjectBuildingID = "8000011299";
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

	// Building Settings-->Operating hours tab - >Verify Unit field gives two
	// options- IP units(Square feet) and SI units(Square meters) to select from.
	@Test(groups = "BuildingsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 477, enabled = false, description = "Building Settings-->Operating hours tab ->Verify Unit field gives two options- IP units(Square feet) and SI units(Square meters) to select from.")
	public void Buildings_MeterSurvey_OperatingHours_CheckUnits() {
		log.info("Buildings_MeterSurvey_OperatingHours_CheckUnits method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectBuildingID = System.getProperty("BuildingProject_Private2");
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
			log.info("Buildings_MeterSurvey_OperatingHours_CheckUnits method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Buildings_MeterSurvey_OperatingHours_CheckUnits method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

}