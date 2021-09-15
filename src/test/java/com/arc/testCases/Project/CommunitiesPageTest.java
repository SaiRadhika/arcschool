package com.arc.testCases.Project;

import java.io.File;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.arc.PageObject.Project.CommunitiesPageObject;
import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class CommunitiesPageTest extends BaseClass{

	private static Logger log = LoggerHelper.getLogger(CommunitiesPageTest.class);

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups={"Reboot"}, enabled = true, priority = 30, description = "Verify Manage-->Agreements should show the project agreement.")
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

	@Test(dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Agreement_Display", groups={"Reboot"}, enabled = true, priority = 31, description = "Verify able to download the agreement successfully.")
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
			CommonMethod.DeleteAllFiles();
			DownloadFolder.delete();
			log.info("Communities_Agreement_Download method completed ");
			Assert.assertTrue(FileLength > 0);
		} else {
			log.info("Communities_Agreement_Download method completed ");
			Assert.assertTrue(false);
		}

	}
	
	@Test(dependsOnGroups = "LoginMethodTCGroup",groups={"Reboot"}, enabled = true, priority = 32, description = "Verify if leed id project, able to download the registration invoice and receipt successfully from Manage-->Billing tab.")
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
	
	// Verify Manage-->Teams should show team members added to the project.

		@Test(dependsOnGroups = "LoginMethodTCGroup", groups = { "Reboot" }, enabled = true, priority = 33, description = "Verify able to add a team-member successfully.")
		public void Community_Team_Add_Member() {

			log.info("Community_Team_Add_Member method started ");
			HomePage.setHomePageApplication();
			ProjectPage = HomePage.clickOnProject();
			System.out.println(data.getCellData("Reboot", 10, 2));
			CommunitiesPage=ProjectPage.SearchAndClickOnCommunitiesProject(data.getCellData("Reboot", 10, 2));
			CommunitiesPage.ClickonTeamInManage();
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
					log.info("Community_Team_Add_Member method completed .......................");
					Assert.assertTrue(true);
				}
				else
				{
					log.info(username+ "  does not exist in the team member");
					log.info("Community_Team_Add_Member method completed .......................");
					Assert.assertTrue(false);
				}
			}
			else
			{
				log.info(username+"  is not added successfully");
				log.info("Community_Team_Add_Member method completed .......................");
				Assert.assertTrue(false);
			}
			

		}

		// Verify Manage-->It should allow to delete member from the added list

		@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
				"Reboot" }, dependsOnMethods = "Community_Team_Add_Member", enabled = true, priority = 34, description = "Verify able to remove a team-member successfully.")
		public void Community_Team_Delete_Member() {

			log.info("Community_Team_Delete_Member method started .......................");
			HomePage.setHomePageApplication();
			ProjectPage = HomePage.clickOnProject();
			System.out.println(data.getCellData("Reboot", 10, 2));
			CommunitiesPage=ProjectPage.SearchAndClickOnCommunitiesProject(data.getCellData("Reboot", 10, 2));
			CommunitiesPage.ClickonTeamInManage();
			HomePage.closeProjectSearchTextBox();
			System.out.println();
			String username = data.getCellData("Reboot", 15, 2);
				boolean flag = CommonMethod.Team_Delete_Member(username);
				if (flag) {
					boolean emailexist = CommonMethod.Team_checkEmailExistOrNot(username);
					if(!emailexist)
					{
						log.info(username+"  does not exist as team member");
						log.info("Community_Team_Delete_Member method completed.......................");
						Assert.assertTrue(true);
					}
					else
					{
						log.info(username+" still exist as team member");
						log.info("Community_Team_Delete_Member method completed.......................");
						Assert.assertTrue(false);
					}
				} 
				else {
					log.info(username+" is not deleted successfully .......................");
					Assert.assertTrue(false);
				
			}

		}
		
