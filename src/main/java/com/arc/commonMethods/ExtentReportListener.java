package com.arc.commonMethods;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener extends TestListenerAdapter{
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	
	public void onStart(ITestContext testContext)
	{
		
		//htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/Reports/"+"ARC_Reboot_TestReport_"+testContext.getName()+".html");//specify location of the report
		
		//htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/Reports/"+"ARC_Reboot_TestReport"+".html");
		//htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		
		htmlReporter=new ExtentHtmlReporter("Reports/"+"ARC_Reboot_TestReport"+".html");
		htmlReporter.loadXMLConfig("extent-config.xml");
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		
		
		htmlReporter.config().setDocumentTitle("ARC Essential Project"); // Tile of report
		htmlReporter.config().setReportName("Reboot Test Automation Report"); // name of the report
		
		
		htmlReporter.config().setTheme(Theme.DARK);
		System.out.println(testContext.getSuite().getName());
		
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		
		
		//logger=extent.createTest(tr.getTestContext().getName()+"::"+tr.getName()); // create new entry in the report
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
	}
	
	public void onTestFailure(ITestResult tr)
	{
		System.out.println("Test Name in TestNG.xml is  ----------"+tr.getTestName());
		//logger=extent.createTest(tr.getTestContext().getName()+"::"+tr.getName()); // create new entry in the report
		logger=extent.createTest(tr.getName());
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
		
		String ScreenShotFile=CommonMethod.takeScreenshotTest(tr.getName());
		
		 
		
			logger.log(Status.FAIL,tr.getThrowable());
			
			try {
				logger.addScreenCaptureFromPath(ScreenShotFile,"Testing Purpose");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		
		//logger=extent.createTest(tr.getTestContext().getName()+"::"+tr.getName()); // create new entry in the report
		logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
}
