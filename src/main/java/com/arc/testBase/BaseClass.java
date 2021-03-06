package com.arc.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.arc.PageObject.HomePageObjects;
import com.arc.PageObject.InsightPageObject;
import com.arc.PageObject.LoginPageObjects;
import com.arc.PageObject.ProjectPaymentPageObject;
import com.arc.PageObject.ProjectRegistrationPageObject;
import com.arc.PageObject.Project.BuildingPageObject;
import com.arc.PageObject.Project.CityPageObject;
import com.arc.PageObject.Project.CommunitiesPageObject;
import com.arc.PageObject.Project.ParkingPageObject;
import com.arc.PageObject.Project.ProjectPageObjects;
import com.arc.PageObject.Project.SchoolFinancialModelPageObject;
import com.arc.PageObject.Project.SchoolPageObject;
import com.arc.PageObject.Project.TransitPageObject;
import com.arc.commonMethods.ActionsHelper;
import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.DropDownHelper;
import com.arc.commonMethods.ExcelHelper;
import com.arc.commonMethods.JavaScriptHelper;
import com.arc.commonMethods.LoggerHelper;
import com.arc.commonMethods.WaitHelper;
import com.arc.commonMethods.WebEventListener;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static String ScreenshotPath;
	public static File DownloadFolder;
	private static Logger log = LoggerHelper.getLogger(BaseClass.class);
	public static ExcelHelper data;
	public static Actions action;
	public static LoginPageObjects LoginPage;
	public static HomePageObjects HomePage;
	public static ProjectPageObjects ProjectPage;
	public static BuildingPageObject BuildingPage;
	public static SchoolPageObject SchoolPage;
	public static CityPageObject CityPage;
	public static WaitHelper waithelper;
	public static ActionsHelper actionhelper;
	public static DropDownHelper dropdownhelper;
	public static TransitPageObject TransitPage;
	public static JavaScriptHelper JSHelper;
	public static CommunitiesPageObject CommunitiesPage;
	public static ParkingPageObject ParkingPage;
	public static ProjectRegistrationPageObject ProjectRegistrationPage;
	public static ProjectPaymentPageObject ProjectPaymentPage;
	public static InsightPageObject InsightPage;
	public static String BaseWindow = null; // This will capture the base window handle
	public static NgWebDriver ngWebDriver;
	public static SchoolFinancialModelPageObject SchoolFinancialModelPage;

	@Parameters({ "browserName" })
	@BeforeTest(groups = { "LoginMethodTCGroup", "Reboot", "CityRegression", "CommunityRegression",
			"ProjectRegsRegression", "ParkSmartRegression", "TransitRegression"})
	public static void initializtion(String browserName) {
		log.info("Initialization method started");
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("src/main/java/com/arc/config/config.properties");
			prop.load(fis);

			String testSuite = System.getProperty("suiteXmlFile");
			log.info("Test Suite File is ---" + testSuite);

			if (testSuite != null && testSuite.equalsIgnoreCase("QAS_RebootTestSuite.xml"))
				data = new ExcelHelper("TestData/QAS_RebootTestData.xlsx");
			else if (testSuite != null && testSuite.equalsIgnoreCase("STG_RebootTestSuite.xml"))
				data = new ExcelHelper("TestData/STG_RebootTestData.xlsx");
			else if (testSuite != null && testSuite.equalsIgnoreCase("RegressionTestSuite.xml"))
				data = new ExcelHelper("TestData/RegressionTestData.xlsx");
			else if (testSuite != null && testSuite.equalsIgnoreCase("CityRegressionTestSuite.xml"))
				data = new ExcelHelper("TestData/RegressionTestData.xlsx");
			else if (testSuite != null && testSuite.equalsIgnoreCase("CommunitiesRegressionTestSuite.xml"))
				data = new ExcelHelper("TestData/RegressionTestData.xlsx");
			else if (testSuite != null && testSuite.equalsIgnoreCase("BuildingsRegressionTestSuite.xml"))
				data = new ExcelHelper("TestData/RegressionTestData.xlsx");
			else if (testSuite != null && testSuite.equalsIgnoreCase("ParkSmartRegressionTestSuite.xml"))
				data = new ExcelHelper("TestData/RegressionTestData.xlsx");	
			else if (testSuite != null && testSuite.equalsIgnoreCase("TransitRegressionTestSuite.xml"))
				data = new ExcelHelper("TestData/RegressionTestData.xlsx");
			else
				data = new ExcelHelper("TestData/RegressionTestData.xlsx");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			log.info("Config.properties file not found");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// String browserName = prop.getProperty("browserName");
		CommonMethod.deleteAllDownloadedFiles();
		// CommonMethod.deleteAllPreviousScreenshotsFiles();
		String OS_Name = System.getProperty("os.name");
		log.info("Opearting System is --" + OS_Name);
		if (browserName.equalsIgnoreCase("chrome")) {
			// System.out.println(System.getProperty("user.dir"));
			DownloadFolder = new File("DownLoadedFiles/" + UUID.randomUUID().toString());
			// DownloadFolder.mkdir();
			log.info("DownloadFolder path is --" + DownloadFolder);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");

			/*
			 * options.addArguments("--no-sandbox");
			 * options.addArguments("--disable-dev-shm-usage");
			 * options.addArguments("--headless"); options.addArguments("--disable-gpu");
			 * options.addArguments("window-size=1382x754");
			 */

			Map<String, Object> Pref = new HashMap<String, Object>();
			Pref.put("profile.default_content_settings.popus", 0);
			Pref.put("download.default_directory", DownloadFolder.getAbsolutePath());
			options.setExperimentalOption("prefs", Pref);
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			if (OS_Name.equalsIgnoreCase("Linux")) {
				log.info("Chrome EXE file path is --" + System.getProperty("user.dir") + "/DriverFiles/chromedriver");
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/DriverFiles/chromedriver");
			} else {
				log.info("Chrome EXE file path is --" + System.getProperty("user.dir")
						+ "/DriverFiles/chromedriver.exe");
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/DriverFiles/chromedriver.exe");
			}

			driver = new ChromeDriver(cap);
			log.info("Chrome browser launched successfully");

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/DriverFiles/geckodriver.exe");
			log.info("Firefox browser launched successfully");
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid Browser Name");
			log.info("IE browser launched successfully");
		}

		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);

		driver = e_driver;
		// NgWebDriver ngWebDriver;
		JavascriptExecutor jsDriver;
		jsDriver = (JavascriptExecutor) driver;
		ngWebDriver = new NgWebDriver(jsDriver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		waithelper = new WaitHelper();
		actionhelper = new ActionsHelper();
		JSHelper = new JavaScriptHelper();
		dropdownhelper = new DropDownHelper();
		System.out.println(prop.getProperty("implicitTime"));
		System.out.println(Long.parseLong(prop.getProperty("implicitTime")));
		waithelper.setImplicitWait(Long.parseLong(prop.getProperty("implicitTime")), TimeUnit.SECONDS);
		waithelper.pageLoadTime(Long.parseLong(prop.getProperty("pageloadtime")), TimeUnit.SECONDS);

		log.info("Environment Name is ---" + System.getProperty("environment"));
		String env = System.getProperty("environment");

		if (env != null && env.equalsIgnoreCase("QAS")) {
			driver.get(prop.getProperty("QAurl"));
			log.info("URL navigated to .. " + prop.getProperty("QAurl"));
		} else if (env != null && env.equalsIgnoreCase("STG")) {
			driver.get(prop.getProperty("STGurl"));
			log.info("URL navigated to .. " + prop.getProperty("STGurl"));
		}

		else {
			log.info("Environment is not provided or wrong environment entered......");
			System.setProperty("environment", "STG");
			driver.get(prop.getProperty("QAurl"));
			log.info("URL navigated to .. " + prop.getProperty("STGurl"));
		}
		ngWebDriver.waitForAngularRequestsToFinish();
		BaseWindow = driver.getWindowHandle();
		log.info("Initialization method ends");

	}

	@AfterTest(groups = { "LoginMethodTCGroup", "Reboot", "Regression", "BuildingsRegression", "CityRegression",
			"CommunityRegression","ParkSmartRegression", "TransitRegression" })
	public void closeBrowser() {

		driver.close();

	}
}
