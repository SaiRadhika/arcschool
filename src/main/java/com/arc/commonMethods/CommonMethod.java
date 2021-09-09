package com.arc.commonMethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arc.testBase.BaseClass;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class CommonMethod extends BaseClass {

	static Format formatter = new SimpleDateFormat("YYYY-MM-dd");
	static Date date = new Date();
	private static boolean root = false;
	private static Logger log = LoggerHelper.getLogger(CommonMethod.class);

	public static String takeScreenshotTest(String MethodName) {
		log.info("takeScreenshotTest method starts here ......");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		
		ScreenshotPath = currentDir + "/Screenshots/" + MethodName;
		//ScreenshotPath ="Screenshots/" + MethodName;
		try {
			FileUtils.copyFile(scrFile, new File(ScreenshotPath + ".png"));
			log.info("Screenshot captured successfully for Method ...." + MethodName);
			log.info("takeScreenshotTest method ends here ......");
			return ScreenshotPath + ".png";

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("Unable to capture Screenshot for Method ...." + MethodName);
		}
		log.info("takeScreenshotTest method ends here ......");
		return null;
	}

	public static String takeScreenshotFullPageTest(String MethodName) {
		log.info("takeScreenshotFullPageTest method starts here ......");

		String currentDir = System.getProperty("user.dir");
		ScreenshotPath = currentDir + "/Screenshots/" + MethodName + "_" + System.currentTimeMillis();
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);
		try {
			ImageIO.write(screenshot.getImage(), "JPEG", new File(ScreenshotPath));
			log.info("Full Screenshot captured successfully for Method ...." + MethodName);
			log.info("takeScreenshotFullPageTest method ends here ......");
		} catch (IOException e) { // TODO Auto-generated catch block
			log.info("Unable to capture Full Screenshot for Method ...." + MethodName);
			e.printStackTrace();
		}
		log.info("takeScreenshotFullPageTest method ends here ......");
		return null;
	}

	
	//This method will return current year 
	
	public static int getCurrentYear() {
		log.info("getCurrentYear method starts here ......");
		int year = Calendar.getInstance().get(Calendar.YEAR);
		log.info("getCurrentYear method ends here ......");
		return year;
		
	}

	public static long CheckDownloadedFile() {
		log.info("CheckDownloadedFile method starts here ......");
		// DownloadFolder=new File(UUID.randomUUID().toString());
		log.info("Temporary folder name is ---"+DownloadFolder);
		File ListOfFiles[] = DownloadFolder.listFiles();
		// make sure the directory is not empty
		log.info("Total file downloaded ...." + ListOfFiles.length);
		if (ListOfFiles.length != 0) {
			for (File file : ListOfFiles) {
				log.info("Size of the file - " + file.getName() + " is  " + file.length());
				log.info("CheckDownloadedFile method ends here ......");
				return file.length();
			}
		}
		log.info("CheckDownloadedFile method ends here ......");
		return 0;
	}

	// Checks that whether Receipt and Invoice file downloaded or not.
	
	public static boolean CheckReceiptAndInvoiceFile() {
		log.info("CheckReceiptAndInvoiceFile method starts here ......");
		boolean flag = false;
		boolean InvoiceFlag=false;
		boolean ReceiptFlag=false;
		// DownloadFolder=new File(UUID.randomUUID().toString());
		log.info("Temporary folder name is ---"+DownloadFolder);
		File ListOfFiles[] = DownloadFolder.listFiles();
		// make sure the directory is not empty
		
		log.info("number of files are --"+ListOfFiles.length);
		
			for (File file : ListOfFiles) {

				if(file.getName().contains("Receipt"))
				{	
					log.info("Receipt file found....");
					log.info("Size of the file - " + file.getName() + " is  " + file.length());
					if (file.length() == 0) {
						ReceiptFlag = false;
						log.info("Receipt file size is zero....");
					
					} else
					{
						log.info("Receipt file size is Non zero....");
						ReceiptFlag = true;
					}
						
				}
				else if(file.getName().contains("Invoice"))
				{
						log.info("Invoice file found....");
						log.info("Size of the file - " + file.getName() + " is  " + file.length());
						if (file.length() == 0) {
							InvoiceFlag = false;
							log.info("Invoice file size is zero....");
						
						} else
						{
							log.info("Invoice file size is Non zero....");
							InvoiceFlag = true;
						}
							
					}
				else
					log.info("Size of the file - " + file.getName() + " is  " + file.length());
				}
				if (ReceiptFlag ==true && InvoiceFlag==true) {
					flag=true;
					log.info("Both Receipt and Invoice file are exist ...");
				} else
				{
					log.info("Both Receipt and Invoice file doesn't exist ...");
					flag = false;
				}
		
			
		log.info("CheckReceiptAndInvoiceFile method ends here ......");
		return flag;
	}


	// Delete all downloaded files from temporaray folder.
	
		public static void DeleteAllFiles() {
			log.info("DeleteAllFiles method starts here ......");
			log.info("number of files are --"+DownloadFolder.listFiles().length);
			for(File file:DownloadFolder.listFiles())
			{
				log.info("Going to delete - " + file.getName() + " with size of  " + file.length());
				file.delete();
				log.info("File Name - " + file.getName() +" deleted successfully");
			}
			log.info("DeleteAllFiles method ends here ......");

		}


	// Checks that whether Agreement is displayed under Manage - > Agreement Menu

	public static boolean CheckAgreementDisplay() {
		log.info("CheckAgreementDisplay method starts here ......");
		boolean flag = false;
		String RowPath = "//table[@class='table table-striped arc-table']/tbody/tr";
		List<WebElement> AgreementTable = driver.findElements(By.xpath(RowPath));
		log.info("Size of the Agreement Table is ---"+AgreementTable.size());
		if (AgreementTable.size() > 0) {
			Iterator itr = AgreementTable.iterator();
			String OrderTypePath="";
			for (int i = 0; i < AgreementTable.size(); i++) {
				int rownum = i + 1;
				OrderTypePath = RowPath + "[" + rownum + "]/td[2]";
				String OrderType = driver.findElement(By.xpath(OrderTypePath)).getText();
				log.info(OrderTypePath + "......." + OrderType);
				if (OrderType.equals("Registration")) {
					log.info("Order Type Registration found and skipping rest of the rows..");
					flag = true;
					break;
				}
			}
		}
		if (flag)
			log.info("Order Type Registration found ...");
		else
			log.info("Order Type Registration not found ...");

		log.info("CheckAgreementDisplay method ends here ......");
		return flag;

	}

	// This function downloads the Agreement from under Manage - > Agreement Menu

	public static void ClikOnAgreementRegistrationDownloadLink() {
		// AgreementDownloadLink.click();
		log.info("ClikOnAgreementRegistrationDownloadLink method starts here ......");
		boolean flag = false;
		String RowPath = "//table[@class='table table-striped arc-table']/tbody/tr";
		List<WebElement> AgreementTable = driver.findElements(By.xpath(RowPath));
		log.info("Size of the Agreement Table is ---"+AgreementTable.size());
		if (AgreementTable.size() > 0) {
			Iterator itr = AgreementTable.iterator();
			String OrderTypePath;
			for (int i = 0; i < AgreementTable.size(); i++) {
				int rownum = i + 1;
				OrderTypePath = RowPath + "[" + rownum + "]/td[2]";
				String OrderType = driver.findElement(By.xpath(OrderTypePath)).getText();
				log.info(OrderTypePath + "......." + OrderType);
				if (OrderType.equals("Registration")) {
					log.info("Order Type Registration found and skipping the rest of rows..");
					flag = true;
					driver.findElement(By.xpath(RowPath + "[" + rownum + "]/td[3]")).click();
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}

			}
		}
		if (flag)
			log.info("Order Type Registration found ...");
		else
			log.info("Order Type Registration not found ...");

		log.info("ClikOnAgreementRegistrationDownloadLink method ends here ......");
	}

	// This method downloads the SUBSCRIPTION from Manage -- > Billing Menu
	public static boolean ClikOnBillingDownloadForSubScriptionLink() {
		log.info("ClikOnBillingDownloadForSubScriptionLink method starts here ......");
		int rownum = 0;
		boolean SubscriptionLinkExist = false;
		String mainwindow = driver.getWindowHandle();
		String RowPath = "//table[@class='table table-striped arc-table']/tbody/tr";
		List<WebElement> BillingTable = driver.findElements(By.xpath(RowPath));
		log.info("Size of the Billing Table is ---"+BillingTable.size());
		if (BillingTable.size() > 0) {
			Iterator itr = BillingTable.iterator();
			String OrderTypePath;

			for (int i = 0; i < BillingTable.size(); i++) {
				rownum = i + 1;
				OrderTypePath = RowPath + "[" + rownum + "]/td[3]";
				String OrderType = driver.findElement(By.xpath(OrderTypePath)).getText();
				log.info(OrderTypePath + "......." + OrderType);
				if (OrderType.equals("SUBSCRIPTION")) {
					SubscriptionLinkExist = true;
					log.info("Order Type SUBSCRIPTION found ...");
					break;
				}

			}
		}
		if (SubscriptionLinkExist) {
			driver.findElement(By.xpath(RowPath + "[" + rownum + "]/td[6]")).click();
			Set<String> AllWindow = driver.getWindowHandles();
			Iterator itr1 = AllWindow.iterator();
			while (itr1.hasNext()) {
				String childwindow = itr1.next().toString();
				if (!mainwindow.equals(childwindow)) {
					driver.switchTo().window(childwindow);

					// DownLoadInvoicelink.click();
					try {
						driver.findElement(By.xpath("//*[contains(text(),' Download invoice')]")).click();
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// DownLoadReceiptlink.click();
					try {
						driver.findElement(By.xpath("//*[contains(text(),' Download receipt')]")).click();
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					driver.close();
					driver.switchTo().window(mainwindow);
					break;
				}

			}

		} else
			log.info("Order Type SUBSCRIPTION not found ...");

		log.info("ClikOnBillingDownloadForSubScriptionLink method ends here ......");
		return SubscriptionLinkExist;

	}

	// This method downloads the REGISTRATION from Manage -- > Billing Menu

	public static void ClikOnBillingDownloadForRegistrationLink() {
		log.info("ClikOnBillingDownloadForRegistrationLink method starts here ......");
		// String mainwindow=driver.getWindowHandle();
		boolean flag = false;
		String RowPath = "//table[@class='table table-striped arc-table']/tbody/tr";
		List<WebElement> BillingTable = driver.findElements(By.xpath(RowPath));
		log.info("Size of the Billing Table is ---"+BillingTable.size());
		if (BillingTable.size() > 0) {
			Iterator itr = BillingTable.iterator();
			String OrderTypePath=null;
			for (int i = 0; i < BillingTable.size(); i++) {
				int rownum = i + 1;
				OrderTypePath = RowPath + "[" + rownum + "]/td[3]";
				String OrderType = driver.findElement(By.xpath(OrderTypePath)).getText();
				log.info(OrderTypePath + "......." + OrderType);
				if (OrderType.equals("REGISTRATION")) {
					log.info("Order Type REGISTRATION found and skipping rest of rows...");
					flag = true;
					driver.findElement(By.xpath(RowPath + "[" + rownum + "]/td[6]")).click();
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					}
					break;
				}

			}
		}
		if (flag)
			log.info("Order Type REGISTRATION found ...");
		else
			log.info("Order Type REGISTRATION not found ...");

		log.info("ClikOnBillingDownloadForRegistrationLink method ends here ......");

	}

	public static void ClikOnBillingDownloadForRecertificationLink() {
		log.info("ClikOnBillingDownloadForRecertificationLink method starts here ......");
		// String mainwindow=driver.getWindowHandle();
		boolean flag = false;
		String RowPath = "//table[@class='table table-striped arc-table']/tbody/tr";
		List<WebElement> BillingTable = driver.findElements(By.xpath(RowPath));
		log.info("Size of the Billing Table is ---"+BillingTable.size());
		if (BillingTable.size() > 0) {
			Iterator itr = BillingTable.iterator();
			String OrderTypePath;
			for (int i = 0; i < BillingTable.size(); i++) {
				int rownum = i + 1;
				OrderTypePath = RowPath + "[" + rownum + "]/td[3]";
				String OrderType = driver.findElement(By.xpath(OrderTypePath)).getText();
				log.info(OrderTypePath + "......." + OrderType);
				if (OrderType.equals("REVIEW\nLEED Certification")) {
					flag = true;
					log.info("Order Type REVIEW\\nLEED Certification found and skipping rest of rows...");
					driver.findElement(By.xpath(RowPath + "[" + rownum + "]/td[6]")).click();
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					}
					break;
				}

			}
		}
		if (flag)
			log.info("Order Type REVIEW found ...");
		else
			log.info("Order Type REVIEW not found ...");

		log.info("ClikOnBillingDownloadForRecertificationLink method ends here ......");

	}

	
	
	public static void setClipBoard(String file) {
		log.info("setClipBoard method starts here ......");
		StringSelection obj = new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(obj, null);
		log.info("setClipBoard method ends here ......");
	}

	public static void UploadFile(String FilePath) {
		log.info("UploadFile method starts here ......");
		Robot robot = null;
		setClipBoard(FilePath);
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		log.info("UploadFile method ends here ......");
	}
	
	
	
	public static void PerformTabout() {
		log.info("PerformTabout method starts here ......");
		Robot robot = null;
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		log.info("PerformTabout method ends here ......");
	}
	
	

	public static void deleteAllDownloadedFiles() {
		log.info("deleteALlDownloadedFiles method starts here ......");
		String filepath = System.getProperty("user.dir") + "\\DownLoadedFiles";
		File file = new File(filepath);

		if (file.listFiles().length > 0) {
			for (File f : file.listFiles()) {
				if (f.isDirectory()) {
					for (File f1 : f.listFiles()) {
						f1.delete();
					}
					f.delete();
				}
				f.delete();
			}
		}
		log.info("deleteALlDownloadedFiles method ends here ......");
	}

	public static void deleteAllPreviousScreenshotsFiles() {
		log.info("deleteAllPreviousScreenshotsFiles method starts here ......");
		String filepath = System.getProperty("user.dir") + "\\Screenshots";
		File file = new File(filepath);
		if (file.listFiles().length > 0) {
			for (File f : file.listFiles()) {
				if (f.isDirectory()) {
					for (File f1 : f.listFiles()) {
						f1.delete();
					}
					f.delete();
				}
				f.delete();
			}
		}
		log.info("deleteAllPreviousScreenshotsFiles method ends here ......");
	}
	
	
	public static String generateRandomString(int n)
	{
		String AlphabeticalString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder(n);
		  
        for (int i = 0; i < n; i++) {  
           
            int index
                = (int)(AlphabeticalString.length()
                        * Math.random());
  
            sb.append(AlphabeticalString
                          .charAt(index));
        }
  
        return sb.toString();
    }
	
	
	// This method will switch to defautl content from any frame
	
	public static void switchToDefaultContent()
	{
		log.info("switchToDefaultContent method starts here......");
		driver.switchTo().defaultContent();
		log.info("switchToDefaultContent method ends here......");
    }
	
	
	

	// This method will switch to Data Input Frame
	
	public static void switchToDataInputFrame()
	{
		log.info("switchToDataInputFrame method starts here......");
		driver.switchTo().frame("datainput-widget");
		log.info("switchToDataInputFrame method ends here......");
    }
	
	
	// This method will refresh the page and wait till page loaded successfully
	
	public static void  RefreshPagewaitForPageLoaded(WebDriver driver)
	{
		 log.info("RefreshPagewaitForPageLoaded method starts here......");
		driver.get(driver.getCurrentUrl());;
	    ExpectedCondition<Boolean> expectation = new
	ExpectedCondition<Boolean>() 
	    {
	        public Boolean apply(WebDriver driver)
	        {
	            return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	        }
	    };
	    Wait<WebDriver> wait = new WebDriverWait(driver,30);
	    try
	    {
	        wait.until(expectation);
	    }
	    catch(Throwable error)
	    {
	        log.info("Timeout waiting for Page Load Request to complete.");
	    }
	    log.info("Page Rerreshed and waited till page load completed successfully......");
	}
	
  // This method will add one team member 
	
	public static boolean Team_Add_Member(String EmailAddress) {
		log.info("Team_Add_Member Method starts here.............................................");
		CommonMethod.RefreshPagewaitForPageLoaded(driver);
		boolean flag = false;

		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//input[@name='input']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.findElement(By.xpath("//input[@name='input']")).clear();

		
		
		driver.findElement(By.xpath("//input[@name='input']")).sendKeys(EmailAddress);

		waithelper.WaitForElementClickable(driver.findElement(By.xpath("(//button[@id='invite_team'])[1]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		driver.findElement(By.xpath("(//button[@id='invite_team'])[1]")).click();
		try {
			Thread.sleep(2000);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.waitForElement(driver.findElement(By.xpath("//*[@class='messenger-message-inner']")),
				Integer.parseInt(prop.getProperty("explicitTime")));
		String msgText = driver.findElement(By.xpath("//*[@class='messenger-message-inner']")).getText();
		
		waithelper.WaitForElementInvisible(driver.findElement(By.xpath("//*[@class='messenger-message-inner']")),
				Integer.parseInt(prop.getProperty("explicitTime")),2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated
		}

		if (msgText.equals("Team member added successfully.")) {
			flag=true;
			log.info(msgText + "  .........  displaying");
			
		} else {
			flag=false;
			log.info(msgText + " .........  displaying");
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Team_Add_Member Method ends here.............................................");
		return flag;

	}

	// This method will check whether email exists or not as team member
	public static boolean Team_checkEmailExistOrNot(String EmailAddress) {
		log.info("Team_checkEmailExistOrNot Method starts here.............................................");
		boolean flag = false;
		String email=null;
		String Rowxpath = "//table[@class='table table-striped arc-table mb40 ng-scope']/tbody/tr";
		//String Rowxpath ="//*[@id='content']/descendant::table[1]/tbody/tr";
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<WebElement> TeamMemberRow = driver.findElements(By.xpath(Rowxpath));
		log.info("Size of the Table is ----- "+TeamMemberRow.size());
		for (int i = 0; i < TeamMemberRow.size(); i++) {
			int row = i + 1;
			String EmailXpath = Rowxpath + "[" + row + "]/td[2]";
			try {
				 email = driver.findElement(By.xpath(EmailXpath)).getText();
				 log.info("Current email address is --"+email );
			}
			catch(StaleElementReferenceException e)
			{
				log.info("StaleElementReferenceException exception showing for--"+EmailXpath);
				
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
				if (EmailAddress.equals(email)) {
				log.info(EmailAddress + "  found in this project.....");
				log.info("Team_checkEmailExistOrNot Method ends with true here.............................................");
				return true;
			}
		}

		log.info("Team_checkEmailExistOrNot Method ends with false here.............................................");
		return flag;

	}
	
	// This method will delete one team member

	public static boolean Team_Delete_Member(String EmailAddress) {
		log.info("Team_Delete_Member Method starts here.............................................");
		
		CommonMethod.RefreshPagewaitForPageLoaded(driver);
		
		String msgText = null;
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String Rowxpath = "//table[@class='table table-striped arc-table mb40 ng-scope']/tbody/tr";
		//String Rowxpath ="//*[@id='content']/descendant::table[1]/tbody/tr";
		List<WebElement> TeamMemberRow = driver.findElements(By.xpath(Rowxpath));
		log.info("Size of the Table is ----- "+TeamMemberRow.size());
		for (int i = 0; i < TeamMemberRow.size(); i++) {
			int row = i + 1;
			String EmailXpath = Rowxpath + "[" + row + "]/td[2]";
			try {
				Thread.sleep(3000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			String email = driver.findElement(By.xpath(EmailXpath)).getText();
			log.info("Current email xpath is --"+EmailXpath + "and email address is --" + email);
			if (EmailAddress.equals(email)) {
				String deletexpath = Rowxpath + "[" + row + "]/td[5]/div[1]";
				try {
					Thread.sleep(3000);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				waithelper.WaitForElementClickable(driver.findElement(By.xpath(deletexpath)),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
				log.info("Before clicking on delete button*********************************");
				driver.findElement(By.xpath(deletexpath)).click();
				log.info("After clicking on delete button*********************************");
				
				try {
					
					Thread.sleep(3000);
					log.info("-----Wait Method--------------------------------------------------------");
					
					waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//*[@class='messenger-message-inner']")),
							Integer.parseInt(prop.getProperty("explicitTime")), 2);
					
				
				} catch (StaleElementReferenceException e) {
					
					log.info("StaleElementReferenceException exception showing for--"+deletexpath);
					e.printStackTrace();

				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					msgText = driver.findElement(By.xpath("//*[@class='messenger-message-inner']")).getText();
					log.info("Displayed Message is -----" + msgText);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			}
		}
		try {
			waithelper.WaitForElementInvisible(driver.findElement(By.xpath("//*[@class='messenger-message-inner']")),
					Integer.parseInt(prop.getProperty("explicitTime")),2);
			
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (msgText.equals("Team member removed successfully.")) {
			log.info("Team_Delete_Member Method ends here.............................................");
			return true;

		}

		log.info("Team_Delete_Member Method ends here.............................................");
		return false;

	}

	
}
