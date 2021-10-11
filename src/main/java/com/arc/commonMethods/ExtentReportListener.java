package com.arc.commonMethods;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener extends TestListenerAdapter {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	private static Logger log = LoggerHelper.getLogger(ExtentReportListener.class);

	public void onStart(ITestContext testContext) {

		// htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+
		// "/Reports/"+"ARC_Reboot_TestReport_"+testContext.getName()+".html");//specify
		// location of the report

		// htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+
		// "/Reports/"+"ARC_Reboot_TestReport"+".html");
		// htmlReporter.loadXMLConfig(System.getProperty("user.dir")+
		// "/extent-config.xml");
		log.info(" Extent Report onStart method started......");
		htmlReporter = new ExtentHtmlReporter("Reports/" + "ARC_Automation_TestReport" + ".html");
		htmlReporter.loadXMLConfig("extent-config.xml");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");

		htmlReporter.config().setDocumentTitle("ARC Essential Project"); // Tile of report
		htmlReporter.config().setReportName("Test Automation Report"); // name of the report

		htmlReporter.config().setTheme(Theme.DARK);
		log.info(testContext.getSuite().getName());
		log.info(" Extent Report onStart method ends......");

	}

	public void onTestSuccess(ITestResult tr) {

		// logger=extent.createTest(tr.getTestContext().getName()+"::"+tr.getName()); //
		// create new entry in the report
		log.info(" Extent Report onTestSuccess method started......");
		logger = extent.createTest(tr.getName(), tr.getMethod().getDescription());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // send the passed
																							// information to the report
																							// with GREEN color
																							// highlighted
		log.info(tr.getName() + " method got success...");
		log.info(" Extent Report onTestSuccess method ends......");
	}

	public void onTestFailure(ITestResult tr) {
		log.info(" Extent Report onTestFailure method starts......");
		// log.info("Test Name in TestNG.xml is ----------"+tr.getTestName());
		// logger=extent.createTest(tr.getTestContext().getName()+"::"+tr.getName()); //
		// create new entry in the report
		// log.info("=============="+tr.getAttribute("description"));
		// log.info("=============="+tr.getAttributeNames());
		logger = extent.createTest(tr.getName(), tr.getMethod().getDescription());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); // send the passed information
																							// to the report with GREEN
																							// color highlighted
		log.info(tr.getThrowable());
		String ScreenShotFile = CommonMethod.takeScreenshotTest(tr.getName());
		log.info("Screen Shot Path is ---" + ScreenShotFile);
		logger.log(Status.FAIL, tr.getThrowable());

		try {

			String OS_Name = System.getProperty("os.name");
			if (OS_Name.equalsIgnoreCase("Linux")) {
				{
					String path=System.getProperty("user.dir") + "/Screenshots";
					log.info("Linux Screenshot path is "+path);
					File ListOfFiles[] = (new File(path)).listFiles();
					log.info("Total file downloaded ...." + ListOfFiles.length);
					if (ListOfFiles.length != 0) {
						for (File file : ListOfFiles) {
							log.info("Size of the file - " + file.getName() + " is  " + file.length()+" File Path is .."+file.getPath()+"  "+file.getAbsolutePath());
							log.info("CheckDownloadedFile method ends here ......");
							//return file.length();
						}
					}
					logger.addScreenCaptureFromPath(path, "Testing Purpose");
					log.info("Screenshot attached to Extent Report Successfully on Linux...");
				}
			}
			else
			{
				logger.addScreenCaptureFromPath(ScreenShotFile, "Testing Purpose");
				log.info("Screenshot attached to Extent Report Successfully on windows...");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.info("Unable to attch screenshot to Extent Report Successfully...");
			e.printStackTrace();
		}

		log.info(tr.getName() + " method got Failed...");
		log.info(" Extent Report onTestFailure method ends......");

	}

	public void onTestSkipped(ITestResult tr) {
		log.info(" Extent Report onTestSkipped method starts......");
		// logger=extent.createTest(tr.getTestContext().getName()+"::"+tr.getName()); //
		// create new entry in the report
		// log.info("=============="+tr.getAttribute("description"));
		// log.info("=============="+tr.getAttributeNames());
		logger = extent.createTest(tr.getName(), tr.getMethod().getDescription());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		log.info(tr.getName() + " method got skipped...");
		log.info(" Extent Report onTestSkipped method ends......");
	}

	public void onFinish(ITestContext testContext) {
		log.info(" Extent Report onFinish method starts......");
		log.info("==============" + testContext.getAttribute("description"));
		log.info("==============" + testContext.getAttributeNames());
		extent.flush();

		log.info(" Extent Report onFinish method ends......");
	}
}
