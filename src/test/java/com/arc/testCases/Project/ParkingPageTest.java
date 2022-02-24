package com.arc.testCases.Project;

import java.io.File;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.arc.PageObject.Project.ParkingPageObject;
import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class ParkingPageTest extends BaseClass {

	private static Logger log = LoggerHelper.getLogger(ParkingPageTest.class);

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, enabled = true, priority = 35, description = "Verify Manage-->Agreements should show the project agreement.")
	public void Parking_Agreement_Display() {
		log.info("Parking_Agreement_Display method started ");
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		ProjectPage = HomePage.clickOnProject();
		//BuildingPage=ProjectPage.clickOnFirstProject();
		// System.out.println(data.getCellData("Reboot", 6, 2));
		ParkingPage = ProjectPage.SearchAndClickOnParkingProject(data.getCellData("Reboot", 12, 2));
		HomePage.closeProjectSearchTextBox();
		ParkingPage.ClickonAgreementInManage();
		boolean flag = CommonMethod.CheckAgreementDisplay();

		if (flag) {
			log.info("Parking_Agreement_Display method completed ");
			Assert.assertTrue(true);
		} else {
			log.info("Parking_Agreement_Display method completed ");
			Assert.assertTrue(false);
		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Parking_Agreement_Display", groups = {
			"Reboot" }, enabled = true, priority = 36, description = "Verify able to download the agreement successfully.")
	public void Parking_Agreement_Download() {
		log.info("Parking_Agreement_Download method started ");
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		ProjectPage = HomePage.clickOnProject();
		ParkingPage = ProjectPage.SearchAndClickOnParkingProject(data.getCellData("Reboot", 12, 2));
		HomePage.closeProjectSearchTextBox();
		ParkingPage.ClickonAgreementInManage();
		CommonMethod.ClikOnAgreementRegistrationDownloadLink();
		long FileLength = CommonMethod.CheckDownloadedFile();
		if (FileLength > 0) {
			CommonMethod.DeleteAllFiles();
			DownloadFolder.delete();
			log.info("Parking_Agreement_Download method completed ");
			Assert.assertTrue(FileLength > 0);
		} else {
			log.info("Parking_Agreement_Download method completed ");
			Assert.assertTrue(false);
		}

	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, enabled = true, priority = 37, description = "Verify if leed id project, able to download the registration invoice and receipt successfully from Manage-->Billing tab.")
	public void Parking_LEEDID_Project_Download_Invoice() {

		log.info("Parking_LEEDID_Project_Download_Invoice method started ");
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		ProjectPage = HomePage.clickOnProject();
		log.info(data.getCellData("Reboot", 8, 2));
		ParkingPage = ProjectPage.SearchAndClickOnParkingProject(data.getCellData("Reboot", 13, 2));
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

	// Verify Manage-->Teams should show team members added to the project.

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, enabled = true, priority = 38, description = "Verify able to add a team-member successfully.")
	public void Parking_Team_Add_Member() {

		log.info("Parking_Team_Add_Member method started ");
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		ProjectPage = HomePage.clickOnProject();
		log.info(data.getCellData("Reboot", 13, 2));
		ParkingPage = ProjectPage.SearchAndClickOnParkingProject(data.getCellData("Reboot", 13, 2));
		HomePage.closeProjectSearchTextBox();
		ParkingPage.ClickonTeamInManage();
		String username = data.getCellData("Reboot", 15, 2);
		boolean emailexist = CommonMethod.Team_checkEmailExistOrNot(username);
		log.info(username + "-----------existence is----" + emailexist);
		if (emailexist == false) {
			CommonMethod.Team_Add_Member(username);
			boolean UserNamePresent = CommonMethod.Team_checkEmailExistOrNot(username);
			if (UserNamePresent) {
				log.info(username + "  exists in the team member");
				log.info("Parking_Team_Add_Member method completed .......................");
				Assert.assertTrue(true);
			} else {
				log.info(username + "  does not exist in the team member");
				log.info("Parking_Team_Add_Member method completed .......................");
				Assert.assertTrue(false);
			}
		} else {
			log.info("First deleting the email and then will add the same email...");
			CommonMethod.Team_Delete_Member(username);
			CommonMethod.Team_Add_Member(username);
			boolean UserNamePresent = CommonMethod.Team_checkEmailExistOrNot(username);
			if (UserNamePresent) {
				log.info(username + "  exists in the team member");
				log.info("Parking_Team_Add_Member method completed .......................");
				Assert.assertTrue(true);
			} else {
				log.info(username + "  does not exist in the team member");
				log.info("Parking_Team_Add_Member method completed .......................");
				Assert.assertTrue(false);
			}
		}
	}

	// Verify Manage-->It should allow to delete member from the added list

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, dependsOnMethods = "Parking_Team_Add_Member", enabled = true, priority = 39, description = "Verify able to remove a team-member successfully.")
	public void Parking_Team_Delete_Member() {

		log.info("Parking_Team_Delete_Member method started .......................");
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		ProjectPage = HomePage.clickOnProject();
		log.info(data.getCellData("Reboot", 13, 2));
		ParkingPage = ProjectPage.SearchAndClickOnParkingProject(data.getCellData("Reboot", 13, 2));
		HomePage.closeProjectSearchTextBox();
		ParkingPage.ClickonTeamInManage();
		String username = data.getCellData("Reboot", 15, 2);
		CommonMethod.Team_Delete_Member(username);
		boolean emailexist = CommonMethod.Team_checkEmailExistOrNot(username);
		if (!emailexist) {
			log.info(username + "  does not exist as team member");
			log.info("Parking_Team_Delete_Member method completed.......................");
			Assert.assertTrue(true);
		} else {
			log.info(username + " still exist as team member");
			log.info("Parking_Team_Delete_Member method completed.......................");
			Assert.assertTrue(false);
		}

	}
	// ********************************************************RegressionTestCases***************************************

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"ParkSmartRegression" }, enabled = true, priority = 38, description = "Verify Manage-->Agreements should show the project agreement.")
	public void Parking_Display_Agreement() {
		log.info("Parking_Display_Agreement method started ");
		
		try {
			ProjectPaymentPage.CancelPaymentButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		if (!ProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
			ParkingPage.ClickonAgreementInManage();
			HomePage.closeProjectSearchTextBox();
			boolean flag = CommonMethod.CheckAgreementDisplay();

			if (flag) {
				log.info("Parking_Display_Agreement method completed ");
				Assert.assertTrue(true);
			} else {
				log.info("Parking_Display_Agreement method completed ");
				Assert.assertTrue(false);
			}
		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = "Parking_Display_Agreement", groups = {
			"ParkSmartRegression" }, enabled = true, priority = 39, description = "Verify able to download the agreement successfully.")
	public void Parking_Download_Agreement() {
		log.info("Parking_Download_Agreement method started ");
		
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		if (!ProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
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

				log.info("Parking_Download_Agreement method completed ");
				Assert.assertTrue(FileLength > 0);
			} else {
				log.info("Parking_Download_Agreement method completed ");
				Assert.assertTrue(false);
			}
		}

	}

	// Verify if 'project is private' is selected, shows private as 'Yes' under
	// Manage--project.

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 40, enabled = true, description = "Verify Date Signed and type 'Registration' displayed.")
	public void Parking_Verify_DateSigned_Displayed() {

		log.info("Verify_DateSigned_ method started ");
		CommonMethod.switchToDefaultContent();
		ParkingPage = new ParkingPageObject();
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		 String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		//String ProjectParkingID = "1000194741";
		if (!ProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
			ParkingPage.ClickonAgreementInManage();
			HomePage.closeProjectSearchTextBox();
			boolean flag = ParkingPageObject.CheckDateSignedDisplay();

			if (flag) {
				log.info("Verify_DateSigned_Displayed method succesfully completed ");
				Assert.assertTrue(true);
			} else {
				log.info("Verify_DateSigned_Displayed method failed ");
				Assert.assertTrue(false);
			}
		}
	}

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 41, enabled = true, description = "Verify the desired content present in Agreement PDF")

	public void Parking_Validating_Pdf_Content() {
		log.info("Parking_Validating_Pdf_Content method starts here........");
		
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		// String ProjectParkingID = "1000194741";
		if (!ProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
			ParkingPage.ClickonAgreementInManage();
			HomePage.closeProjectSearchTextBox();
			CommonMethod.ClikOnAgreementRegistrationDownloadLink();
			long FileLength = CommonMethod.CheckDownloadedFile();
			if (FileLength > 0) {
				boolean flag = ParkingPage.ValidatePdfContent();
				System.out.println("Flag is ---------->" + flag);
				if (!flag) {
					Assert.assertTrue(true);
					log.info("Parking_Validating_Pdf_Content method ends here........");
				} else
					Assert.assertTrue(false);
				log.info("Parking_Validating_Pdf_Content method ends here........");
			}
		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"ParkSmartRegression" }, enabled = true, priority = 42, description = "Verify able to add a team-member successfully.")
	public void Parking_Add_Team_Member() {
		log.info(" Parking_Add_Team_Member method started ");
		try {

			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		if (!ProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
			ParkingPage.ClickonTeamInManage();
			HomePage.closeProjectSearchTextBox();
			System.out.println();
			String username = data.getCellData("Parking", 2, 2);
			boolean emailexist = CommonMethod.Team_checkEmailExistOrNot(username);
			System.out.println(username + "-----------existence is----" + emailexist);
			boolean flag = false;
			flag = CommonMethod.Team_Add_Member(username);
			if (flag) {
				log.info(username + "  added successfully");
				boolean UserNamePresent = CommonMethod.Team_checkEmailExistOrNot(username);
				if (UserNamePresent) {
					log.info(username + "  exists in the team member");
					log.info(" Parking_Add_Team_Member method completed .......................");
					Assert.assertTrue(true);
				} else {
					log.info(username + "  does not exist in the team member");
					log.info(" Parking_Add_Team_Member method completed .......................");
					Assert.assertTrue(false);
				}
			} else {
				log.info(username + "  is not added successfully");
				log.info(" Parking_Add_Team_Member method completed .......................");
				Assert.assertTrue(false);
			}
		}

	}

	// Verify Manage-->It should allow to delete member from the added list

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"ParkSmartRegression" }, dependsOnMethods = "Parking_Add_Team_Member", enabled = true, priority = 43, description = "Verify able to remove a team-member successfully.")
	public void Parking_Delete_Team_Member() {
		log.info("Parking_Delete_Team_Member method started .......................");
		
		try {

			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		// String ProjectParkingID = "1000194741";
		if (!ProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
			ParkingPage.ClickonTeamInManage();
			HomePage.closeProjectSearchTextBox();
			System.out.println();
			String username = data.getCellData("Parking", 2, 2);
			boolean flag = CommonMethod.Team_Delete_Member(username);
			if (flag) {
				boolean emailexist = CommonMethod.Team_checkEmailExistOrNot(username);
				if (!emailexist) {
					log.info(username + "  does not exist as team member");
					log.info("Parking_Delete_Team_Member method completed.......................");
					Assert.assertTrue(true);
				} else {
					log.info(username + " still exist as team member");
					log.info("Parking_Delete_Team_Member method completed.......................");
					Assert.assertTrue(false);
				}
			} else {
				log.info(username + " is not deleted successfully .......................");
				Assert.assertTrue(false);

			}
		}

	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = { "ParkSmartRegression" }, dependsOnMethods = {
			"Parking_Add_Team_Member",
			"Parking_Delete_Team_Member" }, enabled = true, priority = 44, description = "Verify ARC Administrator will be created default when a project is created")
	public void Parking_Team_Default_Displays_ArcAdmin() {
		log.info("Parking_Team_Default_Displays_ArcAdmin method started ");
		try {

			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		// String ProjectParkingID = "1000194741";
		if (!ProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
			ParkingPage.ClickonTeamInManage();
			HomePage.closeProjectSearchTextBox();

			Boolean flag = ParkingPage.Team_CheckDefaultArcAdmin();

			if (!flag) {
				log.info("Parking_Team_Default_Displays_ArcAdmin method completed ");
				Assert.assertTrue(true);
			} else {
				log.info("Parking_Team_Default_Displays_ArcAdmin method completed ");
				Assert.assertTrue(false);
			}
		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = "ParkSmartRegression", enabled = true, dependsOnMethods = {
			"Parking_Add_Team_Member",
			"Parking_Delete_Team_Member" }, priority = 45, description = "Verify existing ARC administrator can't be edited until another ARC adminstrator is present. If edited, error message will display as 'Project should have atleast one ARC Administrator'.")
	public void Parking_Team_ArcAdmin_Not_Editable_Validation() {
		log.info("ArcAdmin_Not_Editable method starts here........");
		
		try {

			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		// String ProjectParkingID = "1000194741";
		if (!ProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
			ParkingPage.ClickonTeamInManage();
			ParkingPage.ClickOnEditInTeam();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ParkingPage.SelectTeamMember();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ParkingPage.ClickOnSaveInTeam();
			HomePage.closeProjectSearchTextBox();

			boolean flag = ParkingPage.Check_Arc_Admin_Error_Msg();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Flag is....................." + flag);
			if (flag) {
				log.info("Error Message found Parking_Team_Check_ArcAdmin_Not_Editable method completed ");
				Assert.assertTrue(true);
			} else {
				log.info("Error Message found Parking_Team_Check_ArcAdmin_Not_Editable method completed  ");
				Assert.assertTrue(false);
			}
		}
	}

	// Verify Team manager role is not present in the dropdown

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 46, enabled = true, dependsOnMethods = {
			"Parking_Add_Team_Member",
			"Parking_Delete_Team_Member" }, description = "Verify Team manager role is not present in the dropdown")
	public void Parking_Team_Verify_Manager_Role_In_DropDown() {

		log.info("Parking_Verify_Team_Manager_Role_In_DropDown method starts here.........");
		
		try {

			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		// String ProjectParkingID = "1000194741";
		if (!ProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
			ParkingPage.ClickonTeamInManage();
			ParkingPage.ClickOnEditInTeam();
			HomePage.closeProjectSearchTextBox();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			boolean flag = ParkingPage.CheckTeamManagerRole();
			if (flag) {
				log.info(" Parking_Verify_Team_Manager_Role_In_DropDown method completed ");
				Assert.assertTrue(true);
			} else {
				log.info(" Parking_Verify_Team_Manager_Role_In_DropDown method completed  ");
				Assert.assertTrue(false);
			}
		}

	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = "ParkSmartRegression", enabled = true, dependsOnMethods = {
			"Parking_Add_Team_Member",
			"Parking_Delete_Team_Member" }, priority = 47, description = "Verify team member can be added who is a registered USGBC.org user. Verify authorization level should be by default as 'Team Member' if added any new team member")
	public void Parking_Team_Adding_Usgbc_User() {
		log.info("Parking_Adding_Usgbc_User method starts here........");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		// String ProjectParkingID = "1000194741";
		if (!ProjectParkingID.equals(null)) {

			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
			ParkingPage.ClickonTeamInManage();
			HomePage.closeProjectSearchTextBox();

			flag = ParkingPage.CheckAddNewTeamMember();
			
			if (flag) {
				log.info("Parking_Adding_Usgbc_User method ends here with true ........... ");
				Assert.assertTrue(true);

			} else {
				log.info("Parking_Adding_Usgbc_User method ends here with false........... ");
				Assert.assertTrue(false);
			}

		}

	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = "ParkSmartRegression", dependsOnMethods = {
			"Parking_Add_Team_Member",
			"Parking_Delete_Team_Member" }, enabled = true, priority = 48, description = "Adding the same team role for a member again, should give a validation message like 'ashree511@gmail.com already has the same team role'")
	public void Parking_Team_Adding_Same_Team_Role_Validation() {
		log.info("Parking_Adding_Same_Team_Role_Validation method starts here........");
		try {

			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		// String ProjectParkingID = "1000194741";
		if (!ProjectParkingID.equals(null)) {

			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
			ParkingPage.ClickonTeamInManage();
			HomePage.closeProjectSearchTextBox();

			String username = data.getCellData("Parking", 1, 2);
			ParkingPage.Add_Team_Member(username);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String NewUserName = driver
					.findElement(By.xpath("/html/body/div[1]/div[6]/main/div/div/div[1]/section/div/table/tbody/tr[1]/td[2]"))
					.getText();
			System.out.println(NewUserName);
			ParkingPage.Add_Team_Member(NewUserName);

			boolean flag = ParkingPage.Check_ID_Already_Exist_Msg();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Flag is....................." + flag);
			if (flag) {
				log.info("Parking_Adding_Same_Team_Role_Validation method completed ");
				Assert.assertTrue(true);
				CommonMethod.Team_Delete_Member(username);
			} else {
				log.info("Parking_Adding_Same_Team_Role_Validation method completed  ");
				Assert.assertTrue(false);
			}
		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = "ParkSmartRegression", enabled = true, priority = 49, description = "Adding the same team role for a member again, should give a validation message like 'ashree511@gmail.com already has the same team role'")
	public void Parking_Team_Project_Have_Multiple_Arc_Admin() {
		log.info("Parking_Team_Project_Have_Multiple_Arc_Admin method starts here...........");
		try {

			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		// String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		String ProjectParkingID = "1000194993";
		if (!ProjectParkingID.equals(null)) {

			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
			ParkingPage.ClickonTeamInManage();
			HomePage.closeProjectSearchTextBox();

			String username = data.getCellData("Parking", 1, 2);
			CommonMethod.Team_Add_Member(username);

			ParkingPage.ClickOnEditInTeam();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ParkingPage.SelectArcAdmin();
			ParkingPage.ClickOnSaveInTeam();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			CommonMethod.RefreshPagewaitForPageLoaded(driver);
			boolean flag = ParkingPage.Check_Multiple_Arc_Admin();

			if (flag) {
				Assert.assertTrue(true);
				CommonMethod.Team_Delete_Member(username);
			} else
				Assert.assertTrue(false);
			log.info("Parking_Team_Project_Have_Multiple_Arc_Admin method ends here..........");

		}

	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = "ParkSmartRegression", enabled = true, priority = 50, description = "Verify under each credit at the bottom of the page- Hyperlink FAQs redirect to FAQ tab for Parksmart- https://parksmart.gbci.org/faq")
	public void Parking_FAQ_Navigation_Validation() {
		log.info("Parking_FAQ_Navigation_Validation method starts here.........");

		String handle = driver.getWindowHandle();
		try {

			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		// String ProjectParkingID = "1000194741";
		if (!ProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
			HomePage.closeProjectSearchTextBox();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// HomePage.closeProjectSearchTextBox();

			boolean flag1 = ParkingPage.ClickonFAQ();

			Set<String> handles = driver.getWindowHandles();
			if (handles.size() == 2) {
				for (String window : handles) {
					if (!handle.equals(window)) {
						driver.switchTo().window(window);
						driver.close();
						driver.switchTo().window(handle);
					}
				}
			}

			if (flag1) {
				// ProjectRegistrationPage.closeProjectButton();
				Assert.assertTrue(true);
			} else
				Assert.assertTrue(false);

			log.info("Parking_FAQ_Navigation_Validation method ends here.........");
		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = "ParkSmartRegression", enabled = true, priority = 51, description = "Verify under each credit at the bottom of the page- Hyperlink 'Parksmart Resources' redirect to resources tab for Parksmart- https://parksmart.gbci.org/resources")
	public void Parking_ParkSmart_Resources_Navigation_Validation() {
		log.info("Parking_ParkSmart_Resources_Navigation_Validation method starts here.........");
		String handle = driver.getWindowHandle();
		
		try {

			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		if (!ProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
			HomePage.closeProjectSearchTextBox();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// HomePage.closeProjectSearchTextBox();

			boolean flag = ParkingPage.ClickonParkSmartResources();

			Set<String> handles = driver.getWindowHandles();
			if (handles.size() == 2) {
				for (String window : handles) {
					if (!handle.equals(window)) {
						driver.switchTo().window(window);
						driver.close();
						driver.switchTo().window(handle);
					}
				}
			}

			if (flag) {
				// ProjectRegistrationPage.closeProjectButton();
				Assert.assertTrue(true);
			} else
				Assert.assertTrue(false);

			log.info("Parking_ParkSmart_Resources_Navigation_Validation method ends here.........");
		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = "ParkSmartRegression", enabled = true, priority = 52, description = "Verify Management,Programs,Technology and Structure Design,Innovation are displayed.")
	public void Parking_SideBar_Elements_Displayed() {
		log.info("Parking_SideBar_Element_Displayed method starts here...........");
		
		try {

			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		if (!ProjectParkingID.equals(null)) {

			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
			ParkingPage.ClickOnMeasuresMenu();
			HomePage.closeProjectSearchTextBox();

			boolean flag = ParkingPage.CheckMeasuresSubMenu();

			if (flag) {
				log.info("Parking_SideBar_Element_Displayed method completed........... ");
				Assert.assertTrue(false);
			} else {
				log.info("Parking_SideBar_Element_Displayed method completed........... ");
				Assert.assertTrue(true);
			}
		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = "ParkSmartRegression", enabled = true, priority = 53, description = "Go to measures-->All Measures shows a list of credits from A1 to A16, B1 to B13, C1 to C18 and D1")
	public void Parking_All_Credits_Present_AllMeasures_SubSection() {
		log.info("Parking_All_Credits_Present_AllMeasures_SubSection method starts here........");
		try {

			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		// String ProjectParkingID = "1000194741";
		if (!ProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
			ParkingPage.ClickonAllMeasuresInMeasures();
			CommonMethod.RefreshPagewaitForPageLoaded(driver);
			HomePage.closeProjectSearchTextBox();

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			boolean flag = ParkingPage.CheckAllCredits();
			System.out.println("flag is ------>" + flag);
			if (flag) {
				log.info("Parking_All_Credits_Present_AllMeasures_SubSection method completed........... ");
				Assert.assertTrue(true);
			} else {
				log.info("Parking_All_Credits_Present_AllMeasures_SubSection method completed........... ");
				Assert.assertTrue(false);
			}
		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = "ParkSmartRegression", enabled = true, priority = 54, description = "Verify Under Management- All A1 to A16 Credits are present.")
	public void Parking_ManagementSubmenu_Credits_Validation() {
		log.info("Parking_ManagementSubmenu_Credits_Validation method starts here..........");

		try {

			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		// String ProjectParkingID = "1000194741";
		if (!ProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
			ParkingPage.ClickonManagementSubmenu();
			CommonMethod.RefreshPagewaitForPageLoaded(driver);
			HomePage.closeProjectSearchTextBox();

			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			boolean flag = ParkingPage.CheckManagementCredits();
			System.out.println("flag is ------>" + flag);
			if (flag) {
				log.info("Parking_ManagementSubmenu_Credits_Validation method completed........... ");
				Assert.assertTrue(true);
			} else {
				log.info("Parking_ManagementSubmenu_Credits_Validation method completed........... ");
				Assert.assertTrue(false);
			}
		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = "ParkSmartRegression", enabled = true, priority = 55, description = "Verify Under Programs- All B1 to B13 Credits are present.")
	public void Parking_ProgramsSubmenu_Credits_Validation() {
		log.info("Parking_ProgramsSubmenu_Credits_Validation method starts here..........");

		try {

			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		// String ProjectParkingID = "1000194741";
		if (!ProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
			ParkingPage.ClickonProgramSubmenu();
			CommonMethod.RefreshPagewaitForPageLoaded(driver);
			HomePage.closeProjectSearchTextBox();

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			boolean flag = ParkingPage.CheckProgramsCredits();
			System.out.println("flag is ------>" + flag);
			if (flag) {
				log.info("Parking_ProgramsSubmenu_Credits_Validation method completed........... ");
				Assert.assertTrue(true);
			} else {
				log.info("Parking_ProgramsSubmenu_Credits_Validation method completed........... ");
				Assert.assertTrue(false);
			}
		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = "ParkSmartRegression", enabled = true, priority = 56, description = "Verify Under Technology and Structure Design- All C1 to C18 Credits are present.")
	public void Parking_TechAndDesignSubmenu_Credits_Validation() {
		log.info("Parking_TechAndDesignSubmenu_Credits_Validation method starts here..........");

		try {

			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		// String ProjectParkingID = "1000194741";
		if (!ProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
			ParkingPage.ClickonTechAndDesignSubmenu();
			CommonMethod.RefreshPagewaitForPageLoaded(driver);
			HomePage.closeProjectSearchTextBox();

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			boolean flag = ParkingPage.CheckTechAndDesignCredits();
			System.out.println("flag is ------>" + flag);
			if (flag) {
				log.info("Parking_TechAndDesignSubmenu_Credits_Validation method completed........... ");
				Assert.assertTrue(true);
			} else {
				log.info("Parking_TechAndDesignSubmenu_Credits_Validation method completed........... ");
				Assert.assertTrue(false);
			}
		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = "ParkSmartRegression", enabled = true, priority = 57, description = "Verify Under Innovation- D1 Credit is present.")
	public void Parking_InnovationSubmenu_Credits_Validation() {
		log.info("Parking_InnovationSubmenu_Credits_Validation method starts here..........");

		try {

			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		// String ProjectParkingID = "1000194741";
		if (!ProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
			ParkingPage.ClickonInnovationSubMenu();
			CommonMethod.RefreshPagewaitForPageLoaded(driver);
			HomePage.closeProjectSearchTextBox();

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			boolean flag = ParkingPage.CheckInnovationCredits();
			System.out.println("flag is ------>" + flag);
			if (flag) {
				log.info("Parking_InnovationSubmenu_Credits_Validation method completed........... ");
				Assert.assertTrue(true);
			} else {
				log.info("Parking_InnovationSubmenu_Credits_Validation method completed........... ");
				Assert.assertTrue(false);
			}
		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = "ParkSmartRegression", enabled = true, priority = 58, description = "Verify if status button is not displayed under each measure")
	public void Parking_StatusButton_Validation() {
		log.info("Parking_StatusButton_Validation method starts here..........");

		try {

			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		// String ProjectParkingID = "1000194993";
		if (!ProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
			ParkingPage.ClickonAllMeasuresInMeasures();
			HomePage.closeProjectSearchTextBox();

			boolean flag = ParkingPage.CheckStatusButtons();

			if (flag) {
				log.info("Parking_StatusButton_Validation method completed........... ");
				Assert.assertTrue(true);
			} else {
				log.info("Parking_StatusButton_Validation method completed........... ");
				Assert.assertTrue(false);
			}
		}

	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = "ParkSmartRegression", enabled = true, priority = 59, description = "Verify under each credit able to upload documentation by clicking on 'Upload using Computer' button."
			+ "Verify  under each credit able to delete uploaded documents by clicking on 'Delete' bucket button.")
	public void Parking_File_Upload_Remove() {
		log.info("Parking_File_Upload_Remove method started ");
		boolean deletedflag = false;
		boolean uploadflag = false;
		
		try {

			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		// String ProjectParkingID = "1000104847";
		if (!ProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
			ParkingPage.AllMeasuresSubMenu();
			HomePage.closeProjectSearchTextBox();
			ParkingPage.ClickonActionName("A1 - Parking Pricing");

			String FilePath = System.getProperty("user.dir") + "\\UploadDocument\\File1.pdf";
			File f = new File(FilePath);
			uploadflag = ParkingPage.CheckFileUploadUsingComputer(FilePath);
			if (uploadflag) {
				log.info("File upload using Computer completed successfully..............");
				deletedflag = ParkingPage.ClickonFileDeleButton(f.getName());
				if (deletedflag) {
					log.info("File deleted successfully...... ");
				} else
					log.info("Unable to delete File...... ");
			}
			if (uploadflag && deletedflag) {
				Assert.assertTrue(true);
			} else
				Assert.assertTrue(false);
		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = "ParkSmartRegression", enabled = true, priority = 60, description = "Verify under each credit able to download uploaded document successfully.")
	public void Parking_Download_Uploaded_File() {
		log.info("Parking_Upload_Download_Uploaded_File method starts here...........");
		boolean downloadflag = false;
		boolean uploadflag = false;
		
		try {

			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		// String ProjectParkingID = "1000104847";
		if (!ProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
			ParkingPage.AllMeasuresSubMenu();
			HomePage.closeProjectSearchTextBox();
			ParkingPage.ClickonActionName("A1 - Parking Pricing");

			String FilePath = System.getProperty("user.dir") + "\\UploadDocument\\File1.pdf";
			File f = new File(FilePath);
			uploadflag = ParkingPage.CheckFileUploadUsingComputer(FilePath);
			if (uploadflag) {
				log.info("File upload using Computer completed successfully..............");
				downloadflag = ParkingPage.CheckDownloadedFile(f.getName());
				if (downloadflag) {
					log.info("File downloaded successfully successfully...... ");
				} else
					log.info("Unable to download File...... ");
			}
			if (!downloadflag) {
				Assert.assertTrue(true);
			} else
				Assert.assertTrue(false);
		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = "ParkSmartRegression", enabled = true, priority = 61, description = "Verify if the tooltip under each measure displays help text")
	public void Parking_Tool_Tip_Validation() {
		log.info("Parking_Tool_Tip_Validation method starts here........");

		boolean flag = false;
		try {

			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		// String ProjectParkingID = "1000194741";
		if (!ProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
			ParkingPage.AllMeasuresSubMenu();
			HomePage.closeProjectSearchTextBox();

			ParkingPage.ClickonActionName("A1 - Parking Pricing");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ParkingPage.ClickOnToolTip();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			flag = ParkingPage.Validate_ToolTipMessage();
			if (flag) {
				Assert.assertTrue(flag);
			} else
				Assert.assertTrue(flag);

			log.info("Parking_Tool_Tip_Validation  method ends here ........... ");
		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = "ParkSmartRegression", enabled = true, priority = 62, description = "Verify  under each credit 'Measure Language' pdf button downloads a pdf doc with name 'credit_name.pdf'")
	public void Parking_Download_Measure_Language_Pdf() {
		log.info(" Parking_Download_Measure_Language_Pdf method started ");
		
		try {

			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		if (!ProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
			ParkingPage.AllMeasuresSubMenu();
			HomePage.closeProjectSearchTextBox();
			ParkingPage.ClickonActionName("A2 - Shared Parking");
			ParkingPage.ClickOnMeasureLanguagePdf();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			boolean flag = ParkingPage.CheckDownloadedPDF();
			if (flag) {
				for (File file : DownloadFolder.listFiles()) {
					file.delete();
				}
				DownloadFolder.delete();

				log.info(" Parking_Download_Measure_Language_Pdf method completed ");
				Assert.assertTrue(true);
			} else {
				log.info(" Parking_Download_Measure_Language_Pdf method completed ");
				Assert.assertTrue(false);
			}

			try {
				Thread.sleep(4000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			ParkingPage.AllMeasuresSubMenu();
			ParkingPage.ClickonActionName("A1 - Parking Pricing");
			ParkingPage.ClickOnMeasureLanguagePdf();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			boolean flag1 = ParkingPage.CheckDownloadedPDF();
			if (flag1) {
				for (File file : DownloadFolder.listFiles()) {
					file.delete();
				}
				DownloadFolder.delete();

				log.info(" Parking_Download_Measure_Language_Pdf method completed ");
				Assert.assertTrue(true);
			} else {
				log.info(" Parking_Download_Measure_Language_Pdf method completed ");
				Assert.assertTrue(false);
			}
		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = "ParkSmartRegression", enabled = true, priority = 63, description = "Verify appropriate points gets updated on selecting the checkboxes")
	public void Parking_Points_Updating_Appropriate_Points() {
		log.info(" Parking_Points_Updating_Appropriate_Points method starts here.........");

		boolean flag = false;
		try {

			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		if (!ProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
			ParkingPage.AllMeasuresSubMenu();
			HomePage.closeProjectSearchTextBox();
			ParkingPage.ClickonActionName("A2 - Shared Parking");

			flag = ParkingPage.Check_Points_Updated();

			if (!flag) {
				Assert.assertTrue(flag);
			} else
				Assert.assertTrue(flag);

			log.info("Parking_Points_Updating_Appropriate_Points method ends here ........... ");

		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = "ParkSmartRegression", enabled = true, priority = 64, description = "Verify appropriate points gets updated on selecting the checkboxes")
	public void Parking_Points_Updating_When_Selecting_All_Checkboxes() {
		log.info(" Parking_Points_Updating_When_Selecting_Checkboxes method starts here.........");

		boolean flag = false;
		
		try {

			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		//String ProjectParkingID = "1000194741";
		if (!ProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
			ParkingPage.AllMeasuresSubMenu();
			HomePage.closeProjectSearchTextBox();
			ParkingPage.ClickonActionName("A1 - Parking Pricing");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ParkingPage.SelectAllCheckBoxes();

			flag = ParkingPage.Check_Points_Updated_Selecting_All_CheckBoxes();

			if (!flag) {
				Assert.assertTrue(flag);
			} else
				Assert.assertTrue(flag);

			log.info("Parking_Points_Updating_When_Selecting_Checkboxes method ends here ........... ");

		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = "ParkSmartRegression", enabled = true, priority = 65, description = "Verify Hyperlinked words in each Measure takes to appropriate navigations")
	public void Parking_Measures_Hyperlinks_Navigation_Validation() {
		log.info(" Parking_Measures_Hyperlinks_Navigation_Validation method starts here.........");

		boolean A4flag = false;
		String handle = driver.getWindowHandle();
		try {

			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		// String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		String ProjectParkingID = "1000194741";
		if (!ProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
			ParkingPage.ClickonManagementSubmenu();
			HomePage.closeProjectSearchTextBox();
			ParkingPage.ClickonActionName("A4 - Recycling Program");

			A4flag = ParkingPage.ClickonA4HyperLink();

			Set<String> handles = driver.getWindowHandles();
			if (handles.size() == 2) {
				for (String window : handles) {
					if (!handle.equals(window)) {
						driver.switchTo().window(window);
						driver.close();
						driver.switchTo().window(handle);
					}
				}
			}

			if (A4flag) {
				Assert.assertTrue(true);
			} else
				Assert.assertTrue(false);

			log.info("Parking_Measures_Hyperlinks_Navigation_Validation method ends here.........");
		}
	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = "ParkSmartRegression", enabled = true, priority = 66, description = "Verify under each credit at the bottom of the page- Hyperlink FAQs redirect to FAQ tab for Parksmart- https://parksmart.gbci.org/faq")
	public void Parking_Teams_Tooltip_Validation() {
		log.info("Parking_Teams_Tool_Tip_Validation method starts here........");

		boolean flag = false;
		try {

			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String ProjectParkingID = System.getProperty("LEEDParkSmartProjectID");
		// String ProjectParkingID = "1000194741";
		if (!ProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ParkingPage = ProjectPage.SearchAndClickOnParkingProject(ProjectParkingID);
			ParkingPage.ClickonTeamInManage();
			HomePage.closeProjectSearchTextBox();
			// CommonMethod.RefreshPagewaitForPageLoaded(driver);

			ParkingPage.ClickOnTeamToolTip();

			flag = ParkingPage.Validate_TeamToolTipMessage();
			log.info("Flag is --------------->" + flag);
			if (!flag) {
				Assert.assertTrue(true);
			} else
				Assert.assertTrue(false);

			log.info("Parking_Teams_Tool_Tip_Validation  method ends here ........... ");
		}
	}
}
