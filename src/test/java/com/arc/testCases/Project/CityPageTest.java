package com.arc.testCases.Project;

import java.io.File;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.arc.PageObject.Project.CityPageObject;
import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class CityPageTest extends BaseClass {

	private static Logger log = LoggerHelper.getLogger(CityPageTest.class);

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, enabled = true, priority = 18, description = "Verify Manage-->Agreements should show the project agreement.")
	public void City_Agreement_Display() {
		log.info("City_Agreement_Display method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		CityPage = ProjectPage.SearchAndClickOnCityProject(data.getCellData("Reboot", 6, 2));
		HomePage.closeProjectSearchTextBox();
		CityPage.ClickonAgreementInManage();
		boolean flag = CommonMethod.CheckAgreementDisplay();

		if (flag) {
			log.info("City_Agreement_Display method completed ");
			Assert.assertTrue(true);
		} else {
			log.info("City_Agreement_Display method completed ");
			Assert.assertTrue(false);
		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Agreement_Display", groups = {
			"Reboot" }, enabled = true, priority = 19, description = "Verify able to download the agreement successfully.")
	public void City_Agreement_Download() {
		log.info("City_Agreement_Download method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		CityPage = ProjectPage.SearchAndClickOnCityProject(data.getCellData("Reboot", 6, 2));
		HomePage.closeProjectSearchTextBox();
		CityPage.ClickonAgreementInManage();
		CommonMethod.ClikOnAgreementRegistrationDownloadLink();
		// BuildingPage.ClikOnAgreementDownloadLink();
		long FileLength = CommonMethod.CheckDownloadedFile();
		if (FileLength > 0) {
			CommonMethod.DeleteAllFiles();
			DownloadFolder.delete();
			log.info("City_Agreement_Download method completed ");
			Assert.assertTrue(FileLength > 0);
		} else {
			log.info("City_Agreement_Download method completed ");
			Assert.assertTrue(false);
		}

	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, enabled = true, priority = 20, description = "Verify if leed id project, able to download the registration invoice and receipt successfully from Manage-->Billing tab.")
	public void City_LEEDIDProject_Download_Invoice() {

		log.info("City_LEEDIDProject_Download_Invoice method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		System.out.println(data.getCellData("Reboot", 7, 2));
		CityPage = ProjectPage.SearchAndClickOnCityProject(data.getCellData("Reboot", 7, 2));
		HomePage.closeProjectSearchTextBox();
		CityPage.ClickonBillingInManage();
		CommonMethod.ClikOnBillingDownloadForRegistrationLink();
		long FileLength = CommonMethod.CheckDownloadedFile();
		if (FileLength > 0) {
			for (File file : DownloadFolder.listFiles()) {
				file.delete();
			}
			DownloadFolder.delete();
			log.info("City_LEEDIDProject_Download_Invoice method completed ");
			Assert.assertTrue(FileLength > 0);
		} else {
			for (File file : DownloadFolder.listFiles()) {
				file.delete();
			}
			DownloadFolder.delete();
			log.info("City_LEEDIDProject_Download_Invoice method completed ");
			Assert.assertTrue(false);
		}
	}

	// Verify Manage-->Teams should show team members added to the project.

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, enabled = true, priority = 21, description = "Verify able to add a team-member successfully.")
	public void City_Team_Add_Member() {

		log.info("City_Team_Add_Member method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		log.info(data.getCellData("Reboot", 6, 2));
		CityPage = ProjectPage.SearchAndClickOnCityProject(data.getCellData("Reboot", 6, 2));
		CityPage.ClickonTeamInManage();
		HomePage.closeProjectSearchTextBox();
		String username = data.getCellData("Reboot", 15, 2);
		boolean emailexist = CommonMethod.Team_checkEmailExistOrNot(username);
		log.info(username + "-----------existence is----" + emailexist);
		if (emailexist == false) {
			CommonMethod.Team_Add_Member(username);
			boolean UserNamePresent = CommonMethod.Team_checkEmailExistOrNot(username);
			if (UserNamePresent) {
				log.info(username + "  exists in the team member");
				log.info("City_Team_Add_Member method completed .......................");
				Assert.assertTrue(true);
			} else {
				log.info(username + "  does not exist in the team member");
				log.info("City_Team_Add_Member method completed .......................");
				Assert.assertTrue(false);
			}
		} else {
			log.info("First deleting the email and then will add the same email...");
			CommonMethod.Team_Delete_Member(username);
			CommonMethod.Team_Add_Member(username);
			boolean UserNamePresent = CommonMethod.Team_checkEmailExistOrNot(username);
			if (UserNamePresent) {
				log.info(username + "  exists in the team member");
				log.info("City_Team_Add_Member method completed .......................");
				Assert.assertTrue(true);
			} else {
				log.info(username + "  does not exist in the team member");
				log.info("City_Team_Add_Member method completed .......................");
				Assert.assertTrue(false);
			}
		}

	}

	// Verify Manage-->It should allow to delete member from the added list

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, dependsOnMethods = "City_Team_Add_Member", enabled = true, priority = 22, description = "Verify able to remove a team-member successfully.")
	public void City_Team_Delete_Member() {

		log.info("City_Team_Delete_Member method started .......................");
		CommonMethod.RefreshPagewaitForPageLoaded(driver);
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		log.info(data.getCellData("Reboot", 6, 2));
		CityPage = ProjectPage.SearchAndClickOnCityProject(data.getCellData("Reboot", 6, 2));
		HomePage.closeProjectSearchTextBox();
		CityPage.ClickonTeamInManage();
		String username = data.getCellData("Reboot", 15, 2);
		CommonMethod.Team_Delete_Member(username);
		boolean emailexist = CommonMethod.Team_checkEmailExistOrNot(username);
		if (!emailexist) {
			log.info(username + "  does not exist as team member");
			log.info("City_Team_Delete_Member method completed.......................");
			Assert.assertTrue(true);
		} else {
			log.info(username + " still exist as team member");
			log.info("City_Team_Delete_Member method completed.......................");
			Assert.assertTrue(false);
		}
	}

	// *************************Regression Test
	// Cases***********************************************

	// --> Certifications- > Verify Under Certifications- Shows text- "LEED v4.1
	// Cities Certification".

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 91, enabled = true, description = "Certifications- > Verify Under Certifications- Shows text- \"LEED v4.1 Cities Certification\".")
	public void City_Certifications_LEED_Certification() {

		log.info("City_Certifications_LEED_Certification method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		//System.setProperty("CityProject_Test1","8000040329");
		String ProjectCityID = System.getProperty("CityProject_Test1");
		// ProjectCityID="8000012008";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonCertifications();
			flag = CityPage.CheckLEEDCitiesCertification();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_Certifications_LEED_Certification method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Certifications_LEED_Certification method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// --> Certifications- > Verify Under Certifications-button 'Register for LEED
	// Certification' redirects to LEED Online page-
	// "https://leedonline-stg.usgbc.org/"

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 92, enabled = true, description = "Certifications- > Verify Under Certifications-button 'Register for LEED Certification' redirects to LEED Online page- \"https://leedonline-stg.usgbc.org/\"")
	public void City_Certifications_RegisterForLEEDCertification() {

		log.info("City_Certifications_RegisterForLEEDCertification method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		
		String ProjectCityID = System.getProperty("CityProject_Test1");
		//ProjectCityID="8000040324";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonCertifications();
			flag = CityPage.CheckRegisterForLEEDCertification();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_Certifications_RegisterForLEEDCertification method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Certifications_RegisterForLEEDCertification method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// --> Certifications- > Verify Under Certifications-'Recent certifications' at
	// Right hand side shows LEED badge with text "Projects achieved LEED
	// certification since Dec 10, 2021."

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 93, enabled = true, description = "Certifications- > Verify Under Certifications-'Recent certifications' at Right hand side shows LEED badge with text \"Projects achieved LEED certification since Dec 10, 2021.\" ")
	public void City_Certifications_RecentCertifications() {

		log.info("City_Certifications_RecentCertifications method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Test1");
		// ProjectCityID="8000039883";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonCertifications();
			flag = CityPage.CheckRecentCertifications();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_Certifications_RecentCertifications method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Certifications_RecentCertifications method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// --> Certifications- > Verify Under Certifications-'Recent certifications' -
	// 'Learn More' link redirects to "https://www.usgbc.org/projects"

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 94, enabled = true, description = "Certifications- > Verify Under Certifications-'Recent certifications' - 'Learn More' link redirects to \"https://www.usgbc.org/projects\"")
	public void City_Certifications_CheckLearnMoreLink() {

		log.info("City_Certifications_CheckLearnMoreLink method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Test1");
		// ProjectCityID="8000039883";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonCertifications();
			flag = CityPage.CheckLearnMoreLink();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_Certifications_CheckLearnMoreLink method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Certifications_CheckLearnMoreLink method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	
	//Verify Under Certifications-Message is displayed "This project does not meet the requirements of the LEED performance prerequisites. Project must achieve a minimum score of 40 to meet the requirements of LEED performance prerequisites." Followed by individual score given for each performance category.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 95, enabled = true, description = "Verify Under Certifications-Message is displayed \"This project does not meet the requirements of the LEED performance prerequisites. Project must achieve a minimum score of 40 to meet the requirements of LEED performance prerequisites.\" Followed by individual score given for each performance category.")
	public void City_Certifications_VerifyTextMessage() {

		log.info("City_Certifications_VerifyTextMessage method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Test1");
		// ProjectCityID="8000039883";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonCertifications();
			flag = CityPage.Certifications_VerifyTextMessage();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_Certifications_VerifyTextMessage method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Certifications_VerifyTextMessage method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify in DI, Project settings - population tab- Add row button adds a new
	// line item with fields- 'Effective year', Population, Updated by followed by
	// Save and delete button

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 101, enabled = true, description = "Verify in DI, Project settings - population tab- Add row button adds a new line item with fields- 'Effective year', Population, Updated by followed by Save and delete button ")
	public void City_ProjectSetting_Population_Add_Row() {

		log.info("City_ProjectSetting_Population_Add_Row method started......................... ");
		// CommonMethod.switchToDefaultContent();
		// CityPage = new CityPageObject();
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004394";
		if (!ProjectCityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProjectSetting();
			flag = CityPage.checkPopulation_AddRow_Header_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			Assert.assertTrue(true);
			log.info("City_ProjectSetting_Population_Add_Row method ends here ........... ");
		} else {
			log.info("City_ProjectSetting_Population_Add_Row method ends here ........... ");
			Assert.assertTrue(false);

		}
	}

	// Verify in DI, Project settings - population tab- Save One row button
	// Verify Effective year opens up decade calendar and gives the option to select
	// any year.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 101, dependsOnMethods = "City_ProjectSetting_Population_Add_Row", enabled = true, description = "Project Setting -> Population \r\n Verify in DI, Project settings - population tab- Save One row button \r\n"
			+ "		Verify Effective year opens up decade calendar and gives the option to select any year.")
	public void City_ProjectSetting_Population_Save_Row_DecadeCalender_Display() {

		log.info(
				"City_ProjectSetting_Population_Save_Row_DecadeCalender_Display method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Test1");
		// ProjectCityID="8000011510";
		if (!ProjectCityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProjectSetting();
			flag = CityPage.checkPopulation_Save_New_Row("1000");

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_ProjectSetting_Population_Save_Row_DecadeCalender_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_ProjectSetting_Population_Save_Row_DecadeCalender_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Population--- Verify Updated by shows the correct team-member/admin name.{To
	// check this, add any team-member in teams section and login using that team
	// member and add line item to this tab and check if his name s updated in
	// 'Updated by column }

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 102, dependsOnMethods = "City_ProjectSetting_Population_Save_Row_DecadeCalender_Display", enabled = true, description = "Project Setting -> population \r\n Verify Updated by shows the correct team-member/admin name.{To check this, add any team-member in teams section and login using that team member and add line item to this tab and chek if his name s updated in 'Updated by column ")
	public void City_ProjectSetting_Population_UpdatedBy_Test() {

		log.info("City_ProjectSetting_Population_UpdatedBy_Test method started......................... ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000011584";
		if (!ProjectCityID.equals(null)) {
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			CityPage.ClickonTeamInManage();
			HomePage.closeProjectSearchTextBox();
			String username = data.getCellData("City", 0, 2);
			boolean emailexist = CommonMethod.Team_checkEmailExistOrNot(username);
			System.out.println(username + "-----------existence is----" + emailexist);
			boolean flag = false;
			flag = CommonMethod.Team_Add_Member(username);
			if (flag) {
				log.info("Team Member added-----------------");
				HomePage.checkSignOut();
				HomePage = LoginPage.loginLater(data.getCellData("City", 0, 2), data.getCellData("City", 1, 2));
				boolean Updatedflag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				ProjectPage = HomePage.clickOnProject();
				CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
				HomePage.closeProjectSearchTextBox();
				String ProfileName = HomePage.getCurrentProfileUserName();
				CityPage.ClickonDataInput();
				CommonMethod.switchToDataInputFrame();
				CityPage.ClickonProjectSetting();
				boolean RecordAdded = CityPage.checkPopulation_Save_New_Row("1400");
				if (RecordAdded) {
					log.info("RecordAdded flag is true  --------------");
					Updatedflag = CityPage.checkPopulationUpdatedByUserName(ProfileName);
					CommonMethod.switchToDefaultContent();
					HomePage.checkSignOut();
					HomePage = LoginPage.loginLater(prop.getProperty("email"), prop.getProperty("password"));
					if (Updatedflag) {
						log.info(
								"City_ProjectSetting_Population_UpdatedBy_Test method ends with true here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info(
								"City_ProjectSetting_Population_UpdatedBy_Test method ends ends with false here ........... ");
						Assert.assertTrue(false);
					}
				} else {
					log.info("RecordAdded flag is false, Unable to add the record--------------");
					CommonMethod.switchToDefaultContent();
					HomePage.checkSignOut();
					HomePage = LoginPage.loginLater(prop.getProperty("email"), prop.getProperty("password"));
					log.info(
							"City_ProjectSetting_Population_UpdatedBy_Test method ends ends with false here ........... ");
					Assert.assertTrue(false);
				}

			} else {
				log.info("Unable to add the team member.-----------------");
				log.info("City_ProjectSetting_Population_UpdatedBy_Test method ends with false here ........... ");
				Assert.assertTrue(false);
			}

		}

		else {
			log.info("City Project is showing Null");
			log.info("City_ProjectSetting_Population_UpdatedBy_Test method ends with false here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Project Setting --> Population --> Verify 'Comments' section by adding
	// comment should show correct timestamp.
	// Project Setting --> Population -->Verify 'Activity' section should show
	// correct activity with date and
	// timestamp.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 103, enabled = true, description = "Project Setting --> Population -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void City_ProjectSetting_Population_Comments_Activity_Test() {

		log.info("City_ProjectSetting_Population_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004489";
		if (!ProjectCityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProjectSetting();

			flag = CityPage.checkPopulationCommentAndActivity(data.getCellData("City", 2, 2), ProfileUserName);

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_ProjectSetting_Population_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_ProjectSetting_Population_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify population field allows to add values followed by commas.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_ProjectSetting_Population_Save_Row_DecadeCalender_Display", priority = 104, enabled = true, description = "Verify population field allows to add values followed by commas.")
	public void City_Population_Field_Comma_Display() {

		log.info("City_Population_Field_Comma_Display method started......................... ");
		boolean flag = false;
		boolean Commaflag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Test1");
		// ProjectCityID="8000004341";
		if (!ProjectCityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProjectSetting();
			flag = CityPage.verifyAddedProject_Setting_PopulationRow();
		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			Commaflag = CityPage.verifyPopulationField_Contains_Comma();
			if (Commaflag) {
				log.info("Population field contains Comma");
				log.info("City_Population_Field_Comma_Display method ends here ........... ");
				Assert.assertTrue(true);
			} else {
				log.info("Population field does not contains Comma");
				log.info("City_Population_Field_Comma_Display method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Row is not added for this project, unable to check population field");
			log.info("City_Population_Field_Comma_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Project Setting - > Population - > Verify filter button - From (Start date)
	// and To (End date) uopens up decade calendar and on selecting any year range,
	// the line items falling into those year should be displayed.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"City_ProjectSetting_Population_Save_Row_DecadeCalender_Display" }, priority = 104, enabled = true, description = "Project Setting - > Population - >Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed. ")
	public void City_Population_Filter_Test() {

		log.info("City_Population_Filter_Test method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Perf4");
		// ProjectCityID="8000011415";
		if (!ProjectCityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProjectSetting();
			flag = CityPage.CheckPopulationFilter();
		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_Population_Filter_Test method ends here ........... ");
			Assert.assertTrue(true);
		} else {
			log.info("City_Population_Filter_Test method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Project Setting - > Population - > Verify delete button deletes the line item
	// successfully.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"City_ProjectSetting_Population_Save_Row_DecadeCalender_Display" }, priority = 105, enabled = true, description = "Project Setting - > Population - > Verify delete button deletes the line item successfully. ")
	public void City_Population_DeleteRecord() {

		log.info("City_Population_DeleteRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Perf4");
		// ProjectCityID="8000011588";
		if (!ProjectCityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProjectSetting();
			flag = CityPage.CheckPopulationDeleteRow();
		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_Population_DeleteRecord method ends here ........... ");
			Assert.assertTrue(true);
		} else {
			log.info("City_Population_DeleteRecord method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify in DI, Project settings - ProjectArea tab- Add row button adds a new
	// line item with fields- 'Effective year', Population, Updated by followed by
	// Save and delete button

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 107, enabled = true, description = "Verify in DI, Project settings - ProjectArea tab- Add row button adds a new line item with fields- 'Effective year', Population, Updated by followed by Save and delete button ")
	public void City_ProjectSetting_ProjectArea_Add_Row() {

		log.info("City_ProjectSetting_ProjectArea_Add_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004332";
		if (!ProjectCityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProjectSetting();
			flag = CityPage.checkProjectArea_AddRow_Header_Display();
		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			Assert.assertTrue(true);
			log.info("City_ProjectSetting_ProjectArea_Add_Row method ends here ........... ");
		} else {
			log.info("City_ProjectSetting_ProjectArea_Add_Row method ends here ........... ");
			Assert.assertTrue(false);

		}
	}

	// Verify in DI, Project settings - Project Area tab- Add One row and save
	// Verify Effective year opens up decade calendar and gives the option to select
	// any year.
	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_ProjectSetting_ProjectArea_Add_Row", priority = 108, enabled = true, description = "Verify in DI, Project settings - Project Area tab- Add One row and save ,  \r\n"
			+ "			 ,  Verify Effective year opens up decade calendar and gives the option to select any year.")
	public void City_ProjectSetting_ProjectArea_Save_Row_DecadeCalender_Display() {

		log.info(
				"City_ProjectSetting_ProjectArea_Save_Row_DecadeCalender_Display method started......................... ");

		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000011415";
		if (!ProjectCityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProjectSetting();
			flag = CityPage.checkProjectArea_Save_New_Row("10000");

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_ProjectSetting_ProjectArea_Save_Row_DecadeCalender_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_ProjectSetting_ProjectArea_Save_Row_DecadeCalender_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify Project Area field allows to add values followed by commas.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 109, enabled = true, description = "Verify Project Area field allows to add values followed by commas.")
	public void City_ProjectArea_Field_Comma_Display() {

		log.info("City_ProjectArea_Field_Comma_Display method started......................... ");
		boolean Commaflag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004355";
		if (!ProjectCityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProjectSetting();
			Commaflag = CityPage.verifyProjectAreaField_Contains_Comma();
			if (Commaflag) {
				log.info("Project Area field contains Comma");
				log.info("City_ProjectArea_Field_Comma_Display method ends here ........... ");
				Assert.assertTrue(true);
			} else {
				log.info("Project Area field field does not contains Comma");
				log.info("City_ProjectArea_Field_Comma_Display method ends here ........... ");
				Assert.assertTrue(false);
			}
		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
	}

	// Project Setting - >Project Area - >Verify 'Comments' section by adding
	// comment should show correct timestamp.
	// Verify 'Activity' section should show correct activity with date and
	// timestamp.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 110, enabled = true, description = "Project Area - > Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void City_ProjectSetting_ProjectArea_Comments_Activity_Test() {

		log.info("City_ProjectSetting_ProjectArea_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004423";
		if (!ProjectCityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProjectSetting();

			flag = CityPage.checkProjectAreaCommentAndActivity(data.getCellData("City", 3, 2), ProfileUserName);

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_ProjectSetting_ProjectArea_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_ProjectSetting_ProjectArea_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify after creating City Project with Gross Area as "Square Miles unit",
	// check in Data Input – Project Setting - > Project Area Tab -> Unit Drop down
	// by default value.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 111, enabled = true, description = "Verify after creating City Project with Gross Area as \"Square Miles unit\", check in Data Input – Project Setting - > Project Area Tab -> Unit Drop down by default value. ")
	public void City_Project_Area_GrossArea_SquareMiles_Display() {
		log.info("City_Project_Area_GrossArea_SquareMiles_Display method started ........... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004319";
		if (!ProjectCityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProjectSetting();
			flag = CityPage.checkUnitTypeInProjectAreaUnderDataInput("sq miles");

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			Assert.assertTrue(true);
			log.info("City_Project_Area_GrossArea_SquareMiles_Display method ends here ........... ");
		} else {
			log.info("City_Project_Area_GrossArea_SquareMiles_Display method ends here ........... ");
			Assert.assertTrue(false);

		}

	}

	// Project Setting - > Project Area - > Verify filter button - From (Start date)
	// and To (End date) uopens up decade calendar and on selecting any year range,
	// the line items falling into those year should be displayed.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"City_ProjectSetting_ProjectArea_Save_Row_DecadeCalender_Display" }, priority = 112, enabled = true, description = "Project Setting - > Project Area - >Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed. ")
	public void City_ProjectArea_Filter_Test() {

		log.info("City_ProjectArea_Filter_Test method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000011415";
		if (!ProjectCityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProjectSetting();
			flag = CityPage.CheckProjectAreaFilter();
		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_ProjectArea_Filter_Test method ends here ........... ");
			Assert.assertTrue(true);
		} else {
			log.info("City_ProjectArea_Filter_Test method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Project Setting - > Project Area - > Verify delete button deletes the line
	// item successfully.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"City_ProjectSetting_ProjectArea_Save_Row_DecadeCalender_Display" }, priority = 113, enabled = true, description = "Project Setting - > Project Area - > Verify delete button deletes the line item successfully. ")
	public void City_ProjectArea_DeleteRecord() {

		log.info("City_ProjectArea_DeleteRecord method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000011588";
		if (!ProjectCityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProjectSetting();
			flag = CityPage.CheckProjectAreaDeleteRow();
		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_ProjectArea_DeleteRecord method ends here ........... ");
			Assert.assertTrue(true);
		} else {
			log.info("City_ProjectArea_DeleteRecord method ends here ........... ");
			Assert.assertTrue(false);
		}

	}
	// Project Area--- Verify Updated by shows the correct team-member/admin
	// name.{To
	// check this, add any team-member in teams section and login using that team
	// member and add line item to this tab and check if his name s updated in
	// 'Updated by column }

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"City_ProjectSetting_ProjectArea_Save_Row_DecadeCalender_Display" }, priority = 114, enabled = true, description = "Project Setting -> Project Area \r\n Verify Updated by shows the correct team-member/admin name.{To check this, add any team-member in teams section and login using that team member and add line item to this tab and chek if his name s updated in 'Updated by column ")
	public void City_ProjectSetting_ProjectArea_UpdatedBy() {

		log.info("City_ProjectSetting_ProjectArea_UpdatedBy method started......................... ");
		CommonMethod.switchToDefaultContent();
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		String ProjectCityID = System.getProperty("CityProject_Test1");
		// ProjectCityID="8000011584";
		if (!ProjectCityID.equals(null)) {
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			CityPage.ClickonTeamInManage();
			HomePage.closeProjectSearchTextBox();
			String username = data.getCellData("City", 0, 2);
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
				HomePage = LoginPage.loginLater(data.getCellData("City", 0, 2), data.getCellData("City", 1, 2));
				// CityPage = new CityPageObject();
				boolean Updatedflag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}
				ProjectPage = HomePage.clickOnProject();
				CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
				HomePage.closeProjectSearchTextBox();
				String ProfileName = HomePage.getCurrentProfileUserName();
				CityPage.ClickonDataInput();
				CommonMethod.switchToDataInputFrame();
				CityPage.ClickonProjectSetting();
				boolean RecordAdded = CityPage.checkProjectArea_Save_New_Row("1400");
				if (RecordAdded) {
					log.info("RecordAdded flag is true  --------------");
					Updatedflag = CityPage.checkProjectAreaUpdatedByUserName(ProfileName);
					CommonMethod.switchToDefaultContent();
					HomePage.checkSignOut();
					HomePage = LoginPage.loginLater(prop.getProperty("email"), prop.getProperty("password"));
					if (Updatedflag) {
						log.info("City_ProjectSetting_ProjectArea_UpdatedBy method ends with true here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info(
								"City_ProjectSetting_ProjectArea_UpdatedBy method ends ends with false here ........... ");
						Assert.assertTrue(false);
					}
				} else {
					log.info("RecordAdded flag is false, Unable to add the record--------------");
					CommonMethod.switchToDefaultContent();
					HomePage.checkSignOut();
					HomePage = LoginPage.loginLater(prop.getProperty("email"), prop.getProperty("password"));
					log.info("City_ProjectSetting_ProjectArea_UpdatedBy method ends ends with false here ........... ");
					Assert.assertTrue(false);
				}

			} else {
				log.info("Unable to add the team member.-----------------");
				log.info("City_ProjectSetting_ProjectArea_UpdatedBy method ends with false here ........... ");
				Assert.assertTrue(false);
			}

		}

		else {
			log.info("City Project is showing Null");
			log.info("City_ProjectSetting_ProjectArea_UpdatedBy_Test method ends with false here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify Energy meter shows GHG emissions meter with data and detals tab.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 115, enabled = true, description = "Verify Energy meter shows GHG emissions meter with data and detals tab.")
	public void City_Energy_GHGEmission_With_DataAndDetails_Display() {

		log.info("City_Energy_GHGEmission_DataAndDetailsTab_Display method started......................... ");
		CommonMethod.switchToDefaultContent();
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004377";
		if (!ProjectCityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonGHGEmiissions();
			flag = CityPage.CheckGHGEmission_Data_DetailsTab_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Energy_GHGEmission_DataAndDetailsTab_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Energy_GHGEmission_DataAndDetailsTab_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify 'Add year' button adds line item with year for previous year.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"City_Energy_GHGEmission_With_DataAndDetails_Display" }, priority = 115, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
	public void City_Energy_GHGEmission_AddYear_AddNewLine() {

		log.info("City_Energy_GHGEmission_AddYear_AddNewLine method started......................... ");
		CommonMethod.switchToDefaultContent();
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004377";
		if (!ProjectCityID.equals(null)) {
			CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonGHGEmiissions();
			flag = CityPage.CheckGHGEmission_AddYear_NewRow_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Energy_GHGEmission_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Energy_GHGEmission_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify by adding value to reading and clicking on save button.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"City_Energy_GHGEmission_AddYear_AddNewLine" }, priority = 115, enabled = true, description = "Verify by adding value to reading and clicking on save button. ")
	public void City_Energy_GHGEmission_SavePreviousYearData() {

		log.info("City_Energy_GHGEmission_SavePreviousYearData method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000011415";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonGHGEmiissions();
			flag = CityPage.CheckGHGEmission_SaveNewRecord();
			if (flag) {
				log.info("Record is added successfully");
				log.info(
						"City_Energy_GHGEmission_SavePreviousYearData method ends here with " + flag + " ........... ");
				Assert.assertTrue(true);
			} else {
				log.info("Record is not added successfully");
				log.info(
						"City_Energy_GHGEmission_SavePreviousYearData method ends here with " + flag + " ........... ");
				Assert.assertTrue(false);
			}
		}

		else {
			log.info("City Project is showing Null");
			log.info("City_Energy_GHGEmission_SavePreviousYearData method ends here with " + flag + " ........... ");
			Assert.assertTrue(false);
		}

	}
	// Verify score gets populated when data is added for previous year

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"City_Energy_GHGEmission_SavePreviousYearData" }, priority = 115, enabled = true, description = " Verify score gets populated when data is added for previous year  ")
	public void City_Energy_GHGEmission_CheckScore() {

		log.info("City_Energy_GHGEmission_CheckScore method started......................... ");
		int Score;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000011415";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonGHGEmiissions();
			Score = CityPage.getEnergyScore();
			if (Score > 0) {
				log.info("Score is updated with---" + Score);
				log.info("City_Energy_GHGEmission_CheckScore method ends here ........... ");
				Assert.assertTrue(true);
			} else {
				log.info("City_Energy_GHGEmission_CheckScore method ends here ........... ");
				Assert.assertTrue(false);
			}
		}

		else {
			log.info("City Project is showing Null");
			log.info("City_Energy_GHGEmission_CheckScore method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify able to Edit line item by using Edit button..

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Energy_GHGEmission_SavePreviousYearData", priority = 116, enabled = true, description = "Verify able to Edit line item by using Edit button..")
	public void City_Energy_GHGEmission_Edit_Row() {

		log.info("City_Energy_GHGEmission_Edit_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004409";
		if (!ProjectCityID.equals(null)) {

			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonGHGEmiissions();
			// OldScore = CityPage.getEnergyScore();
			flag = CityPage.CheckGHGEmission_EditRow();
			/*
			 * if (flag) { CommonMethod.switchToDefaultContent(); ProjectPage =
			 * HomePage.clickOnProject(); CityPage =
			 * ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			 * HomePage.closeProjectSearchTextBox(); CityPage.ClickonDataInput();
			 * CommonMethod.switchToDataInputFrame(); CityPage.ClickonGHGEmiissions();
			 */
			// NewScore = CityPage.getEnergyScore();
			if (flag) {
				// log.info(OldScore + " is updated with---" + NewScore);
				log.info("Record is updated successfully");
				log.info("City_Energy_GHGEmission_Edit_Row method ends here ........... ");
				Assert.assertTrue(true);
			} else {
				log.info("Record is not updated successfully");
				log.info("City_Energy_GHGEmission_Edit_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Energy_GHGEmission_Edit_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify able to delete line item by using delete button.
	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Energy_GHGEmission_SavePreviousYearData", priority = 117, enabled = true, description = "Verify able to delete line item by using delete button.")
	public void City_Energy_GHGEmission_Delete_Row() {

		log.info("City_Energy_GHGEmission_Delete_Row method started......................... ");
		boolean flag = false;
		// int OldScore, NewScore;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004409";
		if (!ProjectCityID.equals(null)) {
			// CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonGHGEmiissions();
			// OldScore = CityPage.getEnergyScore();
			flag = CityPage.CheckGHGEmission_DeleteRow();

			if (flag) {
				log.info("City_Energy_GHGEmission_Delete_Row method ends here ........... ");
				Assert.assertTrue(true);
			} else {
				log.info("City_Energy_GHGEmission_Delete_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Energy_GHGEmission_Delete_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify 'previous year' and 'next year' button adds reading respectively.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 117, dependsOnMethods = {
			"City_Energy_GHGEmission_SavePreviousYearData" }, enabled = true, description = "Verify 'previous year' and 'next year' button adds reading respectively.")
	public void City_Energy_AddRow_PreviousYear_NextYear() {

		log.info("City_Energy_AddRow_PreviousYear_NextYear method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004560";
		if (!ProjectCityID.equals(null)) {
			// CommonMethod.switchToDefaultContent();
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonGHGEmiissions();
			CityPage.CheckGHGEmission_SaveNewRecord();
			flag = CityPage.CheckGHGEmission_SavePreviousAndNextYearRecord();
			if (flag) {
				log.info("City_Energy_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info("City_Energy_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Energy_AddRow_PreviousYear_NextYear method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Energy --> GHS Emissions --> Verify 'Comments' section by adding comment
	// should show correct timestamp.
	// Energy --> GHS Emissions -->'Activity' section should show correct activity
	// with date and
	// timestamp.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 118, enabled = true, description = "Energy --> GHS Emissions -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void City_Energy_DetailsTab_Comments_Activity_Test() {

		log.info("City_Energy_DetailsTab_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004489";
		if (!ProjectCityID.equals(null)) {

			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonGHGEmiissions();
			flag = CityPage.checkEnergyCommentAndActivity(data.getCellData("City", 5, 2), ProfileUserName);

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_Energy_DetailsTab_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Energy_DetailsTab_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Energy --> GHS Emissions -->Verify Details tab shows graph populated with
	// reading value and respective year.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 119, enabled = false, description = "Energy --> GHS Emissions -->Verify Details tab shows graph populated with reading value  and respective year.")
	public void City_Energy_DetailsTab_Graph_Test() {

		log.info("City_Energy_DetailsTab_Graph_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Test1");
		// ProjectCityID="8000007155";
		if (!ProjectCityID.equals(null)) {

			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonGHGEmiissions();
			flag = CityPage.CheckEnergyGraph();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_Energy_DetailsTab_Graph_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Energy_DetailsTab_Graph_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Energy - Verify filter button - From (Start date) and To (End date) uopens up
	// decade calendar and on selecting any year range, the line items falling into
	// those year should be displayed.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"City_Energy_GHGEmission_SavePreviousYearData" }, priority = 120, enabled = true, description = "Energy - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
	public void City_Energy_FilterTest() {

		log.info("City_Energy_FilterTest method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Perf4");
		// ProjectCityID="8000011512";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonGHGEmiissions();
			flag = CityPage.CheckEnergyFilter();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Energy_FilterTest method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Energy_FilterTest method ends here ........... ");
			Assert.assertTrue(false);
		}
	}
// Verify Water meter shows 'Water Consumption' meter with data and details tab.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 121, enabled = true, description = "Verify Water meter shows 'Water Consumption' meter with data and details tab. ")
	public void City_Water_DataAndDetails_Display() {

		log.info("City_Water_DataAndDetails_Display method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID = "8000004396";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonWaterConsumption();
			flag = CityPage.CheckWaterConsumption_Data_DetailsTab_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Water_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Water_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify 'Add year' button adds line item with year for previous year.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Water_DataAndDetails_Display", priority = 121, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
	public void City_Water_Consum_AddYear_AddNewLine() {

		log.info("City_Water_Consum_AddYear_AddNewLine method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID = "8000004396";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonWaterConsumption();
			flag = CityPage.CheckWatwr_Consumption_AddYear_NewRow_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Water_Consum_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Water_Consum_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify by adding value to reading and clicking on save button.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Water_Consum_AddYear_AddNewLine", priority = 121, enabled = true, description = "Verify by adding value to reading and clicking on save button. . ")
	public void City_Water_Consum_SavePreviousYearData() {

		log.info("City_Water_Consum_SavePreviousYearData method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID = "8000004553";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();

			CityPage.ClickonWaterConsumption();
			/*
			 * OldScore = CityPage.getWaterScore(); CommonMethod.switchToDefaultContent();
			 * ProjectPage = HomePage.clickOnProject(); CityPage =
			 * ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			 * HomePage.closeProjectSearchTextBox(); CityPage.ClickonDataInput();
			 * CommonMethod.switchToDataInputFrame(); CityPage.ClickonWaterConsumption();
			 */
			flag = CityPage.CheckWaterConsumption_SaveNewRecord();

			if (flag) {
				log.info("Record is added successfully");
				log.info("City_Water_Consum_SavePreviousYearData method ends here  ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info("City_Water_Consum_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Water_Consum_SavePreviousYearData method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify score gets populated when data is added for previous year

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Water_Consum_SavePreviousYearData", priority = 121, enabled = true, description = "Verify score gets populated when data is added for previous year  ")
	public void City_Water_Consum_CheckScore() {

		log.info("City_Water_Consum_CheckScore method started......................... ");
		int Score;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID = "8000004553";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonWaterConsumption();
			Score = CityPage.getWaterScore();
			if (Score > 0) {
				log.info("Score is updated with---" + Score);
				log.info("City_Water_Consum_CheckScore method ends here ........... ");
				Assert.assertTrue(true);
			} else {
				log.info("Score is not generated successfully");
				log.info("City_Water_Consum_CheckScore method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Water_Consum_CheckScore method ends here ........... ");
			Assert.assertTrue(false);
		}

	}
	// Verify 'Unit' dropdown allows to select unit 'Gallons' or 'Litre'.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Water_Consum_SavePreviousYearData", priority = 121, enabled = true, description = "Verify 'Unit' dropdown allows to select unit 'Gallons' or 'Litre'.")
	public void City_Water_AddRows_With_Gallons_Litres() {

		log.info("City_Water_AddRows_With_Gallons_Litres method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID = "8000011517";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonWaterConsumption();
			flag = CityPage.CheckWaterConsumption_AddRow_UnitTypes();

			if (flag) {

				log.info("City_Water_AddRows_With_Gallons_Litres method ends here ........... ");
				Assert.assertTrue(true);

			} else {

				log.info("City_Water_AddRows_With_Gallons_Litres method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Water_AddRows_With_Gallons_Litres method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify 'Duration' dropdown allows to select unit 'Per Year' or 'Per Month' or
	// 'Per week' or 'Per day' .

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 122, dependsOnMethods = "City_Water_Consum_SavePreviousYearData", enabled = true, description = "Verify 'Duration' dropdown allows to select unit 'Per Year' or 'Per Month' or 'Per week' or 'Per day' .")
	public void City_Water_AddRows_With_Duration_Types() {

		log.info("City_Water_AddRows_With_Duration_Types method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID = "8000004489";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonWaterConsumption();
			// CityPage.getWaterScore();
			flag = CityPage.CheckWaterConsumption_AddRow_DurationTypes();

			if (flag) {

				log.info("City_Water_AddRows_With_Duration_Types method ends here ........... ");
				Assert.assertTrue(true);

			} else {

				log.info("City_Water_AddRows_With_Duration_Types method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Water_AddRows_With_Duration_Types method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify 'previous year' and 'next year' button adds reading respectively.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"City_Water_Consum_SavePreviousYearData" }, priority = 123, enabled = true, description = "Verify 'previous year' and 'next year' button adds reading respectively.")
	public void City_Water_AddRow_PreviousYear_NextYear() {

		log.info("City_Water_AddRow_PreviousYear_NextYear method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000011517";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonWaterConsumption();
			CityPage.CheckWaterConsumption_SaveNewRecord();
			flag = CityPage.CheckWaterConsum_SavePreviousAndNextYearRecord();
			if (flag) {
				log.info("City_Water_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info("City_Water_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Water_AddRow_PreviousYear_NextYear method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify able to Edit line item by using Edit button..

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Water_Consum_SavePreviousYearData", priority = 124, enabled = true, description = "Verify able to Edit line item by using Edit button..")
	public void City_WaterConsum_Edit_Row() {

		log.info("City_WaterConsum_Edit_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000011517";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonWaterConsumption();
			flag = CityPage.CheckWaterConsum_EditRow();

			if (flag) {
				log.info("Record is updated successfully");
				log.info("City_WaterConsum_Edit_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not updated successfully");
				log.info("City_WaterConsum_Edit_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_WaterConsum_Edit_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify able to delete line item by using delete button.
	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Water_Consum_SavePreviousYearData", priority = 125, enabled = true, description = "Verify able to delete line item by using delete button.")
	public void City_WaterConsum_Delete_Row() {

		log.info("City_WaterConsum_Delete_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004487";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonWaterConsumption();
			flag = CityPage.CheckWaterConsum_DeleteRow();

			if (flag) {
				log.info("Record is deleted successfully");
				log.info("City_WaterConsum_Delete_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not deleted successfully");
				log.info("City_WaterConsum_Delete_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_WaterConsum_Delete_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Water --> Water Consumption --> Verify 'Comments' section by adding comment
	// should show correct timestamp.
	// Water --> Water Consumption -->'Activity' section should show correct
	// activity with date and
	// timestamp.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 126, enabled = true, description = "Water --> Water Consumption -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void City_Water_Consumption_Comments_Activity_Test() {

		log.info("City_Water_Consumption_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004520";
		if (!ProjectCityID.equals(null)) {

			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonWaterConsumption();
			flag = CityPage.checkWaterCommentAndActivity(data.getCellData("City", 9, 2), ProfileUserName);

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_Water_Consumption_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Water_Consumption_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Water - Water Consumption - >Verify Details tab shows graph populated with
	// reading value and respective year.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 127, enabled = false, description = "Water - Water Consumption - >Verify Details tab shows graph populated with reading value  and respective year.")
	public void City_Water_DetailsTab_Graph_Test() {

		log.info("City_Water_DetailsTab_Graph_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Test1");
		// ProjectCityID="8000007155";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonWaterConsumption();
			flag = CityPage.CheckWaterGraph();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_Water_DetailsTab_Graph_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Water_DetailsTab_Graph_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Water - Water Consumption - >Verify filter button - From (Start date) and To
	// (End date) uopens up decade calendar and on selecting any year range, the
	// line items falling into those year should be displayed.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Water_Consum_SavePreviousYearData", priority = 128, enabled = true, description = "Water - Water Consumption - > - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
	public void City_Water_FilterTest() {

		log.info("City_Water_FilterTest method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Perf4");
		// ProjectCityID="8000011513";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonWaterConsumption();
			flag = CityPage.CheckWaterFilter();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Water_FilterTest method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Water_FilterTest method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// **************************CITY WASTE TEST
	// CASES********************************************

	// Verify Waste meters shows 'Municipal Solid Waste generation intensity' with
	// data and details tab.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 130, enabled = true, description = "Verify Waste meters shows 'Municipal Solid Waste generation intensity'  with data and details tab. ")
	public void City_Waste_Gen_DataAndDetails_Display() {

		log.info("City_Waste_Gen_DataAndDetails_Display method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID = "8000006972";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonMunicipalSolidwastegeneration();
			flag = CityPage.CheckWasteGeneration_Data_DetailsTab_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Waste_Gen_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Waste_Gen_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// For Municipal Solid Waste generation intensity Meters- Verify 'Add year'
	// button adds line item with year for previous year.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Waste_Gen_DataAndDetails_Display", priority = 130, enabled = true, description = "For Municipal Solid Waste generation intensity Meters- Verify 'Add year' button adds line item with year for previous year.")
	public void City_Waste_Generation_AddYear_AddNewLine() {

		log.info("City_Waste_Generation_AddYear_AddNewLine method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID = "8000006972";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonMunicipalSolidwastegeneration();
			flag = CityPage.CheckWaste_Generation_AddYear_NewRow_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Waste_Generation_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Waste_Generation_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// For Municipal Solid Waste generation intensity Meter- - Verify by adding
	// value to reading and clicking on save button.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Waste_Generation_AddYear_AddNewLine", priority = 130, enabled = true, description = "For Municipal Solid Waste generation intensity Meter- - Verify by adding value to reading and clicking on save button. ")
	public void City_Waste_Generation_SavePreviousYearData() {

		log.info("City_Waste_Generation_SavePreviousYearData method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID = "8000006972";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonMunicipalSolidwastegeneration();
			flag = CityPage.CheckWaste_Generation_SaveNewRecord();

			if (flag) {
				log.info("Record is added successfully");
				log.info("City_Waste_Generation_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info("City_Waste_Generation_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Waste_Generation_SavePreviousYearData method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify 'previous year' and 'next year' button adds reading respectively.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 130, dependsOnMethods = "City_Waste_Generation_SavePreviousYearData", enabled = true, description = "Verify 'previous year' and 'next year' button adds reading respectively.")
	public void City_Waste_Generation_AddRow_PreviousYear_NextYear() {

		log.info("City_Waste_Generation_AddRow_PreviousYear_NextYear method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004409";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonMunicipalSolidwastegeneration();
			flag = CityPage.CheckWaste_Generation_SavePreviousAndNextYearRecord();
			if (flag) {
				log.info("City_Waste_Generation_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info("City_Waste_Generation_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Waste_Generation_AddRow_PreviousYear_NextYear method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify able to Edit line item by using Edit button..

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Waste_Generation_SavePreviousYearData", priority = 131, enabled = true, description = "Verify able to Edit line item by using Edit button..")
	public void City_Waste_Generation_Edit_Row() {

		log.info("City_Waste_Generation_Edit_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000011537";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonMunicipalSolidwastegeneration();
			flag = CityPage.CheckWasteGeneration_EditRow();

			if (flag) {
				log.info("City_Waste_Generation_Edit_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not updated successfully");
				log.info("City_Waste_Generation_Edit_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Waste_Generation_Edit_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify able to delete line item by using delete button.
	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Waste_Generation_SavePreviousYearData", priority = 132, enabled = true, description = "Verify able to delete line item by using delete button.")
	public void City_Waste_Generation_Delete_Row() {

		log.info("City_Waste_Generation_Delete_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000011537";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonMunicipalSolidwastegeneration();

			flag = CityPage.CheckWasteGeneration_DeleteRow();

			if (flag) {

				log.info("Record is deleted successfully");
				log.info("City_Waste_Generation_Delete_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not deleted successfully");
				log.info("City_Waste_Generation_Delete_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Waste_Generation_Delete_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Waste --> Municipal solid waste generation intensity --> Verify 'Comments'
	// section by adding comment should show correct timestamp.
	// Waste --> Municipal solid waste generation intensity -->'Activity' section
	// should show correct activity with date and
	// timestamp.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 133, enabled = true, description = "Waste --> Municipal solid waste generation intensity -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void City_Waste_Generation_Comments_Activity_Test() {

		log.info("City_Waste_Generation_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004465";
		if (!ProjectCityID.equals(null)) {

			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();

			CityPage.ClickonMunicipalSolidwastegeneration();
			flag = CityPage.checkWasteGenerationCommentAndActivity(data.getCellData("City", 11, 2), ProfileUserName);

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_Waste_Generation_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Waste_Generation_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Waste --> Municipal solid waste generation intensity -->Verify Details tab
	// shows graph populated with reading value and respective year.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 134, enabled = false, description = "Waste --> Municipal solid waste generation intensity --> Verify Details tab shows graph populated with reading value  and respective year.")
	public void City_WasteGeneration_DetailsTab_Graph_Test() {

		log.info("City_WasteGeneration_DetailsTab_Graph_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Test1");
		// ProjectCityID="8000007155";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonMunicipalSolidwastegeneration();
			flag = CityPage.CheckWasteGenerationGraph();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_WasteGeneration_DetailsTab_Graph_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_WasteGeneration_DetailsTab_Graph_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Waste - Municipal solid waste generation intensity - >Verify filter button -
	// From (Start date) and To (End date) uopens up decade calendar and on
	// selecting any year range, the line items falling into those year should be
	// displayed.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"City_Waste_Generation_SavePreviousYearData" }, priority = 135, enabled = true, description = "Waste - 	Municipal solid waste generation intensity - >Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
	public void City_Waste_Generation_FilterTest() {

		log.info("City_Waste_Generation_FilterTest method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Perf4");
		// ProjectCityID = "8000011517";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonMunicipalSolidwastegeneration();
			flag = CityPage.CheckWaste_GenerationFilter();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Waste_Generation_FilterTest method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Waste_Generation_FilterTest method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify Waste meters shows 'Municipal solid waste diversion rate from
	// landfill' with data and details tab.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 136, enabled = true, description = "Verify Waste meters shows 'Municipal solid waste diversion rate from landfill'  with data and details tab. ")
	public void City_Waste_Diversion_DataAndDetails_Display() {

		log.info("City_Waste_Diversion_DataAndDetails_Display method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID = "8000004409";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonMunicipalSolidWasteDiversion();
			flag = CityPage.CheckWasteDiversion_Data_DetailsTab_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Waste_Diversion_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Waste_Diversion_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Municipal solid waste diversion rate from landfill- Verify 'Add year' button
	// adds line item with year for previous year.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Waste_Diversion_DataAndDetails_Display", priority = 136, enabled = true, description = "Municipal solid waste diversion rate from landfill- Verify 'Add year' button adds line item with year for previous year.")
	public void City_Waste_Diversion_AddYear_AddNewLine() {

		log.info("City_Waste_Diversion_AddYear_AddNewLine method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID = "8000004409";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonMunicipalSolidWasteDiversion();
			flag = CityPage.CheckWaste_Diversion_AddYear_NewRow_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Waste_Diversion_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Waste_Diversion_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Municipal solid waste diversion rate from landfill- Verify validation Message
	// after adding Invalid Percent value(101)

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Waste_Diversion_AddYear_AddNewLine", priority = 136, enabled = true, description = "Municipal solid waste diversion rate from landfill- Verify validation Message after adding Invalid Percent value(101)")
	public void City_Waste_Diversion_CheckWithInvalidPercent() {

		log.info("City_Waste_Diversion_CheckWithInvalidPercent method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID = "8000006846";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonMunicipalSolidWasteDiversion();
			flag = CityPage.CheckWaste_Diversion_CheckWithInvalidPercent();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Waste_Diversion_CheckWithInvalidPercent method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Waste_Diversion_CheckWithInvalidPercent method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Municipal solid waste diversion rate from landfill- - Verify by adding value
	// to reading and clicking on save button.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Waste_Diversion_AddYear_AddNewLine", priority = 137, enabled = true, description = "Municipal solid waste diversion rate from landfill- - Verify by adding value to reading and clicking on save button.  ")
	public void City_Waste_Diversion_SavePreviousYearData() {

		log.info("City_Waste_Diversion_SavePreviousYearData method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID = "8000004409";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonMunicipalSolidWasteDiversion();
			flag = CityPage.CheckWaste_Diversion_SaveNewRecord();

			if (flag) {
				log.info("Record is added successfully");
				log.info("City_Waste_Diversion_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info("City_Waste_Diversion_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Waste_Diversion_SavePreviousYearData method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Municipal solid waste diversion rate from landfill - Verify 'previous year'
	// and 'next year' button adds reading respectively.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 137, dependsOnMethods = "City_Waste_Diversion_SavePreviousYearData", enabled = true, description = "Municipal solid waste diversion rate from landfill - Verify 'previous year' and 'next year' button adds reading respectively.")
	public void City_Waste_Diversion_AddRow_PreviousYear_NextYear() {

		log.info("City_Waste_Diversion_AddRow_PreviousYear_NextYear method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004409";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonMunicipalSolidWasteDiversion();
			flag = CityPage.CheckWaste_Diversion_SavePreviousAndNextYearRecord();
			if (flag) {
				log.info("City_Waste_Diversion_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info("City_Waste_Diversion_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Waste_Diversion_AddRow_PreviousYear_NextYear method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Municipal solid waste diversion rate from landfill - Verify able to Edit line
	// item by using Edit button..

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Waste_Diversion_SavePreviousYearData", priority = 138, enabled = true, description = "Municipal solid waste diversion rate from landfill - Verify able to Edit line item by using Edit button..")
	public void City_Waste_Diversion_Edit_Row() {

		log.info("City_Waste_Diversion_Edit_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004409";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonMunicipalSolidWasteDiversion();
			flag = CityPage.CheckWasteDiversion_EditRow();

			if (flag) {
				log.info("City_Waste_Diversion_Edit_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not updated successfully");
				log.info("City_Waste_Diversion_Edit_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Waste_Diversion_Edit_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Municipal solid waste diversion rate from landfill - Verify able to delete
	// line item by using delete button.
	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Waste_Diversion_SavePreviousYearData", priority = 139, enabled = true, description = "Municipal solid waste diversion rate from landfill - Verify able to delete line item by using delete button.")
	public void City_Waste_Diversion_Delete_Row() {

		log.info("City_Waste_Diversion_Delete_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004409";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonMunicipalSolidWasteDiversion();

			flag = CityPage.CheckWasteDiversion_DeleteRow();

			if (flag) {

				log.info("Record is deleted successfully");
				log.info("City_Waste_Diversion_Delete_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not deleted successfully");
				log.info("City_Waste_Diversion_Delete_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Waste_Diversion_Delete_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify score gets populated when data is added for previous year for both the
	// meters- 'Municipal Solid Waste generation intensity' and 'Municipal Solid
	// Waste Diversion rate from Landfill '

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"City_Waste_Diversion_SavePreviousYearData",
			"City_Waste_Generation_SavePreviousYearData" }, priority = 140, enabled = true, description = "Verify score gets populated when data is added for previous year for both the meters- 'Municipal Solid Waste generation intensity' and 'Municipal Solid Waste Diversion rate from Landfill '  ")
	public void City_Waste_Score_SavePreviousYearDataForGenerationAndDiversion() {

		log.info(
				"City_Waste_Score_SavePreviousYearDataForGenerationAndDiversion method started......................... ");
		int OldScore, NewScore;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID = "8000007095";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonMunicipalSolidwastegeneration();
			OldScore = CityPage.getWasteScore();
			log.info("Old Score is --" + OldScore);
			CityPage.CheckWaste_Generation_SaveNewRecord();

			CityPage.ClickonMunicipalSolidWasteDiversion();
			CityPage.CheckWaste_Diversion_SaveNewRecord();
			NewScore = CityPage.getWasteScore();

			log.info("Old Score is --" + OldScore);
			log.info("New Score is --" + NewScore);
			if (NewScore > OldScore) {
				log.info("Waste Score is generated successfully");
				log.info(
						"City_Waste_Score_SavePreviousYearDataForGenerationAndDiversion method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Waste Score is not generated successfully");
				log.info(
						"City_Waste_Score_SavePreviousYearDataForGenerationAndDiversion method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Waste_Score_SavePreviousYearDataForGenerationAndDiversion method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Waste --> Municipal solid waste diversion rate from landfill --> Verify
	// 'Comments' section by adding comment should show correct timestamp.
	// Waste --> Municipal solid waste diversion rate from landfill -->'Activity'
	// section should show correct activity with date and
	// timestamp.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 141, enabled = true, description = "Waste --> Municipal solid waste diversion rate from landfill -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void City_Waste_Diversion_Comments_Activity_Test() {

		log.info("City_Waste_Diversion_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Perf4");
		// ProjectCityID="8000004466";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonMunicipalSolidWasteDiversion();
			flag = CityPage.checkWasteDiversionCommentAndActivity(data.getCellData("City", 13, 2), ProfileUserName);

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_Waste_Diversion_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Waste_Diversion_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Waste --> Municipal solid waste diversion rate from landfill -->Verify
	// Details tab shows graph populated with reading value and respective year.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 142, enabled = false, description = " Waste --> Municipal solid waste diversion rate from landfill --> Verify Details tab shows graph populated with reading value  and respective year.")
	public void City_WasteDiversion_DetailsTab_Graph_Test() {

		log.info("City_WasteDiversion_DetailsTab_Graph_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Test1");
		// ProjectCityID="8000007155";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonMunicipalSolidWasteDiversion();
			flag = CityPage.CheckWasteDiversionGraph();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_WasteDiversion_DetailsTab_Graph_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_WasteDiversion_DetailsTab_Graph_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Waste --> Municipal solid waste diversion rate from landfill - >Verify filter
	// button - From (Start date) and To (End date) uopens up decade calendar and on
	// selecting any year range, the line items falling into those year should be
	// displayed.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 143, dependsOnMethods = "City_Waste_Diversion_SavePreviousYearData", enabled = true, description = "Waste --> Municipal solid waste diversion rate from landfill - >Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
	public void City_Waste_Diversion_FilterTest() {

		log.info("City_Waste_Diversion_FilterTest method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Perf4");
		// ProjectCityID="8000004510";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonMunicipalSolidWasteDiversion();
			flag = CityPage.CheckWaste_DiversionFilter();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Waste_Diversion_FilterTest method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Waste_Diversion_FilterTest method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

//*********************************************Transportation Test Cases*************************
	// Verify for Transport, 'Vehicle Miles travelled on individual vehicles
	// daily(VMT) gets added by default with "Data" ad "Details" tab.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 144, enabled = true, description = "Verify for Transport, 'Vehicle Miles travelled on individual vehicles daily(VMT) gets added by default with Data and Details tab.")
	public void City_Transportation_VMT_With_DataAndDetails_Display() {

		log.info("City_Transportation_VMT_With_DataAndDetails_Display method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("CityProject_NonLeed2","8000004525");
		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000006972";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonVMT();
			flag = CityPage.CheckVMT_Data_DetailsTab_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Transportation_VMT_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Transportation_VMT_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify 'Add year' button adds line item with year for previous year.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Transportation_VMT_With_DataAndDetails_Display", priority = 144, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
	public void City_Transportation_VMT_AddYear_AddNewLine() {

		log.info("City_Transportation_VMT_AddYear_AddNewLine method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004456";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonVMT();
			flag = CityPage.CheckTransport_VMT_AddYear_NewRow_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Transportation_VMT_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Transportation_VMT_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Transportation - Verify by adding value to reading and clicking on save
	// button.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Transportation_VMT_AddYear_AddNewLine", priority = 144, enabled = true, description = "Transportation - >Verify by adding value to reading and clicking on save button. ")
	public void City_Transportation_SavePreviousYearData() {

		log.info("City_Transportation_SavePreviousYearData method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000011540";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonVMT();
			// OldScore = CityPage.getTransportScore();
			flag = CityPage.CheckTransportation_SaveNewRecord();

			if (flag) {
				log.info("City_Transportation_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info("City_Transportation_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Transportation_SavePreviousYearData method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify score gets populated when data is added for previous year

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Transportation_SavePreviousYearData", priority = 144, enabled = true, description = "Transportation - >Verify score gets populated when data is added for previous year  ")
	public void City_Transportation_CheckScore() {

		log.info("City_Transportation_CheckScore method started......................... ");
		int Score;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004377";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonVMT();
			Score = CityPage.getTransportScore();

			if (Score > 0) {
				log.info("Score is updated with---" + Score);
				log.info("City_Transportation_CheckScore method ends here ........... ");
				Assert.assertTrue(true);
			} else {
				log.info("City_Transportation_CheckScore method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Transportation_CheckScore method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Transportation - VMT - >Verify 'previous year' and 'next year' button adds
	// reading respectively.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 145, dependsOnMethods = "City_Transportation_SavePreviousYearData", enabled = true, description = "Transportation - VMT - > Verify 'previous year' and 'next year' button adds reading respectively.")
	public void City_Transportation_VMT_AddRow_PreviousYear_NextYear() {

		log.info("City_Transportation_VMT_AddRow_PreviousYear_NextYear method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000011540";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonVMT();
			flag = CityPage.Transportation_VMT_SavePreviousAndNextYearRecord();
			if (flag) {
				log.info("City_Transportation_VMT_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info("City_Transportation_VMT_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Transportation_VMT_AddRow_PreviousYear_NextYear method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Transportation - Verify able to edit readings by using 'Edit' button.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Transportation_SavePreviousYearData", priority = 146, enabled = true, description = "Transportation - >Verify able to edit readings by using 'Edit' button.")

	public void City_Transportation_Edit_Test() {

		log.info("City_Transportation_Edit_Test method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004525";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonVMT();
			flag = CityPage.CheckTransportation_EditRecord();

			if (flag) {
				log.info("Record is updated successfully");
				log.info("City_Transportation_Edit_Test method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not updated successfully");
				log.info("City_Transportation_Edit_Test method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Transportation_Edit_Test method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Transportation - VMT - Verify able to delete line item by using delete
	// button.
	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Transportation_SavePreviousYearData", priority = 147, enabled = true, description = "Transportation - VMT - Verify able to delete line item by using delete button.")
	public void City_Transportation_VMT_Delete_Row() {

		log.info("City_Transportation_VMT_Delete_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004409";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonVMT();

			flag = CityPage.Transportation_VMT_DeleteRow();

			if (flag) {

				log.info("Record is deleted successfully");
				log.info("City_Transportation_VMT_Delete_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not deleted successfully");
				log.info("City_Transportation_VMT_Delete_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Transportation_VMT_Delete_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Transportation->VMT -->Verify Details tab shows graph populated with reading
	// value and respective year.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 148, enabled = false, description = " Transportation->VMT--> Verify Details tab shows graph populated with reading value  and respective year.")
	public void City_Transportation_DetailsTab_Graph_Test() {

		log.info("City_Transportation_DetailsTab_Graph_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Test1");
		// ProjectCityID="8000007155";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonVMT();
			flag = CityPage.CheckTransportationGraph();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_Transportation_DetailsTab_Graph_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Transportation_DetailsTab_Graph_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Transportation->VMT - Verify filter button - From (Start date) and To (End
	// date) opens up decade calendar and on selecting any year range, the line
	// items falling into those year should be displayed.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"City_Transportation_SavePreviousYearData" }, priority = 149, enabled = true, description = "Transportation->VMT - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
	public void City_Transportation_VMT_FilterTest() {

		log.info("City_Transportation_VMT_FilterTest method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Perf4");
		// ProjectCityID="8000011517";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonVMT();
			flag = CityPage.CheckTransportationFilter();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Transportation_VMT_FilterTest method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Transportation_VMT_FilterTest method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Transportation --> VMT --> Verify 'Comments' section by adding comment should
	// show correct timestamp.
	// Transportation --> VMT -->'Activity' section should show correct activity
	// with date and
	// timestamp.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 150, enabled = true, description = "Transportation --> VMT -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void City_Transportation_VMT_Comments_Activity_Test() {

		log.info("City_Transportation_VMT_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004527";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonVMT();
			// OldScore = CityPage.getTransportScore();
			flag = CityPage.checkTransportCommentAndActivity(data.getCellData("City", 15, 2), ProfileUserName);

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_Transportation_VMT_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Transportation_VMT_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// ****************************Quality of Life -- > Health & Safety: Median air
	// quality index (AQI) Test Cases*************************
	// Verify for Health & Safety: Median air quality index (AQI) gets added by
	// default with "Data" ad "Details" tab.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 152, enabled = true, description = "Verify for Health & Safety: Median air quality index (AQI) gets added by default with Data and Details tab.")
	public void City_Health_Safety_With_DataAndDetails_Display() {

		log.info("City_Health_Safety_With_DataAndDetails_Display method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004564";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonHealthAndSafety();
			flag = CityPage.CheckHealthAndSafety_Data_DetailsTab_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Health_Safety_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Health_Safety_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify 'Add year' button adds line item with year for previous year.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Health_Safety_With_DataAndDetails_Display", priority = 152, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
	public void City_Health_Safety_AddYear_AddNewLine() {

		log.info("City_Health_Safety_AddYear_AddNewLine method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004564";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonHealthAndSafety();
			flag = CityPage.CheckHealthAndSafety_AddYear_NewRow_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Health_Safety_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Health_Safety_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify validation Message after adding Invalid value(501)

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Health_Safety_AddYear_AddNewLine", priority = 152, enabled = true, description = "Verify validation Message after adding Invalid value(501)")
	public void City_Health_Safety_CheckWithInvalidValue() {

		log.info("City_Health_Safety_CheckWithInvalidValue method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000006849";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonHealthAndSafety();
			flag = CityPage.CheckHealthAndSafety_CheckWithInvalidValue();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Health_Safety_CheckWithInvalidValue method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Health_Safety_CheckWithInvalidValue method ends here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Quality Of Life--> Health And Safety - Verify by adding value to reading and
	// clicking on save button for previous year

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Health_Safety_AddYear_AddNewLine", priority = 153, enabled = true, description = "Quality Of Life --> Health & Safety: Median air quality index (AQI) - >Verify by adding value to reading and clicking on save button for previous year  ")
	public void City_HealthAndSafety_SavePreviousYearData() {

		log.info("City_HealthAndSafety_SavePreviousYearData method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000011537";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonHealthAndSafety();
			flag = CityPage.CheckHealthAndSafety_SaveNewRecord();

			if (flag) {
				log.info("City_HealthAndSafety_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not added successfully");
				log.info("City_HealthAndSafety_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_HealthAndSafety_SavePreviousYearData method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Health And Safety - >Verify 'previous year' and 'next
	// year' button adds reading respectively.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 153, dependsOnMethods = "City_HealthAndSafety_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Health And Safety - > Verify 'previous year' and 'next year' button adds reading respectively.")
	public void City_HealthAndSafety_AddRow_PreviousYear_NextYear() {

		log.info("City_HealthAndSafety_AddRow_PreviousYear_NextYear method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004564";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonHealthAndSafety();
			flag = CityPage.HealthAndSafety_SavePreviousAndNextYearRecord();
			if (flag) {
				log.info("City_HealthAndSafety_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info("City_HealthAndSafety_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_HealthAndSafety_AddRow_PreviousYear_NextYear method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Health And Safety - Verify able to edit readings by using
	// 'Edit' button.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 154, dependsOnMethods = "City_HealthAndSafety_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Health And Safety - >Verify able to edit readings by using 'Edit' button.")

	public void City_HealthAndSafety_Edit_Test() {

		log.info("City_HealthAndSafety_Edit_Test method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004564";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonHealthAndSafety();
			flag = CityPage.CheckHealthAndSafety_EditRecord();

			if (flag) {
				log.info("Record is updated successfully");
				log.info("City_HealthAndSafety_Edit_Test method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not updated successfully");
				log.info("City_HealthAndSafety_Edit_Test method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_HealthAndSafety_Edit_Test method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Health And Safety - Verify able to delete line item by
	// using delete button.
	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_HealthAndSafety_SavePreviousYearData", priority = 155, enabled = true, description = "Quality Of Life--> Health And Safety - Verify able to delete line item by using delete button.")
	public void City_HealthAndSafety_Delete_Row() {

		log.info("City_HealthAndSafety_Delete_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004564";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonHealthAndSafety();
			flag = CityPage.HealthAndSafety_DeleteRow();

			if (flag) {

				log.info("Record is deleted successfully");
				log.info("City_HealthAndSafety_Delete_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not deleted successfully");
				log.info("City_HealthAndSafety_Delete_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_HealthAndSafety_Delete_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Health And Safety - Verify filter button - From (Start
	// date) and To (End date) uopens up decade calendar and on selecting any year
	// range, the line items falling into those year should be displayed.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 156, enabled = true, description = "Quality Of Life--> Health And Safety - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
	public void City_HealthAndSafey_FilterTest() {

		log.info("City_HealthAndSafey_FilterTest method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Perf4");
		// ProjectCityID="8000004565";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonHealthAndSafety();
			flag = CityPage.CheckHealthAndSafetyFilter();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_HealthAndSafey_FilterTest method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_HealthAndSafey_FilterTest method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Quality Of Life--> Health And Safety --> Verify 'Comments' section by adding
	// comment should show correct timestamp.
	// Quality Of Life--> Health And Safety -->'Activity' section should show
	// correct activity with date and
	// timestamp.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 156, enabled = false, description = "Quality Of Life--> Health And Safety -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void City_HealthAndSafety_Comments_Activity_Test() {

		log.info("City_HealthAndSafety_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004527";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonHealthAndSafety();
			flag = CityPage.checkTransportCommentAndActivity(data.getCellData("City", 17, 2), ProfileUserName);

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_HealthAndSafety_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_HealthAndSafety_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// ****************************Quality of Life -- > Education: Population with
	// (at least) Bachelor's degree (%) Test Cases*************************
	// Verify for Education: Population with (at least) Bachelor's degree (%) gets
	// added by default with "Data" ad "Details" tab.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 159, enabled = true, description = "Verify for Education: Population with (at least) Bachelor's degree (%) gets added by default with Data and Details tab.")
	public void City_Education_Bachelor_Population_With_DataAndDetails_Display() {

		log.info(
				"City_Education_Bachelor_Population_With_DataAndDetails_Display method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004565";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEducation_BachelorPopulation();
			flag = CityPage.CheckEducation_BachelorPopulation_Data_DetailsTab_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Education_Bachelor_Population_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Education_Bachelor_Population_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify 'Add year' button adds line item with year for previous year.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Education_Bachelor_Population_With_DataAndDetails_Display", priority = 159, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
	public void City_Education_Bachelor_Population_AddYear_AddNewLine() {

		log.info("City_Education_Bachelor_Population_AddYear_AddNewLine method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004565";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEducation_BachelorPopulation();
			flag = CityPage.CheckEducation_Bachelor_Population_AddYear_NewRow_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Education_Bachelor_Population_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Education_Bachelor_Population_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify validation Message after adding Invalid Percent value(101).

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Education_Bachelor_Population_AddYear_AddNewLine", priority = 159, enabled = true, description = "Verify validation Message after adding Invalid Percent value(101)")
	public void City_Education_Bachelor_Population_SaveWithInvalidPercent() {

		log.info("City_Education_Bachelor_Population_SaveWithInvalidPercent method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000006849";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEducation_BachelorPopulation();
			flag = CityPage.CheckEducation_Bachelor_Population_CheckWithInvalidPercent();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Education_Bachelor_Population_SaveWithInvalidPercent method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Education_Bachelor_Population_SaveWithInvalidPercent method ends here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Quality Of Life--> Education: Population with (at least) Bachelor's degree
	// (%) -Verify by adding value to reading and clicking on save button for
	// previous year

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Education_Bachelor_Population_AddYear_AddNewLine", priority = 160, enabled = true, description = "Quality Of Life --> Education: Population with (at least) Bachelor's degree (%) - >Verify by adding value to reading and clicking on save button for previous year ")
	public void City_Education_Bachelor_Population_SavePreviousYearData() {

		log.info("City_Education_Bachelor_Population_SavePreviousYearData method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004565";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEducation_BachelorPopulation();
			flag = CityPage.CheckEductaion_Bachelor_Population_SaveNewRecord();

			if (flag) {
				log.info("City_Education_Bachelor_Population_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not added successfully");
				log.info("City_Education_Bachelor_Population_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Education_Bachelor_Population_SavePreviousYearData method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Education: Population with (at least) Bachelor's degree
	// (%) - >Verify 'previous year' and 'next year' button adds reading
	// respectively.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 160, dependsOnMethods = "City_Education_Bachelor_Population_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Education: Population with (at least) Bachelor's degree (%) - > Verify 'previous year' and 'next year' button adds reading respectively.")
	public void City_Education_Bachelor_Population_AddRow_PreviousYear_NextYear() {

		log.info(
				"City_Education_Bachelor_Population_AddRow_PreviousYear_NextYear method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000011537";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEducation_BachelorPopulation();
			flag = CityPage.Education_Bachelor_Population_SavePreviousAndNextYearRecord();
			if (flag) {
				log.info(
						"City_Education_Bachelor_Population_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info(
						"City_Education_Bachelor_Population_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Education_Bachelor_Population_AddRow_PreviousYear_NextYear method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Education: Population with (at least) Bachelor's degree
	// (%) - Verify able to edit readings by using 'Edit' button.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 161, dependsOnMethods = "City_Education_Bachelor_Population_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Education: Population with (at least) Bachelor's degree (%) - >Verify able to edit readings by using 'Edit' button.")

	public void City_Education_Bachelor_Population_Edit_Test() {

		log.info("City_Education_Bachelor_Population_Edit_Test method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004565";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEducation_BachelorPopulation();
			flag = CityPage.CheckEducation_Bachelor_population_EditRecord();

			if (flag) {
				log.info("Record is updated successfully");
				log.info("City_Education_Bachelor_Population_Edit_Test method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not updated successfully");
				log.info("City_Education_Bachelor_Population_Edit_Test method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Education_Bachelor_Population_Edit_Test method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Education: Population with (at least) Bachelor's degree
	// (%) - Verify able to delete line item by using delete button.
	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Education_Bachelor_Population_SavePreviousYearData", priority = 162, enabled = true, description = "Quality Of Life--> Education: Population with (at least) Bachelor's degree (%) - Verify able to delete line item by using delete button.")
	public void City_Education_Bachelor_Population_Delete_Row() {

		log.info("City_Education_Bachelor_Population_Delete_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000011545";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEducation_BachelorPopulation();
			flag = CityPage.Education_Bachelor_Population_DeleteRow();

			if (flag) {

				log.info("Record is deleted successfully");
				log.info("City_Education_Bachelor_Population_Delete_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not deleted successfully");
				log.info("City_Education_Bachelor_Population_Delete_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Education_Bachelor_Population_Delete_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Education: Population with (at least) Bachelor's degree
	// (%) - Verify filter button - From (Start date) and To (End date) uopens up
	// decade calendar and on selecting any year range, the line items falling into
	// those year should be displayed.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 163, dependsOnMethods = "City_Education_Bachelor_Population_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Education: Population with (at least) Bachelor's degree (%) - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
	public void City_Education_Bachelor_Population_FilterTest() {

		log.info("City_Education_Bachelor_Population_FilterTest method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Perf4");
		// ProjectCityID="8000004564";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEducation_BachelorPopulation();
			flag = CityPage.CheckEducation_Bachelor_Population_Filter();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Education_Bachelor_Population_FilterTest method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Education_Bachelor_Population_FilterTest method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Quality Of Life--> Education: Population with (at least) Bachelor's degree
	// (%) --> Verify 'Comments' section by adding comment should show correct
	// timestamp.
	// Quality Of Life--> Education: Population with (at least) Bachelor's degree
	// (%) -->'Activity' section should show correct activity with date and
	// timestamp.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 163, enabled = false, description = "Quality Of Life--> Health And Safety -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void City_Education_Bachelor_Population_Comments_Activity_Test() {

		log.info("City_Education_Bachelor_Population_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004527";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEducation_BachelorPopulation();
			flag = CityPage.checkTransportCommentAndActivity(data.getCellData("City", 19, 2), ProfileUserName);

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_HealthAndSafety_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_HealthAndSafety_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// ****************************Quality of Life -- > Equitability: Gini
	// coefficient (for income distribution) Test Cases*************************
	// Verify for Equitability: Gini coefficient (for income distribution) gets
	// added by default with "Data" ad "Details" tab.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 165, enabled = true, description = "Verify for Equitability: Gini coefficient (for income distribution) gets added by default with Data and Details tab.")
	public void City_Equitability_Gini_Coefficient_With_DataAndDetails_Display() {

		log.info(
				"City_Equitability_Gini_Coefficient_With_DataAndDetails_Display method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004564";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEquitability_Gini_Coeffiecient();
			flag = CityPage.CheckEquitability_Gini_Coefficient_Data_DetailsTab_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Equitability_Gini_Coefficient_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Equitability_Gini_Coefficient_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify 'Add year' button adds line item with year for previous year.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Equitability_Gini_Coefficient_With_DataAndDetails_Display", priority = 165, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
	public void City_Equitability_Gini_Coefficient_AddYear_AddNewLine() {

		log.info("City_Equitability_Gini_Coefficient_AddYear_AddNewLine method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004564";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEquitability_Gini_Coeffiecient();
			flag = CityPage.CheckEquitability_Gini_Coefficient_AddYear_NewRow_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Equitability_Gini_Coefficient_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Equitability_Gini_Coefficient_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify validation Message after adding Invalid value(Test Data -2)

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Equitability_Gini_Coefficient_AddYear_AddNewLine", priority = 165, enabled = true, description = "Verify validation Message after adding Invalid value(Test Data -2)")
	public void City_Equitability_Gini_Coefficient_SaveWithInvalidValue() {

		log.info("City_Equitability_Gini_Coefficient_SaveWithInvalidValue method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000006849";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEquitability_Gini_Coeffiecient();
			flag = CityPage.CheckEquitability_Gini_Coefficient_CheckWithInvalidValue();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Equitability_Gini_Coefficient_SaveWithInvalidValue method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Equitability_Gini_Coefficient_SaveWithInvalidValue method ends here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Quality Of Life--> Equitability: Gini coefficient (for income distribution) -
	// Verify by adding value to reading and clicking on save button for previous
	// year.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Equitability_Gini_Coefficient_AddYear_AddNewLine", priority = 166, enabled = true, description = "Quality Of Life --> Equitability: Gini coefficient (for income distribution) - >Verify by adding value to reading and clicking on save button for previous year ")
	public void City_Equitability_Gini_Coefficient_SavePreviousYearData() {

		log.info("City_Equitability_Gini_Coefficient_SavePreviousYearData method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004564";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEquitability_Gini_Coeffiecient();
			flag = CityPage.CheckEquitability_Gini_Coefficient_SaveNewRecord();

			if (flag) {
				log.info("City_Equitability_Gini_Coefficient_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not added successfully");
				log.info("City_Equitability_Gini_Coefficient_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Equitability_Gini_Coefficient_SavePreviousYearData method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Equitability: Gini coefficient (for income distribution) -
	// >Verify 'previous year' and 'next year' button adds reading respectively.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 166, dependsOnMethods = "City_Equitability_Gini_Coefficient_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Equitability: Gini coefficient (for income distribution) - > Verify 'previous year' and 'next year' button adds reading respectively.")
	public void City_Equitability_Gini_Coefficient_AddRow_PreviousYear_NextYear() {

		log.info(
				"City_Equitability_Gini_Coefficient_AddRow_PreviousYear_NextYear method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004564";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEquitability_Gini_Coeffiecient();
			flag = CityPage.Equitability_Gini_Coefficient_SavePreviousAndNextYearRecord();
			if (flag) {
				log.info(
						"City_Equitability_Gini_Coefficient_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info(
						"City_Equitability_Gini_Coefficient_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Equitability_Gini_Coefficient_AddRow_PreviousYear_NextYear method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Equitability: Gini coefficient (for income distribution) -
	// Verify able to edit readings by using 'Edit' button.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 167, dependsOnMethods = "City_Equitability_Gini_Coefficient_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Equitability: Gini coefficient (for income distribution) - >Verify able to edit readings by using 'Edit' button.")

	public void City_Equitability_Gini_Coefficient_Edit_Test() {

		log.info("City_Equitability_Gini_Coefficient_Edit_Test method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004564";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEquitability_Gini_Coeffiecient();
			flag = CityPage.CheckEquitability_Gini_Coefficient_EditRecord();

			if (flag) {
				log.info("Record is updated successfully");
				log.info("City_Equitability_Gini_Coefficient_Edit_Test method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not updated successfully");
				log.info("City_Equitability_Gini_Coefficient_Edit_Test method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Equitability_Gini_Coefficient_Edit_Test method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Equitability: Gini coefficient (for income distribution) -
	// Verify able to delete line item by using delete button.
	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Equitability_Gini_Coefficient_SavePreviousYearData", priority = 168, enabled = true, description = "Quality Of Life--> Equitability: Gini coefficient (for income distribution) - Verify able to delete line item by using delete button.")
	public void City_Equitability_Gini_Coefficient_Delete_Row() {

		log.info("City_Equitability_Gini_Coefficient_Delete_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004564";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEquitability_Gini_Coeffiecient();
			flag = CityPage.Equitability_Gini_Coefficient_DeleteRow();

			if (flag) {

				log.info("Record is deleted successfully");
				log.info("City_Equitability_Gini_Coefficient_Delete_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not deleted successfully");
				log.info("City_Equitability_Gini_Coefficient_Delete_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Equitability_Gini_Coefficient_Delete_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Equitability: Gini coefficient (for income distribution) -
	// Verify filter button - From (Start date) and To (End date) uopens up decade
	// calendar and on selecting any year range, the line items falling into those
	// year should be displayed.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 169, dependsOnMethods = "City_Equitability_Gini_Coefficient_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Equitability: Gini coefficient (for income distribution) - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
	public void City_Equitability_Gini_Coefficient_FilterTest() {

		log.info("City_Equitability_Gini_Coefficient_FilterTest method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Perf4");
		// ProjectCityID="8000004565";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEquitability_Gini_Coeffiecient();
			flag = CityPage.CheckEquitability_Gini_Coefficient_Filter();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Equitability_Gini_Coefficient_FilterTest method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Equitability_Gini_Coefficient_FilterTest method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Quality Of Life--> Equitability: Gini coefficient (for income distribution)
	// --> Verify 'Comments' section by adding comment should show correct
	// timestamp.
	// Quality Of Life--> Equitability: Gini coefficient (for income distribution)
	// -->'Activity' section should show correct activity with date and
	// timestamp.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 169, enabled = false, description = "Quality Of Life--> Equitability: Gini coefficient (for income distribution)  -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void City_Equitability_Gini_Coefficient_Comments_Activity_Test() {

		log.info("City_Equitability_Gini_Coefficient_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004527";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEquitability_Gini_Coeffiecient();
			flag = CityPage.checkTransportCommentAndActivity(data.getCellData("City", 21, 2), ProfileUserName);

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_Equitability_Gini_Coefficient_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Equitability_Gini_Coefficient_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// ****************************Quality of Life -- > Education: Population with
	// (at least) High School degree (%) Test Cases*************************
	// Verify for Education: Population with (at least) High School degree (%) gets
	// added by default with "Data" ad "Details" tab.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 171, enabled = true, description = "Verify for Education: Population with (at least) High School degree (%) gets added by default with Data and Details tab.")
	public void City_Education_HighSchoolPopulation_With_DataAndDetails_Display() {

		log.info(
				"City_Education_HighSchoolPopulation_With_DataAndDetails_Display method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004564";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEducation_HighSchoolPopulation();
			flag = CityPage.CheckEducation_HighSchoolPopulation_Data_DetailsTab_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Education_HighSchoolPopulation_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Education_HighSchoolPopulation_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify 'Add year' button adds line item with year for previous year.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Education_HighSchoolPopulation_With_DataAndDetails_Display", priority = 171, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
	public void City_Education_HighSchoolPopulation_AddYear_AddNewLine() {

		log.info("City_Education_HighSchoolPopulation_AddYear_AddNewLine method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004564";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEducation_HighSchoolPopulation();
			flag = CityPage.CheckEducation_HighSchoolPopulation_AddYear_NewRow_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Education_HighSchoolPopulation_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Education_HighSchoolPopulation_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify validation Message after adding Invalid Percent value(Test Data - 101)

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Education_HighSchoolPopulation_AddYear_AddNewLine", priority = 171, enabled = true, description = "Verify validation Message after adding Invalid Percent value(Test Data - 101)")
	public void City_Education_HighSchoolPopulation_SaveWithInvalidPercent() {

		log.info("City_Education_HighSchoolPopulation_AddYear_AddNewLine method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000006849";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEducation_HighSchoolPopulation();
			flag = CityPage.CheckEducation_HighSchoolPopulation_CheckWithInvalidPercent();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Education_HighSchoolPopulation_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Education_HighSchoolPopulation_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Quality Of Life--> Education: Population with (at least) High School degree
	// (%) - Verify by adding value to reading and clicking on save button for
	// previous year.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Education_HighSchoolPopulation_AddYear_AddNewLine", priority = 172, enabled = true, description = "Quality Of Life --> Education: Population with (at least) High School degree (%) - >Verify by adding value to reading and clicking on save button for previous year. ")
	public void City_Education_HighSchoolPopulation_SavePreviousYearData() {

		log.info("City_Education_HighSchoolPopulation_SavePreviousYearData method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004564";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEducation_HighSchoolPopulation();
			flag = CityPage.CheckEducation_HighSchoolPopulation_SaveNewRecord();

			if (flag) {
				log.info("City_Education_HighSchoolPopulation_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not added successfully");
				log.info("City_Education_HighSchoolPopulation_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Education_HighSchoolPopulation_SavePreviousYearData method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Education: Population with (at least) High School degree
	// (%) - >Verify 'previous year' and 'next year' button adds reading
	// respectively.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 172, dependsOnMethods = "City_Education_HighSchoolPopulation_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Education: Population with (at least) High School degree (%) - > Verify 'previous year' and 'next year' button adds reading respectively.")
	public void City_Education_HighSchoolPopulation_AddRow_PreviousYear_NextYear() {

		log.info(
				"City_Education_HighSchoolPopulation_AddRow_PreviousYear_NextYear method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004564";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEducation_HighSchoolPopulation();
			flag = CityPage.Education_HighSchoolPopulation_SavePreviousAndNextYearRecord();
			if (flag) {
				log.info(
						"City_Education_HighSchoolPopulation_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info(
						"City_Education_HighSchoolPopulation_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Education_HighSchoolPopulation_AddRow_PreviousYear_NextYear method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Education: Population with (at least) High School degree
	// (%) - Verify able to edit readings by using 'Edit' button.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 173, dependsOnMethods = "City_Education_HighSchoolPopulation_SavePreviousYearData", enabled = true, description = "Quality Of Life-->Education: Population with (at least) High School degree (%)  - >Verify able to edit readings by using 'Edit' button.")

	public void City_Education_HighSchoolPopulation_Edit_Test() {

		log.info("City_Education_HighSchoolPopulation_Edit_Test method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004564";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEducation_HighSchoolPopulation();
			flag = CityPage.CheckEducation_HighSchoolPopulation_EditRecord();

			if (flag) {
				log.info("Record is updated successfully");
				log.info("City_Education_HighSchoolPopulation_Edit_Test method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not updated successfully");
				log.info("City_Education_HighSchoolPopulation_Edit_Test method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Education_HighSchoolPopulation_Edit_Test method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Education: Population with (at least) High School degree
	// (%) - Verify able to delete line item by using delete button.
	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Education_HighSchoolPopulation_SavePreviousYearData", priority = 174, enabled = true, description = "Quality Of Life--> Education: Population with (at least) High School degree (%) - Verify able to delete line item by using delete button.")
	public void City_Education_HighSchoolPopulation_Delete_Row() {

		log.info("City_Education_HighSchoolPopulation_Delete_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004564";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEducation_HighSchoolPopulation();
			flag = CityPage.Education_HighSchoolPopulation_DeleteRow();

			if (flag) {

				log.info("Record is deleted successfully");
				log.info("City_Education_HighSchoolPopulation_Delete_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not deleted successfully");
				log.info("City_Education_HighSchoolPopulation_Delete_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Education_HighSchoolPopulation_Delete_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Education: Population with (at least) High School degree
	// (%) - Verify filter button - From (Start date) and To (End date) uopens up
	// decade calendar and on selecting any year range, the line items falling into
	// those year should be displayed.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 175, enabled = true, description = "Quality Of Life--> Education: Population with (at least) High School degree (%) - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
	public void City_Education_HighSchoolPopulation_FilterTest() {

		log.info("City_Education_HighSchoolPopulation_FilterTest method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Perf4");
		// ProjectCityID="8000011517";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEducation_HighSchoolPopulation();
			flag = CityPage.CheckEducation_HighSchoolPopulation_Filter();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Education_HighSchoolPopulation_FilterTest method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Education_HighSchoolPopulation_FilterTest method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Quality Of Life--> Education: Population with (at least) High School degree
	// (%) --> Verify 'Comments' section by adding comment should show correct
	// timestamp.
	// Quality Of Life--> Education: Population with (at least) High School degree
	// (%) -->'Activity' section should show correct activity with date and
	// timestamp.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 176, enabled = false, description = "Quality Of Life--> Education: Population with (at least) High School degree (%)  -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void City_Equitability_Gini_Coefficient_Comments_Activity_Test1() {

		log.info("City_Equitability_Gini_Coefficient_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004527";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEquitability_Gini_Coeffiecient();

			flag = CityPage.checkTransportCommentAndActivity(data.getCellData("City", 23, 2), ProfileUserName);

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_Equitability_Gini_Coefficient_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Equitability_Gini_Coefficient_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

//****************************Quality of Life -- >	Prosperity: Median household income (US Dollars/Year) Test Cases*************************
	// Verify for Prosperity: Median household income (US Dollars/Year) gets added
	// by default with "Data" ad "Details" tab.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 177, enabled = true, description = "Verify for Prosperity: Median household income (US Dollars/Year) gets added by default with Data and Details tab.")
	public void City_ProsperityMedianIncome_With_DataAndDetails_Display() {

		log.info("City_ProsperityMedianIncome_With_DataAndDetails_Display method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004567";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProsperity_MedianIncome();
			flag = CityPage.CheckProsperityMedianIncome_Data_DetailsTab_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_ProsperityMedianIncome_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_ProsperityMedianIncome_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify 'Add year' button adds line item with year for previous year.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_ProsperityMedianIncome_With_DataAndDetails_Display", priority = 177, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
	public void City_ProsperityMedianIncome_AddYear_AddNewLine() {

		log.info("City_ProsperityMedianIncome_AddYear_AddNewLine method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004567";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProsperity_MedianIncome();
			flag = CityPage.CheckProsperityMedianIncome_AddYear_NewRow_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_ProsperityMedianIncome_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_ProsperityMedianIncome_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Quality Of Life--> Prosperity: Median household income (US Dollars/Year) -
	// Verify by adding value to reading and clicking on save button for previous
	// year.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_ProsperityMedianIncome_AddYear_AddNewLine", priority = 177, enabled = true, description = "Quality Of Life --> Prosperity: Median household income (US Dollars/Year) - >Verify by adding value to reading and clicking on save button for previous year. ")
	public void City_ProsperityMedianIncome_SavePreviousYearData() {

		log.info("City_ProsperityMedianIncome_SavePreviousYearData method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004567";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProsperity_MedianIncome();
			flag = CityPage.CheckProsperityMedianIncome_SaveNewRecord();

			if (flag) {
				log.info("City_ProsperityMedianIncome_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not added successfully");
				log.info("City_ProsperityMedianIncome_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_ProsperityMedianIncome_SavePreviousYearData method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Prosperity: Median household income (US Dollars/Year) -
	// >Verify 'previous year' and 'next year' button adds reading respectively.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 177, dependsOnMethods = "City_ProsperityMedianIncome_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Prosperity: Median household income (US Dollars/Year)  - > Verify 'previous year' and 'next year' button adds reading respectively.")
	public void City_ProsperityMedianIncome_AddRow_PreviousYear_NextYear() {

		log.info("City_ProsperityMedianIncome_AddRow_PreviousYear_NextYear method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004567";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProsperity_MedianIncome();
			flag = CityPage.ProsperityMedianIncome_SavePreviousAndNextYearRecord();
			if (flag) {
				log.info("City_ProsperityMedianIncome_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info("City_ProsperityMedianIncome_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_ProsperityMedianIncome_AddRow_PreviousYear_NextYear method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Prosperity: Median household income (US Dollars/Year) -
	// Verify able to edit readings by using 'Edit' button.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 178, dependsOnMethods = "City_ProsperityMedianIncome_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Prosperity: Median household income (US Dollars/Year)   - >Verify able to edit readings by using 'Edit' button.")

	public void City_ProsperityMedianIncome_Edit_Test() {

		log.info("City_ProsperityMedianIncome_Edit_Test method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004567";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProsperity_MedianIncome();
			flag = CityPage.CheckProsperityMedianIncome_EditRecord();

			if (flag) {
				log.info("Record is updated successfully");
				log.info("City_ProsperityMedianIncome_Edit_Test method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not updated successfully");
				log.info("City_ProsperityMedianIncome_Edit_Test method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_ProsperityMedianIncome_Edit_Test method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Prosperity: Median household income (US Dollars/Year) -
	// Verify able to delete line item by using delete button.
	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_ProsperityMedianIncome_SavePreviousYearData", priority = 179, enabled = true, description = "Quality Of Life--> Prosperity: Median household income (US Dollars/Year) - Verify able to delete line item by using delete button.")
	public void City_ProsperityMedianIncome_Delete_Row() {

		log.info("City_ProsperityMedianIncome_Delete_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004567";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProsperity_MedianIncome();
			flag = CityPage.ProsperityMedianIncome_DeleteRow();

			if (flag) {

				log.info("Record is deleted successfully");
				log.info("City_ProsperityMedianIncome_Delete_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not deleted successfully");
				log.info("City_ProsperityMedianIncome_Delete_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_ProsperityMedianIncome_Delete_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Prosperity: Median household income (US Dollars/Year) -
	// Verify filter button - From (Start date) and To (End date) uopens up decade
	// calendar and on selecting any year range, the line items falling into those
	// year should be displayed.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_ProsperityMedianIncome_SavePreviousYearData", priority = 180, enabled = true, description = "Quality Of Life--> Prosperity: Median household income (US Dollars/Year) - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
	public void City_ProsperityMedianIncome_FilterTest() {

		log.info("City_ProsperityMedianIncome_FilterTest method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Perf4");
		// ProjectCityID="8000004568";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProsperity_MedianIncome();
			flag = CityPage.CheckProsperityMedianIncome_Filter();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_ProsperityMedianIncome_FilterTest method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_ProsperityMedianIncome_FilterTest method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Quality Of Life--> Prosperity: Median household income (US Dollars/Year) -->
	// Verify 'Comments' section by adding comment should show correct timestamp.
	// Quality Of Life--> Prosperity: Median household income (US Dollars/Year)
	// -->'Activity' section should show correct activity with date and
	// timestamp.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 180, enabled = false, description = "Quality Of Life--> Prosperity: Median household income (US Dollars/Year)  -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void City_ProsperityMedianIncome_Comments_Activity_Test() {

		log.info("City_ProsperityMedianIncome_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004527";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEquitability_Gini_Coeffiecient();
			flag = CityPage.checkTransportCommentAndActivity(data.getCellData("City", 25, 2), ProfileUserName);

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_ProsperityMedianIncome_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_ProsperityMedianIncome_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

//****************************Quality of Life -- >	Equitability: Median gross rent as (%) of household income Test Cases*************************
	// Verify for Equitability: Median gross rent as (%) of household income gets
	// added by default with "Data" ad "Details" tab.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 183, enabled = true, description = "Verify for Equitability: Median gross rent as (%) of household income gets added by default with Data and Details tab.")
	public void City_Equitability_MedianGrossIncome_With_DataAndDetails_Display() {

		log.info(
				"City_Equitability_MedianGrossIncome_With_DataAndDetails_Display method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004567";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEquitability_MedianGrossIncome();
			flag = CityPage.CheckEquitability_MedianGrossIncome_Data_DetailsTab_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Equitability_MedianGrossIncome_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Equitability_MedianGrossIncome_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify 'Add year' button adds line item with year for previous year.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Equitability_MedianGrossIncome_With_DataAndDetails_Display", priority = 183, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
	public void City_Equitability_MedianGrossIncome_AddYear_AddNewLine() {

		log.info("City_Equitability_MedianGrossIncome_AddYear_AddNewLine method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004567";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEquitability_MedianGrossIncome();
			flag = CityPage.CheckEquitability_MedianGrossIncome_AddYear_NewRow_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Equitability_MedianGrossIncome_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Equitability_MedianGrossIncome_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify validation Message after adding Invalid Percent value(Test Data - 101)

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Equitability_MedianGrossIncome_AddYear_AddNewLine", priority = 183, enabled = true, description = "Verify validation Message after adding Invalid Percent value(Test Data - 101)")
	public void City_Equitability_MedianGrossIncome_SaveWithInvalidPercent() {

		log.info("City_Equitability_MedianGrossIncome_SaveWithInvalidPercent method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000006849";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEquitability_MedianGrossIncome();
			flag = CityPage.CheckEquitability_MedianGrossIncome_CheckWithInvalidPercentValue();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Equitability_MedianGrossIncome_SaveWithInvalidPercent method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Equitability_MedianGrossIncome_SaveWithInvalidPercent method ends here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Quality Of Life--> Equitability: Median gross rent as (%) of household income
	// - Verify by adding value to reading and clicking on save button for previous
	// year

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Equitability_MedianGrossIncome_AddYear_AddNewLine", priority = 184, enabled = true, description = "Quality Of Life --> Equitability: Median gross rent as (%) of household income - >Verify by adding value to reading and clicking on save button for previous year  ")
	public void City_Equitability_MedianGrossIncome_SavePreviousYearData() {

		log.info("City_Equitability_MedianGrossIncome_SavePreviousYearData method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004567";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEquitability_MedianGrossIncome();
			flag = CityPage.CheckEquitability_MedianGrossIncome_SaveNewRecord();

			if (flag) {
				log.info("City_Equitability_MedianGrossIncome_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not added successfully");
				log.info("City_Equitability_MedianGrossIncome_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Equitability_MedianGrossIncome_SavePreviousYearData method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Equitability: Median gross rent as (%) of household income
	// - >Verify 'previous year' and 'next year' button adds reading respectively.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 184, dependsOnMethods = "City_Equitability_MedianGrossIncome_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Equitability: Median gross rent as (%) of household income  - > Verify 'previous year' and 'next year' button adds reading respectively.")
	public void City_Equitability_MedianGrossIncome_AddRow_PreviousYear_NextYear() {

		log.info(
				"City_Equitability_MedianGrossIncome_AddRow_PreviousYear_NextYear method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004567";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEquitability_MedianGrossIncome();
			flag = CityPage.Equitability_MedianGrossIncome_SavePreviousAndNextYearRecord();
			if (flag) {
				log.info(
						"City_Equitability_MedianGrossIncome_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info(
						"City_Equitability_MedianGrossIncome_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Equitability_MedianGrossIncome_AddRow_PreviousYear_NextYear method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Equitability: Median gross rent as (%) of household income
	// - Verify able to edit readings by using 'Edit' button.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 185, dependsOnMethods = "City_Equitability_MedianGrossIncome_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Equitability: Median gross rent as (%) of household income   - >Verify able to edit readings by using 'Edit' button.")

	public void City_Equitability_MedianGrossIncome_Edit_Test() {

		log.info("City_Equitability_MedianGrossIncome_Edit_Test method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004567";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEquitability_MedianGrossIncome();
			flag = CityPage.CheckEquitability_MedianGrossIncome_EditRecord();

			if (flag) {
				log.info("Record is updated successfully");
				log.info("City_Equitability_MedianGrossIncome_Edit_Test method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not updated successfully");
				log.info("City_Equitability_MedianGrossIncome_Edit_Test method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Equitability_MedianGrossIncome_Edit_Test method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Equitability: Median gross rent as (%) of household income
	// - Verify able to delete line item by using delete button.
	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Equitability_MedianGrossIncome_SavePreviousYearData", priority = 186, enabled = true, description = "Quality Of Life--> Equitability: Median gross rent as (%) of household income - Verify able to delete line item by using delete button.")
	public void City_Equitability_MedianGrossIncome_Delete_Row() {

		log.info("City_Equitability_MedianGrossIncome_Delete_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004567";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEquitability_MedianGrossIncome();
			flag = CityPage.Equitability_MedianGrossIncome_DeleteRow();

			if (flag) {

				log.info("Record is deleted successfully");
				log.info("City_Equitability_MedianGrossIncome_Delete_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not deleted successfully");
				log.info("City_Equitability_MedianGrossIncome_Delete_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_Equitability_MedianGrossIncome_Delete_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Equitability: Median gross rent as (%) of household income
	// - Verify filter button - From (Start date) and To (End date) uopens up decade
	// calendar and on selecting any year range, the line items falling into those
	// year should be displayed.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Equitability_MedianGrossIncome_SavePreviousYearData", priority = 187, enabled = true, description = "Quality Of Life--> Equitability: Median gross rent as (%) of household income - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
	public void City_Equitability_MedianGrossIncome_FilterTest() {

		log.info("City_Equitability_MedianGrossIncome_FilterTest method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Perf4");
		// ProjectCityID="8000004568";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEquitability_MedianGrossIncome();
			flag = CityPage.CheckEquitability_MedianGrossIncome_Filter();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_Equitability_MedianGrossIncome_FilterTest method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Equitability_MedianGrossIncome_FilterTest method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Quality Of Life--> Equitability: Median gross rent as (%) of household income
	// --> Verify 'Comments' section by adding comment should show correct
	// timestamp.
	// Quality Of Life--> Equitability: Median gross rent as (%) of household income
	// -->'Activity' section should show correct activity with date and
	// timestamp.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 187, enabled = false, description = "Quality Of Life--> Equitability: Median gross rent as (%) of household income  -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void City_Equitability_MedianGrossIncome_Comments_Activity_Test() {

		log.info("City_Equitability_MedianGrossIncome_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004527";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonEquitability_MedianGrossIncome();
			flag = CityPage.checkTransportCommentAndActivity(data.getCellData("City", 27, 2), ProfileUserName);

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_Equitability_MedianGrossIncome_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Equitability_MedianGrossIncome_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

//****************************Quality of Life -- >	Prosperity: Unemployment rate (%) Test Cases*************************
	// Verify for Prosperity: Unemployment rate (%) gets added by default with
	// "Data" ad "Details" tab.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 189, enabled = true, description = "Verify for Prosperity: Unemployment rate (%) gets added by default with Data and Details tab.")
	public void City_ProsperityUnemployementRate_With_DataAndDetails_Display() {

		log.info(
				"City_ProsperityUnemployementRate_With_DataAndDetails_Display method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000006625";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProsperityUnemployementRate();
			flag = CityPage.CheckProsperityUnemployementRate_Data_DetailsTab_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_ProsperityUnemployementRate_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_ProsperityUnemployementRate_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify 'Add year' button adds line item with year for previous year.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_ProsperityUnemployementRate_With_DataAndDetails_Display", priority = 189, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
	public void City_ProsperityUnemployementRate_AddYear_AddNewLine() {

		log.info("City_ProsperityUnemployementRate_AddYear_AddNewLine method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000006625";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProsperityUnemployementRate();
			flag = CityPage.CheckProsperityUnemployementRate_AddYear_NewRow_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_ProsperityUnemployementRate_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_ProsperityUnemployementRate_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify validation Message after adding Invalid Percent value(Test Data - 101)

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_ProsperityUnemployementRate_AddYear_AddNewLine", priority = 189, enabled = true, description = "Verify validation Message after adding Invalid Percent value(Test Data - 101)")
	public void City_ProsperityUnemployementRate_SaveWithInvalidPercent() {

		log.info("City_ProsperityUnemployementRate_SaveWithInvalidPercent method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000006844";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProsperityUnemployementRate();
			flag = CityPage.CheckProsperityUnemployementRate_CheckWithInvalidValue();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_ProsperityUnemployementRate_SaveWithInvalidPercent method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_ProsperityUnemployementRate_SaveWithInvalidPercent method ends here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Quality Of Life--> Prosperity: Unemployment rate (%) - Verify by adding value
	// to reading and clicking on save button for previous year

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_ProsperityUnemployementRate_AddYear_AddNewLine", priority = 190, enabled = true, description = "Quality Of Life --> Prosperity: Unemployment rate (%) - >Verify by adding value to reading and clicking on save button for previous year  ")
	public void City_ProsperityUnemployementRate_SavePreviousYearData() {

		log.info("City_ProsperityUnemployementRate_SavePreviousYearData method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000006625";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProsperityUnemployementRate();
			flag = CityPage.CheckProsperityUnemployementRate_SaveNewRecord();

			if (flag) {
				log.info("City_ProsperityUnemployementRate_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not added successfully");
				log.info("City_ProsperityUnemployementRate_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_ProsperityUnemployementRate_SavePreviousYearData method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Prosperity: Unemployment rate (%) - >Verify 'previous
	// year' and 'next year' button adds reading respectively.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 190, dependsOnMethods = "City_ProsperityUnemployementRate_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Prosperity: Unemployment rate (%)  - > Verify 'previous year' and 'next year' button adds reading respectively.")
	public void City_ProsperityUnemployementRate_AddRow_PreviousYear_NextYear() {

		log.info(
				"City_ProsperityUnemployementRate_AddRow_PreviousYear_NextYear method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000006625";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProsperityUnemployementRate();
			flag = CityPage.ProsperityUnemployementRate_SavePreviousAndNextYearRecord();
			if (flag) {
				log.info("City_ProsperityUnemployementRate_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info("City_ProsperityUnemployementRate_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_ProsperityUnemployementRate_AddRow_PreviousYear_NextYear method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Prosperity: Unemployment rate (%) - Verify able to edit
	// readings by using 'Edit' button.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 191, dependsOnMethods = "City_ProsperityUnemployementRate_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Prosperity: Unemployment rate (%)   - >Verify able to edit readings by using 'Edit' button.")

	public void City_ProsperityUnemployementRate_Edit_Test() {

		log.info("City_ProsperityUnemployementRate_Edit_Test method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000006625";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProsperityUnemployementRate();
			flag = CityPage.CheckProsperityUnemployementRate_EditRecord();

			if (flag) {
				log.info("Record is updated successfully");
				log.info("City_ProsperityUnemployementRate_Edit_Test method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not updated successfully");
				log.info("City_ProsperityUnemployementRate_Edit_Test method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_ProsperityUnemployementRate_Edit_Test method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Prosperity: Unemployment rate (%) - Verify able to delete
	// line item by using delete button.
	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_ProsperityUnemployementRate_SavePreviousYearData", priority = 192, enabled = true, description = "Quality Of Life--> Prosperity: Unemployment rate (%) - Verify able to delete line item by using delete button.")
	public void City_ProsperityUnemployementRate_Delete_Row() {

		log.info("City_ProsperityUnemployementRate_Delete_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000006625";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProsperityUnemployementRate();
			flag = CityPage.ProsperityUnemployementRate_DeleteRow();

			if (flag) {

				log.info("Record is deleted successfully");
				log.info("City_ProsperityUnemployementRate_Delete_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not deleted successfully");
				log.info("City_ProsperityUnemployementRate_Delete_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_ProsperityUnemployementRate_Delete_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Prosperity: Unemployment rate (%) - Verify filter button -
	// From (Start date) and To (End date) uopens up decade calendar and on
	// selecting any year range, the line items falling into those year should be
	// displayed.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_ProsperityUnemployementRate_SavePreviousYearData", priority = 193, enabled = true, description = "Quality Of Life--> Prosperity: Unemployment rate (%) - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
	public void City_ProsperityUnemployementRate_FilterTest() {

		log.info("City_ProsperityUnemployementRate_FilterTest method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Perf4");
		// ProjectCityID="8000006626";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProsperityUnemployementRate();
			flag = CityPage.CheckProsperityUnemployementRate_Filter();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_ProsperityUnemployementRate_FilterTest method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_ProsperityUnemployementRate_FilterTest method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Quality Of Life--> Prosperity: Unemployment rate (%) --> Verify 'Comments'
	// section by adding comment should show correct timestamp.
	// Quality Of Life--> Prosperity: Unemployment rate (%) -->'Activity' section
	// should show correct activity with date and
	// timestamp.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 193, enabled = false, description = "Quality Of Life--> Prosperity: Unemployment rate (%)  -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void City_ProsperityUnemployementRate_Comments_Activity_Test() {

		log.info("City_ProsperityUnemployementRate_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID = "8000004568";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonProsperityUnemployementRate();
			flag = CityPage.checkProsperityUnemployementRate(data.getCellData("City", 29, 2), ProfileUserName);

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_ProsperityUnemployementRate_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_ProsperityUnemployementRate_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// ****************************Quality of Life -- > Health & Safety: Air quality
	// days unhealthy for sensitive groups (Days/yr) Test
	// Cases*************************
	// Verify for Health & Safety: Air quality days unhealthy for sensitive groups
	// (Days/yr) gets added by default with "Data" ad "Details" tab.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 195, enabled = true, description = "Verify for Health & Safety: Air quality days unhealthy for sensitive groups (Days/yr) gets added by default with Data and Details tab.")
	public void City_HealthAndSafetySensitiveGroup_With_DataAndDetails_Display() {

		log.info(
				"City_HealthAndSafetySensitiveGroup_With_DataAndDetails_Display method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004567";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonHealthAndSafetySensitiveGroup();
			flag = CityPage.CheckHealthAndSafetySensitiveGroup_Data_DetailsTab_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_HealthAndSafetySensitiveGroup_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_HealthAndSafetySensitiveGroup_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify 'Add year' button adds line item with year for previous year.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_HealthAndSafetySensitiveGroup_With_DataAndDetails_Display", priority = 195, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
	public void City_HealthAndSafetySensitiveGroup_AddYear_AddNewLine() {

		log.info("City_HealthAndSafetySensitiveGroup_AddYear_AddNewLine method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004567";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonHealthAndSafetySensitiveGroup();
			flag = CityPage.CheckHealthAndSafetySensitiveGroup_AddYear_NewRow_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("CheckHealthAndSafetySensitiveGroup_AddYear_NewRow_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_HealthAndSafetySensitiveGroup_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify validation Message after adding Invalid value(Test Data - 366)

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 195, dependsOnMethods = "City_HealthAndSafetySensitiveGroup_AddYear_AddNewLine", enabled = true, description = "Verify validation Message after adding Invalid value(Test Data - 366)")
	public void City_HealthAndSafetySensitiveGroup_SaveWithInvalidValue() {

		log.info("City_HealthAndSafetySensitiveGroup_SaveWithInvalidValue method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000006844";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonHealthAndSafetySensitiveGroup();
			flag = CityPage.CheckHealthAndSafetySensitiveGroup_CheckWithInvalidValue();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_HealthAndSafetySensitiveGroup_SaveWithInvalidValue method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_HealthAndSafetySensitiveGroup_SaveWithInvalidValue method ends here ........... ");
			Assert.assertTrue(false);
		}
	}
	// Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive
	// groups (Days/yr) - Verify by adding value to reading and clicking on save
	// button for previous year

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_HealthAndSafetySensitiveGroup_AddYear_AddNewLine", priority = 196, enabled = true, description = "Quality Of Life --> Health & Safety: Air quality days unhealthy for sensitive groups (Days/yr) - >Verify by adding value to reading and clicking on save button for previous year ")
	public void City_HealthAndSafetySensitiveGroup_SavePreviousYearData() {

		log.info("City_HealthAndSafetySensitiveGroup_SavePreviousYearData method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004567";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonHealthAndSafetySensitiveGroup();
			flag = CityPage.CheckHealthAndSafetySensitiveGroup_SaveNewRecord();

			if (flag) {
				log.info("City_HealthAndSafetySensitiveGroup_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not added successfully");
				log.info("City_HealthAndSafetySensitiveGroup_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_HealthAndSafetySensitiveGroup_SavePreviousYearData method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive
	// groups (Days/yr) - >Verify 'previous year' and 'next year' button adds
	// reading respectively.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 196, dependsOnMethods = "City_HealthAndSafetySensitiveGroup_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive groups (Days/yr)  - > Verify 'previous year' and 'next year' button adds reading respectively.")
	public void City_HealthAndSafetySensitiveGroup_AddRow_PreviousYear_NextYear() {

		log.info(
				"City_HealthAndSafetySensitiveGroup_AddRow_PreviousYear_NextYear method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004567";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonHealthAndSafetySensitiveGroup();
			flag = CityPage.HealthAndSafetySensitiveGroup_SavePreviousAndNextYearRecord();
			if (flag) {
				log.info(
						"City_HealthAndSafetySensitiveGroup_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info(
						"City_HealthAndSafetySensitiveGroup_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_HealthAndSafetySensitiveGroup_AddRow_PreviousYear_NextYear method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive
	// groups (Days/yr) - Verify able to edit readings by using 'Edit' button.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 197, dependsOnMethods = "City_HealthAndSafetySensitiveGroup_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive groups (Days/yr)   - >Verify able to edit readings by using 'Edit' button.")

	public void City_HealthAndSafetySensitiveGroup_Edit_Test() {

		log.info("City_HealthAndSafetySensitiveGroup_Edit_Test method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004567";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonHealthAndSafetySensitiveGroup();
			flag = CityPage.CheckHealthAndSafetySensitiveGroup_EditRecord();

			if (flag) {
				log.info("Record is updated successfully");
				log.info("City_HealthAndSafetySensitiveGroup_Edit_Test method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not updated successfully");
				log.info("City_HealthAndSafetySensitiveGroup_Edit_Test method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_HealthAndSafetySensitiveGroup_Edit_Test method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive
	// groups (Days/yr) - Verify able to delete line item by using delete button.
	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_HealthAndSafetySensitiveGroup_SavePreviousYearData", priority = 198, enabled = true, description = "Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive groups (Days/yr) - Verify able to delete line item by using delete button.")
	public void City_HealthAndSafetySensitiveGroup_Delete_Row() {

		log.info("City_HealthAndSafetySensitiveGroup_Delete_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004567";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonHealthAndSafetySensitiveGroup();
			flag = CityPage.HealthAndSafetySensitiveGroup_DeleteRow();

			if (flag) {

				log.info("Record is deleted successfully");
				log.info("City_HealthAndSafetySensitiveGroup_Delete_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not deleted successfully");
				log.info("City_HealthAndSafetySensitiveGroup_Delete_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_HealthAndSafetySensitiveGroup_Delete_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive
	// groups (Days/yr) - Verify filter button - From (Start date) and To (End date)
	// uopens up decade calendar and on selecting any year range, the line items
	// falling into those year should be displayed.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_HealthAndSafetySensitiveGroup_SavePreviousYearData", priority = 199, enabled = true, description = "Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive groups (Days/yr) - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
	public void City_HealthAndSafetySensitiveGroup_FilterTest() {

		log.info("City_HealthAndSafetySensitiveGroup_FilterTest method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Perf4");
		// ProjectCityID="8000004568";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonHealthAndSafetySensitiveGroup();
			flag = CityPage.CheckHealthAndSafetySensitiveGroup_Filter();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_HealthAndSafetySensitiveGroup_FilterTest method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_HealthAndSafetySensitiveGroup_FilterTest method ends here ........... ");
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

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 199, enabled = false, description = "Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive groups (Days/yr)  -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void City_City_HealthAndSafetySensitiveGroup_Comments_Activity_Test() {

		log.info(
				"City_City_HealthAndSafetySensitiveGroup_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004568";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonHealthAndSafetySensitiveGroup();
			flag = CityPage.checkHealthAndSafetySensitiveGroup(data.getCellData("City", 31, 2), ProfileUserName);

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_City_HealthAndSafetySensitiveGroup_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_City_HealthAndSafetySensitiveGroup_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// ****************************Quality of Life -- > Health & Safety: Violent
	// Crime (per year per capita) Test Cases*************************
	// Verify for Health & Safety: Violent Crime (per year per capita) gets added by
	// default with "Data" ad "Details" tab.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 201, enabled = true, description = "Verify for Health & Safety: Violent Crime (per year per capita) gets added by default with Data and Details tab.")
	public void City_HealthAndSafetyVoilentCrime_With_DataAndDetails_Display() {

		log.info(
				"City_HealthAndSafetyVoilentCrime_With_DataAndDetails_Display method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("CityProject_NonLeed2","8000004525");
		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004567";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonHealthAndSafetyVoilentCrime();
			flag = CityPage.CheckHealthAndSafetyVoilentCrime_Data_DetailsTab_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_HealthAndSafetyVoilentCrime_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_HealthAndSafetyVoilentCrime_With_DataAndDetails_Display method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify 'Add year' button adds line item with year for previous year.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_HealthAndSafetyVoilentCrime_With_DataAndDetails_Display", priority = 201, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
	public void City_HealthAndSafetyVoilentCrime_AddYear_AddNewLine() {

		log.info("City_HealthAndSafetyVoilentCrime_AddYear_AddNewLine method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004567";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonHealthAndSafetyVoilentCrime();
			flag = CityPage.CheckHealthAndSafetyVoilentCrime_AddYear_NewRow_Display();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_HealthAndSafetyVoilentCrime_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_HealthAndSafetyVoilentCrime_AddYear_AddNewLine method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Quality Of Life--> Health & Safety: Violent Crime (per year per capita) -
	// Verify by adding value to reading and clicking on save button for previous
	// year

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_HealthAndSafetyVoilentCrime_AddYear_AddNewLine", priority = 201, enabled = true, description = "Quality Of Life --> Health & Safety: Violent Crime (per year per capita) - >Verify by adding value to reading and clicking on save button for previous year ")
	public void City_HealthAndSafetyVoilentCrime_SavePreviousYearData() {

		log.info("City_HealthAndSafetyVoilentCrime_SavePreviousYearData method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004567";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonHealthAndSafetyVoilentCrime();
			flag = CityPage.CheckHealthAndSafetyVoilentCrime_SaveNewRecord();

			if (flag) {
				log.info("City_HealthAndSafetyVoilentCrime_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not added successfully");
				log.info("City_HealthAndSafetyVoilentCrime_SavePreviousYearData method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_HealthAndSafetyVoilentCrime_SavePreviousYearData method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Health & Safety: Violent Crime (per year per capita) -
	// >Verify 'previous year' and 'next year' button adds reading respectively.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 201, dependsOnMethods = "City_HealthAndSafetyVoilentCrime_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Health & Safety: Violent Crime (per year per capita)  - > Verify 'previous year' and 'next year' button adds reading respectively.")
	public void City_HealthAndSafetyVoilentCrime_AddRow_PreviousYear_NextYear() {

		log.info(
				"City_HealthAndSafetyVoilentCrime_AddRow_PreviousYear_NextYear method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004567";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonHealthAndSafetyVoilentCrime();
			flag = CityPage.HealthAndSafetyVoilentCrime_SavePreviousAndNextYearRecord();
			if (flag) {
				log.info("City_HealthAndSafetyVoilentCrime_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not added successfully");
				log.info("City_HealthAndSafetyVoilentCrime_AddRow_PreviousYear_NextYear method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_HealthAndSafetyVoilentCrime_AddRow_PreviousYear_NextYear method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Health & Safety: Violent Crime (per year per capita) -
	// Verify able to edit readings by using 'Edit' button.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 202, dependsOnMethods = "City_HealthAndSafetyVoilentCrime_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Health & Safety: Violent Crime (per year per capita)   - >Verify able to edit readings by using 'Edit' button.")

	public void City_HealthAndSafetyVoilentCrime_Edit_Test() {

		log.info("City_HealthAndSafetyVoilentCrime_Edit_Test method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004567";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonHealthAndSafetyVoilentCrime();
			flag = CityPage.CheckHealthAndSafetyVoilentCrime_EditRecord();

			if (flag) {
				log.info("Record is updated successfully");
				log.info("City_HealthAndSafetyVoilentCrime_Edit_Test method ends here ........... ");
				Assert.assertTrue(true);
				// }
			} else {
				log.info("Record is not updated successfully");
				log.info("City_HealthAndSafetyVoilentCrime_Edit_Test method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_HealthAndSafetyVoilentCrime_Edit_Test method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Health & Safety: Violent Crime (per year per capita) -
	// Verify able to delete line item by using delete button.
	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_HealthAndSafetyVoilentCrime_SavePreviousYearData", priority = 203, enabled = true, description = "Quality Of Life--> Health & Safety: Violent Crime (per year per capita) - Verify able to delete line item by using delete button.")
	public void City_HealthAndSafetyVoilentCrime_Delete_Row() {

		log.info("City_HealthAndSafetyVoilentCrime_Delete_Row method started......................... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000004567";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonHealthAndSafetyVoilentCrime();
			flag = CityPage.HealthAndSafetyVoilentCrime_DeleteRow();

			if (flag) {

				log.info("Record is deleted successfully");
				log.info("City_HealthAndSafetyVoilentCrime_Delete_Row method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Record is not deleted successfully");
				log.info("City_HealthAndSafetyVoilentCrime_Delete_Row method ends here ........... ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("City Project is showing Null");
			log.info("City_HealthAndSafetyVoilentCrime_Delete_Row method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Quality Of Life--> Health & Safety: Violent Crime (per year per capita) -
	// Verify filter button - From (Start date) and To (End date) uopens up decade
	// calendar and on selecting any year range, the line items falling into those
	// year should be displayed.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_HealthAndSafetyVoilentCrime_SavePreviousYearData", priority = 204, enabled = true, description = "Quality Of Life--> Health & Safety: Violent Crime (per year per capita) - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
	public void City_HealthAndSafetyVoilentCrime_FilterTest() {

		log.info("City_HealthAndSafetyVoilentCrime_FilterTest method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Perf4");
		// ProjectCityID="8000004568";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonHealthAndSafetyVoilentCrime();
			flag = CityPage.CheckHealthAndSafetyVoilentCrime_Filter();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}

		if (flag) {
			log.info("City_HealthAndSafetyVoilentCrime_FilterTest method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_HealthAndSafetyVoilentCrime_FilterTest method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// Quality Of Life--> Health & Safety: Violent Crime (per year per capita) -->
	// Verify 'Comments' section by adding comment should show correct timestamp.
	// Quality Of Life--> Health & Safety: Violent Crime (per year per capita)
	// -->'Activity' section should show correct activity with date and
	// timestamp.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 204, enabled = false, description = "Quality Of Life--> Health & Safety: Violent Crime (per year per capita)  -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
	public void City_HealthAndSafetyVoilentCrime_Comments_Activity_Test() {

		log.info("City_HealthAndSafetyVoilentCrime_Comments_Activity_Test method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000004568";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			String ProfileUserName = HomePage.getCurrentProfileUserName();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonHealthAndSafetyVoilentCrime();
			flag = CityPage.checkHealthAndSafetyVoilentCrime(data.getCellData("City", 33, 2), ProfileUserName);

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_HealthAndSafetyVoilentCrime_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_HealthAndSafetyVoilentCrime_Comments_Activity_Test method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// --> Verify Qualty Of Life Score after entering previous year data

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 205, enabled = true, description = "Quality Of Life -->Verify Qualty Of Life Score after entering previous year data")
	public void City_Check_QualityOfLife_Score() {

		log.info("City_Check_QualityOfLife_Score method started......................... ");
		int QualityScore = 0;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000006833";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();

			QualityScore = CityPage.getQualityOfLifeScore();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (QualityScore > 0) {
			log.info("City_Check_QualityOfLife_Score method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Check_QualityOfLife_Score method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// --> Validate each row item of dropdown additional data- by selecting one item
	// from the dropdown and and adding the field value with unit field.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 206, enabled = false, description = "Quality Of Life -->Additional Data --> Validate each row item of dropdown additional data- by selecting one item from the dropdown and and adding the field value with unit field.")
	public void City_AdditionalData_SaveRecords() {

		log.info("City_AdditionalData_SaveRecords method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Private3");
		// ProjectCityID="8000012008";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonDataInput();
			CommonMethod.switchToDataInputFrame();
			CityPage.ClickonAdditionalData();
			flag = CityPage.checkAdditionalData_SaveRecords();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_AdditionalData_SaveRecords method ends here ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_AdditionalData_SaveRecords method ends here ........... ");
			Assert.assertTrue(false);
		}
	}

	// --------------------------------------------Manage Section Test
	// Cases---------------------

	// --> Verify under Manage--Project-- Project Details, Year founded is a
	// dropdown field with year values ranging from 1900 to current year.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 251, enabled = true, description = " Verify under Manage--Project-- Project Details, Year founded is a dropdown field with year values ranging from 1900 to current year. ")
	public void City_ManageProject_CheckYearRange() {

		log.info("City_ManageProject_CheckYearRange method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		//System.setProperty("CityProject5","8000012010");
		String ProjectCityID = System.getProperty("CityProject5");
		// ProjectCityID="1000102092";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonProjectInManage();
			flag = CityPage.ManageProject_CheckYearRange();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_ManageProject_CheckYearRange method ends here with true ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_ManageProject_CheckYearRange method ends here with false........... ");
			Assert.assertTrue(false);
		}
	}

	// --> Verify Managing entity name, address(line 1), address(line 2), entity
	// city are text field and able to add any value in it.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 252, enabled = true, description = " Verify Managing entity name, address(line 1), address(line 2), entity city are text field and able to add any value in it. ")
	public void City_ManageProject_CheckEntityFields() {

		log.info("City_ManageProject_CheckEntityFields method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject5");
		// ProjectCityID="8000039417";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonProjectInManage();
			flag = CityPage.ManageProject_CheckEntityFields();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_ManageProject_CheckEntityFields method ends here with true ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_ManageProject_CheckEntityFields method ends here with false........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify Managing entity Country/region is drop down field and able to select
	// any country value from it.
	// Verify Managing entity State field is drop down field and the values change
	// as per the country selected in the country field.
	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 253, enabled = true, description = "Verify Managing entity Country/region  is drop down field and able to select any country value from it.\r\n"
			+ "				Verify Managing entity State field  is drop down field and the values change as per the country selected in the country field.")
	public void City_ManageProject_SelectCountryAndState() {

		log.info("City_ManageProject_SelectCountryAndState method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject5");
		// ProjectCityID="8000040234";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonProjectInManage();
			flag = CityPage.ManageProject_SelectCountryAndState();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_ManageProject_SelectCountryAndState method ends here with true ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_ManageProject_SelectCountryAndState method ends here with false........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify Private is a radio button with options Yes And No. Able to select any
	// value from it.
	// Verify 'Intend to precertify?' field has radio button with options- Yes and
	// No.Able to select any value from it.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 254, enabled = true, description = "Verify Private is a radio button with options Yes And No. Able to select any value from it.\r\n"
			+ "	 Verify 'Intend to precertify?' field has radio button with options- Yes and No.Able to select any value from it.")
	public void City_ManageProject_PrivateRadioButton_IntendToPrecertify() {

		log.info("City_ManageProject_PrivateRadioButton_IntendToPrecertify method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject5");
		// ProjectCityID="8000039417";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonProjectInManage();
			flag = CityPage.ManageProject_PrivateRadioButton_IntendToPrecertify();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info(
					"City_ManageProject_PrivateRadioButton_IntendToPrecertify method ends here with true ........... ");
			Assert.assertTrue(true);

		} else {
			log.info(
					"City_ManageProject_PrivateRadioButton_IntendToPrecertify method ends here with false........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify Target certification date opens up a Calendar and able to seelct any
	// date from the calendar.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 255, enabled = true, description = "Verify Target certification date opens up a Calendar and able to seelct any date from the calendar.")
	public void City_ManageProject_TargetCertificationDate() {

		log.info("City_ManageProject_TargetCertificationDate method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject5");
		// ProjectCityID="8000040326";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonProjectInManage();
			flag = CityPage.ManageProject_TargetCertificationDate();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_ManageProject_TargetCertificationDate method ends here with true ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_ManageProject_TargetCertificationDate method ends here with false........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify ARC Administrator will be created by default when a project is created
	// Verify that project should have minimum one ARC adminsitrator.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 256, enabled = true, description = "Verify ARC Administrator will be created by default when a project is created. \r\n"
			+ "	// Verify that project should have minimum one ARC adminsitrator.")
	public void City_ManageTeam_CheckDefaultARCAdministrator() {

		log.info("City_ManageTeam_CheckDefaultARCAdministrator method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject5");
		// ProjectCityID="8000039597";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonTeamInManage();
			flag = CityPage.ManageTeam_CheckDefaultARCAdministrator();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_ManageTeam_CheckDefaultARCAdministrator method ends here with true ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_ManageTeam_CheckDefaultARCAdministrator method ends here with false........... ");
			Assert.assertTrue(false);
		}
	}

	// verify under Manage-teams- 'Invite team members' able to add team member
	// successfully.
	// Verify team member can be added who is a registered USGBC.org user. Verify
	// authorization level should be by default as 'Team Member' if added any new
	// team member

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 257, enabled = true, description = "verify under Manage-teams- 'Invite team members' able to add team member successfully.\r\n"
			+ "		// Verify team member can be added who is a registered USGBC.org user. Verify authorization level should be by default as 'Team Member' if added any new team member")
	public void City_ManageTeam_CheckAddNewTeamMember() {

		log.info("City_ManageTeam_CheckAddNewTeamMember method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject5");
		// ProjectCityID="8000040234";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonTeamInManage();
			flag = CityPage.ManageTeam_CheckAddNewTeamMember();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_ManageTeam_CheckAddNewTeamMember method ends here with true ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_ManageTeam_CheckAddNewTeamMember method ends here with false........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify if the team member added is unregistered user, throws error message in
	// red "a@aa.com is not a registered USGBC.org user, please have the user
	// register at https://new.usgbc.org/registration/create-user and try again."

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 258, enabled = true, description = "Verify if the team member added is unregistered user, throws error message in red  \"a@aa.com is not a registered USGBC.org user, please have the user register at https://new.usgbc.org/registration/create-user and try again.")
	public void City_ManageTeam_CheckAddUnregisteredTeamMember() {

		log.info("City_ManageTeam_CheckAddUnregisteredTeamMember method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject5");
		// ProjectCityID="8000040234";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonTeamInManage();
			flag = CityPage.ManageTeam_CheckAddUnregisteredTeamMember();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_ManageTeam_CheckAddUnregisteredTeamMember method ends here with true ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_ManageTeam_CheckAddUnregisteredTeamMember method ends here with false........... ");
			Assert.assertTrue(false);
		}
	}

	// Adding the same team role for a member again, should give a validation
	// message like 'ashree511@gmail.com already has the same team role'

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_ManageTeam_CheckAddNewTeamMember", priority = 259, enabled = true, description = "Adding the same team role for a member again, should give a validation message like 'ashree511@gmail.com already has the same team role'")
	public void City_ManageTeam_AddExistingTeamMember() {

		log.info("City_ManageTeam_AddExistingTeamMember method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject5");
		// ProjectCityID="8000040234";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonTeamInManage();
			flag = CityPage.ManageTeam_AddExistingTeamMember();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_ManageTeam_AddExistingTeamMember method ends here with true ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_ManageTeam_AddExistingTeamMember method ends here with false........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify existing ARC administrator can't be edited until another ARC
	// adminstrator is present. If edited, error message will display as 'Project
	// should have atleast one ARC Administrator'.

	// Project can also have more than one ARC administrator.
	// Verify a user with role 'Team member' doesnt have the edit/add/remove access
	// to the team section.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 260, enabled = true, description = "Verify existing ARC administrator can't be edited until another ARC adminstrator is present. If edited, error message will display as 'Project should have atleast one ARC Administrator'.\r\n"
			+ "	//  Project can also have more than one ARC administrator. \r\n"
			+ "	//Verify a user with role 'Team member' doesnt have the edit/add/remove access to the team section.")
	public void City_ManageTeam_EditARCAdministratorRole() {

		log.info("City_ManageTeam_EditARCAdministratorRole method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject5");
		// ProjectCityID="8000040230";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonTeamInManage();
			flag = CityPage.ManageTeam_EditARCAdministratorRole();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_ManageTeam_EditARCAdministratorRole method ends here with true ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_ManageTeam_EditARCAdministratorRole method ends here with false........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify able to add/update team member.
	// Verify authorization level Member, etc can be changed and vice-versa.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 261, enabled = true, description = "Verify able to add/update team member.\r\n"
			+ "	//Verify authorization level Member, etc can be changed and vice-versa.")
	public void City_ManageTeam_TeamAddEditMember() {

		log.info("City_ManageTeam_TeamAddEditMember method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		String ProjectCityID = System.getProperty("CityProject_Perf4");
		// ProjectCityID="8000039597";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonTeamInManage();
			flag = CityPage.ManageTeam_TeamAddEditMember();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_ManageTeam_TeamAddEditMember method ends here with true ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_ManageTeam_TeamAddEditMember method ends here with false........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify able to remove team member
	// Verify a user should not have access to a project, if that team member is
	// removed.

	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 262, enabled = true, description = "Verify able to remove team member\r\n"
			+ "		//Verify a user should not have access to a project, if that team member is removed.")
	public void City_ManageTeam_TeamAddRemoveMember() {

		log.info("City_ManageTeam_TeamAddRemoveMember method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("CityProject_Perf4","8000040272");
		String ProjectCityID = System.getProperty("CityProject_NonLeed2");
		// ProjectCityID="8000040272";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonTeamInManage();
			flag = CityPage.ManageTeam_TeamAddRemoveMember();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_ManageTeam_TeamAddRemoveMember method ends here with true ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_ManageTeam_TeamAddRemoveMember method ends here with false........... ");
			Assert.assertTrue(false);
		}
	}

	/*
	 * Verify Manage-Teams- Right hand side 'How team roles work?' tooltip opens a
	 * modal window with team roles definition as below:
	 * 
	 * Arc Administrator: The Arc Administrator has complete access to the project
	 * including data entry, submitting for review, and is granted rights to add
	 * additional team members. The Arc Administrator will also be the point of
	 * contact for automatic notifications, billing information, and review reports.
	 * 
	 * Note: While multiple “Arc Administrators” can exist on a project team, we
	 * strongly recommend that you designate only one person in this role to avoid
	 * confusion and so that a single point of contact is receiving notifications
	 * about billing and certification.
	 * 
	 * Team Manager: A Team Manager has access to the project including data entry
	 * and submitting for review, and can make changes to the project team.
	 * 
	 * Team Member: A Team Member has access to the project including data entry and
	 * submitting for review, but cannot make any changes to the project team.
	 * 
	 * Project Administrator: A Project Administrator is the original LEED Project
	 * Administrator and will only appear on the project team for LEED projects that
	 * were previously or are currently using LEED Online. The Project Administrator
	 * has the same rights as the Arc Administrator.
	 * 
	 * Read Only: Read Only members can access the project to view data but cannot
	 * make any changes to the project, data entry or the project team.
	 * 
	 * 
	 * 
	 */
	@Test(groups = "CityRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 263, enabled = true, description = "Verify Tooltip Text of How Team role works.")
	public void City_ManageTeam_HowTeamRolesWorkTooltip() {

		log.info("City_ManageTeam_HowTeamRolesWorkTooltip method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("CityProject_Perf4","8000040272");
		String ProjectCityID = System.getProperty("CityProject_Perf4");
		// ProjectCityID="8000040272";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonTeamInManage();
			flag = CityPage.ManageTeam_HowTeamRolesWorkTooltip();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_ManageTeam_HowTeamRolesWorkTooltip method ends here with true ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_ManageTeam_HowTeamRolesWorkTooltip method ends here with false........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify 'Agreements' tab contains 'Registration' Agreement with date Signed as
	// the date of registration.
	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"CityRegression" }, enabled = true, priority = 264, description = "Verify 'Agreements' tab contains 'Registration' Agreement with date Signed as the date of registration.")
	public void City_Agreement_CheckAgreement() {
		log.info("City_Agreement_CheckAgreement method started......................... ");
		boolean flag = false;

		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("CityProject_Perf4","8000040272");
		String ProjectCityID = System.getProperty("CityProject5");
		// ProjectCityID="8000040272";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonAgreementInManage();
			flag = CityPage.Manage_Agreement_CheckAgreement();

		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_Agreement_CheckAgreement method ends here with true ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Agreement_CheckAgreement method ends here with false........... ");
			Assert.assertTrue(false);
		}
	}

	// Verify agreement is downloaded successfully.

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"CityRegression" }, enabled = true, priority = 267, description = "Verify able to download the agreement successfully.")
	public void City_Agreement_CheckDownloadAgreement() {
		log.info("City_Agreement_CheckDownloadAgreement method started ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// System.setProperty("CityProject_Perf4","8000040272");
		String ProjectCityID = System.getProperty("CityProject5");
		// ProjectCityID="8000040272";
		if (!ProjectCityID.equals(null)) {
			String username = HomePage.getCurrentProfileUserName();
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonAgreementInManage();
			CommonMethod.ClikOnAgreementRegistrationDownloadLink();
			flag = CityPage.CheckAgreementDownloadedFile(username);
		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_Agreement_CheckDownloadAgreement method ends here with true ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Agreement_CheckDownloadAgreement method ends here with false........... ");
			Assert.assertTrue(false);
		}
	}

// Verify links redirect to correct pages: Data guide for buildings -"https://www.usgbc.org/resources/data-management-buildings" and Data review checklst (pdf)downloads the data review checklist file.

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"CityRegression" }, enabled = true, priority = 268, description = "Verify links redirect to correct pages: Data guide for buildings -\"https://www.usgbc.org/resources/data-management-buildings\" and Data review checklst (pdf)downloads the data review checklist file.")
	public void City_Settings_DataResourceLinks() {
		log.info("City_Settings_DataResourceLinks method started ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		 //System.setProperty("CityProject_Perf4","8000040326");
		String ProjectCityID = System.getProperty("CityProject_Perf4");
		// ProjectCityID="8000040272";
		if (!ProjectCityID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonSettingsInManage();
			flag = CityPage.CheckSettings_DataResourceLink();
		} else {
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if (flag) {
			log.info("City_Settings_DataResourceLinks method ends here with true ........... ");
			Assert.assertTrue(true);

		} else {
			log.info("City_Settings_DataResourceLinks method ends here with false........... ");
			Assert.assertTrue(false);
		}
	}
	
	// Verify able to turn the toggle button 'on' and 'off' for "Show the score animation on the Arc app"

		@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
				"CityRegression" }, enabled = false, priority = 269, description = "Verify able to turn the toggle button 'on' and 'off' for \"Show the score animation on the Arc app\"")
		public void City_Settings_ScoreAnimationToggleButton() {
			log.info("City_Settings_ScoreAnimationToggleButton method started ");
			boolean flag = false;
			try {
				HomePage.setHomePageApplication();
			} catch (Exception e) {
				HomePage.setHomePageApplication();
				e.printStackTrace();
			}
			 //System.setProperty("CityProject_Perf4","8000040326");
			String ProjectCityID = System.getProperty("CityProject_Perf4");
			// ProjectCityID="8000040272";
			if (!ProjectCityID.equals(null)) {
				ProjectPage = HomePage.clickOnProject();
				CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
				HomePage.closeProjectSearchTextBox();
				CityPage.ClickonSettingsInManage();
				flag = CityPage.Settings_ScoreAnimationToggleButton();
			} else {
				log.info("City Project is showing Null");
				Assert.assertTrue(false);
			}
			if (flag) {
				log.info("City_Settings_ScoreAnimationToggleButton method ends here with true ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("City_Settings_ScoreAnimationToggleButton method ends here with false........... ");
				Assert.assertTrue(false);
			}
		}	
	// Verify the Score version for cities shows version 2.0 as of date-Jan-10-2022. 

		@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
				"CityRegression" }, enabled = true, priority = 270, description = "Verify the Score version for cities shows version 2.0 as of date-Jan-10-2022. ")
		public void City_ScoreVersion() {
			log.info("City_ScoreVersion method started ");
			boolean flag = false;
			try {
				HomePage.setHomePageApplication();
			} catch (Exception e) {
				HomePage.setHomePageApplication();
				e.printStackTrace();
			}
			 //System.setProperty("CityProject_Perf4","8000040326");
			String ProjectCityID = System.getProperty("CityProject_Perf4");
			// ProjectCityID="8000040272";
			if (!ProjectCityID.equals(null)) {
				ProjectPage = HomePage.clickOnProject();
				CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
				HomePage.closeProjectSearchTextBox();
				CityPage.ClickonScoreVersionInManage();
				flag = CityPage.CheckScoreVersion();
			} else {
				log.info("City Project is showing Null");
				Assert.assertTrue(false);
			}
			if (flag) {
				log.info("City_ScoreVersion method ends here with true ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("City_ScoreVersion method ends here with false........... ");
				Assert.assertTrue(false);
			}
		}
}
