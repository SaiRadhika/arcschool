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
import com.arc.PageObject.LoginPageObjects;
import com.arc.PageObject.ProjectRegistrationPageObject;
import com.arc.PageObject.Project.BuildingPageObject;
import com.arc.PageObject.Project.CityPageObject;
import com.arc.PageObject.Project.CommunitiesPageObject;
import com.arc.PageObject.Project.ParkingPageObject;
import com.arc.PageObject.Project.ProjectPageObjects;
import com.arc.PageObject.Project.SchoolPageObject;
import com.arc.PageObject.Project.TransitPageObject;
import com.arc.commonMethods.ActionsHelper;
import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.ExcelHelper;
import com.arc.commonMethods.JavaScriptHelper;
import com.arc.commonMethods.LoggerHelper;
import com.arc.commonMethods.WaitHelper;
import com.arc.commonMethods.WebEventListener;
import com.arc.commonMethods.DropDownHelper;

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

	/*
	 * public BaseClass() {
	 * 
	 * try { log.info("Base class constructor started"); prop = new Properties();
	 * FileInputStream fis = new FileInputStream( System.getProperty("user.dir") +
	 * "\\src\\main\\java\\com\\arc\\config\\config.properties"); prop.load(fis);
	 * data = new ExcelHelper(System.getProperty("user.dir") +
	 * "/TestData/RebootTest.xlsx");
	 * 
	 * } catch (FileNotFoundException e) { e.printStackTrace();
	 * log.info("Config.properties file not found"); } catch (IOException e) {
	 * e.printStackTrace(); } log.info("Base class constructor ends");
	 * 
	 * }
	 */
	@Parameters("browserName")
	@BeforeTest(groups={"LoginMethodTCGroup","Reboot","Regression" })
	public static void initializtion(String browserName) {
		log.info("Initialization method started");
		try {
			prop = new Properties();
			/*
			 * FileInputStream fis = new FileInputStream( System.getProperty("user.dir") +
			 * "\\src\\main\\java\\com\\arc\\config\\config.properties");
			 */
			
			//FileInputStream fis = new FileInputStream("src\\main\\java\\com\\arc\\config\\config.properties");
			FileInputStream fis = new FileInputStream("src/main/java/com/arc/config/config.properties");
			prop.load(fis);
			//data = new ExcelHelper(System.getProperty("user.dir") + "/TestData/RebootTest.xlsx");
			data = new ExcelHelper( "TestData/RebootTest.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			log.info("Config.properties file not found");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// String browserName = prop.getProperty("browserName");
			//CommonMethod.deleteAllDownloadedFiles();
			//CommonMethod.deleteAllPreviousScreenshotsFiles();
		if (browserName.equalsIgnoreCase("chrome")) {
			// System.out.println(System.getProperty("user.dir"));
			DownloadFolder = new File("DownLoadedFiles/" + UUID.randomUUID().toString());
			// DownloadFolder.mkdir();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			//options.addArguments("--headless");
			Map<String, Object> Pref = new HashMap<String, Object>();
			Pref.put("profile.default_content_settings.popus", 0);
			Pref.put("download.default_directory", DownloadFolder.getAbsolutePath());
			options.setExperimentalOption("prefs", Pref);
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			log.info("Chrome EXE file path is --"+System.getProperty("user.dir") + "/DriverFiles/chromedriver");
			
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/DriverFiles/chromedriver");
			
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
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		waithelper = new WaitHelper();
		actionhelper = new ActionsHelper();
		JSHelper = new JavaScriptHelper();
		dropdownhelper=new DropDownHelper();
		System.out.println(prop.getProperty("implicitTime"));
		System.out.println(Long.parseLong(prop.getProperty("implicitTime")));
		waithelper.setImplicitWait(Long.parseLong(prop.getProperty("implicitTime")), TimeUnit.SECONDS);
		waithelper.pageLoadTime(Long.parseLong(prop.getProperty("pageloadtime")), TimeUnit.SECONDS);
		/*
		 * driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		 * driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 */
		driver.get(prop.getProperty("QAurl"));
		log.info("URL navigated to .. " + prop.getProperty("QAurl"));
		log.info("Initialization method ends");

	}

	@AfterTest(groups={"LoginMethodTCGroup","Reboot","Regression" })
	public void closeBrowser() {

		driver.close();

	}
}
