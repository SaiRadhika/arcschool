package com.arc.PageObject.Project;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.InputEvent;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.xmlbeans.impl.values.JavaStringHolderEx;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;
import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.NgWebDriver;

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

	@FindBy(xpath = "(//table[@class='meterListByType--wrapper']/tbody/tr[1])[1]/td[3]/div/span/span")
	WebElement EnergyScore;

	@FindBy(xpath = "(//table[@class='meterListByType--wrapper']/tbody/tr[1])[4]/td[3]/div/span/span")
	WebElement TransportScore;

	@FindBy(xpath = "(//table[@class='meterListByType--wrapper']/tbody)[3]/tr[1]/td[3]/div/span/span")
	WebElement WasteScore;

	@FindBy(xpath = "(//table[@class='meterListByType--wrapper']/tbody)[2]/tr[1]/td[3]/div/span/span")
	WebElement WaterScore;

	@FindBy(xpath = "//span[text()='Add a meter']")
	WebElement OverviewAddAMeter;

	@FindBy(xpath = "//div[@class='modal fade in']")
	WebElement AddAMeterPopUpWindow;

	@FindBy(xpath = "//h4[text()='Add Energy Data']")
	WebElement AddAEnergyDataPopUpHeader;

	@FindBy(xpath = "//h4[text()='Add Water Data']")
	WebElement AddAWaterDataPopUpHeader;

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

	@FindBy(xpath = "//button[@class='dropdown-toggle meterDataYearsFilter-btn']")
	WebElement BuildingSetting_FilterButton;

	@FindBy(xpath = "//p[@class='startDateFrom--label']/following-sibling::input")
	WebElement BuildingSetting_FilterStartDate;

	@FindBy(xpath = "//p[@class='endDateFrom--label']/following-sibling::input")
	WebElement BuildingSetting_FilterEndDate;

	@FindBy(xpath = "//button[@class='btn btn-success']")
	WebElement BuildingSetting_UpdateButton;

	@FindBy(xpath = "//h6[@class='reset-filter']")
	WebElement BuildingSetting_ResetButton;

	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[3]/tr[2]/td[2]/div")
	WebElement Waste_Data;

	@FindBy(xpath = "(//*[@id='comment_box'])[1]")
	WebElement BuildingSetting_CommentTextBox;

	@FindBy(xpath = "(//button[text()='Post'])[1]")
	WebElement BuildingSetting_PostButton;

	@FindBy(xpath = "//span[text()='Activity']")
	WebElement BuildingSetting_ActivityButton;

	@FindBy(xpath = "//span[text()='Add Occupancy data']/parent::button")
	WebElement BuildingSetting_AddOccupancyDataBtn;

	@FindBy(xpath = "//div[@id='addNewMeterDisplayModal']/following-sibling::div[@class='openOccupancyModal modal fade in']/descendant::button[text()='Close']")
	WebElement BuildingSetting_AddOccupancy_CloseBtn;

	@FindBy(xpath = "//div[@id='addNewMeterDisplayModal']/following-sibling::div[@class='openOccupancyModal modal fade in']/descendant::button/span[text()='ADD']")
	WebElement BuildingSetting_AddOccupancy_ADDBtn;

	@FindBy(xpath = "//div[text()='Effective date']/following-sibling::input")
	WebElement BuildingSetting_Occupancy_EffectiveDate;

	@FindBy(xpath = "//div[text()='Regular building occupants (daily average)']/following-sibling::input")
	WebElement BuildingSetting_Occupancy_RegularBuildingOccupant;

	@FindBy(xpath = "//div[text()='Days per week with visitors']/following-sibling::input")
	WebElement BuildingSetting_Occupancy_DaysPerWeekWithVisitors;

	@FindBy(xpath = "//div[text()='Number of visitors each day']/following-sibling::input")
	WebElement BuildingSetting_Occupancy_NoOfVisitorsEachDay;

	@FindBy(xpath = "//div[text()='Duration of visit (in hours/day)']/following-sibling::input")
	WebElement BuildingSetting_Occupancy_DurationOfVisit;

	@FindBy(xpath = "//div[text()='Duration of visit (in hours/day)']/following-sibling::div/descendant::a[@title='Increment Hour']/span")
	WebElement BuildingSetting_Occupancy_HoursIncrement;

	@FindBy(xpath = "//div[text()='Duration of visit (in hours/day)']/following-sibling::div/descendant::a[@title='Decrement Hour']/span")
	WebElement BuildingSetting_Occupancy_HoursDecrement;

	@FindBy(xpath = "//div[text()='Duration of visit (in hours/day)']/following-sibling::div/descendant::a[@title='Increment Minute']/span")
	WebElement BuildingSetting_Occupancy_MinutesIncrement;

	@FindBy(xpath = "//div[text()='Duration of visit (in hours/day)']/following-sibling::div/descendant::a[@title='Decrement Minute']/span")
	WebElement BuildingSetting_Occupancy_MinutesDecrement;

	@FindBy(xpath = "//span[@class='timepicker-hour']")
	WebElement BuildingSetting_Occupancy_HoursDropDown;

	@FindBy(xpath = "//span[@class='timepicker-minute']")
	WebElement BuildingSetting_Occupancy_MinutesDropDown;

	@FindBy(xpath = "//div[@class='fw600 mb10'][text()='Weekly operating']/following-sibling::span[1]")
	WebElement BuildingSetting_Occupancy_WeeklyOperatingHours;

	@FindBy(xpath = "//div[@class='fw600 mb10'][text()='Visitors']/following-sibling::span")
	WebElement BuildingSetting_Occupancy_VisitorsDailyAVG;

	@FindBy(xpath = "//div[@class='fw600 mb10'][text()='Total daily']/following-sibling::span")
	WebElement BuildingSetting_Occupancy_TotalDailyOccupancy;

	@FindBy(xpath = "//label[contains(text(),'Use Standard Emissions Factor')]/input")
	WebElement BuildingSetting_Emissions_StandardEmissions;

	@FindBy(xpath = "//label[contains(text(),'Use Custom Emissions Factor')]/input")
	WebElement BuildingSetting_Emissions_CustomEmissions;

	@FindBy(xpath = "(//span[contains(@class,'ml10') and text()='Meters & Surveys'])[1]")
	WebElement MetersAndSurveyMenu;

	@FindBy(xpath = "//div[@class='fw600 mb5' and text()='Energy']/ancestor::tr/following-sibling::tr[1]/descendant::span[text()='Add New Meter']")
	WebElement EnergyAddNewMeter;

	@FindBy(xpath = "//div[@class='modal fade in']/div/div/div[3]/button[text()='Next']")
	WebElement AddNewMeterNextBtn;

	@FindBy(xpath = "//div[@class='modal fade in']/div/div/div[3]/button[text()='Cancel']")
	WebElement AddNewMeterCancelBtn;

	@FindBy(xpath = "//div[@class='fw600 mb10' and text()='Meter Name']/following-sibling::input")
	WebElement MeterNameTextBox;

	@FindBy(xpath = "//div[@class='fw600 mb5' and text()='Water']/ancestor::tr/following-sibling::tr[1]/descendant::span[text()='Add New Meter']")
	WebElement WaterAddNewMeter;

	@FindBy(xpath = "//div[@class='fw600 mb5' and text()='Transportation']/ancestor::tr/following-sibling::tr[1]/td[2]/div[contains(text(),'Transportation Survey')]")
	WebElement TransportationSurvey;

	@FindBy(xpath = "//button[contains(text(),'Survey Tools and Resources')]")
	WebElement Transportation_SurveyToolsResource;

	@FindBy(xpath = "//div[@class='rangeslider__handle']")
	WebElement Transportation_RangeSlider;

	@FindBy(xpath = "//div[@class='mb20 selected']/preceding-sibling::div/h4[@class='slider-text fw-400 ng-binding']")
	WebElement Transportation_SatisfactionMSG;

	@FindBy(xpath = "//p[text()='Comments (Optional)']/following-sibling::input[1]")
	WebElement BuildingSurvey_CommentOptional;

	@FindBy(xpath = "//p[text()='Comments (Optional)']/following-sibling::input[2]")
	WebElement BuildingSurvey_Location;

	@FindBy(xpath = "//p[text()='Comments (Optional)']/following-sibling::input[3]")
	WebElement BuildingSurvey_NameOptional;

	@FindBy(xpath = "//button[text()='Submit']")
	WebElement Transportation_SubmitBtn;

	@FindBy(xpath = "//h4[text()='Thank you for taking our survey! Your responses:']")
	WebElement Transportation_SubmitResponseText;

	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[5]/descendant::div[contains(text(),'Occupant Satisfaction Survey')]")
	WebElement HE_Occupant_Satisfaction_Survey;

	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[5]/descendant::div[contains(text(),'Carbon Dioxide')]")
	WebElement HE_CarbonDioxide;

	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[5]/descendant::div[contains(text(),'Total Volatile Organic Compounds')]")
	WebElement HE_TVOC;

	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[5]/descendant::div[contains(text(),'PM2.5')]")
	WebElement HE_PM2_5;

	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[5]/descendant::div[contains(text(),'Ozone')]")
	WebElement HE_Ozone;

	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[5]/descendant::div[contains(text(),'Carbon Monoxide')]")
	WebElement HE_CarbonMonoOxide;

	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[5]/descendant::div[contains(text(),'Acetaldehyde')]")
	WebElement HE_Acetaldehyde;

	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[5]/descendant::div[contains(text(),'Benzene')]")
	WebElement HE_Benzene;

	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[5]/descendant::div[contains(text(),'Styrene')]")
	WebElement HE_Styrene;

	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[5]/descendant::div[contains(text(),'Toluene')]")
	WebElement HE_Toluene;

	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[5]/descendant::div[contains(text(),'Naphthalene')]")
	WebElement HE_Naphthalene;

	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[5]/descendant::div[contains(text(),'Dichlorobenzene')]")
	WebElement HE_DichloroBenzene;

	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[5]/descendant::div[contains(text(),'Xylenes-total')]")
	WebElement HE_XylenesTotal;

	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[5]/descendant::div[contains(text(),'Formaldehyde')]")
	WebElement HE_FormalDehype;

	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[5]/descendant::span[contains(text(),'Show more')]")
	WebElement HE_ShowMore;

	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[6]/tr/descendant::div[contains(text(),'Facility Management Survey')]")
	WebElement ReEntry_FMS;

	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[6]/tr/descendant::div[contains(text(),'Occupant Survey')]")
	WebElement ReEntry_OccupantSurvey;

	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[6]/tr/descendant::div[contains(text(),'Relative Humidity')]")
	WebElement ReEntry_RelativeHumidity;

	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[6]/tr/descendant::span[contains(text(),'Show more')]")
	WebElement ReEntry_ShowMore;

	@FindBy(xpath = "//div[@id='js-rangeslider-0']/div[@class='rangeslider__handle']")
	WebElement ReEntry_Environment_Slider;

	@FindBy(xpath = "//div[@id='js-rangeslider-1']/div[@class='rangeslider__handle']")
	WebElement ReEntry_DiseaseControl_Slider;

	@FindBy(xpath = "//div[@id='js-rangeslider-2']/div[@class='rangeslider__handle']")
	WebElement ReEntry_OccupantScreening_Slider;

	@FindBy(xpath = "//div[@id='js-rangeslider-3']/div[@class='rangeslider__handle']")
	WebElement ReEntry_HandWashing_Slider;

	@FindBy(xpath = "//div[@id='js-rangeslider-4']/div[@class='rangeslider__handle']")
	WebElement ReEntry_SupportSocialDistancing_Slider;

	@FindBy(xpath = "//div[@id='js-rangeslider-5']/div[@class='rangeslider__handle']")
	WebElement ReEntry_ManintainSocialDistancing_Slider;

	@FindBy(xpath = "//div[@id='js-rangeslider-6']/div[@class='rangeslider__handle']")
	WebElement ReEntry_ProtectedDiseaseTransmission_Slider;

	@FindBy(xpath = "//div[@id='js-rangeslider-7']/div[@class='rangeslider__handle']")
	WebElement ReEntry_StaffUsePPE_Slider;

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

	// This method will return the energy score

	public int getEnergyScore() {

		log.info("getEnergyScore method starts here........");

		int score = Integer.parseInt(EnergyScore.getText());
		log.info("Energy Score is -----" + score);
		log.info("getEnergyScore method ends here........");
		return score;

	}

	// This method will return the Water score

	public int getWaterScore() {

		log.info("getWaterScore method starts here........");
		int score = Integer.parseInt(WaterScore.getText());
		log.info("Water Score is -----" + score);
		log.info("getWaterScore method ends here........");
		return score;

	}

	// This method will return the Waste score

	public int getWasteScore() {

		log.info("getWasteScore method starts here........");

		int score = Integer.parseInt(WasteScore.getText());
		log.info("Waste Score is -----" + score);
		log.info("getWasteScore method ends here........");
		return score;

	}

	// This method will return the project address from Manage->Project Page
	public String getProjectAddress() {
		log.info("getProjectAddress  method starts here.........");
		ClickonProjectInManage();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ProjectAddress = driver.findElement(By.xpath("//div[@class='w50p']/div[2]/div[2]")).getText();
		log.info("Project Address is "+ProjectAddress);
		log.info("getProjectAddress  method ends here.........");
		return ProjectAddress;
	}

	// This method will return the project Name from Manage->Project Page
	public String getProjectName() {
		log.info("getProjectName  method starts here.........");
		ClickonProjectInManage();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ProjectName = driver.findElement(By.xpath("//input[@name='name']")).getAttribute("value");
		log.info("getProjectName  method ends here.........");
		return ProjectName;
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

	// --> Verify in Overview tab, Under Actions- clicking on Add a meter should
	// redirect to 'meters and surveys' and opens up 'Add Energy data' pop-up
	// window.
	public boolean CheckAddEnergyDataModelWindow() {
		log.info("CheckAddEnergyDataModelWindow  method starts here.........");
		boolean PopUpflag = false;
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(OverviewAddAMeter, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		OverviewAddAMeter.click();
		CommonMethod.waitUntilLoadElement();
		CommonMethod.switchToDefaultContent();
		CommonMethod.switchToDataInputFrame();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//div[@class='modal fade in']/div/div/div[1]/h4")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		PopUpflag = AddAEnergyDataPopUpHeader.isDisplayed();
		boolean MetersAndSurveyTab = MeterAndSurveyMiddleSection.isDisplayed();
		log.info("Add Energy Data Pop Up Window flag is --" + PopUpflag);
		log.info("MetersAndSurveyTab flag is --" + MetersAndSurveyTab);
		// AddAEnergyDataPopUpCancelBtn.click();
		if (PopUpflag == true && MetersAndSurveyTab == true) {
			log.info("CheckAddEnergyDataModelWindow  method ends here with true .........");
			return true;
		} else {
			log.info("CheckAddEnergyDataModelWindow  method ends here with false.........");
			return false;
		}

	}

	// --> Verify in Overview tab, Under Actions- clicking on 'Building Settings'
	// should redirect to 'meters and surveys' and highlights up 'Building settings'
	// tab
	public boolean ClickOnBuildingSetting() {
		log.info("ClickOnBuildingSetting  method starts here.........");
		boolean BuldingSettingTab = false;
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(OverviewBuildingSetting, Integer.parseInt(prop.getProperty("explicitTime")),
				2);
		OverviewBuildingSetting.click();
		//ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonMethod.switchToDefaultContent();
		CommonMethod.switchToDataInputFrame();
		boolean MetersAndSurveyTab = MeterAndSurveyMiddleSection.isDisplayed();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By
						.xpath("//div[@class='meterNameInfo--wrapper pt5']/div[contains(text(),'Building Settings')]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
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

	public boolean ClickOnMetersAndSurveyMenu() {
		log.info("ClickOnMetersAndSurveyMenu  method starts here.........");
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(MetersAndSurveyMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		MetersAndSurveyMenu.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// CommonMethod.switchToDefaultContent();
		CommonMethod.switchToDataInputFrame();
		boolean MetersAndSurveyTab = MeterAndSurveyMiddleSection.isDisplayed();
		log.info("MetersAndSurveyTab flag is --" + MetersAndSurveyTab);
		CommonMethod.waitUntilLoadElement();
		if (MetersAndSurveyTab == true) {
			log.info("ClickOnMetersAndSurveyMenu  method ends here with true .........");
			return true;
		} else {
			log.info("ClickOnMetersAndSurveyMenu  method ends here with false.........");
			return false;
		}

	}

	public void ClickOnHE_OccupantSatisfactionSurvey() {
		log.info("ClickOnHE_OccupantSatisfactionSurvey  method starts here.........");
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			HE_ShowMore.click();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Show More text");
			// TODO: handle exception
		}
		waithelper.WaitForElementClickable(HE_Occupant_Satisfaction_Survey,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		HE_Occupant_Satisfaction_Survey.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementClickable(Transportation_SurveyToolsResource,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		log.info("ClickOnHE_OccupantSatisfactionSurvey  method ends here.........");
	}

	public void ClickOnHE_CarbonDioxide() {
		log.info("ClickOnHE_CarbonDioxide  method starts here.........");
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			HE_ShowMore.click();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Show More text");
			// TODO: handle exception
		}
		waithelper.WaitForElementClickable(HE_CarbonDioxide, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		HE_CarbonDioxide.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath(
						"(//div[@class='meterNameInfo--wrapper'])[2]/div[2][contains(text(),'Carbon Dioxide')]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickOnHE_CarbonDioxide  method ends here.........");
	}

	public void ClickOnHE_TVOC() {
		log.info("ClickOnHE_TVOC  method starts here.........");
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			HE_ShowMore.click();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Show More text");
			// TODO: handle exception
		}
		waithelper.WaitForElementClickable(HE_TVOC, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		HE_TVOC.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath(
				"(//div[@class='meterNameInfo--wrapper'])[2]/div[2][contains(text(),'Total Volatile Organic Compounds')]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickOnHE_TVOC  method ends here.........");
	}

	public void ClickOnHE_PM2_5() {
		log.info("ClickOnHE_PM2_5  method starts here.........");
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			HE_ShowMore.click();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Show More text");
			// TODO: handle exception
		}

		waithelper.WaitForElementClickable(HE_PM2_5, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		HE_PM2_5.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//*[contains(text(),'Atmospheric Particulate Matter (PM2.5)')])[3]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickOnHE_PM2_5  method ends here.........");
	}

	public void ClickOnHE_Ozone() {
		log.info("ClickOnHE_Ozone  method starts here.........");
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			HE_ShowMore.click();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Show More text");
			// TODO: handle exception
		}

		waithelper.WaitForElementClickable(HE_Ozone, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		HE_Ozone.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//*[contains(text(),'Ozone')])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickOnHE_Ozone  method ends here.........");
	}

	public void ClickOnHE_CarbonMonoxide() {
		log.info("ClickOnHE_CarbonMonoxide  method starts here.........");
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			HE_ShowMore.click();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Show More text");
			// TODO: handle exception
		}

		waithelper.WaitForElementClickable(HE_CarbonMonoOxide, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		HE_CarbonMonoOxide.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//*[contains(text(),'Carbon Monoxide')])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickOnHE_CarbonMonoxide  method ends here.........");
	}

	public void ClickOnHE_AcetalDehyde() {
		log.info("ClickOnHE_AcetalDehyde  method starts here.........");
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			HE_ShowMore.click();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Show More text");
			// TODO: handle exception
		}

		waithelper.WaitForElementClickable(HE_Acetaldehyde, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		HE_Acetaldehyde.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//*[contains(text(),'Acetaldehyde')])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickOnHE_AcetalDehyde  method ends here.........");
	}

	public void ClickOnHE_Benzene() {
		log.info("ClickOnHE_Benzene  method starts here.........");
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			HE_ShowMore.click();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Show More text");
			// TODO: handle exception
		}

		waithelper.WaitForElementClickable(HE_Benzene, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		HE_Benzene.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//*[contains(text(),'Benzene')])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickOnHE_Benzene  method ends here.........");
	}

	public void ClickOnHE_Styrene() {
		log.info("ClickOnHE_Styrene  method starts here.........");
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			HE_ShowMore.click();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Show More text");
			// TODO: handle exception
		}

		waithelper.WaitForElementClickable(HE_Styrene, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		HE_Styrene.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//*[contains(text(),'Styrene')])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickOnHE_Styrene  method ends here.........");
	}

	public void ClickOnHE_Toluene() {
		log.info("ClickOnHE_Toluene  method starts here.........");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			HE_ShowMore.click();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Show More text");
			// TODO: handle exception
		}

		waithelper.WaitForElementClickable(HE_Toluene, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		HE_Toluene.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//*[contains(text(),'Toluene')])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info("ClickOnHE_Toluene  method ends here.........");
	}

	public void ClickOnHE_Naphthalene() {
		log.info("ClickOnHE_Naphthalene  method starts here.........");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			HE_ShowMore.click();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Show More text");
			// TODO: handle exception
		}

		waithelper.WaitForElementClickable(HE_Naphthalene, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		HE_Naphthalene.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//*[contains(text(),'Naphthalene')])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickOnHE_Naphthalene  method ends here.........");
	}

	public void ClickOnHE_Dichlorobenzene() {
		log.info("ClickOnHE_Dichlorobenzene  method starts here.........");
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			HE_ShowMore.click();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Show More text");
			// TODO: handle exception
		}

		waithelper.WaitForElementClickable(HE_DichloroBenzene, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		HE_DichloroBenzene.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//*[contains(text(),'Dichlorobenzene')])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickOnHE_Dichlorobenzene  method ends here.........");
	}

	public void ClickOnHE_XyleneTotal() {
		log.info("ClickOnHE_XyleneTotal  method starts here.........");
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			HE_ShowMore.click();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Show More text");
			// TODO: handle exception
		}

		waithelper.WaitForElementClickable(HE_XylenesTotal, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		HE_XylenesTotal.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//*[contains(text(),'Xylenes-total')])[3]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickOnHE_XyleneTotal  method ends here.........");
	}

	public void ClickOnHE_Formaldehyde() {
		log.info("ClickOnHE_XyleneTotal  method starts here.........");
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			HE_ShowMore.click();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Show More text");
			// TODO: handle exception
		}

		waithelper.WaitForElementClickable(HE_FormalDehype, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		HE_FormalDehype.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//*[contains(text(),'Formaldehyde')])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickOnHE_XyleneTotal  method ends here.........");
	}

	public void ClickOnReEntry_FMS() {
		log.info("ClickOnReEntry_FMS  method starts here.........");
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ReEntry_ShowMore.click();
		waithelper.WaitForElementClickable(ReEntry_FMS, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ReEntry_FMS.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//*[contains(text(),'Facility Management Survey')])[3]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickOnReEntry_FMS  method ends here.........");
	}

	public void ClickOnReEntry_OccupantSurvey() {
		log.info("ClickOnReEntry_OccupantSurvey  method starts here.........");
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ReEntry_ShowMore.click();
		waithelper.WaitForElementClickable(ReEntry_OccupantSurvey, Integer.parseInt(prop.getProperty("explicitTime")),
				2);
		ReEntry_OccupantSurvey.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//h4[contains(text(),'Re-Entry Survey Responses')]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickOnReEntry_OccupantSurvey  method ends here.........");
	}

	public boolean ClickOnWaste_Data() {
		log.info("ClickOnWaste_Data  method starts here.........");
		boolean Waste_DataTab = false;
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Waste_Data.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/// CommonMethod.switchToDataInputFrame();
		boolean MetersAndSurveyTab = MeterAndSurveyMiddleSection.isDisplayed();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(
						By.xpath("(//div[@class='meterNameInfo--wrapper']/div[contains(text(),'Waste Data')])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Waste_DataTab = driver
				.findElement(By.xpath("(//div[@class='meterNameInfo--wrapper']/div[contains(text(),'Waste Data')])[2]"))
				.isDisplayed();
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("MetersAndSurveyTab flag is --" + MetersAndSurveyTab);
		log.info("Waste_DataTab flag is --" + Waste_DataTab);
		if (Waste_DataTab == true && MetersAndSurveyTab == true) {
			log.info("ClickOnWaste_Data  method ends here with true .........");
			return true;
		} else {
			log.info("ClickOnWaste_Data  method ends here with false.........");
			return false;
		}

	}

	public void ClickOnBuildingSetting_OperatingHoursTab() {
		log.info("ClickOnBuildingSetting_OperatingHoursTab  method starts here.........");
		BuildingSetting_OperatingHourTab.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickOnBuildingSetting_OperatingHoursTab  method ends here .........");
	}

	public void ClickOnBuildingSetting_GrossFloorAreaTab() {
		log.info("ClickOnBuildingSetting_GrossFloorAreaTab  method starts here.........");
		ngWebDriver.waitForAngularRequestsToFinish();
		BuildingSetting_GrossFloorAreaTab.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickOnBuildingSetting_GrossFloorAreaTab  method ends here .........");
	}

	public void ClickOnBuildingSetting_EmissionsFactorTab() {
		log.info("ClickOnBuildingSetting_EmissionsFactorTab  method starts here.........");
		ngWebDriver.waitForAngularRequestsToFinish();
		BuildingSetting_EmissionsFactorTab.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//label[contains(text(),'Use Standard Emissions Factor')]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickOnBuildingSetting_EmissionsFactorTab  method ends here .........");
	}

	public void ClickOnBuildingSetting_OperationalDaysTab() {
		log.info("ClickOnBuildingSetting_OperationalDaysTab  method starts here.........");
		ngWebDriver.waitForAngularRequestsToFinish();
		BuildingSetting_OperationalDaysTab.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickOnBuildingSetting_OperationalDaysTab  method ends here .........");
	}

	public void ClickOnBuildingSetting_OccupantTab() {
		log.info("ClickOnBuildingSetting_OccupantTab  method starts here.........");
		ngWebDriver.waitForAngularRequestsToFinish();
		BuildingSetting_OccupantsTab.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(BuildingSetting_AddOccupancyDataBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickOnBuildingSetting_OccupantTab  method ends here .........");
	}

	// --> Verify in Overview tab, Under Actions- clicking on 'Send A Survey' should
	// redirect to 'meters and surveys' and highlights up 'Transportation Survey'
	public boolean CheckSendASurvey() {
		log.info("CheckSendASurvey  method starts here.........");
		boolean TransportationSurevyTab = false;
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OverviewSendASurvey.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonMethod.switchToDefaultContent();
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

	// --> Verify in Overview tab, Under Actions- clicking on 'Update Apps to
	// collect data' should redirect to Manage--> 'Apps' .

	public boolean CheckUpdateAppsToCollectData() {
		log.info("CheckUpdateAppsToCollectData  method starts here.........");
		boolean AppsTab = false;
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OverviewUpdateAppsToCollectData.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonMethod.switchToDefaultContent();
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

	// --> Verify in Overview tab, Under Actions- clicking on 'Get Certified' should
	// redirect to Project Tools--> 'Leed Certification'
	public boolean CheckGetNotified() {
		log.info("CheckGetNotified  method starts here.........");
		boolean LEEDCertificationsTab = false;
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OverviewGetNotified.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonMethod.switchToDefaultContent();
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

	// --> Verify in Overview Tab, By default Top RHS dropdown should show 'Last 12
	// months'
	public boolean CheckRHS_ShowLast12Months() {
		log.info("CheckRHS_ShowLast12Months  method starts here.........");
		boolean RHS_Last12Months = false;
		// CommonMethod.switchToShowOverviewFrame();
		ngWebDriver.waitForAngularRequestsToFinish();
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

	// --> If Last 12 months is selected in dropdown- Under Scores and Metrics-->
	// Arc Scores should show date window as per the following- End Date- with
	// respect to the current date - last month end date || Start date- one year
	// prior to the end date.

	public boolean CheckRHS_Last12Months_DateRange() {
		log.info("CheckRHS_Last12Months_ARC_Score  method starts here.........");
		boolean RHS_Last12Months = false;
		boolean Arcs_Score_Date_Range_Flag = false;
		boolean Scope1_Scope2_Date_Range_Flag = false;
		boolean Transportation_Date_Range_Flag = false;
		boolean Occupant_Date_Range_Flag = false;
		ngWebDriver.waitForAngularRequestsToFinish();
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
		ngWebDriver.waitForAngularRequestsToFinish();
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
		JSHelper.scrollIntoView(Arcs_Score_Date_Range);
		String TempRange = Arcs_Score_Date_Range.getText();
		log.info("Arcs_Score_Date_Range showing is   " + TempRange);
		if (TempRange.equals(ExpDateRange)) {
			Arcs_Score_Date_Range_Flag = true;
			log.info("Arcs_Score_Date_Range_Flag is --" + Arcs_Score_Date_Range_Flag);
		}
		CommonMethod.switchToDefaultContent();
		CommonMethod.switchToAverageEmissionsFrame();
		JSHelper.scrollIntoView(Scope1_Scope2_Date_Range);
		TempRange = Scope1_Scope2_Date_Range.getText();
		log.info("Arcs_Score_Date_Range showing is   " + TempRange);
		if (TempRange.equals(ExpDateRange)) {
			Scope1_Scope2_Date_Range_Flag = true;
			log.info("Scope1_Scope2_Date_Range_Flag is --" + Scope1_Scope2_Date_Range_Flag);
		}
		CommonMethod.switchToDefaultContent();
		CommonMethod.switchToTransportationCategoryUsageFrame();
		JSHelper.scrollIntoView(Transportation_Date_Range);
		TempRange = Transportation_Date_Range.getText();
		log.info("Transportation_Date_Range showing is   " + TempRange);
		if (TempRange.equals(ExpDateRange)) {
			Transportation_Date_Range_Flag = true;
			log.info("Transportation_Date_Range_Flag is --" + Transportation_Date_Range_Flag);
		}
		CommonMethod.switchToDefaultContent();
		CommonMethod.switchToOccupantCategoryUsageFrame();
		JSHelper.scrollIntoView(Occupant_Date_Range);
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

	// --> If End of calendar is selected in dropdown- Under Scores and Metrics-->
	// Arc Scores should show date window as per the following- End Date- with
	// respect to the current date - last month end date || Start date- one year
	// prior to the end date.
	public boolean CheckRHS_EndOfCalender_DateRange() {
		log.info("CheckRHS_EndOfCalender_DateRange  method starts here.........");
		boolean RHS_EndOfCalender = false;
		boolean Arcs_Score_Date_Range_Flag = false;
		boolean Scope1_Scope2_Date_Range_Flag = false;
		boolean Transportation_Date_Range_Flag = false;
		boolean Occupant_Date_Range_Flag = false;
		ngWebDriver.waitForAngularRequestsToFinish();
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
				ngWebDriver.waitForAngularRequestsToFinish();
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
		ngWebDriver.waitForAngularRequestsToFinish();
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

	// --> If Custom Date Range is selected in dropdown- Under Scores and Metrics-->
	// Arc Scores should show date window as per the following- End Date- with
	// respect to the current date - last month end date || Start date- one year
	// prior to the end date.
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
		JSHelper.scrollIntoView(Arcs_Score_Date_Range);
		String TempRange = Arcs_Score_Date_Range.getText();
		log.info("Arcs_Score_Date_Range showing is   " + TempRange);
		if (TempRange.equals(ExpDateRange)) {
			Arcs_Score_Date_Range_Flag = true;
			log.info("Arcs_Score_Date_Range_Flag is --" + Arcs_Score_Date_Range_Flag);
		}
		CommonMethod.switchToDefaultContent();
		CommonMethod.switchToAverageEmissionsFrame();
		JSHelper.scrollIntoView(Scope1_Scope2_Date_Range);
		TempRange = Scope1_Scope2_Date_Range.getText();
		log.info("Scope1_Scope2_Date_Range showing is   " + TempRange);
		if (TempRange.equals(ExpDateRange)) {
			Scope1_Scope2_Date_Range_Flag = true;
			log.info("Scope1_Scope2_Date_Range_Flag is --" + Scope1_Scope2_Date_Range_Flag);
		}
		CommonMethod.switchToDefaultContent();
		CommonMethod.switchToTransportationCategoryUsageFrame();
		JSHelper.scrollIntoView(Transportation_Date_Range);
		TempRange = Transportation_Date_Range.getText();
		log.info("Transportation_Date_Range showing is   " + TempRange);
		if (TempRange.equals(ExpDateRange)) {
			Transportation_Date_Range_Flag = true;
			log.info("Transportation_Date_Range_Flag is --" + Transportation_Date_Range_Flag);
		}
		CommonMethod.switchToDefaultContent();
		CommonMethod.switchToOccupantCategoryUsageFrame();
		JSHelper.scrollIntoView(Occupant_Date_Range);
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

	// --> Verify in Arc Scores- Just above score- we have dropdown' Total' .
	// Selecting each category from that dropdown should allow to change the graph
	// with respect to the category selected.
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
		/*
		 * JSHelper.scrollIntoView(driver.findElement(By.
		 * xpath("//div[@class='unit drp unitdropitem']/span"))); try {
		 * Thread.sleep(2000); } catch (InterruptedException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */
		driver.findElement(By.xpath("//div[@class='unit drp unitdropitem']/span")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> TotalDrpopList = driver
				.findElements(By.xpath("//div[@class='unit drp unitdropitem']/div/div"));
		driver.findElement(By.xpath("//div[@class='unit drp unitdropitem']/span")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Total List items exists in Total Dropdown is  " + TotalDrpopList.size());
		for (WebElement ele : TotalDrpopList) {
			driver.findElement(By.xpath("//div[@class='unit drp unitdropitem']/span")).click();
			waithelper.WaitForElementClickable(ele, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			// driver.findElement(By.xpath("//*[@class='fa fa-angle-left']")).click();
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

	// --> Verify Current Arc Scores racetrack should be blank with 0 scores and
	// will show Project address at the bottom of the racetrack.
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
		JSHelper.scrollIntoView(RaceTrackScore);
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

	// Verify Current Arc Scores Top right corner has dropdown- 'Graphic' should
	// show Racetrack and 'Table view' should show Tabular view of each category.
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
				waithelper.WaitForElementClickable(driver.findElement(By.xpath("//div[@class='animation drp']/span")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
				driver.findElement(By.xpath("//div[@class='animation drp']/span")).click();

				waithelper.WaitForElementClickable(ele, Integer.parseInt(prop.getProperty("explicitTime")), 2);
				Thread.sleep(2000);
				// ele.click();
				JSHelper.clickElement(ele);
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

	// Verify 'LEED Pandemic Response Options'- clicking on Learn more link navgates
	// the user to -
	// "https://www.arcskoru.com/managing-occupancy-arc-leed-certification-during-covid-19"
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
		driver.switchTo().window(handle);
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

	// Verify Scope 1 and 2 emissions- graphs are blank with 0 MTCO2e.
	public boolean CheckScope1And2emissions_ZeroScore() {
		log.info("CheckScope1And2emissions_ZeroScore  method starts here.........");
		CommonMethod.switchToAverageEmissionsFrame();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSHelper.scrollIntoView(Overview_Scope1and2emissions_Score);
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

	// Verify Arc Improvement Scores show values for all performance categories-
	// 0/100
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

		JSHelper.scrollIntoView(driver.findElement(By
				.xpath("(//h4[text()='Arc Improvement Scores']/parent::div/div[@class='score_item'])[1]/div[1]/span")));
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

	// Verify Transportation GHG emissions graph are blank with 0 lbs.
	public boolean CheckTransportation_GHGEmission_ZeroScores() {
		log.info("CheckTransportation_GHGEmission_ZeroScores  method starts here.........");
		CommonMethod.switchToTransportationCategoryUsageFrame();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSHelper.scrollIntoView(Overview_Transportation_GHG_Emission_Score);
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

	// Verify in Overview Tab, RHS-- all partner apps show up with linear scrolling.
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

	// Verify Building Settings-->Operating hours tab-- clicking on 'Add Row' adds a
	// new line item.
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

	// Building Settings-->Operating Hours tab --> Verify Clicking on effective date
	// opens up calendar and allows to select dates successfully.
	public boolean BuildingSetting_SelectEffectiveDate() {
		log.info("BuildingSetting_SelectEffectiveDate  method starts here.........");
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
		String today = CommonMethod.getCurrentDayIn2Digit();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[1]/input")).click();
		String xpath = "//table[@class=' table-condensed']/tbody/tr/td[contains(@class,'" + today + " day" + "')]";
		driver.findElement(By.xpath(xpath)).click();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy");
		LocalDateTime now = LocalDateTime.now();
		String EffectiveDate = dtf.format(now); // Aug 01, 2020
		String EnteredEffectiveDate = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[1]/input"))
				.getAttribute("value");
		log.info("Selected Effective Date is  " + EnteredEffectiveDate + " and expected effective date is "
				+ EffectiveDate);
		if (EnteredEffectiveDate.equals(EffectiveDate)) {
			log.info("Actual and expected effective dates are macthing.  ");
			log.info("BuildingSetting_SelectEffectiveDate method ends here with true.........");
			return true;
		} else {
			log.info("Actual and expected effective dates are not macthing.  ");
			log.info("BuildingSetting_SelectEffectiveDate method ends here with false.........");
			return false;
		}

	}

	// Building Settings-->Gross Floor Area tab --> Verify Clicking on effective
	// date opens up calendar and allows to select dates successfully.
	public boolean BuildingSetting_GrossFloorArea_SelectEffectiveDate() {
		log.info("BuildingSetting_GrossFloorArea_SelectEffectiveDate  method starts here.........");
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
		String today = CommonMethod.getCurrentDayIn2Digit();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[1]/input")).click();
		String xpath = "//table[@class=' table-condensed']/tbody/tr/td[contains(@class,'" + today + " day" + "')]";
		driver.findElement(By.xpath(xpath)).click();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy");
		LocalDateTime now = LocalDateTime.now();
		String EffectiveDate = dtf.format(now); // Aug 01, 2020
		String EnteredEffectiveDate = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[1]/input"))
				.getAttribute("value");
		log.info("Selected Effective Date is  " + EnteredEffectiveDate + " and expected effective date is "
				+ EffectiveDate);
		if (EnteredEffectiveDate.equals(EffectiveDate)) {
			log.info("Actual and expected effective dates are macthing.  ");
			log.info("BuildingSetting_GrossFloorArea_SelectEffectiveDate method ends here with true.........");
			return true;
		} else {
			log.info("Actual and expected effective dates are not macthing.  ");
			log.info("BuildingSetting_GrossFloorArea_SelectEffectiveDate method ends here with false.........");
			return false;
		}

	}

	// Building Settings-->Occupant tab --> Verify Clicking on effective
	// date opens up calendar and allows to select dates successfully.
	public boolean BuildingSetting_Occupant_SelectEffectiveDate() {
		log.info("BuildingSetting_Occupant_SelectEffectiveDate  method starts here.........");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(BuildingSetting_AddOccupancyDataBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddOccupancyDataBtn.click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//div[text()='Effective date']/following-sibling::input")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BuildingSetting_Occupancy_EffectiveDate.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("(//div[@class='datepicker-days']/table/thead/tr/th[1])[1]")).click();
		String xpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]"; // selecting 1 from Previous
																							// month
		driver.findElement(By.xpath(xpath)).click();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy");
		LocalDateTime now = LocalDateTime.now();
		String EffectiveDate = dtf.format(now.minusMonths(1).withDayOfMonth(1)); // Aug 01, 2020
		String EnteredEffectiveDate = BuildingSetting_Occupancy_EffectiveDate.getAttribute("value");
		log.info("Selected Effective Date is  " + EnteredEffectiveDate + " and expected effective date is "
				+ EffectiveDate);
		BuildingSetting_AddOccupancy_CloseBtn.click();
		if (EnteredEffectiveDate.equals(EffectiveDate)) {
			log.info("Actual and expected effective dates are macthing.  ");
			log.info("BuildingSetting_Occupant_SelectEffectiveDate method ends here with true.........");
			return true;
		} else {
			log.info("Actual and expected effective dates are not macthing.  ");
			log.info("BuildingSetting_Occupant_SelectEffectiveDate method ends here with false.........");
			return false;
		}

	}

//  Building Settings-->Gross Floor Area tab-- -->Verify Gross Area field allows to add only numeric value.
	public boolean BuildingSetting_GrossAreaField_AllowNumericOnly() {
		log.info("BuildingSetting_GrossAreaField_AllowNumericOnly  method starts here.........");
		boolean AlphaFlag = false;
		boolean SpecialCharFlag = false;
		boolean NumericFlag = false;
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

		WebElement GroosArea = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"));
		GroosArea.sendKeys("Alphabets");
		String typedValue = GroosArea.getAttribute("value");
		int len = typedValue.length();
		if (len == 0) {
			AlphaFlag = true;
			log.info("Alphabets are not allowed..");
		} else {
			log.info("Alphabets are allowed..");
		}
		GroosArea.clear();
		GroosArea.sendKeys("!@#$%^&*()_+-=`~[]{}/|<>?");
		typedValue = GroosArea.getAttribute("value");
		len = typedValue.length();
		if (len == 0) {
			SpecialCharFlag = true;
			log.info("Special Character are not allowed..");
		} else {
			SpecialCharFlag = false;
			log.info("Special Character are allowed..");
		}

		GroosArea.clear();
		GroosArea.sendKeys("12345");
		typedValue = GroosArea.getAttribute("value");
		len = typedValue.length();
		if (len > 0) {
			NumericFlag = true;
			log.info("Numeric is allowed..");
		} else {
			log.info("Numeric is not allowed..");
		}

		if (AlphaFlag == true && SpecialCharFlag == true && NumericFlag == true) {
			log.info("Gross Area Text box allows only Numeric value....");
			log.info("BuildingSetting_GrossAreaField_AllowNumericOnly method ends here with true.........");
			return true;
		} else {
			log.info("Gross Area Text box allows other than Numeric value also....");
			log.info("BuildingSetting_GrossAreaField_AllowNumericOnly method ends here with false.........");
			return false;
		}

	}

	// Building Settings-->Occupant tab-- -->Verify Regular building occupants(daily
	// average) field by adding numeric value.
	public boolean BuildingSetting_Occupant_RegularBuildingField_AllowNumericOnly() {
		log.info("BuildingSetting_Occupant_RegularBuildingField_AllowNumericOnly  method starts here.........");
		boolean AlphaFlag = false;
		boolean SpecialCharFlag = false;
		boolean NumericFlag = false;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BuildingSetting_AddOccupancyDataBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//h4[@class='fw600']/span[text()='Add Occupancy']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// WebElement RegularBuildingOccupant =
		// driver.findElement(By.xpath("//div[text()='Regular building occupants (daily
		// average)']/following-sibling::input"));
		BuildingSetting_Occupancy_RegularBuildingOccupant.sendKeys("Alphabets");
		String typedValue = BuildingSetting_Occupancy_RegularBuildingOccupant.getAttribute("value");
		int len = typedValue.length();
		if (len == 0) {
			AlphaFlag = true;
			log.info("Alphabets are not allowed..");
		} else {
			log.info("Alphabets are allowed..");
		}
		BuildingSetting_Occupancy_RegularBuildingOccupant.clear();
		BuildingSetting_Occupancy_RegularBuildingOccupant.sendKeys("!@#$%^&*()_+-=`~[]{}/|<>?");
		typedValue = BuildingSetting_Occupancy_RegularBuildingOccupant.getAttribute("value");
		len = typedValue.length();
		if (len == 0) {
			SpecialCharFlag = true;
			log.info("Special Character are not allowed..");
		} else {
			SpecialCharFlag = false;
			log.info("Special Character are allowed..");
		}

		BuildingSetting_Occupancy_RegularBuildingOccupant.clear();
		BuildingSetting_Occupancy_RegularBuildingOccupant.sendKeys("12345");
		typedValue = BuildingSetting_Occupancy_RegularBuildingOccupant.getAttribute("value");
		len = typedValue.length();
		if (len > 0) {
			NumericFlag = true;
			log.info("Numeric is allowed..");
		} else {
			log.info("Numeric is not allowed..");
		}
		BuildingSetting_AddOccupancy_CloseBtn.click();
		if (AlphaFlag == true && SpecialCharFlag == true && NumericFlag == true) {
			log.info("Regular building occupants (daily average) allows only Numeric value....");
			log.info(
					"BuildingSetting_Occupant_RegularBuildingField_AllowNumericOnly method ends here with true.........");
			return true;
		} else {
			log.info("Regular building occupants (daily average) allows other than Numeric value also....");
			log.info(
					"BuildingSetting_Occupant_RegularBuildingField_AllowNumericOnly method ends here with false.........");
			return false;
		}

	}

	// Building Settings-->Occupant tab-- -->Verify Days per week with visitors
	// field by adding numeric value.
	public boolean BuildingSetting_Occupant_DaysPerWeekWithVisitorField() {
		log.info("BuildingSetting_Occupant_DaysPerWeekWithVisitorField  method starts here.........");
		boolean AlphaFlag = false;
		boolean SpecialCharFlag = false;
		boolean NumericFlag = false;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BuildingSetting_AddOccupancyDataBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//h4[@class='fw600']/span[text()='Add Occupancy']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// WebElement DaysPerWeekWithVisitorst =
		// driver.findElement(By.xpath("//div[text()='Days per week with
		// visitors']/following-sibling::input"));
		BuildingSetting_Occupancy_DaysPerWeekWithVisitors.sendKeys("Alphabets");
		String typedValue = BuildingSetting_Occupancy_DaysPerWeekWithVisitors.getAttribute("value");
		int len = typedValue.length();
		if (len == 0) {
			AlphaFlag = true;
			log.info("Alphabets are not allowed..");
		} else {
			log.info("Alphabets are allowed..");
		}
		BuildingSetting_Occupancy_DaysPerWeekWithVisitors.clear();
		BuildingSetting_Occupancy_DaysPerWeekWithVisitors.sendKeys("!@#$%^&*()_+-=`~[]{}/|<>?");
		typedValue = BuildingSetting_Occupancy_DaysPerWeekWithVisitors.getAttribute("value");
		len = typedValue.length();
		if (len == 0) {
			SpecialCharFlag = true;
			log.info("Special Character are not allowed..");
		} else {
			SpecialCharFlag = false;
			log.info("Special Character are allowed..");
		}

		BuildingSetting_Occupancy_DaysPerWeekWithVisitors.clear();
		BuildingSetting_Occupancy_DaysPerWeekWithVisitors.sendKeys("12345");
		typedValue = BuildingSetting_Occupancy_DaysPerWeekWithVisitors.getAttribute("value");
		len = typedValue.length();
		if (len > 0) {
			NumericFlag = true;
			log.info("Numeric is allowed..");
		} else {
			log.info("Numeric is not allowed..");
		}
		BuildingSetting_AddOccupancy_CloseBtn.click();
		if (AlphaFlag == true && SpecialCharFlag == true && NumericFlag == true) {
			log.info("Days per week with visitors field allows only Numeric value....");
			log.info("BuildingSetting_Occupant_DaysPerWeekWithVisitorField method ends here with true.........");
			return true;
		} else {
			log.info("Days per week with visitors field allows other than Numeric value also....");
			log.info("BuildingSetting_Occupant_DaysPerWeekWithVisitorField method ends here with false.........");
			return false;
		}

	}

	// Building Settings-->Occupant tab-- -->Verify 'Number of visitors each day'
	// field by adding numeric value.
	public boolean BuildingSetting_Occupant_NoOfVisitorEachDayField() {
		log.info("BuildingSetting_Occupant_NoOfVisitorEachDayField  method starts here.........");
		boolean AlphaFlag = false;
		boolean SpecialCharFlag = false;
		boolean NumericFlag = false;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BuildingSetting_AddOccupancyDataBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//h4[@class='fw600']/span[text()='Add Occupancy']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// WebElement NoOfVisitorsEachDay =
		// driver.findElement(By.xpath("//div[text()='Number of visitors each
		// day']/following-sibling::input"));
		BuildingSetting_Occupancy_NoOfVisitorsEachDay.sendKeys("Alphabets");
		String typedValue = BuildingSetting_Occupancy_NoOfVisitorsEachDay.getAttribute("value");
		int len = typedValue.length();
		if (len == 0) {
			AlphaFlag = true;
			log.info("Alphabets are not allowed..");
		} else {
			log.info("Alphabets are allowed..");
		}
		BuildingSetting_Occupancy_NoOfVisitorsEachDay.clear();
		BuildingSetting_Occupancy_NoOfVisitorsEachDay.sendKeys("!@#$%^&*()_+-=`~[]{}/|<>?");
		typedValue = BuildingSetting_Occupancy_NoOfVisitorsEachDay.getAttribute("value");
		len = typedValue.length();
		if (len == 0) {
			SpecialCharFlag = true;
			log.info("Special Character are not allowed..");
		} else {
			SpecialCharFlag = false;
			log.info("Special Character are allowed..");
		}

		BuildingSetting_Occupancy_NoOfVisitorsEachDay.clear();
		BuildingSetting_Occupancy_NoOfVisitorsEachDay.sendKeys("12345");
		typedValue = BuildingSetting_Occupancy_NoOfVisitorsEachDay.getAttribute("value");
		len = typedValue.length();
		if (len > 0) {
			NumericFlag = true;
			log.info("Numeric is allowed..");
		} else {
			log.info("Numeric is not allowed..");
		}
		BuildingSetting_AddOccupancy_CloseBtn.click();
		if (AlphaFlag == true && SpecialCharFlag == true && NumericFlag == true) {
			log.info("Number of visitors each day field allows only Numeric value....");
			log.info("BuildingSetting_Occupant_NoOfVisitorEachDayField method ends here with true.........");
			return true;
		} else {
			log.info("Number of visitors each day field allows other than Numeric value also....");
			log.info("BuildingSetting_Occupant_NoOfVisitorEachDayField method ends here with false.........");
			return false;
		}

	}

	// Building Settings-->Occupant tab-- -->Verify 'Duration of visit(in hours/day)
	// field by adding numeric value in hours:minutes format or by selecting hrs/min
	// using drop down.
	public boolean BuildingSetting_Occupant_SelectDurationOfVisit() {
		log.info("BuildingSetting_Occupant_SelectDurationOfVisit  method starts here.........");
		boolean HourIncrement = false;
		boolean HourDecrement = false;
		boolean MinuteIncrement = false;
		boolean MinuteDecrement = false;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BuildingSetting_AddOccupancyDataBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//h4[@class='fw600']/span[text()='Add Occupancy']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// WebElement DurationOfVisit =
		// driver.findElement(By.xpath("//div[text()='Duration of visit (in
		// hours/day)']/following-sibling::input"));

		BuildingSetting_Occupancy_DurationOfVisit.click();
		String[] Duration = BuildingSetting_Occupancy_DurationOfVisit.getAttribute("value").split(":");
		String TextBoxhours = Duration[0];
		String TextBoxminutes = Duration[1];
		log.info("Hours is " + TextBoxhours + " and Minutes is " + TextBoxminutes);
		BuildingSetting_Occupancy_NoOfVisitorsEachDay.click();

		BuildingSetting_Occupancy_DurationOfVisit.click();

		BuildingSetting_Occupancy_HoursIncrement.click();
		Duration = BuildingSetting_Occupancy_DurationOfVisit.getAttribute("value").split(":");
		TextBoxhours = Duration[0];
		TextBoxminutes = Duration[1];

		String DropDownHours = BuildingSetting_Occupancy_HoursDropDown.getText();
		String DropDownMinutes = BuildingSetting_Occupancy_MinutesDropDown.getText();

		BuildingSetting_Occupancy_NoOfVisitorsEachDay.click();

		if (TextBoxhours.equals(DropDownHours) && TextBoxminutes.equals(DropDownMinutes)) {
			log.info("Hours Increment is working fine..");
			HourIncrement = true;
		} else {
			log.info("Hours Increment is not working ..");
		}

		BuildingSetting_Occupancy_DurationOfVisit.click();
		BuildingSetting_Occupancy_HoursDecrement.click();
		Duration = BuildingSetting_Occupancy_DurationOfVisit.getAttribute("value").split(":");
		TextBoxhours = Duration[0];
		TextBoxminutes = Duration[1];

		DropDownHours = BuildingSetting_Occupancy_HoursDropDown.getText();
		DropDownMinutes = BuildingSetting_Occupancy_MinutesDropDown.getText();
		BuildingSetting_Occupancy_NoOfVisitorsEachDay.click();
		if (TextBoxhours.equals(DropDownHours) && TextBoxminutes.equals(DropDownMinutes)) {
			log.info("Hours Decrement is working fine..");
			HourDecrement = true;
		} else {
			log.info("Hours Decrement is not working ..");
		}
		BuildingSetting_Occupancy_DurationOfVisit.click();
		BuildingSetting_Occupancy_MinutesIncrement.click();
		Duration = BuildingSetting_Occupancy_DurationOfVisit.getAttribute("value").split(":");
		TextBoxhours = Duration[0];
		TextBoxminutes = Duration[1];

		DropDownHours = BuildingSetting_Occupancy_HoursDropDown.getText();
		DropDownMinutes = BuildingSetting_Occupancy_MinutesDropDown.getText();
		BuildingSetting_Occupancy_NoOfVisitorsEachDay.click();
		if (TextBoxhours.equals(DropDownHours) && TextBoxminutes.equals(DropDownMinutes)) {
			log.info("Minutes Increment is working fine..");
			MinuteIncrement = true;
		} else {
			log.info("Minutes Increment is not working ..");
		}
		BuildingSetting_Occupancy_DurationOfVisit.click();
		BuildingSetting_Occupancy_MinutesDecrement.click();
		Duration = BuildingSetting_Occupancy_DurationOfVisit.getAttribute("value").split(":");
		TextBoxhours = Duration[0];
		TextBoxminutes = Duration[1];

		DropDownHours = BuildingSetting_Occupancy_HoursDropDown.getText();
		DropDownMinutes = BuildingSetting_Occupancy_MinutesDropDown.getText();
		BuildingSetting_Occupancy_NoOfVisitorsEachDay.click();
		if (TextBoxhours.equals(DropDownHours) && TextBoxminutes.equals(DropDownMinutes)) {
			log.info("Minutes Decrement is working fine..");
			MinuteDecrement = true;
		} else {
			log.info("Minutes Decrement is not working ..");
		}
		if ((HourIncrement) && (HourDecrement) && (MinuteIncrement) && (MinuteDecrement)) {
			log.info("Hours and Minutes with Increment and Decrement are working fine...");
			log.info("BuildingSetting_Occupant_SelectDurationOfVisit method ends here with true.........");
			return true;
		} else {
			log.info("Hours and Minutes with Increment and Decrement are not working fine...");
			log.info("BuildingSetting_Occupant_SelectDurationOfVisit method ends here with false.........");
			return false;
		}

	}

	// Building Settings-->Occupant tab-- -->Validate Weekly operating hours shows
	// the hrs entered in 'Operating hrs' field.
	public boolean BuildingSetting_Occupant_CheckWeeklyOperatingHours() {
		log.info("BuildingSetting_Occupant_CheckWeeklyOperatingHours  method starts here.........");
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

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[1]/input")).click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting 1st day of previous month
		driver.findElement(By.xpath("//div[@class='dropdown display-inline ml10 cursor-pointer']/button")).click();
		String ExpHours = data.getCellData("Building", 0, 2);
		String HourXpath = "//div[@class='dropdown display-inline ml10 cursor-pointer open']/ul/li/a[text()='"
				+ ExpHours + "']";
		driver.findElement(By.xpath(HourXpath)).click();

		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By
							.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/*[@class='fade-out saved_symbol']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			waithelper.WaitForElementInvisible(
					driver.findElement(By
							.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/*[@class='fade-out saved_symbol']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		List<WebElement> ListOfRows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		log.info("Total number of rows are ..." + ListOfRows.size());

		ClickOnBuildingSetting_OccupantTab();

		BuildingSetting_AddOccupancyDataBtn.click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//div[text()='Effective date']/following-sibling::input")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BuildingSetting_Occupancy_EffectiveDate.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("(//div[@class='datepicker-days']/table/thead/tr/th[1])[1]")).click();
		String xpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]"; // selecting 1 from Previous
																							// month
		driver.findElement(By.xpath(xpath)).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//div[@class='fw600 mb10']/following-sibling::span[text()='Edit']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		String[] hh = ExpHours.split("\\s+");
		int Exphour = Integer.parseInt(hh[0]);

		int ActHour = Integer.parseInt(BuildingSetting_Occupancy_WeeklyOperatingHours.getText());
		if (Exphour == ActHour) {
			log.info("Hour is showing according to Operating Hours Tab..");
			log.info("BuildingSetting_Occupant_CheckWeeklyOperatingHours  method ends here with true.........");
			return true;

		} else {
			log.info("Hour is not showing according to Operating Hours Tab..");
			log.info("BuildingSetting_Occupant_CheckWeeklyOperatingHours  method ends here with false.........");
			return false;
		}

	}

	// Building Settings-->Occupant tab-- -->Validate 'Add Occupany window' visitors
	// are calculated based on the calculation-
	// (Days per week with visitors* no of visitors each day *duration of
	// visit)/operating hours
	public boolean BuildingSetting_Occupant_CheckVisitorsDailyAverage() {
		log.info("BuildingSetting_Occupant_CheckVisitorsDailyAverage  method starts here.........");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BuildingSetting_AddOccupancyDataBtn.click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//div[text()='Effective date']/following-sibling::input")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BuildingSetting_Occupancy_EffectiveDate.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("(//div[@class='datepicker-days']/table/thead/tr/th[1])[1]")).click();
		String xpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]"; // selecting 1 from Previous
																							// month
		driver.findElement(By.xpath(xpath)).click();
		// int RegularBuildingOccupant=Integer.parseInt(data.getCellData("Building", 0,
		// 3));
		int DaysPerWeekWithVisitors = Integer.parseInt(data.getCellData("Building", 4, 2));
		int NoOfVisitorsEachDay = Integer.parseInt(data.getCellData("Building", 5, 2));
		BuildingSetting_Occupancy_RegularBuildingOccupant.sendKeys(data.getCellData("Building", 3, 2));
		BuildingSetting_Occupancy_DaysPerWeekWithVisitors.sendKeys(Integer.toString(DaysPerWeekWithVisitors));
		BuildingSetting_Occupancy_NoOfVisitorsEachDay.sendKeys(Integer.toString(NoOfVisitorsEachDay));

		BuildingSetting_Occupancy_DurationOfVisit.click();
		BuildingSetting_Occupancy_MinutesDecrement.click();
		BuildingSetting_Occupancy_DaysPerWeekWithVisitors.click();
		BuildingSetting_Occupancy_RegularBuildingOccupant.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BuildingSetting_Occupancy_DurationOfVisit.click();
		BuildingSetting_Occupancy_MinutesDecrement.click();
		BuildingSetting_Occupancy_DaysPerWeekWithVisitors.click();
		BuildingSetting_Occupancy_RegularBuildingOccupant.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BuildingSetting_Occupancy_DurationOfVisit.click();
		BuildingSetting_Occupancy_HoursIncrement.click();
		BuildingSetting_Occupancy_DaysPerWeekWithVisitors.click();
		BuildingSetting_Occupancy_RegularBuildingOccupant.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSHelper.scrollIntoView(BuildingSetting_Occupancy_VisitorsDailyAVG);
		String[] Duration = BuildingSetting_Occupancy_DurationOfVisit.getAttribute("value").split(":");
		int TextBoxhours = Integer.parseInt(Duration[0]);
		double TextBoxminutes = Integer.parseInt(Duration[1]);
		TextBoxminutes = TextBoxminutes / 60.0;
		float DurationOfVisit = (float) (TextBoxhours + TextBoxminutes);
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//div[@class='fw600 mb10']/following-sibling::span[text()='Edit']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		int WeeklyOperatingHours = Integer.parseInt(BuildingSetting_Occupancy_WeeklyOperatingHours.getText());

		int ExpVisitorsDailyAverage = Math
				.round((DaysPerWeekWithVisitors * NoOfVisitorsEachDay * DurationOfVisit) / WeeklyOperatingHours);
		int ActVisitorsDailyAverage = Integer.parseInt(BuildingSetting_Occupancy_VisitorsDailyAVG.getText());
		log.info("Actual VisitorsDailyAverage showing is --" + ActVisitorsDailyAverage
				+ " and expected VisitorsDailyAverage is  --" + ExpVisitorsDailyAverage);
		if (ActVisitorsDailyAverage == ExpVisitorsDailyAverage) {
			log.info("BuildingSetting_Occupant_CheckVisitorsDailyAverage  method ends here with true.........");
			return true;

		} else {
			log.info("BuildingSetting_Occupant_CheckVisitorsDailyAverage  method ends here with false.........");
			return false;
		}

	}

	// Building Settings-->Occupant tab-- -->Validate total daily occupancy is sum
	// of Visitors and Regular building occupants.
	public boolean BuildingSetting_Occupant_CheckTotalDailyOccupancy() {
		log.info("BuildingSetting_Occupant_CheckTotalDailyOccupancy  method starts here.........");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BuildingSetting_AddOccupancyDataBtn.click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//div[text()='Effective date']/following-sibling::input")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BuildingSetting_Occupancy_EffectiveDate.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("(//div[@class='datepicker-days']/table/thead/tr/th[1])[1]")).click();
		String xpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]"; // selecting 1 from Previous
																							// month
		driver.findElement(By.xpath(xpath)).click();
		int RegularBuildingOccupant = Integer.parseInt(data.getCellData("Building", 3, 2));
		int DaysPerWeekWithVisitors = Integer.parseInt(data.getCellData("Building", 4, 2));
		int NoOfVisitorsEachDay = Integer.parseInt(data.getCellData("Building", 5, 2));
		BuildingSetting_Occupancy_RegularBuildingOccupant.sendKeys(Integer.toString(RegularBuildingOccupant));
		BuildingSetting_Occupancy_DaysPerWeekWithVisitors.sendKeys(Integer.toString(DaysPerWeekWithVisitors));
		BuildingSetting_Occupancy_NoOfVisitorsEachDay.sendKeys(Integer.toString(NoOfVisitorsEachDay));

		BuildingSetting_Occupancy_DurationOfVisit.click();
		BuildingSetting_Occupancy_MinutesDecrement.click();
		BuildingSetting_Occupancy_DaysPerWeekWithVisitors.click();
		BuildingSetting_Occupancy_RegularBuildingOccupant.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BuildingSetting_Occupancy_DurationOfVisit.click();
		BuildingSetting_Occupancy_MinutesDecrement.click();
		BuildingSetting_Occupancy_DaysPerWeekWithVisitors.click();
		BuildingSetting_Occupancy_RegularBuildingOccupant.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BuildingSetting_Occupancy_DurationOfVisit.click();
		BuildingSetting_Occupancy_HoursIncrement.click();
		BuildingSetting_Occupancy_DaysPerWeekWithVisitors.click();
		BuildingSetting_Occupancy_RegularBuildingOccupant.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//div[@class='fw600 mb10']/following-sibling::span[text()='Edit']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.scrollIntoView(BuildingSetting_Occupancy_VisitorsDailyAVG);
		int VisitorsDailyAverage = Integer.parseInt(BuildingSetting_Occupancy_VisitorsDailyAVG.getText());

		int ExpTotalDailyOccupancy = VisitorsDailyAverage + RegularBuildingOccupant;
		int ActTotalDailyOccupancy = Integer.parseInt(BuildingSetting_Occupancy_TotalDailyOccupancy.getText());
		log.info("Actual TotalDailyOccupancy showing is --" + ActTotalDailyOccupancy
				+ " and expected TotalDailyOccupancy is  --" + ExpTotalDailyOccupancy);
		if (ExpTotalDailyOccupancy == ActTotalDailyOccupancy) {
			log.info("BuildingSetting_Occupant_CheckTotalDailyOccupancy  method ends here with true.........");
			return true;

		} else {
			log.info("BuildingSetting_Occupant_CheckTotalDailyOccupancy  method ends here with false.........");
			return false;
		}

	}

	// Building Settings-->Occupant tab-- --> Add one record with Effective Date,
	// Regular Building Occupants, Days per week with Visitors, No. of Visitors each
	// day, and Duration of Visit
	public boolean BuildingSetting_Occupant_AddOneRecord() {
		log.info("BuildingSetting_Occupant_AddOneRecord  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BuildingSetting_AddOccupancyDataBtn.click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//div[text()='Effective date']/following-sibling::input")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BuildingSetting_Occupancy_EffectiveDate.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("(//div[@class='datepicker-days']/table/thead/tr/th[1])[1]")).click();
		String xpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]"; // selecting 1 from Previous
																							// month
		driver.findElement(By.xpath(xpath)).click();
		int RegularBuildingOccupant = Integer.parseInt(data.getCellData("Building", 3, 2));
		int DaysPerWeekWithVisitors = Integer.parseInt(data.getCellData("Building", 4, 2));
		int NoOfVisitorsEachDay = Integer.parseInt(data.getCellData("Building", 5, 2));
		BuildingSetting_Occupancy_RegularBuildingOccupant.sendKeys(Integer.toString(RegularBuildingOccupant));
		BuildingSetting_Occupancy_DaysPerWeekWithVisitors.sendKeys(Integer.toString(DaysPerWeekWithVisitors));
		BuildingSetting_Occupancy_NoOfVisitorsEachDay.sendKeys(Integer.toString(NoOfVisitorsEachDay));

		BuildingSetting_Occupancy_DurationOfVisit.click();
		BuildingSetting_Occupancy_MinutesDecrement.click();
		BuildingSetting_Occupancy_DaysPerWeekWithVisitors.click();
		BuildingSetting_Occupancy_RegularBuildingOccupant.click();

		BuildingSetting_Occupancy_DurationOfVisit.click();
		BuildingSetting_Occupancy_MinutesDecrement.click();
		BuildingSetting_Occupancy_DaysPerWeekWithVisitors.click();
		BuildingSetting_Occupancy_RegularBuildingOccupant.click();

		BuildingSetting_Occupancy_DurationOfVisit.click();
		BuildingSetting_Occupancy_HoursIncrement.click();
		BuildingSetting_Occupancy_DaysPerWeekWithVisitors.click();
		BuildingSetting_Occupancy_RegularBuildingOccupant.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//div[@class='fw600 mb10']/following-sibling::span[text()='Edit']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		// JSHelper.scrollIntoView(BuildingSetting_Occupancy_VisitorsDailyAVG);

		BuildingSetting_AddOccupancy_ADDBtn.click();

		waithelper.WaitForElementInvisible(
				driver.findElement(By.xpath(
						"//div[@class='openOccupancyModal modal fade in']/descendant::span[text()='ADDING...']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		flag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[8]/span")).isDisplayed();

		if (flag) {
			log.info("BuildingSetting_Occupant_AddOneRecord  method ends here with true.........");
			return true;

		} else {
			log.info("BuildingSetting_Occupant_AddOneRecord  method ends here with false.........");
			return false;
		}

	}

	// Building Settings-->Occupant tab-- -->Verify 'Days per week with visitors'
	// has a limit to not allow value greater than 7.
	public boolean BuildingSetting_Occupant_DaysPerWeekWithVisitor_NotAllowMoreThan7() {
		log.info("BuildingSetting_Occupant_DaysPerWeekWithVisitor_NotAllowMoreThan7  method starts here.........");
		boolean ValidationMsg = false;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BuildingSetting_AddOccupancyDataBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//h4[@class='fw600']/span[text()='Add Occupancy']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BuildingSetting_Occupancy_EffectiveDate.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("(//div[@class='datepicker-days']/table/thead/tr/th[1])[1]")).click();
		String xpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]"; // selecting 1 from Previous
																							// month
		driver.findElement(By.xpath(xpath)).click();

		String RegularOccupant = data.getCellData("Building", 3, 2);
		BuildingSetting_Occupancy_RegularBuildingOccupant.sendKeys(RegularOccupant);

		BuildingSetting_Occupancy_DaysPerWeekWithVisitors.sendKeys("8");

		BuildingSetting_AddOccupancy_ADDBtn.click();

		ValidationMsg = driver.findElement(By.xpath(
				"//div[text()='Days per week with visitors']/following-sibling::p[text()='Enter days (Max: 7)']"))
				.isDisplayed();

		BuildingSetting_AddOccupancy_CloseBtn.click();
		if (ValidationMsg == true) {
			log.info(
					"BuildingSetting_Occupant_DaysPerWeekWithVisitor_NotAllowMoreThan7 method ends here with true.........");
			return true;
		} else {
			log.info(
					"BuildingSetting_Occupant_DaysPerWeekWithVisitor_NotAllowMoreThan7 method ends here with false.........");
			return false;
		}

	}

	// Verify Operating hours field by selecting hours from the dropdown.
	public boolean BuildingSetting_SelectOperatingHours() {
		log.info("BuildingSetting_SelectOperatingHours  method starts here.........");
		boolean HourSelectionflag = false;
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

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[1]/input")).click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]"; // Selecting 1st day of
																								// Previous Month
		driver.findElement(By.xpath(CalXpath)).click();
		/*
		 * String today = CommonMethod.getCurrentDayIn2Digit();
		 * driver.findElement(By.xpath(
		 * "//table[@id='readingsTable']/tbody/tr/td[1]/input")).click(); String xpath =
		 * "//table[@class=' table-condensed']/tbody/tr/td[contains(@class,'" + today +
		 * " day" + "')]"; driver.findElement(By.xpath(xpath)).click();
		 */
		driver.findElement(By.xpath("//div[@class='dropdown display-inline ml10 cursor-pointer']/button")).click();
		List<WebElement> HoursList = driver
				.findElements(By.xpath("//div[@class='dropdown display-inline ml10 cursor-pointer open']/ul/li/a"));
		log.info("Total Number of items present in Hours dropdown is  " + HoursList.size());
		String ExpHours = data.getCellData("Building", 0, 2);
		for (WebElement ele : HoursList) {
			String HoursText = ele.getAttribute("innerHTML");
			log.info("Current Hours is " + HoursText);
			if (HoursText.equals(ExpHours)) {
				ele.click();
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath(
								"//table[@id='readingsTable']/tbody/tr[1]/td[5]/*[@class='fade-out saved_symbol']")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
				try {
					waithelper.WaitForElementInvisible(driver.findElement(By
							.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/*[@class='fade-out saved_symbol']")),
							Integer.parseInt(prop.getProperty("explicitTime")), 1);
				} catch (Exception e) {
					e.printStackTrace();
				}
				log.info("Operating Hour selected successfully....");
				HourSelectionflag = true;
				break;
			}
		}
		if ((HourSelectionflag)) {
			// log.info("Hours is selected and document is uploaded successfully... ");
			log.info("BuildingSetting_SelectOperatingHours method ends here with true.........");
			return true;
		} else {
			// log.info("Unable to select Hours... ");
			log.info("BuildingSetting_SelectOperatingHours method ends here with false.........");
			return false;
		}

	}

	// Building Settings-->Operating hours tab - >verify delete button allows you to
	// delete line item.
	public boolean BuildingSetting_Ohours_CheckDelete() {
		log.info("BuildingSetting_Ohours_CheckDelete  method starts here.........");
		boolean RowsAddedFlag = false;
		boolean DeleteFlag = false;
		List<WebElement> ListOfRows;
		int i;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (i = 1; i < 3; i++) {
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

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[1]/input")).click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@class=' table-condensed']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
			String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='" + i + "'])[1]";
			driver.findElement(By.xpath(CalXpath)).click();
			int hour = i + 1;
			driver.findElement(By.xpath("//div[@class='dropdown display-inline ml10 cursor-pointer']/button")).click();
			String HourXpath = "//div[@class='dropdown display-inline ml10 cursor-pointer open']/ul/li/a[text()='"
					+ hour + " Hours']";
			driver.findElement(By.xpath(HourXpath)).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By
							.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/*[@class='fade-out saved_symbol']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@id='readingsTable']/tbody/tr[1]/td[5]/*[@class='fade-out saved_symbol']")),
						Integer.parseInt(prop.getProperty("explicitTime")), 1);
			} catch (Exception e) {
				e.printStackTrace();
			}

			ListOfRows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			log.info("Total number of rows are ..." + ListOfRows.size());
			if (i == ListOfRows.size()) {
				RowsAddedFlag = true;
			} else {
				RowsAddedFlag = false;
				break;
			}

		}
		if (RowsAddedFlag) {
			log.info("All rows are added successfully..");
			ListOfRows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			int BeforeDelete_RowCount = ListOfRows.size();
			log.info("Before deleting Total number of rows are ..." + BeforeDelete_RowCount);

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/span")).click();
			try {
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			ListOfRows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			int AfterDelete_RowCount = ListOfRows.size();
			log.info("After deleting Total number of rows are ..." + AfterDelete_RowCount);
			if (BeforeDelete_RowCount - AfterDelete_RowCount == 1) {
				log.info("Row deleted successfully...");
				DeleteFlag = true;
			} else {
				log.info("Row is not deleted successfully...");
				DeleteFlag = false;
			}
		}

		else {
			log.info("Row is not added successfully..");
			log.info("BuildingSetting_Ohours_CheckDelete method ends with false here.........");
			return false;

		}
		if (DeleteFlag) {
			log.info("BuildingSetting_Ohours_CheckDelete method ends with true here.........");
			return true;
		} else {
			log.info("BuildingSetting_Ohours_CheckDelete method ends with false here.........");
			return false;
		}

	}

	// Building Settings-->Gross Floor Area tab - >verify delete button allows you
	// to delete line item.
	public boolean BuildingSetting_GrossFloor_CheckDelete() {
		log.info("BuildingSetting_GrossFloor_CheckDelete  method starts here.........");
		boolean DeleteFlag = false;
		List<WebElement> ListOfRows;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ListOfRows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int BeforeDelete_RowCount = ListOfRows.size();
		log.info("Before deleting Total number of rows are ..." + BeforeDelete_RowCount);
		if (BeforeDelete_RowCount > 1) {

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[7]/span")).click();
			try {
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[7]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[7]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			ListOfRows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			int AfterDelete_RowCount = ListOfRows.size();
			log.info("After deleting Total number of rows are ..." + AfterDelete_RowCount);
			if (BeforeDelete_RowCount - AfterDelete_RowCount == 1) {
				log.info("Row deleted successfully...");
				DeleteFlag = true;
			} else {
				log.info("Row is not deleted successfully...");
				DeleteFlag = false;
			}
		}

		else {
			log.info("There is only one row, can not delete..");
			log.info("BuildingSetting_GrossFloor_CheckDelete method ends with false here.........");
			return false;

		}
		if (DeleteFlag) {
			log.info("BuildingSetting_GrossFloor_CheckDelete method ends with true here.........");
			return true;
		} else {
			log.info("BuildingSetting_GrossFloor_CheckDelete method ends with false here.........");
			return false;
		}

	}

	// Building Settings-->Operating hours tab - >Verify filter and reset
	// functionalities.
	public boolean BuildingSetting_CheckFilterAndReset() {
		log.info("BuildingSetting_CheckFilterAndReset  method starts here.........");
		boolean RowsAddedFlag = false;
		boolean FilterFlag = false;
		boolean Resetflag = false;
		int i;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (i = 1; i < 5; i++) {
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

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[1]/input")).click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@class=' table-condensed']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
			String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='" + i + "'])[1]";
			driver.findElement(By.xpath(CalXpath)).click();
			int hour = i + 1;
			driver.findElement(By.xpath("//div[@class='dropdown display-inline ml10 cursor-pointer']/button")).click();
			String HourXpath = "//div[@class='dropdown display-inline ml10 cursor-pointer open']/ul/li/a[text()='"
					+ hour + " Hours']";
			driver.findElement(By.xpath(HourXpath)).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By
							.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/*[@class='fade-out saved_symbol']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@id='readingsTable']/tbody/tr[1]/td[5]/*[@class='fade-out saved_symbol']")),
						Integer.parseInt(prop.getProperty("explicitTime")), 1);
			} catch (Exception e) {
				e.printStackTrace();
			}

			List<WebElement> ListOfRows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			log.info("Total number of rows are ..." + ListOfRows.size());
			if (i == ListOfRows.size()) {
				RowsAddedFlag = true;
			} else {
				RowsAddedFlag = false;
				break;
			}

		}
		if (RowsAddedFlag) {
			log.info("All rows are added successfully..");

			/*
			 * ClickOnWaste_Data(); ClickOnBuildingSetting();
			 * ClickOnBuildingSetting_OperatingHoursTab();
			 */
			ClickOnBuildingSetting_GrossFloorAreaTab();
			ClickOnBuildingSetting_OperatingHoursTab();
			BuildingSetting_FilterButton.click();
			BuildingSetting_FilterStartDate.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[contains(@class,'table-condensed')])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
			String StartDateXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='" + (i - 3) + "'])[1]";
			String EndDateXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='" + (i - 2) + "'])[1]";
			driver.findElement(By.xpath(StartDateXpath)).click();
			BuildingSetting_FilterEndDate.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@class=' table-condensed']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
			driver.findElement(By.xpath(EndDateXpath)).click();
			BuildingSetting_UpdateButton.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			List<WebElement> ListOfRows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			log.info("Total number of rows are ..." + ListOfRows.size());
			if (ListOfRows.size() == 2) {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy");
				LocalDateTime now = LocalDateTime.now();
				String FirstRowEffectiveDate = dtf.format(now.minusMonths(1).withDayOfMonth(1).plusDays(2));
				String SecondRowEffectiveDate = dtf.format(now.minusMonths(1).withDayOfMonth(1).plusDays(1));

				String TextBox1EffectiveDate = driver
						.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input"))
						.getAttribute("value");
				String TextBox2EffectiveDate = driver
						.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input"))
						.getAttribute("value");

				log.info("FirstRowEffectiveDate is --" + FirstRowEffectiveDate + " and TextBox1EffectiveDate is  "
						+ TextBox1EffectiveDate);
				log.info("SecondRowEffectiveDate is --" + SecondRowEffectiveDate + " and TextBox2EffectiveDate is  "
						+ TextBox2EffectiveDate);
				if (FirstRowEffectiveDate.equals(TextBox1EffectiveDate)
						&& SecondRowEffectiveDate.equals(TextBox2EffectiveDate)) {
					log.info("Filter is working properly...");
					FilterFlag = true;
				}
			}

			if (FilterFlag) {
				BuildingSetting_FilterButton.click();
				BuildingSetting_ResetButton.click();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				i = 4;
				int row = 1;
				List<WebElement> EffectiveDateList = driver
						.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr/td[1]/input"));
				log.info("Total rows displaying after Reset is " + EffectiveDateList.size());
				for (WebElement ele : EffectiveDateList) {
					ele.click();
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String Hourxpath = "//table[@id='readingsTable']/tbody/tr[" + row + "]/td[2]/div/button";
					int days = Integer.parseInt(driver.findElement(By.xpath(
							"//table[@class=' table-condensed']/tbody/tr/td[contains(@class,'active day operating_hours_active_day')]"))
							.getText());
					driver.findElement(By.xpath(Hourxpath)).click();
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (days == i) {
						Resetflag = true;
						log.info("Calender Days value is " + days + " and Loop I value is " + i);
					} else {
						Resetflag = false;
						break;
					}
					i--;
					row++;
				}

			} else {
				log.info("Filter is not working properly..");
				log.info("BuildingSetting_CheckFilterAndReset method ends with false here.........");
				return false;
			}

		} else {
			log.info("Row is not added successfully..");
			log.info("BuildingSetting_CheckFilterAndReset method ends with false here.........");
			return false;

		}
		if ((RowsAddedFlag) && (FilterFlag) && (Resetflag)) {
			log.info("Filter and Reset are working fine...");
			log.info("BuildingSetting_CheckFilterAndReset method ends with true here.........");
			return true;
		} else {
			log.info("Filter and Reset are working fine...");
			log.info("BuildingSetting_CheckFilterAndReset method ends with false here.........");
			return false;
		}

	}

	// Building Settings-->Gross Floor Area tab - >Verify filter and reset
	// functionalities.
	public boolean BuildingSetting_GrossFloorArea_CheckFilterAndReset() {
		log.info("BuildingSetting_GrossFloorArea_CheckFilterAndReset  method starts here.........");
		boolean RowsAddedFlag = false;
		boolean FilterFlag = false;
		boolean Resetflag = false;
		int i;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> ListOfRows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int grossArea = Integer.parseInt(data.getCellData("Building", 2, 2));
		log.info("Total number of rows are ..." + ListOfRows.size());
		for (i = 1; i < 5; i++) {
			ListOfRows.size();
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

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[1]/input")).click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@class=' table-condensed']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
			String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='" + i + "'])[1]";
			driver.findElement(By.xpath(CalXpath)).click();

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(grossArea));

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/button")).click();
			String UnitXpath = "//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/ul/li/a[text()='IP units (sq feet)']";
			driver.findElement(By.xpath(UnitXpath)).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By
							.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/*[@class='fade-out saved_symbol']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@id='readingsTable']/tbody/tr[1]/td[6]/*[@class='fade-out saved_symbol']")),
						Integer.parseInt(prop.getProperty("explicitTime")), 1);
			} catch (Exception e) {
				e.printStackTrace();
			}

			ListOfRows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			int TotalRow_afterAdding = ListOfRows.size();
			log.info("Total number of rows are ..." + TotalRow_afterAdding);
			if (i + 1 == TotalRow_afterAdding) {
				RowsAddedFlag = true;
			} else {
				RowsAddedFlag = false;
				break;
			}
			grossArea = grossArea + 10;

		}
		if (RowsAddedFlag) {
			log.info("All rows are added successfully..");

			/*
			 * ClickOnWaste_Data(); ClickOnBuildingSetting();
			 * ClickOnBuildingSetting_OperatingHoursTab();
			 */
			ClickOnBuildingSetting_OperatingHoursTab();
			ClickOnBuildingSetting_GrossFloorAreaTab();
			BuildingSetting_FilterButton.click();
			BuildingSetting_FilterStartDate.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[contains(@class,'table-condensed')])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
			String StartDateXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='" + (i - 3) + "'])[1]";
			String EndDateXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='" + (i - 2) + "'])[1]";
			driver.findElement(By.xpath(StartDateXpath)).click();
			BuildingSetting_FilterEndDate.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@class=' table-condensed']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
			driver.findElement(By.xpath(EndDateXpath)).click();
			BuildingSetting_UpdateButton.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			ListOfRows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			log.info("Total number of rows are ..." + ListOfRows.size());
			if (ListOfRows.size() == 2) {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy");
				LocalDateTime now = LocalDateTime.now();
				String FirstRowEffectiveDate = dtf.format(now.minusMonths(1).withDayOfMonth(1).plusDays(2));
				String SecondRowEffectiveDate = dtf.format(now.minusMonths(1).withDayOfMonth(1).plusDays(1));

				String TextBox1EffectiveDate = driver
						.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input"))
						.getAttribute("value");
				String TextBox2EffectiveDate = driver
						.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input"))
						.getAttribute("value");

				log.info("FirstRowEffectiveDate is --" + FirstRowEffectiveDate + " and TextBox1EffectiveDate is  "
						+ TextBox1EffectiveDate);
				log.info("SecondRowEffectiveDate is --" + SecondRowEffectiveDate + " and TextBox2EffectiveDate is  "
						+ TextBox2EffectiveDate);
				if (FirstRowEffectiveDate.equals(TextBox1EffectiveDate)
						&& SecondRowEffectiveDate.equals(TextBox2EffectiveDate)) {
					log.info("Filter is working properly...");
					FilterFlag = true;
				}
			}

			if (FilterFlag) {
				BuildingSetting_FilterButton.click();
				BuildingSetting_ResetButton.click();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				List<WebElement> EffectiveDateList = driver
						.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr/td[1]/input"));
				log.info("Total rows displaying after Reset is " + EffectiveDateList.size());
				i = EffectiveDateList.size() - 1;
				int row = 1;
				if (i == 4) {
					for (int j = 0; j < 4; j++) {
						EffectiveDateList.get(j).click();
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						String GrossAreaxpath = "//table[@id='readingsTable']/tbody/tr[" + row + "]/td[2]/input";
						int days = Integer.parseInt(driver.findElement(By.xpath(
								"//table[@class=' table-condensed']/tbody/tr/td[contains(@class,'active day gross_area_active_day')]"))
								.getText());
						driver.findElement(By.xpath(GrossAreaxpath)).click();
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (days == i) {
							Resetflag = true;
							log.info("Calender Days value is " + days + " and Loop I value is " + i);
						} else {
							Resetflag = false;
							break;
						}
						i--;
						row++;

					}
				}

			} else {
				log.info("Filter is not working properly..");
				log.info("BuildingSetting_GrossFloorArea_CheckFilterAndReset method ends with false here.........");
				return false;
			}

		} else {
			log.info("Row is not added successfully..");
			log.info("BuildingSetting_GrossFloorArea_CheckFilterAndReset method ends with false here.........");
			return false;

		}
		if ((RowsAddedFlag) && (FilterFlag) && (Resetflag)) {
			log.info("Filter and Reset are working fine...");
			log.info("BuildingSetting_GrossFloorArea_CheckFilterAndReset method ends with true here.........");
			return true;
		} else {
			log.info("Filter and Reset are working fine...");
			log.info("BuildingSetting_GrossFloorArea_CheckFilterAndReset method ends with false here.........");
			return false;
		}

	}

	// // Building Settings-->Occupant tab - >Verify Occupants tab by clicking on
	// 'Add Occupancy data' button
	public boolean BuildingSetting_OccupantTab_AddOccupancyData() {
		log.info("BuildingSetting_OccupantTab_AddOccupancyData  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(BuildingSetting_AddOccupancyDataBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BuildingSetting_AddOccupancyDataBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//h4[@class='fw600']/span[text()='Add Occupancy']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		flag = driver.findElement(By.xpath("//h4[@class='fw600']/span[text()='Add Occupancy']")).isDisplayed();
		log.info(flag);
		log.info("BuildingSetting_OccupantTab_AddOccupancyData  method ends here.........");
		return flag;
	}

	// Verify clicking on 'Upload' button opens up with four options- 'Computer
	// File', 'Dropbox, OneDrive,Google Drive.
	public boolean BuildingSetting_CheckUploadOprions() {
		log.info("BuildingSetting_CheckUploadOprions  method starts here.........");
		boolean ComputerFileFlag = false;
		boolean Dropboxflag = false;
		boolean OneDriveflag = false;
		boolean GDriveflag = false;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/div/button")).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ComputerFile = driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/div/ul/li/span"))
				.getAttribute("innerHTML");
		if (ComputerFile.equals("Computer File")) {
			ComputerFileFlag = true;
			log.info("Current Option showing is  " + ComputerFile);
		}

		List<WebElement> DocumentList = driver
				.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/div/ul/li/div"));
		for (WebElement ele : DocumentList) {
			String optionText = ele.getText();
			log.info("Current Option showing is  " + optionText);
			if (optionText.contains("Dropbox")) {
				Dropboxflag = true;
			} else if (optionText.contains("OneDrive")) {
				OneDriveflag = true;
			} else if (optionText.contains("Google Drive")) {
				GDriveflag = true;
			}
		}

		if ((ComputerFileFlag) && (Dropboxflag) && (OneDriveflag) && (GDriveflag)) {
			log.info("All four options are showing properly");
			log.info("BuildingSetting_CheckUploadOprions method ends here with true.........");
			return true;

		} else {
			log.info("All four options are not showing properly");
			log.info("BuildingSetting_CheckUploadOprions method ends here with false.........");
			return false;
		}

	}

	// Building Settings-->Gross Floor Area tab -->Verify clicking on 'Upload'
	// button opens up with four options- 'Computer
	// File', 'Dropbox, OneDrive,Google Drive.
	public boolean BuildingSetting_GrossFloorArea_CheckUploadOprions() {
		log.info("BuildingSetting_GrossFloorArea_CheckUploadOprions  method starts here.........");
		boolean ComputerFileFlag = false;
		boolean Dropboxflag = false;
		boolean OneDriveflag = false;
		boolean GDriveflag = false;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/div/button")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ComputerFile = driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/div/ul/li/span")).getText();
		if (ComputerFile.equals("Computer File")) {
			ComputerFileFlag = true;
			log.info("Current Option showing is  " + ComputerFile);
		}

		List<WebElement> DocumentList = driver
				.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/div/ul/li/div"));
		for (WebElement ele : DocumentList) {
			String optionText = ele.getText();
			log.info("Current Option showing is  " + optionText);
			if (optionText.contains("Dropbox")) {
				Dropboxflag = true;
			} else if (optionText.contains("OneDrive")) {
				OneDriveflag = true;
			} else if (optionText.contains("Google Drive")) {
				GDriveflag = true;
			}
		}

		if ((ComputerFileFlag) && (Dropboxflag) && (OneDriveflag) && (GDriveflag)) {
			log.info("All four options are showing properly");
			log.info("BuildingSetting_GrossFloorArea_CheckUploadOprions method ends here with true.........");
			return true;

		} else {
			log.info("All four options are not showing properly");
			log.info("BuildingSetting_GrossFloorArea_CheckUploadOprions method ends here with false.........");
			return false;
		}

	}

	// Building Settings-->Emissions Factor tab -->Verify clicking on 'Upload'
	// button opens up with four options- 'Computer
	// File', 'Dropbox, OneDrive,Google Drive.
	public boolean BuildingSetting_EmissionsFactor_CheckUploadOprions() {
		log.info("BuildingSetting_EmissionsFactor_CheckUploadOprions  method starts here.........");
		boolean ComputerFileFlag = false;
		boolean Dropboxflag = false;
		boolean OneDriveflag = false;
		boolean GDriveflag = false;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/div/button")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ComputerFile = driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/div/ul/li/span")).getText();
		if (ComputerFile.equals("Computer File")) {
			ComputerFileFlag = true;
			log.info("Current Option showing is  " + ComputerFile);
		}

		List<WebElement> DocumentList = driver
				.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/div/ul/li/div"));
		for (WebElement ele : DocumentList) {
			String optionText = ele.getText();
			log.info("Current Option showing is  " + optionText);
			if (optionText.contains("Dropbox")) {
				Dropboxflag = true;
			} else if (optionText.contains("OneDrive")) {
				OneDriveflag = true;
			} else if (optionText.contains("Google Drive")) {
				GDriveflag = true;
			}
		}

		if ((ComputerFileFlag) && (Dropboxflag) && (OneDriveflag) && (GDriveflag)) {
			log.info("All four options are showing properly");
			log.info("BuildingSetting_EmissionsFactor_CheckUploadOprions method ends here with true.........");
			return true;

		} else {
			log.info("All four options are not showing properly");
			log.info("BuildingSetting_EmissionsFactor_CheckUploadOprions method ends here with false.........");
			return false;
		}

	}

	// Building Settings-->Operational Days tab -->Verify clicking on 'Upload'
	// button opens up with four options- 'Computer
	// File', 'Dropbox, OneDrive,Google Drive.
	public boolean OperationalDays_CheckUploadOprions() {
		log.info("OperationalDays_CheckUploadOprions  method starts here.........");
		boolean ComputerFileFlag = false;
		boolean Dropboxflag = false;
		boolean OneDriveflag = false;
		boolean GDriveflag = false;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/div/button")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ComputerFile = driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/div/ul/li/span")).getText();
		if (ComputerFile.equals("Computer File")) {
			ComputerFileFlag = true;
			log.info("Current Option showing is  " + ComputerFile);
		}

		List<WebElement> DocumentList = driver
				.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/div/ul/li/div"));
		for (WebElement ele : DocumentList) {
			String optionText = ele.getText();
			log.info("Current Option showing is  " + optionText);
			if (optionText.contains("Dropbox")) {
				Dropboxflag = true;
			} else if (optionText.contains("OneDrive")) {
				OneDriveflag = true;
			} else if (optionText.contains("Google Drive")) {
				GDriveflag = true;
			}
		}

		if ((ComputerFileFlag) && (Dropboxflag) && (OneDriveflag) && (GDriveflag)) {
			log.info("All four options are showing properly");
			log.info("OperationalDays_CheckUploadOprions method ends here with true.........");
			return true;

		} else {
			log.info("All four options are not showing properly");
			log.info("OperationalDays_CheckUploadOprions method ends here with false.........");
			return false;
		}

	}

	// Building Settings-->Occupant tab -->Verify clicking on 'Upload'
	// button opens up with four options- 'Computer
	// File', 'Dropbox, OneDrive,Google Drive.
	public boolean BuildingSetting_Occupant_CheckUploadOprions() {
		log.info("BuildingSetting_Occupant_CheckUploadOprions  method starts here.........");
		boolean ComputerFileFlag = false;
		boolean Dropboxflag = false;
		boolean OneDriveflag = false;
		boolean GDriveflag = false;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/div/button")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ComputerFile = driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/div/ul/li/span")).getText();
		if (ComputerFile.equals("Computer File")) {
			ComputerFileFlag = true;
			log.info("Current Option showing is  " + ComputerFile);
		}

		List<WebElement> DocumentList = driver
				.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/div/ul/li/div"));
		for (WebElement ele : DocumentList) {
			String optionText = ele.getText();
			log.info("Current Option showing is  " + optionText);
			if (optionText.contains("Dropbox")) {
				Dropboxflag = true;
			} else if (optionText.contains("OneDrive")) {
				OneDriveflag = true;
			} else if (optionText.contains("Google Drive")) {
				GDriveflag = true;
			}
		}

		if ((ComputerFileFlag) && (Dropboxflag) && (OneDriveflag) && (GDriveflag)) {
			log.info("All four options are showing properly");
			log.info("BuildingSetting_Occupant_CheckUploadOprions method ends here with true.........");
			return true;

		} else {
			log.info("All four options are not showing properly");
			log.info("BuildingSetting_Occupant_CheckUploadOprions method ends here with false.........");
			return false;
		}

	}

	// Building Settings-->Operating hours tab - > Verify comments and activity..
	public boolean BuildingSetting_CheckCommentAndActivity(String comment, String uname) {
		log.info("BuildingSetting_CheckCommentAndActivity  starts here........");
		boolean Commentflag = false;
		BuildingSetting_CommentTextBox.sendKeys(comment);
		waithelper.WaitForElementClickable(BuildingSetting_PostButton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(BuildingSetting_PostButton);
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
		Date date = new Date();
		String strDate = formatter.format(date);
		strDate = formatter.format(date);
		LocalTime localTime = LocalTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
		String currentTime = localTime.format(dateTimeFormatter).toLowerCase();
		// log.info(localTime.format(dateTimeFormatter));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Commentflag = driver.findElement(By.xpath("(//p[text()='" + comment + "'])[1]")).isDisplayed();
		log.info(" Comment display in Comment Tab is --" + Commentflag);
		waithelper.WaitForElementClickable(BuildingSetting_ActivityButton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		BuildingSetting_ActivityButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ActivityDate = driver.findElement(By.xpath("//th[@class='activity_date']/p")).getText();
		String ActivityTime = driver.findElement(By.xpath("(//table[@class='mb10 ng-scope']/tbody/tr/td[1]/span)[1]"))
				.getText().toLowerCase();
		String ActivtyComment = driver.findElement(By.xpath("(//table[@class='mb10 ng-scope']/tbody/tr/td[2]/p)[1]"))
				.getText();

		String ExpComment = uname + " commented in Operating Hours";

		log.info("Displayed Activity Date is ---" + ActivityDate);
		log.info("Displayed Activity Time is ---" + ActivityTime);
		log.info("Displayed Activity comment is ---" + ActivtyComment);
		log.info("Expected Activity Time is ---" + currentTime);
		log.info("Expected Activity Date is ---" + strDate);
		log.info("Expected Activity Comment is ---" + ExpComment);
		if ((Commentflag) && (ActivityDate.equals(strDate)) && (ActivityTime.equals(currentTime))
				&& (ActivtyComment.equals(ExpComment))) {
			log.info("BuildingSetting_CheckCommentAndActivity  ends here........");
			return true;
		} else {
			log.info("BuildingSetting_CheckCommentAndActivity  ends here........");
			return false;
		}

	}

	// Building Settings-->Gross Floor Area tab - > Verify comments and activity..
	public boolean BuildingSetting_GrossFloorAreaCheckCommentAndActivity(String comment, String uname) {
		log.info("BuildingSetting_GrossFloorAreaCheckCommentAndActivity  starts here........");
		boolean Commentflag = false;
		BuildingSetting_CommentTextBox.sendKeys(comment);
		waithelper.WaitForElementClickable(BuildingSetting_PostButton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(BuildingSetting_PostButton);
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
		Date date = new Date();
		String strDate = formatter.format(date);
		strDate = formatter.format(date);
		LocalTime localTime = LocalTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
		String currentTime = localTime.format(dateTimeFormatter).toLowerCase();
		// log.info(localTime.format(dateTimeFormatter));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Commentflag = driver.findElement(By.xpath("(//p[text()='" + comment + "'])[1]")).isDisplayed();
		log.info(" Comment display in Comment Tab is --" + Commentflag);
		waithelper.WaitForElementClickable(BuildingSetting_ActivityButton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		BuildingSetting_ActivityButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ActivityDate = driver.findElement(By.xpath("//th[@class='activity_date']/p")).getText();
		String ActivityTime = driver.findElement(By.xpath("(//table[@class='mb10 ng-scope']/tbody/tr/td[1]/span)[1]"))
				.getText().toLowerCase();
		String ActivtyComment = driver.findElement(By.xpath("(//table[@class='mb10 ng-scope']/tbody/tr/td[2]/p)[1]"))
				.getText();

		String ExpComment = uname + " commented in Gross Floor Area";

		log.info("Displayed Activity Date is ---" + ActivityDate);
		log.info("Displayed Activity Time is ---" + ActivityTime);
		log.info("Displayed Activity comment is ---" + ActivtyComment);
		log.info("Expected Activity Time is ---" + currentTime);
		log.info("Expected Activity Date is ---" + strDate);
		log.info("Expected Activity Comment is ---" + ExpComment);
		if ((Commentflag) && (ActivityDate.equals(strDate)) && (ActivityTime.equals(currentTime))
				&& (ActivtyComment.equals(ExpComment))) {
			log.info("BuildingSetting_GrossFloorAreaCheckCommentAndActivity  ends here........");
			return true;
		} else {
			log.info("BuildingSetting_GrossFloorAreaCheckCommentAndActivity  ends here........");
			return false;
		}

	}

	// Building Settings-->Occupant tab - > Verify comments and activity..
	public boolean BuildingSetting_Occupant_CheckCommentAndActivity(String comment, String uname) {
		log.info("BuildingSetting_Occupant_CheckCommentAndActivity  starts here........");
		boolean Commentflag = false;
		BuildingSetting_CommentTextBox.sendKeys(comment);
		waithelper.WaitForElementClickable(BuildingSetting_PostButton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(BuildingSetting_PostButton);
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
		Date date = new Date();
		String strDate = formatter.format(date);
		strDate = formatter.format(date);
		LocalTime localTime = LocalTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
		String currentTime = localTime.format(dateTimeFormatter).toLowerCase();
		// log.info(localTime.format(dateTimeFormatter));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Commentflag = driver.findElement(By.xpath("(//p[text()='" + comment + "'])[1]")).isDisplayed();
		log.info(" Comment display in Comment Tab is --" + Commentflag);
		waithelper.WaitForElementClickable(BuildingSetting_ActivityButton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		BuildingSetting_ActivityButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ActivityDate = driver.findElement(By.xpath("//th[@class='activity_date']/p")).getText();
		String ActivityTime = driver.findElement(By.xpath("(//table[@class='mb10 ng-scope']/tbody/tr/td[1]/span)[1]"))
				.getText().toLowerCase();
		String ActivtyComment = driver.findElement(By.xpath("(//table[@class='mb10 ng-scope']/tbody/tr/td[2]/p)[1]"))
				.getText();

		String ExpComment = uname + " commented in Occupants";

		log.info("Displayed Activity Date is ---" + ActivityDate);
		log.info("Displayed Activity Time is ---" + ActivityTime);
		log.info("Displayed Activity comment is ---" + ActivtyComment);
		log.info("Expected Activity Time is ---" + currentTime);
		log.info("Expected Activity Date is ---" + strDate);
		log.info("Expected Activity Comment is ---" + ExpComment);
		if ((Commentflag) && (ActivityDate.equals(strDate)) && (ActivityTime.equals(currentTime))
				&& (ActivtyComment.equals(ExpComment))) {
			log.info("BuildingSetting_Occupant_CheckCommentAndActivity  ends here........");
			return true;
		} else {
			log.info("BuildingSetting_Occupant_CheckCommentAndActivity  ends here........");
			return false;
		}

	}

	// Building Settings-->Operational Days tab - > Verify comments and activity..
	public boolean BuildingSetting_OperationalDays_CheckCommentAndActivity(String comment, String uname) {
		log.info("BuildingSetting_OperationalDays_CheckCommentAndActivity  starts here........");
		boolean Commentflag = false;
		BuildingSetting_CommentTextBox.sendKeys(comment);
		waithelper.WaitForElementClickable(BuildingSetting_PostButton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(BuildingSetting_PostButton);
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
		Date date = new Date();
		String strDate = formatter.format(date);
		strDate = formatter.format(date);
		LocalTime localTime = LocalTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
		String currentTime = localTime.format(dateTimeFormatter).toLowerCase();
		// log.info(localTime.format(dateTimeFormatter));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Commentflag = driver.findElement(By.xpath("(//p[text()='" + comment + "'])[1]")).isDisplayed();
		log.info(" Comment display in Comment Tab is --" + Commentflag);
		waithelper.WaitForElementClickable(BuildingSetting_ActivityButton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		BuildingSetting_ActivityButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ActivityDate = driver.findElement(By.xpath("//th[@class='activity_date']/p")).getText();
		String ActivityTime = driver.findElement(By.xpath("(//table[@class='mb10 ng-scope']/tbody/tr/td[1]/span)[1]"))
				.getText().toLowerCase();
		String ActivtyComment = driver.findElement(By.xpath("(//table[@class='mb10 ng-scope']/tbody/tr/td[2]/p)[1]"))
				.getText();

		String ExpComment = uname + " commented in Operational Days";

		log.info("Displayed Activity Date is ---" + ActivityDate);
		log.info("Displayed Activity Time is ---" + ActivityTime);
		log.info("Displayed Activity comment is ---" + ActivtyComment);
		log.info("Expected Activity Time is ---" + currentTime);
		log.info("Expected Activity Date is ---" + strDate);
		log.info("Expected Activity Comment is ---" + ExpComment);
		if ((Commentflag) && (ActivityDate.equals(strDate)) && (ActivityTime.equals(currentTime))
				&& (ActivtyComment.equals(ExpComment))) {
			log.info("BuildingSetting_OperationalDays_CheckCommentAndActivity  ends here........");
			return true;
		} else {
			log.info("BuildingSetting_OperationalDays_CheckCommentAndActivity  ends here........");
			return false;
		}

	}

	// Building Settings-->Emissions Factor tab - > Verify comments and activity..
	public boolean BuildingSetting_EmissionsFactor_CheckCommentAndActivity(String comment, String uname) {
		log.info("BuildingSetting_EmissionsFactor_CheckCommentAndActivity  starts here........");
		boolean Commentflag = false;
		BuildingSetting_CommentTextBox.sendKeys(comment);
		waithelper.WaitForElementClickable(BuildingSetting_PostButton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(BuildingSetting_PostButton);
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
		Date date = new Date();
		String strDate = formatter.format(date);
		strDate = formatter.format(date);
		LocalTime localTime = LocalTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
		String currentTime = localTime.format(dateTimeFormatter).toLowerCase();
		// log.info(localTime.format(dateTimeFormatter));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Commentflag = driver.findElement(By.xpath("(//p[text()='" + comment + "'])[1]")).isDisplayed();
		log.info(" Comment display in Comment Tab is --" + Commentflag);
		waithelper.WaitForElementClickable(BuildingSetting_ActivityButton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		BuildingSetting_ActivityButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ActivityDate = driver.findElement(By.xpath("//th[@class='activity_date']/p")).getText();
		String ActivityTime = driver.findElement(By.xpath("(//table[@class='mb10 ng-scope']/tbody/tr/td[1]/span)[1]"))
				.getText().toLowerCase();
		String ActivtyComment = driver.findElement(By.xpath("(//table[@class='mb10 ng-scope']/tbody/tr/td[2]/p)[1]"))
				.getText();

		String ExpComment = uname + " commented in Emissions Factor";

		log.info("Displayed Activity Date is ---" + ActivityDate);
		log.info("Displayed Activity Time is ---" + ActivityTime);
		log.info("Displayed Activity comment is ---" + ActivtyComment);
		log.info("Expected Activity Time is ---" + currentTime);
		log.info("Expected Activity Date is ---" + strDate);
		log.info("Expected Activity Comment is ---" + ExpComment);
		if ((Commentflag) && (ActivityDate.equals(strDate)) && (ActivityTime.equals(currentTime))
				&& (ActivtyComment.equals(ExpComment))) {
			log.info("BuildingSetting_EmissionsFactor_CheckCommentAndActivity  ends here........");
			return true;
		} else {
			log.info("BuildingSetting_EmissionsFactor_CheckCommentAndActivity  ends here........");
			return false;
		}

	}

	// Building Settings-->Operational Days tab - > Validate Operational days, by
	// default the value is present as '313' and the value is editable.
	public boolean BuildingSetting_ODays_CheckDefaultValue313() {
		log.info("BuildingSetting_ODays_CheckDefaultValue313  starts here........");
		boolean Defaultflag = false;

		int DefaultValue = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).getAttribute("value"));
		log.info("Default value is --" + DefaultValue);
		if (DefaultValue == 313) {
			Defaultflag = true;
		}
		int ODays = Integer.parseInt(data.getCellData("Building", 8, 2));
		ODays = ODays + 20;
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(ODays));
		BuildingSetting_CommentTextBox.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(
						By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/*[@class='fade-out saved_symbol']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		try {

			waithelper.WaitForElementInvisible(
					driver.findElement(By
							.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/*[@class='fade-out saved_symbol']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (Defaultflag) {
			log.info("BuildingSetting_ODays_CheckDefaultValue313  ends here........");
			return true;
		} else {
			log.info("BuildingSetting_ODays_CheckDefaultValue313  ends here........");
			return false;
		}

	}

	// Building Settings-->Operational Days tab - > Validate Operational days,
	// default row item field is editable and allows to add new row.
	public boolean BuildingSetting_ODays_AddNewRow() {
		log.info("BuildingSetting_ODays_AddNewRow  starts here........");
		boolean AddedFlag = false;
		List<WebElement> ListOfRows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int TotalRow_BeforeAdding = ListOfRows.size();
		log.info("Total rows before adding...." + TotalRow_BeforeAdding);
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

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[1]/input")).click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting 1st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(data.getCellData("Building", 8, 2));

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/button")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(
						By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/*[@class='fade-out saved_symbol']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By
							.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/*[@class='fade-out saved_symbol']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ListOfRows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int TotalRow_afterAdding = ListOfRows.size();
		log.info("Total rows after adding...." + TotalRow_afterAdding);
		if (TotalRow_afterAdding - TotalRow_BeforeAdding == 1) {
			log.info("Row is added successfully....");
			AddedFlag = true;
		} else {
			log.info("Row is not added successfully....");
			AddedFlag = false;

		}

		if (AddedFlag) {
			log.info("BuildingSetting_ODays_AddNewRow  ends here with true........");
			return true;
		} else {
			log.info("BuildingSetting_ODays_AddNewRow  ends here false........");
			return false;
		}

	}

	// Building Settings-->Emissions Factor tab - > Validate emission factor-
	// Standard emission factor radio button is selected.
	public boolean BuildingSetting_EmissionFactor_StandardEmission() {
		log.info("BuildingSetting_EmissionFactor_StandardEmission  starts here........");
		boolean flag = false;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flag = BuildingSetting_Emissions_StandardEmissions.isSelected();
		if (flag) {
			log.info("BuildingSetting_EmissionFactor_StandardEmission  ends here with true........");
			return true;
		} else {
			log.info("BuildingSetting_EmissionFactor_StandardEmission  ends here false........");
			return false;
		}

	}

	// Building Settings-->Emissions Factor tab - > Validate emission factor- Custom
	// emission factor allows to add row item with effective date, value and
	// documents.
	public boolean BuildingSetting_EmissionFactor_CustomEmission(String filePath) {
		log.info("BuildingSetting_EmissionFactor_CustomEmission  starts here........");
		boolean flag = false;

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BuildingSetting_Emissions_CustomEmissions.click();

		waithelper.WaitForElementVisibleWithPollingTime(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> ListOfRows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		ListOfRows.size();
		log.info("Total number of rows before Adding ..." + ListOfRows.size());
		BuildingSetting_AddRow_button.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[1]/input")).click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting 1st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(data.getCellData("Building", 10, 2));

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/button/span")).click();

		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By
							.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/*[@class='fade-out saved_symbol']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			waithelper.WaitForElementInvisible(
					driver.findElement(By
							.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/*[@class='fade-out saved_symbol']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		flag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/span")).isDisplayed();
		ListOfRows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		log.info("Total number of rows after adding ..." + ListOfRows.size());
		if (flag) {
			log.info("BuildingSetting_EmissionFactor_CustomEmission  ends here with true........");
			return true;
		} else {
			log.info("BuildingSetting_EmissionFactor_CustomEmission  ends here with false........");
			return false;
		}

	}

	// Verify Building Settings-->Gross Floor Area tab-- Verify clicking on 'Add
	// Row' adds a new line item.
	public boolean BuildingSetting_GrossFloorArea_AddRow(String UserName) {
		log.info("BuildingSetting_GrossFloorArea_AddRow  method starts here.........");
		boolean EffectiveTextBoxflag = false;
		boolean GrossAreaTextBoxflag = false;
		boolean Unitflag = false;
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
		List<WebElement> ListOfRows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int Total_Rows = ListOfRows.size();
		log.info("Total number of rows are ..." + Total_Rows);

		BuildingSetting_AddRow_button.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ListOfRows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		Total_Rows = ListOfRows.size();
		log.info("Total number of rows after clicking on AddRow button are ..." + Total_Rows);
		if (driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).isDisplayed()) {
			EffectiveTextBoxflag = true;
			log.info("EffectiveTextBoxflag is " + EffectiveTextBoxflag);
		}
		if (driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).isDisplayed()) {
			GrossAreaTextBoxflag = true;
			log.info("GrossAreaTextBoxflag is " + GrossAreaTextBoxflag);
		}
		if (driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/button")).isDisplayed()) {
			Unitflag = true;
			log.info("Unitflag is " + Unitflag);
		}
		if (driver.findElement(By
				.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/div/button/span[@class='upload-doc--icon']"))
				.isDisplayed()) {
			DocumentationFlag = true;
			log.info("DocumentationFlag is " + DocumentationFlag);
		}

		if (driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div")).getText()
				.contains(UserName)) {
			UpdatedByFlag = true;
			log.info("UpdatedByFlag is " + UpdatedByFlag);
		}

		if (driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/button/span[text()='Save']"))
				.isDisplayed()) {
			SaveBtnFlag = true;
			log.info("SaveBtnFlag is " + SaveBtnFlag);
		}

		if (driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[8]/span")).isDisplayed()) {
			DeleteBtnFlag = true;
			log.info("DeleteBtnFlag is " + DeleteBtnFlag);
		}

		if ((EffectiveTextBoxflag) && (GrossAreaTextBoxflag) && (Unitflag) && (DocumentationFlag) && (UpdatedByFlag)
				&& (SaveBtnFlag) && (DeleteBtnFlag)) {
			log.info("All the fields are displaying properly.");
			log.info("BuildingSetting_GrossFloorArea_AddRow  method ends here with true.........");
			return true;
		} else {
			log.info("All the fields are not displaying properly.");
			log.info("BuildingSetting_GrossFloorArea_AddRow  method ends here with false.........");
			return false;
		}
	}

	// Building Settings-->Gross Floor Area tab - >Verify Unit field gives two
	// options- IP units(Square feet) and SI units(Square meters) to select from.
	public boolean BuildingSetting_CheckAddRowWithBothUnits() {
		log.info("BuildingSetting_GrossAreaField_AllowNumericOnly  method starts here.........");
		boolean AddedFlag = false;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<String> Units = new ArrayList<String>();
		Units.add("IP units (sq feet)");
		Units.add("SI units (sq meters)");
		int i = 1;
		// List<WebElement> ListOfRows =
		// driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int Total_Rows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		int grossArea = Integer.parseInt(data.getCellData("Building", 2, 2));
		log.info("Total number of rows are ..." + Total_Rows);
		for (String unit : Units) {
			// int Total_Rows = ListOfRows.size();
			Total_Rows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
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

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[1]/input")).click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@class=' table-condensed']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
			String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='" + i + "'])[1]";
			driver.findElement(By.xpath(CalXpath)).click();

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(grossArea));

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/button")).click();
			String UnitXpath = "//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/ul/li/a[text()='" + unit + "']";
			driver.findElement(By.xpath(UnitXpath)).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By
							.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/*[@class='fade-out saved_symbol']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@id='readingsTable']/tbody/tr[1]/td[6]/*[@class='fade-out saved_symbol']")),
						Integer.parseInt(prop.getProperty("explicitTime")), 1);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// ListOfRows =
			// driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			int TotalRow_afterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total number of rows are ..." + TotalRow_afterAdding);
			if (TotalRow_afterAdding - Total_Rows == 1) {
				log.info("Row is added successfully....");
				AddedFlag = true;
			} else {
				log.info("Row is not added successfully....");
				AddedFlag = false;
				break;
			}

			grossArea = grossArea + 10;
			i++;
		}
		if (AddedFlag == true) {
			log.info("Rows are added with both units successfully....");
			log.info("BuildingSetting_CheckAddRowWithBothUnits method ends here with true.........");
			return true;
		} else {
			log.info("Rows are added with both units successfully value also....");
			log.info("BuildingSetting_CheckAddRowWithBothUnits method ends here with false.........");
			return false;
		}

	}
//------------------------------------------------------------------------------------------------------------------------

	// Building Settings--> Energy --> Validate unit type present in dropdown are-
	// kwh,mwh,mbtu,kbtu,GJ
	public boolean Energy_ValidateUnitType() {
		log.info("Energy_ValidateUnitType  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<String> units = new ArrayList<String>();
		units.add("kWh");
		units.add("MWh");
		units.add("MBtu");
		units.add("kBtu");
		units.add("GJ");
		waithelper.WaitForElementClickable(EnergyAddNewMeter, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		EnergyAddNewMeter.click();
		waithelper.WaitForElementVisibleWithPollingTime(AddAEnergyDataPopUpHeader,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		waithelper.WaitForElementClickable(AddNewMeterNextBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		AddNewMeterNextBtn.click();
		MeterNameTextBox.sendKeys("E-" + CommonMethod.generateRandomString(5));
		waithelper.WaitForElementClickable(
				driver.findElement(By.xpath("//div[@class='fw600 mb10' and text()='Unit']/parent::div/div[2]/button")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		// driver.findElement(By.xpath("//div[@class='fw600 mb10' and
		// text()='Unit']/parent::div/div[2]/button")).click();
		JSHelper.clickElement(
				driver.findElement(By.xpath("//div[@class='fw600 mb10' and text()='Unit']/parent::div/div[2]/button")));

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> unitList = driver.findElements(By.xpath(
				"//div[@class='fw600 mb10' and text()='Unit']/parent::div/div[2]/ul/li[@class='energy_unit']/a"));
		log.info("Total number of units are -- " + unitList.size());
		for (WebElement ele : unitList) {
			String unit = ele.getText();
			log.info("Current Unit is " + unit);
			if (units.contains(unit)) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		if (flag == true) {
			log.info("Energy_ValidateUnitType method ends here with true.........");
			return true;
		} else {
			log.info("Energy_ValidateUnitType method ends here with false.........");
			return false;
		}

	}

	// Building Settings--> Water --> Validate unit type present in dropdown are-
	// gal,kgal,mgal,cf,ccf,kcf,mcf,l,cu,gal(UK),kgal(UK),mgal(UK),cgal(UK),cgal(US),kcm
	public boolean Water_ValidateUnitType() {
		log.info("Water_ValidateUnitType  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<String> units = new ArrayList<String>();
		units.add("gal");
		units.add("kGal");
		units.add("MGal");
		units.add("cf");
		units.add("ccf");
		units.add("kcf");
		units.add("mcf");
		units.add("l");
		units.add("cu m");
		units.add("gal(UK)");
		units.add("kGal(UK)");
		units.add("MGal(UK)");
		units.add("cGal (UK)");
		units.add("cGal (US)");
		units.add("Kcm");

		waithelper.WaitForElementClickable(WaterAddNewMeter, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		WaterAddNewMeter.click();
		waithelper.WaitForElementVisibleWithPollingTime(AddAWaterDataPopUpHeader,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		waithelper.WaitForElementClickable(AddNewMeterNextBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(AddNewMeterNextBtn);
		// AddNewMeterNextBtn.click();
		MeterNameTextBox.sendKeys("W-" + CommonMethod.generateRandomString(5));
		waithelper.WaitForElementClickable(
				driver.findElement(By.xpath("//div[@class='fw600 mb10' and text()='Unit']/parent::div/div[2]/button")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(
				driver.findElement(By.xpath("//div[@class='fw600 mb10' and text()='Unit']/parent::div/div[2]/button")));
		// driver.findElement(By.xpath("//div[@class='fw600 mb10' and
		// text()='Unit']/parent::div/div[2]/button")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> unitList = driver.findElements(By
				.xpath("//div[@class='fw600 mb10' and text()='Unit']/parent::div/div[2]/ul/li[@class='water_unit']/a"));

		for (WebElement ele : unitList) {
			String unit = ele.getText();
			log.info("Current Unit is " + unit);
			if (units.contains(unit)) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		if (flag == true) {
			log.info("Water_ValidateUnitType method ends here with true.........");
			return true;
		} else {
			log.info("Water_ValidateUnitType method ends here with false.........");
			return false;
		}

	}

//	Building Settings--> Energy --> Validate for Energy meter- Add new meter- Should populate values by default as -"Type- Electricity", "Unit type- kwh" and "Fuel source- purchased from grid.", Just add 'meter name'.
	public boolean Energy_AddNewMeter_DefaultValues() {
		log.info("Energy_AddNewMeter_DefaultValues  method starts here.........");
		boolean DefaultType = false;
		boolean DefaultUnitType = false;
		boolean DefaultFuelSource = false;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementClickable(EnergyAddNewMeter, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		EnergyAddNewMeter.click();
		waithelper.WaitForElementVisibleWithPollingTime(AddAEnergyDataPopUpHeader,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		waithelper.WaitForElementClickable(AddNewMeterNextBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(AddNewMeterNextBtn);

		MeterNameTextBox.sendKeys("E-" + CommonMethod.generateRandomString(5));

		String DefaultTypeValue = driver
				.findElement(By.xpath("//div[@class='fw600 mb10' and text()='Type']/parent::div/div[2]/button/span"))
				.getText();
		String DefaultUnitValue = driver
				.findElement(By.xpath("//div[@class='fw600 mb10' and text()='Unit']/parent::div/div[2]/button/span"))
				.getText();
		String DefaultFuelSourceValue = driver
				.findElement(
						By.xpath("//div[@class='fw600 mb10' and text()='Fuel Source']/parent::div/div[2]/button/span"))
				.getText().trim();
		if (DefaultTypeValue.equals("Electricity")) {
			DefaultType = true;
			log.info("Default Type is selected as " + DefaultTypeValue);
		}

		if (DefaultUnitValue.equals("kWh")) {
			DefaultUnitType = true;
			log.info("Default unit is selected as " + DefaultUnitValue);
		}

		if (DefaultFuelSourceValue.equals("Purchased from Grid")) {
			DefaultFuelSource = true;
			log.info("Default Fuel Source is selected as " + DefaultFuelSourceValue);
		}

		if ((DefaultUnitType) && (DefaultType) && (DefaultFuelSource)) {
			log.info("Energy_AddNewMeter_DefaultValues method ends here with true.........");
			return true;
		} else {
			log.info("Energy_AddNewMeter_DefaultValues method ends here with false.........");
			return false;
		}

	}

	// Building Settings--> Energy --> Validate Type, Unit and Fuel source selected
	// value shows in Meter details tab..Click on Add button should add a new meter.
	public boolean Energy_ValidateTypeUnitFuelSourceInDetailsTab() {
		log.info("Energy_ValidateTypeUnitFuelSourceInDetailsTab  method starts here.........");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementClickable(EnergyAddNewMeter, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		EnergyAddNewMeter.click();
		waithelper.WaitForElementVisibleWithPollingTime(AddAEnergyDataPopUpHeader,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		waithelper.WaitForElementClickable(AddNewMeterNextBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AddNewMeterNextBtn.click();
		String MeterName = "E-" + CommonMethod.generateRandomString(6);
		MeterNameTextBox.sendKeys(MeterName);
		String FuelSource = data.getCellData("Building", 14, 2);
		String EnergyUnitSource = data.getCellData("Building", 13, 2);

		driver.findElement(By.xpath("//div[@class='fw600 mb10' and text()='Unit']/parent::div/div[2]/button")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> UnitOptions = driver.findElements(By.xpath(
				"//div[@class='fw600 mb10' and text()='Unit']/following-sibling::div/ul/li[@class='energy_unit']/a"));
		log.info("Total number of options for Unit  " + UnitOptions.size());

		for (WebElement ele : UnitOptions) {
			String option = ele.getText().trim();
			log.info("Current option is -- " + option);
			if (EnergyUnitSource.equals(option)) {
				ele.click();
				log.info(option + " is selected successfully..");
				break;
			}
		}

		driver.findElement(By.xpath("//div[@class='fw600 mb10' and text()='Fuel Source']/parent::div/div[2]/button"))
				.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> FuelSourceOptions = driver.findElements(
				By.xpath("//div[@class='fw600 mb10' and text()='Fuel Source']/following-sibling::div/ul/li/a"));
		log.info("Total number of options for Fuel Source  " + FuelSourceOptions.size());
		for (WebElement ele : FuelSourceOptions) {
			String option = ele.getText().trim();
			log.info("Current option is -- " + option);
			log.info(FuelSource);
			if (FuelSource.equals(option)) {
				ele.click();
				log.info(option + " is selected successfully..");
				break;
			}
		}

		waithelper.WaitForElementClickable(
				driver.findElement(
						By.xpath("//div[@class='modalWindow-footer overflow-auto']/button/span[text()='ADD']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//div[@class='modalWindow-footer overflow-auto']/button/span[text()='ADD']"))
				.click();
		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//span[text()='Details']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//span[text()='Details']")).click();

		String ActualUnitSelected = driver.findElement(By.xpath("//label[text()='Unit:']/parent::div/div/button/span"))
				.getText().trim();
		String ActualFuelSourceSelected = driver
				.findElement(By.xpath("//label[text()='Fuel Source:']/parent::div/descendant::span")).getText().trim();
		String ActualEnergyMeterName = driver
				.findElement(By.xpath("//div[@class='form-group meterDetails-form--meterName']/input"))
				.getAttribute("value");
		String ActualType = driver.findElement(By.xpath("//span[text()='Type:']/following-sibling::span")).getText();

		if (EnergyUnitSource.equals(ActualUnitSelected) && FuelSource.equals(ActualFuelSourceSelected)
				&& MeterName.equals(ActualEnergyMeterName) && ActualType.equals("Electricity")) {
			System.setProperty("EnergyMeterName", ActualEnergyMeterName);
			log.info("Energy_ValidateTypeUnitFuelSourceInDetailsTab method ends here with true.........");
			return true;
		} else {
			log.info("Energy_ValidateTypeUnitFuelSourceInDetailsTab method ends here with false.........");
			return false;
		}

	}

	// Building Settings--> Water --> Validate Type, Unit and Fuel source selected
	// value shows in Meter details tab..Click on Add button should add a new meter.
	public boolean Water_ValidateTypeUnitFuelSourceInDetailsTab() {
		log.info("Water_ValidateTypeUnitFuelSourceInDetailsTab  method starts here.........");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementClickable(WaterAddNewMeter, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(WaterAddNewMeter);
		// WaterAddNewMeter.click();
		waithelper.WaitForElementVisibleWithPollingTime(AddAWaterDataPopUpHeader,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		waithelper.WaitForElementClickable(AddNewMeterNextBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(AddNewMeterNextBtn);
		// AddNewMeterNextBtn.click();
		String MeterName = "W-" + CommonMethod.generateRandomString(6);
		MeterNameTextBox.sendKeys(MeterName);
		String FuelSource = data.getCellData("Building", 19, 2);
		String WaterUnit = data.getCellData("Building", 18, 2);

		waithelper.WaitForElementClickable(
				driver.findElement(By.xpath("//div[@class='fw600 mb10' and text()='Unit']/parent::div/div[2]/button")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(
				driver.findElement(By.xpath("//div[@class='fw600 mb10' and text()='Unit']/parent::div/div[2]/button")));
		// driver.findElement(By.xpath("//div[@class='fw600 mb10' and
		// text()='Unit']/parent::div/div[2]/button")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> UnitOptions = driver.findElements(By.xpath(
				"//div[@class='fw600 mb10' and text()='Unit']/following-sibling::div/ul/li[@class='water_unit']/a"));
		log.info("Total number of options for Unit  " + UnitOptions.size());

		for (WebElement ele : UnitOptions) {
			String option = ele.getText().trim();
			log.info("Current option is -- " + option);
			if (WaterUnit.equalsIgnoreCase(option)) {
				waithelper.WaitForElementClickable(ele, Integer.parseInt(prop.getProperty("explicitTime")), 2);
				JSHelper.clickElement(ele);
				// ele.click();
				log.info(option + " is selected successfully..");
				break;
			}
		}

		waithelper.WaitForElementClickable(
				driver.findElement(
						By.xpath("//div[@class='fw600 mb10' and text()='Fuel Source']/parent::div/div[2]/button")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(driver.findElement(
				By.xpath("//div[@class='fw600 mb10' and text()='Fuel Source']/parent::div/div[2]/button")));
		// driver.findElement(By.xpath("//div[@class='fw600 mb10' and text()='Fuel
		// Source']/parent::div/div[2]/button")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> FuelSourceOptions = driver.findElements(
				By.xpath("//div[@class='fw600 mb10' and text()='Fuel Source']/following-sibling::div/ul/li/a"));
		log.info("Total number of options for Fuel Source  " + FuelSourceOptions.size());
		for (WebElement ele : FuelSourceOptions) {
			String option = ele.getText().trim();
			log.info("Current option is -- " + option);
			// log.info(FuelSource);
			if (FuelSource.equals(option)) {
				waithelper.WaitForElementClickable(ele, Integer.parseInt(prop.getProperty("explicitTime")), 2);
				JSHelper.clickElement(ele);
				// ele.click();
				log.info(option + " is selected successfully..");
				break;
			}
		}

		waithelper.WaitForElementClickable(
				driver.findElement(
						By.xpath("//div[@class='modalWindow-footer overflow-auto']/button/span[text()='ADD']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//div[@class='modalWindow-footer overflow-auto']/button/span[text()='ADD']"))
				.click();
		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//span[text()='Details']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//span[text()='Details']")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//div[@class='form-group meterDetails-form--meterName']/input")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		String ActualUnitSelected = driver.findElement(By.xpath("//label[text()='Unit:']/parent::div/div/button/span"))
				.getText().trim();
		String ActualFuelSourceSelected = driver
				.findElement(By.xpath("//label[text()='Fuel Source:']/parent::div/descendant::span")).getText().trim();
		String ActualWaterMeterName = driver
				.findElement(By.xpath("//div[@class='form-group meterDetails-form--meterName']/input"))
				.getAttribute("value");
		String ActualType = driver.findElement(By.xpath("//span[text()='Type:']/following-sibling::span")).getText();

		log.info("Expected Water unit is " + WaterUnit + " and Acutal Water Unit is  " + ActualUnitSelected);
		log.info("Expected FuelSource is " + FuelSource + " and Acutal FuelSource is  " + ActualFuelSourceSelected);
		log.info("Expected MeterName is " + MeterName + " and Acutal MeterName is  " + ActualWaterMeterName);
		if (WaterUnit.equalsIgnoreCase(ActualUnitSelected) && FuelSource.equals(ActualFuelSourceSelected)
				&& MeterName.equals(ActualWaterMeterName) && ActualType.equals("Water")) {
			System.setProperty("WaterMeterName", ActualWaterMeterName);
			log.info("Water_ValidateTypeUnitFuelSourceInDetailsTab method ends here with true.........");
			return true;
		} else {
			log.info("Water_ValidateTypeUnitFuelSourceInDetailsTab method ends here with false.........");
			return false;
		}

	}

	// Building Settings--> Energy --> Verify if Start date is greater than end
	// date, gives Overlapping dates error.
	public boolean Energy_ValidateOverlappingDate() {
		log.info("Energy_ValidateOverlappingDate  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.getProperty("EnergyMeterName");
		driver.findElement(By.xpath("(//table[@class='meterListByType--wrapper']/tbody/tr[2])[1]/td[2]/div")).click();

		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 26st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 1st day of previous month

		flag = driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[text()='Overlapping Dates']"))
				.isDisplayed();

		if (flag) {
			log.info("Energy_ValidateOverlappingDate method ends here with true.........");
			return true;
		} else {
			log.info("Energy_ValidateOverlappingDate method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Carbon Dioxide -> --> Verify if Start date is greater than
	// end
	// date, gives Overlapping dates error.
	public boolean HE_CarbonDioxide_ValidateOverlappingDate() {
		log.info("HE_CarbonDioxide_ValidateOverlappingDate  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 26st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 1st day of previous month

		flag = driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[text()='Overlapping Dates']"))
				.isDisplayed();

		if (flag) {
			log.info("HE_CarbonDioxide_ValidateOverlappingDate method ends here with true.........");
			return true;
		} else {
			log.info("HE_CarbonDioxide_ValidateOverlappingDate method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- TVOC -> --> Verify if Start date is greater than end
	// date, gives Overlapping dates error.
	public boolean HE_TVOC_ValidateOverlappingDate() {
		log.info("HE_TVOC_ValidateOverlappingDate  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 26st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 1st day of previous month

		flag = driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[text()='Overlapping Dates']"))
				.isDisplayed();

		if (flag) {
			log.info("HE_TVOC_ValidateOverlappingDate method ends here with true.........");
			return true;
		} else {
			log.info("HE_TVOC_ValidateOverlappingDate method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- PM2.5 -> --> Verify if Start date is greater than end
	// date, gives Overlapping dates error.
	public boolean HE_PM2_5_ValidateOverlappingDate() {
		log.info("HE_PM2_5_ValidateOverlappingDate  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 26st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 1st day of previous month

		flag = driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[text()='Overlapping Dates']"))
				.isDisplayed();

		if (flag) {
			log.info("HE_PM2_5_ValidateOverlappingDate method ends here with true.........");
			return true;
		} else {
			log.info("HE_PM2_5_ValidateOverlappingDate method ends here with false.........");
			return false;
		}

	}

// Building -> HE- Ozone -> --> Verify if Start date is greater than end
// date, gives Overlapping dates error.
	public boolean HE_Ozone_ValidateOverlappingDate() {
		log.info("HE_Ozone_ValidateOverlappingDate  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 26st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 1st day of previous month

		flag = driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[text()='Overlapping Dates']"))
				.isDisplayed();

		if (flag) {
			log.info("HE_Ozone_ValidateOverlappingDate method ends here with true.........");
			return true;
		} else {
			log.info("HE_Ozone_ValidateOverlappingDate method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Carbon Monoxide -> --> Verify if Start date is greater than
	// end
	// date, gives Overlapping dates error.
	public boolean HE_CarbonMonoxide_ValidateOverlappingDate() {
		log.info("HE_CarbonMonoxide_ValidateOverlappingDate  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 26st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 1st day of previous month

		flag = driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[text()='Overlapping Dates']"))
				.isDisplayed();

		if (flag) {
			log.info("HE_CarbonMonoxide_ValidateOverlappingDate method ends here with true.........");
			return true;
		} else {
			log.info("HE_CarbonMonoxide_ValidateOverlappingDate method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Acetaldehyde -> --> Verify if Start date is greater than end
	// date, gives Overlapping dates error.
	public boolean HE_Acetaldehyde_ValidateOverlappingDate() {
		log.info("HE_Acetaldehyde_ValidateOverlappingDate  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 26st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 1st day of previous month

		flag = driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[text()='Overlapping Dates']"))
				.isDisplayed();

		if (flag) {
			log.info("HE_Acetaldehyde_ValidateOverlappingDate method ends here with true.........");
			return true;
		} else {
			log.info("HE_Acetaldehyde_ValidateOverlappingDate method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Benzene -> --> Verify if Start date is greater than end
	// date, gives Overlapping dates error.
	public boolean HE_Benzene_ValidateOverlappingDate() {
		log.info("HE_Benzene_ValidateOverlappingDate  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 26st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 1st day of previous month

		flag = driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[text()='Overlapping Dates']"))
				.isDisplayed();

		if (flag) {
			log.info("HE_Benzene_ValidateOverlappingDate method ends here with true.........");
			return true;
		} else {
			log.info("HE_Benzene_ValidateOverlappingDate method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Styrene -> --> Verify if Start date is greater than end
	// date, gives Overlapping dates error.
	public boolean HE_Styrene_ValidateOverlappingDate() {
		log.info("HE_Styrene_ValidateOverlappingDate  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 26st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 1st day of previous month

		flag = driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[text()='Overlapping Dates']"))
				.isDisplayed();

		if (flag) {
			log.info("HE_Styrene_ValidateOverlappingDate method ends here with true.........");
			return true;
		} else {
			log.info("HE_Styrene_ValidateOverlappingDate method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Toluene -> --> Verify if Start date is greater than end
	// date, gives Overlapping dates error.
	public boolean HE_Toluene_ValidateOverlappingDate() {
		log.info("HE_Toluene_ValidateOverlappingDate  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 26st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 1st day of previous month

		flag = driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[text()='Overlapping Dates']"))
				.isDisplayed();

		if (flag) {
			log.info("HE_Toluene_ValidateOverlappingDate method ends here with true.........");
			return true;
		} else {
			log.info("HE_Toluene_ValidateOverlappingDate method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Naphthalene -> --> Verify if Start date is greater than end
	// date, gives Overlapping dates error.
	public boolean HE_Naphthalene_ValidateOverlappingDate() {
		log.info("HE_Naphthalene_ValidateOverlappingDate  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 26st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 1st day of previous month

		flag = driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[text()='Overlapping Dates']"))
				.isDisplayed();

		if (flag) {
			log.info("HE_Naphthalene_ValidateOverlappingDate method ends here with true.........");
			return true;
		} else {
			log.info("HE_Naphthalene_ValidateOverlappingDate method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Dichlorobenzene -> --> Verify if Start date is greater than
	// end
	// date, gives Overlapping dates error.
	public boolean HE_Dichlorobenzene_ValidateOverlappingDate() {
		log.info("HE_Dichlorobenzene_ValidateOverlappingDate  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 26st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 1st day of previous month

		flag = driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[text()='Overlapping Dates']"))
				.isDisplayed();

		if (flag) {
			log.info("HE_Dichlorobenzene_ValidateOverlappingDate method ends here with true.........");
			return true;
		} else {
			log.info("HE_Dichlorobenzene_ValidateOverlappingDate method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Xylenes-total -> --> Verify if Start date is greater than
	// end
	// date, gives Overlapping dates error.
	public boolean HE_XylenesTotal_ValidateOverlappingDate() {
		log.info("HE_XylenesTotal_ValidateOverlappingDate  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 26st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 1st day of previous month

		flag = driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[text()='Overlapping Dates']"))
				.isDisplayed();

		if (flag) {
			log.info("HE_XylenesTotal_ValidateOverlappingDate method ends here with true.........");
			return true;
		} else {
			log.info("HE_XylenesTotal_ValidateOverlappingDate method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Formaldehyde -> --> Verify if Start date is greater than
	// end
	// date, gives Overlapping dates error.
	public boolean HE_Formaldehyde_ValidateOverlappingDate() {
		log.info("HE_Formaldehyde_ValidateOverlappingDate  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 26st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 1st day of previous month

		flag = driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[text()='Overlapping Dates']"))
				.isDisplayed();

		if (flag) {
			log.info("HE_Formaldehyde_ValidateOverlappingDate method ends here with true.........");
			return true;
		} else {
			log.info("HE_Formaldehyde_ValidateOverlappingDate method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Carbon Dioxide -> --> Verify Delete button allows you to
	// delete line item.
	public boolean HECarbonDioxide_DeleteRecord() {
		log.info("HECarbonDioxide_DeleteRecord  method starts here.........");
		int TotalRowsBeforeDelete, TotalRowsAfterDelete;
		TotalRowsBeforeDelete = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number showing before delete  " + TotalRowsBeforeDelete);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (TotalRowsBeforeDelete > 0) {
			try {
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[8]/span")).click();
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to delete record ....");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		TotalRowsAfterDelete = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + TotalRowsAfterDelete);

		if (TotalRowsBeforeDelete - TotalRowsAfterDelete == 1) {
			log.info("HECarbonDioxide_DeleteRecord method ends here with true.........");
			return true;
		} else {
			log.info("HECarbonDioxide_DeleteRecord method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- TVOC -> --> Verify Delete button allows you to delete line
	// item.
	public boolean HETVOC_DeleteRecord() {
		log.info("HETVOC_DeleteRecord  method starts here.........");
		int TotalRowsBeforeDelete, TotalRowsAfterDelete;
		TotalRowsBeforeDelete = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number showing before delete  " + TotalRowsBeforeDelete);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (TotalRowsBeforeDelete > 0) {
			try {
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[8]/span")).click();
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to delete record ....");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		TotalRowsAfterDelete = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + TotalRowsAfterDelete);

		if (TotalRowsBeforeDelete - TotalRowsAfterDelete == 1) {
			log.info("HETVOC_DeleteRecord method ends here with true.........");
			return true;
		} else {
			log.info("HETVOC_DeleteRecord method ends here with false.........");
			return false;
		}

	}

// Building -> HE- PM2.5 -> --> Verify Delete button allows you to delete line item.
	public boolean HEPM2_5_DeleteRecord() {
		log.info("HEPM2_5_DeleteRecord  method starts here.........");
		int TotalRowsBeforeDelete, TotalRowsAfterDelete;
		TotalRowsBeforeDelete = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number showing before delete  " + TotalRowsBeforeDelete);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (TotalRowsBeforeDelete > 0) {
			try {
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[7]/span")).click();
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to delete record ....");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		TotalRowsAfterDelete = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + TotalRowsAfterDelete);

		if (TotalRowsBeforeDelete - TotalRowsAfterDelete == 1) {
			log.info("HEPM2_5_DeleteRecord method ends here with true.........");
			return true;
		} else {
			log.info("HEPM2_5_DeleteRecord method ends here with false.........");
			return false;
		}

	}

//Building -> HE- Ozone -> --> Verify Delete button allows you to delete line item.
	public boolean HEOzone_DeleteRecord() {
		log.info("HEOzone_DeleteRecord  method starts here.........");
		int TotalRowsBeforeDelete, TotalRowsAfterDelete;
		TotalRowsBeforeDelete = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number showing before delete  " + TotalRowsBeforeDelete);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (TotalRowsBeforeDelete > 0) {
			try {
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[7]/span")).click();
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to delete record ....");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		TotalRowsAfterDelete = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + TotalRowsAfterDelete);

		if (TotalRowsBeforeDelete - TotalRowsAfterDelete == 1) {
			log.info("HEOzone_DeleteRecord method ends here with true.........");
			return true;
		} else {
			log.info("HEOzone_DeleteRecord method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Carbon Monoxide -> --> Verify Delete button allows you to
	// delete line item.
	public boolean HE_CarbonMonoxide_DeleteRecord() {
		log.info("HE_CarbonMonoxide_DeleteRecord  method starts here.........");
		int TotalRowsBeforeDelete = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number showing before delete  " + TotalRowsBeforeDelete);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (TotalRowsBeforeDelete > 0) {
			try {
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[7]/span")).click();
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to delete record ....");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int TotalRowsAfterDelete = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + TotalRowsAfterDelete);

		if (TotalRowsBeforeDelete - TotalRowsAfterDelete == 1) {
			log.info("HE_CarbonMonoxide_DeleteRecord method ends here with true.........");
			return true;
		} else {
			log.info("HE_CarbonMonoxide_DeleteRecord method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Acetaldehyde -> --> Verify Delete button allows you to delete
	// line item.
	public boolean HE_Acetaldehyde_DeleteRecord() {
		log.info("HE_Acetaldehyde_DeleteRecord  method starts here.........");
		int TotalRowsBeforeDelete = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number showing before delete  " + TotalRowsBeforeDelete);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (TotalRowsBeforeDelete > 0) {
			try {
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[7]/span")).click();
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to delete record ....");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int TotalRowsAfterDelete = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + TotalRowsAfterDelete);

		if (TotalRowsBeforeDelete - TotalRowsAfterDelete == 1) {
			log.info("HE_Acetaldehyde_DeleteRecord method ends here with true.........");
			return true;
		} else {
			log.info("HE_Acetaldehyde_DeleteRecord method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Styrene -> --> Verify Delete button allows you to delete line
	// item.
	public boolean HE_Styrene_DeleteRecord() {
		log.info("HE_Styrene_DeleteRecord  method starts here.........");
		int TotalRowsBeforeDelete = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number showing before delete  " + TotalRowsBeforeDelete);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (TotalRowsBeforeDelete > 0) {
			try {
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[7]/span")).click();
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to delete record ....");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int TotalRowsAfterDelete = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + TotalRowsAfterDelete);

		if (TotalRowsBeforeDelete - TotalRowsAfterDelete == 1) {
			log.info("HE_Styrene_DeleteRecord method ends here with true.........");
			return true;
		} else {
			log.info("HE_Styrene_DeleteRecord method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Toluene -> --> Verify Delete button allows you to delete line
	// item.
	public boolean HE_Toluene_DeleteRecord() {
		log.info("HE_Toluene_DeleteRecord  method starts here.........");
		int TotalRowsBeforeDelete = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number showing before delete  " + TotalRowsBeforeDelete);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ngWebDriver.waitForAngularRequestsToFinish();
		if (TotalRowsBeforeDelete > 0) {
			try {
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[7]/span")).click();
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to delete record ....");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ngWebDriver.waitForAngularRequestsToFinish();
		}
		int TotalRowsAfterDelete = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + TotalRowsAfterDelete);

		if (TotalRowsBeforeDelete - TotalRowsAfterDelete == 1) {
			log.info("HE_Toluene_DeleteRecord method ends here with true.........");
			return true;
		} else {
			log.info("HE_Toluene_DeleteRecord method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Naphthalene -> --> Verify Delete button allows you to delete
	// line item.
	public boolean HE_Naphthalene_DeleteRecord() {
		log.info("HE_Naphthalene_DeleteRecord  method starts here.........");
		int TotalRowsBeforeDelete = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number showing before delete  " + TotalRowsBeforeDelete);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (TotalRowsBeforeDelete > 0) {
			try {
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[7]/span")).click();
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to delete record ....");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int TotalRowsAfterDelete = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + TotalRowsAfterDelete);

		if (TotalRowsBeforeDelete - TotalRowsAfterDelete == 1) {
			log.info("HE_Naphthalene_DeleteRecord method ends here with true.........");
			return true;
		} else {
			log.info("HE_Naphthalene_DeleteRecord method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Dichlorobenzene -> --> Verify Delete button allows you to
	// delete line item.
	public boolean HE_Dichlorobenzene_DeleteRecord() {
		log.info("HE_Dichlorobenzene_DeleteRecord  method starts here.........");
		int TotalRowsBeforeDelete = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number showing before delete  " + TotalRowsBeforeDelete);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (TotalRowsBeforeDelete > 0) {
			try {
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[7]/span")).click();
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to delete record ....");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int TotalRowsAfterDelete = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + TotalRowsAfterDelete);

		if (TotalRowsBeforeDelete - TotalRowsAfterDelete == 1) {
			log.info("HE_Dichlorobenzene_DeleteRecord method ends here with true.........");
			return true;
		} else {
			log.info("HE_Dichlorobenzene_DeleteRecord method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Xylenes-total -> --> Verify Delete button allows you to
	// delete line item.
	public boolean HE_XylenesTotal_DeleteRecord() {
		log.info("HE_XylenesTotal_DeleteRecord  method starts here.........");
		int TotalRowsBeforeDelete = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number showing before delete  " + TotalRowsBeforeDelete);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (TotalRowsBeforeDelete > 0) {
			try {
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[7]/span")).click();
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to delete record ....");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int TotalRowsAfterDelete = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + TotalRowsAfterDelete);

		if (TotalRowsBeforeDelete - TotalRowsAfterDelete == 1) {
			log.info("HE_XylenesTotal_DeleteRecord method ends here with true.........");
			return true;
		} else {
			log.info("HE_XylenesTotal_DeleteRecord method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Formaldehyde -> --> Verify Delete button allows you to
	// delete line item.
	public boolean HE_Formaldehyde_DeleteRecord() {
		log.info("HE_Formaldehyde_DeleteRecord  method starts here.........");
		int TotalRowsBeforeDelete = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number showing before delete  " + TotalRowsBeforeDelete);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (TotalRowsBeforeDelete > 0) {
			try {
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[7]/span")).click();
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to delete record ....");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int TotalRowsAfterDelete = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + TotalRowsAfterDelete);

		if (TotalRowsBeforeDelete - TotalRowsAfterDelete == 1) {
			log.info("HE_Formaldehyde_DeleteRecord method ends here with true.........");
			return true;
		} else {
			log.info("HE_Formaldehyde_DeleteRecord method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Benzene -> --> Verify Delete button allows you to delete line
	// item.
	public boolean HE_Benzene_DeleteRecord() {
		log.info("HE_Benzene_DeleteRecord  method starts here.........");
		int TotalRowsBeforeDelete = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number showing before delete  " + TotalRowsBeforeDelete);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (TotalRowsBeforeDelete > 0) {
			try {
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[7]/span")).click();
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to delete record ....");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int TotalRowsAfterDelete = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + TotalRowsAfterDelete);

		if (TotalRowsBeforeDelete - TotalRowsAfterDelete == 1) {
			log.info("HE_Benzene_DeleteRecord method ends here with true.........");
			return true;
		} else {
			log.info("HE_Benzene_DeleteRecord method ends here with false.........");
			return false;
		}

	}

	// Building Settings--> Water --> Verify if Start date is greater than end
	// date, gives Overlapping dates error.
	public boolean Water_ValidateOverlappingDate() {
		log.info("Water_ValidateOverlappingDate  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.getProperty("WaterMeterName");
		driver.findElement(By.xpath("(//table[@class='meterListByType--wrapper']/tbody/tr[2])[2]/td[2]/div")).click();

		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BuildingSetting_AddRow_button.click();

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 26st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 1st day of previous month

		flag = driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[text()='Overlapping Dates']"))
				.isDisplayed();

		if (flag) {
			log.info("Water_ValidateOverlappingDate method ends here with true.........");
			return true;
		} else {
			log.info("Water_ValidateOverlappingDate method ends here with false.........");
			return false;
		}

	}

	// Building Settings--> Waste Data --> Verify if Start date is greater than end
	// date, gives Overlapping dates error.

	public boolean WasteData_ValidateOverlappingDate() {
		log.info("WasteData_ValidateOverlappingDate  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='wasteTable']/tbody/tr[1]/td[2]/input")).click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='10'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 10th day of previous month
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='wasteTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 1st day of previous month

		flag = driver.findElement(By.xpath("//table[@id='wasteTable']/tbody/tr[1]/td[2]/p[text()='Overlapping Dates']"))
				.isDisplayed();
		/*
		 * try { driver.findElement(By.xpath(
		 * "//table[@id='wasteTable']/tbody/tr[1]/td[10]/span")).click(); }
		 * catch(Exception e) { e.printStackTrace(); }
		 */
		if (flag) {
			log.info("WasteData_ValidateOverlappingDate method ends here with true.........");
			return true;
		} else {
			log.info("WasteData_ValidateOverlappingDate method ends here with false.........");
			return false;
		}

	}

	// Building Settings--> Energy --> Verify Clicking on add row allows to add
	// start date,end date and reading
	public boolean Energy_AddRecord() {
		log.info("Energy_AddRecord  method starts here.........");
		int BeforeTotalRows = 0;
		int AfterTotalRows = 0;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.getProperty("EnergyMeterName");
		waithelper.WaitForElementClickable(
				driver.findElement(By.xpath("(//table[@class='meterListByType--wrapper']/tbody/tr[2])[1]/td[2]/div")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		driver.findElement(By.xpath("(//table[@class='meterListByType--wrapper']/tbody/tr[2])[1]/td[2]/div")).click();
		BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows before adding showing are  " + BeforeTotalRows);
		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 1st day of previous month
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='25'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 25st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/input"))
				.sendKeys(data.getCellData("Building", 15, 2));

		// driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/input")).sendKeys(data.getCellData("Building",
		// 16, 2));

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[7]/button")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(
						By.xpath("(//table[@class='meterListByType--wrapper']/tbody/tr[1])[1]/td[3]/div/span/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody/tr[1])[1]/td[3]/div/span/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AfterTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + AfterTotalRows);

		if (AfterTotalRows - BeforeTotalRows == 1) {
			log.info("Energy_AddRecord method ends here with true.........");
			return true;
		} else {
			log.info("Energy_AddRecord method ends here with false.........");
			return false;
		}

	}

	// Building -> Operating Hours-> Verify able to upload file successfully using
	// Documentation dropdown using Computer upload option.
	public boolean OperatingHours_ValidateDocument() {
		log.info("OperatingHours_ValidateDocument  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows showing are  " + BeforeTotalRows);
		if (BeforeTotalRows > 0) {
			log.info("Going to upload document..");

			//String UploadPath = System.getProperty("user.dir") + "\\UploadDocument\\File1.pdf";
			String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/div/button")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			driver.findElement(By
					.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/div/ul/li/span[text()='Computer File']"))
					.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			WebElement element = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input"));
			JSHelper.displayHiddenElement(element);
			element.sendKeys(UploadPath);
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			/*
			 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
			 * try { waithelper.WaitForElementVisibleWithPollingTime(
			 * driver.findElement(By.xpath("//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
			 * 
			 * waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
			 * "//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2); } catch (Exception e)
			 * { e.printStackTrace(); }
			 * 
			 * try { waithelper.WaitForElementVisibleWithPollingTime(
			 * driver.findElement(By.xpath("//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
			 * 
			 * waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
			 * "//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2); } catch (Exception e)
			 * { e.printStackTrace(); } // TODO: handle exception
			 */
		}

		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String FileCount = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/span"))
					.getText();
			log.info("File Count showing is " + FileCount);
			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Uploaded File Count...");
			flag = false;
		}

		if (flag) {
			log.info("OperatingHours_ValidateDocument method ends here with true.........");
			return true;
		} else {
			log.info("OperatingHours_ValidateDocument method ends here with false.........");
			return false;
		}

	}

	// Building -> Gross Floor Area-> Verify able to upload file successfully using
	// Documentation dropdown using Computer upload option.
	public boolean GrossFloorArea_ValidateDocument() {
		log.info("GrossFloorArea_ValidateDocument  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows showing are  " + BeforeTotalRows);
		if (BeforeTotalRows > 0) {
			log.info("Going to upload document..");

			String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/div/button")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			driver.findElement(By
					.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/div/ul/li/span[text()='Computer File']"))
					.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			WebElement element = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/input"));
			JSHelper.displayHiddenElement(element);
			element.sendKeys(UploadPath);
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			/*
			 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
			 * try { waithelper.WaitForElementVisibleWithPollingTime(
			 * driver.findElement(By.xpath("//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
			 * 
			 * waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
			 * "//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2); } catch (Exception e)
			 * { e.printStackTrace(); }
			 * 
			 * try { waithelper.WaitForElementVisibleWithPollingTime(
			 * driver.findElement(By.xpath("//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
			 * 
			 * waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
			 * "//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2); } catch (Exception e)
			 * { e.printStackTrace(); } // TODO: handle exception
			 */
		}

		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String FileCount = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/span"))
					.getText();
			log.info("File Count showing is " + FileCount);
			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Uploaded File Count...");
			flag = false;
		}

		if (flag) {
			log.info("GrossFloorArea_ValidateDocument method ends here with true.........");
			return true;
		} else {
			log.info("GrossFloorArea_ValidateDocument method ends here with false.........");
			return false;
		}

	}

	// Building -> Emissions Factor-> Verify able to upload file successfully using
	// Documentation dropdown using Computer upload option.
	public boolean EmissionsFactor_ValidateDocument() {
		log.info("EmissionsFactor_ValidateDocument  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows showing are  " + BeforeTotalRows);
		if (BeforeTotalRows > 0) {
			log.info("Going to upload document..");

			String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/div/button")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			driver.findElement(By
					.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/div/ul/li/span[text()='Computer File']"))
					.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			WebElement element = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input"));
			JSHelper.displayHiddenElement(element);
			element.sendKeys(UploadPath);
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			/*
			 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
			 * try { waithelper.WaitForElementVisibleWithPollingTime(
			 * driver.findElement(By.xpath("//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
			 * 
			 * waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
			 * "//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2); } catch (Exception e)
			 * { e.printStackTrace(); }
			 */
		}

		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String FileCount = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/span"))
					.getText();
			log.info("File Count showing is " + FileCount);
			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Uploaded File Count...");
			flag = false;
		}

		if (flag) {
			log.info("EmissionsFactor_ValidateDocument method ends here with true.........");
			return true;
		} else {
			log.info("EmissionsFactor_ValidateDocument method ends here with false.........");
			return false;
		}

	}

	// Building -> Operational Days-> Verify able to upload file successfully using
	// Documentation dropdown using Computer upload option.
	public boolean OperationalDays_ValidateDocument() {
		log.info("OperationalDays_ValidateDocument  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows showing are  " + BeforeTotalRows);
		if (BeforeTotalRows > 0) {
			log.info("Going to upload document..");

			String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/div/button")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			driver.findElement(By
					.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/div/ul/li/span[text()='Computer File']"))
					.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			WebElement element = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input"));
			JSHelper.displayHiddenElement(element);
			element.sendKeys(UploadPath);
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/*
			 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
			 * try { waithelper.WaitForElementVisibleWithPollingTime(
			 * driver.findElement(By.xpath("//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
			 * 
			 * waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
			 * "//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2); } catch (Exception e)
			 * { e.printStackTrace(); } // TODO: handle exception
			 */
		}

		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String FileCount = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/span"))
					.getText();
			log.info("File Count showing is " + FileCount);
			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Uploaded File Count...");
			flag = false;
		}

		if (flag) {
			log.info("OperationalDays_ValidateDocument method ends here with true.........");
			return true;
		} else {
			log.info("OperationalDays_ValidateDocument method ends here with false.........");
			return false;
		}

	}

	// Building -> Occupant-> Verify able to upload file successfully using
	// Documentation dropdown using Computer upload option.
	public boolean Occupant_ValidateDocument() {
		log.info("Occupant_ValidateDocument  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows showing are  " + BeforeTotalRows);
		if (BeforeTotalRows > 0) {
			log.info("Going to upload document..");

			String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/div/button")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			driver.findElement(By
					.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/div/ul/li/span[text()='Computer File']"))
					.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			WebElement element = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/input"));
			JSHelper.displayHiddenElement(element);
			element.sendKeys(UploadPath);
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			/*
			 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
			 * try { waithelper.WaitForElementVisibleWithPollingTime(
			 * driver.findElement(By.xpath("//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
			 * 
			 * waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
			 * "//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2); } catch (Exception e)
			 * { e.printStackTrace(); }
			 */

		}

		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String FileCount = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/span"))
					.getText();
			log.info("File Count showing is " + FileCount);
			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Uploaded File Count...");
			flag = false;
		}

		if (flag) {
			log.info("Occupant_ValidateDocument method ends here with true.........");
			return true;
		} else {
			log.info("Occupant_ValidateDocument method ends here with false.........");
			return false;
		}

	}

	// Building Settings--> Energy --> Validate documents added in the row item are
	// displayed under Documents tab.
	public boolean Energy_ValidateDocument() {
		log.info("Energy_ValidateDocument  method starts here.........");
		boolean flag = false;
		int BeforeTotalRows = 0;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String EnergyMeterName = System.getProperty("EnergyMeterName");
		// EnergyMeterName = "E-BPWFKT";
		driver.findElement(By.xpath(
				"//div[@class='fw600 mb5' and text()='Energy']/ancestor::tr/following-sibling::tr[1]/td[2]/div[contains(text(),'"
						+ EnergyMeterName + "')]"))
				.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows showing are  " + BeforeTotalRows);
		if (BeforeTotalRows > 0) {
			log.info("Going to upload document..");
			String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/div/div/button")).click();

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			driver.findElement(By
					.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/div/div/ul/li/span[text()='Computer File']"))
					.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			WebElement element = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/input"));
			JSHelper.displayHiddenElement(element);
			element.sendKeys(UploadPath);
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			/*
			 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
			 * try { waithelper.WaitForElementVisibleWithPollingTime(
			 * driver.findElement(By.xpath("//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
			 * 
			 * waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
			 * "//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2); } catch (Exception e)
			 * { e.printStackTrace(); }
			 */
		}

		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//span[text()='Documents']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		driver.findElement(By.xpath("//span[text()='Documents']")).click();
		List<WebElement> DocumentList = driver.findElements(By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr"));
		int RowsInDocument = DocumentList.size();
		if (RowsInDocument > 0) {
			for (int i = 0; i < RowsInDocument; i++) {
				if (driver
						.findElement(
								By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[2]/div/a"))
						.getText().equals(EnergyMeterName)) {
					log.info("Energy Meter row found...");
					String FileName = driver
							.findElement(By
									.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[1]/span"))
							.getText().trim();
					if (FileName.equals("File1.pdf")) {
						log.info("Document found with Energy meter..");
						flag = true;
						break;
					} else {
						flag = false;
					}
				} else {
					log.info("Energy Meter row not found...");
				}

			}
		}

		if (flag) {
			log.info("Energy_ValidateDocument method ends here with true.........");
			return true;
		} else {
			log.info("Energy_ValidateDocument method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Carbon Dioxide -> --> Validate documents added in the row
	// item are
	// displayed under Documents tab.
	public boolean HECarbonDioxide_ValidateDocument() {
		log.info("HECarbonDioxide_ValidateDocument  method starts here.........");
		boolean flag = false;
		int BeforeTotalRows;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows showing are  " + BeforeTotalRows);
		if (BeforeTotalRows > 0) {
			log.info("Going to upload document..");

			String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/div/div/button")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			driver.findElement(By
					.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/div/div/ul/li/span[text()='Computer File']"))
					.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			WebElement element = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/input"));
			JSHelper.displayHiddenElement(element);
			element.sendKeys(UploadPath);
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			/*
			 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
			 * try { waithelper.WaitForElementVisibleWithPollingTime(
			 * driver.findElement(By.xpath("//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
			 * 
			 * waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
			 * "//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2); } catch (Exception e)
			 * { e.printStackTrace(); }
			 */
		}

		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//span[text()='Documents']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		driver.findElement(By.xpath("//span[text()='Documents']")).click();
		List<WebElement> DocumentList = driver.findElements(By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr"));
		int RowsInDocument = DocumentList.size();
		if (RowsInDocument > 0) {
			for (int i = 0; i < RowsInDocument; i++) {
				if (driver
						.findElement(
								By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[2]/div/a"))
						.getText().equals("Carbon Dioxide")) {
					log.info("Carbon Dioxide row found...");
					String FileName = driver
							.findElement(By
									.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[1]/span"))
							.getText().trim();
					if (FileName.equals("File1.pdf")) {
						log.info("Document found with Carbon Dioxide..");
						flag = true;
						break;
					} else {
						log.info("Document found with other name.." + FileName);
						flag = false;
					}
				} else {
					log.info("Carbon Dioxide row not found...");
				}

			}
		}

		if (flag) {
			log.info("HECarbonDioxide_ValidateDocument method ends here with true.........");
			return true;
		} else {
			log.info("HECarbonDioxide_ValidateDocument method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- TVOC -> --> Validate documents added in the row item are
	// displayed under Documents tab.
	public boolean HETVOC_ValidateDocument() {
		log.info("HETVOC_ValidateDocument  method starts here.........");
		boolean flag = false;
		int BeforeTotalRows;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows showing are  " + BeforeTotalRows);
		if (BeforeTotalRows > 0) {
			log.info("Going to upload document..");

			String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/div/div/button")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			driver.findElement(By
					.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/div/div/ul/li/span[text()='Computer File']"))
					.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			WebElement element = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/input"));
			JSHelper.displayHiddenElement(element);
			element.sendKeys(UploadPath);
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			/*
			 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
			 * try { waithelper.WaitForElementVisibleWithPollingTime(
			 * driver.findElement(By.xpath("//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
			 * 
			 * waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
			 * "//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2); } catch (Exception e)
			 * { e.printStackTrace(); }
			 */

		}

		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//span[text()='Documents']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		driver.findElement(By.xpath("//span[text()='Documents']")).click();
		List<WebElement> DocumentList = driver.findElements(By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr"));
		int RowsInDocument = DocumentList.size();
		if (RowsInDocument > 0) {
			for (int i = 0; i < RowsInDocument; i++) {
				if (driver
						.findElement(
								By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[2]/div/a"))
						.getText().equals("Total Volatile Organic Compounds")) {
					log.info("Total Volatile Organic Compounds row found...");
					String FileName = driver
							.findElement(By
									.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[1]/span"))
							.getText().trim();
					if (FileName.equals("File1.pdf")) {
						log.info("Document found with TVOC..");
						flag = true;
						break;
					} else {
						log.info("Document found with other name.." + FileName);
						flag = false;
					}
				} else {
					log.info("TVOC row not found...");
				}

			}
		}

		if (flag) {
			log.info("HETVOC_ValidateDocument method ends here with true.........");
			return true;
		} else {
			log.info("HETVOC_ValidateDocument method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- PM2.5 -> --> Validate documents added in the row item are
	// displayed under Documents tab.
	public boolean HE_PM2_5_ValidateDocument() {
		log.info("HE_PM2_5_ValidateDocument  method starts here.........");
		boolean flag = false;
		int BeforeTotalRows;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows showing are  " + BeforeTotalRows);
		if (BeforeTotalRows > 0) {
			log.info("Going to upload document..");

			String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/div/button")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			driver.findElement(By
					.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/div/ul/li/span[text()='Computer File']"))
					.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			WebElement element = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/input"));
			JSHelper.displayHiddenElement(element);
			element.sendKeys(UploadPath);
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			/*
			 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
			 * try { waithelper.WaitForElementVisibleWithPollingTime(
			 * driver.findElement(By.xpath("//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
			 * 
			 * waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
			 * "//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2); } catch (Exception e)
			 * { e.printStackTrace(); }
			 */
		}

		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//span[text()='Documents']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		driver.findElement(By.xpath("//span[text()='Documents']")).click();
		List<WebElement> DocumentList = driver.findElements(By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr"));
		int RowsInDocument = DocumentList.size();
		if (RowsInDocument > 0) {
			for (int i = 0; i < RowsInDocument; i++) {
				if (driver
						.findElement(
								By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[2]/div/a"))
						.getText().equals("Atmospheric Particulate Matter (PM2.5)")) {
					log.info("Carbon Dioxide row found...");
					String FileName = driver
							.findElement(By
									.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[1]/span"))
							.getText().trim();
					if (FileName.equals("File1.pdf")) {
						log.info("Document found with PM2.5..");
						flag = true;
						break;
					} else {
						log.info("Document found with other name.." + FileName);
						flag = false;
					}
				} else {
					log.info("PM2.5 row not found...");
				}

			}
		}

		if (flag) {
			log.info("HE_PM2_5_ValidateDocument method ends here with true.........");
			return true;
		} else {
			log.info("HE_PM2_5_ValidateDocument method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Ozone -> --> Validate documents added in the row item are
	// displayed under Documents tab.
	public boolean HE_Ozone_ValidateDocument() {
		log.info("HE_Ozone_ValidateDocument  method starts here.........");
		boolean flag = false;
		int BeforeTotalRows;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows showing are  " + BeforeTotalRows);
		if (BeforeTotalRows > 0) {
			log.info("Going to upload document..");

			String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/div/button")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			driver.findElement(By
					.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/div/ul/li/span[text()='Computer File']"))
					.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			WebElement element = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/input"));
			JSHelper.displayHiddenElement(element);
			element.sendKeys(UploadPath);
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			/*
			 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
			 * try { waithelper.WaitForElementVisibleWithPollingTime(
			 * driver.findElement(By.xpath("//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
			 * 
			 * waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
			 * "//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2); } catch (Exception e)
			 * { e.printStackTrace(); }
			 */
		}

		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//span[text()='Documents']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		driver.findElement(By.xpath("//span[text()='Documents']")).click();
		List<WebElement> DocumentList = driver.findElements(By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr"));
		int RowsInDocument = DocumentList.size();
		if (RowsInDocument > 0) {
			for (int i = 0; i < RowsInDocument; i++) {
				if (driver
						.findElement(
								By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[2]/div/a"))
						.getText().equals("Ozone")) {
					log.info("Ozone row found...");
					String FileName = driver
							.findElement(By
									.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[1]/span"))
							.getText().trim();
					if (FileName.equals("File1.pdf")) {
						log.info("Document found with Ozone..");
						flag = true;
						break;
					} else {
						log.info("Document found with other name.." + FileName);
						flag = false;
					}
				} else {
					log.info("Ozone row not found...");
				}

			}
		}

		if (flag) {
			log.info("HE_Ozone_ValidateDocument method ends here with true.........");
			return true;
		} else {
			log.info("HE_Ozone_ValidateDocument method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Acetaldehyde -> --> Validate documents added in the row item
	// are
	// displayed under Documents tab.
	public boolean HE_Acetaldehyde_ValidateDocument() {
		log.info("HE_Acetaldehyde_ValidateDocument  method starts here.........");
		boolean flag = false;
		int BeforeTotalRows;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows showing are  " + BeforeTotalRows);
		if (BeforeTotalRows > 0) {
			log.info("Going to upload document..");

			String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/div/button")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			driver.findElement(By
					.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/div/ul/li/span[text()='Computer File']"))
					.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			WebElement element = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/input"));
			JSHelper.displayHiddenElement(element);
			element.sendKeys(UploadPath);
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			/*
			 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
			 * try { waithelper.WaitForElementVisibleWithPollingTime(
			 * driver.findElement(By.xpath("//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
			 * 
			 * waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
			 * "//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2); } catch (Exception e)
			 * { e.printStackTrace(); }
			 */
		}

		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//span[text()='Documents']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		driver.findElement(By.xpath("//span[text()='Documents']")).click();
		List<WebElement> DocumentList = driver.findElements(By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr"));
		int RowsInDocument = DocumentList.size();
		if (RowsInDocument > 0) {
			for (int i = 0; i < RowsInDocument; i++) {
				if (driver
						.findElement(
								By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[2]/div/a"))
						.getText().equals("Acetaldehyde")) {
					log.info("Acetaldehyde row found...");
					String FileName = driver
							.findElement(By
									.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[1]/span"))
							.getText().trim();
					if (FileName.equals("File1.pdf")) {
						log.info("Document found with Acetaldehyde..");
						flag = true;
						break;
					} else {
						log.info("Document found with other name.." + FileName);
						flag = false;
					}
				} else {
					log.info("Acetaldehyde row not found...");
				}

			}
		}

		if (flag) {
			log.info("HE_Acetaldehyde_ValidateDocument method ends here with true.........");
			return true;
		} else {
			log.info("HE_Acetaldehyde_ValidateDocument method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Benzene -> --> Validate documents added in the row item are
	// displayed under Documents tab.
	public boolean HE_Benzene_ValidateDocument() {
		log.info("HE_Benzene_ValidateDocument  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows showing are  " + BeforeTotalRows);
		if (BeforeTotalRows > 0) {
			log.info("Going to upload document..");

			String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/div/button")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			driver.findElement(By
					.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/div/ul/li/span[text()='Computer File']"))
					.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			WebElement element = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/input"));
			JSHelper.displayHiddenElement(element);
			element.sendKeys(UploadPath);
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			/*
			 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
			 * try { waithelper.WaitForElementVisibleWithPollingTime(
			 * driver.findElement(By.xpath("//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
			 * 
			 * waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
			 * "//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2); } catch (Exception e)
			 * { e.printStackTrace(); }
			 */
		}

		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//span[text()='Documents']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		driver.findElement(By.xpath("//span[text()='Documents']")).click();
		List<WebElement> DocumentList = driver.findElements(By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr"));
		int RowsInDocument = DocumentList.size();
		if (RowsInDocument > 0) {
			for (int i = 0; i < RowsInDocument; i++) {
				if (driver
						.findElement(
								By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[2]/div/a"))
						.getText().equals("Benzene")) {
					log.info("Benzene row found...");
					String FileName = driver
							.findElement(By
									.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[1]/span"))
							.getText().trim();
					if (FileName.equals("File1.pdf")) {
						log.info("Document found with Benzene..");
						flag = true;
						break;
					} else {
						log.info("Document found with other name.." + FileName);
						flag = false;
					}
				} else {
					log.info("Benzene row not found...");
				}

			}
		}

		if (flag) {
			log.info("HE_Benzene_ValidateDocument method ends here with true.........");
			return true;
		} else {
			log.info("HE_Benzene_ValidateDocument method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Styrene -> --> Validate documents added in the row item are
	// displayed under Documents tab.
	public boolean HE_Styrene_ValidateDocument() {
		log.info("HE_Styrene_ValidateDocument  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows showing are  " + BeforeTotalRows);
		if (BeforeTotalRows > 0) {
			log.info("Going to upload document..");

			String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/div/button")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			driver.findElement(By
					.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/div/ul/li/span[text()='Computer File']"))
					.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			WebElement element = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/input"));
			JSHelper.displayHiddenElement(element);
			element.sendKeys(UploadPath);
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			/*
			 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
			 * try { waithelper.WaitForElementVisibleWithPollingTime(
			 * driver.findElement(By.xpath("//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
			 * 
			 * waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
			 * "//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2); } catch (Exception e)
			 * { e.printStackTrace(); }
			 */
		}

		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//span[text()='Documents']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		driver.findElement(By.xpath("//span[text()='Documents']")).click();
		List<WebElement> DocumentList = driver.findElements(By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr"));
		int RowsInDocument = DocumentList.size();
		if (RowsInDocument > 0) {
			for (int i = 0; i < RowsInDocument; i++) {
				if (driver
						.findElement(
								By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[2]/div/a"))
						.getText().equals("Styrene")) {
					log.info("Styrene row found...");
					String FileName = driver
							.findElement(By
									.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[1]/span"))
							.getText().trim();
					if (FileName.equals("File1.pdf")) {
						log.info("Document found with Styrene..");
						flag = true;
						break;
					} else {
						log.info("Document found with other name.." + FileName);
						flag = false;
					}
				} else {
					log.info("Styrene row not found...");
				}

			}
		}

		if (flag) {
			log.info("HE_Styrene_ValidateDocument method ends here with true.........");
			return true;
		} else {
			log.info("HE_Styrene_ValidateDocument method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Toluene -> --> Validate documents added in the row item are
	// displayed under Documents tab.
	public boolean HE_Toluene_ValidateDocument() {
		log.info("HE_Toluene_ValidateDocument  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows showing are  " + BeforeTotalRows);
		if (BeforeTotalRows > 0) {
			log.info("Going to upload document..");

			String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/div/button")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			driver.findElement(By
					.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/div/ul/li/span[text()='Computer File']"))
					.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			WebElement element = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/input"));
			JSHelper.displayHiddenElement(element);
			element.sendKeys(UploadPath);
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			/*
			 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
			 * try { waithelper.WaitForElementVisibleWithPollingTime(
			 * driver.findElement(By.xpath("//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
			 * 
			 * waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
			 * "//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2); } catch (Exception e)
			 * { e.printStackTrace(); }
			 */
		}

		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//span[text()='Documents']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		driver.findElement(By.xpath("//span[text()='Documents']")).click();
		List<WebElement> DocumentList = driver.findElements(By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr"));
		int RowsInDocument = DocumentList.size();
		if (RowsInDocument > 0) {
			for (int i = 0; i < RowsInDocument; i++) {
				if (driver
						.findElement(
								By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[2]/div/a"))
						.getText().equals("Toluene")) {
					log.info("Toluene row found...");
					String FileName = driver
							.findElement(By
									.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[1]/span"))
							.getText().trim();
					if (FileName.equals("File1.pdf")) {
						log.info("Document found with Toluene..");
						flag = true;
						break;
					} else {
						log.info("Document found with other name.." + FileName);
						flag = false;
					}
				} else {
					log.info("Toluene row not found...");
				}

			}
		}

		if (flag) {
			log.info("HE_Toluene_ValidateDocument method ends here with true.........");
			return true;
		} else {
			log.info("HE_Toluene_ValidateDocument method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Naphthalene -> --> Validate documents added in the row item
	// are
	// displayed under Documents tab.
	public boolean HE_Naphthalene_ValidateDocument() {
		log.info("HE_Naphthalene_ValidateDocument  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows showing are  " + BeforeTotalRows);
		if (BeforeTotalRows > 0) {
			log.info("Going to upload document..");

			String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/div/button")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			driver.findElement(By
					.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/div/ul/li/span[text()='Computer File']"))
					.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			WebElement element = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/input"));
			JSHelper.displayHiddenElement(element);
			element.sendKeys(UploadPath);
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			/*
			 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
			 * try { waithelper.WaitForElementVisibleWithPollingTime(
			 * driver.findElement(By.xpath("//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
			 * 
			 * waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
			 * "//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2); } catch (Exception e)
			 * { e.printStackTrace(); }
			 */
		}

		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//span[text()='Documents']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		driver.findElement(By.xpath("//span[text()='Documents']")).click();
		List<WebElement> DocumentList = driver.findElements(By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr"));
		int RowsInDocument = DocumentList.size();
		if (RowsInDocument > 0) {
			for (int i = 0; i < RowsInDocument; i++) {
				if (driver
						.findElement(
								By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[2]/div/a"))
						.getText().equals("Naphthalene")) {
					log.info("Naphthalene row found...");
					String FileName = driver
							.findElement(By
									.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[1]/span"))
							.getText().trim();
					if (FileName.equals("File1.pdf")) {
						log.info("Document found with Naphthalene..");
						flag = true;
						break;
					} else {
						log.info("Document found with other name.." + FileName);
						flag = false;
					}
				} else {
					log.info("Naphthalene row not found...");
				}

			}
		}

		if (flag) {
			log.info("HE_Naphthalene_ValidateDocument method ends here with true.........");
			return true;
		} else {
			log.info("HE_Naphthalene_ValidateDocument method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Dichlorobenzene -> --> Validate documents added in the row
	// item are
	// displayed under Documents tab.
	public boolean HE_Dichlorobenzene_ValidateDocument() {
		log.info("HE_Dichlorobenzene_ValidateDocument  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows showing are  " + BeforeTotalRows);
		if (BeforeTotalRows > 0) {
			log.info("Going to upload document..");

			String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/div/button")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			driver.findElement(By
					.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/div/ul/li/span[text()='Computer File']"))
					.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			WebElement element = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/input"));
			JSHelper.displayHiddenElement(element);
			element.sendKeys(UploadPath);
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			/*
			 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
			 * try { waithelper.WaitForElementVisibleWithPollingTime(
			 * driver.findElement(By.xpath("//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
			 * 
			 * waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
			 * "//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2); } catch (Exception e)
			 * { e.printStackTrace(); }
			 */
		}

		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//span[text()='Documents']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		driver.findElement(By.xpath("//span[text()='Documents']")).click();
		List<WebElement> DocumentList = driver.findElements(By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr"));
		int RowsInDocument = DocumentList.size();
		if (RowsInDocument > 0) {
			for (int i = 0; i < RowsInDocument; i++) {
				if (driver
						.findElement(
								By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[2]/div/a"))
						.getText().equals("Dichlorobenzene")) {
					log.info("Dichlorobenzene row found...");
					String FileName = driver
							.findElement(By
									.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[1]/span"))
							.getText().trim();
					if (FileName.equals("File1.pdf")) {
						log.info("Document found with Dichlorobenzene..");
						flag = true;
						break;
					} else {
						log.info("Document found with other name.." + FileName);
						flag = false;
					}
				} else {
					log.info("Dichlorobenzene row not found...");
				}

			}
		}

		if (flag) {
			log.info("HE_Dichlorobenzene_ValidateDocument method ends here with true.........");
			return true;
		} else {
			log.info("HE_Dichlorobenzene_ValidateDocument method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Xylenes-total -> --> Validate documents added in the row
	// item are
	// displayed under Documents tab.
	public boolean HE_XylenesTotal_ValidateDocument() {
		log.info("HE_XylenesTotal_ValidateDocument  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows showing are  " + BeforeTotalRows);
		if (BeforeTotalRows > 0) {
			log.info("Going to upload document..");

			String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/div/button")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			driver.findElement(By
					.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/div/ul/li/span[text()='Computer File']"))
					.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			WebElement element = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/input"));
			JSHelper.displayHiddenElement(element);
			element.sendKeys(UploadPath);
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			/*
			 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
			 * try { waithelper.WaitForElementVisibleWithPollingTime(
			 * driver.findElement(By.xpath("//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
			 * 
			 * waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
			 * "//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2); } catch (Exception e)
			 * { e.printStackTrace(); }
			 */
		}

		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//span[text()='Documents']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		driver.findElement(By.xpath("//span[text()='Documents']")).click();
		List<WebElement> DocumentList = driver.findElements(By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr"));
		int RowsInDocument = DocumentList.size();
		if (RowsInDocument > 0) {
			for (int i = 0; i < RowsInDocument; i++) {
				if (driver
						.findElement(
								By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[2]/div/a"))
						.getText().equals("Xylenes-total")) {
					log.info("Xylenes-total row found...");
					String FileName = driver
							.findElement(By
									.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[1]/span"))
							.getText().trim();
					if (FileName.equals("File1.pdf")) {
						log.info("Document found with Xylenes-total..");
						flag = true;
						break;
					} else {
						log.info("Document found with other name.." + FileName);
						flag = false;
					}
				} else {
					log.info("Xylenes-total row not found...");
				}

			}
		}

		if (flag) {
			log.info("HE_XylenesTotal_ValidateDocument method ends here with true.........");
			return true;
		} else {
			log.info("HE_XylenesTotal_ValidateDocument method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Formaldehyde -> --> Validate documents added in the row
	// item are
	// displayed under Documents tab.
	public boolean HE_Formaldehyde_ValidateDocument() {
		log.info("HE_Formaldehyde_ValidateDocument  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows showing are  " + BeforeTotalRows);
		if (BeforeTotalRows > 0) {
			log.info("Going to upload document..");

			String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/div/button")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			driver.findElement(By
					.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/div/ul/li/span[text()='Computer File']"))
					.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			WebElement element = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/input"));
			JSHelper.displayHiddenElement(element);
			element.sendKeys(UploadPath);
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			/*
			 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
			 * try { waithelper.WaitForElementVisibleWithPollingTime(
			 * driver.findElement(By.xpath("//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
			 * 
			 * waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
			 * "//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2); } catch (Exception e)
			 * { e.printStackTrace(); }
			 */
		}

		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//span[text()='Documents']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		driver.findElement(By.xpath("//span[text()='Documents']")).click();
		List<WebElement> DocumentList = driver.findElements(By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr"));
		int RowsInDocument = DocumentList.size();
		if (RowsInDocument > 0) {
			for (int i = 0; i < RowsInDocument; i++) {
				if (driver
						.findElement(
								By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[2]/div/a"))
						.getText().equals("Formaldehyde")) {
					log.info("Formaldehyde row found...");
					String FileName = driver
							.findElement(By
									.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[1]/span"))
							.getText().trim();
					if (FileName.equals("File1.pdf")) {
						log.info("Document found with Formaldehyde..");
						flag = true;
						break;
					} else {
						log.info("Document found with other name.." + FileName);
						flag = false;
					}
				} else {
					log.info("Formaldehyde row not found...");
				}

			}
		}

		if (flag) {
			log.info("HE_Formaldehyde_ValidateDocument method ends here with true.........");
			return true;
		} else {
			log.info("HE_Formaldehyde_ValidateDocument method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Carbon Monoxide -> --> Validate documents added in the row
	// item are
	// displayed under Documents tab.
	public boolean HE_CarbonMonoxide_ValidateDocument() {
		log.info("HE_CarbonMonoxide_ValidateDocument  method starts here.........");
		boolean flag = false;
		int BeforeTotalRows;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows showing are  " + BeforeTotalRows);
		if (BeforeTotalRows > 0) {
			log.info("Going to upload document..");

			String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/div/button")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			driver.findElement(By
					.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/div/div/ul/li/span[text()='Computer File']"))
					.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			WebElement element = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/input"));
			JSHelper.displayHiddenElement(element);
			element.sendKeys(UploadPath);
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			/*
			 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
			 * try { waithelper.WaitForElementVisibleWithPollingTime(
			 * driver.findElement(By.xpath("//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
			 * 
			 * waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
			 * "//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2); } catch (Exception e)
			 * { e.printStackTrace(); }
			 */
		}

		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//span[text()='Documents']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		driver.findElement(By.xpath("//span[text()='Documents']")).click();
		List<WebElement> DocumentList = driver.findElements(By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr"));
		int RowsInDocument = DocumentList.size();
		if (RowsInDocument > 0) {
			for (int i = 0; i < RowsInDocument; i++) {
				if (driver
						.findElement(
								By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[2]/div/a"))
						.getText().equals("Carbon Monoxide")) {
					log.info("Carbon Monoxide row found...");
					String FileName = driver
							.findElement(By
									.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[1]/span"))
							.getText().trim();
					if (FileName.equals("File1.pdf")) {
						log.info("Document found with Carbon Monoxide..");
						flag = true;
						break;
					} else {
						log.info("Document found with other name.." + FileName);
						flag = false;
					}
				} else {
					log.info("Carbon Monoxide row not found...");
				}

			}
		}

		if (flag) {
			log.info("HE_CarbonMonoxide_ValidateDocument method ends here with true.........");
			return true;
		} else {
			log.info("HE_CarbonMonoxide_ValidateDocument method ends here with false.........");
			return false;
		}

	}

	// Building Settings--> Water --> Validate documents added in the row item are
	// displayed under Documents tab.
	public boolean Water_ValidateDocument() {
		log.info("Water_ValidateDocument  method starts here.........");
		boolean flag = false;
		int BeforeTotalRows = 0;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String WaterMeterName = System.getProperty("WaterMeterName");
		// WaterMeterName="Water1";
		driver.findElement(By.xpath(
				"//div[@class='fw600 mb5' and text()='Water']/ancestor::tr/following-sibling::tr[1]/td[2]/div[contains(text(),'"
						+ WaterMeterName + "')]"))
				.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows showing are  " + BeforeTotalRows);
		if (BeforeTotalRows > 0) {
			log.info("Going to upload document..");

			String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/div/div/button")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			driver.findElement(By
					.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/div/div/ul/li/span[text()='Computer File']"))
					.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			WebElement element = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/input"));
			JSHelper.displayHiddenElement(element);
			element.sendKeys(UploadPath);
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			/*
			 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
			 * try { waithelper.WaitForElementVisibleWithPollingTime(
			 * driver.findElement(By.xpath("//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
			 * 
			 * waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
			 * "//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2); } catch (Exception e)
			 * { e.printStackTrace(); }
			 * 
			 * try { waithelper.WaitForElementVisibleWithPollingTime(
			 * driver.findElement(By.xpath("//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
			 * 
			 * waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
			 * "//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2); } catch (Exception e)
			 * { e.printStackTrace(); } // TODO: handle exception
			 */
		}

		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//span[text()='Documents']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		driver.findElement(By.xpath("//span[text()='Documents']")).click();
		List<WebElement> DocumentList = driver.findElements(By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr"));
		int RowsInDocument = DocumentList.size();
		if (RowsInDocument > 0) {
			for (int i = 0; i < RowsInDocument; i++) {
				if (driver
						.findElement(
								By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[2]/div/a"))
						.getText().equals(WaterMeterName)) {
					log.info("Water Meter row found...");
					String FileName = driver
							.findElement(By
									.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[1]/span"))
							.getText().trim();
					if (FileName.equals("File1.pdf")) {
						log.info("Document found with Water meter..");
						flag = true;
						break;
					} else {
						flag = false;
					}
				} else {
					log.info("Water Meter row not found...");
				}

			}
		}

		if (flag) {
			log.info("Water_ValidateDocument method ends here with true.........");
			return true;
		} else {
			log.info("Water_ValidateDocument method ends here with false.........");
			return false;
		}

	}

	// Building Settings--> Waste --> Validate documents added in the row item are
	// displayed under Documents tab.
	public boolean Waste_ValidateDocument() {
		log.info("Waste_ValidateDocument  method starts here.........");
		boolean flag = false;
		int BeforeTotalRows = 0;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"//div[@class='fw600 mb5' and text()='Waste']/ancestor::tr/following-sibling::tr[1]/td[2]/div[contains(text(),'Waste Data')]"))
				.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='wasteTable']/tbody/tr");
		log.info("Total Number of rows showing are  " + BeforeTotalRows);
		if (BeforeTotalRows > 0) {
			log.info("Going to upload document..");

			String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";

			driver.findElement(By.xpath("//div[@class='dropdown dropDownuploadOptions']/button")).click();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			driver.findElement(By.xpath("//span[text()='Computer File']")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			WebElement element = driver
					.findElement(By.xpath("//table[@id='wasteTable']/tbody/tr[1]/td/input[@name='action_file']"));
			JSHelper.displayHiddenElement(element);
			element.sendKeys(UploadPath);
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			/*
			 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
			 * try { waithelper.WaitForElementVisibleWithPollingTime(
			 * driver.findElement(By.xpath("//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
			 * 
			 * waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
			 * "//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2); } catch (Exception e)
			 * { e.printStackTrace(); }
			 * 
			 * try { waithelper.WaitForElementVisibleWithPollingTime(
			 * driver.findElement(By.xpath("//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
			 * 
			 * waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
			 * "//span[contains(text(),'Uploading')]")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2); } catch (Exception e)
			 * { e.printStackTrace(); } // TODO: handle exception
			 */
		}

		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//span[text()='Documents']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		driver.findElement(By.xpath("//span[text()='Documents']")).click();
		List<WebElement> DocumentList = driver.findElements(By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr"));
		int RowsInDocument = DocumentList.size();
		if (RowsInDocument > 0) {
			for (int i = 0; i < RowsInDocument; i++) {
				if (driver
						.findElement(
								By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[2]/div/a"))
						.getText().equals("Waste Data")) {
					log.info("Waste Data row found...");
					String FileName = driver
							.findElement(By
									.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[" + (i + 1) + "]/td[1]/span"))
							.getText().trim();
					if (FileName.equals("File1.pdf")) {
						log.info("Document found with Waste Data..");
						flag = true;
						break;
					} else {
						flag = false;
					}
				} else {
					log.info("Waste Data row not found...");
				}

			}
		}

		if (flag) {
			log.info("Waste_ValidateDocument method ends here with true.........");
			return true;
		} else {
			log.info("Waste_ValidateDocument method ends here with false.........");
			return false;
		}

	}

	public boolean Transportation_CopySurveylink() {
		log.info("Transportation_CopySurveylink  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TransportationSurvey.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		waithelper.WaitForElementClickable(Transportation_SurveyToolsResource,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Transportation_SurveyToolsResource.click();

		driver.findElement(By.xpath("(//div[@class='dropdown-toggle'])[2]")).click();

		List<WebElement> LanguageList = driver
				.findElements(By.xpath("(//div[@class='dropdown-toggle'])[2]/following-sibling::ul/li/a"));
		List<WebElement> LanguageCopy = driver.findElements(
				By.xpath("(//div[@class='dropdown-toggle'])[2]/following-sibling::ul/li/span[text()='Copied!']"));
		for (int i = 0; i < LanguageList.size(); i++) {
			LanguageList.get(i).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (LanguageCopy.get(i).isDisplayed()) {
				log.info(LanguageList.get(i).getText() + " copied successfully");
				flag = true;
			} else {
				log.info(LanguageList.get(i).getText() + " not copied successfully");
				flag = false;
				break;
			}
		}

		if (flag) {
			log.info("Transportation_CopySurveylink method ends here with true.........");
			return true;
		} else {
			log.info("Transportation_CopySurveylink method ends here with false.........");
			return false;
		}

	}

	// Building -> HE - Occupant Satisfaction Survey -> Validate Survey Tools and
	// Resources Dropdown- Copy survey link allows to copy the survey in fourteen
	// languages. The User should see a copied text in Green.
	public boolean HE_OccupantSurvey_CopySurveylink() {
		log.info("HE_OccupantSurvey_CopySurveylink  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Transportation_SurveyToolsResource.click();

		driver.findElement(By.xpath("(//div[@class='dropdown-toggle'])[2]")).click();

		List<WebElement> LanguageList = driver
				.findElements(By.xpath("(//div[@class='dropdown-toggle'])[2]/following-sibling::ul/li/a"));
		List<WebElement> LanguageCopy = driver.findElements(
				By.xpath("(//div[@class='dropdown-toggle'])[2]/following-sibling::ul/li/span[text()='Copied!']"));
		for (int i = 0; i < LanguageList.size(); i++) {
			LanguageList.get(i).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (LanguageCopy.get(i).isDisplayed()) {
				log.info(LanguageList.get(i).getText() + " copied successfully");
				flag = true;
			} else {
				log.info(LanguageList.get(i).getText() + " not copied successfully");
				flag = false;
				break;
			}
		}

		if (flag) {
			log.info("HE_OccupantSurvey_CopySurveylink method ends here with true.........");
			return true;
		} else {
			log.info("HE_OccupantSurvey_CopySurveylink method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Carbon Dioxide -> Verify Clicking on add row allows to add
	// start date,end date, reading, and documents.
	public boolean HE_CarbonDioxide_AddRecord() {
		log.info("HE_CarbonDioxide_AddRecord  method starts here.........");
		int BeforeTotalRows = 0;
		int AfterTotalRows = 0;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows before adding showing are  " + BeforeTotalRows);
		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 1st day of previous month
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 20st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/input"))
				.sendKeys(data.getCellData("Building", 40, 2));

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[7]/button")).click();

		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[8]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AfterTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + AfterTotalRows);

		if (AfterTotalRows - BeforeTotalRows == 1) {
			log.info("HE_CarbonDioxide_AddRecord method ends here with true.........");
			return true;
		} else {
			log.info("HE_CarbonDioxide_AddRecord method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- PM2.5 -> Verify Clicking on add row allows to add start
	// date,end date, reading, and documents.
	public boolean HE_PM2_5_AddRecord() {
		log.info("HE_PM2_5_AddRecord  method starts here.........");
		int BeforeTotalRows = 0;
		int AfterTotalRows = 0;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows before adding showing are  " + BeforeTotalRows);
		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 1st day of previous month
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 20st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/input"))
				.sendKeys(data.getCellData("Building", 42, 2));

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/button")).click();

		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[7]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AfterTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + AfterTotalRows);

		if (AfterTotalRows - BeforeTotalRows == 1) {
			log.info("HE_PM2_5_AddRecord method ends here with true.........");
			return true;
		} else {
			log.info("HE_PM2_5_AddRecord method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Ozone -> Verify Clicking on add row allows to add start
	// date,end date, reading, and documents.
	public boolean HE_Ozone_AddRecord() {
		log.info("HE_Ozone_AddRecord  method starts here.........");
		int BeforeTotalRows = 0;
		int AfterTotalRows = 0;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows before adding showing are  " + BeforeTotalRows);
		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 1st day of previous month
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 20st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/input"))
				.sendKeys(data.getCellData("Building", 43, 2));

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/button")).click();

		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[7]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AfterTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + AfterTotalRows);

		if (AfterTotalRows - BeforeTotalRows == 1) {
			log.info("HE_Ozone_AddRecord method ends here with true.........");
			return true;
		} else {
			log.info("HE_Ozone_AddRecord method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- CarbonMonoxide -> Verify Clicking on add row allows to add
	// start
	// date,end date, reading, and documents.
	public boolean HE_CarbonMonoxide_AddRecord() {
		log.info("HE_CarbonMonoxide_AddRecord  method starts here.........");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows before adding showing are  " + BeforeTotalRows);
		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 1st day of previous month
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 20st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/input"))
				.sendKeys(data.getCellData("Building", 44, 2));

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/button")).click();

		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[7]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int AfterTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + AfterTotalRows);

		if (AfterTotalRows - BeforeTotalRows == 1) {
			log.info("HE_CarbonMonoxide_AddRecord method ends here with true.........");
			return true;
		} else {
			log.info("HE_CarbonMonoxide_AddRecord method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Acetaldehyde -> Verify Clicking on add row allows to add
	// start
	// date,end date, reading, and documents.
	public boolean HE_Acetaldehyde_AddRecord() {
		log.info("HE_Acetaldehyde_AddRecord  method starts here.........");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows before adding showing are  " + BeforeTotalRows);
		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 1st day of previous month
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 20st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/input"))
				.sendKeys(data.getCellData("Building", 45, 2));

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/button")).click();

		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[7]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int AfterTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + AfterTotalRows);

		if (AfterTotalRows - BeforeTotalRows == 1) {
			log.info("HE_Acetaldehyde_AddRecord method ends here with true.........");
			return true;
		} else {
			log.info("HE_Acetaldehyde_AddRecord method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Benzene -> Verify Clicking on add row allows to add start
	// date,end date, reading, and documents.
	public boolean HE_Benzene_AddRecord() {
		log.info("HE_Benzene_AddRecord  method starts here.........");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows before adding showing are  " + BeforeTotalRows);
		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 1st day of previous month
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 20st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/input"))
				.sendKeys(data.getCellData("Building", 46, 2));

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/button")).click();

		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[7]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int AfterTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + AfterTotalRows);

		if (AfterTotalRows - BeforeTotalRows == 1) {
			log.info("HE_Benzene_AddRecord method ends here with true.........");
			return true;
		} else {
			log.info("HE_Benzene_AddRecord method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Styrene -> Verify Clicking on add row allows to add start
	// date,end date, reading, and documents.
	public boolean HE_Styrene_AddRecord() {
		log.info("HE_Styrene_AddRecord  method starts here.........");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows before adding showing are  " + BeforeTotalRows);
		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 1st day of previous month
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 20st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/input"))
				.sendKeys(data.getCellData("Building", 47, 2));

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/button")).click();

		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[7]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int AfterTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + AfterTotalRows);

		if (AfterTotalRows - BeforeTotalRows == 1) {
			log.info("HE_Styrene_AddRecord method ends here with true.........");
			return true;
		} else {
			log.info("HE_Styrene_AddRecord method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Toluene -> Verify Clicking on add row allows to add start
	// date,end date, reading, and documents.
	public boolean HE_Toluene_AddRecord() {
		log.info("HE_Toluene_AddRecord  method starts here.........");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows before adding showing are  " + BeforeTotalRows);
		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 1st day of previous month
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 20st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/input"))
				.sendKeys(data.getCellData("Building", 48, 2));

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/button")).click();

		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[7]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int AfterTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + AfterTotalRows);

		if (AfterTotalRows - BeforeTotalRows == 1) {
			log.info("HE_Toluene_AddRecord method ends here with true.........");
			return true;
		} else {
			log.info("HE_Toluene_AddRecord method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Naphthalene -> Verify Clicking on add row allows to add start
	// date,end date, reading, and documents.
	public boolean HE_Naphthalene_AddRecord() {
		log.info("HE_Naphthalene_AddRecord  method starts here.........");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows before adding showing are  " + BeforeTotalRows);
		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 1st day of previous month
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 20st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/input"))
				.sendKeys(data.getCellData("Building", 49, 2));

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/button")).click();

		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[7]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int AfterTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + AfterTotalRows);

		if (AfterTotalRows - BeforeTotalRows == 1) {
			log.info("HE_Naphthalene_AddRecord method ends here with true.........");
			return true;
		} else {
			log.info("HE_Naphthalene_AddRecord method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Dichlorobenzene -> Verify Clicking on add row allows to add
	// start
	// date,end date, reading, and documents.
	public boolean HE_Dichlorobenzene_AddRecord() {
		log.info("HE_Dichlorobenzene_AddRecord  method starts here.........");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows before adding showing are  " + BeforeTotalRows);
		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 1st day of previous month
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 20st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/input"))
				.sendKeys(data.getCellData("Building", 50, 2));

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/button")).click();

		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[7]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int AfterTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + AfterTotalRows);

		if (AfterTotalRows - BeforeTotalRows == 1) {
			log.info("HE_Dichlorobenzene_AddRecord method ends here with true.........");
			return true;
		} else {
			log.info("HE_Dichlorobenzene_AddRecord method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Xylenes-total -> Verify Clicking on add row allows to add
	// start
	// date,end date, reading, and documents.
	public boolean HE_XylenesTotal_AddRecord() {
		log.info("HE_XylenesTotal_AddRecord  method starts here.........");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows before adding showing are  " + BeforeTotalRows);
		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 1st day of previous month
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 20st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/input"))
				.sendKeys(data.getCellData("Building", 51, 2));

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/button")).click();

		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[7]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int AfterTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + AfterTotalRows);

		if (AfterTotalRows - BeforeTotalRows == 1) {
			log.info("HE_XylenesTotal_AddRecord method ends here with true.........");
			return true;
		} else {
			log.info("HE_XylenesTotal_AddRecord method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- Formaldehyde -> Verify Clicking on add row allows to add
	// start
	// date,end date, reading, and documents.
	public boolean HE_Formaldehyde_AddRecord() {
		log.info("HE_Formaldehyde_AddRecord  method starts here.........");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows before adding showing are  " + BeforeTotalRows);
		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 1st day of previous month
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 20st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/input"))
				.sendKeys(data.getCellData("Building", 52, 2));

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/button")).click();

		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[7]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int AfterTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + AfterTotalRows);

		if (AfterTotalRows - BeforeTotalRows == 1) {
			log.info("HE_Formaldehyde_AddRecord method ends here with true.........");
			return true;
		} else {
			log.info("HE_Formaldehyde_AddRecord method ends here with false.........");
			return false;
		}

	}

	// Building -> HE- TVOC -> Verify Clicking on add row allows to add start
	// date,end date, reading, and documents.
	public boolean HE_TVOC_AddRecord() {
		log.info("HE_TVOC_AddRecord  method starts here.........");
		int BeforeTotalRows = 0;
		int AfterTotalRows = 0;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows before adding showing are  " + BeforeTotalRows);
		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 1st day of previous month
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 20st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/input"))
				.sendKeys(data.getCellData("Building", 41, 2));

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[7]/button")).click();

		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr/td[8]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AfterTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + AfterTotalRows);

		if (AfterTotalRows - BeforeTotalRows == 1) {
			log.info("HE_TVOC_AddRecord method ends here with true.........");
			return true;
		} else {
			log.info("HE_TVOC_AddRecord method ends here with false.........");
			return false;
		}

	}

//Building -> Transportation-> Open a new tab and paste the copied content from above test case and fill the survey.
	public boolean Transportation_OpenSurveyLinkInNewTab() {
		log.info("Transportation_OpenSurveyLinkInNewTab  method starts here.........");
		boolean flag = false;
		boolean OpenSurveyTab = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TransportationSurvey.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String handle = driver.getWindowHandle();
		waithelper.WaitForElementClickable(Transportation_SurveyToolsResource,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Transportation_SurveyToolsResource.click();

		driver.findElement(By.xpath("(//div[@class='dropdown-toggle'])[2]")).click();
		flag = Transportation_copyLanguage("English");
		String url=null;
		if (flag) {

			OpenSurveyTab = Transportation_OpenNewTabWithCopiedURL(url);
			driver.close();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().window(handle);
		}

		if (OpenSurveyTab) {
			log.info("Transportation_OpenSurveyLinkInNewTab method ends here with true.........");
			return true;
		} else {
			log.info("Transportation_OpenSurveyLinkInNewTab method ends here with false.........");
			return false;
		}

	}

//Building -> Transportation-> Validate Survey Page- Survey shows project name and address just below the Arc logo.
	public boolean Transportation_SurveyPage_ProjectNameAndAddress(String PAddress) {
		log.info("Transportation_SurveyPage_ProjectNameAndAddress  method starts here.........");
		boolean flag = false;
		String ExpProjectName_Address = null;
		String ActProjectName_Address = null;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TransportationSurvey.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String handle = driver.getWindowHandle();
		waithelper.WaitForElementClickable(Transportation_SurveyToolsResource,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Transportation_SurveyToolsResource.click();

		driver.findElement(By.xpath("(//div[@class='dropdown-toggle'])[2]")).click();
		flag = Transportation_copyLanguage("English");
		String url=null;
		if (flag) {
			Transportation_OpenNewTabWithCopiedURL(url);
			ExpProjectName_Address = System.getProperty("BuildingProject_Test1_Name") + ", " + PAddress;
			ActProjectName_Address = driver
					.findElement(By.xpath("//div[@class='survey-logo']/parent::div/following-sibling::div[1]"))
					.getText();
			log.info("Expected Project Name and Project Address are.. " + ExpProjectName_Address);
			log.info("Actual Project Name and Project Address are.. " + ActProjectName_Address);
			driver.close();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().window(handle);
		}

		if (ExpProjectName_Address.equals(ActProjectName_Address)) {
			log.info("Transportation_SurveyPage_ProjectNameAndAddress method ends here with true.........");
			return true;
		} else {
			log.info("Transportation_SurveyPage_ProjectNameAndAddress method ends here with false.........");
			return false;
		}

	}

	public boolean OccupantSurvey_SurveyPage_ProjectNameAndAddress() {
		log.info("OccupantSurvey_SurveyPage_ProjectNameAndAddress  method starts here.........");
		boolean flag = false;
		String ExpProjectName_Address = null;
		String ActProjectName_Address = null;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ExpProjectName_Address = System.getProperty("BuildingProject_Test1_Name") + ", " + PAddress;
		ExpProjectName_Address = System.getProperty("BuildingProject_Test1_Name") + ", " + data.getCellData("ProjectRegistration", 3, 2);
		ActProjectName_Address = driver
				.findElement(By.xpath("//div[@class='survey-logo']/parent::div/following-sibling::div[1]")).getText();
		log.info("Expected Project Name and Project Address are.. " + ExpProjectName_Address);
		log.info("Actual Project Name and Project Address are.. " + ActProjectName_Address);
		//driver.close();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.switchTo().window(BaseWindow);
		if (ExpProjectName_Address.equals(ActProjectName_Address)) {
			log.info("OccupantSurvey_SurveyPage_ProjectNameAndAddress method ends here with true.........");
			return true;
		} else {
			log.info("OccupantSurvey_SurveyPage_ProjectNameAndAddress method ends here with false.........");
			return false;
		}

	}

//Building -> Transportation-> Validate clicking on Question 1. Route-1-Select Travel method open up the section to add modes of transport.
	public boolean Transportation_ValidateRoute_1_Questions() {
		log.info("Transportation_ValidateRoute_1_Questions  method starts here.........");
		boolean flag = false;
		boolean QuestionFillFlag = false;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TransportationSurvey.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		// String handle = driver.getWindowHandle();
		waithelper.WaitForElementClickable(Transportation_SurveyToolsResource,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Transportation_SurveyToolsResource.click();

		driver.findElement(By.xpath("(//div[@class='dropdown-toggle'])[2]")).click();

		flag = Transportation_copyLanguage("English");
		String url=null;
		if (flag) {
			Transportation_OpenNewTabWithCopiedURL(url);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			waithelper.WaitForElementClickable(
					driver.findElement(By.xpath("//span[text()='Select Travel Method']/parent::button")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			JSHelper.clickElement(driver.findElement(By.xpath("//span[text()='Select Travel Method']/parent::button")));

			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h4[text()='Route 1']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			QuestionFillFlag = Transportaton_FillQuestion1_RouteDetails();

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			driver.close();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().window(BaseWindow);
		}

		if (QuestionFillFlag) {
			log.info("Transportation_ValidateRoute_1_Questions method ends here with true.........");
			return true;
		} else {
			log.info("Transportation_ValidateRoute_1_Questions method ends here with false.........");
			return false;
		}

	}

	public boolean Transportaton_FillQuestion1_RouteDetails() {
		log.info("Transportaton_FillQuestion1_RouteDetails method starts here...");
		HashMap<String, String> ModalWindowPageRoute = new HashMap<String, String>(); // It stores all the travel method
		// and values from Modal Window
		// Page
		HashMap<String, String> SurveyPageRoute = new HashMap<String, String>(); // It stores all the travel method and
		// values from Survey Page

		List<WebElement> TravelMethodModalWindowPage = driver.findElements(
				By.xpath("//div[@class='mode-option mode-option-border']/following-sibling::div/div/div[2]"));
		log.info("Total Number of Travel Methods on Modal Window Page are  " + TravelMethodModalWindowPage.size());

		List<WebElement> TravelMethodModalWindowPageValues = driver.findElements(
				By.xpath("//div[@class='mode-option mode-option-border']/following-sibling::div/div[2]/input"));

		int i = 26; // reading excel data for travel methods from column 26
		int j = 0;
		for (WebElement ele : TravelMethodModalWindowPage) {
			TravelMethodModalWindowPageValues.get(j).sendKeys(data.getCellData("Building", i, 2));
			ModalWindowPageRoute.put(ele.getText(), data.getCellData("Building", i, 2));
			i++;
			j++;
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//span[text()='SAVE']/parent::button")).click();

		List<WebElement> TravelMethodSurveyPage = driver
				.findElements(By.xpath("//div[@class='mode-list cursor-pointer']/div/div/div[2]"));
		log.info("Total Number of Travel Methods on Survey Page are  " + TravelMethodSurveyPage.size());

		List<WebElement> TravelMethodSurveyPageValues = driver
				.findElements(By.xpath("//div[@class='mode-list cursor-pointer']/div/div/following-sibling::span"));
		j = 0;
		for (WebElement ele : TravelMethodSurveyPage) {
			String Textvalue = TravelMethodSurveyPageValues.get(j).getText();
			String[] splited = Textvalue.split("\\s+");
			SurveyPageRoute.put(ele.getText(), splited[0]);
			j++;
		}

		log.info(ModalWindowPageRoute);
		log.info(SurveyPageRoute);

		if (ModalWindowPageRoute.equals(SurveyPageRoute)) {
			log.info("Transportaton_FillQuestion1_RouteDetails method ends here with true.........");
			return true;
		} else {
			log.info("Transportaton_FillQuestion1_RouteDetails method ends here with false.........");
			return false;
		}
	}

// This method will take language and it copes the url of the same language to open it in new tab.

	public boolean Transportation_copyLanguage(String language) {
		log.info("Transportation_copyLanguage method starts here for " + language + "  ...");
		boolean flag = false;
		List<WebElement> LanguageList = driver
				.findElements(By.xpath("(//div[@class='dropdown-toggle'])[2]/following-sibling::ul/li/a"));
		List<WebElement> LanguageCopy = driver.findElements(
				By.xpath("(//div[@class='dropdown-toggle'])[2]/following-sibling::ul/li/span[text()='Copied!']"));

		for (int i = 0; i < LanguageList.size(); i++) {
			if (LanguageList.get(i).getText().equals(language)) {
				// waithelper.WaitForElementClickable(LanguageList.get(i),
				// Integer.parseInt(prop.getProperty("explicitTime")), 2);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				waithelper.WaitForElementClickable(LanguageList.get(i),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

				WebElement ele = driver.findElement(By.xpath("(//a[text()='English'])[2]/following-sibling::span"));
				JSHelper.displayHiddenElement(ele);
				actionhelper.mouseOverElement(driver.findElement(By.xpath("(//a[text()='English'])[2]/parent::li")));
				actionhelper.mouseOverElementAndDoubleClick(
						driver.findElement(By.xpath("(//a[text()='English'])[2]/parent::li")));

				actionhelper.mouseOverElement(driver.findElement(By.xpath("(//a[text()='English'])[2]/parent::li")));
				waithelper.WaitForElementClickable(
						driver.findElement(By.xpath("(//a[text()='English'])[2]/parent::li")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
				// JSHelper.clickElement(LanguageList.get(i));
				actionhelper.mouseOverElement(driver.findElement(By.xpath("(//a[text()='English'])[2]/parent::li")));
				driver.findElement(By.xpath("(//a[text()='English'])[2]/parent::li")).sendKeys(Keys.ENTER);

				// driver.findElement(ByAngular.buttonText("English")).click();

				// Thread.sleep(2000);
				actionhelper.mouseOverElement(driver.findElement(By.xpath("(//a[text()='English'])[2]/parent::li")));
				LanguageList.get(i).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// JSHelper.clickElement(LanguageList.get(i));
				// log.info("Before Clicking "+LanguageCopy.get(i).isDisplayed());
				// LanguageList.get(i).click();
				/*
				 * waithelper.WaitForElementVisibleWithPollingTime(LanguageCopy.get(i),
				 * Integer.parseInt(prop.getProperty("explicitTime")), 2); try {
				 * Thread.sleep(1000); } catch (InterruptedException e) { // TODO Auto-generated
				 * catch block e.printStackTrace(); }
				 */
				log.info(LanguageCopy.get(i).isDisplayed());
				if (LanguageCopy.get(i).isDisplayed()) {
					log.info(LanguageList.get(i).getText() + " copied successfully");
					flag = true;
					break;
				} else {
					log.info("Unable to select " + language + " Language...");
					flag = false;
					break;
				}

			} else {
				// log.info("English Language not found....");
				flag = false;
			}
		}
		log.info("Transportation_copyLanguage method ends here with " + flag + " for " + language + "  ...");
		return flag;
	}

	// This method will open new tab and paste the url from system clipboard.

	public boolean Transportation_OpenNewTabWithCopiedURL(String newURL) {
		log.info("Transportation_OpenNewTabWithCopiedURL method starts here ...");
		boolean flag = false;
		/*Object copiedText = null;
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		// String handle = driver.getWindowHandle();
		try {
			copiedText = clipboard.getData(DataFlavor.stringFlavor);
		} catch (UnsupportedFlavorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Copied text from ClipBoard is " + copiedText);
		// ((JavascriptExecutor) driver).executeScript("window.open(\"" + copiedText +
		// "\")"); */
		((JavascriptExecutor) driver).executeScript("window.open('" + newURL + "')");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ngWebDriver.waitForAngularRequestsToFinish();
		Set<String> handles = driver.getWindowHandles();
		for (String window : handles) {
			if (!window.equals(BaseWindow)) {
				driver.switchTo().window(window);
				log.info("Switched to new window....");
				break;
			}
		}
		waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@class='survey-logo']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		flag = driver.findElement(By.xpath("//div[@class='survey-logo']")).isDisplayed();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Transportation_OpenNewTabWithCopiedURL method ends here ...");
		return flag;

	}

	// Occupant Survey -->This method will open new tab and paste the url from
	// system clipboard.

	public boolean OcupantSurvey_OpenNewTabWithCopiedURL(String url) {
		log.info("OcupantSurvey_OpenNewTabWithCopiedURL method starts here ...");
		boolean flag = false;
		/*Object copiedText = null;
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		// String handle = driver.getWindowHandle();
		try {
			copiedText = clipboard.getData(DataFlavor.stringFlavor);
		} catch (UnsupportedFlavorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Copied text from ClipBoard is " + copiedText);
		// ((JavascriptExecutor) driver).executeScript("window.open(\"" + copiedText +
		// "\")"); */
		((JavascriptExecutor) driver).executeScript("window.open('" + url + "')");
		//ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		log.info("Base Window ID is "+driver.getWindowHandle());
		Set<String> handles = driver.getWindowHandles();
		log.info("Total Number of Window Handles is "+handles.size());
		for (String window : handles) {
			log.info("Current window ID is "+window);
			if (!window.equals(BaseWindow)) {
				driver.switchTo().window(window);
				log.info("Switched to new window....");
				break;
			}
		}
		waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@class='survey-logo']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		flag = driver.findElement(By.xpath("//div[@class='survey-logo']")).isDisplayed();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("OcupantSurvey_OpenNewTabWithCopiedURL method ends here ...");
		return flag;

	}

//Building -> Transportation-> Validate Question-2, For Slider user gets the option to select from Extremely Unsatisfied, Very Unsatisfied, the option in Question 3 are changed to "We're sorry to hear that. Please select the options below that significantly reduce your satisfaction:"
	public boolean Transportation_ValidateRoute_2_Questions() {
		log.info("Transportation_ValidateRoute_2_Questions  method starts here.........");
		boolean flag = false;
		boolean SliderFlag = false;
		// boolean LabelFound = false;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TransportationSurvey.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String handle = driver.getWindowHandle();
		waithelper.WaitForElementClickable(Transportation_SurveyToolsResource,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Transportation_SurveyToolsResource.click();

		driver.findElement(By.xpath("(//div[@class='dropdown-toggle'])[2]")).click();

		flag = Transportation_copyLanguage("English");
		String url=null;
		if (flag) {
			Transportation_OpenNewTabWithCopiedURL(url);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int xwidth = Transportation_RangeSlider.getSize().getWidth();
			System.out.println("width is " + xwidth);
			System.out.println("Height is " + Transportation_RangeSlider.getSize().getHeight());

			actionhelper.dragAndDrop(Transportation_RangeSlider, xwidth - 300, 0);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String Message = Transportation_SatisfactionMSG.getText();
			SliderFlag = Transportation_Validate_SurveyOptions(Message);
			log.info(SliderFlag);
			log.info("  ---- " + Message);
			if (SliderFlag) {
				for (int i = 0; i < 6; i++) {

					actionhelper.dragAndDrop(Transportation_RangeSlider, xwidth, 0);
					actionhelper.dragAndDrop(Transportation_RangeSlider, xwidth + 50, 0);
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Message = Transportation_SatisfactionMSG.getText();
					SliderFlag = Transportation_Validate_SurveyOptions(Message);
					log.info(i + "  ---- " + Message + " " + flag);
					if (SliderFlag == false) {
						log.info("Validate_SurveyOptions method failed for " + Message + " ...");
						break;
					}
				}
			} else {
				log.info("Validate_SurveyOptions method failed...");
			}
			driver.close();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().window(handle);

		}
		if (SliderFlag) {
			log.info("Transportation_ValidateRoute_2_Questions method ends here with true.........");
			return true;
		} else {
			log.info("Transportation_ValidateRoute_2_Questions method ends here with false.........");
			return false;
		}
	}

	// Building -> Transportation-> Fill all the details and select "Extremely
	// Unsatisfied" and submit the survey.
	public boolean Transportation_SubmitSurveyWithExtremelyUnsatisfied() {
		log.info("Transportation_SubmitSurveyWithExtremelyUnsatisfied  method starts here.........");
		boolean flag = false;
		boolean SubmitResponseFlag = false;
		boolean SliderFlag = false;
		// boolean LabelFound = false;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TransportationSurvey.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String handle = driver.getWindowHandle();
		waithelper.WaitForElementClickable(Transportation_SurveyToolsResource,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Transportation_SurveyToolsResource.click();

		driver.findElement(By.xpath("(//div[@class='dropdown-toggle'])[2]")).click();
		flag = Transportation_copyLanguage("English");
		String url=null;
		if (flag) {
			Transportation_OpenNewTabWithCopiedURL(url);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			waithelper.WaitForElementClickable(
					driver.findElement(By.xpath("//span[text()='Select Travel Method']/parent::button")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			JSHelper.clickElement(driver.findElement(By.xpath("//span[text()='Select Travel Method']/parent::button")));

			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h4[text()='Route 1']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			Transportaton_FillQuestion1_RouteDetails();
			int xwidth = Transportation_RangeSlider.getSize().getWidth();
			System.out.println("width is " + xwidth);
			System.out.println("Height is " + Transportation_RangeSlider.getSize().getHeight());

			actionhelper.dragAndDrop(Transportation_RangeSlider, xwidth - 300, 0);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String Message = Transportation_SatisfactionMSG.getText();
			SliderFlag = Transportation_SelectAll_SurveyOptions(Message);
			log.info(SliderFlag);
			log.info("  ---- " + Message);
			BuildingSurvey_CommentOptional.sendKeys(data.getCellData("Building", 36, 2));
			BuildingSurvey_Location.sendKeys(data.getCellData("Building", 37, 2));
			BuildingSurvey_NameOptional.sendKeys(data.getCellData("Building", 38, 2));
			String Occupant = data.getCellData("Building", 39, 2);

			driver.findElement(By.xpath("//select[@id='occupant_category']")).click();
			driver.findElement(By.xpath("//select[@id='occupant_category']/option[text()='" + Occupant + "']")).click();
			Transportation_SubmitBtn.click();
			if (Transportation_SubmitResponseText.isDisplayed()) {
				log.info("Response message displayed.. ");
				SubmitResponseFlag = true;
			} else {
				log.info("Response message not displayed.. ");
			}
			driver.close();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().window(handle);

		}
		if (SubmitResponseFlag) {
			log.info("Transportation_SubmitSurveyWithExtremelyUnsatisfied method ends here with true.........");
			return true;
		} else {
			log.info("Transportation_SubmitSurveyWithExtremelyUnsatisfied method ends here with false.........");
			return false;
		}
	}

	// Building -> Transportation-> Submit Survey in French Language.
	public boolean Transportation_SubmitSurveyInFrench() {
		log.info("Transportation_SubmitSurveyInFrench  method starts here.........");
		boolean flag = false;
		boolean SubmitResponseFlag = false;
		boolean SliderFlag = false;
		boolean LanguagSelectionFlag = false;
		// boolean LabelFound = false;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TransportationSurvey.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String handle = driver.getWindowHandle();
		waithelper.WaitForElementClickable(Transportation_SurveyToolsResource,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Transportation_SurveyToolsResource.click();

		driver.findElement(By.xpath("(//div[@class='dropdown-toggle'])[2]")).click();
		flag = Transportation_copyLanguage("English");
		String url=null;
		if (flag) {
			Transportation_OpenNewTabWithCopiedURL(url);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			waithelper.WaitForElementClickable(
					driver.findElement(By.xpath("//span[text()='Select Travel Method']/parent::button")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			JSHelper.clickElement(driver.findElement(By.xpath("//span[text()='Select Travel Method']/parent::button")));

			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h4[text()='Route 1']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			Transportaton_FillQuestion1_RouteDetails();
			int xwidth = Transportation_RangeSlider.getSize().getWidth();
			System.out.println("width is " + xwidth);
			System.out.println("Height is " + Transportation_RangeSlider.getSize().getHeight());

			actionhelper.dragAndDrop(Transportation_RangeSlider, xwidth - 300, 0);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String Message = Transportation_SatisfactionMSG.getText();
			SliderFlag = Transportation_SelectAll_SurveyOptions(Message);
			log.info(SliderFlag);
			log.info("  ---- " + Message);
			BuildingSurvey_CommentOptional.sendKeys(data.getCellData("Building", 36, 2));
			BuildingSurvey_Location.sendKeys(data.getCellData("Building", 37, 2));
			BuildingSurvey_NameOptional.sendKeys(data.getCellData("Building", 38, 2));
			String Occupant = data.getCellData("Building", 39, 2);

			driver.findElement(By.xpath("//select[@id='occupant_category']")).click();
			driver.findElement(By.xpath("//select[@id='occupant_category']/option[text()='" + Occupant + "']")).click();

			LanguagSelectionFlag = Transportation_SelectLanguage("French");
			if (LanguagSelectionFlag) {
				driver.findElement(By.xpath("//button[text()='Soumettre']")).click();
			}

			if (driver
					.findElement(
							By.xpath("//h4[text()='Nous vous remercions pour votre participation à cette enquête !']"))
					.isDisplayed()) {
				log.info("Response message displayed.. ");
				SubmitResponseFlag = true;
			} else {
				log.info("Response message not displayed.. ");
			}
			driver.close();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().window(handle);

		}
		if (SubmitResponseFlag) {
			log.info("Transportation_SubmitSurveyInFrench method ends here with true.........");
			return true;
		} else {
			log.info("Transportation_SubmitSurveyInFrench method ends here with false.........");
			return false;
		}
	}

	// Building -> Transportation-> Submit Survey in ALL Language.
	public boolean Transportation_SubmitSurveyInAllLanguage() {
		log.info("Transportation_SubmitSurveyInAllLanguage  method starts here.........");
		boolean flag = false;
		boolean SubmitResponseFlag = false;
		boolean SliderFlag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TransportationSurvey.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		// String handle = driver.getWindowHandle();
		waithelper.WaitForElementClickable(Transportation_SurveyToolsResource,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Transportation_SurveyToolsResource.click();

		driver.findElement(By.xpath("(//div[@class='dropdown-toggle'])[2]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		List<WebElement> LanguageList = driver
				.findElements(By.xpath("(//div[@class='dropdown-toggle'])[2]/following-sibling::ul/li/a"));
		ArrayList<String> langList = new ArrayList<String>();
		for (WebElement ele : LanguageList) {
			langList.add(ele.getText());
		}
		log.info("Total Number of language is " + LanguageList.size());
		flag = Transportation_copyLanguage("English");
		String url=null;
		log.info("Language copy flag is .." + flag);
		int xaxis = 0;
		int z = 0;
		if (flag) {
			for (int i = 0; i < 14; i++) {
				Transportation_OpenNewTabWithCopiedURL(url);
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				waithelper.WaitForElementClickable(
						driver.findElement(By.xpath("//span[text()='Select Travel Method']/parent::button")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
				JSHelper.clickElement(
						driver.findElement(By.xpath("//span[text()='Select Travel Method']/parent::button")));

				waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h4[text()='Route 1']")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
				Transportaton_FillQuestion1_RouteDetails();
				int xwidth = Transportation_RangeSlider.getSize().getWidth();
				xaxis = xwidth - 300 + z;
				actionhelper.dragAndDrop(Transportation_RangeSlider, xaxis, 0);
				z = z + 100;
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (i == 3 || i == 10) /// In case of "Neither satisfied nor unsatisfied"
				{
					actionhelper.dragAndDrop(Transportation_RangeSlider, xwidth - 300, 0);
					/*
					 * try { Thread.sleep(1000); } catch (InterruptedException e1) { // TODO
					 * Auto-generated catch block e1.printStackTrace(); }
					 */
					actionhelper.dragAndDrop(Transportation_RangeSlider, xwidth + 300, 0);
				}
				// String Message = Transportation_SatisfactionMSG.getText();
				String Message = driver.findElement(By.xpath(
						"//div[@class='mb20 selected']/preceding-sibling::div/h4[@class='slider-text fw-400 ng-binding']"))
						.getText();

				log.info(Message);
				SliderFlag = Transportation_SelectAll_SurveyOptions(Message);
				log.info(SliderFlag);
				log.info("  ---- " + Message);
				if (Message.equals("Extremely Satisfied"))
					z = 0;
				BuildingSurvey_CommentOptional.sendKeys(data.getCellData("Building", 36, 2));
				BuildingSurvey_Location.sendKeys(data.getCellData("Building", 37, 2));
				BuildingSurvey_NameOptional.sendKeys(data.getCellData("Building", 38, 2));
				String Occupant = data.getCellData("Building", 39, 2);

				waithelper.WaitForElementClickable(driver.findElement(By.xpath("//select[@id='occupant_category']")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

				driver.findElement(By.xpath("//select[@id='occupant_category']")).click();
				driver.findElement(By.xpath("//select[@id='occupant_category']/option[text()='" + Occupant + "']"))
						.click();
				String CurrentLanguage = langList.get(i);
				dropdownhelper.selectUsingVisibleText(driver.findElement(By.xpath("//select[@id='survey_language']")),
						CurrentLanguage);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// LanguagSelectionFlag = Transportation_SelectLanguage(CurrentLanguage);
				// log.info("Language Dropdown selection flag is "+LanguagSelectionFlag);
				log.info("Current Language is " + CurrentLanguage);
				switch (CurrentLanguage) {
				case "English":
					driver.findElement(By.xpath("//button[text()='Submit']")).click();
					if (driver.findElement(By.xpath("//h4[text()='Thank you for taking our survey! Your responses:']"))
							.isDisplayed()) {
						log.info("Response message displayed.. ");
						SubmitResponseFlag = true;
					} else {
						log.info("Response message not displayed.. ");
						SubmitResponseFlag = false;
					}
					break;
				case "Arabic":
					driver.findElement(By.xpath("//button[text()='تقديم']")).click();
					if (driver.findElement(By.xpath("//h4[text()='نشكرك لاهتمامك بتعبئة الاستبيان! إجاباتك']"))
							.isDisplayed()) {
						log.info("Response message displayed.. ");
						SubmitResponseFlag = true;
					} else {
						log.info("Response message not displayed.. ");
						SubmitResponseFlag = false;
					}
					break;
				case "Chinese":
					driver.findElement(By.xpath("//button[text()='提交']")).click();
					if (driver.findElement(By.xpath("//h4[text()='感謝您參加我們的調查！你的回答：']")).isDisplayed()) {
						log.info("Response message displayed.. ");
						SubmitResponseFlag = true;
					} else {
						log.info("Response message not displayed.. ");
						SubmitResponseFlag = false;
					}
					break;
				default:
					break;

				case "Finnish":
					driver.findElement(By.xpath("//button[text()='Lähetä']")).click();
					if (driver.findElement(By.xpath("//h4[text()='Kiitos vastaamisesta! Vastauksesi:']"))
							.isDisplayed()) {
						log.info("Response message displayed.. ");
						SubmitResponseFlag = true;
					} else {
						log.info("Response message not displayed.. ");
						SubmitResponseFlag = false;
					}
					break;
				case "French":
					driver.findElement(By.xpath("//button[text()='Soumettre']")).click();
					if (driver
							.findElement(By.xpath(
									"//h4[text()='Nous vous remercions pour votre participation à cette enquête !']"))
							.isDisplayed()) {
						log.info("Response message displayed.. ");
						SubmitResponseFlag = true;
					} else {
						log.info("Response message not displayed.. ");
						SubmitResponseFlag = false;
					}
					break;

				case "German":
					driver.findElement(By.xpath("//button[text()='Einreichen']")).click();
					if (driver.findElement(By
							.xpath("//h4[text()='Vielen Dank für Ihre Teilnahme an unserer Umfrage! Ihre Antworten:']"))
							.isDisplayed()) {
						log.info("Response message displayed.. ");
						SubmitResponseFlag = true;
					} else {
						log.info("Response message not displayed.. ");
						SubmitResponseFlag = false;
					}
					break;
				case "Italian":
					driver.findElement(By.xpath("//button[text()='Invia']")).click();
					if (driver.findElement(By.xpath(
							"//h4[text()='Grazie per aver partecipato al nostro sondaggio! Le vostre risposte']"))
							.isDisplayed()) {
						log.info("Response message displayed.. ");
						SubmitResponseFlag = true;
					} else {
						log.info("Response message not displayed.. ");
						SubmitResponseFlag = false;
					}
					break;
				case "Japanese":
					driver.findElement(By.xpath("//button[text()='提出']")).click();
					if (driver.findElement(By.xpath("//h4[text()='アンケートにご協力いただきありがとうございます。あなたの回答']")).isDisplayed()) {
						log.info("Response message displayed.. ");
						SubmitResponseFlag = true;
					} else {
						log.info("Response message not displayed.. ");
						SubmitResponseFlag = false;
					}
					break;
				case "Korean":
					driver.findElement(By.xpath("//button[text()='제출']")).click();
					if (driver.findElement(By.xpath("//h4[text()='설문 조사에 응 해주셔서 감사합니다! 귀하의 응답']")).isDisplayed()) {
						log.info("Response message displayed.. ");
						SubmitResponseFlag = true;
					} else {
						log.info("Response message not displayed.. ");
						SubmitResponseFlag = false;
					}
					break;
				case "Portuguese":
					driver.findElement(By.xpath("//button[text()='Submeter']")).click();
					if (driver
							.findElement(By.xpath("//h4[text()='Obrigado por fazer nossa pesquisa! Suas respostas:']"))
							.isDisplayed()) {
						log.info("Response message displayed.. ");
						SubmitResponseFlag = true;
					} else {
						log.info("Response message not displayed.. ");
						SubmitResponseFlag = false;
					}
					break;
				case "Russian":
					driver.findElement(By.xpath("//button[text()='отправить']")).click();
					if (driver.findElement(By.xpath("//h4[text()='Спасибо за участие в нашем опросе. Ваши ответы:']"))
							.isDisplayed()) {
						log.info("Response message displayed.. ");
						SubmitResponseFlag = true;
					} else {
						log.info("Response message not displayed.. ");
						SubmitResponseFlag = false;
					}
					break;
				case "Spanish":
					driver.findElement(By.xpath("//button[text()='Enviar']")).click();
					if (driver
							.findElement(By.xpath("//h4[text()='Gracias por tomar nuestra encuesta! Sus respuestas:']"))
							.isDisplayed()) {
						log.info("Response message displayed.. ");
						SubmitResponseFlag = true;
					} else {
						log.info("Response message not displayed.. ");
						SubmitResponseFlag = false;
					}
					break;
				case "Swedish":
					driver.findElement(By.xpath("//button[text()='Skicka']")).click();
					if (driver.findElement(By.xpath("//h4[text()='Tack för att du har gjort vår enkät! Dina svar']"))
							.isDisplayed()) {
						log.info("Response message displayed.. ");
						SubmitResponseFlag = true;
					} else {
						log.info("Response message not displayed.. ");
						SubmitResponseFlag = false;
					}
					break;
				case "Turkish":
					driver.findElement(By.xpath("//button[text()='Teslim et']")).click();
					if (driver
							.findElement(By.xpath(
									"//h4[text()='Anketimizi doldurduğunuz için teşekkür ederiz. Cevaplarınız:']"))
							.isDisplayed()) {
						log.info("Response message displayed.. ");
						SubmitResponseFlag = true;
					} else {
						log.info("Response message not displayed.. ");
						SubmitResponseFlag = false;
					}
					break;

				}
				driver.close();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.switchTo().window(BaseWindow);
			}
		}

		if (SubmitResponseFlag) {
			log.info("Transportation_SubmitSurveyInAllLanguage method ends here with true.........");
			return true;
		} else {
			log.info("Transportation_SubmitSurveyInAllLanguage method ends here with false.........");
			return false;
		}
	}

	// Building -> Transportation-> Exports survey results
	public boolean Transportation_ExportSurveyResults() {
		log.info("Transportation_ExportSurveyResults  method starts here.........");
		boolean DownloadedFlag = false;
		boolean WalkFlag = false;
		boolean BikeFlag = false;
		boolean TeleCommuteFlag = false;
		boolean MotorCycleFlag = false;
		boolean ProjectNameFlag = false;
		boolean RapidTransitFlag = false;
		boolean CarPoolFlag = false;
		boolean CarAlternateFlag = false;
		boolean LightRailFlag = false;
		boolean BusFlag = false;
		boolean CarSoloFlag = false;
		boolean NameFlag = false;
		boolean LanguageFlag = false;
		boolean OccupantCategoryFlag = false;
		// boolean ProjectIDFlag=false;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		TransportationSurvey.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		// String handle = driver.getWindowHandle();
		waithelper.WaitForElementClickable(Transportation_SurveyToolsResource,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Transportation_SurveyToolsResource.click();

		driver.findElement(By.xpath("(//div[@class='dropdown-toggle'])[2]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		List<WebElement> LanguageList = driver
				.findElements(By.xpath("(//div[@class='dropdown-toggle'])[2]/following-sibling::ul/li/a"));
		ArrayList<String> langList = new ArrayList<String>();
		for (WebElement ele : LanguageList) {
			langList.add(ele.getText());
		}
		log.info("Total Number of language is " + LanguageList.size());

		driver.findElement(By.xpath("//a[text()='Export Survey Results']")).click(); // Clicking on Export Survey
																						// Results.
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		DownloadedFlag = CommonMethod.CheckExportDataDownloadedFile();
		log.info("Downloaded file flag is " + DownloadedFlag);
		String Excelpath = DownloadFolder + "\\Export Data.xlsx";
		log.info(Excelpath);

		// ArrayList<Integer> ExcelProjectID =
		// data.getAllNumericDataFromColumn(Excelpath, "Transportation", 0);
		ArrayList<String> ExcelProjectName = data.getAllStringDataFromColumn(Excelpath, "Transportation", 1);
		ArrayList<Integer> ExcelWalk = data.getAllNumericDataFromColumn(Excelpath, "Transportation", 2);
		ArrayList<Integer> ExcelBike = data.getAllNumericDataFromColumn(Excelpath, "Transportation", 3);
		ArrayList<Integer> ExcelTeleCommute = data.getAllNumericDataFromColumn(Excelpath, "Transportation", 4);
		ArrayList<Integer> ExcelBus = data.getAllNumericDataFromColumn(Excelpath, "Transportation", 5);
		ArrayList<Integer> ExcelLightRail = data.getAllNumericDataFromColumn(Excelpath, "Transportation", 6);
		ArrayList<Integer> ExcelRapidTransit = data.getAllNumericDataFromColumn(Excelpath, "Transportation", 7);
		ArrayList<Integer> ExcelMotorCycle = data.getAllNumericDataFromColumn(Excelpath, "Transportation", 8);
		ArrayList<Integer> ExcelCarSolo = data.getAllNumericDataFromColumn(Excelpath, "Transportation", 9);
		ArrayList<Integer> ExcelCarPool = data.getAllNumericDataFromColumn(Excelpath, "Transportation", 10);
		ArrayList<Integer> ExcelCarAlterNatePool = data.getAllNumericDataFromColumn(Excelpath, "Transportation", 11);
		ArrayList<String> ExcelName = data.getAllStringDataFromColumn(Excelpath, "Transportation", 12);
		ArrayList<String> ExcelCategory = data.getAllStringDataFromColumn(Excelpath, "Transportation", 14);
		ArrayList<String> ExcelLangList = data.getAllStringDataFromColumn(Excelpath, "Transportation", 13);

		// String ProjectID=System.getProperty("BuildingProject_Test1");
		String ProjectName = System.getProperty("BuildingProject_Test1_Name");
		int Walk = Integer.parseInt(data.getCellData("Building", 26, 2));
		int Bike = Integer.parseInt(data.getCellData("Building", 27, 2));
		int TeleCommute = Integer.parseInt(data.getCellData("Building", 28, 2));
		int MotorCycle = Integer.parseInt(data.getCellData("Building", 29, 2));
		int RapidTransit = Integer.parseInt(data.getCellData("Building", 30, 2));
		int CarPool = Integer.parseInt(data.getCellData("Building", 31, 2));
		int CarAlternatePool = Integer.parseInt(data.getCellData("Building", 32, 2));
		int LightRail = Integer.parseInt(data.getCellData("Building", 33, 2));
		int Bus = Integer.parseInt(data.getCellData("Building", 34, 2));
		int CarSolo = Integer.parseInt(data.getCellData("Building", 35, 2));
		String Name = data.getCellData("Building", 38, 2);
		String Category = data.getCellData("Building", 39, 2);

		// ProjectIDFlag=Transportation_CheckNumericInArrayList(ExcelProjectID,
		// ProjectID);
		WalkFlag = Transportation_CheckNumericInArrayList(ExcelWalk, Walk);
		BikeFlag = Transportation_CheckNumericInArrayList(ExcelBike, Bike);
		TeleCommuteFlag = Transportation_CheckNumericInArrayList(ExcelTeleCommute, TeleCommute);
		MotorCycleFlag = Transportation_CheckNumericInArrayList(ExcelMotorCycle, MotorCycle);
		RapidTransitFlag = Transportation_CheckNumericInArrayList(ExcelRapidTransit, RapidTransit);
		CarPoolFlag = Transportation_CheckNumericInArrayList(ExcelCarPool, CarPool);
		CarAlternateFlag = Transportation_CheckNumericInArrayList(ExcelCarAlterNatePool, CarAlternatePool);
		LightRailFlag = Transportation_CheckNumericInArrayList(ExcelLightRail, LightRail);
		BusFlag = Transportation_CheckNumericInArrayList(ExcelBus, Bus);
		CarSoloFlag = Transportation_CheckNumericInArrayList(ExcelCarSolo, CarSolo);
		ProjectNameFlag = Transportation_CheckStringInArrayList(ExcelProjectName, ProjectName);
		NameFlag = Transportation_CheckStringInArrayList(ExcelName, Name);
		OccupantCategoryFlag = Transportation_CheckStringInArrayList(ExcelCategory, Category);

		if (ExcelLangList.equals(langList)) {
			LanguageFlag = true;
		}

		// log.info("ProjectIDFlag value is "+ProjectIDFlag);
		log.info("WalkFlag value is " + WalkFlag);
		log.info("BikeFlag value is " + BikeFlag);
		log.info("TeleCommuteFlag value is " + TeleCommuteFlag);
		log.info("MotorCycleFlag value is " + MotorCycleFlag);
		log.info("RapidTransitFlag value is " + RapidTransitFlag);
		log.info("CarPoolFlag value is " + CarPoolFlag);
		log.info("CarAlternateFlag value is " + CarAlternateFlag);
		log.info("LightRailFlag value is " + LightRailFlag);
		log.info("BusFlag value is " + BusFlag);
		log.info("CarSoloFlag value is " + CarSoloFlag);
		log.info("ProjectNameFlag value is " + ProjectNameFlag);
		log.info("NameFlag value is " + NameFlag);
		log.info("OccupantCategoryFlag value is " + OccupantCategoryFlag);

		if ((WalkFlag) && (BikeFlag) && (TeleCommuteFlag) && (MotorCycleFlag) && (RapidTransitFlag) && (CarPoolFlag)
				&& (CarAlternateFlag) && (LightRailFlag) && (BusFlag) && (CarSoloFlag) && (ProjectNameFlag)
				&& (OccupantCategoryFlag) && (NameFlag) && (LanguageFlag)) {
			log.info("Transportation_ExportSurveyResults method ends here with true.........");
			return true;
		} else {
			log.info("Transportation_ExportSurveyResults method ends here with false.........");
			return false;
		}
	}

	// Building -> Transportation-> Verify for the above test case- X is calculated
	// as = (Number of Response/total occupancy)*100
	public boolean Transportation_ResponsePercentage() {
		log.info("Transportation_ResponsePercentage  method starts here.........");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"(//table[@class='building-settings'])[2]/descendant::div[contains(text(),'Building Settings')]"))
				.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ClickOnBuildingSetting_OccupantTab();
		float TotalOccupant = Float.parseFloat(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/span")).getText());

		TransportationSurvey.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		waithelper.WaitForElementClickable(Transportation_SurveyToolsResource,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		actionhelper.mouseOverElement(driver.findElement(By.xpath("//*[name()='g']//*[local-name()='circle' ]")));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//p[@class='heading']/following-sibling::div[@class='values']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		float Response = Float.parseFloat(driver
				.findElement(By.xpath("//p[@class='heading']/following-sibling::div[@class='values']")).getText());
		float Exp_PCT = (Response / TotalOccupant) * 100;
		String PCT = driver.findElement(By.xpath(
				"//div[@class='progress']/following-sibling::div[1]/span[contains(@class,'survey_label floatr')]"))
				.getText();
		String[] PCTValue = PCT.split("\\s");
		float Act_PCT = Float.parseFloat(PCTValue[0]);
		DecimalFormat df = new DecimalFormat("0.00");

		String formate1 = df.format(Exp_PCT);
		double EPCT = 0;
		try {
			EPCT = (Double) df.parse(formate1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Actual Percentage showing is " + Act_PCT);
		log.info("Expected Percentage should be " + EPCT);
		if (Float.toString(Act_PCT).equals(Double.toString(EPCT))) {
			log.info("Transportation_ResponsePercentage method ends here with true.........");
			return true;
		} else {
			log.info("Transportation_ResponsePercentage method ends here with false.........");
			return false;
		}
	}

	// Building -> HE - Occupant Satisfaction Survey -> Validate in HE- Survey bar
	// shows the same percentage as transportation Survey bar.
	public boolean HE_OccupantSatisfactionSurvey_ResponsePercentage() {
		log.info("HE_OccupantSatisfactionSurvey_ResponsePercentage  method starts here.........");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String OccupantPCT = driver.findElement(By.xpath(
				"//div[@class='progress']/following-sibling::div[1]/span[contains(@class,'survey_label floatr')]"))
				.getText();

		TransportationSurvey.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		waithelper.WaitForElementClickable(Transportation_SurveyToolsResource,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		String TransportPCT = driver.findElement(By.xpath(
				"//div[@class='progress']/following-sibling::div[1]/span[contains(@class,'survey_label floatr')]"))
				.getText();

		log.info("Occupant Percentage showing is " + OccupantPCT);
		log.info("Transportation Percentage showing is " + TransportPCT);
		if (OccupantPCT.equals(TransportPCT)) {
			log.info("HE_OccupantSatisfactionSurvey_ResponsePercentage method ends here with true.........");
			return true;
		} else {
			log.info("HE_OccupantSatisfactionSurvey_ResponsePercentage method ends here with false.........");
			return false;
		}
	}

	// Building -> Transportation -Verify "For your project X responses will
	// generate score" message is displayed below transport bar.
	public boolean Transportation_CheckMessageBelowTransportBar() {
		log.info("Transportation_CheckMessageBelowTransportBar  method starts here.........");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		TransportationSurvey.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		waithelper.WaitForElementClickable(Transportation_SurveyToolsResource,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println(driver.findElement(By.xpath("//div[@class='progress']/following-sibling::div[2]")).getText());
		String[] message = driver.findElement(By.xpath("//div[@class='progress']/following-sibling::div[2]")).getText()
				.split(",");

		if (message[0].contains("For your project") && message[1].contains("responses will generate a score.")) {
			log.info("Transportation_CheckMessageBelowTransportBar method ends here with true.........");
			return true;
		} else {
			log.info("Transportation_CheckMessageBelowTransportBar method ends here with false.........");
			return false;
		}
	}

// This method will check whether same text exists in whole Arraylist or not

	public boolean Transportation_CheckStringInArrayList(ArrayList<String> ListName, String Text) {
		log.info("Transportation_CheckStringInArrayList method starts here  ");
		boolean flag = false;
		for (String name : ListName) {
			if (name.equals(Text)) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		log.info("Transportation_CheckStringInArrayList method ends here  ");
		return flag;
	}

//This method will check whether same Number exists in whole Arraylist or not

	public boolean Transportation_CheckNumericInArrayList(ArrayList<Integer> ListName, int num) {
		log.info("Transportation_CheckNumericInArrayList method starts here  ");
		boolean flag = false;
		for (int number : ListName) {
			if (number == num) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		log.info("Transportation_CheckNumericInArrayList method ends here  ");
		return flag;
	}

	public boolean Transportation_SelectLanguage(String Lang) {
		boolean languageFlag = false;
		driver.findElement(By.xpath("//select[@id='survey_language']")).click();
		driver.findElement(By.xpath("//select[@id='survey_language']/option[text()='" + Lang + "']")).click();
		/*
		 * try { languageFlag =
		 * driver.findElement(By.xpath("//button[text()='Soumettre']")).isDisplayed(); }
		 * catch (Exception e) { e.printStackTrace(); log.info("Unable to select " +
		 * Lang + " language..."); }
		 */
		return languageFlag;
	}

	// Building -> Transportation-> Fill all the details and submit the survey with
	// each slider options.
	public boolean Transportation_SubmitSurveyWithEachSliderOptions() {
		log.info("Transportation_SubmitSurveyWithEachSliderOptions  method starts here.........");
		boolean flag = false;
		boolean SubmitResponseFlag = false;
		boolean SliderFlag = false;
		// boolean LabelFound = false;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TransportationSurvey.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		// String handle = driver.getWindowHandle();
		waithelper.WaitForElementClickable(Transportation_SurveyToolsResource,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Transportation_SurveyToolsResource.click();

		driver.findElement(By.xpath("(//div[@class='dropdown-toggle'])[2]")).click();
		flag = Transportation_copyLanguage("English");
		String url=null;
		if (flag) {
			int k = 0;
			for (int i = 1; i <= 7; i++) {
				Transportation_OpenNewTabWithCopiedURL(url);
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				waithelper.WaitForElementClickable(
						driver.findElement(By.xpath("//span[text()='Select Travel Method']/parent::button")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
				JSHelper.clickElement(
						driver.findElement(By.xpath("//span[text()='Select Travel Method']/parent::button")));

				waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h4[text()='Route 1']")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
				Transportaton_FillQuestion1_RouteDetails();
				int xwidth = Transportation_RangeSlider.getSize().getWidth();
				log.info("width is " + xwidth);
				log.info("Height is " + Transportation_RangeSlider.getSize().getHeight());

				log.info("Ith value is " + i);
				actionhelper.dragAndDrop(Transportation_RangeSlider, xwidth - 300, 0);
				actionhelper.dragAndDrop(Transportation_RangeSlider, xwidth + k, 0);
				k = k + 100;

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String Message = Transportation_SatisfactionMSG.getText();
				SliderFlag = Transportation_SelectAll_SurveyOptions(Message);
				log.info(SliderFlag);
				log.info("  ---- " + Message);
				BuildingSurvey_CommentOptional.sendKeys(data.getCellData("Building", 36, 2));
				BuildingSurvey_Location.sendKeys(data.getCellData("Building", 37, 2));
				BuildingSurvey_NameOptional.sendKeys(data.getCellData("Building", 38, 2));
				String Occupant = data.getCellData("Building", 39, 2);

				driver.findElement(By.xpath("//select[@id='occupant_category']")).click();
				driver.findElement(By.xpath("//select[@id='occupant_category']/option[text()='" + Occupant + "']"))
						.click();
				waithelper.WaitForElementClickable(Transportation_SubmitBtn,
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
				Transportation_SubmitBtn.click();
				if (Transportation_SubmitResponseText.isDisplayed()) {
					log.info("Response message displayed.. ");
					SubmitResponseFlag = true;
					driver.close();
					driver.switchTo().window(BaseWindow);
				} else {
					log.info("Response message not displayed.. ");
					SubmitResponseFlag = false;
					driver.close();
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					driver.switchTo().window(BaseWindow);
					break;
				}

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		if (SubmitResponseFlag) {
			log.info("Transportation_SubmitSurveyWithEachSliderOptions method ends here with true.........");
			return true;
		} else {
			log.info("Transportation_SubmitSurveyWithEachSliderOptions method ends here with false.........");
			return false;
		}
	}

	// Building -> Transportation-> Fill all the details and submit the survey with
	// 2 route details
	public boolean Transportation_SubmitSurveyWith2Routes() {
		log.info("Transportation_SubmitSurveyWith2Routes  method starts here.........");
		boolean SubmitResponseFlag = false;
		boolean SliderFlag = false;
		// boolean LabelFound = false;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TransportationSurvey.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String handle = driver.getWindowHandle();
		waithelper.WaitForElementClickable(Transportation_SurveyToolsResource,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Transportation_SurveyToolsResource.click();

		driver.findElement(By.xpath("(//div[@class='dropdown-toggle'])[2]")).click();
		Transportation_copyLanguage("English");
		String url=null;
		Transportation_OpenNewTabWithCopiedURL(url);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementClickable(
				driver.findElement(By.xpath("//span[text()='Select Travel Method']/parent::button")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(driver.findElement(By.xpath("//span[text()='Select Travel Method']/parent::button")));

		waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h4[text()='Route 1']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		Transportaton_FillQuestion1_RouteDetails();

		// actionhelper.dragAndDrop(Transportation_RangeSlider, xwidth + k, 0);
		driver.findElement(By.xpath(" //*[contains(text(),'Add Another Route')]")).click();

		waithelper.WaitForElementClickable(
				driver.findElement(By.xpath("(//span[text()='Select Travel Method'])[2]/parent::button")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(
				driver.findElement(By.xpath("(//span[text()='Select Travel Method'])[2]/parent::button")));

		waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h4[text()='Route 2']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Transportaton_FillQuestion1_RouteDetails();
		int xwidth = Transportation_RangeSlider.getSize().getWidth();
		actionhelper.dragAndDrop(Transportation_RangeSlider, xwidth - 200, 0);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// String Message = Transportation_SatisfactionMSG.getText();
		// String Message = Transportation_SatisfactionMSG.getText();
		String Message = driver.findElement(By.xpath(
				"//div[@class='mb20 selected']/preceding-sibling::div/h4[@class='slider-text fw-400 ng-binding']"))
				.getText();

		// SliderFlag = Transportation_SelectAll_SurveyOptions(Message);
		SliderFlag = Transportation_SelectAll_SurveyOptions(Message);
		log.info(SliderFlag);
		log.info("  ---- " + Message);
		BuildingSurvey_CommentOptional.sendKeys(data.getCellData("Building", 36, 2));
		BuildingSurvey_Location.sendKeys(data.getCellData("Building", 37, 2));
		BuildingSurvey_NameOptional.sendKeys(data.getCellData("Building", 38, 2));
		String Occupant = data.getCellData("Building", 39, 2);

		driver.findElement(By.xpath("//select[@id='occupant_category']")).click();
		driver.findElement(By.xpath("//select[@id='occupant_category']/option[text()='" + Occupant + "']")).click();
		waithelper.WaitForElementClickable(Transportation_SubmitBtn, Integer.parseInt(prop.getProperty("explicitTime")),
				2);
		Transportation_SubmitBtn.click();
		if (Transportation_SubmitResponseText.isDisplayed()) {
			log.info("Response message displayed.. ");
			SubmitResponseFlag = true;
		} else {
			log.info("Response message not displayed.. ");
			SubmitResponseFlag = false;
			driver.close();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().window(handle);
			// break;
		}
		driver.close();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().window(handle);

		if (SubmitResponseFlag) {
			log.info("Transportation_SubmitSurveyWith2Routes method ends here with true.........");
			return true;
		} else {
			log.info("Transportation_SubmitSurveyWith2Routes method ends here with false.........");
			return false;
		}
	}

	// Validate the options based on slider selection whether options are showing or
	// not.
	public boolean Transportation_Validate_SurveyOptions(String Message) {
		log.info("Transportation_Validate_SurveyOptions method starts here with option " + Message);
		String[] UnsatisfiedArray = { "Dirty", "Cold", "Drafty", "Smelly", "Dark", "Bright", "Stuffy", "Glare",
				"Views to Outdoors", "Acoustics", "Privacy", "Sound", "Hot", "Humid" };
		ArrayList<String> UnSatisfiedList = new ArrayList<String>(Arrays.asList(UnsatisfiedArray));

		String[] satisfiedArray = { "Thermal Comfort", "Sound", "Air Quality", "Cleanliness", "Light", "Privacy",
				"Views to Outdoors", "Daylight" };
		ArrayList<String> SatisfiedList = new ArrayList<String>(Arrays.asList(satisfiedArray));

		List<WebElement> UnsatisfiedCheckBoxLabelList;

		List<WebElement> satisfiedCheckBoxLabelList;
		boolean flag = false;
		boolean Question3Flag = false;
		if (Message.equals("Extremely Unsatisfied") || Message.equals("Very Unsatisfied")
				|| Message.equals("Unsatisfied")) {
			log.info(Message + " is selected.");
			String Question3 = driver
					.findElement(By.xpath("//span[contains(@class,'fontSize16 fw-600 col-md-12 pl0')]")).getText();
			// System.out.println(Question3);
			if (Question3.equals(
					"3. We're sorry to hear that. Please select the options below that significantly reduce your satisfaction:")) {
				log.info("Question 3 showing properly...");
				driver.findElements(By.xpath("//div[contains(@class,'col-md-4 survey-options mt20')]/div/input"));
				UnsatisfiedCheckBoxLabelList = driver
						.findElements(By.xpath("//div[contains(@class,'col-md-4 survey-options mt20')]/div/label"));
				log.info("Total Number of Labels showing for " + Message + " are "
						+ UnsatisfiedCheckBoxLabelList.size());

				for (WebElement ele : UnsatisfiedCheckBoxLabelList) {
					if (UnSatisfiedList.contains(ele.getText())) {
						log.info(ele.getText() + " exists on the page..");
						/*
						 * UnsatisfiedCheckBoxeList.get(i).click(); try { Thread.sleep(1000); } catch
						 * (InterruptedException e) { // TODO Auto-generated catch block
						 * e.printStackTrace(); }
						 */
						flag = true;
					} else {
						log.info(ele.getText() + " does not exist on the page..");
						flag = false;
						break;
					}
				}
			} else {
				log.info("Question 3 not showing properly...");
				flag = false;
			}
		} else if (Message.equals("Neither satisfied nor unsatisfied")) {
			log.info(Message + " is selected.");
			try {
				Question3Flag = driver
						.findElement(By.xpath("//span[contains(@class,'fontSize16 fw-600 col-md-12 pl0')]"))
						.isDisplayed();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (Question3Flag == false) {
				log.info("Question 3 is not displaying...");
				flag = true;
			} else {
				log.info("Question 3 is still displaying...");
				flag = false;
			}

		}

		else if (Message.equals("Satisfied") || Message.equals("Very Satisfied")
				|| Message.equals("Extremely Satisfied")) {
			log.info(Message + " is selected.");
			String Question3 = driver
					.findElement(By.xpath("//span[contains(@class,'fontSize16 fw-600 col-md-12 pl0')]")).getText();
			// System.out.println(Question3);
			if (Question3.equals(
					"3. We're glad to hear that. Please select the options below that significantly enhance your satisfaction:")) {
				log.info("Question 3 showing properly...");
				driver.findElements(By.xpath("//div[contains(@class,'col-md-4 survey-options mt20')]/div/input"));
				satisfiedCheckBoxLabelList = driver
						.findElements(By.xpath("//div[contains(@class,'col-md-4 survey-options mt20')]/div/label"));
				log.info("Total Number of Labels showing for " + Message + " are " + satisfiedCheckBoxLabelList.size());

				for (WebElement ele : satisfiedCheckBoxLabelList) {
					if (SatisfiedList.contains(ele.getText())) {
						log.info(ele.getText() + " exists on the page..");
						/*
						 * CheckBoxeList.get(i).click(); try { Thread.sleep(1000); } catch
						 * (InterruptedException e) { // TODO Auto-generated catch block
						 * e.printStackTrace(); }
						 */
						flag = true;
					} else {
						log.info(ele.getText() + " does not exist on the page..");
						flag = false;
						break;
					}
				}
			} else {
				log.info("Question 3 not showing properly...");
				flag = false;
			}
		}
		log.info("Transportation_Validate_SurveyOptions method ends here with option " + Message);
		return flag;
	}

	// Select all the options based on slider selection.
	public boolean Transportation_SelectAll_SurveyOptions(String Message) {
		log.info("Transportation_SelectAll_SurveyOptions method starts here with option " + Message);
		String[] UnsatisfiedArray = { "Dirty", "Cold", "Drafty", "Smelly", "Dark", "Bright", "Stuffy", "Glare",
				"Views to Outdoors", "Acoustics", "Privacy", "Sound", "Hot", "Humid" };
		ArrayList<String> UnSatisfiedList = new ArrayList<String>(Arrays.asList(UnsatisfiedArray));

		String[] satisfiedArray = { "Thermal Comfort", "Sound", "Air Quality", "Cleanliness", "Light", "Privacy",
				"Views to Outdoors", "Daylight" };
		ArrayList<String> SatisfiedList = new ArrayList<String>(Arrays.asList(satisfiedArray));

		List<WebElement> UnsatisfiedCheckBoxeList;
		List<WebElement> UnsatisfiedCheckBoxLabelList;

		List<WebElement> satisfiedCheckBoxeList;
		List<WebElement> satisfiedCheckBoxLabelList;
		boolean flag = false;
		boolean Question3Flag = false;
		if (Message.equals("Extremely Unsatisfied") || Message.equals("Very Unsatisfied")
				|| Message.equals("Unsatisfied")) {
			log.info(Message + " is selected.");
			String Question3 = driver
					.findElement(By.xpath("//span[contains(@class,'fontSize16 fw-600 col-md-12 pl0')]")).getText();
			// System.out.println(Question3);
			if (Question3.equals(
					"3. We're sorry to hear that. Please select the options below that significantly reduce your satisfaction:")) {
				log.info("Question 3 showing properly...");
				UnsatisfiedCheckBoxeList = driver
						.findElements(By.xpath("//div[contains(@class,'col-md-4 survey-options mt20')]/div/input"));
				UnsatisfiedCheckBoxLabelList = driver
						.findElements(By.xpath("//div[contains(@class,'col-md-4 survey-options mt20')]/div/label"));
				log.info("Total Number of Labels showing for " + Message + " are "
						+ UnsatisfiedCheckBoxLabelList.size());

				// Validation and checking all Checkboxes.
				int i = 0;
				for (WebElement ele : UnsatisfiedCheckBoxLabelList) {
					if (UnSatisfiedList.contains(ele.getText())) {
						log.info(ele.getText() + " exists on the page..");
						UnsatisfiedCheckBoxeList.get(i).click();
						if (UnsatisfiedCheckBoxeList.get(i).isSelected()) {
							log.info(ele.getText() + " is selected successfully...");
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) { // TODO Auto-generated catch block
								e.printStackTrace();
							}

							flag = true;
						} else {
							log.info("Unable to select " + ele.getText());
							flag = false;
							break;
						}
					} else {
						log.info(ele.getText() + " does not exist on the page..");
						flag = false;
						break;
					}
					i++;
				}
			} else {
				log.info("Question 3 not showing properly...");
				flag = false;
			}
		} else if (Message.equals("Neither satisfied nor unsatisfied")) {
			log.info(Message + " is selected.");
			try {
				Question3Flag = driver
						.findElement(By.xpath("//span[contains(@class,'fontSize16 fw-600 col-md-12 pl0')]"))
						.isDisplayed();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (Question3Flag == false) {
				log.info("Question 3 is not displaying...");
				flag = true;
			} else {
				log.info("Question 3 is still displaying...");
				flag = false;
			}

		}

		else if (Message.equals("Satisfied") || Message.equals("Very Satisfied")
				|| Message.equals("Extremely Satisfied")) {
			log.info(Message + " is selected.");
			String Question3 = driver
					.findElement(By.xpath("//span[contains(@class,'fontSize16 fw-600 col-md-12 pl0')]")).getText();
			// System.out.println(Question3);
			if (Question3.equals(
					"3. We're glad to hear that. Please select the options below that significantly enhance your satisfaction:")) {
				log.info("Question 3 showing properly...");
				satisfiedCheckBoxeList = driver
						.findElements(By.xpath("//div[contains(@class,'col-md-4 survey-options mt20')]/div/input"));
				satisfiedCheckBoxLabelList = driver
						.findElements(By.xpath("//div[contains(@class,'col-md-4 survey-options mt20')]/div/label"));
				log.info("Total Number of Labels showing for " + Message + " are " + satisfiedCheckBoxLabelList.size());

				// Validation and checking all Checkboxes.
				int i = 0;
				for (WebElement ele : satisfiedCheckBoxLabelList) {
					if (SatisfiedList.contains(ele.getText())) {
						satisfiedCheckBoxeList.get(i).click();
						if (satisfiedCheckBoxeList.get(i).isSelected()) {
							log.info(ele.getText() + " is selected successfully...");
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) { // TODO Auto-generated catch block
								e.printStackTrace();
							}

							flag = true;
						} else {
							log.info("Unable to select " + ele.getText());
							flag = false;
							break;
						}
					} else {
						log.info(ele.getText() + " does not exist on the page..");
						flag = false;
						break;
					}
					i++;
				}
			} else {
				log.info("Question 3 not showing properly...");
				flag = false;
			}
		}
		log.info("Transportation_SelectAll_SurveyOptions method ends here with option " + Message);
		return flag;
	}

	// Building Settings--> Water --> Verify Clicking on add row allows to add
	// start date,end date, reading, cost and documents.
	public boolean Water_AddRecord() {
		log.info("Water_AddRecord  method starts here.........");
		int BeforeTotalRows = 0;
		int AfterTotalRows = 0;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.getProperty("WaterMeterName");
		driver.findElement(By.xpath("(//table[@class='meterListByType--wrapper']/tbody/tr[2])[2]/td[2]/div")).click();
		BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows before adding showing are  " + BeforeTotalRows);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * String UploadPath = System.getProperty("user.dir") +
		 * "\\UploadDocument\\File1.pdf"; driver.findElement(By.xpath(
		 * "//table[@id='readingsTable']/tbody/tr[1]/td[6]/div/div/button")).click();
		 * WebElement element = driver.findElement(By.xpath(
		 * "//table[@id='readingsTable']/tbody/tr[1]/td[6]/input")); // element.click();
		 * try { Thread.sleep(3000); } catch (InterruptedException e1) { // TODO
		 * Auto-generated catch block e1.printStackTrace(); } driver.findElement( By.
		 * xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/div/div/ul/li/span[text()='Computer File']"
		 * )) .click(); try { Thread.sleep(3000); } catch (InterruptedException e1) { //
		 * TODO Auto-generated catch block e1.printStackTrace(); }
		 * 
		 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
		 */
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 1st day of previous month
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 20st day of previous month

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/input"))
				.sendKeys(data.getCellData("Building", 20, 2));

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[7]/button")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(
						By.xpath("(//table[@class='meterListByType--wrapper']/tbody/tr[1])[2]/td[3]/div/span/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody/tr[1])[2]/td[3]/div/span/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		AfterTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + AfterTotalRows);
		/*
		 * int score = Integer.parseInt(driver .findElement( By.xpath(
		 * "(//table[@class='meterListByType--wrapper']/tbody/tr[1])[1]/td[3]/div/span/span"
		 * )) .getText()); RowsList =
		 * driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr")); int
		 * AfterAddingTotalRows = RowsList.size();
		 * log.info("Total Number of rows after adding " + AfterAddingTotalRows);
		 */
		if (AfterTotalRows - BeforeTotalRows == 1) {
			log.info("Water_AddRecord method ends here with true.........");
			return true;
		} else {
			log.info("Water_AddRecord method ends here with false.........");
			return false;
		}

	}

	// Building Settings--> Waste Data --> Verify Clicking on add row allows to add
	// with Diverted value greater than Generated Value
	public boolean WasteData_CheckValidation_DivertedValueGenerated() {
		log.info("WasteData_CheckValidation_DivertedValueGenerated  method starts here.........");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//table[@id='wasteTable']/tbody/tr[1]/td[2]/input")).click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 1st day of previous month
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='wasteTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 20st day of previous month

		int Generated = Integer.parseInt(data.getCellData("Building", 22, 2));
		int Diverted = Generated + 100;
		driver.findElement(By.xpath("//table[@id='wasteTable']/tbody/tr[1]/td[4]/input"))
				.sendKeys(Integer.toString(Generated));

		driver.findElement(By.xpath("//table[@id='wasteTable']/tbody/tr[1]/td[5]/input"))
				.sendKeys(Integer.toString(Diverted));
		String unit = data.getCellData("Building", 24, 2);

		waithelper.WaitForElementClickable(
				driver.findElement(By.xpath("//table[@id='wasteTable']/tbody/tr[1]/td[6]/div/button")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		JSHelper.clickElement(driver.findElement(By.xpath("//table[@id='wasteTable']/tbody/tr[1]/td[6]/div/button")));
		// driver.findElement(By.xpath("//table[@id='wasteTable']/tbody/tr[1]/td[6]/div/button")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<WebElement> Units = driver
				.findElements(By.xpath("//table[@id='wasteTable']/tbody/tr[1]/td[6]/div/ul/li/a"));
		log.info("Total Number of size is --" + Units.size());
		CommonMethod.selectValuesFromDropDown(Units, unit);

		flag = driver.findElement(By.xpath(
				"//table[@id='wasteTable']/tbody/tr[1]/td[5]/p[text()='Waste Diverted greater than Waste Genereted']"))
				.isDisplayed();
		if (flag) {
			log.info("WasteData_CheckValidation_DivertedValueGenerated method ends here with true.........");
			return true;
		} else {
			log.info("WasteData_CheckValidation_DivertedValueGenerated method ends here with false.........");
			return false;
		}

	}

	// Building Settings--> Waste Data --> Verify Clicking on add row allows to add
	// start date,end date, Generated, Diverted, Units, Source and documents.
	public boolean WasteData_AddRecord() {
		log.info("WasteData_AddRecord  method starts here.........");
		int BeforeTotalRows = 0;
		int AfterTotalRows = 0;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BeforeTotalRows = CommonMethod.getTotalRowCount("//table[@id='wasteTable']/tbody/tr");
		log.info("Total Number of rows before adding showing are  " + BeforeTotalRows);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		BuildingSetting_AddRow_button.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * String UploadPath = System.getProperty("user.dir") +
		 * "\\UploadDocument\\File1.pdf"; driver.findElement(By.xpath(
		 * "//table[@id='wasteTable']/tbody/tr[1]/td[8]/div/div/button")).click();
		 * 
		 * try { Thread.sleep(3000); } catch (InterruptedException e1) { // TODO
		 * Auto-generated catch block e1.printStackTrace(); } driver.findElement(By.
		 * xpath("//table[@id='wasteTable']/tbody/tr[1]/td[8]/div/div/ul/li/span[text()='Computer File']"
		 * )).click(); try { Thread.sleep(3000); } catch (InterruptedException e1) { //
		 * TODO Auto-generated catch block e1.printStackTrace(); }
		 * 
		 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
		 */

		driver.findElement(By.xpath("//table[@id='wasteTable']/tbody/tr[1]/td[2]/input")).click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		String CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 1st day of previous month
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='wasteTable']/tbody/tr[1]/td[3]/input")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@class=' table-condensed']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click();
		CalXpath = "(//table[@class=' table-condensed']/tbody/tr/td[text()='20'])[1]";
		driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 20st day of previous month

		driver.findElement(By.xpath("//table[@id='wasteTable']/tbody/tr[1]/td[4]/input"))
				.sendKeys(data.getCellData("Building", 22, 2));

		driver.findElement(By.xpath("//table[@id='wasteTable']/tbody/tr[1]/td[5]/input"))
				.sendKeys(data.getCellData("Building", 23, 2));
		String unit = data.getCellData("Building", 24, 2);

		waithelper.WaitForElementClickable(
				driver.findElement(By.xpath("//table[@id='wasteTable']/tbody/tr[1]/td[6]/div/button")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		JSHelper.clickElement(driver.findElement(By.xpath("//table[@id='wasteTable']/tbody/tr[1]/td[6]/div/button")));
		// driver.findElement(By.xpath("//table[@id='wasteTable']/tbody/tr[1]/td[6]/div/button")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<WebElement> Units = driver
				.findElements(By.xpath("//table[@id='wasteTable']/tbody/tr[1]/td[6]/div/ul/li/a"));
		log.info("Total Number of size is --" + Units.size());
		CommonMethod.selectValuesFromDropDown(Units, unit);
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(
						By.xpath("(//table[@class='meterListByType--wrapper']/tbody/tr[1])[3]/td[3]/div/span/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody/tr[1])[3]/td[3]/div/span/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		AfterTotalRows = CommonMethod.getTotalRowCount("//table[@id='wasteTable']/tbody/tr");
		log.info("Total Number of rows After adding showing are  " + AfterTotalRows);

		if (AfterTotalRows - BeforeTotalRows == 1) {
			log.info("WasteData_AddRecord method ends here with true.........");
			return true;
		} else {
			log.info("WasteData_AddRecord method ends here with false.........");
			return false;
		}

	}

	// Building Settings--> Energy --> Verify Delete button allows you to delete
	// line item.
	// First adding one record and then delete the same record.
	public boolean Energy_DeleteRow() {
		log.info("Energy_DeleteRow  method starts here.........");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.getProperty("EnergyMeterName");
		waithelper.WaitForElementClickable(
				driver.findElement(By.xpath("(//table[@class='meterListByType--wrapper']/tbody/tr[2])[1]/td[2]/div")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		driver.findElement(By.xpath("(//table[@class='meterListByType--wrapper']/tbody/tr[2])[1]/td[2]/div")).click();
		/*
		 * waithelper.WaitForElementClickable(BuildingSetting_AddRow_button,
		 * Integer.parseInt(prop.getProperty("explicitTime")), 2); int
		 * BeforeAddingTotalRows =
		 * CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		 * log.info("Total Number of rows before adding " + BeforeAddingTotalRows);
		 * BuildingSetting_AddRow_button.click();
		 * 
		 * try { Thread.sleep(2000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * driver.findElement(By.xpath(
		 * "//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).click();
		 * 
		 * waithelper.WaitForElementVisibleWithPollingTime(
		 * driver.findElement(By.xpath("//table[@class=' table-condensed']")),
		 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
		 * driver.findElement(By.
		 * xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click
		 * (); String CalXpath =
		 * "(//table[@class=' table-condensed']/tbody/tr/td[text()='1'])[1]";
		 * driver.findElement(By.xpath(CalXpath)).click(); // Selecting Start Date 1st
		 * day of previous month try { Thread.sleep(2000); } catch (InterruptedException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * driver.findElement(By.xpath(
		 * "//table[@id='readingsTable']/tbody/tr[1]/td[3]/input")).click();
		 * 
		 * waithelper.WaitForElementVisibleWithPollingTime(
		 * driver.findElement(By.xpath("//table[@class=' table-condensed']")),
		 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
		 * driver.findElement(By.
		 * xpath("//table[@class=' table-condensed']/thead/tr/th[@class='prev']")).click
		 * (); CalXpath =
		 * "(//table[@class=' table-condensed']/tbody/tr/td[text()='25'])[1]";
		 * driver.findElement(By.xpath(CalXpath)).click(); // Selecting End Date 25st
		 * day of previous month
		 * 
		 * driver.findElement(By.xpath(
		 * "//table[@id='readingsTable']/tbody/tr[1]/td[4]/input"))
		 * .sendKeys(data.getCellData("Building", 15, 2));
		 * 
		 * // driver.findElement(By.xpath(
		 * "//table[@id='readingsTable']/tbody/tr[1]/td[5]/input")).sendKeys(data.
		 * getCellData("Building", // 16, 2));
		 * 
		 * driver.findElement(By.xpath(
		 * "//table[@id='readingsTable']/tbody/tr[1]/td[7]/button")).click();
		 * 
		 * waithelper.WaitForElementVisibleWithPollingTime( driver.findElement(
		 * By.xpath(
		 * "(//table[@class='meterListByType--wrapper']/tbody/tr[1])[1]/td[3]/div/span/span/*"
		 * )), Integer.parseInt(prop.getProperty("explicitTime")), 2); try {
		 * waithelper.WaitForElementInvisible( driver.findElement(By.xpath(
		 * "(//table[@class='meterListByType--wrapper']/tbody/tr[1])[1]/td[3]/div/span/span/*"
		 * )), Integer.parseInt(prop.getProperty("explicitTime")), 2); } catch
		 * (Exception e) { e.printStackTrace(); }
		 * 
		 * int AfterAddingTotalRows =
		 * CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		 * log.info("Total Number of rows after adding " + BeforeAddingTotalRows); if
		 * (AfterAddingTotalRows - BeforeAddingTotalRows == 1) {
		 * log.info("Row added successfully and going to delete..."); try {
		 * driver.findElement(By.xpath(
		 * "//table[@id='readingsTable']/tbody/tr[1]/td[8]/span")).click(); } catch
		 * (Exception e) { e.printStackTrace(); log.info("Unable to delete row......");
		 * } }
		 */
		int TotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows before deleting " + TotalRows);
		if (TotalRows >= 1) {
			log.info("Going to delete...");
			try {
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[8]/span")).click();
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to delete row......");
			}

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[8]/div/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"(//table[@class='meterListByType--wrapper']/tbody/tr[1])[1]/td[3]/div/span/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			log.info("There is no row,so can not perform delete operation...");
			return false;
		}

		int AfterDeletingTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows after Deleting " + AfterDeletingTotalRows);

		if (TotalRows - AfterDeletingTotalRows == 1) {
			log.info("Energy_DeleteRow method ends here with true.........");
			return true;
		} else {
			log.info("Energy_DeleteRow method ends here with false.........");
			return false;
		}

	}

	// Building Settings--> Water --> Verify Delete button allows you to delete
	// line item.
	// First adding one record and then delete the same record.
	public boolean Water_DeleteRow() {
		log.info("Water_DeleteRow  method starts here.........");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.getProperty("EnergyMeterName");

		int BeforeDeletingTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows before adding " + BeforeDeletingTotalRows);

		if (BeforeDeletingTotalRows >= 0) {
			try {
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[8]/span")).click();
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to delete row......");
			}
		} else {
			log.info("There is no row added, can not perform delete operation....");
		}

		waithelper.WaitForElementInvisible(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[8]/div/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody/tr[1])[1]/td[3]/div/span/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		int AfterDeletingTotalRows = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows after Deleting " + AfterDeletingTotalRows);

		if (BeforeDeletingTotalRows - AfterDeletingTotalRows == 1) {
			log.info("Water_DeleteRow method ends here with true.........");
			return true;
		} else {
			log.info("Water_DeleteRow method ends here with false.........");
			return false;
		}

	}

	// Building Settings--> Energy --> Verify when adding new meter and type is
	// selected as 'other fuel' , Fuel Source options get changed to Natural gas.
	public boolean EnergyCheckOtherFuelType() {
		log.info("EnergyCheckOtherFuelType  method starts here.........");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementVisibleWithPollingTime(AddAEnergyDataPopUpHeader,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		waithelper.WaitForElementClickable(AddNewMeterNextBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(AddNewMeterNextBtn);
		String MeterName = "E-" + CommonMethod.generateRandomString(6);
		MeterNameTextBox.sendKeys(MeterName);

		data.getCellData("Building", 13, 2);
		JSHelper.clickElement(driver
				.findElement(By.xpath("//div[@class='fw600 mb10' and text()='Type']/following-sibling::div/button")));
		// driver.findElement(By.xpath("//div[@class='fw600 mb10' and
		// text()='Type']/following-sibling::div/button")).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> TypeOptions = driver
				.findElements(By.xpath("//div[@class='fw600 mb10' and text()='Type']/following-sibling::div/ul/li/a"));
		log.info("Total number of options for Type  " + TypeOptions.size());

		for (WebElement ele : TypeOptions) {
			String option = ele.getText().trim();
			log.info("Current option is -- " + option);
			if (option.equals("Other Fuels")) {
				// ele.click();
				JSHelper.clickElement(ele);
				log.info(option + " is selected successfully..");
				break;
			}
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String SelectedFuelSource = driver
				.findElement(
						By.xpath("//div[@class='fw600 mb10' and text()='Fuel Source']/parent::div/div[2]/button/span"))
				.getText().trim();

		if (SelectedFuelSource.equals("Natural Gas")) {
			log.info("Natural Gas is selected successfully..");
			log.info("EnergyCheckOtherFuelType  method ends here with true .........");
			return true;
		} else {
			log.info("Natural Gas is not selected successfully..");
			log.info("EnergyCheckOtherFuelType  method ends here with false .........");
			return false;
		}
	}

	// Building Settings--> Energy --> Verify for type 'Fuel type' by adding all the
	// options from the dropdown.
	public boolean Energy_AddWithOtherFuelsType() {
		log.info("Energy_AddWithOtherFuelsType  method starts here.........");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean flag = false;
		ArrayList<String> FuelSource = new ArrayList<String>();

		CommonMethod.switchToShowOverviewFrame();
		CheckAddEnergyDataModelWindow();

		waithelper.WaitForElementClickable(AddNewMeterNextBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		AddNewMeterNextBtn.click();

		data.getCellData("Building", 13, 2);

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//div[@class='fw600 mb10' and text()='Type']/following-sibling::div/button"))
				.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> TypeOptions = driver
				.findElements(By.xpath("//div[@class='fw600 mb10' and text()='Type']/following-sibling::div/ul/li/a"));
		log.info("Total number of options for Type  " + TypeOptions.size());

		for (WebElement ele : TypeOptions) {
			String option = ele.getText();
			// log.info("Current option is -- " + option);
			if (option.equals("Other Fuels")) {
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
		// System.out.println(FuelSource);
		driver.findElement(
				By.xpath("//div[@class='fw600 mb10' and text()='Fuel Source']/following-sibling::div/button")).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> FuelSourcList = driver.findElements(
				By.xpath("//div[@class='fw600 mb10' and text()='Fuel Source']/following-sibling::div/ul/li/a"));

		for (WebElement ele : FuelSourcList) {
			String option = ele.getText();
			// log.info("Current option is -- " + option);
			FuelSource.add(option);
		}
		log.info("Total number of option in Fuel Source are -- " + FuelSource.size());
		log.info("Total number of FuelSourcList are -- " + FuelSourcList.size());
		int i = 0;
		Iterator<String> itr = FuelSource.iterator();
		while (itr.hasNext()) {
			CommonMethod.switchToDefaultContent();
			ClickonOverview();
			CommonMethod.switchToShowOverviewFrame();

			CheckAddEnergyDataModelWindow();

			waithelper.WaitForElementClickable(AddNewMeterNextBtn, Integer.parseInt(prop.getProperty("explicitTime")),
					2);
			AddNewMeterNextBtn.click();
			String FuelS = itr.next().toString();
			String MeterName = "E-" + FuelS;
			MeterNameTextBox.sendKeys(MeterName);

			waithelper.WaitForElementClickable(
					driver.findElement(
							By.xpath("//div[@class='fw600 mb10' and text()='Type']/following-sibling::div/button")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			driver.findElement(By.xpath("//div[@class='fw600 mb10' and text()='Type']/following-sibling::div/button"))
					.click();

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			TypeOptions = driver.findElements(
					By.xpath("//div[@class='fw600 mb10' and text()='Type']/following-sibling::div/ul/li/a"));
			log.info("Total number of options for Type  " + TypeOptions.size());

			for (WebElement ele : TypeOptions) {
				String option = ele.getText();
				if (option.equals("Other Fuels")) {
					log.info("Current Type is -- " + option);
					waithelper.WaitForElementClickable(ele, Integer.parseInt(prop.getProperty("explicitTime")), 2);
					ele.click();
					break;
				}
			}

			waithelper.WaitForElementClickable(
					driver.findElement(By.xpath(
							"//div[@class='fw600 mb10' and text()='Fuel Source']/following-sibling::div/button")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			driver.findElement(
					By.xpath("//div[@class='fw600 mb10' and text()='Fuel Source']/following-sibling::div/button"))
					.click();

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FuelSourcList = driver.findElements(
					By.xpath("//div[@class='fw600 mb10' and text()='Fuel Source']/following-sibling::div/ul/li/a"));

			for (WebElement ele : FuelSourcList) {
				String option = ele.getText();
				if (option.equals(FuelS)) {
					waithelper.WaitForElementClickable(ele, Integer.parseInt(prop.getProperty("explicitTime")), 2);
					log.info("Current Fuel Source is -- " + option);
					ele.click();
					log.info(option + " is selected successfully...");
					break;
				}
			}

			waithelper.WaitForElementClickable(
					driver.findElement(
							By.xpath("//div[@class='modalWindow-footer overflow-auto']/button/span[text()='ADD']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			driver.findElement(By.xpath("//div[@class='modalWindow-footer overflow-auto']/button/span[text()='ADD']"))
					.click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//div[contains(text(),'ENERGY METER')])[2]/following-sibling::div")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			i++;

			if (driver.findElement(By.xpath("(//div[contains(text(),'ENERGY METER')])[2]/following-sibling::div"))
					.isDisplayed()) {
				log.info("Record added successfully with " + FuelS);
				flag = true;
			} else {
				log.info("Record not added successfully with " + FuelS);
				flag = false;
				break;
			}

			log.info("Total record added is ............" + i);

		}
		if (flag) {
			log.info("Energy_AddWithOtherFuelsType  method ends here with true .........");
			return true;
		} else {
			log.info("Energy_AddWithOtherFuelsType  method ends here with false .........");
			return false;
		}
	}
	// Building Settings--> Water --> Validate for Water meter- Add new meter-
	// Should populate values by default as -"Type- Water", "Unit type- gal" and
	// "Fuel source- municipality supplied potable water.", Just add 'meter name'
	// and click on Add button should add a new meter.

	public boolean Water_AddNewMeter_DefaultValues() {
		log.info("Water_AddNewMeter_DefaultValues  method starts here.........");
		boolean DefaultType = false;
		boolean DefaultUnitType = false;
		boolean DefaultFuelSource = false;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementClickable(WaterAddNewMeter, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		WaterAddNewMeter.click();
		waithelper.WaitForElementVisibleWithPollingTime(AddAWaterDataPopUpHeader,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		waithelper.WaitForElementClickable(AddNewMeterNextBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		AddNewMeterNextBtn.click();

		MeterNameTextBox.sendKeys("W-" + CommonMethod.generateRandomString(5));

		String DefaultTypeValue = driver
				.findElement(By.xpath("//div[@class='fw600 mb10' and text()='Type']/parent::div/div[2]/button/span"))
				.getText();
		String DefaultUnitValue = driver
				.findElement(By.xpath("//div[@class='fw600 mb10' and text()='Unit']/parent::div/div[2]/button/span"))
				.getText();
		String DefaultFuelSourceValue = driver
				.findElement(
						By.xpath("//div[@class='fw600 mb10' and text()='Fuel Source']/parent::div/div[2]/button/span"))
				.getText().trim();
		if (DefaultTypeValue.equals("Water")) {
			DefaultType = true;
			log.info("Default Type is selected as " + DefaultTypeValue);
		}

		if (DefaultUnitValue.equals("gal")) {
			DefaultUnitType = true;
			log.info("Default unit is selected as " + DefaultUnitValue);
		}

		if (DefaultFuelSourceValue.equals("Municipality supplied potable water")) {
			DefaultFuelSource = true;
			log.info("Default Fuel Source is selected as " + DefaultFuelSourceValue);
		}

		if ((DefaultUnitType) && (DefaultType) && (DefaultFuelSource)) {
			log.info("Water_AddNewMeter_DefaultValues method ends here with true.........");
			return true;
		} else {
			log.info("Water_AddNewMeter_DefaultValues method ends here with false.........");
			return false;
		}

	}

	// Building -> Re-Entry -->FMS -> --> Go to Survey Tools and Resources- Send
	// Survey- Copy link and paste it to another browser.
	public boolean ReEntry_FMS_OpenSurveyLinkInNewTab() {
		log.info("ReEntry_FMS_OpenSurveyLinkInNewTab  method starts here.........");
		boolean flag = false;
		boolean OpenSurveyTab = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(
				driver.findElement(By.xpath("(//button[contains(text(),'Survey Tools and Resources')])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("(//button[contains(text(),'Survey Tools and Resources')])[2]")).click();

		driver.findElement(By.xpath("//a[text()='Send Survey']")).click();
		CommonMethod.switchToDefaultContent();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//div[text()='Facilities and Management Survey']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String url = driver.findElement(By.xpath("//div[@class='w60p']/input")).getAttribute("value");
		log.info("Copied URL is "+url);
		//CommonMethod.setClipBoard(url);
		JSHelper.clickElement(driver.findElement(By.xpath("//a[text()='Copy Link']")));
		flag = driver.findElement(By.xpath("//div[@class='ml10 copy_notif']")).isDisplayed();
		log.info("Flag value is "+flag);
		driver.findElement(By.xpath("//div[@class='pt16']/button[text()='Close']")).click();
		if (flag) {
			OpenSurveyTab = Transportation_OpenNewTabWithCopiedURL(url);
			driver.close();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().window(BaseWindow);
		}

		if (OpenSurveyTab) {
			log.info("ReEntry_FMS_OpenSurveyLinkInNewTab method ends here with true.........");
			return true;
		} else {
			log.info("ReEntry_FMS_OpenSurveyLinkInNewTab method ends here with false.........");
			return false;
		}

	}

	// Building -> Re-Entry -->FMS -> In F & M survey, If question 1 Is a specific
	// individual responsible for the development and implementation of infectious
	// disease control policies, plans, and procedures for this facility?" is
	// selected as Yes, gives option to upload file, paste link and Enter 'Contact
	// information'
	public boolean ReEntry_FMS_Question1_WithYesOption() {
		log.info("ReEntry_FMS_Question1_WithYesOption  method starts here.........");
		boolean flag = false;
		String Question_Link = data.getCellData("Building", 53, 2);
		String Question_Contact = data.getCellData("Building", 54, 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(
				driver.findElement(By.xpath("(//button[contains(text(),'Survey Tools and Resources')])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("(//button[contains(text(),'Survey Tools and Resources')])[2]")).click();

		driver.findElement(By.xpath("//a[text()='Send Survey']")).click();
		CommonMethod.switchToDefaultContent();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//div[text()='Facilities and Management Survey']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String url = driver.findElement(By.xpath("//div[@class='w60p']/input")).getAttribute("value");
		log.info("Copied URL is "+url);
		//CommonMethod.setClipBoard(url);
		// js.executeScript("document.querySelector("'#copy-link-button'")
		// driver.findElement(By.xpath("//a[text()='Copy
		// Link']/parent::button")).click();
		// driver.findElement(By.xpath("//div[@class='w60p']/following-sibling::div[1]/*")).click();
		// actionhelper.mouseOverElementAndClick(driver.findElement(By.xpath("//a[text()='Copy
		// Link']")));
		JSHelper.clickElement(driver.findElement(By.xpath("//a[text()='Copy Link']")));
		flag = driver.findElement(By.xpath("//div[@class='ml10 copy_notif']")).isDisplayed();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		log.info("Copied flag is " + flag);
		driver.findElement(By.xpath("//div[@class='pt16']/button[text()='Close']")).click();
		if (flag) {
			Transportation_OpenNewTabWithCopiedURL(url);
			driver.findElement(
					By.xpath("(//div[@class='survey-question radio-button'])[1]/div[2]/descendant::input[1]")).click();
			String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";
			js.executeScript("arguments[0].setAttribute('style', 'display:block !important;')", driver.findElement(
					By.xpath("(//div[@class='survey-question radio-button'])[1]/div[2]/div[2]/input[@type='file']")));
			driver.findElement(By.xpath("(//div[@class='survey-question radio-button'])[1]/div[2]/div[2]/div[2]/span"))
					.click();
			driver.findElement(By.xpath("//input[@id='infectious_control_upload_picker']")).sendKeys(UploadPath);

			/*
			 * driver.findElement(By.
			 * xpath("(//div[@class='survey-question radio-button'])[1]/div[2]/div[2]/div[2]/span"
			 * )) .click(); try { Thread.sleep(5000); } catch (InterruptedException e1) { //
			 * TODO Auto-generated catch block e1.printStackTrace(); }
			 * 
			 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
			 */

			waithelper.WaitForElementClickable(driver.findElement(By.xpath(
					"(//div[@class='survey-question radio-button'])[1]/div[2]/div[2]/div[2]/div[@class='icon_deleteDoc']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			driver.findElement(By.xpath("(//div[@class='mt16 ng-scope'])[2]/descendant::input"))
					.sendKeys(Question_Link);
			try {
				driver.findElement(By.xpath(
						"(//div[@class='radio_buttons'])[1]/following-sibling::div[2]/descendant::div[text()='Add link']"))
						.click();

			} catch (Exception e) {
				log.info("Unable to click on Add Link");
			}
			driver.findElement(By.xpath("(//div[@class='mt16 ng-scope'])[3]/descendant::input"))
					.sendKeys(Question_Contact);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			waithelper.WaitForElementClickable(driver.findElement(By.xpath("//button[text()='Submit']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			driver.findElement(By.xpath("//button[text()='Submit']")).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h4[@class='fw-400 mb20']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			driver.close();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		flag = FMS_Verify(1, Question_Link);
		return flag;
	}

	public boolean ReEntry_FMS_Question2_WithYesOption() {
		log.info("ReEntry_FMS_Question2_WithYesOption  method starts here.........");
		boolean OpenSurveyTab = false;
		boolean flag = false;
		String Question_Link = data.getCellData("Building", 55, 2);
		String url=FMS_CopySurveyLink();
		OpenSurveyTab = Transportation_OpenNewTabWithCopiedURL(url);
		if (OpenSurveyTab) {
			FMS_SelectYes_UploadFile_AddLink(2, Question_Link);// takes row number and URL to paste in
			flag = FMS_Verify(2, Question_Link); // that particular question
			if (flag) {
				log.info("ReEntry_FMS_Question2_WithYesOption method ends here with true.........");
				return true;
			} else {
				log.info("ReEntry_FMS_Question2_WithYesOption method ends here with false.........");
				return false;
			}
		} else {
			log.info("Unable to open new tab with copied URL...");
			log.info("ReEntry_FMS_Question2_WithYesOption method ends here with false.........");
			return false;
		}
	}

	public String FMS_CopySurveyLink() {
		log.info("FMS_CopySurveyLink method starts here...");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(
				driver.findElement(By.xpath("(//button[contains(text(),'Survey Tools and Resources')])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("(//button[contains(text(),'Survey Tools and Resources')])[2]")).click();

		driver.findElement(By.xpath("//a[text()='Send Survey']")).click();
		CommonMethod.switchToDefaultContent();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//div[text()='Facilities and Management Survey']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String url = driver.findElement(By.xpath("//div[@class='w60p']/input")).getAttribute("value");
		//CommonMethod.setClipBoard(url);
		log.info("Copied url is " + url);
		JSHelper.clickElement(driver.findElement(By.xpath("//a[text()='Copy Link']")));
		flag = driver.findElement(By.xpath("//div[@class='ml10 copy_notif']")).isDisplayed();
		log.info("Copied flag is " + flag);
		driver.findElement(By.xpath("//div[@class='pt16']/button[text()='Close']")).click();
		log.info("FMS_CopySurveyLink method ends here with " + flag + "  ...");
		return url;
	}

	public void FMS_SelectYes_UploadFile_AddLink(int QNo, String QLink) {
		log.info("FMS_SelectYes_UploadFile_AddLink method starts here...");
		driver.findElement(
				By.xpath("(//div[@class='survey-question radio-button'])[" + QNo + "]/div[2]/descendant::input[1]"))
				.click();
		String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";
		// driver.findElement(
		// By.xpath("(//div[@class='survey-question radio-button'])[" + QNo +
		// "]/div[2]/div[2]/div[2]/span")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(
				By.xpath("(//div[@class='survey-question radio-button'])[" + QNo + "]/div[2]/div[2]/input"));
		js.executeScript("arguments[0].setAttribute('style', 'display:block !important;')", element);
		driver.findElement(By.xpath("(//div[@class='survey-question radio-button'])[" + QNo
				+ "]/div[2]/div[2]/descendant::span[text()='Upload file']")).click();
		element.sendKeys(UploadPath);
		/*
		 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
		 * 
		 * waithelper.WaitForElementClickable(
		 * driver.findElement(By.xpath("(//div[@class='survey-question radio-button'])["
		 * + QNo + "]/div[2]/div[2]/div[2]/div[@class='icon_deleteDoc']")),
		 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
		 */
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(
				By.xpath("(//div[@class='radio_buttons'])[" + QNo + "]/following-sibling::div[2]/descendant::input"))
				.sendKeys(QLink);
		try {
			driver.findElement(By.xpath("(//div[@class='radio_buttons'])[" + QNo
					+ "]/following-sibling::div[2]/descendant::div[text()='Add link']")).click();

		} catch (Exception e) {
			log.info("Unable to click on Add Link");
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//button[text()='Submit']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h4[@class='fw-400 mb20']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.close();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("FMS_SelectYes_UploadFile_AddLink method ends here...");
	}

	public boolean FMS_Verify(int QNo, String QLink) {
		log.info("FMS_Verify method starts here....");
		driver.switchTo().window(BaseWindow);
		CommonMethod.RefreshPagewaitForPageLoaded(driver);
		ClickOnMetersAndSurveyMenu();
		ClickOnReEntry_FMS();

		boolean ResponseFlag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + QNo
				+ "]/td[2]/span[contains(@class,'mr5 saved_symbol saved_symbol')]")).isDisplayed();
		String ResponseText = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + QNo + "]/td[2]"))
				.getText();
		String DocumentCount = driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + QNo + "]/td[3]/div/span")).getText();

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + QNo + "]/td[3]/div")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JSHelper.scrollIntoView(
				driver.findElement(By.xpath("(//*[contains(text(),'Facility Management Survey')])[3]")));
		String DocumentName = driver
				.findElement(By.xpath("(//table[@class='file-explorer'])[2]/tbody/tr[1]/td[1]/span")).getText();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath(
				"(//table[@class='file-explorer'])[2]/ancestor::div[@class='modal-body']/following-sibling::div/button"))
				.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String LinkCount = driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + QNo + "]/td[4]/div/span")).getText();

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + QNo + "]/td[4]/div")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JSHelper.scrollIntoView(
				driver.findElement(By.xpath("(//*[contains(text(),'Facility Management Survey')])[3]")));
		String LinkURL = driver.findElement(By.xpath("(//table[@class='file-explorer'])[1]/tbody/tr[1]/td[1]"))
				.getText();
		JSHelper.clickElement(driver.findElement(By.xpath(
				"(//table[@class='file-explorer'])[1]/ancestor::div[@class='modal-body']/following-sibling::div/button")));
		log.info("Response Flag is  " + ResponseFlag);
		log.info("ResponseText is  " + ResponseText);
		log.info("DocumentCount is  " + DocumentCount);
		log.info("DocumentName is  " + DocumentName);
		log.info("LinkCount is  " + LinkCount);
		log.info("LinkURL is  " + LinkURL);

		if ((ResponseFlag) && (ResponseText.equals("Yes")) && (DocumentCount.equals("1"))
				&& (DocumentName.equals("File1.pdf")) && (LinkCount.equals("1")) && (LinkURL.equals(QLink))) {
			log.info("FMS_Verify method ends here with true  ...");
			return true;
		} else {
			log.info("FMS_Verify method ends here with false.........");
			return false;
		}
	}

	public void FMS_DiseaseControlCommmunication_Yes_UploadFile_AddLink(int QNo, String QLink) {
		log.info("FMS_DiseaseControlCommmunication_Yes_UploadFile_AddLink method starts here...");
		String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";
		String YesXpath = "//div[@class='mb30 disease_comm_signage']/descendant::span[contains(text(),'Yes')]/input";
		String UploadXpath = "//div[@class='mb30 disease_comm_signage']/descendant::span[contains(text(),'Upload file')]";
		String DeleteXpath = "//div[@class='mb30 disease_comm_signage']/descendant::div[@class='icon_deleteDoc']";
		String LinkXpath = "//div[@class='mb30 disease_comm_signage']/descendant::input[starts-with(@class,'link_value')]";
		driver.findElement(By.xpath(YesXpath)).click();
		driver.findElement(By.xpath(UploadXpath)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//input[@id='disease_comm_signage_upload_picker']"));
		js.executeScript("arguments[0].setAttribute('style', 'display:block !important;')", element);
		element.sendKeys(UploadPath);
		/*
		 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
		 * 
		 * waithelper.WaitForElementClickable(
		 * driver.findElement(By.xpath(DeleteXpath)),
		 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
		 */
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath(LinkXpath)).sendKeys(QLink);
		try {
			driver.findElement(By.xpath("(//div[@class='radio_buttons'])[" + QNo
					+ "]/following-sibling::div[2]/descendant::div[text()='Add link']")).click();

		} catch (Exception e) {
			log.info("Unable to click on Add Link");
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//button[text()='Submit']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h4[@class='fw-400 mb20']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.close();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("FMS_DiseaseControlCommmunication_Yes_UploadFile_AddLink method ends here...");

	}

	public void FMS_HandWashingAndDisinfection_Yes_UploadFile_AddLink(int QNo, String QLink) {
		log.info("FMS_HandWashingAndDisinfection_Yes_UploadFile_AddLink method starts here...");
		String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";
		String YesXpath = "//div[@class='mb30 clean_disinfactant']/descendant::span[contains(text(),'Yes')]/input";
		String UploadXpath = "//div[@class='mb30 clean_disinfactant']/descendant::span[contains(text(),'Upload file')]";
		String DeleteXpath = "//div[@class='mb30 clean_disinfactant']/descendant::div[@class='icon_deleteDoc']";
		String LinkXpath = "//div[@class='mb30 clean_disinfactant']/descendant::input[starts-with(@class,'link_value')]";
		driver.findElement(By.xpath(YesXpath)).click();
		driver.findElement(By.xpath(UploadXpath)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//input[@id='clean_disinfactant_upload_picker']"));
		js.executeScript("arguments[0].setAttribute('style', 'display:block !important;')", element);
		element.sendKeys(UploadPath);
		/*
		 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
		 * 
		 * waithelper.WaitForElementClickable(
		 * driver.findElement(By.xpath(DeleteXpath)),
		 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
		 */
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath(LinkXpath)).sendKeys(QLink);
		try {
			driver.findElement(By.xpath("(//div[@class='radio_buttons'])[" + QNo
					+ "]/following-sibling::div[2]/descendant::div[text()='Add link']")).click();

		} catch (Exception e) {
			log.info("Unable to click on Add Link");
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//button[text()='Submit']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h4[@class='fw-400 mb20']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.close();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("FMS_HandWashingAndDisinfection_Yes_UploadFile_AddLink method ends here...");
	}

	public void FMS_ProvidingPPE_And_ProperUse_Yes_UploadFile_AddLink(int QNo, String QLink) {
		log.info("FMS_ProvidingPPE_And_ProperUse_Yes_UploadFile_AddLink method starts here...");
		String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";
		String YesXpath = "//div[@class='mb30 ppe_facility']/descendant::span[contains(text(),'Yes')]/input";
		String UploadXpath = "//div[@class='mb30 ppe_facility']/descendant::span[contains(text(),'Upload file')]";
		String DeleteXpath = "//div[@class='mb30 ppe_facility']/descendant::div[@class='icon_deleteDoc']";
		String LinkXpath = "//div[@class='mb30 ppe_facility']/descendant::input[starts-with(@class,'link_value')]";
		driver.findElement(By.xpath(YesXpath)).click();
		driver.findElement(By.xpath(UploadXpath)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//input[@id='ppe_facility_upload_picker']"));
		js.executeScript("arguments[0].setAttribute('style', 'display:block !important;')", element);
		element.sendKeys(UploadPath);
		/*
		 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
		 * 
		 * waithelper.WaitForElementClickable(
		 * driver.findElement(By.xpath(DeleteXpath)),
		 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
		 */
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath(LinkXpath)).sendKeys(QLink);
		try {
			driver.findElement(By.xpath("(//div[@class='radio_buttons'])[" + QNo
					+ "]/following-sibling::div[2]/descendant::div[text()='Add link']")).click();

		} catch (Exception e) {
			log.info("Unable to click on Add Link");
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//button[text()='Submit']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h4[@class='fw-400 mb20']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.close();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.info("FMS_ProvidingPPE_And_ProperUse_Yes_UploadFile_AddLink method ends here...");

	}

	public void FMS_SocialDistancing_Yes_UploadFile_AddLink_Verify(int QNo, String QLink) {
		log.info("FMS_SocialDistancing_Yes_UploadFile_AddLink_Verify method starts here...");
		String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";
		String YesXpath = "//div[@class='mb30 social_distance']/descendant::span[contains(text(),'Yes')]/input";
		String UploadXpath = "//div[@class='mb30 social_distance']/descendant::span[contains(text(),'Upload file')]";
		String DeleteXpath = "//div[@class='mb30 social_distance']/descendant::div[@class='icon_deleteDoc']";
		String LinkXpath = "//div[@class='mb30 social_distance']/descendant::input[starts-with(@class,'link_value')]";
		driver.findElement(By.xpath(YesXpath)).click();
		driver.findElement(By.xpath(UploadXpath)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//input[@id='social_distance_upload_picker']"));
		js.executeScript("arguments[0].setAttribute('style', 'display:block !important;')", element);
		element.sendKeys(UploadPath);
		/*
		 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
		 * 
		 * waithelper.WaitForElementClickable(
		 * driver.findElement(By.xpath(DeleteXpath)),
		 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
		 */
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath(LinkXpath)).sendKeys(QLink);
		try {
			driver.findElement(By.xpath("(//div[@class='radio_buttons'])[" + QNo
					+ "]/following-sibling::div[2]/descendant::div[text()='Add link']")).click();

		} catch (Exception e) {
			log.info("Unable to click on Add Link");
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//button[text()='Submit']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h4[@class='fw-400 mb20']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.close();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("FMS_SocialDistancing_Yes_UploadFile_AddLink_Verify method ends here...");
	}

	public void FMS_HVACSystemOperation_Yes_UploadFile_AddLink(int QNo, String QLink) {
		log.info("FMS_HVACSystemOperation_Yes_UploadFile_AddLink method starts here...");
		String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";
		String YesXpath = "//div[@class='mb30 hvac_system']/descendant::span[contains(text(),'Yes')]/input";
		String UploadXpath = "//div[@class='mb30 hvac_system']/descendant::span[contains(text(),'Upload file')]";
		String DeleteXpath = "//div[@class='mb30 hvac_system']/descendant::div[@class='icon_deleteDoc']";
		String LinkXpath = "//div[@class='mb30 hvac_system']/descendant::input[starts-with(@class,'link_value')]";
		driver.findElement(By.xpath(YesXpath)).click();
		driver.findElement(By.xpath(UploadXpath)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//input[@id='hvac_system_upload_picker']"));
		js.executeScript("arguments[0].setAttribute('style', 'display:block !important;')", element);
		element.sendKeys(UploadPath);
		/*
		 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
		 * 
		 * waithelper.WaitForElementClickable(
		 * driver.findElement(By.xpath(DeleteXpath)),
		 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
		 */
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath(LinkXpath)).sendKeys(QLink);
		try {
			driver.findElement(By.xpath("(//div[@class='radio_buttons'])[" + QNo
					+ "]/following-sibling::div[2]/descendant::div[text()='Add link']")).click();

		} catch (Exception e) {
			log.info("Unable to click on Add Link");
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//button[text()='Submit']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h4[@class='fw-400 mb20']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.close();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("FMS_HVACSystemOperation_Yes_UploadFile_AddLink method ends here...");
	}

	public void FMS_HVACIncreasedVentilationRates_Yes_UploadFile_AddLink(int QNo, String QLink) {
		log.info("FMS_HVACIncreasedVentilationRates_Yes_UploadFile_AddLink method starts here...");
		String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";
		String YesXpath = "//div[@class='mb30 hvac_ventilation']/descendant::span[contains(text(),'Yes')]/input";
		String UploadXpath = "//div[@class='mb30 hvac_ventilation']/descendant::span[contains(text(),'Upload file')]";
		String DeleteXpath = "//div[@class='mb30 hvac_ventilation']/descendant::div[@class='icon_deleteDoc']";
		String LinkXpath = "//div[@class='mb30 hvac_ventilation']/descendant::input[starts-with(@class,'link_value')]";
		driver.findElement(By.xpath(YesXpath)).click();
		driver.findElement(By.xpath(UploadXpath)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//input[@id='hvac_ventilation_upload_picker']"));
		js.executeScript("arguments[0].setAttribute('style', 'display:block !important;')", element);
		element.sendKeys(UploadPath);
		/*
		 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
		 * 
		 * waithelper.WaitForElementClickable(
		 * driver.findElement(By.xpath(DeleteXpath)),
		 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
		 */
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath(LinkXpath)).sendKeys(QLink);
		try {
			driver.findElement(By.xpath("(//div[@class='radio_buttons'])[" + QNo
					+ "]/following-sibling::div[2]/descendant::div[text()='Add link']")).click();

		} catch (Exception e) {
			log.info("Unable to click on Add Link");
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//button[text()='Submit']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		// driver.findElement(By.xpath("//button[text()='Submit']")).click();
		JSHelper.clickElement(driver.findElement(By.xpath("//button[text()='Submit']")));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h4[@class='fw-400 mb20']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.close();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("FMS_HVACIncreasedVentilationRates_Yes_UploadFile_AddLink method ends here...");

	}

	public void FMS_HVACEnhanceFiltration_Yes_UploadFile_AddLink(int QNo, String QLink) {
		log.info("FMS_HVACEnhanceFiltration_Yes_UploadFile_AddLink method starts here...");
		String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";
		String YesXpath = "//div[@class='mb30 hvac_filtration']/descendant::span[contains(text(),'Yes')]/input";
		String UploadXpath = "//div[@class='mb30 hvac_filtration']/descendant::span[contains(text(),'Upload file')]";
		String DeleteXpath = "//div[@class='mb30 hvac_filtration']/descendant::div[@class='icon_deleteDoc']";
		String LinkXpath = "//div[@class='mb30 hvac_filtration']/descendant::input[starts-with(@class,'link_value')]";
		driver.findElement(By.xpath(YesXpath)).click();
		driver.findElement(By.xpath(UploadXpath)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//input[@id='hvac_filtration_upload_picker']"));
		js.executeScript("arguments[0].setAttribute('style', 'display:block !important;')", element);
		element.sendKeys(UploadPath);
		/*
		 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
		 * 
		 * waithelper.WaitForElementClickable(
		 * driver.findElement(By.xpath(DeleteXpath)),
		 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
		 */
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath(LinkXpath)).sendKeys(QLink);
		try {
			driver.findElement(By.xpath("(//div[@class='radio_buttons'])[" + QNo
					+ "]/following-sibling::div[2]/descendant::div[text()='Add link']")).click();

		} catch (Exception e) {
			log.info("Unable to click on Add Link");
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//button[text()='Submit']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		// driver.findElement(By.xpath("//button[text()='Submit']")).click();
		JSHelper.clickElement(driver.findElement(By.xpath("//button[text()='Submit']")));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h4[@class='fw-400 mb20']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.close();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("FMS_HVACEnhanceFiltration_Yes_UploadFile_AddLink method starts here...");
	}

	public void FMS_Elevatormanagement_Yes_UploadFile_AddLink(int QNo, String QLink) {
		log.info("FMS_Elevatormanagement_Yes_UploadFile_AddLink method starts here...");
		String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";
		String YesXpath = "//div[@class='mb30 elevator_man']/descendant::span[contains(text(),'Yes')]/input";
		String UploadXpath = "//div[@class='mb30 elevator_man']/descendant::span[contains(text(),'Upload file')]";
		String DeleteXpath = "//div[@class='mb30 elevator_man']/descendant::div[@class='icon_deleteDoc']";
		String LinkXpath = "//div[@class='mb30 elevator_man']/descendant::input[starts-with(@class,'link_value')]";
		driver.findElement(By.xpath(YesXpath)).click();
		driver.findElement(By.xpath(UploadXpath)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//input[@id='elevator_man_upload_picker']"));
		js.executeScript("arguments[0].setAttribute('style', 'display:block !important;')", element);
		element.sendKeys(UploadPath);
		/*
		 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
		 * 
		 * waithelper.WaitForElementClickable(
		 * driver.findElement(By.xpath(DeleteXpath)),
		 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
		 */
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath(LinkXpath)).sendKeys(QLink);
		try {
			driver.findElement(By.xpath("(//div[@class='radio_buttons'])[" + QNo
					+ "]/following-sibling::div[2]/descendant::div[text()='Add link']")).click();

		} catch (Exception e) {
			log.info("Unable to click on Add Link");
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//button[text()='Submit']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		// driver.findElement(By.xpath("//button[text()='Submit']")).click();
		JSHelper.clickElement(driver.findElement(By.xpath("//button[text()='Submit']")));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h4[@class='fw-400 mb20']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.close();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("FMS_Elevatormanagement_Yes_UploadFile_AddLink method ends here...");
	}

	public void FMS_PortableWaterManagement_Yes_UploadFile_AddLink(int QNo, String QLink) {
		log.info("FMS_PortableWaterManagement_Yes_UploadFile_AddLink method starts here...");
		String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";
		String YesXpath = "//div[@class='mb30 potable_water']/descendant::span[contains(text(),'Yes')]/input";
		String UploadXpath = "//div[@class='mb30 potable_water']/descendant::span[contains(text(),'Upload file')]";
		String DeleteXpath = "//div[@class='mb30 potable_water']/descendant::div[@class='icon_deleteDoc']";
		String LinkXpath = "//div[@class='mb30 potable_water']/descendant::input[starts-with(@class,'link_value')]";
		driver.findElement(By.xpath(YesXpath)).click();
		driver.findElement(By.xpath(UploadXpath)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//input[@id='potable_water_upload_picker']"));
		js.executeScript("arguments[0].setAttribute('style', 'display:block !important;')", element);
		element.sendKeys(UploadPath);
		/*
		 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
		 * 
		 * waithelper.WaitForElementClickable(
		 * driver.findElement(By.xpath(DeleteXpath)),
		 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
		 */
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath(LinkXpath)).sendKeys(QLink);
		try {
			driver.findElement(By.xpath("(//div[@class='radio_buttons'])[" + QNo
					+ "]/following-sibling::div[2]/descendant::div[text()='Add link']")).click();

		} catch (Exception e) {
			log.info("Unable to click on Add Link");
		}
		try {
			driver.findElement(By.xpath("(//div[@class='radio_buttons'])[" + QNo
					+ "]/following-sibling::div[2]/descendant::div[text()='Add link']")).click();

		} catch (Exception e) {
			log.info("Unable to click on Add Link");
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//button[text()='Submit']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		// driver.findElement(By.xpath("//button[text()='Submit']")).click();
		JSHelper.clickElement(driver.findElement(By.xpath("//button[text()='Submit']")));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h4[@class='fw-400 mb20']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.close();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("FMS_PortableWaterManagement_Yes_UploadFile_AddLink method ends here...");
	}

	public void FMS_IAQAssessment_Yes_UploadFile_AddLink(int QNo, String QLink) {
		log.info("FMS_IAQAssessment_Yes_UploadFile_AddLink method starts here...");
		String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";
		String YesXpath = "//div[@class='mb30 iaq_assessment']/descendant::span[contains(text(),'Yes')]/input";
		String UploadXpath = "//div[@class='mb30 iaq_assessment']/descendant::span[contains(text(),'Upload file')]";
		String DeleteXpath = "//div[@class='mb30 iaq_assessment']/descendant::div[@class='icon_deleteDoc']";
		String LinkXpath = "//div[@class='mb30 iaq_assessment']/descendant::input[starts-with(@class,'link_value')]";
		driver.findElement(By.xpath(YesXpath)).click();
		driver.findElement(By.xpath(UploadXpath)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//input[@id='iaq_assessment_upload_picker']"));
		js.executeScript("arguments[0].setAttribute('style', 'display:block !important;')", element);
		element.sendKeys(UploadPath);
		/*
		 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
		 * 
		 * waithelper.WaitForElementClickable(
		 * driver.findElement(By.xpath(DeleteXpath)),
		 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
		 */
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath(LinkXpath)).sendKeys(QLink);
		try {
			driver.findElement(By.xpath("(//div[@class='radio_buttons'])[" + QNo
					+ "]/following-sibling::div[2]/descendant::div[text()='Add link']")).click();

		} catch (Exception e) {
			log.info("Unable to click on Add Link");
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//button[text()='Submit']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		// driver.findElement(By.xpath("//button[text()='Submit']")).click();
		JSHelper.clickElement(driver.findElement(By.xpath("//button[text()='Submit']")));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h4[@class='fw-400 mb20']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.close();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("FMS_IAQAssessment_Yes_UploadFile_AddLink method ends here...");
	}

	public void FMS_HVACIncreasedOutdoorAirQuality_Yes_UploadFile_AddLink(int QNo, String QLink) {
		log.info("FMS_HVACIncreasedOutdoorAirQuality_Yes_UploadFile_AddLink method starts here...");
		String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";
		String YesXpath = "//div[@class='mb30 hvac_outdoor']/descendant::span[contains(text(),'Yes')]/input";
		String UploadXpath = "//div[@class='mb30 hvac_outdoor']/descendant::span[contains(text(),'Upload file')]";
		String DeleteXpath = "//div[@class='mb30 hvac_outdoor']/descendant::div[@class='icon_deleteDoc']";
		String LinkXpath = "//div[@class='mb30 hvac_outdoor']/descendant::input[starts-with(@class,'link_value')]";
		driver.findElement(By.xpath(YesXpath)).click();
		driver.findElement(By.xpath(UploadXpath)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//input[@id='hvac_system_upload_picker']"));
		js.executeScript("arguments[0].setAttribute('style', 'display:block !important;')", element);
		element.sendKeys(UploadPath);
		/*
		 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
		 * 
		 * waithelper.WaitForElementClickable(
		 * driver.findElement(By.xpath(DeleteXpath)),
		 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
		 */
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath(LinkXpath)).sendKeys(QLink);
		try {
			driver.findElement(By.xpath("(//div[@class='radio_buttons'])[" + QNo
					+ "]/following-sibling::div[2]/descendant::div[text()='Add link']")).click();

		} catch (Exception e) {
			log.info("Unable to click on Add Link");
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//button[text()='Submit']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h4[@class='fw-400 mb20']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.close();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("FMS_HVACIncreasedOutdoorAirQuality_Yes_UploadFile_AddLink method ends here...");
	}

	public void FMS_OccupantScreening_Yes_UploadFile_AddLink(int QNo, String QLink) {
		log.info("FMS_OccupantScreening_Yes_UploadFile_AddLink method starts here...");
		String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";
		String YesXpath = "//div[@class='mb30 occupant_screening']/descendant::span[contains(text(),'Yes')]/input";
		String UploadXpath = "//div[@class='mb30 occupant_screening']/descendant::span[contains(text(),'Upload file')]";
		String DeleteXpath = "//div[@class='mb30 occupant_screening']/descendant::div[@class='icon_deleteDoc']";
		String LinkXpath = "//div[@class='mb30 occupant_screening']/descendant::input[starts-with(@class,'link_value')]";
		driver.findElement(By.xpath(YesXpath)).click();
		driver.findElement(By.xpath(UploadXpath)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//input[@id='occupant_screening_upload_picker']"));
		js.executeScript("arguments[0].setAttribute('style', 'display:block !important;')", element);
		element.sendKeys(UploadPath);
		/*
		 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
		 * 
		 * waithelper.WaitForElementClickable(
		 * driver.findElement(By.xpath(DeleteXpath)),
		 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
		 */
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath(LinkXpath)).sendKeys(QLink);
		try {
			driver.findElement(By.xpath("(//div[@class='radio_buttons'])[" + QNo
					+ "]/following-sibling::div[2]/descendant::div[text()='Add link']")).click();

		} catch (Exception e) {
			log.info("Unable to click on Add Link");
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//button[text()='Submit']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h4[@class='fw-400 mb20']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.close();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("FMS_OccupantScreening_Yes_UploadFile_AddLink method ends here...");

	}

	public void FMS_SickLeaveStaffContractors_Yes_UploadFile_AddLink(int QNo, String QLink) {
		log.info("FMS_SickLeaveStaffContractors_Yes_UploadFile_AddLink method starts here...");
		String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";
		String YesXpath = "//div[@class='mb30 sick_leave']/descendant::span[contains(text(),'Yes')]/input";
		String UploadXpath = "//div[@class='mb30 sick_leave']/descendant::span[contains(text(),'Upload file')]";
		String DeleteXpath = "//div[@class='mb30 sick_leave']/descendant::div[@class='icon_deleteDoc']";
		String LinkXpath = "//div[@class='mb30 sick_leave']/descendant::input[starts-with(@class,'link_value')]";
		driver.findElement(By.xpath(YesXpath)).click();
		boolean FacilityVanueStaff = driver.findElement(By.xpath(
				"//div[@class='mb30 sick_leave']/descendant::div[@class='ml20 pl0 checkbox ng-scope']/label[text()='Facility or venue staff']"))
				.isDisplayed();
		boolean Contractors = driver.findElement(By.xpath(
				"//div[@class='mb30 sick_leave']/descendant::div[@class='ml20 pl0 checkbox ng-scope']/label[text()='Contractors']"))
				.isDisplayed();
		log.info("FacilityVanueStaff displays flag is  " + FacilityVanueStaff);
		log.info("Contractors displays flag is  " + Contractors);
		boolean FacilitySelected = false;
		boolean ContractorSelected = false;
		if ((FacilityVanueStaff) && (Contractors)) {
			driver.findElement(By.xpath(
					"(//div[@class='mb30 sick_leave']/descendant::div[@class='ml20 pl0 checkbox ng-scope']/input)[1]"))
					.click();
			driver.findElement(By.xpath(
					"(//div[@class='mb30 sick_leave']/descendant::div[@class='ml20 pl0 checkbox ng-scope']/input)[2]"))
					.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			FacilitySelected = driver.findElement(By.xpath(
					"(//div[@class='mb30 sick_leave']/descendant::div[@class='ml20 pl0 checkbox ng-scope']/input)[1]"))
					.isSelected();
			ContractorSelected = driver.findElement(By.xpath(
					"(//div[@class='mb30 sick_leave']/descendant::div[@class='ml20 pl0 checkbox ng-scope']/input)[2]"))
					.isSelected();
		}

		driver.findElement(By.xpath(UploadXpath)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//input[@id='sick_leave_upload_picker']"));
		js.executeScript("arguments[0].setAttribute('style', 'display:block !important;')", element);
		element.sendKeys(UploadPath);
		/*
		 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
		 * 
		 * waithelper.WaitForElementClickable(
		 * driver.findElement(By.xpath(DeleteXpath)),
		 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
		 */
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath(LinkXpath)).sendKeys(QLink);
		try {
			driver.findElement(By.xpath("(//div[@class='radio_buttons'])[" + QNo
					+ "]/following-sibling::div[2]/descendant::div[text()='Add link']")).click();

		} catch (Exception e) {
			log.info("Unable to click on Add Link");
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//button[text()='Submit']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h4[@class='fw-400 mb20']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.close();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("FMS_SickLeaveStaffContractors_Yes_UploadFile_AddLink method ends here...");

	}

	public void FMS_HealthInsuranceStaffContractors_Yes_UploadFile_AddLink(int QNo, String QLink) {
		log.info("FMS_HealthInsuranceStaffContractors_Yes_UploadFile_AddLink method starts here...");
		String UploadPath = System.getProperty("user.dir") + "/UploadDocument/File1.pdf";
		String YesXpath = "//div[@class='mb30 health_insurance']/descendant::span[contains(text(),'Yes')]/input";
		String UploadXpath = "//div[@class='mb30 health_insurance']/descendant::span[contains(text(),'Upload file')]";
		String DeleteXpath = "//div[@class='mb30 health_insurance']/descendant::div[@class='icon_deleteDoc']";
		String LinkXpath = "//div[@class='mb30 health_insurance']/descendant::input[starts-with(@class,'link_value')]";
		driver.findElement(By.xpath(YesXpath)).click();
		boolean FacilityVanueStaff = driver.findElement(By.xpath(
				"//div[@class='mb30 health_insurance']/descendant::div[@class='ml20 pl0 checkbox ng-scope']/label[text()='Facility or venue staff']"))
				.isDisplayed();
		boolean Contractors = driver.findElement(By.xpath(
				"//div[@class='mb30 health_insurance']/descendant::div[@class='ml20 pl0 checkbox ng-scope']/label[text()='Contractors']"))
				.isDisplayed();
		log.info("FacilityVanueStaff displays flag is  " + FacilityVanueStaff);
		log.info("Contractors displays flag is  " + Contractors);
		boolean FacilitySelected = false;
		boolean ContractorSelected = false;
		if ((FacilityVanueStaff) && (Contractors)) {
			driver.findElement(By.xpath(
					"(//div[@class='mb30 health_insurance']/descendant::div[@class='ml20 pl0 checkbox ng-scope']/input)[1]"))
					.click();
			driver.findElement(By.xpath(
					"(//div[@class='mb30 health_insurance']/descendant::div[@class='ml20 pl0 checkbox ng-scope']/input)[2]"))
					.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			FacilitySelected = driver.findElement(By.xpath(
					"(//div[@class='mb30 health_insurance']/descendant::div[@class='ml20 pl0 checkbox ng-scope']/input)[1]"))
					.isSelected();
			ContractorSelected = driver.findElement(By.xpath(
					"(//div[@class='mb30 health_insurance']/descendant::div[@class='ml20 pl0 checkbox ng-scope']/input)[2]"))
					.isSelected();
		}

		driver.findElement(By.xpath(UploadXpath)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//input[@id='health_insurance_upload_picker']"));
		js.executeScript("arguments[0].setAttribute('style', 'display:block !important;')", element);
		element.sendKeys(UploadPath);
		/*
		 * CommonMethod.setClipBoard(UploadPath); CommonMethod.UploadFile(UploadPath);
		 * 
		 * waithelper.WaitForElementClickable(
		 * driver.findElement(By.xpath(DeleteXpath)),
		 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
		 */
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath(LinkXpath)).sendKeys(QLink);
		try {
			driver.findElement(By.xpath("(//div[@class='radio_buttons'])[" + QNo
					+ "]/following-sibling::div[2]/descendant::div[text()='Add link']")).click();

		} catch (Exception e) {
			log.info("Unable to click on Add Link");
		}
		waithelper.WaitForElementClickable(driver.findElement(By.xpath("//button[text()='Submit']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h4[@class='fw-400 mb20']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.close();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("FMS_HealthInsuranceStaffContractors_Yes_UploadFile_AddLink method ends here...");
	}

	public boolean FMS_SelectYes_No_NA_Verify(int QNo, String Option) {
		log.info("FMS_SelectYes_UploadFile_AddLink_Verify method starts here with " + Option + "  . ..");
		if (Option.equals("Yes")) {
			driver.findElement(
					By.xpath("(//div[@class='survey-question radio-button'])[" + QNo + "]/div[2]/descendant::input[1]"))
					.click();

			waithelper.WaitForElementClickable(driver.findElement(By.xpath("//button[text()='Submit']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			driver.findElement(By.xpath("//button[text()='Submit']")).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h4[@class='fw-400 mb20']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			driver.close();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().window(BaseWindow);
			CommonMethod.RefreshPagewaitForPageLoaded(driver);
			ClickOnMetersAndSurveyMenu();
			ClickOnReEntry_FMS();

			boolean ResponseFlag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + QNo
					+ "]/td[2]/span[contains(@class,'mr5 saved_symbol saved_symbol')]")).isDisplayed();
			String ResponseText = driver
					.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + QNo + "]/td[2]")).getText();
			String DocumentText = driver
					.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + QNo + "]/td[3]/span")).getText();
			String LinkText = driver
					.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + QNo + "]/td[4]/span")).getText();
			log.info("Response Flag is  " + ResponseFlag);
			log.info("ResponseText is  " + ResponseText);
			log.info("DocumentText is  " + DocumentText);
			log.info("LinkText is  " + LinkText);
			log.info("FMS_SelectYes_UploadFile_AddLink_Verify method ends here with " + Option + "  . ..");
			if ((ResponseFlag) && (ResponseText.equals("Yes")) && (DocumentText.equals("NA"))
					&& (LinkText.equals("NA"))) {
				return true;
			} else {
				return false;
			}
		} else if (Option.equals("No")) {
			driver.findElement(
					By.xpath("(//div[@class='survey-question radio-button'])[" + QNo + "]/div[2]/descendant::input[2]"))
					.click();

			waithelper.WaitForElementClickable(driver.findElement(By.xpath("//button[text()='Submit']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			driver.findElement(By.xpath("//button[text()='Submit']")).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h4[@class='fw-400 mb20']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			driver.close();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().window(BaseWindow);
			CommonMethod.RefreshPagewaitForPageLoaded(driver);
			ClickOnMetersAndSurveyMenu();
			ClickOnReEntry_FMS();

			boolean ResponseFlag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + QNo
					+ "]/td[2]/span[contains(@class,'mr5 error_symbol error_symbol')]")).isDisplayed();
			String ResponseText = driver
					.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + QNo + "]/td[2]")).getText();

			String DocumentText = driver
					.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + QNo + "]/td[3]/span")).getText();
			String LinkText = driver
					.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + QNo + "]/td[4]/span")).getText();
			log.info("Response Flag is  " + ResponseFlag);
			log.info("ResponseText is  " + ResponseText);
			log.info("DocumentText is  " + DocumentText);
			log.info("LinkText is  " + LinkText);
			log.info("FMS_SelectYes_UploadFile_AddLink_Verify method ends here with " + Option + "  . ..");
			if ((ResponseFlag) && (ResponseText.contains("No")) && (DocumentText.equals("NA"))
					&& (LinkText.equals("NA"))) {
				return true;
			} else {
				return false;
			}
		}

		else if (Option.equals("NA")) {
			driver.findElement(
					By.xpath("(//div[@class='survey-question radio-button'])[" + QNo + "]/div[2]/descendant::input[3]"))
					.click();

			waithelper.WaitForElementClickable(driver.findElement(By.xpath("//button[text()='Submit']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			driver.findElement(By.xpath("//button[text()='Submit']")).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h4[@class='fw-400 mb20']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			driver.close();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().window(BaseWindow);
			CommonMethod.RefreshPagewaitForPageLoaded(driver);
			ClickOnMetersAndSurveyMenu();
			ClickOnReEntry_FMS();

			boolean ResponseFlag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + QNo
					+ "]/td[2]/span[contains(@class,'mr5 error_symbol error_symbol')]")).isDisplayed();
			String ResponseText = driver
					.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + QNo + "]/td[2]")).getText();

			String DocumentText = driver
					.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + QNo + "]/td[3]/span")).getText();
			String LinkText = driver
					.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + QNo + "]/td[4]/span")).getText();
			log.info("Response Flag is  " + ResponseFlag);
			log.info("ResponseText is  " + ResponseText);
			log.info("DocumentText is  " + DocumentText);
			log.info("LinkText is  " + LinkText);
			log.info("FMS_SelectYes_UploadFile_AddLink_Verify method ends here with " + Option + "  . ..");
			if ((ResponseFlag) && (ResponseText.contains("No")) && (DocumentText.equals("NA"))
					&& (LinkText.equals("NA"))) {
				return true;
			} else {
				return false;
			}
		}
		return false;

	}

	public boolean ReEntry_FMS_Question3_WithYesOption() {
		log.info("ReEntry_FMS_Question3_WithYesOption  method starts here.........");
		boolean OpenSurveyTab = false;
		boolean flag = false;
		String Question_Link = data.getCellData("Building", 56, 2);
		String url=FMS_CopySurveyLink();
		OpenSurveyTab = Transportation_OpenNewTabWithCopiedURL(url);
		if (OpenSurveyTab) {
			FMS_SelectYes_UploadFile_AddLink(3, Question_Link);// takes row number and URL to paste in
			flag = FMS_Verify(3, Question_Link); // that particular question
			if (flag) {
				log.info("ReEntry_FMS_Question3_WithYesOption method ends here with true.........");
				return true;
			} else {
				log.info("ReEntry_FMS_Question3_WithYesOption method ends here with false.........");
				return false;
			}
		} else {
			log.info("Unable to open new tab with copied URL...");
			return false;
		}
	}

	public boolean ReEntry_FMS_Question4_WithYes_NO_NA_Option() {
		log.info("ReEntry_FMS_Question4_WithYes_NO_NA_Option  method starts here.........");
		boolean OpenSurveyTab = false;
		boolean Yesflag = false;
		boolean Noflag = false;
		boolean NAflag = false;
		// String Question_Link = data.getCellData("Building", 56, 2);
		String url=FMS_CopySurveyLink();
		for (int i = 0; i < 3; i++) {
			OpenSurveyTab = Transportation_OpenNewTabWithCopiedURL(url);
			if (OpenSurveyTab) {
				Yesflag = FMS_SelectYes_No_NA_Verify(4, "Yes");// takes row number and URL to paste in that particular
																// question
				Transportation_OpenNewTabWithCopiedURL(url);
				Noflag = FMS_SelectYes_No_NA_Verify(4, "No");
				Transportation_OpenNewTabWithCopiedURL(url);
				NAflag = FMS_SelectYes_No_NA_Verify(4, "No");
				log.info("Value of Yes Flag is " + Yesflag);
				log.info("Value of No Flag is " + Noflag);
				log.info("Value of NA Flag is " + NAflag);
				if ((Yesflag) && (Noflag) && (NAflag)) {
					log.info("ReEntry_FMS_Question4_WithYes_NO_NA_Option method ends here with true.........");
					return true;
				} else {
					log.info("ReEntry_FMS_Question4_WithYes_NO_NA_Option method ends here with false.........");
					return false;
				}
			} else {
				log.info("Unable to open new tab with copied URL...");
				return false;
			}
		}
		return false;

	}

	// Building -> Re-Entry -->FMS -> Verify 'CDC guideline' redirects to the
	// following link- "https://stg.app.arconline.io/assets/pdf/CDC%20Guidance.pdf"
	public boolean ReEntry_FMS_Question5_CheckCDC_GuideLine() {
		log.info("ReEntry_FMS_Question5_CheckCDC_GuideLine  method starts here.........");
		boolean OpenSurveyTab = false;
		String pdfcontent = null;
		String url=FMS_CopySurveyLink();
		OpenSurveyTab = Transportation_OpenNewTabWithCopiedURL(url);
		if (OpenSurveyTab) {
			String SurveyWindow = driver.getWindowHandle();
			driver.findElement(
					By.xpath("(//div[@class='survey-question radio-button'])[5]/div[2]/descendant::input[1]")).click();
			driver.findElement(By.xpath("//a[text()='CDC guidance']")).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Set<String> handles = driver.getWindowHandles();
			for (String window : handles) {
				if (!BaseWindow.equals(window) && !SurveyWindow.equals(window)) {
					driver.switchTo().window(window);
					String cdcURl = "https://" + (System.getProperty("environment")).toLowerCase()
							+ ".app.arconline.io/assets/pdf/CDC%20Guidance.pdf";
					log.info("PDF URL is " + cdcURl);
					pdfcontent = CommonMethod.getPDFContent(cdcURl);
					driver.close();
					driver.switchTo().window(SurveyWindow);
					driver.close();
					driver.switchTo().window(BaseWindow);
				}
			}

			if (pdfcontent.contains("GUIDANCE FOR CLEANING AND DISINFECTING")) {
				log.info("ReEntry_FMS_Question5_CheckCDC_GuideLine method ends here with true.........");
				return true;
			} else {
				log.info("ReEntry_FMS_Question5_CheckCDC_GuideLine method ends here with false.........");
				return false;
			}
		} else {
			log.info("Unable to open new tab with copied URL...");
			return false;
		}
	}

	// Building -> Re-Entry -->FMS -> Verify USGBC credits link redirects to
	// "https://www.usgbc.org/credits/safety-first-136-v4.1?return=/credits/Existing%20Buildings/v4.1"
	public boolean ReEntry_FMS_Question5_USGBC_CreditLink() {
		log.info("ReEntry_FMS_Question5_USGBC_CreditLink  method starts here.........");
		boolean OpenSurveyTab = false;
		String PageTitle = null;
		String url=FMS_CopySurveyLink();
		OpenSurveyTab = Transportation_OpenNewTabWithCopiedURL(url);
		if (OpenSurveyTab) {
			String SurveyWindow = driver.getWindowHandle();
			driver.findElement(
					By.xpath("(//div[@class='survey-question radio-button'])[5]/div[2]/descendant::input[1]")).click();
			driver.findElement(By.xpath(
					"//a[@href='https://www.usgbc.org/credits/safety-first-136-v4.1?return=/credits/Existing%20Buildings/v4.1']"))
					.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Set<String> handles = driver.getWindowHandles();
			for (String window : handles) {
				if (!BaseWindow.equals(window) && !SurveyWindow.equals(window)) {
					driver.switchTo().window(window);
					PageTitle = driver.getTitle();
					driver.close();
					driver.switchTo().window(SurveyWindow);
					driver.close();
					driver.switchTo().window(BaseWindow);
				}
			}

			if (PageTitle.equals("Safety First: Re-Enter Your Workspace | U.S. Green Building Council")) {
				log.info("ReEntry_FMS_Question5_USGBC_CreditLink method ends here with true.........");
				return true;
			} else {
				log.info("ReEntry_FMS_Question5_USGBC_CreditLink method ends here with false.........");
				return false;
			}
		} else {
			log.info("Unable to open new tab with copied URL...");
			return false;
		}
	}

	public boolean ReEntry_FMS_Question5_WithYesOption() {
		log.info("ReEntry_FMS_Question5_WithYesOption  method starts here.........");
		boolean OpenSurveyTab = false;
		boolean flag = false;
		String Question_Link = data.getCellData("Building", 57, 2);
		String url=FMS_CopySurveyLink();
		OpenSurveyTab = Transportation_OpenNewTabWithCopiedURL(url);
		if (OpenSurveyTab) {
			FMS_SelectYes_UploadFile_AddLink(5, Question_Link);// takes row number and URL to paste in
			flag = FMS_Verify(5, Question_Link); // that particular question
			if (flag) {
				log.info("ReEntry_FMS_Question5_WithYesOption method ends here with true.........");
				return true;
			} else {
				log.info("ReEntry_FMS_Question5_WithYesOption method ends here with false.........");
				return false;
			}
		} else {
			log.info("Unable to open new tab with copied URL...");
			return false;
		}
	}

	public boolean ReEntry_FMS_Question6_WithYesOption() {
		log.info("ReEntry_FMS_Question6_WithYesOption  method starts here.........");
		boolean OpenSurveyTab = false;
		boolean flag = false;
		String Question_Link = data.getCellData("Building", 58, 2);
		String url=FMS_CopySurveyLink();
		OpenSurveyTab = Transportation_OpenNewTabWithCopiedURL(url);
		if (OpenSurveyTab) {
			FMS_DiseaseControlCommmunication_Yes_UploadFile_AddLink(6, Question_Link);// takes row number and URL to
																						// paste in
			flag = FMS_Verify(6, Question_Link); // that particular question
			if (flag) {
				log.info("ReEntry_FMS_Question6_WithYesOption method ends here with true.........");
				return true;
			} else {
				log.info("ReEntry_FMS_Question6_WithYesOption method ends here with false.........");
				return false;
			}
		} else {
			log.info("Unable to open new tab with copied URL...");
			return false;
		}
	}

	public boolean ReEntry_FMS_Question7_WithYesOption() {
		log.info("ReEntry_FMS_Question7_WithYesOption  method starts here.........");
		boolean OpenSurveyTab = false;
		boolean flag = false;
		String Question_Link = data.getCellData("Building", 59, 2);
		String url=FMS_CopySurveyLink();
		OpenSurveyTab = Transportation_OpenNewTabWithCopiedURL(url);
		if (OpenSurveyTab) {
			FMS_HandWashingAndDisinfection_Yes_UploadFile_AddLink(7, Question_Link);// takes row number and URL to paste
																					// in
			flag = FMS_Verify(7, Question_Link); // that particular question
			if (flag) {
				log.info("ReEntry_FMS_Question7_WithYesOption method ends here with true.........");
				return true;
			} else {
				log.info("ReEntry_FMS_Question7_WithYesOption method ends here with false.........");
				return false;
			}
		} else {
			log.info("Unable to open new tab with copied URL...");
			return false;
		}
	}

	public boolean ReEntry_FMS_Question10_WithYesOption() {
		log.info("ReEntry_FMS_Question10_WithYesOption  method starts here.........");
		boolean OpenSurveyTab = false;
		boolean flag = false;
		String Question_Link = data.getCellData("Building", 62, 2);
		String url=FMS_CopySurveyLink();
		OpenSurveyTab = Transportation_OpenNewTabWithCopiedURL(url);
		if (OpenSurveyTab) {
			FMS_SickLeaveStaffContractors_Yes_UploadFile_AddLink(10, Question_Link);// takes row number and URL to paste
																					// in
			flag = FMS_Verify(10, Question_Link); // that particular question
			if (flag) {
				log.info("ReEntry_FMS_Question10_WithYesOption method ends here with true.........");
				return true;
			} else {
				log.info("ReEntry_FMS_Question10_WithYesOption method ends here with false.........");
				return false;
			}
		} else {
			log.info("Unable to open new tab with copied URL...");
			return false;
		}
	}

	public boolean ReEntry_FMS_Question11_WithYesOption() {
		log.info("ReEntry_FMS_Question11_WithYesOption  method starts here.........");
		boolean OpenSurveyTab = false;
		boolean flag = false;
		String Question_Link = data.getCellData("Building", 63, 2);
		String url=FMS_CopySurveyLink();
		OpenSurveyTab = Transportation_OpenNewTabWithCopiedURL(url);
		if (OpenSurveyTab) {
			FMS_HealthInsuranceStaffContractors_Yes_UploadFile_AddLink(11, Question_Link);// takes row number and URL to
																							// paste in
			flag = FMS_Verify(11, Question_Link); // that particular question
			if (flag) {
				log.info("ReEntry_FMS_Question11_WithYesOption method ends here with true.........");
				return true;
			} else {
				log.info("ReEntry_FMS_Question11_WithYesOption method ends here with false.........");
				return false;
			}
		} else {
			log.info("Unable to open new tab with copied URL...");
			return false;
		}
	}

	public boolean ReEntry_FMS_Question9_WithYesOption() {
		log.info("ReEntry_FMS_Question9_WithYesOption  method starts here.........");
		boolean OpenSurveyTab = false;
		boolean flag = false;
		String Question_Link = data.getCellData("Building", 61, 2);
		String url=FMS_CopySurveyLink();
		OpenSurveyTab = Transportation_OpenNewTabWithCopiedURL(url);
		if (OpenSurveyTab) {
			FMS_OccupantScreening_Yes_UploadFile_AddLink(9, Question_Link);// takes row number and URL to paste in
			flag = FMS_Verify(9, Question_Link); // that particular question
			if (flag) {
				log.info("ReEntry_FMS_Question9_WithYesOption method ends here with true.........");
				return true;
			} else {
				log.info("ReEntry_FMS_Question9_WithYesOption method ends here with false.........");
				return false;
			}
		} else {
			log.info("Unable to open new tab with copied URL...");
			return false;
		}
	}

	public boolean ReEntry_FMS_Question8_WithYesOption() {
		log.info("ReEntry_FMS_Question8_WithYesOption  method starts here.........");
		boolean OpenSurveyTab = false;
		boolean flag = false;
		String Question_Link = data.getCellData("Building", 60, 2);
		String url=FMS_CopySurveyLink();
		OpenSurveyTab = Transportation_OpenNewTabWithCopiedURL(url);
		if (OpenSurveyTab) {
			FMS_ProvidingPPE_And_ProperUse_Yes_UploadFile_AddLink(8, Question_Link);// takes row number and URL to paste
																					// in
			flag = FMS_Verify(8, Question_Link); // that particular question
			if (flag) {
				log.info("ReEntry_FMS_Question8_WithYesOption method ends here with true.........");
				return true;
			} else {
				log.info("ReEntry_FMS_Question8_WithYesOption method ends here with false.........");
				return false;
			}
		} else {
			log.info("Unable to open new tab with copied URL...");
			return false;
		}
	}

	public boolean ReEntry_FMS_Question12_WithYesOption() {
		log.info("ReEntry_FMS_Question12_WithYesOption  method starts here.........");
		boolean OpenSurveyTab = false;
		boolean flag = false;
		String Question_Link = data.getCellData("Building", 64, 2);
		String url=FMS_CopySurveyLink();
		OpenSurveyTab = Transportation_OpenNewTabWithCopiedURL(url);
		if (OpenSurveyTab) {
			FMS_SocialDistancing_Yes_UploadFile_AddLink_Verify(12, Question_Link);// takes row number and URL to paste
																					// in
			flag = FMS_Verify(12, Question_Link); // that particular question
			if (flag) {
				log.info("ReEntry_FMS_Question12_WithYesOption method ends here with true.........");
				return true;
			} else {
				log.info("ReEntry_FMS_Question12_WithYesOption method ends here with false.........");
				return false;
			}
		} else {
			log.info("Unable to open new tab with copied URL...");
			return false;
		}
	}

	public boolean ReEntry_FMS_Question13_WithYesOption() {
		log.info("ReEntry_FMS_Question13_WithYesOption  method starts here.........");
		boolean OpenSurveyTab = false;
		boolean flag = false;
		String Question_Link = data.getCellData("Building", 65, 2);
		String url=FMS_CopySurveyLink();
		OpenSurveyTab = Transportation_OpenNewTabWithCopiedURL(url);
		if (OpenSurveyTab) {
			FMS_HVACSystemOperation_Yes_UploadFile_AddLink(13, Question_Link);// takes row number and URL to paste in
			flag = FMS_Verify(13, Question_Link); // that particular question
			if (flag) {
				log.info("ReEntry_FMS_Question13_WithYesOption method ends here with true.........");
				return true;
			} else {
				log.info("ReEntry_FMS_Question13_WithYesOption method ends here with false.........");
				return false;
			}
		} else {
			log.info("Unable to open new tab with copied URL...");
			return false;
		}
	}

	public boolean ReEntry_FMS_Question14_WithYesOption() {
		log.info("ReEntry_FMS_Question14_WithYesOption  method starts here.........");
		boolean OpenSurveyTab = false;
		boolean flag = false;
		String Question_Link = data.getCellData("Building", 66, 2);
		String url=FMS_CopySurveyLink();
		OpenSurveyTab = Transportation_OpenNewTabWithCopiedURL(url);
		if (OpenSurveyTab) {
			FMS_HVACIncreasedOutdoorAirQuality_Yes_UploadFile_AddLink(14, Question_Link);// takes row number and URL to
																							// paste in
			flag = FMS_Verify(14, Question_Link); // that particular question
			if (flag) {
				log.info("ReEntry_FMS_Question14_WithYesOption method ends here with true.........");
				return true;
			} else {
				log.info("ReEntry_FMS_Question14_WithYesOption method ends here with false.........");
				return false;
			}
		} else {
			log.info("Unable to open new tab with copied URL...");
			return false;
		}
	}

	public boolean ReEntry_FMS_Question15_WithYesOption() {
		log.info("ReEntry_FMS_Question15_WithYesOption  method starts here.........");
		boolean OpenSurveyTab = false;
		boolean flag = false;
		String Question_Link = data.getCellData("Building", 67, 2);
		String url=FMS_CopySurveyLink();
		OpenSurveyTab = Transportation_OpenNewTabWithCopiedURL(url);
		if (OpenSurveyTab) {
			FMS_HVACIncreasedVentilationRates_Yes_UploadFile_AddLink(15, Question_Link);// takes row number and URL to
																						// paste in
			flag = FMS_Verify(15, Question_Link); // that particular question
			if (flag) {
				log.info("ReEntry_FMS_Question15_WithYesOption method ends here with true.........");
				return true;
			} else {
				log.info("ReEntry_FMS_Question15_WithYesOption method ends here with false.........");
				return false;
			}
		} else {
			log.info("Unable to open new tab with copied URL...");
			return false;
		}
	}

	public boolean ReEntry_FMS_Question16_WithYesOption() {
		log.info("ReEntry_FMS_Question16_WithYesOption  method starts here.........");
		boolean OpenSurveyTab = false;
		boolean flag = false;
		String Question_Link = data.getCellData("Building", 68, 2);
		String url=FMS_CopySurveyLink();
		OpenSurveyTab = Transportation_OpenNewTabWithCopiedURL(url);
		if (OpenSurveyTab) {
			FMS_HVACEnhanceFiltration_Yes_UploadFile_AddLink(16, Question_Link);// takes row number and URL to paste in
			flag = FMS_Verify(16, Question_Link); // that particular question
			if (flag) {
				log.info("ReEntry_FMS_Question16_WithYesOption method ends here with true.........");
				return true;
			} else {
				log.info("ReEntry_FMS_Question16_WithYesOption method ends here with false.........");
				return false;
			}
		} else {
			log.info("Unable to open new tab with copied URL...");
			return false;
		}
	}

	public boolean ReEntry_FMS_Question17_WithYesOption() {
		log.info("ReEntry_FMS_Question17_WithYesOption  method starts here.........");
		boolean OpenSurveyTab = false;
		boolean flag = false;
		String Question_Link = data.getCellData("Building", 69, 2);
		String url=FMS_CopySurveyLink();
		OpenSurveyTab = Transportation_OpenNewTabWithCopiedURL(url);
		if (OpenSurveyTab) {
			FMS_Elevatormanagement_Yes_UploadFile_AddLink(17, Question_Link);// takes row number and URL to paste in
			flag = FMS_Verify(17, Question_Link); // that particular question
			if (flag) {
				log.info("ReEntry_FMS_Question17_WithYesOption method ends here with true.........");
				return true;
			} else {
				log.info("ReEntry_FMS_Question17_WithYesOption method ends here with false.........");
				return false;
			}
		} else {
			log.info("Unable to open new tab with copied URL...");
			return false;
		}
	}

	public boolean ReEntry_FMS_Question18_WithYesOption() {
		log.info("ReEntry_FMS_Question18_WithYesOption  method starts here.........");
		boolean OpenSurveyTab = false;
		boolean flag = false;
		String Question_Link = data.getCellData("Building", 70, 2);
		String url=FMS_CopySurveyLink();
		OpenSurveyTab = Transportation_OpenNewTabWithCopiedURL(url);
		if (OpenSurveyTab) {
			FMS_PortableWaterManagement_Yes_UploadFile_AddLink(18, Question_Link);// takes row number and URL to paste
																					// in
			flag = FMS_Verify(18, Question_Link); // that particular question
			if (flag) {
				log.info("ReEntry_FMS_Question18_WithYesOption method ends here with true.........");
				return true;
			} else {
				log.info("ReEntry_FMS_Question18_WithYesOption method ends here with false.........");
				return false;
			}
		} else {
			log.info("Unable to open new tab with copied URL...");
			return false;
		}
	}

	public boolean ReEntry_FMS_Question19_WithYesOption() {
		log.info("ReEntry_FMS_Question19_WithYesOption  method starts here.........");
		boolean OpenSurveyTab = false;
		boolean flag = false;
		String Question_Link = data.getCellData("Building", 71, 2);
		String url=FMS_CopySurveyLink();
		OpenSurveyTab = Transportation_OpenNewTabWithCopiedURL(url);
		if (OpenSurveyTab) {
			FMS_IAQAssessment_Yes_UploadFile_AddLink(19, Question_Link);// takes row number and URL to paste in
			flag = FMS_Verify(19, Question_Link); // that particular question
			if (flag) {
				log.info("ReEntry_FMS_Question19_WithYesOption method ends here with true.........");
				return true;
			} else {
				log.info("ReEntry_FMS_Question19_WithYesOption method ends here with false.........");
				return false;
			}
		} else {
			log.info("Unable to open new tab with copied URL...");
			return false;
		}
	}

	public boolean ReEntry_FMS_DownloadArcGuideToReEntry() {
		log.info("ReEntry_FMS_DownloadArcGuideToReEntry  method starts here.........");
		boolean flag = false;

		waithelper.WaitForElementClickable(
				driver.findElement(By.xpath("(//button[contains(text(),'Survey Tools and Resources')])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("(//button[contains(text(),'Survey Tools and Resources')])[2]")).click();

		driver.findElement(By.xpath("//a[text()='Arc Re-Entry Guide']")).click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//flag = CommonMethod.CheckDownloadedFileName("Re-Entry.pdf");
		Set<String> handles = driver.getWindowHandles();
		log.info("Total Number of Window Handles is "+handles.size());
		for (String window : handles) {
			log.info("Current window ID is "+window);
			if (!window.equals(BaseWindow)) {
				driver.switchTo().window(window);
				log.info("Switched to new window....");
				break;
			}
		}
		if (flag) {
			log.info("ReEntry_FMS_DownloadArcGuideToReEntry method ends here with true.........");
			return true;
		} else {
			log.info("ReEntry_FMS_DownloadArcGuideToReEntry method ends here with false.........");
			return false;
		}

	}

	public boolean ReEntry_OccupantSurvey_OpenSurvey_NewTab(String Scope, String Group) {
		log.info("ReEntry_OccupantSurvey_OpenSurvey_NewTab  method starts here.........");
		boolean flag = false;

		waithelper.WaitForElementClickable(
				driver.findElement(By.xpath("(//button[contains(text(),'Survey Tools and Resources')])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("(//button[contains(text(),'Survey Tools and Resources')])[2]")).click();

		driver.findElement(By.xpath("//a[text()='Send Survey']")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonMethod.switchToDefaultContent();
		WebElement DropScope = driver.findElement(By.xpath("//select[@name='scope']"));
		dropdownhelper.selectUsingVisibleText(DropScope, Scope);
		WebElement DropGroup = driver.findElement(By.xpath("//select[@name='group']"));
		dropdownhelper.selectUsingVisibleText(DropGroup, Group);
		String name=Scope.split(" ")[0]+Group;
		
		driver.findElement(ByAngular.model("tenant")).sendKeys(name);
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = driver.findElement(ByAngular.model("oe_link")).getAttribute("value");
		//CommonMethod.setClipBoard(url);
		log.info("Url Copied is "+url);
		JSHelper.clickElement(driver.findElement(By.xpath("//a[text()='Copy Link']")));
		flag = driver.findElement(By.xpath("//div[@class='ml10 copy_notif']")).isDisplayed();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		log.info("Copied flag is " + flag);
		driver.findElement(By.xpath("//div[@class='pt16']/button[text()='Close']")).click();
		flag = OcupantSurvey_OpenNewTabWithCopiedURL(url);
		//CommonMethod.clearClipBoard();
		if (flag) {
			log.info("ReEntry_OccupantSurvey_OpenSurvey_NewTab method ends here with true.........");
			return true;
		} else {
			log.info("ReEntry_OccupantSurvey_OpenSurvey_NewTab method ends here with false.........");
			return false;
		}

	}

	public boolean ReEntry_OccupantSurvey_DownloadArcGuideToReEntry() {
		log.info("ReEntry_FMS_DownloadArcGuideToReEntry  method starts here.........");
		boolean flag = false;

		waithelper.WaitForElementClickable(
				driver.findElement(By.xpath("(//button[contains(text(),'Survey Tools and Resources')])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("(//button[contains(text(),'Survey Tools and Resources')])[2]")).click();

		driver.findElement(By.xpath("//a[text()='Arc Re-Entry Guide']")).click();
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flag = CommonMethod.CheckDownloadedFileName("Re-Entry.pdf");
		if (flag) {
			log.info("ReEntry_FMS_DownloadArcGuideToReEntry method ends here with true.........");
			return true;
		} else {
			log.info("ReEntry_FMS_DownloadArcGuideToReEntry method ends here with false.........");
			return false;
		}

	}

	public boolean OccupantSurvey_SubmitSurveyWithCommonSpace_Management() {
		log.info("OccupantSurvey_SubmitSurveyWithCommonSpace_Management  method starts here.........");
		boolean SubmitResponseFlag = false;
		boolean SliderFlag = false;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CommonMethod.SelectEnvironmentSlider(ReEntry_Environment_Slider, "Extremely Unsatisfied");
		SliderFlag = OccupantSurvey_SelectAll_SurveyOptions("Extremely Unsatisfied");
		BuildingSurvey_CommentOptional.sendKeys(data.getCellData("Building", 36, 2));
		BuildingSurvey_Location.sendKeys(data.getCellData("Building", 37, 2));
		BuildingSurvey_NameOptional.sendKeys(data.getCellData("Building", 38, 2));
		String Occupant = data.getCellData("Building", 39, 2);
		driver.findElement(By.xpath("//select[@id='occupant_category']")).click();
		driver.findElement(By.xpath("//select[@id='occupant_category']/option[text()='" + Occupant + "']")).click();
		driver.findElement(By.xpath("//span[text()='Yes ']/input[@name='infection_control']")).click();
		driver.findElement(ByAngular.model("question.reason.data")).sendKeys(data.getCellData("Building", 72, 2));
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement DiseaseControlHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][1]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_DiseaseControl_Slider, DiseaseControlHeader, "Never");
		// driver.findElement(ByAngular.model("question.reason.data")).sendKeys(data.getCellData("Building",
		// 72, 2));
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[1]"))
				.sendKeys(data.getCellData("Building", 73, 2));

		WebElement OccupantScreeningHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][2]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_OccupantScreening_Slider, OccupantScreeningHeader, "Never");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[2]"))
				.sendKeys(data.getCellData("Building", 74, 2));

		WebElement HandWashingHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][3]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_HandWashing_Slider, HandWashingHeader, "Never");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[3]"))
				.sendKeys(data.getCellData("Building", 75, 2));

		WebElement SupportSocialDistancingHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][4]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_SupportSocialDistancing_Slider, SupportSocialDistancingHeader,
				"Never");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[4]"))
				.sendKeys(data.getCellData("Building", 76, 2));

		WebElement MaintainSocialDistancingHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][5]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_ManintainSocialDistancing_Slider,
				MaintainSocialDistancingHeader, "Never");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[5]"))
				.sendKeys(data.getCellData("Building", 77, 2));

		WebElement ProtectedDiseaseTransmissionHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][6]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_ProtectedDiseaseTransmission_Slider,
				ProtectedDiseaseTransmissionHeader, "Never");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[6]"))
				.sendKeys(data.getCellData("Building", 78, 2));

		WebElement StaffUsePPEHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][7]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_StaffUsePPE_Slider, StaffUsePPEHeader, "Never");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[7]"))
				.sendKeys(data.getCellData("Building", 79, 2));

		Transportation_SubmitBtn.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (driver.findElement(By.xpath("//h4[text()='Thank you for taking our survey!']")).isDisplayed()) {
			log.info("Response message displayed.. ");
			SubmitResponseFlag = true;
			driver.close();
			driver.switchTo().window(BaseWindow);
		} else {
			log.info("Response message not displayed.. ");
			SubmitResponseFlag = false;
			driver.close();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().window(BaseWindow);
			// break;
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (SubmitResponseFlag) {
			log.info("OccupantSurvey_SubmitSurveyWithCommonSpace_Management method ends here with true.........");
			return true;
		} else {
			log.info("OccupantSurvey_SubmitSurveyWithCommonSpace_Management method ends here with false.........");
			return false;
		}
	}

	public boolean OccupantSurvey_SubmitSurveyWithCommonSpace_Tenant() {
		log.info("OccupantSurvey_SubmitSurveyWithCommonSpace_Tenant  method starts here.........");
		boolean SubmitResponseFlag = false;
		boolean SliderFlag = false;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CommonMethod.SelectEnvironmentSlider(ReEntry_Environment_Slider, "Very Unsatisfied");
		SliderFlag = OccupantSurvey_SelectAll_SurveyOptions("Very Unsatisfied");
		BuildingSurvey_CommentOptional.sendKeys(data.getCellData("Building", 36, 2));
		BuildingSurvey_Location.sendKeys(data.getCellData("Building", 37, 2));
		BuildingSurvey_NameOptional.sendKeys(data.getCellData("Building", 38, 2));
		String Occupant = data.getCellData("Building", 39, 2);
		driver.findElement(By.xpath("//select[@id='occupant_category']")).click();
		driver.findElement(By.xpath("//select[@id='occupant_category']/option[text()='" + Occupant + "']")).click();
		driver.findElement(By.xpath("//span[text()='Yes ']/input[@name='infection_control']")).click();
		driver.findElement(ByAngular.model("question.reason.data")).sendKeys(data.getCellData("Building", 72, 2));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement DiseaseControlHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][1]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_DiseaseControl_Slider, DiseaseControlHeader, "Rarely");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[1]"))
				.sendKeys(data.getCellData("Building", 73, 2));

		WebElement OccupantScreeningHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][2]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_OccupantScreening_Slider, OccupantScreeningHeader, "Rarely");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[2]"))
				.sendKeys(data.getCellData("Building", 74, 2));

		WebElement HandWashingHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][3]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_HandWashing_Slider, HandWashingHeader, "Rarely");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[3]"))
				.sendKeys(data.getCellData("Building", 75, 2));

		WebElement SupportSocialDistancingHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][4]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_SupportSocialDistancing_Slider, SupportSocialDistancingHeader,
				"Rarely");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[4]"))
				.sendKeys(data.getCellData("Building", 76, 2));

		WebElement MaintainSocialDistancingHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][5]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_ManintainSocialDistancing_Slider,
				MaintainSocialDistancingHeader, "Rarely");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[5]"))
				.sendKeys(data.getCellData("Building", 77, 2));

		WebElement ProtectedDiseaseTransmissionHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][6]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_ProtectedDiseaseTransmission_Slider,
				ProtectedDiseaseTransmissionHeader, "Rarely");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[6]"))
				.sendKeys(data.getCellData("Building", 78, 2));

		WebElement StaffUsePPEHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][7]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_StaffUsePPE_Slider, StaffUsePPEHeader, "Rarely");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[7]"))
				.sendKeys(data.getCellData("Building", 79, 2));

		Transportation_SubmitBtn.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (driver.findElement(By.xpath("//h4[text()='Thank you for taking our survey!']")).isDisplayed()) {
			log.info("Response message displayed.. ");
			SubmitResponseFlag = true;
			driver.close();
			driver.switchTo().window(BaseWindow);
		} else {
			log.info("Response message not displayed.. ");
			SubmitResponseFlag = false;
			driver.close();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().window(BaseWindow);
			// break;
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (SubmitResponseFlag) {
			log.info("OccupantSurvey_SubmitSurveyWithCommonSpace_Tenant method ends here with true.........");
			return true;
		} else {
			log.info("OccupantSurvey_SubmitSurveyWithCommonSpace_Tenant method ends here with false.........");
			return false;
		}
	}

	public boolean OccupantSurvey_SubmitSurveyWithTenantSpace_Management() {
		log.info("OccupantSurvey_SubmitSurveyWithTenantSpace_Management  method starts here.........");
		boolean SubmitResponseFlag = false;
		boolean SliderFlag = false;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CommonMethod.SelectEnvironmentSlider(ReEntry_Environment_Slider, "Neither satisfied nor unsatisfied");
		SliderFlag = OccupantSurvey_SelectAll_SurveyOptions("Neither satisfied nor unsatisfied");
		BuildingSurvey_CommentOptional.sendKeys(data.getCellData("Building", 36, 2));
		BuildingSurvey_Location.sendKeys(data.getCellData("Building", 37, 2));
		BuildingSurvey_NameOptional.sendKeys(data.getCellData("Building", 38, 2));
		String Occupant = data.getCellData("Building", 39, 2);
		driver.findElement(By.xpath("//select[@id='occupant_category']")).click();
		driver.findElement(By.xpath("//select[@id='occupant_category']/option[text()='" + Occupant + "']")).click();
		driver.findElement(By.xpath("//span[text()='No ']/input[@name='infection_control']")).click();
		// driver.findElement(ByAngular.model("question.reason.data")).sendKeys(data.getCellData("Building",
		// 72, 2));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement DiseaseControlHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][1]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_DiseaseControl_Slider, DiseaseControlHeader, "Usually");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[1]"))
				.sendKeys(data.getCellData("Building", 73, 2));

		WebElement OccupantScreeningHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][2]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_OccupantScreening_Slider, OccupantScreeningHeader, "Usually");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[2]"))
				.sendKeys(data.getCellData("Building", 74, 2));

		WebElement HandWashingHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][3]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_HandWashing_Slider, HandWashingHeader, "Usually");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[3]"))
				.sendKeys(data.getCellData("Building", 75, 2));

		WebElement SupportSocialDistancingHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][4]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_SupportSocialDistancing_Slider, SupportSocialDistancingHeader,
				"Usually");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[4]"))
				.sendKeys(data.getCellData("Building", 76, 2));

		WebElement MaintainSocialDistancingHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][5]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_ManintainSocialDistancing_Slider,
				MaintainSocialDistancingHeader, "Usually");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[5]"))
				.sendKeys(data.getCellData("Building", 77, 2));

		WebElement ProtectedDiseaseTransmissionHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][6]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_ProtectedDiseaseTransmission_Slider,
				ProtectedDiseaseTransmissionHeader, "Usually");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[6]"))
				.sendKeys(data.getCellData("Building", 78, 2));

		WebElement StaffUsePPEHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][7]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_StaffUsePPE_Slider, StaffUsePPEHeader, "Usually");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[7]"))
				.sendKeys(data.getCellData("Building", 79, 2));

		Transportation_SubmitBtn.click();
		CommonMethod.waitUntilLoadElement();
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (driver.findElement(By.xpath("//h4[text()='Thank you for taking our survey!']")).isDisplayed()) {
			log.info("Response message displayed.. ");
			SubmitResponseFlag = true;
			driver.close();
			driver.switchTo().window(BaseWindow);
		} else {
			log.info("Response message not displayed.. ");
			SubmitResponseFlag = false;
			driver.close();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().window(BaseWindow);
			// break;
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (SubmitResponseFlag) {
			log.info("OccupantSurvey_SubmitSurveyWithTenantSpace_Management method ends here with true.........");
			return true;
		} else {
			log.info("OccupantSurvey_SubmitSurveyWithTenantSpace_Management method ends here with false.........");
			return false;
		}
	}

	public boolean OccupantSurvey_SubmitSurveyWithTenantSpace_Tenant() {
		log.info("OccupantSurvey_SubmitSurveyWithTenantSpace_Tenant  method starts here.........");
		boolean SubmitResponseFlag = false;
		boolean SliderFlag = false;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CommonMethod.SelectEnvironmentSlider(ReEntry_Environment_Slider, "Satisfied");
		SliderFlag = OccupantSurvey_SelectAll_SurveyOptions("Satisfied");
		BuildingSurvey_CommentOptional.sendKeys(data.getCellData("Building", 36, 2));
		BuildingSurvey_Location.sendKeys(data.getCellData("Building", 37, 2));
		BuildingSurvey_NameOptional.sendKeys(data.getCellData("Building", 38, 2));
		String Occupant = data.getCellData("Building", 39, 2);
		driver.findElement(By.xpath("//select[@id='occupant_category']")).click();
		driver.findElement(By.xpath("//select[@id='occupant_category']/option[text()='" + Occupant + "']")).click();
		driver.findElement(By.xpath("//span[text()='No ']/input[@name='infection_control']")).click();
		// driver.findElement(ByAngular.model("question.reason.data")).sendKeys(data.getCellData("Building",
		// 72, 2));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement DiseaseControlHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][1]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_DiseaseControl_Slider, DiseaseControlHeader, "Always");
		// driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[1]")).sendKeys(data.getCellData("Building",
		// 73, 2));

		WebElement OccupantScreeningHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][2]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_OccupantScreening_Slider, OccupantScreeningHeader, "Always");
		// driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[2]")).sendKeys(data.getCellData("Building",
		// 74, 2));

		WebElement HandWashingHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][3]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_HandWashing_Slider, HandWashingHeader, "Always");
		// driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[3]")).sendKeys(data.getCellData("Building",
		// 75, 2));

		WebElement SupportSocialDistancingHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][4]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_SupportSocialDistancing_Slider, SupportSocialDistancingHeader,
				"Always");
		// driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[4]")).sendKeys(data.getCellData("Building",
		// 76, 2));

		WebElement MaintainSocialDistancingHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][5]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_ManintainSocialDistancing_Slider,
				MaintainSocialDistancingHeader, "Always");
		// driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[5]")).sendKeys(data.getCellData("Building",
		// 77, 2));

		WebElement ProtectedDiseaseTransmissionHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][6]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_ProtectedDiseaseTransmission_Slider,
				ProtectedDiseaseTransmissionHeader, "Always");
		// driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[6]")).sendKeys(data.getCellData("Building",
		// 78, 2));

		WebElement StaffUsePPEHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][7]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_StaffUsePPE_Slider, StaffUsePPEHeader, "Always");
		// driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[7]")).sendKeys(data.getCellData("Building",
		// 79, 2));

		Transportation_SubmitBtn.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (driver.findElement(By.xpath("//h4[text()='Thank you for taking our survey!']")).isDisplayed()) {
			log.info("Response message displayed.. ");
			SubmitResponseFlag = true;
			driver.close();
			driver.switchTo().window(BaseWindow);
		} else {
			log.info("Response message not displayed.. ");
			SubmitResponseFlag = false;
			driver.close();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().window(BaseWindow);
			// break;
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (SubmitResponseFlag) {
			log.info("OccupantSurvey_SubmitSurveyWithTenantSpace_Tenant method ends here with true.........");
			return true;
		} else {
			log.info("OccupantSurvey_SubmitSurveyWithTenantSpace_Tenant method ends here with false.........");
			return false;
		}
	}

	public boolean OccupantSurvey_SubmitSurveyWithTenantSpace_Visitor() {
		log.info("OccupantSurvey_SubmitSurveyWithTenantSpace_Visitor  method starts here.........");
		boolean SubmitResponseFlag = false;
		boolean SliderFlag = false;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CommonMethod.SelectEnvironmentSlider(ReEntry_Environment_Slider, "Very Satisfied");
		SliderFlag = OccupantSurvey_SelectAll_SurveyOptions("Very Satisfied");
		BuildingSurvey_CommentOptional.sendKeys(data.getCellData("Building", 36, 2));
		BuildingSurvey_Location.sendKeys(data.getCellData("Building", 37, 2));
		BuildingSurvey_NameOptional.sendKeys(data.getCellData("Building", 38, 2));
		String Occupant = data.getCellData("Building", 39, 2);
		driver.findElement(By.xpath("//select[@id='occupant_category']")).click();
		driver.findElement(By.xpath("//select[@id='occupant_category']/option[text()='" + Occupant + "']")).click();
		driver.findElement(By.xpath("//span[text()='No ']/input[@name='infection_control']")).click();
		// driver.findElement(ByAngular.model("question.reason.data")).sendKeys(data.getCellData("Building",
		// 72, 2));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement DiseaseControlHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][1]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_DiseaseControl_Slider, DiseaseControlHeader, "Rarely");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[1]"))
				.sendKeys(data.getCellData("Building", 73, 2));

		WebElement OccupantScreeningHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][2]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_OccupantScreening_Slider, OccupantScreeningHeader, "Rarely");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[2]"))
				.sendKeys(data.getCellData("Building", 74, 2));

		WebElement HandWashingHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][3]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_HandWashing_Slider, HandWashingHeader, "Rarely");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[3]"))
				.sendKeys(data.getCellData("Building", 75, 2));

		WebElement SupportSocialDistancingHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][4]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_SupportSocialDistancing_Slider, SupportSocialDistancingHeader,
				"Rarely");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[4]"))
				.sendKeys(data.getCellData("Building", 76, 2));

		WebElement MaintainSocialDistancingHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][5]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_ManintainSocialDistancing_Slider,
				MaintainSocialDistancingHeader, "Rarely");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[5]"))
				.sendKeys(data.getCellData("Building", 77, 2));

		WebElement ProtectedDiseaseTransmissionHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][6]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_ProtectedDiseaseTransmission_Slider,
				ProtectedDiseaseTransmissionHeader, "Rarely");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[6]"))
				.sendKeys(data.getCellData("Building", 78, 2));

		WebElement StaffUsePPEHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][7]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_StaffUsePPE_Slider, StaffUsePPEHeader, "Rarely");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[7]"))
				.sendKeys(data.getCellData("Building", 79, 2));

		Transportation_SubmitBtn.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (driver.findElement(By.xpath("//h4[text()='Thank you for taking our survey!']")).isDisplayed()) {
			log.info("Response message displayed.. ");
			SubmitResponseFlag = true;
			driver.close();
			driver.switchTo().window(BaseWindow);
		} else {
			log.info("Response message not displayed.. ");
			SubmitResponseFlag = false;
			driver.close();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().window(BaseWindow);
			// break;
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (SubmitResponseFlag) {
			log.info("OccupantSurvey_SubmitSurveyWithTenantSpace_Visitor method ends here with true.........");
			return true;
		} else {
			log.info("OccupantSurvey_SubmitSurveyWithTenantSpace_Visitor method ends here with false.........");
			return false;
		}
	}

	public boolean OccupantSurvey_SubmitSurveyWithWholeSpace_Management() {
		log.info("OccupantSurvey_SubmitSurveyWithWholeSpace_Management  method starts here.........");
		boolean SubmitResponseFlag = false;
		boolean SliderFlag = false;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CommonMethod.SelectEnvironmentSlider(ReEntry_Environment_Slider, "Extremely Satisfied");
		SliderFlag = OccupantSurvey_SelectAll_SurveyOptions("Extremely Satisfied");
		BuildingSurvey_CommentOptional.sendKeys(data.getCellData("Building", 36, 2));
		BuildingSurvey_Location.sendKeys(data.getCellData("Building", 37, 2));
		BuildingSurvey_NameOptional.sendKeys(data.getCellData("Building", 38, 2));
		String Occupant = data.getCellData("Building", 39, 2);
		driver.findElement(By.xpath("//select[@id='occupant_category']")).click();
		driver.findElement(By.xpath("//select[@id='occupant_category']/option[text()='" + Occupant + "']")).click();
		driver.findElement(By.xpath("//span[text()='No ']/input[@name='infection_control']")).click();
		// driver.findElement(ByAngular.model("question.reason.data")).sendKeys(data.getCellData("Building",
		// 72, 2));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement DiseaseControlHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][1]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_DiseaseControl_Slider, DiseaseControlHeader, "Sometimes");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[1]"))
				.sendKeys(data.getCellData("Building", 73, 2));

		WebElement OccupantScreeningHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][2]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_OccupantScreening_Slider, OccupantScreeningHeader, "Sometimes");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[2]"))
				.sendKeys(data.getCellData("Building", 74, 2));

		WebElement HandWashingHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][3]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_HandWashing_Slider, HandWashingHeader, "Sometimes");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[3]"))
				.sendKeys(data.getCellData("Building", 75, 2));

		WebElement SupportSocialDistancingHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][4]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_SupportSocialDistancing_Slider, SupportSocialDistancingHeader,
				"Sometimes");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[4]"))
				.sendKeys(data.getCellData("Building", 76, 2));

		WebElement MaintainSocialDistancingHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][5]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_ManintainSocialDistancing_Slider,
				MaintainSocialDistancingHeader, "Sometimes");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[5]"))
				.sendKeys(data.getCellData("Building", 77, 2));

		WebElement ProtectedDiseaseTransmissionHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][6]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_ProtectedDiseaseTransmission_Slider,
				ProtectedDiseaseTransmissionHeader, "Sometimes");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[6]"))
				.sendKeys(data.getCellData("Building", 78, 2));

		WebElement StaffUsePPEHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][7]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_StaffUsePPE_Slider, StaffUsePPEHeader, "Sometimes");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[7]"))
				.sendKeys(data.getCellData("Building", 79, 2));

		Transportation_SubmitBtn.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (driver.findElement(By.xpath("//h4[text()='Thank you for taking our survey!']")).isDisplayed()) {
			log.info("Response message displayed.. ");
			SubmitResponseFlag = true;
			driver.close();
			driver.switchTo().window(BaseWindow);
		} else {
			log.info("Response message not displayed.. ");
			SubmitResponseFlag = false;
			driver.close();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().window(BaseWindow);
			// break;
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (SubmitResponseFlag) {
			log.info("OccupantSurvey_SubmitSurveyWithWholeSpace_Management method ends here with true.........");
			return true;
		} else {
			log.info("OccupantSurvey_SubmitSurveyWithWholeSpace_Management method ends here with false.........");
			return false;
		}
	}

	public boolean OccupantSurvey_SubmitSurveyWithWholeSpace_Tenant() {
		log.info("OccupantSurvey_SubmitSurveyWithWholeSpace_Tenant  method starts here.........");
		boolean SubmitResponseFlag = false;
		boolean SliderFlag = false;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CommonMethod.SelectEnvironmentSlider(ReEntry_Environment_Slider, "Extremely Unsatisfied");
		SliderFlag = OccupantSurvey_SelectAll_SurveyOptions("Extremely Unsatisfied");
		BuildingSurvey_CommentOptional.sendKeys(data.getCellData("Building", 36, 2));
		BuildingSurvey_Location.sendKeys(data.getCellData("Building", 37, 2));
		BuildingSurvey_NameOptional.sendKeys(data.getCellData("Building", 38, 2));
		String Occupant = data.getCellData("Building", 39, 2);
		driver.findElement(By.xpath("//select[@id='occupant_category']")).click();
		driver.findElement(By.xpath("//select[@id='occupant_category']/option[text()='" + Occupant + "']")).click();
		driver.findElement(By.xpath("//span[text()='No ']/input[@name='infection_control']")).click();
		// driver.findElement(ByAngular.model("question.reason.data")).sendKeys(data.getCellData("Building",
		// 72, 2));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement DiseaseControlHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][1]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_DiseaseControl_Slider, DiseaseControlHeader, "Usually");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[1]"))
				.sendKeys(data.getCellData("Building", 73, 2));

		WebElement OccupantScreeningHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][2]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_OccupantScreening_Slider, OccupantScreeningHeader, "Usually");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[2]"))
				.sendKeys(data.getCellData("Building", 74, 2));

		WebElement HandWashingHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][3]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_HandWashing_Slider, HandWashingHeader, "Usually");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[3]"))
				.sendKeys(data.getCellData("Building", 75, 2));

		WebElement SupportSocialDistancingHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][4]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_SupportSocialDistancing_Slider, SupportSocialDistancingHeader,
				"Usually");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[4]"))
				.sendKeys(data.getCellData("Building", 76, 2));

		WebElement MaintainSocialDistancingHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][5]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_ManintainSocialDistancing_Slider,
				MaintainSocialDistancingHeader, "Usually");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[5]"))
				.sendKeys(data.getCellData("Building", 77, 2));

		WebElement ProtectedDiseaseTransmissionHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][6]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_ProtectedDiseaseTransmission_Slider,
				ProtectedDiseaseTransmissionHeader, "Usually");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[6]"))
				.sendKeys(data.getCellData("Building", 78, 2));

		WebElement StaffUsePPEHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][7]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_StaffUsePPE_Slider, StaffUsePPEHeader, "Usually");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[7]"))
				.sendKeys(data.getCellData("Building", 79, 2));

		Transportation_SubmitBtn.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (driver.findElement(By.xpath("//h4[text()='Thank you for taking our survey!']")).isDisplayed()) {
			log.info("Response message displayed.. ");
			SubmitResponseFlag = true;
			driver.close();
			driver.switchTo().window(BaseWindow);
		} else {
			log.info("Response message not displayed.. ");
			SubmitResponseFlag = false;
			driver.close();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().window(BaseWindow);
			// break;
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (SubmitResponseFlag) {
			log.info("OccupantSurvey_SubmitSurveyWithWholeSpace_Tenant method ends here with true.........");
			return true;
		} else {
			log.info("OccupantSurvey_SubmitSurveyWithWholeSpace_Tenant method ends here with false.........");
			return false;
		}
	}

	public boolean OccupantSurvey_SubmitSurveyWithWholeSpace_Visitor() {
		log.info("OccupantSurvey_SubmitSurveyWithWholeSpace_Visitor  method starts here.........");
		boolean SubmitResponseFlag = false;
		boolean SliderFlag = false;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CommonMethod.SelectEnvironmentSlider(ReEntry_Environment_Slider, "Very Unsatisfied");
		SliderFlag = OccupantSurvey_SelectAll_SurveyOptions("Very Unsatisfied");
		BuildingSurvey_CommentOptional.sendKeys(data.getCellData("Building", 36, 2));
		BuildingSurvey_Location.sendKeys(data.getCellData("Building", 37, 2));
		BuildingSurvey_NameOptional.sendKeys(data.getCellData("Building", 38, 2));
		String Occupant = data.getCellData("Building", 39, 2);
		driver.findElement(By.xpath("//select[@id='occupant_category']")).click();
		driver.findElement(By.xpath("//select[@id='occupant_category']/option[text()='" + Occupant + "']")).click();
		driver.findElement(By.xpath("//span[text()='No ']/input[@name='infection_control']")).click();
		// driver.findElement(ByAngular.model("question.reason.data")).sendKeys(data.getCellData("Building",
		// 72, 2));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement DiseaseControlHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][1]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_DiseaseControl_Slider, DiseaseControlHeader, "Always");
		// driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[1]")).sendKeys(data.getCellData("Building",
		// 73, 2));

		WebElement OccupantScreeningHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][2]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_OccupantScreening_Slider, OccupantScreeningHeader, "Always");
		// driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[2]")).sendKeys(data.getCellData("Building",
		// 74, 2));

		WebElement HandWashingHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][3]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_HandWashing_Slider, HandWashingHeader, "Always");
		// driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[3]")).sendKeys(data.getCellData("Building",
		// 75, 2));

		WebElement SupportSocialDistancingHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][4]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_SupportSocialDistancing_Slider, SupportSocialDistancingHeader,
				"Always");
		// driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[4]")).sendKeys(data.getCellData("Building",
		// 76, 2));

		WebElement MaintainSocialDistancingHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][5]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_ManintainSocialDistancing_Slider,
				MaintainSocialDistancingHeader, "Always");
		// driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[5]")).sendKeys(data.getCellData("Building",
		// 77, 2));

		WebElement ProtectedDiseaseTransmissionHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][6]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_ProtectedDiseaseTransmission_Slider,
				ProtectedDiseaseTransmissionHeader, "Always");
		// driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[6]")).sendKeys(data.getCellData("Building",
		// 78, 2));

		WebElement StaffUsePPEHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][7]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_StaffUsePPE_Slider, StaffUsePPEHeader, "Always");
		// driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[7]")).sendKeys(data.getCellData("Building",
		// 79, 2));

		Transportation_SubmitBtn.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (driver.findElement(By.xpath("//h4[text()='Thank you for taking our survey!']")).isDisplayed()) {
			log.info("Response message displayed.. ");
			SubmitResponseFlag = true;
			driver.close();
			driver.switchTo().window(BaseWindow);
		} else {
			log.info("Response message not displayed.. ");
			SubmitResponseFlag = false;
			driver.close();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().window(BaseWindow);
			// break;
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (SubmitResponseFlag) {
			log.info("OccupantSurvey_SubmitSurveyWithWholeSpace_Visitor method ends here with true.........");
			return true;
		} else {
			log.info("OccupantSurvey_SubmitSurveyWithWholeSpace_Visitor method ends here with false.........");
			return false;
		}
	}

	public boolean OccupantSurvey_SubmitSurveyWithCommonSpace_Visitor() {
		log.info("OccupantSurvey_SubmitSurveyWithCommonSpace_Visitor  method starts here.........");
		boolean SubmitResponseFlag = false;
		boolean SliderFlag = false;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonMethod.SelectEnvironmentSlider(ReEntry_Environment_Slider, "Unsatisfied");
		OccupantSurvey_SelectAll_SurveyOptions("Unsatisfied");
		BuildingSurvey_CommentOptional.sendKeys(data.getCellData("Building", 36, 2));
		BuildingSurvey_Location.sendKeys(data.getCellData("Building", 37, 2));
		BuildingSurvey_NameOptional.sendKeys(data.getCellData("Building", 38, 2));
		String Occupant = data.getCellData("Building", 39, 2);
		driver.findElement(By.xpath("//select[@id='occupant_category']")).click();
		driver.findElement(By.xpath("//select[@id='occupant_category']/option[text()='" + Occupant + "']")).click();
		driver.findElement(By.xpath("//span[text()='Yes ']/input[@name='infection_control']")).click();
		driver.findElement(ByAngular.model("question.reason.data")).sendKeys(data.getCellData("Building", 72, 2));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement DiseaseControlHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][1]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_DiseaseControl_Slider, DiseaseControlHeader, "Sometimes");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[1]"))
				.sendKeys(data.getCellData("Building", 73, 2));

		WebElement OccupantScreeningHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][2]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_OccupantScreening_Slider, OccupantScreeningHeader, "Sometimes");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[2]"))
				.sendKeys(data.getCellData("Building", 74, 2));

		WebElement HandWashingHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][3]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_HandWashing_Slider, HandWashingHeader, "Sometimes");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[3]"))
				.sendKeys(data.getCellData("Building", 75, 2));

		WebElement SupportSocialDistancingHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][4]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_SupportSocialDistancing_Slider, SupportSocialDistancingHeader,
				"Sometimes");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[4]"))
				.sendKeys(data.getCellData("Building", 76, 2));

		WebElement MaintainSocialDistancingHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][5]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_ManintainSocialDistancing_Slider,
				MaintainSocialDistancingHeader, "Sometimes");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[5]"))
				.sendKeys(data.getCellData("Building", 77, 2));

		WebElement ProtectedDiseaseTransmissionHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][6]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_ProtectedDiseaseTransmission_Slider,
				ProtectedDiseaseTransmissionHeader, "Sometimes");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[6]"))
				.sendKeys(data.getCellData("Building", 78, 2));

		WebElement StaffUsePPEHeader = driver.findElement(By.xpath(
				"//div[@class='survey-question survey-slider'][7]/descendant::div[@class='slider_heading ng-binding']"));
		CommonMethod.SelectSliderControl(ReEntry_StaffUsePPE_Slider, StaffUsePPEHeader, "Sometimes");
		driver.findElement(By.xpath("(//textarea[@ng-model='textarea_val'])[7]"))
				.sendKeys(data.getCellData("Building", 79, 2));

		Transportation_SubmitBtn.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (driver.findElement(By.xpath("//h4[text()='Thank you for taking our survey!']")).isDisplayed()) {
			log.info("Response message displayed.. ");
			SubmitResponseFlag = true;
			driver.close();
			driver.switchTo().window(BaseWindow);
		} else {
			log.info("Response message not displayed.. ");
			SubmitResponseFlag = false;
			driver.close();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().window(BaseWindow);
			// break;
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (SubmitResponseFlag) {
			log.info("OccupantSurvey_SubmitSurveyWithCommonSpace_Visitor method ends here with true.........");
			return true;
		} else {
			log.info("OccupantSurvey_SubmitSurveyWithCommonSpace_Visitor method ends here with false.........");
			return false;
		}
	}

	// Select all the options based on slider selection.
	public boolean OccupantSurvey_SelectAll_SurveyOptions(String Message) {
		log.info("OccupantSurvey_SelectAll_SurveyOptions method starts here with option " + Message);
		String[] UnsatisfiedArray = { "Dirty", "Cold", "Drafty", "Smelly", "Dark", "Bright", "Stuffy", "Glare",
				"Views to Outdoors", "Acoustics", "Privacy", "Sound", "Hot", "Humid" };
		ArrayList<String> UnSatisfiedList = new ArrayList<String>(Arrays.asList(UnsatisfiedArray));

		String[] satisfiedArray = { "Thermal Comfort", "Sound", "Air Quality", "Cleanliness", "Light", "Privacy",
				"Views to Outdoors", "Daylight" };
		ArrayList<String> SatisfiedList = new ArrayList<String>(Arrays.asList(satisfiedArray));

		List<WebElement> UnsatisfiedCheckBoxeList;
		List<WebElement> UnsatisfiedCheckBoxLabelList;

		List<WebElement> satisfiedCheckBoxeList;
		List<WebElement> satisfiedCheckBoxLabelList;
		boolean flag = false;
		boolean Question2Flag = false;
		if (Message.equals("Extremely Unsatisfied") || Message.equals("Very Unsatisfied")
				|| Message.equals("Unsatisfied")) {
			log.info(Message + " is selected.");
			String Question2 = driver.findElement(By.xpath("//span[contains(@class,'question col-md-12 pl0')]"))
					.getText();
			// System.out.println(Question3);
			if (Question2.equals(
					"2. We're sorry to hear that. Please select the options below that significantly reduce your satisfaction:")) {
				log.info("Question 2 showing properly...");
				UnsatisfiedCheckBoxeList = driver
						.findElements(By.xpath("//div[contains(@class,'col-md-4 survey-options mt20')]/div/input"));
				UnsatisfiedCheckBoxLabelList = driver
						.findElements(By.xpath("//div[contains(@class,'col-md-4 survey-options mt20')]/div/label"));
				log.info("Total Number of Labels showing for " + Message + " are "
						+ UnsatisfiedCheckBoxLabelList.size());

				// Validation and checking all Checkboxes.
				int i = 0;
				for (WebElement ele : UnsatisfiedCheckBoxLabelList) {
					if (UnSatisfiedList.contains(ele.getText())) {
						log.info(ele.getText() + " exists on the page..");
						UnsatisfiedCheckBoxeList.get(i).click();
						if (UnsatisfiedCheckBoxeList.get(i).isSelected()) {
							log.info(ele.getText() + " is selected successfully...");
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) { // TODO Auto-generated catch block
								e.printStackTrace();
							}

							flag = true;
						} else {
							log.info("Unable to select " + ele.getText());
							flag = false;
							break;
						}
					} else {
						log.info(ele.getText() + " does not exist on the page..");
						flag = false;
						break;
					}
					i++;
				}
			} else {
				log.info("Question 2 not showing properly...");
				flag = false;
			}
		} else if (Message.equals("Neither satisfied nor unsatisfied")) {
			log.info(Message + " is selected.");
			try {
				Question2Flag = driver.findElement(By.xpath("//span[contains(@class,'question col-md-12 pl0')]"))
						.isDisplayed();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (Question2Flag == false) {
				log.info("Question 2 is not displaying...");
				flag = true;
			} else {
				log.info("Question 2 is still displaying...");
				flag = false;
			}

		}

		else if (Message.equals("Satisfied") || Message.equals("Very Satisfied")
				|| Message.equals("Extremely Satisfied")) {
			log.info(Message + " is selected.");
			String Question2 = driver.findElement(By.xpath("//span[contains(@class,'question col-md-12 pl0')]"))
					.getText();
			// System.out.println(Question3);
			if (Question2.equals(
					"2. We're glad to hear that. Please select the options below that significantly enhance your satisfaction:")) {
				log.info("Question 3 showing properly...");
				satisfiedCheckBoxeList = driver
						.findElements(By.xpath("//div[contains(@class,'col-md-4 survey-options mt20')]/div/input"));
				satisfiedCheckBoxLabelList = driver
						.findElements(By.xpath("//div[contains(@class,'col-md-4 survey-options mt20')]/div/label"));
				log.info("Total Number of Labels showing for " + Message + " are " + satisfiedCheckBoxLabelList.size());

				// Validation and checking all Checkboxes.
				int i = 0;
				for (WebElement ele : satisfiedCheckBoxLabelList) {
					if (SatisfiedList.contains(ele.getText())) {
						satisfiedCheckBoxeList.get(i).click();
						if (satisfiedCheckBoxeList.get(i).isSelected()) {
							log.info(ele.getText() + " is selected successfully...");
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) { // TODO Auto-generated catch block
								e.printStackTrace();
							}

							flag = true;
						} else {
							log.info("Unable to select " + ele.getText());
							flag = false;
							break;
						}
					} else {
						log.info(ele.getText() + " does not exist on the page..");
						flag = false;
						break;
					}
					i++;
				}
			} else {
				log.info("Question 2 not showing properly...");
				flag = false;
			}
		}
		log.info("OccupantSurvey_SelectAll_SurveyOptions method ends here with option " + Message);
		return flag;
	}

	// (Building-->Occupant Survey) This method takes the Satisfaction and verifies
	// it.
	public boolean OccupantSurveyVerify(String Scope, String Group, String SatisfactionLevel) {
		log.info("OccupantSurveyVerify Method starts here...........");
		//CommonMethod.RefreshPagewaitForPageLoaded(driver);
		//BuildingPage.ClickOnMetersAndSurveyMenu();
		//BuildingPage.ClickOnReEntry_OccupantSurvey();
		CommonMethod.switchToDataInputFrame();
		BuildingPage.SelectScope_Group(Scope, Group);
		CommonMethod.waitUntilLoadElement();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean Responseflag = false;
		boolean Averageflag = false;
		List<WebElement> ResponseList = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr/td[2]"));
		List<WebElement> AverageResponseList = driver
				.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr/td[3]"));
		for (WebElement ele : ResponseList) {
			String res=ele.getText();
			log.info("Current Response is "+res);
			if (res.contains("1")) {
				Responseflag = true;
			} else {
				Responseflag = false;
				break;
			}
		}
		for (byte i = 1; i < 8; i++) {
			String AverageText = AverageResponseList.get(i).getAttribute("innerText");
			log.info("Current Average is "+AverageText);
			if (AverageText.contains(SatisfactionLevel)) {
				Averageflag = true;
			} else {
				Averageflag = false;
				break;
			}
		}

		if ((Averageflag) && (Responseflag)) {
			log.info("OccupantSurveyVerify Method ends here with true ...........");
			return true;
		} else {
			log.info("OccupantSurveyVerify Method ends here with false ...........");
			return false;
		}

	}

	public void SelectScope_Group(String Scope, String Group) {
		waithelper.WaitForElementClickable(
				driver.findElement(By.xpath("//div[text()='Select scope']/following-sibling::button")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//div[text()='Select scope']/following-sibling::button")).click();
		ngWebDriver.waitForAngularRequestsToFinish();
		driver.findElement(By.xpath("//div[text()='Select scope']/following-sibling::ul/li/a[text()='" + Scope + "']")).click();
		//JSHelper.clickElement(driver.findElement(By.xpath("//div[text()='Select scope']/following-sibling::button")));
		//JSHelper.clickElement(driver.findElement(By.xpath("//div[text()='Select scope']/following-sibling::ul/li/a[text()='" + Scope + "']")));
		
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementClickable(
				driver.findElement(By.xpath("//div[text()='Select group response']/following-sibling::button")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//div[text()='Select group response']/following-sibling::button")).click();
		ngWebDriver.waitForAngularRequestsToFinish();
		driver.findElement(By.xpath("//div[text()='Select group response']/following-sibling::ul/li/a[text()='" + Group + "']")).click();
		ngWebDriver.waitForAngularRequestsToFinish();
		//JSHelper.clickElement(driver.findElement(By.xpath("//div[text()='Select group response']/following-sibling::button")));
		//JSHelper.clickElement(driver.findElement(By.xpath("//div[text()='Select group response']/following-sibling::ul/li/a[text()='" + Group + "']")));
		ngWebDriver.waitForAngularRequestsToFinish();
		
		
		driver.findElement(By.xpath("//div[text()='Select scope']/following-sibling::button")).click();
		ngWebDriver.waitForAngularRequestsToFinish();
		driver.findElement(By.xpath("//div[text()='Select scope']/following-sibling::ul/li/a[text()='" + Scope + "']")).click();
		//JSHelper.clickElement(driver.findElement(By.xpath("//div[text()='Select scope']/following-sibling::button")));
	//	JSHelper.clickElement(driver.findElement(By.xpath("//div[text()='Select scope']/following-sibling::ul/li/a[text()='" + Scope + "']")));
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
