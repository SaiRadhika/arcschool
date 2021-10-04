package com.arc.testCases;

import java.io.File;
import java.util.Set;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class ProjectRegistrationPageTest extends BaseClass {

	private static Logger log = LoggerHelper.getLogger(ProjectRegistrationPageTest.class);

	// Verify allowed special characters for Project name are - & + / : ' , - . #

	@Test(groups = "ProjectRegsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 3, enabled = false, description = "Verify Project Name should allow special character (-&+/:',-.#)")
	public void ProjectName_With_Valid_SpecialCharacters() {
		log.info("ProjectName_With_Valid_SpecialCharacters method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean flag = false;
		// HomePage.setHomePageApplication();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + "-&+/:',-.#");

		try {
			flag = ProjectRegistrationPage.CheckProjectNameValidationMsg();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		// ProjectRegistrationPage.closeProjectButton();
		log.info("ProjectName_With_Valid_SpecialCharacters method ends here ........... ");

	}

	// Verify with Invalid special characters for Project name are !~$%^*()

	@Test(groups = "ProjectRegsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 4, enabled = false, description = "Verify with Invalid special characters for Project name are !~$%^*()")
	public void ProjectName_With_Invalid_SpecialCharacters() {
		log.info("ProjectName_With_Invalid_SpecialCharacters method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();

			/*
			 * if (!HomePage.CheckHomePageLabel())
			 * ProjectRegistrationPage.closeProjectButton();
			 * HomePage.setHomePageApplication();
			 */

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean flag = false;
		// HomePage.setHomePageApplication();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + "!~$%^*()");

		try {
			flag = ProjectRegistrationPage.CheckProjectNameValidationMsg();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		// ProjectRegistrationPage.closeProjectButton();
		log.info("ProjectName_With_Invalid_SpecialCharacters method ends here ........... ");

	}

	// Verify Project Type is selected as 'Cities'

	@Test(groups = {
			"CityRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 5, enabled = true, description = "Verify Project Type is selected as 'Cities'")
	public void ProjectRegistration_ProjectType_City_Value() {
		log.info("ProjectRegistration_ProjectType_City_Value method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean flag = false;
		HomePage.clickOnProject();
		HomePage.clickOnCitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));

		try {

			flag = ProjectRegistrationPage.SelectCityProjectType();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		log.info("ProjectRegistration_ProjectType_City_Value method ends here ........... ");

	}

	// Verify City adding Gross area - limit allowed is Max: 19,305 square miles

	@Test(groups = {
			"CityRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 6, enabled = true, description = "Verify City adding Gross area - limit allowed is Max: 19,305 square miles")
	public void ProjectRegistration_CityGrossArea_Valid_19305_SQ_Miles() {
		log.info("ProjectRegistration_CityGrossArea_Valid_19305_SQ_Miles method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean flag = false;

		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectCityProjectType();
		ProjectRegistrationPage.SelectUnitType("square miles");
		ProjectRegistrationPage.enterGrossArea("19305");

		try {

			flag = ProjectRegistrationPage.CheckGrossAreaValidationMsg();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		log.info("ProjectRegistration_CityGrossArea_Valid_19305_SQ_Miles method ends here ........... ");

	}

	// Verify City adding invalid Gross area - limit 19,306 square miles

	@Test(groups = {
			"CityRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 7, enabled = true, description = "Verify City adding invalid Gross area - limit  19,306 square miles")
	public void ProjectRegistration_CityGrossArea_Invalid_19306_SQ_Miles() {
		log.info("ProjectRegistration_CityGrossArea_Invalid_19306_SQ_Miles method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean flag = false;

		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectCityProjectType();

		ProjectRegistrationPage.enterGrossArea("19306");
		ProjectRegistrationPage.SelectUnitType("square miles");
		ProjectRegistrationPage.enterPopulation(data.getCellData("ProjectRegistration", 2, 2));
		ProjectRegistrationPage.clickNoLEEDRegistration();
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		CityPage = ProjectRegistrationPage.ClickonCityAddProjectButton();
		try {

			flag = ProjectRegistrationPage.CheckGrossAreaValidationMsg();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		// ProjectRegistrationPage.closeProjectButton();
		log.info("ProjectRegistration_CityGrossArea_Invalid_19306_SQ_Miles method ends here ........... ");

	}

	// Verify City adding Gross area - limit allowed is Max: 50000 square kilometers

	@Test(groups = {
			"CityRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 8, enabled = true, description = "Verify City adding Gross area - limit allowed is Max: 50000 square kilometers")
	public void ProjectRegistration_CityGrossArea_Valid_50000_SQ_KM() {
		log.info("ProjectRegistration_CityGrossArea_Valid_50000_SQ_KM method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean flag = false;

		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectCityProjectType();
		ProjectRegistrationPage.SelectUnitType("square kilometers");
		ProjectRegistrationPage.enterGrossArea("50000");

		try {

			flag = ProjectRegistrationPage.CheckGrossAreaValidationMsg();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		// ProjectRegistrationPage.closeProjectButton();
		log.info("ProjectRegistration_CityGrossArea_Valid_50000_SQ_KM method ends here ........... ");

	}

	// Verify City adding invalid Gross area - limit 50001 square Kilometer

	@Test(groups = {
			"CityRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 9, enabled = true, description = " Verify City adding invalid Gross area - limit  50001 square Kilometer")
	public void ProjectRegistration_CityGrossArea_Invalid_50001_SQ_KM() {
		log.info("ProjectRegistration_CityGrossArea_Invalid_50001_SQ_KM method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean flag = false;

		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectCityProjectType();

		ProjectRegistrationPage.enterGrossArea("50001");
		ProjectRegistrationPage.SelectUnitType("square kilometers");
		ProjectRegistrationPage.enterPopulation(data.getCellData("ProjectRegistration", 2, 2));
		ProjectRegistrationPage.clickNoLEEDRegistration();
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		CityPage = ProjectRegistrationPage.ClickonCityAddProjectButton();
		try {

			flag = ProjectRegistrationPage.CheckGrossAreaValidationMsg();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		// ProjectRegistrationPage.closeProjectButton();
		log.info("ProjectRegistration_CityGrossArea_Invalid_50001_SQ_KM method ends here ........... ");

	}

	/*
	 * Verify if 'Are you registering for a LEED CERTIFICATION' is selected as
	 * 'Yes', opens a new modal window with text as below:
	 * "If you're interested in registering this project for LEED certification, please select the "
	 * Register for LEED certification now" button below and you’ll be routed to
	 * LEED Online.
	 * 
	 * Otherwise, you can get started now with Arc for free. Just select the
	 * "Not now" button below.
	 * 
	 * You can enter your performance data in Arc and choose to register for LEED
	 * later. Your performance data will get you most of the way, but you'll need to
	 * complete the LEED prerequisites, and possibly other requirements before
	 * submitting for certification."
	 * 
	 * 
	 */
	@Test(groups = {
			"CityRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 10, enabled = true, description = "Verify if 'Are you registering for a LEED CERTIFICATION' is selected as 'Yes', opens a new modal window with text as below:\r\n"
					+ "\"If you're interested in registering this project for LEED certification, please select the \"Register for LEED certification now\" button below and you’ll be routed to LEED Online.\r\n"
					+ "\r\n"
					+ "Otherwise, you can get started now with Arc for free. Just select the \"Not now\" button below.\r\n"
					+ "\r\n"
					+ "You can enter your performance data in Arc and choose to register for LEED later. Your performance data will get you most of the way, but you'll need to complete the LEED prerequisites, and possibly other requirements before submitting for certification.\"\r\n"
					+ "")
	public void ProjectRegistration_LEED_Registration_Yes_CheckMessage() {
		log.info("ProjectRegistration_LEED_Registration_Yes_CheckMessage method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean flag = false;

		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectCityProjectType();
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.clickYesLEEDRegistration();
		flag = ProjectRegistrationPage.Validate_LEEDRegistrationPopupMessage();
		if (flag) {
			// ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(flag);
		} else
			Assert.assertTrue(flag);
		// ProjectRegistrationPage.closeProjectButton();
		log.info("ProjectRegistration_LEED_Registration_Yes_CheckMessage method ends here ........... ");

	}

	// Verify the new modal window shows two buttons- 'Register for LEED
	// certification now' and 'Not now'

	@Test(groups = {
			"CityRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 11, enabled = true, description = "Verify the new modal window shows two buttons- 'Register for LEED certification now' and 'Not now'")
	public void ProjectRegistration_LEED_Regis_Shows_RegisterforLEEDcertification_NotNow() {
		log.info(
				"ProjectRegistration_LEED_Regis_Shows_RegisterforLEEDcertification_NotNow method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();

			/*
			 * if (!HomePage.CheckHomePageLabel())
			 * ProjectRegistrationPage.closeProjectButton();
			 * HomePage.setHomePageApplication();
			 */
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean flag = false;

		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectCityProjectType();
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.clickYesLEEDRegistration();
		flag = ProjectRegistrationPage.CheckRegisterforLEEDPopupButtonsExists();

		if (flag) {
			// ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(flag);
		} else
			Assert.assertTrue(flag);
		log.info(
				"ProjectRegistration_LEED_Regis_Shows_RegisterforLEEDcertification_NotNow method ends here ........... ");

	}

	// Verify clicking on 'Register for LEED certification now' redirects to Leed
	// Online portal.

	@Test(groups = { "CityRegression" }, dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"ProjectRegistration_LEED_Regis_Shows_RegisterforLEEDcertification_NotNow" }, priority = 12, enabled = true, description = "Verify clicking on 'Register for LEED certification now' redirects to Leed Online portal.")
	public void ProjectRegistration_LEED_Regis_Redirects_LeedOnlineportal() {
		log.info("ProjectRegistration_LEED_Regis_Redirects_LeedOnlineportal method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String handle = driver.getWindowHandle();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectCityProjectType();
		System.out.println(data.getCellData("City", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.clickYesLEEDRegistration();

		String CityRegistrationText = ProjectRegistrationPage.checkLEEDOnLinePortal();

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
		if (CityRegistrationText.equals("City Registration")) {
			ProjectRegistrationPage.clickOnNotNowPopUpButton();
			// ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(true);
		} else {
			// ProjectRegistrationPage.clickOnNotNowPopUpButton();
			Assert.assertTrue(false);
		}

		log.info("ProjectRegistration_LEED_Regis_Redirects_LeedOnlineportal method ends here ........... ");
	}

	// Verify clicking on 'Not now' closes the modal window and keeps the user at
	// the registration page.
	// Verify clicking on 'Not now' closes the modal window and selects the 'No'
	// radio button.

	@Test(groups = { "CityRegression" }, dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"ProjectRegistration_LEED_Regis_Shows_RegisterforLEEDcertification_NotNow" }, priority = 13, enabled = true, description = "Verify clicking on 'Not now' closes the modal window and keeps the user at the registration page. \r\n"
					+ "	// Verify clicking on 'Not now' closes the modal window and selects the 'No' radio button.")
	public void ProjectRegistration_LEED_Registration_Not_Now_Test() {
		log.info("ProjectRegistration_LEED_Registration_Not_Now_Test method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectCityProjectType();
		System.out.println(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.clickYesLEEDRegistration();
		ProjectRegistrationPage.clickOnNotNowPopUpButton();
		boolean flag = ProjectRegistrationPage.checkAfterClickOnNotNowPopupButton();

		if (flag) {

			// ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(true);
		} else {

			Assert.assertTrue(false);
		}

		log.info("ProjectRegistration_LEED_Registration_Not_Now_Test method ends here ........... ");
	}

	// Verify address field auto populates the address(this address is being pulled
	// using google maps API).
	// Verify auto pulled address populates all the fields -City, County,States,zip
	// code

	@Test(groups = {
			"CityRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 14, enabled = true, description = "Verify address field auto populates the address(this address is being pulled using google maps API).\r\n"
					+ "	Verify auto pulled address populates all the fields -City, County,States,zipcode")
	public void ProjectRegistration_AutoPopulate_Address_City_Country_State_ZipCode() {
		log.info("ProjectRegistration_AutoPopulate_Address_City_Country_State_ZipCode method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectCityProjectType();
		System.out.println(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.clickNoLEEDRegistration();

		boolean flag = ProjectRegistrationPage
				.CheckAddress_City_Country_State_ZipCode("2101 L St NW Washington DC 20037 USA");
		if (flag) {
			// ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		log.info("ProjectRegistration_AutoPopulate_Address_City_Country_State_ZipCode method ends here ........... ");
	}

	// Verify after address is auto pulled, geo location gets auto -populated.

	@Test(groups = { "CityRegression" }, dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {

			"ProjectRegistration_AutoPopulate_Address_City_Country_State_ZipCode" }, priority = 15, enabled = true, description = "Verify after address is auto pulled, geo location gets auto -populated.")
	public void ProjectRegistration_AutoPopulate_Latitude_Longitude() {
		log.info("ProjectRegistration_AutoPopulate_Latitude_Longitude method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectCityProjectType();
		System.out.println(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.clickNoLEEDRegistration();

		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode("2101 L St NW washington DC 20037 USA");
		boolean flag = ProjectRegistrationPage.CheckGeoLocation();
		if (flag) {
			// ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		log.info("ProjectRegistration_AutoPopulate_Latitude_Longitude method ends here ........... ");
	}

	// Verify able to download service agreement successfully.

	@Test(groups = { "ProjectRegsRegression", "CityRegression",
			"CommunityRegression" }, dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
					"ProjectRegistration_ProjectType_City_Value" }, priority = 16, enabled = false, description = " Verify able to download service agreement successfully.")
	public void ProjectRegistration_Download_Service_Agreement() {
		log.info("ProjectRegistration_Download_Service_Agreement method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String handle = driver.getWindowHandle();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectCityProjectType();
		System.out.println(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.clickNoLEEDRegistration();

		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode("2101 L St NW washington DC 20037 USA");

		boolean flag = ProjectRegistrationPage.DownLoadServiceAgreement();

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

		log.info("ProjectRegistration_Download_Service_Agreement method ends here ........... ");
	}

	// Verify when 'I agree to … agreement' checkbox is selected, 'Add project'
	// button gets enabled.

	@Test(groups = { "CityRegression",
			"CommunityRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 17, enabled = true, description = "Verify when 'I agree to … agreement' checkbox is selected, 'Add project' button gets enabled.")
	public void ProjectRegistration_Agreement_Check_AddButtonEnabled() {
		log.info("ProjectRegistration_Agreement_Check_AddButtonEnabled method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String handle = driver.getWindowHandle();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectCityProjectType();
		boolean flag = ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		if (flag) {
			// ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);

		log.info("ProjectRegistration_Agreement_Check_AddButtonEnabled method ends here ........... ");
	}

	// Verify clicking on checkbox for 'This is a test project' creates a test
	// project and the same gets populated after project creation under
	// manage-project.

	@Test(groups = { "CityRegression" }, dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"ProjectRegistration_ProjectType_City_Value",
			"ProjectRegistration_AutoPopulate_Address_City_Country_State_ZipCode",
			"ProjectRegistration_AutoPopulate_Latitude_Longitude" }, priority = 18, enabled = true, description = "Verify clicking on checkbox for 'This is a test project' creates a test project and the same gets populated after project creation under  manage-project.")
	public void City_TestProject_Creation() {
		log.info("City_TestProject_Creation method started ........... ");
		String ProjectCityID = null;
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String handle = driver.getWindowHandle();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String CityProjectName = data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(6);
		ProjectRegistrationPage.enterProjectName(CityProjectName);
		ProjectRegistrationPage.SelectThisIsTestProjectCheckBox();
		ProjectRegistrationPage.SelectCityProjectType();
		System.out.println(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.SelectUnitType("square miles");
		ProjectRegistrationPage.clickNoLEEDRegistration();
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		CityPage = ProjectRegistrationPage.ClickonCityAddProjectButton();

		boolean flag = CityPage.checkCityProjectCreation(CityProjectName);
		if (flag) {
			CityPage.ClickonProjectInManage();
			ProjectCityID = CityPage.getProjectID(CityProjectName);
			System.setProperty("CityProject_Test1", ProjectCityID);
			log.info("  CityProject_Test1 is ---" + ProjectCityID);

			if (CityPage.CheckThisIsTestProjectCheckBox(ProjectCityID)) {
				log.info("This is test project creation done successfully ........... ");
				Assert.assertTrue(true);
			} else {
				log.info("This is Test Project checkbox is not checked..................");
				log.info("City_TestProject_Creation method ends with false here ........... ");
				Assert.assertTrue(false);
			}
		} else {
			log.info("Project Creation gets failed..........");
			log.info("City_TestProject_Creation method ends with false here ........... ");
			Assert.assertTrue(false);
		}

		log.info("City_TestProject_Creation method ends here ........... ");
	}

	// Verify clicking on 'Add project' button registers the project with non-leed
	// id.
	// Verify that the population field is optional.

	@Test(groups = { "CityRegression" }, dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"ProjectRegistration_ProjectType_City_Value",
			"ProjectRegistration_AutoPopulate_Address_City_Country_State_ZipCode",
			"ProjectRegistration_AutoPopulate_Latitude_Longitude" }, priority = 19, enabled = true, description = "Verify clicking on 'Add project' button registers the project with non-leed id")
	public void City_NonLEEDProject_Creation() {
		log.info("City_NonLEEDProject_Creation method started ........... ");
		String ProjectCityID = null;
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String handle = driver.getWindowHandle();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String CityProjectName = data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(6);
		ProjectRegistrationPage.enterProjectName(CityProjectName);
		// ProjectRegistrationPage.SelectThisIsTestProjectCheckBox();
		ProjectRegistrationPage.SelectCityProjectType();
		System.out.println(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.SelectUnitType("square miles");
		// ProjectRegistrationPage.enterPopulation(data.getCellData("City", 2, 2));
		ProjectRegistrationPage.clickNoLEEDRegistration();
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		CityPage = ProjectRegistrationPage.ClickonCityAddProjectButton();

		boolean flag = CityPage.checkCityProjectCreation(CityProjectName);
		if (flag) {
			CityPage.ClickonProjectInManage();
			ProjectCityID = CityPage.getProjectID(CityProjectName);
			System.setProperty("CityProject_NonLeed2", ProjectCityID);
			log.info("  CityProject_NonLeed2 is ---" + ProjectCityID);
			if (ProjectCityID.substring(0, 4).equals("8000")) {
				log.info("Non LEED ID Project creation successful..................");
				Assert.assertTrue(true);
			} else {
				log.info("Non LEED ID Project creation failed..................");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Project Creation gets failed..........");
			Assert.assertTrue(false);
		}

		log.info("City_NonLEEDProject_Creation method ends here ........... ");
	}

	// Verify if 'project is private' is selected, shows private as 'Yes' under
	// Manage--project.

	@Test(groups = { "CityRegression" }, dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"ProjectRegistration_ProjectType_City_Value",
			"ProjectRegistration_AutoPopulate_Address_City_Country_State_ZipCode",
			"ProjectRegistration_AutoPopulate_Latitude_Longitude" }, priority = 20, enabled = true, description = "Verify if 'project is private' is selected, shows private as 'Yes' under Manage--project.")
	public void City_Project_Is_Private_Creation() {
		log.info("City_Project_Is_Private_Creation method started ........... ");
		String ProjectCityID = "";
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String handle = driver.getWindowHandle();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String CityProjectName = data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(CityProjectName);
		ProjectRegistrationPage.SelectCityProjectType();
		System.out.println(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.SelectUnitType("square miles");
		ProjectRegistrationPage.enterPopulation(data.getCellData("ProjectRegistration", 2, 2));
		ProjectRegistrationPage.clickNoLEEDRegistration();
		ProjectRegistrationPage.SelectProjectIsPrivateCheckBox();
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		CityPage = ProjectRegistrationPage.ClickonCityAddProjectButton();

		boolean flag = CityPage.checkCityProjectCreation(CityProjectName);
		// String HeaderText=CityPage.CheckPerformanceHeaderShowing();
		if (flag) {
			CityPage.ClickonProjectInManage();
			ProjectCityID = CityPage.getProjectID(CityProjectName);
			System.setProperty("CityProject_Private3", ProjectCityID);
			log.info("  CityProject_Private3 is ---" + ProjectCityID);
			if ((CityPage.CheckProjectIsPrivateFlagUnderManage(ProjectCityID) == true)) {
				Assert.assertTrue(true);
			} else {
				log.info("This is Project is Private as YES radiobutton is not selected..................");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Project is Private Creation gets failed..........");
			Assert.assertTrue(false);
		}

		log.info("City_Project_Is_Private_Creation method ends here ........... ");
	}

	// Verify clicking on 'Add project' button opens the 'Performance' Tab.

	@Test(groups = { "CityRegression" }, dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"ProjectRegistration_ProjectType_City_Value",
			"ProjectRegistration_AutoPopulate_Address_City_Country_State_ZipCode",
			"ProjectRegistration_AutoPopulate_Latitude_Longitude" }, priority = 21, enabled = true, description = "Verify clicking on 'Add project' button opens the 'Performance' Tab.")
	public void City_Project_Creation_Opens_Performance_Screen() {
		log.info("City_Project_Creation_Opens_Performance_Screen method started ........... ");
		String ProjectCityID = "";
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String handle = driver.getWindowHandle();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String CityProjectName = data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(CityProjectName);
		ProjectRegistrationPage.SelectCityProjectType();
		System.out.println(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.SelectUnitType("square miles");
		ProjectRegistrationPage.enterPopulation(data.getCellData("ProjectRegistration", 2, 2));
		ProjectRegistrationPage.clickNoLEEDRegistration();
		// ProjectRegistrationPage.SelectProjectIsPrivateCheckBox();
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		CityPage = ProjectRegistrationPage.ClickonCityAddProjectButton();

		boolean flag = CityPage.checkCityProjectCreation(CityProjectName);
		String HeaderText = CityPage.CheckPerformanceHeaderShowing();
		if (flag) {
			CityPage.ClickonProjectInManage();
			ProjectCityID = CityPage.getProjectID(CityProjectName);
			System.setProperty("CityProject_Perf4", ProjectCityID);
			log.info("  CityProject_Perf4 is ---" + ProjectCityID);
			if (HeaderText.equals("Performance")) {
				Assert.assertTrue(true);
			} else {
				log.info("Performance screen not showing..................");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Project Creation gets failed..........");
			Assert.assertTrue(false);
		}

		log.info("City_Project_Creation_Opens_Performance_Screen method ends here ........... ");
	}

//-----------------------------------------------Communities related Test Cases----------------------------
	// Verify Project Type is selected as 'Communities'

	@Test(groups = {
			"CommunityRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 24, enabled = true, description = "Verify Project Type is selected as 'Communities'")
	public void ProjectRegistration_ProjectType_Communities_Value() {
		log.info("ProjectRegistration_ProjectType_Communities_Value method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean flag = false;
		HomePage.clickOnProject();
		HomePage.clickOnCommunitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));

		try {

			flag = ProjectRegistrationPage.SelectCommunitiesProjectType();
			ProjectRegistrationPage.closeProjectButton();

		} catch (Exception e) {
			ProjectRegistrationPage.closeProjectButton();
			e.printStackTrace();
		}
		if (flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		// ProjectRegistrationPage.closeProjectButton();
		log.info("ProjectRegistration_ProjectType_Communities_Value method ends here ........... ");

	}

	// Verify clicking on checkbox for 'This is a test project' creates a test
	// Communities
	// project and the same gets populated after project creation under
	// manage-project.

	@Test(groups = { "CommunityRegression" }, dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"ProjectRegistration_ProjectType_Communities_Value" }, priority = 25, enabled = true, description = "Verify clicking on checkbox for 'This is a test project' creates a test Communities project and the same gets populated after project creation under  manage-project.")
	public void Communities_TestProject_Creation() {
		log.info("Communities_TestProject_Creation method started ........... ");
		String ProjectCommunitiesID = null;
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String handle = driver.getWindowHandle();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String CommunitiesProjectName = data.getCellData("ProjectRegistration", 8, 2)
				+ CommonMethod.generateRandomString(6);
		ProjectRegistrationPage.enterProjectName(CommunitiesProjectName);
		ProjectRegistrationPage.SelectThisIsTestProjectCheckBox();
		ProjectRegistrationPage.SelectCityProjectType();
		System.out.println(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.SelectUnitType("square miles");
		// ProjectRegistrationPage.enterPopulation(data.getCellData("City", 2, 2));
		ProjectRegistrationPage.clickNoLEEDRegistration();
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		CommunitiesPage = ProjectRegistrationPage.ClickonCommunitiesAddProjectButton();

		boolean flag = CommunitiesPage.checkCommunitiesProjectCreation(CommunitiesProjectName);
		if (flag) {
			CommunitiesPage.ClickonProjectInManage();
			ProjectCommunitiesID = CommunitiesPage.getProjectID(CommunitiesProjectName);
			System.setProperty("CommunitiesProject_Test1", ProjectCommunitiesID);
			log.info("  CommunitiesProject_Test1 is ---" + ProjectCommunitiesID);

			if (CommunitiesPage.CheckThisIsTestProjectCheckBox(ProjectCommunitiesID)) {
				log.info("This is test project creation done successfully ........... ");
				Assert.assertTrue(true);
			} else {
				log.info("This is Test Project checkbox is not checked..................");
				log.info("Communities_TestProject_Creation method ends with false here ........... ");
				Assert.assertTrue(false);
			}
		} else {
			log.info("Project Creation gets failed..........");
			log.info("Communities_TestProject_Creation method ends with false here ........... ");
			Assert.assertTrue(false);
		}

		log.info("Communities_TestProject_Creation method ends here ........... ");
	}

	// Verify clicking on 'Add project' button registers the project with non-leed
	// id.
	// Verify that the population field is optional.

	@Test(groups = { "CommunityRegression" }, dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"ProjectRegistration_ProjectType_Communities_Value" }, priority = 26, enabled = true, description = "Verify clicking on 'Add project' button registers the project with non-leed id")
	public void Communities_NonLEEDProject_Creation() {
		log.info("Communities_NonLEEDProject_Creation method started ........... ");
		String ProjectCommunitiesID = null;
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String handle = driver.getWindowHandle();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String CommunitiesProjectName = data.getCellData("ProjectRegistration", 8, 2)
				+ CommonMethod.generateRandomString(6);
		ProjectRegistrationPage.enterProjectName(CommunitiesProjectName);
		// ProjectRegistrationPage.SelectThisIsTestProjectCheckBox();
		ProjectRegistrationPage.SelectCityProjectType();
		System.out.println(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.SelectUnitType("square miles");
		// ProjectRegistrationPage.enterPopulation(data.getCellData("City", 2, 2));
		ProjectRegistrationPage.clickNoLEEDRegistration();
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		CommunitiesPage = ProjectRegistrationPage.ClickonCommunitiesAddProjectButton();

		boolean flag = CommunitiesPage.checkCommunitiesProjectCreation(CommunitiesProjectName);
		if (flag) {
			CommunitiesPage.ClickonProjectInManage();
			ProjectCommunitiesID = CommunitiesPage.getProjectID(CommunitiesProjectName);
			System.setProperty("CommunitiesProject_NonLeed2", ProjectCommunitiesID);
			log.info("  CommunitiesProject_NonLeed2 is ---" + ProjectCommunitiesID);
			if (ProjectCommunitiesID.substring(0, 4).equals("8000")) {
				log.info("Non LEED ID Project creation successful..................");
				Assert.assertTrue(true);
			} else {
				log.info("Non LEED ID Project creation failed..................");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Project Creation gets failed..........");
			Assert.assertTrue(false);
		}

		log.info("Communities_NonLEEDProject_Creation method ends here ........... ");
	}

	// Verify if 'project is private' is selected, shows private as 'Yes' under
	// Manage--project.

	@Test(groups = { "CommunityRegression" }, dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"ProjectRegistration_ProjectType_Communities_Value" }, priority = 27, enabled = true, description = "Verify if 'project is private' is selected, shows private as 'Yes' under Manage--project.")
	public void Communities_Project_Is_Private_Creation() {
		log.info("Communities_Project_Is_Private_Creation method started ........... ");
		String ProjectCommunitiesID = "";
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String handle = driver.getWindowHandle();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String CommunitiesProjectName = data.getCellData("ProjectRegistration", 8, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(CommunitiesProjectName);
		ProjectRegistrationPage.SelectCityProjectType();
		System.out.println(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.SelectUnitType("square miles");
		ProjectRegistrationPage.enterPopulation(data.getCellData("ProjectRegistration", 2, 2));
		ProjectRegistrationPage.clickNoLEEDRegistration();
		ProjectRegistrationPage.SelectProjectIsPrivateCheckBox();
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		CommunitiesPage = ProjectRegistrationPage.ClickonCommunitiesAddProjectButton();

		boolean flag = CommunitiesPage.checkCommunitiesProjectCreation(CommunitiesProjectName);
		// String HeaderText=CityPage.CheckPerformanceHeaderShowing();
		if (flag) {
			CommunitiesPage.ClickonProjectInManage();
			ProjectCommunitiesID = CommunitiesPage.getProjectID(CommunitiesProjectName);
			System.setProperty("CommunitiesProject_Private3", ProjectCommunitiesID);
			log.info("  CommunitiesProject_Private3 is ---" + ProjectCommunitiesID);
			if ((CommunitiesPage.CheckProjectIsPrivateFlagUnderManage(ProjectCommunitiesID) == true)) {
				Assert.assertTrue(true);
			} else {
				log.info("This is Project is Private as YES radiobutton is not selected..................");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Project is Private Creation gets failed..........");
			Assert.assertTrue(false);
		}

		log.info("Communities_Project_Is_Private_Creation method ends here ........... ");
	}

	// Verify clicking on 'Add project' button opens the 'Performance' Tab.

	@Test(groups = { "CommunityRegression" }, dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"ProjectRegistration_ProjectType_Communities_Value" }, priority = 28, enabled = true, description = "Verify clicking on 'Add project' button opens the 'Performance' Tab.")
	public void Communities_Project_Creation_Opens_Performance_Screen() {
		log.info("Communities_Project_Creation_Opens_Performance_Screen method started ........... ");
		String ProjectCommunitiesID = "";
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String handle = driver.getWindowHandle();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String CommunitiesProjectName = data.getCellData("ProjectRegistration", 8, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(CommunitiesProjectName);
		ProjectRegistrationPage.SelectCityProjectType();
		System.out.println(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.SelectUnitType("square miles");
		ProjectRegistrationPage.enterPopulation(data.getCellData("ProjectRegistration", 2, 2));
		ProjectRegistrationPage.clickNoLEEDRegistration();
		// ProjectRegistrationPage.SelectProjectIsPrivateCheckBox();
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		CommunitiesPage = ProjectRegistrationPage.ClickonCommunitiesAddProjectButton();

		boolean flag = CommunitiesPage.checkCommunitiesProjectCreation(CommunitiesProjectName);
		String HeaderText = CommunitiesPage.CheckPerformanceHeaderShowing();
		if (flag) {
			CommunitiesPage.ClickonProjectInManage();
			ProjectCommunitiesID = CommunitiesPage.getProjectID(CommunitiesProjectName);
			System.setProperty("CommunitiesProject_Perf4", ProjectCommunitiesID);
			log.info("  CommunitiesProject_Perf4 is ---" + ProjectCommunitiesID);
			if (HeaderText.equals("Performance")) {
				Assert.assertTrue(true);
			} else {
				log.info("Performance screen not showing..................");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Project Creation gets failed..........");
			Assert.assertTrue(false);
		}

		log.info("Communities_Project_Creation_Opens_Performance_Screen method ends here ........... ");
	}

	// -----------------------------------------------Buildings related Test
	// Cases----------------------------

	// Verify Project Type is selected as 'Buildings'

	@Test(groups = {
			"BuildingsRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 30, enabled = true, description = "Verify Project Type is selected as 'Buildings'")
	public void ProjectRegistration_ProjectType_Buildings_Value() {
		log.info("ProjectRegistration_ProjectType_Buildings_Value method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean flag = false;
		HomePage.clickOnProject();
		HomePage.clickOnBuildingSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 9, 2) + CommonMethod.generateRandomString(5));

		try {

			flag = ProjectRegistrationPage.SelectBuildingProjectType();
			// ProjectRegistrationPage.closeProjectButton();

		} catch (Exception e) {
			// ProjectRegistrationPage.closeProjectButton();
			e.printStackTrace();
		}
		if (flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		// ProjectRegistrationPage.closeProjectButton();
		log.info("ProjectRegistration_ProjectType_Buildings_Value method ends here ........... ");

	}

	// Verify Buildings adding Gross area - limit allowed is Max: 20,499,999 square
	// feets

	@Test(groups = {
			"BuildingsRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 31, enabled = true, description = " Verify Buildings adding Gross area - limit allowed is Max: 20,499,999  square feets")
	public void ProjectRegistration_BuildingsGrossArea_Valid_20499999_SQ_Feet() {
		log.info("ProjectRegistration_BuildingsGrossArea_Valid_20499999_SQ_Feet method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean flag = false;
		HomePage.clickOnProject();
		HomePage.clickOnBuildingSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 9, 2) + CommonMethod.generateRandomString(5));

		ProjectRegistrationPage.SelectBuildingProjectType();
		ProjectRegistrationPage.SelectUnitType("square feet");
		ProjectRegistrationPage.enterGrossArea("20499999");

		try {

			flag = ProjectRegistrationPage.CheckGrossAreaValidationMsg();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		log.info("ProjectRegistration_BuildingsGrossArea_Valid_20499999_SQ_Feet method ends here ........... ");

	}

	// Verify Buildings adding invalid Gross area - 20,500,000 square feets should
	// display Validation message

	@Test(groups = {
			"BuildingsRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 32, enabled = true, description = "Verify Buildings adding invalid Gross area - 20,500,000  square feets should display Validation message")
	public void ProjectRegistration_BuildingsGrossArea_Invalid_20500000_SQ_Feet() {
		log.info("ProjectRegistration_BuildingsGrossArea_Invalid_20500000_SQ_Feet method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean flag = false;
		HomePage.clickOnProject();
		HomePage.clickOnBuildingSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 9, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectBuildingProjectType();

		ProjectRegistrationPage.enterGrossArea("20500000");
		ProjectRegistrationPage.SelectUnitType("square feet");
		ProjectRegistrationPage.clickNoLEEDRegistration();
		ProjectRegistrationPage.selectSpaceType(data.getCellData("ProjectRegistration", 11, 2));
		ProjectRegistrationPage.selectOwnerType(data.getCellData("ProjectRegistration", 12, 2));
		ProjectRegistrationPage.selectOwnerOrg(data.getCellData("ProjectRegistration", 13, 2));
		ProjectRegistrationPage.enterOwnerEmail(data.getCellData("ProjectRegistration", 14, 2));
		ProjectRegistrationPage.selectCountry(data.getCellData("ProjectRegistration", 15, 2));

		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		BuildingPage = ProjectRegistrationPage.ClickonBuildingsAddProjectButton();
		try {

			flag = ProjectRegistrationPage.CheckGrossAreaValidationMsg();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		log.info("ProjectRegistration_BuildingsGrossArea_Invalid_20500000_SQ_Feet method ends here ........... ");

	}

	// Verify Buildings adding Gross area - limit allowed is Max: 1,904,514 square
	// meters

	@Test(groups = {
			"BuildingsRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 33, enabled = true, description = " Verify Buildings adding Gross area - limit allowed is Max: 1,904,514 square meters")
	public void ProjectRegistration_BuildingsGrossArea_Valid_1904514_SQ_MT() {
		log.info("ProjectRegistration_BuildingsGrossArea_Valid_1904514_SQ_MT method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean flag = false;
		HomePage.clickOnProject();
		HomePage.clickOnBuildingSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 9, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectBuildingProjectType();
		ProjectRegistrationPage.SelectUnitType("square meters");
		ProjectRegistrationPage.enterGrossArea("1904514");

		try {

			flag = ProjectRegistrationPage.CheckGrossAreaValidationMsg();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		// ProjectRegistrationPage.closeProjectButton();
		log.info("ProjectRegistration_BuildingsGrossArea_Valid_1904514_SQ_MT method ends here ........... ");

	}

	// Verify Buildings adding invalid Gross area - 1,904,515 square meters should
	// display validation message

	@Test(groups = {
			"BuildingsRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 34, enabled = true, description = " Verify Buildings adding invalid Gross area -  1,904,515 square meters should display validation message")
	public void ProjectRegistration_BuildingsGrossArea_Invalid_1904515_SQ_MT() {
		log.info("ProjectRegistration_BuildingsGrossArea_Invalid_1904515_SQ_MT method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean flag = false;
		HomePage.clickOnProject();
		HomePage.clickOnBuildingSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 9, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectBuildingProjectType();

		ProjectRegistrationPage.enterGrossArea("1904515");
		ProjectRegistrationPage.SelectUnitType("square meters");

		ProjectRegistrationPage.clickNoLEEDRegistration();
		ProjectRegistrationPage.selectSpaceType(data.getCellData("ProjectRegistration", 11, 2));
		ProjectRegistrationPage.selectOwnerType(data.getCellData("ProjectRegistration", 12, 2));
		ProjectRegistrationPage.selectOwnerOrg(data.getCellData("ProjectRegistration", 13, 2));
		ProjectRegistrationPage.enterOwnerEmail(data.getCellData("ProjectRegistration", 14, 2));
		ProjectRegistrationPage.selectCountry(data.getCellData("ProjectRegistration", 15, 2));

		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		BuildingPage = ProjectRegistrationPage.ClickonBuildingsAddProjectButton();

		try {

			flag = ProjectRegistrationPage.CheckGrossAreaValidationMsg();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		// ProjectRegistrationPage.closeProjectButton();
		log.info("ProjectRegistration_BuildingsGrossArea_Invalid_1904515_SQ_MT method ends here ........... ");

	}

	// Verify 'Owner organization' field by adding a letter should give suggested
	// values from the database.

	@Test(groups = {
			"BuildingsRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 35, enabled = true, description = "Verify 'Owner organization' field by adding a letter should give suggested values from the database.")
	public void ProjectRegistration_OwnerOrganization_AutoSuggestion() {
		log.info("ProjectRegistration_OwnerOrganization_AutoSuggestion method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean flag = false;
		HomePage.clickOnProject();
		HomePage.clickOnBuildingSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 9, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectBuildingProjectType();
		ProjectRegistrationPage.enterGrossArea("1904515");
		ProjectRegistrationPage.SelectUnitType("square meters");
		ProjectRegistrationPage.clickNoLEEDRegistration();
		ProjectRegistrationPage.selectSpaceType(data.getCellData("ProjectRegistration", 11, 2));
		ProjectRegistrationPage.selectOwnerType(data.getCellData("ProjectRegistration", 12, 2));
		int totalOwnerName = ProjectRegistrationPage
				.CheckOwnerOrgAutoSuggetion(data.getCellData("ProjectRegistration", 13, 2));
		log.info("Total Suggestion showing is ---" + totalOwnerName);
		if (totalOwnerName > 0) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		log.info("ProjectRegistration_OwnerOrganization_AutoSuggestion method ends here ........... ");

	}

	// Verify 'Owner Email' field gives error if @ and 2 letters after . are
	// missing.

	@Test(groups = {
			"BuildingsRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 36, enabled = true, description = "Verify 'Owner Email' field gives error if @ and 2 letters after . are missing")
	public void ProjectRegistration_InvalidEmailCheck() {
		log.info("ProjectRegistration_InvalidEmailCheck method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean flag = false;
		HomePage.clickOnProject();
		HomePage.clickOnBuildingSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 9, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectBuildingProjectType();
		ProjectRegistrationPage.enterGrossArea("1904515");
		ProjectRegistrationPage.SelectUnitType("square meters");
		ProjectRegistrationPage.clickNoLEEDRegistration();
		ProjectRegistrationPage.selectSpaceType(data.getCellData("ProjectRegistration", 11, 2));
		ProjectRegistrationPage.selectOwnerType(data.getCellData("ProjectRegistration", 12, 2));
		flag = ProjectRegistrationPage.CheckInvalidEmail();
		if (flag) {
			log.info("ProjectRegistration_InvalidEmailCheck method ends here ........... ");
			Assert.assertTrue(true);
		} else {
			log.info("ProjectRegistration_InvalidEmailCheck method ends here ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify Project Location(City,Country,State and zipcode) gets auto populated
	// from google maps API. Verify this by adding 3-4 characters of the address.

	@Test(groups = {
			"BuildingsRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 37, enabled = true, description = "Verify Project Location(City,Country,State and zipcode) gets auto populated from google maps API. Verify this by adding 3-4 characters of the address.")
	public void ProjectRegistration_ProjectLocation_AutoPopulate() {
		log.info("ProjectRegistration_ProjectLocation_AutoPopulate method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean flag = false;
		HomePage.clickOnProject();
		HomePage.clickOnBuildingSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 9, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectBuildingProjectType();
		ProjectRegistrationPage.enterGrossArea("1904515");
		ProjectRegistrationPage.SelectUnitType("square meters");
		ProjectRegistrationPage.selectSpaceType(data.getCellData("ProjectRegistration", 11, 2));
		ProjectRegistrationPage.selectOwnerType(data.getCellData("ProjectRegistration", 12, 2));
		ProjectRegistrationPage.selectOwnerOrg(data.getCellData("ProjectRegistration", 13, 2));
		ProjectRegistrationPage.enterOwnerEmail(data.getCellData("ProjectRegistration", 14, 2));
		ProjectRegistrationPage.selectCountry(data.getCellData("ProjectRegistration", 15, 2));
		int totalAddress = ProjectRegistrationPage.CheckLocationAutoPopulate("2101");
		log.info("Total Suggestion showing is ---" + totalAddress);
		if (totalAddress > 0) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		log.info("ProjectRegistration_ProjectLocation_AutoPopulate method ends here ........... ");

	}

	// Verify 'Add Project' button is disabled until checkbox for 'Agreement' is
	// selected.

	@Test(groups = {
			"BuildingsRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 38, enabled = true, description = " Verify 'Add Project' button is disabled until checkbox for 'Agreement' is selected.")
	public void ProjectRegistration_Check_AddButton_Disabled() {
		log.info("ProjectRegistration_Check_AddButton_Disabled method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean BeforeAddbuttonEnabled = false;
		boolean AfterAddbuttonEnabled = false;
		HomePage.clickOnProject();
		HomePage.clickOnBuildingSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 9, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectBuildingProjectType();
		ProjectRegistrationPage.enterGrossArea("1904515");
		ProjectRegistrationPage.SelectUnitType("square meters");
		ProjectRegistrationPage.clickNoLEEDRegistration();
		ProjectRegistrationPage.selectSpaceType(data.getCellData("ProjectRegistration", 11, 2));
		ProjectRegistrationPage.selectOwnerType(data.getCellData("ProjectRegistration", 12, 2));
		ProjectRegistrationPage.selectOwnerOrg(data.getCellData("ProjectRegistration", 13, 2));
		ProjectRegistrationPage.enterOwnerEmail(data.getCellData("ProjectRegistration", 14, 2));
		ProjectRegistrationPage.selectCountry(data.getCellData("ProjectRegistration", 15, 2));
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
		BeforeAddbuttonEnabled = ProjectRegistrationPage.CheckAddButtonEnabled();

		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		AfterAddbuttonEnabled = ProjectRegistrationPage.CheckAddButtonEnabled();

		if (BeforeAddbuttonEnabled == false && AfterAddbuttonEnabled == true) {
			log.info(" BeforeAddbuttonEnabled flag is --" + BeforeAddbuttonEnabled
					+ " and  AfterAddbuttonEnabled flag is --" + AfterAddbuttonEnabled);
			log.info("ProjectRegistration_Check_AddButton_Disabled method ended ........... ");
			Assert.assertTrue(true);
		} else {
			log.info(" BeforeAddbuttonEnabled flag is --" + BeforeAddbuttonEnabled
					+ " and  AfterAddbuttonEnabled flag is --" + AfterAddbuttonEnabled);
			log.info("ProjectRegistration_Check_AddButton_Disabled method ended ........... ");
			Assert.assertTrue(false);
		}

	}

	// Verify checkbox 'This is a test project'.

	@Test(groups = {
			"BuildingsRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 39, enabled = true, description = "Verify checkbox 'This is a test project'.")
	public void Buildings_TestProject_Creation() {
		log.info("Buildings_TestProject_Creation method started ........... ");
		String ProjectBuildingID = "";
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		HomePage.clickOnProject();
		HomePage.clickOnBuildingSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String BuildingProjectName = data.getCellData("ProjectRegistration", 9, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.SelectThisIsTestProjectCheckBox();
		ProjectRegistrationPage.enterProjectName(BuildingProjectName);
		ProjectRegistrationPage.SelectBuildingProjectType();
		ProjectRegistrationPage.enterGrossArea("1904514");
		ProjectRegistrationPage.SelectUnitType("square meters");
		ProjectRegistrationPage.clickNoLEEDRegistration();
		ProjectRegistrationPage.selectSpaceType(data.getCellData("ProjectRegistration", 11, 2));
		ProjectRegistrationPage.selectOwnerType(data.getCellData("ProjectRegistration", 12, 2));
		ProjectRegistrationPage.selectOwnerOrg(data.getCellData("ProjectRegistration", 13, 2));
		ProjectRegistrationPage.enterOwnerEmail(data.getCellData("ProjectRegistration", 14, 2));
		ProjectRegistrationPage.selectCountry(data.getCellData("ProjectRegistration", 15, 2));
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();

		BuildingPage = ProjectRegistrationPage.ClickonBuildingsAddProjectButton();

		boolean flag = BuildingPage.checkBuildingProjectCreation(BuildingProjectName);
		if (flag) {
			BuildingPage.ClickonProjectInManage();
			ProjectBuildingID = BuildingPage.getProjectID(BuildingProjectName);
			System.setProperty("BuildingProject_Test1", ProjectBuildingID);
			log.info("  BuildingProject_Test1 is ---" + ProjectBuildingID);

			if (BuildingPage.CheckThisIsTestProjectCheckBox(ProjectBuildingID)) {
				log.info("This is test project creation done successfully ........... ");
				log.info("Buildings_TestProject_Creation method ends with true here ........... ");
				Assert.assertTrue(true);
			} else {
				log.info("This is Test Project checkbox is not checked..................");
				log.info("Buildings_TestProject_Creation method ends with false here ........... ");
				Assert.assertTrue(false);
			}
		} else {
			log.info("Project Creation gets failed..........");
			log.info("Buildings_TestProject_Creation method ends with false here ........... ");
			Assert.assertTrue(false);
		}

		log.info("Buildings_TestProject_Creation method ends here ........... ");

	}

	// Verify if 'project is private' is selected, shows private as 'Yes' under
	// Manage--project.

	@Test(groups = {
			"BuildingsRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 40, enabled = true, description = "Verify if 'project is private' is selected, shows private as 'Yes' under Manage--project.")
	public void Buildings_Project_Is_Private_Creation() {
		log.info("Buildings_Project_Is_Private_Creation method started ........... ");
		String ProjectBuildingID = "";
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		HomePage.clickOnProject();
		HomePage.clickOnBuildingSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String BuildingProjectName = data.getCellData("ProjectRegistration", 9, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(BuildingProjectName);
		ProjectRegistrationPage.SelectBuildingProjectType();
		ProjectRegistrationPage.enterGrossArea("1904514");
		ProjectRegistrationPage.SelectUnitType("square meters");

		ProjectRegistrationPage.clickNoLEEDRegistration();
		ProjectRegistrationPage.selectSpaceType(data.getCellData("ProjectRegistration", 11, 2));
		ProjectRegistrationPage.selectOwnerType(data.getCellData("ProjectRegistration", 12, 2));
		ProjectRegistrationPage.selectOwnerOrg(data.getCellData("ProjectRegistration", 13, 2));
		ProjectRegistrationPage.enterOwnerEmail(data.getCellData("ProjectRegistration", 14, 2));
		ProjectRegistrationPage.selectCountry(data.getCellData("ProjectRegistration", 15, 2));
		ProjectRegistrationPage.SelectProjectIsPrivateCheckBox();
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();

		BuildingPage = ProjectRegistrationPage.ClickonBuildingsAddProjectButton();

		boolean flag = BuildingPage.checkBuildingProjectCreation(BuildingProjectName);
		if (flag) {
			BuildingPage.ClickonProjectInManage();
			ProjectBuildingID = BuildingPage.getProjectID(BuildingProjectName);
			System.setProperty("BuildingProject_Private3", ProjectBuildingID);
			log.info("  BuildingProject_Private3 is ---" + ProjectBuildingID);

			if (BuildingPage.CheckProjectIsPrivateFlagUnderManage(ProjectBuildingID)) {
				log.info("This is Private project creation done successfully ........... ");
				log.info("Buildings_Project_Is_Private_Creation method ends with true here ........... ");
				Assert.assertTrue(true);
			} else {
				log.info("This is Private Project checkbox is not checked..................");
				log.info("Buildings_Project_Is_Private_Creation method ends with false here ........... ");
				Assert.assertTrue(false);
			}
		} else {
			log.info("Project Creation gets failed..........");
			log.info("Buildings_Project_Is_Private_Creation method ends with false here ........... ");
			Assert.assertTrue(false);
		}

		log.info("Buildings_Project_Is_Private_Creation method ends here ........... ");
	}

	// Verify clicking on 'Add project' button redirects to newly registered project
	// at 'Overview' Tab.

	@Test(groups = {
			"BuildingsRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 41, enabled = true, description = "Verify clicking on 'Add project' button redirects to newly registered project at 'Overview' Tab.")
	public void Buildings_Project_Creation_Opens_Overview_Screen() {
		log.info("Buildings_Project_Creation_Opens_Overview_Screen method started ........... ");
		String ProjectBuildingID = "";
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		HomePage.clickOnProject();
		HomePage.clickOnBuildingSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String BuildingProjectName = data.getCellData("ProjectRegistration", 9, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(BuildingProjectName);
		ProjectRegistrationPage.SelectBuildingProjectType();
		ProjectRegistrationPage.enterGrossArea("1904514");
		ProjectRegistrationPage.SelectUnitType("square meters");

		ProjectRegistrationPage.clickNoLEEDRegistration();
		ProjectRegistrationPage.selectSpaceType(data.getCellData("ProjectRegistration", 11, 2));
		ProjectRegistrationPage.selectOwnerType(data.getCellData("ProjectRegistration", 12, 2));
		ProjectRegistrationPage.selectOwnerOrg(data.getCellData("ProjectRegistration", 13, 2));
		ProjectRegistrationPage.enterOwnerEmail(data.getCellData("ProjectRegistration", 14, 2));
		ProjectRegistrationPage.selectCountry(data.getCellData("ProjectRegistration", 15, 2));
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();

		BuildingPage = ProjectRegistrationPage.ClickonBuildingsAddProjectButton();

		boolean flag = BuildingPage.checkBuildingProjectCreation(BuildingProjectName);
		String HeaderText = BuildingPage.CheckOverviewHeaderShowing();
		if (flag) {
			BuildingPage.ClickonProjectInManage();
			ProjectBuildingID = BuildingPage.getProjectID(BuildingProjectName);
			System.setProperty("BuildingProject_Perf4", ProjectBuildingID);
			log.info("  BuildingProject_Perf4 is ---" + ProjectBuildingID);
			if (HeaderText.equals("Overview")) {
				Assert.assertTrue(true);
			} else {
				log.info("Overview screen not showing..................");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Project Creation gets failed..........");
			Assert.assertTrue(false);
		}

		log.info("Buildings_Project_Creation_Opens_Overview_Screen method ends here ........... ");
	}

}
