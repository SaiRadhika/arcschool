package com.arc.testCases.Project;

import java.io.File;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.arc.PageObject.Project.CityPageObject;
import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class CityPageTest extends BaseClass {

	private static Logger log = LoggerHelper.getLogger(CityPageTest.class);

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups={"Reboot"}, enabled = true, priority = 6)
	public void City_Agreement_Display() {
		log.info("City_Agreement_Display method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		// BuildingPage=ProjectPage.clickOnFirstProject();
		// System.out.println(data.getCellData("Reboot", 6, 2));
		CityPage = ProjectPage.SearchAndClickOnCityProject(data.getCellData("Reboot", 6, 2));
		CityPage.ClickonAgreementInManage();
		HomePage.closeProjectSearchTextBox();
		boolean flag = CommonMethod.CheckAgreementDisplay();

		if (flag) {
			log.info("City_Agreement_Display method completed ");
			Assert.assertTrue(true);
		} else {
			log.info("City_Agreement_Display method completed ");
			Assert.assertTrue(false);
		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "City_Agreement_Display",  groups={"Reboot"}, enabled = true, priority = 6)
	public void City_Agreement_Download() {
		log.info("City_Agreement_Download method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		// BuildingPage=ProjectPage.clickOnFirstProject();
		// System.out.println(data.getCellData("Reboot", 0, 2));
		CityPage = ProjectPage.SearchAndClickOnCityProject(data.getCellData("Reboot", 6, 2));
		CityPage.ClickonAgreementInManage();
		HomePage.closeProjectSearchTextBox();
		CommonMethod.ClikOnAgreementRegistrationDownloadLink();
		// BuildingPage.ClikOnAgreementDownloadLink();
		long FileLength = CommonMethod.CheckDownloadedFile();
		if (FileLength > 0) {
			for (File file : DownloadFolder.listFiles()) {
				file.delete();
			}
			DownloadFolder.delete();
			log.info("City_Agreement_Download method completed ");
			Assert.assertTrue(FileLength > 0);
		} else {
			log.info("City_Agreement_Download method completed ");
			Assert.assertTrue(false);
		}

	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups={"Reboot"}, enabled = true, priority = 6)
	public void City_LEEDIDProject_Download_Invoice() {

		log.info("City_LEEDIDProject_Download_Invoice method started ");		
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		System.out.println(data.getCellData("Reboot", 7, 2));
		CityPage = ProjectPage.SearchAndClickOnCityProject(data.getCellData("Reboot", 7, 2));
		CityPage.ClickonBillingInManage();
		HomePage.closeProjectSearchTextBox();
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

			@Test(dependsOnGroups = "LoginMethodTCGroup", groups = { "Reboot" }, enabled = true, priority = 6)
			public void City_Team_Add_Member() {

				log.info("City_Team_Add_Member method started ");
				HomePage.setHomePageApplication();
				ProjectPage = HomePage.clickOnProject();
				System.out.println(data.getCellData("Reboot", 6, 2));
				CityPage = ProjectPage.SearchAndClickOnCityProject(data.getCellData("Reboot", 6, 2));
				CityPage.ClickonTeamInManage();
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
						log.info("City_Team_Add_Member method completed .......................");
						Assert.assertTrue(true);
					} else {
						log.info(username + "  does not exist in the team member");
						log.info("City_Team_Add_Member method completed .......................");
						Assert.assertTrue(false);
					}
				} else {
					log.info(username + "  is not added successfully");
					log.info("City_Team_Add_Member method completed .......................");
					Assert.assertTrue(false);
				}

			}

			// Verify Manage-->It should allow to delete member from the added list

			@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
					"Reboot" }, dependsOnMethods = "City_Team_Add_Member", enabled = true, priority = 6)
			public void City_Team_Delete_Member() {
				
				log.info("City_Team_Delete_Member method started .......................");
				CommonMethod.RefreshPagewaitForPageLoaded(driver);
				HomePage.setHomePageApplication();
				ProjectPage = HomePage.clickOnProject();
				System.out.println(data.getCellData("Reboot", 6, 2));
				CityPage = ProjectPage.SearchAndClickOnCityProject(data.getCellData("Reboot", 6, 2));
				CityPage.ClickonTeamInManage();
				HomePage.closeProjectSearchTextBox();
				System.out.println();
				String username = data.getCellData("Reboot", 15, 2);
				boolean flag = CommonMethod.Team_Delete_Member(username);
				if (flag) {
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
				} else {
					log.info(username + " is not deleted successfully .......................");
					Assert.assertTrue(false);

				}

			}

		//*************************Regression Test Cases***********************************************
	

	@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 6,  enabled = false)
	public void City_AddRowInEnergy() {

		log.info("City_AddRowInEnergy method started ");
		HomePage.setHomePageApplication();
		ProjectPage = HomePage.clickOnProject();
		System.out.println(data.getCellData("Reboot", 8, 2));
		CityPage = ProjectPage.SearchAndClickOnCityProject(data.getCellData("Reboot", 7, 2));
		CityPage.ClickonBillingInManage();
		HomePage.closeProjectSearchTextBox();
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
			log.info("City_AddRowInEnergy method completed ");
			Assert.assertTrue(false);
		}
	}
	
	// Verify in DI, Project settings - population tab- Add row button adds a new line item with fields- 'Effective year', Population, Updated by followed by Save and delete button 
	
	@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup",priority = 4,  enabled = false)
	public void City_DI_ProjectSetting_Population_Add_Row() {

		log.info("City_DI_ProjectSetting_Population_Add_Row method started......................... ");
		CommonMethod.switchToDefaultContent();
		CityPage=new CityPageObject();
		boolean flag=false;
		try {
				HomePage.setHomePageApplication();
			
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		
		String ProjectCityID=System.getProperty("NonLEEDCItyProjectID");
		//ProjectCityID="8000004332";
		if(! ProjectCityID.equals(null))
		{
			ProjectPage = HomePage.clickOnProject();
			//CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			CityPage.ClickonDataInput();
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonProjectSetting();
			flag=CityPage.checkPopulation_AddRow_Header_Display();
			
		}
		else
		{
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if(flag)
		{
			Assert.assertTrue(true);
			log.info("City_DI_ProjectSetting_Population_Add_Row method ends here ........... ");
		}
		else
		{
			log.info("City_DI_ProjectSetting_Population_Add_Row method ends here ........... ");
			Assert.assertTrue(false);
			
		}
	}
	
	
	
	// Verify in DI, Project settings - ProjectArea tab- Add row button adds a new line item with fields- 'Effective year', Population, Updated by followed by Save and delete button 
	
		@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup",priority = 4,  enabled = false)
		public void City_ProjectSetting_ProjectArea_Add_Row() {

			log.info("City_ProjectSetting_ProjectArea_Add_Row method started......................... ");
			CommonMethod.switchToDefaultContent();
			CityPage=new CityPageObject();
			boolean flag=false;
			try {
					HomePage.setHomePageApplication();
				
			} catch (Exception e) {
				HomePage.setHomePageApplication();
				e.printStackTrace();
			}
			
			String ProjectCityID=System.getProperty("NonLEEDCItyProjectID");
			//ProjectCityID="8000004332";
			if(! ProjectCityID.equals(null))
			{
				ProjectPage = HomePage.clickOnProject();
				//CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
				CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
				CityPage.ClickonDataInput();
				HomePage.closeProjectSearchTextBox();
				CityPage.ClickonProjectSetting();
				flag=CityPage.checkProjectArea_AddRow_Header_Display();
			}
			else
			{
				log.info("City Project is showing Null");
				Assert.assertTrue(false);
			}
			if(flag)
			{
				Assert.assertTrue(true);
				log.info("City_ProjectSetting_ProjectArea_Add_Row method ends here ........... ");
			}
			else
			{
				log.info("City_ProjectSetting_ProjectArea_Add_Row method ends here ........... ");
				Assert.assertTrue(false);
				
			}
		}
		
	
	// Verify in DI, Project settings - population tab- Save One row button  
	// Decade Calender is showing proper or not
	
		@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup",priority = 4,  enabled = true)
		public void City_ProjectSetting_Population_Save_Row_DecadeCalender_Display() {

			log.info("City_ProjectSetting_Population_Save_Row_DecadeCalender_Display method started......................... ");
			CommonMethod.switchToDefaultContent();
			CityPage=new CityPageObject();
			boolean RowAddflag=false;
			boolean DecadeCalenderflag=false;
			try {
					HomePage.setHomePageApplication();
				
			} catch (Exception e) {
				HomePage.setHomePageApplication();
				e.printStackTrace();
			}
			
			String ProjectCityID=System.getProperty("NonLEEDCItyProjectID");
			//ProjectCityID="8000004341";
			if(! ProjectCityID.equals(null))
			{
				ProjectPage = HomePage.clickOnProject();
				//CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
				CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
				CityPage.ClickonDataInput();
				HomePage.closeProjectSearchTextBox();
				CityPage.ClickonProjectSetting();
				DecadeCalenderflag=CityPage.checkPopulation_Save_New_Row("40000");
				if(DecadeCalenderflag)
				{
					log.info("Decade Calender for Effective Year is showing proper..........");
				}
				else
				{
					log.info("Decade Calender for Effective Year is not showing proper..........");
				}
				
				CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
				CityPage.ClickonDataInput();
				HomePage.closeProjectSearchTextBox();
				CityPage.ClickonProjectSetting();
				RowAddflag=CityPage.verifyAddedProject_Setting_PopulationRow();
			}
			else
			{
				log.info("City Project is showing Null");
				Assert.assertTrue(false);
			}
			if((RowAddflag) && (DecadeCalenderflag))
			{
				log.info("City_ProjectSetting_Population_Save_Row_DecadeCalender_Display method ends here ........... ");
				Assert.assertTrue(true);
				
			}
			else
			{
				log.info("City_ProjectSetting_Population_Save_Row_DecadeCalender_Display method ends here ........... ");
				Assert.assertTrue(false);
			}
		}
		
		
		// Verify population field allows to add values followed by commas.
		
			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup",dependsOnMethods = "City_ProjectSetting_Population_Save_Row_DecadeCalender_Display", priority  = 4,  enabled = true)
			public void City_Population_Field_Comma_Display() {

				log.info("City_Population_Field_Comma_Display method started......................... ");
				CommonMethod.switchToDefaultContent();
				CityPage=new CityPageObject();
				boolean flag=false;
				boolean Commaflag=false;
				try {
						HomePage.setHomePageApplication();
					
				} catch (Exception e) {
					HomePage.setHomePageApplication();
					e.printStackTrace();
				}
				
				String ProjectCityID=System.getProperty("NonLEEDCItyProjectID");
				//ProjectCityID="8000004341";
				if(! ProjectCityID.equals(null))
				{
					ProjectPage = HomePage.clickOnProject();
					//CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
					CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
					CityPage.ClickonDataInput();
					HomePage.closeProjectSearchTextBox();
					CityPage.ClickonProjectSetting();					
					flag=CityPage.verifyAddedProject_Setting_PopulationRow();
				}
				else
				{
					log.info("City Project is showing Null");
					Assert.assertTrue(false);
				}
				if(flag)
				{
					Commaflag=CityPage.verifyPopulationField_Contains_Comma();
					if(Commaflag)
					{
						log.info("Population field contains Comma" );
						log.info("City_Population_Field_Comma_Display method ends here ........... ");
						Assert.assertTrue(true);
					}
					else
					{
						log.info("Population field does not contains Comma" );
						log.info("City_Population_Field_Comma_Display method ends here ........... ");
						Assert.assertTrue(false);
					}
					
				}
				else
				{
					log.info("Row is not added for this project, unable to check population field" );
					log.info("City_Population_Field_Comma_Display method ends here ........... ");
					Assert.assertTrue(false);
				}
			}
		
		
	// Verify after creating City Project with Gross Area as "Square Miles unit", check in Data Input – Project Setting - > Project Area Tab -> Unit Drop down by default value. 

	@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 4, enabled = false)
	public void City_Project_Area_GrossArea_SquareMiles_Display() {
		log.info("City_Project_Area_GrossArea_SquareMiles_Display method started ........... ");
		CommonMethod.switchToDefaultContent();
		CityPage=new CityPageObject();
		boolean flag=false;
		try {
				HomePage.setHomePageApplication();
			
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		
		String ProjectCityID=System.getProperty("NonLEEDCItyProjectID");
		ProjectCityID="8000004319";
		if(! ProjectCityID.equals(null))
		{
			ProjectPage = HomePage.clickOnProject();
			//CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			CityPage = ProjectPage.SearchAndClickOnCityProject(ProjectCityID);
			CityPage.ClickonDataInput();
			HomePage.closeProjectSearchTextBox();
			CityPage.ClickonProjectSetting();
			flag=CityPage.checkUnitTypeInProjectAreaUnderDataInput("sq miles");
			
		}
		else
		{
			log.info("City Project is showing Null");
			Assert.assertTrue(false);
		}
		if(flag)
		{
			Assert.assertTrue(true);
			log.info("City_Project_Area_GrossArea_SquareMiles_Display method ends here ........... ");
		}
		else
		{
			log.info("City_Project_Area_GrossArea_SquareMiles_Display method ends here ........... ");
			Assert.assertTrue(false);
			
		}
		
		
		
		
			
	}
	
	
	
	

}