//*******************************Regression Test Case*************************************
		// Verify in DI, Project settings - population tab- Add row button adds a new
		// line item with fields- 'Effective year', Population, Updated by followed by
		// Save and delete button

		@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 250, enabled = true, description = "Verify in DI, Project settings - population tab- Add row button adds a new line item with fields- 'Effective year', Population, Updated by followed by Save and delete button ")
		public void Communities_DI_ProjectSetting_Population_Add_Row() {

			log.info("Communities_DI_ProjectSetting_Population_Add_Row method started......................... ");
			//CommonMethod.switchToDefaultContent();
			//CommunitiesPage = new CommunitiesPageObject();
			boolean flag = false;
			try {
				HomePage.setHomePageApplication();

			} catch (Exception e) {
				HomePage.setHomePageApplication();
				e.printStackTrace();
			}

			String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
			// ProjectCommunitiesID="8000004394";
			if (!ProjectCommunitiesID.equals(null)) {
				ProjectPage = HomePage.clickOnProject();
				CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
				CommunitiesPage.ClickonDataInput();
				HomePage.closeProjectSearchTextBox();
				CommonMethod.switchToDataInputFrame();
				CommunitiesPage.ClickonProjectSetting();
				flag = CommunitiesPage.checkPopulation_AddRow_Header_Display();

			} else {
				log.info("Communities Project is showing Null");
				Assert.assertTrue(false);
			}
			if (flag) {
				Assert.assertTrue(true);
				log.info("Communities_DI_ProjectSetting_Population_Add_Row method ends here ........... ");
			} else {
				log.info("Communities_DI_ProjectSetting_Population_Add_Row method ends here ........... ");
				Assert.assertTrue(false);

			}
		}

		// Verify in DI, Project settings - population tab- Save One row button
		// Verify Effective year opens up decade calendar and gives the option to select
		// any year.

		@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 250, dependsOnMethods = "Communities_DI_ProjectSetting_Population_Add_Row", enabled = true, description = "Project Setting -> Population \r\n Verify in DI, Project settings - population tab- Save One row button \r\n"
				+ "		Verify Effective year opens up decade calendar and gives the option to select any year.")
		public void Communities_ProjectSetting_Population_Save_Row_DecadeCalender_Display() {

			log.info(
					"Communities_ProjectSetting_Population_Save_Row_DecadeCalender_Display method started......................... ");
			//CommonMethod.switchToDefaultContent();
			//CommunitiesPage = new CommunitiesPageObject();
			boolean RowAddflag = false;
			boolean DecadeCalenderflag = false;
			try {
				HomePage.setHomePageApplication();

			} catch (Exception e) {
				HomePage.setHomePageApplication();
				e.printStackTrace();
			}

			String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
			// ProjectCommunitiesID="8000004341";
			if (!ProjectCommunitiesID.equals(null)) {
				ProjectPage = HomePage.clickOnProject();
				// CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
				CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
				CommunitiesPage.ClickonDataInput();
				HomePage.closeProjectSearchTextBox();
				CommonMethod.switchToDataInputFrame();
				CommunitiesPage.ClickonProjectSetting();
				DecadeCalenderflag = CommunitiesPage.checkPopulation_Save_New_Row("1000");
				if (DecadeCalenderflag) {
					log.info("Decade Calender for Effective Year is showing proper..........");
				} else {
					log.info("Decade Calender for Effective Year is not showing proper..........");
				}
				HomePage.setHomePageApplication();
				CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
				CommunitiesPage.ClickonDataInput();
				HomePage.closeProjectSearchTextBox();
				CommonMethod.switchToDataInputFrame();
				CommunitiesPage.ClickonProjectSetting();
				RowAddflag = CommunitiesPage.verifyAddedProject_Setting_PopulationRow();
			} else {
				log.info("Communities Project is showing Null");
				Assert.assertTrue(false);
			}
			if ((RowAddflag) && (DecadeCalenderflag)) {
				log.info("Communities_ProjectSetting_Population_Save_Row_DecadeCalender_Display method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Communities_ProjectSetting_Population_Save_Row_DecadeCalender_Display method ends here ........... ");
				Assert.assertTrue(false);
			}
		}

		// Population--- Verify Updated by shows the correct team-member/admin name.{To
		// check this, add any team-member in teams section and login using that team
		// member and add line item to this tab and check if his name s updated in
		// 'Updated by column }

		@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup",dependsOnMethods = "Communities_ProjectSetting_Population_Save_Row_DecadeCalender_Display", priority = 250, enabled = false, description = "Project Setting -> population \r\n Verify Updated by shows the correct team-member/admin name.{To check this, add any team-member in teams section and login using that team member and add line item to this tab and chek if his name s updated in 'Updated by column ")
		public void Communities_ProjectSetting_Population_UpdatedBy_Test() {

			log.info("Communities_ProjectSetting_Population_UpdatedBy_Test method started......................... ");
			//CommonMethod.switchToDefaultContent();

			HomePage.setHomePageApplication();
			ProjectPage = HomePage.clickOnProject();
			String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
			//ProjectCommunitiesID="8000006647";
			 if (!ProjectCommunitiesID.equals(null)) {
				 CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
				 CommunitiesPage.ClickonTeamInManage();
					HomePage.closeProjectSearchTextBox();
					String username = data.getCellData("Communities", 0, 2);
					boolean emailexist = CommonMethod.Team_checkEmailExistOrNot(username);
					System.out.println(username + "-----------existence is----" + emailexist);
					boolean flag = false;
					flag = CommonMethod.Team_Add_Member(username);
					if(flag)
					{
						log.info("Team Member added-----------------");
						HomePage.checkSignOut();
						HomePage = LoginPage.loginLater(data.getCellData("Communities", 0, 2), data.getCellData("Communities", 1, 2));
						//CommunitiesPage = new CommunitiesPageObject();
						boolean Updatedflag = false;

						try {
							HomePage.setHomePageApplication();

						} catch (Exception e) {
							HomePage.setHomePageApplication();
							e.printStackTrace();
						}
						
						ProjectPage = HomePage.clickOnProject();
						CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						CommunitiesPage.ClickonDataInput();
						HomePage.closeProjectSearchTextBox();
						CommonMethod.switchToDataInputFrame();
						CommunitiesPage.ClickonProjectSetting();
						
						boolean RecordAdded=CommunitiesPage.checkPopulation_Save_New_Row("1400");
						if(RecordAdded)
						{
							log.info("RecordAdded flag is true  --------------");
							CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
							CommunitiesPage.ClickonDataInput();
							HomePage.closeProjectSearchTextBox();
							CommonMethod.switchToDataInputFrame();
							CommunitiesPage.ClickonProjectSetting();
							Updatedflag = CommunitiesPage.checkPopulationUpdatedByUserName(HomePage.getCurrentProfileUserName());
							CommonMethod.switchToDefaultContent();
							HomePage.checkSignOut();
							HomePage = LoginPage.loginLater(prop.getProperty("email"), prop.getProperty("password"));
							if (Updatedflag) {
								log.info("Communities_ProjectSetting_Population_UpdatedBy_Test method ends with true here ........... ");
								Assert.assertTrue(true);

							} else {
								log.info("Communities_ProjectSetting_Population_UpdatedBy_Test method ends ends with false here ........... ");
								Assert.assertTrue(false);
							}
						}
						else
						{
							log.info("RecordAdded flag is false, Unable to add the record--------------");
							CommonMethod.switchToDefaultContent();
							HomePage.checkSignOut();
							HomePage = LoginPage.loginLater(prop.getProperty("email"), prop.getProperty("password"));
							log.info("Communities_ProjectSetting_Population_UpdatedBy_Test method ends ends with false here ........... ");
							Assert.assertTrue(false);
						}
						

					}
					else {
							log.info("Unable to add the team member.-----------------");
							log.info("Communities_ProjectSetting_Population_UpdatedBy_Test method ends with false here ........... ");
							Assert.assertTrue(false);
						}
				 
			 }
			 
			 else {
					log.info("Communities Project is showing Null");
					log.info("Communities_ProjectSetting_Population_UpdatedBy_Test method ends with false here ........... ");
					Assert.assertTrue(false);
				}
			
		}

		// Project Setting --> Population --> Verify 'Comments' section by adding
		// comment should show correct timestamp.
		// Project Setting --> Population -->Verify 'Activity' section should show
		// correct activity with date and
		// timestamp.

		@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 251, enabled = true, description = "Project Setting --> Population -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
		public void Communities_ProjectSetting_Population_Comments_Activity_Test() {

			log.info("Communities_ProjectSetting_Population_Comments_Activity_Test method started......................... ");
			//CommonMethod.switchToDefaultContent();
			//CommunitiesPage = new CommunitiesPageObject();
			boolean flag = false;

			try {
				HomePage.setHomePageApplication();

			} catch (Exception e) {
				HomePage.setHomePageApplication();
				e.printStackTrace();
			}

			String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
			// ProjectCommunitiesID="8000004489";
			if (!ProjectCommunitiesID.equals(null)) {
				ProjectPage = HomePage.clickOnProject();
				String ProfileUserName = HomePage.getCurrentProfileUserName();
				CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
				HomePage.closeProjectSearchTextBox();				
				CommunitiesPage.ClickonDataInput();				
				CommonMethod.switchToDataInputFrame();
				CommunitiesPage.ClickonProjectSetting();

				flag = CommunitiesPage.checkPopulationCommentAndActivity(data.getCellData("Communities", 2, 2), ProfileUserName);

			} else {
				log.info("Communities Project is showing Null");
				Assert.assertTrue(false);
			}
			if (flag) {
				log.info("Communities_ProjectSetting_Population_Comments_Activity_Test method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Communities_ProjectSetting_Population_Comments_Activity_Test method ends here ........... ");
				Assert.assertTrue(false);
			}
		}

		// Verify population field allows to add values followed by commas.

		@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_ProjectSetting_Population_Save_Row_DecadeCalender_Display", priority = 252, enabled = true, description = "Verify population field allows to add values followed by commas.")
		public void Communities_Population_Field_Comma_Display() {

			log.info("Communities_Population_Field_Comma_Display method started......................... ");
			//CommonMethod.switchToDefaultContent();
			//CommunitiesPage = new CommunitiesPageObject();
			boolean flag = false;
			boolean Commaflag = false;
			try {
				HomePage.setHomePageApplication();

			} catch (Exception e) {
				HomePage.setHomePageApplication();
				e.printStackTrace();
			}

			String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
			// ProjectCommunitiesID="8000004341";
			if (!ProjectCommunitiesID.equals(null)) {
				ProjectPage = HomePage.clickOnProject();
				CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
				HomePage.closeProjectSearchTextBox();				
				CommunitiesPage.ClickonDataInput();
				CommonMethod.switchToDataInputFrame();
				CommunitiesPage.ClickonProjectSetting();
				flag = CommunitiesPage.verifyAddedProject_Setting_PopulationRow();
			} else {
				log.info("Communities Project is showing Null");
				Assert.assertTrue(false);
			}
			if (flag) {
				Commaflag = CommunitiesPage.verifyPopulationField_Contains_Comma();
				if (Commaflag) {
					log.info("Population field contains Comma");
					log.info("Communities_Population_Field_Comma_Display method ends here ........... ");
					Assert.assertTrue(true);
				} else {
					log.info("Population field does not contains Comma");
					log.info("Communities_Population_Field_Comma_Display method ends here ........... ");
					Assert.assertTrue(false);
				}

			} else {
				log.info("Row is not added for this project, unable to check population field");
				log.info("Communities_Population_Field_Comma_Display method ends here ........... ");
				Assert.assertTrue(false);
			}
		}
		


		// Project Setting - > Population - > Verify filter button - From (Start date)
		// and To (End date) uopens up decade calendar and on selecting any year range,
		// the line items falling into those year should be displayed.

		@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
				"Communities_ProjectSetting_Population_Save_Row_DecadeCalender_Display" }, priority = 253, enabled = true, description = "Project Setting - > Population - >Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed. ")
		public void Communities_Population_Filter_Test() {

			log.info("Communities_Population_Filter_Test method started......................... ");
			//CommonMethod.switchToDefaultContent();
			//CommunitiesPage = new CommunitiesPageObject();
			boolean flag = false;
			boolean Commaflag = false;
			try {
				HomePage.setHomePageApplication();

			} catch (Exception e) {
				HomePage.setHomePageApplication();
				e.printStackTrace();
			}

			String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Perf4");
			// ProjectCommunitiesID="8000004498";
			if (!ProjectCommunitiesID.equals(null)) {
				ProjectPage = HomePage.clickOnProject();
				CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
				HomePage.closeProjectSearchTextBox();				
				CommunitiesPage.ClickonDataInput();
				CommonMethod.switchToDataInputFrame();
				CommunitiesPage.ClickonProjectSetting();
				flag = CommunitiesPage.CheckPopulationFilter();
			} else {
				log.info("Communities Project is showing Null");
				Assert.assertTrue(false);
			}
			if (flag) {

				// log.info("Population field contains Comma");
				log.info("Communities_Population_Filter_Test method ends here ........... ");
				Assert.assertTrue(true);
			} else {
				// log.info("Population field does not contains Comma");
				log.info("Communities_Population_Filter_Test method ends here ........... ");
				Assert.assertTrue(false);
			}

		}

		// Verify in DI, Project settings - ProjectArea tab- Add row button adds a new
		// line item with fields- 'Effective year', Population, Updated by followed by
		// Save and delete button

		@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 254, enabled = true, description = "Verify in DI, Project settings - ProjectArea tab- Add row button adds a new line item with fields- 'Effective year', Population, Updated by followed by Save and delete button ")
		public void Communities_ProjectSetting_ProjectArea_Add_Row() {

			log.info("Communities_ProjectSetting_ProjectArea_Add_Row method started......................... ");
			//CommonMethod.switchToDefaultContent();
			//CommunitiesPage = new CommunitiesPageObject();
			boolean flag = false;
			try {
				HomePage.setHomePageApplication();

			} catch (Exception e) {
				HomePage.setHomePageApplication();
				e.printStackTrace();
			}

			String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
			// ProjectCommunitiesID="8000004332";
			if (!ProjectCommunitiesID.equals(null)) {
				ProjectPage = HomePage.clickOnProject();
				CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
				HomePage.closeProjectSearchTextBox();				
				CommunitiesPage.ClickonDataInput();
				CommonMethod.switchToDataInputFrame();
				CommunitiesPage.ClickonProjectSetting();
				flag = CommunitiesPage.checkProjectArea_AddRow_Header_Display();
			} else {
				log.info("Communities Project is showing Null");
				Assert.assertTrue(false);
			}
			if (flag) {
				Assert.assertTrue(true);
				log.info("Communities_ProjectSetting_ProjectArea_Add_Row method ends here ........... ");
			} else {
				log.info("Communities_ProjectSetting_ProjectArea_Add_Row method ends here ........... ");
				Assert.assertTrue(false);

			}
		}

		// Verify in DI, Project settings - Project Area tab- Add One row and save
		// Verify Effective year opens up decade calendar and gives the option to select
		// any year.
		@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 254, enabled = true, description = "Verify in DI, Project settings - Project Area tab- Add One row and save ,  \r\n"
				+ "			 ,  Verify Effective year opens up decade calendar and gives the option to select any year.")
		public void Communities_ProjectSetting_ProjectArea_Save_Row_DecadeCalender_Display() {

			log.info(
					"Communities_ProjectSetting_ProjectArea_Save_Row_DecadeCalender_Display method started......................... ");
			//CommonMethod.switchToDefaultContent();
			//CommunitiesPage = new CommunitiesPageObject();
			boolean DecadeCalenderflag = false;
			boolean RowAddflag = false;
			try {
				HomePage.setHomePageApplication();

			} catch (Exception e) {
				HomePage.setHomePageApplication();
				e.printStackTrace();
			}

			String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
			// ProjectCommunitiesID="8000004554";
			if (!ProjectCommunitiesID.equals(null)) {
				ProjectPage = HomePage.clickOnProject();
				CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
				HomePage.closeProjectSearchTextBox();				
				CommunitiesPage.ClickonDataInput();
				CommonMethod.switchToDataInputFrame();
				CommunitiesPage.ClickonProjectSetting();
				DecadeCalenderflag = CommunitiesPage.checkProjectArea_Save_New_Row("10000");
				if (DecadeCalenderflag) {
					log.info("Decade Calender for Effective Year is showing proper..........");
				} else {
					log.info("Decade Calender for Effective Year is not showing proper..........");
				}
				HomePage.setHomePageApplication();
				ProjectPage = HomePage.clickOnProject();
				CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
				HomePage.closeProjectSearchTextBox();				
				CommunitiesPage.ClickonDataInput();
				CommonMethod.switchToDataInputFrame();
				CommunitiesPage.ClickonProjectSetting();
				RowAddflag = CommunitiesPage.verifyAddedProject_Setting_ProjectAreaRow();
			} else {
				log.info("Communities Project is showing Null");
				Assert.assertTrue(false);
			}
			if ((RowAddflag) && (DecadeCalenderflag)) {
				log.info("Communities_ProjectSetting_ProjectArea_Save_Row_DecadeCalender_Display method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Communities_ProjectSetting_ProjectArea_Save_Row_DecadeCalender_Display method ends here ........... ");
				Assert.assertTrue(false);
			}
		}

		// Verify Project Area field allows to add values followed by commas.

		@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 255, enabled = true, description = "Verify Project Area field allows to add values followed by commas.")
		public void Communities_ProjectArea_Field_Comma_Display() {

			log.info("Communities_ProjectArea_Field_Comma_Display method started......................... ");
			//CommonMethod.switchToDefaultContent();
			//CommunitiesPage = new CommunitiesPageObject();
			boolean flag = false;
			boolean Commaflag = false;
			try {
				HomePage.setHomePageApplication();

			} catch (Exception e) {
				HomePage.setHomePageApplication();
				e.printStackTrace();
			}

			String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
			// ProjectCommunitiesID="8000004355";
			if (!ProjectCommunitiesID.equals(null)) {
				ProjectPage = HomePage.clickOnProject();
				CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
				HomePage.closeProjectSearchTextBox();				
				CommunitiesPage.ClickonDataInput();
				CommonMethod.switchToDataInputFrame();
				CommunitiesPage.ClickonProjectSetting();
				Commaflag = CommunitiesPage.verifyProjectAreaField_Contains_Comma();
				if (Commaflag) {
					log.info("Project Area field contains Comma");
					log.info("Communities_ProjectArea_Field_Comma_Display method ends here ........... ");
					Assert.assertTrue(true);
				} else {
					log.info("Project Area field field does not contains Comma");
					log.info("Communities_ProjectArea_Field_Comma_Display method ends here ........... ");
					Assert.assertTrue(false);
				}
			} else {
				log.info("Communities Project is showing Null");
				Assert.assertTrue(false);
			}
		}

		// Project Setting - >Project Area - >Verify 'Comments' section by adding
		// comment should show correct timestamp.
		// Verify 'Activity' section should show correct activity with date and
		// timestamp.

		@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 256, enabled = true, description = "Project Area - > Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
		public void Communities_ProjectSetting_ProjectArea_Comments_Activity_Test() {

			log.info("Communities_ProjectSetting_ProjectArea_Comments_Activity_Test method started......................... ");
			//CommonMethod.switchToDefaultContent();
			//CommunitiesPage = new CommunitiesPageObject();
			boolean flag = false;

			try {
				HomePage.setHomePageApplication();

			} catch (Exception e) {
				HomePage.setHomePageApplication();
				e.printStackTrace();
			}

			String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
			// ProjectCommunitiesID="8000004423";
			if (!ProjectCommunitiesID.equals(null)) {
				ProjectPage = HomePage.clickOnProject();
				String ProfileUserName = HomePage.getCurrentProfileUserName();
				CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
				HomePage.closeProjectSearchTextBox();				
				CommunitiesPage.ClickonDataInput();				
				CommonMethod.switchToDataInputFrame();
				CommunitiesPage.ClickonProjectSetting();

				flag = CommunitiesPage.checkProjectAreaCommentAndActivity(data.getCellData("Communities", 3, 2), ProfileUserName);

			} else {
				log.info("Communities Project is showing Null");
				Assert.assertTrue(false);
			}
			if (flag) {
				log.info("Communities_ProjectSetting_ProjectArea_Comments_Activity_Test method ends here ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Communities_ProjectSetting_ProjectArea_Comments_Activity_Test method ends here ........... ");
				Assert.assertTrue(false);
			}
		}

		// Verify after creating Communities Project with Gross Area as "Square Miles unit",
		// check in Data Input – Project Setting - > Project Area Tab -> Unit Drop down
		// by default value.

		@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 257, enabled = true, description = "Verify after creating Communities Project with Gross Area as \"Square Miles unit\", check in Data Input – Project Setting - > Project Area Tab -> Unit Drop down by default value. ")
		public void Communities_Project_Area_GrossArea_SquareMiles_Display() {
			log.info("Communities_Project_Area_GrossArea_SquareMiles_Display method started ........... ");
			//CommonMethod.switchToDefaultContent();
			//CommunitiesPage = new CommunitiesPageObject();
			boolean flag = false;
			try {
				HomePage.setHomePageApplication();

			} catch (Exception e) {
				HomePage.setHomePageApplication();
				e.printStackTrace();
			}

			String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
			// ProjectCommunitiesID="8000004319";
			if (!ProjectCommunitiesID.equals(null)) {
				ProjectPage = HomePage.clickOnProject();
				CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
				HomePage.closeProjectSearchTextBox();				
				CommunitiesPage.ClickonDataInput();
				CommonMethod.switchToDataInputFrame();
				CommunitiesPage.ClickonProjectSetting();
				flag = CommunitiesPage.checkUnitTypeInProjectAreaUnderDataInput("sq miles");

			} else {
				log.info("Communities Project is showing Null");
				Assert.assertTrue(false);
			}
			if (flag) {
				Assert.assertTrue(true);
				log.info("Communities_Project_Area_GrossArea_SquareMiles_Display method ends here ........... ");
			} else {
				log.info("Communities_Project_Area_GrossArea_SquareMiles_Display method ends here ........... ");
				Assert.assertTrue(false);

			}

		}

		// Project Setting - > Project Area - > Verify filter button - From (Start date)
		// and To (End date) uopens up decade calendar and on selecting any year range,
		// the line items falling into those year should be displayed.

		@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
				"Communities_ProjectSetting_ProjectArea_Save_Row_DecadeCalender_Display" }, priority = 258, enabled = true, description = "Project Setting - > Project Area - >Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed. ")
		public void Communities_ProjectArea_Filter_Test() {

			log.info("Communities_ProjectArea_Filter_Test method started......................... ");
			//CommonMethod.switchToDefaultContent();
			//CommunitiesPage = new CommunitiesPageObject();
			boolean flag = false;
			boolean Commaflag = false;
			try {
				HomePage.setHomePageApplication();

			} catch (Exception e) {
				HomePage.setHomePageApplication();
				e.printStackTrace();
			}

			String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
			// ProjectCommunitiesID="8000004498";
			if (!ProjectCommunitiesID.equals(null)) {
				ProjectPage = HomePage.clickOnProject();
				CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
				HomePage.closeProjectSearchTextBox();				
				CommunitiesPage.ClickonDataInput();
				CommonMethod.switchToDataInputFrame();
				CommunitiesPage.ClickonProjectSetting();
				flag = CommunitiesPage.CheckProjectAreaFilter();
			} else {
				log.info("Communities Project is showing Null");
				Assert.assertTrue(false);
			}
			if (flag) {

				// log.info("Population field contains Comma");
				log.info("Communities_ProjectArea_Filter_Test method ends here ........... ");
				Assert.assertTrue(true);
			} else {
				// log.info("Population field does not contains Comma");
				log.info("Communities_ProjectArea_Filter_Test method ends here ........... ");
				Assert.assertTrue(false);
			}

		}

		// Project Area--- Verify Updated by shows the correct team-member/admin name.{To
			// check this, add any team-member in teams section and login using that team
			// member and add line item to this tab and check if his name s updated in
			// 'Updated by column }

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 259, enabled = false, description = "Project Setting -> Project Area \r\n Verify Updated by shows the correct team-member/admin name.{To check this, add any team-member in teams section and login using that team member and add line item to this tab and chek if his name s updated in 'Updated by column ")
			public void Communities_ProjectSetting_ProjectArea_UpdatedBy_Test() {

				log.info("Communities_ProjectSetting_ProjectArea_UpdatedBy_Test method started......................... ");
				//CommonMethod.switchToDefaultContent();

				HomePage.setHomePageApplication();
				ProjectPage = HomePage.clickOnProject();
				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Test1");
				//ProjectCommunitiesID="8000006651";
				 if (!ProjectCommunitiesID.equals(null)) {
					 CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					 CommunitiesPage.ClickonTeamInManage();
						HomePage.closeProjectSearchTextBox();
						String username = data.getCellData("Communities", 0, 2);
						boolean emailexist = CommonMethod.Team_checkEmailExistOrNot(username);
						System.out.println(username + "-----------existence is----" + emailexist);
						boolean flag = false;
						if(emailexist==false) {
							flag = CommonMethod.Team_Add_Member(username);
						}
						else
						{
							flag=true;
						}
						if(flag)
						{
							log.info("Team Member added-----------------");
							HomePage.checkSignOut();
							HomePage = LoginPage.loginLater(data.getCellData("Communities", 0, 2), data.getCellData("Communities", 1, 2));
							//CommunitiesPage = new CommunitiesPageObject();
							boolean Updatedflag = false;

							try {
								HomePage.setHomePageApplication();

							} catch (Exception e) {
								HomePage.setHomePageApplication();
								e.printStackTrace();
							}
							
							ProjectPage = HomePage.clickOnProject();
							CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
							CommunitiesPage.ClickonDataInput();
							HomePage.closeProjectSearchTextBox();
							CommonMethod.switchToDataInputFrame();
							CommunitiesPage.ClickonProjectSetting();						
							boolean RecordAdded=CommunitiesPage.checkProjectArea_Save_New_Row("1400");
							if(RecordAdded)
							{
								log.info("RecordAdded flag is true  --------------");
								CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
								CommunitiesPage.ClickonDataInput();
								HomePage.closeProjectSearchTextBox();
								CommonMethod.switchToDataInputFrame();
								CommunitiesPage.ClickonProjectSetting();
								Updatedflag = CommunitiesPage.checkProjectAreaUpdatedByUserName(HomePage.getCurrentProfileUserName());
								CommonMethod.switchToDefaultContent();
								HomePage.checkSignOut();
								HomePage = LoginPage.loginLater(prop.getProperty("email"), prop.getProperty("password"));
								if (Updatedflag) {
									log.info("Communities_ProjectSetting_ProjectArea_UpdatedBy_Test method ends with true here ........... ");
									Assert.assertTrue(true);

								} else {
									log.info("Communities_ProjectSetting_ProjectArea_UpdatedBy_Test method ends ends with false here ........... ");
									Assert.assertTrue(false);
								}
							}
							else
							{
								log.info("RecordAdded flag is false, Unable to add the record--------------");
								CommonMethod.switchToDefaultContent();
								HomePage.checkSignOut();
								HomePage = LoginPage.loginLater(prop.getProperty("email"), prop.getProperty("password"));
								log.info("Communities_ProjectSetting_ProjectArea_UpdatedBy_Test method ends ends with false here ........... ");
								Assert.assertTrue(false);
							}
							
						}
						else {
								log.info("Unable to add the team member.-----------------");
								log.info("Communities_ProjectSetting_ProjectArea_UpdatedBy_Test method ends with false here ........... ");
								Assert.assertTrue(false);
							}
					 
				 }
				 
				 else {
						log.info("Communities Project is showing Null");
						log.info("Communities_ProjectSetting_ProjectArea_UpdatedBy_Test method ends with false here ........... ");
						Assert.assertTrue(false);
					}
				
			}
		

			
			// Verify Energy meter shows GHG emissions meter with data and detals tab.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 262, enabled = true, description = "Verify Energy meter shows GHG emissions meter with data and detals tab.")
			public void Communities_Energy_GHGEmission_With_DataAndDetails_Display() {

				log.info("Communities_Energy_GHGEmission_DataAndDetailsTab_Display method started......................... ");
				//CommonMethod.switchToDefaultContent();

				////CommunitiesPage=new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000006730";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonGHGEmiissions();
					flag = CommunitiesPage.CheckGHGEmission_Data_DetailsTab_Display();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Energy_GHGEmission_DataAndDetailsTab_Display method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Energy_GHGEmission_DataAndDetailsTab_Display method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Verify 'Add year' button adds line item with year for previous year.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
					"Communities_Energy_GHGEmission_With_DataAndDetails_Display" }, priority = 262, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
			public void Communities_Energy_GHGEmission_AddYear_AddNewLine() {

				log.info("Communities_Energy_GHGEmission_AddYear_AddNewLine method started......................... ");
				//CommonMethod.switchToDefaultContent();
				////CommunitiesPage=new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000006730";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonGHGEmiissions();
					flag = CommunitiesPage.CheckGHGEmission_AddYear_NewRow_Display();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Energy_GHGEmission_AddYear_AddNewLine method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Energy_GHGEmission_AddYear_AddNewLine method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Verify by adding value to reading and clicking on save button.
			// Verify score gets populated when data is added for previous year

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
					"Communities_Energy_GHGEmission_AddYear_AddNewLine" }, priority = 262, enabled = true, description = "Verify by adding value to reading and clicking on save button. \r\n"
							+ "				 Verify score gets populated when data is added for previous year  ")
			public void Communities_Energy_GHGEmission_SavePreviousYearData_CheckScore() {

				log.info("Communities_Energy_GHGEmission_SavePreviousYearData_CheckScore method started......................... ");
				//CommonMethod.switchToDefaultContent();
				////CommunitiesPage=new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000006730";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonGHGEmiissions();
					OldScore = CommunitiesPage.getEnergyScore();
					flag = CommunitiesPage.CheckGHGEmission_SaveNewRecord();

					if (flag) {
						HomePage.setHomePageApplication();
						ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						HomePage.closeProjectSearchTextBox();
						CommunitiesPage.ClickonDataInput();
						CommonMethod.switchToDataInputFrame();
						CommunitiesPage.ClickonGHGEmiissions();

						NewScore = CommunitiesPage.getEnergyScore();
						if (NewScore > OldScore) {
							log.info("Score is updated with---" + NewScore);
							log.info("Communities_Energy_GHGEmission_SavePreviousYearData_CheckScore method ends here ........... ");
							Assert.assertTrue(true);
						}
					} else {
						log.info("Record is not added successfully");
						log.info("Communities_Energy_GHGEmission_SavePreviousYearData_CheckScore method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Energy_GHGEmission_SavePreviousYearData_CheckScore method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Verify able to Edit line item by using Edit button..

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Energy_GHGEmission_SavePreviousYearData_CheckScore", priority = 262, enabled = true, description = "Verify able to Edit line item by using Edit button..")
			public void Communities_Energy_GHGEmission_Edit_Row() {

				log.info("Communities_Energy_GHGEmission_Edit_Row method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage=new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000006730";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonGHGEmiissions();
					OldScore = CommunitiesPage.getEnergyScore();
					flag = CommunitiesPage.CheckGHGEmission_EditRow();

					if (flag) {
						CommonMethod.switchToDefaultContent();
						HomePage.clickOnProject();
						ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						HomePage.closeProjectSearchTextBox();
						CommunitiesPage.ClickonDataInput();
						CommonMethod.switchToDataInputFrame();
						CommunitiesPage.ClickonGHGEmiissions();
						NewScore = CommunitiesPage.getEnergyScore();
						if (NewScore != OldScore) {
							log.info(OldScore + " is updated with---" + NewScore);
							log.info("Communities_Energy_GHGEmission_Edit_Row method ends here ........... ");
							Assert.assertTrue(true);
						}
					} else {
						log.info("Record is not updated successfully");
						log.info("Communities_Energy_GHGEmission_Edit_Row method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Energy_GHGEmission_Edit_Row method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Verify able to delete line item by using delete button.
			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Energy_GHGEmission_SavePreviousYearData_CheckScore", priority = 263, enabled = true, description = "Verify able to delete line item by using delete button.")
			public void Communities_Energy_GHGEmission_Delete_Row() {

				log.info("Communities_Energy_GHGEmission_Delete_Row method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage=new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000006730";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonGHGEmiissions();
					OldScore = CommunitiesPage.getEnergyScore();
					// CommunitiesPage.ClickonDataInput();
					// CommunitiesPage.ClickonGHGEmiissions();
					flag = CommunitiesPage.CheckGHGEmission_DeleteRow();

					if (flag) {
						CommonMethod.switchToDefaultContent();
						HomePage.clickOnProject();
						ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						HomePage.closeProjectSearchTextBox();
						CommunitiesPage.ClickonDataInput();
						CommonMethod.switchToDataInputFrame();
						CommunitiesPage.ClickonGHGEmiissions();

						NewScore = CommunitiesPage.getEnergyScore();
						if (NewScore != OldScore) {
							log.info(OldScore + " is updated with---" + NewScore);
							log.info("Communities_Energy_GHGEmission_Delete_Row method ends here ........... ");
							Assert.assertTrue(true);
						}
					} else {
						log.info("Record is not deleted successfully");
						log.info("Communities_Energy_GHGEmission_Delete_Row method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Energy_GHGEmission_Delete_Row method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Verify 'previous year' and 'next year' button adds reading respectively.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 264, dependsOnMethods = {
					"Communities_Energy_GHGEmission_SavePreviousYearData_CheckScore" }, enabled = true, description = "Verify 'previous year' and 'next year' button adds reading respectively.")
			public void Communities_Energy_AddRow_PreviousYear_NextYear() {

				log.info("Communities_Energy_AddRow_PreviousYear_NextYear method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage=new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000006731";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonGHGEmiissions();
					CommunitiesPage.CheckGHGEmission_SaveNewRecord();
					flag = CommunitiesPage.CheckGHGEmission_SavePreviousAndNextYearRecord();
					if (flag) {
						log.info("Communities_Energy_AddRow_PreviousYear_NextYear method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not added successfully");
						log.info("Communities_Energy_AddRow_PreviousYear_NextYear method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Energy_AddRow_PreviousYear_NextYear method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Energy --> GHS Emissions --> Verify 'Comments' section by adding comment
			// should show correct timestamp.
			// Energy --> GHS Emissions -->'Activity' section should show correct activity
			// with date and
			// timestamp.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 265, enabled = true, description = "Energy --> GHS Emissions -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
			public void Communities_Energy_DetailsTab_Comments_Activity_Test() {

				log.info("Communities_Energy_DetailsTab_Comments_Activity_Test method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage=new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000006730";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					String ProfileUserName = HomePage.getCurrentProfileUserName();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();				
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonGHGEmiissions();
					flag = CommunitiesPage.checkEnergyCommentAndActivity(data.getCellData("Communities", 5, 2), ProfileUserName);

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}
				if (flag) {
					log.info("Communities_Energy_DetailsTab_Comments_Activity_Test method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Energy_DetailsTab_Comments_Activity_Test method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Energy - Verify filter button - From (Start date) and To (End date) uopens up
			// decade calendar and on selecting any year range, the line items falling into
			// those year should be displayed.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
					"Communities_Energy_GHGEmission_SavePreviousYearData_CheckScore" }, priority = 266, enabled = true, description = "Energy - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
			public void Communities_Energy_FilterTest() {

				log.info("Communities_Energy_FilterTest method started......................... ");
				//CommonMethod.switchToDefaultContent();

				//CommunitiesPage=new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Perf4");
				// ProjectCommunitiesID="8000006732";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();

					CommunitiesPage.ClickonGHGEmiissions();
					flag = CommunitiesPage.CheckEnergyFilter();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Energy_FilterTest method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Energy_FilterTest method ends here ........... ");
					Assert.assertTrue(false);
				}
			}
		// Verify Water meter shows 'Water Consumption' meter with data and details tab.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 270, enabled = true, description = "Verify Water meter shows 'Water Consumption' meter with data and details tab. ")
			public void Communities_Water_DataAndDetails_Display() {

				log.info("Communities_Water_DataAndDetails_Display method started......................... ");
				//CommonMethod.switchToDefaultContent();

				//CommunitiesPage=new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID = "8000006730";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();

					CommunitiesPage.ClickonWaterConsumption();
					flag = CommunitiesPage.CheckWaterConsumption_Data_DetailsTab_Display();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Water_DataAndDetails_Display method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Water_DataAndDetails_Display method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Verify 'Add year' button adds line item with year for previous year.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Water_DataAndDetails_Display", priority = 270, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
			public void Communities_Water_Consum_AddYear_AddNewLine() {

				log.info("Communities_Water_Consum_AddYear_AddNewLine method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage=new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID = "8000006730";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();

					CommunitiesPage.ClickonWaterConsumption();
					flag = CommunitiesPage.CheckWatwr_Consumption_AddYear_NewRow_Display();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Water_Consum_AddYear_AddNewLine method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Water_Consum_AddYear_AddNewLine method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Verify by adding value to reading and clicking on save button.
			// Verify score gets populated when data is added for previous year

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Water_Consum_AddYear_AddNewLine", priority = 270, enabled = true, description = "Verify by adding value to reading and clicking on save button. . \r\n"
					+ "				 Verify score gets populated when data is added for previous year  ")
			public void Communities_Water_Consum_SavePreviousYearData_CheckScore() {

				log.info("Communities_Water_Consum_SavePreviousYearData_CheckScore method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage=new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID = "8000006730";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonWaterConsumption();
					OldScore = CommunitiesPage.getWaterScore();
					flag = CommunitiesPage.CheckWaterConsumption_SaveNewRecord();

					if (flag) {
						HomePage.setHomePageApplication();
						ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						HomePage.closeProjectSearchTextBox();
						CommunitiesPage.ClickonDataInput();
						CommonMethod.switchToDataInputFrame();
						CommunitiesPage.ClickonWaterConsumption();

						NewScore = CommunitiesPage.getWaterScore();
						if (NewScore > OldScore) {
							log.info("Water Score is updated with---" + NewScore);
							log.info("Communities_Water_Consum_SavePreviousYearData_CheckScore method ends here ........... ");
							Assert.assertTrue(true);
						}
					} else {
						log.info("Record is not added successfully");
						log.info("Communities_Water_Consum_SavePreviousYearData_CheckScore method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Water_Consum_SavePreviousYearData_CheckScore method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Verify 'Unit' dropdown allows to select unit 'Gallons' or 'Litre'.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Water_Consum_SavePreviousYearData_CheckScore", priority = 271, enabled = true, description = "Verify 'Unit' dropdown allows to select unit 'Gallons' or 'Litre'.")
			public void Communities_Water_AddRows_With_Gallons_Litres() {

				log.info("Communities_Water_AddRows_With_Gallons_Litres method started......................... ");
				//CommonMethod.switchToDefaultContent();

				//CommunitiesPage=new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID = "8000006730";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();

					CommunitiesPage.ClickonWaterConsumption();
					OldScore = CommunitiesPage.getWaterScore();
					
					flag = CommunitiesPage.CheckWaterConsumption_AddRow_UnitTypes();

					if (flag) {

						log.info("Communities_Water_AddRows_With_Gallons_Litres method ends here ........... ");
						Assert.assertTrue(true);

					} else {

						log.info("Communities_Water_AddRows_With_Gallons_Litres method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Water_AddRows_With_Gallons_Litres method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Verify 'Duration' dropdown allows to select unit 'Per Year' or 'Per Month' or
			// 'Per week' or 'Per day' .

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 272, dependsOnMethods = "Communities_Water_Consum_SavePreviousYearData_CheckScore", enabled = true, description = "Verify 'Duration' dropdown allows to select unit 'Per Year' or 'Per Month' or 'Per week' or 'Per day' .")
			public void Communities_Water_AddRows_With_Duration_Types() {

				log.info("Communities_Water_AddRows_With_Duration_Types method started......................... ");
				//CommonMethod.switchToDefaultContent();

				//CommunitiesPage=new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID = "8000006730";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();

					CommunitiesPage.ClickonWaterConsumption();
					OldScore = CommunitiesPage.getWaterScore();
					
					flag = CommunitiesPage.CheckWaterConsumption_AddRow_DurationTypes();

					if (flag) {

						log.info("Communities_Water_AddRows_With_Duration_Types method ends here ........... ");
						Assert.assertTrue(true);

					} else {

						log.info("Communities_Water_AddRows_With_Duration_Types method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Water_AddRows_With_Duration_Types method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Verify 'previous year' and 'next year' button adds reading respectively.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
					"Communities_Water_Consum_SavePreviousYearData_CheckScore" }, priority = 273, enabled = true, description = "Verify 'previous year' and 'next year' button adds reading respectively.")
			public void Communities_Water_AddRow_PreviousYear_NextYear() {

				log.info("Communities_Water_AddRow_PreviousYear_NextYear method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage=new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000006731";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();

					CommunitiesPage.ClickonWaterConsumption();
					CommunitiesPage.CheckWaterConsumption_SaveNewRecord();
					flag = CommunitiesPage.CheckWaterConsum_SavePreviousAndNextYearRecord();
					if (flag) {
						log.info("Communities_Water_AddRow_PreviousYear_NextYear method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not added successfully");
						log.info("Communities_Water_AddRow_PreviousYear_NextYear method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Water_AddRow_PreviousYear_NextYear method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Verify able to Edit line item by using Edit button..

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Water_Consum_SavePreviousYearData_CheckScore", priority = 274, enabled = true, description = "Verify able to Edit line item by using Edit button..")
			public void Communities_Water_Edit_Row() {

				log.info("Communities_Water_Edit_Row method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage=new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000006730";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();

					CommunitiesPage.ClickonWaterConsumption();
					flag = CommunitiesPage.CheckWaterConsum_EditRow();

					if (flag) {
						log.info("Record is updated successfully");
						log.info("Communities_Water_Edit_Row method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not updated successfully");
						log.info("Communities_Water_Edit_Row method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Water_Edit_Row method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Verify able to delete line item by using delete button.
			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Water_Consum_SavePreviousYearData_CheckScore", priority = 275, enabled = true, description = "Verify able to delete line item by using delete button.")
			public void Communities_Water_Delete_Row() {

				log.info("Communities_Water_Delete_Row method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage=new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000006730";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();

					CommunitiesPage.ClickonWaterConsumption();
					;
					// OldScore = CommunitiesPage.getEnergyScore();

					flag = CommunitiesPage.CheckWaterConsum_DeleteRow();

					if (flag) {
						log.info("Record is deleted successfully");
						log.info("Communities_Water_Delete_Row method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not deleted successfully");
						log.info("Communities_Water_Delete_Row method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Water_Delete_Row method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Water --> Water Consumption --> Verify 'Comments' section by adding comment
			// should show correct timestamp.
			// Water --> Water Consumption -->'Activity' section should show correct
			// activity with date and
			// timestamp.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 276, enabled = true, description = "Water --> Water Consumption -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
			public void Communities_Water_Comments_Activity_Test() {

				log.info("Communities_Water_Comments_Activity_Test method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage=new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000006730";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					String ProfileUserName = HomePage.getCurrentProfileUserName();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();				
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonWaterConsumption();
					flag = CommunitiesPage.checkWaterCommentAndActivity(data.getCellData("Communities", 9, 2), ProfileUserName);

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}
				if (flag) {
					log.info("Communities_Water_Comments_Activity_Test method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Water_Comments_Activity_Test method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Water - Water Consumption - >Verify filter button - From (Start date) and To
			// (End date) uopens up decade calendar and on selecting any year range, the
			// line items falling into those year should be displayed.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 277, enabled = true, description = "Water - Water Consumption - > - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
			public void Communities_Water_FilterTest() {

				log.info("Communities_Water_FilterTest method started......................... ");
				//CommonMethod.switchToDefaultContent();

				//CommunitiesPage=new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Perf4");
				// ProjectCommunitiesID="8000006732";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonWaterConsumption();
					flag = CommunitiesPage.CheckWaterFilter();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Water_FilterTest method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Water_FilterTest method ends here ........... ");
					Assert.assertTrue(false);
				}
			}
			
			
			// **************************Communities WASTE TEST CASES********************************************

			// Verify Waste meters shows 'Municipal Solid Waste generation intensity' with
			// data and details tab.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 280, enabled = true, description = "Verify Waste meters shows 'Municipal Solid Waste generation intensity'  with data and details tab. ")
			public void Communities_Waste_Gen_DataAndDetails_Display() {

				log.info("Communities_Waste_Gen_DataAndDetails_Display method started......................... ");
				//CommonMethod.switchToDefaultContent();

				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID = "8000004409";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonMunicipalSolidwastegeneration();
					flag = CommunitiesPage.CheckWasteGeneration_Data_DetailsTab_Display();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Waste_Gen_DataAndDetails_Display method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Waste_Gen_DataAndDetails_Display method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// For Municipal Solid Waste generation intensity Meters- Verify 'Add year'
			// button adds line item with year for previous year.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Waste_Gen_DataAndDetails_Display", priority = 280, enabled = true, description = "For Municipal Solid Waste generation intensity Meters- Verify 'Add year' button adds line item with year for previous year.")
			public void Communities_Waste_Generation_AddYear_AddNewLine() {

				log.info("Communities_Waste_Generation_AddYear_AddNewLine method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID = "8000004409";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonMunicipalSolidwastegeneration();
					flag = CommunitiesPage.CheckWaste_Generation_AddYear_NewRow_Display();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Waste_Generation_AddYear_AddNewLine method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Waste_Generation_AddYear_AddNewLine method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// For Municipal Solid Waste generation intensity Meter- - Verify by adding
			// value to reading and clicking on save button.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Waste_Generation_AddYear_AddNewLine", priority = 280, enabled = true, description = "For Municipal Solid Waste generation intensity Meter- - Verify by adding value to reading and clicking on save button. ")
			public void Communities_Waste_Generation_SavePreviousYearData() {

				log.info("Communities_Waste_Generation_SavePreviousYearData method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID = "8000004409";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonMunicipalSolidwastegeneration();
					flag = CommunitiesPage.CheckWaste_Generation_SaveNewRecord();

					if (flag) {
						log.info("Record is added successfully");
						log.info("Communities_Waste_Generation_SavePreviousYearData method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not added successfully");
						log.info("Communities_Waste_Generation_SavePreviousYearData method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Waste_Generation_SavePreviousYearData method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Verify 'previous year' and 'next year' button adds reading respectively.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 281, dependsOnMethods = "Communities_Waste_Generation_SavePreviousYearData", enabled = true, description = "Verify 'previous year' and 'next year' button adds reading respectively.")
			public void Communities_Waste_Generation_AddRow_PreviousYear_NextYear() {

				log.info("Communities_Waste_Generation_AddRow_PreviousYear_NextYear method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000004409";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonMunicipalSolidwastegeneration();
					flag = CommunitiesPage.CheckWaste_Generation_SavePreviousAndNextYearRecord();
					if (flag) {
						log.info("Communities_Waste_Generation_AddRow_PreviousYear_NextYear method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not added successfully");
						log.info("Communities_Waste_Generation_AddRow_PreviousYear_NextYear method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Waste_Generation_AddRow_PreviousYear_NextYear method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Verify able to Edit line item by using Edit button..

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Waste_Generation_SavePreviousYearData", priority = 282, enabled = true, description = "Verify able to Edit line item by using Edit button..")
			public void Communities_Waste_Generation_Edit_Row() {

				log.info("Communities_Waste_Generation_Edit_Row method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000004409";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonMunicipalSolidwastegeneration();
					flag = CommunitiesPage.CheckWasteGeneration_EditRow();

					if (flag) {
						log.info("Communities_Waste_Generation_Edit_Row method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not updated successfully");
						log.info("Communities_Waste_Generation_Edit_Row method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Waste_Generation_Edit_Row method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Verify able to delete line item by using delete button.
			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Waste_Generation_SavePreviousYearData", priority = 283, enabled = true, description = "Verify able to delete line item by using delete button.")
			public void Communities_Waste_Generation_Delete_Row() {

				log.info("Communities_Waste_Generation_Delete_Row method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000004409";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonMunicipalSolidwastegeneration();

					flag = CommunitiesPage.CheckWasteGeneration_DeleteRow();

					if (flag) {

						log.info("Record is deleted successfully");
						log.info("Communities_Waste_Generation_Delete_Row method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not deleted successfully");
						log.info("Communities_Waste_Generation_Delete_Row method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Waste_Generation_Delete_Row method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Waste --> Municipal solid waste generation intensity --> Verify 'Comments'
			// section by adding comment should show correct timestamp.
			// Waste --> Municipal solid waste generation intensity -->'Activity' section
			// should show correct activity with date and
			// timestamp.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 284, enabled = true, description = "Waste --> Municipal solid waste generation intensity -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
			public void Communities_Waste_Generation_Comments_Activity_Test() {

				log.info("Communities_Waste_Generation_Comments_Activity_Test method started......................... ");
			//	CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000004465";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					String ProfileUserName = HomePage.getCurrentProfileUserName();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();				
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonMunicipalSolidwastegeneration();
					flag = CommunitiesPage.checkWasteGenerationCommentAndActivity(data.getCellData("Communities", 11, 2), ProfileUserName);

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}
				if (flag) {
					log.info("Communities_Waste_Generation_Comments_Activity_Test method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Waste_Generation_Comments_Activity_Test method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Waste - Municipal solid waste generation intensity - >Verify filter button -
			// From (Start date) and To (End date) uopens up decade calendar and on
			// selecting any year range, the line items falling into those year should be
			// displayed.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
					"Communities_Waste_Generation_SavePreviousYearData" }, priority = 285, enabled = true, description = "Waste - 	Municipal solid waste generation intensity - >Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
			public void Communities_Waste_Generation_FilterTest() {

				log.info("Communities_Waste_Generation_FilterTest method started......................... ");
				//CommonMethod.switchToDefaultContent();

				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Perf4");
				// ProjectCommunitiesID="8000004566";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonMunicipalSolidwastegeneration();
					flag = CommunitiesPage.CheckWaste_GenerationFilter();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Waste_Generation_FilterTest method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Waste_Generation_FilterTest method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Verify Waste meters shows 'Municipal solid waste diversion rate from
			// landfill' with data and details tab.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 290, enabled = true, description = "Verify Waste meters shows 'Municipal solid waste diversion rate from landfill'  with data and details tab. ")
			public void Communities_Waste_Diversion_DataAndDetails_Display() {

				log.info("Communities_Waste_Diversion_DataAndDetails_Display method started......................... ");
				//CommonMethod.switchToDefaultContent();

				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID = "8000004409";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonMunicipalSolidWasteDiversion();
					flag = CommunitiesPage.CheckWasteDiversion_Data_DetailsTab_Display();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Waste_Diversion_DataAndDetails_Display method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Waste_Diversion_DataAndDetails_Display method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Municipal solid waste diversion rate from landfill- Verify 'Add year' button
			// adds line item with year for previous year.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Waste_Diversion_DataAndDetails_Display", priority = 290, enabled = true, description = "Municipal solid waste diversion rate from landfill- Verify 'Add year' button adds line item with year for previous year.")
			public void Communities_Waste_Diversion_AddYear_AddNewLine() {

				log.info("Communities_Waste_Diversion_AddYear_AddNewLine method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID = "8000004409";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonMunicipalSolidWasteDiversion();
					flag = CommunitiesPage.CheckWaste_Diversion_AddYear_NewRow_Display();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Waste_Diversion_AddYear_AddNewLine method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Waste_Diversion_AddYear_AddNewLine method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			
			// Municipal solid waste diversion rate from landfill- Verify validation Message after adding Invalid Percent value(101)
			

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Waste_Diversion_AddYear_AddNewLine", priority = 290, enabled = true, description = "Municipal solid waste diversion rate from landfill- Verify validation Message after adding Invalid Percent value(101)")
			public void Communities_Waste_Diversion_CheckWithInvalidPercent() {

				log.info("Communities_Waste_Diversion_CheckWithInvalidPercent method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				//ProjectCommunitiesID = "8000006850";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonMunicipalSolidWasteDiversion();
					flag = CommunitiesPage.CheckWaste_Diversion_CheckWithInvalidPercent();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Waste_Diversion_CheckWithInvalidPercent method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Waste_Diversion_CheckWithInvalidPercent method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Municipal solid waste diversion rate from landfill- - Verify by adding value
			// to reading and clicking on save button.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Waste_Diversion_AddYear_AddNewLine", priority = 291, enabled = true, description = "Municipal solid waste diversion rate from landfill- - Verify by adding value to reading and clicking on save button.  ")
			public void Communities_Waste_Diversion_SavePreviousYearData() {

				log.info("Communities_Waste_Diversion_SavePreviousYearData method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID = "8000004409";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonMunicipalSolidWasteDiversion();
					flag = CommunitiesPage.CheckWaste_Diversion_SaveNewRecord();

					if (flag) {
						log.info("Record is added successfully");
						log.info("Communities_Waste_Diversion_SavePreviousYearData method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not added successfully");
						log.info("Communities_Waste_Diversion_SavePreviousYearData method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Waste_Diversion_SavePreviousYearData method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Municipal solid waste diversion rate from landfill - Verify 'previous year'
			// and 'next year' button adds reading respectively.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 291, dependsOnMethods = "Communities_Waste_Diversion_SavePreviousYearData", enabled = true, description = "Municipal solid waste diversion rate from landfill - Verify 'previous year' and 'next year' button adds reading respectively.")
			public void Communities_Waste_Diversion_AddRow_PreviousYear_NextYear() {

				log.info("Communities_Waste_Diversion_AddRow_PreviousYear_NextYear method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000004409";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonMunicipalSolidWasteDiversion();
					flag = CommunitiesPage.CheckWaste_Diversion_SavePreviousAndNextYearRecord();
					if (flag) {
						log.info("Communities_Waste_Diversion_AddRow_PreviousYear_NextYear method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not added successfully");
						log.info("Communities_Waste_Diversion_AddRow_PreviousYear_NextYear method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Waste_Diversion_AddRow_PreviousYear_NextYear method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Municipal solid waste diversion rate from landfill - Verify able to Edit line
			// item by using Edit button..

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Waste_Diversion_SavePreviousYearData", priority = 292, enabled = true, description = "Municipal solid waste diversion rate from landfill - Verify able to Edit line item by using Edit button..")
			public void Communities_Waste_Diversion_Edit_Row() {

				log.info("Communities_Waste_Diversion_Edit_Row method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000004409";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonMunicipalSolidWasteDiversion();
					flag = CommunitiesPage.CheckWasteDiversion_EditRow();

					if (flag) {
						log.info("Communities_Waste_Diversion_Edit_Row method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not updated successfully");
						log.info("Communities_Waste_Diversion_Edit_Row method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Waste_Diversion_Edit_Row method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Municipal solid waste diversion rate from landfill - Verify able to delete
			// line item by using delete button.
			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Waste_Diversion_SavePreviousYearData", priority = 293, enabled = true, description = "Municipal solid waste diversion rate from landfill - Verify able to delete line item by using delete button.")
			public void Communities_Waste_Diversion_Delete_Row() {

				log.info("Communities_Waste_Diversion_Delete_Row method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000004409";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonMunicipalSolidWasteDiversion();

					flag = CommunitiesPage.CheckWasteDiversion_DeleteRow();

					if (flag) {

						log.info("Record is deleted successfully");
						log.info("Communities_Waste_Diversion_Delete_Row method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not deleted successfully");
						log.info("Communities_Waste_Diversion_Delete_Row method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Waste_Diversion_Delete_Row method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Verify score gets populated when data is added for previous year for both the
			// meters- 'Municipal Solid Waste generation intensity' and 'Municipal Solid
			// Waste Diversion rate from Landfill '

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
					"Communities_Waste_Diversion_SavePreviousYearData",
					"Communities_Waste_Generation_SavePreviousYearData" }, priority = 294, enabled = true, description = "Verify score gets populated when data is added for previous year for both the meters- 'Municipal Solid Waste generation intensity' and 'Municipal Solid Waste Diversion rate from Landfill '  ")
			public void Communities_Waste_Score_SavePreviousYearDataForGenerationAndDiversion() {

				log.info(
						"Communities_Waste_Score_SavePreviousYearDataForGenerationAndDiversion method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID = "8000004454";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
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
								"Communities_Waste_Score_SavePreviousYearDataForGenerationAndDiversion method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Waste Score is not generated successfully");
						log.info(
								"Communities_Waste_Score_SavePreviousYearDataForGenerationAndDiversion method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Waste_Score_SavePreviousYearDataForGenerationAndDiversion method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Waste --> Municipal solid waste diversion rate from landfill --> Verify
			// 'Comments' section by adding comment should show correct timestamp.
			// Waste --> Municipal solid waste diversion rate from landfill -->'Activity'
			// section should show correct activity with date and
			// timestamp.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 295, enabled = true, description = "Waste --> Municipal solid waste diversion rate from landfill -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
			public void Communities_Waste_Diversion_Comments_Activity_Test() {

				log.info("Communities_Waste_Diversion_Comments_Activity_Test method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Perf4");
				// ProjectCommunitiesID="8000004466";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					String ProfileUserName = HomePage.getCurrentProfileUserName();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();				
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonMunicipalSolidWasteDiversion();
					flag = CommunitiesPage.checkWasteDiversionCommentAndActivity(data.getCellData("Communities", 13, 2), ProfileUserName);

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}
				if (flag) {
					log.info("Communities_Waste_Diversion_Comments_Activity_Test method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Waste_Diversion_Comments_Activity_Test method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Waste --> Municipal solid waste diversion rate from landfill - >Verify filter
			// button - From (Start date) and To (End date) uopens up decade calendar and on
			// selecting any year range, the line items falling into those year should be
			// displayed.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 296, dependsOnMethods = "Communities_Waste_Diversion_SavePreviousYearData", enabled = true, description = "Waste --> Municipal solid waste diversion rate from landfill - >Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
			public void Communities_Waste_Diversion_FilterTest() {

				log.info("Communities_Waste_Diversion_FilterTest method started......................... ");
				//CommonMethod.switchToDefaultContent();

				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Perf4");
				// ProjectCommunitiesID="8000004510";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonMunicipalSolidWasteDiversion();
					flag = CommunitiesPage.CheckWaste_DiversionFilter();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Waste_Diversion_FilterTest method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Waste_Diversion_FilterTest method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			
			//*********************************************Transportation Test Cases*************************
			// Verify for Transport, 'Vehicle Miles travelled on individual vehicles
			// daily(VMT) gets added by default with "Data" ad "Details" tab.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 300, enabled = true, description = "Verify for Transport, 'Vehicle Miles travelled on individual vehicles daily(VMT) gets added by default with Data and Details tab.")
			public void Communities_Transportation_VMT_With_DataAndDetails_Display() {

				log.info("Communities_Transportation_VMT_With_DataAndDetails_Display method started......................... ");
				//CommonMethod.switchToDefaultContent();

				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}
				// System.setProperty("CommunitiesProject_NonLeed2","8000004525");
				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000004456";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonVMT();
					flag = CommunitiesPage.CheckVMT_Data_DetailsTab_Display();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Transportation_VMT_With_DataAndDetails_Display method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Transportation_VMT_With_DataAndDetails_Display method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Verify 'Add year' button adds line item with year for previous year.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Transportation_VMT_With_DataAndDetails_Display", priority = 300, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
			public void Communities_Transportation_VMT_AddYear_AddNewLine() {

				log.info("Communities_Transportation_VMT_AddYear_AddNewLine method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000004456";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonVMT();
					flag = CommunitiesPage.CheckTransport_VMT_AddYear_NewRow_Display();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Transportation_VMT_AddYear_AddNewLine method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Transportation_VMT_AddYear_AddNewLine method ends here ........... ");
					Assert.assertTrue(false);
				}
			}
			// Transportation - Verify by adding value to reading and clicking on save
			// button.
			// Verify score gets populated when data is added for previous year

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Transportation_VMT_AddYear_AddNewLine", priority = 300, enabled = true, description = "Transportation - >Verify by adding value to reading and clicking on save button. \r\n"
					+ "				 Verify score gets populated when data is added for previous year  ")
			public void Communities_Transportation_SavePreviousYearData_CheckScore() {

				log.info("Communities_Transportation_SavePreviousYearData_CheckScore method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000004377";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonVMT();
					OldScore = CommunitiesPage.getTransportScore();
					flag = CommunitiesPage.CheckTransportation_SaveNewRecord();

					if (flag) {

						HomePage.setHomePageApplication();
						ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						HomePage.closeProjectSearchTextBox();
						CommunitiesPage.ClickonDataInput();
						CommonMethod.switchToDataInputFrame();
						CommunitiesPage.ClickonGHGEmiissions();

						NewScore = CommunitiesPage.getEnergyScore();

						if (NewScore > OldScore) {
							log.info("Score is updated with---" + NewScore);
							log.info("Communities_Transportation_SavePreviousYearData_CheckScore method ends here ........... ");
							Assert.assertTrue(true);
						}
					} else {
						log.info("Record is not added successfully");
						log.info("Communities_Transportation_SavePreviousYearData_CheckScore method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Transportation_SavePreviousYearData_CheckScore method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Transportation - VMT - >Verify 'previous year' and 'next year' button adds
				// reading respectively.

				@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 300, dependsOnMethods = "Communities_Transportation_SavePreviousYearData_CheckScore", enabled = true, description = "Transportation - VMT - > Verify 'previous year' and 'next year' button adds reading respectively.")
				public void Communities_Transportation_VMT_AddRow_PreviousYear_NextYear() {

					log.info("Communities_Transportation_VMT_AddRow_PreviousYear_NextYear method started......................... ");
					int OldScore;
					//CommonMethod.switchToDefaultContent();
					//CommunitiesPage = new CommunitiesPageObject();
					boolean flag = false;

					try {
						HomePage.setHomePageApplication();

					} catch (Exception e) {
						HomePage.setHomePageApplication();
						e.printStackTrace();
					}

					String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
					// ProjectCommunitiesID="8000004525";
					if (!ProjectCommunitiesID.equals(null)) {
						ProjectPage = HomePage.clickOnProject();
						CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						HomePage.closeProjectSearchTextBox();				
						CommunitiesPage.ClickonDataInput();
						CommonMethod.switchToDataInputFrame();
						CommunitiesPage.ClickonVMT();
						OldScore = CommunitiesPage.getTransportScore();
						flag = CommunitiesPage.Transportation_VMT_SavePreviousAndNextYearRecord();
						if (flag) {
							log.info("Communities_Transportation_VMT_AddRow_PreviousYear_NextYear method ends here ........... ");
							Assert.assertTrue(true);

						} else {
							log.info("Record is not added successfully");
							log.info("Communities_Transportation_VMT_AddRow_PreviousYear_NextYear method ends here ........... ");
							Assert.assertTrue(false);
						}

					} else {
						log.info("Communities Project is showing Null");
						log.info("Communities_Transportation_VMT_AddRow_PreviousYear_NextYear method ends here ........... ");
						Assert.assertTrue(false);
					}

				}


			// Transportation - Verify able to edit readings by using 'Edit' button.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Transportation_SavePreviousYearData_CheckScore", priority = 301, enabled = true, description = "Transportation - >Verify able to edit readings by using 'Edit' button.")

			public void Communities_Transportation_Edit_Test() {

				log.info("Communities_Transportation_Edit_Test method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000004525";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonVMT();
					//OldScore = CommunitiesPage.getTransportScore();
					
					flag = CommunitiesPage.CheckTransportation_EditRecord();

					if (flag) {
						/*
						 * HomePage.setHomePageApplication();
						 * ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						 * HomePage.closeProjectSearchTextBox(); CommunitiesPage.ClickonDataInput();
						 * CommonMethod.switchToDataInputFrame(); CommunitiesPage.ClickonGHGEmiissions();
						 * 
						 * NewScore = CommunitiesPage.getEnergyScore();
						 */
						// if (NewScore > OldScore) {
						// log.info("Score is updated with---" + NewScore);
						log.info("Record is updated successfully");
						log.info("Communities_Transportation_Edit_Test method ends here ........... ");
						Assert.assertTrue(true);
						// }
					} else {
						log.info("Record is not updated successfully");
						log.info("Communities_Transportation_Edit_Test method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Transportation_Edit_Test method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

				// Transportation - VMT - Verify able to delete line item by using delete
			// button.
			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Transportation_SavePreviousYearData_CheckScore", priority = 302, enabled = true, description = "Transportation - VMT - Verify able to delete line item by using delete button.")
			public void Communities_Transportation_VMT_Delete_Row() {

				log.info("Communities_Transportation_VMT_Delete_Row method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000004409";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonVMT();
					//OldScore = CommunitiesPage.getTransportScore();
					
					flag = CommunitiesPage.Transportation_VMT_DeleteRow();

					if (flag) {

						log.info("Record is deleted successfully");
						log.info("Communities_Transportation_VMT_Delete_Row method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not deleted successfully");
						log.info("Communities_Transportation_VMT_Delete_Row method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Transportation_VMT_Delete_Row method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Transportation->VMT - Verify filter button - From (Start date) and To (End
			// date) uopens up decade calendar and on selecting any year range, the line
			// items falling into those year should be displayed.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
					"Communities_Transportation_SavePreviousYearData_CheckScore" }, priority = 303, enabled = true, description = "Transportation->VMT - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
			public void Transportation_VMT_FilterTest() {

				log.info("Communities_Transportation_VMT_FilterTest method started......................... ");
				int OldScore;
				//CommonMethod.switchToDefaultContent();

				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Perf4");
				// ProjectCommunitiesID="8000004525";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonVMT();
					//OldScore = CommunitiesPage.getTransportScore();
					flag = CommunitiesPage.CheckTransportationFilter();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Transportation_VMT_FilterTest method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Transportation_VMT_FilterTest method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Transportation --> VMT --> Verify 'Comments' section by adding comment should
			// show correct timestamp.
			// Transportation --> VMT -->'Activity' section should show correct activity
			// with date and
			// timestamp.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 304, enabled = true, description = "Transportation --> VMT -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
			public void Communities_Transportation_VMT_Comments_Activity_Test() {

				log.info("Communities_Transportation_VMT_Comments_Activity_Test method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000004527";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					String ProfileUserName = HomePage.getCurrentProfileUserName();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();				
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonVMT();
					// OldScore = CommunitiesPage.getTransportScore();
					flag = CommunitiesPage.checkTransportCommentAndActivity(data.getCellData("Communities", 15, 2), ProfileUserName);

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}
				if (flag) {
					log.info("Communities_Transportation_VMT_Comments_Activity_Test method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Transportation_VMT_Comments_Activity_Test method ends here ........... ");
					Assert.assertTrue(false);
				}
			}
			
			
			// ****************************Quality of Life -- > Health & Safety: Median air
			// quality index (AQI) Test Cases*************************
			// Verify for Health & Safety: Median air quality index (AQI) gets added by
			// default with "Data" ad "Details" tab.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 310, enabled = true, description = "Verify for Health & Safety: Median air quality index (AQI) gets added by default with Data and Details tab.")
			public void Communities_Health_Safety_With_DataAndDetails_Display() {

				log.info("Communities_Health_Safety_With_DataAndDetails_Display method started......................... ");
				//CommonMethod.switchToDefaultContent();

				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}
				// System.setProperty("CommunitiesProject_NonLeed2","8000004525");
				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004564";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonHealthAndSafety();
					flag = CommunitiesPage.CheckHealthAndSafety_Data_DetailsTab_Display();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Health_Safety_With_DataAndDetails_Display method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Health_Safety_With_DataAndDetails_Display method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Verify 'Add year' button adds line item with year for previous year.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Health_Safety_With_DataAndDetails_Display", priority = 310, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
			public void Communities_Health_Safety_AddYear_AddNewLine() {

				log.info("Communities_Health_Safety_AddYear_AddNewLine method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004564";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonHealthAndSafety();
					flag = CommunitiesPage.CheckHealthAndSafety_AddYear_NewRow_Display();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Health_Safety_AddYear_AddNewLine method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Health_Safety_AddYear_AddNewLine method ends here ........... ");
					Assert.assertTrue(false);
				}
			}
			
			// Verify validation Message after adding Invalid value(501)

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Health_Safety_AddYear_AddNewLine", priority = 310, enabled = true, description = "Verify validation Message after adding Invalid value(501)")
			public void Communities_Health_Safety_CheckWithInvalidValue() {

				log.info("Communities_Health_Safety_CheckWithInvalidValue method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				//ProjectCommunitiesID="8000006844";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonHealthAndSafety();
					flag = CommunitiesPage.CheckHealthAndSafety_CheckWithInvalidValue();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Health_Safety_CheckWithInvalidValue method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Health_Safety_CheckWithInvalidValue method ends here ........... ");
					Assert.assertTrue(false);
				}
			}
			// Quality Of Life--> Health And Safety - Verify by adding value to reading and clicking on save button for previous year

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Health_Safety_AddYear_AddNewLine", priority = 311, enabled = true, description = "Quality Of Life --> Health & Safety: Median air quality index (AQI) - >Verify by adding value to reading and clicking on save button for previous year  ")
			public void Communities_HealthAndSafety_SavePreviousYearData() {

				log.info("Communities_HealthAndSafety_SavePreviousYearData method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004564";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonHealthAndSafety();
					flag = CommunitiesPage.CheckHealthAndSafety_SaveNewRecord();

					if (flag) {
						/*
						 * HomePage.setHomePageApplication();
						 * ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						 * HomePage.closeProjectSearchTextBox(); CommunitiesPage.ClickonDataInput();
						 * CommonMethod.switchToDataInputFrame(); CommunitiesPage.ClickonGHGEmiissions();
						 * 
						 * NewScore = CommunitiesPage.getEnergyScore();
						 */
						// if (NewScore > OldScore) {
						// log.info("Score is updated with---" + NewScore);
						log.info("Communities_HealthAndSafety_SavePreviousYearData method ends here ........... ");
						Assert.assertTrue(true);
						// }
					} else {
						log.info("Record is not added successfully");
						log.info("Communities_HealthAndSafety_SavePreviousYearData method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_HealthAndSafety_SavePreviousYearData method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			
			// Quality Of Life--> Health And Safety - >Verify 'previous year' and 'next
				// year' button adds reading respectively.

				@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 311, dependsOnMethods = "Communities_HealthAndSafety_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Health And Safety - > Verify 'previous year' and 'next year' button adds reading respectively.")
				public void Communities_HealthAndSafety_AddRow_PreviousYear_NextYear() {

					log.info("Communities_HealthAndSafety_AddRow_PreviousYear_NextYear method started......................... ");
					int OldScore;
					//CommonMethod.switchToDefaultContent();
					//CommunitiesPage = new CommunitiesPageObject();
					boolean flag = false;

					try {
						HomePage.setHomePageApplication();

					} catch (Exception e) {
						HomePage.setHomePageApplication();
						e.printStackTrace();
					}

					String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
					// ProjectCommunitiesID="8000004564";
					if (!ProjectCommunitiesID.equals(null)) {
						ProjectPage = HomePage.clickOnProject();
						CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						HomePage.closeProjectSearchTextBox();				
						CommunitiesPage.ClickonDataInput();
						CommonMethod.switchToDataInputFrame();
						CommunitiesPage.ClickonHealthAndSafety();
						flag = CommunitiesPage.HealthAndSafety_SavePreviousAndNextYearRecord();
						if (flag) {
							log.info("Communities_HealthAndSafety_AddRow_PreviousYear_NextYear method ends here ........... ");
							Assert.assertTrue(true);

						} else {
							log.info("Record is not added successfully");
							log.info("Communities_HealthAndSafety_AddRow_PreviousYear_NextYear method ends here ........... ");
							Assert.assertTrue(false);
						}

					} else {
						log.info("Communities Project is showing Null");
						log.info("Communities_HealthAndSafety_AddRow_PreviousYear_NextYear method ends here ........... ");
						Assert.assertTrue(false);
					}

				}

			// Quality Of Life--> Health And Safety - Verify able to edit readings by using
			// 'Edit' button.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 312, dependsOnMethods = "Communities_HealthAndSafety_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Health And Safety - >Verify able to edit readings by using 'Edit' button.")

			public void Communities_HealthAndSafety_Edit_Test() {

				log.info("Communities_HealthAndSafety_Edit_Test method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004564";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonHealthAndSafety();
					flag = CommunitiesPage.CheckHealthAndSafety_EditRecord();

					if (flag) {
						/*
						 * HomePage.setHomePageApplication();
						 * ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						 * HomePage.closeProjectSearchTextBox(); CommunitiesPage.ClickonDataInput();
						 * CommonMethod.switchToDataInputFrame(); CommunitiesPage.ClickonGHGEmiissions();
						 * 
						 * NewScore = CommunitiesPage.getEnergyScore();
						 */
						// if (NewScore > OldScore) {
						// log.info("Score is updated with---" + NewScore);
						log.info("Record is updated successfully");
						log.info("Communities_HealthAndSafety_Edit_Test method ends here ........... ");
						Assert.assertTrue(true);
						// }
					} else {
						log.info("Record is not updated successfully");
						log.info("Communities_HealthAndSafety_Edit_Test method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_HealthAndSafety_Edit_Test method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			
			// Quality Of Life--> Health And Safety - Verify able to delete line item by
			// using delete button.
			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_HealthAndSafety_SavePreviousYearData", priority = 313, enabled = true, description = "Quality Of Life--> Health And Safety - Verify able to delete line item by using delete button.")
			public void Communities_HealthAndSafety_Delete_Row() {

				log.info("Communities_HealthAndSafety_Delete_Row method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004564";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonHealthAndSafety();
					flag = CommunitiesPage.HealthAndSafety_DeleteRow();

					if (flag) {

						log.info("Record is deleted successfully");
						log.info("Communities_HealthAndSafety_Delete_Row method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not deleted successfully");
						log.info("Communities_HealthAndSafety_Delete_Row method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_HealthAndSafety_Delete_Row method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Health And Safety - Verify filter button - From (Start
			// date) and To (End date) uopens up decade calendar and on selecting any year
			// range, the line items falling into those year should be displayed.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 314, enabled = true, description = "Quality Of Life--> Health And Safety - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
			public void Communities_HealthAndSafey_FilterTest() {

				log.info("Communities_HealthAndSafey_FilterTest method started......................... ");
				int OldScore;
				//CommonMethod.switchToDefaultContent();

				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Perf4");
				// ProjectCommunitiesID="8000004565";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonHealthAndSafety();
					flag = CommunitiesPage.CheckHealthAndSafetyFilter();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_HealthAndSafey_FilterTest method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_HealthAndSafey_FilterTest method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Quality Of Life--> Health And Safety --> Verify 'Comments' section by adding
			// comment should show correct timestamp.
			// Quality Of Life--> Health And Safety -->'Activity' section should show
			// correct activity with date and
			// timestamp.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 314, enabled = false, description = "Quality Of Life--> Health And Safety -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
			public void Communities_HealthAndSafety_Comments_Activity_Test() {

				log.info("Communities_HealthAndSafety_Comments_Activity_Test method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000004527";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					String ProfileUserName = HomePage.getCurrentProfileUserName();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();				
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonHealthAndSafety();
					flag = CommunitiesPage.checkTransportCommentAndActivity(data.getCellData("Communities", 17, 2), ProfileUserName);

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}
				if (flag) {
					log.info("Communities_HealthAndSafety_Comments_Activity_Test method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_HealthAndSafety_Comments_Activity_Test method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// ****************************Quality of Life -- > Education: Population with
			// (at least) Bachelor's degree (%) Test Cases*************************
			// Verify for Education: Population with (at least) Bachelor's degree (%) gets
			// added by default with "Data" ad "Details" tab.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 318, enabled = true, description = "Verify for Education: Population with (at least) Bachelor's degree (%) gets added by default with Data and Details tab.")
			public void Communities_Education_Bachelor_Population_With_DataAndDetails_Display() {

				log.info(
						"Communities_Education_Bachelor_Population_With_DataAndDetails_Display method started......................... ");
				//CommonMethod.switchToDefaultContent();

				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}
				// System.setProperty("CommunitiesProject_NonLeed2","8000004525");
				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004565";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEducation_BachelorPopulation();
					flag = CommunitiesPage.CheckEducation_BachelorPopulation_Data_DetailsTab_Display();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Education_Bachelor_Population_With_DataAndDetails_Display method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Education_Bachelor_Population_With_DataAndDetails_Display method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Verify 'Add year' button adds line item with year for previous year.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Education_Bachelor_Population_With_DataAndDetails_Display", priority = 318, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
			public void Communities_Education_Bachelor_Population_AddYear_AddNewLine() {

				log.info("Communities_Education_Bachelor_Population_AddYear_AddNewLine method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004565";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEducation_BachelorPopulation();
					flag = CommunitiesPage.CheckEducation_Bachelor_Population_AddYear_NewRow_Display();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Education_Bachelor_Population_AddYear_AddNewLine method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Education_Bachelor_Population_AddYear_AddNewLine method ends here ........... ");
					Assert.assertTrue(false);
				}
			}
			
			
			// Verify validation Message after adding Invalid Percent value(101).

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup",dependsOnMethods = "Communities_Education_Bachelor_Population_AddYear_AddNewLine", priority = 318, enabled = true, description = "Verify validation Message after adding Invalid Percent value(101)")
			public void Communities_Education_Bachelor_Population_SaveWithInvalidPercent() {

				log.info("Communities_Education_Bachelor_Population_SaveWithInvalidPercent method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000006844";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEducation_BachelorPopulation();
					flag = CommunitiesPage.CheckEducation_Bachelor_Population_CheckWithInvalidPercent();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Education_Bachelor_Population_SaveWithInvalidPercent method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Education_Bachelor_Population_SaveWithInvalidPercent method ends here ........... ");
					Assert.assertTrue(false);
				}
			}
			// Quality Of Life--> Education: Population with (at least) Bachelor's degree
			// (%) - Verify by adding value to reading and clicking on save button for previous year

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Education_Bachelor_Population_AddYear_AddNewLine", priority = 319, enabled = true, description = "Quality Of Life --> Education: Population with (at least) Bachelor's degree (%) - >Verify by adding value to reading and clicking on save button for previous year  ")
			public void Communities_Education_Bachelor_Population_SavePreviousYearData() {

				log.info(
						"Communities_Education_Bachelor_Population_SavePreviousYearData method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004565";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEducation_BachelorPopulation();
					flag = CommunitiesPage.CheckEductaion_Bachelor_Population_SaveNewRecord();

					if (flag) {
						/*
						 * HomePage.setHomePageApplication();
						 * ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						 * HomePage.closeProjectSearchTextBox(); CommunitiesPage.ClickonDataInput();
						 * CommonMethod.switchToDataInputFrame(); CommunitiesPage.ClickonGHGEmiissions();
						 * 
						 * NewScore = CommunitiesPage.getEnergyScore();
						 */
						// if (NewScore > OldScore) {
						// log.info("Score is updated with---" + NewScore);
						log.info(
								"Communities_Education_Bachelor_Population_SavePreviousYearData method ends here ........... ");
						Assert.assertTrue(true);
						// }
					} else {
						log.info("Record is not added successfully");
						log.info(
								"Communities_Education_Bachelor_Population_SavePreviousYearData method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info(
							"Communities_Education_Bachelor_Population_SavePreviousYearData method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Education: Population with (at least) Bachelor's degree
			// (%) - >Verify 'previous year' and 'next year' button adds reading
			// respectively.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 319, dependsOnMethods = "Communities_Education_Bachelor_Population_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Education: Population with (at least) Bachelor's degree (%) - > Verify 'previous year' and 'next year' button adds reading respectively.")
			public void Communities_Education_Bachelor_Population_AddRow_PreviousYear_NextYear() {

				log.info(
						"Communities_Education_Bachelor_Population_AddRow_PreviousYear_NextYear method started......................... ");
				int OldScore;
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004565";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEducation_BachelorPopulation();
					flag = CommunitiesPage.Education_Bachelor_Population_SavePreviousAndNextYearRecord();
					if (flag) {
						log.info(
								"Communities_Education_Bachelor_Population_AddRow_PreviousYear_NextYear method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not added successfully");
						log.info(
								"Communities_Education_Bachelor_Population_AddRow_PreviousYear_NextYear method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Education_Bachelor_Population_AddRow_PreviousYear_NextYear method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Education: Population with (at least) Bachelor's degree
			// (%) - Verify able to edit readings by using 'Edit' button.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 320, dependsOnMethods = "Communities_Education_Bachelor_Population_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Education: Population with (at least) Bachelor's degree (%) - >Verify able to edit readings by using 'Edit' button.")

			public void Communities_Education_Bachelor_Population_Edit_Test() {

				log.info("Communities_Education_Bachelor_Population_Edit_Test method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004565";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEducation_BachelorPopulation();
					flag = CommunitiesPage.CheckEducation_Bachelor_population_EditRecord();

					if (flag) {
						/*
						 * HomePage.setHomePageApplication();
						 * ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						 * HomePage.closeProjectSearchTextBox(); CommunitiesPage.ClickonDataInput();
						 * CommonMethod.switchToDataInputFrame(); CommunitiesPage.ClickonGHGEmiissions();
						 * 
						 * NewScore = CommunitiesPage.getEnergyScore();
						 */
						// if (NewScore > OldScore) {
						// log.info("Score is updated with---" + NewScore);
						log.info("Record is updated successfully");
						log.info("Communities_Education_Bachelor_Population_Edit_Test method ends here ........... ");
						Assert.assertTrue(true);
						// }
					} else {
						log.info("Record is not updated successfully");
						log.info("Communities_Education_Bachelor_Population_Edit_Test method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Education_Bachelor_Population_Edit_Test method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Education: Population with (at least) Bachelor's degree
			// (%) - Verify able to delete line item by using delete button.
			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Education_Bachelor_Population_SavePreviousYearData", priority = 321, enabled = true, description = "Quality Of Life--> Education: Population with (at least) Bachelor's degree (%) - Verify able to delete line item by using delete button.")
			public void Communities_Education_Bachelor_Population_Delete_Row() {

				log.info("Communities_Education_Bachelor_Population_Delete_Row method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004565";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEducation_BachelorPopulation();
					flag = CommunitiesPage.Education_Bachelor_Population_DeleteRow();

					if (flag) {

						log.info("Record is deleted successfully");
						log.info("Communities_Education_Bachelor_Population_Delete_Row method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not deleted successfully");
						log.info("Communities_Education_Bachelor_Population_Delete_Row method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Education_Bachelor_Population_Delete_Row method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Education: Population with (at least) Bachelor's degree
			// (%) - Verify filter button - From (Start date) and To (End date) uopens up
			// decade calendar and on selecting any year range, the line items falling into
			// those year should be displayed.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 322, dependsOnMethods = "Communities_Education_Bachelor_Population_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Education: Population with (at least) Bachelor's degree (%) - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
			public void Communities_Education_Bachelor_Population_FilterTest() {

				log.info("Communities_Education_Bachelor_Population_FilterTest method started......................... ");
				int OldScore;
				//CommonMethod.switchToDefaultContent();

				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Perf4");
				// ProjectCommunitiesID="8000004564";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEducation_BachelorPopulation();
					flag = CommunitiesPage.CheckEducation_Bachelor_Population_Filter();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Education_Bachelor_Population_FilterTest method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Education_Bachelor_Population_FilterTest method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Quality Of Life--> Education: Population with (at least) Bachelor's degree
			// (%) --> Verify 'Comments' section by adding comment should show correct
			// timestamp.
			// Quality Of Life--> Education: Population with (at least) Bachelor's degree
			// (%) -->'Activity' section should show correct activity with date and
			// timestamp.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 322, enabled = false, description = "Quality Of Life--> Health And Safety -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
			public void Communities_Education_Bachelor_Population_Comments_Activity_Test() {

				log.info("Communities_Education_Bachelor_Population_Comments_Activity_Test method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000004527";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					String ProfileUserName = HomePage.getCurrentProfileUserName();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();				
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEducation_BachelorPopulation();
					flag = CommunitiesPage.checkTransportCommentAndActivity(data.getCellData("Communities", 19, 2), ProfileUserName);

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}
				if (flag) {
					log.info("Communities_HealthAndSafety_Comments_Activity_Test method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_HealthAndSafety_Comments_Activity_Test method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// ****************************Quality of Life -- > Equitability: Gini
			// coefficient (for income distribution) Test Cases*************************
			// Verify for Equitability: Gini coefficient (for income distribution) gets
			// added by default with "Data" ad "Details" tab.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 327, enabled = true, description = "Verify for Equitability: Gini coefficient (for income distribution) gets added by default with Data and Details tab.")
			public void Communities_Equitability_Gini_Coefficient_With_DataAndDetails_Display() {

				log.info(
						"Communities_Equitability_Gini_Coefficient_With_DataAndDetails_Display method started......................... ");
				//	CommonMethod.switchToDefaultContent();

				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}
				// System.setProperty("CommunitiesProject_NonLeed2","8000004525");
				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004564";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEquitability_Gini_Coeffiecient();
					flag = CommunitiesPage.CheckEquitability_Gini_Coefficient_Data_DetailsTab_Display();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Equitability_Gini_Coefficient_With_DataAndDetails_Display method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Equitability_Gini_Coefficient_With_DataAndDetails_Display method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Verify 'Add year' button adds line item with year for previous year.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Equitability_Gini_Coefficient_With_DataAndDetails_Display", priority = 327, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
			public void Communities_Equitability_Gini_Coefficient_AddYear_AddNewLine() {

				log.info("Communities_Equitability_Gini_Coefficient_AddYear_AddNewLine method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004564";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEquitability_Gini_Coeffiecient();
					flag = CommunitiesPage.CheckEquitability_Gini_Coefficient_AddYear_NewRow_Display();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Equitability_Gini_Coefficient_AddYear_AddNewLine method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Equitability_Gini_Coefficient_AddYear_AddNewLine method ends here ........... ");
					Assert.assertTrue(false);
				}
			}
			
			
			// Verify validation Message after adding Invalid value(Test Data - 2)

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Equitability_Gini_Coefficient_AddYear_AddNewLine", priority = 327, enabled = true, description = "Verify validation Message after adding Invalid value(Test Data - 2)")
			public void Communities_Equitability_Gini_Coefficient_SaveWithInvalidValue() {

				log.info("Communities_Equitability_Gini_Coefficient_SaveWithInvalidValue method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				//ProjectCommunitiesID="8000006868";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEquitability_Gini_Coeffiecient();
					flag = CommunitiesPage.CheckEquitability_Gini_Coefficient_CheckWithInvalidValue();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Equitability_Gini_Coefficient_SaveWithInvalidValue method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Equitability_Gini_Coefficient_SaveWithInvalidValue method ends here ........... ");
					Assert.assertTrue(false);
				}
			}
			// Quality Of Life--> Equitability: Gini coefficient (for income distribution) -
			// Verify by adding value to reading and clicking on save button for previous year

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Equitability_Gini_Coefficient_AddYear_AddNewLine", priority = 328, enabled = true, description = "Quality Of Life --> Equitability: Gini coefficient (for income distribution) - >Verify by adding value to reading and clicking on save button for previous year  ")
			public void Communities_Equitability_Gini_Coefficient_SavePreviousYearData() {

				log.info(
						"Communities_Equitability_Gini_Coefficient_SavePreviousYearData method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004564";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEquitability_Gini_Coeffiecient();
					flag = CommunitiesPage.CheckEquitability_Gini_Coefficient_SaveNewRecord();

					if (flag) {
						/*
						 * HomePage.setHomePageApplication();
						 * ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						 * HomePage.closeProjectSearchTextBox(); CommunitiesPage.ClickonDataInput();
						 * CommonMethod.switchToDataInputFrame(); CommunitiesPage.ClickonGHGEmiissions();
						 * 
						 * NewScore = CommunitiesPage.getEnergyScore();
						 */
						// if (NewScore > OldScore) {
						// log.info("Score is updated with---" + NewScore);
						log.info(
								"Communities_Equitability_Gini_Coefficient_SavePreviousYearData method ends here ........... ");
						Assert.assertTrue(true);
						// }
					} else {
						log.info("Record is not added successfully");
						log.info(
								"Communities_Equitability_Gini_Coefficient_SavePreviousYearData method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info(
							"Communities_Equitability_Gini_Coefficient_SavePreviousYearData method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Equitability: Gini coefficient (for income distribution) -
			// >Verify 'previous year' and 'next year' button adds reading respectively.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 328, dependsOnMethods = "Communities_Equitability_Gini_Coefficient_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Equitability: Gini coefficient (for income distribution) - > Verify 'previous year' and 'next year' button adds reading respectively.")
			public void Communities_Equitability_Gini_Coefficient_AddRow_PreviousYear_NextYear() {

				log.info(
						"Communities_Equitability_Gini_Coefficient_AddRow_PreviousYear_NextYear method started......................... ");
				int OldScore;
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004564";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEquitability_Gini_Coeffiecient();
					flag = CommunitiesPage.Equitability_Gini_Coefficient_SavePreviousAndNextYearRecord();
					if (flag) {
						log.info(
								"Communities_Equitability_Gini_Coefficient_AddRow_PreviousYear_NextYear method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not added successfully");
						log.info(
								"Communities_Equitability_Gini_Coefficient_AddRow_PreviousYear_NextYear method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Equitability_Gini_Coefficient_AddRow_PreviousYear_NextYear method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Equitability: Gini coefficient (for income distribution) -
			// Verify able to edit readings by using 'Edit' button.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 329, dependsOnMethods = "Communities_Equitability_Gini_Coefficient_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Equitability: Gini coefficient (for income distribution) - >Verify able to edit readings by using 'Edit' button.")

			public void Communities_Equitability_Gini_Coefficient_Edit_Test() {

				log.info("Communities_Equitability_Gini_Coefficient_Edit_Test method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004564";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEquitability_Gini_Coeffiecient();
					flag = CommunitiesPage.CheckEquitability_Gini_Coefficient_EditRecord();

					if (flag) {
						/*
						 * HomePage.setHomePageApplication();
						 * ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						 * HomePage.closeProjectSearchTextBox(); CommunitiesPage.ClickonDataInput();
						 * CommonMethod.switchToDataInputFrame(); CommunitiesPage.ClickonGHGEmiissions();
						 * 
						 * NewScore = CommunitiesPage.getEnergyScore();
						 */
						// if (NewScore > OldScore) {
						// log.info("Score is updated with---" + NewScore);
						log.info("Record is updated successfully");
						log.info("Communities_Equitability_Gini_Coefficient_Edit_Test method ends here ........... ");
						Assert.assertTrue(true);
						// }
					} else {
						log.info("Record is not updated successfully");
						log.info("Communities_Equitability_Gini_Coefficient_Edit_Test method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Equitability_Gini_Coefficient_Edit_Test method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Equitability: Gini coefficient (for income distribution) -
			// Verify able to delete line item by using delete button.
			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Equitability_Gini_Coefficient_SavePreviousYearData", priority = 330, enabled = true, description = "Quality Of Life--> Equitability: Gini coefficient (for income distribution) - Verify able to delete line item by using delete button.")
			public void Communities_Equitability_Gini_Coefficient_Delete_Row() {

				log.info("Communities_Equitability_Gini_Coefficient_Delete_Row method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004564";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEquitability_Gini_Coeffiecient();
					flag = CommunitiesPage.Equitability_Gini_Coefficient_DeleteRow();

					if (flag) {

						log.info("Record is deleted successfully");
						log.info("Communities_Equitability_Gini_Coefficient_Delete_Row method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not deleted successfully");
						log.info("Communities_Equitability_Gini_Coefficient_Delete_Row method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Equitability_Gini_Coefficient_Delete_Row method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Equitability: Gini coefficient (for income distribution) -
			// Verify filter button - From (Start date) and To (End date) uopens up decade
			// calendar and on selecting any year range, the line items falling into those
			// year should be displayed.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 331, dependsOnMethods = "Communities_Equitability_Gini_Coefficient_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Equitability: Gini coefficient (for income distribution) - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
			public void Communities_Equitability_Gini_Coefficient_FilterTest() {

				log.info("Communities_Equitability_Gini_Coefficient_FilterTest method started......................... ");
				int OldScore;
				//CommonMethod.switchToDefaultContent();

				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Perf4");
				// ProjectCommunitiesID="8000004565";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEquitability_Gini_Coeffiecient();
					flag = CommunitiesPage.CheckEquitability_Gini_Coefficient_Filter();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Equitability_Gini_Coefficient_FilterTest method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Equitability_Gini_Coefficient_FilterTest method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Quality Of Life--> Equitability: Gini coefficient (for income distribution)
			// --> Verify 'Comments' section by adding comment should show correct
			// timestamp.
			// Quality Of Life--> Equitability: Gini coefficient (for income distribution)
			// -->'Activity' section should show correct activity with date and
			// timestamp.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 331, enabled = false, description = "Quality Of Life--> Equitability: Gini coefficient (for income distribution)  -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
			public void Communities_Equitability_Gini_Coefficient_Comments_Activity_Test() {

				log.info("Communities_Equitability_Gini_Coefficient_Comments_Activity_Test method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000004527";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					String ProfileUserName = HomePage.getCurrentProfileUserName();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();				
					CommonMethod.switchToDataInputFrame();
					
					CommunitiesPage.ClickonEquitability_Gini_Coeffiecient();
					flag = CommunitiesPage.checkTransportCommentAndActivity(data.getCellData("Communities", 21, 2), ProfileUserName);

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}
				if (flag) {
					log.info("Communities_Equitability_Gini_Coefficient_Comments_Activity_Test method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Equitability_Gini_Coefficient_Comments_Activity_Test method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// ****************************Quality of Life -- > Education: Population with
			// (at least) High School degree (%) Test Cases*************************
			// Verify for Education: Population with (at least) High School degree (%) gets
			// added by default with "Data" ad "Details" tab.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 335, enabled = true, description = "Verify for Education: Population with (at least) High School degree (%) gets added by default with Data and Details tab.")
			public void Communities_Education_HighSchoolPopulation_With_DataAndDetails_Display() {

				log.info(
						"Communities_Education_HighSchoolPopulation_With_DataAndDetails_Display method started......................... ");
				//CommonMethod.switchToDefaultContent();

				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}
				// System.setProperty("CommunitiesProject_NonLeed2","8000004525");
				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004564";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEducation_HighSchoolPopulation();
					flag = CommunitiesPage.CheckEducation_HighSchoolPopulation_Data_DetailsTab_Display();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Education_HighSchoolPopulation_With_DataAndDetails_Display method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Education_HighSchoolPopulation_With_DataAndDetails_Display method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Verify 'Add year' button adds line item with year for previous year.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Education_HighSchoolPopulation_With_DataAndDetails_Display", priority = 335, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
			public void Communities_Education_HighSchoolPopulation_AddYear_AddNewLine() {

				log.info("Communities_Education_HighSchoolPopulation_AddYear_AddNewLine method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004564";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEducation_HighSchoolPopulation();
					flag = CommunitiesPage.CheckEducation_HighSchoolPopulation_AddYear_NewRow_Display();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Education_HighSchoolPopulation_AddYear_AddNewLine method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Education_HighSchoolPopulation_AddYear_AddNewLine method ends here ........... ");
					Assert.assertTrue(false);
				}
			}
			
			
			// Verify validation Message after adding Invalid Percent value(Test Data - 101)

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Education_HighSchoolPopulation_AddYear_AddNewLine", priority = 335, enabled = true, description = "Verify validation Message after adding Invalid Percent value(Test Data - 101)")
			public void Communities_Education_HighSchoolPopulation_SaveWithInvalidPercent() {

				log.info("Communities_Education_HighSchoolPopulation_SaveWithInvalidPercent method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000006868";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEducation_HighSchoolPopulation();
					flag = CommunitiesPage.CheckEducation_HighSchoolPopulation_CheckWithInvalidPercent();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Education_HighSchoolPopulation_SaveWithInvalidPercent method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Education_HighSchoolPopulation_SaveWithInvalidPercent method ends here ........... ");
					Assert.assertTrue(false);
				}
			}
			// Quality Of Life--> Education: Population with (at least) High School degree
			// (%) - Verify by adding value to reading and clicking on save button for previous year

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Education_HighSchoolPopulation_AddYear_AddNewLine", priority = 336, enabled = true, description = "Quality Of Life --> Education: Population with (at least) High School degree (%) - >Verify by adding value to reading and clicking on save button for previous year  ")
			public void Communities_Education_HighSchoolPopulation_SavePreviousYearData() {

				log.info(
						"Communities_Education_HighSchoolPopulation_SavePreviousYearData method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004564";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEducation_HighSchoolPopulation();
					flag = CommunitiesPage.CheckEducation_HighSchoolPopulation_SaveNewRecord();

					if (flag) {
						/*
						 * HomePage.setHomePageApplication();
						 * ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						 * HomePage.closeProjectSearchTextBox(); CommunitiesPage.ClickonDataInput();
						 * CommonMethod.switchToDataInputFrame(); CommunitiesPage.ClickonGHGEmiissions();
						 * 
						 * NewScore = CommunitiesPage.getEnergyScore();
						 */
						// if (NewScore > OldScore) {
						// log.info("Score is updated with---" + NewScore);
						log.info(
								"Communities_Education_HighSchoolPopulation_SavePreviousYearData method ends here ........... ");
						Assert.assertTrue(true);
						// }
					} else {
						log.info("Record is not added successfully");
						log.info(
								"Communities_Education_HighSchoolPopulation_SavePreviousYearData method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info(
							"Communities_Education_HighSchoolPopulation_SavePreviousYearData method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Education: Population with (at least) High School degree
			// (%) - >Verify 'previous year' and 'next year' button adds reading
			// respectively.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 336, dependsOnMethods = "Communities_Education_HighSchoolPopulation_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Education: Population with (at least) High School degree (%) - > Verify 'previous year' and 'next year' button adds reading respectively.")
			public void Communities_Education_HighSchoolPopulation_AddRow_PreviousYear_NextYear() {

				log.info(
						"Communities_Education_HighSchoolPopulation_AddRow_PreviousYear_NextYear method started......................... ");
				int OldScore;
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004564";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEducation_HighSchoolPopulation();
					flag = CommunitiesPage.Education_HighSchoolPopulation_SavePreviousAndNextYearRecord();
					if (flag) {
						log.info(
								"Communities_Education_HighSchoolPopulation_AddRow_PreviousYear_NextYear method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not added successfully");
						log.info(
								"Communities_Education_HighSchoolPopulation_AddRow_PreviousYear_NextYear method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Education_HighSchoolPopulation_AddRow_PreviousYear_NextYear method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Education: Population with (at least) High School degree
			// (%) - Verify able to edit readings by using 'Edit' button.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 337, dependsOnMethods = "Communities_Education_HighSchoolPopulation_SavePreviousYearData", enabled = true, description = "Quality Of Life-->Education: Population with (at least) High School degree (%)  - >Verify able to edit readings by using 'Edit' button.")

			public void Communities_Education_HighSchoolPopulation_Edit_Test() {

				log.info("Communities_Education_HighSchoolPopulation_Edit_Test method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004564";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEducation_HighSchoolPopulation();
					flag = CommunitiesPage.CheckEducation_HighSchoolPopulation_EditRecord();

					if (flag) {
						/*
						 * HomePage.setHomePageApplication();
						 * ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						 * HomePage.closeProjectSearchTextBox(); CommunitiesPage.ClickonDataInput();
						 * CommonMethod.switchToDataInputFrame(); CommunitiesPage.ClickonGHGEmiissions();
						 * 
						 * NewScore = CommunitiesPage.getEnergyScore();
						 */
						// if (NewScore > OldScore) {
						// log.info("Score is updated with---" + NewScore);
						log.info("Record is updated successfully");
						log.info("Communities_Education_HighSchoolPopulation_Edit_Test method ends here ........... ");
						Assert.assertTrue(true);
						// }
					} else {
						log.info("Record is not updated successfully");
						log.info("Communities_Education_HighSchoolPopulation_Edit_Test method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Education_HighSchoolPopulation_Edit_Test method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Education: Population with (at least) High School degree
			// (%) - Verify able to delete line item by using delete button.
			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Education_HighSchoolPopulation_SavePreviousYearData", priority = 338, enabled = true, description = "Quality Of Life--> Education: Population with (at least) High School degree (%) - Verify able to delete line item by using delete button.")
			public void Communities_Education_HighSchoolPopulation_Delete_Row() {

				log.info("Communities_Education_HighSchoolPopulation_Delete_Row method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004564";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEducation_HighSchoolPopulation();
					flag = CommunitiesPage.Education_HighSchoolPopulation_DeleteRow();

					if (flag) {

						log.info("Record is deleted successfully");
						log.info("Communities_Education_HighSchoolPopulation_Delete_Row method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not deleted successfully");
						log.info("Communities_Education_HighSchoolPopulation_Delete_Row method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Education_HighSchoolPopulation_Delete_Row method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Education: Population with (at least) High School degree
			// (%) - Verify filter button - From (Start date) and To (End date) uopens up
			// decade calendar and on selecting any year range, the line items falling into
			// those year should be displayed.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 339, enabled = true, description = "Quality Of Life--> Education: Population with (at least) High School degree (%) - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
			public void Communities_Education_HighSchoolPopulation_FilterTest() {

				log.info("Communities_Education_HighSchoolPopulation_FilterTest method started......................... ");
				int OldScore;
				//CommonMethod.switchToDefaultContent();

				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Perf4");
				// ProjectCommunitiesID="8000004565";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEducation_HighSchoolPopulation();
					flag = CommunitiesPage.CheckEducation_HighSchoolPopulation_Filter();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Education_HighSchoolPopulation_FilterTest method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Education_HighSchoolPopulation_FilterTest method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Quality Of Life--> Education: Population with (at least) High School degree
			// (%) --> Verify 'Comments' section by adding comment should show correct
			// timestamp.
			// Quality Of Life--> Education: Population with (at least) High School degree
			// (%) -->'Activity' section should show correct activity with date and
			// timestamp.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 339, enabled = false, description = "Quality Of Life--> Education: Population with (at least) High School degree (%)  -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
			public void Communities_Equitability_Gini_Coefficient_Comments_Activity_Test1() {

				log.info("Communities_Equitability_Gini_Coefficient_Comments_Activity_Test method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000004527";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					String ProfileUserName = HomePage.getCurrentProfileUserName();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();				
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEquitability_Gini_Coeffiecient();
					// OldScore = CommunitiesPage.getTransportScore();
			
					flag = CommunitiesPage.checkTransportCommentAndActivity(data.getCellData("Communities", 23, 2), ProfileUserName);

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}
				if (flag) {
					log.info("Communities_Equitability_Gini_Coefficient_Comments_Activity_Test method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Equitability_Gini_Coefficient_Comments_Activity_Test method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

		//****************************Quality of Life -- >	Prosperity: Median household income (US Dollars/Year) Test Cases*************************
			// Verify for Prosperity: Median household income (US Dollars/Year) gets added
			// by default with "Data" ad "Details" tab.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 344, enabled = true, description = "Verify for Prosperity: Median household income (US Dollars/Year) gets added by default with Data and Details tab.")
			public void Communities_ProsperityMedianIncome_With_DataAndDetails_Display() {

				log.info("Communities_ProsperityMedianIncome_With_DataAndDetails_Display method started......................... ");
			//	CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}
				// System.setProperty("CommunitiesProject_NonLeed2","8000004525");
				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004567";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonProsperity_MedianIncome();
					flag = CommunitiesPage.CheckProsperityMedianIncome_Data_DetailsTab_Display();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_ProsperityMedianIncome_With_DataAndDetails_Display method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_ProsperityMedianIncome_With_DataAndDetails_Display method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Verify 'Add year' button adds line item with year for previous year.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_ProsperityMedianIncome_With_DataAndDetails_Display", priority = 344, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
			public void Communities_ProsperityMedianIncome_AddYear_AddNewLine() {

				log.info("Communities_ProsperityMedianIncome_AddYear_AddNewLine method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004567";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonProsperity_MedianIncome();
					flag = CommunitiesPage.CheckProsperityMedianIncome_AddYear_NewRow_Display();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_ProsperityMedianIncome_AddYear_AddNewLine method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_ProsperityMedianIncome_AddYear_AddNewLine method ends here ........... ");
					Assert.assertTrue(false);
				}
			}
			// Quality Of Life--> Prosperity: Median household income (US Dollars/Year) -
			// Verify by adding value to reading and clicking on save button for previous year

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_ProsperityMedianIncome_AddYear_AddNewLine", priority = 344, enabled = true, description = "Quality Of Life --> Prosperity: Median household income (US Dollars/Year) - >Verify by adding value to reading and clicking on save button for previous year  ")
			public void Communities_ProsperityMedianIncome_SavePreviousYearData() {

				log.info(
						"Communities_ProsperityMedianIncome_SavePreviousYearData method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004567";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonProsperity_MedianIncome();
					flag = CommunitiesPage.CheckProsperityMedianIncome_SaveNewRecord();

					if (flag) {
						/*
						 * HomePage.setHomePageApplication();
						 * ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						 * HomePage.closeProjectSearchTextBox(); CommunitiesPage.ClickonDataInput();
						 * CommonMethod.switchToDataInputFrame(); CommunitiesPage.ClickonGHGEmiissions();
						 * 
						 * NewScore = CommunitiesPage.getEnergyScore();
						 */
						// if (NewScore > OldScore) {
						// log.info("Score is updated with---" + NewScore);
						log.info("Communities_ProsperityMedianIncome_SavePreviousYearData method ends here ........... ");
						Assert.assertTrue(true);
						// }
					} else {
						log.info("Record is not added successfully");
						log.info("Communities_ProsperityMedianIncome_SavePreviousYearData method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_ProsperityMedianIncome_SavePreviousYearData method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Prosperity: Median household income (US Dollars/Year) -
			// >Verify 'previous year' and 'next year' button adds reading respectively.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 344, dependsOnMethods = "Communities_ProsperityMedianIncome_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Prosperity: Median household income (US Dollars/Year)  - > Verify 'previous year' and 'next year' button adds reading respectively.")
			public void Communities_ProsperityMedianIncome_AddRow_PreviousYear_NextYear() {

				log.info("Communities_ProsperityMedianIncome_AddRow_PreviousYear_NextYear method started......................... ");
				int OldScore;
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004567";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonProsperity_MedianIncome();
					flag = CommunitiesPage.ProsperityMedianIncome_SavePreviousAndNextYearRecord();
					if (flag) {
						log.info("Communities_ProsperityMedianIncome_AddRow_PreviousYear_NextYear method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not added successfully");
						log.info("Communities_ProsperityMedianIncome_AddRow_PreviousYear_NextYear method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_ProsperityMedianIncome_AddRow_PreviousYear_NextYear method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Prosperity: Median household income (US Dollars/Year) -
			// Verify able to edit readings by using 'Edit' button.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 345, dependsOnMethods = "Communities_ProsperityMedianIncome_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Prosperity: Median household income (US Dollars/Year)   - >Verify able to edit readings by using 'Edit' button.")

			public void Communities_ProsperityMedianIncome_Edit_Test() {

				log.info("Communities_ProsperityMedianIncome_Edit_Test method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004567";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonProsperity_MedianIncome();
					flag = CommunitiesPage.CheckProsperityMedianIncome_EditRecord();

					if (flag) {
						/*
						 * HomePage.setHomePageApplication();
						 * ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						 * HomePage.closeProjectSearchTextBox(); CommunitiesPage.ClickonDataInput();
						 * CommonMethod.switchToDataInputFrame(); CommunitiesPage.ClickonGHGEmiissions();
						 * 
						 * NewScore = CommunitiesPage.getEnergyScore();
						 */
						// if (NewScore > OldScore) {
						// log.info("Score is updated with---" + NewScore);
						log.info("Record is updated successfully");
						log.info("Communities_ProsperityMedianIncome_Edit_Test method ends here ........... ");
						Assert.assertTrue(true);
						// }
					} else {
						log.info("Record is not updated successfully");
						log.info("Communities_ProsperityMedianIncome_Edit_Test method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_ProsperityMedianIncome_Edit_Test method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Prosperity: Median household income (US Dollars/Year) -
			// Verify able to delete line item by using delete button.
			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_ProsperityMedianIncome_SavePreviousYearData", priority = 346, enabled = true, description = "Quality Of Life--> Prosperity: Median household income (US Dollars/Year) - Verify able to delete line item by using delete button.")
			public void Communities_ProsperityMedianIncome_Delete_Row() {

				log.info("Communities_ProsperityMedianIncome_Delete_Row method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004567";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonProsperity_MedianIncome();
					flag = CommunitiesPage.ProsperityMedianIncome_DeleteRow();

					if (flag) {

						log.info("Record is deleted successfully");
						log.info("Communities_ProsperityMedianIncome_Delete_Row method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not deleted successfully");
						log.info("Communities_ProsperityMedianIncome_Delete_Row method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_ProsperityMedianIncome_Delete_Row method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Prosperity: Median household income (US Dollars/Year) -
			// Verify filter button - From (Start date) and To (End date) uopens up decade
			// calendar and on selecting any year range, the line items falling into those
			// year should be displayed.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_ProsperityMedianIncome_SavePreviousYearData", priority = 347, enabled = true, description = "Quality Of Life--> Prosperity: Median household income (US Dollars/Year) - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
			public void Communities_ProsperityMedianIncome_FilterTest() {

				log.info("Communities_ProsperityMedianIncome_FilterTest method started......................... ");
				int OldScore;
				//CommonMethod.switchToDefaultContent();

				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Perf4");
				// ProjectCommunitiesID="8000004568";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonProsperity_MedianIncome();
					flag = CommunitiesPage.CheckProsperityMedianIncome_Filter();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_ProsperityMedianIncome_FilterTest method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_ProsperityMedianIncome_FilterTest method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Quality Of Life--> Prosperity: Median household income (US Dollars/Year) -->
			// Verify 'Comments' section by adding comment should show correct timestamp.
			// Quality Of Life--> Prosperity: Median household income (US Dollars/Year)
			// -->'Activity' section should show correct activity with date and
			// timestamp.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 348, enabled = false, description = "Quality Of Life--> Prosperity: Median household income (US Dollars/Year)  -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
			public void Communities_ProsperityMedianIncome_Comments_Activity_Test() {

				log.info("Communities_ProsperityMedianIncome_Comments_Activity_Test method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000004527";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					String ProfileUserName = HomePage.getCurrentProfileUserName();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();				
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEquitability_Gini_Coeffiecient();
					
					flag = CommunitiesPage.checkTransportCommentAndActivity(data.getCellData("Communities", 25, 2), ProfileUserName);

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}
				if (flag) {
					log.info("Communities_ProsperityMedianIncome_Comments_Activity_Test method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_ProsperityMedianIncome_Comments_Activity_Test method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

		//****************************Quality of Life -- >	Equitability: Median gross rent as (%) of household income Test Cases*************************
			// Verify for Equitability: Median gross rent as (%) of household income gets
			// added by default with "Data" ad "Details" tab.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 353, enabled = true, description = "Verify for Equitability: Median gross rent as (%) of household income gets added by default with Data and Details tab.")
			public void Communities_Equitability_MedianGrossIncome_With_DataAndDetails_Display() {

				log.info(
						"Communities_Equitability_MedianGrossIncome_With_DataAndDetails_Display method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}
				// System.setProperty("CommunitiesProject_NonLeed2","8000004525");
				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004567";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEquitability_MedianGrossIncome();
					flag = CommunitiesPage.CheckEquitability_MedianGrossIncome_Data_DetailsTab_Display();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Equitability_MedianGrossIncome_With_DataAndDetails_Display method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Equitability_MedianGrossIncome_With_DataAndDetails_Display method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Verify 'Add year' button adds line item with year for previous year.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Equitability_MedianGrossIncome_With_DataAndDetails_Display", priority = 353, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
			public void Communities_Equitability_MedianGrossIncome_AddYear_AddNewLine() {

				log.info("Communities_Equitability_MedianGrossIncome_AddYear_AddNewLine method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004567";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEquitability_MedianGrossIncome();
					flag = CommunitiesPage.CheckEquitability_MedianGrossIncome_AddYear_NewRow_Display();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Equitability_MedianGrossIncome_AddYear_AddNewLine method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Equitability_MedianGrossIncome_AddYear_AddNewLine method ends here ........... ");
					Assert.assertTrue(false);
				}
			}
			
			
			// Verify validation Message after adding Invalid Percent value(Test Data - 101)

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Equitability_MedianGrossIncome_AddYear_AddNewLine", priority = 353, enabled = true, description = "Verify validation Message after adding Invalid Percent value(Test Data - 101)")
			public void Communities_Equitability_MedianGrossIncome_SaveWithInvalidPercent() {

				log.info("Communities_Equitability_MedianGrossIncome_SaveWithInvalidPercent method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000006868";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEquitability_MedianGrossIncome();
					flag = CommunitiesPage.CheckEquitability_MedianGrossIncome_CheckWithInvalidPercentValue();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Equitability_MedianGrossIncome_SaveWithInvalidPercent method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Equitability_MedianGrossIncome_SaveWithInvalidPercent method ends here ........... ");
					Assert.assertTrue(false);
				}
			}
			// Quality Of Life--> Equitability: Median gross rent as (%) of household income
			// - Verify by adding value to reading and clicking on save button for previous year

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Equitability_MedianGrossIncome_AddYear_AddNewLine", priority = 354, enabled = true, description = "Quality Of Life --> Equitability: Median gross rent as (%) of household income - >Verify by adding value to reading and clicking on save button for previous year  ")
			public void Communities_Equitability_MedianGrossIncome_SavePreviousYearData() {

				log.info(
						"Communities_Equitability_MedianGrossIncome_SavePreviousYearData method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004567";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEquitability_MedianGrossIncome();
					flag = CommunitiesPage.CheckEquitability_MedianGrossIncome_SaveNewRecord();

					if (flag) {
						/*
						 * HomePage.setHomePageApplication();
						 * ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						 * HomePage.closeProjectSearchTextBox(); CommunitiesPage.ClickonDataInput();
						 * CommonMethod.switchToDataInputFrame(); CommunitiesPage.ClickonGHGEmiissions();
						 * 
						 * NewScore = CommunitiesPage.getEnergyScore();
						 */
						// if (NewScore > OldScore) {
						// log.info("Score is updated with---" + NewScore);
						log.info(
								"Communities_Equitability_MedianGrossIncome_SavePreviousYearData method ends here ........... ");
						Assert.assertTrue(true);
						// }
					} else {
						log.info("Record is not added successfully");
						log.info(
								"Communities_Equitability_MedianGrossIncome_SavePreviousYearData method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info(
							"Communities_Equitability_MedianGrossIncome_SavePreviousYearData method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Equitability: Median gross rent as (%) of household income
			// - >Verify 'previous year' and 'next year' button adds reading respectively.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 354, dependsOnMethods = "Communities_Equitability_MedianGrossIncome_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Equitability: Median gross rent as (%) of household income  - > Verify 'previous year' and 'next year' button adds reading respectively.")
			public void Communities_Equitability_MedianGrossIncome_AddRow_PreviousYear_NextYear() {

				log.info(
						"Communities_Equitability_MedianGrossIncome_AddRow_PreviousYear_NextYear method started......................... ");
				int OldScore;
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004567";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEquitability_MedianGrossIncome();
					flag = CommunitiesPage.Equitability_MedianGrossIncome_SavePreviousAndNextYearRecord();
					if (flag) {
						log.info(
								"Communities_Equitability_MedianGrossIncome_AddRow_PreviousYear_NextYear method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not added successfully");
						log.info(
								"Communities_Equitability_MedianGrossIncome_AddRow_PreviousYear_NextYear method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Equitability_MedianGrossIncome_AddRow_PreviousYear_NextYear method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Equitability: Median gross rent as (%) of household income
			// - Verify able to edit readings by using 'Edit' button.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 355, dependsOnMethods = "Communities_Equitability_MedianGrossIncome_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Equitability: Median gross rent as (%) of household income   - >Verify able to edit readings by using 'Edit' button.")

			public void Communities_Equitability_MedianGrossIncome_Edit_Test() {

				log.info("Communities_Equitability_MedianGrossIncome_Edit_Test method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004567";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEquitability_MedianGrossIncome();
					flag = CommunitiesPage.CheckEquitability_MedianGrossIncome_EditRecord();

					if (flag) {
						/*
						 * HomePage.setHomePageApplication();
						 * ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						 * HomePage.closeProjectSearchTextBox(); CommunitiesPage.ClickonDataInput();
						 * CommonMethod.switchToDataInputFrame(); CommunitiesPage.ClickonGHGEmiissions();
						 * 
						 * NewScore = CommunitiesPage.getEnergyScore();
						 */
						// if (NewScore > OldScore) {
						// log.info("Score is updated with---" + NewScore);
						log.info("Record is updated successfully");
						log.info("Communities_Equitability_MedianGrossIncome_Edit_Test method ends here ........... ");
						Assert.assertTrue(true);
						// }
					} else {
						log.info("Record is not updated successfully");
						log.info("Communities_Equitability_MedianGrossIncome_Edit_Test method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Equitability_MedianGrossIncome_Edit_Test method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Equitability: Median gross rent as (%) of household income
			// - Verify able to delete line item by using delete button.
			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Equitability_MedianGrossIncome_SavePreviousYearData", priority = 356, enabled = true, description = "Quality Of Life--> Equitability: Median gross rent as (%) of household income - Verify able to delete line item by using delete button.")
			public void Communities_Equitability_MedianGrossIncome_Delete_Row() {

				log.info("Communities_Equitability_MedianGrossIncome_Delete_Row method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004567";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEquitability_MedianGrossIncome();
					flag = CommunitiesPage.Equitability_MedianGrossIncome_DeleteRow();

					if (flag) {

						log.info("Record is deleted successfully");
						log.info("Communities_Equitability_MedianGrossIncome_Delete_Row method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not deleted successfully");
						log.info("Communities_Equitability_MedianGrossIncome_Delete_Row method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_Equitability_MedianGrossIncome_Delete_Row method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Equitability: Median gross rent as (%) of household income
			// - Verify filter button - From (Start date) and To (End date) uopens up decade
			// calendar and on selecting any year range, the line items falling into those
			// year should be displayed.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_Equitability_MedianGrossIncome_SavePreviousYearData", priority = 357, enabled = true, description = "Quality Of Life--> Equitability: Median gross rent as (%) of household income - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
			public void Communities_Equitability_MedianGrossIncome_FilterTest() {

				log.info("Communities_Equitability_MedianGrossIncome_FilterTest method started......................... ");
				int OldScore;
				//CommonMethod.switchToDefaultContent();

				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Perf4");
				// ProjectCommunitiesID="8000004568";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEquitability_MedianGrossIncome();
					flag = CommunitiesPage.CheckEquitability_MedianGrossIncome_Filter();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_Equitability_MedianGrossIncome_FilterTest method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Equitability_MedianGrossIncome_FilterTest method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Quality Of Life--> Equitability: Median gross rent as (%) of household income
			// --> Verify 'Comments' section by adding comment should show correct
			// timestamp.
			// Quality Of Life--> Equitability: Median gross rent as (%) of household income
			// -->'Activity' section should show correct activity with date and
			// timestamp.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 357, enabled = false, description = "Quality Of Life--> Equitability: Median gross rent as (%) of household income  -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
			public void Communities_Equitability_MedianGrossIncome_Comments_Activity_Test() {

				log.info("Communities_Equitability_MedianGrossIncome_Comments_Activity_Test method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000004527";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					String ProfileUserName = HomePage.getCurrentProfileUserName();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();				
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonEquitability_MedianGrossIncome();
					flag = CommunitiesPage.checkTransportCommentAndActivity(data.getCellData("Communities", 27, 2), ProfileUserName);

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}
				if (flag) {
					log.info("Communities_Equitability_MedianGrossIncome_Comments_Activity_Test method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Equitability_MedianGrossIncome_Comments_Activity_Test method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

		//****************************Quality of Life -- >	Prosperity: Unemployment rate (%) Test Cases*************************
			// Verify for Prosperity: Unemployment rate (%) gets added by default with
			// "Data" ad "Details" tab.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 361, enabled = true, description = "Verify for Prosperity: Unemployment rate (%) gets added by default with Data and Details tab.")
			public void Communities_ProsperityUnemployementRate_With_DataAndDetails_Display() {

				log.info(
						"Communities_ProsperityUnemployementRate_With_DataAndDetails_Display method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}
				// System.setProperty("CommunitiesProject_NonLeed2","8000004525");
				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000006625";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonProsperityUnemployementRate();
					flag = CommunitiesPage.CheckProsperityUnemployementRate_Data_DetailsTab_Display();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_ProsperityUnemployementRate_With_DataAndDetails_Display method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_ProsperityUnemployementRate_With_DataAndDetails_Display method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Verify 'Add year' button adds line item with year for previous year.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_ProsperityUnemployementRate_With_DataAndDetails_Display", priority = 361, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
			public void Communities_ProsperityUnemployementRate_AddYear_AddNewLine() {

				log.info("Communities_ProsperityUnemployementRate_AddYear_AddNewLine method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000006625";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonProsperityUnemployementRate();
					flag = CommunitiesPage.CheckProsperityUnemployementRate_AddYear_NewRow_Display();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_ProsperityUnemployementRate_AddYear_AddNewLine method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_ProsperityUnemployementRate_AddYear_AddNewLine method ends here ........... ");
					Assert.assertTrue(false);
				}
			}
			

			// Verify validation Message after adding Invalid Percent value(Test Data - 101)


				@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_ProsperityUnemployementRate_AddYear_AddNewLine", priority = 361, enabled = true, description = "Verify validation Message after adding Invalid Percent value(Test Data - 101)")
				public void Communities_ProsperityUnemployementRate_SaveWithInvalidPercent() {

					log.info("Communities_ProsperityUnemployementRate_SaveWithInvalidPercent method started......................... ");
					//CommonMethod.switchToDefaultContent();
					//CommunitiesPage = new CommunitiesPageObject();
					boolean flag = false;

					try {
						HomePage.setHomePageApplication();

					} catch (Exception e) {
						HomePage.setHomePageApplication();
						e.printStackTrace();
					}

					String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
					//ProjectCommunitiesID="8000006848";
					if (!ProjectCommunitiesID.equals(null)) {
						ProjectPage = HomePage.clickOnProject();
						CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						HomePage.closeProjectSearchTextBox();				
						CommunitiesPage.ClickonDataInput();
						CommonMethod.switchToDataInputFrame();
						CommunitiesPage.ClickonProsperityUnemployementRate();
						flag = CommunitiesPage.CheckProsperityUnemployementRate_CheckWithInvalidValue();

					} else {
						log.info("Communities Project is showing Null");
						Assert.assertTrue(false);
					}

					if (flag) {
						log.info("Communities_ProsperityUnemployementRate_SaveWithInvalidPercent method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Communities_ProsperityUnemployementRate_SaveWithInvalidPercent method ends here ........... ");
						Assert.assertTrue(false);
					}
				}
			// Quality Of Life--> Prosperity: Unemployment rate (%) - Verify by adding value to reading and clicking on save button for previous year

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_ProsperityUnemployementRate_AddYear_AddNewLine", priority = 362, enabled = true, description = "Quality Of Life --> Prosperity: Unemployment rate (%) - >Verify by adding value to reading and clicking on save button for previous year  ")
			public void Communities_ProsperityUnemployementRate_SavePreviousYearData() {

				log.info(
						"Communities_ProsperityUnemployementRate_SavePreviousYearData method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000006625";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonProsperityUnemployementRate();
					flag = CommunitiesPage.CheckProsperityUnemployementRate_SaveNewRecord();

					if (flag) {
						/*
						 * HomePage.setHomePageApplication();
						 * ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						 * HomePage.closeProjectSearchTextBox(); CommunitiesPage.ClickonDataInput();
						 * CommonMethod.switchToDataInputFrame(); CommunitiesPage.ClickonGHGEmiissions();
						 * 
						 * NewScore = CommunitiesPage.getEnergyScore();
						 */
						// if (NewScore > OldScore) {
						// log.info("Score is updated with---" + NewScore);
						log.info(
								"Communities_ProsperityUnemployementRate_SavePreviousYearData method ends here ........... ");
						Assert.assertTrue(true);
						// }
					} else {
						log.info("Record is not added successfully");
						log.info(
								"Communities_ProsperityUnemployementRate_SavePreviousYearData method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_ProsperityUnemployementRate_SavePreviousYearData method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Prosperity: Unemployment rate (%) - >Verify 'previous
			// year' and 'next year' button adds reading respectively.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 362, dependsOnMethods = "Communities_ProsperityUnemployementRate_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Prosperity: Unemployment rate (%)  - > Verify 'previous year' and 'next year' button adds reading respectively.")
			public void Communities_ProsperityUnemployementRate_AddRow_PreviousYear_NextYear() {

				log.info(
						"Communities_ProsperityUnemployementRate_AddRow_PreviousYear_NextYear method started......................... ");
				int OldScore;
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000006795";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonProsperityUnemployementRate();
					flag = CommunitiesPage.ProsperityUnemployementRate_SavePreviousAndNextYearRecord();
					if (flag) {
						log.info("Communities_ProsperityUnemployementRate_AddRow_PreviousYear_NextYear method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not added successfully");
						log.info("Communities_ProsperityUnemployementRate_AddRow_PreviousYear_NextYear method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_ProsperityUnemployementRate_AddRow_PreviousYear_NextYear method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Prosperity: Unemployment rate (%) - Verify able to edit
			// readings by using 'Edit' button.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 363, dependsOnMethods = "Communities_ProsperityUnemployementRate_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Prosperity: Unemployment rate (%)   - >Verify able to edit readings by using 'Edit' button.")

			public void Communities_ProsperityUnemployementRate_Edit_Test() {

				log.info("Communities_ProsperityUnemployementRate_Edit_Test method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000006625";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonProsperityUnemployementRate();
					flag = CommunitiesPage.CheckProsperityUnemployementRate_EditRecord();

					if (flag) {
						/*
						 * HomePage.setHomePageApplication();
						 * ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						 * HomePage.closeProjectSearchTextBox(); CommunitiesPage.ClickonDataInput();
						 * CommonMethod.switchToDataInputFrame(); CommunitiesPage.ClickonGHGEmiissions();
						 * 
						 * NewScore = CommunitiesPage.getEnergyScore();
						 */
						// if (NewScore > OldScore) {
						// log.info("Score is updated with---" + NewScore);
						log.info("Record is updated successfully");
						log.info("Communities_ProsperityUnemployementRate_Edit_Test method ends here ........... ");
						Assert.assertTrue(true);
						// }
					} else {
						log.info("Record is not updated successfully");
						log.info("Communities_ProsperityUnemployementRate_Edit_Test method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_ProsperityUnemployementRate_Edit_Test method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Prosperity: Unemployment rate (%) - Verify able to delete
			// line item by using delete button.
			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_ProsperityUnemployementRate_SavePreviousYearData", priority = 364, enabled = true, description = "Quality Of Life--> Prosperity: Unemployment rate (%) - Verify able to delete line item by using delete button.")
			public void Communities_ProsperityUnemployementRate_Delete_Row() {

				log.info("Communities_ProsperityUnemployementRate_Delete_Row method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000006625";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonProsperityUnemployementRate();
					flag = CommunitiesPage.ProsperityUnemployementRate_DeleteRow();

					if (flag) {

						log.info("Record is deleted successfully");
						log.info("Communities_ProsperityUnemployementRate_Delete_Row method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not deleted successfully");
						log.info("Communities_ProsperityUnemployementRate_Delete_Row method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_ProsperityUnemployementRate_Delete_Row method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Prosperity: Unemployment rate (%) - Verify filter button -
			// From (Start date) and To (End date) uopens up decade calendar and on
			// selecting any year range, the line items falling into those year should be
			// displayed.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_ProsperityUnemployementRate_SavePreviousYearData", priority = 365, enabled = true, description = "Quality Of Life--> Prosperity: Unemployment rate (%) - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
			public void Communities_ProsperityUnemployementRate_FilterTest() {

				log.info("Communities_ProsperityUnemployementRate_FilterTest method started......................... ");
				int OldScore;
				//CommonMethod.switchToDefaultContent();

				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Perf4");
				// ProjectCommunitiesID="8000006626";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonProsperityUnemployementRate();
					flag = CommunitiesPage.CheckProsperityUnemployementRate_Filter();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_ProsperityUnemployementRate_FilterTest method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_ProsperityUnemployementRate_FilterTest method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Quality Of Life--> Prosperity: Unemployment rate (%) --> Verify 'Comments'
			// section by adding comment should show correct timestamp.
			// Quality Of Life--> Prosperity: Unemployment rate (%) -->'Activity' section
			// should show correct activity with date and
			// timestamp.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 365, enabled = false, description = "Quality Of Life--> Prosperity: Unemployment rate (%)  -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
			public void Communities_ProsperityUnemployementRate_Comments_Activity_Test() {

				log.info("Communities_ProsperityUnemployementRate_Comments_Activity_Test method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				//ProjectCommunitiesID = "8000004568";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					String ProfileUserName = HomePage.getCurrentProfileUserName();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();				
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonProsperityUnemployementRate();
					flag = CommunitiesPage.checkProsperityUnemployementRate(data.getCellData("Communities", 29, 2), ProfileUserName);

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}
				if (flag) {
					log.info("Communities_ProsperityUnemployementRate_Comments_Activity_Test method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_ProsperityUnemployementRate_Comments_Activity_Test method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// ****************************Quality of Life -- > Health & Safety: Air quality
			// days unhealthy for sensitive groups (Days/yr) Test
			// Cases*************************
			// Verify for Health & Safety: Air quality days unhealthy for sensitive groups
			// (Days/yr) gets added by default with "Data" ad "Details" tab.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 370, enabled = true, description = "Verify for Health & Safety: Air quality days unhealthy for sensitive groups (Days/yr) gets added by default with Data and Details tab.")
			public void Communities_HealthAndSafetySensitiveGroup_With_DataAndDetails_Display() {

				log.info(
						"Communities_HealthAndSafetySensitiveGroup_With_DataAndDetails_Display method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}
				// System.setProperty("CommunitiesProject_NonLeed2","8000004525");
				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004567";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonHealthAndSafetySensitiveGroup();
					flag = CommunitiesPage.CheckHealthAndSafetySensitiveGroup_Data_DetailsTab_Display();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_HealthAndSafetySensitiveGroup_With_DataAndDetails_Display method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_HealthAndSafetySensitiveGroup_With_DataAndDetails_Display method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Verify 'Add year' button adds line item with year for previous year.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_HealthAndSafetySensitiveGroup_With_DataAndDetails_Display", priority = 370, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
			public void Communities_HealthAndSafetySensitiveGroup_AddYear_AddNewLine() {

				log.info("Communities_HealthAndSafetySensitiveGroup_AddYear_AddNewLine method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004567";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonHealthAndSafetySensitiveGroup();
					flag = CommunitiesPage.CheckHealthAndSafetySensitiveGroup_AddYear_NewRow_Display();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("CheckHealthAndSafetySensitiveGroup_AddYear_NewRow_Display method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_HealthAndSafetySensitiveGroup_AddYear_AddNewLine method ends here ........... ");
					Assert.assertTrue(false);
				}
			}
			
			// Verify validation Message after adding Invalid value(Test Data - 366)


						@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 370, dependsOnMethods = "Communities_HealthAndSafetySensitiveGroup_AddYear_AddNewLine", enabled = true, description = "Verify validation Message after adding Invalid value(Test Data - 366)")
						public void Communities_HealthAndSafetySensitiveGroup_SaveWithInvalidValue() {

							log.info("Communities_HealthAndSafetySensitiveGroup_SaveWithInvalidValue method started......................... ");
							//CommonMethod.switchToDefaultContent();
							//CommunitiesPage = new CommunitiesPageObject();
							boolean flag = false;

							try {
								HomePage.setHomePageApplication();

							} catch (Exception e) {
								HomePage.setHomePageApplication();
								e.printStackTrace();
							}

							String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
							// ProjectCommunitiesID="8000006844";
							if (!ProjectCommunitiesID.equals(null)) {
								ProjectPage = HomePage.clickOnProject();
								CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
								HomePage.closeProjectSearchTextBox();				
								CommunitiesPage.ClickonDataInput();
								CommonMethod.switchToDataInputFrame();
								CommunitiesPage.ClickonHealthAndSafetySensitiveGroup();
								flag = CommunitiesPage.CheckHealthAndSafetySensitiveGroup_CheckWithInvalidValue();

							} else {
								log.info("Communities Project is showing Null");
								Assert.assertTrue(false);
							}

							if (flag) {
								log.info("Communities_HealthAndSafetySensitiveGroup_SaveWithInvalidValue method ends here ........... ");
								Assert.assertTrue(true);

							} else {
								log.info("Communities_HealthAndSafetySensitiveGroup_SaveWithInvalidValue method ends here ........... ");
								Assert.assertTrue(false);
							}
						}
			// Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive
			// groups (Days/yr) - Verify by adding value to reading and clicking on save button for previous year

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_HealthAndSafetySensitiveGroup_AddYear_AddNewLine", priority = 371, enabled = true, description = "Quality Of Life --> Health & Safety: Air quality days unhealthy for sensitive groups (Days/yr) - >Verify by adding value to reading and clicking on save button for previous year ")
			public void Communities_HealthAndSafetySensitiveGroup_SavePreviousYearData() {

				log.info(
						"Communities_HealthAndSafetySensitiveGroup_SavePreviousYearData method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004567";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonHealthAndSafetySensitiveGroup();
					flag = CommunitiesPage.CheckHealthAndSafetySensitiveGroup_SaveNewRecord();

					if (flag) {
						/*
						 * HomePage.setHomePageApplication();
						 * ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						 * HomePage.closeProjectSearchTextBox(); CommunitiesPage.ClickonDataInput();
						 * CommonMethod.switchToDataInputFrame(); CommunitiesPage.ClickonGHGEmiissions();
						 * 
						 * NewScore = CommunitiesPage.getEnergyScore();
						 */
						// if (NewScore > OldScore) {
						// log.info("Score is updated with---" + NewScore);
						log.info(
								"Communities_HealthAndSafetySensitiveGroup_SavePreviousYearData method ends here ........... ");
						Assert.assertTrue(true);
						// }
					} else {
						log.info("Record is not added successfully");
						log.info(
								"Communities_HealthAndSafetySensitiveGroup_SavePreviousYearData method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info(
							"Communities_HealthAndSafetySensitiveGroup_SavePreviousYearData method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive
			// groups (Days/yr) - >Verify 'previous year' and 'next year' button adds
			// reading respectively.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 371, dependsOnMethods = "Communities_HealthAndSafetySensitiveGroup_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive groups (Days/yr)  - > Verify 'previous year' and 'next year' button adds reading respectively.")
			public void Communities_HealthAndSafetySensitiveGroup_AddRow_PreviousYear_NextYear() {

				log.info(
						"Communities_HealthAndSafetySensitiveGroup_AddRow_PreviousYear_NextYear method started......................... ");
				int OldScore;
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004567";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonHealthAndSafetySensitiveGroup();
					flag = CommunitiesPage.HealthAndSafetySensitiveGroup_SavePreviousAndNextYearRecord();
					if (flag) {
						log.info(
								"Communities_HealthAndSafetySensitiveGroup_AddRow_PreviousYear_NextYear method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not added successfully");
						log.info(
								"Communities_HealthAndSafetySensitiveGroup_AddRow_PreviousYear_NextYear method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_HealthAndSafetySensitiveGroup_AddRow_PreviousYear_NextYear method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive
			// groups (Days/yr) - Verify able to edit readings by using 'Edit' button.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 372, dependsOnMethods = "Communities_HealthAndSafetySensitiveGroup_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive groups (Days/yr)   - >Verify able to edit readings by using 'Edit' button.")

			public void Communities_HealthAndSafetySensitiveGroup_Edit_Test() {

				log.info("Communities_HealthAndSafetySensitiveGroup_Edit_Test method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004567";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonHealthAndSafetySensitiveGroup();
					flag = CommunitiesPage.CheckHealthAndSafetySensitiveGroup_EditRecord();

					if (flag) {
						/*
						 * HomePage.setHomePageApplication();
						 * ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						 * HomePage.closeProjectSearchTextBox(); CommunitiesPage.ClickonDataInput();
						 * CommonMethod.switchToDataInputFrame(); CommunitiesPage.ClickonGHGEmiissions();
						 * 
						 * NewScore = CommunitiesPage.getEnergyScore();
						 */
						// if (NewScore > OldScore) {
						// log.info("Score is updated with---" + NewScore);
						log.info("Record is updated successfully");
						log.info("Communities_HealthAndSafetySensitiveGroup_Edit_Test method ends here ........... ");
						Assert.assertTrue(true);
						// }
					} else {
						log.info("Record is not updated successfully");
						log.info("Communities_HealthAndSafetySensitiveGroup_Edit_Test method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_HealthAndSafetySensitiveGroup_Edit_Test method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive
			// groups (Days/yr) - Verify able to delete line item by using delete button.
			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_HealthAndSafetySensitiveGroup_SavePreviousYearData", priority = 373, enabled = true, description = "Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive groups (Days/yr) - Verify able to delete line item by using delete button.")
			public void Communities_HealthAndSafetySensitiveGroup_Delete_Row() {

				log.info("Communities_HealthAndSafetySensitiveGroup_Delete_Row method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004567";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonHealthAndSafetySensitiveGroup();
					flag = CommunitiesPage.HealthAndSafetySensitiveGroup_DeleteRow();

					if (flag) {

						log.info("Record is deleted successfully");
						log.info("Communities_HealthAndSafetySensitiveGroup_Delete_Row method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not deleted successfully");
						log.info("Communities_HealthAndSafetySensitiveGroup_Delete_Row method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_HealthAndSafetySensitiveGroup_Delete_Row method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive
			// groups (Days/yr) - Verify filter button - From (Start date) and To (End date)
			// uopens up decade calendar and on selecting any year range, the line items
			// falling into those year should be displayed.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_HealthAndSafetySensitiveGroup_SavePreviousYearData", priority = 374, enabled = true, description = "Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive groups (Days/yr) - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
			public void Communities_HealthAndSafetySensitiveGroup_FilterTest() {

				log.info("Communities_HealthAndSafetySensitiveGroup_FilterTest method started......................... ");
				int OldScore;
				//CommonMethod.switchToDefaultContent();

				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Perf4");
				// ProjectCommunitiesID="8000004568";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonHealthAndSafetySensitiveGroup();
					flag = CommunitiesPage.CheckHealthAndSafetySensitiveGroup_Filter();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_HealthAndSafetySensitiveGroup_FilterTest method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_HealthAndSafetySensitiveGroup_FilterTest method ends here ........... ");
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

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 374, enabled = false, description = "Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive groups (Days/yr)  -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
			public void Communities_Communities_HealthAndSafetySensitiveGroup_Comments_Activity_Test() {

				log.info(
						"Communities_Communities_HealthAndSafetySensitiveGroup_Comments_Activity_Test method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000004568";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					String ProfileUserName = HomePage.getCurrentProfileUserName();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();				
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonHealthAndSafetySensitiveGroup();
					flag = CommunitiesPage.checkHealthAndSafetySensitiveGroup(data.getCellData("Communities", 31, 2), ProfileUserName);

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}
				if (flag) {
					log.info("Communities_Communities_HealthAndSafetySensitiveGroup_Comments_Activity_Test method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_Communities_HealthAndSafetySensitiveGroup_Comments_Activity_Test method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// ****************************Quality of Life -- > Health & Safety: Violent
			// Crime (per year per capita) Test Cases*************************
			// Verify for Health & Safety: Violent Crime (per year per capita) gets added by
			// default with "Data" ad "Details" tab.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 379, enabled = true, description = "Verify for Health & Safety: Violent Crime (per year per capita) gets added by default with Data and Details tab.")
			public void Communities_HealthAndSafetyVoilentCrime_With_DataAndDetails_Display() {

				log.info(
						"Communities_HealthAndSafetyVoilentCrime_With_DataAndDetails_Display method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}
				// System.setProperty("CommunitiesProject_NonLeed2","8000004525");
				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004567";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonHealthAndSafetyVoilentCrime();
					flag = CommunitiesPage.CheckHealthAndSafetyVoilentCrime_Data_DetailsTab_Display();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_HealthAndSafetyVoilentCrime_With_DataAndDetails_Display method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_HealthAndSafetyVoilentCrime_With_DataAndDetails_Display method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Verify 'Add year' button adds line item with year for previous year.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_HealthAndSafetyVoilentCrime_With_DataAndDetails_Display", priority = 379, enabled = true, description = "Verify 'Add year' button adds line item with year for previous year.")
			public void Communities_HealthAndSafetyVoilentCrime_AddYear_AddNewLine() {

				log.info("Communities_HealthAndSafetyVoilentCrime_AddYear_AddNewLine method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004567";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonHealthAndSafetyVoilentCrime();
					flag = CommunitiesPage.CheckHealthAndSafetyVoilentCrime_AddYear_NewRow_Display();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_HealthAndSafetyVoilentCrime_AddYear_AddNewLine method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_HealthAndSafetyVoilentCrime_AddYear_AddNewLine method ends here ........... ");
					Assert.assertTrue(false);
				}
			}
			// Quality Of Life--> Health & Safety: Violent Crime (per year per capita) -
			// Verify by adding value to reading and clicking on save button for previous year

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_HealthAndSafetyVoilentCrime_AddYear_AddNewLine", priority = 379, enabled = true, description = "Quality Of Life --> Health & Safety: Violent Crime (per year per capita) - >Verify by adding value to reading and clicking on save button for previous year  ")
			public void Communities_HealthAndSafetyVoilentCrime_SavePreviousYearData() {

				log.info(
						"Communities_HealthAndSafetyVoilentCrime_SavePreviousYearData method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004567";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonHealthAndSafetyVoilentCrime();
					flag = CommunitiesPage.CheckHealthAndSafetyVoilentCrime_SaveNewRecord();

					if (flag) {
						/*
						 * HomePage.setHomePageApplication();
						 * ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						 * HomePage.closeProjectSearchTextBox(); CommunitiesPage.ClickonDataInput();
						 * CommonMethod.switchToDataInputFrame(); CommunitiesPage.ClickonGHGEmiissions();
						 * 
						 * NewScore = CommunitiesPage.getEnergyScore();
						 */
						// if (NewScore > OldScore) {
						// log.info("Score is updated with---" + NewScore);
						log.info(
								"Communities_HealthAndSafetyVoilentCrime_SavePreviousYearData method ends here ........... ");
						Assert.assertTrue(true);
						// }
					} else {
						log.info("Record is not added successfully");
						log.info(
								"Communities_HealthAndSafetyVoilentCrime_SavePreviousYearData method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_HealthAndSafetyVoilentCrime_SavePreviousYearData method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Health & Safety: Violent Crime (per year per capita) -
			// >Verify 'previous year' and 'next year' button adds reading respectively.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 379, dependsOnMethods = "Communities_HealthAndSafetyVoilentCrime_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Health & Safety: Violent Crime (per year per capita)  - > Verify 'previous year' and 'next year' button adds reading respectively.")
			public void Communities_HealthAndSafetyVoilentCrime_AddRow_PreviousYear_NextYear() {

				log.info(
						"Communities_HealthAndSafetyVoilentCrime_AddRow_PreviousYear_NextYear method started......................... ");
				int OldScore;
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004567";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonHealthAndSafetyVoilentCrime();
					flag = CommunitiesPage.HealthAndSafetyVoilentCrime_SavePreviousAndNextYearRecord();
					if (flag) {
						log.info("Communities_HealthAndSafetyVoilentCrime_AddRow_PreviousYear_NextYear method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not added successfully");
						log.info("Communities_HealthAndSafetyVoilentCrime_AddRow_PreviousYear_NextYear method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_HealthAndSafetyVoilentCrime_AddRow_PreviousYear_NextYear method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Health & Safety: Violent Crime (per year per capita) -
			// Verify able to edit readings by using 'Edit' button.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 380, dependsOnMethods = "Communities_HealthAndSafetyVoilentCrime_SavePreviousYearData", enabled = true, description = "Quality Of Life--> Health & Safety: Violent Crime (per year per capita)   - >Verify able to edit readings by using 'Edit' button.")

			public void Communities_HealthAndSafetyVoilentCrime_Edit_Test() {

				log.info("Communities_HealthAndSafetyVoilentCrime_Edit_Test method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004567";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonHealthAndSafetyVoilentCrime();
					flag = CommunitiesPage.CheckHealthAndSafetyVoilentCrime_EditRecord();

					if (flag) {
						/*
						 * HomePage.setHomePageApplication();
						 * ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						 * HomePage.closeProjectSearchTextBox(); CommunitiesPage.ClickonDataInput();
						 * CommonMethod.switchToDataInputFrame(); CommunitiesPage.ClickonGHGEmiissions();
						 * 
						 * NewScore = CommunitiesPage.getEnergyScore();
						 */
						// if (NewScore > OldScore) {
						// log.info("Score is updated with---" + NewScore);
						log.info("Record is updated successfully");
						log.info("Communities_HealthAndSafetyVoilentCrime_Edit_Test method ends here ........... ");
						Assert.assertTrue(true);
						// }
					} else {
						log.info("Record is not updated successfully");
						log.info("Communities_HealthAndSafetyVoilentCrime_Edit_Test method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_HealthAndSafetyVoilentCrime_Edit_Test method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Health & Safety: Violent Crime (per year per capita) -
			// Verify able to delete line item by using delete button.
			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_HealthAndSafetyVoilentCrime_SavePreviousYearData", priority = 381, enabled = true, description = "Quality Of Life--> Health & Safety: Violent Crime (per year per capita) - Verify able to delete line item by using delete button.")
			public void Communities_HealthAndSafetyVoilentCrime_Delete_Row() {

				log.info("Communities_HealthAndSafetyVoilentCrime_Delete_Row method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;
				int OldScore, NewScore;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
				// ProjectCommunitiesID="8000004567";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonHealthAndSafetyVoilentCrime();
					flag = CommunitiesPage.HealthAndSafetyVoilentCrime_DeleteRow();

					if (flag) {

						log.info("Record is deleted successfully");
						log.info("Communities_HealthAndSafetyVoilentCrime_Delete_Row method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Record is not deleted successfully");
						log.info("Communities_HealthAndSafetyVoilentCrime_Delete_Row method ends here ........... ");
						Assert.assertTrue(false);
					}

				} else {
					log.info("Communities Project is showing Null");
					log.info("Communities_HealthAndSafetyVoilentCrime_Delete_Row method ends here ........... ");
					Assert.assertTrue(false);
				}

			}

			// Quality Of Life--> Health & Safety: Violent Crime (per year per capita) -
			// Verify filter button - From (Start date) and To (End date) uopens up decade
			// calendar and on selecting any year range, the line items falling into those
			// year should be displayed.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Communities_HealthAndSafetyVoilentCrime_SavePreviousYearData", priority = 382, enabled = true, description = "Quality Of Life--> Health & Safety: Violent Crime (per year per capita) - Verify filter button - From (Start date) and To (End date) uopens up decade calendar and on selecting any year range, the line items falling into those year should be displayed.")
			public void Communities_HealthAndSafetyVoilentCrime_FilterTest() {

				log.info("Communities_HealthAndSafetyVoilentCrime_FilterTest method started......................... ");
				int OldScore;
				//CommonMethod.switchToDefaultContent();

				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Perf4");
				// ProjectCommunitiesID="8000004568";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonHealthAndSafetyVoilentCrime();
					flag = CommunitiesPage.CheckHealthAndSafetyVoilentCrime_Filter();

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}

				if (flag) {
					log.info("Communities_HealthAndSafetyVoilentCrime_FilterTest method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_HealthAndSafetyVoilentCrime_FilterTest method ends here ........... ");
					Assert.assertTrue(false);
				}
			}

			// Quality Of Life--> Health & Safety: Violent Crime (per year per capita) -->
			// Verify 'Comments' section by adding comment should show correct timestamp.
			// Quality Of Life--> Health & Safety: Violent Crime (per year per capita)
			// -->'Activity' section should show correct activity with date and
			// timestamp.

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 383, enabled = false, description = "Quality Of Life--> Health & Safety: Violent Crime (per year per capita)  -->Verify 'Comments' section by adding comment should show correct timestamp.\r\n Verify 'Activity' section should show correct activity with date and timestamp")
			public void Communities_HealthAndSafetyVoilentCrime_Comments_Activity_Test() {

				log.info("Communities_HealthAndSafetyVoilentCrime_Comments_Activity_Test method started......................... ");
				//CommonMethod.switchToDefaultContent();
				//CommunitiesPage = new CommunitiesPageObject();
				boolean flag = false;

				try {
					HomePage.setHomePageApplication();

				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}

				String ProjectCommunitiesID = System.getProperty("CommunitiesProject_NonLeed2");
				// ProjectCommunitiesID="8000004568";
				if (!ProjectCommunitiesID.equals(null)) {
					ProjectPage = HomePage.clickOnProject();
					String ProfileUserName = HomePage.getCurrentProfileUserName();
					CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
					HomePage.closeProjectSearchTextBox();				
					CommunitiesPage.ClickonDataInput();				
					CommonMethod.switchToDataInputFrame();
					CommunitiesPage.ClickonHealthAndSafetyVoilentCrime();
					flag = CommunitiesPage.checkHealthAndSafetyVoilentCrime(data.getCellData("Communities", 33, 2), ProfileUserName);

				} else {
					log.info("Communities Project is showing Null");
					Assert.assertTrue(false);
				}
				if (flag) {
					log.info("Communities_HealthAndSafetyVoilentCrime_Comments_Activity_Test method ends here ........... ");
					Assert.assertTrue(true);

				} else {
					log.info("Communities_HealthAndSafetyVoilentCrime_Comments_Activity_Test method ends here ........... ");
					Assert.assertTrue(false);
				}
			}		
				// --> Verify Qualty Of Life Score after entering previous year data

				@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 384, enabled = true, description = "Quality Of Life -->Verify Qualty Of Life Score after entering previous year data")
				public void Communities_Check_QualityOfLife_Score() {

					log.info("Communities_Check_QualityOfLife_Score method started......................... ");
					//CommonMethod.switchToDefaultContent();
					//CommunitiesPage = new CommunitiesPageObject();
					int QualityScore=0;
					boolean flag = false;

					try {
						HomePage.setHomePageApplication();

					} catch (Exception e) {
						HomePage.setHomePageApplication();
						e.printStackTrace();
					}

					String ProjectCommunitiesID = System.getProperty("CommunitiesProject_Private3");
					//ProjectCommunitiesID="8000006717";
					if (!ProjectCommunitiesID.equals(null)) {
						ProjectPage = HomePage.clickOnProject();
						CommunitiesPage = ProjectPage.SearchAndClickOnCommunitiesProject(ProjectCommunitiesID);
						HomePage.closeProjectSearchTextBox();				
						CommunitiesPage.ClickonDataInput();
						CommonMethod.switchToDataInputFrame();
						QualityScore = CommunitiesPage.getQualityOfLifeScore();
						
					} else {
						log.info("Communities Project is showing Null");
						Assert.assertTrue(false);
					}
					if (QualityScore >0) {
						log.info("Communities_Check_QualityOfLife_Score method ends here ........... ");
						Assert.assertTrue(true);

					} else {
						log.info("Communities_Check_QualityOfLife_Score method ends here ........... ");
						Assert.assertTrue(false);
					}
				}
			
}
