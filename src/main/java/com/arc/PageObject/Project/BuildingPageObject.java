package com.arc.PageObject.Project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class BuildingPageObject extends BaseClass {

	private static Logger log = LoggerHelper.getLogger(BuildingPageObject.class);

	@FindBy(xpath = "(//*[name()='svg']//*[local-name()='circle' ])[2]")
	WebElement CircularLoader;

	@FindBy(xpath = "//*[@class='page-controls navbar_info navbar-default']//child::h4")
	WebElement ProjectNameLabel;

	@FindBy(xpath = "(//*[text()='Manage' and @class='ml10'])[1]")
	WebElement ManageMenu;

	@FindBy(xpath = "//h3[@class='fw-500 black-color pl15 mb25 pt5']")
	WebElement OverviewText;

	@FindBy(xpath = "(//a[text()=' Agreements '])[1]")
	WebElement AgreementSubmenu;

	@FindBy(xpath = "//table[@class='table table-striped arc-table']/tbody/tr/td[3]/button")
	WebElement AgreementDownloadLink;

	@FindBy(xpath = "//table[@class='table table-striped arc-table']/tbody/tr[1]/td[6]/button")
	WebElement BillingDownloadLink;

	@FindBy(xpath = "//*[contains(text(),' Download invoice')]")
	WebElement DownLoadInvoicelink;

	@FindBy(xpath = "//*[contains(text(),' Download receipt')]")
	WebElement DownLoadReceiptlink;

	@FindBy(xpath = "(//a[text()=' Billing '])[1]")
	WebElement BillingSubmenu;

	@FindBy(xpath = "(//a[text()=' Team '])[1]")
	WebElement TeamSubmenu;

	@FindBy(xpath = "//input[@name='input']")
	WebElement TeamEmailTextBox;

	@FindBy(xpath = "(//button[@id='invite_team'])[1]")
	WebElement TeamInviteButton;

	@FindBy(xpath = "(//a[text()=' Project '])[1]")
	WebElement ProjectSubmenu;

	@FindBy(xpath = "(//span[text()='Overview'])[1]")
	WebElement OverviewMenu;

	@FindBy(name = "test_project")
	WebElement ThisIsTestProjectCheckBox;

	@FindBy(xpath = "//span[text()='Private']/parent::div/div/div[1]/span/input")
	WebElement PrivateYesRadioButton;

	// ***********************Regression Test

	@FindBy(xpath = "//span[text()='Add a meter']")
	WebElement OverviewAddAMeter;

	@FindBy(xpath = "//div[@class='modal fade in']")
	WebElement AddAMeterPopUpWindow;

	@FindBy(xpath = "//h4[text()='Add Energy Data']")
	WebElement AddAEnergyDataPopUpHeader;

	@FindBy(xpath = "//div[@class='meterList--wrapper']/div[1]/div[1]/span")
	WebElement MeterAndSurveyMiddleSection;

	@FindBy(xpath = "//div[@class='modalWindow-footer']/button[text()='Next']")
	WebElement AddAEnergyDataPopUpNextBtn;

	@FindBy(xpath = "//div[@class='modalWindow-footer']/button[text()='Cancel']")
	WebElement AddAEnergyDataPopUpCancelBtn;

	@FindBy(xpath = "//span[text()='Building Settings']")
	WebElement OverviewBuildingSetting;

	@FindBy(xpath = "//span[text()='Send a survey']")
	WebElement OverviewSendASurvey;

	@FindBy(xpath = "//span[text()='Update apps to collect data']")
	WebElement OverviewUpdateAppsToCollectData;

	@FindBy(xpath = "//span[text()='Get certified']")
	WebElement OverviewGetNotified;

	@FindBy(xpath = "//*[@class='toggle fa fa-angle-down initial-position']")
	WebElement Last12MonthsDropDownArrow;

	@FindBy(xpath = "//div[@class='label_wrapper']/span[@class='label reading_range']")
	WebElement Arcs_Score_Date_Range;

	@FindBy(xpath = "//span[text()='Cumulative GHG emissions from ']/parent::div/span[2]")
	WebElement Scope1_Scope2_Date_Range;

	@FindBy(xpath = "//span[text()='Average transportation GHG emissions from ']/parent::div/span[2]")
	WebElement Transportation_Date_Range;

	@FindBy(xpath = "//span[text()='Average occupant satisfaction from ']/parent::div/span[2]")
	WebElement Occupant_Date_Range;

	@FindBy(xpath = "//div[@id='score-puck']/div")
	WebElement RaceTrackScore;

	@FindBy(xpath = "//div[@id='address']")
	WebElement RaceTrackAddress;

	@FindBy(xpath = "//a[text()='Learn more']")
	WebElement LEEDPanDemicLearnMore;

	@FindBy(xpath = "//div[@class='unit drp unitdropitem']/following-sibling::div/div[2]/span[@class='value']")
	WebElement Overview_Arc_Score;

	@FindBy(xpath = "//h4[text()='Scope 1 and 2 emissions']/parent::div/div[3][@class='reading']/span[@class='value']")
	WebElement Overview_Scope1and2emissions_Score;

	@FindBy(xpath = "//h4[text()='Scope 1 and 2 emissions']/parent::div/div[3][@class='reading']/span[@class='unit']")
	WebElement Overview_Scope1and2emissions_Unit;

	@FindBy(xpath = "//h4[text()='Transportation GHG emissions']/parent::div/div[3][@class='reading']/span[@class='value']")
	WebElement Overview_Transportation_GHG_Emission_Score;

	@FindBy(xpath = "//h4[text()='Transportation GHG emissions']/parent::div/div[3][@class='reading']/span[@class='unit']")
	WebElement Overview_Transportation_GHG_Emission_Unit;

	@FindBy(xpath = "(//div[@class='meterInfo--wrapper'])[1]/following-sibling::ul/li/span[text()='Occupants']")
	WebElement BuildingSetting_OccupantsTab;

	@FindBy(xpath = "(//div[@class='meterInfo--wrapper'])[1]/following-sibling::ul/li/span[text()='Gross Floor Area']")
	WebElement BuildingSetting_GrossFloorAreaTab;

	@FindBy(xpath = "(//div[@class='meterInfo--wrapper'])[1]/following-sibling::ul/li/span[text()='Operating Hours']")
	WebElement BuildingSetting_OperatingHourTab;

	@FindBy(xpath = "(//div[@class='meterInfo--wrapper'])[1]/following-sibling::ul/li/span[text()='Emissions Factor']")
	WebElement BuildingSetting_EmissionsFactorTab;

	@FindBy(xpath = "(//div[@class='meterInfo--wrapper'])[1]/following-sibling::ul/li/span[text()='Operational Days']")
	WebElement BuildingSetting_OperationalDaysTab;

	@FindBy(xpath = "//span[text()='Add Row']")
	WebElement BuildingSetting_AddRow_button;

	public BuildingPageObject() {
		PageFactory.initElements(driver, this);
	}

	public String getProjectLabelText() {
		return ProjectNameLabel.getText();
	}

	public void ClickonAgreementInManage() {
		log.info("ClickonAgreementInManage method starts here...");
		waithelper.WaitForElementClickable(ManageMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ManageMenu.click();
		waithelper.WaitForElementClickable(AgreementSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		AgreementSubmenu.click();
		CommonMethod.waitUntilLoadElement();
		waithelper.waitForElement(driver.findElement(By.xpath("//span[text()='Agreements']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickonAgreementInManage method ends here...");
	}

	public void ClickonBillingInManage() {
		log.info("ClickonBillingInManage method starts here...");
		waithelper.WaitForElementClickable(ManageMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ManageMenu.click();
		waithelper.WaitForElementClickable(BillingSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		BillingSubmenu.click();
		CommonMethod.waitUntilLoadElement();
		waithelper.waitForElement(driver.findElement(By.xpath("//span[text()='Billing']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickonBillingInManage method ends here...");
	}

	public String CheckOverviewHeaderShowing() {
		log.info("CheckOverviewHeaderShowing method starts here...");
		try {

			waithelper.WaitForElementVisibleWithPollingTime(OverviewText,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			log.info("OverviewText.getText() value is ---- " + OverviewText.isDisplayed());
			log.info("CheckOverviewHeaderShowing method ends here...");
			return OverviewText.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("CheckOverviewHeaderShowing method ends here...");
		return null;

	}

	public void ClickonTeamInManage() {
		log.info("ClickonTeamInManage method starts here...");
		waithelper.WaitForElementClickable(ManageMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ManageMenu.click();
		waithelper.WaitForElementClickable(TeamSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		TeamSubmenu.click();
		CommonMethod.waitUntilLoadElement();
		waithelper.waitForElement(driver.findElement(By.xpath("//span[text()='Team']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickonTeamInManage method ends here...");
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

	public void ClickonOverview() {
		OverviewMenu.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//h3[@class='fw-500 black-color pl15 mb25 pt5'][text()='Overview']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
	}

	public boolean checkBuildingProjectCreation(String PName) {

		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(
							By.xpath("//*[@class='page-controls navbar_info navbar-default']/div/div/div/h4")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			if (driver.findElement(By.xpath("//*[@class='page-controls navbar_info navbar-default']/div/div/div/h4"))
					.getText().contains(PName)) {
				log.info("Project Name showing---------" + driver
						.findElement(By.xpath("//*[@class='page-controls navbar_info navbar-default']/div/div/div/h4"))
						.getText());
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;

	}

	public boolean CheckProjectIsPrivateFlagUnderManage(String ProjectID) {
		try {
			String path = "(//*[text()='" + ProjectID + "'])[2]";
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath(path)),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			log.info("PrivateYesRadioButton.isSelected() value is ---- " + PrivateYesRadioButton.isSelected());
			return PrivateYesRadioButton.isSelected();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

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

	public boolean CheckAddEnergyDataModelWindow() {
		log.info("CheckAddEnergyDataModelWindow  method starts here.........");
		boolean PopUpflag = false;
		CommonMethod.switchToShowOverviewFrame();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OverviewAddAMeter.click();
		CommonMethod.waitUntilLoadElement();
		CommonMethod.switchToDataInputFrame();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//div[@class='modal fade in']/div/div/div[1]/h4")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		PopUpflag = AddAEnergyDataPopUpHeader.isDisplayed();
		boolean MetersAndSurveyTab = MeterAndSurveyMiddleSection.isDisplayed();
		log.info("Add Energy Data Pop Up Window flag is --" + PopUpflag);
		log.info("MetersAndSurveyTab flag is --" + MetersAndSurveyTab);
		AddAEnergyDataPopUpCancelBtn.click();
		if (PopUpflag == true && MetersAndSurveyTab == true) {
			log.info("CheckAddEnergyDataModelWindow  method ends here with true .........");
			return true;
		} else {
			log.info("CheckAddEnergyDataModelWindow  method ends here with false.........");
			return false;
		}

	}

	public boolean ClickOnBuildingSetting() {
		log.info("ClickOnBuildingSetting  method starts here.........");
		boolean BuldingSettingTab = false;
		CommonMethod.switchToShowOverviewFrame();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OverviewBuildingSetting.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonMethod.switchToDataInputFrame();
		boolean MetersAndSurveyTab = MeterAndSurveyMiddleSection.isDisplayed();
		BuldingSettingTab = driver
				.findElement(By
						.xpath("//div[@class='meterNameInfo--wrapper pt5']/div[contains(text(),'Building Settings')]"))
				.isDisplayed();
		log.info("MetersAndSurveyTab flag is --" + MetersAndSurveyTab);
		log.info("BuldingSettingTab flag is --" + BuldingSettingTab);
		if (BuldingSettingTab == true && MetersAndSurveyTab == true) {
			log.info("ClickOnBuildingSetting  method ends here with true .........");
			return true;
		} else {
			log.info("ClickOnBuildingSetting  method ends here with false.........");
			return false;
		}

	}

	public void ClickOnBuildingSetting_OperatingHoursTab() {
		log.info("ClickOnBuildingSetting_OperatingHoursTab  method starts here.........");
		BuildingSetting_OperatingHourTab.click();
		waithelper.WaitForElementVisibleWithPollingTime(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		log.info("ClickOnBuildingSetting_OperatingHoursTab  method ends here with false.........");
	}

	public boolean CheckSendASurvey() {
		log.info("CheckSendASurvey  method starts here.........");
		boolean TransportationSurevyTab = false;
		CommonMethod.switchToShowOverviewFrame();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OverviewSendASurvey.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonMethod.switchToDataInputFrame();
		boolean MetersAndSurveyTab = MeterAndSurveyMiddleSection.isDisplayed();
		TransportationSurevyTab = driver
				.findElement(By.xpath(
						"//div[@class='meterNameInfo--wrapper']/div[2][contains(text(),'Transportation Survey')]"))
				.isDisplayed();
		log.info("MetersAndSurveyTab flag is --" + MetersAndSurveyTab);
		log.info("TransportationSurevyTab flag is --" + TransportationSurevyTab);
		if (TransportationSurevyTab == true && MetersAndSurveyTab == true) {
			log.info("CheckSendASurvey  method ends here with true .........");
			return true;
		} else {
			log.info("CheckSendASurvey  method ends here with false.........");
			return false;
		}

	}

	public boolean CheckUpdateAppsToCollectData() {
		log.info("CheckUpdateAppsToCollectData  method starts here.........");
		boolean AppsTab = false;
		CommonMethod.switchToShowOverviewFrame();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OverviewUpdateAppsToCollectData.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AppsTab = driver.findElement(By.xpath("//main[@id='content']/h1/span[2][text()='Apps']")).isDisplayed();
		log.info("AppsTab flag is --" + AppsTab);
		if (AppsTab == true) {
			log.info("CheckUpdateAppsToCollectData  method ends here with true .........");
			return true;
		} else {
			log.info("CheckUpdateAppsToCollectData  method ends here with false.........");
			return false;
		}

	}

	public boolean CheckGetNotified() {
		log.info("CheckGetNotified  method starts here.........");
		boolean LEEDCertificationsTab = false;
		CommonMethod.switchToShowOverviewFrame();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OverviewGetNotified.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LEEDCertificationsTab = driver.findElement(By.xpath("//main[@id='content']/h1/span[text()='Certifications']"))
				.isDisplayed();
		log.info("LEEDCertificationsTab flag is --" + LEEDCertificationsTab);
		if (LEEDCertificationsTab == true) {
			log.info("CheckGetNotified  method ends here with true .........");
			return true;
		} else {
			log.info("CheckGetNotified  method ends here with false.........");
			return false;
		}

	}

	public boolean CheckRHS_ShowLast12Months() {
		log.info("CheckRHS_ShowLast12Months  method starts here.........");
		boolean RHS_Last12Months = false;
		// CommonMethod.switchToShowOverviewFrame();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RHS_Last12Months = driver
				.findElement(By.xpath("//div[@class='dropdown dropdown_v2 pt2']/div/span[text()='Last 12 months']"))
				.isDisplayed();
		log.info("RHS_Last12Months flag is --" + RHS_Last12Months);
		if (RHS_Last12Months == true) {
			log.info("CheckRHS_ShowLast12Months  method ends here with true .........");
			return true;
		} else {
			log.info("CheckRHS_ShowLast12Months  method ends here with false.........");
			return false;
		}

	}

	public boolean CheckRHS_Last12Months_DateRange() {
		log.info("CheckRHS_Last12Months_ARC_Score  method starts here.........");
		boolean RHS_Last12Months = false;
		boolean Arcs_Score_Date_Range_Flag = false;
		boolean Scope1_Scope2_Date_Range_Flag = false;
		boolean Transportation_Date_Range_Flag = false;
		boolean Occupant_Date_Range_Flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			RHS_Last12Months = driver
					.findElement(By.xpath("//div[@class='dropdown dropdown_v2 pt2']/div/span[text()='Last 12 months']"))
					.isDisplayed();
			log.info("RHS_Last12Months flag is --" + RHS_Last12Months);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (RHS_Last12Months == false) {
			Last12MonthsDropDownArrow.click();
			List<WebElement> Last12MonthsDrop = driver.findElements(By.xpath("//ul[@id='range_dropdown']/li/a"));
			for (WebElement ele : Last12MonthsDrop) {
				log.info("Currently showing value for Last12Months Dropdown is --" + ele.getText());
				if (ele.getText().equals("Last 12 months"))
					ele.click();
				break;
			}
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy");
		LocalDateTime now = LocalDateTime.now();
		String StartDate = dtf.format(now.minusYears(1).withDayOfMonth(1)); // working Sep 01, 2020
		String EndDate = dtf.format(now.withDayOfMonth(1).minusDays(1)); // Aug 31, 2021
		String ExpDateRange = StartDate + " - " + EndDate;
		log.info("Expected Date Range is ---" + ExpDateRange);
		CommonMethod.switchToArcAverageFrame();
		String TempRange = Arcs_Score_Date_Range.getText();
		log.info("Arcs_Score_Date_Range showing is   " + TempRange);
		if (TempRange.equals(ExpDateRange)) {
			Arcs_Score_Date_Range_Flag = true;
			log.info("Arcs_Score_Date_Range_Flag is --" + Arcs_Score_Date_Range_Flag);
		}
		CommonMethod.switchToDefaultContent();
		CommonMethod.switchToAverageEmissionsFrame();
		TempRange = Scope1_Scope2_Date_Range.getText();
		log.info("Arcs_Score_Date_Range showing is   " + TempRange);
		if (TempRange.equals(ExpDateRange)) {
			Scope1_Scope2_Date_Range_Flag = true;
			log.info("Scope1_Scope2_Date_Range_Flag is --" + Scope1_Scope2_Date_Range_Flag);
		}
		CommonMethod.switchToDefaultContent();
		CommonMethod.switchToTransportationCategoryUsageFrame();
		TempRange = Transportation_Date_Range.getText();
		log.info("Transportation_Date_Range showing is   " + TempRange);
		if (TempRange.equals(ExpDateRange)) {
			Transportation_Date_Range_Flag = true;
			log.info("Transportation_Date_Range_Flag is --" + Transportation_Date_Range_Flag);
		}
		CommonMethod.switchToDefaultContent();
		CommonMethod.switchToOccupantCategoryUsageFrame();
		TempRange = Occupant_Date_Range.getText();
		log.info("Occupant_Date_Range showing is   " + TempRange);
		if (TempRange.equals(ExpDateRange)) {
			Occupant_Date_Range_Flag = true;
			log.info("Occupant_Date_Range_Flag is --" + Occupant_Date_Range_Flag);
		}

		if (Arcs_Score_Date_Range_Flag == true && Scope1_Scope2_Date_Range_Flag == true
				&& Transportation_Date_Range_Flag == true && Occupant_Date_Range_Flag == true) {
			log.info("Date Ranges are showing proper at all places..");
			log.info("CheckRHS_Last12Months_ARC_Score  method ends here with true.........");
			return true;
		} else {
			log.info("Date Ranges are not showing proper at all places..");
			log.info("CheckRHS_Last12Months_ARC_Score  method ends here with false.........");
			return false;
		}

	}

	public boolean CheckRHS_EndOfCalender_DateRange() {
		log.info("CheckRHS_EndOfCalender_DateRange  method starts here.........");
		boolean RHS_EndOfCalender = false;
		boolean Arcs_Score_Date_Range_Flag = false;
		boolean Scope1_Scope2_Date_Range_Flag = false;
		boolean Transportation_Date_Range_Flag = false;
		boolean Occupant_Date_Range_Flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			RHS_EndOfCalender = driver
					.findElement(
							By.xpath("//div[@class='dropdown dropdown_v2 pt2']/div/span[text()='End of calendar']"))
					.isDisplayed();
			log.info("RHS_Last12Months flag is --" + RHS_EndOfCalender);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (RHS_EndOfCalender == false) {
			Last12MonthsDropDownArrow.click();
			List<WebElement> Last12MonthsDrop = driver.findElements(By.xpath("//ul[@id='range_dropdown']/li/a"));
			for (WebElement ele : Last12MonthsDrop) {
				log.info("Currently showing value for Last12Months Dropdown is --" + ele.getText());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (ele.getText().equals("End of calendar")) {
					ele.click();
					break;
				}
			}
		}

		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy");
		LocalDateTime now = LocalDateTime.now();
		String StartDate = dtf.format(now.minusYears(1).withMonth(1).withDayOfMonth(1)); // Jan 01, 2020
		String EndDate = dtf.format(now.withMonth(1).withDayOfMonth(1).minusDays(1)); // Dec 31, 2020
		String ExpDateRange = StartDate + " - " + EndDate;
		log.info("Expected Date Range is ---" + ExpDateRange);
		CommonMethod.switchToArcAverageFrame();
		String TempRange = Arcs_Score_Date_Range.getText();
		log.info("Arcs_Score_Date_Range showing is   " + TempRange);
		if (TempRange.equals(ExpDateRange)) {
			Arcs_Score_Date_Range_Flag = true;
			log.info("Arcs_Score_Date_Range_Flag is --" + Arcs_Score_Date_Range_Flag);
		}
		CommonMethod.switchToDefaultContent();
		CommonMethod.switchToAverageEmissionsFrame();
		TempRange = Scope1_Scope2_Date_Range.getText();
		log.info("Scope1_Scope2_Date_Range showing is   " + TempRange);
		if (TempRange.equals(ExpDateRange)) {
			Scope1_Scope2_Date_Range_Flag = true;
			log.info("Scope1_Scope2_Date_Range_Flag is --" + Scope1_Scope2_Date_Range_Flag);
		}
		CommonMethod.switchToDefaultContent();
		CommonMethod.switchToTransportationCategoryUsageFrame();
		TempRange = Transportation_Date_Range.getText();
		log.info("Transportation_Date_Range showing is   " + TempRange);
		if (TempRange.equals(ExpDateRange)) {
			Transportation_Date_Range_Flag = true;
			log.info("Transportation_Date_Range_Flag is --" + Transportation_Date_Range_Flag);
		}
		CommonMethod.switchToDefaultContent();
		CommonMethod.switchToOccupantCategoryUsageFrame();
		TempRange = Occupant_Date_Range.getText();
		log.info("Occupant_Date_Range showing is   " + TempRange);
		if (TempRange.equals(ExpDateRange)) {
			Occupant_Date_Range_Flag = true;
			log.info("Occupant_Date_Range_Flag is --" + Occupant_Date_Range_Flag);
		}

		if (Arcs_Score_Date_Range_Flag == true && Scope1_Scope2_Date_Range_Flag == true
				&& Transportation_Date_Range_Flag == true && Occupant_Date_Range_Flag == true) {
			log.info("Date Ranges are showing proper at all places..");
			log.info("CheckRHS_EndOfCalender_DateRange  method ends here with true.........");
			return true;
		} else {
			log.info("Date Ranges are not showing proper at all places..");
			log.info("CheckRHS_EndOfCalender_DateRange  method ends here with false.........");
			return false;
		}

	}

	public boolean CheckRHS_CustomDateRange() {
		log.info("CheckRHS_EndOfCalender_DateRange  method starts here.........");
		boolean Arcs_Score_Date_Range_Flag = false;
		boolean Scope1_Scope2_Date_Range_Flag = false;
		boolean Transportation_Date_Range_Flag = false;
		boolean Occupant_Date_Range_Flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Last12MonthsDropDownArrow.click();
		List<WebElement> Last12MonthsDrop = driver.findElements(By.xpath("//ul[@id='range_dropdown']/li/a"));
		for (WebElement ele : Last12MonthsDrop) {
			log.info("Currently showing value for Last12Months Dropdown is --" + ele.getText());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (ele.getText().equals("Custom date range...")) {
				ele.click();
				break;
			}
		}
		waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='calendar_range']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//*[@class='fa fa-angle-left']")).click();
		// int day=CommonMethod.getCurrentDay();
		driver.findElement(By.xpath("//*[contains(@class,'days_grid')]/div[text()='10']")).click();
		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//div[text()='Apply']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//div[text()='Apply']")).click();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy");
		LocalDateTime now = LocalDateTime.now();
		String StartDate = dtf.format(now.withDayOfMonth(1).minusYears(1).minusMonths(1)); // Aug 01, 2020
		String EndDate = dtf.format(now.withDayOfMonth(1).minusMonths(1).minusDays(1)); // Jul 31, 2021
		String ExpDateRange = StartDate + " - " + EndDate;
		log.info("Expected Date Range is ---" + ExpDateRange);
		CommonMethod.switchToArcAverageFrame();
		String TempRange = Arcs_Score_Date_Range.getText();
		log.info("Arcs_Score_Date_Range showing is   " + TempRange);
		if (TempRange.equals(ExpDateRange)) {
			Arcs_Score_Date_Range_Flag = true;
			log.info("Arcs_Score_Date_Range_Flag is --" + Arcs_Score_Date_Range_Flag);
		}
		CommonMethod.switchToDefaultContent();
		CommonMethod.switchToAverageEmissionsFrame();
		TempRange = Scope1_Scope2_Date_Range.getText();
		log.info("Scope1_Scope2_Date_Range showing is   " + TempRange);
		if (TempRange.equals(ExpDateRange)) {
			Scope1_Scope2_Date_Range_Flag = true;
			log.info("Scope1_Scope2_Date_Range_Flag is --" + Scope1_Scope2_Date_Range_Flag);
		}
		CommonMethod.switchToDefaultContent();
		CommonMethod.switchToTransportationCategoryUsageFrame();
		TempRange = Transportation_Date_Range.getText();
		log.info("Transportation_Date_Range showing is   " + TempRange);
		if (TempRange.equals(ExpDateRange)) {
			Transportation_Date_Range_Flag = true;
			log.info("Transportation_Date_Range_Flag is --" + Transportation_Date_Range_Flag);
		}
		CommonMethod.switchToDefaultContent();
		CommonMethod.switchToOccupantCategoryUsageFrame();
		TempRange = Occupant_Date_Range.getText();
		log.info("Occupant_Date_Range showing is   " + TempRange);
		if (TempRange.equals(ExpDateRange)) {
			Occupant_Date_Range_Flag = true;
			log.info("Occupant_Date_Range_Flag is --" + Occupant_Date_Range_Flag);
		}

		if (Arcs_Score_Date_Range_Flag == true && Scope1_Scope2_Date_Range_Flag == true
				&& Transportation_Date_Range_Flag == true && Occupant_Date_Range_Flag == true) {
			log.info("Date Ranges are showing proper at all places..");
			log.info("CheckRHS_CustomDateRange  method ends here with true.........");
			return true;
		} else {
			log.info("Date Ranges are not showing proper at all places..");
			log.info("CheckRHS_CustomDateRange  method ends here with false.........");
			return false;
		}

	}

	public boolean CheckTotalDropDownWithZeroScore() {
		log.info("CheckTotalDropDownWithZeroScore  method starts here.........");
		boolean ScoreFlag = false;

		CommonMethod.switchToArcAverageFrame();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//div[@class='unit drp unitdropitem']/span")).click();
		List<WebElement> TotalDrpopList = driver
				.findElements(By.xpath("//div[@class='unit drp unitdropitem']/div/div"));
		driver.findElement(By.xpath("//div[@class='unit drp unitdropitem']/span")).click();
		log.info("Total List items exists in Total Dropdown is  " + TotalDrpopList.size());
		for (WebElement ele : TotalDrpopList) {
			driver.findElement(By.xpath("//div[@class='unit drp unitdropitem']/span")).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ele.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// String score = driver.findElement(By.xpath("//div[@class='unit drp
			// unitdropitem']/following-sibling::div/div[2]/span[@class='value']")).getText();
			String score = Overview_Arc_Score.getText();
			log.info(ele.getAttribute("innerText") + " score is " + score);
			if (Integer.parseInt(score) == 0) {
				ScoreFlag = true;
			} else
				break;
		}

		if (ScoreFlag == true) {
			log.info("Score of All dropdown values are 0");
			log.info("CheckTotalDropDownWithZeroScore  method ends here with true.........");
			return true;
		} else {
			log.info("Score of All dropdown values are not 0");
			log.info("CheckTotalDropDownWithZeroScore  method ends here with false.........");
			return false;
		}

	}

	public boolean CheckRaceTrackWithZeroScore() {
		log.info("CheckRaceTrackWithZeroScore  method starts here.........");

		ClickonProjectInManage();
		String ProjectAddress = driver.findElement(By.xpath("//div[@class='w50p']/div[2]/div[2]")).getText();
		ClickonOverview();
		CommonMethod.switchToPlaqueFrame();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int RaceScore = Integer.parseInt(RaceTrackScore.getText());
		String RaceAddress = RaceTrackAddress.getText();
		log.info("Project Address is  " + ProjectAddress);
		log.info("RaceTrack Address is  " + RaceAddress + " and RaceTrack Score is " + RaceScore);

		if (RaceAddress.contains(ProjectAddress) && RaceScore == 0) {
			log.info("RaceTrack Address and RaceTrack Score are showing proper");
			log.info("CheckRaceTrackWithZeroScore  method ends here with true.........");
			return true;
		}

		else {
			log.info("RaceTrack Address and RaceTrack Score are not showing proper");
			log.info("CheckRaceTrackWithZeroScore  method ends here with false.........");
			return false;
		}

	}

	public boolean CheckGraphicDropDownWithZeroScore() {
		log.info("CheckGraphicDropDownWithZeroScore  method starts here.........");
		boolean RaceImageflag = false;
		boolean EnergyFlag = false;
		boolean WaterFlag = false;
		boolean WasteFlag = false;
		boolean TransportationFlag = false;
		boolean HRFlag = false;
		CommonMethod.switchToPlaqueFrame();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// driver.findElement(By.xpath("//div[@class='animation drp']/span")).click();
		List<WebElement> GraphicDropList = driver.findElements(By.xpath("//div[@class='animation drp']/div/div"));
		// driver.findElement(By.xpath("//div[@class='animation drp']/span")).click();
		log.info("Total Number of List items are  " + GraphicDropList.size());

		for (WebElement ele : GraphicDropList) {
			try {
				driver.findElement(By.xpath("//div[@class='animation drp']/span")).click();
				ele.click();
				Thread.sleep(4000);
				log.info("Current Drop down value is  " + ele.getAttribute("innerText"));
				if (driver.findElement(By.xpath("//div[@class='animation drp']/span")).getText().equals("Graphic")) {
					RaceImageflag = driver.findElement(By.xpath("//div[@id='score_puck_container_total']"))
							.isDisplayed();
					log.info("RaceTrack image displayed flag is   " + RaceImageflag);
				} else if (driver.findElement(By.xpath("//div[@class='animation drp']/span")).getText()
						.equals("Table View")) {
					for (int i = 1; i < 6; i++) {
						String LabelXpath = "((//div[@id='table_container']/div)[" + i + "]/div)[1]/span";
						String ScoreXpath = "((//div[@id='table_container']/div)[" + i + "]/div)[2]/span[1]";
						String Label = driver.findElement(By.xpath(LabelXpath)).getText();
						int score = Integer.parseInt(driver.findElement(By.xpath(ScoreXpath)).getText());
						log.info("Current Label is  " + Label + " Score is " + score);
						if (Label.equals("Energy") && score == 0) {
							EnergyFlag = true;
						} else if ((Label.equals("Water") && score == 0)) {
							WaterFlag = true;
						} else if ((Label.equals("Waste") && score == 0)) {
							WasteFlag = true;
						} else if ((Label.equals("Transportation") && score == 0)) {
							TransportationFlag = true;
						} else if ((Label.equals("Human Experience") && score == 0)) {
							HRFlag = true;
						}
					}

				}
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}

		if ((RaceImageflag) && (EnergyFlag) && (WaterFlag) && (WasteFlag) && (TransportationFlag) && (HRFlag)) {
			log.info("Both Graphic and Tabular View are showing proper");
			log.info("CheckGraphicDropDownWithZeroScore  method ends here with true.........");
			return true;
		}

		else {
			log.info("Both Graphic and Tabular View are not showing proper");
			log.info("CheckGraphicDropDownWithZeroScore  method ends here with false.........");
			return false;
		}

	}

	public boolean CheckLEEDPandemicResponseOptions() {
		log.info("CheckLEEDPandemicResponseOptions  method starts here.........");
		String title = "";
		// CommonMethod.switchToPlaqueFrame();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String handle = driver.getWindowHandle();
		LEEDPanDemicLearnMore.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Set<String> handles = driver.getWindowHandles();
		for (String window : handles) {
			if (!window.equals(handle)) {
				driver.switchTo().window(window);
				title = driver.getTitle();
				driver.close();
				break;
			}
		}

		if (title.equals("Managing Occupancy in Arc for LEED Certification during COVID-19 | Arc Skoru")) {
			log.info("Learn more link is working properly");
			log.info("CheckLEEDPandemicResponseOptions  method ends here with true.........");
			return true;
		}

		else {
			log.info("Learn more link is not working properly");
			log.info("CheckLEEDPandemicResponseOptions  method ends here with false.........");
			return false;
		}

	}

	public boolean CheckScope1And2emissions_ZeroScore() {
		log.info("CheckScope1And2emissions_ZeroScore  method starts here.........");
		CommonMethod.switchToAverageEmissionsFrame();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int Scope1Scope2Score = Integer.parseInt(Overview_Scope1and2emissions_Score.getText());
		String Scope1Scope2_Unit = Overview_Scope1and2emissions_Unit.getText();
		log.info("Scope 1 and 2 emissions Score is      " + Scope1Scope2Score + " and unit is " + Scope1Scope2_Unit);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (Scope1Scope2Score == 0 && Scope1Scope2_Unit.equals("MTCO2e")) {
			log.info("CheckScope1And2emissions_ZeroScore  method ends here with true.........");
			return true;
		}

		else {
			log.info("CheckScope1And2emissions_ZeroScore  method ends here with false.........");
			return false;
		}

	}

	public boolean CheckArcImprovementWithZeroScores() {
		log.info("CheckArcImprovementWithZeroScores  method starts here.........");
		boolean EnergyFlag = false;
		boolean WaterFlag = false;
		boolean WasteFlag = false;
		boolean TransportationFlag = false;
		boolean HRFlag = false;
		CommonMethod.switchArcImprovementFrame();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 1; i < 6; i++) {
			String LabelXpath = "(//h4[text()='Arc Improvement Scores']/parent::div/div[@class='score_item'])[" + i
					+ "]/div[1]/span";
			String ScoreXpath = "(//h4[text()='Arc Improvement Scores']/parent::div/div[@class='score_item'])[" + i
					+ "]/div[2]/span[@class='value']";
			String TotalScoreXpath = "(//h4[text()='Arc Improvement Scores']/parent::div/div[@class='score_item'])[" + i
					+ "]/div[2]/span[@class='unit']";

			String Label = driver.findElement(By.xpath(LabelXpath)).getText();
			int score = Integer.parseInt(driver.findElement(By.xpath(ScoreXpath)).getText());
			String TotalScore = driver.findElement(By.xpath(TotalScoreXpath)).getText();
			log.info("Current Label is  " + Label + " Score is " + score + TotalScore);
			if (Label.equals("Energy") && score == 0 && TotalScore.equals("/100")) {
				EnergyFlag = true;
			} else if ((Label.equals("Water") && score == 0 && TotalScore.equals("/100"))) {
				WaterFlag = true;
			} else if ((Label.equals("Waste") && score == 0 && TotalScore.equals("/100"))) {
				WasteFlag = true;
			} else if ((Label.equals("Transportation") && score == 0 && TotalScore.equals("/100"))) {
				TransportationFlag = true;
			} else if ((Label.equals("Human Experience") && score == 0 && TotalScore.equals("/100"))) {
				HRFlag = true;
			}
		}

		if ((EnergyFlag) && (WaterFlag) && (WasteFlag) && (TransportationFlag) && (HRFlag)) {
			log.info("CheckArcImprovementWithZeroScores  method ends here with true.........");
			return true;
		}

		else {
			log.info("CheckArcImprovementWithZeroScores  method ends here with false.........");
			return false;
		}
	}

	public boolean CheckTransportation_GHGEmission_ZeroScores() {
		log.info("CheckTransportation_GHGEmission_ZeroScores  method starts here.........");
		CommonMethod.switchToTransportationCategoryUsageFrame();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int TransportationScore = Integer.parseInt(Overview_Transportation_GHG_Emission_Score.getText());
		String Transportation_Unit = Overview_Transportation_GHG_Emission_Unit.getText();
		log.info("Transportation  Score is      " + TransportationScore + " and Unit is " + Transportation_Unit);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (TransportationScore == 0 && Transportation_Unit.equals("lbs")) {
			log.info("CheckTransportation_GHGEmission_ZeroScores  method ends here with true.........");
			return true;
		}

		else {
			log.info("CheckTransportation_GHGEmission_ZeroScores  method ends here with false.........");
			return false;
		}
	}

	public boolean CheckRHS_All_Partners_App() {
		log.info("CheckRHS_All_Partners_App  method starts here.........");
		CommonMethod.switchToArcPartnerFrame();
		String PartnerHeader = null;
		boolean flag = false;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> partners = driver.findElements(By.xpath("//div[@id='myCarousel']/ol/li"));
		log.info("Total number of Partners is  " + partners.size());
		int i = 1;
		for (WebElement ele : partners) {
			ele.click();
			String PartnerHeader_Xpath = "//div[@class='carousel-inner']/div[" + i + "]/div/h4";
			try {
				PartnerHeader = driver.findElement(By.xpath(PartnerHeader_Xpath)).getAttribute("innerText");
				flag = driver.findElement(By.xpath(PartnerHeader_Xpath)).isDisplayed();
			} catch (Exception e) {
				flag = false;
				e.printStackTrace();
				break;
			}
			log.info("Current Partner Heading showing is  " + PartnerHeader + " isDisplayed flag is " + flag);
			/*
			 * if(PartnerHeader.equals(null ) || PartnerHeader.equals(" ")) { flag=false;
			 * break; }
			 */
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (flag) {
			log.info("CheckRHS_All_Partners_App  method ends here with true.........");
			return true;
		}

		else {
			log.info("CheckRHS_All_Partners_App  method ends here with false.........");
			return false;
		}
	}

	public boolean BuildingSetting_OperatingHours_AddRow(String UserName) {
		log.info("BuildingSetting_OperatingHours_AddRow  method starts here.........");
		boolean EffectiveTextBoxflag = false;
		boolean OperatingHoursFlag = false;
		boolean DocumentationFlag = false;
		boolean SaveBtnFlag = false;
		boolean UpdatedByFlag = false;
		boolean DeleteBtnFlag = false;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BuildingSetting_AddRow_button.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[1]/input")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[1]/input")).isDisplayed()) {
			EffectiveTextBoxflag = true;
			log.info("EffectiveTextBoxflag is " + EffectiveTextBoxflag);
		}
		if (driver.findElement(By.xpath(
				"//table[@id='readingsTable']/tbody/tr/td[2]/div/button[@type='button']/span[contains(text(),'Hour')]"))
				.isDisplayed()) {
			OperatingHoursFlag = true;
			log.info("OperatingHoursFlag is " + OperatingHoursFlag);
		}
		if (driver
				.findElement(By.xpath(
						"//table[@id='readingsTable']/tbody/tr/td[3]/div/div/button/span[@class='upload-doc--icon']"))
				.isDisplayed()) {
			DocumentationFlag = true;
			log.info("DocumentationFlag is " + DocumentationFlag);
		}

		if (driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[4]/div")).getText()
				.contains(UserName)) {
			UpdatedByFlag = true;
			log.info("UpdatedByFlag is " + UpdatedByFlag);
		}

		if (driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[5]/button/span[text()='Save']"))
				.isDisplayed()) {
			SaveBtnFlag = true;
			log.info("SaveBtnFlag is " + SaveBtnFlag);
		}

		if (driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[7]/span")).isDisplayed()) {
			DeleteBtnFlag = true;
			log.info("DeleteBtnFlag is " + DeleteBtnFlag);
		}

		if ((EffectiveTextBoxflag) && (OperatingHoursFlag) && (DocumentationFlag) && (UpdatedByFlag) && (SaveBtnFlag)
				&& (DeleteBtnFlag)) {
			log.info("All the fields are displaying properly.");
			log.info("BuildingSetting_OperatingHours_AddRow  method ends here with true.........");
			return true;
		} else {
			log.info("All the fields are not displaying properly.");
			log.info("BuildingSetting_OperatingHours_AddRow  method ends here with false.........");
			return false;
		}
	}

}
