package com.arc.testCases.Project;

import java.io.File;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.arc.PageObject.Project.CommunitiesPageObject;
import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class CommunitiesPageTest extends BaseClass {

	private static Logger log = LoggerHelper.getLogger(CommunitiesPageTest.class);

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, enabled = true, priority = 30, description = "Verify Manage-->Agreements should show the project agreement.")
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

	@Test(dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Agreement_Display", groups = {
			"Reboot" }, enabled = true, priority = 31, description = "Verify able to download the agreement successfully.")
	public void Communities_Agreement_Download() {
		log.info("Communities_Agreement_Download method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(data.getCellData("Reboot", 10, 2));
		CommunitiesPage.ClickonAgreementInManage();
		HomePage.closeProjectSearchTextBox();
		CommonMethod.ClikOnAgreementRegistrationDownloadLink();
		// BuildingPage.ClikOnAgreementDownloadLink();
		long FileLength = CommonMethod.CheckDownloadedFile();
		if (FileLength > 0) {
			CommonMethod.DeleteAllFiles();
			DownloadFolder.delete();
			log.info("Communities_Agreement_Download method completed ");
			Assert.assertTrue(FileLength > 0);
		} else {
			log.info("Communities_Agreement_Download method completed ");
			Assert.assertTrue(false);
		}

	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, enabled = true, priority = 32, description = "Verify if leed id project, able to download the registration invoice and receipt successfully from Manage-->Billing tab.")
	public void Community_LEEDIDProject_Download_Invoice() {

		log.info("Community_LEEDIDProject_Download_Invoice method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		System.out.println(data.getCellData("Reboot", 11, 2));
		CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(data.getCellData("Reboot", 11, 2));
		HomePage.closeProjectSearchTextBox();
		CommunitiesPage.ClickonBillingInManage();
		CommonMethod.ClikOnBillingDownloadForRegistrationLink();
		long FileLength = CommonMethod.CheckDownloadedFile();
		if (FileLength > 0) {
			for (File file : DownloadFolder.listFiles()) {
				file.delete();
			}
			DownloadFolder.delete();
			log.info("Community_LEEDIDProject_Download_Invoice method completed ");
			Assert.assertTrue(FileLength > 0);
		} else {
			for (File file : DownloadFolder.listFiles()) {
				file.delete();
			}
			DownloadFolder.delete();
			log.info("Community_LEEDIDProject_Download_Invoice method completed ");
			Assert.assertTrue(false);
		}
	}

	// Verify Manage-->Teams should show team members added to the project.

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, enabled = true, priority = 33, description = "Verify able to add a team-member successfully.")
	public void Community_Team_Add_Member() {

		log.info("Community_Team_Add_Member method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		log.info(data.getCellData("Reboot", 10, 2));
		CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(data.getCellData("Reboot", 10, 2));
		HomePage.closeProjectSearchTextBox();
		CommunitiesPage.ClickonTeamInManage();
		String username = data.getCellData("Reboot", 15, 2);
		boolean emailexist = CommonMethod.Team_checkEmailExistOrNot(username);
		log.info(username + "-----------existence is----" + emailexist);
		if (emailexist == false) {
			CommonMethod.Team_Add_Member(username);
			boolean UserNamePresent = CommonMethod.Team_checkEmailExistOrNot(username);
			if (UserNamePresent) {
				log.info(username + "  exists in the team member");
				log.info("Community_Team_Add_Member method completed .......................");
				Assert.assertTrue(true);
			} else {
				log.info(username + "  does not exist in the team member");
				log.info("Community_Team_Add_Member method completed .......................");
				Assert.assertTrue(false);
			}
		} else {
			log.info("First deleting the email and then will add the same email...");
			CommonMethod.Team_Delete_Member(username);
			CommonMethod.Team_Add_Member(username);
			boolean UserNamePresent = CommonMethod.Team_checkEmailExistOrNot(username);
			if (UserNamePresent) {
				log.info(username + "  exists in the team member");
				log.info("Community_Team_Add_Member method completed .......................");
				Assert.assertTrue(true);
			} else {
				log.info(username + "  does not exist in the team member");
				log.info("Community_Team_Add_Member method completed .......................");
				Assert.assertTrue(false);
			}
		}

	}

	// Verify Manage-->It should allow to delete member from the added list

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, dependsOnMethods = "Community_Team_Add_Member", enabled = true, priority = 34, description = "Verify able to remove a team-member successfully.")
	public void Community_Team_Delete_Member() {

		log.info("Community_Team_Delete_Member method started .......................");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		log.info(data.getCellData("Reboot", 10, 2));
		CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(data.getCellData("Reboot", 10, 2));
		HomePage.closeProjectSearchTextBox();
		CommunitiesPage.ClickonTeamInManage();
		String username = data.getCellData("Reboot", 15, 2);
		CommonMethod.Team_Delete_Member(username);
		boolean emailexist = CommonMethod.Team_checkEmailExistOrNot(username);
		if (!emailexist) {
			log.info(username + "  does not exist as team member");
			log.info("Community_Team_Delete_Member method completed.......................");
			Assert.assertTrue(true);
		} else {
			log.info(username + " still exist as team member");
			log.info("Community_Team_Delete_Member method completed.......................");
			Assert.assertTrue(false);
		}

	}

	// *************************Regression Test
	// Cases***********************************************

	// Verify in DI, Project settings - population tab- Add row button adds a new
	// line item with fields- 'Effective year', Population, Updated by followed by
	// Save and delete button

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 101, enabled = true, description = "Verify in DI, Project settings - population tab- Add row button adds a new line item with fields- 'Effective year', Population, Updated by followed by Save and delete button ")
	public void Community_ProjectSetting_Population_Add_Row() {

		log.info("Community_ProjectSetting_Population_Add_Row method started......................... ");
		// CommonMethod.switchToDefaultContent();
		// CommunitiesPage = new CommunitiesPageObject();
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004394";
		if (!ProjectCommunityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProjectSetting();
			flag = CommunitiesPage.checkPopulation_AddRow_Header_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			Assert.assertTrue(true);
			log.info("Community_ProjectSetting_Population_Add_Row method ends here ........... ");
		} else {
			log.info("Community_ProjectSetting_Population_Add_Row method ends here ........... ");
			Assert.assertTrue(false);

		}
	}

	// Verify in DI, Project settings - population tab- Save One row button
	// Verify Effective year opens up decade calendar and gives the option to select
	// any year.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 101, dependsOnMethods = "Community_ProjectSetting_Population_Add_Row", enabled = true, description = "Project Setting -> Population \r\n Verify in DI, Project settings - population tab- Save One row button \r\n"
			+ "		Verify Effective year opens up decade calendar and gives the option to select any year.")
	public void Community_ProjectSetting_Population_Save_Row_DecadeCalender_Display() {

		log.info(
				"Community_ProjectSetting_Population_Save_Row_DecadeCalender_Display method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Test1");
		// ProjectCommunityID="8000011510";
		if (!ProjectCommunityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProjectSetting();
			flag = CommunitiesPage.checkPopulation_Save_New_Row("1000");

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Community_ProjectSetting_Population_Save_Row_DecadeCalender_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_ProjectSetting_Population_Save_Row_DecadeCalender_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Population--- Verify Updated by shows the correct team-member/admin name.{To
	// check this, add any team-member in teams section and login using that team
	// member and add line item to this tab and check if his name s updated in
	// 'Updated by column }

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_ProjectSetting_Population_Save_Row_DecadeCalender_Display", priority = 102, enabled = true, description = "Project Setting -> population \r\n Verify Updated by shows the correct team-member/admin name.{To check this, add any team-member in teams section and login using that team member and add line item to this tab and chek if his name s updated in 'Updated by column ")
	public void Community_ProjectSetting_Population_UpdatedBy_Test() {

		log.info("Community_ProjectSetting_Population_UpdatedBy_Test method started......................... ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000006647";
		if (!ProjectCommunityID.equals(null)) {
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			CommunitiesPage.ClickonTeamInManage();
			HomePage.closeProjectSearchTextBox();
			String username = data.getCellData("Communities", 0, 2);
			boolean emailexist = CommonMethod.Team_checkEmailExistOrNot(username);
			System.out.println(username + "-----------existence is----" + emailexist);
			boolean flag = false;
			flag = CommonMethod.Team_Add_Member(username);
			if (flag) {
				log.info("Team Member added-----------------");
				HomePage.checkSignOut();
				HomePage = LoginPage.loginLater(data.getCellData("Communities", 0, 2), data.getCellData("Communities", 1, 2));
				boolean Updatedflag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				ProjectPage = HomePage.clickOnProject();
				CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
				HomePage.closeProjectSearchTextBox();
				String ProfileName=HomePage.getCurrentProfileUserName();
				CommunitiesPage.ClickonDataInput();
				CommonMethod.switchToDataInputFrame();
				CommunitiesPage.ClickonProjectSetting();
				boolean RecordAdded = CommunitiesPage.checkPopulation_Save_New_Row("1400");
				if (RecordAdded) {
					log.info("RecordAdded flag is true  --------------");
					Updatedflag = CommunitiesPage.checkPopulationUpdatedByUserName(ProfileName);
					CommonMethod.switchToDefaultContent();
					HomePage.checkSignOut();
					HomePage = LoginPage.loginLater(prop.getProperty("email"), prop.getProperty("password"));
					if (Updatedflag) {
						log.info(
								"Community_ProjectSetting_Population_UpdatedBy_Test method ends with true here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info(
								"Community_ProjectSetting_Population_UpdatedBy_Test method ends ends with false here ........... ");
						Assert.assertTrue(false);
					}
				} else {
					log.info("RecordAdded flag is false, Unable to add the record--------------");
					CommonMethod.switchToDefaultContent();
					HomePage.checkSignOut();
					HomePage = LoginPage.loginLater(prop.getProperty("email"), prop.getProperty("password"));
					log.info(
							"Community_ProjectSetting_Population_UpdatedBy_Test method ends ends with false here ........... ");
					Assert.assertTrue(false);
				}

			} else {
				log.info("Unable to add the team member.-----------------");
				log.info("Community_ProjectSetting_Population_UpdatedBy_Test method ends with false here ........... ");
				Assert.assertTrue(false);
			}

		}

		else {
			log.info("Community Project is showing Null");
			log.info("Community_ProjectSetting_Population_UpdatedBy_Test method ends with false here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Project Setting --> Population --> Verify 'Comments' section by adding
	// comment should show correct timestamp.
	// Project Setting --> Population -->Verify 'Activity' section should show
	// correct activity with date and
	// timestamp.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 103, enabled = true, description = "Project Setting --> Population -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void Community_ProjectSetting_Population_Comments_Activity_Test() {

		log.info("Community_ProjectSetting_Population_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004489";
		if (!ProjectCommunityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProjectSetting();

			flag = CommunitiesPage.checkPopulationCommentAndActivity(data.getCellData("Communities", 2, 2), ProfileUserName);

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Community_ProjectSetting_Population_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_ProjectSetting_Population_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify population field allows to add values followed by commas.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_ProjectSetting_Population_Save_Row_DecadeCalender_Display", priority = 104, enabled = true, description = "Verify population field allows to add values followed by commas.")
	public void Community_Population_Field_Comma_Display() {

		log.info("Community_Population_Field_Comma_Display method started......................... ");
		boolean flag = false;
		boolean Commaflag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Test1");
		// ProjectCommunityID="8000004341";
		if (!ProjectCommunityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProjectSetting();
			flag = CommunitiesPage.verifyAddedProject_Setting_PopulationRow();
		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			Commaflag = CommunitiesPage.verifyPopulationField_Contains_Comma();
			if (Commaflag) {
				log.info("Population field contains Comma");
				log.info("Community_Population_Field_Comma_Display method ends here ........... ");
				Assert.assertTrue(true);
			} else {
				log.info("Population field does not contains Comma");
				log.info("Community_Population_Field_Comma_Display method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Row is not added for this project, unable to check population field");
			log.info("Community_Population_Field_Comma_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Project Setting - > Population - > Verify filter button - From (Start date)
	// and To (End date) uopens up decade calendar and on selecting any year range,
	// the line items falling into those year should be displayed.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Community_ProjectSetting_Population_Save_Row_DecadeCalender_Display" }, priority = 104, enabled = true, description = "Project Setting - > Population - >Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed. ")
	public void Community_Population_Filter_Test() {

		log.info("Community_Population_Filter_Test method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Perf4");
		// ProjectCommunityID="8000011415";
		if (!ProjectCommunityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProjectSetting();
			flag = CommunitiesPage.CheckPopulationFilter();
		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Community_Population_Filter_Test method ends here ........... ");
			Assert.assertTrue(true);
		} else {
			log.info("Community_Population_Filter_Test method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Project Setting - > Population - > Verify delete button deletes the line item successfully.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Community_ProjectSetting_Population_Save_Row_DecadeCalender_Display" }, priority = 105, enabled = true, description = "Project Setting - > Population - > Verify delete button deletes the line item successfully. ")
	public void Community_Population_DeleteRecord() {

		log.info("Community_Population_DeleteRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Perf4");
		// ProjectCommunityID="8000011588";
		if (!ProjectCommunityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProjectSetting();
			flag = CommunitiesPage.CheckPopulationDeleteRow();
		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Community_Population_DeleteRecord method ends here ........... ");
			Assert.assertTrue(true);
		} else {
			log.info("Community_Population_DeleteRecord method ends here ........... ");
			Assert.assertTrue(false);
		}

	}	
	// Verify in DI, Project settings - ProjectArea tab- Add row button adds a new
	// line item with fields- 'Effective year', Population, Updated by followed by
	// Save and delete button

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 107, enabled = true, description = "Verify in DI, Project settings - ProjectArea tab- Add row button adds a new line item with fields- 'Effective year', Population, Updated by followed by Save and delete button ")
	public void Community_ProjectSetting_ProjectArea_Add_Row() {

		log.info("Community_ProjectSetting_ProjectArea_Add_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004332";
		if (!ProjectCommunityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProjectSetting();
			flag = CommunitiesPage.checkProjectArea_AddRow_Header_Display();
		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			Assert.assertTrue(true);
			log.info("Community_ProjectSetting_ProjectArea_Add_Row method ends here ........... ");
		} else {
			log.info("Community_ProjectSetting_ProjectArea_Add_Row method ends here ........... ");
			Assert.assertTrue(false);

		}
	}

	// Verify in DI, Project settings - Project Area tab- Add One row and save
	// Verify Effective year opens up decade calendar and gives the option to select
	// any year.
	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_ProjectSetting_ProjectArea_Add_Row", priority = 108, enabled = true, description = "Verify in DI, Project settings - Project Area tab- Add One row and save ,  \r\n"
			+ "			 ,  Verify Effective year opens up decade calendar and gives the option to select any year.")
	public void Community_ProjectSetting_ProjectArea_Save_Row_DecadeCalender_Display() {

		log.info(
				"Community_ProjectSetting_ProjectArea_Save_Row_DecadeCalender_Display method started......................... ");

		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000011415";
		if (!ProjectCommunityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProjectSetting();
			flag = CommunitiesPage.checkProjectArea_Save_New_Row("10000");

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Community_ProjectSetting_ProjectArea_Save_Row_DecadeCalender_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_ProjectSetting_ProjectArea_Save_Row_DecadeCalender_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify Project Area field allows to add values followed by commas.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 109, enabled = true, description = "Verify Project Area field allows to add values followed by commas.")
	public void Community_ProjectArea_Field_Comma_Display() {

		log.info("Community_ProjectArea_Field_Comma_Display method started......................... ");
		boolean Commaflag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004355";
		if (!ProjectCommunityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProjectSetting();
			Commaflag = CommunitiesPage.verifyProjectAreaField_Contains_Comma();
			if (Commaflag) {
				log.info("Project Area field contains Comma");
				log.info("Community_ProjectArea_Field_Comma_Display method ends here ........... ");
				Assert.assertTrue(true);
			} else {
				log.info("Project Area field field does not contains Comma");
				log.info("Community_ProjectArea_Field_Comma_Display method ends here ........... ");
				Assert.assertTrue(false);
			}
		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
	}

	// Project Setting - >Project Area - >Verify 'Comments' section by adding
	// comment should show correct timestamp.
	// Verify 'Activity' section should show correct activity with date and
	// timestamp.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 110, enabled = true, description = "Project Area - > Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void Community_ProjectSetting_ProjectArea_Comments_Activity_Test() {

		log.info("Community_ProjectSetting_ProjectArea_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004423";
		if (!ProjectCommunityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProjectSetting();

			flag = CommunitiesPage.checkProjectAreaCommentAndActivity(data.getCellData("Communities", 3, 2), ProfileUserName);

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Community_ProjectSetting_ProjectArea_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_ProjectSetting_ProjectArea_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify after creating Community Project with Gross Area as "Square Miles unit",
	// check in Data Input – Project Setting - > Project Area Tab -> Unit Drop down
	// by default value.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 111, enabled = true, description = "Verify after creating Community Project with Gross Area as \"Square Miles unit\", check in Data Input – Project Setting - > Project Area Tab -> Unit Drop down by default value. ")
	public void Community_Project_Area_GrossArea_SquareMiles_Display() {
		log.info("Community_Project_Area_GrossArea_SquareMiles_Display method started ........... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004319";
		if (!ProjectCommunityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProjectSetting();
			flag = CommunitiesPage.checkUnitTypeInProjectAreaUnderDataInput("sq miles");

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			Assert.assertTrue(true);
			log.info("Community_Project_Area_GrossArea_SquareMiles_Display method ends here ........... ");
		} else {
			log.info("Community_Project_Area_GrossArea_SquareMiles_Display method ends here ........... ");
			Assert.assertTrue(false);

		}

	}

	// Project Setting - > Project Area - > Verify filter button - From (Start date)
	// and To (End date) uopens up decade calendar and on selecting any year range,
	// the line items falling into those year should be displayed.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Community_ProjectSetting_ProjectArea_Save_Row_DecadeCalender_Display" }, priority = 112, enabled = true, description = "Project Setting - > Project Area - >Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed. ")
	public void Community_ProjectArea_Filter_Test() {

		log.info("Community_ProjectArea_Filter_Test method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000011415";
		if (!ProjectCommunityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProjectSetting();
			flag = CommunitiesPage.CheckProjectAreaFilter();
		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Community_ProjectArea_Filter_Test method ends here ........... ");
			Assert.assertTrue(true);
		} else {
			log.info("Community_ProjectArea_Filter_Test method ends here ........... ");
			Assert.assertTrue(false);
		}

	}
	
	// Project Setting - > Project Area - > Verify delete button deletes the line item successfully.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Community_ProjectSetting_ProjectArea_Save_Row_DecadeCalender_Display" }, priority = 113, enabled = true, description = "Project Setting - > Project Area - > Verify delete button deletes the line item successfully. ")
	public void Community_ProjectArea_DeleteRecord() {

		log.info("Community_ProjectArea_DeleteRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000011588";
		if (!ProjectCommunityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProjectSetting();
			flag = CommunitiesPage.CheckProjectAreaDeleteRow();
		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Community_ProjectArea_DeleteRecord method ends here ........... ");
			Assert.assertTrue(true);
		} else {
			log.info("Community_ProjectArea_DeleteRecord method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Project Area--- Verify Updated by shows the correct team-member/admin
	// name.{To
	// check this, add any team-member in teams section and login using that team
	// member and add line item to this tab and check if his name s updated in
	// 'Updated by column }

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Community_ProjectSetting_ProjectArea_Save_Row_DecadeCalender_Display" }, priority = 112, enabled = true, description = "Project Setting -> Project Area \r\n Verify Updated by shows the correct team-member/admin name.{To check this, add any team-member in teams section and login using that team member and add line item to this tab and chek if his name s updated in 'Updated by column ")
	public void Community_ProjectSetting_ProjectArea_UpdatedBy_Test() {

		log.info("Community_ProjectSetting_ProjectArea_UpdatedBy_Test method started......................... ");
		CommonMethod.switchToDefaultContent();
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		String ProjectCommunityID = System.getProperty("CommunitiesProject_Test1");
		// ProjectCommunityID="8000006651";
		if (!ProjectCommunityID.equals(null)) {
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			CommunitiesPage.ClickonTeamInManage();
			HomePage.closeProjectSearchTextBox();
			String username = data.getCellData("Communities", 0, 2);
			boolean emailexist = CommonMethod.Team_checkEmailExistOrNot(username);
			System.out.println(username + "-----------existence is----" + emailexist);
			boolean flag = false;
			if (emailexist == false) {
				flag = CommonMethod.Team_Add_Member(username);
			} else {
				flag = true;
			}
			if (flag) {
				log.info("Team Member added-----------------");
				HomePage.checkSignOut();
				HomePage = LoginPage.loginLater(data.getCellData("Communities", 0, 2), data.getCellData("Communities", 1, 2));
				// CommunitiesPage = new CommunitiesPageObject();
				boolean Updatedflag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				ProjectPage = HomePage.clickOnProject();
				CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
				HomePage.closeProjectSearchTextBox();
				String ProfileName=HomePage.getCurrentProfileUserName();
				CommunitiesPage.ClickonDataInput();
				CommonMethod.switchToDataInputFrame();
				CommunitiesPage.ClickonProjectSetting();
				boolean RecordAdded = CommunitiesPage.checkProjectArea_Save_New_Row("1400");
				if (RecordAdded) {
					log.info("RecordAdded flag is true  --------------");
					Updatedflag = CommunitiesPage.checkProjectAreaUpdatedByUserName(ProfileName);
					CommonMethod.switchToDefaultContent();
					HomePage.checkSignOut();
					HomePage = LoginPage.loginLater(prop.getProperty("email"), prop.getProperty("password"));
					if (Updatedflag) {
						log.info(
								"Community_ProjectSetting_ProjectArea_UpdatedBy_Test method ends with true here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info(
								"Community_ProjectSetting_ProjectArea_UpdatedBy_Test method ends ends with false here ........... ");
						Assert.assertTrue(false);
					}
				} else {
					log.info("RecordAdded flag is false, Unable to add the record--------------");
					CommonMethod.switchToDefaultContent();
					HomePage.checkSignOut();
					HomePage = LoginPage.loginLater(prop.getProperty("email"), prop.getProperty("password"));
					log.info(
							"Community_ProjectSetting_ProjectArea_UpdatedBy_Test method ends ends with false here ........... ");
					Assert.assertTrue(false);
				}

			} else {
				log.info("Unable to add the team member.-----------------");
				log.info("Community_ProjectSetting_ProjectArea_UpdatedBy_Test method ends with false here ........... ");
				Assert.assertTrue(false);
			}

		}

		else {
			log.info("Community Project is showing Null");
			log.info("Community_ProjectSetting_ProjectArea_UpdatedBy_Test method ends with false here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify Energy meter shows GHG emissions meter with data and detals tab.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 115, enabled = true, description = "Verify Energy meter shows GHG emissions meter with data and detals tab.")
	public void Community_Energy_GHGEmission_With_DataAndDetails_Display() {

		log.info("Community_Energy_GHGEmission_DataAndDetailsTab_Display method started......................... ");
		CommonMethod.switchToDefaultContent();
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004377";
		if (!ProjectCommunityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonGHGEmiissions();
			flag = CommunitiesPage.CheckGHGEmission_Data_DetailsTab_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Energy_GHGEmission_DataAndDetailsTab_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Energy_GHGEmission_DataAndDetailsTab_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify 'Add year' button adds line item with year for previous year.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Community_Energy_GHGEmission_With_DataAndDetails_Display" }, priority = 115, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
	public void Community_Energy_GHGEmission_AddYear_AddNewLine() {

		log.info("Community_Energy_GHGEmission_AddYear_AddNewLine method started......................... ");
		CommonMethod.switchToDefaultContent();
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004377";
		if (!ProjectCommunityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonGHGEmiissions();
			flag = CommunitiesPage.CheckGHGEmission_AddYear_NewRow_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Energy_GHGEmission_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Energy_GHGEmission_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify by adding value to reading and clicking on save button.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Community_Energy_GHGEmission_AddYear_AddNewLine" }, priority = 115, enabled = true, description = "Verify by adding value to reading and clicking on save button. ")
	public void Community_Energy_GHGEmission_SavePreviousYearData() {

		log.info("Community_Energy_GHGEmission_SavePreviousYearData method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000011415";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonGHGEmiissions();
			flag = CommunitiesPage.CheckGHGEmission_SaveNewRecord();
			if (flag) {
				log.info("Record is added successfully");
				log.info(
						"Community_Energy_GHGEmission_SavePreviousYearData method ends here with " + flag + " ........... ");
				Assert.assertTrue(true);
			} else {
				log.info("Record is not added successfully");
				log.info(
						"Community_Energy_GHGEmission_SavePreviousYearData method ends here with " + flag + " ........... ");
				Assert.assertTrue(false);
			}
		}

		else {
			log.info("Community Project is showing Null");
			log.info("Community_Energy_GHGEmission_SavePreviousYearData method ends here with " + flag + " ........... ");
			Assert.assertTrue(false);
		}

	}
	// Verify score gets populated when data is added for previous year

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Community_Energy_GHGEmission_SavePreviousYearData" }, priority = 115, enabled = true, description = " Verify score gets populated when data is added for previous year  ")
	public void Community_Energy_GHGEmission_CheckScore() {

		log.info("Community_Energy_GHGEmission_CheckScore method started......................... ");
		int Score;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000011415";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonGHGEmiissions();
			Score = CommunitiesPage.getEnergyScore();
			if (Score > 0) {
				log.info("Score is updated with---" + Score);
				log.info("Community_Energy_GHGEmission_CheckScore method ends here ........... ");
				Assert.assertTrue(true);
			} else {
				log.info("Community_Energy_GHGEmission_CheckScore method ends here ........... ");
				Assert.assertTrue(false);
			}
		}

		else {
			log.info("Community Project is showing Null");
			log.info("Community_Energy_GHGEmission_CheckScore method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify able to Edit line item by using Edit button..

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Energy_GHGEmission_SavePreviousYearData", priority = 116, enabled = true, description = "Verify able to Edit line item by using Edit button..")
	public void Community_Energy_GHGEmission_Edit_Row() {

		log.info("Community_Energy_GHGEmission_Edit_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004409";
		if (!ProjectCommunityID.equals(null)) {

			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonGHGEmiissions();
			// OldScore = CommunitiesPage.getEnergyScore();
			flag = CommunitiesPage.CheckGHGEmission_EditRow();
			/*
			 * if (flag) { CommonMethod.switchToDefaultContent(); ProjectPage =
			 * HomePage.clickOnProject(); CommunitiesPage =
			 * ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			 * HomePage.closeProjectSearchTextBox(); CommunitiesPage.ClickonDataInput();
			 * CommonMethod.switchToDataInputFrame(); CommunitiesPage.ClickonGHGEmiissions();
			 */
			// NewScore = CommunitiesPage.getEnergyScore();
			if (flag) {
				// log.info(OldScore + " is updated with---" + NewScore);
				log.info("Record is updated successfully");
				log.info("Community_Energy_GHGEmission_Edit_Row method ends here ........... ");
				Assert.assertTrue(true);
			} else {
				log.info("Record is not updated successfully");
				log.info("Community_Energy_GHGEmission_Edit_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Energy_GHGEmission_Edit_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify able to delete line item by using delete button.
	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Energy_GHGEmission_SavePreviousYearData", priority = 117, enabled = true, description = "Verify able to delete line item by using delete button.")
	public void Community_Energy_GHGEmission_Delete_Row() {

		log.info("Community_Energy_GHGEmission_Delete_Row method started......................... ");
		boolean flag = false;
		// int OldScore, NewScore;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004409";
		if (!ProjectCommunityID.equals(null)) {
			// CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonGHGEmiissions();
			// OldScore = CommunitiesPage.getEnergyScore();
			flag = CommunitiesPage.CheckGHGEmission_DeleteRow();

			if (flag) {
				log.info("Community_Energy_GHGEmission_Delete_Row method ends here ........... ");
				Assert.assertTrue(true);
			} else {
				log.info("Community_Energy_GHGEmission_Delete_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Energy_GHGEmission_Delete_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify 'previous year' and 'next year' button adds reading respectively.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 117, dependsOnMethods = {
			"Community_Energy_GHGEmission_SavePreviousYearData" }, enabled = true, description = "Verify 'previous year' and 'next year' button adds reading respectively.")
	public void Community_Energy_AddRow_PreviousYear_NextYear() {

		log.info("Community_Energy_AddRow_PreviousYear_NextYear method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004560";
		if (!ProjectCommunityID.equals(null)) {
			// CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonGHGEmiissions();
			CommunitiesPage.CheckGHGEmission_SaveNewRecord();
			flag = CommunitiesPage.CheckGHGEmission_SavePreviousAndNextYearRecord();
			if (flag) {
				log.info("Community_Energy_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info("Community_Energy_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Energy_AddRow_PreviousYear_NextYear method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Energy --> GHS Emissions --> Verify 'Comments' section by adding comment
	// should show correct timestamp.
	// Energy --> GHS Emissions -->'Activity' section should show correct activity
	// with date and
	// timestamp.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 118, enabled = true, description = "Energy --> GHS Emissions -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void Community_Energy_DetailsTab_Comments_Activity_Test() {

		log.info("Community_Energy_DetailsTab_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004489";
		if (!ProjectCommunityID.equals(null)) {

			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonGHGEmiissions();
			flag = CommunitiesPage.checkEnergyCommentAndActivity(data.getCellData("Communities", 5, 2), ProfileUserName);

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Community_Energy_DetailsTab_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Energy_DetailsTab_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Energy --> GHS Emissions -->Verify Details tab shows graph populated with
	// reading value and respective year.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 119, enabled = false, description = "Energy --> GHS Emissions -->Verify Details tab shows graph populated with reading value  and respective year.")
	public void Community_Energy_DetailsTab_Graph_Test() {

		log.info("Community_Energy_DetailsTab_Graph_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Test1");
		// ProjectCommunityID="8000007155";
		if (!ProjectCommunityID.equals(null)) {

			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonGHGEmiissions();
			flag = CommunitiesPage.CheckEnergyGraph();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Community_Energy_DetailsTab_Graph_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Energy_DetailsTab_Graph_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Energy - Verify filter button - From (Start date) and To (End date) uopens up
	// decade calendar and on selecting any year range, the line items falling into
	// those year should be displayed.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Community_Energy_GHGEmission_SavePreviousYearData" }, priority = 120, enabled = true, description = "Energy - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
	public void Community_Energy_FilterTest() {

		log.info("Community_Energy_FilterTest method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Perf4");
		//ProjectCommunityID="8000011512";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonGHGEmiissions();
			flag = CommunitiesPage.CheckEnergyFilter();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Energy_FilterTest method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Energy_FilterTest method ends here ........... ");
			Assert.assertTrue(false);
		}
	}
// Verify Water meter shows 'Water Consumption' meter with data and details tab.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 121, enabled = true, description = "Verify Water meter shows 'Water Consumption' meter with data and details tab. ")
	public void Community_Water_DataAndDetails_Display() {

		log.info("Community_Water_DataAndDetails_Display method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID = "8000004396";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonWaterConsumption();
			flag = CommunitiesPage.CheckWaterConsumption_Data_DetailsTab_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Water_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Water_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify 'Add year' button adds line item with year for previous year.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Water_DataAndDetails_Display", priority = 121, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
	public void Community_Water_Consum_AddYear_AddNewLine() {

		log.info("Community_Water_Consum_AddYear_AddNewLine method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID = "8000004396";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonWaterConsumption();
			flag = CommunitiesPage.CheckWatwr_Consumption_AddYear_NewRow_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Water_Consum_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Water_Consum_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify by adding value to reading and clicking on save button.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Water_Consum_AddYear_AddNewLine", priority = 121, enabled = true, description = "Verify by adding value to reading and clicking on save button. . ")
	public void Community_Water_Consum_SavePreviousYearData() {

		log.info("Community_Water_Consum_SavePreviousYearData method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID = "8000004553";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();

			CommunitiesPage.ClickonWaterConsumption();
			/*OldScore = CommunitiesPage.getWaterScore();
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonWaterConsumption();*/
			flag = CommunitiesPage.CheckWaterConsumption_SaveNewRecord();

			if (flag) {
				log.info("Record is added successfully");
				log.info("Community_Water_Consum_SavePreviousYearData method ends here  ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info("Community_Water_Consum_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Water_Consum_SavePreviousYearData method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify score gets populated when data is added for previous year

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Water_Consum_SavePreviousYearData", priority = 121, enabled = true, description = "Verify score gets populated when data is added for previous year  ")
	public void Community_Water_Consum_CheckScore() {

		log.info("Community_Water_Consum_CheckScore method started......................... ");
		int Score;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID = "8000004553";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonWaterConsumption();
			Score = CommunitiesPage.getWaterScore();
			if (Score > 0) {
				log.info("Score is updated with---" + Score);
				log.info("Community_Water_Consum_CheckScore method ends here ........... ");
				Assert.assertTrue(true);
			} else {
				log.info("Score is not generated successfully");
				log.info("Community_Water_Consum_CheckScore method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Water_Consum_CheckScore method ends here ........... ");
			Assert.assertTrue(false);
		}

	}
	// Verify 'Unit' dropdown allows to select unit 'Gallons' or 'Litre'.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Water_Consum_SavePreviousYearData", priority = 121, enabled = true, description = "Verify 'Unit' dropdown allows to select unit 'Gallons' or 'Litre'.")
	public void Community_Water_AddRows_With_Gallons_Litres() {

		log.info("Community_Water_AddRows_With_Gallons_Litres method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID = "8000011517";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonWaterConsumption();
			flag = CommunitiesPage.CheckWaterConsumption_AddRow_UnitTypes();

			if (flag) {

				log.info("Community_Water_AddRows_With_Gallons_Litres method ends here ........... ");
				Assert.assertTrue(true);

			} else {

				log.info("Community_Water_AddRows_With_Gallons_Litres method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Water_AddRows_With_Gallons_Litres method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify 'Duration' dropdown allows to select unit 'Per Year' or 'Per Month' or
	// 'Per week' or 'Per day' .

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 122, dependsOnMethods = "Community_Water_Consum_SavePreviousYearData", enabled = true, description = "Verify 'Duration' dropdown allows to select unit 'Per Year' or 'Per Month' or 'Per week' or 'Per day' .")
	public void Community_Water_AddRows_With_Duration_Types() {

		log.info("Community_Water_AddRows_With_Duration_Types method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID = "8000004489";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonWaterConsumption();
			//CommunitiesPage.getWaterScore();
			flag = CommunitiesPage.CheckWaterConsumption_AddRow_DurationTypes();

			if (flag) {

				log.info("Community_Water_AddRows_With_Duration_Types method ends here ........... ");
				Assert.assertTrue(true);

			} else {

				log.info("Community_Water_AddRows_With_Duration_Types method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Water_AddRows_With_Duration_Types method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify 'previous year' and 'next year' button adds reading respectively.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Community_Water_Consum_SavePreviousYearData" }, priority = 123, enabled = true, description = "Verify 'previous year' and 'next year' button adds reading respectively.")
	public void Community_Water_AddRow_PreviousYear_NextYear() {

		log.info("Community_Water_AddRow_PreviousYear_NextYear method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000011517";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonWaterConsumption();
			CommunitiesPage.CheckWaterConsumption_SaveNewRecord();
			flag = CommunitiesPage.CheckWaterConsum_SavePreviousAndNextYearRecord();
			if (flag) {
				log.info("Community_Water_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info("Community_Water_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Water_AddRow_PreviousYear_NextYear method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify able to Edit line item by using Edit button..

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Water_Consum_SavePreviousYearData", priority = 124, enabled = true, description = "Verify able to Edit line item by using Edit button..")
	public void Community_WaterConsum_Edit_Row() {

		log.info("Community_WaterConsum_Edit_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000011517";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonWaterConsumption();
			flag = CommunitiesPage.CheckWaterConsum_EditRow();

			if (flag) {
				log.info("Record is updated successfully");
				log.info("Community_WaterConsum_Edit_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not updated successfully");
				log.info("Community_WaterConsum_Edit_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_WaterConsum_Edit_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify able to delete line item by using delete button.
	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Water_Consum_SavePreviousYearData", priority = 125, enabled = true, description = "Verify able to delete line item by using delete button.")
	public void Community_WaterConsum_Delete_Row() {

		log.info("Community_WaterConsum_Delete_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004487";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonWaterConsumption();
			flag = CommunitiesPage.CheckWaterConsum_DeleteRow();

			if (flag) {
				log.info("Record is deleted successfully");
				log.info("Community_WaterConsum_Delete_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not deleted successfully");
				log.info("Community_WaterConsum_Delete_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_WaterConsum_Delete_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Water --> Water Consumption --> Verify 'Comments' section by adding comment
	// should show correct timestamp.
	// Water --> Water Consumption -->'Activity' section should show correct
	// activity with date and
	// timestamp.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 126, enabled = true, description = "Water --> Water Consumption -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void Community_Water_Consumption_Comments_Activity_Test() {

		log.info("Community_Water_Consumption_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004520";
		if (!ProjectCommunityID.equals(null)) {

			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonWaterConsumption();
			flag = CommunitiesPage.checkWaterCommentAndActivity(data.getCellData("Communities", 9, 2), ProfileUserName);

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Community_Water_Consumption_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Water_Consumption_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Water - Water Consumption - >Verify Details tab shows graph populated with
	// reading value and respective year.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 127, enabled = false, description = "Water - Water Consumption - >Verify Details tab shows graph populated with reading value  and respective year.")
	public void Community_Water_DetailsTab_Graph_Test() {

		log.info("Community_Water_DetailsTab_Graph_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Test1");
		// ProjectCommunityID="8000007155";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonWaterConsumption();
			flag = CommunitiesPage.CheckWaterGraph();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Community_Water_DetailsTab_Graph_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Water_DetailsTab_Graph_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Water - Water Consumption - >Verify filter button - From (Start date) and To
	// (End date) uopens up decade calendar and on selecting any year range, the
	// line items falling into those year should be displayed.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Water_Consum_SavePreviousYearData", priority = 128, enabled = true, description = "Water - Water Consumption - > - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
	public void Community_Water_FilterTest() {

		log.info("Community_Water_FilterTest method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Perf4");
		// ProjectCommunityID="8000011513";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonWaterConsumption();
			flag = CommunitiesPage.CheckWaterFilter();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Water_FilterTest method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Water_FilterTest method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// **************************Community WASTE TEST
	// CASES********************************************

	// Verify Waste meters shows 'Municipal Solid Waste generation intensity' with
	// data and details tab.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 130, enabled = true, description = "Verify Waste meters shows 'Municipal Solid Waste generation intensity'  with data and details tab. ")
	public void Community_Waste_Gen_DataAndDetails_Display() {

		log.info("Community_Waste_Gen_DataAndDetails_Display method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID = "8000006972";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonMunicipalSolidwastegeneration();
			flag = CommunitiesPage.CheckWasteGeneration_Data_DetailsTab_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Waste_Gen_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Waste_Gen_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// For Municipal Solid Waste generation intensity Meters- Verify 'Add year'
	// button adds line item with year for previous year.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Waste_Gen_DataAndDetails_Display", priority = 130, enabled = true, description = "For Municipal Solid Waste generation intensity Meters- Verify 'Add year' button adds line item with year for previous year.")
	public void Community_Waste_Generation_AddYear_AddNewLine() {

		log.info("Community_Waste_Generation_AddYear_AddNewLine method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID = "8000006972";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonMunicipalSolidwastegeneration();
			flag = CommunitiesPage.CheckWaste_Generation_AddYear_NewRow_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Waste_Generation_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Waste_Generation_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// For Municipal Solid Waste generation intensity Meter- - Verify by adding
	// value to reading and clicking on save button.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Waste_Generation_AddYear_AddNewLine", priority = 130, enabled = true, description = "For Municipal Solid Waste generation intensity Meter- - Verify by adding value to reading and clicking on save button. ")
	public void Community_Waste_Generation_SavePreviousYearData() {

		log.info("Community_Waste_Generation_SavePreviousYearData method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID = "8000006972";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonMunicipalSolidwastegeneration();
			flag = CommunitiesPage.CheckWaste_Generation_SaveNewRecord();

			if (flag) {
				log.info("Record is added successfully");
				log.info("Community_Waste_Generation_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info("Community_Waste_Generation_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Waste_Generation_SavePreviousYearData method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify 'previous year' and 'next year' button adds reading respectively.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 130, dependsOnMethods = "Community_Waste_Generation_SavePreviousYearData", enabled = true, description = "Verify 'previous year' and 'next year' button adds reading respectively.")
	public void Community_Waste_Generation_AddRow_PreviousYear_NextYear() {

		log.info("Community_Waste_Generation_AddRow_PreviousYear_NextYear method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004409";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonMunicipalSolidwastegeneration();
			flag = CommunitiesPage.CheckWaste_Generation_SavePreviousAndNextYearRecord();
			if (flag) {
				log.info("Community_Waste_Generation_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info("Community_Waste_Generation_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Waste_Generation_AddRow_PreviousYear_NextYear method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify able to Edit line item by using Edit button..

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Waste_Generation_SavePreviousYearData", priority = 131, enabled = true, description = "Verify able to Edit line item by using Edit button..")
	public void Community_Waste_Generation_Edit_Row() {

		log.info("Community_Waste_Generation_Edit_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000011537";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonMunicipalSolidwastegeneration();
			flag = CommunitiesPage.CheckWasteGeneration_EditRow();

			if (flag) {
				log.info("Community_Waste_Generation_Edit_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not updated successfully");
				log.info("Community_Waste_Generation_Edit_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Waste_Generation_Edit_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify able to delete line item by using delete button.
	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Waste_Generation_SavePreviousYearData", priority = 132, enabled = true, description = "Verify able to delete line item by using delete button.")
	public void Community_Waste_Generation_Delete_Row() {

		log.info("Community_Waste_Generation_Delete_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000011537";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonMunicipalSolidwastegeneration();

			flag = CommunitiesPage.CheckWasteGeneration_DeleteRow();

			if (flag) {

				log.info("Record is deleted successfully");
				log.info("Community_Waste_Generation_Delete_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not deleted successfully");
				log.info("Community_Waste_Generation_Delete_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Waste_Generation_Delete_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Waste --> Municipal solid waste generation intensity --> Verify 'Comments'
	// section by adding comment should show correct timestamp.
	// Waste --> Municipal solid waste generation intensity -->'Activity' section
	// should show correct activity with date and
	// timestamp.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 133, enabled = true, description = "Waste --> Municipal solid waste generation intensity -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void Community_Waste_Generation_Comments_Activity_Test() {

		log.info("Community_Waste_Generation_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004465";
		if (!ProjectCommunityID.equals(null)) {

			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();

			CommunitiesPage.ClickonMunicipalSolidwastegeneration();
			flag = CommunitiesPage.checkWasteGenerationCommentAndActivity(data.getCellData("Communities", 11, 2), ProfileUserName);

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Community_Waste_Generation_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Waste_Generation_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Waste --> Municipal solid waste generation intensity -->Verify Details tab
	// shows graph populated with reading value and respective year.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 134, enabled = false, description = "Waste --> Municipal solid waste generation intensity --> Verify Details tab shows graph populated with reading value  and respective year.")
	public void Community_WasteGeneration_DetailsTab_Graph_Test() {

		log.info("Community_WasteGeneration_DetailsTab_Graph_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Test1");
		// ProjectCommunityID="8000007155";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonMunicipalSolidwastegeneration();
			flag = CommunitiesPage.CheckWasteGenerationGraph();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Community_WasteGeneration_DetailsTab_Graph_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_WasteGeneration_DetailsTab_Graph_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Waste - Municipal solid waste generation intensity - >Verify filter button -
	// From (Start date) and To (End date) uopens up decade calendar and on
	// selecting any year range, the line items falling into those year should be
	// displayed.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Community_Waste_Generation_SavePreviousYearData" }, priority = 135, enabled = true, description = "Waste - 	Municipal solid waste generation intensity - >Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
	public void Community_Waste_Generation_FilterTest() {

		log.info("Community_Waste_Generation_FilterTest method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Perf4");
		// ProjectCommunityID = "8000011517";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonMunicipalSolidwastegeneration();
			flag = CommunitiesPage.CheckWaste_GenerationFilter();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Waste_Generation_FilterTest method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Waste_Generation_FilterTest method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify Waste meters shows 'Municipal solid waste diversion rate from
	// landfill' with data and details tab.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 136, enabled = true, description = "Verify Waste meters shows 'Municipal solid waste diversion rate from landfill'  with data and details tab. ")
	public void Community_Waste_Diversion_DataAndDetails_Display() {

		log.info("Community_Waste_Diversion_DataAndDetails_Display method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID = "8000004409";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonMunicipalSolidWasteDiversion();
			flag = CommunitiesPage.CheckWasteDiversion_Data_DetailsTab_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Waste_Diversion_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Waste_Diversion_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Municipal solid waste diversion rate from landfill- Verify 'Add year' button
	// adds line item with year for previous year.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Waste_Diversion_DataAndDetails_Display", priority = 136, enabled = true, description = "Municipal solid waste diversion rate from landfill- Verify 'Add year' button adds line item with year for previous year.")
	public void Community_Waste_Diversion_AddYear_AddNewLine() {

		log.info("Community_Waste_Diversion_AddYear_AddNewLine method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID = "8000004409";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonMunicipalSolidWasteDiversion();
			flag = CommunitiesPage.CheckWaste_Diversion_AddYear_NewRow_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Waste_Diversion_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Waste_Diversion_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Municipal solid waste diversion rate from landfill- Verify validation Message
	// after adding Invalid Percent value(101)

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Waste_Diversion_AddYear_AddNewLine", priority = 136, enabled = true, description = "Municipal solid waste diversion rate from landfill- Verify validation Message after adding Invalid Percent value(101)")
	public void Community_Waste_Diversion_CheckWithInvalidPercent() {

		log.info("Community_Waste_Diversion_CheckWithInvalidPercent method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID = "8000006846";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonMunicipalSolidWasteDiversion();
			flag = CommunitiesPage.CheckWaste_Diversion_CheckWithInvalidPercent();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Waste_Diversion_CheckWithInvalidPercent method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Waste_Diversion_CheckWithInvalidPercent method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Municipal solid waste diversion rate from landfill- - Verify by adding value
	// to reading and clicking on save button.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Waste_Diversion_AddYear_AddNewLine", priority = 137, enabled = true, description = "Municipal solid waste diversion rate from landfill- - Verify by adding value to reading and clicking on save button.  ")
	public void Community_Waste_Diversion_SavePreviousYearData() {

		log.info("Community_Waste_Diversion_SavePreviousYearData method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID = "8000004409";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonMunicipalSolidWasteDiversion();
			flag = CommunitiesPage.CheckWaste_Diversion_SaveNewRecord();

			if (flag) {
				log.info("Record is added successfully");
				log.info("Community_Waste_Diversion_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info("Community_Waste_Diversion_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Waste_Diversion_SavePreviousYearData method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Municipal solid waste diversion rate from landfill - Verify 'previous year'
	// and 'next year' button adds reading respectively.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 137, dependsOnMethods = "Community_Waste_Diversion_SavePreviousYearData", enabled = true, description = "Municipal solid waste diversion rate from landfill - Verify 'previous year' and 'next year' button adds reading respectively.")
	public void Community_Waste_Diversion_AddRow_PreviousYear_NextYear() {

		log.info("Community_Waste_Diversion_AddRow_PreviousYear_NextYear method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004409";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonMunicipalSolidWasteDiversion();
			flag = CommunitiesPage.CheckWaste_Diversion_SavePreviousAndNextYearRecord();
			if (flag) {
				log.info("Community_Waste_Diversion_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info("Community_Waste_Diversion_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Waste_Diversion_AddRow_PreviousYear_NextYear method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Municipal solid waste diversion rate from landfill - Verify able to Edit line
	// item by using Edit button..

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Waste_Diversion_SavePreviousYearData", priority = 138, enabled = true, description = "Municipal solid waste diversion rate from landfill - Verify able to Edit line item by using Edit button..")
	public void Community_Waste_Diversion_Edit_Row() {

		log.info("Community_Waste_Diversion_Edit_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004409";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonMunicipalSolidWasteDiversion();
			flag = CommunitiesPage.CheckWasteDiversion_EditRow();

			if (flag) {
				log.info("Community_Waste_Diversion_Edit_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not updated successfully");
				log.info("Community_Waste_Diversion_Edit_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Waste_Diversion_Edit_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Municipal solid waste diversion rate from landfill - Verify able to delete
	// line item by using delete button.
	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Waste_Diversion_SavePreviousYearData", priority = 139, enabled = true, description = "Municipal solid waste diversion rate from landfill - Verify able to delete line item by using delete button.")
	public void Community_Waste_Diversion_Delete_Row() {

		log.info("Community_Waste_Diversion_Delete_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004409";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonMunicipalSolidWasteDiversion();

			flag = CommunitiesPage.CheckWasteDiversion_DeleteRow();

			if (flag) {

				log.info("Record is deleted successfully");
				log.info("Community_Waste_Diversion_Delete_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not deleted successfully");
				log.info("Community_Waste_Diversion_Delete_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Waste_Diversion_Delete_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify score gets populated when data is added for previous year for both the
	// meters- 'Municipal Solid Waste generation intensity' and 'Municipal Solid
	// Waste Diversion rate from Landfill '

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Community_Waste_Diversion_SavePreviousYearData",
			"Community_Waste_Generation_SavePreviousYearData" }, priority = 140, enabled = true, description = "Verify score gets populated when data is added for previous year for both the meters- 'Municipal Solid Waste generation intensity' and 'Municipal Solid Waste Diversion rate from Landfill '  ")
	public void Community_Waste_Score_SavePreviousYearDataForGenerationAndDiversion() {

		log.info(
				"Community_Waste_Score_SavePreviousYearDataForGenerationAndDiversion method started......................... ");
		int OldScore, NewScore;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID = "8000007095";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonMunicipalSolidwastegeneration();
			OldScore = CommunitiesPage.getWasteScore();
			log.info("Old Score is --" + OldScore);
			CommunitiesPage.CheckWaste_Generation_SaveNewRecord();

			CommunitiesPage.ClickonMunicipalSolidWasteDiversion();
			CommunitiesPage.CheckWaste_Diversion_SaveNewRecord();
			NewScore = CommunitiesPage.getWasteScore();

			log.info("Old Score is --" + OldScore);
			log.info("New Score is --" + NewScore);
			if (NewScore > OldScore) {
				log.info("Waste Score is generated successfully");
				log.info(
						"Community_Waste_Score_SavePreviousYearDataForGenerationAndDiversion method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Waste Score is not generated successfully");
				log.info(
						"Community_Waste_Score_SavePreviousYearDataForGenerationAndDiversion method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Waste_Score_SavePreviousYearDataForGenerationAndDiversion method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Waste --> Municipal solid waste diversion rate from landfill --> Verify
	// 'Comments' section by adding comment should show correct timestamp.
	// Waste --> Municipal solid waste diversion rate from landfill -->'Activity'
	// section should show correct activity with date and
	// timestamp.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 141, enabled = true, description = "Waste --> Municipal solid waste diversion rate from landfill -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void Community_Waste_Diversion_Comments_Activity_Test() {

		log.info("Community_Waste_Diversion_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Perf4");
		// ProjectCommunityID="8000004466";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonMunicipalSolidWasteDiversion();
			flag = CommunitiesPage.checkWasteDiversionCommentAndActivity(data.getCellData("Communities", 13, 2), ProfileUserName);

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Community_Waste_Diversion_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Waste_Diversion_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Waste --> Municipal solid waste diversion rate from landfill -->Verify
	// Details tab shows graph populated with reading value and respective year.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 142, enabled = false, description = " Waste --> Municipal solid waste diversion rate from landfill --> Verify Details tab shows graph populated with reading value  and respective year.")
	public void Community_WasteDiversion_DetailsTab_Graph_Test() {

		log.info("Community_WasteDiversion_DetailsTab_Graph_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Test1");
		// ProjectCommunityID="8000007155";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonMunicipalSolidWasteDiversion();
			flag = CommunitiesPage.CheckWasteDiversionGraph();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Community_WasteDiversion_DetailsTab_Graph_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_WasteDiversion_DetailsTab_Graph_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Waste --> Municipal solid waste diversion rate from landfill - >Verify filter
	// button - From (Start date) and To (End date) uopens up decade calendar and on
	// selecting any year range, the line items falling into those year should be
	// displayed.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 143, dependsOnMethods = "Community_Waste_Diversion_SavePreviousYearData", enabled = true, description = "Waste --> Municipal solid waste diversion rate from landfill - >Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
	public void Community_Waste_Diversion_FilterTest() {

		log.info("Community_Waste_Diversion_FilterTest method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Perf4");
		// ProjectCommunityID="8000004510";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonMunicipalSolidWasteDiversion();
			flag = CommunitiesPage.CheckWaste_DiversionFilter();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Waste_Diversion_FilterTest method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Waste_Diversion_FilterTest method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

//*********************************************Transportation Test Cases*************************
	// Verify for Transport, 'Vehicle Miles travelled on individual vehicles
	// daily(VMT) gets added by default with "Data" ad "Details" tab.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 144, enabled = true, description = "Verify for Transport, 'Vehicle Miles travelled on individual vehicles daily(VMT) gets added by default with Data and Details tab.")
	public void Community_Transportation_VMT_With_DataAndDetails_Display() {

		log.info("Community_Transportation_VMT_With_DataAndDetails_Display method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("CommunitiesProject_NonLeed2","8000004525");
		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000006972";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonVMT();
			flag = CommunitiesPage.CheckVMT_Data_DetailsTab_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Transportation_VMT_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Transportation_VMT_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify 'Add year' button adds line item with year for previous year.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Transportation_VMT_With_DataAndDetails_Display", priority = 144, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
	public void Community_Transportation_VMT_AddYear_AddNewLine() {

		log.info("Community_Transportation_VMT_AddYear_AddNewLine method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004456";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonVMT();
			flag = CommunitiesPage.CheckTransport_VMT_AddYear_NewRow_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Transportation_VMT_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Transportation_VMT_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Transportation - Verify by adding value to reading and clicking on save
	// button.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Transportation_VMT_AddYear_AddNewLine", priority = 144, enabled = true, description = "Transportation - >Verify by adding value to reading and clicking on save button. ")
	public void Community_Transportation_SavePreviousYearData() {

		log.info("Community_Transportation_SavePreviousYearData method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000011540";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonVMT();
			//OldScore = CommunitiesPage.getTransportScore();
			flag = CommunitiesPage.CheckTransportation_SaveNewRecord();

			if (flag) {
					log.info("Community_Transportation_SavePreviousYearData method ends here ........... ");
					Assert.assertTrue(true);
				
			} else {
				log.info("Record is not added successfully");
				log.info("Community_Transportation_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Transportation_SavePreviousYearData method ends here ........... ");
			Assert.assertTrue(false);
		}

	}
	
	
	// Verify score gets populated when data is added for previous year

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Transportation_SavePreviousYearData", priority = 144, enabled = true, description = "Transportation - >Verify score gets populated when data is added for previous year  ")
	public void Community_Transportation_CheckScore() {

		log.info("Community_Transportation_CheckScore method started......................... ");
		int Score;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004377";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonVMT();
			Score = CommunitiesPage.getTransportScore();
			
				if (Score>0) {
					log.info("Score is updated with---" + Score);
					log.info("Community_Transportation_CheckScore method ends here ........... ");
					Assert.assertTrue(true);
				}
			 else {
				log.info("Community_Transportation_CheckScore method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Transportation_CheckScore method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Transportation - VMT - >Verify 'previous year' and 'next year' button adds
	// reading respectively.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 145, dependsOnMethods = "Community_Transportation_SavePreviousYearData", enabled = true, description = "Transportation - VMT - > Verify 'previous year' and 'next year' button adds reading respectively.")
	public void Community_Transportation_VMT_AddRow_PreviousYear_NextYear() {

		log.info("Community_Transportation_VMT_AddRow_PreviousYear_NextYear method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000011540";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonVMT();
			flag = CommunitiesPage.Transportation_VMT_SavePreviousAndNextYearRecord();
			if (flag) {
				log.info("Community_Transportation_VMT_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info("Community_Transportation_VMT_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Transportation_VMT_AddRow_PreviousYear_NextYear method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Transportation - Verify able to edit readings by using 'Edit' button.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Transportation_SavePreviousYearData", priority = 146, enabled = true, description = "Transportation - >Verify able to edit readings by using 'Edit' button.")

	public void Community_Transportation_Edit_Test() {

		log.info("Community_Transportation_Edit_Test method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004525";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonVMT();
			flag = CommunitiesPage.CheckTransportation_EditRecord();

			if (flag) {
				log.info("Record is updated successfully");
				log.info("Community_Transportation_Edit_Test method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not updated successfully");
				log.info("Community_Transportation_Edit_Test method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Transportation_Edit_Test method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Transportation - VMT - Verify able to delete line item by using delete
	// button.
	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Transportation_SavePreviousYearData", priority = 147, enabled = true, description = "Transportation - VMT - Verify able to delete line item by using delete button.")
	public void Community_Transportation_VMT_Delete_Row() {

		log.info("Community_Transportation_VMT_Delete_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004409";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonVMT();

			flag = CommunitiesPage.Transportation_VMT_DeleteRow();

			if (flag) {

				log.info("Record is deleted successfully");
				log.info("Community_Transportation_VMT_Delete_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not deleted successfully");
				log.info("Community_Transportation_VMT_Delete_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Transportation_VMT_Delete_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Transportation->VMT -->Verify Details tab shows graph populated with reading
	// value and respective year.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 148, enabled = false, description = " Transportation->VMT--> Verify Details tab shows graph populated with reading value  and respective year.")
	public void Community_Transportation_DetailsTab_Graph_Test() {

		log.info("Community_Transportation_DetailsTab_Graph_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Test1");
		// ProjectCommunityID="8000007155";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonVMT();
			flag = CommunitiesPage.CheckTransportationGraph();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Community_Transportation_DetailsTab_Graph_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Transportation_DetailsTab_Graph_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Transportation->VMT - Verify filter button - From (Start date) and To (End
	// date) opens up decade calendar and on selecting any year range, the line
	// items falling into those year should be displayed.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Community_Transportation_SavePreviousYearData" }, priority = 149, enabled = true, description = "Transportation->VMT - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
	public void Community_Transportation_VMT_FilterTest() {

		log.info("Community_Transportation_VMT_FilterTest method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Perf4");
		// ProjectCommunityID="8000011517";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonVMT();
			flag = CommunitiesPage.CheckTransportationFilter();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Transportation_VMT_FilterTest method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Transportation_VMT_FilterTest method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Transportation --> VMT --> Verify 'Comments' section by adding comment should
	// show correct timestamp.
	// Transportation --> VMT -->'Activity' section should show correct activity
	// with date and
	// timestamp.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 150, enabled = true, description = "Transportation --> VMT -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void Community_Transportation_VMT_Comments_Activity_Test() {

		log.info("Community_Transportation_VMT_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004527";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonVMT();
			// OldScore = CommunitiesPage.getTransportScore();
			flag = CommunitiesPage.checkTransportCommentAndActivity(data.getCellData("Communities", 15, 2), ProfileUserName);

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Community_Transportation_VMT_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Transportation_VMT_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// ****************************Quality of Life -- > Health & Safety: Median air
	// quality index (AQI) Test Cases*************************
	// Verify for Health & Safety: Median air quality index (AQI) gets added by
	// default with "Data" ad "Details" tab.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 152, enabled = true, description = "Verify for Health & Safety: Median air quality index (AQI) gets added by default with Data and Details tab.")
	public void Community_Health_Safety_With_DataAndDetails_Display() {

		log.info("Community_Health_Safety_With_DataAndDetails_Display method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004564";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonHealthAndSafety();
			flag = CommunitiesPage.CheckHealthAndSafety_Data_DetailsTab_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Health_Safety_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Health_Safety_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify 'Add year' button adds line item with year for previous year.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Health_Safety_With_DataAndDetails_Display", priority = 152, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
	public void Community_Health_Safety_AddYear_AddNewLine() {

		log.info("Community_Health_Safety_AddYear_AddNewLine method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004564";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonHealthAndSafety();
			flag = CommunitiesPage.CheckHealthAndSafety_AddYear_NewRow_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Health_Safety_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Health_Safety_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify validation Message after adding Invalid value(501)

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Health_Safety_AddYear_AddNewLine", priority = 152, enabled = true, description = "Verify validation Message after adding Invalid value(501)")
	public void Community_Health_Safety_CheckWithInvalidValue() {

		log.info("Community_Health_Safety_CheckWithInvalidValue method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000006849";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonHealthAndSafety();
			flag = CommunitiesPage.CheckHealthAndSafety_CheckWithInvalidValue();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Health_Safety_CheckWithInvalidValue method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Health_Safety_CheckWithInvalidValue method ends here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Quality Of Life--> Health And Safety - Verify by adding value to reading and
	// clicking on save button for previous year

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Health_Safety_AddYear_AddNewLine", priority = 153, enabled = true, description = "Quality Of Life --> Health & Safety: Median air quality index (AQI) - >Verify by adding value to reading and clicking on save button for previous year  ")
	public void Community_HealthAndSafety_SavePreviousYearData() {

		log.info("Community_HealthAndSafety_SavePreviousYearData method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000011537";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonHealthAndSafety();
			flag = CommunitiesPage.CheckHealthAndSafety_SaveNewRecord();

			if (flag) {
				log.info("Community_HealthAndSafety_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not added successfully");
				log.info("Community_HealthAndSafety_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_HealthAndSafety_SavePreviousYearData method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Health And Safety - >Verify 'previous year' and 'next
	// year' button adds reading respectively.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 153, dependsOnMethods = "Community_HealthAndSafety_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Health And Safety - > Verify 'previous year' and 'next year' button adds reading respectively.")
	public void Community_HealthAndSafety_AddRow_PreviousYear_NextYear() {

		log.info("Community_HealthAndSafety_AddRow_PreviousYear_NextYear method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004564";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonHealthAndSafety();
			flag = CommunitiesPage.HealthAndSafety_SavePreviousAndNextYearRecord();
			if (flag) {
				log.info("Community_HealthAndSafety_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info("Community_HealthAndSafety_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_HealthAndSafety_AddRow_PreviousYear_NextYear method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Health And Safety - Verify able to edit readings by using
	// 'Edit' button.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 154, dependsOnMethods = "Community_HealthAndSafety_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Health And Safety - >Verify able to edit readings by using 'Edit' button.")

	public void Community_HealthAndSafety_Edit_Test() {

		log.info("Community_HealthAndSafety_Edit_Test method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004564";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonHealthAndSafety();
			flag = CommunitiesPage.CheckHealthAndSafety_EditRecord();

			if (flag) {
				log.info("Record is updated successfully");
				log.info("Community_HealthAndSafety_Edit_Test method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not updated successfully");
				log.info("Community_HealthAndSafety_Edit_Test method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_HealthAndSafety_Edit_Test method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Health And Safety - Verify able to delete line item by
	// using delete button.
	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_HealthAndSafety_SavePreviousYearData", priority = 155, enabled = true, description = "Quality Of Life--> Health And Safety - Verify able to delete line item by using delete button.")
	public void Community_HealthAndSafety_Delete_Row() {

		log.info("Community_HealthAndSafety_Delete_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004564";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonHealthAndSafety();
			flag = CommunitiesPage.HealthAndSafety_DeleteRow();

			if (flag) {

				log.info("Record is deleted successfully");
				log.info("Community_HealthAndSafety_Delete_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not deleted successfully");
				log.info("Community_HealthAndSafety_Delete_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_HealthAndSafety_Delete_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Health And Safety - Verify filter button - From (Start
	// date) and To (End date) uopens up decade calendar and on selecting any year
	// range, the line items falling into those year should be displayed.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 156, enabled = true, description = "Quality Of Life--> Health And Safety - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
	public void Community_HealthAndSafey_FilterTest() {

		log.info("Community_HealthAndSafey_FilterTest method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Perf4");
		// ProjectCommunityID="8000004565";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonHealthAndSafety();
			flag = CommunitiesPage.CheckHealthAndSafetyFilter();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_HealthAndSafey_FilterTest method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_HealthAndSafey_FilterTest method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Quality Of Life--> Health And Safety --> Verify 'Comments' section by adding
	// comment should show correct timestamp.
	// Quality Of Life--> Health And Safety -->'Activity' section should show
	// correct activity with date and
	// timestamp.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 156, enabled = false, description = "Quality Of Life--> Health And Safety -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void Community_HealthAndSafety_Comments_Activity_Test() {

		log.info("Community_HealthAndSafety_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004527";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonHealthAndSafety();
			flag = CommunitiesPage.checkTransportCommentAndActivity(data.getCellData("Communities", 17, 2), ProfileUserName);

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Community_HealthAndSafety_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_HealthAndSafety_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// ****************************Quality of Life -- > Education: Population with
	// (at least) Bachelor's degree (%) Test Cases*************************
	// Verify for Education: Population with (at least) Bachelor's degree (%) gets
	// added by default with "Data" ad "Details" tab.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 159, enabled = true, description = "Verify for Education: Population with (at least) Bachelor's degree (%) gets added by default with Data and Details tab.")
	public void Community_Education_Bachelor_Population_With_DataAndDetails_Display() {

		log.info(
				"Community_Education_Bachelor_Population_With_DataAndDetails_Display method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004565";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEducation_BachelorPopulation();
			flag = CommunitiesPage.CheckEducation_BachelorPopulation_Data_DetailsTab_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Education_Bachelor_Population_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Education_Bachelor_Population_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify 'Add year' button adds line item with year for previous year.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Education_Bachelor_Population_With_DataAndDetails_Display", priority = 159, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
	public void Community_Education_Bachelor_Population_AddYear_AddNewLine() {

		log.info("Community_Education_Bachelor_Population_AddYear_AddNewLine method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004565";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEducation_BachelorPopulation();
			flag = CommunitiesPage.CheckEducation_Bachelor_Population_AddYear_NewRow_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Education_Bachelor_Population_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Education_Bachelor_Population_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify validation Message after adding Invalid Percent value(101).

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Education_Bachelor_Population_AddYear_AddNewLine", priority = 159, enabled = true, description = "Verify validation Message after adding Invalid Percent value(101)")
	public void Community_Education_Bachelor_Population_SaveWithInvalidPercent() {

		log.info("Community_Education_Bachelor_Population_SaveWithInvalidPercent method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000006849";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEducation_BachelorPopulation();
			flag = CommunitiesPage.CheckEducation_Bachelor_Population_CheckWithInvalidPercent();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Education_Bachelor_Population_SaveWithInvalidPercent method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Education_Bachelor_Population_SaveWithInvalidPercent method ends here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Quality Of Life--> Education: Population with (at least) Bachelor's degree
	// (%) -Verify by adding value to reading and clicking on save button for
	// previous year

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Education_Bachelor_Population_AddYear_AddNewLine", priority = 160, enabled = true, description = "Quality Of Life --> Education: Population with (at least) Bachelor's degree (%) - >Verify by adding value to reading and clicking on save button for previous year ")
	public void Community_Education_Bachelor_Population_SavePreviousYearData() {

		log.info("Community_Education_Bachelor_Population_SavePreviousYearData method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004565";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEducation_BachelorPopulation();
			flag = CommunitiesPage.CheckEductaion_Bachelor_Population_SaveNewRecord();

			if (flag) {
				log.info("Community_Education_Bachelor_Population_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not added successfully");
				log.info("Community_Education_Bachelor_Population_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Education_Bachelor_Population_SavePreviousYearData method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Education: Population with (at least) Bachelor's degree
	// (%) - >Verify 'previous year' and 'next year' button adds reading
	// respectively.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 160, dependsOnMethods = "Community_Education_Bachelor_Population_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Education: Population with (at least) Bachelor's degree (%) - > Verify 'previous year' and 'next year' button adds reading respectively.")
	public void Community_Education_Bachelor_Population_AddRow_PreviousYear_NextYear() {

		log.info(
				"Community_Education_Bachelor_Population_AddRow_PreviousYear_NextYear method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000011537";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEducation_BachelorPopulation();
			flag = CommunitiesPage.Education_Bachelor_Population_SavePreviousAndNextYearRecord();
			if (flag) {
				log.info(
						"Community_Education_Bachelor_Population_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info(
						"Community_Education_Bachelor_Population_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Education_Bachelor_Population_AddRow_PreviousYear_NextYear method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Education: Population with (at least) Bachelor's degree
	// (%) - Verify able to edit readings by using 'Edit' button.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 161, dependsOnMethods = "Community_Education_Bachelor_Population_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Education: Population with (at least) Bachelor's degree (%) - >Verify able to edit readings by using 'Edit' button.")

	public void Community_Education_Bachelor_Population_Edit_Test() {

		log.info("Community_Education_Bachelor_Population_Edit_Test method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004565";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEducation_BachelorPopulation();
			flag = CommunitiesPage.CheckEducation_Bachelor_population_EditRecord();

			if (flag) {
				log.info("Record is updated successfully");
				log.info("Community_Education_Bachelor_Population_Edit_Test method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not updated successfully");
				log.info("Community_Education_Bachelor_Population_Edit_Test method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Education_Bachelor_Population_Edit_Test method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Education: Population with (at least) Bachelor's degree
	// (%) - Verify able to delete line item by using delete button.
	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup",dependsOnMethods = "Community_Education_Bachelor_Population_SavePreviousYearData", priority = 162, enabled = true, description = "Quality Of Life--> Education: Population with (at least) Bachelor's degree (%) - Verify able to delete line item by using delete button.")
	public void Community_Education_Bachelor_Population_Delete_Row() {

		log.info("Community_Education_Bachelor_Population_Delete_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000011545";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEducation_BachelorPopulation();
			flag = CommunitiesPage.Education_Bachelor_Population_DeleteRow();

			if (flag) {

				log.info("Record is deleted successfully");
				log.info("Community_Education_Bachelor_Population_Delete_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not deleted successfully");
				log.info("Community_Education_Bachelor_Population_Delete_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Education_Bachelor_Population_Delete_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Education: Population with (at least) Bachelor's degree
	// (%) - Verify filter button - From (Start date) and To (End date) uopens up
	// decade calendar and on selecting any year range, the line items falling into
	// those year should be displayed.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 163, dependsOnMethods = "Community_Education_Bachelor_Population_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Education: Population with (at least) Bachelor's degree (%) - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
	public void Community_Education_Bachelor_Population_FilterTest() {

		log.info("Community_Education_Bachelor_Population_FilterTest method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Perf4");
		// ProjectCommunityID="8000004564";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEducation_BachelorPopulation();
			flag = CommunitiesPage.CheckEducation_Bachelor_Population_Filter();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Education_Bachelor_Population_FilterTest method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Education_Bachelor_Population_FilterTest method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Quality Of Life--> Education: Population with (at least) Bachelor's degree
	// (%) --> Verify 'Comments' section by adding comment should show correct
	// timestamp.
	// Quality Of Life--> Education: Population with (at least) Bachelor's degree
	// (%) -->'Activity' section should show correct activity with date and
	// timestamp.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 163, enabled = false, description = "Quality Of Life--> Health And Safety -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void Community_Education_Bachelor_Population_Comments_Activity_Test() {

		log.info("Community_Education_Bachelor_Population_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004527";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEducation_BachelorPopulation();
			flag = CommunitiesPage.checkTransportCommentAndActivity(data.getCellData("Communities", 19, 2), ProfileUserName);

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Community_HealthAndSafety_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_HealthAndSafety_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// ****************************Quality of Life -- > Equitability: Gini
	// coefficient (for income distribution) Test Cases*************************
	// Verify for Equitability: Gini coefficient (for income distribution) gets
	// added by default with "Data" ad "Details" tab.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 165, enabled = true, description = "Verify for Equitability: Gini coefficient (for income distribution) gets added by default with Data and Details tab.")
	public void Community_Equitability_Gini_Coefficient_With_DataAndDetails_Display() {

		log.info(
				"Community_Equitability_Gini_Coefficient_With_DataAndDetails_Display method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004564";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEquitability_Gini_Coeffiecient();
			flag = CommunitiesPage.CheckEquitability_Gini_Coefficient_Data_DetailsTab_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Equitability_Gini_Coefficient_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Equitability_Gini_Coefficient_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify 'Add year' button adds line item with year for previous year.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Equitability_Gini_Coefficient_With_DataAndDetails_Display", priority = 165, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
	public void Community_Equitability_Gini_Coefficient_AddYear_AddNewLine() {

		log.info("Community_Equitability_Gini_Coefficient_AddYear_AddNewLine method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004564";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEquitability_Gini_Coeffiecient();
			flag = CommunitiesPage.CheckEquitability_Gini_Coefficient_AddYear_NewRow_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Equitability_Gini_Coefficient_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Equitability_Gini_Coefficient_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify validation Message after adding Invalid value(Test Data -2)

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Equitability_Gini_Coefficient_AddYear_AddNewLine", priority = 165, enabled = true, description = "Verify validation Message after adding Invalid value(Test Data -2)")
	public void Community_Equitability_Gini_Coefficient_SaveWithInvalidValue() {

		log.info("Community_Equitability_Gini_Coefficient_SaveWithInvalidValue method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000006849";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEquitability_Gini_Coeffiecient();
			flag = CommunitiesPage.CheckEquitability_Gini_Coefficient_CheckWithInvalidValue();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Equitability_Gini_Coefficient_SaveWithInvalidValue method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Equitability_Gini_Coefficient_SaveWithInvalidValue method ends here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Quality Of Life--> Equitability: Gini coefficient (for income distribution) -
	// Verify by adding value to reading and clicking on save button for previous
	// year.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Equitability_Gini_Coefficient_AddYear_AddNewLine", priority = 166, enabled = true, description = "Quality Of Life --> Equitability: Gini coefficient (for income distribution) - >Verify by adding value to reading and clicking on save button for previous year ")
	public void Community_Equitability_Gini_Coefficient_SavePreviousYearData() {

		log.info("Community_Equitability_Gini_Coefficient_SavePreviousYearData method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004564";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEquitability_Gini_Coeffiecient();
			flag = CommunitiesPage.CheckEquitability_Gini_Coefficient_SaveNewRecord();

			if (flag) {
				log.info("Community_Equitability_Gini_Coefficient_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not added successfully");
				log.info("Community_Equitability_Gini_Coefficient_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Equitability_Gini_Coefficient_SavePreviousYearData method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Equitability: Gini coefficient (for income distribution) -
	// >Verify 'previous year' and 'next year' button adds reading respectively.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 166, dependsOnMethods = "Community_Equitability_Gini_Coefficient_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Equitability: Gini coefficient (for income distribution) - > Verify 'previous year' and 'next year' button adds reading respectively.")
	public void Community_Equitability_Gini_Coefficient_AddRow_PreviousYear_NextYear() {

		log.info(
				"Community_Equitability_Gini_Coefficient_AddRow_PreviousYear_NextYear method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004564";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEquitability_Gini_Coeffiecient();
			flag = CommunitiesPage.Equitability_Gini_Coefficient_SavePreviousAndNextYearRecord();
			if (flag) {
				log.info(
						"Community_Equitability_Gini_Coefficient_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info(
						"Community_Equitability_Gini_Coefficient_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Equitability_Gini_Coefficient_AddRow_PreviousYear_NextYear method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Equitability: Gini coefficient (for income distribution) -
	// Verify able to edit readings by using 'Edit' button.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 167, dependsOnMethods = "Community_Equitability_Gini_Coefficient_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Equitability: Gini coefficient (for income distribution) - >Verify able to edit readings by using 'Edit' button.")

	public void Community_Equitability_Gini_Coefficient_Edit_Test() {

		log.info("Community_Equitability_Gini_Coefficient_Edit_Test method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004564";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEquitability_Gini_Coeffiecient();
			flag = CommunitiesPage.CheckEquitability_Gini_Coefficient_EditRecord();

			if (flag) {
				log.info("Record is updated successfully");
				log.info("Community_Equitability_Gini_Coefficient_Edit_Test method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not updated successfully");
				log.info("Community_Equitability_Gini_Coefficient_Edit_Test method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Equitability_Gini_Coefficient_Edit_Test method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Equitability: Gini coefficient (for income distribution) -
	// Verify able to delete line item by using delete button.
	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Equitability_Gini_Coefficient_SavePreviousYearData", priority = 168, enabled = true, description = "Quality Of Life--> Equitability: Gini coefficient (for income distribution) - Verify able to delete line item by using delete button.")
	public void Community_Equitability_Gini_Coefficient_Delete_Row() {

		log.info("Community_Equitability_Gini_Coefficient_Delete_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004564";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEquitability_Gini_Coeffiecient();
			flag = CommunitiesPage.Equitability_Gini_Coefficient_DeleteRow();

			if (flag) {

				log.info("Record is deleted successfully");
				log.info("Community_Equitability_Gini_Coefficient_Delete_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not deleted successfully");
				log.info("Community_Equitability_Gini_Coefficient_Delete_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Equitability_Gini_Coefficient_Delete_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Equitability: Gini coefficient (for income distribution) -
	// Verify filter button - From (Start date) and To (End date) uopens up decade
	// calendar and on selecting any year range, the line items falling into those
	// year should be displayed.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 169, dependsOnMethods = "Community_Equitability_Gini_Coefficient_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Equitability: Gini coefficient (for income distribution) - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
	public void Community_Equitability_Gini_Coefficient_FilterTest() {

		log.info("Community_Equitability_Gini_Coefficient_FilterTest method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Perf4");
		// ProjectCommunityID="8000004565";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEquitability_Gini_Coeffiecient();
			flag = CommunitiesPage.CheckEquitability_Gini_Coefficient_Filter();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Equitability_Gini_Coefficient_FilterTest method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Equitability_Gini_Coefficient_FilterTest method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Quality Of Life--> Equitability: Gini coefficient (for income distribution)
	// --> Verify 'Comments' section by adding comment should show correct
	// timestamp.
	// Quality Of Life--> Equitability: Gini coefficient (for income distribution)
	// -->'Activity' section should show correct activity with date and
	// timestamp.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 169, enabled = false, description = "Quality Of Life--> Equitability: Gini coefficient (for income distribution)  -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void Community_Equitability_Gini_Coefficient_Comments_Activity_Test() {

		log.info("Community_Equitability_Gini_Coefficient_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004527";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEquitability_Gini_Coeffiecient();
			flag = CommunitiesPage.checkTransportCommentAndActivity(data.getCellData("Communities", 21, 2), ProfileUserName);

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Community_Equitability_Gini_Coefficient_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Equitability_Gini_Coefficient_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// ****************************Quality of Life -- > Education: Population with
	// (at least) High School degree (%) Test Cases*************************
	// Verify for Education: Population with (at least) High School degree (%) gets
	// added by default with "Data" ad "Details" tab.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 171, enabled = true, description = "Verify for Education: Population with (at least) High School degree (%) gets added by default with Data and Details tab.")
	public void Community_Education_HighSchoolPopulation_With_DataAndDetails_Display() {

		log.info(
				"Community_Education_HighSchoolPopulation_With_DataAndDetails_Display method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004564";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEducation_HighSchoolPopulation();
			flag = CommunitiesPage.CheckEducation_HighSchoolPopulation_Data_DetailsTab_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Education_HighSchoolPopulation_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Education_HighSchoolPopulation_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify 'Add year' button adds line item with year for previous year.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Education_HighSchoolPopulation_With_DataAndDetails_Display", priority = 171, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
	public void Community_Education_HighSchoolPopulation_AddYear_AddNewLine() {

		log.info("Community_Education_HighSchoolPopulation_AddYear_AddNewLine method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004564";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEducation_HighSchoolPopulation();
			flag = CommunitiesPage.CheckEducation_HighSchoolPopulation_AddYear_NewRow_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Education_HighSchoolPopulation_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Education_HighSchoolPopulation_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify validation Message after adding Invalid Percent value(Test Data - 101)

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Education_HighSchoolPopulation_AddYear_AddNewLine", priority = 171, enabled = true, description = "Verify validation Message after adding Invalid Percent value(Test Data - 101)")
	public void Community_Education_HighSchoolPopulation_SaveWithInvalidPercent() {

		log.info("Community_Education_HighSchoolPopulation_AddYear_AddNewLine method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000006849";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEducation_HighSchoolPopulation();
			flag = CommunitiesPage.CheckEducation_HighSchoolPopulation_CheckWithInvalidPercent();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Education_HighSchoolPopulation_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Education_HighSchoolPopulation_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Quality Of Life--> Education: Population with (at least) High School degree
	// (%) - Verify by adding value to reading and clicking on save button for
	// previous year.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Education_HighSchoolPopulation_AddYear_AddNewLine", priority = 172, enabled = true, description = "Quality Of Life --> Education: Population with (at least) High School degree (%) - >Verify by adding value to reading and clicking on save button for previous year. ")
	public void Community_Education_HighSchoolPopulation_SavePreviousYearData() {

		log.info("Community_Education_HighSchoolPopulation_SavePreviousYearData method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004564";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEducation_HighSchoolPopulation();
			flag = CommunitiesPage.CheckEducation_HighSchoolPopulation_SaveNewRecord();

			if (flag) {
				log.info("Community_Education_HighSchoolPopulation_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not added successfully");
				log.info("Community_Education_HighSchoolPopulation_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Education_HighSchoolPopulation_SavePreviousYearData method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Education: Population with (at least) High School degree
	// (%) - >Verify 'previous year' and 'next year' button adds reading
	// respectively.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 172, dependsOnMethods = "Community_Education_HighSchoolPopulation_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Education: Population with (at least) High School degree (%) - > Verify 'previous year' and 'next year' button adds reading respectively.")
	public void Community_Education_HighSchoolPopulation_AddRow_PreviousYear_NextYear() {

		log.info(
				"Community_Education_HighSchoolPopulation_AddRow_PreviousYear_NextYear method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004564";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEducation_HighSchoolPopulation();
			flag = CommunitiesPage.Education_HighSchoolPopulation_SavePreviousAndNextYearRecord();
			if (flag) {
				log.info(
						"Community_Education_HighSchoolPopulation_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info(
						"Community_Education_HighSchoolPopulation_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Education_HighSchoolPopulation_AddRow_PreviousYear_NextYear method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Education: Population with (at least) High School degree
	// (%) - Verify able to edit readings by using 'Edit' button.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 173, dependsOnMethods = "Community_Education_HighSchoolPopulation_SavePreviousYearData", enabled = true, description = "Quality Of Life-->Education: Population with (at least) High School degree (%)  - >Verify able to edit readings by using 'Edit' button.")

	public void Community_Education_HighSchoolPopulation_Edit_Test() {

		log.info("Community_Education_HighSchoolPopulation_Edit_Test method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004564";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEducation_HighSchoolPopulation();
			flag = CommunitiesPage.CheckEducation_HighSchoolPopulation_EditRecord();

			if (flag) {
				log.info("Record is updated successfully");
				log.info("Community_Education_HighSchoolPopulation_Edit_Test method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not updated successfully");
				log.info("Community_Education_HighSchoolPopulation_Edit_Test method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Education_HighSchoolPopulation_Edit_Test method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Education: Population with (at least) High School degree
	// (%) - Verify able to delete line item by using delete button.
	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Education_HighSchoolPopulation_SavePreviousYearData", priority = 174, enabled = true, description = "Quality Of Life--> Education: Population with (at least) High School degree (%) - Verify able to delete line item by using delete button.")
	public void Community_Education_HighSchoolPopulation_Delete_Row() {

		log.info("Community_Education_HighSchoolPopulation_Delete_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004564";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEducation_HighSchoolPopulation();
			flag = CommunitiesPage.Education_HighSchoolPopulation_DeleteRow();

			if (flag) {

				log.info("Record is deleted successfully");
				log.info("Community_Education_HighSchoolPopulation_Delete_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not deleted successfully");
				log.info("Community_Education_HighSchoolPopulation_Delete_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Education_HighSchoolPopulation_Delete_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Education: Population with (at least) High School degree
	// (%) - Verify filter button - From (Start date) and To (End date) uopens up
	// decade calendar and on selecting any year range, the line items falling into
	// those year should be displayed.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 175, enabled = true, description = "Quality Of Life--> Education: Population with (at least) High School degree (%) - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
	public void Community_Education_HighSchoolPopulation_FilterTest() {

		log.info("Community_Education_HighSchoolPopulation_FilterTest method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Perf4");
		// ProjectCommunityID="8000011517";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEducation_HighSchoolPopulation();
			flag = CommunitiesPage.CheckEducation_HighSchoolPopulation_Filter();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Education_HighSchoolPopulation_FilterTest method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Education_HighSchoolPopulation_FilterTest method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Quality Of Life--> Education: Population with (at least) High School degree
	// (%) --> Verify 'Comments' section by adding comment should show correct
	// timestamp.
	// Quality Of Life--> Education: Population with (at least) High School degree
	// (%) -->'Activity' section should show correct activity with date and
	// timestamp.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 176, enabled = false, description = "Quality Of Life--> Education: Population with (at least) High School degree (%)  -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void Community_Equitability_Gini_Coefficient_Comments_Activity_Test1() {

		log.info("Community_Equitability_Gini_Coefficient_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004527";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEquitability_Gini_Coeffiecient();

			flag = CommunitiesPage.checkTransportCommentAndActivity(data.getCellData("Communities", 23, 2), ProfileUserName);

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Community_Equitability_Gini_Coefficient_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Equitability_Gini_Coefficient_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

//****************************Quality of Life -- >	Prosperity: Median household income (US Dollars/Year) Test Cases*************************
	// Verify for Prosperity: Median household income (US Dollars/Year) gets added
	// by default with "Data" ad "Details" tab.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 177, enabled = true, description = "Verify for Prosperity: Median household income (US Dollars/Year) gets added by default with Data and Details tab.")
	public void Community_ProsperityMedianIncome_With_DataAndDetails_Display() {

		log.info("Community_ProsperityMedianIncome_With_DataAndDetails_Display method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004567";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProsperity_MedianIncome();
			flag = CommunitiesPage.CheckProsperityMedianIncome_Data_DetailsTab_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_ProsperityMedianIncome_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_ProsperityMedianIncome_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify 'Add year' button adds line item with year for previous year.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_ProsperityMedianIncome_With_DataAndDetails_Display", priority = 177, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
	public void Community_ProsperityMedianIncome_AddYear_AddNewLine() {

		log.info("Community_ProsperityMedianIncome_AddYear_AddNewLine method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004567";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProsperity_MedianIncome();
			flag = CommunitiesPage.CheckProsperityMedianIncome_AddYear_NewRow_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_ProsperityMedianIncome_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_ProsperityMedianIncome_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Quality Of Life--> Prosperity: Median household income (US Dollars/Year) -
	// Verify by adding value to reading and clicking on save button for previous
	// year.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_ProsperityMedianIncome_AddYear_AddNewLine", priority = 177, enabled = true, description = "Quality Of Life --> Prosperity: Median household income (US Dollars/Year) - >Verify by adding value to reading and clicking on save button for previous year. ")
	public void Community_ProsperityMedianIncome_SavePreviousYearData() {

		log.info("Community_ProsperityMedianIncome_SavePreviousYearData method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004567";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProsperity_MedianIncome();
			flag = CommunitiesPage.CheckProsperityMedianIncome_SaveNewRecord();

			if (flag) {
				log.info("Community_ProsperityMedianIncome_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not added successfully");
				log.info("Community_ProsperityMedianIncome_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_ProsperityMedianIncome_SavePreviousYearData method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Prosperity: Median household income (US Dollars/Year) -
	// >Verify 'previous year' and 'next year' button adds reading respectively.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 177, dependsOnMethods = "Community_ProsperityMedianIncome_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Prosperity: Median household income (US Dollars/Year)  - > Verify 'previous year' and 'next year' button adds reading respectively.")
	public void Community_ProsperityMedianIncome_AddRow_PreviousYear_NextYear() {

		log.info("Community_ProsperityMedianIncome_AddRow_PreviousYear_NextYear method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004567";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProsperity_MedianIncome();
			flag = CommunitiesPage.ProsperityMedianIncome_SavePreviousAndNextYearRecord();
			if (flag) {
				log.info("Community_ProsperityMedianIncome_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info("Community_ProsperityMedianIncome_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_ProsperityMedianIncome_AddRow_PreviousYear_NextYear method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Prosperity: Median household income (US Dollars/Year) -
	// Verify able to edit readings by using 'Edit' button.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 178, dependsOnMethods = "Community_ProsperityMedianIncome_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Prosperity: Median household income (US Dollars/Year)   - >Verify able to edit readings by using 'Edit' button.")

	public void Community_ProsperityMedianIncome_Edit_Test() {

		log.info("Community_ProsperityMedianIncome_Edit_Test method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004567";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProsperity_MedianIncome();
			flag = CommunitiesPage.CheckProsperityMedianIncome_EditRecord();

			if (flag) {
				log.info("Record is updated successfully");
				log.info("Community_ProsperityMedianIncome_Edit_Test method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not updated successfully");
				log.info("Community_ProsperityMedianIncome_Edit_Test method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_ProsperityMedianIncome_Edit_Test method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Prosperity: Median household income (US Dollars/Year) -
	// Verify able to delete line item by using delete button.
	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_ProsperityMedianIncome_SavePreviousYearData", priority = 179, enabled = true, description = "Quality Of Life--> Prosperity: Median household income (US Dollars/Year) - Verify able to delete line item by using delete button.")
	public void Community_ProsperityMedianIncome_Delete_Row() {

		log.info("Community_ProsperityMedianIncome_Delete_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004567";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProsperity_MedianIncome();
			flag = CommunitiesPage.ProsperityMedianIncome_DeleteRow();

			if (flag) {

				log.info("Record is deleted successfully");
				log.info("Community_ProsperityMedianIncome_Delete_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not deleted successfully");
				log.info("Community_ProsperityMedianIncome_Delete_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_ProsperityMedianIncome_Delete_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Prosperity: Median household income (US Dollars/Year) -
	// Verify filter button - From (Start date) and To (End date) uopens up decade
	// calendar and on selecting any year range, the line items falling into those
	// year should be displayed.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_ProsperityMedianIncome_SavePreviousYearData", priority = 180, enabled = true, description = "Quality Of Life--> Prosperity: Median household income (US Dollars/Year) - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
	public void Community_ProsperityMedianIncome_FilterTest() {

		log.info("Community_ProsperityMedianIncome_FilterTest method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Perf4");
		// ProjectCommunityID="8000004568";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProsperity_MedianIncome();
			flag = CommunitiesPage.CheckProsperityMedianIncome_Filter();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_ProsperityMedianIncome_FilterTest method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_ProsperityMedianIncome_FilterTest method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Quality Of Life--> Prosperity: Median household income (US Dollars/Year) -->
	// Verify 'Comments' section by adding comment should show correct timestamp.
	// Quality Of Life--> Prosperity: Median household income (US Dollars/Year)
	// -->'Activity' section should show correct activity with date and
	// timestamp.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 180, enabled = false, description = "Quality Of Life--> Prosperity: Median household income (US Dollars/Year)  -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void Community_ProsperityMedianIncome_Comments_Activity_Test() {

		log.info("Community_ProsperityMedianIncome_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004527";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEquitability_Gini_Coeffiecient();
			flag = CommunitiesPage.checkTransportCommentAndActivity(data.getCellData("Communities", 25, 2), ProfileUserName);

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Community_ProsperityMedianIncome_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_ProsperityMedianIncome_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

//****************************Quality of Life -- >	Equitability: Median gross rent as (%) of household income Test Cases*************************
	// Verify for Equitability: Median gross rent as (%) of household income gets
	// added by default with "Data" ad "Details" tab.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 183, enabled = true, description = "Verify for Equitability: Median gross rent as (%) of household income gets added by default with Data and Details tab.")
	public void Community_Equitability_MedianGrossIncome_With_DataAndDetails_Display() {

		log.info(
				"Community_Equitability_MedianGrossIncome_With_DataAndDetails_Display method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004567";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEquitability_MedianGrossIncome();
			flag = CommunitiesPage.CheckEquitability_MedianGrossIncome_Data_DetailsTab_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Equitability_MedianGrossIncome_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Equitability_MedianGrossIncome_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify 'Add year' button adds line item with year for previous year.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Equitability_MedianGrossIncome_With_DataAndDetails_Display", priority = 183, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
	public void Community_Equitability_MedianGrossIncome_AddYear_AddNewLine() {

		log.info("Community_Equitability_MedianGrossIncome_AddYear_AddNewLine method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004567";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEquitability_MedianGrossIncome();
			flag = CommunitiesPage.CheckEquitability_MedianGrossIncome_AddYear_NewRow_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Equitability_MedianGrossIncome_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Equitability_MedianGrossIncome_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify validation Message after adding Invalid Percent value(Test Data - 101)

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Equitability_MedianGrossIncome_AddYear_AddNewLine", priority = 183, enabled = true, description = "Verify validation Message after adding Invalid Percent value(Test Data - 101)")
	public void Community_Equitability_MedianGrossIncome_SaveWithInvalidPercent() {

		log.info("Community_Equitability_MedianGrossIncome_SaveWithInvalidPercent method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000006849";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEquitability_MedianGrossIncome();
			flag = CommunitiesPage.CheckEquitability_MedianGrossIncome_CheckWithInvalidPercentValue();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Equitability_MedianGrossIncome_SaveWithInvalidPercent method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Equitability_MedianGrossIncome_SaveWithInvalidPercent method ends here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Quality Of Life--> Equitability: Median gross rent as (%) of household income
	// - Verify by adding value to reading and clicking on save button for previous
	// year

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Equitability_MedianGrossIncome_AddYear_AddNewLine", priority = 184, enabled = true, description = "Quality Of Life --> Equitability: Median gross rent as (%) of household income - >Verify by adding value to reading and clicking on save button for previous year  ")
	public void Community_Equitability_MedianGrossIncome_SavePreviousYearData() {

		log.info("Community_Equitability_MedianGrossIncome_SavePreviousYearData method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004567";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEquitability_MedianGrossIncome();
			flag = CommunitiesPage.CheckEquitability_MedianGrossIncome_SaveNewRecord();

			if (flag) {
				log.info("Community_Equitability_MedianGrossIncome_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not added successfully");
				log.info("Community_Equitability_MedianGrossIncome_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Equitability_MedianGrossIncome_SavePreviousYearData method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Equitability: Median gross rent as (%) of household income
	// - >Verify 'previous year' and 'next year' button adds reading respectively.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 184, dependsOnMethods = "Community_Equitability_MedianGrossIncome_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Equitability: Median gross rent as (%) of household income  - > Verify 'previous year' and 'next year' button adds reading respectively.")
	public void Community_Equitability_MedianGrossIncome_AddRow_PreviousYear_NextYear() {

		log.info(
				"Community_Equitability_MedianGrossIncome_AddRow_PreviousYear_NextYear method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004567";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEquitability_MedianGrossIncome();
			flag = CommunitiesPage.Equitability_MedianGrossIncome_SavePreviousAndNextYearRecord();
			if (flag) {
				log.info(
						"Community_Equitability_MedianGrossIncome_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info(
						"Community_Equitability_MedianGrossIncome_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Equitability_MedianGrossIncome_AddRow_PreviousYear_NextYear method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Equitability: Median gross rent as (%) of household income
	// - Verify able to edit readings by using 'Edit' button.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 185, dependsOnMethods = "Community_Equitability_MedianGrossIncome_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Equitability: Median gross rent as (%) of household income   - >Verify able to edit readings by using 'Edit' button.")

	public void Community_Equitability_MedianGrossIncome_Edit_Test() {

		log.info("Community_Equitability_MedianGrossIncome_Edit_Test method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004567";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEquitability_MedianGrossIncome();
			flag = CommunitiesPage.CheckEquitability_MedianGrossIncome_EditRecord();

			if (flag) {
				log.info("Record is updated successfully");
				log.info("Community_Equitability_MedianGrossIncome_Edit_Test method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not updated successfully");
				log.info("Community_Equitability_MedianGrossIncome_Edit_Test method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Equitability_MedianGrossIncome_Edit_Test method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Equitability: Median gross rent as (%) of household income
	// - Verify able to delete line item by using delete button.
	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Equitability_MedianGrossIncome_SavePreviousYearData", priority = 186, enabled = true, description = "Quality Of Life--> Equitability: Median gross rent as (%) of household income - Verify able to delete line item by using delete button.")
	public void Community_Equitability_MedianGrossIncome_Delete_Row() {

		log.info("Community_Equitability_MedianGrossIncome_Delete_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004567";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEquitability_MedianGrossIncome();
			flag = CommunitiesPage.Equitability_MedianGrossIncome_DeleteRow();

			if (flag) {

				log.info("Record is deleted successfully");
				log.info("Community_Equitability_MedianGrossIncome_Delete_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not deleted successfully");
				log.info("Community_Equitability_MedianGrossIncome_Delete_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_Equitability_MedianGrossIncome_Delete_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Equitability: Median gross rent as (%) of household income
	// - Verify filter button - From (Start date) and To (End date) uopens up decade
	// calendar and on selecting any year range, the line items falling into those
	// year should be displayed.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_Equitability_MedianGrossIncome_SavePreviousYearData", priority = 187, enabled = true, description = "Quality Of Life--> Equitability: Median gross rent as (%) of household income - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
	public void Community_Equitability_MedianGrossIncome_FilterTest() {

		log.info("Community_Equitability_MedianGrossIncome_FilterTest method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Perf4");
		// ProjectCommunityID="8000004568";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEquitability_MedianGrossIncome();
			flag = CommunitiesPage.CheckEquitability_MedianGrossIncome_Filter();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_Equitability_MedianGrossIncome_FilterTest method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Equitability_MedianGrossIncome_FilterTest method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Quality Of Life--> Equitability: Median gross rent as (%) of household income
	// --> Verify 'Comments' section by adding comment should show correct
	// timestamp.
	// Quality Of Life--> Equitability: Median gross rent as (%) of household income
	// -->'Activity' section should show correct activity with date and
	// timestamp.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 187, enabled = false, description = "Quality Of Life--> Equitability: Median gross rent as (%) of household income  -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void Community_Equitability_MedianGrossIncome_Comments_Activity_Test() {

		log.info("Community_Equitability_MedianGrossIncome_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004527";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonEquitability_MedianGrossIncome();
			flag = CommunitiesPage.checkTransportCommentAndActivity(data.getCellData("Communities", 27, 2), ProfileUserName);

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Community_Equitability_MedianGrossIncome_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Equitability_MedianGrossIncome_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

//****************************Quality of Life -- >	Prosperity: Unemployment rate (%) Test Cases*************************
	// Verify for Prosperity: Unemployment rate (%) gets added by default with
	// "Data" ad "Details" tab.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 189, enabled = true, description = "Verify for Prosperity: Unemployment rate (%) gets added by default with Data and Details tab.")
	public void Community_ProsperityUnemployementRate_With_DataAndDetails_Display() {

		log.info(
				"Community_ProsperityUnemployementRate_With_DataAndDetails_Display method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000006625";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProsperityUnemployementRate();
			flag = CommunitiesPage.CheckProsperityUnemployementRate_Data_DetailsTab_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_ProsperityUnemployementRate_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_ProsperityUnemployementRate_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify 'Add year' button adds line item with year for previous year.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_ProsperityUnemployementRate_With_DataAndDetails_Display", priority = 189, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
	public void Community_ProsperityUnemployementRate_AddYear_AddNewLine() {

		log.info("Community_ProsperityUnemployementRate_AddYear_AddNewLine method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000006625";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProsperityUnemployementRate();
			flag = CommunitiesPage.CheckProsperityUnemployementRate_AddYear_NewRow_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_ProsperityUnemployementRate_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_ProsperityUnemployementRate_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify validation Message after adding Invalid Percent value(Test Data - 101)

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_ProsperityUnemployementRate_AddYear_AddNewLine", priority = 189, enabled = true, description = "Verify validation Message after adding Invalid Percent value(Test Data - 101)")
	public void Community_ProsperityUnemployementRate_SaveWithInvalidPercent() {

		log.info("Community_ProsperityUnemployementRate_SaveWithInvalidPercent method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000006844";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProsperityUnemployementRate();
			flag = CommunitiesPage.CheckProsperityUnemployementRate_CheckWithInvalidValue();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_ProsperityUnemployementRate_SaveWithInvalidPercent method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_ProsperityUnemployementRate_SaveWithInvalidPercent method ends here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Quality Of Life--> Prosperity: Unemployment rate (%) - Verify by adding value
	// to reading and clicking on save button for previous year

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_ProsperityUnemployementRate_AddYear_AddNewLine", priority = 190, enabled = true, description = "Quality Of Life --> Prosperity: Unemployment rate (%) - >Verify by adding value to reading and clicking on save button for previous year  ")
	public void Community_ProsperityUnemployementRate_SavePreviousYearData() {

		log.info("Community_ProsperityUnemployementRate_SavePreviousYearData method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000006625";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProsperityUnemployementRate();
			flag = CommunitiesPage.CheckProsperityUnemployementRate_SaveNewRecord();

			if (flag) {
				log.info("Community_ProsperityUnemployementRate_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not added successfully");
				log.info("Community_ProsperityUnemployementRate_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_ProsperityUnemployementRate_SavePreviousYearData method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Prosperity: Unemployment rate (%) - >Verify 'previous
	// year' and 'next year' button adds reading respectively.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 190, dependsOnMethods = "Community_ProsperityUnemployementRate_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Prosperity: Unemployment rate (%)  - > Verify 'previous year' and 'next year' button adds reading respectively.")
	public void Community_ProsperityUnemployementRate_AddRow_PreviousYear_NextYear() {

		log.info(
				"Community_ProsperityUnemployementRate_AddRow_PreviousYear_NextYear method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000006625";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProsperityUnemployementRate();
			flag = CommunitiesPage.ProsperityUnemployementRate_SavePreviousAndNextYearRecord();
			if (flag) {
				log.info("Community_ProsperityUnemployementRate_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info("Community_ProsperityUnemployementRate_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_ProsperityUnemployementRate_AddRow_PreviousYear_NextYear method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Prosperity: Unemployment rate (%) - Verify able to edit
	// readings by using 'Edit' button.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 191, dependsOnMethods = "Community_ProsperityUnemployementRate_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Prosperity: Unemployment rate (%)   - >Verify able to edit readings by using 'Edit' button.")

	public void Community_ProsperityUnemployementRate_Edit_Test() {

		log.info("Community_ProsperityUnemployementRate_Edit_Test method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000006625";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProsperityUnemployementRate();
			flag = CommunitiesPage.CheckProsperityUnemployementRate_EditRecord();

			if (flag) {
				log.info("Record is updated successfully");
				log.info("Community_ProsperityUnemployementRate_Edit_Test method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not updated successfully");
				log.info("Community_ProsperityUnemployementRate_Edit_Test method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_ProsperityUnemployementRate_Edit_Test method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Prosperity: Unemployment rate (%) - Verify able to delete
	// line item by using delete button.
	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_ProsperityUnemployementRate_SavePreviousYearData", priority = 192, enabled = true, description = "Quality Of Life--> Prosperity: Unemployment rate (%) - Verify able to delete line item by using delete button.")
	public void Community_ProsperityUnemployementRate_Delete_Row() {

		log.info("Community_ProsperityUnemployementRate_Delete_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000006625";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProsperityUnemployementRate();
			flag = CommunitiesPage.ProsperityUnemployementRate_DeleteRow();

			if (flag) {

				log.info("Record is deleted successfully");
				log.info("Community_ProsperityUnemployementRate_Delete_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not deleted successfully");
				log.info("Community_ProsperityUnemployementRate_Delete_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_ProsperityUnemployementRate_Delete_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Prosperity: Unemployment rate (%) - Verify filter button -
	// From (Start date) and To (End date) uopens up decade calendar and on
	// selecting any year range, the line items falling into those year should be
	// displayed.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_ProsperityUnemployementRate_SavePreviousYearData", priority = 193, enabled = true, description = "Quality Of Life--> Prosperity: Unemployment rate (%) - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
	public void Community_ProsperityUnemployementRate_FilterTest() {

		log.info("Community_ProsperityUnemployementRate_FilterTest method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Perf4");
		// ProjectCommunityID="8000006626";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProsperityUnemployementRate();
			flag = CommunitiesPage.CheckProsperityUnemployementRate_Filter();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_ProsperityUnemployementRate_FilterTest method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_ProsperityUnemployementRate_FilterTest method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Quality Of Life--> Prosperity: Unemployment rate (%) --> Verify 'Comments'
	// section by adding comment should show correct timestamp.
	// Quality Of Life--> Prosperity: Unemployment rate (%) -->'Activity' section
	// should show correct activity with date and
	// timestamp.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 193, enabled = false, description = "Quality Of Life--> Prosperity: Unemployment rate (%)  -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void Community_ProsperityUnemployementRate_Comments_Activity_Test() {

		log.info("Community_ProsperityUnemployementRate_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID = "8000004568";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonProsperityUnemployementRate();
			flag = CommunitiesPage.checkProsperityUnemployementRate(data.getCellData("Communities", 29, 2), ProfileUserName);

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Community_ProsperityUnemployementRate_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_ProsperityUnemployementRate_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// ****************************Quality of Life -- > Health & Safety: Air quality
	// days unhealthy for sensitive groups (Days/yr) Test
	// Cases*************************
	// Verify for Health & Safety: Air quality days unhealthy for sensitive groups
	// (Days/yr) gets added by default with "Data" ad "Details" tab.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 195, enabled = true, description = "Verify for Health & Safety: Air quality days unhealthy for sensitive groups (Days/yr) gets added by default with Data and Details tab.")
	public void Community_HealthAndSafetySensitiveGroup_With_DataAndDetails_Display() {

		log.info(
				"Community_HealthAndSafetySensitiveGroup_With_DataAndDetails_Display method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004567";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonHealthAndSafetySensitiveGroup();
			flag = CommunitiesPage.CheckHealthAndSafetySensitiveGroup_Data_DetailsTab_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_HealthAndSafetySensitiveGroup_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_HealthAndSafetySensitiveGroup_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify 'Add year' button adds line item with year for previous year.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_HealthAndSafetySensitiveGroup_With_DataAndDetails_Display", priority = 195, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
	public void Community_HealthAndSafetySensitiveGroup_AddYear_AddNewLine() {

		log.info("Community_HealthAndSafetySensitiveGroup_AddYear_AddNewLine method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004567";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonHealthAndSafetySensitiveGroup();
			flag = CommunitiesPage.CheckHealthAndSafetySensitiveGroup_AddYear_NewRow_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("CheckHealthAndSafetySensitiveGroup_AddYear_NewRow_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_HealthAndSafetySensitiveGroup_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify validation Message after adding Invalid value(Test Data - 366)

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 195, dependsOnMethods = "Community_HealthAndSafetySensitiveGroup_AddYear_AddNewLine", enabled = true, description = "Verify validation Message after adding Invalid value(Test Data - 366)")
	public void Community_HealthAndSafetySensitiveGroup_SaveWithInvalidValue() {

		log.info("Community_HealthAndSafetySensitiveGroup_SaveWithInvalidValue method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000006844";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonHealthAndSafetySensitiveGroup();
			flag = CommunitiesPage.CheckHealthAndSafetySensitiveGroup_CheckWithInvalidValue();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_HealthAndSafetySensitiveGroup_SaveWithInvalidValue method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_HealthAndSafetySensitiveGroup_SaveWithInvalidValue method ends here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive
	// groups (Days/yr) - Verify by adding value to reading and clicking on save
	// button for previous year

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_HealthAndSafetySensitiveGroup_AddYear_AddNewLine", priority = 196, enabled = true, description = "Quality Of Life --> Health & Safety: Air quality days unhealthy for sensitive groups (Days/yr) - >Verify by adding value to reading and clicking on save button for previous year ")
	public void Community_HealthAndSafetySensitiveGroup_SavePreviousYearData() {

		log.info("Community_HealthAndSafetySensitiveGroup_SavePreviousYearData method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004567";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonHealthAndSafetySensitiveGroup();
			flag = CommunitiesPage.CheckHealthAndSafetySensitiveGroup_SaveNewRecord();

			if (flag) {
				log.info("Community_HealthAndSafetySensitiveGroup_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not added successfully");
				log.info("Community_HealthAndSafetySensitiveGroup_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_HealthAndSafetySensitiveGroup_SavePreviousYearData method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive
	// groups (Days/yr) - >Verify 'previous year' and 'next year' button adds
	// reading respectively.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 196, dependsOnMethods = "Community_HealthAndSafetySensitiveGroup_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive groups (Days/yr)  - > Verify 'previous year' and 'next year' button adds reading respectively.")
	public void Community_HealthAndSafetySensitiveGroup_AddRow_PreviousYear_NextYear() {

		log.info(
				"Community_HealthAndSafetySensitiveGroup_AddRow_PreviousYear_NextYear method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004567";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonHealthAndSafetySensitiveGroup();
			flag = CommunitiesPage.HealthAndSafetySensitiveGroup_SavePreviousAndNextYearRecord();
			if (flag) {
				log.info(
						"Community_HealthAndSafetySensitiveGroup_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info(
						"Community_HealthAndSafetySensitiveGroup_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_HealthAndSafetySensitiveGroup_AddRow_PreviousYear_NextYear method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive
	// groups (Days/yr) - Verify able to edit readings by using 'Edit' button.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 197, dependsOnMethods = "Community_HealthAndSafetySensitiveGroup_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive groups (Days/yr)   - >Verify able to edit readings by using 'Edit' button.")

	public void Community_HealthAndSafetySensitiveGroup_Edit_Test() {

		log.info("Community_HealthAndSafetySensitiveGroup_Edit_Test method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004567";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonHealthAndSafetySensitiveGroup();
			flag = CommunitiesPage.CheckHealthAndSafetySensitiveGroup_EditRecord();

			if (flag) {
				log.info("Record is updated successfully");
				log.info("Community_HealthAndSafetySensitiveGroup_Edit_Test method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not updated successfully");
				log.info("Community_HealthAndSafetySensitiveGroup_Edit_Test method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_HealthAndSafetySensitiveGroup_Edit_Test method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive
	// groups (Days/yr) - Verify able to delete line item by using delete button.
	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_HealthAndSafetySensitiveGroup_SavePreviousYearData", priority = 198, enabled = true, description = "Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive groups (Days/yr) - Verify able to delete line item by using delete button.")
	public void Community_HealthAndSafetySensitiveGroup_Delete_Row() {

		log.info("Community_HealthAndSafetySensitiveGroup_Delete_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004567";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonHealthAndSafetySensitiveGroup();
			flag = CommunitiesPage.HealthAndSafetySensitiveGroup_DeleteRow();

			if (flag) {

				log.info("Record is deleted successfully");
				log.info("Community_HealthAndSafetySensitiveGroup_Delete_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not deleted successfully");
				log.info("Community_HealthAndSafetySensitiveGroup_Delete_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_HealthAndSafetySensitiveGroup_Delete_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive
	// groups (Days/yr) - Verify filter button - From (Start date) and To (End date)
	// uopens up decade calendar and on selecting any year range, the line items
	// falling into those year should be displayed.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_HealthAndSafetySensitiveGroup_SavePreviousYearData", priority = 199, enabled = true, description = "Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive groups (Days/yr) - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
	public void Community_HealthAndSafetySensitiveGroup_FilterTest() {

		log.info("Community_HealthAndSafetySensitiveGroup_FilterTest method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Perf4");
		// ProjectCommunityID="8000004568";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonHealthAndSafetySensitiveGroup();
			flag = CommunitiesPage.CheckHealthAndSafetySensitiveGroup_Filter();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_HealthAndSafetySensitiveGroup_FilterTest method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_HealthAndSafetySensitiveGroup_FilterTest method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive
	// groups (Days/yr) --> Verify 'Comments' section by adding comment should show
	// correct timestamp.
	// Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive
	// groups (Days/yr) -->'Activity' section should show correct activity with date
	// and
	// timestamp.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 199, enabled = false, description = "Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive groups (Days/yr)  -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void Community_Community_HealthAndSafetySensitiveGroup_Comments_Activity_Test() {

		log.info(
				"Community_Community_HealthAndSafetySensitiveGroup_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004568";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonHealthAndSafetySensitiveGroup();
			flag = CommunitiesPage.checkHealthAndSafetySensitiveGroup(data.getCellData("Communities", 31, 2), ProfileUserName);

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Community_Community_HealthAndSafetySensitiveGroup_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Community_HealthAndSafetySensitiveGroup_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// ****************************Quality of Life -- > Health & Safety: Violent
	// Crime (per year per capita) Test Cases*************************
	// Verify for Health & Safety: Violent Crime (per year per capita) gets added by
	// default with "Data" ad "Details" tab.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 201, enabled = true, description = "Verify for Health & Safety: Violent Crime (per year per capita) gets added by default with Data and Details tab.")
	public void Community_HealthAndSafetyVoilentCrime_With_DataAndDetails_Display() {

		log.info(
				"Community_HealthAndSafetyVoilentCrime_With_DataAndDetails_Display method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("CommunitiesProject_NonLeed2","8000004525");
		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004567";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonHealthAndSafetyVoilentCrime();
			flag = CommunitiesPage.CheckHealthAndSafetyVoilentCrime_Data_DetailsTab_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_HealthAndSafetyVoilentCrime_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_HealthAndSafetyVoilentCrime_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify 'Add year' button adds line item with year for previous year.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_HealthAndSafetyVoilentCrime_With_DataAndDetails_Display", priority = 201, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
	public void Community_HealthAndSafetyVoilentCrime_AddYear_AddNewLine() {

		log.info("Community_HealthAndSafetyVoilentCrime_AddYear_AddNewLine method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004567";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonHealthAndSafetyVoilentCrime();
			flag = CommunitiesPage.CheckHealthAndSafetyVoilentCrime_AddYear_NewRow_Display();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_HealthAndSafetyVoilentCrime_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_HealthAndSafetyVoilentCrime_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Quality Of Life--> Health & Safety: Violent Crime (per year per capita) -
	// Verify by adding value to reading and clicking on save button for previous
	// year

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_HealthAndSafetyVoilentCrime_AddYear_AddNewLine", priority = 201, enabled = true, description = "Quality Of Life --> Health & Safety: Violent Crime (per year per capita) - >Verify by adding value to reading and clicking on save button for previous year ")
	public void Community_HealthAndSafetyVoilentCrime_SavePreviousYearData() {

		log.info("Community_HealthAndSafetyVoilentCrime_SavePreviousYearData method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004567";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonHealthAndSafetyVoilentCrime();
			flag = CommunitiesPage.CheckHealthAndSafetyVoilentCrime_SaveNewRecord();

			if (flag) {
				log.info("Community_HealthAndSafetyVoilentCrime_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not added successfully");
				log.info("Community_HealthAndSafetyVoilentCrime_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_HealthAndSafetyVoilentCrime_SavePreviousYearData method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Health & Safety: Violent Crime (per year per capita) -
	// >Verify 'previous year' and 'next year' button adds reading respectively.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 201, dependsOnMethods = "Community_HealthAndSafetyVoilentCrime_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Health & Safety: Violent Crime (per year per capita)  - > Verify 'previous year' and 'next year' button adds reading respectively.")
	public void Community_HealthAndSafetyVoilentCrime_AddRow_PreviousYear_NextYear() {

		log.info(
				"Community_HealthAndSafetyVoilentCrime_AddRow_PreviousYear_NextYear method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004567";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonHealthAndSafetyVoilentCrime();
			flag = CommunitiesPage.HealthAndSafetyVoilentCrime_SavePreviousAndNextYearRecord();
			if (flag) {
				log.info("Community_HealthAndSafetyVoilentCrime_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info("Community_HealthAndSafetyVoilentCrime_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_HealthAndSafetyVoilentCrime_AddRow_PreviousYear_NextYear method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Health & Safety: Violent Crime (per year per capita) -
	// Verify able to edit readings by using 'Edit' button.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 202, dependsOnMethods = "Community_HealthAndSafetyVoilentCrime_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Health & Safety: Violent Crime (per year per capita)   - >Verify able to edit readings by using 'Edit' button.")

	public void Community_HealthAndSafetyVoilentCrime_Edit_Test() {

		log.info("Community_HealthAndSafetyVoilentCrime_Edit_Test method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004567";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonHealthAndSafetyVoilentCrime();
			flag = CommunitiesPage.CheckHealthAndSafetyVoilentCrime_EditRecord();

			if (flag) {
				log.info("Record is updated successfully");
				log.info("Community_HealthAndSafetyVoilentCrime_Edit_Test method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not updated successfully");
				log.info("Community_HealthAndSafetyVoilentCrime_Edit_Test method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_HealthAndSafetyVoilentCrime_Edit_Test method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Health & Safety: Violent Crime (per year per capita) -
	// Verify able to delete line item by using delete button.
	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_HealthAndSafetyVoilentCrime_SavePreviousYearData", priority = 203, enabled = true, description = "Quality Of Life--> Health & Safety: Violent Crime (per year per capita) - Verify able to delete line item by using delete button.")
	public void Community_HealthAndSafetyVoilentCrime_Delete_Row() {

		log.info("Community_HealthAndSafetyVoilentCrime_Delete_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000004567";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonHealthAndSafetyVoilentCrime();
			flag = CommunitiesPage.HealthAndSafetyVoilentCrime_DeleteRow();

			if (flag) {

				log.info("Record is deleted successfully");
				log.info("Community_HealthAndSafetyVoilentCrime_Delete_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not deleted successfully");
				log.info("Community_HealthAndSafetyVoilentCrime_Delete_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Community Project is showing Null");
			log.info("Community_HealthAndSafetyVoilentCrime_Delete_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Health & Safety: Violent Crime (per year per capita) -
	// Verify filter button - From (Start date) and To (End date) uopens up decade
	// calendar and on selecting any year range, the line items falling into those
	// year should be displayed.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Community_HealthAndSafetyVoilentCrime_SavePreviousYearData", priority = 204, enabled = true, description = "Quality Of Life--> Health & Safety: Violent Crime (per year per capita) - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
	public void Community_HealthAndSafetyVoilentCrime_FilterTest() {

		log.info("Community_HealthAndSafetyVoilentCrime_FilterTest method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Perf4");
		// ProjectCommunityID="8000004568";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonHealthAndSafetyVoilentCrime();
			flag = CommunitiesPage.CheckHealthAndSafetyVoilentCrime_Filter();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("Community_HealthAndSafetyVoilentCrime_FilterTest method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_HealthAndSafetyVoilentCrime_FilterTest method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Quality Of Life--> Health & Safety: Violent Crime (per year per capita) -->
	// Verify 'Comments' section by adding comment should show correct timestamp.
	// Quality Of Life--> Health & Safety: Violent Crime (per year per capita)
	// -->'Activity' section should show correct activity with date and
	// timestamp.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 204, enabled = false, description = "Quality Of Life--> Health & Safety: Violent Crime (per year per capita)  -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void Community_HealthAndSafetyVoilentCrime_Comments_Activity_Test() {

		log.info("Community_HealthAndSafetyVoilentCrime_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_NonLeed2");
		// ProjectCommunityID="8000004568";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonHealthAndSafetyVoilentCrime();
			flag = CommunitiesPage.checkHealthAndSafetyVoilentCrime(data.getCellData("Communities", 33, 2), ProfileUserName);

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Community_HealthAndSafetyVoilentCrime_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_HealthAndSafetyVoilentCrime_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// --> Verify Qualty Of Life Score after entering previous year data

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 205, enabled = true, description = "Quality Of Life -->Verify Qualty Of Life Score after entering previous year data")
	public void Community_Check_QualityOfLife_Score() {

		log.info("Community_Check_QualityOfLife_Score method started......................... ");
		int QualityScore = 0;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000006833";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();

			QualityScore = CommunitiesPage.getQualityOfLifeScore();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (QualityScore > 0) {
			log.info("Community_Check_QualityOfLife_Score method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_Check_QualityOfLife_Score method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// --> Validate each row item of dropdown additional data- by selecting one item
	// from the dropdown and and adding the field value with unit field.

	@Test(groups = "CommunityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 206, enabled = false, description = "Quality Of Life -->Additional Data --> Validate each row item of dropdown additional data- by selecting one item from the dropdown and and adding the field value with unit field.")
	public void Community_AdditionalData_SaveRecords() {

		log.info("Community_AdditionalData_SaveRecords method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCommunityID = System.getProperty("CommunitiesProject_Private3");
		// ProjectCommunityID="8000006797";
		if (!ProjectCommunityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunityID);
			HomePage.closeProjectSearchTextBox();
			CommunitiesPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CommunitiesPage.ClickonAdditionalData();
			flag = CommunitiesPage.checkAdditionalData_SaveRecords();

		} else {
			log.info("Community Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("Community_AdditionalData_SaveRecords method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("Community_AdditionalData_SaveRecords method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

}
