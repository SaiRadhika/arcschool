package com.arc.testCases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.arc.PageObject.HomePageObjects;
import com.arc.PageObject.LoginPageObjects;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;



public class LoginPageTest extends BaseClass{
	/*
	 * LoginPageObjects LoginPage; HomePageObjects HomePage;
	 */
	
	private static Logger log= LoggerHelper.getLogger(LoginPageTest.class);
	
	/*
	 * public LoginPageTest() { //super();
	 * log.info("LoginPageTest constructor is called"); }
	 */
	
	/*
	 * @BeforeMethod
	 * 
	 * @Parameters("browserName") public void setup(String browserName) {
	 * log.info("Setup method of LoginPageTest class started ");
	 * initializtion(browserName); LoginPage=new LoginPageObjects(); HomePage=new
	 * HomePageObjects();
	 * log.info("Setup method of LoginPageTest class completed "); }
	 */
	
	
	@Test(enabled=false)
	public void LoginPageTitleTest()
	{
			LoginPage=new LoginPageObjects();
			HomePage=new HomePageObjects();
		    log.info("LoginPageTitleTest started");
			String Title=LoginPage.checkLoginPageTitle();
			Assert.assertEquals("Arc Skoru | Sustainability performance platform", Title);
			log.info("LoginPageTitleTest completed");
	}
	
	@Test(groups={"LoginMethodTCGroup" }, priority = 1)
	
	public void Login_ApplicationTest()
	{
		LoginPage=new LoginPageObjects();
		HomePage=new HomePageObjects();
		log.info("LoginApplicationTest started");
		HomePage=LoginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		boolean flag = HomePage.CheckHomePageLabel();
		if(flag)
		{
			log.info("LoginApplicationTest completed");
			Assert.assertTrue(true);
		}
		else
		{
			log.info("LoginApplicationTest completed");
			Assert.assertTrue(false);
		}
		
		
		
	}
	/*
	 * @AfterMethod public void tearDown() {
	 * log.info("tearDown method of LoginPageTest class started "); closeBrowser();
	 * log.info("tearDown method of LoginPageTest class completed "); }
	 */

}
