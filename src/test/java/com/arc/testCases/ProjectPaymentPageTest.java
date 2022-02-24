package com.arc.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import com.arc.PageObject.ProjectPaymentPageObject;
import com.arc.PageObject.Project.ParkingPageObject;
import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class ProjectPaymentPageTest extends BaseClass {
	private static Logger log = LoggerHelper.getLogger(ProjectPaymentPageTest.class);

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 26, enabled = true, description = "Verify Billing Name should allow special character (-&+/:',-.#)")
	public void BillingName_With_Valid_SpecialCharacters() {
		log.info(" BillingName_With_Valid_SpecialCharacters method started ........... ");
		boolean flag = false;
		try {
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String UnregisteredProjectParkingID = System.getProperty("UnregisteredParkSmartProjectID");
		System.out.println(UnregisteredProjectParkingID);
		if (!UnregisteredProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ProjectPaymentPage = ProjectPage.SearchAndClickOnUnregisteredParkingProject(UnregisteredProjectParkingID);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ProjectPaymentPage.EnterBillingName(data.getCellData("ProjectRegistration", 24, 2) + "-&+/:',-.#");

			try {
				flag = ProjectPaymentPage.CheckBillingNameValidationMsg();

			} catch (Exception e) {
				e.printStackTrace();
			}

			if (!flag) {
				Assert.assertTrue(true);
			} else
				Assert.assertTrue(false);

			log.info("BillingName_With_Valid_SpecialCharacters method ends here ........... ");
		}

	}

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 27, enabled = true, description = "Verify Billing Name should allow special character (-&+/:',-.#)")
	public void BillingName_With_InValid_SpecialCharacters() {
		log.info(" BillingName_With_InValid_SpecialCharacters method started ........... ");

		boolean flag = false;
		try {
			ProjectPaymentPage.CancelPaymentButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String UnregisteredProjectParkingID = System.getProperty("UnregisteredParkSmartProjectID");
		System.out.println(UnregisteredProjectParkingID);
		if (!UnregisteredProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ProjectPaymentPage = ProjectPage.SearchAndClickOnUnregisteredParkingProject(UnregisteredProjectParkingID);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ProjectPaymentPage.EnterBillingName(data.getCellData("ProjectRegistration", 24, 2) + "!~$%^*()");

			try {
				flag = ProjectPaymentPage.CheckBillingNameValidationMsg();

			} catch (Exception e) {
				e.printStackTrace();
			}

			if (flag) {
				Assert.assertTrue(true);
			} else
				Assert.assertTrue(false);

			log.info("BillingName_With_InValid_SpecialCharacters method ends here ........... ");
		}

	}

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 28, enabled = true, description = "Verify by adding email should take the value in email format- with only 1 '@' and upto 2 '.' allowed.")

	public void Billing_Email_Validation() {

		log.info(" Billing_Email_Validation method started ........... ");
		boolean flag = false;
		try {
			ProjectPaymentPage.CancelPaymentButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String UnregisteredProjectParkingID = System.getProperty("UnregisteredParkSmartProjectID");
		System.out.println(UnregisteredProjectParkingID);
		if (!UnregisteredProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ProjectPaymentPage = ProjectPage.SearchAndClickOnUnregisteredParkingProject(UnregisteredProjectParkingID);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ProjectPaymentPage.EnterBillingName(data.getCellData("ProjectRegistration", 24, 2));
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ProjectPaymentPage.enterBillingEmail(data.getCellData("ProjectRegistration", 22, 2));

			try {
				flag = ProjectPaymentPage.CheckEmailValidationMsg();

			} catch (Exception e) {
				e.printStackTrace();
			}

			if (!flag) {
				Assert.assertTrue(true);
			} else
				Assert.assertTrue(false);

			log.info("Billing_Email_Validation method ends here ........... ");
		}
	}

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 29, enabled = true, description = "Verify by adding email should take the value in email format- with only 1 '@' and upto 2 '.' allowed.")

	public void Billing_Invalid_Email_Validation() {

		log.info(" Billing_Invalid_Email_Validation method started ........... ");
		boolean flag = false;
		try {
			ProjectPaymentPage.CancelPaymentButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String UnregisteredProjectParkingID = System.getProperty("UnregisteredParkSmartProjectID");
		System.out.println(UnregisteredProjectParkingID);
		if (!UnregisteredProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ProjectPaymentPage = ProjectPage.SearchAndClickOnUnregisteredParkingProject(UnregisteredProjectParkingID);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ProjectPaymentPage.EnterBillingName(data.getCellData("ProjectRegistration", 24, 2));
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ProjectPaymentPage.enterBillingEmail(data.getCellData("ProjectRegistration", 22, 2) + "@gmail.com");

			try {
				flag = ProjectPaymentPage.CheckEmailValidationMsg();

			} catch (Exception e) {
				e.printStackTrace();
			}

			if (flag) {
				Assert.assertTrue(true);
			} else
				Assert.assertTrue(false);

			log.info("Billing_Email_Validation method ends here ........... ");
		}
	}

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 30, enabled = true, description = "Verify able to successfully enter address in Address, City and Zipcode field")

	public void Billing_Address_Validation() {

		log.info(" Billing_Address_Validation method started ........... ");
		boolean flag = false;
		
		try {
			ProjectPaymentPage.CancelPaymentButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String UnregisteredProjectParkingID = System.getProperty("UnregisteredParkSmartProjectID");
		System.out.println(UnregisteredProjectParkingID);
		if (!UnregisteredProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ProjectPaymentPage = ProjectPage.SearchAndClickOnUnregisteredParkingProject(UnregisteredProjectParkingID);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ProjectPaymentPage.EnterBillingAddress(data.getCellData("ProjectRegistration", 3, 2));
			ProjectPaymentPage.EnterBillingCity(data.getCellData("ProjectRegistration", 4, 2));
			ProjectPaymentPage.EnterBillingZipCode(data.getCellData("ProjectRegistration", 7, 2));
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				flag = ProjectPaymentPage.CheckAddressValidationMsg();

			} catch (Exception e) {
				e.printStackTrace();
			}
			if (!flag) {
				Assert.assertTrue(true);
			} else
				Assert.assertTrue(false);

			log.info("Billing_Email_Validation method ends here ........... ");
		}
	}

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 31, enabled = true, description = "Verify Country field contains dropdown and select a country.")

	public void Billing_Country_Validation() {

		log.info(" Billing_Country_Validation method started ........... ");
		
		try {
			ProjectPaymentPage.CancelPaymentButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String UnregisteredProjectParkingID = System.getProperty("UnregisteredParkSmartProjectID");
		System.out.println(UnregisteredProjectParkingID);
		if (!UnregisteredProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ProjectPaymentPage = ProjectPage.SearchAndClickOnUnregisteredParkingProject(UnregisteredProjectParkingID);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			boolean flag = ProjectPaymentPage.Check_Billing_Country("United States");
			System.out.println("Flag is -------> " + flag);
			if (!flag) {
				Assert.assertTrue(true);
			} else
				Assert.assertTrue(false);

			log.info("Billing_Country_Validation method ends here ........... ");
		}
	}

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 32, enabled = true, description = "Verify that the credit card details like Card Number, CVV, Expiry are valid")

	public void CreditCard_Number_Validation() {

		log.info(" CreditCard_Number_Validation method started ........... ");
		boolean flag = false;	
		try {
			ProjectPaymentPage.CancelPaymentButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String UnregisteredProjectParkingID = System.getProperty("UnregisteredParkSmartProjectID");
		System.out.println(UnregisteredProjectParkingID);
		if (!UnregisteredProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ProjectPaymentPage = ProjectPage.SearchAndClickOnUnregisteredParkingProject(UnregisteredProjectParkingID);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			ProjectPaymentPage.EnterCardNumber(data.getCellData("ProjectRegistration", 25, 2));
		

			try {
				flag = ProjectPaymentPage.CheckCardNumberValidationMsg();

			} catch (Exception e) {
				e.printStackTrace();
			}

			if (!flag) {
				Assert.assertTrue(true);

			} else
				Assert.assertTrue(false);

			log.info("CreditCard_Number_Validation method ends here ........... ");
		}
	}

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 33, enabled = true, description = "Verify that the credit card details like Card Number, CVV, Expiry are valid")

	public void Credit_Invalid_Card_Number_Validation() {

		log.info(" CreditCard_Invalid_Number_Validation method started ........... ");
		boolean flag = false;
		try {
			ProjectPaymentPage.CancelPaymentButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String UnregisteredProjectParkingID = System.getProperty("UnregisteredParkSmartProjectID");
		System.out.println(UnregisteredProjectParkingID);
		if (!UnregisteredProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ProjectPaymentPage = ProjectPage.SearchAndClickOnUnregisteredParkingProject(UnregisteredProjectParkingID);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			ProjectPaymentPage.EnterCardNumber(data.getCellData("ProjectRegistration", 25, 2) + "!@#$");
			
			try {
				flag = ProjectPaymentPage.CheckCardNumberValidationMsg();

			} catch (Exception e) {
				e.printStackTrace();
			}

			if (flag) {
				Assert.assertTrue(true);

			} else
				Assert.assertTrue(false);

			log.info("CreditCard_Invalid_Number_Validation method ends here ........... ");
		}
	}

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 34, enabled = true, description = "Verify that the credit card details like Card Number, CVV, Expiry are valid")

	public void CreditCard_Expiry_Validation() {

		log.info(" CreditCard_Expiry_Validation method started ........... ");
		boolean flag = false;	
		try {
			ProjectPaymentPage.CancelPaymentButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String UnregisteredProjectParkingID = System.getProperty("UnregisteredParkSmartProjectID");
		System.out.println(UnregisteredProjectParkingID);
		if (!UnregisteredProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ProjectPaymentPage = ProjectPage.SearchAndClickOnUnregisteredParkingProject(UnregisteredProjectParkingID);

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ProjectPaymentPage.EnterExpiryDate(data.getCellData("ProjectRegistration", 26, 2));

			try {
				flag = ProjectPaymentPage.CheckExpiryValidationMsg();

			} catch (Exception e) {
				e.printStackTrace();
			}

			if (!flag) {
				Assert.assertTrue(true);

			} else
				Assert.assertTrue(false);

			log.info("CreditCard_Details_Validation method ends here ........... ");
		}
	}

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 35, enabled = true, description = "Verify that the credit card details like Card Number, CVV, Expiry are valid")

	public void CreditCard_Invalid_Expiry_Validation() {

		log.info(" CreditCard_Invalid_Expiry_Validatio method started ........... ");
		boolean flag = false;
		
		try {
			ProjectPaymentPage.CancelPaymentButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String UnregisteredProjectParkingID = System.getProperty("UnregisteredParkSmartProjectID");
		System.out.println(UnregisteredProjectParkingID);
		if (!UnregisteredProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ProjectPaymentPage = ProjectPage.SearchAndClickOnUnregisteredParkingProject(UnregisteredProjectParkingID);

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ProjectPaymentPage.EnterExpiryDate("12/23");

			try {
				flag = ProjectPaymentPage.CheckExpiryValidationMsg();

			} catch (Exception e) {
				e.printStackTrace();
			}

			if (flag) {
				Assert.assertTrue(true);

			} else
				Assert.assertTrue(false);

			log.info("CreditCard_Invalid_Expiry_Validation method ends here ........... ");
		}
	}

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 36, enabled = true, description = "Verify that the credit card details like Card Number, CVV, Expiry are valid")

	public void CreditCard_Cvv_Validation() {

		log.info(" CreditCard_Expiry_Validation method started ........... ");
		boolean flag = false;
		
		try {
			ProjectPaymentPage.CancelPaymentButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String UnregisteredProjectParkingID = System.getProperty("UnregisteredParkSmartProjectID");
		System.out.println(UnregisteredProjectParkingID);
		if (!UnregisteredProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ProjectPaymentPage = ProjectPage.SearchAndClickOnUnregisteredParkingProject(UnregisteredProjectParkingID);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			ProjectPaymentPage.EnterCvv(data.getCellData("ProjectRegistration", 27, 2));

			try {
				flag = ProjectPaymentPage.CheckCvvValidationMsg();

			} catch (Exception e) {
				e.printStackTrace();
			}

			if (!flag) {
				Assert.assertTrue(true);

			} else
				Assert.assertTrue(false);

			log.info("CreditCard_Details_Validation method ends here ........... ");
		}
	}

	@Test(groups = "ParkSmartRegression", dependsOnGroups = "LoginMethodTCGroup", priority = 37, enabled = true, description = "Verify that the credit card details like Card Number, CVV, Expiry are valid")

	public void CreditCard_Invalid_Cvv_Validation() {

		log.info(" CreditCard_Invalid_Cvv_Validatio method started ........... ");
		boolean flag = false;
		
		try {
			ProjectPaymentPage.CancelPaymentButton();
			HomePage.setHomePageApplication();

		} catch (Exception e) {
			HomePage.setHomePageApplication();
			e.printStackTrace();
		}
		String UnregisteredProjectParkingID = System.getProperty("UnregisteredParkSmartProjectID");
		System.out.println(UnregisteredProjectParkingID);
		if (!UnregisteredProjectParkingID.equals(null)) {
			ProjectPage = HomePage.clickOnProject();
			ProjectPaymentPage = ProjectPage.SearchAndClickOnUnregisteredParkingProject(UnregisteredProjectParkingID);

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ProjectPaymentPage.EnterCvv("abc");

			try {
				flag = ProjectPaymentPage.CheckCvvValidationMsg();

			} catch (Exception e) {
				e.printStackTrace();
			}

			if (flag) {
				Assert.assertTrue(true);

			} else
				Assert.assertTrue(false);

			log.info("CreditCard_Invalid_Expiry_Validation method ends here ........... ");
		}
	}

}