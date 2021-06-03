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
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

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
		// ScreenshotPath = currentDir + "/Screenshots/" + MethodName + "_" +
		// System.currentTimeMillis();
		ScreenshotPath = currentDir + "/Screenshots/" + MethodName;
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

	public static long CheckDownloadedFile() {
		log.info("CheckDownloadedFile method starts here ......");
		// DownloadFolder=new File(UUID.randomUUID().toString());
		System.out.println(DownloadFolder);
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

	public static boolean CheckDownloadedForTwoFile() {
		log.info("CheckDownloadedForTwoFile method starts here ......");
		boolean flag = false;
		// DownloadFolder=new File(UUID.randomUUID().toString());
		System.out.println(DownloadFolder);
		File ListOfFiles[] = DownloadFolder.listFiles();
		// make sure the directory is not empty
		System.out.println(ListOfFiles.length);
		if (ListOfFiles.length == 2) {
			for (File file : ListOfFiles) {

				log.info("Size of the file - " + file.getName() + " is  " + file.length());

				if (file.length() == 0) {
					flag = false;
					break;
				} else
					flag = true;
			}
		}
		log.info("CheckDownloadedForTwoFile method ends here ......");
		return flag;
	}

	// Checks that whether Agreement is displayed under Manage - > Agreement Menu

	public static boolean CheckAgreementDisplay() {
		log.info("CheckAgreementDisplay method starts here ......");
		boolean flag = false;
		String RowPath = "//table[@class='table table-striped arc-table']/tbody/tr";
		List<WebElement> AgreementTable = driver.findElements(By.xpath(RowPath));
		if (AgreementTable.size() > 0) {
			Iterator itr = AgreementTable.iterator();
			String OrderTypePath;
			for (int i = 0; i < AgreementTable.size(); i++) {
				int rownum = i + 1;
				OrderTypePath = RowPath + "[" + rownum + "]/td[2]";
				String OrderType = driver.findElement(By.xpath(OrderTypePath)).getText();
				System.out.println(OrderTypePath + "......." + OrderType);
				if (OrderType.equals("Registration")) {
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
		if (AgreementTable.size() > 0) {
			Iterator itr = AgreementTable.iterator();
			String OrderTypePath;
			for (int i = 0; i < AgreementTable.size(); i++) {
				int rownum = i + 1;
				OrderTypePath = RowPath + "[" + rownum + "]/td[2]";
				String OrderType = driver.findElement(By.xpath(OrderTypePath)).getText();
				System.out.println(OrderTypePath + "......." + OrderType);
				if (OrderType.equals("Registration")) {
					flag = true;
					driver.findElement(By.xpath(RowPath + "[" + rownum + "]/td[3]")).click();
					try {
						Thread.sleep(8000);
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
		if (BillingTable.size() > 0) {
			Iterator itr = BillingTable.iterator();
			String OrderTypePath;

			for (int i = 0; i < BillingTable.size(); i++) {
				rownum = i + 1;
				OrderTypePath = RowPath + "[" + rownum + "]/td[3]";
				String OrderType = driver.findElement(By.xpath(OrderTypePath)).getText();
				System.out.println(OrderTypePath + "......." + OrderType);
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
						Thread.sleep(8000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// DownLoadReceiptlink.click();
					try {
						driver.findElement(By.xpath("//*[contains(text(),' Download receipt')]")).click();
						Thread.sleep(8000);
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
		if (BillingTable.size() > 0) {
			Iterator itr = BillingTable.iterator();
			String OrderTypePath;
			for (int i = 0; i < BillingTable.size(); i++) {
				int rownum = i + 1;
				OrderTypePath = RowPath + "[" + rownum + "]/td[3]";
				String OrderType = driver.findElement(By.xpath(OrderTypePath)).getText();
				System.out.println(OrderTypePath + "......." + OrderType);
				if (OrderType.equals("REGISTRATION")) {
					flag = true;
					driver.findElement(By.xpath(RowPath + "[" + rownum + "]/td[6]")).click();
					try {
						Thread.sleep(8000);
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
		if (BillingTable.size() > 0) {
			Iterator itr = BillingTable.iterator();
			String OrderTypePath;
			for (int i = 0; i < BillingTable.size(); i++) {
				int rownum = i + 1;
				OrderTypePath = RowPath + "[" + rownum + "]/td[3]";
				String OrderType = driver.findElement(By.xpath(OrderTypePath)).getText();
				System.out.println(OrderTypePath + "......." + OrderType);
				if (OrderType.equals("REVIEW\nLEED Certification")) {
					flag = true;
					driver.findElement(By.xpath(RowPath + "[" + rownum + "]/td[6]")).click();
					try {
						Thread.sleep(8000);
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
}
