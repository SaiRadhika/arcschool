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

	@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 3, enabled = true, description = "Verify Project Name should allow special character (-&+/:',-.#)")
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
		//ProjectRegistrationPage.closeProjectButton();
		log.info("ProjectName_With_Valid_SpecialCharacters method ends here ........... ");

	}

	
	// Verify with Invalid special characters for Project name are !~$%^*()

		@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 4, enabled = true, description = "Verify with Invalid special characters for Project name are !~$%^*()")
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
			//ProjectRegistrationPage.closeProjectButton();
			log.info("ProjectName_With_Invalid_SpecialCharacters method ends here ........... ");

		}

	// Verify Project Type is selected as 'Cities'

	@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 5, enabled = true, description = "Verify Project Type is selected as 'Cities'")
	public void Check_ProjectType_City_Value() {
		log.info("Check_ProjectType_City_Value method started ........... ");
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
		HomePage.clickOnProject();
		HomePage.clickOnCitiesSubMenu();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		ProjectRegistrationPage.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));

		try {

			flag = ProjectRegistrationPage.SelectCityProjectType();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		//ProjectRegistrationPage.closeProjectButton();
		log.info("Check_ProjectType_City_Value method ends here ........... ");

	}

	// Verify City adding Gross area - limit allowed is Max: 19,305 square miles

	@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Check_ProjectType_City_Value" }, priority = 6,  enabled = true, description = "Verify City adding Gross area - limit allowed is Max: 19,305 square miles")
	public void ProjectRegistration_GrossArea_Valid_19305_SQ_Miles() {
		log.info("ProjectRegistration_GrossArea_Valid_19305_SQ_Miles method started ........... ");
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
		ProjectRegistrationPage.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
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
		//ProjectRegistrationPage.closeProjectButton();
		log.info("ProjectRegistration_GrossArea_Valid_19305_SQ_Miles method ends here ........... ");

	}

	
	// Verify City adding invalid Gross area - limit  19,306 square miles

		@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
				"Check_ProjectType_City_Value" }, priority = 7, enabled = true, description = "Verify City adding invalid Gross area - limit  19,306 square miles")
		public void ProjectRegistration_GrossArea_Invalid_19306_SQ_Miles() {
			log.info("ProjectRegistration_GrossArea_Invalid_19306_SQ_Miles method started ........... ");
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
			ProjectRegistrationPage.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
			ProjectRegistrationPage.SelectCityProjectType();
			
			ProjectRegistrationPage.enterGrossArea("19306");
			ProjectRegistrationPage.SelectUnitType("square miles");
			ProjectRegistrationPage.enterPopulation(data.getCellData("ProjectRegistration", 2, 2));
			ProjectRegistrationPage.clickNoLEEDRegistration();
			ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
			ProjectRegistrationPage.CheckServiceAgreementCheckbox();
			CityPage=ProjectRegistrationPage.ClickonCityAddProjectButton();
			try {

				flag = ProjectRegistrationPage.CheckGrossAreaValidationMsg();

			} catch (Exception e) {
				e.printStackTrace();
			}
			if (flag) {
				Assert.assertTrue(true);
			} else
				Assert.assertTrue(false);
			//ProjectRegistrationPage.closeProjectButton();
			log.info("ProjectRegistration_GrossArea_Invalid_19306_SQ_Miles method ends here ........... ");

		}

		
		
		// Verify City adding Gross area - limit allowed is Max: 50000 square kilometers

		@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
				"Check_ProjectType_City_Value" }, priority = 8, enabled = true, description = "Verify City adding Gross area - limit allowed is Max: 50000 square kilometers")
		public void ProjectRegistration_GrossArea_Valid_50000_SQ_KM() {
			log.info("ProjectRegistration_GrossArea_Valid_50000_SQ_KM method started ........... ");
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
			ProjectRegistrationPage.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
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
			//ProjectRegistrationPage.closeProjectButton();
			log.info("ProjectRegistration_GrossArea_Valid_50000_SQ_KM method ends here ........... ");

		}

		
		// Verify City adding invalid Gross area - limit  50001 square Kilometer

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
					"Check_ProjectType_City_Value" }, priority = 9, enabled = true, description = " Verify City adding invalid Gross area - limit  50001 square Kilometer")
			public void ProjectRegistration_GrossArea_Invalid_50001_SQ_KM() {
				log.info("ProjectRegistration_GrossArea_Invalid_50001_SQ_KM method started ........... ");
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
				ProjectRegistrationPage.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
				ProjectRegistrationPage.SelectCityProjectType();
				
				ProjectRegistrationPage.enterGrossArea("50001");
				ProjectRegistrationPage.SelectUnitType("square kilometers");
				ProjectRegistrationPage.enterPopulation(data.getCellData("ProjectRegistration", 2, 2));
				ProjectRegistrationPage.clickNoLEEDRegistration();
				ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
				ProjectRegistrationPage.CheckServiceAgreementCheckbox();
				CityPage=ProjectRegistrationPage.ClickonCityAddProjectButton();
				try {

					flag = ProjectRegistrationPage.CheckGrossAreaValidationMsg();

				} catch (Exception e) {
					e.printStackTrace();
				}
				if (flag) {
					Assert.assertTrue(true);
				} else
					Assert.assertTrue(false);
				//ProjectRegistrationPage.closeProjectButton();
				log.info("ProjectRegistration_GrossArea_Invalid_50001_SQ_KM method ends here ........... ");

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
	@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Check_ProjectType_City_Value" }, priority = 10, enabled = true, description = "Verify if 'Are you registering for a LEED CERTIFICATION' is selected as 'Yes', opens a new modal window with text as below:\r\n"
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
		ProjectRegistrationPage.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectCityProjectType();
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.clickYesLEEDRegistration();
		flag = ProjectRegistrationPage.Validate_LEEDRegistrationPopupMessage();
		if (flag) {
			//ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(flag);
		} else
			Assert.assertTrue(flag);
		// ProjectRegistrationPage.closeProjectButton();
		log.info("ProjectRegistration_LEED_Registration_Yes_CheckMessage method ends here ........... ");

	}

	// Verify the new modal window shows two buttons- 'Register for LEED
	// certification now' and 'Not now'

	@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 11, dependsOnMethods = {
			"Check_ProjectType_City_Value" }, enabled = true, description = "Verify the new modal window shows two buttons- 'Register for LEED certification now' and 'Not now'")
	public void ProjectRegistration_LEED_Regis_Shows_RegisterforLEEDcertification_NotNow() {
		log.info("ProjectRegistration_LEED_Regis_Shows_RegisterforLEEDcertification_NotNow method started ........... ");
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
		ProjectRegistrationPage.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectCityProjectType();
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.clickYesLEEDRegistration();
		flag = ProjectRegistrationPage.CheckRegisterforLEEDPopupButtonsExists();

		if (flag) {
			//ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(flag);
		} else
			Assert.assertTrue(flag);
		log.info("ProjectRegistration_LEED_Regis_Shows_RegisterforLEEDcertification_NotNow method ends here ........... ");

	}

	// Verify clicking on 'Register for LEED certification now' redirects to Leed Online portal.

	@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Check_ProjectType_City_Value",
			"ProjectRegistration_LEED_Regis_Shows_RegisterforLEEDcertification_NotNow" }, priority = 12, enabled = true, description = "Verify clicking on 'Register for LEED certification now' redirects to Leed Online portal.")
	public void ProjectRegistration_LEED_Regis_Redirects_LeedOnlineportal() {
		log.info("ProjectRegistration_LEED_Regis_Redirects_LeedOnlineportal method started ........... ");
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
		String handle = driver.getWindowHandle();
		ProjectRegistrationPage.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
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
			//ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(true);
		} else {
			//ProjectRegistrationPage.clickOnNotNowPopUpButton();
			Assert.assertTrue(false);
		}

		log.info("ProjectRegistration_LEED_Regis_Redirects_LeedOnlineportal method ends here ........... ");
	}

	// Verify clicking on 'Not now' closes the modal window and keeps the user at
	// the registration page.
	// Verify clicking on 'Not now' closes the modal window and selects the 'No'
	// radio button.

	@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Check_ProjectType_City_Value",
			"ProjectRegistration_LEED_Regis_Shows_RegisterforLEEDcertification_NotNow" }, priority = 13, enabled = true, description = "Verify clicking on 'Not now' closes the modal window and keeps the user at the registration page. \r\n"
					+ "	// Verify clicking on 'Not now' closes the modal window and selects the 'No' radio button.")
	public void ProjectRegistration_LEED_Registration_Not_Now_Test() {
		log.info("ProjectRegistration_LEED_Registration_Not_Now_Test method started ........... ");
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
		ProjectRegistrationPage.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectCityProjectType();
		System.out.println(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.clickYesLEEDRegistration();
		ProjectRegistrationPage.clickOnNotNowPopUpButton();
		boolean flag = ProjectRegistrationPage.checkAfterClickOnNotNowPopupButton();

		if (flag) {

			//ProjectRegistrationPage.closeProjectButton();
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

	@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Check_ProjectType_City_Value" }, priority = 14, enabled = true, description = "Verify address field auto populates the address(this address is being pulled using google maps API).\r\n"
					+ "	Verify auto pulled address populates all the fields -City, County,States,zipcode")
	public void ProjectRegistration_AutoPopulate_Address_City_Country_State_ZipCode() {
		log.info("ProjectRegistration_AutoPopulate_Address_City_Country_State_ZipCode method started ........... ");
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
		ProjectRegistrationPage.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectCityProjectType();
		System.out.println(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.clickNoLEEDRegistration();

		boolean flag = ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode("2101 L St NW washington DC 20037 USA");
		if (flag) {
			//ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		log.info("ProjectRegistration_AutoPopulate_Address_City_Country_State_ZipCode method ends here ........... ");
	}

	// Verify after address is auto pulled, geo location gets auto -populated.

	@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Check_ProjectType_City_Value",
			"ProjectRegistration_AutoPopulate_Address_City_Country_State_ZipCode" }, priority = 15, enabled = true, description = "Verify after address is auto pulled, geo location gets auto -populated.")
	public void ProjectRegistration_AutoPopulate_Latitude_Longitude() {
		log.info("ProjectRegistration_AutoPopulate_Latitude_Longitude method started ........... ");
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
		ProjectRegistrationPage.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectCityProjectType();
		System.out.println(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.clickNoLEEDRegistration();

		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode("2101 L St NW washington DC 20037 USA");
		boolean flag = ProjectRegistrationPage.CheckGeoLocation();
		if (flag) {
			//ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		log.info("ProjectRegistration_AutoPopulate_Latitude_Longitude method ends here ........... ");
	}

	// Verify able to download service agreement successfully.

	@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Check_ProjectType_City_Value" }, priority = 16, enabled = true, description = " Verify able to download service agreement successfully.")
	public void ProjectRegistration_Download_Service_Agreement() {
		log.info("ProjectRegistration_Download_Service_Agreement method started ........... ");
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
		ProjectRegistrationPage.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
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
			//ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);

		log.info("ProjectRegistration_Download_Service_Agreement method ends here ........... ");
	}

	// Verify when 'I agree to … agreement' checkbox is selected, 'Add project'
	// button gets enabled.

	@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Check_ProjectType_City_Value" }, priority = 17, enabled = true, description = "Verify when 'I agree to … agreement' checkbox is selected, 'Add project' button gets enabled.")
	public void ProjectRegistration_Agreement_Check_AddButtonEnabled() {
		log.info("ProjectRegistration_Agreement_Check_AddButtonEnabled method started ........... ");
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
		ProjectRegistrationPage.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectCityProjectType();
		boolean flag = ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		if (flag) {
			//ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);

		log.info("ProjectRegistration_Agreement_Check_AddButtonEnabled method ends here ........... ");
	}

	// Verify clicking on checkbox for 'This is a test project' creates a test
	// project and the same gets populated after project creation under
	// manage-project.
	
	
	@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Check_ProjectType_City_Value","ProjectRegistration_AutoPopulate_Address_City_Country_State_ZipCode","ProjectRegistration_AutoPopulate_Latitude_Longitude" }, priority = 18, enabled = true, description = "Verify clicking on checkbox for 'This is a test project' creates a test project and the same gets populated after project creation under  manage-project.")
	public void City_TestProject_Creation() {
		log.info("City_TestProject_Creation method started ........... ");
		String ProjectCityID=null;
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
		String CityProjectName = data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(6);
		ProjectRegistrationPage.enterProjectName(CityProjectName);
		ProjectRegistrationPage.SelectThisIsTestProjectCheckBox();
		ProjectRegistrationPage.SelectCityProjectType();
		System.out.println(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.SelectUnitType("square miles");
		//ProjectRegistrationPage.enterPopulation(data.getCellData("City", 2, 2));
		ProjectRegistrationPage.clickNoLEEDRegistration();
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		CityPage=ProjectRegistrationPage.ClickonCityAddProjectButton();

		boolean flag=CityPage.checkCityProjectCreation(CityProjectName);
		if(flag)
		{
			CityPage.ClickonProjectInManage();
			ProjectCityID=CityPage.getProjectID(CityProjectName);
			System.setProperty("CityProject_Test1", ProjectCityID);
			log.info("  CityProject_Test1 is ---"+ProjectCityID);
				
					if(CityPage.CheckThisIsTestProjectCheckBox(ProjectCityID))
					{
						log.info("This is test project creation done successfully ........... ");
						Assert.assertTrue(true);
					}
					else
					{
						log.info("This is Test Project checkbox is not checked..................");
						log.info("City_TestProject_Creation method ends with false here ........... ");
						Assert.assertTrue(false);
					}
		}
		else
		{
			log.info("Project Creation gets failed..........");
			log.info("City_TestProject_Creation method ends with false here ........... ");
			Assert.assertTrue(false);
		}
		
		
			

		log.info("City_TestProject_Creation method ends here ........... ");
	}

	
	// Verify clicking on 'Add project' button registers the project with non-leed id.
	// Verify that the population field is optional.

	@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Check_ProjectType_City_Value","ProjectRegistration_AutoPopulate_Address_City_Country_State_ZipCode","ProjectRegistration_AutoPopulate_Latitude_Longitude" }, priority = 19, enabled = true, description = "Verify clicking on 'Add project' button registers the project with non-leed id")
	public void City_NonLEEDProject_Creation() {
		log.info("City_NonLEEDProject_Creation method started ........... ");
		String ProjectCityID=null;
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
		String CityProjectName = data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(6);
		ProjectRegistrationPage.enterProjectName(CityProjectName);
		//ProjectRegistrationPage.SelectThisIsTestProjectCheckBox();
		ProjectRegistrationPage.SelectCityProjectType();
		System.out.println(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
		ProjectRegistrationPage.SelectUnitType("square miles");
		//ProjectRegistrationPage.enterPopulation(data.getCellData("City", 2, 2));
		ProjectRegistrationPage.clickNoLEEDRegistration();
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		CityPage=ProjectRegistrationPage.ClickonCityAddProjectButton();

		boolean flag=CityPage.checkCityProjectCreation(CityProjectName);
		if(flag)
		{
			CityPage.ClickonProjectInManage();
			ProjectCityID=CityPage.getProjectID(CityProjectName);
			System.setProperty("CityProject_NonLeed2", ProjectCityID);
			log.info("  CityProject_NonLeed2 is ---"+ProjectCityID);
				if(ProjectCityID.substring(0, 4).equals("8000"))
				{
					log.info("Non LEED ID Project creation successful..................");
					Assert.assertTrue(true);
				}
				else
				{
					log.info("Non LEED ID Project creation failed..................");
					Assert.assertTrue(false);
				}
			
		}
		else
		{
			log.info("Project Creation gets failed..........");
			Assert.assertTrue(false);
		}
		
		
			

		log.info("City_NonLEEDProject_Creation method ends here ........... ");
	}

	
	
	// Verify if 'project is private' is selected, shows private as 'Yes' under Manage--project.
	

		@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
				"Check_ProjectType_City_Value","ProjectRegistration_AutoPopulate_Address_City_Country_State_ZipCode","ProjectRegistration_AutoPopulate_Latitude_Longitude" }, priority = 20, enabled = true
						,description = "Verify if 'project is private' is selected, shows private as 'Yes' under Manage--project.")
		public void City_Project_Is_Private_Creation() {
			log.info("City_Project_Is_Private_Creation method started ........... ");
			String ProjectCityID="";
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
			CityPage=ProjectRegistrationPage.ClickonCityAddProjectButton();

			boolean flag=CityPage.checkCityProjectCreation(CityProjectName);
			//String HeaderText=CityPage.CheckPerformanceHeaderShowing();
			if(flag)
			{
				CityPage.ClickonProjectInManage();
				ProjectCityID=CityPage.getProjectID(CityProjectName);
				System.setProperty("CityProject_Private3", ProjectCityID);
				log.info("  CityProject_Private3 is ---"+ProjectCityID);
						if((CityPage.CheckProjectIsPrivateFlagUnderManage(ProjectCityID)==true ))
						{
							Assert.assertTrue(true);
						}
						else
						{
							log.info("This is Project is Private as YES radiobutton is not selected..................");
							Assert.assertTrue(false);
						}
					
				
			}
			else
			{
				log.info("Project is Private Creation gets failed..........");
				Assert.assertTrue(false);
			}
			
			
				

			log.info("City_Project_Is_Private_Creation method ends here ........... ");
		}
		
		
		// Verify clicking on 'Add project' button opens the 'Performance' Tab.
		

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
					"Check_ProjectType_City_Value","ProjectRegistration_AutoPopulate_Address_City_Country_State_ZipCode","ProjectRegistration_AutoPopulate_Latitude_Longitude" }, priority = 21, enabled = true
							,description = "Verify clicking on 'Add project' button opens the 'Performance' Tab.")
			public void City_Project_Creation_Opens_Performance_Screen() {
				log.info("City_Project_Creation_Opens_Performance_Screen method started ........... ");
				String ProjectCityID="";
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
				String CityProjectName = data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5);
				ProjectRegistrationPage.enterProjectName(CityProjectName);			
				ProjectRegistrationPage.SelectCityProjectType();
				System.out.println(data.getCellData("ProjectRegistration", 1, 2));
				ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
				ProjectRegistrationPage.SelectUnitType("square miles");
				ProjectRegistrationPage.enterPopulation(data.getCellData("ProjectRegistration", 2, 2));
				ProjectRegistrationPage.clickNoLEEDRegistration();
				//ProjectRegistrationPage.SelectProjectIsPrivateCheckBox();
				ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
				ProjectRegistrationPage.CheckServiceAgreementCheckbox();
				CityPage=ProjectRegistrationPage.ClickonCityAddProjectButton();

				boolean flag=CityPage.checkCityProjectCreation(CityProjectName);
				String HeaderText=CityPage.CheckPerformanceHeaderShowing();
				if(flag)
				{
					CityPage.ClickonProjectInManage();
					ProjectCityID=CityPage.getProjectID(CityProjectName);
					System.setProperty("CityProject_Perf4", ProjectCityID);
					log.info("  CityProject_Perf4 is ---"+ProjectCityID);
							if(HeaderText.equals("Performance"))
							{
								Assert.assertTrue(true);
							}
							else
							{
								log.info("Performance screen not showing..................");
								Assert.assertTrue(false);
							}
						
					
				}
				else
				{
					log.info("Project Creation gets failed..........");
					Assert.assertTrue(false);
				}
				
				
					

				log.info("City_Project_Creation_Opens_Performance_Screen method ends here ........... ");
			}

		
		
	
	
	
//-----------------------------------------------Communities related Test Cases----------------------------
	// Verify Project Type is selected as 'Communities'

		@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 24, enabled = true, description = "Verify Project Type is selected as 'Communities'")
		public void Check_ProjectType_Communities_Value() {
			log.info("Check_ProjectType_Communities_Value method started ........... ");
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
			HomePage.clickOnProject();
			HomePage.clickOnCommunitiesSubMenu();
			ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
			ProjectRegistrationPage.enterProjectName(data.getCellData("ProjectRegistration", 0, 2) + CommonMethod.generateRandomString(5));

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
			//ProjectRegistrationPage.closeProjectButton();
			log.info("Check_ProjectType_Communities_Value method ends here ........... ");

		}
		
		
		// Verify clicking on checkbox for 'This is a test project' creates a test Communities
		// project and the same gets populated after project creation under
		// manage-project.
		
		
		@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
				"Check_ProjectType_Communities_Value","ProjectRegistration_AutoPopulate_Address_City_Country_State_ZipCode","ProjectRegistration_AutoPopulate_Latitude_Longitude" }, priority = 25, enabled = true, description = "Verify clicking on checkbox for 'This is a test project' creates a test Communities project and the same gets populated after project creation under  manage-project.")
		public void Communities_TestProject_Creation() {
			log.info("Communities_TestProject_Creation method started ........... ");
			String ProjectCommunitiesID=null;
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
			String CommunitiesProjectName = data.getCellData("ProjectRegistration", 8, 2) + CommonMethod.generateRandomString(6);
			ProjectRegistrationPage.enterProjectName(CommunitiesProjectName);
			ProjectRegistrationPage.SelectThisIsTestProjectCheckBox();
			ProjectRegistrationPage.SelectCityProjectType();
			System.out.println(data.getCellData("ProjectRegistration", 1, 2));
			ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
			ProjectRegistrationPage.SelectUnitType("square miles");
			//ProjectRegistrationPage.enterPopulation(data.getCellData("City", 2, 2));
			ProjectRegistrationPage.clickNoLEEDRegistration();
			ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
			ProjectRegistrationPage.CheckServiceAgreementCheckbox();
			CommunitiesPage=ProjectRegistrationPage.ClickonCommunitiesAddProjectButton();

			boolean flag=CommunitiesPage.checkCommunitiesProjectCreation(CommunitiesProjectName);
			if(flag)
			{
				CommunitiesPage.ClickonProjectInManage();
				ProjectCommunitiesID=CommunitiesPage.getProjectID(CommunitiesProjectName);
				System.setProperty("CommunitiesProject_Test1", ProjectCommunitiesID);
				log.info("  CommunitiesProject_Test1 is ---"+ProjectCommunitiesID);
					
						if(CommunitiesPage.CheckThisIsTestProjectCheckBox(ProjectCommunitiesID))
						{
							log.info("This is test project creation done successfully ........... ");
							Assert.assertTrue(true);
						}
						else
						{
							log.info("This is Test Project checkbox is not checked..................");
							log.info("Communities_TestProject_Creation method ends with false here ........... ");
							Assert.assertTrue(false);
						}
			}
			else
			{
				log.info("Project Creation gets failed..........");
				log.info("Communities_TestProject_Creation method ends with false here ........... ");
				Assert.assertTrue(false);
			}
			
			
				

			log.info("Communities_TestProject_Creation method ends here ........... ");
		}

		
		// Verify clicking on 'Add project' button registers the project with non-leed id.
		// Verify that the population field is optional.

		@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
				"Check_ProjectType_Communities_Value","ProjectRegistration_AutoPopulate_Address_City_Country_State_ZipCode","ProjectRegistration_AutoPopulate_Latitude_Longitude" }, priority = 26, enabled = true, description = "Verify clicking on 'Add project' button registers the project with non-leed id")
		public void Communities_NonLEEDProject_Creation() {
			log.info("Communities_NonLEEDProject_Creation method started ........... ");
			String ProjectCommunitiesID=null;
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
			String CommunitiesProjectName = data.getCellData("ProjectRegistration", 8, 2) + CommonMethod.generateRandomString(6);
			ProjectRegistrationPage.enterProjectName(CommunitiesProjectName);
			//ProjectRegistrationPage.SelectThisIsTestProjectCheckBox();
			ProjectRegistrationPage.SelectCityProjectType();
			System.out.println(data.getCellData("ProjectRegistration", 1, 2));
			ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
			ProjectRegistrationPage.SelectUnitType("square miles");
			//ProjectRegistrationPage.enterPopulation(data.getCellData("City", 2, 2));
			ProjectRegistrationPage.clickNoLEEDRegistration();
			ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
			ProjectRegistrationPage.CheckServiceAgreementCheckbox();
			CommunitiesPage=ProjectRegistrationPage.ClickonCommunitiesAddProjectButton();

			boolean flag=CommunitiesPage.checkCommunitiesProjectCreation(CommunitiesProjectName);
			if(flag)
			{
				CommunitiesPage.ClickonProjectInManage();
				ProjectCommunitiesID=CommunitiesPage.getProjectID(CommunitiesProjectName);
				System.setProperty("CommunitiesProject_NonLeed2", ProjectCommunitiesID);
				log.info("  CommunitiesProject_NonLeed2 is ---"+ProjectCommunitiesID);
					if(ProjectCommunitiesID.substring(0, 4).equals("8000"))
					{
						log.info("Non LEED ID Project creation successful..................");
						Assert.assertTrue(true);
					}
					else
					{
						log.info("Non LEED ID Project creation failed..................");
						Assert.assertTrue(false);
					}
				
			}
			else
			{
				log.info("Project Creation gets failed..........");
				Assert.assertTrue(false);
			}
			
			
				

			log.info("Communities_NonLEEDProject_Creation method ends here ........... ");
		}

		
		
		// Verify if 'project is private' is selected, shows private as 'Yes' under Manage--project.
		

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
					"Check_ProjectType_Communities_Value","ProjectRegistration_AutoPopulate_Address_City_Country_State_ZipCode","ProjectRegistration_AutoPopulate_Latitude_Longitude" }, priority = 27, enabled = true
							,description = "Verify if 'project is private' is selected, shows private as 'Yes' under Manage--project.")
			public void Communities_Project_Is_Private_Creation() {
				log.info("Communities_Project_Is_Private_Creation method started ........... ");
				String ProjectCommunitiesID="";
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
				String CommunitiesProjectName = data.getCellData("ProjectRegistration", 8, 2) + CommonMethod.generateRandomString(5);
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
				CommunitiesPage=ProjectRegistrationPage.ClickonCommunitiesAddProjectButton();

				boolean flag=CommunitiesPage.checkCommunitiesProjectCreation(CommunitiesProjectName);
				//String HeaderText=CityPage.CheckPerformanceHeaderShowing();
				if(flag)
				{
					CommunitiesPage.ClickonProjectInManage();
					ProjectCommunitiesID=CommunitiesPage.getProjectID(CommunitiesProjectName);
					System.setProperty("CommunitiesProject_Private3", ProjectCommunitiesID);
					log.info("  CommunitiesProject_Private3 is ---"+ProjectCommunitiesID);
							if((CommunitiesPage.CheckProjectIsPrivateFlagUnderManage(ProjectCommunitiesID)==true ))
							{
								Assert.assertTrue(true);
							}
							else
							{
								log.info("This is Project is Private as YES radiobutton is not selected..................");
								Assert.assertTrue(false);
							}
						
					
				}
				else
				{
					log.info("Project is Private Creation gets failed..........");
					Assert.assertTrue(false);
				}
				
				
					

				log.info("Communities_Project_Is_Private_Creation method ends here ........... ");
			}
			
			
			// Verify clicking on 'Add project' button opens the 'Performance' Tab.
			

				@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
						"Check_ProjectType_Communities_Value","ProjectRegistration_AutoPopulate_Address_City_Country_State_ZipCode","ProjectRegistration_AutoPopulate_Latitude_Longitude" }, priority = 28, enabled = true
								,description = "Verify clicking on 'Add project' button opens the 'Performance' Tab.")
				public void Communities_Project_Creation_Opens_Performance_Screen() {
					log.info("Communities_Project_Creation_Opens_Performance_Screen method started ........... ");
					String ProjectCommunitiesID="";
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
					String CommunitiesProjectName = data.getCellData("ProjectRegistration", 8, 2) + CommonMethod.generateRandomString(5);
					ProjectRegistrationPage.enterProjectName(CommunitiesProjectName);			
					ProjectRegistrationPage.SelectCityProjectType();
					System.out.println(data.getCellData("ProjectRegistration", 1, 2));
					ProjectRegistrationPage.enterGrossArea(data.getCellData("ProjectRegistration", 1, 2));
					ProjectRegistrationPage.SelectUnitType("square miles");
					ProjectRegistrationPage.enterPopulation(data.getCellData("ProjectRegistration", 2, 2));
					ProjectRegistrationPage.clickNoLEEDRegistration();
					//ProjectRegistrationPage.SelectProjectIsPrivateCheckBox();
					ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("ProjectRegistration", 3, 2));
					ProjectRegistrationPage.CheckServiceAgreementCheckbox();
					CommunitiesPage=ProjectRegistrationPage.ClickonCommunitiesAddProjectButton();

					boolean flag=CommunitiesPage.checkCommunitiesProjectCreation(CommunitiesProjectName);
					String HeaderText=CommunitiesPage.CheckPerformanceHeaderShowing();
					if(flag)
					{
						CommunitiesPage.ClickonProjectInManage();
						ProjectCommunitiesID=CommunitiesPage.getProjectID(CommunitiesProjectName);
						System.setProperty("CommunitiesProject_Perf4", ProjectCommunitiesID);
						log.info("  CommunitiesProject_Perf4 is ---"+ProjectCommunitiesID);
								if(HeaderText.equals("Performance"))
								{
									Assert.assertTrue(true);
								}
								else
								{
									log.info("Performance screen not showing..................");
									Assert.assertTrue(false);
								}
							
						
					}
					else
					{
						log.info("Project Creation gets failed..........");
						Assert.assertTrue(false);
					}
					
					
						

					log.info("Communities_Project_Creation_Opens_Performance_Screen method ends here ........... ");
				}

			


}
