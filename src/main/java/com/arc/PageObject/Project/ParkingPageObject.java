package com.arc.PageObject.Project;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class ParkingPageObject extends BaseClass {

	private static Logger log = LoggerHelper.getLogger(ParkingPageObject.class);

	@FindBy(xpath = "(//*[text()='Manage' and @class='ml10'])[1]")
	WebElement ManageMenu;

	@FindBy(xpath = "(//a[text()=' Agreements '])[1]")
	WebElement AgreementSubmenu;

	@FindBy(xpath = "(//a[text()=' Billing '])[1]")
	WebElement BillingSubmenu;

	@FindBy(xpath = "(//a[text()=' Team '])[1]")
	WebElement TeamSubmenu;

	@FindBy(xpath = "(//a[text()=' Project '])[1]")
	WebElement ProjectSubmenu;

	@FindBy(xpath = "(//input[@type='radio'])[1]")
	WebElement PrivateYesRadioButton;

	@FindBy(name = "test_project")
	WebElement ThisIsTestProjectCheckBox;

	@FindBy(xpath = "//a[normalize-space()='FAQs']")
	WebElement FAQLink;

	@FindBy(xpath = "//a[normalize-space()='Contact us']")
	WebElement ContactUsLink;

	@FindBy(xpath = "//a[normalize-space()='Parksmart Resources']")
	WebElement ParkSmartResourceLink;

	@FindBy(xpath = "//div[@class='ng-scope']//a[@class='pl50'][normalize-space()='All Measures']")
	WebElement AllMeasuresSubMenu;

	@FindBy(xpath = "//div[@class='ng-scope']//a[@class='pl50'][normalize-space()='Management']")
	WebElement ManagementSubmMenu;

	@FindBy(xpath = "//div[@class='ng-scope']//a[@class='pl50'][normalize-space()='Programs']")
	WebElement ProgramSubMenu;

	@FindBy(xpath = "//div[@class='ng-scope']//a[@class='pl50'][normalize-space()='Technology & Structure Design']")
	WebElement TechAndDesignSubMenu;

	@FindBy(xpath = "//div[@class='ng-scope']//a[@class='pl50'][normalize-space()='Innovation']")
	WebElement InnovationSubMenu;

	@FindBy(xpath = "//button[normalize-space()='Measure Language (PDF)']")
	WebElement MeasureLanguagePDF;

	@FindBy(xpath = "//*[@class='viewUpload laptop']")
	WebElement FileUploadButtonUsingComputer;

	@FindBy(xpath = "//*[@id=\"DataTables_Table_1_paginate\"]/ul/button[2]")
	WebElement NextButton;

	@FindBy(xpath = "//*[@id=\"actions-form\"]/div[2]/section[1]/header/div/a/i")
	WebElement HelpButton;

	@FindBy(xpath = "//div[@class='ng-scope']//span[@class='ml10'][normalize-space()='Measures']")
	WebElement MeasureMenu;

	@FindBy(xpath = "(//*[text()='File successfully uploaded.'])[1]")
	WebElement FileUploadMsg;

	@FindBy(xpath = "//span[@class='fa fa-trash-o cursor-pointer align_file_name']")
	WebElement FileDeletebutton;

	@FindBy(xpath = "//*[@id=\"actions-form\"]/div[3]/section/div/div[1]/p/a")
	WebElement FileUploaded;

	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[1]/section/div/table/tbody/tr[1]/td[4]/div/button[1]")
	WebElement EditButton;

	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[1]/section/div/table/tbody/tr[1]/td[4]/div/button[2]")
	WebElement SaveButton;

	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[1]/section/div/table/tbody/tr[1]/td[3]/select")
	WebElement AccessDropdown;

	@FindBy(xpath = "/html/body/ul/li[1]/div/div")
	WebElement ArcAdminErrorMsg;

	@FindBy(xpath = "//*[@id=\"details-form\"]/div/span[3]/p[2]")
	WebElement IdAlreadyExistsMsg;

	@FindBy(xpath = "//a[normalize-space()='Parksmart criteria']")
	WebElement A4_HyperLink;

	@FindBy(xpath = "//span[contains(text(),'Operator employs a minimum of 4')]//a[@class='fw-bold'][normalize-space()='Parksmart traffic flow strategies']")
	WebElement B5_Hyperlink;

	@FindBy(xpath = "//a[normalize-space()='Parksmart criteria']")
	WebElement C4_Hyperlink;

	@FindBy(xpath = "//h1[@class='page-title pull-left']")
	WebElement AllMeasureHead;

	@FindBy(xpath = "//span[@class='cursor-pointer']//*[name()='svg']")
	WebElement TeamToolTip;

	public ParkingPageObject() {
		PageFactory.initElements(driver, this);
	}

	public void AllMeasuresSubMenu() {
		MeasureMenu.click();
		AllMeasuresSubMenu.click();
	}

	public void ClickonAgreementInManage() {
		ManageMenu.click();
		AgreementSubmenu.click();

	}

	public void ClickonAccessDropdown() {
		AccessDropdown.click();

	}

	public void ClickonBillingInManage() {
		ManageMenu.click();
		BillingSubmenu.click();

	}

	public void ClickonAllMeasuresInMeasures() {
		MeasureMenu.click();
		AllMeasuresSubMenu.click();
	}

	public void ClickonManagementSubmenu() {
		MeasureMenu.click();
		ManagementSubmMenu.click();
	}

	public void ClickonProgramSubmenu() {
		MeasureMenu.click();
		ProgramSubMenu.click();
	}

	public void ClickonTechAndDesignSubmenu() {
		MeasureMenu.click();
		TechAndDesignSubMenu.click();
	}

	public void ClickonInnovationSubMenu() {
		MeasureMenu.click();
		InnovationSubMenu.click();
	}

	public void ClickOnMeasuresMenu() {
		MeasureMenu.click();
	}

	public void ClickOnToolTip() {
		HelpButton.click();
	}

	public void ClickOnTeamToolTip() {
		try {

			waithelper.WaitForElementClickable(TeamToolTip, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			TeamToolTip.click();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ClickOnMeasureLanguagePdf() {
		MeasureLanguagePDF.click();
	}

	public boolean ClickonA4HyperLink() {
		String pdfcontent = null;
		waithelper.WaitForElementClickable(A4_HyperLink, Integer.parseInt(prop.getProperty("explicitTime")), 2);

		A4_HyperLink.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		Set<String> handles = driver.getWindowHandles();
		for (String window : handles) {
			if (!BaseWindow.equals(window)) {
				driver.switchTo().window(window);
				String url = "https://" + (System.getProperty("environment")).toLowerCase()
						+ ".app.arconline.io/assets/json-v2/parksmart/measure_pdf/A4.pdf";
				log.info("Agreement URL is " + url);
				pdfcontent = CommonMethod.getPDFContent(url);
				if (pdfcontent.contains("SECTION")) {
					driver.close();
					driver.switchTo().window(BaseWindow);
					log.info("ClickonA4HyperLink  method ends with true here -----");
					return true;
				} else
					log.info("ClickonA4HyperLink  method ends with false here -----");
				return false;

			}
		}

		log.info("ClickonA4HyperLink  method ends with false here -----");
		return false;
	}

	public boolean ClickonB5HyperLink() {
		String pdfcontent = null;
		waithelper.WaitForElementClickable(B5_Hyperlink, Integer.parseInt(prop.getProperty("explicitTime")), 2);

		B5_Hyperlink.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		Set<String> handles = driver.getWindowHandles();
		for (String window : handles) {
			if (!BaseWindow.equals(window)) {
				driver.switchTo().window(window);
				String url = "https://" + (System.getProperty("environment")).toLowerCase()
						+ ".app.arconline.io/assets/json-v2/parksmart/measure_pdf/B5.pdf";
				log.info("Agreement URL is " + url);
				pdfcontent = CommonMethod.getPDFContent(url);
				if (pdfcontent.contains("MEASURE 5 Traffic Flow Plan")) {
					driver.close();
					driver.switchTo().window(BaseWindow);
					log.info("ClickonB5HyperLink  method ends with true here -----");
					return true;
				} else
					log.info("ClickonB5HyperLink  method ends with false here -----");
				return false;

			}
		}

		log.info("ClickonB5HyperLink  method ends with false here -----");
		return false;
	}

	public boolean ClickonC4HyperLink() {
		String pdfcontent = null;
		waithelper.WaitForElementClickable(C4_Hyperlink, Integer.parseInt(prop.getProperty("explicitTime")), 2);

		C4_Hyperlink.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		Set<String> handles = driver.getWindowHandles();
		for (String window : handles) {
			if (!BaseWindow.equals(window)) {
				driver.switchTo().window(window);
				String url = "https://" + (System.getProperty("environment")).toLowerCase()
						+ ".app.arconline.io/assets/json-v2/parksmart/measure_pdf/C4.pdf";
				log.info("Agreement URL is " + url);
				pdfcontent = CommonMethod.getPDFContent(url);
				if (pdfcontent.contains("SECTION C Technology & Structure Design")) {
					driver.close();
					driver.switchTo().window(BaseWindow);
					log.info("ClickonC4HyperLink  method ends with true here -----");
					return true;
				} else
					log.info("ClickonC4HyperLink  method ends with false here -----");
				return false;

			}
		}

		log.info("ClickonC4HyperLink  method ends with false here -----");
		return false;
	}

	public boolean ClickonFAQ() {
		String handle = driver.getWindowHandle();
		FAQLink.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		Set<String> handles = driver.getWindowHandles();
		if (handles.size() == 2) {
			for (String window : handles) {
				if (!handle.equals(window)) {
					driver.switchTo().window(window);
					String url = driver.getCurrentUrl();
					System.out.println("Second URL is ---------------" + url);
					if (url.contains("https://parksmart.gbci.org/faq")) {
						driver.close();
						driver.switchTo().window(handle);
						return true;
					} else
						return false;

				}
			}

		}
		return false;

	}

	public boolean ClickonContactUs() {
		String handle = driver.getWindowHandle();
		ContactUsLink.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		Set<String> handles = driver.getWindowHandles();
		if (handles.size() == 2) {
			for (String window : handles) {
				if (!handle.equals(window)) {
					driver.switchTo().window(window);
					String url = driver.getCurrentUrl();
					System.out.println("Second URL is ---------------" + url);
					if (url.contains("https://parksmart.gbci.org/faq")) {
						driver.close();
						driver.switchTo().window(handle);
						return true;
					} else
						return false;

				}
			}

		}
		return false;

	}

	public boolean ClickonParkSmartResources() {
		String handle = driver.getWindowHandle();
		ParkSmartResourceLink.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		Set<String> handles = driver.getWindowHandles();
		if (handles.size() == 2) {
			for (String window : handles) {
				if (!handle.equals(window)) {
					driver.switchTo().window(window);
					String url = driver.getCurrentUrl();
					System.out.println("Second URL is ---------------" + url);
					if (url.contains("https://parksmart.gbci.org/resources")) {
						driver.close();
						driver.switchTo().window(handle);
						return true;
					} else
						return false;

				}
			}

		}
		return false;

	}

	public void ClickOnEditInTeam() {
		EditButton.click();
	}

	public void ClickOnSaveInTeam() {
		SaveButton.click();
	}

	public void ClickonTeamInManage() {
		try {
			ManageMenu.click();
			TeamSubmenu.click();
			waithelper.waitForElement(driver.findElement(By.xpath("//span[text()='Team']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to traverse Team Submenu");
		}

	}

	public boolean CheckThisIsTestProjectCheckBox(String ProjectID) {
		try {
			String path = "(//*[text()='" + ProjectID + "'])[2]";
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath(path)),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			return ThisIsTestProjectCheckBox.isSelected();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkParkingProjectCreation(String PName) {

		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(
							By.xpath("//*[@class='page-controls navbar_info navbar-default']/div/div/div/h4")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			if (driver.findElement(By.xpath("//*[@class='page-controls navbar_info navbar-default']/div/div/div/h4"))
					.getText().contains(PName)) {
				System.out.println("Project Name showing---------" + driver
						.findElement(By.xpath("//*[@class='page-controls navbar_info navbar-default']/div/div/div/h4"))
						.getText());
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;

	}

	public void ClickonProjectInManage() {
		try {

			ManageMenu.click();
			ProjectSubmenu.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//span[@class='fw-semi-bold' and text()='Project']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getProjectID(String PName) {

		try {
			return driver
					.findElement(
							By.xpath("//*[@class='page-controls navbar_info navbar-default']/div/div/div//div[1]/span"))
					.getText();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public boolean CheckProjectIsPrivateFlagUnderManage(String ProjectID) {
		try {
			String path = "(//*[text()='" + ProjectID + "'])[2]";
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath(path)),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			System.out
					.println("PrivateYesRadioButton.isSelected() value is ---- " + PrivateYesRadioButton.isSelected());
			return PrivateYesRadioButton.isSelected();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public String CheckAllMeasureHeaderShowing() {
		try {

			waithelper.WaitForElementVisibleWithPollingTime(AllMeasureHead,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			System.out.println("AllMeasureHeadText.getText() value is ---- " + AllMeasureHead.isDisplayed());
			return AllMeasureHead.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean ClickonActionName(String Action) {
		boolean flag = false;
		List<WebElement> ActionNames = driver
				.findElements(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr/td[3]/a/span"));
		// ArrayList<String> AllNames=new ArrayList<String>();
		for (int i = 0; i < ActionNames.size(); i++) {
			int row = i + 1;
			if (ActionNames.get(i).getText().equals(Action)) {
				driver.findElement(By
						.xpath("//table[@class='table table-striped table-hover']/tbody/tr[" + row + "]/td[3]/a/span"))
						.click();
				flag = true;
				break;
			}
		}

		return flag;

	}

	public void ClickonFileUpLoadUsingComputerButton() {

		try {

			waithelper.WaitForElementClickable(FileUploadButtonUsingComputer,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			JSHelper.clickElement(FileUploadButtonUsingComputer);
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean FileuploadStatus() {
		waithelper.WaitForElementVisibleWithPollingTime(FileUploadMsg,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			boolean flag = FileUploadMsg.isDisplayed();
			return flag;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	public boolean CheckFileUploadUsingComputer(String filePath) {

		try {
			log.info("File uploading using computer path is --" + filePath);
			WebElement ele2 = driver.findElement(By.xpath("//div[@class='viewUpload laptop']"));
			JSHelper.clickElement(ele2);
			WebElement ele = driver.findElement(By.xpath("//input[@class='hide uploadFile']"));
			JSHelper.displayHiddenElement(ele);
			Thread.sleep(3000);
			ele.sendKeys(filePath);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			boolean flag = FileUploadMsg.isDisplayed();
			Thread.sleep(3000);
			return flag;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	public boolean ClickonFileDeleButton(String fname) {
		log.info("ClickonFileDeleButton method starts here ...");
		boolean flag = false;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement ele = driver.findElement(By.xpath("//*[text()='" + fname + "']"));
		if (ele.isDisplayed()) {
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			FileDeletebutton.click();

			try {
				waithelper.WaitForElementInvisible(ele, 30, 2);
				flag = ele.isDisplayed();
				log.info(flag + "This is ele.isDisplayed() value;");

			} catch (StaleElementReferenceException e) {
				flag = false;
				log.info("=====================StaleElementReferenceException=====================");
				e.printStackTrace();

			} catch (NoSuchElementException e) {
				log.info("=====================NoSuchElementException=====================");
				flag = false;
			}
			log.info("ClickonFileDeleButton method ends here ...");
			if (flag == true) {
				return false;
			} else
				return true;
		}
		return false;

	}


	public void SelectTeamMember() {
		AccessDropdown.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(
						By.xpath("//*[@id=\"content\"]/div/div/div[1]/section/div/table/tbody/tr[1]/td[3]/select")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(
				By.xpath("//*[@id=\"content\"]/div/div/div[1]/section/div/table/tbody/tr[1]/td[3]/select/option[2]"))
				.click();

	}

	public void SelectArcAdmin() {
		AccessDropdown.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(
						By.xpath("//*[@id=\"content\"]/div/div/div[1]/section/div/table/tbody/tr[1]/td[3]/select")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(
				By.xpath("//*[@id=\"content\"]/div/div/div[1]/section/div/table/tbody/tr[1]/td[3]/select/option[1]"))
				.click();

	}

	public boolean Check_Arc_Admin_Error_Msg() {

		waithelper.WaitForElementVisibleWithPollingTime(ArcAdminErrorMsg,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			boolean flag = ArcAdminErrorMsg.isDisplayed();
			return flag;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;

	}

	public void Add_Team_Member(String EmailAddress) {
		log.info("Add_Team_Member Method starts here.............................................");

		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//input[@name='input']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// driver.findElement(By.xpath("//input[@name='input']")).clear();

		driver.findElement(By.xpath("//input[@name='input']")).sendKeys(EmailAddress);

		waithelper.WaitForElementClickable(driver.findElement(By.xpath("(//button[@id='invite_team'])[1]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		driver.findElement(By.xpath("(//button[@id='invite_team'])[1]")).click();

	}

	public boolean Check_ID_Already_Exist_Msg() {

		waithelper.WaitForElementVisibleWithPollingTime(IdAlreadyExistsMsg,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		try {
			boolean flag = IdAlreadyExistsMsg.isDisplayed();
			return flag;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;

	}

	public boolean CheckAddNewTeamMember() {
		log.info("CheckAddNewTeamMember  starts here........");
		boolean MemberAddedflag = false;
		boolean flag = false;
		ngWebDriver.waitForAngularRequestsToFinish();
		String username = data.getCellData("Parking", 0, 2);
		MemberAddedflag = CommonMethod.Team_Add_Member(username);
		if (MemberAddedflag) {
			flag = CommonMethod.CheckRoleOfEmail(username, "Team Member");
		} else {
			log.info("Member not added..");
		}
		if (flag) {
			log.info("CheckAddNewTeamMember  ends here with true........");
			return true;
		} else {
			log.info("CheckAddNewTeamMember  ends here with false........");
			return false;
		}

	}

	public boolean Team_CheckDefaultArcAdmin() {
		log.info("CheckDefaultArcAdmin method starts here .....");
		boolean flag = false;
		String RowPath = "//table[@class='table table-striped arc-table mb40 ng-scope']/tbody/tr[1]";
		List<WebElement> TeamTable = driver.findElements(By.xpath(RowPath));
		if (TeamTable.size() > 0) {
			Iterator itr = TeamTable.iterator();
			String ArcAdminPath;
			for (int i = 0; i < TeamTable.size(); i++) {
				int rownum = i + 3;
				ArcAdminPath = RowPath + "/td[" + (rownum) + "]";
				String ArcAdmin = driver.findElement(By.xpath(ArcAdminPath)).getText();
				// System.out.println(ArcAdminPath + "......." + ArcAdmin);
				if (ArcAdmin.equals("Arc Administrator")) {
					flag = true;
					break;
				}
			}
		}
		if (flag)
			log.info("Arc Administrator found ...");
		else
			log.info("Arc Administrator not found ...");

		return flag;

	}

	public boolean Team_CheckDefaultProjectAdmin() {
		log.info("CheckDefaultProjectAdmin method starts here .....");
		boolean flag = false;
		String RowPath = "//table[@class='table table-striped arc-table mb40 ng-scope']/tbody/tr[2]";
		List<WebElement> TeamTable = driver.findElements(By.xpath(RowPath));
		if (TeamTable.size() > 0) {
			Iterator itr = TeamTable.iterator();
			String ProjectAdminPath;
			for (int i = 0; i < TeamTable.size(); i++) {
				int rownum = i + 3;
				ProjectAdminPath = RowPath + "/td[" + (rownum) + "]";
				String ProjectAdmin = driver.findElement(By.xpath(ProjectAdminPath)).getText();
				if (ProjectAdmin.equals("Project Admin")) {
					flag = true;
					break;
				}
			}
		}
		if (flag)
			log.info("Project Admin found ...");
		else
			log.info("Project Admin not found ...");

		return flag;
	}

	public boolean Team_CheckEditButton() {
		log.info("CheckEditButton method starts here");
		boolean flag = false;
		String RowPath = "//table[@class='table table-striped arc-table mb40 ng-scope']/tbody/tr[2]";
		List<WebElement> TeamTable = driver.findElements(By.xpath(RowPath));
		if (TeamTable.size() > 0) {
			Iterator itr = TeamTable.iterator();
			String UserTypePath;
			for (int i = 0; i < TeamTable.size(); i++) {
				int RowNum = i + 3;
				UserTypePath = RowPath + "/td[" + RowNum + "]";
				String UserType = driver.findElement(By.xpath(UserTypePath)).getText();
				System.out.println(UserTypePath + "..........." + UserType);
				if (UserType.equals("Project Admin")) {
					WebElement EditButton = driver.findElement(
							By.xpath("//*[@id=\"content\"]/div/div/div[1]/section/div/table/tbody/tr[2]/td[4]"));
					if (EditButton.equals("Edit")) {

						EditButton.click();
						flag = true;

						log.info("Edit Button Found Project Admin can be Edited");
					} else
						log.info("Edit Button Not Found Hence Admin cannot be Edited");
				}
			}
		}

		return false;
	}

	public boolean Check_Multiple_Arc_Admin() {
		log.info("Check_Multiple_Arc_Admin method starts here...........");
		boolean flag = false;

		List<WebElement> table = driver
				.findElements(By.xpath("//*[@id=\"content\"]/div/div/div[1]/section/div/table/tbody/tr/td[3]"));
		List<String> Role = new ArrayList<>();
		for (int i = 0; i < table.size(); i++) {
			Role.add(i, table.get(i).getText());
		}
		log.info("Roles we have .........."+ Role);
		
		Set<String> set = new HashSet<>(Role);

		if (set.size() != Role.size()) {
			flag = true;

			if (flag) {
				log.info("Have multiple Arc Admin.............");
			} else
				log.info("Not have multiple ArcAdmin.............");
		}
		log.info("Check_Multiple_Arc_Admin method ends here..........");
		return flag;

	}

	public boolean CheckStatusButtons() {
		log.info("CheckStatusButtons method starts here...........");
		boolean flag = false;

		WebElement table = driver.findElement(By.xpath("//*[@id=\"content\"]/section/div[1]/div/table/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int Credits = rows.size();
		log.info("No. of credits are...... " + rows.size());
		List<WebElement> StatusButtons = driver
				.findElements(By.xpath("//*[@id=\"content\"]/section/div[1]/div/table/tbody/tr/td[1]/span"));
		int Sbuttons = StatusButtons.size();
		log.info("No of Status Buttons are : " + StatusButtons.size());
		if (Credits == Sbuttons) {
			flag = true;
		}

		if (flag) {
			log.info("All Credits have Status Buttons.......");
		} else {
			log.info("All Credits not have Status Buttons.......");
		}

		log.info("CheckStatusButtons method ends here...........");
		return flag;
	}

	public boolean CheckTeamManagerRole() {

		boolean flag = true;

		WebElement element = driver.findElement(
				By.xpath("//*[@id=\"content\"]/div/div/div[1]/section/div/table/tbody/tr[1]/td[3]/select"));
		Select select = new Select(element);
		List<WebElement> allOptions = select.getAllSelectedOptions();
		for (int i = 0; i < allOptions.size(); i++) {
			if (allOptions.equals("Team Manager")) {
				flag = false;
				break;

			}
			if (flag) {
				log.info("Team Manager Role doesn't exists 'passed' ");
			} else
				log.info("Team Manager Role exists 'failed' ");
		}
		return flag;
	}

	public boolean CheckMeasuresSubMenu() {

		log.info("CheckMeasuresSubmenu method starts here...........");

		String className = null;
		boolean flag = false;
		List<WebElement> allElement = driver
				.findElements(By.xpath("//div[@class='ng-scope']//a[@class='pl50'][normalize-space()]"));
		for (WebElement element : allElement) {
			className = element.getText();
			System.out.println(className);
		}

		if (className.equals("All Measures\r\n" + "Management\r\n" + "Programs\r\n"
				+ "Technology & Structure Design\r\n" + "Innovation")) {

			flag = true;

		}
		if (flag)
			log.info("CheckMeasuresSubMenu method ends here..........");
		else
			log.info("CheckMeasuresSubMenu method ends here..........");

		return flag;
	}

	public boolean CheckAllCredits() {

		log.info("CheckAllCredits method starts here............");

		HashMap<String, Integer> Credits = new HashMap<String, Integer>();
		Credits.put("A1 - Parking Pricing", 0);
		Credits.put("A2 - Shared Parking", 1);
		Credits.put("A3 - Transportation Management Association (TMA) / Organization (TMO) Affiliation", 2);
		Credits.put("A4 - Recycling Program", 3);
		Credits.put("A5 - Sustainable Purchasing Program", 4);
		Credits.put("A6 - Proactive Operational Maintenance", 5);
		Credits.put("A7 - Cleaning Procedures - Occupied Spaces", 6);
		Credits.put("A8 - Cleaning Procedures - Parking Decks", 7);
		Credits.put("A9 - Building Systems Commissioning", 8);
		Credits.put("A10 - Construction Waste Management", 9);
		Credits.put("A11 - Regional Materials for New Construction, Rehabilitation, or Retrofit", 10);
		Credits.put("A12 - Regional Labor for New Construction, Rehabilitation, or Retrofit", 11);
		Credits.put("A13 - Reused, Repurposed or Recycled Materials", 12);
		Credits.put("A14 - Third Party Sustainability Certification", 13);
		Credits.put("A15 - Credentialed Management", 14);
		Credits.put("A16 - Life-cycle Assessment", 15);
		Credits.put("B1 - Placemaking", 16);
		Credits.put("B2 - Access to Mass Transit", 17);
		Credits.put("B3 - Wayfinding Systems - External", 18);
		Credits.put("B4 - Wayfinding Systems - Internal", 19);
		Credits.put("B5 - Traffic Flow Plan", 20);
		Credits.put("B6 - Carshare Program", 21);
		Credits.put("B7 - Rideshare Program", 22);
		Credits.put("B8 - Low-emitting and Fuel-efficient Vehicle Program", 23);
		Credits.put("B9 - Alternative Fuel Vehicles", 24);
		Credits.put("B10 - Alternative Fuel Fleet Vehicles", 25);
		Credits.put("B11 - Bicycle Parking", 26);
		Credits.put("B12 - Bicycle Sharing/Rental", 27);
		Credits.put("B13 - Marketing/Educational Program", 28);
		Credits.put("C1 - Idle Reduction Payment Systems", 29);
		Credits.put("C2 - Fire Suppression Systems", 30);
		Credits.put("C3 - No/Low-VOC Coatings, Paints and Sealants", 31);
		Credits.put("C4 - Tire Inflation Stations", 32);
		Credits.put("C5 - Electric Vehicle (EV) Charging Stations", 33);
		Credits.put("C6 - HVAC Systems - Occupied Spaces", 34);
		Credits.put("C7 - Ventilation Systems - Parking Decks", 35);
		Credits.put("C8 - Lighting Controls", 36);
		Credits.put("C9 - Energy-efficient Lighting System", 37);
		Credits.put("C10 - Stormwater Management", 38);
		Credits.put("C11 - Rainwater Harvesting", 39);
		Credits.put("C12 - Greywater Reuse", 40);
		Credits.put("C13 - Indoor Water-efficiency", 41);
		Credits.put("C14 - Water-efficient Landscaping", 42);
		Credits.put("C15 - Roofing Systems", 43);
		Credits.put("C16 - Renewable Energy Generation", 44);
		Credits.put("C17 - Design for Durability", 45);
		Credits.put("C18 - Energy Resiliency - Storage", 46);
		Credits.put("D1 - Innovative Approach", 48);
		// System.out.println(Credits);

		boolean flag = false;

		WebElement table = driver.findElement(By.xpath("//*[@id=\"content\"]/section/div[1]/div/table/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		HashMap<String, Integer> WebValue = new HashMap<String, Integer>();

		System.out.println(rows.size());

		for (int i = 0; i < rows.size(); i++) {
			System.out.println(rows.get(i).getText());
			WebValue.put(rows.get(i).getText(), i);
		}
		// System.out.println(WebValue);

		Set<String> keyList = Credits.keySet();
		for (String key : keyList) {
			// System.out.println(key);
			if (Credits.get(key).equals(WebValue.get(key))) {
				flag = true;
				log.info("Credits Found......");
			} else
				log.info("Credits didn't Found........");
		}
		return flag;
	}

	public boolean CheckManagementCredits() {

		log.info("CheckManagementCredits method starts here............");

		HashMap<String, Integer> Credits = new HashMap<String, Integer>();
		Credits.put("A1 - Parking Pricing", 0);
		Credits.put("A2 - Shared Parking", 1);
		Credits.put("A3 - Transportation Management Association (TMA) / Organization (TMO) Affiliation", 2);
		Credits.put("A4 - Recycling Program", 3);
		Credits.put("A5 - Sustainable Purchasing Program", 4);
		Credits.put("A6 - Proactive Operational Maintenance", 5);
		Credits.put("A7 - Cleaning Procedures - Occupied Spaces", 6);
		Credits.put("A8 - Cleaning Procedures - Parking Decks", 7);
		Credits.put("A9 - Building Systems Commissioning", 8);
		Credits.put("A10 - Construction Waste Management", 9);
		Credits.put("A11 - Regional Materials for New Construction, Rehabilitation, or Retrofit", 10);
		Credits.put("A12 - Regional Labor for New Construction, Rehabilitation, or Retrofit", 11);
		Credits.put("A13 - Reused, Repurposed or Recycled Materials", 12);
		Credits.put("A14 - Third Party Sustainability Certification", 13);
		Credits.put("A15 - Credentialed Management", 14);
		Credits.put("A16 - Life-cycle Assessment", 15);

		// System.out.println(Credits);

		boolean flag = false;

		WebElement table = driver.findElement(By.xpath("//*[@id=\"content\"]/section/div[1]/div/table/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		HashMap<String, Integer> WebValue = new HashMap<String, Integer>();

		System.out.println(rows.size());

		for (int i = 0; i < rows.size(); i++) {
			// System.out.println(rows.get(i).getText());
			WebValue.put(rows.get(i).getText(), i);
		}
		// System.out.println(WebValue);

		Set<String> keyList = Credits.keySet();
		for (String key : keyList) {
			// System.out.println(key);
			if (Credits.get(key).equals(WebValue.get(key))) {
				flag = true;
				log.info("Credits Found......");
			} else
				log.info("Credits didn't Found........");
		}
		return flag;
	}

	public boolean CheckProgramsCredits() {

		log.info("CheckProgramsCredits method starts here............");

		HashMap<String, Integer> Credits = new HashMap<String, Integer>();
		Credits.put("B1 - Placemaking", 0);
		Credits.put("B2 - Access to Mass Transit", 1);
		Credits.put("B3 - Wayfinding Systems - External", 2);
		Credits.put("B4 - Wayfinding Systems - Internal", 3);
		Credits.put("B5 - Traffic Flow Plan", 4);
		Credits.put("B6 - Carshare Program", 5);
		Credits.put("B7 - Rideshare Program", 6);
		Credits.put("B8 - Low-emitting and Fuel-efficient Vehicle Program", 7);
		Credits.put("B9 - Alternative Fuel Vehicles", 8);
		Credits.put("B10 - Alternative Fuel Fleet Vehicles", 9);
		Credits.put("B11 - Bicycle Parking", 10);
		Credits.put("B12 - Bicycle Sharing/Rental", 11);
		Credits.put("B13 - Marketing/Educational Program", 12);
		// System.out.println(Credits);

		boolean flag = false;

		WebElement table = driver.findElement(By.xpath("//*[@id=\"content\"]/section/div[1]/div/table/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		HashMap<String, Integer> WebValue = new HashMap<String, Integer>();

		System.out.println(rows.size());

		for (int i = 0; i < rows.size(); i++) {
			// System.out.println(rows.get(i).getText());
			WebValue.put(rows.get(i).getText(), i);
		}
		// System.out.println(WebValue);

		Set<String> keyList = Credits.keySet();
		for (String key : keyList) {
			// System.out.println(key);
			if (Credits.get(key).equals(WebValue.get(key))) {
				flag = true;
				log.info("Credits Found......");
			} else
				log.info("Credits didn't Found........");
		}
		return flag;
	}

	public boolean CheckTechAndDesignCredits() {

		log.info(" CheckTechAndDesignCredits method starts here............");

		HashMap<String, Integer> Credits = new HashMap<String, Integer>();
		Credits.put("C1 - Idle Reduction Payment Systems", 0);
		Credits.put("C2 - Fire Suppression Systems", 1);
		Credits.put("C3 - No/Low-VOC Coatings, Paints and Sealants", 2);
		Credits.put("C4 - Tire Inflation Stations", 3);
		Credits.put("C5 - Electric Vehicle (EV) Charging Stations", 4);
		Credits.put("C6 - HVAC Systems - Occupied Spaces", 5);
		Credits.put("C7 - Ventilation Systems - Parking Decks", 6);
		Credits.put("C8 - Lighting Controls", 7);
		Credits.put("C9 - Energy-efficient Lighting System", 8);
		Credits.put("C10 - Stormwater Management", 9);
		Credits.put("C11 - Rainwater Harvesting", 10);
		Credits.put("C12 - Greywater Reuse", 11);
		Credits.put("C13 - Indoor Water-efficiency", 12);
		Credits.put("C14 - Water-efficient Landscaping", 13);
		Credits.put("C15 - Roofing Systems", 14);
		Credits.put("C16 - Renewable Energy Generation", 15);
		Credits.put("C17 - Design for Durability", 16);
		Credits.put("C18 - Energy Resiliency - Storage", 17);

		// System.out.println(Credits);

		boolean flag = false;

		WebElement table = driver.findElement(By.xpath("//*[@id=\"content\"]/section/div[1]/div/table/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		HashMap<String, Integer> WebValue = new HashMap<String, Integer>();

		System.out.println(rows.size());

		for (int i = 0; i < rows.size(); i++) {
			// System.out.println(rows.get(i).getText());
			WebValue.put(rows.get(i).getText(), i);
		}
		// System.out.println(WebValue);

		Set<String> keyList = Credits.keySet();
		for (String key : keyList) {
			// System.out.println(key);
			if (Credits.get(key).equals(WebValue.get(key))) {
				flag = true;
				log.info("Credits Found......");
			} else
				log.info("Credits didn't Found........");
		}
		return flag;
	}

	public boolean CheckInnovationCredits() {

		log.info("CheckInnovationCredits method starts here............");

		boolean flag = false;

		WebElement table = driver.findElement(By.xpath("//*[@id=\"content\"]/section/div[1]/div/table/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		List<String> value = new ArrayList<String>();

		System.out.println(rows.size());

		for (int j = 0; j < rows.size(); j++) {
			System.out.println(rows.get(j).getText());
			value.add(rows.get(j).getText());
		}
		System.out.println(value);
		if (value.contains("D1 - Innovative Approach")) {
			flag = true;
			log.info("Credit D1 found.....");
		} else
			log.info("Credit D1 Missing.....");

		return flag;
	}

	public boolean Validate_ToolTipMessage() {
		String Para1, Para2, Para3;
		boolean flag = true;
		for (int i = 1; i < 4; i++) {
			if (i == 1) {
				Para1 = driver
						.findElement(
								By.xpath("//p[contains(text(),'To select an option, click one of the check boxes.')]"))
						.getText();
				if (!Para1.equals(
						"To select an option, click one of the check boxes. Once you have selected an option, the documentation requirements for that option will appear.")) {
					flag = false;
					break;
				}
			}

			else if (i == 2) {
				Para2 = driver
						.findElement(
								By.xpath("//p[contains(text(),'Upload each of the required documents using the bu')]"))
						.getText();
				if (!Para2.equals(
						"Upload each of the required documents using the button to the left of the word “Upload” on the right hand side of your screen. Indicate which documents you have uploaded by clicking the check boxes next to each of the documentation requirements.")) {
					flag = false;
					break;
				}
			}

			else if (i == 3) {
				Para3 = driver
						.findElement(
								By.xpath("//p[contains(text(),'To reference the measure language for this measure')]"))
						.getText();
				if (!Para3.equals(
						"To reference the measure language for this measure, click the “Measure Language (PDF)” button on the right hand side of your screen.")) {
					flag = false;
					break;
				}
			}
		}
		try {
			actionhelper.clickRandomlyOnPage();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public boolean Validate_TeamToolTipMessage() {
		String Para1, Para2, Para3;
		boolean flag = true;
		for (int i = 1; i < 4; i++) {
			if (i == 1) {
				Para1 = driver
						.findElement(
								By.xpath("//p[contains(text(),'The Arc Administrator has complete access to the p')]"))
						.getText();
				if (!Para1.equals("Arc Administrator:\r\n"
						+ "The Arc Administrator has complete access to the project including data entry, submitting for review, and is granted rights to add additional team members. The Arc Administrator will also be the point of contact for automatic notifications, billing information, and review reports.")) {
					flag = false;
					break;
				}
			}

			else if (i == 2) {
				Para2 = driver
						.findElement(
								By.xpath("//p[contains(text(),': While multiple “Arc Administrators” can exist on')]"))
						.getText();
				if (!Para2.equals(
						"Note: While multiple “Arc Administrators” can exist on a project team, we strongly recommend that you designate only one person in this role to avoid confusion and so that a single point of contact is receiving notifications about billing and certification.")) {
					flag = false;
					break;
				}
			}

			else if (i == 3) {
				Para3 = driver
						.findElement(
								By.xpath("//p[contains(text(),'A Team Member has access to the project including ')]"))
						.getText();
				if (!Para3.equals("Team Member:\r\n"
						+ "A Team Member has access to the project including data entry and submitting for review, but cannot make any changes to the project team.")) {
					flag = false;
					break;
				}
			}
		}

		try {
			actionhelper.clickRandomlyOnPage();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public boolean CheckMeasurePDFDownloadedFile() {
		log.info("CheckDownloadedFile method starts here ......");
		// DownloadFolder=new File(UUID.randomUUID().toString());
		boolean flag = false;
		boolean flag1 = false;
		System.out.println(DownloadFolder);
		File ListOfFiles[] = DownloadFolder.listFiles();
		final String MeasureName = "";
		System.out.println(MeasureName);
		for (int i = 0; i < ListOfFiles.length; i++) {
			if (ListOfFiles[i].isFile()) {
				String fileName = ListOfFiles[i].getName();
				if (fileName.startsWith(MeasureName) && fileName.endsWith(".pdf")) {
					System.out.println("found file" + " " + fileName);
					flag = true;
					flag1 = true;
				}
			}
		}
		return flag && flag1;
	}

	public boolean CheckDownloadedFile(String fname) {
		log.info("CheckDownloadedFile method starts here ......");
		// DownloadFolder=new File(UUID.randomUUID().toString());

		WebElement ele = driver.findElement(By.xpath("//*[text()='" + fname + "']"));
		if (ele.isDisplayed()) {
			FileUploaded.click();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(DownloadFolder);
		File ListOfFiles[] = DownloadFolder.listFiles();
		// make sure the directory is not empty
		log.info("Total file downloaded ...." + ListOfFiles.length);
		if (ListOfFiles.length != 0) {
			for (File file : ListOfFiles) {

				log.info("Size of the file - " + file.getName() + " is  " + file.length());
				log.info("CheckDownloadedFile method ends here ......");
				return true;
			}
		} else
			log.info("CheckDownloadedFile method ends here ......");
		return false;
	}

	public boolean CheckDownloadedPDF() {
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
				return true;
			}
		} else
			log.info("CheckDownloadedFile method ends here ......");
		return false;
	}

	public boolean Check_Points_Updated() {
		log.info("Check_Points_Updated method starts here...........");

		boolean flag = false;

		String CheckboxPointText = driver.findElement(By.xpath("//span[@class='ng-scope'][1]")).getText();
		// System.out.println(CheckboxPointText);
		String[] SplitedPointText = CheckboxPointText.split("");
		String CheckBoxPoint = (String) Array.get(SplitedPointText, 1);
		log.info("Point Against Checkbox is ----->" + CheckBoxPoint);

		String PointsText = driver.findElement(By.xpath("/html/body/div[1]/div[6]/main/div/div[2]/div[1]/span"))
				.getText();
		String[] SplitText = PointsText.split(" ");
		String TextBefore = (String) Array.get(SplitText, 0);
		log.info("Points Before Selecting CheckBox ----->" + TextBefore);

		if (TextBefore.equals("0")) {

			driver.findElement(By.xpath("//input[@ng-model='option.data' and @type='checkbox'][1]")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String NewPointsText = driver.findElement(By.xpath("/html/body/div[1]/div[6]/main/div/div[2]/div[1]/span"))
					.getText();
			String[] SplitNewText = NewPointsText.split(" ");
			String TextAfter = (String) Array.get(SplitNewText, 0);
			log.info("Points After Selecting CheckBox ----->" + TextAfter);

			if (CheckBoxPoint.matches(TextAfter)) {
				flag = true;
				driver.findElement(By.xpath("//*[@id=\"actions-form\"]/div[2]/section[1]/div[3]/div/div[1]/div/input")).click();
			}
			log.info("Appropriate Points are updated Check_Points_Updated method ends here.........");
		} else
			log.info("Appropriate Points not updated Check_Points_Updated method ends here.........");
		
		return flag;
	}

	public void SelectAllCheckBoxes() {

		List<WebElement> AllCheckboxes = driver
				.findElements(By.xpath("//input[@ng-model='option.data' and @type='checkbox']"));

		int size = AllCheckboxes.size();
		System.out.println(size);

		for (int i = 0; i < size; i++) {

			AllCheckboxes.get(i).click();
		}
	}

	public boolean Check_Points_Updated_Selecting_All_CheckBoxes() {
		log.info("Check_Points_Updated_Selecting_All_CheckBoxes method starts here...........");

		boolean flag = false;
		String PointsText = driver.findElement(By.xpath("/html/body/div[1]/div[6]/main/div/div[2]/div[1]/span"))
				.getText();
		String[] SplitText = PointsText.split(" ");
		String TextBefore = (String) Array.get(SplitText, 0);
		String MaxPoints = (String) Array.get(SplitText, 2);
		log.info("Points Before Selecting CheckBox ----->" + TextBefore);

		String NewPointsText = driver.findElement(By.xpath("/html/body/div[1]/div[6]/main/div/div[2]/div[1]/span"))
				.getText();
		String[] SplitNewText = NewPointsText.split(" ");
		String TextAfter = (String) Array.get(SplitNewText, 0);
		log.info("Points After Selecting CheckBox ----->" + TextAfter);

		if (TextAfter.matches(MaxPoints)) {
			flag = true;
			log.info(
					"Points matched did not exceeded Max Points Check_Points_Updated_Selecting_All_CheckBoxes method ends here.........");
		} else
			log.info(
					"Points did not matched  Max Points Check_Points_Updated_Selecting_All_CheckBoxes method ends here.........");

		return flag;
	}

	public boolean ValidatePdfContent() {
		String pdfContent = null;

		String AgreementUrl = "file://////" + DownloadFolder.getAbsolutePath().toString() + "//Agreement.pdf";
		System.out.println(AgreementUrl);

		pdfContent = CommonMethod.getPDFContent(AgreementUrl);
		if (pdfContent.contains("Project ID : \r\n" + "Rating system : \r\n" + "User Name : \r\n" + "User Email : \r\n"
				+ "User ID : \r\n" + "Date and Time of Acceptance : \r\n" + "Name of Project : \r\n"
				+ "Owner Email : ")) {
			log.info("Validation of pdf content is done content matched..........");
			return true;
		} else
			log.info("Validation of pdf content is not done content didn't matched.........");
		return false;
	}

	public boolean CheckFileUploadedStatus(String fname) {
		log.info("CheckFileUploadedStatus method starts here ...");
		try {
			WebElement ele = driver.findElement(By.xpath("//*[text()='" + fname + "']"));
			if (ele.isDisplayed()) {
				log.info(" File is displaying ...");
				log.info("CheckFileUploadedStatus method ends with here true  ...");
				return true;
			} else {
				log.info(" File is not displaying ...");
				log.info("CheckFileUploadedStatus method ends with here false  ...");
				return false;
			}
		} catch (NoSuchElementException e) {
			log.info("Unable to locate uploaded file...");
			log.info(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	public static boolean CheckDateSignedDisplay() {
		log.info("CheckDateSignedDisplay method starts here ......");
		boolean flag = false;
		String RowPath = "//table[@class='table table-striped arc-table']/tbody/tr";
		List<WebElement> AgreementTable = driver.findElements(By.xpath(RowPath));
		log.info("Size of the Agreement Table is ---" + AgreementTable.size());
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
		Date date = new Date();
		String strDate = formatter.format(date);
		log.info(strDate);
		if (AgreementTable.size() > 0) {
			AgreementTable.iterator();
			String DateSignedPath = "";
			for (int i = 0; i < AgreementTable.size(); i++) {
				int rownum = i + 1;
					DateSignedPath = RowPath + "[" + rownum + "]/td[1]/span";
					String DateSigned = driver.findElement(By.xpath(DateSignedPath)).getText();
					log.info("Date Signed showing is " + DateSigned);
					if (DateSigned.equals(strDate)) {
						flag = true;
						break;
					}

				}

			}
		if (flag) {
			log.info("Date signed showing proper and flag is .........."+flag);
		} else {
			log.info("Date signed is not showing proper and flag is .........."+flag);
		}

		log.info("CheckDateSignedDisplay method ends here ......");
		return flag;
	}
	
	
}
