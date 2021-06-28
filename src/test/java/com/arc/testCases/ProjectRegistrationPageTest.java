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

	@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 3, enabled = false, description = "Verify Project Name should allow special character (-&+/:',-.#)")
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
		ProjectRegistrationPage.enterProjectName(data.getCellData("City", 0, 2) + "-&+/:',-.#");

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

		@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 3, enabled = false, description = "Verify with Invalid special characters for Project name are !~$%^*()")
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
			ProjectRegistrationPage.enterProjectName(data.getCellData("City", 0, 2) + "!~$%^*()");

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

	// Verify Project Type as 'Cities' available in dropdown or not

	@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 3, enabled = true, description = "Verify Project Type as 'Cities' available in dropdown or not")
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
		ProjectRegistrationPage.enterProjectName(data.getCellData("City", 0, 2) + CommonMethod.generateRandomString(5));

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
			"Check_ProjectType_City_Value" }, priority = 3, enabled = false, description = "Verify City adding Gross area - limit allowed is Max: 19,305 square miles")
	public void City_GrossArea_Valid_19305_SQ_Miles() {
		log.info("City_GrossArea_Max_19305_SQ_Miles method started ........... ");
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
		ProjectRegistrationPage.enterProjectName(data.getCellData("City", 0, 2) + CommonMethod.generateRandomString(5));
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
		log.info("City_GrossArea_Max_19305_SQ_Miles method ends here ........... ");

	}

	
	// Verify City adding invalid Gross area - limit  19,306 square miles

		@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
				"Check_ProjectType_City_Value" }, priority = 3, enabled = false, description = "Verify City adding invalid Gross area - limit  19,306 square miles")
		public void City_GrossArea_Invalid_19306_SQ_Miles() {
			log.info("City_GrossArea_Invalid_19306_SQ_Miles method started ........... ");
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
			ProjectRegistrationPage.enterProjectName(data.getCellData("City", 0, 2) + CommonMethod.generateRandomString(5));
			ProjectRegistrationPage.SelectCityProjectType();
			
			ProjectRegistrationPage.enterGrossArea("19306");
			ProjectRegistrationPage.SelectUnitType("square miles");
			ProjectRegistrationPage.enterPopulation(data.getCellData("City", 2, 2));
			ProjectRegistrationPage.clickNoLEEDRegistration();
			ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("City", 3, 2));
			ProjectRegistrationPage.CheckServiceAgreementCheckbox();
			CityPage=ProjectRegistrationPage.ClickonAddProjectButton();
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
			log.info("City_GrossArea_Invalid_19306_SQ_Miles method ends here ........... ");

		}

		
		
		// Verify City adding Gross area - limit allowed is Max: 50000 square kilometers

		@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
				"Check_ProjectType_City_Value" }, priority = 3, enabled = false, description = "Verify City adding Gross area - limit allowed is Max: 50000 square kilometers")
		public void City_GrossArea_Valid_50000_SQ_KM() {
			log.info("City_GrossArea_Valid_50000_SQ_KM method started ........... ");
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
			ProjectRegistrationPage.enterProjectName(data.getCellData("City", 0, 2) + CommonMethod.generateRandomString(5));
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
			log.info("City_GrossArea_Valid_50000_SQ_KM method ends here ........... ");

		}

		
		// Verify City adding invalid Gross area - limit  50001 square Kilometer

			@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
					"Check_ProjectType_City_Value" }, priority = 3, enabled = false, description = " Verify City adding invalid Gross area - limit  50001 square Kilometer")
			public void City_GrossArea_Invalid_50001_SQ_KM() {
				log.info("City_GrossArea_Invalid_50001_SQ_KM method started ........... ");
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
				ProjectRegistrationPage.enterProjectName(data.getCellData("City", 0, 2) + CommonMethod.generateRandomString(5));
				ProjectRegistrationPage.SelectCityProjectType();
				
				ProjectRegistrationPage.enterGrossArea("50001");
				ProjectRegistrationPage.SelectUnitType("square kilometers");
				ProjectRegistrationPage.enterPopulation(data.getCellData("City", 2, 2));
				ProjectRegistrationPage.clickNoLEEDRegistration();
				ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("City", 3, 2));
				ProjectRegistrationPage.CheckServiceAgreementCheckbox();
				CityPage=ProjectRegistrationPage.ClickonAddProjectButton();
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
				log.info("City_GrossArea_Invalid_50001_SQ_KM method ends here ........... ");

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
			"Check_ProjectType_City_Value" }, priority = 3, enabled = false, description = "Verify if 'Are you registering for a LEED CERTIFICATION' is selected as 'Yes', opens a new modal window with text as below:\r\n"
					+ "\"If you're interested in registering this project for LEED certification, please select the \"Register for LEED certification now\" button below and you’ll be routed to LEED Online.\r\n"
					+ "\r\n"
					+ "Otherwise, you can get started now with Arc for free. Just select the \"Not now\" button below.\r\n"
					+ "\r\n"
					+ "You can enter your performance data in Arc and choose to register for LEED later. Your performance data will get you most of the way, but you'll need to complete the LEED prerequisites, and possibly other requirements before submitting for certification.\"\r\n"
					+ "")
	public void City_LEED_Registration_Yes_CheckMessage() {
		log.info("City_LEED_Registration_Yes_CheckMessage method started ........... ");
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
		ProjectRegistrationPage.enterProjectName(data.getCellData("City", 0, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectCityProjectType();
		ProjectRegistrationPage.enterGrossArea(data.getCellData("City", 1, 2));
		ProjectRegistrationPage.clickYesLEEDRegistration();
		flag = ProjectRegistrationPage.Validate_LEEDRegistrationPopupMessage();
		if (flag) {
			//ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(flag);
		} else
			Assert.assertTrue(flag);
		// ProjectRegistrationPage.closeProjectButton();
		log.info("City_LEED_Registration_Yes_CheckMessage method ends here ........... ");

	}

	// Verify the new modal window shows two buttons- 'Register for LEED
	// certification now' and 'Not now'

	@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 3, dependsOnMethods = {
			"Check_ProjectType_City_Value" }, enabled = true, description = "Verify the new modal window shows two buttons- 'Register for LEED certification now' and 'Not now'")
	public void City_LEED_Regis_Shows_RegisterforLEEDcertification_NotNow() {
		log.info("City_LEED_Regis_Shows_RegisterforLEEDcertification_NotNow method started ........... ");
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
		ProjectRegistrationPage.enterProjectName(data.getCellData("City", 0, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectCityProjectType();
		ProjectRegistrationPage.enterGrossArea(data.getCellData("City", 1, 2));
		ProjectRegistrationPage.clickYesLEEDRegistration();
		flag = ProjectRegistrationPage.CheckRegisterforLEEDPopupButtonsExists();

		if (flag) {
			//ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(flag);
		} else
			Assert.assertTrue(flag);
		log.info("City_LEED_Regis_Shows_RegisterforLEEDcertification_NotNow method ends here ........... ");

	}

	// Verify clicking on 'Register for LEED certification now' redirects to Leed
	// Online portal.

	@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Check_ProjectType_City_Value",
			"City_LEED_Regis_Shows_RegisterforLEEDcertification_NotNow" }, priority = 3, enabled = true, description = "Verify clicking on 'Register for LEED certification now' redirects to Leed Online portal.")
	public void City_LEED_Regis_Redirects_LeedOnlineportal() {
		log.info("City_LEED_Regis_Redirects_LeedOnlineportal method started ........... ");
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
		ProjectRegistrationPage.enterProjectName(data.getCellData("City", 0, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectCityProjectType();
		System.out.println(data.getCellData("City", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("City", 1, 2));
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

		log.info("City_LEED_Regis_Redirects_LeedOnlineportal method ends here ........... ");
	}

	// Verify clicking on 'Not now' closes the modal window and keeps the user at
	// the registration page.
	// Verify clicking on 'Not now' closes the modal window and selects the 'No'
	// radio button.

	@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Check_ProjectType_City_Value",
			"City_LEED_Regis_Shows_RegisterforLEEDcertification_NotNow" }, priority = 3, enabled = true, description = "Verify clicking on 'Not now' closes the modal window and keeps the user at the registration page. \r\n"
					+ "	// Verify clicking on 'Not now' closes the modal window and selects the 'No' radio button.")
	public void City_LEED_Registration_Not_Now_Test() {
		log.info("City_LEED_Registration_Not_Now_Test method started ........... ");
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
		ProjectRegistrationPage.enterProjectName(data.getCellData("City", 0, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectCityProjectType();
		System.out.println(data.getCellData("City", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("City", 1, 2));
		ProjectRegistrationPage.clickYesLEEDRegistration();
		ProjectRegistrationPage.clickOnNotNowPopUpButton();
		boolean flag = ProjectRegistrationPage.checkAfterClickOnNotNowPopupButton();

		if (flag) {

			//ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(true);
		} else {

			Assert.assertTrue(false);
		}

		log.info("City_LEED_Registration_Not_Now_Test method ends here ........... ");
	}

	// Verify address field auto populates the address(this address is being pulled
	// using google maps API).
	// Verify auto pulled address populates all the fields -City, County,States,zip
	// code

	@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Check_ProjectType_City_Value" }, priority = 3, enabled = true, description = "Verify address field auto populates the address(this address is being pulled using google maps API).\r\n"
					+ "	Verify auto pulled address populates all the fields -City, County,States,zipcode")
	public void City_AutoPopulate_Address_City_Country_State_ZipCode() {
		log.info("City_AutoPopulate_Address_City_Country_State_ZipCode method started ........... ");
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
		ProjectRegistrationPage.enterProjectName(data.getCellData("City", 0, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectCityProjectType();
		System.out.println(data.getCellData("City", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("City", 1, 2));
		ProjectRegistrationPage.clickNoLEEDRegistration();

		boolean flag = ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode("2101 L St NW washington DC 20037 USA");
		if (flag) {
			//ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		log.info("City_AutoPopulate_Address_City_Country_State_ZipCode method ends here ........... ");
	}

	// Verify after address is auto pulled, geo location gets auto -populated.

	@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Check_ProjectType_City_Value",
			"City_AutoPopulate_Address_City_Country_State_ZipCode" }, priority = 3, enabled = true, description = "Verify after address is auto pulled, geo location gets auto -populated.")
	public void City_AutoPopulate_Latitude_Longitude() {
		log.info("City_AutoPopulate_Latitude_Longitude method started ........... ");
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
		ProjectRegistrationPage.enterProjectName(data.getCellData("City", 0, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectCityProjectType();
		System.out.println(data.getCellData("City", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("City", 1, 2));
		ProjectRegistrationPage.clickNoLEEDRegistration();

		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode("2101 L St NW washington DC 20037 USA");
		boolean flag = ProjectRegistrationPage.CheckGeoLocation();
		if (flag) {
			//ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		log.info("City_AutoPopulate_Latitude_Longitude method ends here ........... ");
	}

	// Verify able to download service agreement successfully.

	@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Check_ProjectType_City_Value" }, priority = 3, enabled = false, description = " Verify able to download service agreement successfully.")
	public void City_Download_Service_Agreement() {
		log.info("City_Download_Service_Agreement method started ........... ");
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
		ProjectRegistrationPage.enterProjectName(data.getCellData("City", 0, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectCityProjectType();
		System.out.println(data.getCellData("City", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("City", 1, 2));
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

		log.info("City_Download_Service_Agreement method ends here ........... ");
	}

	// Verify when 'I agree to … agreement' checkbox is selected, 'Add project'
	// button gets enabled.

	@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Check_ProjectType_City_Value" }, priority = 3, enabled = false, description = "Verify when 'I agree to … agreement' checkbox is selected, 'Add project' button gets enabled.")
	public void City_Agreement_Check_AddButtonEnabled() {
		log.info("City_Agreement_Check_AddButtonEnabled method started ........... ");
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
		ProjectRegistrationPage.enterProjectName(data.getCellData("City", 0, 2) + CommonMethod.generateRandomString(5));
		ProjectRegistrationPage.SelectCityProjectType();
		boolean flag = ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		if (flag) {
			//ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);

		log.info("City_Agreement_Check_AddButtonEnabled method ends here ........... ");
	}

	// Verify clicking on checkbox for 'This is a test project' creates a test
	// project and the same gets populated after project creation under
	// manage-project.
	
	// Verify clicking on 'Add project' button registers the project with non-leed id.
	// Verify that the population field is optional.

	@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Check_ProjectType_City_Value","City_AutoPopulate_Address_City_Country_State_ZipCode","City_AutoPopulate_Latitude_Longitude" }, priority = 3, enabled = true, description = "Verify clicking on checkbox for 'This is a test project' creates a test project and the same gets populated after project creation under  manage-project.\r\n"
					+ "	\r\n"
					+ "	// Verify clicking on 'Add project' button registers the project with non-leed id.\r\n"
					+ "	")
	public void City_TestProject_NonLEED_Creation() {
		log.info("City_TestProject_NonLEED_Creation method started ........... ");
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
		String CityProjectName = data.getCellData("City", 0, 2) + CommonMethod.generateRandomString(5);
		ProjectRegistrationPage.enterProjectName(CityProjectName);
		ProjectRegistrationPage.SelectThisIsTestProjectCheckBox();
		ProjectRegistrationPage.SelectCityProjectType();
		System.out.println(data.getCellData("City", 1, 2));
		ProjectRegistrationPage.enterGrossArea(data.getCellData("City", 1, 2));
		ProjectRegistrationPage.SelectUnitType("square miles");
		//ProjectRegistrationPage.enterPopulation(data.getCellData("City", 2, 2));
		ProjectRegistrationPage.clickNoLEEDRegistration();
		ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("City", 3, 2));
		ProjectRegistrationPage.CheckServiceAgreementCheckbox();
		CityPage=ProjectRegistrationPage.ClickonAddProjectButton();

		boolean flag=CityPage.checkCityProjectCreation(CityProjectName);
		if(flag)
		{
			CityPage.ClickonProjectInManage();
			ProjectCityID=CityPage.getProjectID(CityProjectName);
			System.setProperty("NonLEEDCItyProjectID", ProjectCityID);
				if(ProjectCityID.substring(0, 4).equals("8000"))
				{
					//CityPage.ClickonProjectInManage();
					if(CityPage.CheckThisIsTestProjectCheckBox(ProjectCityID))
					{
						Assert.assertTrue(true);
					}
					else
					{
						log.info("This is Test Project checkbox is not checked..................");
						Assert.assertTrue(false);
					}
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
		
		
			

		log.info("City_TestProject_NonLEED_Creation method ends here ........... ");
	}

	
	
	// Verify if 'project is private' is selected, shows private as 'Yes' under Manage--project.
	
	// Verify clicking on 'Add project' button opens the 'Performance' Tab.
	

		@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
				"Check_ProjectType_City_Value","City_AutoPopulate_Address_City_Country_State_ZipCode","City_AutoPopulate_Latitude_Longitude" }, priority = 3, enabled = true
						,description = "Verify if 'project is private' is selected, shows private as 'Yes' under Manage--project. \r\n Verify clicking on 'Add project' button opens the 'Performance' Tab.")
		public void City_Project_Is_Private_Creation_Opens_Performance_Screen() {
			log.info("City_Project_Is_Private_Creation_Opens_Performance_Screen method started ........... ");
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
			String CityProjectName = data.getCellData("City", 0, 2) + CommonMethod.generateRandomString(5);
			ProjectRegistrationPage.enterProjectName(CityProjectName);			
			ProjectRegistrationPage.SelectCityProjectType();
			System.out.println(data.getCellData("City", 1, 2));
			ProjectRegistrationPage.enterGrossArea(data.getCellData("City", 1, 2));
			ProjectRegistrationPage.SelectUnitType("square miles");
			ProjectRegistrationPage.enterPopulation(data.getCellData("City", 2, 2));
			ProjectRegistrationPage.clickNoLEEDRegistration();
			ProjectRegistrationPage.SelectProjectIsPrivateCheckBox();
			ProjectRegistrationPage.CheckAddress_City_Country_State_ZipCode(data.getCellData("City", 3, 2));
			ProjectRegistrationPage.CheckServiceAgreementCheckbox();
			CityPage=ProjectRegistrationPage.ClickonAddProjectButton();

			boolean flag=CityPage.checkCityProjectCreation(CityProjectName);
			String HeaderText=CityPage.CheckPerformanceHeaderShowing();
			if(flag)
			{
				CityPage.ClickonProjectInManage();
				ProjectCityID=CityPage.getProjectID(CityProjectName);
						if((CityPage.CheckProjectIsPrivateFlagUnderManage(ProjectCityID)==true && HeaderText.equals("Performance")))
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
			
			
				

			log.info("City_Project_Is_Private_Creation_Opens_Performance_Screen method ends here ........... ");
		}

		
		
	
	@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", dependsOnMethods = {
			"Check_ProjectType_City_Value","City_AutoPopulate_Address_City_Country_State_ZipCode","City_AutoPopulate_Latitude_Longitude" }, priority = 3, enabled = false)
	public void City_Test() {
		log.info("City_Test method started ........... ");
		try {
			ProjectRegistrationPage.closeProjectButton();
			HomePage.setHomePageApplication();
		
		/*
		 * if (!HomePage.CheckHomePageLabel())
		 * ProjectRegistrationPage.closeProjectButton();
		 * HomePage.setHomePageApplication();
		 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ProjectPage = HomePage.clickOnProject();
		CityPage = ProjectPage.SearchAndClickOnCityProject("8000004297");
		CityPage.ClickonProjectInManage();
		HomePage.closeProjectSearchTextBox();
		boolean flag = CityPage.CheckThisIsTestProjectCheckBox("8000004297");
		System.out.println("Flag value ------------" + flag);
		if (flag) {
			//HomePage.setHomePageApplication();
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
	}

}
