package com.arc.testCases;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.arc.PageObject.InsightPageObject;
import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class HomePageTest extends BaseClass {

	/*
	 * LoginPageObjects LoginPage; HomePageObjects HomePage; ProjectPageObjects
	 * ProjectPage;
	 */

	private static Logger log = LoggerHelper.getLogger(HomePageTest.class);

	/*
	 * public HomePageTest() { //super();
	 * log.info("HomePageTest constructor is called"); }
	 */

	/*
	 * @BeforeMethod
	 * 
	 * @Parameters("browserName") public void setup(String browserName)
	 * 
	 * { log.info("Setup method of HomePageTest class started ");
	 * initializtion(browserName); LoginPage=new LoginPageObjects(); HomePage=new
	 * HomePageObjects(); HomePage=LoginPage.login(prop.getProperty("email"),
	 * prop.getProperty("password"));
	 * log.info("Setup method of HomePageTest class completed "); }
	 */

	/*
	 * @Test( dependsOnGroups = "LoginMethodTCGroup", enabled = false) public void
	 * CheckAfterOnProjectsMenu() {
	 * log.info("CheckAfterOnProjectsMenu method started ");
	 * ProjectPage=HomePage.clickOnProject(); boolean
	 * flag=ProjectPage.CheckProjectLabel(); Assert.assertTrue(flag);
	 * log.info("CheckAfterOnProjectsMenu method completed ");
	 * 
	 * 
	 * e.printStackTrace(); com.arc.commonMethods.CommonMethod.takeScreenshotTest(
	 * "CheckClickOnProjectsMenu");
	 * 
	 * 
	 * }
	 */

	@Test(dependsOnGroups = "LoginMethodTCGroup", priority = 2, groups = {
			"Reboot" }, enabled = true, description = "Verify if Essential user, profile icon-->Billing-->billing and payments tab-->able to download the invoice and receipts successfully.")
	public void EssentialUser_Download_Invoice() {

		HomePage.setHomePageApplication();
		log.info("EssentialUser_Download_Invoice method started ");
		boolean flag = HomePage.ProfileBillingInvoice();

		if (flag) {
			boolean FilesDownloaded = CommonMethod.CheckReceiptAndInvoiceFile();
			if (FilesDownloaded == true) {
				CommonMethod.DeleteAllFiles();
				DownloadFolder.delete();
				log.info("EssentialUser_Download_Invoice method completed ");
				Assert.assertTrue(FilesDownloaded);
			} else {
				CommonMethod.DeleteAllFiles();
				DownloadFolder.delete();
				log.info("EssentialUser_Download_Invoice method completed ");
				Assert.assertTrue(false);
			}

		} else {
			log.info("EssentialUser_Download_Invoice method completed ");
			Assert.assertTrue(false);
		}

	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, priority = 1000, description = "Verify able to Logout Successfully.")
	public void Logout_Test() {

		log.info("Logout_Test method started ");
		HomePage.setHomePageApplication();
		String Title = HomePage.checkSignOut();
		Assert.assertEquals(Title, "Arc Skoru | Sustainability performance platform");

	}

	@Test(dependsOnGroups = "LoginMethodTCGroup", groups = {
			"Reboot" }, priority = 40, description = "Verify able to Login into Insight.")
	public void Login_To_Insight() {
		log.info("InsightLoginTest method started here ... ");
		HomePage.setHomePageApplication();
		InsightPage = HomePage.LoginToInsight();
		if (InsightPage == null) {
			HomePage.closeInsightModelWindow();
			Assert.assertTrue(false);
		} else
			Assert.assertTrue(true);
		log.info("InsightLoginTest method ends here ");

	}

	//////////////////////////////////////////// Regression
	//////////////////////////////////////////// Tests**********************************///////////////////////////////////////////////

	// Verify clicking on add a project at RHS button opens the registration form
	// successfully.

	@Test(groups = "Regression", dependsOnGroups = "LoginMethodTCGroup", priority = 2, enabled = false, description = "Verify clicking on add a project at RHS button opens the registration form successfully.")
	public void Check_Add_A_Project() {
		log.info("Check_Add_A_Project method started ........... ");

		boolean flag = false;
		HomePage.setHomePageApplication();
		ProjectRegistrationPage = HomePage.ClickOnAddAProjectButton();
		flag = ProjectRegistrationPage.checkAddAProjectLabel();
		if (flag) {
			// ProjectRegistrationPage.closeProjectButton();
			Assert.assertTrue(flag);
		} else
			Assert.assertTrue(flag);

		log.info("Check_Add_A_Project method ends here ........... ");

	}

}
