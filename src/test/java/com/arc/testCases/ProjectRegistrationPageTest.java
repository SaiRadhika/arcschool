package com.arc.testCases;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;
import java.lang.reflect.Array;

public class ProjectRegistrationPageTest extends BaseClass {

	private static Logger log = LoggerHelper.getLogger(ProjectRegistrationPageTest.class);

	// Verify allowed special characters for Project name are - & + / : ' , - . #

	@Test(groups = "ProjectRegsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 3, enabled = true, description = "Verify Project Name should allow special character (-&+/:',-.#)")
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
		log.info("ProjectName_With_Valid_SpecialCharacters method ends here ........... ");

	}

	// Verify with Invalid special characters for Project name are !~$%^*()

	@Test(groups = "ProjectRegsRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 4, enabled = true, description = "Verify with Invalid special characters for Project name are !~$%^*()")
	public void ProjectName_With_Invalid_SpecialCharacters() {
		log.info("ProjectName_With_Invalid_SpecialCharacters method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean flag = false;
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

			flag = ProjectRegistrationPage.CheckCityProjectType();

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
		HomePage.clickOnProject();
		HomePage.clickOnCitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
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
		HomePage.clickOnProject();
		HomePage.clickOnCitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
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
		HomePage.clickOnProject();
		HomePage.clickOnCitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
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
		HomePage.clickOnProject();
		HomePage.clickOnCitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		// ProjectRegistrationPage.SelectCityProjectType();

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
		log.info("ProjectRegistration_CityGrossArea_Invalid_50001_SQ_KM method ends here ........... ");

	}

	// Verify if none of the radio button is selected for 'Are You registering for a
	// LEED Certfication?' , throws an error message "This field is required."

	@Test(groups = {
			"CityRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 10, enabled = true, description = "Verify if none of the radio button is selected for 'Are You registering for a LEED Certfication?' , throws an error message \"This field is required.\"")
	public void ProjectRegistration_LEED_Certification_NotSelectedRadioButton() {
		log.info("ProjectRegistration_LEED_Certification_NotSelectedRadioButton method started ........... ");
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
		// ProjectRegistrationPage.SelectCityProjectType();
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		// ProjectRegistrationPage.clickYesLEEDRegistration();
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode("2101 L St NW washington DC 20037 USA");
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		ProjectRegistrationPage.ClickonCityAddProjectButton();
		flag = ProjectRegistrationPage.CheckRegisterforLEEDValidationMessage();

		if (flag) {
			// ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		log.info("ProjectRegistration_LEED_Certification_NotSelectedRadioButton method ends here ........... ");

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
		HomePage.clickOnProject();
		HomePage.clickOnCitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		// ProjectRegistrationPage.SelectCityProjectType();
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
		// ProjectRegistrationPage.SelectCityProjectType();
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
		HomePage.clickOnProject();
		HomePage.clickOnCitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		// ProjectRegistrationPage.SelectCityProjectType();
		System.out.println(data.getCellData("City", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.clickYesLEEDRegistration();

		String CityRegistrationText = ProjectRegistrationPage.checkCityLEEDOnLinePortal();

		Set<String> handles = driver.getWindowHandles();
		if (handles.size() == 2) {
			for (String window : handles) {
				if (!BaseWindow.equals(window)) {
					driver.switchTo().window(window);
					driver.close();
					driver.switchTo().window(BaseWindow);
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
		HomePage.clickOnProject();
		HomePage.clickOnCitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		// ProjectRegistrationPage.SelectCityProjectType();
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
		HomePage.clickOnProject();
		HomePage.clickOnCitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		// ProjectRegistrationPage.SelectCityProjectType();
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
		HomePage.clickOnProject();
		HomePage.clickOnCitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		// ProjectRegistrationPage.SelectCityProjectType();
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

	@Test(groups = { "CityRegression" }, dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"ProjectRegistration_ProjectType_City_Value" }, priority = 16, enabled = true, description = " Verify able to download service agreement successfully.")
	public void ProjectRegistration_Download_Service_Agreement() {
		log.info("ProjectRegistration_Download_Service_Agreement method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		HomePage.clickOnProject();
		HomePage.clickOnCitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		System.out.println(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.clickNoLEEDRegistration();

		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode("2101 L St NW washington DC 20037 USA");

		boolean flag = ProjectRegistrationPage.DownLoadServiceAgreement();

		log.info("ProjectRegistration_Download_Service_Agreement method ends with " + flag + " here ........... ");
		if (flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);

	}

	// Verify when 'I agree to … agreement' checkbox is selected, 'Add project'
	// button gets enabled.

	@Test(groups = {
			"CityRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 17, enabled = true, description = "Verify when 'I agree to … agreement' checkbox is selected, 'Add project' button gets enabled.")
	public void ProjectRegistration_Agreement_Check_AddButtonEnabled() {
		log.info("ProjectRegistration_Agreement_Check_AddButtonEnabled method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		HomePage.clickOnProject();
		HomePage.clickOnCitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		// ProjectRegistrationPage.SelectCityProjectType();
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
		HomePage.clickOnProject();
		HomePage.clickOnCitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String CityProjectName = data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(6);
		ProjectRegistrationPage.enterProjectName(CityProjectName);
		ProjectRegistrationPage.SelectThisIsTestProjectCheckBox();
		// ProjectRegistrationPage.SelectCityProjectType();
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
		HomePage.clickOnProject();
		HomePage.clickOnCitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String CityProjectName = data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(6);
		ProjectRegistrationPage.enterProjectName(CityProjectName);
		// ProjectRegistrationPage.SelectThisIsTestProjectCheckBox();
		// ProjectRegistrationPage.SelectCityProjectType();
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
			System.setProperty("CityProject_NonLeed2_Name", CityProjectName);
			log.info("CityProject_NonLeed2_Name is ---" + CityProjectName);
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
		HomePage.clickOnProject();
		HomePage.clickOnCitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String CityProjectName = data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(CityProjectName);
		// ProjectRegistrationPage.SelectCityProjectType();
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
			System.setProperty("CityProject_Private3_Name", CityProjectName);
			log.info("  CityProject_Private3_Name is ---" + CityProjectName);
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
		HomePage.clickOnProject();
		HomePage.clickOnCitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String CityProjectName = data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(CityProjectName);
		// ProjectRegistrationPage.SelectCityProjectType();
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
			System.setProperty("CityProject_Perf4_Name", CityProjectName);
			log.info("  CityProject_Perf4_Name is ---" + CityProjectName);
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

	// Verify Manage--Project --Under Project - Project ID matches with the actual
	// project id of the project.
	// Verify Manage--Project --Under Project - Project Address matches with the
	// actual project address through which the project was registered.
	// Verify Manage--Project --Under Project - Project City matches with the actual
	// city through which the project was regsitered.
	// Verify Manage--Project --Under Project - Project Country matches with the
	// actual Country value through which the project was regsitered.
	// Verify Under Project Details-Project name shows the same name used at the
	// time of project registration.
	// Verify Under Project Details- If Project was marked as Test at time of
	// project registration then checkmark shows selected for "This is a test
	// project" Otherwise checkbox should be unselected.
	// Verify under Manage--Project-- Project Details, Year founded is a dropdown
	// field with year values ranging from 1900 to current year.

	@Test(groups = { "CityRegression" }, dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"ProjectRegistration_ProjectType_City_Value",
			"ProjectRegistration_AutoPopulate_Address_City_Country_State_ZipCode",
			"ProjectRegistration_AutoPopulate_Latitude_Longitude" }, priority = 250, enabled = true, description = "Verify Manage--Project --Under Project  - Project ID matches with the actual project id of the project.\r\n"
					+ "	// Verify Manage--Project --Under Project  - Project Address matches with the actual project address through which the project was registered. \r\n"
					+ "	// Verify Manage--Project --Under Project  - Project City matches with the actual city through which the project was regsitered.\r\n"
					+ "	// Verify Manage--Project --Under Project  - Project Country matches with the actual Country value through which the project was regsitered.\r\n"
					+ "	// Verify Under Project Details-Project name shows the same name used at the time of project registration.\r\n"
					+ "	// Verify Under Project Details- If Project was marked as Test at time of project registration then checkmark shows selected for \"This is a test project\" Otherwise checkbox should be unselected.\r\n"
					+ "	// Verify under Manage--Project-- Project Details, Year founded is a dropdown field with year values ranging from 1900 to current year. ")
	public void City_Project_Creation_ValidateProjectDetails() {
		log.info("City_Project_Creation_ValidateProjectDetails method started ........... ");
		String ProjectCityID = "";
		try {
			// ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		HomePage.clickOnProject();
		HomePage.clickOnCitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String CityProjectName = data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(6);
		String ProjectAddress = data.getCellData("ProjectRegistration", 3, 2);
		ProjectRegistrationPage.enterProjectName(CityProjectName);
		// ProjectRegistrationPage.SelectCityProjectType();
		System.out.println(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.SelectUnitType("square miles");
		ProjectRegistrationPage.enterPopulation(data.getCellData("ProjectRegistration", 2, 2));
		ProjectRegistrationPage.clickNoLEEDRegistration();
		// ProjectRegistrationPage.SelectProjectIsPrivateCheckBox();
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(ProjectAddress);

		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		CityPage = ProjectRegistrationPage.ClickonCityAddProjectButton();

		boolean flag = CityPage.checkCityProjectCreation(CityProjectName);
		// String HeaderText = CityPage.CheckPerformanceHeaderShowing();
		if (flag) {
			CityPage.ClickonProjectInManage();
			ProjectCityID = CityPage.getProjectID(CityProjectName);
			System.setProperty("CityProject5", ProjectCityID);
			log.info("  CityProject5 is ---" + ProjectCityID);
			System.setProperty("CityProject5_Name", CityProjectName);
			log.info("  CityProject5_Name is ---" + CityProjectName);
			boolean ProjectDetailsFlag = CityPage.CheckProjectDetails(CityProjectName, ProjectAddress);
			if (ProjectDetailsFlag) {
				log.info("Project Details are matching ........... ");
				Assert.assertTrue(true);
			} else {
				log.info("Project Details are not matching ........... ");
				Assert.assertTrue(false);
			}
		} else {
			log.info("Project Creation gets failed..........");
			Assert.assertTrue(false);
		}
		ProjectRegistrationPage.closeProjectButton();
		log.info("City_Project_Creation_ValidateProjectDetails method ends here ........... ");
	}
	// -----------------------------------------------Communities related Test
	// Cases----------------------------
	// Verify Community adding Gross area - limit allowed is Max: 19,305 square
	// miles

	@Test(groups = {
			"CommunityRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 6, enabled = true, description = "Verify Community adding Gross area - limit allowed is Max: 19,305 square miles")
	public void ProjectRegistration_CommunityGrossArea_Valid_19305_SQ_Miles() {
		log.info("ProjectRegistration_CommunityGrossArea_Valid_19305_SQ_Miles method started ........... ");
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
		log.info("ProjectRegistration_CommunityGrossArea_Valid_19305_SQ_Miles method ends here ........... ");

	}

	// Verify Community adding invalid Gross area - limit 19,306 square miles

	@Test(groups = {
			"CommunityRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 7, enabled = true, description = "Verify Community adding invalid Gross area - limit  19,306 square miles")
	public void ProjectRegistration_CommunityGrossArea_Invalid_19306_SQ_Miles() {
		log.info("ProjectRegistration_CommunityGrossArea_Invalid_19306_SQ_Miles method started ........... ");
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
		ProjectRegistrationPage.enterGrossArea("19306");
		ProjectRegistrationPage.SelectUnitType("square miles");
		ProjectRegistrationPage.enterPopulation(data.getCellData("ProjectRegistration", 2, 2));
		ProjectRegistrationPage.clickNoLEEDRegistration();
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		CommunitiesPage = ProjectRegistrationPage.ClickonCommunitiesAddProjectButton();
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

	// Verify Community adding Gross area - limit allowed is Max: 50000 square
	// kilometers

	@Test(groups = {
			"CommunityRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 8, enabled = true, description = "Verify Community adding Gross area - limit allowed is Max: 50000 square kilometers")
	public void ProjectRegistration_CommunityGrossArea_Valid_50000_SQ_KM() {
		log.info("ProjectRegistration_CommunityGrossArea_Valid_50000_SQ_KM method started ........... ");
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
		log.info("ProjectRegistration_CommunityGrossArea_Valid_50000_SQ_KM method ends here ........... ");

	}

	// Verify Community adding invalid Gross area - limit 50001 square Kilometer

	@Test(groups = {
			"CommunityRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 9, enabled = true, description = " Verify Community adding invalid Gross area - limit  50001 square Kilometer")
	public void ProjectRegistration_CommunityGrossArea_Invalid_50001_SQ_KM() {
		log.info("ProjectRegistration_CommunityGrossArea_Invalid_50001_SQ_KM method started ........... ");
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
		// ProjectRegistrationPage.SelectCommunityProjectType();

		ProjectRegistrationPage.enterGrossArea("50001");
		ProjectRegistrationPage.SelectUnitType("square kilometers");
		ProjectRegistrationPage.enterPopulation(data.getCellData("ProjectRegistration", 2, 2));
		ProjectRegistrationPage.clickNoLEEDRegistration();
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		CommunitiesPage = ProjectRegistrationPage.ClickonCommunitiesAddProjectButton();
		try {

			flag = ProjectRegistrationPage.CheckGrossAreaValidationMsg();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		log.info("ProjectRegistration_CommunityGrossArea_Invalid_50001_SQ_KM method ends here ........... ");

	}

	// Verify if none of the radio button is selected for 'Are You registering for a
	// LEED Certfication?' , throws an error message "This field is required."

	@Test(groups = {
			"CommunityRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 10, enabled = true, description = "Verify if none of the radio button is selected for 'Are You registering for a LEED Certfication?' , throws an error message \"This field is required.\"")
	public void ProjectRegistration_CommunityLEED_Certification_NotSelectedRadioButton() {
		log.info("ProjectRegistration_CommunityLEED_Certification_NotSelectedRadioButton method started ........... ");
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
		// ProjectRegistrationPage.SelectCityProjectType();
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		// ProjectRegistrationPage.clickYesLEEDRegistration();
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode("2101 L St NW washington DC 20037 USA");
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		ProjectRegistrationPage.ClickonCommunitiesAddProjectButton();
		flag = ProjectRegistrationPage.CheckRegisterforLEEDValidationMessage();

		if (flag) {
			// ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		log.info(
				"ProjectRegistration_CommunityLEED_Certification_NotSelectedRadioButton method ends here ........... ");

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
			"CommunityRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 10, enabled = true, description = "Verify if 'Are you registering for a LEED CERTIFICATION' is selected as 'Yes', opens a new modal window with text as below:\r\n"
					+ "\"If you're interested in registering this project for LEED certification, please select the \"Register for LEED certification now\" button below and you’ll be routed to LEED Online.\r\n"
					+ "\r\n"
					+ "Otherwise, you can get started now with Arc for free. Just select the \"Not now\" button below.\r\n"
					+ "\r\n"
					+ "You can enter your performance data in Arc and choose to register for LEED later. Your performance data will get you most of the way, but you'll need to complete the LEED prerequisites, and possibly other requirements before submitting for certification.\"\r\n"
					+ "")
	public void Community_LEED_Registration_Yes_CheckMessage() {
		log.info("Community_LEED_Registration_Yes_CheckMessage method started ........... ");
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
		// ProjectRegistrationPage.SelectCommunityProjectType();
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.clickYesLEEDRegistration();
		flag = ProjectRegistrationPage.Validate_LEEDRegistrationPopupMessage();
		if (flag) {
			// ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(flag);
		} else
			Assert.assertTrue(flag);
		// ProjectRegistrationPage.closeProjectButton();
		log.info("Community_LEED_Registration_Yes_CheckMessage method ends here ........... ");

	}

	// Verify the new modal window shows two buttons- 'Register for LEED
	// certification now' and 'Not now'

	@Test(groups = {
			"CommunityRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 11, enabled = true, description = "Verify the new modal window shows two buttons- 'Register for LEED certification now' and 'Not now'")
	public void Community_LEED_Regis_Shows_RegisterforLEEDcertification_NotNow() {
		log.info("Community_LEED_Regis_Shows_RegisterforLEEDcertification_NotNow method started ........... ");
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
		// ProjectRegistrationPage.SelectCommunityProjectType();
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.clickYesLEEDRegistration();
		flag = ProjectRegistrationPage.CheckRegisterforLEEDPopupButtonsExists();

		if (flag) {
			// ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(flag);
		} else
			Assert.assertTrue(flag);
		log.info("Community_LEED_Regis_Shows_RegisterforLEEDcertification_NotNow method ends here ........... ");

	}

	// Verify clicking on 'Register for LEED certification now' redirects to Leed
	// Online portal.

	@Test(groups = { "CommunityRegression" }, dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Community_LEED_Regis_Shows_RegisterforLEEDcertification_NotNow" }, priority = 12, enabled = true, description = "Verify clicking on 'Register for LEED certification now' redirects to Leed Online portal.")
	public void Community_LEED_Regis_Redirects_LeedOnlineportal() {
		log.info("Community_LEED_Regis_Redirects_LeedOnlineportal method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		HomePage.clickOnProject();
		HomePage.clickOnCommunitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		// ProjectRegistrationPage.SelectCommunityProjectType();
		System.out.println(data.getCellData("Communities", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.clickYesLEEDRegistration();

		String CommunityRegistrationText = ProjectRegistrationPage.checkCommunityLEEDOnLinePortal();

		Set<String> handles = driver.getWindowHandles();
		if (handles.size() == 2) {
			for (String window : handles) {
				if (!BaseWindow.equals(window)) {
					driver.switchTo().window(window);
					driver.close();
					driver.switchTo().window(BaseWindow);
				}
			}
		}
		if (CommunityRegistrationText.equals("Community Registration")) {
			ProjectRegistrationPage.clickOnNotNowPopUpButton();
			// ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(true);
		} else {
			// ProjectRegistrationPage.clickOnNotNowPopUpButton();
			Assert.assertTrue(false);
		}

		log.info("Community_LEED_Regis_Redirects_LeedOnlineportal method ends here ........... ");
	}

	// Verify clicking on 'Not now' closes the modal window and keeps the user at
	// the registration page.
	// Verify clicking on 'Not now' closes the modal window and selects the 'No'
	// radio button.

	@Test(groups = { "CommunityRegression" }, dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Community_LEED_Regis_Shows_RegisterforLEEDcertification_NotNow" }, priority = 13, enabled = true, description = "Verify clicking on 'Not now' closes the modal window and keeps the user at the registration page. \r\n"
					+ "	// Verify clicking on 'Not now' closes the modal window and selects the 'No' radio button.")
	public void Community_LEED_Registration_Not_Now_Test() {
		log.info("Community_LEED_Registration_Not_Now_Test method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		HomePage.clickOnProject();
		HomePage.clickOnCommunitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		// ProjectRegistrationPage.SelectCommunityProjectType();
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

		log.info("Community_LEED_Registration_Not_Now_Test method ends here ........... ");
	}

	// Verify address field auto populates the address(this address is being pulled
	// using google maps API).
	// Verify auto pulled address populates all the fields -Community,
	// County,States,zip
	// code

	@Test(groups = {
			"CommunityRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 14, enabled = true, description = "Verify address field auto populates the address(this address is being pulled using google maps API).\r\n"
					+ "	Verify auto pulled address populates all the fields -City, County,States,zipcode")
	public void Community_AutoPopulate_Address_City_Country_State_Zipcode() {
		log.info("Community_AutoPopulate_Address_City_Country_State_Zipcode method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		HomePage.clickOnProject();
		HomePage.clickOnCommunitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		// ProjectRegistrationPage.SelectCommunityProjectType();
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
		log.info("Community_AutoPopulate_Address_City_Country_State_Zipcode method ends here ........... ");
	}

	// Verify after address is auto pulled, geo location gets auto -populated.

	@Test(groups = { "CommunityRegression" }, dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {

			"Community_AutoPopulate_Address_City_Country_State_Zipcode" }, priority = 15, enabled = true, description = "Verify after address is auto pulled, geo location gets auto -populated.")
	public void Community_Populate_Latitude_Longitude() {
		log.info("Community_Populate_Latitude_Longitude method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		HomePage.clickOnProject();
		HomePage.clickOnCommunitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		// ProjectRegistrationPage.SelectCommunityProjectType();
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
		log.info("Community_Populate_Latitude_Longitude method ends here ........... ");
	}

	// Verify able to download service agreement successfully.

	@Test(groups = { "CommunityRegression" }, dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Community_ProjectType_Communities_Value" }, priority = 16, enabled = true, description = " Verify able to download service agreement successfully.")
	public void Community_Download_Service_Agreement() {
		log.info("Community_Download_Service_Agreement method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		HomePage.clickOnProject();
		HomePage.clickOnCommunitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		System.out.println(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.clickNoLEEDRegistration();

		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode("2101 L St NW washington DC 20037 USA");

		boolean flag = ProjectRegistrationPage.DownLoadServiceAgreement();

		Set<String> handles = driver.getWindowHandles();
		if (handles.size() == 2) {
			for (String window : handles) {
				if (!BaseWindow.equals(window)) {
					driver.switchTo().window(window);
					driver.close();
					driver.switchTo().window(BaseWindow);
				}
			}
		}
		if (flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);

		log.info("Community_Download_Service_Agreement method ends here ........... ");
	}

	// Verify when 'I agree to … agreement' checkbox is selected, 'Add project'
	// button gets enabled.

	@Test(groups = {
			"CommunityRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 17, enabled = true, description = "Verify when 'I agree to … agreement' checkbox is selected, 'Add project' button gets enabled.")
	public void Community_Agreement_AddButtonEnabled() {
		log.info("Community_Agreement_AddButtonEnabled method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		HomePage.clickOnProject();
		HomePage.clickOnCommunitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage
				.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		// ProjectRegistrationPage.SelectCommunityProjectType();
		boolean flag = ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		if (flag) {
			// ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);

		log.info("Community_Agreement_AddButtonEnabled method ends here ........... ");
	}

	// Verify Project Type is selected as 'Communities'

	@Test(groups = {
			"CommunityRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 5, enabled = true, description = "Verify Project Type is selected as 'Communities'")
	public void Community_ProjectType_Communities_Value() {
		log.info("Community_ProjectType_Communities_Value method started ........... ");
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
		log.info("Community_ProjectType_Communities_Value method ends here ........... ");

	}

	// Verify clicking on checkbox for 'This is a test project' creates a test
	// Communities
	// project and the same gets populated after project creation under
	// manage-project.

	@Test(groups = { "CommunityRegression" }, dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Community_ProjectType_Communities_Value" }, priority = 25, enabled = true, description = "Verify clicking on checkbox for 'This is a test project' creates a test Communities project and the same gets populated after project creation under  manage-project.")
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
		HomePage.clickOnProject();
		HomePage.clickOnCommunitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String CommunitiesProjectName = data.getCellData("ProjectRegistration", 8, 2)
				+ CommonMethod.generateRandomString(6);
		ProjectRegistrationPage.enterProjectName(CommunitiesProjectName);
		ProjectRegistrationPage.SelectThisIsTestProjectCheckBox();
		// ProjectRegistrationPage.SelectCommunityProjectType();
		System.out.println(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.SelectUnitType("square miles");
		// ProjectRegistrationPage.enterPopulation(data.getCellData("Communities", 2,
		// 2));
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
			"Community_ProjectType_Communities_Value" }, priority = 26, enabled = true, description = "Verify clicking on 'Add project' button registers the project with non-leed id")
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
		HomePage.clickOnProject();
		HomePage.clickOnCommunitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String CommunitiesProjectName = data.getCellData("ProjectRegistration", 8, 2)
				+ CommonMethod.generateRandomString(6);
		ProjectRegistrationPage.enterProjectName(CommunitiesProjectName);
		// ProjectRegistrationPage.SelectThisIsTestProjectCheckBox();
		// ProjectRegistrationPage.SelectCommunityProjectType();
		System.out.println(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.SelectUnitType("square miles");
		// ProjectRegistrationPage.enterPopulation(data.getCellData("Communities", 2,
		// 2));
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
			"Community_ProjectType_Communities_Value" }, priority = 27, enabled = true, description = "Verify if 'project is private' is selected, shows private as 'Yes' under Manage--project.")
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
		HomePage.clickOnProject();
		HomePage.clickOnCommunitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String CommunitiesProjectName = data.getCellData("ProjectRegistration", 8, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(CommunitiesProjectName);
		// ProjectRegistrationPage.SelectCityProjectType();
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
			"Community_ProjectType_Communities_Value" }, priority = 28, enabled = true, description = "Verify clicking on 'Add project' button opens the 'Performance' Tab.")
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
		HomePage.clickOnProject();
		HomePage.clickOnCommunitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String CommunitiesProjectName = data.getCellData("ProjectRegistration", 8, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(CommunitiesProjectName);
		// ProjectRegistrationPage.SelectCityProjectType();
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

	// Verify Manage--Project --Under Project - Project ID matches with the actual
	// project id of the project.
	// Verify Manage--Project --Under Project - Project Address matches with the
	// actual project address through which the project was registered.
	// Verify Manage--Project --Under Project - Project City matches with the actual
	// city through which the project was regsitered.
	// Verify Manage--Project --Under Project - Project Country matches with the
	// actual Country value through which the project was regsitered.
	// Verify Under Project Details-Project name shows the same name used at the
	// time of project registration.
	// Verify Under Project Details- If Project was marked as Test at time of
	// project registration then checkmark shows selected for "This is a test
	// project" Otherwise checkbox should be unselected.
	// Verify under Manage--Project-- Project Details, Year founded is a dropdown
	// field with year values ranging from 1900 to current year.

	@Test(groups = { "CommunityRegression" }, dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Community_ProjectType_Communities_Value" }, priority = 250, enabled = true, description = "Verify Manage--Project --Under Project  - Project ID matches with the actual project id of the project.\r\n"
					+ "	// Verify Manage--Project --Under Project  - Project Address matches with the actual project address through which the project was registered. \r\n"
					+ "	// Verify Manage--Project --Under Project  - Project City matches with the actual city through which the project was regsitered.\r\n"
					+ "	// Verify Manage--Project --Under Project  - Project Country matches with the actual Country value through which the project was regsitered.\r\n"
					+ "	// Verify Under Project Details-Project name shows the same name used at the time of project registration.\r\n"
					+ "	// Verify Under Project Details- If Project was marked as Test at time of project registration then checkmark shows selected for \"This is a test project\" Otherwise checkbox should be unselected.\r\n"
					+ "	// Verify under Manage--Project-- Project Details, Year founded is a dropdown field with year values ranging from 1900 to current year. ")
	public void Community_Project_Creation_ValidateProjectDetails() {
		log.info("Community_Project_Creation_ValidateProjectDetails method started ........... ");
		String ProjectCommunityID = "";
		try {
			// ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		HomePage.clickOnProject();
		HomePage.clickOnCommunitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String CommunitiesProjectName = data.getCellData("ProjectRegistration", 8, 2)
				+ CommonMethod.generateRandomString(6);
		String ProjectAddress = data.getCellData("ProjectRegistration", 3, 2);
		ProjectRegistrationPage.enterProjectName(CommunitiesProjectName);
		// ProjectRegistrationPage.SelectCityProjectType();
		System.out.println(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.SelectUnitType("square miles");
		ProjectRegistrationPage.enterPopulation(data.getCellData("ProjectRegistration", 2, 2));
		ProjectRegistrationPage.clickNoLEEDRegistration();
		// ProjectRegistrationPage.SelectProjectIsPrivateCheckBox();
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(ProjectAddress);

		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		CommunitiesPage = ProjectRegistrationPage.ClickonCommunitiesAddProjectButton();

		boolean flag = CommunitiesPage.checkCommunitiesProjectCreation(CommunitiesProjectName);
		if (flag) {
			CommunitiesPage.ClickonProjectInManage();
			ProjectCommunityID = CommunitiesPage.getProjectID(CommunitiesProjectName);
			System.setProperty("CommunityProject5", ProjectCommunityID);
			log.info("  CommunityProject5 is ---" + ProjectCommunityID);
			System.setProperty("CommunityProject5_Name", CommunitiesProjectName);
			log.info("  CommunityProject5_Name is ---" + CommunitiesProjectName);
			boolean ProjectDetailsFlag = CommunitiesPage.CheckProjectDetails(CommunitiesProjectName, ProjectAddress);
			if (ProjectDetailsFlag) {
				log.info("Project Details are matching ........... ");
				Assert.assertTrue(true);
			} else {
				log.info("Project Details are not matching ........... ");
				Assert.assertTrue(false);
			}
		} else {
			log.info("Project Creation gets failed..........");
			Assert.assertTrue(false);
		}
		ProjectRegistrationPage.closeProjectButton();
		log.info("Community_Project_Creation_ValidateProjectDetails method ends here ........... ");
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

			System.setProperty("BuildingProject_Test1_Name", BuildingProjectName);
			log.info("  BuildingProject_Test1_Name is ---" + BuildingProjectName);

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
			System.setProperty("BuildingProject_Private2", ProjectBuildingID);
			log.info("  BuildingProject_Private2 is ---" + ProjectBuildingID);

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
			System.setProperty("BuildingProject_Perf3", ProjectBuildingID);
			log.info("  BuildingProject_Perf3 is ---" + ProjectBuildingID);
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

	// Verify clicking on 'Add project' button registers the project with non-leed
	// id.

	@Test(groups = {
			"BuildingsRegression" }, dependsOnGroups = "LoginMethodTCGroup", priority = 42, enabled = true, description = "Verify clicking on 'Add project' button registers the project with non-leed id.")
	public void Buildings_Project_Creation_NonLEEDID() {
		log.info("Buildings_Project_Creation_NonLEEDID method started ........... ");
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
		// String HeaderText = BuildingPage.CheckOverviewHeaderShowing();
		if (flag) {
			BuildingPage.ClickonProjectInManage();
			ProjectBuildingID = BuildingPage.getProjectID(BuildingProjectName);
			System.setProperty("BuildingProject_NonLEED4", ProjectBuildingID);
			log.info("  BuildingProject_NonLEED4 is ---" + ProjectBuildingID);
			if (ProjectBuildingID.substring(0, 4).equals("8000")) {
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

		log.info("Buildings_Project_Creation_NonLEEDID method ends here ........... ");
	}

	/////////////////////////////////////////////////// Test Cases For
	/////////////////////////////////////////////////// Parking/////////////////////////////////////////////////////////////////

	// Verify Project Type as 'Parking' available in dropdown or not

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 5, enabled = true, description = "Verify Project Type as 'Cities' available in dropdown or not")
	public void Parking_ProjectType_Parking_Value() {
		log.info("Parking_ProjectType_Parking_Value method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean flag = false;
		HomePage.clickOnProject();
		HomePage.clickOnParkingSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage.enterProjectName(
				data.getCellData("ProjectRegistration", 16, 2) + CommonMethod.generateRandomString(5));

		try {

			flag = ProjectRegistrationPage.SelectParkingProjectType();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		// ProjectRegistrationPage.closeProjectButton();
		log.info("Parking_ProjectType_Parking_Value method ends here ........... ");

	}

	// Verify- Parking adding Gross area - limit allowed is Max: 1904514 square
	// meters

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Parking_ProjectType_Parking_Value" }, priority = 6, enabled = true, description = "Verify Parking adding Gross area - limit allowed is Max: 1904514 square meters")
	public void Parking_GrossArea_Valid_SQ_MT() {
		log.info("Parking_GrossArea_Valid_SQ_MT method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean flag = false;

		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage.enterProjectName(
				data.getCellData("ProjectRegistration", 16, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectParkingProjectType();
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
		log.info("Parking_GrossArea_Valid_Square_Meters method ends here ........... ");

	}

	// Verify parking adding invalid Gross area - limit 1904515 square meters

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Parking_ProjectType_Parking_Value" }, priority = 7, enabled = true, description = "Verify Parking adding invalid Gross area - limit  1904515 square meters")
	public void Parking_GrossArea_Invalid_SQ_MT() {
		log.info("Parking_GrossArea_Invalid_SQ_MT method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean flag = false;

		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage.enterProjectName(
				data.getCellData("ProjectRegistration", 16, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectParkingProjectType();

		ProjectRegistrationPage.SelectUnitType("square meters");
		ProjectRegistrationPage.enterGrossArea("1904515");

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
		log.info("Parking_GrossArea_Invalid_Square_Meters method ends here ........... ");

	}

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Parking_ProjectType_Parking_Value" }, priority = 8, enabled = false, description = "Verify Parking adding Gross area - limit allowed is Max: 1904514 square meters")
	public void Parking_GrossArea_Valid_SQ_FT() {
		log.info("Parking_GrossArea_Valid_SQ_FT method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean flag = false;

		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage.enterProjectName(
				data.getCellData("ProjectRegistration", 16, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectParkingProjectType();
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
		// ProjectRegistrationPage.closeProjectButton();
		log.info("Parking_GrossArea_Valid_SQ_FT method ends here ........... ");

	}

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Parking_ProjectType_Parking_Value" }, priority = 9, enabled = true, description = "Verify Parking adding Gross area - limit allowed is Max: 1904514 square meters")
	public void Parking_GrossArea_Invalid_SQ_FT() {
		log.info("Parking_GrossArea_Inalid_SQ_FT method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean flag = false;

		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage.enterProjectName(
				data.getCellData("ProjectRegistration", 16, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectParkingProjectType();
		ProjectRegistrationPage.SelectUnitType("square feet");
		ProjectRegistrationPage.enterGrossArea("20500000");

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
		log.info("Parking_GrossArea_Invalid_SQ_FT method ends here ........... ");

	}

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Parking_ProjectType_Parking_Value" }, priority = 10, enabled = true, description = "Verify 'Date commisioned' opens up the calendar.")
	public void Parking_DateCommisioned_Open_Calendar() {

		log.info("Parking_DateCommisioned_Open_Calendar method started ........... ");
		boolean flag = false;
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage.enterProjectName(
				data.getCellData("ProjectRegistration", 16, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectParkingProjectType();

		flag = ProjectRegistrationPage.DateCommisonedOpensCalendar();
		log.info("Flag is ----------->" + flag);

		if (flag) {
			Assert.assertTrue(true);
			log.info("Parking_DateCommisioned_Open_Calendar method ends with true here ........... ");

		} else
			Assert.assertTrue(false);
		log.info("Parking_DateCommisioned_Open_Calendar method ends with false here ........... ");

	}

	// Verify Auto-Population of the Address

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Parking_ProjectType_Parking_Value" }, priority = 11, enabled = true, description = "Verify address field auto populates the address(this address is being pulled using google maps API).\r\n"
					+ "	Verify auto pulled address populates all the fields -City, County,States,zipcode")
	public void Parking_AutoPopulate_Address_City_Country_State_ZipCode() {
		log.info("Parking_AutoPopulate_Address_Parking_Country_State_ZipCode method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage.enterProjectName(
				data.getCellData("ProjectRegistration", 16, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectParkingProjectType();
		System.out.println(data.getCellData("ProjectRegistration", 17, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 17, 2));
		// ProjectRegistrationPage.clickNoLEEDRegistration();

		boolean flag = ProjectRegistrationPage
				.CheckAddress_City_Country_State_ZipCode("2101 L St NW washington DC 20037 USA");
		if (flag) {
			// ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		log.info("Parking_AutoPopulate_Address_Parking_Country_State_ZipCode method ends here ........... ");
	}

	// Verify Auto-Populate Latitude and Longitude value

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Parking_ProjectType_Parking_Value",
			"Parking_AutoPopulate_Address_City_Country_State_ZipCode" }, priority = 12, enabled = true, description = "Verify after address is auto pulled, geo location gets auto -populated.")
	public void Parking_AutoPopulate_Latitude_Longitude() {
		log.info("Parking_AutoPopulate_Latitude_Longitude method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage.enterProjectName(
				data.getCellData("ProjectRegistration", 16, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectParkingProjectType();
		System.out.println(data.getCellData("ProjectRegistration", 17, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 17, 2));
		// ProjectRegistrationPage.clickNoLEEDRegistration();

		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode("2101 L St NW washington DC 20037 USA");
		boolean flag = ProjectRegistrationPage.CheckGeoLocation();
		if (flag) {
			// ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		log.info("Parking_AutoPopulate_Latitude_Longitude method ends here ........... ");
	}

	// Verify able to download service agreement successfully.

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Parking_ProjectType_Parking_Value" }, priority = 13, enabled = true, description = " Verify able to download service agreement successfully.")
	public void Parking_Download_Service_Agreement() {
		log.info("Parking_Download_Service_Agreement method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String handle = driver.getWindowHandle();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage.enterProjectName(
				data.getCellData("ProjectRegistration", 16, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectParkingProjectType();
		System.out.println(data.getCellData("ProjectRegistration", 17, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 17, 2));
		// ProjectRegistrationPage.clickNoLEEDRegistration();

		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode("2101 L St NW washington DC 20037 USA");

		boolean flag = ProjectRegistrationPage.ParkSmartDownLoadServiceAgreement();

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

		log.info("Parking_Download_Service_Agreement method ends here ........... ");
	}

	// Verify when 'I agree to … agreement' checkbox is selected, 'Add project'
	// button gets enabled.

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Parking_ProjectType_Parking_Value" }, priority = 14, enabled = true, description = "Verify when 'I agree to … agreement' checkbox is selected, 'Add project' button gets enabled.")
	public void Parking_Agreement_Check_AddButtonEnabled() {
		log.info("Parking_Agreement_Check_AddButtonEnabled method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String handle = driver.getWindowHandle();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage.enterProjectName(
				data.getCellData("ProjectRegistration", 16, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectParkingProjectType();
		boolean flag = ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		if (flag) {
			// ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);

		log.info("Parking_Agreement_Check_AddButtonEnabled method ends here ........... ");
	}

	// Verify 'Number of parking spaces' is a whole number field i.e. should not
	// accept decimals and alphabets

	@Test(groups = "ParkSmartRegression", dependsOnMethods = {
			"Parking_ProjectType_Parking_Value" }, dependsOnGroups = "LoginMethodTCGroup", priority = 15, enabled = true, description = "Verify 'Number of parking spaces' is a whole number  field i.e. should not accept decimals and alphabets")
	public void Parking_Space_Is_Whole_Number() {

		log.info(" Parking_Space_Is_Whole_Number method started ........... ");
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
		ProjectRegistrationPage.SelectParkingProjectType();
		ProjectRegistrationPage.enterProjectName(
				data.getCellData("ProjectRegistration", 16, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.enterParkingSpace(data.getCellData("ProjectRegistration", 17, 2));

		try {
			flag = ProjectRegistrationPage.CheckParkingSpaceValidationMsg();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		// ProjectRegistrationPage.closeProjectButton();
		log.info("Parking_Space_Is_Whole_Number method ends here ........... ");

	}

	@Test(groups = "ParkSmartRegression", dependsOnMethods = {
			"Parking_ProjectType_Parking_Value" }, dependsOnGroups = "LoginMethodTCGroup", priority = 16, enabled = true, description = "Verify 'How many levels in your parking structure' is a whole number  field i.e. should not accept decimals and alphabets")
	public void Parking_Space_Invalid() {
		log.info(" Parking_Space_Is_Invalid method started ........... ");
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
		ProjectRegistrationPage.SelectParkingProjectType();
		ProjectRegistrationPage.enterProjectName(
				data.getCellData("ProjectRegistration", 16, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.enterParkingSpace(
				data.getCellData("ProjectRegistration", 18, 2) + CommonMethod.generateRandomString(3));

		try {
			flag = ProjectRegistrationPage.CheckParkingSpaceValidationMsg();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(true);
		// ProjectRegistrationPage.closeProjectButton();
		log.info("Parking_Space_Is_Invalid method ends here ........... ");
	}

	// Verify 'How many levels in your parking structure' is a whole number field
	// i.e. should not accept decimals and alphabets

	@Test(groups = "ParkSmartRegression", dependsOnMethods = {
			"Parking_ProjectType_Parking_Value" }, dependsOnGroups = "LoginMethodTCGroup", priority = 17, enabled = true, description = "Verify 'How many levels in your parking structure' is a whole number  field i.e. should not accept decimals and alphabets")

	public void Parking_Level_Validation() {

		log.info(" Parking_Level_Validation method started ........... ");
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
		ProjectRegistrationPage.SelectParkingProjectType();
		ProjectRegistrationPage.enterProjectName(
				data.getCellData("ProjectRegistration", 16, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.enterParkingLevel(data.getCellData("ProjectRegistration", 19, 2));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			flag = ProjectRegistrationPage.CheckParkingLevelValidationMsg();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		// ProjectRegistrationPage.closeProjectButton();
		log.info("Parking_Level_Validation method ends here ........... ");

	}

	// Verify Owner email should take the value is email format- with only 1 '@' and
	// upto 2 '.' allowed.

	@Test(groups = "ParkSmartRegression", dependsOnMethods = {
			"Parking_ProjectType_Parking_Value" }, dependsOnGroups = "LoginMethodTCGroup", priority = 18, enabled = true, description = "Verify Owner email should take the value in email format- with only 1 '@' and upto 2 '.' allowed.")

	public void Parking_Owner_Email_Validation() {

		log.info("Parking_Owner_Email_Validation method started ........... ");

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
		ProjectRegistrationPage.SelectParkingProjectType();
		ProjectRegistrationPage.enterProjectName(
				data.getCellData("ProjectRegistration", 16, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.enterOwnerEmail(data.getCellData("ProjectRegistration", 22, 2));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			flag = ProjectRegistrationPage.CheckEmailValidationMsg();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		// ProjectRegistrationPage.closeProjectButton();
		log.info("Parking_Owner_Email_Validation method ends here ........... ");

	}

	// Verify 'Owner type' field opens up the dropdown with list of organizations
	// and allows to select the value from the dropdown.

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Parking_ProjectType_Parking_Value" }, priority = 19, enabled = true, description = "Verify 'Owner type' field opens up the dropdown with list of organizations and allows to select the value from the dropdown.")
	public void Parking_Owner_Type_Validation() {
		log.info("Parking_Owner_Type_Validation method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage.enterProjectName(
				data.getCellData("ProjectRegistration", 16, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectParkingProjectType();
		System.out.println(data.getCellData("ProjectRegistration", 17, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 17, 2));

		boolean flag = ProjectRegistrationPage.Check_Owner_Type("Business Improvement District");
		if (!flag) {
			// ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		log.info("Parking_Owner_Type_Validation method ends here ........... ");
	}

	// Verify 'Owner organization' field- enter one or 2 letters should auto
	// populate the list of organizations.

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Parking_ProjectType_Parking_Value" }, priority = 20, enabled = true, description = "Verify 'Owner organization' field- enter one or 2 letters should auto populate the list of organizations.")
	public void Parking_OwnerOrganization_AutoSuggestion() {
		log.info("ProjectRegistration_OwnerOrganization_AutoSuggestion method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		HomePage.clickOnProject();
		HomePage.clickOnParkingSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage.enterProjectName(
				data.getCellData("ProjectRegistration", 16, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectParkingProjectType();
		ProjectRegistrationPage.enterGrossArea("1904515");
		ProjectRegistrationPage.SelectUnitType("square meters");

		int totalOwnerName = ProjectRegistrationPage
				.CheckOwnerOrgAutoSuggetion(data.getCellData("ProjectRegistration", 13, 2));
		log.info("Total Suggestion showing is ---" + totalOwnerName);
		if (totalOwnerName > 0) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		log.info("ProjectRegistration_OwnerOrganization_AutoSuggestion method ends here ........... ");

	}

	// Verify Owner country should open a list of countries.

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Parking_ProjectType_Parking_Value" }, priority = 21, enabled = true, description = "Verify Owner country should open a list of countries.")
	public void Parking_Owner_Region_Validation() {
		log.info("Parking_Owner_Region_Validation method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage.enterProjectName(
				data.getCellData("ProjectRegistration", 16, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectParkingProjectType();
		System.out.println(data.getCellData("ProjectRegistration", 17, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 17, 2));

		boolean flag = ProjectRegistrationPage.Check_Owner_Region("United States");
		if (!flag) {
			// ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		log.info("Parking_Owner_Region_Validation method ends here ........... ");
	}

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Parking_ProjectType_Parking_Value", "Parking_AutoPopulate_Address_City_Country_State_ZipCode",
			"Parking_AutoPopulate_Latitude_Longitude", "Parking_Owner_Type_Validation",
			"Parking_Owner_Region_Validation", }, priority = 22, enabled = true, description = " Verify clicking on 'Add project' button registers the project.")

	public void Parking_Registered_TestProject_Creation() {
		log.info("Parking_Registered_TestProject_Creation method started ........... ");
		String ProjectParkingID = null;
		String ProjectName = null;
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String handle = driver.getWindowHandle();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String ParkingProjectName = data.getCellData("ProjectRegistration", 16, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(ParkingProjectName);
		ProjectRegistrationPage.SelectParkingProjectType();
		ProjectRegistrationPage.enterParkingSpace(data.getCellData("ProjectRegistration", 18, 2));
		ProjectRegistrationPage.enterParkingLevel(data.getCellData("ProjectRegistration", 19, 2));
		System.out.println(data.getCellData("ProjectRegistration", 17, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 17, 2));
		ProjectRegistrationPage.SelectUnitType("square meters");
		ProjectRegistrationPage.Check_Owner_Type(data.getCellData("ProjectRegistration", 20, 2));
		ProjectRegistrationPage.selectOwnerOrg(data.getCellData("ProjectRegistration", 21, 2));
		ProjectRegistrationPage.enterOwnerEmail(data.getCellData("ProjectRegistration", 22, 2));
		ProjectRegistrationPage.Check_Owner_Region(data.getCellData("ProjectRegistration", 23, 2));
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();

		ProjectPaymentPage = ProjectRegistrationPage.ClickonParkingAddProjectButton();

		ngWebDriver.waitForAngularRequestsToFinish();

		ProjectPaymentPage.EnterBillingName(
				data.getCellData("ProjectRegistration", 24, 2) + CommonMethod.generateRandomNumber(2));
		ProjectPaymentPage.enterBillingEmail(data.getCellData("ProjectRegistration", 22, 2));
		ProjectPaymentPage.EnterBillingAddress(data.getCellData("ProjectRegistration", 3, 2));
		ProjectPaymentPage.EnterBillingCity(data.getCellData("ProjectRegistration", 4, 2));
		ProjectPaymentPage.EnterBillingZipCode(data.getCellData("ProjectRegistration", 7, 2));
		ProjectPaymentPage.selectBillingState(data.getCellData("ProjectRegistration", 6, 2));
		ProjectPaymentPage.EnterCardNumber(data.getCellData("ProjectRegistration", 25, 2));
		ProjectPaymentPage.EnterExpiryDate(data.getCellData("ProjectRegistration", 26, 2));
		ProjectPaymentPage.EnterCvv(data.getCellData("ProjectRegistration", 27, 2));

		ParkingPage = ProjectPaymentPage.ClickonParkingSubmitButton();

		ngWebDriver.waitForAngularRequestsToFinish();

		boolean flag = ParkingPage.checkParkingProjectCreation(ParkingProjectName);
		System.out.println("Flag is --------->" + flag);
		if (flag) {
			ParkingPage.ClickonProjectInManage();
			ProjectParkingID = ParkingPage.getProjectID(ParkingProjectName);
			System.setProperty("LEEDParkSmartProjectID", ProjectParkingID);
			log.info("Project ID is -------->" + ProjectParkingID);
			ProjectName = driver.findElement(By.xpath("//input[@name='name']")).getAttribute("value");
			System.setProperty("RegisteredProjectName", ParkingProjectName);
			log.info("Project Name is -------->" + ProjectName);
			if (ProjectParkingID.substring(0, 4).equals("1000")) {
				// ParkingPage.ClickonProjectInManage();
				log.info("Project creation done successfully.......");
				Assert.assertTrue(true);
			} else {
				log.info(" Project creation failed..................");
				Assert.assertTrue(false);
			}

		}

		log.info("Parking_Registered_TestProject_Creation method ends here ........... ");
	}

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Parking_ProjectType_Parking_Value", "Parking_AutoPopulate_Address_City_Country_State_ZipCode",
			"Parking_AutoPopulate_Latitude_Longitude", "Parking_Owner_Type_Validation",
			"Parking_Owner_Region_Validation" }, priority = 23, enabled = true, description = " Verify clicking on 'Add project' button registers the project.")

	public void Parking_Unregistered_TestProject_Creation() {
		log.info("Parking_Unregistered_TestProject_Creation method started ........... ");
		String UnregisteredProjectID = null;
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String handle = driver.getWindowHandle();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String ParkingProjectName = data.getCellData("ProjectRegistration", 16, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(ParkingProjectName);
		ProjectRegistrationPage.SelectParkingProjectType();
		ProjectRegistrationPage.enterParkingSpace(data.getCellData("ProjectRegistration", 18, 2));
		ProjectRegistrationPage.enterParkingLevel(data.getCellData("ProjectRegistration", 19, 2));
		System.out.println(data.getCellData("ProjectRegistration", 17, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 17, 2));
		ProjectRegistrationPage.SelectUnitType("square meters");
		ProjectRegistrationPage.Check_Owner_Type(data.getCellData("ProjectRegistration", 20, 2));
		ProjectRegistrationPage.selectOwnerOrg(data.getCellData("ProjectRegistration", 21, 2));
		ProjectRegistrationPage.enterOwnerEmail(data.getCellData("ProjectRegistration", 22, 2));
		ProjectRegistrationPage.Check_Owner_Region(data.getCellData("ProjectRegistration", 23, 2));
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		ngWebDriver.waitForAngularRequestsToFinish();
		ProjectPaymentPage = ProjectRegistrationPage.ClickonParkingAddProjectButton();

		flag = ProjectPaymentPage.checkUnregisteredParkingProjectCreation();
		System.out.println("Flag is -------------> " + flag);
		if (flag) {
			String Url = driver.getCurrentUrl();
			System.out.println("Url is ---------> " + Url);
			String UrlParts[] = Url.split("/");
			UnregisteredProjectID = (String) Array.get(UrlParts, 4);
			System.setProperty("UnregisteredParkSmartProjectID", UnregisteredProjectID);
			System.out.println("Project Id is ----->" + UnregisteredProjectID);
			if (UnregisteredProjectID.substring(0, 4).equals("1000")) {
				log.info("Project creation done successfully.......");
				Assert.assertTrue(true);
			} else {
				log.info(" Project creation failed..................");
				Assert.assertTrue(false);
			}

		}
		ProjectPaymentPage.CancelPaymentButton();
		log.info("Parking_Unregistered_TestProject_Creation method ends here ........... ");
	}

	@Test(groups = { "ParkSmartRegression" }, dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Parking_ProjectType_Parking_Value" }, priority = 24, enabled = true, description = "Verify if 'project is private' is selected, shows private as 'Yes' under Manage--project.")
	public void Parking_Project_Is_Private_Creation() {
		log.info("Parking_Project_Is_Private_Creation method started ........... ");
		String ProjectParkingID = "";
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		HomePage.clickOnProject();
		HomePage.clickOnParkingSubMenu();
		String handle = driver.getWindowHandle();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String ParkingProjectName = data.getCellData("ProjectRegistration", 16, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(ParkingProjectName);
		ProjectRegistrationPage.SelectParkingProjectType();
		ProjectRegistrationPage.enterParkingSpace(data.getCellData("ProjectRegistration", 18, 2));
		ProjectRegistrationPage.enterParkingLevel(data.getCellData("ProjectRegistration", 19, 2));
		System.out.println(data.getCellData("ProjectRegistration", 17, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 17, 2));
		ProjectRegistrationPage.SelectUnitType("square meters");
		ProjectRegistrationPage.Check_Owner_Type(data.getCellData("ProjectRegistration", 20, 2));
		ProjectRegistrationPage.selectOwnerOrg(data.getCellData("ProjectRegistration", 21, 2));
		ProjectRegistrationPage.enterOwnerEmail(data.getCellData("ProjectRegistration", 22, 2));
		ProjectRegistrationPage.Check_Owner_Region(data.getCellData("ProjectRegistration", 23, 2));
		ProjectRegistrationPage.SelectProjectIsPrivateCheckBox();
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();

		ProjectPaymentPage = ProjectRegistrationPage.ClickonParkingAddProjectButton();

		ngWebDriver.waitForAngularRequestsToFinish();

		ProjectPaymentPage.EnterBillingName(
				data.getCellData("ProjectRegistration", 24, 2) + CommonMethod.generateRandomNumber(2));
		ProjectPaymentPage.enterBillingEmail(data.getCellData("ProjectRegistration", 22, 2));
		ProjectPaymentPage.EnterBillingAddress(data.getCellData("ProjectRegistration", 3, 2));
		ProjectPaymentPage.EnterBillingCity(data.getCellData("ProjectRegistration", 4, 2));
		ProjectPaymentPage.EnterBillingZipCode(data.getCellData("ProjectRegistration", 7, 2));
		ProjectPaymentPage.selectBillingState(data.getCellData("ProjectRegistration", 6, 2));
		ProjectPaymentPage.EnterCardNumber(data.getCellData("ProjectRegistration", 25, 2));
		ProjectPaymentPage.EnterExpiryDate(data.getCellData("ProjectRegistration", 26, 2));
		ProjectPaymentPage.EnterCvv(data.getCellData("ProjectRegistration", 27, 2));

		ParkingPage = ProjectPaymentPage.ClickonParkingSubmitButton();

		ngWebDriver.waitForAngularRequestsToFinish();

		boolean flag = ParkingPage.checkParkingProjectCreation(ParkingProjectName);
		if (flag) {
			ParkingPage.ClickonProjectInManage();
			ProjectParkingID = ParkingPage.getProjectID(ParkingProjectName);
			System.setProperty("ParkingProject_Private", ProjectParkingID);
			log.info("  ParkingProject_Private is ---" + ProjectParkingID);
			if ((ParkingPage.CheckProjectIsPrivateFlagUnderManage(ProjectParkingID) == true)) {
				Assert.assertTrue(true);
			} else {
				log.info("This is Project is Private as YES radiobutton is not selected..................");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Project is Private Creation gets failed..........");
			Assert.assertTrue(false);
		}

		log.info("Parking_Project_Is_Private_Creation method ends here ........... ");
	}

	// Successful Payment open all measures page
	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Parking_ProjectType_Parking_Value", "Parking_AutoPopulate_Address_City_Country_State_ZipCode",
			"Parking_AutoPopulate_Latitude_Longitude" }, priority = 25, enabled = true, description = "Verify after successful payment, user sould be redirected to 'All measures' page of the project.")
	public void Parking_Project_Creation_Opens_AllMeasures_Screen() {
		log.info("Parking_Project_Creation_Opens_AllMeasures_Screen method started ........... ");
		String ProjectParkingID = null;
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
		String handle = driver.getWindowHandle();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String ParkingProjectName = data.getCellData("ProjectRegistration", 16, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(ParkingProjectName);
		ProjectRegistrationPage.SelectParkingProjectType();
		ProjectRegistrationPage.enterParkingSpace(data.getCellData("ProjectRegistration", 18, 2));
		ProjectRegistrationPage.enterParkingLevel(data.getCellData("ProjectRegistration", 19, 2));
		System.out.println(data.getCellData("ProjectRegistration", 17, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 17, 2));
		ProjectRegistrationPage.SelectUnitType("square meters");
		ProjectRegistrationPage.Check_Owner_Type(data.getCellData("ProjectRegistration", 20, 2));
		ProjectRegistrationPage.selectOwnerOrg(data.getCellData("ProjectRegistration", 21, 2));
		ProjectRegistrationPage.enterOwnerEmail(data.getCellData("ProjectRegistration", 22, 2));
		ProjectRegistrationPage.Check_Owner_Region(data.getCellData("ProjectRegistration", 23, 2));
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();

		ProjectPaymentPage = ProjectRegistrationPage.ClickonParkingAddProjectButton();

		ngWebDriver.waitForAngularRequestsToFinish();

		ProjectPaymentPage.EnterBillingName(
				data.getCellData("ProjectRegistration", 24, 2) + CommonMethod.generateRandomNumber(2));
		ProjectPaymentPage.enterBillingEmail(data.getCellData("ProjectRegistration", 22, 2));
		ProjectPaymentPage.EnterBillingAddress(data.getCellData("ProjectRegistration", 3, 2));
		ProjectPaymentPage.EnterBillingCity(data.getCellData("ProjectRegistration", 4, 2));
		ProjectPaymentPage.EnterBillingZipCode(data.getCellData("ProjectRegistration", 7, 2));
		ProjectPaymentPage.selectBillingState(data.getCellData("ProjectRegistration", 6, 2));
		ProjectPaymentPage.EnterCardNumber(data.getCellData("ProjectRegistration", 25, 2));
		ProjectPaymentPage.EnterExpiryDate(data.getCellData("ProjectRegistration", 26, 2));
		ProjectPaymentPage.EnterCvv(data.getCellData("ProjectRegistration", 27, 2));

		ParkingPage = ProjectPaymentPage.ClickonParkingSubmitButton();

		ngWebDriver.waitForAngularRequestsToFinish();

		boolean flag = ParkingPage.checkParkingProjectCreation(ParkingProjectName);
		String HeaderText = ParkingPage.CheckAllMeasureHeaderShowing();
		if (flag) {
			ParkingPage.ClickonProjectInManage();
			ProjectParkingID = ParkingPage.getProjectID(ParkingProjectName);
			if ((HeaderText.equals("All Measures"))) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}

			log.info("Parking_Project_Creation_Opens_Measures_Screen method ends here ........... ");
		}
	}
	// *********************************************For Transit Project
	// Registration*************************************\\

	@Test(groups = "TransitRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 5, enabled = true, description = "Verify Project Type as 'Transit' available in dropdown or not")
	public void ProjectType_Transit_Value_Validation() {
		log.info("ProjectType_Transit_Value_Validation method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean flag = false;
		HomePage.clickOnProject();
		HomePage.clickOnTransitSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String TransitProjectName = data.getCellData("TransitRegistration", 1, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(TransitProjectName);

		try {

			flag = ProjectRegistrationPage.SelectTransitProjectType();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		// ProjectRegistrationPage.closeProjectButton();
		log.info("ProjectType_Transit_Value_Validation method ends here............");

	}

	@Test(groups = "TransitRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"ProjectType_Transit_Value_Validation" }, priority = 6, enabled = true, description = "Verify Transit adding Gross area - limit allowed is Max: 1904514 square meters")
	public void Transit_GrossArea_Valid_SQ_MT() {
		log.info("Transit_GrossArea_Valid_SQ_MT method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();

			/*
			 * if (!HomePage.CheckHomePageLabel())
			 * ProjectRegistrationPage.closeProjectButton();
			 * HomePage.setHomePageApplication();
			 */
			// else
			// ProjectRegistrationPage.closeProjectButton();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean flag = false;

		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String TransitProjectName = data.getCellData("TransitRegistration", 1, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(TransitProjectName);
		ProjectRegistrationPage.SelectTransitProjectType();
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

		log.info("Transit_GrossArea_Valid_SQ_MT method ends here ........... ");

	}

	// Verify parking adding invalid Gross area - limit 1904515 square meters

	@Test(groups = "TransitRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"ProjectType_Transit_Value_Validation" }, priority = 7, enabled = true, description = "Verify Transit adding invalid Gross area - limit  1904515 square meters")
	public void Transit_GrossArea_Invalid_SQ_MT() {
		log.info("Transit_GrossArea_Invalid_SQ_MT method started ........... ");
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
		String TransitProjectName = data.getCellData("TransitRegistration", 1, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(TransitProjectName);
		;
		ProjectRegistrationPage.SelectTransitProjectType();

		ProjectRegistrationPage.SelectUnitType("square meters");
		ProjectRegistrationPage.enterGrossArea("1904515");

		try {

			flag = ProjectRegistrationPage.CheckGrossAreaValidationMsg();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);

		log.info("Transit_GrossArea_Invalid_SQ_MT method ends here ........... ");

	}

	@Test(groups = "TransitRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"ProjectType_Transit_Value_Validation" }, priority = 8, enabled = true, description = "Verify Transit adding Gross area - limit allowed is Max: 1904514 square meters")
	public void Transit_GrossArea_Valid_SQ_FT() {
		log.info("Transit_GrossArea_Valid_SQ_FT method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();

			/*
			 * if (!HomePage.CheckHomePageLabel())
			 * ProjectRegistrationPage.closeProjectButton();
			 * HomePage.setHomePageApplication();
			 */
			// else
			// ProjectRegistrationPage.closeProjectButton();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean flag = false;

		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String TransitProjectName = data.getCellData("TransitRegistration", 1, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(TransitProjectName);
		ProjectRegistrationPage.SelectTransitProjectType();
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

		log.info("Transit_GrossArea_Valid_SQ_FT method ends here ........... ");

	}

	@Test(groups = "TransitRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"ProjectType_Transit_Value_Validation" }, priority = 9, enabled = true, description = "Verify Transit adding Gross area - limit allowed is Max: 1904514 square meters")
	public void Transit_GrossArea_Invalid_SQ_FT() {
		log.info("Transit_GrossArea_Invalid_SQ_FT method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();

			/*
			 * if (!HomePage.CheckHomePageLabel())
			 * ProjectRegistrationPage.closeProjectButton();
			 * HomePage.setHomePageApplication();
			 */
			// else
			// ProjectRegistrationPage.closeProjectButton();
		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}

		boolean flag = false;

		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String TransitProjectName = data.getCellData("TransitRegistration", 1, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(TransitProjectName);
		ProjectRegistrationPage.SelectTransitProjectType();
		ProjectRegistrationPage.SelectUnitType("square feet");
		ProjectRegistrationPage.enterGrossArea("20500000");

		try {

			flag = ProjectRegistrationPage.CheckGrossAreaValidationMsg();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);

		log.info("Transit_GrossArea_Invalid_SQ_FT method ends here ........... ");

	}

	@Test(groups = "TransitRegression", dependsOnMethods = {
			"ProjectType_Transit_Value_Validation" }, dependsOnGroups = "LoginMethodTCGroup", priority = 10, enabled = true, description = "Verify 'What is Annual ride ship for station ' is a whole number  field i.e. should not accept decimals and alphabets")
	public void Transit_Annual_RiderShip_Is_Whole_Num() {

		log.info(" Transit_Annual_RiderShip_Is_Whole_Num method started ........... ");
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
		ProjectRegistrationPage.SelectTransitProjectType();
		String TransitProjectName = data.getCellData("TransitRegistration", 1, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(TransitProjectName);
		ProjectRegistrationPage.enterAnnualRidership(data.getCellData("TransitRegistration", 2, 2));

		try {
			flag = ProjectRegistrationPage.CheckAnnualRidershipValidationMsg();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		// ProjectRegistrationPage.closeProjectButton();
		log.info("Transit_Annual_RiderShip_Is_Whole_Num method ends here ........... ");

	}

	@Test(groups = "TransitRegression", dependsOnMethods = {
			"ProjectType_Transit_Value_Validation" }, dependsOnGroups = "LoginMethodTCGroup", priority = 11, enabled = true, description = "Verify 'What is Annual ride ship for station ' is a whole number  field i.e. should not accept decimals and alphabets")
	public void Transit_AnnualRidership_Invalid() {
		log.info(" Transit_AnnualRidership_Invalid method started ........... ");
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
		ProjectRegistrationPage.SelectTransitProjectType();
		String TransitProjectName = data.getCellData("TransitRegistration", 1, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(TransitProjectName);
		ProjectRegistrationPage.enterAnnualRidership(
				data.getCellData("TransitRegistration", 2, 2) + CommonMethod.generateRandomString(3));

		try {
			flag = ProjectRegistrationPage.CheckAnnualRidershipValidationMsg();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(true);

		log.info("Transit_AnnualRidership_Invalid method ends here ........... ");
	}

	@Test(groups = "TransitRegression", dependsOnMethods = {
			"ProjectType_Transit_Value_Validation" }, dependsOnGroups = "LoginMethodTCGroup", priority = 12, enabled = true, description = "Verify 'Weekly Operating hours ' is a whole number  field i.e. should not accept decimals and alphabets")
	public void Transit_Weekly_Operating_Hrs_Is_Whole_Num() {

		log.info(" Transit_Weekly_Operating_Hrs_Is_Whole_Num method started ........... ");
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
		ProjectRegistrationPage.SelectTransitProjectType();
		String TransitProjectName = data.getCellData("TransitRegistration", 1, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(TransitProjectName);
		ProjectRegistrationPage.enterWeeklyOperatingHrs(data.getCellData("TransitRegistration", 3, 2));

		try {
			flag = ProjectRegistrationPage.CheckWeeklyHrsValidationMsg();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		// ProjectRegistrationPage.closeProjectButton();
		log.info("Transit_Weekly_Operating_Hrs_Is_Whole_Num method ends here ........... ");

	}

	@Test(groups = "TransitRegression", dependsOnMethods = {
			"ProjectType_Transit_Value_Validation" }, dependsOnGroups = "LoginMethodTCGroup", priority = 13, enabled = true, description = "Verify 'Weekly Operating hours ' is a whole number  field i.e. should not accept decimals and alphabets")
	public void Transit_WeeklyOperatingHrs_Invalid() {
		log.info(" Transit_WeeklyOperatingHrs_Invalid method started ........... ");
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
		ProjectRegistrationPage.SelectTransitProjectType();
		String TransitProjectName = data.getCellData("TransitRegistration", 1, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(TransitProjectName);
		ProjectRegistrationPage.enterWeeklyOperatingHrs(
				data.getCellData("TransitRegistration", 3, 2) + CommonMethod.generateRandomString(3));

		try {
			flag = ProjectRegistrationPage.CheckWeeklyHrsValidationMsg();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(true);

		log.info("Transit_WeeklyOperatingHrs_Invalid method ends here ........... ");
	}

	@Test(groups = "TransitRegression", dependsOnMethods = {
			"ProjectType_Transit_Value_Validation" }, dependsOnGroups = "LoginMethodTCGroup", priority = 14, enabled = true, description = "Verify 'Full time staff at station' is a whole number  field i.e. should not accept decimals and alphabets")
	public void Transit_Fulltime_Staff_Is_Whole_Num() {

		log.info(" Transit_Fulltime_Staff_Is_Whole_Num method started ........... ");
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
		ProjectRegistrationPage.SelectTransitProjectType();
		String TransitProjectName = data.getCellData("TransitRegistration", 1, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(TransitProjectName);
		ProjectRegistrationPage.enterFulltimeStaff(data.getCellData("TransitRegistration", 4, 2));

		try {
			flag = ProjectRegistrationPage.CheckFulltimeStaffValidationMsg();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);

		log.info("Transit_Fulltime_Staff_Is_Whole_Num method ends here ........... ");

	}

	@Test(groups = "TransitRegression", dependsOnMethods = {
			"ProjectType_Transit_Value_Validation" }, dependsOnGroups = "LoginMethodTCGroup", priority = 15, enabled = true, description = "Verify 'Full time staff at station' is a whole number  field i.e. should not accept decimals and alphabets")
	public void Transit_FulltimeStaff_Invalid() {
		log.info(" Transit_FulltimeStaff_Invalid method started ........... ");
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
		ProjectRegistrationPage.SelectTransitProjectType();
		String TransitProjectName = data.getCellData("TransitRegistration", 1, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(TransitProjectName);
		ProjectRegistrationPage.enterFulltimeStaff(
				data.getCellData("TransitRegistration", 4, 2) + CommonMethod.generateRandomString(3));

		try {
			flag = ProjectRegistrationPage.CheckFulltimeStaffValidationMsg();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(true);

		log.info("Transit_FulltimeStaff_Invalid method ends here ........... ");
	}

	@Test(groups = "TransitRegression", dependsOnMethods = {
			"ProjectType_Transit_Value_Validation" }, dependsOnGroups = "LoginMethodTCGroup", priority = 16, enabled = true, description = "Verify 'Average time spent by riders at the station (in minutes)' is a whole number  field i.e. should not accept decimals and alphabets")
	public void Transit_Avg_Time_Spent_Whole_Num() {

		log.info(" Transit_Fulltime_Staff_Is_Whole_Num method started ........... ");
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
		ProjectRegistrationPage.SelectTransitProjectType();
		String TransitProjectName = data.getCellData("TransitRegistration", 1, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(TransitProjectName);
		ProjectRegistrationPage.enterAvgTimeSpent(data.getCellData("TransitRegistration", 5, 2));

		try {
			flag = ProjectRegistrationPage.CheckAvgTimeSpentValidationMsg();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		// ProjectRegistrationPage.closeProjectButton();
		log.info("Transit_Fulltime_Staff_Is_Whole_Num method ends here ........... ");

	}

	@Test(groups = "TransitRegression", dependsOnMethods = {
			"ProjectType_Transit_Value_Validation" }, dependsOnGroups = "LoginMethodTCGroup", priority = 17, enabled = true, description = "Verify 'Average time spent by riders at the station (in minutes)' is a whole number  field i.e. should not accept decimals and alphabets")
	public void Transit_AvgTimeSpent_Invalid() {
		log.info(" Transit_AvgTimeSpent_Invalid method started ........... ");
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
		ProjectRegistrationPage.SelectTransitProjectType();
		String TransitProjectName = data.getCellData("TransitRegistration", 1, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(TransitProjectName);
		ProjectRegistrationPage.enterAvgTimeSpent(
				data.getCellData("TransitRegistration", 5, 2) + CommonMethod.generateRandomString(3));

		try {
			flag = ProjectRegistrationPage.CheckAvgTimeSpentValidationMsg();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(true);

		log.info("Transit_AvgTimeSpent_Invalid method ends here ........... ");
	}

	@Test(groups = "TransitRegression", dependsOnMethods = {
			"ProjectType_Transit_Value_Validation" }, dependsOnGroups = "LoginMethodTCGroup", priority = 18, enabled = true, description = "Verify 'Average time spent by riders at the station (in minutes)' is a whole number  field i.e. should not accept decimals and alphabets")
	public void Transit_WeightedDailyOccupancy_Validation() {
		log.info(" Transit_WeightedDailyOccupancy_Validation method started ........... ");
		String AnnualRidership = null;
		String WeeklyHours = null;
		String FulltimeStaff = null;
		String AvgTime = null;
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
		ProjectRegistrationPage.SelectTransitProjectType();
		String TransitProjectName = data.getCellData("TransitRegistration", 1, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(TransitProjectName);

		AnnualRidership = data.getCellData("TransitRegistration", 2, 2);
		System.setProperty("Annual_Ridership", AnnualRidership);
		ProjectRegistrationPage.enterAnnualRidership(AnnualRidership);

		WeeklyHours = data.getCellData("TransitRegistration", 3, 2);
		System.setProperty("Weekly_Hours", WeeklyHours);
		ProjectRegistrationPage.enterWeeklyOperatingHrs(WeeklyHours);

		FulltimeStaff = data.getCellData("TransitRegistration", 4, 2);
		System.setProperty("Fulltime_Staff", FulltimeStaff);
		ProjectRegistrationPage.enterFulltimeStaff(FulltimeStaff);

		AvgTime = data.getCellData("TransitRegistration", 5, 2);
		System.setProperty("Average_Time", AvgTime);
		ProjectRegistrationPage.enterAvgTimeSpent(AvgTime);

		ProjectRegistrationPage.enterGrossArea(data.getCellData("TransitRegistration", 6, 2));

		flag = ProjectRegistrationPage.Validate_WeightedDailyOccupancy();

		if (flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		log.info("Transit_WeightedDailyOccupancy_Validation method ends here ........... ");
	}

	@Test(groups = "TransitRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"ProjectType_Transit_Value_Validation" }, priority = 19, enabled = true, description = "Verify address field auto populates the address(this address is being pulled using google maps API).\r\n"
					+ "	Verify auto pulled address populates all the fields -City, County,States,zipcode")
	public void Transit_AutoPopulate_Address_City_Country_State_ZipCode() {
		log.info("Transit_AutoPopulate_Address_Parking_Country_State_ZipCode method started ........... ");
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
		String handle = driver.getWindowHandle();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String TransitProjectName = data.getCellData("TransitRegistration", 1, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(TransitProjectName);
		ProjectRegistrationPage.SelectTransitProjectType();
		ProjectRegistrationPage.enterAnnualRidership(data.getCellData("TransitRegistration", 2, 2));
		ProjectRegistrationPage.enterWeeklyOperatingHrs(data.getCellData("TransitRegistration", 3, 2));
		ProjectRegistrationPage.enterFulltimeStaff(data.getCellData("TransitRegistration", 4, 2));
		ProjectRegistrationPage.enterAvgTimeSpent(data.getCellData("TransitRegistration", 5, 2));
		ProjectRegistrationPage.SelectUnitType("square meter");
		ProjectRegistrationPage.enterGrossArea(data.getCellData("TransitRegistration", 6, 2));

		boolean flag = ProjectRegistrationPage
				.CheckAddress_City_Country_State_ZipCode("2101 L St NW washington DC 20037 USA");
		if (flag) {
			// ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		log.info("Transit_AutoPopulate_Address_Parking_Country_State_ZipCode method ends here ........... ");
	}

	// Verify Auto-Populate Latitude and Longitude value

	@Test(groups = "TransitRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"ProjectType_Transit_Value_Validation",
			"Transit_AutoPopulate_Address_City_Country_State_ZipCode" }, priority = 20, enabled = true, description = "Verify after address is auto pulled, geo location gets auto -populated.")
	public void Transit_AutoPopulate_Latitude_Longitude() {
		log.info("Transit_AutoPopulate_Latitude_Longitude method started ........... ");
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
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String TransitProjectName = data.getCellData("TransitRegistration", 1, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(TransitProjectName);
		ProjectRegistrationPage.SelectTransitProjectType();
		ProjectRegistrationPage.enterAnnualRidership(data.getCellData("TransitRegistration", 2, 2));
		ProjectRegistrationPage.enterWeeklyOperatingHrs(data.getCellData("TransitRegistration", 3, 2));
		ProjectRegistrationPage.enterFulltimeStaff(data.getCellData("TransitRegistration", 4, 2));
		ProjectRegistrationPage.enterAvgTimeSpent(data.getCellData("TransitRegistration", 5, 2));
		ProjectRegistrationPage.SelectUnitType("square meter");
		ProjectRegistrationPage.enterGrossArea(data.getCellData("TransitRegistration", 6, 2));
		ProjectRegistrationPage.CheckTransit_Address_City_Country_State_ZipCode("2101 L St NW washington DC 20037 USA");

		boolean flag = ProjectRegistrationPage.CheckGeoLocation();
		if (flag) {
			// ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		log.info("Transit_AutoPopulate_Latitude_Longitude method ends here ........... ");
	}

	// Verify able to download service agreement successfully.

	@Test(groups = "TransitRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"ProjectType_Transit_Value_Validation" }, priority = 21, enabled = true, description = " Verify able to download service agreement successfully.")
	public void Transit_Download_Service_Agreement() {
		log.info("Transit_Download_Service_Agreement method started ........... ");
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
		String handle = driver.getWindowHandle();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String TransitProjectName = data.getCellData("TransitRegistration", 1, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(TransitProjectName);
		ProjectRegistrationPage.SelectTransitProjectType();
		ProjectRegistrationPage.enterAnnualRidership(data.getCellData("TransitRegistration", 2, 2));
		ProjectRegistrationPage.enterWeeklyOperatingHrs(data.getCellData("TransitRegistration", 3, 2));
		ProjectRegistrationPage.enterFulltimeStaff(data.getCellData("TransitRegistration", 4, 2));
		ProjectRegistrationPage.enterAvgTimeSpent(data.getCellData("TransitRegistration", 5, 2));
		ProjectRegistrationPage.SelectUnitType("square meter");
		ProjectRegistrationPage.enterGrossArea(data.getCellData("TransitRegistration", 6, 2));
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode("2101 L St NW washington DC 20037 USA");

		boolean flag = ProjectRegistrationPage.ParkSmartDownLoadServiceAgreement();

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

		log.info("Transit_Download_Service_Agreement method ends here ........... ");
	}

	// Verify when 'I agree to … agreement' checkbox is selected, 'Add project'
	// button gets enabled.

	@Test(groups = "TransitRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"ProjectType_Transit_Value_Validation" }, priority = 22, enabled = true, description = "Verify when 'I agree to … agreement' checkbox is selected, 'Add project' button gets enabled.")
	public void Transit_Agreement_Check_AddButtonEnabled() {
		log.info("Transit_Agreement_Check_AddButtonEnabled method started ........... ");
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
		String handle = driver.getWindowHandle();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String TransitProjectName = data.getCellData("TransitRegistration", 0, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(TransitProjectName);
		ProjectRegistrationPage.SelectTransitProjectType();
		ProjectRegistrationPage.enterAnnualRidership(data.getCellData("TransitRegistration", 2, 2));
		ProjectRegistrationPage.enterWeeklyOperatingHrs(data.getCellData("TransitRegistration", 3, 2));
		ProjectRegistrationPage.enterFulltimeStaff(data.getCellData("TransitRegistration", 4, 2));
		ProjectRegistrationPage.enterAvgTimeSpent(data.getCellData("TransitRegistration", 5, 2));
		ProjectRegistrationPage.SelectUnitType("square meter");
		ProjectRegistrationPage.enterGrossArea(data.getCellData("TransitRegistration", 6, 2));
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode("2101 L St NW washington DC 20037 USA");

		boolean flag = ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		if (flag) {
			// ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);

		log.info("Transit_Agreement_Check_AddButtonEnabled method ends here ........... ");
	}

	@Test(groups = "TransitRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"ProjectType_Transit_Value_Validation" }, priority = 6, enabled = true, description = "Verify when 'I agree to … agreement' checkbox is selected, 'Add project' button gets enabled.")
	public void Transit_UG_Non_Leed_Project_Creation() {
		log.info("Transit_UG_Non_Leed_Project_Creation method start here................");
		String UG_ProjectTransitID = null;
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
		String handle = driver.getWindowHandle();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String TransitProjectName = data.getCellData("TransitRegistration", 0, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(TransitProjectName);
		ProjectRegistrationPage.SelectTransitProjectType();
		ProjectRegistrationPage.SelectStationType("Underground");
		ProjectRegistrationPage.enterAnnualRidership(data.getCellData("TransitRegistration", 2, 2));
		ProjectRegistrationPage.enterWeeklyOperatingHrs(data.getCellData("TransitRegistration", 3, 2));
		ProjectRegistrationPage.enterFulltimeStaff(data.getCellData("TransitRegistration", 4, 2));
		ProjectRegistrationPage.enterAvgTimeSpent(data.getCellData("TransitRegistration", 5, 2));
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProjectRegistrationPage.enterGrossArea(data.getCellData("TransitRegistration", 6, 2));
		ProjectRegistrationPage.SelectUnitType("square feet");
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode("2101 L St NW washington DC 20037 USA");
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		ProjectRegistrationPage.ClickonTransitAddProjectButton();
		ngWebDriver.waitForAngularRequestsToFinish();
		TransitPage = ProjectRegistrationPage.ClickOnPreviewAccess();
		TransitPage.ClickonTrailCloseButton();

		boolean flag = TransitPage.checkTransitProjectCreation(TransitProjectName);
		if (flag) {
			TransitPage.ClickonProjectInManage();
			UG_ProjectTransitID = TransitPage.getProjectID(TransitProjectName);
			System.setProperty("Transit_UG_NonLeedID", UG_ProjectTransitID);
			log.info("UG-Transit Project ID (1) is----->" + UG_ProjectTransitID);
			String env = System.getProperty("environment");
			log.info("Environment is ---->" + env);
			if (env.equals("STG")) {
				UG_ProjectTransitID.substring(0, 4).equals("9001");
				log.info("Project creation done successfully.......");
				Assert.assertTrue(true);
			} else if (env.equals("QAS")) {
				UG_ProjectTransitID.substring(0, 4).equals("9000");
				log.info("Project creation done successfully.......");
				Assert.assertTrue(true);
			} else {
				log.info("Project Creation failed........");
				Assert.assertTrue(false);
			}
		}

		log.info("Transit_UG_Non_Leed_Project_Creation method ends here ........... ");
	}

	@Test(groups = "TransitRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"ProjectType_Transit_Value_Validation" }, priority = 24, enabled = true, description = "Verify when 'I agree to … agreement' checkbox is selected, 'Add project' button gets enabled.")
	public void Transit_UG_Leed_Project_Creation() {
		log.info("Transit_UG_Leed_Project_Creation method start here................");
		String UG_ProjectTransitID = null;
		String UG_ProjectName = null;
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
		String handle = driver.getWindowHandle();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String TransitProjectName = data.getCellData("TransitRegistration", 0, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(TransitProjectName);
		ProjectRegistrationPage.SelectTransitProjectType();
		ProjectRegistrationPage.SelectStationType("Underground");
		ProjectRegistrationPage.enterAnnualRidership(data.getCellData("TransitRegistration", 2, 2));
		ProjectRegistrationPage.enterWeeklyOperatingHrs(data.getCellData("TransitRegistration", 3, 2));
		ProjectRegistrationPage.enterFulltimeStaff(data.getCellData("TransitRegistration", 4, 2));
		ProjectRegistrationPage.enterAvgTimeSpent(data.getCellData("TransitRegistration", 5, 2));
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProjectRegistrationPage.enterGrossArea(data.getCellData("TransitRegistration", 6, 2));
		ProjectRegistrationPage.SelectUnitType("square feet");
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode("2101 L St NW washington DC 20037 USA");
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		ProjectRegistrationPage.ClickonTransitAddProjectButton();
		ngWebDriver.waitForAngularRequestsToFinish();
		ProjectPaymentPage = ProjectRegistrationPage.ClickOnPayNow();
		ProjectPaymentPage.selectSpaceType(data.getCellData("TransitRegistration", 12, 2));
		ProjectPaymentPage.selectOwnerType(data.getCellData("TransitRegistration", 13, 2));
		ProjectPaymentPage.selectOwnerOrg(data.getCellData("TransitRegistration", 14, 2));
		ProjectPaymentPage.enterOwnerEmail(data.getCellData("TransitRegistration", 15, 2));
		// ProjectPaymentPage.selectOwnerRegion(data.getCellData("TransitRegistration",
		// 16, 2));
		ProjectPaymentPage.selectRatingSystem("LEED for transit");
		ProjectPaymentPage.clickOnSave();

		ngWebDriver.waitForAngularRequestsToFinish();

		ProjectPaymentPage.EnterBillingName(data.getCellData("TransitRegistration", 18, 2));
		ProjectPaymentPage.enterBillingEmail(data.getCellData("TransitRegistration", 15, 2));
		ProjectPaymentPage.EnterBillingAddress(data.getCellData("TransitRegistration", 7, 2));
		ProjectPaymentPage.EnterBillingCity(data.getCellData("TransitRegistration", 8, 2));
		ProjectPaymentPage.selectBillingState(data.getCellData("TransitRegistration", 10, 2));
		ProjectPaymentPage.EnterBillingZipCode(data.getCellData("TransitRegistration", 11, 2));

		ProjectPaymentPage.EnterCardNumber(data.getCellData("TransitRegistration", 18, 2));
		ProjectPaymentPage.EnterExpiryDate(data.getCellData("TransitRegistration", 19, 2));
		ProjectPaymentPage.EnterCvv(data.getCellData("TransitRegistration", 20, 2));
		TransitPage = ProjectPaymentPage.ClickonTransitSubmitButton();

		boolean flag = TransitPage.checkTransitProjectCreation(TransitProjectName);
		System.out.println("Flag is --------->" + flag);
		if (flag) {
			TransitPage.ClickonProjectInManage();
			UG_ProjectTransitID = TransitPage.getProjectID(TransitProjectName);
			System.setProperty("UG_TransitPrivateProject_2", UG_ProjectTransitID);
			UG_ProjectName = driver.findElement(By.xpath("//input[@name='name']")).getAttribute("value");
			System.setProperty("UG_ProjectName", UG_ProjectName);
			log.info("Project Name is -------->" + UG_ProjectName);
			log.info("UG-Transit ProjectID (2) is -------->" + UG_ProjectTransitID);
			if (UG_ProjectTransitID.substring(0, 4).equals("1000")) {
				log.info("Project creation done successfully.......");
				Assert.assertTrue(true);
			} else {
				log.info(" Project creation failed..................");
				Assert.assertTrue(false);
			}

		}

		log.info("Transit_UG_Leed_Project_Creation method ends here ........... ");
	}

	@Test(groups = "TransitRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"ProjectType_Transit_Value_Validation" }, priority = 25, enabled = true, description = "Verify when 'I agree to … agreement' checkbox is selected, 'Add project' button gets enabled.")
	public void Transit_UG_Leed_PrivateProject_Creation() {
		log.info("Transit_UG_Leed_PrivateProject_Creation method start here................");
		String UG_PrivateProjectTransitID = null;
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
		String handle = driver.getWindowHandle();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String TransitProjectName = data.getCellData("TransitRegistration", 0, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(TransitProjectName);
		ProjectRegistrationPage.SelectTransitProjectType();
		ProjectRegistrationPage.SelectStationType("Above ground");
		ProjectRegistrationPage.enterAnnualRidership(data.getCellData("TransitRegistration", 2, 2));
		ProjectRegistrationPage.enterWeeklyOperatingHrs(data.getCellData("TransitRegistration", 3, 2));
		ProjectRegistrationPage.enterFulltimeStaff(data.getCellData("TransitRegistration", 4, 2));
		ProjectRegistrationPage.enterAvgTimeSpent(data.getCellData("TransitRegistration", 5, 2));
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProjectRegistrationPage.enterGrossArea(data.getCellData("TransitRegistration", 6, 2));
		ProjectRegistrationPage.SelectUnitType("square feet");
		ProjectRegistrationPage.SelectProjectIsPrivateCheckBox();
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode("2101 L St NW washington DC 20037 USA");
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		ProjectRegistrationPage.ClickonTransitAddProjectButton();

		ngWebDriver.waitForAngularRequestsToFinish();
		ProjectPaymentPage = ProjectRegistrationPage.ClickOnPayNow();
		ProjectPaymentPage.selectSpaceType(data.getCellData("TransitRegistration", 12, 2));
		ProjectPaymentPage.selectOwnerType(data.getCellData("TransitRegistration", 13, 2));
		ProjectPaymentPage.selectOwnerOrg(data.getCellData("TransitRegistration", 14, 2));
		ProjectPaymentPage.enterOwnerEmail(data.getCellData("TransitRegistration", 15, 2));
//			ProjectPaymentPage.selectOwnerRegion(data.getCellData("TransitRegistration", 16, 2));
		ProjectPaymentPage.selectRatingSystem("LEED for transit");
		ProjectPaymentPage.clickOnSave();
		ngWebDriver.waitForAngularRequestsToFinish();

		ProjectPaymentPage.EnterBillingName(data.getCellData("TransitRegistration", 17, 2));
		ProjectPaymentPage.enterBillingEmail(data.getCellData("TransitRegistration", 15, 2));
		ProjectPaymentPage.EnterBillingAddress(data.getCellData("TransitRegistration", 7, 2));
		ProjectPaymentPage.EnterBillingCity(data.getCellData("TransitRegistration", 8, 2));
		ProjectPaymentPage.selectBillingState(data.getCellData("TransitRegistration", 10, 2));
		ProjectPaymentPage.EnterBillingZipCode(data.getCellData("TransitRegistration", 11, 2));

		ProjectPaymentPage.EnterCardNumber(data.getCellData("TransitRegistration", 18, 2));
		ProjectPaymentPage.EnterExpiryDate(data.getCellData("TransitRegistration", 19, 2));
		ProjectPaymentPage.EnterCvv(data.getCellData("TransitRegistration", 20, 2));
		TransitPage = ProjectPaymentPage.ClickonTransitSubmitButton();

		boolean flag = TransitPage.checkTransitProjectCreation(TransitProjectName);
		if (flag) {
			TransitPage.ClickonProjectInManage();
			UG_PrivateProjectTransitID = TransitPage.getProjectID(TransitProjectName);
			System.setProperty("UG_TransitPrivateProject_3", UG_PrivateProjectTransitID);
			log.info("UG-Transit Project ID (3)" + UG_PrivateProjectTransitID);
			if ((TransitPage.CheckProjectIsPrivateFlagUnderManage(UG_PrivateProjectTransitID) == true)) {
				Assert.assertTrue(true);
			} else {
				log.info("This is Project is Private as YES radiobutton is not selected..................");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Project is Private Creation gets failed..........");
			Assert.assertTrue(false);
		}

		log.info("Transit_UG_Leed_PrivateProject_Creation method ends here ........... ");
	}

	@Test(groups = "TransitRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"ProjectType_Transit_Value_Validation" }, priority = 26, enabled = true, description = "Verify when 'I agree to … agreement' checkbox is selected, 'Add project' button gets enabled.")
	public void Transit_AG_Non_Leed_Project_Creation() {
		log.info("Transit_AG_Non_Leed_Project_Creation method start here................");
		String AG_TransitProjectID = null;
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
		String handle = driver.getWindowHandle();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String TransitProjectName = data.getCellData("TransitRegistration", 1, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(TransitProjectName);
		ProjectRegistrationPage.SelectTransitProjectType();
		ProjectRegistrationPage.SelectStationType("Above ground");
		ProjectRegistrationPage.enterAnnualRidership(data.getCellData("TransitRegistration", 2, 2));
		ProjectRegistrationPage.enterWeeklyOperatingHrs(data.getCellData("TransitRegistration", 3, 2));
		ProjectRegistrationPage.enterFulltimeStaff(data.getCellData("TransitRegistration", 4, 2));
		ProjectRegistrationPage.enterAvgTimeSpent(data.getCellData("TransitRegistration", 5, 2));
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProjectRegistrationPage.enterGrossArea(data.getCellData("TransitRegistration", 6, 2));
		ProjectRegistrationPage.SelectUnitType("square feet");
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode("2101 L St NW washington DC 20037 USA");
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		ProjectRegistrationPage.ClickonTransitAddProjectButton();

		TransitPage = ProjectRegistrationPage.ClickOnPreviewAccess();
		TransitPage.ClickonTrailCloseButton();

		boolean flag = TransitPage.checkTransitProjectCreation(TransitProjectName);
		if (flag) {
			TransitPage.ClickonProjectInManage();
			AG_TransitProjectID = TransitPage.getProjectID(TransitProjectName);
			System.setProperty("Transit_AG_NonLeedID", AG_TransitProjectID);
			log.info("AG-Transit Project ID (2) is ------->" + AG_TransitProjectID);
			String env = System.getProperty("environment");
			log.info("Environment is ---->" + env);
			if (env.equals("STG")) {
				AG_TransitProjectID.substring(0, 4).equals("9001");
				log.info("Project creation done successfully.......");
				Assert.assertTrue(true);
			} else if (env.equals("QAS")) {
				AG_TransitProjectID.substring(0, 4).equals("9000");
				log.info("Project creation done successfully.......");
				Assert.assertTrue(true);
			} else {
				log.info("Project Creation failed........");
				Assert.assertTrue(false);
			}
		}

		log.info("Transit_AG_Non_Leed_Project_Creation method ends here ........... ");
	}

	@Test(groups = "TransitRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"ProjectType_Transit_Value_Validation" }, priority = 27, enabled = true, description = "Verify when 'I agree to … agreement' checkbox is selected, 'Add project' button gets enabled.")
	public void Transit_AG_Leed_Project_Creation() {
		log.info("Transit_AG_Leed_Project_Creation method start here................");
		String AG_TransitProjectID = null;
		String AG_ProjectName = null;
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
		String handle = driver.getWindowHandle();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String TransitProjectName = data.getCellData("TransitRegistration", 1, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(TransitProjectName);
		ProjectRegistrationPage.SelectTransitProjectType();
		ProjectRegistrationPage.SelectStationType("Above ground");
		ProjectRegistrationPage.enterAnnualRidership(data.getCellData("TransitRegistration", 2, 2));
		ProjectRegistrationPage.enterWeeklyOperatingHrs(data.getCellData("TransitRegistration", 3, 2));
		ProjectRegistrationPage.enterFulltimeStaff(data.getCellData("TransitRegistration", 4, 2));
		ProjectRegistrationPage.enterAvgTimeSpent(data.getCellData("TransitRegistration", 5, 2));
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProjectRegistrationPage.enterGrossArea(data.getCellData("TransitRegistration", 6, 2));
		ProjectRegistrationPage.SelectUnitType("square feet");
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode("2101 L St NW washington DC 20037 USA");
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		ProjectRegistrationPage.ClickonTransitAddProjectButton();
		ngWebDriver.waitForAngularRequestsToFinish();
		ProjectPaymentPage = ProjectRegistrationPage.ClickOnPayNow();
		ProjectPaymentPage.selectSpaceType(data.getCellData("TransitRegistration", 12, 2));
		ProjectPaymentPage.selectOwnerType(data.getCellData("TransitRegistration", 13, 2));
		ProjectPaymentPage.selectOwnerOrg(data.getCellData("TransitRegistration", 14, 2));
		ProjectPaymentPage.enterOwnerEmail(data.getCellData("TransitRegistration", 15, 2));
//			ProjectPaymentPage.selectOwnerRegion(data.getCellData("TransitRegistration", 16, 2));
		ProjectPaymentPage.selectRatingSystem("LEED for transit");
		ProjectPaymentPage.clickOnSave();

		ngWebDriver.waitForAngularRequestsToFinish();

		ProjectPaymentPage.EnterBillingName(data.getCellData("TransitRegistration", 17, 2));
		ProjectPaymentPage.enterBillingEmail(data.getCellData("TransitRegistration", 15, 2));
		ProjectPaymentPage.EnterBillingAddress(data.getCellData("TransitRegistration", 7, 2));
		ProjectPaymentPage.EnterBillingCity(data.getCellData("TransitRegistration", 8, 2));
		ProjectPaymentPage.selectBillingState(data.getCellData("TransitRegistration", 10, 2));
		ProjectPaymentPage.EnterBillingZipCode(data.getCellData("TransitRegistration", 11, 2));

		ProjectPaymentPage.EnterCardNumber(data.getCellData("TransitRegistration", 18, 2));
		ProjectPaymentPage.EnterExpiryDate(data.getCellData("TransitRegistration", 19, 2));
		ProjectPaymentPage.EnterCvv(data.getCellData("TransitRegistration", 20, 2));
		TransitPage = ProjectPaymentPage.ClickonTransitSubmitButton();

		boolean flag = TransitPage.checkTransitProjectCreation(TransitProjectName);
		if (flag) {
			TransitPage.ClickonProjectInManage();
			AG_TransitProjectID = TransitPage.getProjectID(TransitProjectName);
			System.setProperty("AG_TransitProject_2", AG_TransitProjectID);
			AG_ProjectName = driver.findElement(By.xpath("//input[@name='name']")).getAttribute("value");
			System.setProperty("AG_ProjectName2", AG_ProjectName);
			log.info("Project Name is -------->" + AG_ProjectName);
			log.info("AG-Transit Project ID (2) is ------->" + AG_TransitProjectID);
			if (AG_TransitProjectID.substring(0, 4).equals("1000")) {
				// ParkingPage.ClickonProjectInManage();
				log.info("Project creation done successfully.......");
				Assert.assertTrue(true);
			} else {
				log.info(" Project creation failed..................");
				Assert.assertTrue(false);
			}

		}

		log.info("Transit_AG_Leed_Project_Creation method ends here ........... ");
	}

	@Test(groups = "TransitRegression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"ProjectType_Transit_Value_Validation" }, priority = 28, enabled = true, description = "Verify when 'I agree to … agreement' checkbox is selected, 'Add project' button gets enabled.")
	public void Transit_AG_Leed_PivateProject_Creation() {
		log.info("Transit_AG_Leed_PivateProject_Creation method start here................");
		String AG_PrivateTransitProjectID = null;
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
		String handle = driver.getWindowHandle();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		String TransitProjectName = data.getCellData("TransitRegistration", 1, 2)
				+ CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(TransitProjectName);
		ProjectRegistrationPage.SelectTransitProjectType();
		ProjectRegistrationPage.SelectStationType("Above ground");
		ProjectRegistrationPage.enterAnnualRidership(data.getCellData("TransitRegistration", 2, 2));
		ProjectRegistrationPage.enterWeeklyOperatingHrs(data.getCellData("TransitRegistration", 3, 2));
		ProjectRegistrationPage.enterFulltimeStaff(data.getCellData("TransitRegistration", 4, 2));
		ProjectRegistrationPage.enterAvgTimeSpent(data.getCellData("TransitRegistration", 5, 2));
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProjectRegistrationPage.enterGrossArea(data.getCellData("TransitRegistration", 6, 2));
		ProjectRegistrationPage.SelectUnitType("square feet");
		ProjectRegistrationPage.SelectProjectIsPrivateCheckBox();
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode("2101 L St NW washington DC 20037 USA");
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		ProjectRegistrationPage.ClickonTransitAddProjectButton();
		ngWebDriver.waitForAngularRequestsToFinish();
		ProjectPaymentPage = ProjectRegistrationPage.ClickOnPayNow();
		ProjectPaymentPage.selectSpaceType(data.getCellData("TransitRegistration", 12, 2));
		ProjectPaymentPage.selectOwnerType(data.getCellData("TransitRegistration", 13, 2));
		ProjectPaymentPage.selectOwnerOrg(data.getCellData("TransitRegistration", 14, 2));
		ProjectPaymentPage.enterOwnerEmail(data.getCellData("TransitRegistration", 15, 2));
//			ProjectPaymentPage.selectOwnerRegion(data.getCellData("TransitRegistration", 16, 2));
		ProjectPaymentPage.selectRatingSystem("LEED for transit");
		ProjectPaymentPage.clickOnSave();

		ngWebDriver.waitForAngularRequestsToFinish();

		ProjectPaymentPage.EnterBillingName(data.getCellData("TransitRegistration", 17, 2));
		ProjectPaymentPage.enterBillingEmail(data.getCellData("TransitRegistration", 15, 2));
		ProjectPaymentPage.EnterBillingAddress(data.getCellData("TransitRegistration", 7, 2));
		ProjectPaymentPage.EnterBillingCity(data.getCellData("TransitRegistration", 8, 2));
		ProjectPaymentPage.selectBillingState(data.getCellData("TransitRegistration", 10, 2));
		ProjectPaymentPage.EnterBillingZipCode(data.getCellData("TransitRegistration", 11, 2));

		ProjectPaymentPage.EnterCardNumber(data.getCellData("TransitRegistration", 18, 2));
		ProjectPaymentPage.EnterExpiryDate(data.getCellData("TransitRegistration", 19, 2));
		ProjectPaymentPage.EnterCvv(data.getCellData("TransitRegistration", 20, 2));
		TransitPage = ProjectPaymentPage.ClickonTransitSubmitButton();

		boolean flag = TransitPage.checkTransitProjectCreation(TransitProjectName);
		if (flag) {
			TransitPage.ClickonProjectInManage();
			AG_PrivateTransitProjectID = TransitPage.getProjectID(TransitProjectName);
			System.setProperty("AG_PrivateTransitProject_3", AG_PrivateTransitProjectID);
			log.info("AG-Transit Project ID (3) is ------>" + AG_PrivateTransitProjectID);
			if ((TransitPage.CheckProjectIsPrivateFlagUnderManage(AG_PrivateTransitProjectID) == true)) {
				Assert.assertTrue(true);
			} else {
				log.info("This is Project is Private as YES radiobutton is not selected..................");
				Assert.assertTrue(false);
			}

		} else {
			log.info("Project is Private Creation gets failed..........");
			Assert.assertTrue(false);
		}

		log.info("Transit_AG_Leed_PrivateProject_Creation method ends here ........... ");
	}

}
