package com.arc.PageObject.Project;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;
import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class CityPageObject extends BaseClass {

	private static Logger log = LoggerHelper.getLogger(CityPageObject.class);

	@FindBy(xpath = "(//*[text()='Manage' and @class='ml10'])[1]")
	WebElement ManageMenu;

	@FindBy(xpath = "(//*[text()='Certifications' and @class='ml10'])[1]")
	WebElement CertificationsMenu;

	@FindBy(xpath = "(//*[text()='Data Input'])[1]")
	WebElement DataInputSubMenu;

	@FindBy(xpath = "//table[@class='building-settings']/tbody/tr/td[2]/div")
	WebElement ProjectSettingButton;

	@FindBy(xpath = "(//table[@class='meterListByType--wrapper']/tbody/tr[2])[1]/td[2]/div")
	WebElement GHGEmission;

	@FindBy(xpath = "(//table[@class='meterListByType--wrapper']/tbody)[2]/tr[2]/td[2]/div")
	WebElement WaterConsumption;

	@FindBy(xpath = "(//table[@class='meterListByType--wrapper']/tbody/tr[1])[1]/td[3]/div/span/span")
	WebElement EnergyScore;

	@FindBy(xpath = "(//table[@class='meterListByType--wrapper']/tbody/tr[1])[4]/td[3]/div/span/span")
	WebElement TransportScore;

	@FindBy(xpath = "(//table[@class='meterListByType--wrapper']/tbody)[2]/tr[1]/td[3]/div/span/span")
	WebElement WaterScore;

	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span/span")
	WebElement QualityScore;

	@FindBy(xpath = "(//table[@class='meterListByType--wrapper']/tbody)[3]/tr[1]/td[3]/div/span/span")
	WebElement WasteScore;

	@FindBy(xpath = "//*[text()='Population']")
	WebElement PopulationTab;

	@FindBy(xpath = "//*[@id='meter_item']/ul/li[2]/span")
	WebElement ProjectAreaTab;

	@FindBy(xpath = "//*[@class='meterData-btn--addRowTitle']")
	WebElement ProjectSettingAddRowButton;

	@FindBy(xpath = "//table[@id='readingsTable']/thead/tr/th[1]")
	WebElement PopulationEffectiveYearHeading;

	@FindBy(xpath = "//table[@id='readingsTable']/thead/tr/th[2]")
	WebElement Population_populationHeading;

	@FindBy(xpath = "//table[@id='readingsTable']/thead/tr/th[3]")
	WebElement Population_UpdatedByHeading;

	@FindBy(xpath = "//table[@id='readingsTable']/tbody/tr[1]/td[4]/button")
	WebElement Population_SaveButton;

	@FindBy(xpath = "//button[@class='dropdown-toggle meterDataYearsFilter-btn']")
	WebElement YearFilterButton;

	@FindBy(xpath = "(//ul[@class='filter_dropdown dropdown-menu left']/li/div[2]/div/input)[1]")
	WebElement YearStartDateTextBox;

	@FindBy(xpath = "(//ul[@class='filter_dropdown dropdown-menu left']/li/div[2]/div/input)[2]")
	WebElement YearEndDateTextBox;

	@FindBy(xpath = "//ul[@class='filter_dropdown dropdown-menu left']/li/div[3]/button")
	WebElement YearUpdateBtn;

	@FindBy(xpath = "//ul[@class='filter_dropdown dropdown-menu left']/li/div[1]/h6")
	WebElement YearResetBtn;

	@FindBy(xpath = "//table[@id='readingsTable']/tbody/tr[1]/td[6]/span")
	WebElement Population_DeleteButton;

	@FindBy(xpath = "(//*[@id='comment_box'])[1]")
	WebElement Population_CommentTextBox;

	@FindBy(xpath = "(//button[text()='Post'])[1]")
	WebElement Population_PostButton;

	@FindBy(xpath = "//span[text()='Activity']")
	WebElement Population_ActivityButton;

	@FindBy(xpath = "(//*[@id='comment_box'])[1]")
	WebElement ProjectArea_CommentTextBox;

	@FindBy(xpath = "(//button[text()='Post'])[1]")
	WebElement ProjectArea_PostButton;

	@FindBy(xpath = "//span[text()='Activity']")
	WebElement ProjectArea_ActivityButton;

	@FindBy(xpath = "(//*[@id='comment_box'])[2]")
	WebElement Energy_CommentTextBox;

	@FindBy(xpath = "(//button[@class='btn btn-default button--post'])[2]")
	WebElement Energy_PostButton;

	@FindBy(xpath = "//span[text()='Activity']")
	WebElement Energy_ActivityButton;

	@FindBy(xpath = "(//*[@id='comment_box'])[2]")
	WebElement Water_CommentTextBox;

	@FindBy(xpath = "(//button[@class='btn btn-default button--post'])[2]")
	WebElement Water_PostButton;

	@FindBy(xpath = "//span[text()='Activity']")
	WebElement Water_ActivityButton;

	@FindBy(xpath = "(//*[@id='comment_box'])[2]")
	WebElement Waste_Gen_CommentTextBox;

	@FindBy(xpath = "(//button[@class='btn btn-default button--post'])[2]")
	WebElement Waste_Gen_PostButton;

	@FindBy(xpath = "//span[text()='Activity']")
	WebElement Waste_Gen_ActivityButton;

	@FindBy(xpath = "(//*[@id='comment_box'])[2]")
	WebElement Waste_Div_CommentTextBox;

	@FindBy(xpath = "(//button[@class='btn btn-default button--post'])[2]")
	WebElement Waste_Div_PostButton;

	@FindBy(xpath = "//span[text()='Activity']")
	WebElement Waste_Div_ActivityButton;

	@FindBy(xpath = "//table[@id='readingsTable']/thead/tr/th[1]")
	WebElement ProjectAreaEffectiveYearHeading;

	@FindBy(xpath = "//table[@id='readingsTable']/thead/tr/th[2]")
	WebElement ProjectArea_ProjectAreaHeading;

	@FindBy(xpath = "//table[@id='readingsTable']/thead/tr/th[3]")
	WebElement ProjectArea_UpdatedByHeading;

	@FindBy(xpath = "//table[@id='readingsTable']/tbody/tr[1]/td[4]/button")
	WebElement ProjectArea_SaveButton;

	@FindBy(xpath = "//table[@id='readingsTable']/tbody/tr[1]/td[6]/span")
	WebElement ProjectArea_DeleteButton;

	@FindBy(xpath = "//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")
	WebElement Population_populationTextBox;

	@FindBy(xpath = "//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")
	WebElement Population_EffectiveYearTextBox;

	@FindBy(xpath = "//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")
	WebElement ProjectArea_EffectiveYearTextBox;

	@FindBy(xpath = "//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")
	WebElement ProjectAreaTextBox;

	@FindBy(xpath = "//*[text()='Energy']//parent::td//parent::tr//following-sibling::tr[1]/td[2]/div")
	WebElement EnergyMeter;

	@FindBy(xpath = "//span[text()='Data']")
	WebElement GHGEmission_DataTab;

	@FindBy(xpath = "(//ul[@class='meterNav'])[2]/li[2]/span")
	WebElement GHGEmission_DetailsTab;

	@FindBy(xpath = "//span[text()='Data']")
	WebElement WaterConsum_DataTab;

	@FindBy(xpath = "(//ul[@class='meterNav'])[2]/li[2]/span")
	WebElement WaterConsum_DetailsTab;

	@FindBy(xpath = "(//ul[@class='meterNav'])[2]/li[2]/span")
	WebElement WasteGen_DetailsTab;

	@FindBy(xpath = "(//ul[@class='meterNav'])[2]/li[2]/span")
	WebElement WasteDiv_DetailsTab;

	@FindBy(xpath = "//span[text()='Add Year']/parent::button")
	WebElement GHGEmission_Data_AddYearBtn;

	@FindBy(xpath = "//span[text()='Add Year']/parent::button")
	WebElement WaterConsum_Data_AddYearBtn;

	@FindBy(xpath = "//span[text()='Add Year']/parent::button")
	WebElement Additional_Data_AddYearBtn;

	@FindBy(xpath = "//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")
	WebElement GHGEmission_Data_Save_EditBtn;

	@FindBy(xpath = "//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")
	WebElement FirstRow_Waste_Gen_Data_Save_EditBtn;

	@FindBy(xpath = "//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")
	WebElement FirstRow_Waste_Div_Data_Save_EditBtn;

	@FindBy(xpath = "//table[@class='table arcTbl cityTable']/tbody/tr[1]/td[2]/input")
	WebElement AddYearbutton;

	@FindBy(xpath = "//span[text()='Previous Year']//parent::button")
	WebElement PreviousYearbutton;

	@FindBy(xpath = "//span[text()='Next Year']//parent::button")
	WebElement NextYearbutton;

	@FindBy(xpath = "(//input[@type='radio'])[1]")
	WebElement PrivateYesRadioButton;

	@FindBy(xpath = "(//input[@type='radio'])[2]")
	WebElement PrivateNoRadioButton;

	@FindBy(xpath = "//h3[@class='fw-500 black-color pl15 mb25 pt5']")
	WebElement PerformanceHeaderText;

	@FindBy(xpath = "(//a[text()=' Agreements '])[1]")
	WebElement AgreementSubmenu;

	@FindBy(xpath = "(//a[text()=' Settings '])[1]")
	WebElement SettingsSubmenu;
	
	@FindBy(xpath = "(//a[text()=' Score Version '])[1]")
	WebElement ScoreVersionSubmenu;

	@FindBy(xpath = "(//a[text()=' Billing '])[1]")
	WebElement BillingSubmenu;

	@FindBy(xpath = "(//a[text()=' Project '])[1]")
	WebElement ProjectSubmenu;

	@FindBy(xpath = "(//a[text()=' Team '])[1]")
	WebElement TeamSubmenu;

	@FindBy(xpath = "(//table[@class='meterListByType--wrapper']/tbody)[3]/tr[2]/td[2]/div")
	WebElement Waste_Solid_Generation;

	@FindBy(xpath = "(//table[@class='meterListByType--wrapper']/tbody)[3]/tr[3]/td[2]/div")
	WebElement Waste_Solid_Diversion;

	@FindBy(xpath = "//span[@class='meterData-btn--addRowTitle']/parent::button")
	WebElement Waste_AddYearButton;

	@FindBy(xpath = "//span[text()='Previous Year']/parent::button")
	WebElement Waste_PrevoiusYearButton;

	@FindBy(xpath = "//span[text()='Next Year']/parent::button")
	WebElement Waste_NextYearButton;

	@FindBy(xpath = "//span[text()='Data']")
	WebElement Waste_DataTab;

	@FindBy(xpath = "(//ul[@class='meterNav'])[2]/li[2]/span")
	WebElement Waste_DetailsTab;

	@FindBy(name = "test_project")
	WebElement ThisIsTestProjectCheckBox;

	@FindBy(xpath = "(//table[@class='table-condensed'])[2]/thead/tr/th[2]")
	WebElement DecadeCalenderHeader;

	// ****************************Transportation Objects************************
	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[4]/tr[2]/td[2]/div")
	WebElement Transport_VMT;

	@FindBy(xpath = "//span[text()='Data']")
	WebElement VMT_DataTab;

	@FindBy(xpath = "(//ul[@class='meterNav'])[2]/li[2]/span")
	WebElement VMT_DetailsTab;

	@FindBy(xpath = "//span[text()='Add Year']/parent::button")
	WebElement VMT_Data_AddYearBtn;

	@FindBy(xpath = "//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")
	WebElement VMT_Data_Save_EditBtn;

	@FindBy(xpath = "(//textarea[@id='comment_box'])[2]")
	WebElement VMT_CommentTextBox;

	@FindBy(xpath = "(//button[@class='btn btn-default button--post'])[2]")
	WebElement VMT_PostButton;

	@FindBy(xpath = "//span[text()='Activity']")
	WebElement VMT_ActivityButton;

	// ****************************Quality Of Life--> Health And Safety
	// Objects************************
	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[5]/tr[2]/td[2]/div")
	WebElement HealthAndSafety;

	@FindBy(xpath = "//span[text()='Data']")
	WebElement HealthAndSafety_DataTab;

	@FindBy(xpath = "(//ul[@class='meterNav'])[2]/li[2]/span")
	WebElement HealthAndSafety_DetailsTab;

	@FindBy(xpath = "//span[text()='Add Year']/parent::button")
	WebElement HealthAndSafety_Data_AddYearBtn;

	@FindBy(xpath = "//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")
	WebElement HealthAndSafety_Data_Save_EditBtn;

	@FindBy(xpath = "(//textarea[@id='comment_box'])[2]")
	WebElement HealthAndSafety_CommentTextBox;

	@FindBy(xpath = "(//button[@class='btn btn-default button--post'])[2]")
	WebElement HealthAndSafety_PostButton;

	@FindBy(xpath = "//span[text()='Activity']")
	WebElement HealthAndSafety_ActivityButton;

	// ****************************Quality Of Life--> Equitability: Gini coefficient
	// (for income distribution)************************
	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[5]/tr[4]/td[2]/div")
	WebElement Equitability_Gini_Coefficient;

	@FindBy(xpath = "//span[text()='Data']")
	WebElement Equitability_Gini_Coefficient_DataTab;

	@FindBy(xpath = "(//ul[@class='meterNav'])[2]/li[2]/span")
	WebElement Equitability_Gini_Coefficient_DetailsTab;

	@FindBy(xpath = "//span[text()='Add Year']/parent::button")
	WebElement Equitability_Gini_Coefficient_Data_AddYearBtn;

	@FindBy(xpath = "//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")
	WebElement Equitability_Gini_Coefficient_Data_Save_EditBtn;

	@FindBy(xpath = "(//textarea[@id='comment_box'])[2]")
	WebElement Equitability_Gini_Coefficient_CommentTextBox;

	@FindBy(xpath = "(//button[@class='btn btn-default button--post'])[2]")
	WebElement Equitability_Gini_Coefficient_PostButton;

	@FindBy(xpath = "//span[text()='Activity']")
	WebElement Equitability_Gini_Coefficient_ActivityButton;

	// ****************************Quality Of Life--> Education: Population with (at
	// least) Bachelor's degree (%)************************
	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[5]/tr[3]/td[2]/div")
	WebElement Education_BachelorPopulation;

	@FindBy(xpath = "//span[text()='Data']")
	WebElement Education_BachelorPopulation_DataTab;

	@FindBy(xpath = "(//ul[@class='meterNav'])[2]/li[2]/span")
	WebElement Education_BachelorPopulation_DetailsTab;

	@FindBy(xpath = "//span[text()='Add Year']/parent::button")
	WebElement Education_BachelorPopulation_Data_AddYearBtn;

	@FindBy(xpath = "//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")
	WebElement Education_BachelorPopulation_Data_Save_EditBtn;

	@FindBy(xpath = "(//textarea[@id='comment_box'])[2]")
	WebElement Education_BachelorPopulation_CommentTextBox;

	@FindBy(xpath = "(//button[@class='btn btn-default button--post'])[2]")
	WebElement Education_BachelorPopulation_PostButton;

	@FindBy(xpath = "//span[text()='Activity']")
	WebElement Education_BachelorPopulation_ActivityButton;

	// ****************************Quality Of Life--> Education: Population with (at
	// least) High School degree (%)************************
	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[5]/tr[5]/td[2]/div")
	WebElement Education_HighSchoolPopulation;

	@FindBy(xpath = "//span[text()='Data']")
	WebElement Education_HighSchoolPopulation_DataTab;

	@FindBy(xpath = "(//ul[@class='meterNav'])[2]/li[2]/span")
	WebElement Education_HighSchoolPopulation_DetailsTab;

	@FindBy(xpath = "//span[text()='Add Year']/parent::button")
	WebElement Education_HighSchoolPopulation_Data_AddYearBtn;

	@FindBy(xpath = "//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")
	WebElement Education_HighSchoolPopulation_Data_Save_EditBtn;

	@FindBy(xpath = "(//textarea[@id='comment_box'])[2]")
	WebElement Education_HighSchoolPopulation_CommentTextBox;

	@FindBy(xpath = "(//button[@class='btn btn-default button--post'])[2]")
	WebElement Education_HighSchoolPopulation_PostButton;

	@FindBy(xpath = "//span[text()='Activity']")
	WebElement Education_HighSchoolPopulation_ActivityButton;

	// ****************************Quality Of Life--> Prosperity: Median household
	// income (US Dollars/Year)************************
	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[5]/tr[6]/td[2]/div")
	WebElement ProsperityMedianIncome;

	@FindBy(xpath = "//span[text()='Data']")
	WebElement ProsperityMedianIncome_DataTab;

	@FindBy(xpath = "(//ul[@class='meterNav'])[2]/li[2]/span")
	WebElement ProsperityMedianIncome_DetailsTab;

	@FindBy(xpath = "//span[text()='Add Year']/parent::button")
	WebElement ProsperityMedianIncome_Data_AddYearBtn;

	@FindBy(xpath = "//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")
	WebElement ProsperityMedianIncome_Data_Save_EditBtn;

	@FindBy(xpath = "(//textarea[@id='comment_box'])[2]")
	WebElement ProsperityMedianIncome_CommentTextBox;

	@FindBy(xpath = "(//button[@class='btn btn-default button--post'])[2]")
	WebElement ProsperityMedianIncome_PostButton;

	@FindBy(xpath = "//span[text()='Activity']")
	WebElement ProsperityMedianIncome_ActivityButton;

	// ****************************Quality Of Life--> Prosperity: Median household
	// income (US Dollars/Year)************************
	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[5]/tr[7]/td[2]/div")
	WebElement Equitability_MedianGrossIncome;

	@FindBy(xpath = "//span[text()='Data']")
	WebElement Equitability_MedianGrossIncome_DataTab;

	@FindBy(xpath = "(//ul[@class='meterNav'])[2]/li[2]/span")
	WebElement Equitability_MedianGrossIncome_DetailsTab;

	@FindBy(xpath = "//span[text()='Add Year']/parent::button")
	WebElement Equitability_MedianGrossIncome_Data_AddYearBtn;

	@FindBy(xpath = "//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")
	WebElement Equitability_MedianGrossIncome_Data_Save_EditBtn;

	@FindBy(xpath = "(//textarea[@id='comment_box'])[2]")
	WebElement Equitability_MedianGrossIncome_CommentTextBox;

	@FindBy(xpath = "(//button[@class='btn btn-default button--post'])[2]")
	WebElement Equitability_MedianGrossIncome_PostButton;

	@FindBy(xpath = "//span[text()='Activity']")
	WebElement Equitability_MedianGrossIncome_ActivityButton;

	// ****************************Quality Of Life--> Prosperity: Unemployment rate
	// (%)************************
	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[5]/tr[8]/td[2]/div")
	WebElement ProsperityUnemployementRate;

	@FindBy(xpath = "//span[text()='Data']")
	WebElement ProsperityUnemployementRate_DataTab;

	@FindBy(xpath = "(//ul[@class='meterNav'])[2]/li[2]/span")
	WebElement ProsperityUnemployementRate_DetailsTab;

	@FindBy(xpath = "//span[text()='Add Year']/parent::button")
	WebElement ProsperityUnemployementRate_Data_AddYearBtn;

	@FindBy(xpath = "//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")
	WebElement ProsperityUnemployementRate_Data_Save_EditBtn;

	@FindBy(xpath = "(//textarea[@id='comment_box'])[2]")
	WebElement ProsperityUnemployementRate_CommentTextBox;

	@FindBy(xpath = "(//button[@class='btn btn-default button--post'])[2]")
	WebElement ProsperityUnemployementRate_PostButton;

	@FindBy(xpath = "//span[text()='Activity']")
	WebElement ProsperityUnemployementRate_ActivityButton;

	// ****************************Quality Of Life--> Health & Safety: Air quality
	// days unhealthy for sensitive groups (Days/yr)************************
	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[5]/tr[9]/td[2]/div")
	WebElement HealthAndSafetySensitiveGroup;

	@FindBy(xpath = "//span[text()='Data']")
	WebElement HealthAndSafetySensitiveGroup_DataTab;

	@FindBy(xpath = "(//ul[@class='meterNav'])[2]/li[2]/span")
	WebElement HealthAndSafetySensitiveGroup_DetailsTab;

	@FindBy(xpath = "//span[text()='Add Year']/parent::button")
	WebElement HealthAndSafetySensitiveGroup_Data_AddYearBtn;

	@FindBy(xpath = "//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")
	WebElement HealthAndSafetySensitiveGroup_Data_Save_EditBtn;

	@FindBy(xpath = "(//textarea[@id='comment_box'])[2]")
	WebElement HealthAndSafetySensitiveGroup_CommentTextBox;

	@FindBy(xpath = "(//button[@class='btn btn-default button--post'])[2]")
	WebElement HealthAndSafetySensitiveGroup_PostButton;

	@FindBy(xpath = "//span[text()='Activity']")
	WebElement HealthAndSafetySensitiveGroup_ActivityButton;

	// ****************************Quality Of Life--> Health & Safety: Violent Crime
	// (per year per capita)************************
	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[5]/tr[10]/td[2]/div")
	WebElement HealthAndSafetyVoilentCrime;

	@FindBy(xpath = "//span[text()='Data']")
	WebElement HealthAndSafetyVoilentCrime_DataTab;

	@FindBy(xpath = "(//ul[@class='meterNav'])[2]/li[2]/span")
	WebElement HealthAndSafetyVoilentCrime_DetailsTab;

	@FindBy(xpath = "//span[text()='Add Year']/parent::button")
	WebElement HealthAndSafetyVoilentCrime_Data_AddYearBtn;

	@FindBy(xpath = "//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")
	WebElement HealthAndSafetyVoilentCrime_Data_Save_EditBtn;

	@FindBy(xpath = "(//textarea[@id='comment_box'])[2]")
	WebElement HealthAndSafetyVoilentCrime_CommentTextBox;

	@FindBy(xpath = "(//button[@class='btn btn-default button--post'])[2]")
	WebElement HealthAndSafetyVoilentCrime_PostButton;

	@FindBy(xpath = "//span[text()='Activity']")
	WebElement HealthAndSafetyVoilentCrime_ActivityButton;

	// *******************************Additional Data
	// *****************************************

	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[6]/tr[2]/td[2]/div")
	WebElement AdditionalData;

	// *******************************Manage-Project Sections

	@FindBy(xpath = "//input[@name='manageEntityName']")
	WebElement ManagingEntityName;

	@FindBy(xpath = "//input[@name='manageEntityAdd1']")
	WebElement ManagingEntityAddress1;

	@FindBy(xpath = "//input[@name='manageEntityAdd2']")
	WebElement ManagingEntityAddress2;

	@FindBy(xpath = "//input[@name='manageEntityCity']")
	WebElement ManagingEntityCity;

	@FindBy(xpath = "//input[@name='targetCertDate']")
	WebElement TargetCertificationDate;

	// *****************************************
	// ************************************************************************
	public CityPageObject() {
		PageFactory.initElements(driver, this);
	}

	public void ClickonAgreementInManage() {
		log.info("ClickonAgreementInManage method starts here ....");
		waithelper.WaitForElementClickable(ManageMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ManageMenu.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementClickable(AgreementSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		AgreementSubmenu.click();
		CommonMethod.waitUntilLoadElement();
		ngWebDriver.waitForAngularRequestsToFinish();
		log.info("ClickonAgreementInManage method ends here ....");
	}

	public void ClickonSettingsInManage() {
		log.info("ClickonSettingsInManage method starts here ....");
		waithelper.WaitForElementClickable(ManageMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ManageMenu.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementClickable(SettingsSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		SettingsSubmenu.click();
		CommonMethod.waitUntilLoadElement();
		ngWebDriver.waitForAngularRequestsToFinish();
		log.info("ClickonSettingsInManage method ends here ....");
	}
	
	public void ClickonScoreVersionInManage() {
		log.info("ClickonScoreVersionInManage method starts here ....");
		waithelper.WaitForElementClickable(ManageMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ManageMenu.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementClickable(ScoreVersionSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ScoreVersionSubmenu.click();
		CommonMethod.waitUntilLoadElement();
		ngWebDriver.waitForAngularRequestsToFinish();
		log.info("ClickonScoreVersionInManage method ends here ....");
	}

	public void ClickonBillingInManage() {
		log.info("ClickonBillingInManage method ends here ....");
		waithelper.WaitForElementClickable(ManageMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ManageMenu.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementClickable(BillingSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		BillingSubmenu.click();
		CommonMethod.waitUntilLoadElement();
		ngWebDriver.waitForAngularRequestsToFinish();
		log.info("ClickonBillingInManage method ends here ....");
	}

	public void ClickonDataInput() {

		log.info("ClickonDataInput method started here. ...");
		waithelper.WaitForElementVisibleWithPollingTime(PerformanceHeaderText,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		DataInputSubMenu.click();
		CommonMethod.waitUntilLoadElement();
		ngWebDriver.waitForAngularRequestsToFinish();
		log.info("ClickonDataInput method ends here. ...");
	}

	public void ClickonProjectSetting() {

		log.info("ClickonProjectSetting method started here. ...");
		// driver.switchTo().frame("datainput-widget");
		waithelper.WaitForElementVisibleWithPollingTime(ProjectSettingButton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProjectSettingButton.click();
		CommonMethod.waitUntilLoadElement();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(PopulationTab,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickonProjectSetting method ends here. ...");
	}

	// This method will click on Energy --> GHG Emissions
	public void ClickonGHGEmiissions() {

		log.info("ClickonGHGEmiissions method started here.....");

		// driver.switchTo().frame("datainput-widget");
		try {
			waithelper.WaitForElementVisibleWithPollingTime(GHGEmission,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();

		}
		GHGEmission.click();
		CommonMethod.waitUntilLoadElement();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//*[contains(text(),'GHG Emissions')])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickonGHGEmiissions method ends here.....");

	}

	// This method will click on Transportation --> VMT
	public void ClickonVMT() {

		log.info("ClickonVMT method started here.....");

		// driver.switchTo().frame("datainput-widget");
		try {
			waithelper.WaitForElementVisibleWithPollingTime(Transport_VMT,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();

		}
		Transport_VMT.click();
		CommonMethod.waitUntilLoadElement();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath(
						"(//*[contains(text(),'Vehicle miles traveled on individual vehicles daily (VMT)')])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickonVMT method ends here.....");

	}

	// This method will click on Quality of Life --> Health And Safety: Median Air
	// Quality Index (AQI)
	public void ClickonHealthAndSafety() {

		log.info("ClickonHealthAndSafety method started here.....");

		// driver.switchTo().frame("datainput-widget");
		try {
			waithelper.WaitForElementVisibleWithPollingTime(HealthAndSafety,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();

		}
		HealthAndSafety.click();
		CommonMethod.waitUntilLoadElement();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(
						By.xpath("(//*[contains(text(),'Health & Safety: Median air quality index (AQI)')])[3]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickonHealthAndSafety method ends here.....");

	}

	// This method will click on Quality of Life --> Education: Population with (at
	// least) Bachelor's degree (%)
	public void ClickonEducation_BachelorPopulation() {

		log.info("ClickonEducation_BachelorPopulation method started here.....");

		// driver.switchTo().frame("datainput-widget");
		try {
			waithelper.WaitForElementVisibleWithPollingTime(Education_BachelorPopulation,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();

		}
		Education_BachelorPopulation.click();
		CommonMethod.waitUntilLoadElement();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath(
						"(//*[contains(text(),\"Education: Population with (at least) Bachelor's degree\")])[3]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickonEducation_BachelorPopulation method ends here.....");

	}

	// This method will click on Quality of Life --> Equitability: Gini coefficient
	// (for income distribution)
	public void ClickonEquitability_Gini_Coeffiecient() {

		log.info("ClickonEquitability_Gini_Coeffiecient method started here.....");

		// driver.switchTo().frame("datainput-widget");
		try {
			waithelper.WaitForElementVisibleWithPollingTime(Equitability_Gini_Coefficient,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();

		}
		Equitability_Gini_Coefficient.click();
		CommonMethod.waitUntilLoadElement();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath(
						"(//*[contains(text(),\"Equitability: Gini coefficient (for income distribution)\")])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickonEquitability_Gini_Coeffiecient method ends here.....");

	}

	// This method will click on Quality of Life --> Education: Population with (at
	// least) High School degree (%)
	public void ClickonEducation_HighSchoolPopulation() {

		log.info("ClickonEducation_HighSchoolPopulation method started here.....");

		// driver.switchTo().frame("datainput-widget");
		try {
			waithelper.WaitForElementVisibleWithPollingTime(Education_HighSchoolPopulation,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();

		}
		Education_HighSchoolPopulation.click();
		CommonMethod.waitUntilLoadElement();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath(
						"(//*[contains(text(),\"Education: Population with (at least) High School degree (%)\")])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickonEducation_HighSchoolPopulation method ends here.....");

	}

// This method will click on Quality of Life --> Prosperity: Median household income (US Dollars/Year)
	public void ClickonProsperity_MedianIncome() {

		log.info("ClickonProsperity_MedianIncome method started here.....");

		// driver.switchTo().frame("datainput-widget");
		try {
			waithelper.WaitForElementVisibleWithPollingTime(ProsperityMedianIncome,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();

		}
		ProsperityMedianIncome.click();
		CommonMethod.waitUntilLoadElement();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By
						.xpath("(//*[contains(text(),\"Prosperity: Median household income (US Dollars/Year)\")])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickonProsperity_MedianIncome method ends here.....");

	}

	// This method will click on Quality of Life --> Equitability: Median gross rent
	// as (%) of household income
	public void ClickonEquitability_MedianGrossIncome() {

		log.info("ClickonEquitability_MedianGrossIncome method started here.....");

		// driver.switchTo().frame("datainput-widget");
		try {
			waithelper.WaitForElementVisibleWithPollingTime(Equitability_MedianGrossIncome,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();

		}
		Equitability_MedianGrossIncome.click();
		CommonMethod.waitUntilLoadElement();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath(
						"(//*[contains(text(),\"Equitability: Median gross rent as (%) of household income\")])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickonEquitability_MedianGrossIncome method ends here.....");

	}

	// This method will click on Quality of Life --> Prosperity: Unemployment rate
	// (%) of household income
	public void ClickonProsperityUnemployementRate() {

		log.info("ClickonProsperityUnemployementRate method started here.....");

		// driver.switchTo().frame("datainput-widget");
		try {
			waithelper.WaitForElementVisibleWithPollingTime(ProsperityUnemployementRate,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();

		}
		ProsperityUnemployementRate.click();
		CommonMethod.waitUntilLoadElement();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//*[contains(text(),\"Prosperity: Unemployment rate (%)\")])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickonProsperityUnemployementRate method ends here.....");

	}

	// This method will click on Quality of Life --> Health & Safety: Air quality
	// days unhealthy for sensitive groups (Days/yr)
	public void ClickonHealthAndSafetySensitiveGroup() {

		log.info("ClickonHealthAndSafetySensitiveGroup method started here.....");

		// driver.switchTo().frame("datainput-widget");
		try {
			waithelper.WaitForElementVisibleWithPollingTime(HealthAndSafetySensitiveGroup,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();

		}
		HealthAndSafetySensitiveGroup.click();
		CommonMethod.waitUntilLoadElement();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath(
				"(//*[contains(text(),\"Health & Safety: Air quality days unhealthy for sensitive groups (Days/yr)\")])[3]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickonHealthAndSafetySensitiveGroup method ends here.....");

	}

	// This method will click on Quality of Life --> Health & Safety: Violent Crime
	// (per year per capita)
	public void ClickonHealthAndSafetyVoilentCrime() {

		log.info("ClickonHealthAndSafetyVoilentCrime method started here.....");

		// driver.switchTo().frame("datainput-widget");
		try {
			waithelper.WaitForElementVisibleWithPollingTime(HealthAndSafetyVoilentCrime,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();

		}
		HealthAndSafetyVoilentCrime.click();
		CommonMethod.waitUntilLoadElement();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By
						.xpath("(//*[contains(text(),\"Health & Safety: Violent Crime (per year per capita)\")])[3]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickonHealthAndSafetyVoilentCrime method ends here.....");

	}

	// This method will click on Additional Data --> Data
	public void ClickonAdditionalData() {

		log.info("ClickonAdditionalData method started here.....");

		try {
			waithelper.WaitForElementVisibleWithPollingTime(AdditionalData,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();

		}
		AdditionalData.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//*[contains(text(),'Additional Data')])[3]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickonAdditionalData method ends here.....");

	}

	// This method will click on Water --> Water Consumption
	public void ClickonWaterConsumption() {
		log.info("ClickonWaterConsumption method started .............");

		// driver.switchTo().frame("datainput-widget");
		waithelper.WaitForElementVisibleWithPollingTime(WaterConsumption,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		WaterConsumption.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//*[contains(text(),'Water consumption')])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickonWaterConsumption method ends .............");
	}

	// This method will click on Waste --> Municipal solid waste generation
	// intensity
	public void ClickonMunicipalSolidwastegeneration() {
		log.info("ClickonMunicipalSolidwastegeneration method started .............");

		// driver.switchTo().frame("datainput-widget");
		waithelper.WaitForElementVisibleWithPollingTime(Waste_Solid_Generation,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Waste_Solid_Generation.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//*[contains(text(),'Municipal solid waste generation intensity')])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickonMunicipalSolidwastegeneration method ends .............");
	}

	// This method will click on Waste --> Municipal solid waste Diversion
	public void ClickonMunicipalSolidWasteDiversion() {
		log.info("ClickonMunicipalSolidWasteDiversion method started .............");

		// driver.switchTo().frame("datainput-widget");
		waithelper.WaitForElementVisibleWithPollingTime(Waste_Solid_Diversion,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Waste_Solid_Diversion.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(
						By.xpath("(//*[contains(text(),'Municipal solid waste diversion rate from landfill')])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickonMunicipalSolidWasteDiversion method ends .............");
	}

	public void getCityProjectID() {
		try {
			ManageMenu.click();
			ngWebDriver.waitForAngularRequestsToFinish();
			ProjectSubmenu.click();
			ngWebDriver.waitForAngularRequestsToFinish();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//span[@class='fw-semi-bold' and text()='Project']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void ClickonProjectInManage() {
		try {

			ManageMenu.click();
			ngWebDriver.waitForAngularRequestsToFinish();
			ProjectSubmenu.click();
			ngWebDriver.waitForAngularRequestsToFinish();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//span[@class='fw-semi-bold' and text()='Project']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void ClickonCertifications() {
		try {

			CertificationsMenu.click();
			CommonMethod.waitUntilLoadElement();
			ngWebDriver.waitForAngularRequestsToFinish();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//span[@class='fw-semi-bold' and text()='Certifications']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void ClickonTeamInManage() {
		log.info("ClickonTeamInManage method starts here ....");
		;
		ManageMenu.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		TeamSubmenu.click();
		CommonMethod.waitUntilLoadElement();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.waitForElement(driver.findElement(By.xpath("//span[text()='Team']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickonTeamInManage method ends here ....");
	}

	public boolean checkCityProjectCreation(String PName) {

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

	// This method will return the energy score

	public int getEnergyScore() {

		log.info("getEnergyScore method starts here........");

		int score = Integer.parseInt(EnergyScore.getText());
		log.info("Energy Score is -----" + score);
		log.info("getEnergyScore method ends here........");
		return score;

	}

	// This method will return the Transportation score

	public int getTransportScore() {

		log.info("getTransportScore method starts here........");

		int score = Integer.parseInt(TransportScore.getText());
		log.info("Transport Score is -----" + score);
		log.info("getTransportScore method ends here........");
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

	// This method will return the Water score

	public int getWaterScore() {

		log.info("getWaterScore method starts here........");
		int score = Integer.parseInt(WaterScore.getText());
		log.info("Water Score is -----" + score);
		log.info("getWaterScore method ends here........");
		return score;

	}

	// This method will return the Quality Of Life score
	public int getQualityOfLifeScore() {

		log.info("getQualityOfLifeScore method starts here........");
		int score = Integer.parseInt(QualityScore.getText());
		log.info("Quality Of Life Score is -----" + score);
		log.info("getQualityOfLifeScore method ends here........");
		return score;

	}

	public boolean checkUnitTypeInProjectAreaUnderDataInput(String UnitType) {

		boolean flag = false;
		waithelper.WaitForElementClickable(ProjectAreaTab, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(ProjectAreaTab);
		ngWebDriver.waitForAngularRequestsToFinish();
		// ProjectAreaTab.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//*[@class='meter_info_heading']/parent::div/button/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String UnitSelected = driver.findElement(By.xpath("//*[@class='meter_info_heading']/parent::div/button/span"))
				.getText();
		if (UnitSelected.contains(UnitType))
			flag = true;
		return flag;

	}

	public boolean checkPopulation_AddRow_Header_Display() {

		boolean flag = false;
		try {
			// PopulationTab.click();
			Thread.sleep(3000);
			waithelper.WaitForElementClickable(ProjectSettingAddRowButton,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			ProjectSettingAddRowButton.click();
			ngWebDriver.waitForAngularRequestsToFinish();

			if (PopulationEffectiveYearHeading.getText().equals("EFFECTIVE YEAR")
					&& Population_populationHeading.getText().equals("POPULATION")
					&& Population_UpdatedByHeading.getText().equals("UPDATED BY")
					&& Population_SaveButton.isDisplayed() == true && Population_DeleteButton.isDisplayed() == true) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}

	// This method will add comment and check in activity section DI - > Project
	// Setting - > Population Tab and check it in Activity
	public boolean checkPopulationCommentAndActivity(String comment, String uname) {
		log.info("checkPopulationCommentAndActivity  starts here........");
		boolean Commentflag = false;
		waithelper.WaitForElementClickable(Population_CommentTextBox,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Population_CommentTextBox.sendKeys(comment);
		waithelper.WaitForElementClickable(Population_PostButton, Integer.parseInt(prop.getProperty("explicitTime")),
				2);
		JSHelper.clickElement(Population_PostButton);
		ngWebDriver.waitForAngularRequestsToFinish();
		// Population_PostButton.click();
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
		waithelper.WaitForElementClickable(Population_ActivityButton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Population_ActivityButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ActivityDate = driver.findElement(By.xpath("//table[@class='mb10 ng-scope']/thead/tr/th[1]/p"))
				.getText();
		String ActivityTime = driver.findElement(By.xpath("//table[@class='mb10 ng-scope']/tbody/tr/td[1]/span"))
				.getText().toLowerCase();
		String ActivtyComment = driver.findElement(By.xpath("//table[@class='mb10 ng-scope']/tbody/tr/td[2]/p"))
				.getText();

		String ExpComment = uname + " commented in Population";

		log.info("Displayed Activity Date is ---" + ActivityDate);
		log.info("Displayed Activity Time is ---" + ActivityTime);
		log.info("Displayed Activity comment is ---" + ActivtyComment);
		log.info("Expected Activity Time is ---" + currentTime);
		log.info("Expected Activity Date is ---" + strDate);
		log.info("Expected Activity Comment is ---" + ExpComment);
		if (Commentflag && (ActivityDate.equals(strDate)) && (ActivityTime.equals(currentTime))
				&& (ActivtyComment.equals(ExpComment))) {
			log.info("checkPopulationCommentAndActivity  ends here........");
			return true;
		} else {
			log.info("checkPopulationCommentAndActivity  ends here........");
			return false;
		}

	}

	// This method will add comment and check in activity section DI - > Energy
	// - > GHS Emission Tab and check it in Activity
	public boolean checkEnergyCommentAndActivity(String comment, String uname) {
		log.info("checkEnergyCommentAndActivity  starts here........");
		boolean Commentflag = false;
		JSHelper.clickElement(GHGEmission_DetailsTab);
		ngWebDriver.waitForAngularRequestsToFinish();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(Energy_CommentTextBox, Integer.parseInt(prop.getProperty("explicitTime")),
				2);
		Energy_CommentTextBox.sendKeys(comment);
		waithelper.WaitForElementClickable(Energy_PostButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		// Energy_PostButton.click();
		JSHelper.clickElement(Energy_PostButton);
		ngWebDriver.waitForAngularRequestsToFinish();
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

		// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("(//p[text()='"
		// + comment + "'])[1]")), Integer.parseInt(prop.getProperty("explicitTime")),
		// 2);
		String xp = "(//p[text()='" + comment + "'])[2]";
		Commentflag = driver.findElement(By.xpath(xp)).isDisplayed();
		// log.info("Commentenabled flag --"+
		// driver.findElement(By.xpath(xp)).isEnabled());
		log.info("Comment displayed flag --" + Commentflag);
		waithelper.WaitForElementClickable(Energy_ActivityButton, Integer.parseInt(prop.getProperty("explicitTime")),
				2);
		Energy_ActivityButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ActivityDate = driver.findElement(By.xpath("(//table[@class='mb20 ng-scope'])[2]/thead/tr/th/p"))
				.getText();
		String ActivityTime = driver
				.findElement(By.xpath("(//table[@class='mb20 ng-scope']/tbody[1]/tr/td[1]/span)[2]")).getText()
				.toLowerCase();
		String ActivityComment = driver.findElement(By.xpath(
				"(//td[@class='vtop']/span[text()='" + ActivityTime + "'])[2]/parent::td/following-sibling::td/p"))
				.getText();

		String ExpComment = uname + " commented in Ghg Emissions";

		log.info("Displayed Activity Date is ---" + ActivityDate);
		log.info("Displayed Activity Time is ---" + ActivityTime);
		log.info("Displayed Activity comment is ---" + ActivityComment);
		log.info("Expected Activity Time is ---" + currentTime);
		log.info("Expected Activity Date is ---" + strDate);
		log.info("Expected Activity Comment is ---" + ExpComment);

		if (Commentflag && (ActivityDate.equals(strDate)) && (ActivityTime.equals(currentTime))
				&& (ActivityComment.equals(ExpComment))) {
			log.info("Comments and activity showing proper");
			log.info("checkEnergyCommentAndActivity  ends here........");
			return true;
		} else {
			log.info("Comments and activity not showing proper");
			log.info("checkEnergyCommentAndActivity  ends here........");
			return false;
		}

	}

	// This method will add comment and check in activity section DI - >
	// Transportation
	// - > VMT - Details Tab and check it in Activity
	public boolean checkTransportCommentAndActivity(String comment, String uname) {
		log.info("checkTransportCommentAndActivity  starts here........");
		boolean Commentflag = false;
		JSHelper.clickElement(VMT_DetailsTab);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(VMT_CommentTextBox, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		VMT_CommentTextBox.sendKeys(comment);
		waithelper.WaitForElementClickable(VMT_PostButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		// Energy_PostButton.click();
		JSHelper.clickElement(VMT_PostButton);
		ngWebDriver.waitForAngularRequestsToFinish();
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

		// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("(//p[text()='"
		// + comment + "'])[1]")), Integer.parseInt(prop.getProperty("explicitTime")),
		// 2);
		String xp = "(//p[text()='" + comment + "'])[2]";
		Commentflag = driver.findElement(By.xpath(xp)).isDisplayed();
		// log.info("Commentenabled flag --"+
		// driver.findElement(By.xpath(xp)).isEnabled());
		log.info("Comment displayed flag --" + Commentflag);
		waithelper.WaitForElementClickable(VMT_ActivityButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		VMT_ActivityButton.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ActivityDate = driver.findElement(By.xpath("(//table[@class='mb20 ng-scope'])[2]/thead/tr/th/p"))
				.getText();
		String ActivityTime = driver
				.findElement(By.xpath("(//table[@class='mb20 ng-scope']/tbody[1]/tr/td[1]/span)[2]")).getText()
				.toLowerCase();
		String ActivityComment = driver.findElement(By.xpath(
				"(//td[@class='vtop']/span[text()='" + ActivityTime + "'])[2]/parent::td/following-sibling::td/p"))
				.getText();

		String ExpComment = uname + " commented in Transportation";

		log.info("Displayed Activity Date is ---" + ActivityDate);
		log.info("Displayed Activity Time is ---" + ActivityTime);
		log.info("Displayed Activity comment is ---" + ActivityComment);
		log.info("Expected Activity Time is ---" + currentTime);
		log.info("Expected Activity Date is ---" + strDate);
		log.info("Expected Activity Comment is ---" + ExpComment);

		if (Commentflag && (ActivityDate.equals(strDate)) && (ActivityTime.equals(currentTime))
				&& (ActivityComment.equals(ExpComment))) {
			log.info("Comments and activity showing proper");
			log.info("checkTransportCommentAndActivity  ends here........");
			return true;
		} else {
			log.info("Comments and activity not showing proper");
			log.info("checkTransportCommentAndActivity  ends here........");
			return false;
		}

	}

	// This method will add comment and check in activity section Quality Of Life-->
	// Prosperity: Unemployment rate (%)
	// - Details Tab and check it in Activity
	public boolean checkProsperityUnemployementRate(String comment, String uname) {
		log.info("checkProsperityUnemployementRate  starts here........");
		boolean Commentflag = false;
		JSHelper.clickElement(ProsperityUnemployementRate_DetailsTab);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(ProsperityUnemployementRate_CommentTextBox,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ProsperityUnemployementRate_CommentTextBox.sendKeys(comment);
		waithelper.WaitForElementClickable(ProsperityUnemployementRate_PostButton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		// Energy_PostButton.click();
		JSHelper.clickElement(ProsperityUnemployementRate_PostButton);

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

		// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("(//p[text()='"
		// + comment + "'])[1]")), Integer.parseInt(prop.getProperty("explicitTime")),
		// 2);
		String xp = "(//p[text()='" + comment + "'])[2]";
		Commentflag = driver.findElement(By.xpath(xp)).isDisplayed();
		// log.info("Commentenabled flag --"+
		// driver.findElement(By.xpath(xp)).isEnabled());
		log.info("Comment displayed flag --" + Commentflag);
		waithelper.WaitForElementClickable(ProsperityUnemployementRate_ActivityButton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ProsperityUnemployementRate_ActivityButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ActivityDate = driver.findElement(By.xpath("(//table[@class='mb20 ng-scope'])[2]/thead/tr/th/p"))
				.getText();
		String ActivityTime = driver
				.findElement(By.xpath("(//table[@class='mb20 ng-scope']/tbody[1]/tr/td[1]/span)[2]")).getText()
				.toLowerCase();
		String ActivityComment = driver.findElement(By.xpath(
				"(//td[@class='vtop']/span[text()='" + ActivityTime + "'])[2]/parent::td/following-sibling::td/p"))
				.getText();

		String ExpComment = uname + " commented in Transportation";

		log.info("Displayed Activity Date is ---" + ActivityDate);
		log.info("Displayed Activity Time is ---" + ActivityTime);
		log.info("Displayed Activity comment is ---" + ActivityComment);
		log.info("Expected Activity Time is ---" + currentTime);
		log.info("Expected Activity Date is ---" + strDate);
		log.info("Expected Activity Comment is ---" + ExpComment);

		if (Commentflag && (ActivityDate.equals(strDate)) && (ActivityTime.equals(currentTime))
				&& (ActivityComment.equals(ExpComment))) {
			log.info("Comments and activity showing proper");
			log.info("checkProsperityUnemployementRate  ends here........");
			return true;
		} else {
			log.info("Comments and activity not showing proper");
			log.info("checkProsperityUnemployementRate  ends here........");
			return false;
		}

	}

	// This method will add comment and check in activity section Quality Of Life-->
	// Health & Safety: Air quality days unhealthy for sensitive groups (Days/yr)
	// - Details Tab and check it in Activity
	public boolean checkHealthAndSafetySensitiveGroup(String comment, String uname) {
		log.info("checkHealthAndSafetySensitiveGroup  starts here........");
		boolean Commentflag = false;
		JSHelper.clickElement(HealthAndSafetySensitiveGroup_DetailsTab);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(HealthAndSafetySensitiveGroup_CommentTextBox,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		HealthAndSafetySensitiveGroup_CommentTextBox.sendKeys(comment);
		waithelper.WaitForElementClickable(HealthAndSafetySensitiveGroup_PostButton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		// Energy_PostButton.click();
		JSHelper.clickElement(HealthAndSafetySensitiveGroup_PostButton);

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

		// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("(//p[text()='"
		// + comment + "'])[1]")), Integer.parseInt(prop.getProperty("explicitTime")),
		// 2);
		String xp = "(//p[text()='" + comment + "'])[2]";
		Commentflag = driver.findElement(By.xpath(xp)).isDisplayed();
		// log.info("Commentenabled flag --"+
		// driver.findElement(By.xpath(xp)).isEnabled());
		log.info("Comment displayed flag --" + Commentflag);
		waithelper.WaitForElementClickable(HealthAndSafetySensitiveGroup_ActivityButton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		HealthAndSafetySensitiveGroup_ActivityButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ActivityDate = driver.findElement(By.xpath("(//table[@class='mb20 ng-scope'])[2]/thead/tr/th/p"))
				.getText();
		String ActivityTime = driver
				.findElement(By.xpath("(//table[@class='mb20 ng-scope']/tbody[1]/tr/td[1]/span)[2]")).getText()
				.toLowerCase();
		String ActivityComment = driver.findElement(By.xpath(
				"(//td[@class='vtop']/span[text()='" + ActivityTime + "'])[2]/parent::td/following-sibling::td/p"))
				.getText();

		String ExpComment = uname + " commented in Transportation";

		log.info("Displayed Activity Date is ---" + ActivityDate);
		log.info("Displayed Activity Time is ---" + ActivityTime);
		log.info("Displayed Activity comment is ---" + ActivityComment);
		log.info("Expected Activity Time is ---" + currentTime);
		log.info("Expected Activity Date is ---" + strDate);
		log.info("Expected Activity Comment is ---" + ExpComment);

		if (Commentflag && (ActivityDate.equals(strDate)) && (ActivityTime.equals(currentTime))
				&& (ActivityComment.equals(ExpComment))) {
			log.info("Comments and activity showing proper");
			log.info("checkHealthAndSafetySensitiveGroup  ends here........");
			return true;
		} else {
			log.info("Comments and activity not showing proper");
			log.info("checkHealthAndSafetySensitiveGroup  ends here........");
			return false;
		}

	}

	// This method will add comment and check in activity section Quality Of Life-->
	// Health & Safety: Violent Crime (per year per capita)
	// - Details Tab and check it in Activity
	public boolean checkHealthAndSafetyVoilentCrime(String comment, String uname) {
		log.info("checkHealthAndSafetyVoilentCrime  starts here........");
		boolean Commentflag = false;
		JSHelper.clickElement(HealthAndSafetyVoilentCrime_DetailsTab);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(HealthAndSafetyVoilentCrime_CommentTextBox,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		HealthAndSafetyVoilentCrime_CommentTextBox.sendKeys(comment);
		waithelper.WaitForElementClickable(HealthAndSafetyVoilentCrime_PostButton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		// Energy_PostButton.click();
		JSHelper.clickElement(HealthAndSafetyVoilentCrime_PostButton);

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

		// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("(//p[text()='"
		// + comment + "'])[1]")), Integer.parseInt(prop.getProperty("explicitTime")),
		// 2);
		String xp = "(//p[text()='" + comment + "'])[2]";
		Commentflag = driver.findElement(By.xpath(xp)).isDisplayed();
		// log.info("Commentenabled flag --"+
		// driver.findElement(By.xpath(xp)).isEnabled());
		log.info("Comment displayed flag --" + Commentflag);
		waithelper.WaitForElementClickable(HealthAndSafetyVoilentCrime_ActivityButton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		HealthAndSafetyVoilentCrime_ActivityButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ActivityDate = driver.findElement(By.xpath("(//table[@class='mb20 ng-scope'])[2]/thead/tr/th/p"))
				.getText();
		String ActivityTime = driver
				.findElement(By.xpath("(//table[@class='mb20 ng-scope']/tbody[1]/tr/td[1]/span)[2]")).getText()
				.toLowerCase();
		String ActivityComment = driver.findElement(By.xpath(
				"(//td[@class='vtop']/span[text()='" + ActivityTime + "'])[2]/parent::td/following-sibling::td/p"))
				.getText();

		String ExpComment = uname + " commented in Transportation";

		log.info("Displayed Activity Date is ---" + ActivityDate);
		log.info("Displayed Activity Time is ---" + ActivityTime);
		log.info("Displayed Activity comment is ---" + ActivityComment);
		log.info("Expected Activity Time is ---" + currentTime);
		log.info("Expected Activity Date is ---" + strDate);
		log.info("Expected Activity Comment is ---" + ExpComment);

		if (Commentflag && (ActivityDate.equals(strDate)) && (ActivityTime.equals(currentTime))
				&& (ActivityComment.equals(ExpComment))) {
			log.info("Comments and activity showing proper");
			log.info("checkHealthAndSafetyVoilentCrime  ends here........");
			return true;
		} else {
			log.info("Comments and activity not showing proper");
			log.info("checkHealthAndSafetyVoilentCrime  ends here........");
			return false;
		}

	}

	// This method will add record for each items of Additional Data Dropdown box

	public boolean checkAdditionalData_SaveRecords() {
		log.info("checkAdditionalData_SaveRecords  starts here........");
		boolean flag = false;
		List<String> ItemList = new ArrayList<>();
		JSHelper.clickElement(AdditionalData);
		List<WebElement> AdditionalItems = driver
				.findElements(By.xpath("//*[@class='water_unit add_item ng-scope']/span"));
		log.info("Total number of items is ---" + AdditionalItems.size());
		int row = 1;
		int value = 100;
		int unit = 100;
		String UnitValue = "Unit" + unit;
		for (WebElement ele : AdditionalItems) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// js.executeScript("window.scrollBy(0,-400);");
			if (row > 5) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JSHelper.scrollIntoView(driver.findElement(By.xpath("(//*[contains(text(),'Additional Data')])[3]")));
			}
			log.info("Goint to add record number -- " + row);
			driver.findElement(By.xpath("//*[@id='addtional_data']")).click();
			ele.click();
			String itemname = driver.findElement(By.xpath("//*[@id='addtional_data']/span")).getText();
			// log.info(itemname);
			ItemList.add(itemname);

			waithelper.WaitForElementClickable(Additional_Data_AddYearBtn,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Additional_Data_AddYearBtn.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			log.info("Row number is --" + row);
			int Selected_Year = Integer.parseInt(driver
					.findElement(By.xpath("//table[@class='table arcTbl cityTable']/tbody/tr[" + row + "]/td[1]/input"))
					.getAttribute("value"));
			log.info("Selected Year is ---" + Selected_Year);
			if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
				driver.findElement(
						By.xpath("//table[@class='table arcTbl cityTable']/tbody/tr[" + row + "]/td[3]/input"))
						.sendKeys(Integer.toString(value));
				driver.findElement(
						By.xpath("//table[@class='table arcTbl cityTable']/tbody/tr[" + row + "]/td[4]/input"))
						.sendKeys(UnitValue);
				driver.findElement(
						By.xpath("//table[@class='table arcTbl cityTable']/tbody/tr[" + row + "]/td[5]/button"))
						.click();
				try {
					waithelper.WaitForElementInvisible(
							driver.findElement(By.xpath(
									"//table[@class='table arcTbl cityTable']/tbody/tr[" + row + "]/td[6]/div/*")),
							Integer.parseInt(prop.getProperty("explicitTime")), 2);
				} catch (Exception e) {
					log.info("Loading symbol is not showing...........");
					e.printStackTrace();
					e.getMessage();
				}
				flag = driver.findElement(By
						.xpath("//table[@class='table arcTbl cityTable']/tbody/tr[1]/td[5]/button/span[text()='Edit']"))
						.isDisplayed();
				if (flag) {
					log.info("Record added for --" + itemname);
				} else {
					log.info("Unable to add Record for --" + itemname);
				}

			}
			row++;
			value = value + 1;
			unit = unit + 1;
			UnitValue = "Unit" + unit;
		}

		/*
		 * for(String s:ItemList) { log.info(s); }
		 */

		if (flag) {
			log.info("Comments and activity showing proper");
			log.info("checkAdditionalData_SaveRecords  ends here........");
			return true;
		} else {
			log.info("Comments and activity not showing proper");
			log.info("checkAdditionalData_SaveRecords  ends here........");
			return false;
		}

	}

	// This method will add comment and check in activity section DI - >Quality Of
	// Life--> Health And Safety
	// - Details Tab and check it in Activity
	public boolean checkHealthAndSafetyCommentAndActivity(String comment, String uname) {
		log.info("checkHealthAndSafetyCommentAndActivity  starts here........");
		boolean Commentflag = false;
		JSHelper.clickElement(HealthAndSafety_DetailsTab);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(HealthAndSafety_CommentTextBox,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		HealthAndSafety_CommentTextBox.sendKeys(comment);
		waithelper.WaitForElementClickable(HealthAndSafety_PostButton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		// Energy_PostButton.click();
		JSHelper.clickElement(HealthAndSafety_PostButton);

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

		// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("(//p[text()='"
		// + comment + "'])[1]")), Integer.parseInt(prop.getProperty("explicitTime")),
		// 2);
		String xp = "(//p[text()='" + comment + "'])[2]";
		Commentflag = driver.findElement(By.xpath(xp)).isDisplayed();
		// log.info("Commentenabled flag --"+
		// driver.findElement(By.xpath(xp)).isEnabled());
		log.info("Comment displayed flag --" + Commentflag);
		waithelper.WaitForElementClickable(HealthAndSafety_ActivityButton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		HealthAndSafety_ActivityButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ActivityDate = driver.findElement(By.xpath("(//table[@class='mb20 ng-scope'])[2]/thead/tr/th/p"))
				.getText();
		String ActivityTime = driver
				.findElement(By.xpath("(//table[@class='mb20 ng-scope']/tbody[1]/tr/td[1]/span)[2]")).getText()
				.toLowerCase();
		String ActivityComment = driver.findElement(By.xpath(
				"(//td[@class='vtop']/span[text()='" + ActivityTime + "'])[2]/parent::td/following-sibling::td/p"))
				.getText();

		String ExpComment = uname + " commented in Transportation";

		log.info("Displayed Activity Date is ---" + ActivityDate);
		log.info("Displayed Activity Time is ---" + ActivityTime);
		log.info("Displayed Activity comment is ---" + ActivityComment);
		log.info("Expected Activity Time is ---" + currentTime);
		log.info("Expected Activity Date is ---" + strDate);
		log.info("Expected Activity Comment is ---" + ExpComment);

		if (Commentflag && (ActivityDate.equals(strDate)) && (ActivityTime.equals(currentTime))
				&& (ActivityComment.equals(ExpComment))) {
			log.info("Comments and activity showing proper");
			log.info("checkHealthAndSafetyCommentAndActivity  ends here........");
			return true;
		} else {
			log.info("Comments and activity not showing proper");
			log.info("checkHealthAndSafetyCommentAndActivity  ends here........");
			return false;
		}

	}

	// This method will add comment and check in activity section DI - > Water
	// - > Water Consumption Tab and check it in Activity
	public boolean checkWaterCommentAndActivity(String comment, String uname) {
		log.info("checkWaterCommentAndActivity  starts here........");
		boolean Commentflag = false;
		JSHelper.clickElement(WaterConsum_DetailsTab);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(Water_CommentTextBox, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Water_CommentTextBox.sendKeys(comment);
		waithelper.WaitForElementClickable(Water_PostButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Water_PostButton.click();
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

		Commentflag = driver.findElement(By.xpath("(//p[text()='" + comment + "'])[2]")).isDisplayed();
		log.info("Comment displays in comment tab is ----" + Commentflag);
		waithelper.WaitForElementClickable(Water_ActivityButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Water_ActivityButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ActivityDate = driver.findElement(By.xpath("(//table[@class='mb20 ng-scope']/thead/tr/th[1]/p)[2]"))
				.getText();
		String ActivityTime = driver
				.findElement(By.xpath("(//table[@class='mb20 ng-scope']/tbody[1]/tr/td[1]/span)[2]")).getText()
				.toLowerCase();
		// String ActivtyComment = driver.findElement(By.xpath("//table[@class='mb20
		// ng-scope']/tbody/tr/td[2]/p")).getText();

		String ExpComment = uname + " commented in Water Consumption";
		// boolean ActivityTime =
		// driver.findElement(By.xpath("(//td[@class='vtop']/span[text()='"+currentTime+"'])[2]")).isDisplayed();
		String ActivityComment = driver.findElement(By.xpath(
				"(//td[@class='vtop']/span[text()='" + ActivityTime + "'])[2]/parent::td/following-sibling::td/p"))
				.getText();

		log.info("Displayed Activity Date is ---" + ActivityDate);
		log.info("Displayed Activity Time is ---" + ActivityTime);
		log.info("Displayed Activity comment is ---" + ActivityComment);
		log.info("Expected Activity Time is ---" + currentTime);
		log.info("Expected Activity Date is ---" + strDate);
		log.info("Expected Activity Comment is ---" + ExpComment);

		if (Commentflag && (ActivityDate.equals(strDate)) && (ActivityTime.equals(currentTime))
				&& (ActivityComment.equals(ExpComment))) {
			log.info("Comments and activity showing proper");
			log.info("checkWaterCommentAndActivity  ends here........");
			return true;
		} else {
			log.info("Comments and activity not showing proper");
			log.info("checkWaterCommentAndActivity  ends here........");
			return false;
		}

	}

	// This method will add comment and check in activity section DI - > Waste
	// - > Municipal solid waste generation intensity and check it in Activity
	public boolean checkWasteGenerationCommentAndActivity(String comment, String uname) {
		log.info("checkWasteGenerationCommentAndActivity  starts here........");
		boolean Commentflag = false;
		JSHelper.clickElement(WasteGen_DetailsTab);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(Waste_Gen_CommentTextBox, Integer.parseInt(prop.getProperty("explicitTime")),
				2);
		Waste_Gen_CommentTextBox.sendKeys(comment);
		waithelper.WaitForElementClickable(Waste_Gen_PostButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Waste_Gen_PostButton.click();
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

		Commentflag = driver.findElement(By.xpath("(//p[text()='" + comment + "'])[2]")).isDisplayed();
		waithelper.WaitForElementClickable(Waste_Gen_ActivityButton, Integer.parseInt(prop.getProperty("explicitTime")),
				2);
		Waste_Gen_ActivityButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ExpComment = uname + " commented in Waste Data";
		String ActivityDate = driver.findElement(By.xpath("(//table[@class='mb20 ng-scope']/thead/tr/th[1]/p)[2]"))
				.getText();
		String ActivityTime = driver
				.findElement(By.xpath("(//table[@class='mb20 ng-scope']/tbody[1]/tr/td[1]/span)[2]")).getText()
				.toLowerCase();
		// String ActivtyComment = driver.findElement(By.xpath("(//table[@class='mb20
		// ng-scope']/tbody/tr/td[2]/p)[2]")).getText();

		// boolean ActivityTime =
		// driver.findElement(By.xpath("(//td[@class='vtop']/span[text()='"+currentTime+"'])[2]")).isDisplayed();
		String ActivityComment = driver.findElement(By.xpath(
				"(//td[@class='vtop']/span[text()='" + ActivityTime + "'])[2]/parent::td/following-sibling::td/p"))
				.getText();

		log.info("Displayed Activity Date is ---" + ActivityDate);
		log.info("Displayed Activity Time is ---" + ActivityTime);
		log.info("Displayed Activity comment is ---" + ActivityComment);
		log.info("Expected Activity Time is ---" + currentTime);
		log.info("Expected Activity Date is ---" + strDate);
		log.info("Expected Activity Comment is ---" + ExpComment);

		if (Commentflag && (ActivityDate.equals(strDate)) && (ActivityTime.equals(currentTime))
				&& (ActivityComment.equals(ExpComment))) {
			log.info("checkWasteGenerationCommentAndActivity  ends here........");
			return true;
		} else {
			log.info("checkWasteGenerationCommentAndActivity  ends here........");
			return false;
		}

	}

	// This method will add comment and check in activity section DI - > Waste
	// - > Municipal solid waste diversion rate from landfill and check it in
	// Activity
	public boolean checkWasteDiversionCommentAndActivity(String comment, String uname) {
		log.info("checkWasteDiversionCommentAndActivity  starts here........");
		boolean Commentflag = false;
		JSHelper.clickElement(WasteDiv_DetailsTab);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(Waste_Div_CommentTextBox, Integer.parseInt(prop.getProperty("explicitTime")),
				2);
		Waste_Div_CommentTextBox.sendKeys(comment);
		waithelper.WaitForElementClickable(Waste_Div_PostButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Waste_Div_PostButton.click();
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

		Commentflag = driver.findElement(By.xpath("(//p[text()='" + comment + "'])[2]")).isDisplayed();
		waithelper.WaitForElementClickable(Waste_Div_ActivityButton, Integer.parseInt(prop.getProperty("explicitTime")),
				2);
		Waste_Div_ActivityButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ExpComment = uname + " commented in Waste Data";
		String ActivityDate = driver.findElement(By.xpath("(//table[@class='mb20 ng-scope']/thead/tr/th[1]/p)[2]"))
				.getText();
		String ActivityTime = driver
				.findElement(By.xpath("(//table[@class='mb20 ng-scope']/tbody[1]/tr/td[1]/span)[2]")).getText()
				.toLowerCase();
		// String ActivtyComment = driver.findElement(By.xpath("//table[@class='mb20
		// ng-scope']/tbody/tr/td[2]/p")).getText();

		// boolean ActivityTime =
		// driver.findElement(By.xpath("(//td[@class='vtop']/span[text()='"+currentTime+"'])[2]")).isDisplayed();
		String ActivityComment = driver.findElement(By.xpath(
				"(//td[@class='vtop']/span[text()='" + ActivityTime + "'])[2]/parent::td/following-sibling::td/p"))
				.getText();

		log.info("Displayed Activity Date is ---" + ActivityDate);
		log.info("Displayed Activity Time is ---" + ActivityTime);
		log.info("Displayed Activity comment is ---" + ActivityComment);
		log.info("Expected Activity Time is ---" + currentTime);
		log.info("Expected Activity Date is ---" + strDate);
		log.info("Expected Activity Comment is ---" + ExpComment);

		if (Commentflag && (ActivityDate.equals(strDate)) && (ActivityTime.equals(currentTime))
				&& (ActivityComment.equals(ExpComment))) {
			log.info("checkWasteDiversionCommentAndActivity  ends here........");
			return true;
		} else {
			log.info("checkWasteDiversionCommentAndActivity  ends here........");
			return false;
		}

	}

	// This method will add comment and check in activity section DI - > Project
	// Setting - > Project Area Tab and check it in Activity
	public boolean checkProjectAreaCommentAndActivity(String comment, String uname) {
		log.info("checkProjectAreaCommentAndActivity  starts here........");
		boolean Commentflag = false;
		waithelper.WaitForElementClickable(ProjectAreaTab, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(ProjectAreaTab);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//*[contains(text(),'PROJECT AREA')]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ProjectArea_CommentTextBox.sendKeys(comment);
		waithelper.WaitForElementClickable(ProjectArea_PostButton, Integer.parseInt(prop.getProperty("explicitTime")),
				2);
		ProjectArea_PostButton.click();
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
		ProjectArea_ActivityButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ActivityDate = driver.findElement(By.xpath("//table[@class='mb10 ng-scope']/thead/tr/th[1]/p"))
				.getText();
		String ActivityTime = driver.findElement(By.xpath("//table[@class='mb10 ng-scope']/tbody/tr/td[1]/span"))
				.getText().toLowerCase();
		String ActivtyComment = driver.findElement(By.xpath("//table[@class='mb10 ng-scope']/tbody/tr/td[2]/p"))
				.getText();

		String ExpComment = uname + " commented in Project Area";

		// Activityflag = driver.findElement(By.xpath("(//p[text()='" + uname + "
		// commented in Population'])[1]")).isDisplayed();

		log.info("Displayed Activity Date is ---" + ActivityDate);
		log.info("Displayed Activity Time is ---" + ActivityTime);
		log.info("Displayed Activity comment is ---" + ActivtyComment);
		log.info("Expected Activity Time is ---" + currentTime);
		log.info("Expected Activity Date is ---" + strDate);
		log.info("Expected Activity Comment is ---" + ExpComment);

		if (Commentflag && (ActivityDate.equals(strDate)) && (ActivityTime.equals(currentTime))
				&& (ActivtyComment.equals(ExpComment))) {
			log.info("checkProjectAreaCommentAndActivity  ends here........");
			return true;
		} else {
			log.info("checkProjectAreaCommentAndActivity  ends here........");
			return false;
		}

	}

	// This method will add one row in DI - > Project Setting - > Project Area and
	// checks the Header
	public boolean checkProjectArea_AddRow_Header_Display() {
		log.info("checkProjectArea_AddRow_Header_Display  starts here........");
		boolean flag = false;
		waithelper.WaitForElementClickable(ProjectAreaTab, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(ProjectAreaTab);
		// ProjectAreaTab.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//*[contains(text(),'PROJECT AREA')]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		waithelper.WaitForElementClickable(ProjectSettingAddRowButton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ProjectSettingAddRowButton.click();

		if (ProjectAreaEffectiveYearHeading.getText().equals("EFFECTIVE YEAR")
				&& ProjectArea_ProjectAreaHeading.getText().contains("PROJECT AREA")
				&& ProjectArea_UpdatedByHeading.getText().equals("UPDATED BY")
				&& ProjectArea_SaveButton.isDisplayed() == true && ProjectArea_DeleteButton.isDisplayed() == true) {
			flag = true;
		}

		log.info("checkProjectArea_AddRow_Header_Display  ends here........");
		return flag;

	}

	// This method will add new row and save the record
	// It also checks whether decade calender is opening or not

	public boolean checkPopulation_Save_New_Row(String population) {
		log.info("checkPopulation_Save_New_Row method starts here .........");
		boolean decadeCalenderflag = false;
		boolean RowAddedflag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int TotalRowbeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total row is ---" + TotalRowbeforeAdding);
		waithelper.WaitForElementClickable(ProjectSettingAddRowButton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ProjectSettingAddRowButton.click();
		Population_EffectiveYearTextBox.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		String DecadeCal = DecadeCalenderHeader.getText();
		driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/tbody/tr/td/span[3]")).click();

		String[] s1 = DecadeCal.split("-");
		int Start_Year = Integer.parseInt(s1[0]);
		int End_Year = Integer.parseInt(s1[1]);
		if (End_Year - Start_Year == 9) {
			log.info("Decade Calender for Effective Year is showing proper..........");
			decadeCalenderflag = true;
		} else {
			log.info("Decade Calender for Effective Year is not showing proper..........");
			decadeCalenderflag = false;
		}

		Population_populationTextBox.sendKeys(population);
		Population_SaveButton.click();

		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By
							.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/*[@class='fade-out saved_symbol']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By
							.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/*[@class='fade-out saved_symbol']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * waithelper.WaitForElementVisibleWithPollingTime( driver.findElement(
		 * By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/span")),
		 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
		 */
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// ListOfRows =
		// driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int TotalRowAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total row is ---" + TotalRowAfterAdding);
		if (TotalRowAfterAdding - TotalRowbeforeAdding == 1) {
			log.info("Row is added successfully....");
			RowAddedflag = true;
		} else {
			log.info("Row is not added successfully....");
		}
		if (decadeCalenderflag == true && RowAddedflag == true) {
			log.info("checkPopulation_Save_New_Row method ends here with true  .........");
			return true;
		} else {
			log.info("checkPopulation_Save_New_Row method ends here with false.........");
			return false;
		}

	}

	public boolean checkPopulationUpdatedByUserName(String Username) {
		log.info("checkPopulationUpdatedByUserName method starts here............");
		// driver.switchTo().frame("datainput-widget");
		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		log.info("Total Rows displaying is --" + rows);
		for (int i = 0; i < rows.size(); i++) {
			int rownum = i + 1;
			String CurrentUpdatedBy = driver
					.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + rownum + "]/td[3]/div")).getText();
			log.info(CurrentUpdatedBy + " ----------------- " + Username);
			if (CurrentUpdatedBy.contains(Username)) {

				flag = true;
				break;
			}

		}

		if (flag) {
			log.info("Found Updated By --- " + Username);
		} else {
			log.info("Not found Updated By --- " + Username);
		}
		log.info("checkPopulationUpdatedByUserName method ends here............");
		return flag;
	}

	public boolean checkProjectAreaUpdatedByUserName(String Username) {
		log.info("checkProjectAreaUpdatedByUserName method starts here............");
		// driver.switchTo().frame("datainput-widget");
		waithelper.WaitForElementClickable(ProjectAreaTab, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(ProjectAreaTab);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//*[contains(text(),'PROJECT AREA')]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		boolean flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		log.info("Total Rows displaying is --" + rows);
		for (int i = 0; i < rows.size(); i++) {
			int rownum = i + 1;
			String CurrentUpdatedBy = driver
					.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + rownum + "]/td[3]/div")).getText();
			log.info(CurrentUpdatedBy + " ----------------- " + Username);
			if (CurrentUpdatedBy.contains(Username)) {

				flag = true;
				break;
			}

		}

		if (flag) {
			log.info("Found Updated By --- " + Username);
		} else {
			log.info("Not found Updated By --- " + Username);
		}
		log.info("checkProjectAreaUpdatedByUserName method ends here............");
		return flag;
	}

	// This method will add new row and save the record
	// It also checks whether decade Calender is opening or not

	public boolean checkProjectArea_Save_New_Row(String PArea) {
		log.info("checkProjectArea_Save_New_Row method starts here .........");
		boolean decadeCalenderflag = false;
		boolean RowAddedflag = false;
		waithelper.WaitForElementClickable(ProjectAreaTab, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(ProjectAreaTab);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//*[contains(text(),'PROJECT AREA')]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		// List<WebElement> ListOfRows =
		// driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int TotalRowbeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total row is ---" + TotalRowbeforeAdding);

		waithelper.WaitForElementClickable(ProjectSettingAddRowButton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		ProjectSettingAddRowButton.click();
		ProjectArea_EffectiveYearTextBox.click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		String DecadeCal = DecadeCalenderHeader.getText();
		// driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/tbody/tr/td/span[3]")).click();
		driver.findElement(By.xpath(
				"(//table[@class='table-condensed'])[2]/tbody/tr/td/span[@class='year old']/following-sibling::span[1]"))
				.click();
		String[] s1 = DecadeCal.split("-");
		int Start_Year = Integer.parseInt(s1[0]);
		int End_Year = Integer.parseInt(s1[1]);
		if (End_Year - Start_Year == 9) {
			// log.info("Decade Calender for Effective Year is showing proper..........");
			decadeCalenderflag = true;
		} else {
			// log.info("Decade Calender for Effective Year is not showing
			// proper..........");
			decadeCalenderflag = false;
		}

		ProjectAreaTextBox.sendKeys(PArea);
		ProjectArea_SaveButton.click();
		// JSHelper.clickElement(ProjectArea_SaveButton);

		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By
							.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/*[@class='fade-out saved_symbol']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By
							.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/*[@class='fade-out saved_symbol']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ListOfRows =
		// driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int TotalRowAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		;
		log.info("Total row is ---" + TotalRowAfterAdding);
		if (TotalRowAfterAdding - TotalRowbeforeAdding == 1) {
			log.info("Row is added successfully....");
			RowAddedflag = true;
		} else {
			log.info("Row is not added successfully....");
		}
		if (decadeCalenderflag == true && RowAddedflag == true) {
			log.info("checkProjectArea_Save_New_Row method ends here with true  .........");
			return true;
		} else {
			log.info("checkProjectArea_Save_New_Row method ends here with false.........");
			return false;
		}

	}

	// This method will check whether newly added row in Population is saved
	// successfully or not

	public boolean verifyAddedProject_Setting_PopulationRow() {
		log.info("verifyAddedProject_Setting_Row starts here ................");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean AddedRowFlag = false;
		// List<WebElement> rows =
		// driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int TotalRow = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Row display is ---  " + TotalRow);
		if (TotalRow > 0) {
			log.info("Added Row showing proper----");
			AddedRowFlag = true;
		} else {
			log.info("Added Row is not showing proper----");
			AddedRowFlag = false;
		}
		if (AddedRowFlag) {
			log.info("verifyAddedProject_Setting_Row method ends here .........");
			return true;
		} else {
			log.info("verifyAddedProject_Setting_Row method ends here .........");
			return false;
		}
	}

	// GHG Emissions -- > Energy --> This method will add records and check whether
	// filter is working or not

	public boolean CheckEnergyGraph() {
		log.info("CheckEnergyGraph starts here ................");
		GHGEmission_Data_AddYearBtn.click();
		HashMap<Integer, Integer> GraphValue = new HashMap<Integer, Integer>();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean flag = false;
		driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int tons = 100;
		int year = CommonMethod.getCurrentYear() - 1;
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(tons));

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("(//table[@class='meterListByType--wrapper']/tbody)[1]/tr[1]/td[3]/div/span/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		GraphValue.put(year, tons);

		for (int i = 2; i < 4; i++) {

			waithelper.WaitForElementClickable(PreviousYearbutton, Integer.parseInt(prop.getProperty("explicitTime")),
					2);
			PreviousYearbutton.click();

			String xpath = "//table[@id='readingsTable']/tbody/tr[" + i + "]/td[2]/input";
			year = year - 1;
			tons = tons + 100;
			driver.findElement(By.xpath(xpath)).sendKeys(Integer.toString(tons));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + i + "]/td[3]/button")).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + i + "]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody)[1]/tr[1]/td[3]/div/span/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			GraphValue.put(year, tons);
			// System.out.println(GraphValue);

		}

		JSHelper.clickElement(GHGEmission_DetailsTab);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> barList = driver.findElements(By.xpath(
				"//div[@class='amcharts-chart-div']//*[name()='svg']//*[local-name()='g' ]//*[name()='path' and @fill='#D0DD3D']"));
		for (WebElement ele : barList) {
			actionhelper.mouseOverElement(ele);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String tooltip = driver.findElement(By.xpath("//div[@class='amcharts-balloon-div']/div")).getText();
			int Graph_Tons = Integer.parseInt(tooltip.substring(9, 12));
			if (!GraphValue.containsValue(Graph_Tons)) {
				flag = false;
				break;
			} else
				flag = true;
			log.info("Matching for " + Graph_Tons + "  is " + GraphValue.containsValue(Graph_Tons));
		}
		log.info("CheckEnergyGraph ends here ................");
		return flag;

	}

	// Water - Water Consumption - > This method will add records and check whether
	// filter is working or not

	public boolean CheckWaterGraph() {
		log.info("CheckWaterGraph starts here ................");
		WaterConsum_Data_AddYearBtn.click();
		HashMap<Integer, Integer> GraphValue = new HashMap<Integer, Integer>();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean flag = false;
		driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int value = 100;
		int year = CommonMethod.getCurrentYear() - 1;
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/button")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("(//table[@class='meterListByType--wrapper']/tbody)[2]/tr[1]/td[3]/div/span/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		GraphValue.put(year, value);

		for (int i = 2; i < 4; i++) {

			waithelper.WaitForElementClickable(PreviousYearbutton, Integer.parseInt(prop.getProperty("explicitTime")),
					2);
			PreviousYearbutton.click();

			String xpath = "//table[@id='readingsTable']/tbody/tr[" + i + "]/td[2]/input";
			year = year - 1;
			value = value + 100;
			driver.findElement(By.xpath(xpath)).sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + i + "]/td[5]/button")).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + i + "]/td[6]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody)[2]/tr[1]/td[3]/div/span/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			GraphValue.put(year, value);
			// System.out.println(GraphValue);

		}

		JSHelper.clickElement(WaterConsum_DetailsTab);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> barList = driver.findElements(By.xpath(
				"//div[@class='amcharts-chart-div']//*[name()='svg']//*[local-name()='g' ]//*[name()='path' and @fill='#55CAF5']"));
		for (WebElement ele : barList) {
			actionhelper.mouseOverElement(ele);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String tooltip = driver.findElement(By.xpath("//div[@class='amcharts-balloon-div']/div")).getText();
			int Graph_value = Integer.parseInt(tooltip.substring(9, 12));
			if (!GraphValue.containsValue(Graph_value)) {
				flag = false;
				break;
			} else
				flag = true;
			log.info("Matching for " + Graph_value + "  is " + GraphValue.containsValue(Graph_value));
		}
		log.info("CheckWaterGraph ends here ................");
		return flag;

	}

	// Waste --> Municipal solid waste generation intensity --> This method will add
	// records and check whether filter is working or not

	public boolean CheckWasteGenerationGraph() {
		log.info("CheckWasteGenerationGraph starts here ................");
		Waste_AddYearButton.click();
		HashMap<Integer, Integer> GraphValue = new HashMap<Integer, Integer>();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean flag = false;
		driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int tons = 100;
		int year = CommonMethod.getCurrentYear() - 1;
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(tons));

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("(//table[@class='meterListByType--wrapper']/tbody)[3]/tr[1]/td[3]/div/span/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		GraphValue.put(year, tons);

		for (int i = 2; i < 4; i++) {

			waithelper.WaitForElementClickable(PreviousYearbutton, Integer.parseInt(prop.getProperty("explicitTime")),
					2);
			PreviousYearbutton.click();

			String xpath = "//table[@id='readingsTable']/tbody/tr[" + i + "]/td[2]/input";
			year = year - 1;
			tons = tons + 100;
			driver.findElement(By.xpath(xpath)).sendKeys(Integer.toString(tons));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + i + "]/td[3]/button")).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + i + "]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody)[3]/tr[1]/td[3]/div/span/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			GraphValue.put(year, tons);
			// System.out.println(GraphValue);

		}

		JSHelper.clickElement(Waste_DetailsTab);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> barList = driver.findElements(By.xpath(
				"//div[@class='amcharts-chart-div']//*[name()='svg']//*[local-name()='g' ]//*[name()='path' and @fill='#74D681']"));
		for (WebElement ele : barList) {
			actionhelper.mouseOverElement(ele);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String tooltip = driver.findElement(By.xpath("//div[@class='amcharts-balloon-div']/div")).getText();
			int Graph_value = Integer.parseInt(tooltip.substring(9, 12));
			if (!GraphValue.containsValue(Graph_value)) {
				flag = false;
				break;
			} else
				flag = true;
			log.info("Matching for " + Graph_value + "  is " + GraphValue.containsValue(Graph_value));
		}
		log.info("CheckWasteGenerationGraph ends here ................");
		return flag;

	}

	// Waste --> Municipal solid waste diversion rate from landfill --> This method
	// will add records and check whether filter is working or not

	public boolean CheckWasteDiversionGraph() {
		log.info("CheckWasteDiversionGraph starts here ................");
		Waste_AddYearButton.click();
		HashMap<Integer, Integer> GraphValue = new HashMap<Integer, Integer>();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean flag = false;
		driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int percent = 50;
		int year = CommonMethod.getCurrentYear() - 1;
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(percent));

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("(//table[@class='meterListByType--wrapper']/tbody)[3]/tr[1]/td[3]/div/span/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		GraphValue.put(year, percent);

		for (int i = 2; i < 4; i++) {

			waithelper.WaitForElementClickable(PreviousYearbutton, Integer.parseInt(prop.getProperty("explicitTime")),
					2);
			PreviousYearbutton.click();

			String xpath = "//table[@id='readingsTable']/tbody/tr[" + i + "]/td[2]/input";
			year = year - 1;
			percent = percent + 10;
			driver.findElement(By.xpath(xpath)).sendKeys(Integer.toString(percent));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + i + "]/td[3]/button")).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + i + "]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody)[3]/tr[1]/td[3]/div/span/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			GraphValue.put(year, percent);
			// System.out.println(GraphValue);

		}

		JSHelper.clickElement(Waste_DetailsTab);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> barList = driver.findElements(By.xpath(
				"//div[@class='amcharts-chart-div']//*[name()='svg']//*[local-name()='g' ]//*[name()='path' and @fill='#74D681']"));
		for (WebElement ele : barList) {
			actionhelper.mouseOverElement(ele);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String tooltip = driver.findElement(By.xpath("//div[@class='amcharts-balloon-div']/div")).getText();
			int Graph_value = Integer.parseInt(tooltip.substring(9, 11));
			if (!GraphValue.containsValue(Graph_value)) {
				flag = false;
				break;
			} else
				flag = true;
			log.info("Matching for " + Graph_value + "  is " + GraphValue.containsValue(Graph_value));
		}
		log.info("CheckWasteDiversionGraph ends here ................");
		return flag;

	}

	// Transportation->VMT --> This method will add records and check whether filter
	// is working or not

	public boolean CheckTransportationGraph() {
		log.info("CheckTransportationGraph starts here ................");
		VMT_Data_AddYearBtn.click();
		HashMap<Integer, Integer> GraphValue = new HashMap<Integer, Integer>();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean flag = false;
		driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int miles = 100;
		int year = CommonMethod.getCurrentYear() - 1;
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(miles));

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("(//table[@class='meterListByType--wrapper']/tbody)[3]/tr[1]/td[3]/div/span/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		GraphValue.put(year, miles);

		for (int i = 2; i < 4; i++) {

			waithelper.WaitForElementClickable(PreviousYearbutton, Integer.parseInt(prop.getProperty("explicitTime")),
					2);
			PreviousYearbutton.click();

			String xpath = "//table[@id='readingsTable']/tbody/tr[" + i + "]/td[2]/input";
			year = year - 1;
			miles = miles + 100;
			driver.findElement(By.xpath(xpath)).sendKeys(Integer.toString(miles));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + i + "]/td[3]/button")).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + i + "]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody)[3]/tr[1]/td[3]/div/span/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			GraphValue.put(year, miles);
			// System.out.println(GraphValue);

		}

		JSHelper.clickElement(VMT_DetailsTab);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> barList = driver.findElements(By.xpath(
				"//div[@class='amcharts-chart-div']//*[name()='svg']//*[local-name()='g' ]//*[name()='path' and @fill='#74D681']"));
		for (WebElement ele : barList) {
			actionhelper.mouseOverElement(ele);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String tooltip = driver.findElement(By.xpath("//div[@class='amcharts-balloon-div']/div")).getText();
			int Graph_value = Integer.parseInt(tooltip.substring(9, 12));
			if (!GraphValue.containsValue(Graph_value)) {
				flag = false;
				break;
			} else
				flag = true;
			log.info("Matching for " + Graph_value + "  is " + GraphValue.containsValue(Graph_value));
		}
		log.info("CheckTransportationGraph ends here ................");
		return flag;

	}
	// Project Setting -- > Population --> This method will add records and check
	// whether filter is working or not

	public boolean CheckPopulationFilter() {
		log.info("CheckPopulationFilter starts here ................");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean RowAddedflag = false;
		boolean flag = false;
		// List<WebElement> rows =
		// driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));

		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 5;
		int prev_year = CurrentYear - 1;
		int population = 100;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;
		List<WebElement> ListOfRows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");

		// int TotalRowsBeforeAdding = ListOfRows.size();
		int TotalRowsAfterAdding;
		log.info("Total rows before adding any row--  " + TotalRowsBeforeAdding);
		log.info("Population-->Going to add record from --" + StartYear + "  to " + prev_year);
		for (int i = StartYear; i < CurrentYear; i++) {
			log.info("Population-->Going to add record for year--" + i + "  with " + population);
			ListOfRows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			// TotalRowsBeforeAdding = ListOfRows.size();
			TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			waithelper.WaitForElementClickable(ProjectSettingAddRowButton,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			ProjectSettingAddRowButton.click();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + i + "']";
			try {
				driver.findElement(By.xpath(xpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(xpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(population));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/button")).click();

			try {
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath(
								"//table[@id='readingsTable']/tbody/tr[1]/td[4]/*[@class='fade-out saved_symbol']")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@id='readingsTable']/tbody/tr[1]/td[4]/*[@class='fade-out saved_symbol']")),
						Integer.parseInt(prop.getProperty("explicitTime")), 1);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {

				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			/*
			 * waithelper.WaitForElementVisibleWithPollingTime( driver.findElement(
			 * By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/span")),
			 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
			 */
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// ListOfRows =
			// driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			// TotalRowsAfterAdding = ListOfRows.size();
			TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total row after adding --" + TotalRowsAfterAdding);
			if (TotalRowsAfterAdding - TotalRowsBeforeAdding == 1) {
				RowAddedflag = true;
			} else {
				RowAddedflag = false;
				log.info("Adding row is failed for the year..." + i);
				break;
			}

			population = population + 100;
		}

		if (RowAddedflag) {
			waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearFilterButton.click();
			YearStartDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Startxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterStartYear
					+ "']";
			try {
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}
			YearEndDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Endxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterEndYear + "']";
			try {
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}

			waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearUpdateBtn.click();
			CommonMethod.waitUntilLoadElement();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// ListOfRows =
			// driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			// log.info("After Filter Total rows displaying are --" + ListOfRows.size());
			int RowsAfterFilter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("After Filter Total rows displaying are --" + RowsAfterFilter);
			int j = 1;
			if (RowsAfterFilter == 3) {
				for (int i = filterEndYear; i >= filterStartYear; i--) {
					String currentyear = driver
							.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
							.getAttribute("value");
					log.info("Current showing Year is --" + currentyear + "  and filter year is --" + i);
					if (!currentyear.equals(Integer.toString(i))) {
						log.info("Filtered Year not matching");
						flag = false;
						break;
					} else {
						flag = true;
					}
					j++;
				}
			} else {
				log.info("Total number of row should be displayed 3 but it is showing " + ListOfRows.size());
				log.info("CheckPopulationFilter ends here with false ................");
				return false;
			}
			if (flag == true) {
				log.info("CheckPopulationFilter ends here with true ................");
				return true;
			} else {
				log.info("CheckPopulationFilter ends here with false ................");
				return false;
			}
		} else {
			log.info("CheckPopulationFilter ends here with false ................");
			return false;
		}

	}

	// Project Setting -- > Project Area --> This method will add records and check
	// whether filter is working or not

	public boolean CheckProjectAreaFilter() {
		log.info("CheckProjectAreaFilter starts here ................");
		waithelper.WaitForElementClickable(ProjectAreaTab, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(ProjectAreaTab);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//*[contains(text(),'PROJECT AREA')]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		boolean flag = false;
		boolean RowAddedflag = false;
		// List<WebElement> rows =
		// driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 5;
		int prev_year = CurrentYear - 1;
		int PArea = 100;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;
		// List<WebElement> ListOfRows =
		// driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		int TotalRowsAfterAdding;
		log.info("Total rows before adding any row--  " + TotalRowsBeforeAdding);
		log.info("Project Area-->Going to add record from " + StartYear + "to " + prev_year);
		for (int i = StartYear; i < CurrentYear; i++) {
			log.info("Project Area-->Going to add record for year--" + i + "  with " + PArea);
			// ListOfRows =
			// driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			waithelper.WaitForElementClickable(ProjectSettingAddRowButton,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			ProjectSettingAddRowButton.click();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + i + "']";
			try {
				driver.findElement(By.xpath(xpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(xpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}

			// driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).sendKeys(Integer.toString(i));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(PArea));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/button")).click();

			try {
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath(
								"//table[@id='readingsTable']/tbody/tr[1]/td[4]/*[@class='fade-out saved_symbol']")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@id='readingsTable']/tbody/tr[1]/td[4]/*[@class='fade-out saved_symbol']")),
						Integer.parseInt(prop.getProperty("explicitTime")), 1);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {

				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 1);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// ListOfRows =
			// driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total row after adding --" + TotalRowsAfterAdding);
			if (TotalRowsAfterAdding - TotalRowsBeforeAdding == 1) {
				RowAddedflag = true;
			} else {
				RowAddedflag = false;
				log.info("Adding row is failed for the year..." + i);
				break;
			}

			PArea = PArea + 100;
		}

		if (RowAddedflag) {
			waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearFilterButton.click();
			YearStartDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Startxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterStartYear
					+ "']";
			try {
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}
			YearEndDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Endxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterEndYear + "']";
			try {
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}

			waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearUpdateBtn.click();
			CommonMethod.waitUntilLoadElement();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// ListOfRows =
			// driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			int TotalRowAfterFilter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("After Filter Total rows displaying are --" + TotalRowAfterFilter);
			int j = 1;
			if (TotalRowAfterFilter == 3) {
				for (int i = filterEndYear; i >= filterStartYear; i--) {
					String currentyear = driver
							.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
							.getAttribute("value");
					log.info("Current showing Year is --" + currentyear + "  and filter year is --" + i);
					if (!currentyear.equals(Integer.toString(i))) {
						log.info("Filtered Year not matching");
						flag = false;
						break;
					} else {
						flag = true;
					}
					j++;
				}
			}
			if (flag == true) {
				log.info("CheckProjectAreaFilter ends here with true ................");
				return true;
			} else {
				log.info("CheckProjectAreaFilter ends here with false ................");
				return false;
			}
		} else {
			log.info("CheckProjectAreaFilter ends here with false ................");
			return false;
		}
	}

	// GHG Emissions -- > Energy --> This method will add records and check whether
	// filter is working or not

	public boolean CheckEnergyFilter() {
		log.info("CheckEnergyFilter starts here ................");

		boolean flag = false;
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 6;
		int tons = 100;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;
		int TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		int TotalRowsAfterAdding;
		log.info("Total rows before adding any row--  " + TotalRowsBeforeAdding);
		GHGEmission_Data_AddYearBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + StartYear + "']";
		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
			driver.findElement(By.xpath(xpath)).click();
		} catch (Exception e) {
			e.printStackTrace();

		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(tons));
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Row Circular Image");
		}

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Energy Circular Image");
		}

		tons = tons + 10;
		TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		if (TotalRowsAfterAdding - TotalRowsBeforeAdding != 1) {
			flag = false;
			log.info("Record is not added for " + StartYear);

		} else {
			log.info("Record added for " + StartYear);
			StartYear++;
			for (int i = StartYear; i < CurrentYear; i++) {

				TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
				NextYearbutton.click();

				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
				xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + i + "']";
				try {
					driver.findElement(By.xpath(xpath)).click();
				} catch (NoSuchElementException e) {
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
					driver.findElement(By.xpath(xpath)).click();
				} catch (Exception e) {
					e.printStackTrace();

				}

				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
						.sendKeys(Integer.toString(tons));
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

				try {
					waithelper.WaitForElementInvisible(
							driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
							Integer.parseInt(prop.getProperty("explicitTime")), 2);
				} catch (Exception e) {
					e.printStackTrace();
					log.info("Unable to locate Row Circular Image");
				}

				try {
					waithelper.WaitForElementInvisible(
							driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
							Integer.parseInt(prop.getProperty("explicitTime")), 2);
				} catch (Exception e) {
					e.printStackTrace();
					log.info("Unable to locate Energy Circular Image");
				}

				TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
				if (TotalRowsAfterAdding - TotalRowsBeforeAdding == 1) {
					log.info("Record added for " + i);
					flag = true;
				} else {
					log.info("Record is not added for " + i);
					flag = false;
				}

				tons = tons + 2;
			}
		}
		if (flag) {
			ClickonWaterConsumption();
			ClickonGHGEmiissions();
			waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearFilterButton.click();
			YearStartDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Startxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterStartYear
					+ "']";
			try {
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}
			YearEndDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Endxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterEndYear + "']";
			try {
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}

			waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearUpdateBtn.click();
			CommonMethod.waitUntilLoadElement();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int RowsAfterFilter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("After Filter Total rows displaying are --" + RowsAfterFilter);
			int j = 1;
			if (RowsAfterFilter == 3) {
				for (int i = filterEndYear; i >= filterStartYear; i--) {
					String currentyear = driver
							.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
							.getAttribute("value");
					log.info("Current showing Year is --" + currentyear + "  and filter year is --" + i);
					if (!currentyear.equals(Integer.toString(i))) {
						log.info("Filtered Year not matching");
						flag = false;
						break;
					} else {
						flag = true;
					}
					j++;
				}
			} else {
				log.info("Total number of row should be displayed 3 but it is showing " + RowsAfterFilter);
				log.info("CheckEnergyFilter ends here with false ................");
				return false;
			}
			if (flag == true) {
				log.info("CheckEnergyFilter ends here with true ................");
				return true;
			} else {
				log.info("CheckEnergyFilter ends here with false ................");
				return false;
			}
		} else {
			log.info("CheckEnergyFilter ends here with false ................");
			return false;
		}

	}

	// Transportation -- > VMT --> This method will add records and check whether
	// filter is working or not

	public boolean CheckTransportationFilter() {
		log.info("CheckTransportationFilter starts here ................");

		boolean flag = false;
		driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 6;
		int Miles = 10;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;
		int TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		int TotalRowsAfterAdding;
		VMT_Data_AddYearBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + StartYear + "']";
		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
			driver.findElement(By.xpath(xpath)).click();
		} catch (Exception e) {
			e.printStackTrace();

		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(Miles));
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Circular Image");
		}

		Miles = Miles + 2;
		TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		if (TotalRowsAfterAdding - TotalRowsBeforeAdding != 1) {
			flag = false;
			log.info("Record is not added for " + StartYear);

		} else {
			log.info("Record added for " + StartYear);
			StartYear++;
			for (int i = StartYear; i < CurrentYear; i++) {
				TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
				waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")),
						2);
				NextYearbutton.click();

				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
				xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + i + "']";
				try {
					driver.findElement(By.xpath(xpath)).click();
				} catch (NoSuchElementException e) {
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
					driver.findElement(By.xpath(xpath)).click();
				} catch (Exception e) {
					e.printStackTrace();

				}

				// driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).sendKeys(Integer.toString(i));
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
						.sendKeys(Integer.toString(Miles));
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

				try {
					waithelper.WaitForElementInvisible(
							driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
							Integer.parseInt(prop.getProperty("explicitTime")), 2);
				} catch (Exception e) {
					e.printStackTrace();
					log.info("Unable to locate Circular Image");
				}

				TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
				if (TotalRowsAfterAdding - TotalRowsBeforeAdding == 1) {
					log.info("Record added for " + i);
					flag = true;
				} else {
					log.info("Record is not added for " + i);
					flag = false;
				}

				Miles = Miles + 2;
			}
		}
		if (flag) {
			ClickonGHGEmiissions();
			ClickonVMT();
			waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearFilterButton.click();
			YearStartDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Startxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterStartYear
					+ "']";
			try {
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}
			YearEndDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Endxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterEndYear + "']";
			try {
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}

			waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearUpdateBtn.click();
			CommonMethod.waitUntilLoadElement();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int RowsAfterFilter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("After Filter Total rows displaying are --" + RowsAfterFilter);
			int j = 1;
			if (RowsAfterFilter == 3) {
				for (int i = filterEndYear; i >= filterStartYear; i--) {
					String currentyear = driver
							.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
							.getAttribute("value");
					log.info("Current showing Year is --" + currentyear + "  and filter year is --" + i);
					if (!currentyear.equals(Integer.toString(i))) {
						log.info("Filtered Year not matching");
						flag = false;
						break;
					} else {
						flag = true;
					}
					j++;
				}
			} else {
				log.info("Total number of row should be displayed 3 but it is showing " + RowsAfterFilter);
				log.info("CheckTransportationFilter ends here with false ................");
				return false;
			}
			if (flag == true) {
				log.info("CheckTransportationFilter ends here with true ................");
				return true;
			} else {
				log.info("CheckTransportationFilter ends here with false ................");
				return false;
			}
		} else {
			log.info("CheckTransportationFilter ends here with false ................");
			return false;
		}

	}

	// Quality Of Life--> Health And Safety --> This method will add records and
	// check whether filter is working or not

	public boolean CheckHealthAndSafetyFilter() {
		log.info("CheckHealthAndSafetyFilter starts here ................");

		boolean flag = false;
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 6;
		int Miles = 10;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;
		int TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		int TotalRowsAfterAdding;
		waithelper.WaitForElementClickable(HealthAndSafety_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		HealthAndSafety_Data_AddYearBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + StartYear + "']";
		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
			driver.findElement(By.xpath(xpath)).click();
		} catch (Exception e) {
			e.printStackTrace();

		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(Miles));
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate  Circular Image");
		}

		Miles = Miles + 2;
		TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		if (TotalRowsAfterAdding - TotalRowsBeforeAdding != 1) {
			flag = false;
			log.info("Record is not added for " + StartYear);

		} else {
			log.info("Record added for " + StartYear);
			StartYear++;

			for (int i = StartYear; i < CurrentYear; i++) {
				TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");

				waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")),
						2);

				NextYearbutton.click();

				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
				xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + i + "']";
				try {
					driver.findElement(By.xpath(xpath)).click();
				} catch (NoSuchElementException e) {
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
					driver.findElement(By.xpath(xpath)).click();
				} catch (Exception e) {
					e.printStackTrace();

				}

				// driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).sendKeys(Integer.toString(i));
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
						.sendKeys(Integer.toString(Miles));
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

				try {
					waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
							Integer.parseInt(prop.getProperty("explicitTime")), 2);
				} catch (Exception e) {
					e.printStackTrace();
					log.info("Unable to locate  Circular Image");
				}

				TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
				if (TotalRowsAfterAdding - TotalRowsBeforeAdding == 1) {
					log.info("Record added for " + i);
					flag = true;
				} else {
					log.info("Record is not added for " + i);
					flag = false;
				}

				Miles = Miles + 2;
			}
		}
		if (flag) {
			ClickonGHGEmiissions();
			ClickonHealthAndSafety();
			waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearFilterButton.click();
			YearStartDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Startxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterStartYear
					+ "']";
			try {
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}
			YearEndDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Endxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterEndYear + "']";
			try {
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}

			waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearUpdateBtn.click();
			CommonMethod.waitUntilLoadElement();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int RowsAfterFilter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("After Filter Total rows displaying are --" + RowsAfterFilter);
			int j = 1;
			if (RowsAfterFilter == 3) {
				for (int i = filterEndYear; i >= filterStartYear; i--) {
					String currentyear = driver
							.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
							.getAttribute("value");
					log.info("Current showing Year is --" + currentyear + "  and filter year is --" + i);
					if (!currentyear.equals(Integer.toString(i))) {
						log.info("Filtered Year not matching");
						flag = false;
						break;
					} else {
						flag = true;
					}
					j++;
				}
			} else {
				log.info("Total number of row should be displayed 3 but it is showing " + RowsAfterFilter);
				log.info("CheckHealthAndSafetyFilter ends here with false ................");
				return false;
			}
			if (flag == true) {
				log.info("CheckHealthAndSafetyFilter ends here with true ................");
				return true;
			} else {
				log.info("CheckHealthAndSafetyFilter ends here with false ................");
				return false;
			}
		} else {
			log.info("CheckHealthAndSafetyFilter ends here with false ................");
			return false;
		}

	}

	// Quality Of Life--> Education: Population with (at least) Bachelor's degree
	// (%) --> This method will add records and check whether filter is working or
	// not

	public boolean CheckEducation_Bachelor_Population_Filter() {
		log.info("CheckEducation_Bachelor_Population_Filter starts here ................");

		boolean flag = false;
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 6;
		int Percent = 50;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;
		int TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		int TotalRowsAfterAdding;
		waithelper.WaitForElementClickable(Education_BachelorPopulation_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Education_BachelorPopulation_Data_AddYearBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + StartYear + "']";
		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
			driver.findElement(By.xpath(xpath)).click();
		} catch (Exception e) {
			e.printStackTrace();

		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(Percent));
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate  Circular Image");
		}

		Percent = Percent + 2;
		TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		if (TotalRowsAfterAdding - TotalRowsBeforeAdding != 1) {
			flag = false;
			log.info("Record is not added for " + StartYear);

		} else {
			log.info("Record added for " + StartYear);
			StartYear++;
			for (int i = StartYear; i < CurrentYear; i++) {
				TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");

				waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")),
						2);

				NextYearbutton.click();

				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
				xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + i + "']";
				try {
					driver.findElement(By.xpath(xpath)).click();
				} catch (NoSuchElementException e) {
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
					driver.findElement(By.xpath(xpath)).click();
				} catch (Exception e) {
					e.printStackTrace();

				}

				// driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).sendKeys(Integer.toString(i));
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
						.sendKeys(Integer.toString(Percent));
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

				try {
					waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
							Integer.parseInt(prop.getProperty("explicitTime")), 2);
				} catch (Exception e) {
					e.printStackTrace();
					log.info("Unable to locate  Circular Image");
				}

				TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
				if (TotalRowsAfterAdding - TotalRowsBeforeAdding == 1) {
					log.info("Record added for " + i);
					flag = true;
				} else {
					log.info("Record is not added for " + i);
					flag = false;
				}

				Percent = Percent + 2;
			}
		}
		if (flag) {
			ClickonGHGEmiissions();
			ClickonEducation_BachelorPopulation();
			waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearFilterButton.click();
			YearStartDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Startxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterStartYear
					+ "']";
			try {
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}
			YearEndDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Endxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterEndYear + "']";
			try {
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}

			waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearUpdateBtn.click();
			CommonMethod.waitUntilLoadElement();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int RowsAfterFilter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("After Filter Total rows displaying are --" + RowsAfterFilter);
			int j = 1;
			if (RowsAfterFilter == 3) {
				for (int i = filterEndYear; i >= filterStartYear; i--) {
					String currentyear = driver
							.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
							.getAttribute("value");
					log.info("Current showing Year is --" + currentyear + "  and filter year is --" + i);
					if (!currentyear.equals(Integer.toString(i))) {
						log.info("Filtered Year not matching");
						flag = false;
						break;
					} else {
						flag = true;
					}
					j++;
				}
			} else {
				log.info("Total number of row should be displayed 3 but it is showing " + RowsAfterFilter);
				log.info("CheckEducation_Bachelor_Population_Filter ends here with false ................");
				return false;
			}
			if (flag == true) {
				log.info("CheckEducation_Bachelor_Population_Filter ends here with true ................");
				return true;
			} else {
				log.info("CheckEducation_Bachelor_Population_Filter ends here with false ................");
				return false;
			}
		} else {
			log.info("CheckEducation_Bachelor_Population_Filter ends here with false ................");
			return false;
		}

	}

	// Quality Of Life--> Equitability: Gini coefficient (for income distribution)
	// --> This method will add records and check whether filter is working or not

	public boolean CheckEquitability_Gini_Coefficient_Filter() {
		log.info("CheckEquitability_Gini_Coefficient_Filter starts here ................");

		boolean flag = false;
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 6;
		int value = 1;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;
		int TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		int TotalRowsAfterAdding;
		waithelper.WaitForElementClickable(Equitability_Gini_Coefficient_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(Equitability_Gini_Coefficient_Data_AddYearBtn);
		// Equitability_Gini_Coefficient_Data_AddYearBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + StartYear + "']";
		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
			driver.findElement(By.xpath(xpath)).click();
		} catch (Exception e) {
			e.printStackTrace();

		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate  Circular Image");
		}
		// Percent=Percent+2;
		TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		if (TotalRowsAfterAdding - TotalRowsBeforeAdding != 1) {
			flag = false;
			log.info("Record is not added for " + StartYear);

		} else {
			log.info("Record added for " + StartYear);
			StartYear++;
			for (int i = StartYear; i < CurrentYear; i++) {
				TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");

				waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")),
						2);

				NextYearbutton.click();

				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
				xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + i + "']";
				try {
					driver.findElement(By.xpath(xpath)).click();
				} catch (NoSuchElementException e) {
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
					driver.findElement(By.xpath(xpath)).click();
				} catch (Exception e) {
					e.printStackTrace();

				}

				// driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).sendKeys(Integer.toString(i));
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
						.sendKeys(Integer.toString(value));
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

				try {
					waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
							Integer.parseInt(prop.getProperty("explicitTime")), 2);
				} catch (Exception e) {
					e.printStackTrace();
					log.info("Unable to locate  Circular Image");
				}

				TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
				if (TotalRowsAfterAdding - TotalRowsBeforeAdding == 1) {
					log.info("Record added for " + i);
					flag = true;
				} else {
					log.info("Record is not added for " + i);
					flag = false;
				}
			}
		}
		if (flag) {
			ClickonGHGEmiissions();
			ClickonEquitability_Gini_Coeffiecient();
			waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearFilterButton.click();
			YearStartDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Startxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterStartYear
					+ "']";
			try {
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}
			YearEndDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Endxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterEndYear + "']";
			try {
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}

			waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearUpdateBtn.click();
			CommonMethod.waitUntilLoadElement();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int RowsAfterFilter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("After Filter Total rows displaying are --" + RowsAfterFilter);
			int j = 1;
			if (RowsAfterFilter == 3) {
				for (int i = filterEndYear; i >= filterStartYear; i--) {
					String currentyear = driver
							.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
							.getAttribute("value");
					log.info("Current showing Year is --" + currentyear + "  and filter year is --" + i);
					if (!currentyear.equals(Integer.toString(i))) {
						log.info("Filtered Year not matching");
						flag = false;
						break;
					} else {
						flag = true;
					}
					j++;
				}
			} else {
				log.info("Total number of row should be displayed 3 but it is showing " + RowsAfterFilter);
				log.info("CheckEquitability_Gini_Coefficient_Filter ends here with false ................");
				return false;
			}
			if (flag == true) {
				log.info("CheckEquitability_Gini_Coefficient_Filter ends here with true ................");
				return true;
			} else {
				log.info("CheckEquitability_Gini_Coefficient_Filter ends here with false ................");
				return false;
			}
		} else {
			log.info("CheckEquitability_Gini_Coefficient_Filter ends here with false ................");
			return false;
		}

	}

	// Quality Of Life--> Education: Population with (at least) High School degree
	// (%) --> This method will add records and check whether filter is working or
	// not

	public boolean CheckEducation_HighSchoolPopulation_Filter() {
		log.info("CheckEducation_HighSchoolPopulation_Filter starts here ................");
		// JSHelper.clickElement(Education_HighSchoolPopulation_Data_AddYearBtn);

		boolean flag = false;
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 6;
		int value = 65;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;
		int TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		int TotalRowsAfterAdding;

		waithelper.WaitForElementClickable(Education_HighSchoolPopulation_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Education_HighSchoolPopulation_Data_AddYearBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + StartYear + "']";
		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
			driver.findElement(By.xpath(xpath)).click();
		} catch (Exception e) {
			e.printStackTrace();

		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate  Circular Image");
		}
		value = value + 2;
		TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		if (TotalRowsAfterAdding - TotalRowsBeforeAdding != 1) {
			flag = false;
			log.info("Record is not added for " + StartYear);

		} else {
			log.info("Record added for " + StartYear);
			StartYear++;
			for (int i = StartYear; i < CurrentYear; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
				waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")),
						2);

				NextYearbutton.click();

				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
				xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + i + "']";
				try {
					driver.findElement(By.xpath(xpath)).click();
				} catch (NoSuchElementException e) {
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
					driver.findElement(By.xpath(xpath)).click();
				} catch (Exception e) {
					e.printStackTrace();

				}

				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
						.sendKeys(Integer.toString(value));
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

				try {
					waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
							Integer.parseInt(prop.getProperty("explicitTime")), 2);
				} catch (Exception e) {
					e.printStackTrace();
					log.info("Unable to locate  Circular Image");
				}

				TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
				if (TotalRowsAfterAdding - TotalRowsBeforeAdding == 1) {
					log.info("Record added for " + i);
					flag = true;
				} else {
					log.info("Record is not added for " + i);
					flag = false;
				}

				value = value + 2;
			}
		}

		if (flag) {
			ClickonGHGEmiissions();
			ClickonEducation_HighSchoolPopulation();
			waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearFilterButton.click();
			YearStartDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Startxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterStartYear
					+ "']";
			try {
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}
			YearEndDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Endxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterEndYear + "']";
			try {
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}

			waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearUpdateBtn.click();
			CommonMethod.waitUntilLoadElement();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int RowsAfterFilter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("After Filter Total rows displaying are --" + RowsAfterFilter);
			int j = 1;
			if (RowsAfterFilter == 3) {
				for (int i = filterEndYear; i >= filterStartYear; i--) {
					String currentyear = driver
							.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
							.getAttribute("value");
					log.info("Current showing Year is --" + currentyear + "  and filter year is --" + i);
					if (!currentyear.equals(Integer.toString(i))) {
						log.info("Filtered Year not matching");
						flag = false;
						break;
					} else {
						flag = true;
					}
					j++;
				}
			} else {
				log.info("Total number of row should be displayed 3 but it is showing " + RowsAfterFilter);
				log.info("CheckEducation_HighSchoolPopulation_Filter ends here with false ................");
				return false;
			}
			if (flag == true) {
				log.info("CheckEducation_HighSchoolPopulation_Filter ends here with true ................");
				return true;
			} else {
				log.info("CheckEducation_HighSchoolPopulation_Filter ends here with false ................");
				return false;
			}
		} else {
			log.info("CheckEducation_HighSchoolPopulation_Filter ends here with false ................");
			return false;
		}

	}

	// Quality Of Life--> Prosperity: Median household income (US Dollars/Year) -->
	// This method will add records and check whether filter is working or not

	public boolean CheckProsperityMedianIncome_Filter() {
		log.info("CheckProsperityMedianIncome_Filter starts here ................");
		// JSHelper.clickElement(Education_HighSchoolPopulation_Data_AddYearBtn);

		boolean flag = false;
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 6;
		int value = 1000;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;
		int TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		int TotalRowsAfterAdding;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(ProsperityMedianIncome_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ProsperityMedianIncome_Data_AddYearBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + StartYear + "']";
		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
			driver.findElement(By.xpath(xpath)).click();
		} catch (Exception e) {
			e.printStackTrace();

		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate  Circular Image");
		}
		value = value + 10;
		TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		if (TotalRowsAfterAdding - TotalRowsBeforeAdding != 1) {
			flag = false;
			log.info("Record is not added for " + StartYear);

		} else {
			log.info("Record added for " + StartYear);
			StartYear++;
			for (int i = StartYear; i < CurrentYear; i++) {
				TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");

				waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")),
						2);
				NextYearbutton.click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
				xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + i + "']";
				try {
					driver.findElement(By.xpath(xpath)).click();
				} catch (NoSuchElementException e) {
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
					driver.findElement(By.xpath(xpath)).click();
				} catch (Exception e) {
					e.printStackTrace();

				}

				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
						.sendKeys(Integer.toString(value));
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

				try {
					waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
							Integer.parseInt(prop.getProperty("explicitTime")), 2);
				} catch (Exception e) {
					e.printStackTrace();
					log.info("Unable to locate  Circular Image");
				}

				TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
				if (TotalRowsAfterAdding - TotalRowsBeforeAdding == 1) {
					log.info("Record added for " + i);
					flag = true;
				} else {
					log.info("Record is not added for " + i);
					flag = false;
				}
				value = value + 10;
			}
		}
		if (flag) {
			ClickonGHGEmiissions();
			ClickonProsperity_MedianIncome();
			waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearFilterButton.click();
			YearStartDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Startxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterStartYear
					+ "']";
			try {
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}
			YearEndDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Endxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterEndYear + "']";
			try {
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}

			waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearUpdateBtn.click();
			CommonMethod.waitUntilLoadElement();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int RowsAfterFilter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("After Filter Total rows displaying are --" + RowsAfterFilter);
			int j = 1;
			if (RowsAfterFilter == 3) {
				for (int i = filterEndYear; i >= filterStartYear; i--) {
					String currentyear = driver
							.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
							.getAttribute("value");
					log.info("Current showing Year is --" + currentyear + "  and filter year is --" + i);
					if (!currentyear.equals(Integer.toString(i))) {
						log.info("Filtered Year not matching");
						flag = false;
						break;
					} else {
						flag = true;
					}
					j++;
				}
			} else {
				log.info("Total number of row should be displayed 3 but it is showing " + RowsAfterFilter);
				log.info("CheckProsperityMedianIncome_Filter ends here with false ................");
				return false;
			}
			if (flag == true) {
				log.info("CheckProsperityMedianIncome_Filter ends here with true ................");
				return true;
			} else {
				log.info("CheckProsperityMedianIncome_Filter ends here with false ................");
				return false;
			}
		} else {
			log.info("CheckProsperityMedianIncome_Filter ends here with false ................");
			return false;
		}

	}

	// Quality Of Life--> Equitability: Median gross rent as (%) of household income
	// --> This method will add records and check whether filter is working or not

	public boolean CheckEquitability_MedianGrossIncome_Filter() {
		log.info("CheckProsperityMedianIncome_Filter starts here ................");
		// JSHelper.clickElement(Education_HighSchoolPopulation_Data_AddYearBtn);

		boolean flag = false;
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 6;
		int value = 50;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;
		int TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		int TotalRowsAfterAdding;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(Equitability_MedianGrossIncome_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Equitability_MedianGrossIncome_Data_AddYearBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + StartYear + "']";
		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
			driver.findElement(By.xpath(xpath)).click();
		} catch (Exception e) {
			e.printStackTrace();

		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate  Circular Image");
		}

		value = value + 5;

		TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		if (TotalRowsAfterAdding - TotalRowsBeforeAdding != 1) {
			flag = false;
			log.info("Record is not added for " + StartYear);

		} else {
			log.info("Record added for " + StartYear);
			StartYear++;
			for (int i = StartYear; i < CurrentYear; i++) {
				TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
				waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")),
						2);
				NextYearbutton.click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
				xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + i + "']";
				try {
					driver.findElement(By.xpath(xpath)).click();
				} catch (NoSuchElementException e) {
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
					driver.findElement(By.xpath(xpath)).click();
				} catch (Exception e) {
					e.printStackTrace();

				}
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
						.sendKeys(Integer.toString(value));
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

				try {
					waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
							Integer.parseInt(prop.getProperty("explicitTime")), 2);
				} catch (Exception e) {
					e.printStackTrace();
					log.info("Unable to locate  Circular Image");
				}

				TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
				if (TotalRowsAfterAdding - TotalRowsBeforeAdding == 1) {
					log.info("Record added for " + i);
					flag = true;
				} else {
					log.info("Record is not added for " + i);
					flag = false;
				}

				value = value + 10;
			}
		}
		if (flag) {
			ClickonGHGEmiissions();
			ClickonEquitability_MedianGrossIncome();
			waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearFilterButton.click();
			YearStartDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Startxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterStartYear
					+ "']";
			try {
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}
			YearEndDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Endxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterEndYear + "']";
			try {
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}

			waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearUpdateBtn.click();
			CommonMethod.waitUntilLoadElement();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int RowsAfterFilter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("After Filter Total rows displaying are --" + RowsAfterFilter);
			int j = 1;
			if (RowsAfterFilter == 3) {
				for (int i = filterEndYear; i >= filterStartYear; i--) {
					String currentyear = driver
							.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
							.getAttribute("value");
					log.info("Current showing Year is --" + currentyear + "  and filter year is --" + i);
					if (!currentyear.equals(Integer.toString(i))) {
						log.info("Filtered Year not matching");
						flag = false;
						break;
					} else {
						flag = true;
					}
					j++;
				}
			} else {
				log.info("Total number of row should be displayed 3 but it is showing " + RowsAfterFilter);
				log.info("CheckEquitability_MedianGrossIncome_Filter ends here with false ................");
				return false;
			}
			if (flag == true) {
				log.info("CheckEquitability_MedianGrossIncome_Filter ends here with true ................");
				return true;
			} else {
				log.info("CheckEquitability_MedianGrossIncome_Filter ends here with false ................");
				return false;
			}
		} else {
			log.info("CheckEquitability_MedianGrossIncome_Filter ends here with false ................");
			return false;
		}

	}
	// Quality Of Life--> Prosperity: Unemployment rate (%) --> This method will add
	// records and check whether filter is working or not

	public boolean CheckProsperityUnemployementRate_Filter() {
		log.info("CheckProsperityUnemployementRate_Filter starts here ................");
		// JSHelper.clickElement(Education_HighSchoolPopulation_Data_AddYearBtn);

		boolean flag = false;
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 6;
		int value = 50;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;
		int TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		int TotalRowsAfterAdding;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(Equitability_MedianGrossIncome_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Equitability_MedianGrossIncome_Data_AddYearBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + StartYear + "']";
		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
			driver.findElement(By.xpath(xpath)).click();
		} catch (Exception e) {
			e.printStackTrace();

		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate  Circular Image");
		}
		value = value + 5;

		TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		if (TotalRowsAfterAdding - TotalRowsBeforeAdding != 1) {
			flag = false;
			log.info("Record is not added for " + StartYear);

		} else {
			log.info("Record added for " + StartYear);
			StartYear++;
			for (int i = StartYear; i < CurrentYear; i++) {
				TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
				waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")),
						2);
				NextYearbutton.click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
				xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + i + "']";
				try {
					driver.findElement(By.xpath(xpath)).click();
				} catch (NoSuchElementException e) {
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
					driver.findElement(By.xpath(xpath)).click();
				} catch (Exception e) {
					e.printStackTrace();

				}
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
						.sendKeys(Integer.toString(value));
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

				try {
					waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
							Integer.parseInt(prop.getProperty("explicitTime")), 2);
				} catch (Exception e) {
					e.printStackTrace();
					log.info("Unable to locate  Circular Image");
				}

				TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
				if (TotalRowsAfterAdding - TotalRowsBeforeAdding == 1) {
					log.info("Record added for " + i);
					flag = true;
				} else {
					log.info("Record is not added for " + i);
					flag = false;
				}

				value = value + 5;
			}
		}

		if (flag) {
			ClickonGHGEmiissions();
			ClickonProsperityUnemployementRate();
			waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearFilterButton.click();
			YearStartDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Startxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterStartYear
					+ "']";
			try {
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}
			YearEndDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Endxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterEndYear + "']";
			try {
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}

			waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearUpdateBtn.click();
			CommonMethod.waitUntilLoadElement();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int RowsAfterFilter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("After Filter Total rows displaying are --" + RowsAfterFilter);
			int j = 1;
			if (RowsAfterFilter == 3) {
				for (int i = filterEndYear; i >= filterStartYear; i--) {
					String currentyear = driver
							.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
							.getAttribute("value");
					log.info("Current showing Year is --" + currentyear + "  and filter year is --" + i);
					if (!currentyear.equals(Integer.toString(i))) {
						log.info("Filtered Year not matching");
						flag = false;
						break;
					} else {
						flag = true;
					}
					j++;
				}
			} else {
				log.info("Total number of row should be displayed 3 but it is showing " + RowsAfterFilter);
				log.info("CheckProsperityUnemployementRate_Filter ends here with false ................");
				return false;
			}
			if (flag == true) {
				log.info("CheckProsperityUnemployementRate_Filter ends here with true ................");
				return true;
			} else {
				log.info("CheckProsperityUnemployementRate_Filter ends here with false ................");
				return false;
			}
		} else {
			log.info("CheckProsperityUnemployementRate_Filter ends here with false ................");
			return false;
		}

	}

	// Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive
	// groups (Days/yr) --> This method will add records and check whether filter is
	// working or not

	public boolean CheckHealthAndSafetySensitiveGroup_Filter() {
		log.info("CheckHealthAndSafetySensitiveGroup_Filter starts here ................");
		// JSHelper.clickElement(Education_HighSchoolPopulation_Data_AddYearBtn);

		boolean flag = false;
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 6;
		int value = 250;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;
		int TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		int TotalRowsAfterAdding;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(HealthAndSafetySensitiveGroup_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		HealthAndSafetySensitiveGroup_Data_AddYearBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + StartYear + "']";
		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
			driver.findElement(By.xpath(xpath)).click();
		} catch (Exception e) {
			e.printStackTrace();

		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate  Circular Image");
		}
		value = value + 5;

		TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		if (TotalRowsAfterAdding - TotalRowsBeforeAdding != 1) {
			flag = false;
			log.info("Record is not added for " + StartYear);

		} else {
			log.info("Record added for " + StartYear);
			StartYear++;
			for (int i = StartYear; i < CurrentYear; i++) {
				TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
				waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")),
						2);
				NextYearbutton.click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
				xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + i + "']";
				try {
					driver.findElement(By.xpath(xpath)).click();
				} catch (NoSuchElementException e) {
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
					driver.findElement(By.xpath(xpath)).click();
				} catch (Exception e) {
					e.printStackTrace();

				}
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
						.sendKeys(Integer.toString(value));
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

				try {
					waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
							Integer.parseInt(prop.getProperty("explicitTime")), 2);
				} catch (Exception e) {
					e.printStackTrace();
					log.info("Unable to locate  Circular Image");
				}

				TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
				if (TotalRowsAfterAdding - TotalRowsBeforeAdding == 1) {
					log.info("Record added for " + i);
					flag = true;
				} else {
					log.info("Record is not added for " + i);
					flag = false;
				}

				value = value + 5;
			}
		}

		if (flag) {
			ClickonHealthAndSafetySensitiveGroup();
			ClickonWaterConsumption();
			waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearFilterButton.click();
			YearStartDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Startxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterStartYear
					+ "']";
			try {
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}
			YearEndDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Endxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterEndYear + "']";
			try {
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}

			waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearUpdateBtn.click();
			CommonMethod.waitUntilLoadElement();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int RowsAfterFilter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("After Filter Total rows displaying are --" + RowsAfterFilter);
			int j = 1;
			if (RowsAfterFilter == 3) {
				for (int i = filterEndYear; i >= filterStartYear; i--) {
					String currentyear = driver
							.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
							.getAttribute("value");
					log.info("Current showing Year is --" + currentyear + "  and filter year is --" + i);
					if (!currentyear.equals(Integer.toString(i))) {
						log.info("Filtered Year not matching");
						flag = false;
						break;
					} else {
						flag = true;
					}
					j++;
				}
			} else {
				log.info("Total number of row should be displayed 3 but it is showing " + RowsAfterFilter);
				log.info("CheckHealthAndSafetySensitiveGroup_Filter ends here with false ................");
				return false;
			}
			if (flag == true) {
				log.info("CheckHealthAndSafetySensitiveGroup_Filter ends here with true ................");
				return true;
			} else {
				log.info("CheckHealthAndSafetySensitiveGroup_Filter ends here with false ................");
				return false;
			}
		} else {
			log.info("CheckHealthAndSafetySensitiveGroup_Filter ends here with false ................");
			return false;
		}

	}

	// Quality Of Life--> Health & Safety: Violent Crime (per year per capita) -->
	// This method will add records and check whether filter is working or not

	public boolean CheckHealthAndSafetyVoilentCrime_Filter() {
		log.info("CheckHealthAndSafetyVoilentCrime_Filter starts here ................");
		// JSHelper.clickElement(Education_HighSchoolPopulation_Data_AddYearBtn);

		boolean flag = false;
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 6;
		int value = 250;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;
		int TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		int TotalRowsAfterAdding;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(HealthAndSafetyVoilentCrime_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		HealthAndSafetyVoilentCrime_Data_AddYearBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + StartYear + "']";
		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
			driver.findElement(By.xpath(xpath)).click();
		} catch (Exception e) {
			e.printStackTrace();

		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate  Circular Image");
		}
		value = value + 5;

		TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		if (TotalRowsAfterAdding - TotalRowsBeforeAdding != 1) {
			flag = false;
			log.info("Record is not added for " + StartYear);

		} else {
			log.info("Record added for " + StartYear);
			StartYear++;
			for (int i = StartYear; i < CurrentYear; i++) {
				TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
				waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")),
						2);
				NextYearbutton.click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
				xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + i + "']";
				try {
					driver.findElement(By.xpath(xpath)).click();
				} catch (NoSuchElementException e) {
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
					driver.findElement(By.xpath(xpath)).click();
				} catch (Exception e) {
					e.printStackTrace();

				}

				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
						.sendKeys(Integer.toString(value));
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

				try {
					waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
							Integer.parseInt(prop.getProperty("explicitTime")), 2);
				} catch (Exception e) {
					e.printStackTrace();
					log.info("Unable to locate  Circular Image");
				}

				TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
				if (TotalRowsAfterAdding - TotalRowsBeforeAdding == 1) {
					log.info("Record added for " + i);
					flag = true;
				} else {
					log.info("Record is not added for " + i);
					flag = false;
				}

				value = value + 5;
			}
		}
		if (flag) {
			ClickonGHGEmiissions();
			ClickonHealthAndSafetyVoilentCrime();
			waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearFilterButton.click();
			YearStartDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Startxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterStartYear
					+ "']";
			try {
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}
			YearEndDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Endxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterEndYear + "']";
			try {
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}

			waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearUpdateBtn.click();
			CommonMethod.waitUntilLoadElement();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int RowsAfterFilter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("After Filter Total rows displaying are --" + RowsAfterFilter);
			int j = 1;
			if (RowsAfterFilter == 3) {
				for (int i = filterEndYear; i >= filterStartYear; i--) {
					String currentyear = driver
							.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
							.getAttribute("value");
					log.info("Current showing Year is --" + currentyear + "  and filter year is --" + i);
					if (!currentyear.equals(Integer.toString(i))) {
						log.info("Filtered Year not matching");
						flag = false;
						break;
					} else {
						flag = true;
					}
					j++;
				}
			} else {
				log.info("Total number of row should be displayed 3 but it is showing " + RowsAfterFilter);
				log.info("CheckHealthAndSafetyVoilentCrime_Filter ends here with false ................");
				return false;
			}
			if (flag == true) {
				log.info("CheckHealthAndSafetyVoilentCrime_Filter ends here with true ................");
				return true;
			} else {
				log.info("CheckHealthAndSafetyVoilentCrime_Filter ends here with false ................");
				return false;
			}
		} else {
			log.info("CheckHealthAndSafetyVoilentCrime_Filter ends here with false ................");
			return false;
		}

	}

	// Waste -- > Waste Generation --> This method will add records and check
	// whether filter is working or not
	public boolean CheckWaste_GenerationFilter() {
		log.info("CheckWaste_GenerationFilter starts here ................");

		boolean flag = false;
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 6;
		int tons = 100;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;
		int TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		int TotalRowsAfterAdding;
		waithelper.WaitForElementClickable(Waste_AddYearButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(Waste_AddYearButton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + StartYear + "']";
		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
			driver.findElement(By.xpath(xpath)).click();
		} catch (Exception e) {
			e.printStackTrace();

		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(tons));
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Circular Image");
		}

		tons = tons + 10;
		TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		if (TotalRowsAfterAdding - TotalRowsBeforeAdding != 1) {
			flag = false;
			log.info("Record is not added for " + StartYear);

		} else {
			log.info("Record added for " + StartYear);
			StartYear++;
			for (int i = StartYear; i < CurrentYear; i++) {
				TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");

				waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")),
						2);
				NextYearbutton.click();

				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
				xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + i + "']";
				try {
					driver.findElement(By.xpath(xpath)).click();
				} catch (NoSuchElementException e) {
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
					driver.findElement(By.xpath(xpath)).click();
				} catch (Exception e) {
					e.printStackTrace();

				}

				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
						.sendKeys(Integer.toString(tons));
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

				try {
					waithelper.WaitForElementInvisible(
							driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
							Integer.parseInt(prop.getProperty("explicitTime")), 2);
				} catch (Exception e) {
					e.printStackTrace();
					log.info("Unable to locate Circular Image");
				}
				TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
				if (TotalRowsAfterAdding - TotalRowsBeforeAdding == 1) {
					log.info("Record added for " + i);
					flag = true;
				} else {
					log.info("Record is not added for " + i);
					flag = false;
				}
				tons = tons + 2;
			}
		}
		if (flag) {
			ClickonGHGEmiissions();
			ClickonMunicipalSolidwastegeneration();
			waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearFilterButton.click();
			YearStartDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Startxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterStartYear
					+ "']";
			try {
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}
			YearEndDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Endxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterEndYear + "']";
			try {
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}

			waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearUpdateBtn.click();
			CommonMethod.waitUntilLoadElement();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int RowsAfterFilter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("After Filter Total rows displaying are --" + RowsAfterFilter);
			int j = 1;
			if (RowsAfterFilter == 3) {
				for (int i = filterEndYear; i >= filterStartYear; i--) {
					String currentyear = driver
							.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
							.getAttribute("value");
					log.info("Current showing Year is --" + currentyear + "  and filter year is --" + i);
					if (!currentyear.equals(Integer.toString(i))) {
						log.info("Filtered Year not matching");
						flag = false;
						break;
					} else {
						flag = true;
					}
					j++;
				}
			} else {
				log.info("Total number of row should be displayed 3 but it is showing " + RowsAfterFilter);
				log.info("CheckWaste_GenerationFilter ends here with false ................");
				return false;
			}
			if (flag == true) {
				log.info("CheckWaste_GenerationFilter ends here with true ................");
				return true;
			} else {
				log.info("CheckWaste_GenerationFilter ends here with false ................");
				return false;
			}
		} else {
			log.info("CheckWaste_GenerationFilter ends here with false ................");
			return false;
		}

	}

	// Waste -- > Waste Generation --> This method will add records and check
	// whether filter is working or not

	public boolean CheckWaste_DiversionFilter() {
		log.info("CheckWaste_DiversionFilter starts here ................");
		// Waste_AddYearButton.click();

		boolean flag = false;
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 6;
		int percent = 10;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;
		int TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		int TotalRowsAfterAdding;
		JSHelper.clickElement(Waste_AddYearButton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + StartYear + "']";
		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
			driver.findElement(By.xpath(xpath)).click();
		} catch (Exception e) {
			e.printStackTrace();

		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(percent));
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Circular Image");
		}

		percent = percent + 3;
		TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		if (TotalRowsAfterAdding - TotalRowsBeforeAdding != 1) {
			flag = false;
			log.info("Record is not added for " + StartYear);

		} else {
			log.info("Record added for " + StartYear);
			StartYear++;
			for (int i = StartYear; i < CurrentYear; i++) {
				TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
				waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")),
						2);
				NextYearbutton.click();

				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
				xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + i + "']";
				try {
					driver.findElement(By.xpath(xpath)).click();
				} catch (NoSuchElementException e) {
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
					driver.findElement(By.xpath(xpath)).click();
				} catch (Exception e) {
					e.printStackTrace();

				}

				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
						.sendKeys(Integer.toString(percent));
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

				try {
					waithelper.WaitForElementInvisible(
							driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
							Integer.parseInt(prop.getProperty("explicitTime")), 2);
				} catch (Exception e) {
					e.printStackTrace();
					log.info("Unable to locate  Circular Image");
				}

				TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
				if (TotalRowsAfterAdding - TotalRowsBeforeAdding == 1) {
					log.info("Record added for " + i);
					flag = true;
				} else {
					log.info("Record is not added for " + i);
					flag = false;
				}

				percent = percent + 2;
			}
		}
		if (flag) {
			ClickonGHGEmiissions();
			ClickonMunicipalSolidwastegeneration();
			waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearFilterButton.click();
			YearStartDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Startxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterStartYear
					+ "']";
			try {
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}
			YearEndDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Endxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterEndYear + "']";
			try {
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}

			waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearUpdateBtn.click();
			CommonMethod.waitUntilLoadElement();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int RowsAfterFilter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("After Filter Total rows displaying are --" + RowsAfterFilter);
			int j = 1;
			if (RowsAfterFilter == 3) {
				for (int i = filterEndYear; i >= filterStartYear; i--) {
					String currentyear = driver
							.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
							.getAttribute("value");
					log.info("Current showing Year is --" + currentyear + "  and filter year is --" + i);
					if (!currentyear.equals(Integer.toString(i))) {
						log.info("Filtered Year not matching");
						flag = false;
						break;
					} else {
						flag = true;
					}
					j++;
				}
			} else {
				log.info("Total number of row should be displayed 3 but it is showing " + RowsAfterFilter);
				log.info("CheckWaste_DiversionFilter ends here with false ................");
				return false;
			}
			if (flag == true) {
				log.info("CheckWaste_DiversionFilter ends here with true ................");
				return true;
			} else {
				log.info("CheckWaste_DiversionFilter ends here with false ................");
				return false;
			}
		} else {
			log.info("CheckWaste_DiversionFilter ends here with false ................");
			return false;
		}

	}

	// Water Consumption -- > This method will add records and check whether filter
	// is working or not

	public boolean CheckWaterFilter() {
		log.info("CheckWaterFilter starts here ................");

		boolean flag = false;
		int TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		int TotalRowsAfterAdding;
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 6;
		int value = 100;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;
		WaterConsum_Data_AddYearBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + StartYear + "']";
		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
			driver.findElement(By.xpath(xpath)).click();
		} catch (Exception e) {
			e.printStackTrace();

		}

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/button")).click();

		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/span")),
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
			log.info("Unable to locate Energy Circular Image");
		}

		value = value + 10;
		TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		if (TotalRowsAfterAdding - TotalRowsBeforeAdding != 1) {
			flag = false;
			log.info("Record is not added for " + StartYear);

		} else {
			log.info("Record added for " + StartYear);
			StartYear++;
			for (int i = StartYear; i < CurrentYear; i++) {
				TotalRowsBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
				waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")),
						2);
				NextYearbutton.click();

				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
				xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + i + "']";
				try {
					driver.findElement(By.xpath(xpath)).click();
				} catch (NoSuchElementException e) {
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
					driver.findElement(By.xpath(xpath)).click();
				} catch (Exception e) {
					e.printStackTrace();

				}

				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
						.sendKeys(Integer.toString(value));
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/button")).click();

				try {
					waithelper.WaitForElementVisibleWithPollingTime(
							driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/span")),
							Integer.parseInt(prop.getProperty("explicitTime")), 2);

				} catch (Exception e) {
					e.printStackTrace();
					log.info("Unable to locate Row Circular Image");
				}

				try {
					waithelper.WaitForElementInvisible(
							driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
							Integer.parseInt(prop.getProperty("explicitTime")), 2);
				} catch (Exception e) {
					e.printStackTrace();
					log.info("Unable to locate Water Circular Image");
				}

				TotalRowsAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
				if (TotalRowsAfterAdding - TotalRowsBeforeAdding == 1) {
					log.info("Record added for " + i);
					flag = true;
				} else {
					log.info("Record is not added for " + i);
					flag = false;
				}
				value = value + 2;
			}
		}

		if (flag) {
			ClickonGHGEmiissions();
			ClickonWaterConsumption();
			waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearFilterButton.click();
			YearStartDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Startxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterStartYear
					+ "']";
			try {
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Startxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}
			YearEndDateTextBox.click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			String Endxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterEndYear + "']";
			try {
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
				driver.findElement(By.xpath(Endxpath)).click();
			} catch (Exception e) {
				e.printStackTrace();

			}

			waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			YearUpdateBtn.click();
			CommonMethod.waitUntilLoadElement();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int RowsAfterFilter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("After Filter Total rows displaying are --" + RowsAfterFilter);
			int j = 1;
			if (RowsAfterFilter == 3) {
				for (int i = filterEndYear; i >= filterStartYear; i--) {
					String currentyear = driver
							.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
							.getAttribute("value");
					log.info("Current showing Year is --" + currentyear + "  and filter year is --" + i);
					if (!currentyear.equals(Integer.toString(i))) {
						log.info("Filtered Year not matching");
						flag = false;
						break;
					} else {
						flag = true;
					}
					j++;
				}
			} else {
				log.info("Total number of row should be displayed 3 but it is showing " + RowsAfterFilter);
				log.info("CheckWaterFilter ends here with false ................");
				return false;
			}
			if (flag == true) {
				log.info("CheckWaterFilter ends here with true ................");
				return true;
			} else {
				log.info("CheckWaterFilter ends here with false ................");
				return false;
			}
		} else {
			log.info("CheckWaterFilter ends here with false ................");
			return false;
		}

	}
	// This method will check whether newly added row in Population is saved
	// successfully or not

	public boolean verifyAddedProject_Setting_ProjectAreaRow() {
		log.info("verifyAddedProject_Setting_ProjectAreaRow starts here ................");

		JSHelper.clickElement(ProjectAreaTab);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//*[contains(text(),'PROJECT AREA')]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		boolean AddedRowFlag = false;
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		log.info("Total Row display is ---  " + rows.size());
		log.info("Total Row display is ---  " + rows.size());
		if (rows.size() > 1) {
			log.info("Added Row showing proper----");
			AddedRowFlag = true;
		} else {
			log.info("Added Row is not showing proper----");
			AddedRowFlag = false;
		}
		if (AddedRowFlag) {
			log.info("verifyAddedProject_Setting_ProjectAreaRow method ends here .........");
			return true;
		} else {
			log.info("verifyAddedProject_Setting_ProjectAreaRow method ends here .........");
			return false;
		}
	}

	// This method will check whether population field contains comma or not

	public boolean verifyPopulationField_Contains_Comma() {
		log.info("verifyPopulationField_Contains_Comma starts here ................");
		PopulationTab.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String PopulationValue = Population_populationTextBox.getAttribute("value");
		log.info("Population Value is --" + PopulationValue);
		if (PopulationValue.contains(",")) {
			log.info("verifyPopulationField_Contains_Comma method ends here .........");
			return true;

		} else {
			log.info("verifyPopulationField_Contains_Comma method ends here .........");
			return false;
		}
	}

	public boolean verifyProjectAreaField_Contains_Comma() {
		log.info("verifyProjectAreaField_Contains_Comma starts here ................");
		waithelper.WaitForElementClickable(ProjectAreaTab, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(ProjectAreaTab);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//*[contains(text(),'PROJECT AREA')]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String ProjectAreaValue = ProjectAreaTextBox.getAttribute("value");
		log.info("Project Area Value is --" + ProjectAreaValue);
		if (ProjectAreaValue.contains(",")) {
			log.info("verifyProjectAreaField_Contains_Comma method ends here .........");
			return true;

		} else {
			log.info("verifyProjectAreaField_Contains_Comma method ends here .........");
			return false;
		}
	}

	public boolean checkPopulation_AddRow_Data() {

		boolean flag = false;
		try {
			PopulationTab.click();
			Thread.sleep(2000);
			waithelper.WaitForElementClickable(ProjectSettingAddRowButton,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			ProjectSettingAddRowButton.click();

			if (PopulationEffectiveYearHeading.getText().equals("EFFECTIVE YEAR")
					&& Population_populationHeading.getText().equals("POPULATION")
					&& Population_UpdatedByHeading.getText().equals("UPDATED BY")
					&& Population_SaveButton.isDisplayed() == true && Population_DeleteButton.isDisplayed() == true) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}

	public void Add_Row_PopulationTab() {

		ProjectSettingButton.click();
		waithelper.WaitForElementVisibleWithPollingTime(PerformanceHeaderText,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		DataInputSubMenu.click();
		waithelper.WaitForElementVisibleWithPollingTime(ProjectSettingButton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

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

	public boolean CheckProjectDetails(String PName, String PAddress) {
		log.info("CheckProjectDetails method starts here......");
		String City = data.getCellData("ProjectRegistration", 4, 2);
		String Country = data.getCellData("ProjectRegistration", 5, 2);
		String State = data.getCellData("ProjectRegistration", 6, 2);
		// String ZipCode= data.getCellData("ProjectRegistration", 7, 2);
		String ProjectID = driver.findElement(By.xpath("//div[text()='Project ID']/following-sibling::div")).getText();
		String ProjectName = driver.findElement(By.xpath("//input[@name='name']")).getAttribute("value");
		String ProjectAddress = driver.findElement(By.xpath("//div[text()='Project Address']/following-sibling::div"))
				.getText();
		String ProjectCity = driver.findElement(By.xpath("//div[text()='Project City']/following-sibling::div"))
				.getText();
		String ProjectCountry = driver
				.findElement(By.xpath("//div[text()='Project Country/Region']/following-sibling::div")).getText();
		String ProjectState = driver.findElement(By.xpath("//div[text()='Project State']/following-sibling::div"))
				.getText();
		boolean TestFlag = CheckThisIsTestProjectCheckBox(ProjectID);
		log.info("Actual Project ID is " + ProjectID);
		log.info("Expected Project ID is " + System.getProperty("CityProject5"));
		log.info("Actual Project Name is " + ProjectName);
		log.info("Expected Project Name is " + PName);
		log.info("Actual Project Address " + ProjectAddress);
		log.info("Expected Project Address is " + PAddress);
		log.info("Actual Project City " + ProjectCity);
		log.info("Expected Project City is " + City);
		log.info("Actual Project State " + ProjectState);
		log.info("Expected Project State is " + State);
		log.info("Actual Project Country " + ProjectCountry);
		log.info("Expected Project Country is " + Country);
		log.info("Actual Project Country " + ProjectCountry);
		if (ProjectID.equals(System.getProperty("CityProject5")) && ProjectName.equals(PName)
				&& ProjectAddress.equals(PAddress) && ProjectCity.equals(City) && ProjectState.equals(State)
				&& ProjectCountry.equals(Country) && (TestFlag == false)) {
			log.info("CheckProjectDetails method ends here with true......");
			return true;
		} else {
			log.info("CheckProjectDetails method ends here with false......");
			return true;
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

	public String CheckPerformanceHeaderShowing() {
		try {

			waithelper.WaitForElementVisibleWithPollingTime(PerformanceHeaderText,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			log.info("PerformanceHeaderText.getText() value is ---- " + PerformanceHeaderText.isDisplayed());
			return PerformanceHeaderText.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	// This method will check whether Data and Details Tab is displaying or not
	// (Data Input - > GHG Emission - > Data/Details Tab

	public boolean CheckGHGEmission_Data_DetailsTab_Display() {
		log.info("CheckGHGEmission_Data_DetailsTab_Display  starts here........");
		boolean DataTabflag = false;
		boolean DetailsTabflag = false;
		DataTabflag = GHGEmission_DataTab.isDisplayed();
		log.info("Data Tab display status is --" + DataTabflag);
		DetailsTabflag = GHGEmission_DetailsTab.isDisplayed();
		log.info("Details Tab display status is --" + DetailsTabflag);

		if (DataTabflag && DetailsTabflag) {
			log.info("CheckGHGEmission_Data_DetailsTab_Display  ends here........");
			return true;
		} else {
			log.info("CheckGHGEmission_Data_DetailsTab_Display  ends here........");
			return false;
		}

	}

	// This method will check whether Data and Details Tab is displaying or not
	// (Data Input - > Transportation - > Data/Details Tab

	public boolean CheckVMT_Data_DetailsTab_Display() {
		log.info("CheckVMT_Data_DetailsTab_Display  starts here........");
		boolean DataTabflag = false;
		boolean DetailsTabflag = false;
		DataTabflag = VMT_DataTab.isDisplayed();
		log.info("Data Tab display status is --" + DataTabflag);
		DetailsTabflag = VMT_DetailsTab.isDisplayed();
		log.info("Details Tab display status is --" + DetailsTabflag);

		if (DataTabflag && DetailsTabflag) {
			log.info("CheckVMT_Data_DetailsTab_Display  ends here........");
			return true;
		} else {
			log.info("CheckVMT_Data_DetailsTab_Display  ends here........");
			return false;
		}

	}

	// This method will check whether Data and Details Tab is displaying or not
	// (Data Input - > Quality Of life --> Health And Safety - > Data/Details Tab

	public boolean CheckHealthAndSafety_Data_DetailsTab_Display() {
		log.info("CheckHealthAndSafety_Data_DetailsTab_Display  starts here........");
		boolean DataTabflag = false;
		boolean DetailsTabflag = false;
		DataTabflag = HealthAndSafety_DataTab.isDisplayed();
		log.info("Data Tab display status is --" + DataTabflag);
		DetailsTabflag = HealthAndSafety_DetailsTab.isDisplayed();
		log.info("Details Tab display status is --" + DetailsTabflag);

		if (DataTabflag && DetailsTabflag) {
			log.info("CheckHealthAndSafety_Data_DetailsTab_Display  ends here........");
			return true;
		} else {
			log.info("CheckHealthAndSafety_Data_DetailsTab_Display  ends here........");
			return false;
		}

	}
	// This method will check whether Data and Details Tab is displaying or not
	// (Data Input - > Quality Of life --> Education: Population with (at least)
	// Bachelor's degree (%) - > Data/Details Tab

	public boolean CheckEducation_BachelorPopulation_Data_DetailsTab_Display() {
		log.info("CheckEducation_BachelorPopulation_Data_DetailsTab_Display  starts here........");
		boolean DataTabflag = false;
		boolean DetailsTabflag = false;
		DataTabflag = Education_BachelorPopulation_DataTab.isDisplayed();
		log.info("Data Tab display status is --" + DataTabflag);
		DetailsTabflag = Education_BachelorPopulation_DetailsTab.isDisplayed();
		log.info("Details Tab display status is --" + DetailsTabflag);

		if (DataTabflag && DetailsTabflag) {
			log.info("CheckEducation_BachelorPopulation_Data_DetailsTab_Display  ends here........");
			return true;
		} else {
			log.info("CheckEducation_BachelorPopulation_Data_DetailsTab_Display  ends here........");
			return false;
		}

	}
	// This method will check whether Data and Details Tab is displaying or not
	// (Data Input - > Quality Of life --> Equitability: Gini coefficient (for
	// income distribution) - > Data/Details Tab

	public boolean CheckEquitability_Gini_Coefficient_Data_DetailsTab_Display() {
		log.info("CheckEquitability_Gini_Coefficient_Data_DetailsTab_Display  starts here........");
		boolean DataTabflag = false;
		boolean DetailsTabflag = false;
		DataTabflag = Equitability_Gini_Coefficient_DataTab.isDisplayed();
		log.info("Data Tab display status is --" + DataTabflag);
		DetailsTabflag = Equitability_Gini_Coefficient_DetailsTab.isDisplayed();
		log.info("Details Tab display status is --" + DetailsTabflag);

		if (DataTabflag && DetailsTabflag) {
			log.info("CheckEquitability_Gini_Coefficient_Data_DetailsTab_Display  ends here........");
			return true;
		} else {
			log.info("CheckEquitability_Gini_Coefficient_Data_DetailsTab_Display  ends here........");
			return false;
		}

	}

	// This method will check whether Data and Details Tab is displaying or not
	// (Data Input - > Quality Of life --> Education: Population with (at least)
	// High School degree (%) - > Data/Details Tab

	public boolean CheckEducation_HighSchoolPopulation_Data_DetailsTab_Display() {
		log.info("CheckEducation_HighSchoolPopulation_Data_DetailsTab_Display  starts here........");
		boolean DataTabflag = false;
		boolean DetailsTabflag = false;
		DataTabflag = Education_HighSchoolPopulation_DataTab.isDisplayed();
		log.info("Data Tab display status is --" + DataTabflag);
		DetailsTabflag = Education_HighSchoolPopulation_DetailsTab.isDisplayed();
		log.info("Details Tab display status is --" + DetailsTabflag);

		if (DataTabflag && DetailsTabflag) {
			log.info("CheckEducation_HighSchoolPopulation_Data_DetailsTab_Display  ends here........");
			return true;
		} else {
			log.info("CheckEducation_HighSchoolPopulation_Data_DetailsTab_Display  ends here........");
			return false;
		}

	}

	// This method will check whether Data and Details Tab is displaying or not
	// (Data Input - > Quality Of life --> Prosperity: Median household income (US
	// Dollars/Year) - > Data/Details Tab

	public boolean CheckProsperityMedianIncome_Data_DetailsTab_Display() {
		log.info("CheckProsperityMedianIncome_Data_DetailsTab_Display  starts here........");
		boolean DataTabflag = false;
		boolean DetailsTabflag = false;
		DataTabflag = ProsperityMedianIncome_DataTab.isDisplayed();
		log.info("Data Tab display status is --" + DataTabflag);
		DetailsTabflag = ProsperityMedianIncome_DetailsTab.isDisplayed();
		log.info("Details Tab display status is --" + DetailsTabflag);

		if (DataTabflag && DetailsTabflag) {
			log.info("CheckProsperityMedianIncome_Data_DetailsTab_Display  ends here........");
			return true;
		} else {
			log.info("CheckProsperityMedianIncome_Data_DetailsTab_Display  ends here........");
			return false;
		}

	}

	// This method will check whether Data and Details Tab is displaying or not
	// (Data Input - > Quality Of life --> Equitability: Median gross rent as (%) of
	// household income - > Data/Details Tab

	public boolean CheckEquitability_MedianGrossIncome_Data_DetailsTab_Display() {
		log.info("CheckEquitability_MedianGrossIncome_Data_DetailsTab_Display  starts here........");
		boolean DataTabflag = false;
		boolean DetailsTabflag = false;
		DataTabflag = Equitability_MedianGrossIncome_DataTab.isDisplayed();
		log.info("Data Tab display status is --" + DataTabflag);
		DetailsTabflag = Equitability_MedianGrossIncome_DetailsTab.isDisplayed();
		log.info("Details Tab display status is --" + DetailsTabflag);

		if (DataTabflag && DetailsTabflag) {
			log.info("CheckEquitability_MedianGrossIncome_Data_DetailsTab_Display  ends here........");
			return true;
		} else {
			log.info("CheckEquitability_MedianGrossIncome_Data_DetailsTab_Display  ends here........");
			return false;
		}

	}
	// This method will check whether Data and Details Tab is displaying or not
	// (Data Input - > Quality Of life --> Prosperity: Unemployment rate (%) - >
	// Data/Details Tab

	public boolean CheckProsperityUnemployementRate_Data_DetailsTab_Display() {
		log.info("CheckProsperityUnemployementRate_Data_DetailsTab_Display  starts here........");
		boolean DataTabflag = false;
		boolean DetailsTabflag = false;
		DataTabflag = ProsperityUnemployementRate_DataTab.isDisplayed();
		log.info("Data Tab display status is --" + DataTabflag);
		DetailsTabflag = ProsperityUnemployementRate_DetailsTab.isDisplayed();
		log.info("Details Tab display status is --" + DetailsTabflag);

		if (DataTabflag && DetailsTabflag) {
			log.info("CheckProsperityUnemployementRate_Data_DetailsTab_Display  ends here........");
			return true;
		} else {
			log.info("CheckProsperityUnemployementRate_Data_DetailsTab_Display  ends here........");
			return false;
		}

	}

	// This method will check whether Data and Details Tab is displaying or not
	// (Data Input - > Quality Of life --> Health & Safety: Air quality days
	// unhealthy for sensitive groups (Days/yr) - > Data/Details Tab

	public boolean CheckHealthAndSafetySensitiveGroup_Data_DetailsTab_Display() {
		log.info("CheckProsperityUnemployementRate_Data_DetailsTab_Display  starts here........");
		boolean DataTabflag = false;
		boolean DetailsTabflag = false;
		DataTabflag = HealthAndSafetySensitiveGroup_DataTab.isDisplayed();
		log.info("Data Tab display status is --" + DataTabflag);
		DetailsTabflag = HealthAndSafetySensitiveGroup_DetailsTab.isDisplayed();
		log.info("Details Tab display status is --" + DetailsTabflag);

		if (DataTabflag && DetailsTabflag) {
			log.info("CheckHealthAndSafetySensitiveGroup_Data_DetailsTab_Display  ends here........");
			return true;
		} else {
			log.info("CheckHealthAndSafetySensitiveGroup_Data_DetailsTab_Display  ends here........");
			return false;
		}

	}

	// This method will check whether Data and Details Tab is displaying or not
	// (Data Input - > Quality Of life -->Health & Safety: Violent Crime (per year
	// per capita) - > Data/Details Tab

	public boolean CheckHealthAndSafetyVoilentCrime_Data_DetailsTab_Display() {
		log.info("CheckHealthAndSafetyVoilentCrime_Data_DetailsTab_Display  starts here........");
		boolean DataTabflag = false;
		boolean DetailsTabflag = false;
		DataTabflag = HealthAndSafetyVoilentCrime_DataTab.isDisplayed();
		log.info("Data Tab display status is --" + DataTabflag);
		DetailsTabflag = HealthAndSafetyVoilentCrime_DetailsTab.isDisplayed();
		log.info("Details Tab display status is --" + DetailsTabflag);

		if (DataTabflag && DetailsTabflag) {
			log.info("CheckHealthAndSafetyVoilentCrime_Data_DetailsTab_Display  ends here........");
			return true;
		} else {
			log.info("CheckHealthAndSafetyVoilentCrime_Data_DetailsTab_Display  ends here........");
			return false;
		}

	}
	// This method will check whether Data and Details Tab is displaying or not
	// (Data Input - > Waste - > Municipal solid waste generation
	// intensityData/Details Tab

	public boolean CheckWasteGeneration_Data_DetailsTab_Display() {
		log.info("CheckWasteGeneration_Data_DetailsTab_Display  starts here........");
		boolean DataTabflag = false;
		boolean DetailsTabflag = false;
		DataTabflag = Waste_DataTab.isDisplayed();
		log.info("Data Tab display status is --" + DataTabflag);
		DetailsTabflag = Waste_DetailsTab.isDisplayed();
		log.info("Details Tab display status is --" + DetailsTabflag);

		if (DataTabflag && DetailsTabflag) {
			log.info("CheckWasteGeneration_Data_DetailsTab_Display  ends here........");
			return true;
		} else {
			log.info("CheckWasteGeneration_Data_DetailsTab_Display  ends here........");
			return false;
		}

	}

	// This method will check whether Data and Details Tab is displaying or not
	// (Data Input - > Waste - > Municipal solid waste diversion rate from landfill
	// Data/Details Tab

	public boolean CheckWasteDiversion_Data_DetailsTab_Display() {
		log.info("CheckWasteDiversion_Data_DetailsTab_Display  starts here........");
		boolean DataTabflag = false;
		boolean DetailsTabflag = false;
		DataTabflag = Waste_DataTab.isDisplayed();
		log.info("Data Tab display status is --" + DataTabflag);
		DetailsTabflag = Waste_DetailsTab.isDisplayed();
		log.info("Details Tab display status is --" + DetailsTabflag);

		if (DataTabflag && DetailsTabflag) {
			log.info("CheckWasteDiversion_Data_DetailsTab_Display  ends here........");
			return true;
		} else {
			log.info("CheckWasteDiversion_Data_DetailsTab_Display  ends here........");
			return false;
		}

	}

	// This method will check whether Data and Details Tab is displaying or not
	// (Data Input - > Waste - > Data/Details Tab

	public boolean CheckWaterConsumption_Data_DetailsTab_Display() {
		log.info("CheckGHGEmission_Data_DetailsTab_Display  starts here........");
		boolean DataTabflag = false;
		boolean DetailsTabflag = false;
		DataTabflag = WaterConsum_DataTab.isDisplayed();
		log.info("Data Tab display status is --" + DataTabflag);
		DetailsTabflag = WaterConsum_DetailsTab.isDisplayed();
		log.info("Details Tab display status is --" + DetailsTabflag);

		if (DataTabflag && DetailsTabflag) {
			log.info("CheckWaterConsumption_Data_DetailsTab_Display  ends here........");
			return true;
		} else {
			log.info("CheckWaterConsumption_Data_DetailsTab_Display  ends here........");
			return false;
		}

	}

	// This method will check on clicking Add Year button, new row should be listed
	// with previous year (Data Input - > GHG Emission - > Data/Details Tab

	public boolean CheckGHGEmission_AddYear_NewRow_Display() {
		log.info("CheckGHGEmission_Data_DetailsTab_Display  starts here........");
		GHGEmission_Data_AddYearBtn.click();
		int CurrentYear = CommonMethod.getCurrentYear();
		int YearValue = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		int PreviousYear = CurrentYear - 1;
		if (YearValue == PreviousYear) {
			log.info("CheckGHGEmission_AddYear_NewRow_Display  ends here........");
			return true;
		} else {
			log.info("CheckGHGEmission_AddYear_NewRow_Display  ends here........");
			return false;
		}

	}

	// This method will check on clicking Add Year button, new row should be listed
	// with previous year (Data Input - > Transportation - > Data/Details Tab

	public boolean CheckTransport_VMT_AddYear_NewRow_Display() {
		log.info("CheckTransport_VMT_AddYear_NewRow_Display  starts here........");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(VMT_Data_AddYearBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		VMT_Data_AddYearBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(PreviousYearbutton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		int CurrentYear = CommonMethod.getCurrentYear();
		int YearValue = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		int PreviousYear = CurrentYear - 1;
		if (YearValue == PreviousYear) {
			log.info("CheckTransport_VMT_AddYear_NewRow_Display  ends here........");
			return true;
		} else {
			log.info("CheckTransport_VMT_AddYear_NewRow_Display  ends here........");
			return false;
		}

	}

	// This method will check on clicking Add Year button, new row should be listed
	// with previous year (Data Input - > Quality Of Life - > Health & Safety:
	// Median air quality index (AQI)--> Data/Details Tab

	public boolean CheckHealthAndSafety_AddYear_NewRow_Display() {
		log.info("CheckHealthAndSafety_AddYear_NewRow_Display  starts here........");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(HealthAndSafety_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		HealthAndSafety_Data_AddYearBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(PreviousYearbutton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		int CurrentYear = CommonMethod.getCurrentYear();
		int YearValue = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		int PreviousYear = CurrentYear - 1;
		if (YearValue == PreviousYear) {
			log.info("CheckHealthAndSafety_AddYear_NewRow_Display  ends here........");
			return true;
		} else {
			log.info("CheckHealthAndSafety_AddYear_NewRow_Display  ends here........");
			return false;
		}

	}

	public boolean CheckHealthAndSafety_CheckWithInvalidValue() {
		log.info("CheckWaste_Diversion_CheckWithInvalidPercent  starts here........");
		List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		TableRow.size();
		log.info("Before adding number of row showing is ---" + TableRow.size());
		boolean flag = false;
		boolean ValidationMsg = false;
		waithelper.WaitForElementClickable(HealthAndSafety_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HealthAndSafety_Data_AddYearBtn.click();
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		log.info("Selected Year is ---" + Selected_Year);
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).sendKeys("501");

			ValidationMsg = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[1]"))
					.isDisplayed();
			if (ValidationMsg) {
				String ActualValMsg = driver
						.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[1]")).getText();
				log.info("Validation Message displayed ---" + ActualValMsg);
				if (ActualValMsg.equals("Invalid Reading (Min:0, Max; 500)"))
					flag = true;
				else
					flag = false;
			} else {
				log.info("Validation Message not displayed..");
			}
			log.info("CheckHealthAndSafety_CheckWithInvalidValue  ends here........");
			return flag;
		}
		return flag;

	}
	// This method will check on clicking Add Year button, new row should be listed
	// with previous year (Data Input - > Quality of Life -- > Education: Population
	// with (at least) Bachelor's degree (%)--> Data/Details Tab

	public boolean CheckEducation_Bachelor_Population_AddYear_NewRow_Display() {
		log.info("CheckEducation_Bachelor_Population_AddYear_NewRow_Display  starts here........");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(Education_BachelorPopulation_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Education_BachelorPopulation_Data_AddYearBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(PreviousYearbutton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		int CurrentYear = CommonMethod.getCurrentYear();
		int YearValue = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		int PreviousYear = CurrentYear - 1;
		if (YearValue == PreviousYear) {
			log.info("CheckEducation_Bachelor_Population_AddYear_NewRow_Display  ends here........");
			return true;
		} else {
			log.info("CheckEducation_Bachelor_Population_AddYear_NewRow_Display  ends here........");
			return false;
		}

	}

	public boolean CheckEducation_Bachelor_Population_CheckWithInvalidPercent() {
		log.info("CheckEducation_Bachelor_Population_CheckWithInvalidPercent  starts here........");
		List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		TableRow.size();
		log.info("Before adding number of row showing is ---" + TableRow.size());
		boolean flag = false;
		boolean ValidationMsg = false;
		waithelper.WaitForElementClickable(Education_BachelorPopulation_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Education_BachelorPopulation_Data_AddYearBtn.click();
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		log.info("Selected Year is ---" + Selected_Year);
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).sendKeys("101");

			ValidationMsg = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[1]"))
					.isDisplayed();
			if (ValidationMsg) {
				String ActualValMsg = driver
						.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[1]")).getText();
				log.info("Validation Message displayed ---" + ActualValMsg);
				if (ActualValMsg.equals("Exceeded maximum value (Max: 100)"))
					flag = true;
				else
					flag = false;
			} else {
				log.info("Validation Message not displayed..");
			}
			log.info("CheckEducation_Bachelor_Population_CheckWithInvalidPercent  ends here........");
			return flag;
		}
		return flag;

	}

	// This method will check on clicking Add Year button, new row should be listed
	// with previous year (Data Input - > Quality of Life -- > Equitability: Gini
	// coefficient (for income distribution)--> Data/Details Tab

	public boolean CheckEquitability_Gini_Coefficient_AddYear_NewRow_Display() {
		log.info("CheckEquitability_Gini_Coefficient_AddYear_NewRow_Display  starts here........");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(Equitability_Gini_Coefficient_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Equitability_Gini_Coefficient_Data_AddYearBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(PreviousYearbutton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		int CurrentYear = CommonMethod.getCurrentYear();
		int YearValue = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		int PreviousYear = CurrentYear - 1;
		if (YearValue == PreviousYear) {
			log.info("CheckEquitability_Gini_Coefficient_AddYear_NewRow_Display  ends here........");
			return true;
		} else {
			log.info("CheckEquitability_Gini_Coefficient_AddYear_NewRow_Display  ends here........");
			return false;
		}

	}

	public boolean CheckEquitability_Gini_Coefficient_CheckWithInvalidValue() {
		log.info("CheckEquitability_Gini_Coefficient_CheckWithInvalidValue  starts here........");
		List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		TableRow.size();
		log.info("Before adding number of row showing is ---" + TableRow.size());
		boolean flag = false;
		boolean ValidationMsg = false;
		waithelper.WaitForElementClickable(Equitability_Gini_Coefficient_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Equitability_Gini_Coefficient_Data_AddYearBtn.click();
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		log.info("Selected Year is ---" + Selected_Year);
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).sendKeys("2");

			ValidationMsg = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[1]"))
					.isDisplayed();
			if (ValidationMsg) {
				String ActualValMsg = driver
						.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[1]")).getText();
				log.info("Validation Message displayed ---" + ActualValMsg);
				if (ActualValMsg.equals("Invalid Reading (Min:0, Max; 1)"))
					flag = true;
				else
					flag = false;
			} else {
				log.info("Validation Message not displayed..");
			}
			log.info("CheckEducation_Bachelor_Population_CheckWithInvalidPercent  ends here........");
			return flag;
		}
		return flag;

	}
	// This method will check on clicking Add Year button, new row should be listed
	// with previous year (Data Input - > Quality of Life -- > Education: Population
	// with (at least) High School degree (%)--> Data/Details Tab

	public boolean CheckEducation_HighSchoolPopulation_AddYear_NewRow_Display() {
		log.info("CheckEducation_HighSchoolPopulation_AddYear_NewRow_Display  starts here........");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(Education_HighSchoolPopulation_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Education_HighSchoolPopulation_Data_AddYearBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(PreviousYearbutton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		int CurrentYear = CommonMethod.getCurrentYear();
		int YearValue = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		int PreviousYear = CurrentYear - 1;
		if (YearValue == PreviousYear) {
			log.info("CheckEducation_HighSchoolPopulation_AddYear_NewRow_Display  ends here........");
			return true;
		} else {
			log.info("CheckEducation_HighSchoolPopulation_AddYear_NewRow_Display  ends here........");
			return false;
		}

	}

	public boolean CheckEducation_HighSchoolPopulation_CheckWithInvalidPercent() {
		log.info("CheckEducation_HighSchoolPopulation_CheckWithInvalidPercent  starts here........");
		List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		TableRow.size();
		log.info("Before adding number of row showing is ---" + TableRow.size());
		boolean flag = false;
		boolean ValidationMsg = false;
		waithelper.WaitForElementClickable(Education_HighSchoolPopulation_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Education_HighSchoolPopulation_Data_AddYearBtn.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		log.info("Selected Year is ---" + Selected_Year);
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).sendKeys("101");

			ValidationMsg = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[1]"))
					.isDisplayed();
			if (ValidationMsg) {

				String ActualValMsg = driver
						.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[1]")).getText();
				log.info("Validation Message displayed ---" + ActualValMsg);
				if (ActualValMsg.equals("Exceeded maximum value (Max: 100)"))
					flag = true;
				else
					flag = false;
			} else {
				log.info("Validation Message not displayed..");
			}
			log.info("CheckEducation_HighSchoolPopulation_CheckWithInvalidPercent  ends here........");
			return flag;
		}
		return flag;

	}

	// This method will check on clicking Add Year button, new row should be listed
	// with previous year (Data Input - > Quality of Life -- > Prosperity: Median
	// household income (US Dollars/Year)--> Data/Details Tab

	public boolean CheckProsperityMedianIncome_AddYear_NewRow_Display() {
		log.info("CheckProsperityMedianIncome_AddYear_NewRow_Display  starts here........");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(ProsperityMedianIncome_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ProsperityMedianIncome_Data_AddYearBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(PreviousYearbutton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		int CurrentYear = CommonMethod.getCurrentYear();
		int YearValue = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		int PreviousYear = CurrentYear - 1;
		if (YearValue == PreviousYear) {
			log.info("CheckProsperityMedianIncome_AddYear_NewRow_Display  ends here........");
			return true;
		} else {
			log.info("CheckProsperityMedianIncome_AddYear_NewRow_Display  ends here........");
			return false;
		}

	}
	// This method will check on clicking Add Year button, new row should be listed
	// with previous year (Data Input - > Quality of Life -- > Equitability: Median
	// gross rent as (%) of household income--> Data/Details Tab

	public boolean CheckEquitability_MedianGrossIncome_AddYear_NewRow_Display() {
		log.info("CheckEquitability_MedianGrossIncome_AddYear_NewRow_Display  starts here........");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(Equitability_MedianGrossIncome_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Equitability_MedianGrossIncome_Data_AddYearBtn.click();

		waithelper.WaitForElementVisibleWithPollingTime(PreviousYearbutton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		int CurrentYear = CommonMethod.getCurrentYear();
		int YearValue = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		int PreviousYear = CurrentYear - 1;
		if (YearValue == PreviousYear) {
			log.info("CheckEquitability_MedianGrossIncome_AddYear_NewRow_Display  ends here........");
			return true;
		} else {
			log.info("CheckEquitability_MedianGrossIncome_AddYear_NewRow_Display  ends here........");
			return false;
		}

	}

	public boolean CheckEquitability_MedianGrossIncome_CheckWithInvalidPercentValue() {
		log.info("CheckEquitability_MedianGrossIncome_CheckWithInvalidPercentValue  starts here........");
		List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		TableRow.size();
		log.info("Before adding number of row showing is ---" + TableRow.size());
		boolean flag = false;
		boolean ValidationMsg = false;
		waithelper.WaitForElementClickable(Equitability_MedianGrossIncome_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Equitability_MedianGrossIncome_Data_AddYearBtn.click();

		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		log.info("Selected Year is ---" + Selected_Year);
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).sendKeys("101");

			ValidationMsg = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[1]"))
					.isDisplayed();
			if (ValidationMsg) {
				String ActualValMsg = driver
						.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[1]")).getText();
				log.info("Validation Message displayed ---" + ActualValMsg);
				if (ActualValMsg.equals("Exceeded maximum value (Max: 100)"))
					flag = true;
				else
					flag = false;

			} else {
				log.info("Validation Message not displayed..");
			}
			log.info("CheckEquitability_MedianGrossIncome_CheckWithInvalidPercentValue  ends here........");
			return flag;
		}
		return flag;

	}

	// This method will check on clicking Add Year button, new row should be listed
	// with previous year (Data Input - > Quality of Life -- > Prosperity:
	// Unemployment rate (%)--> Data/Details Tab

	public boolean CheckProsperityUnemployementRate_AddYear_NewRow_Display() {
		log.info("CheckProsperityUnemployementRate_AddYear_NewRow_Display  starts here........");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(ProsperityUnemployementRate_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProsperityUnemployementRate_Data_AddYearBtn.click();

		waithelper.WaitForElementVisibleWithPollingTime(PreviousYearbutton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		int CurrentYear = CommonMethod.getCurrentYear();
		int YearValue = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		int PreviousYear = CurrentYear - 1;
		if (YearValue == PreviousYear) {
			log.info("CheckProsperityUnemployementRate_AddYear_NewRow_Display  ends here........");
			return true;
		} else {
			log.info("CheckProsperityUnemployementRate_AddYear_NewRow_Display  ends here........");
			return false;
		}

	}

	public boolean CheckProsperityUnemployementRate_CheckWithInvalidValue() {
		log.info("CheckProsperityUnemployementRate_CheckWithInvalidValue  starts here........");
		List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		TableRow.size();
		log.info("Before adding number of row showing is ---" + TableRow.size());
		boolean flag = false;
		boolean ValidationMsg = false;
		waithelper.WaitForElementClickable(ProsperityUnemployementRate_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProsperityUnemployementRate_Data_AddYearBtn.click();

		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		log.info("Selected Year is ---" + Selected_Year);
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).sendKeys("101");

			ValidationMsg = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[1]"))
					.isDisplayed();
			if (ValidationMsg) {

				String ActualValMsg = driver
						.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[1]")).getText();
				log.info("Validation Message displayed ---" + ActualValMsg);
				if (ActualValMsg.equals("Exceeded maximum value (Max: 100)"))
					flag = true;
				else
					flag = false;
			} else {
				log.info("Validation Message not displayed..");
			}
			log.info("CheckProsperityUnemployementRate_CheckWithInvalidValue  ends here........");
			return flag;
		}
		return flag;

	}
	// This method will check on clicking Add Year button, new row should be listed
	// with previous year (Data Input - > Quality of Life -- > Health & Safety:
	// Violent Crime (per year per capita)--> Data/Details Tab

	public boolean CheckHealthAndSafetyVoilentCrime_AddYear_NewRow_Display() {
		log.info("CheckHealthAndSafetyVoilentCrime_AddYear_NewRow_Display  starts here........");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(HealthAndSafetyVoilentCrime_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HealthAndSafetyVoilentCrime_Data_AddYearBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(PreviousYearbutton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		int CurrentYear = CommonMethod.getCurrentYear();
		int YearValue = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		int PreviousYear = CurrentYear - 1;
		if (YearValue == PreviousYear) {
			log.info("CheckHealthAndSafetyVoilentCrime_AddYear_NewRow_Display  ends here........");
			return true;
		} else {
			log.info("CheckHealthAndSafetyVoilentCrime_AddYear_NewRow_Display  ends here........");
			return false;
		}

	}

	public boolean CheckHealthAndSafetySensitiveGroup_CheckWithInvalidValue() {
		log.info("CheckHealthAndSafetySensitiveGroup_CheckWithInvalidValue  starts here........");
		List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		TableRow.size();
		log.info("Before adding number of row showing is ---" + TableRow.size());
		boolean flag = false;
		boolean ValidationMsg = false;

		waithelper.WaitForElementClickable(HealthAndSafetySensitiveGroup_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HealthAndSafetySensitiveGroup_Data_AddYearBtn.click();
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		log.info("Selected Year is ---" + Selected_Year);
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).sendKeys("366");

			ValidationMsg = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[1]"))
					.isDisplayed();
			if (ValidationMsg) {

				String ActualValMsg = driver
						.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[1]")).getText();
				log.info("Validation Message displayed ---" + ActualValMsg);
				if (ActualValMsg.equals("Invalid Reading (Min:0, Max; 365)"))
					flag = true;
				else
					flag = false;
			} else {
				log.info("Validation Message not displayed..");
			}
			log.info("CheckHealthAndSafetySensitiveGroup_CheckWithInvalidValue  ends here........");
			return flag;
		}
		return flag;

	}
	// This method will check on clicking Add Year button, new row should be listed
	// with previous year (Data Input - > Quality of Life -- > Health & Safety: Air
	// quality days unhealthy for sensitive groups (Days/yr)--> Data/Details Tab

	public boolean CheckHealthAndSafetySensitiveGroup_AddYear_NewRow_Display() {
		log.info("CheckHealthAndSafetySensitiveGroup_AddYear_NewRow_Display  starts here........");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(HealthAndSafetySensitiveGroup_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		HealthAndSafetySensitiveGroup_Data_AddYearBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(PreviousYearbutton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		int CurrentYear = CommonMethod.getCurrentYear();
		int YearValue = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		int PreviousYear = CurrentYear - 1;
		if (YearValue == PreviousYear) {
			log.info("CheckHealthAndSafetySensitiveGroup_AddYear_NewRow_Display  ends here........");
			return true;
		} else {
			log.info("CheckHealthAndSafetySensitiveGroup_AddYear_NewRow_Display  ends here........");
			return false;
		}

	}
	// This method will check on clicking Add Year button, new row should be listed
	// with previous year (Data Input - > Water Consumption - > Data/Details Tab

	public boolean CheckWatwr_Consumption_AddYear_NewRow_Display() {
		log.info("CheckWatwr_Consumption_AddYear_NewRow_Display  starts here........");
		waithelper.WaitForElementClickable(WaterConsum_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		WaterConsum_Data_AddYearBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int CurrentYear = CommonMethod.getCurrentYear();
		int YearValue = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		int PreviousYear = CurrentYear - 1;
		if (YearValue == PreviousYear) {
			log.info("CheckWatwr_Consumption_AddYear_NewRow_Display  ends here........");
			return true;
		} else {
			log.info("CheckWatwr_Consumption_AddYear_NewRow_Display  ends here........");
			return false;
		}

	}

	// This method will check on clicking Add Year button, new row should be listed
	// with previous year (Data Input - > Waste - > Solid Waste Generation- Data ->
	// Add New Line

	public boolean CheckWaste_Generation_AddYear_NewRow_Display() {
		log.info("CheckWaste_Generation_AddYear_NewRow_Display  starts here........");
		waithelper.WaitForElementClickable(Waste_AddYearButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Waste_AddYearButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int CurrentYear = CommonMethod.getCurrentYear();
		int YearValue = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		int PreviousYear = CurrentYear - 1;
		if (YearValue == PreviousYear) {
			log.info("CheckWaste_Generation_AddYear_NewRow_Display  ends here........");
			return true;
		} else {
			log.info("CheckWaste_Generation_AddYear_NewRow_Display  ends here........");
			return false;
		}

	}

	// This method will check on clicking Add Year button, new row should be listed
	// with previous year (Data Input - > Waste - >Municipal solid waste diversion
	// rate from landfill- Data ->
	// Add New Line

	public boolean CheckWaste_Diversion_AddYear_NewRow_Display() {
		log.info("CheckWaste_Diversion_AddYear_NewRow_Display  starts here........");
		waithelper.WaitForElementClickable(Waste_AddYearButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Waste_AddYearButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int CurrentYear = CommonMethod.getCurrentYear();
		int YearValue = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		int PreviousYear = CurrentYear - 1;
		if (YearValue == PreviousYear) {
			log.info("CheckWaste_Diversion_AddYear_NewRow_Display  ends here........");
			return true;
		} else {
			log.info("CheckWaste_Diversion_AddYear_NewRow_Display  ends here........");
			return false;
		}

	}

	// This method will check on clicking Add Year button, new row should be listed
	// with previous year (Data Input - > Waste - >Municipal solid waste diversion
	// rate from landfill- Data ->
	// Check with Percentage value 101

	public boolean CheckWaste_Diversion_CheckWithInvalidPercent() {
		log.info("CheckWaste_Diversion_CheckWithInvalidPercent  starts here........");
		List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		TableRow.size();
		log.info("Before adding number of row showing is ---" + TableRow.size());
		boolean flag = false;
		boolean ValidationMsg = false;
		waithelper.WaitForElementClickable(Waste_AddYearButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Waste_AddYearButton.click();
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		log.info("Selected Year is ---" + Selected_Year);
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).sendKeys("101");

			ValidationMsg = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[1]"))
					.isDisplayed();
			if (ValidationMsg) {
				String ActualValMsg = driver
						.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/p[1]")).getText();
				log.info("Validation Message displayed ---" + ActualValMsg);
				if (ActualValMsg.equals("Exceeded maximum value (Max: 100)"))
					flag = true;
				else
					flag = false;
			} else {
				log.info("Validation Message not displayed..");
			}
			log.info("CheckWaste_Diversion_CheckWithInvalidPercent  ends here........");
			return flag;
		}
		return flag;

	}

	// This method will add one row with previous year in Data Input - > GHG
	// Emission - > Data Tab

	public boolean CheckGHGEmission_SaveNewRecord() {
		log.info("CheckGHGEmission_SaveNewRecord  starts here........");
		driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int Prev_TableRowCount = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Before adding number of row showing is ---" + Prev_TableRowCount);
		waithelper.WaitForElementClickable(GHGEmission_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		GHGEmission_Data_AddYearBtn.click();
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		log.info("Selected Year is ---" + Selected_Year);
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("City", 4, 2));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Energy Circular Image");
			}
			try {

				waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Energy ScoreTip Message..");
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		int After_TableRowCount = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("After adding number of row showing is ---" + After_TableRowCount);
		if (After_TableRowCount - Prev_TableRowCount == 1) {
			log.info("CheckGHGEmission_SaveNewRecord  ends here with true........");
			return true;
		} else {
			log.info("CheckGHGEmission_SaveNewRecord  ends here with false........");
			return false;
		}

	}

	// This method will add one row with previous year in Data Input - >
	// Transportation - > Data Tab

	public boolean CheckTransportation_SaveNewRecord() {
		log.info("CheckTransportation_SaveNewRecord  starts here........");
		// List<WebElement> TableRow =
		// driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int Prev_TableRowCount = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Before adding number of row showing is ---" + Prev_TableRowCount);
		waithelper.WaitForElementClickable(VMT_Data_AddYearBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		VMT_Data_AddYearBtn.click();
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		log.info("Selected Year is ---" + Selected_Year);
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("City", 14, 2));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}

			try {
				waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  ScoreTip Message..");
			}
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int After_TableRowCount = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("After adding number of row showing is ---" + After_TableRowCount);
		if (After_TableRowCount - Prev_TableRowCount == 1) {
			log.info("CheckGHGEmission_SaveNewRecord  ends here with true........");
			return true;
		} else {
			log.info("CheckGHGEmission_SaveNewRecord  ends here with false........");
			return false;
		}

	}

	// This method will add one row with previous year in Data Input - > Quality Of
	// Life - > Health And Safety) --> Data Tab

	public boolean CheckHealthAndSafety_SaveNewRecord() {
		log.info("CheckHealthAndSafety_SaveNewRecord  starts here........");
		int Prev_TableRowCount = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Before adding number of row showing is ---" + Prev_TableRowCount);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(HealthAndSafety_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		HealthAndSafety_Data_AddYearBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(PreviousYearbutton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		log.info("Selected Year is ---" + Selected_Year);
		log.info(data.getCellData("City", 26, 2));
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("City", 16, 2));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Circular Image");
			}
			try {

				waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate ScoreTip Message..");
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		int After_TableRowCount = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("After adding number of row showing is ---" + After_TableRowCount);
		if (After_TableRowCount - Prev_TableRowCount == 1) {
			log.info("CheckHealthAndSafety_SaveNewRecord  ends here with true........");
			return true;
		} else {
			log.info("CheckHealthAndSafety_SaveNewRecord  ends here with false........");
			return false;
		}

	}

	// This method will add one row with previous year in Data Input - > Quality Of
	// Life - > Education: Population with (at least) Bachelor's degree (%) --> Data
	// Tab

	public boolean CheckEductaion_Bachelor_Population_SaveNewRecord() {
		log.info("CheckEductaion_Bachelor_Population_SaveNewRecord  starts here........");
		int Prev_TableRowCount = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Before adding number of row showing is ---" + Prev_TableRowCount);
		waithelper.WaitForElementClickable(Education_BachelorPopulation_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Education_BachelorPopulation_Data_AddYearBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(PreviousYearbutton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		log.info("Selected Year is ---" + Selected_Year);
		log.info(data.getCellData("City", 18, 2));
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("City", 28, 2));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}
			try {

				waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate ScoreTip Message..");
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		int After_TableRowCount = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("After adding number of row showing is ---" + Prev_TableRowCount);
		if (After_TableRowCount - Prev_TableRowCount == 1) {
			log.info("CheckEductaion_Bachelor_Population_SaveNewRecord  ends here with true........");
			return true;
		} else {
			log.info("CheckEductaion_Bachelor_Population_SaveNewRecord  ends here with false........");
			return false;
		}

	}

	// This method will add one row with previous year in Data Input - > Quality Of
	// Life - > Equitability: Gini coefficient (for income distribution) --> Data
	// Tab

	public boolean CheckEquitability_Gini_Coefficient_SaveNewRecord() {
		log.info("CheckEquitability_Gini_Coefficient_SaveNewRecord  starts here........");
		int Prev_TableRowCount = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Before adding number of row showing is ---" + Prev_TableRowCount);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(Equitability_Gini_Coefficient_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Equitability_Gini_Coefficient_Data_AddYearBtn.click();
		// waithelper.WaitForElementVisibleWithPollingTime(PreviousYearbutton,Integer.parseInt(prop.getProperty("explicitTime")),
		// 2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		log.info("Selected Year is ---" + Selected_Year);
		log.info(data.getCellData("City", 20, 2));
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("City", 20, 2));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}
			try {

				waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate ScoreTip Message..");
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		int After_TableRowCount = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("After adding number of row showing is ---" + After_TableRowCount);
		if (After_TableRowCount - Prev_TableRowCount == 1) {
			log.info("CheckEquitability_Gini_Coefficient_SaveNewRecord  ends here with true........");
			return true;
		} else {
			log.info("CheckEquitability_Gini_Coefficient_SaveNewRecord  ends here with false........");
			return false;
		}

	}

	// This method will add one row with previous year in Data Input - > Quality Of
	// Life - > Education: Population with (at least) High School degree (%) -->
	// Data Tab

	public boolean CheckEducation_HighSchoolPopulation_SaveNewRecord() {
		log.info("CheckEducation_HighSchoolPopulation_SaveNewRecord  starts here........");
		int Prev_TableRowCount = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Before adding number of row showing is ---" + Prev_TableRowCount);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementClickable(Education_HighSchoolPopulation_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Education_HighSchoolPopulation_Data_AddYearBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(PreviousYearbutton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		log.info("Selected Year is ---" + Selected_Year);
		log.info(data.getCellData("City", 22, 2));
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("City", 22, 2));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}
			try {

				waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate ScoreTip Message..");
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		int After_TableRowCount = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("After adding number of row showing is ---" + After_TableRowCount);
		if (After_TableRowCount - Prev_TableRowCount == 1) {
			log.info("City_Education_HighSchoolPopulation_SavePreviousYearData  ends here with true........");
			return true;
		} else {
			log.info("City_Education_HighSchoolPopulation_SavePreviousYearData  ends here with false........");
			return false;
		}

	}
	// This method will add one row with previous year in Data Input - > Quality Of
	// Life - > Prosperity: Median household income (US Dollars/Year) --> Data Tab

	public boolean CheckProsperityMedianIncome_SaveNewRecord() {
		log.info("CheckProsperityMedianIncome_SaveNewRecord  starts here........");

		int Prev_TableRowCount = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Before adding number of row showing is ---" + Prev_TableRowCount);
		// JSHelper.clickElement(ProsperityMedianIncome_Data_AddYearBtn);
		waithelper.WaitForElementClickable(ProsperityMedianIncome_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		// JSHelper.clickElement(ProsperityMedianIncome_Data_AddYearBtn);
		try {

			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProsperityMedianIncome_Data_AddYearBtn.click();
		try {

			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		log.info("Selected Year is ---" + Selected_Year);
		log.info(data.getCellData("City", 24, 2));
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("City", 24, 2));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}
			try {

				waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate ScoreTip Message..");
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		int After_TableRowCount = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("After adding number of row showing is ---" + After_TableRowCount);
		if (After_TableRowCount - Prev_TableRowCount == 1) {
			log.info("CheckProsperityMedianIncome_SaveNewRecord  ends here with true........");
			return true;
		} else {
			log.info("CheckProsperityMedianIncome_SaveNewRecord  ends here with false........");
			return false;
		}

	}

	// This method will add one row with previous year in Data Input - > Quality Of
	// Life - > Equitability: Median gross rent as (%) of household income --> Data
	// Tab

	public boolean CheckEquitability_MedianGrossIncome_SaveNewRecord() {
		log.info("CheckEquitability_MedianGrossIncome_SaveNewRecord  starts here........");
		int Prev_TableRowCount = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Before adding number of row showing is ---" + Prev_TableRowCount);
		// JSHelper.clickElement(ProsperityMedianIncome_Data_AddYearBtn);
		waithelper.WaitForElementClickable(Equitability_MedianGrossIncome_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		// JSHelper.clickElement(ProsperityMedianIncome_Data_AddYearBtn);
		try {

			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Equitability_MedianGrossIncome_Data_AddYearBtn.click();
		try {

			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		log.info("Selected Year is ---" + Selected_Year);
		log.info(data.getCellData("City", 26, 2));
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("City", 26, 2));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}
			try {

				waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate ScoreTip Message..");
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		int After_TableRowCount = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("After adding number of row showing is ---" + After_TableRowCount);
		if (After_TableRowCount - Prev_TableRowCount == 1) {
			log.info("CheckEquitability_MedianGrossIncome_SaveNewRecord  ends here with true........");
			return true;
		} else {
			log.info("CheckEquitability_MedianGrossIncome_SaveNewRecord  ends here with false........");
			return false;
		}

	}

	// This method will add one row with previous year in Data Input - > Quality Of
	// Life - > Prosperity: Unemployment rate (%) --> Data Tab

	public boolean CheckProsperityUnemployementRate_SaveNewRecord() {
		log.info("CheckProsperityUnemployementRate_SaveNewRecord  starts here........");
		int Prev_TableRowCount = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Before adding number of row showing is ---" + Prev_TableRowCount);
		// JSHelper.clickElement(ProsperityMedianIncome_Data_AddYearBtn);
		waithelper.WaitForElementClickable(ProsperityUnemployementRate_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		// JSHelper.clickElement(ProsperityMedianIncome_Data_AddYearBtn);
		try {

			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProsperityUnemployementRate_Data_AddYearBtn.click();
		try {

			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		log.info("Selected Year is ---" + Selected_Year);
		log.info(data.getCellData("City", 28, 2));
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("City", 28, 2));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Circular Image");
			}
			try {

				waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate ScoreTip Message..");
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		int After_TableRowCount = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("After adding number of row showing is ---" + After_TableRowCount);
		if (After_TableRowCount - Prev_TableRowCount == 1) {
			log.info("CheckProsperityUnemployementRate_SaveNewRecord  ends here with true........");
			return true;
		} else {
			log.info("CheckProsperityUnemployementRate_SaveNewRecord  ends here with false........");
			return false;
		}

	}

	// This method will add one row with previous year in Data Input - > Quality Of
	// Life - > Health & Safety: Air quality days unhealthy for sensitive groups
	// (Days/yr) --> Data Tab

	public boolean CheckHealthAndSafetySensitiveGroup_SaveNewRecord() {
		log.info("CheckHealthAndSafetySensitiveGroup_SaveNewRecord  starts here........");
		int Prev_TableRowCount = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Before adding number of row showing is ---" + Prev_TableRowCount);
		try {

			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementClickable(HealthAndSafetySensitiveGroup_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		// JSHelper.clickElement(ProsperityMedianIncome_Data_AddYearBtn);
		try {

			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HealthAndSafetySensitiveGroup_Data_AddYearBtn.click();
		try {

			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		log.info("Selected Year is ---" + Selected_Year);
		log.info(data.getCellData("City", 30, 2));
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("City", 30, 2));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}
			try {

				waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate ScoreTip Message..");
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		int After_TableRowCount = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("After adding number of row showing is ---" + After_TableRowCount);
		if (After_TableRowCount - Prev_TableRowCount == 1) {
			log.info("CheckHealthAndSafetySensitiveGroup_SaveNewRecord  ends here with true........");
			return true;
		} else {
			log.info("CheckHealthAndSafetySensitiveGroup_SaveNewRecord  ends here with false........");
			return false;
		}

	}

	// This method will add one row with previous year in Data Input - > Quality Of
	// Life - > Health & Safety: Violent Crime (per year per capita) --> Data Tab

	public boolean CheckHealthAndSafetyVoilentCrime_SaveNewRecord() {
		log.info("CheckHealthAndSafetySensitiveGroup_SaveNewRecord  starts here........");
		int Prev_TableRowCount = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Before adding number of row showing is ---" + Prev_TableRowCount);
		waithelper.WaitForElementClickable(HealthAndSafetyVoilentCrime_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {

			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HealthAndSafetyVoilentCrime_Data_AddYearBtn.click();
		try {

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		log.info("Selected Year is ---" + Selected_Year);
		log.info(data.getCellData("City", 32, 2));
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("City", 32, 2));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Circular Image");
			}
			try {

				waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate ScoreTip Message..");
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		int After_TableRowCount = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("After adding number of row showing is ---" + After_TableRowCount);
		if (After_TableRowCount - Prev_TableRowCount == 1) {
			log.info("CheckHealthAndSafetyVoilentCrime_SaveNewRecord  ends here with true........");
			return true;
		} else {
			log.info("CheckHealthAndSafetyVoilentCrime_SaveNewRecord  ends here with false........");
			return false;
		}

	}
	// This method will Edit Record in Data Input - > Transportation - > Data Tab

	public boolean CheckTransportation_EditRecord() {
		log.info("CheckTransportation_EditRecord  starts here........");
		waithelper.WaitForElementClickable(VMT_Data_Save_EditBtn, Integer.parseInt(prop.getProperty("explicitTime")),
				2);
		VMT_Data_Save_EditBtn.click();
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		Selected_Year++;
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + Selected_Year + "']";

		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath(xpath)).click();
			e.printStackTrace();
			log.info(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}

		String Miles_Days_Capita = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.getAttribute("value");
		int Miles_Days_CapitaNew = Integer.parseInt(Miles_Days_Capita);
		Miles_Days_CapitaNew = Miles_Days_CapitaNew + 5;
		String ExpMiles_Days_CapitaNew = Integer.toString(Miles_Days_CapitaNew);
		log.info(Miles_Days_CapitaNew);
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(Miles_Days_CapitaNew));
		VMT_Data_Save_EditBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Circular Image");
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String ActMiles_Days_CapitaNew = driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).getAttribute("value");
		if (ExpMiles_Days_CapitaNew.equals(ActMiles_Days_CapitaNew) && (driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
				.isDisplayed())) {

			log.info("City_Transportation_Edit_Test  ends here with true ........");
			return true;
		} else {
			log.info("City_Transportation_Edit_Test  ends here with false ........");
			return false;
		}

	}

	// This method will Edit Record in Data Input - > Quality Of Life--> Health And
	// Safety - > Data Tab

	public boolean CheckHealthAndSafety_EditRecord() {
		log.info("CheckHealthAndSafety_EditRecord  starts here........");
		waithelper.WaitForElementClickable(VMT_Data_Save_EditBtn, Integer.parseInt(prop.getProperty("explicitTime")),
				2);
		HealthAndSafety_Data_Save_EditBtn.click();
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		Selected_Year++;
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + Selected_Year + "']";

		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath(xpath)).click();
			e.printStackTrace();
			log.info(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}

		String OldValue = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.getAttribute("value");
		int value = Integer.parseInt(OldValue);
		value = value + 100;
		String ExpValue = Integer.toString(value);
		log.info(value);
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));
		HealthAndSafety_Data_Save_EditBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate  Circular Image");
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String ActValue = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.getAttribute("value");
		if (ExpValue.equals(ActValue) && (driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
				.isDisplayed())) {

			log.info("City_HealthAndSafety_Edit_Test  ends here with true ........");
			return true;
		} else {
			log.info("City_HealthAndSafety_Edit_Test  ends here with false ........");
			return false;
		}

	}

	// This method will Edit Record in Data Input - > Quality Of Life--> Education:
	// Population with (at least) Bachelor's degree (%) - > Data Tab

	public boolean CheckEducation_Bachelor_population_EditRecord() {
		log.info("CheckEducation_Bachelor_population_EditRecord  starts here........");
		waithelper.WaitForElementClickable(VMT_Data_Save_EditBtn, Integer.parseInt(prop.getProperty("explicitTime")),
				2);
		Education_BachelorPopulation_Data_Save_EditBtn.click();
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		Selected_Year++;
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + Selected_Year + "']";

		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath(xpath)).click();
			e.printStackTrace();
			log.info(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}

		String OldValue = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.getAttribute("value");
		int value = Integer.parseInt(OldValue);
		value = value + 10;
		String ExpValue = Integer.toString(value);
		log.info(value);
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));
		Education_BachelorPopulation_Data_Save_EditBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate  Circular Image");
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String ActValue = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.getAttribute("value");
		if (ActValue.equals(ExpValue) && (driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
				.isDisplayed())) {

			log.info("City_Education_Bachelor_Population_Edit_Test  ends here with true ........");
			return true;
		} else {
			log.info("City_Education_Bachelor_Population_Edit_Test  ends here with false ........");
			return false;
		}

	}

	// This method will Edit Record in Data Input - > Quality Of Life-->
	// Equitability: Gini coefficient (for income distribution) - > Data Tab

	public boolean CheckEquitability_Gini_Coefficient_EditRecord() {
		log.info("CheckEquitability_Gini_Coefficient_EditRecord  starts here........");
		waithelper.WaitForElementClickable(Equitability_Gini_Coefficient_Data_Save_EditBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Equitability_Gini_Coefficient_Data_Save_EditBtn.click();
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		Selected_Year++;
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + Selected_Year + "']";

		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath(xpath)).click();
			e.printStackTrace();
			log.info(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}

		String OldValue = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.getAttribute("value");
		int value = Integer.parseInt(OldValue);
		if (value == 1)
			value = 0;
		else
			value = 1;
		// value=value+10;
		log.info(value);
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));
		Equitability_Gini_Coefficient_Data_Save_EditBtn.click();
		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Row Circular Image");
		}

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate  Circular Image");
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if ((driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
				.isDisplayed())) {

			log.info("CheckEquitability_Gini_Coefficient_EditRecord  ends here with true ........");
			return true;
		} else {
			log.info("CheckEquitability_Gini_Coefficient_EditRecord  ends here with false ........");
			return false;
		}

	}

	// This method will Edit Record in Data Input - > Quality Of Life--> Education:
	// Population with (at least) High School degree (%) - > Data Tab

	public boolean CheckEducation_HighSchoolPopulation_EditRecord() {
		log.info("CheckEducation_HighSchoolPopulation_EditRecord  starts here........");
		waithelper.WaitForElementClickable(Education_HighSchoolPopulation_Data_Save_EditBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Education_HighSchoolPopulation_Data_Save_EditBtn.click();
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		Selected_Year++;
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + Selected_Year + "']";

		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath(xpath)).click();
			e.printStackTrace();
			log.info(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}

		String OldValue = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.getAttribute("value");
		int value = Integer.parseInt(OldValue);

		value = value + 10;
		String ExpValue = Integer.toString(value);
		log.info(value);
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));
		Education_HighSchoolPopulation_Data_Save_EditBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate  Circular Image");
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String ActValue = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.getAttribute("value");
		if (ActValue.equals(ExpValue) && (driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
				.isDisplayed())) {

			log.info("CheckEducation_HighSchoolPopulation_EditRecord  ends here with true ........");
			return true;
		} else {
			log.info("CheckEducation_HighSchoolPopulation_EditRecord  ends here with false ........");
			return false;
		}

	}
	// This method will Edit Record in Data Input - > Quality Of Life--> Prosperity:
	// Median household income (US Dollars/Year) - > Data Tab

	public boolean CheckProsperityMedianIncome_EditRecord() {
		log.info("CheckProsperityMedianIncome_EditRecord  starts here........");
		waithelper.WaitForElementClickable(ProsperityMedianIncome_Data_Save_EditBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ProsperityMedianIncome_Data_Save_EditBtn.click();
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		Selected_Year++;
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + Selected_Year + "']";

		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath(xpath)).click();
			e.printStackTrace();
			log.info(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}

		String OldValue = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.getAttribute("value");
		int value = Integer.parseInt(OldValue);

		value = value + 10;
		String ExpValue = Integer.toString(value);
		log.info(value);
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));
		ProsperityMedianIncome_Data_Save_EditBtn.click();
		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Row Circular Image");
		}

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate  Circular Image");
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String ActValue = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.getAttribute("value");
		if (ActValue.equals(ExpValue) && (driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
				.isDisplayed())) {

			log.info("CheckProsperityMedianIncome_EditRecord  ends here with true ........");
			return true;
		} else {
			log.info("CheckProsperityMedianIncome_EditRecord  ends here with false ........");
			return false;
		}

	}
	// This method will Edit Record in Data Input - > Quality Of Life-->
	// Equitability: Median gross rent as (%) of household income - > Data Tab

	public boolean CheckEquitability_MedianGrossIncome_EditRecord() {
		log.info("CheckEquitability_MedianGrossIncome_EditRecord  starts here........");
		waithelper.WaitForElementClickable(Equitability_MedianGrossIncome_Data_Save_EditBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Equitability_MedianGrossIncome_Data_Save_EditBtn.click();
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		Selected_Year++;
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + Selected_Year + "']";

		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath(xpath)).click();
			e.printStackTrace();
			log.info(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}

		String OldValue = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.getAttribute("value");
		int value = Integer.parseInt(OldValue);

		value = value + 10;
		String ExpValue = Integer.toString(value);
		log.info(value);
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));
		ProsperityMedianIncome_Data_Save_EditBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate  Circular Image");
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String ActValue = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.getAttribute("value");
		if (ActValue.equals(ExpValue) && (driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
				.isDisplayed())) {

			log.info("City_Equitability_MedianGrossIncome_Edit_Test  ends here with true ........");
			return true;
		} else {
			log.info("City_Equitability_MedianGrossIncome_Edit_Test  ends here with false ........");
			return false;
		}

	}

	// This method will Edit Record in Data Input - > Quality Of Life--> Prosperity:
	// Unemployment rate (%) - > Data Tab

	public boolean CheckProsperityUnemployementRate_EditRecord() {
		log.info("CheckProsperityUnemployementRate_EditRecord  starts here........");
		waithelper.WaitForElementClickable(ProsperityUnemployementRate_Data_Save_EditBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ProsperityUnemployementRate_Data_Save_EditBtn.click();
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		Selected_Year++;
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + Selected_Year + "']";

		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath(xpath)).click();
			e.printStackTrace();
			log.info(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}

		String OldValue = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.getAttribute("value");
		int value = Integer.parseInt(OldValue);

		value = value + 10;
		String ExpValue = Integer.toString(value);
		log.info(value);
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));
		ProsperityMedianIncome_Data_Save_EditBtn.click();
		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Row Circular Image");
		}

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate  Circular Image");
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String ActValue = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.getAttribute("value");
		if (ActValue.equals(ExpValue) && (driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
				.isDisplayed())) {

			log.info("CheckProsperityUnemployementRate_EditRecord  ends here with true ........");
			return true;
		} else {
			log.info("CheckProsperityUnemployementRate_EditRecord  ends here with false ........");
			return false;
		}

	}

	// This method will Edit Record in Data Input - > Quality Of Life--> Health &
	// Safety: Air quality days unhealthy for sensitive groups (Days/yr) - > Data
	// Tab

	public boolean CheckHealthAndSafetySensitiveGroup_EditRecord() {
		log.info("CheckHealthAndSafetySensitiveGroup_EditRecord  starts here........");
		waithelper.WaitForElementClickable(HealthAndSafetySensitiveGroup_Data_Save_EditBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		HealthAndSafetySensitiveGroup_Data_Save_EditBtn.click();
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		Selected_Year++;
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + Selected_Year + "']";

		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath(xpath)).click();
			e.printStackTrace();
			log.info(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}

		String OldValue = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.getAttribute("value");
		int value = Integer.parseInt(OldValue);

		value = value + 10;
		String ExpValue = Integer.toString(value);
		log.info(value);
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));
		HealthAndSafetySensitiveGroup_Data_Save_EditBtn.click();
		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Row Circular Image");
		}

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate  Circular Image");
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String ActValue = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.getAttribute("value");
		if (ActValue.equals(ExpValue) && (driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
				.isDisplayed())) {

			log.info("CheckHealthAndSafetySensitiveGroup_EditRecord  ends here with true ........");
			return true;
		} else {
			log.info("CheckHealthAndSafetySensitiveGroup_EditRecord  ends here with false ........");
			return false;
		}

	}

	// This method will Edit Record in Data Input - > Quality Of Life--> Health &
	// Safety: Violent Crime (per year per capita) - > Data Tab

	public boolean CheckHealthAndSafetyVoilentCrime_EditRecord() {
		log.info("CheckHealthAndSafetyVoilentCrime_EditRecord  starts here........");
		waithelper.WaitForElementClickable(HealthAndSafetyVoilentCrime_Data_Save_EditBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		HealthAndSafetyVoilentCrime_Data_Save_EditBtn.click();
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		Selected_Year++;
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + Selected_Year + "']";

		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath(xpath)).click();
			e.printStackTrace();
			log.info(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}

		String OldValue = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.getAttribute("value");
		int value = Integer.parseInt(OldValue);

		value = value + 10;
		String ExpValue = Integer.toString(value);
		log.info(value);
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));
		HealthAndSafetyVoilentCrime_Data_Save_EditBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Circular Image");
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String ActValue = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.getAttribute("value");
		if (ActValue.equals(ExpValue) && (driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
				.isDisplayed())) {

			log.info("CheckHealthAndSafetyVoilentCrime_EditRecord  ends here with true ........");
			return true;
		} else {
			log.info("CheckHealthAndSafetyVoilentCrime_EditRecord  ends here with false ........");
			return false;
		}

	}
	// This method will Edit Row in Data Input - > GHG Emission - > Data Tab

	public boolean CheckGHGEmission_EditRow() {
		log.info("CheckGHGEmission_EditRow  starts here........");
		GHGEmission_Data_Save_EditBtn.click();
		log.info(data.getCellData("City", 4, 2));
		int value = Integer.parseInt(data.getCellData("City", 4, 2)) + 5;
		// log.info(Integer.parseInt(data.getCellData("City", 4, 2)) + 5);
		// log.info(Integer.toString(Integer.parseInt(data.getCellData("City", 4, 2)) +
		// 5));
		String Tons_Year_Capita = Integer.toString(value);
		// log.info(Tons_Year_Capita);
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).sendKeys(Tons_Year_Capita);
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
		// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
		// Integer.parseInt(prop.getProperty("explicitTime")), 2);

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Row Circular Image");
		}

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Energy Circular Image");
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String Updated_Tons_Year_Capita = driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).getAttribute("value");
		if (Tons_Year_Capita.equals(Updated_Tons_Year_Capita) && (driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
				.isDisplayed())) {

			log.info("CheckGHGEmission_EditRow  ends here with true ........");
			return true;
		} else {
			log.info("CheckGHGEmission_EditRow  ends here with false ........");
			return false;
		}

	}

	// This method will Edit Row in Data Input - > Waste - > Municipal solid waste
	// generation intensity

	public boolean CheckWasteGeneration_EditRow() {
		log.info("CheckWasteGeneration_EditRow  starts here........");
		FirstRow_Waste_Gen_Data_Save_EditBtn.click();

		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		selected_year = selected_year + 1;
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		driver.findElement(By.xpath(
				"(//table[@class='table-condensed'])[2]/tbody/tr/td/span[@class='year active']/following-sibling::span"))
				.click();

		int value = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).getAttribute("value"));
		value = value + 5;
		String Expvalue = Integer.toString(value);
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));

		FirstRow_Waste_Gen_Data_Save_EditBtn.click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate  Circular Image");
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String Actvalue = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.getAttribute("value");
		if (Expvalue.equals(Actvalue) && (driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
				.isDisplayed())) {

			log.info("CheckWasteGeneration_EditRow  ends here with true ........");
			return true;
		} else {
			log.info("CheckWasteGeneration_EditRow  ends here with false ........");
			return false;
		}

	}

	// This method will Edit Row in Data Input - > Waste - > Municipal solid waste
	// diversion rate from landfill

	public boolean CheckWasteDiversion_EditRow() {
		log.info("CheckWasteDiversion_EditRow  starts here........");
		waithelper.WaitForElementVisibleWithPollingTime(PreviousYearbutton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		FirstRow_Waste_Div_Data_Save_EditBtn.click();

		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		selected_year = selected_year + 1;
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		driver.findElement(By.xpath(
				"(//table[@class='table-condensed'])[2]/tbody/tr/td/span[@class='year active']/following-sibling::span"))
				.click();

		int value = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).getAttribute("value"));
		value = value + 5;
		String ExpValue = Integer.toString(value);
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));

		FirstRow_Waste_Div_Data_Save_EditBtn.click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate  Circular Image");
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String Actvalue = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.getAttribute("value");
		if (ExpValue.equals(Actvalue) && (driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
				.isDisplayed())) {

			log.info("CheckWasteDiversion_EditRow  ends here with true ........");
			return true;
		} else {
			log.info("CheckWasteDiversion_EditRow  ends here with false ........");
			return false;
		}

	}

// This method will Edit Row in Data Input - > Water Consumption - > Data Tab 

	public boolean CheckWaterConsum_EditRow() {
		log.info("CheckWaterConsum_EditRow  starts here........");
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/button")).click();
		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		selected_year = selected_year + 1;
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		driver.findElement(By.xpath(
				"(//table[@class='table-condensed'])[2]/tbody/tr/td/span[@class='year active']/following-sibling::span"))
				.click();

		int value = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).getAttribute("value"));

		value = value + 10;
		String StringValue = Integer.toString(value);
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/button")).click();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/button")).click();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/button")).click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate  Circular Image");
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String Updated_Vaue = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.getAttribute("value");

		if (StringValue.equals(Updated_Vaue) && (driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/button/span[text()='Edit']"))
				.isDisplayed())) {

			log.info("CheckWaterConsum_EditRow  ends here with true ........");
			return true;
		} else {
			log.info("CheckWaterConsum_EditRow  ends here with false ........");
			return false;
		}

	}

	// Project Setting - > Population - > Verify delete button deletes the line item
	// successfully.

	public boolean CheckPopulationDeleteRow() {
		log.info("CheckPopulationDeleteRow  starts here........");
		int TotalRowBeforeDeleting = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows before deleting  " + TotalRowBeforeDeleting);

		try {
			driver.findElement(
					By.xpath("//table[@id='readingsTable']/tbody/tr[" + TotalRowBeforeDeleting + "]/td[5]/span"))
					.click();

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By
							.xpath("//table[@id='readingsTable']/tbody/tr[" + TotalRowBeforeDeleting + "]/td[5]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Circular Image");
		}

		int TotalRowAfterDeleting = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows after deleting  " + TotalRowAfterDeleting);
		if (TotalRowBeforeDeleting - TotalRowAfterDeleting == 1) {
			log.info("CheckPopulationDeleteRow  ends here with true........");
			return true;
		} else {
			log.info("CheckPopulationDeleteRow  ends here with false........");
			return false;
		}

	}

	// Project Setting - > Project Area - > Verify delete button deletes the line
	// item
	// successfully.

	public boolean CheckProjectAreaDeleteRow() {
		log.info("CheckProjectAreaDeleteRow  starts here........");
		waithelper.WaitForElementClickable(ProjectAreaTab, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(ProjectAreaTab);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//*[contains(text(),'PROJECT AREA')]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		int TotalRowBeforeDeleting = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows before deleting  " + TotalRowBeforeDeleting);

		try {
			driver.findElement(
					By.xpath("//table[@id='readingsTable']/tbody/tr[" + TotalRowBeforeDeleting + "]/td[5]/span"))
					.click();

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By
							.xpath("//table[@id='readingsTable']/tbody/tr[" + TotalRowBeforeDeleting + "]/td[5]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Circular Image");
		}

		int TotalRowAfterDeleting = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows after deleting  " + TotalRowAfterDeleting);
		if (TotalRowBeforeDeleting - TotalRowAfterDeleting == 1) {
			log.info("CheckProjectAreaDeleteRow  ends here with true........");
			return true;
		} else {
			log.info("CheckProjectAreaDeleteRow  ends here with false........");
			return false;
		}

	}
	// This method will Delete Row in Data Input - > GHG Emission - > Data Tab

	public boolean CheckGHGEmission_DeleteRow() {
		log.info("CheckGHGEmission_DeleteRow  starts here........");
		int TotalRowBeforeDeleting = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows before deleting  " + TotalRowBeforeDeleting);

		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")).click();
		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		try {
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to locate Energy Circular Image");
		}

		int TotalRowAfterDeleting = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of rows after deleting  " + TotalRowAfterDeleting);
		if (TotalRowBeforeDeleting - TotalRowAfterDeleting == 1) {
			log.info("CheckGHGEmission_DeleteRow  ends here with true........");
			return true;
		} else {
			log.info("CheckGHGEmission_DeleteRow  ends here with false........");
			return false;
		}

	}

// This method will Delete Row in Data Input - > Waste - > Municipal solid waste generation intensity 

	public boolean CheckWasteGeneration_DeleteRow() {
		log.info("CheckWasteGeneration_DeleteRow  starts here........");
		boolean flag = false;
		int RowCountBefore = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Row showing is --" + RowCountBefore);
		if (RowCountBefore > 1) {
			try {
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")).click();
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to delete the row..");
				// TODO: handle exception
			}

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}

		} else {
			log.info("There is no any row to delete..");
		}
		int RowCountAfter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");

		log.info("Row count after deleting is ---" + RowCountAfter);
		if (RowCountBefore - RowCountAfter == 1)
			flag = true;
		log.info("CheckWasteGeneration_DeleteRow  ends here........");
		return flag;

	}

	// This method will Delete Row in Data Input - > Waste - > Municipal solid waste
	// diversion rate from landfill

	public boolean CheckWasteDiversion_DeleteRow() {
		log.info("CheckWasteDiversion_DeleteRow  starts here........");
		boolean flag = false;
		int RowCountBefore = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Row showing is --" + RowCountBefore);
		if (RowCountBefore > 1) {
			try {
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")).click();
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to delete the row..");
				// TODO: handle exception
			}

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}

		} else {
			log.info("There is no any row to delete..");
		}
		int RowCountAfter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");

		log.info("Row count after deleting is ---" + RowCountAfter);
		if (RowCountBefore - RowCountAfter == 1)
			flag = true;
		log.info("CheckWasteDiversion_DeleteRow  ends here........");
		return flag;

	}

	// This method will Delete Row in Data Input - > Transportation - > VMT

	public boolean Transportation_VMT_DeleteRow() {
		log.info("Transportation_VMT_DeleteRow  starts here........");
		boolean flag = false;
		int RowCountBefore = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Row showing is --" + RowCountBefore);
		if (RowCountBefore > 1) {
			try {
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")).click();
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to delete the row..");
				// TODO: handle exception
			}

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}

		} else {
			log.info("There is no any row to delete..");
		}
		int RowCountAfter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");

		log.info("Row count after deleting is ---" + RowCountAfter);
		if (RowCountBefore - RowCountAfter == 1)
			flag = true;
		log.info("Transportation_VMT_DeleteRow  ends here........");
		return flag;

	}

	// This method will Delete Row in Data Input - > Quality Of Life--> Health And
	// Safety

	public boolean HealthAndSafety_DeleteRow() {
		log.info("HealthAndSafety_DeleteRow  starts here........");
		boolean flag = false;
		waithelper.WaitForElementVisibleWithPollingTime(PreviousYearbutton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		int RowCountBefore = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Row showing is --" + RowCountBefore);
		if (RowCountBefore > 1) {
			try {
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")).click();
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to delete the row..");
				// TODO: handle exception
			}
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}

		} else {
			log.info("There is no any row to delete..");
		}
		int RowCountAfter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");

		log.info("Row count after deleting is ---" + RowCountAfter);
		if (RowCountBefore - RowCountAfter == 1)
			flag = true;
		log.info("HealthAndSafety_DeleteRow  ends here........");
		return flag;

	}
	// This method will Delete Row in Data Input - > Quality Of Life--> Education:
	// Population with (at least) Bachelor's degree (%)

	public boolean Education_Bachelor_Population_DeleteRow() {
		log.info("Education_Bachelor_Population_DeleteRow  starts here........");
		boolean flag = false;
		waithelper.WaitForElementVisibleWithPollingTime(PreviousYearbutton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		int RowCountBefore = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Row showing is --" + RowCountBefore);
		if (RowCountBefore > 1) {
			try {
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")).click();
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to delete the row..");
				// TODO: handle exception
			}
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}

		} else {
			log.info("There is no any row to delete..");
		}
		int RowCountAfter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");

		log.info("Row count after deleting is ---" + RowCountAfter);
		if (RowCountBefore - RowCountAfter == 1)
			flag = true;
		log.info("Education_Bachelor_Population_DeleteRow  ends here........");
		return flag;

	}

	// This method will Delete Row in Data Input - > Quality Of Life-->
	// Equitability: Gini coefficient (for income distribution)

	public boolean Equitability_Gini_Coefficient_DeleteRow() {
		log.info("Equitability_Gini_Coefficient_DeleteRow  starts here........");
		boolean flag = false;
		waithelper.WaitForElementVisibleWithPollingTime(PreviousYearbutton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		int RowCountBefore = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Row showing is --" + RowCountBefore);
		if (RowCountBefore > 1) {
			try {
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")).click();
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to delete the row..");
				// TODO: handle exception
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}

		} else {
			log.info("There is no any row to delete..");
		}
		int RowCountAfter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");

		log.info("Row count after deleting is ---" + RowCountAfter);
		if (RowCountBefore - RowCountAfter == 1)
			flag = true;
		log.info("Equitability_Gini_Coefficient_DeleteRow  ends here........");
		return flag;

	}
	// This method will Delete Row in Data Input - > Quality Of Life--> Education:
	// Population with (at least) High School degree (%)

	public boolean Education_HighSchoolPopulation_DeleteRow() {
		log.info("Education_HighSchoolPopulation_DeleteRow  starts here........");
		boolean flag = false;
		waithelper.WaitForElementVisibleWithPollingTime(PreviousYearbutton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		int RowCountBefore = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Row showing is --" + RowCountBefore);
		if (RowCountBefore > 1) {
			try {
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")).click();
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to delete the row..");
				// TODO: handle exception
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}

		} else {
			log.info("There is no any row to delete..");
		}
		int RowCountAfter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");

		log.info("Row count after deleting is ---" + RowCountAfter);
		if (RowCountBefore - RowCountAfter == 1)
			flag = true;
		log.info("Education_HighSchoolPopulation_DeleteRow  ends here........");
		return flag;

	}

	// This method will Delete Row in Data Input - > Quality Of Life--> Prosperity:
	// Median household income (US Dollars/Year)

	public boolean ProsperityMedianIncome_DeleteRow() {
		log.info("ProsperityMedianIncome_DeleteRow  starts here........");
		boolean flag = false;
		waithelper.WaitForElementVisibleWithPollingTime(PreviousYearbutton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		int RowCountBefore = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Row showing is --" + RowCountBefore);
		if (RowCountBefore > 1) {
			try {
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")).click();
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to delete the row..");
				// TODO: handle exception
			}
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}

		} else {
			log.info("There is no any row to delete..");
		}
		int RowCountAfter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");

		log.info("Row count after deleting is ---" + RowCountAfter);
		if (RowCountBefore - RowCountAfter == 1)
			flag = true;
		log.info("ProsperityMedianIncome_DeleteRow  ends here........");
		return flag;

	}
	// This method will Delete Row in Data Input - > Quality Of Life-->
	// Equitability: Median gross rent as (%) of household income

	public boolean Equitability_MedianGrossIncome_DeleteRow() {
		log.info("Equitability_MedianGrossIncome_DeleteRow  starts here........");
		boolean flag = false;
		waithelper.WaitForElementVisibleWithPollingTime(PreviousYearbutton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		int RowCountBefore = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Row showing is --" + RowCountBefore);
		if (RowCountBefore > 1) {
			try {
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")).click();
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to delete the row..");
				// TODO: handle exception
			}
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}

		} else {
			log.info("There is no any row to delete..");
		}
		int RowCountAfter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");

		log.info("Row count after deleting is ---" + RowCountAfter);
		if (RowCountBefore - RowCountAfter == 1)
			flag = true;
		log.info("CheckWasteGeneration_DeleteRow  ends here........");
		return flag;

	}

	// This method will Delete Row in Data Input - > Quality Of Life--> Prosperity:
	// Unemployment rate (%)

	public boolean ProsperityUnemployementRate_DeleteRow() {
		log.info("ProsperityUnemployementRate_DeleteRow  starts here........");
		boolean flag = false;
		waithelper.WaitForElementVisibleWithPollingTime(PreviousYearbutton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		int RowCountBefore = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Row showing is --" + RowCountBefore);
		if (RowCountBefore > 1) {
			try {
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")).click();
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to delete the row..");
				// TODO: handle exception
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}

		} else {
			log.info("There is no any row to delete..");
		}
		int RowCountAfter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");

		log.info("Row count after deleting is ---" + RowCountAfter);
		if (RowCountBefore - RowCountAfter == 1)
			flag = true;
		log.info("City_ProsperityUnemployementRate_Delete_Row  ends here........");
		return flag;

	}

	// This method will Delete Row in Data Input - > Quality Of Life--> Health &
	// Safety: Air quality days unhealthy for sensitive groups (Days/yr)

	public boolean HealthAndSafetySensitiveGroup_DeleteRow() {
		log.info("HealthAndSafetySensitiveGroup_DeleteRow  starts here........");
		boolean flag = false;
		waithelper.WaitForElementVisibleWithPollingTime(PreviousYearbutton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		int RowCountBefore = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Row showing is --" + RowCountBefore);
		if (RowCountBefore > 1) {
			try {
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")).click();
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to delete the row..");
				// TODO: handle exception
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}

		} else {
			log.info("There is no any row to delete..");
		}
		int RowCountAfter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");

		log.info("Row count after deleting is ---" + RowCountAfter);
		if (RowCountBefore - RowCountAfter == 1)
			flag = true;
		log.info("HealthAndSafetySensitiveGroup_DeleteRow  ends here........");
		return flag;

	}

	// This method will Delete Row in Data Input - > Quality Of Life--> Health &
	// Safety: Violent Crime (per year per capita)

	public boolean HealthAndSafetyVoilentCrime_DeleteRow() {
		log.info("HealthAndSafetyVoilentCrime_DeleteRow  starts here........");
		boolean flag = false;
		waithelper.WaitForElementVisibleWithPollingTime(PreviousYearbutton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		int RowCountBefore = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Row showing is --" + RowCountBefore);
		if (RowCountBefore > 1) {
			try {
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")).click();
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to delete the row..");
				// TODO: handle exception
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}

		} else {
			log.info("There is no any row to delete..");
		}
		int RowCountAfter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");

		log.info("Row count after deleting is ---" + RowCountAfter);
		if (RowCountBefore - RowCountAfter == 1)
			flag = true;
		log.info("HealthAndSafetyVoilentCrime_DeleteRow  ends here........");
		return flag;

	}

// This method will Delete Row in Data Input - > Water Consumption - > Data Tab 

	public boolean CheckWaterConsum_DeleteRow() {
		log.info("CheckWaterConsum_DeleteRow  starts here........");
		boolean flag = false;
		int RowCountBefore = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/span")).click();
		log.info("Total Row showing is --" + RowCountBefore);
		if (RowCountBefore > 1) {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			try {
				waithelper.waitForElementToBeStale(
						driver.findElement(By.xpath(
								"(//table[@class='meterListByType--wrapper']/tbody)[2]/tr[1]/td[3]/div/span/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")));
			} catch (StaleElementReferenceException e) {
				log.info("Stale Element Reference exception occurred");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else {

			try {
				waithelper.waitForElementToBeStale(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")));
				waithelper.waitForElementToBeStale(
						driver.findElement(By.xpath(
								"(//table[@class='meterListByType--wrapper']/tbody)[2]/tr[1]/td[3]/div/span/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")));
			} catch (StaleElementReferenceException e) {
				log.info("Stale Element Reference exception occurred");
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		int RowCountAfter = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");

		log.info("Row count after deleting is ---" + RowCountAfter);
		if (RowCountBefore - RowCountAfter == 1)
			flag = true;
		log.info("CheckWaterConsum_DeleteRow  ends here........");
		return flag;

	}

	// This method will add one row with previous year and One row with Next Year in
	// Data Input - > GHG Emission - > Data Tab

	public boolean CheckGHGEmission_SavePreviousAndNextYearRecord() {
		log.info("CheckGHGEmission_SavePreviousAndNextYearRecord  starts here........");
		boolean prev_flag = false;
		boolean Next_flag = false;
		int TotalRowBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of Rows before Adding  " + TotalRowBeforeAdding);
		PreviousYearbutton.click();
		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() - selected_year == 2) {
			String Tons_Year_Capita = Integer.toString(Integer.parseInt(data.getCellData("City", 4, 2)) + 10);
			log.info("Tons_Year_Capita value is ---" + Tons_Year_Capita);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input"))
					.sendKeys(Tons_Year_Capita);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button")).click();

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Energy Circular Image");
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(
							By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button/span[text()='Edit']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			int TotalRowAfterAddingPrevious = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of Rows after Adding Previous record " + TotalRowAfterAddingPrevious);
			if (TotalRowAfterAddingPrevious - TotalRowBeforeAdding == 1) {
				prev_flag = true;
				log.info("Previous year record added successfully...");
			} else {
				log.info("Previous year record not added successfully...");
			}

		}

		NextYearbutton.click();
		selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() == selected_year) {
			String Tons_Year_Capita = Integer.toString(Integer.parseInt(data.getCellData("City", 4, 2)) + 20);
			log.info("Tons_Year_Capita value is ---" + Tons_Year_Capita);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Tons_Year_Capita);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Energy Circular Image");
			}

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int TotalRowAfterAddingNext = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of Rows after Adding Next record " + TotalRowAfterAddingNext);
			if (TotalRowAfterAddingNext - TotalRowBeforeAdding == 2) {
				Next_flag = true;
				log.info("Next year record added successfully...");
			} else {
				log.info("Next year record not added successfully...");
			}

		}
		if (prev_flag && Next_flag) {
			log.info("CheckGHGEmission_SavePreviousAndNextYearRecord  ends here........");
			return true;
		} else {
			log.info("CheckGHGEmission_SavePreviousAndNextYearRecord  ends here........");
			return false;
		}
	}

// This method will add one row with previous year and One row with Next Year in Data Input - > GHG Emission - > Data Tab 

	public boolean CheckWaste_Generation_SavePreviousAndNextYearRecord() {
		log.info("CheckWaste_Generation_SavePreviousAndNextYearRecord  starts here........");
		int WasteTons;

		boolean prev_flag = false;
		boolean Next_flag = false;
		int TotalRowBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of Rows before Adding  " + TotalRowBeforeAdding);
		PreviousYearbutton.click();
		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() - selected_year == 2) {
			WasteTons = Integer.parseInt(data.getCellData("City", 10, 2));
			WasteTons = WasteTons - 5;
			log.info("Previous Year TONs Value is ---" + WasteTons);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input"))
					.sendKeys(Integer.toString(WasteTons));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button")).click();
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Waste Circular Image");
			}

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int TotalRowAfterAddingPrevious = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of Rows after Adding Previous record " + TotalRowAfterAddingPrevious);
			if (TotalRowAfterAddingPrevious - TotalRowBeforeAdding == 1) {
				prev_flag = true;
				log.info("Previous year record added successfully...");
			} else {
				log.info("Previous year record not added successfully...");
			}
		}

		NextYearbutton.click();
		selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() == selected_year) {
			WasteTons = Integer.parseInt(data.getCellData("City", 10, 2));
			WasteTons = WasteTons + 5;
			log.info("Next Year TONs Value is ---" + WasteTons);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(WasteTons));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Waste Circular Image");
			}

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(
							By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			int TotalRowAfterAddingNext = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of Rows after Adding Next record " + TotalRowAfterAddingNext);
			if (TotalRowAfterAddingNext - TotalRowBeforeAdding == 2) {
				Next_flag = true;
				log.info("Next year record added successfully...");
			} else {
				log.info("Next year record not added successfully...");
			}

		}
		if (prev_flag && Next_flag) {
			log.info("CheckWaste_Generation_SavePreviousAndNextYearRecord  ends here........");
			return true;
		} else {
			log.info("CheckWaste_Generation_SavePreviousAndNextYearRecord  ends here........");
			return false;
		}

	}

	// This method will add one row with previous year and One row with Next Year in
	// Data Input - > GHG Emission - > Data Tab

	public boolean CheckWaste_Diversion_SavePreviousAndNextYearRecord() {
		log.info("CheckWaste_Diversion_SavePreviousAndNextYearRecord  starts here........");
		int WastePercent;

		boolean prev_flag = false;
		boolean Next_flag = false;
		int TotalRowBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of Rows before Adding  " + TotalRowBeforeAdding);
		PreviousYearbutton.click();
		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() - selected_year == 2) {
			WastePercent = Integer.parseInt(data.getCellData("City", 12, 2));
			WastePercent = WastePercent - 5;
			log.info("Previous Year TONs Value is ---" + WastePercent);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input"))
					.sendKeys(Integer.toString(WastePercent));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button")).click();
			try {
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/span")),
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
				log.info("Unable to locate Waste Circular Image");
			}

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int TotalRowAfterAddingPrevious = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of Rows after Adding Previous record " + TotalRowAfterAddingPrevious);
			if (TotalRowAfterAddingPrevious - TotalRowBeforeAdding == 1) {
				prev_flag = true;
				log.info("Previous year record added successfully...");
			} else {
				log.info("Previous year record not added successfully...");
			}
		}

		NextYearbutton.click();
		selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() == selected_year) {
			WastePercent = Integer.parseInt(data.getCellData("City", 12, 2));
			WastePercent = WastePercent + 5;
			log.info("Next Year TONs Value is ---" + WastePercent);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(WastePercent));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			try {
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
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
				log.info("Unable to locate Waste Circular Image");
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int TotalRowAfterAddingNext = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of Rows after Adding Next record " + TotalRowAfterAddingNext);
			if (TotalRowAfterAddingNext - TotalRowBeforeAdding == 2) {
				Next_flag = true;
				log.info("Next year record added successfully...");
			} else {
				log.info("Next year record not added successfully...");
			}
		}

		if (prev_flag && Next_flag) {

			log.info("CheckWaste_Diversion_SavePreviousAndNextYearRecord  ends here........");
			return true;
		} else {
			log.info("CheckWaste_Diversion_SavePreviousAndNextYearRecord  ends here........");
			return false;
		}
	}

	// This method will add one row with previous year and One row with Next Year in
	// Data Input - > Transportation - > Data Tab

	public boolean Transportation_VMT_SavePreviousAndNextYearRecord() {
		log.info("Transportation_VMT_SavePreviousAndNextYearRecord  starts here........");
		int TransportMiles;

		boolean prev_flag = false;
		boolean Next_flag = false;
		int TotalRowBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of Rows before Adding  " + TotalRowBeforeAdding);
		PreviousYearbutton.click();
		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() - selected_year == 2) {
			TransportMiles = Integer.parseInt(data.getCellData("City", 14, 2));
			TransportMiles = TransportMiles - 5;
			log.info("Previous Year TONs Value is ---" + TransportMiles);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input"))
					.sendKeys(Integer.toString(TransportMiles));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button")).click();
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Transport Circular Image");
			}

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int TotalRowAfterAddingPrevious = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of Rows after Adding Previous record " + TotalRowAfterAddingPrevious);
			if (TotalRowAfterAddingPrevious - TotalRowBeforeAdding == 1) {
				prev_flag = true;
				log.info("Previous year record added successfully...");
			} else {
				log.info("Previous year record not added successfully...");
			}
		}

		NextYearbutton.click();
		selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() == selected_year) {
			TransportMiles = Integer.parseInt(data.getCellData("City", 14, 2));
			TransportMiles = TransportMiles + 5;
			log.info("Next Year TONs Value is ---" + TransportMiles);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(TransportMiles));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Transport Circular Image");
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int TotalRowAfterAddingNext = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of Rows after Adding Next record " + TotalRowAfterAddingNext);
			if (TotalRowAfterAddingNext - TotalRowBeforeAdding == 2) {
				Next_flag = true;
				log.info("Next year record added successfully...");
			} else {
				log.info("Next year record not added successfully...");
			}
		}

		if (prev_flag && Next_flag) {

			log.info("Transportation_VMT_SavePreviousAndNextYearRecord  ends here........");
			return true;
		} else {
			log.info("Transportation_VMT_SavePreviousAndNextYearRecord  ends here........");
			return false;
		}
	}

	// This method will add one row with previous year and One row with Next Year in
	// Data Input - >Quality Of Life--> Health And Safety - > Data Tab

	public boolean HealthAndSafety_SavePreviousAndNextYearRecord() {
		log.info("HealthAndSafety_SavePreviousAndNextYearRecord  starts here........");
		int value;
		boolean prev_flag = false;
		boolean Next_flag = false;
		int TotalRowBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of Rows before Adding  " + TotalRowBeforeAdding);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(PreviousYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		PreviousYearbutton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() - selected_year == 2) {
			value = Integer.parseInt(data.getCellData("City", 16, 2));
			value = value - 10;
			log.info("Previous Year Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button")).click();

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Circular Image");
			}

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int TotalRowAfterAddingPrevious = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of Rows after Adding Previous record " + TotalRowAfterAddingPrevious);
			if (TotalRowAfterAddingPrevious - TotalRowBeforeAdding == 1) {
				prev_flag = true;
				log.info("Previous year record added successfully...");
			} else {
				log.info("Previous year record not added successfully...");
			}
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);

		NextYearbutton.click();
		selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() == selected_year) {
			value = Integer.parseInt(data.getCellData("City", 16, 2));
			value = value + 5;
			log.info("Next Year TONs Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int TotalRowAfterAddingNext = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of Rows after Adding Next record " + TotalRowAfterAddingNext);
			if (TotalRowAfterAddingNext - TotalRowBeforeAdding == 2) {
				Next_flag = true;
				log.info("Next year record added successfully...");
			} else {
				log.info("Next year record not added successfully...");
			}
		}

		if (prev_flag && Next_flag) {

			log.info("HealthAndSafety_SavePreviousAndNextYearRecord  ends here........");
			return true;
		} else {
			log.info("HealthAndSafety_SavePreviousAndNextYearRecord  ends here........");
			return false;
		}
	}

	// This method will add one row with previous year and One row with Next Year in
	// Data Input - >Quality Of Life--> Education: Population with (at least)
	// Bachelor's degree (%) - > Data Tab

	public boolean Education_Bachelor_Population_SavePreviousAndNextYearRecord() {
		log.info("Education_Bachelor_Population_SavePreviousAndNextYearRecord  starts here........");
		int value;
		boolean prev_flag = false;
		boolean Next_flag = false;
		int TotalRowBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of Rows before Adding  " + TotalRowBeforeAdding);
		waithelper.WaitForElementClickable(PreviousYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		PreviousYearbutton.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() - selected_year == 2) {
			value = Integer.parseInt(data.getCellData("City", 18, 2));
			value = value - 5;
			log.info("Previous Year Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button")).click();
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int TotalRowAfterAddingPrevious = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of Rows after Adding Previous record " + TotalRowAfterAddingPrevious);
			if (TotalRowAfterAddingPrevious - TotalRowBeforeAdding == 1) {
				prev_flag = true;
				log.info("Previous year record added successfully...");
			} else {
				log.info("Previous year record not added successfully...");
			}
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);

		NextYearbutton.click();
		selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() == selected_year) {
			value = Integer.parseInt(data.getCellData("City", 18, 2));
			value = value + 5;
			log.info("Next Year TONs Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Transport Circular Image");
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int TotalRowAfterAddingNext = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of Rows after Adding Next record " + TotalRowAfterAddingNext);
			if (TotalRowAfterAddingNext - TotalRowBeforeAdding == 2) {
				Next_flag = true;
				log.info("Next year record added successfully...");
			} else {
				log.info("Next year record not added successfully...");
			}
		}

		if (prev_flag && Next_flag) {

			log.info("Education_Bachelor_Population_SavePreviousAndNextYearRecord  ends here........");
			return true;
		} else {
			log.info("Education_Bachelor_Population_SavePreviousAndNextYearRecord  ends here........");
			return false;
		}
	}
	// This method will add one row with previous year and One row with Next Year in
	// Data Input - >Quality Of Life--> Equitability: Gini coefficient (for income
	// distribution) - > Data Tab

	public boolean Equitability_Gini_Coefficient_SavePreviousAndNextYearRecord() {
		log.info("Equitability_Gini_Coefficient_SavePreviousAndNextYearRecord  starts here........");
		int value;
		boolean prev_flag = false;
		boolean Next_flag = false;
		int TotalRowBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of Rows before Adding  " + TotalRowBeforeAdding);
		waithelper.WaitForElementClickable(PreviousYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		PreviousYearbutton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() - selected_year == 2) {
			value = Integer.parseInt(data.getCellData("City", 20, 2));
			value = value - 1;
			log.info("Previous Year Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button")).click();

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int TotalRowAfterAddingPrevious = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of Rows after Adding Previous record " + TotalRowAfterAddingPrevious);
			if (TotalRowAfterAddingPrevious - TotalRowBeforeAdding == 1) {
				prev_flag = true;
				log.info("Previous year record added successfully...");
			} else {
				log.info("Previous year record not added successfully...");
			}

		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);

		NextYearbutton.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() == selected_year) {
			value = Integer.parseInt(data.getCellData("City", 20, 2));
			value = value + 0;
			log.info("Next Year TONs Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int TotalRowAfterAddingNext = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of Rows after Adding Next record " + TotalRowAfterAddingNext);
			if (TotalRowAfterAddingNext - TotalRowBeforeAdding == 2) {
				Next_flag = true;
				log.info("Next year record added successfully...");
			} else {
				log.info("Next year record not added successfully...");
			}

		}
		if (prev_flag && Next_flag) {

			log.info("Equitability_Gini_Coefficient_SavePreviousAndNextYearRecord  ends here........");
			return true;
		} else {
			log.info("Equitability_Gini_Coefficient_SavePreviousAndNextYearRecord  ends here........");
			return false;
		}
	}

	// This method will add one row with previous year and One row with Next Year in
	// Data Input - >Quality Of Life--> Education: Population with (at least) High
	// School degree (%) - > Data Tab

	public boolean Education_HighSchoolPopulation_SavePreviousAndNextYearRecord() {
		log.info("Education_HighSchoolPopulation_SavePreviousAndNextYearRecord  starts here........");
		int value;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean prev_flag = false;
		boolean Next_flag = false;
		int TotalRowBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of Rows before Adding  " + TotalRowBeforeAdding);
		waithelper.WaitForElementClickable(PreviousYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(PreviousYearbutton);

		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() - selected_year == 2) {
			value = Integer.parseInt(data.getCellData("City", 22, 2));
			value = value - 5;
			log.info("Previous Year Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button")).click();

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int TotalRowAfterAddingPrevious = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of Rows after Adding Previous record " + TotalRowAfterAddingPrevious);
			if (TotalRowAfterAddingPrevious - TotalRowBeforeAdding == 1) {
				prev_flag = true;
				log.info("Previous year record added successfully...");
			} else {
				log.info("Previous year record not added successfully...");
			}
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);

		JSHelper.clickElement(NextYearbutton);
		// NextYearbutton.click();
		selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() == selected_year) {
			value = Integer.parseInt(data.getCellData("City", 22, 2));
			value = value + 5;
			log.info("Next Year TONs Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int TotalRowAfterAddingNext = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of Rows after Adding Next record " + TotalRowAfterAddingNext);
			if (TotalRowAfterAddingNext - TotalRowBeforeAdding == 2) {
				Next_flag = true;
				log.info("Next year record added successfully...");
			} else {
				log.info("Next year record not added successfully...");
			}
		}

		if (prev_flag && Next_flag) {

			log.info("Education_HighSchoolPopulation_SavePreviousAndNextYearRecord  ends here........");
			return true;
		} else {
			log.info("Education_HighSchoolPopulation_SavePreviousAndNextYearRecord  ends here........");
			return false;
		}
	}

	// This method will add one row with previous year and One row with Next Year in
	// Data Input - >Quality Of Life--> Education: Population with (at least) High
	// School degree (%) - > Data Tab

	public boolean ProsperityMedianIncome_SavePreviousAndNextYearRecord() {
		log.info("ProsperityMedianIncome_SavePreviousAndNextYearRecord  starts here........");
		int value;
		boolean prev_flag = false;
		boolean Next_flag = false;
		int TotalRowBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of Rows before Adding  " + TotalRowBeforeAdding);
		waithelper.WaitForElementClickable(PreviousYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(PreviousYearbutton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() - selected_year == 2) {
			value = Integer.parseInt(data.getCellData("City", 24, 2));
			value = value - 10;
			log.info("Previous Year Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button")).click();
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int TotalRowAfterAddingPrevious = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of Rows after Adding Previous record " + TotalRowAfterAddingPrevious);
			if (TotalRowAfterAddingPrevious - TotalRowBeforeAdding == 1) {
				prev_flag = true;
				log.info("Previous year record added successfully...");
			} else {
				log.info("Previous year record not added successfully...");
			}
		}

		waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(NextYearbutton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// NextYearbutton.click();
		selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() == selected_year) {
			value = Integer.parseInt(data.getCellData("City", 24, 2));
			value = value + 10;
			log.info("Next Year TONs Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int TotalRowAfterAddingNext = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of Rows after Adding Next record " + TotalRowAfterAddingNext);
			if (TotalRowAfterAddingNext - TotalRowBeforeAdding == 2) {
				Next_flag = true;
				log.info("Next year record added successfully...");
			} else {
				log.info("Next year record not added successfully...");
			}
		}

		if (prev_flag && Next_flag) {

			log.info("ProsperityMedianIncome_SavePreviousAndNextYearRecord  ends here........");
			return true;
		} else {
			log.info("ProsperityMedianIncome_SavePreviousAndNextYearRecord  ends here........");
			return false;
		}
	}
	// This method will add one row with previous year and One row with Next Year in
	// Data Input - >Quality Of Life--> Equitability: Median gross rent as (%) of
	// household income - > Data Tab

	public boolean Equitability_MedianGrossIncome_SavePreviousAndNextYearRecord() {
		log.info("Equitability_MedianGrossIncome_SavePreviousAndNextYearRecord  starts here........");
		int value;
		boolean prev_flag = false;
		boolean Next_flag = false;
		int TotalRowBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of Rows before Adding  " + TotalRowBeforeAdding);
		waithelper.WaitForElementClickable(PreviousYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(PreviousYearbutton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() - selected_year == 2) {
			value = Integer.parseInt(data.getCellData("City", 26, 2));
			value = value - 10;
			log.info("Previous Year Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button")).click();
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Circular Image");
			}

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int TotalRowAfterAddingPrevious = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of Rows after Adding Previous record " + TotalRowAfterAddingPrevious);
			if (TotalRowAfterAddingPrevious - TotalRowBeforeAdding == 1) {
				prev_flag = true;
				log.info("Previous year record added successfully...");
			} else {
				log.info("Previous year record not added successfully...");
			}
		}

		waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(NextYearbutton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// NextYearbutton.click();
		selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() == selected_year) {
			value = Integer.parseInt(data.getCellData("City", 26, 2));
			value = value + 10;
			log.info("Next Year TONs Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int TotalRowAfterAddingNext = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of Rows after Adding Next record " + TotalRowAfterAddingNext);
			if (TotalRowAfterAddingNext - TotalRowBeforeAdding == 2) {
				Next_flag = true;
				log.info("Next year record added successfully...");
			} else {
				log.info("Next year record not added successfully...");
			}
		}

		if (prev_flag && Next_flag) {

			log.info("Equitability_MedianGrossIncome_SavePreviousAndNextYearRecord  ends here........");
			return true;
		} else {
			log.info("Equitability_MedianGrossIncome_SavePreviousAndNextYearRecord  ends here........");
			return false;
		}
	}

	// This method will add one row with previous year and One row with Next Year in
	// Data Input - >Quality Of Life--> Prosperity: Unemployment rate (%) - > Data
	// Tab

	public boolean ProsperityUnemployementRate_SavePreviousAndNextYearRecord() {
		log.info("ProsperityUnemployementRate_SavePreviousAndNextYearRecord  starts here........");
		int value;
		boolean prev_flag = false;
		boolean Next_flag = false;
		int TotalRowBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of Rows before Adding  " + TotalRowBeforeAdding);
		waithelper.WaitForElementClickable(PreviousYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(PreviousYearbutton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() - selected_year == 2) {
			value = Integer.parseInt(data.getCellData("City", 28, 2));
			value = value - 10;
			log.info("Previous Year Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button")).click();
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int TotalRowAfterAddingPrevious = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of Rows after Adding Previous record " + TotalRowAfterAddingPrevious);
			if (TotalRowAfterAddingPrevious - TotalRowBeforeAdding == 1) {
				prev_flag = true;
				log.info("Previous year record added successfully...");
			} else {
				log.info("Previous year record not added successfully...");
			}
		}
		waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(NextYearbutton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// NextYearbutton.click();
		selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() == selected_year) {
			value = Integer.parseInt(data.getCellData("City", 28, 2));
			value = value + 10;
			log.info("Next Year TONs Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int TotalRowAfterAddingNext = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of Rows after Adding Next record " + TotalRowAfterAddingNext);
			if (TotalRowAfterAddingNext - TotalRowBeforeAdding == 2) {
				Next_flag = true;
				log.info("Next year record added successfully...");
			} else {
				log.info("Next year record not added successfully...");
			}
		}

		if (prev_flag && Next_flag) {

			log.info("ProsperityUnemployementRate_SavePreviousAndNextYearRecord  ends here........");
			return true;
		} else {
			log.info("ProsperityUnemployementRate_SavePreviousAndNextYearRecord  ends here........");
			return false;
		}
	}

	// This method will add one row with previous year and One row with Next Year in
	// Data Input - >Quality Of Life--> Prosperity: Unemployment rate (%) - > Data
	// Tab

	public boolean HealthAndSafetySensitiveGroup_SavePreviousAndNextYearRecord() {
		log.info("HealthAndSafetySensitiveGroup_SavePreviousAndNextYearRecord  starts here........");
		int value;
		boolean prev_flag = false;
		boolean Next_flag = false;
		int TotalRowBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of Rows before Adding  " + TotalRowBeforeAdding);
		waithelper.WaitForElementClickable(PreviousYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(PreviousYearbutton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() - selected_year == 2) {
			value = Integer.parseInt(data.getCellData("City", 30, 2));
			value = value - 10;
			log.info("Previous Year Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button")).click();
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int TotalRowAfterAddingPrevious = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of Rows after Adding Previous record " + TotalRowAfterAddingPrevious);
			if (TotalRowAfterAddingPrevious - TotalRowBeforeAdding == 1) {
				prev_flag = true;
				log.info("Previous year record added successfully...");
			} else {
				log.info("Previous year record not added successfully...");
			}
		}

		waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(NextYearbutton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// NextYearbutton.click();
		selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() == selected_year) {
			value = Integer.parseInt(data.getCellData("City", 30, 2));
			value = value + 10;
			log.info("Next Year TONs Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int TotalRowAfterAddingNext = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of Rows after Adding Next record " + TotalRowAfterAddingNext);
			if (TotalRowAfterAddingNext - TotalRowBeforeAdding == 2) {
				Next_flag = true;
				log.info("Next year record added successfully...");
			} else {
				log.info("Next year record not added successfully...");
			}
		}

		if (prev_flag && Next_flag) {

			log.info("HealthAndSafetySensitiveGroup_SavePreviousAndNextYearRecord  ends here........");
			return true;
		} else {
			log.info("HealthAndSafetySensitiveGroup_SavePreviousAndNextYearRecord  ends here........");
			return false;
		}
	}

	// This method will add one row with previous year and One row with Next Year in
	// Data Input - >Quality Of Life-->Health & Safety: Violent Crime (per year per
	// capita) - > Data Tab

	public boolean HealthAndSafetyVoilentCrime_SavePreviousAndNextYearRecord() {
		log.info("HealthAndSafetyVoilentCrime_SavePreviousAndNextYearRecord  starts here........");
		int value;
		boolean prev_flag = false;
		boolean Next_flag = false;
		int TotalRowBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of Rows before Adding  " + TotalRowBeforeAdding);
		waithelper.WaitForElementClickable(PreviousYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(PreviousYearbutton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() - selected_year == 2) {
			value = Integer.parseInt(data.getCellData("City", 32, 2));
			value = value - 10;
			log.info("Previous Year Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button")).click();
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int TotalRowAfterAddingPrevious = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of Rows after Adding Previous record " + TotalRowAfterAddingPrevious);
			if (TotalRowAfterAddingPrevious - TotalRowBeforeAdding == 1) {
				prev_flag = true;
				log.info("Previous year record added successfully...");
			} else {
				log.info("Previous year record not added successfully...");
			}
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(NextYearbutton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// NextYearbutton.click();
		selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() == selected_year) {
			value = Integer.parseInt(data.getCellData("City", 32, 2));
			value = value + 10;
			log.info("Next Year TONs Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate  Circular Image");
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int TotalRowAfterAddingNext = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of Rows after Adding Next record " + TotalRowAfterAddingNext);
			if (TotalRowAfterAddingNext - TotalRowBeforeAdding == 2) {
				Next_flag = true;
				log.info("Next year record added successfully...");
			} else {
				log.info("Next year record not added successfully...");
			}
		}

		if (prev_flag && Next_flag) {

			log.info("HealthAndSafetyVoilentCrime_SavePreviousAndNextYearRecord  ends here........");
			return true;
		} else {
			log.info("HealthAndSafetyVoilentCrime_SavePreviousAndNextYearRecord  ends here........");
			return false;
		}
	}

// This method will add one row with previous year and One row with Next Year in Data Input - > GHG Emission - > Data Tab 

	public boolean CheckWaterConsum_SavePreviousAndNextYearRecord() {
		log.info("CheckWaterConsum_SavePreviousAndNextYearRecord  starts here........");

		boolean prev_flag = false;
		boolean Next_flag = false;
		int TotalRowBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		PreviousYearbutton.click();
		log.info("Total Number of record showing before adding..." + TotalRowBeforeAdding);
		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() - selected_year == 2) {
			String value = Integer.toString(Integer.parseInt(data.getCellData("City", 6, 2)) + 10);
			log.info("Previous Water value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input")).sendKeys(value);

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/div/button")).click();

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/div/ul/li/a[text()='"
					+ data.getCellData("City", 7, 2) + "']")).click();

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/div/button")).click();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/div/ul/li/a[text()='"
					+ data.getCellData("City", 8, 2) + "']")).click();

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[5]/button")).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[6]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate water Circular Image");
			}

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int TotalRowAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of record showing after adding..." + TotalRowAfterAdding);
			if (TotalRowAfterAdding - TotalRowBeforeAdding == 1) {
				log.info("Record added successfully for Previous year..");
				prev_flag = true;
			} else {
				log.info("Record not added for Previous year..");
				prev_flag = false;
			}

		}

		NextYearbutton.click();
		selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() == selected_year) {
			String value = Integer.toString(Integer.parseInt(data.getCellData("City", 6, 2)) + 20);
			log.info("Next Water value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).sendKeys(value);

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/button")).click();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/ul/li/a[text()='"
					+ data.getCellData("City", 7, 2) + "']")).click();

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/button")).click();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/ul/li/a[text()='"
					+ data.getCellData("City", 8, 2) + "']")).click();

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/button")).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate water Circular Image");
			}

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int TotalRowAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of record showing after adding..." + TotalRowAfterAdding);
			if (TotalRowAfterAdding - TotalRowBeforeAdding == 2) {
				log.info("Record added successfully for Next year..");
				Next_flag = true;
			} else {
				log.info("Record not added for Next year..");
				Next_flag = false;
			}
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (prev_flag && Next_flag) {
			log.info("CheckWaterConsum_SavePreviousAndNextYearRecord  ends here with true........");
			return true;
		} else {
			log.info("CheckWaterConsum_SavePreviousAndNextYearRecord  ends here with false ........");
			return false;
		}
	}

	// This method will add one row with previous year in Data Input - > Water
	// Consumption - > Data Tab

	public boolean CheckWaterConsumption_SaveNewRecord() {
		log.info("CheckWaterConsumption_SaveNewRecord  starts here........");

		int TotalRowBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of row before adding.. " + TotalRowBeforeAdding);
		WaterConsum_Data_AddYearBtn.click();
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		log.info("Selected Year is ---" + Selected_Year);
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("City", 6, 2));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/button")).click();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/ul/li/a[text()='"
					+ data.getCellData("City", 7, 2) + "']")).click();

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/button")).click();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/ul/li/a[text()='"
					+ data.getCellData("City", 8, 2) + "']")).click();

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/button")).click();

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/div/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Row Circular Image");
			}

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Water Circular Image");
			}
			try {

				waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Energy ScoreTip Message..");
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int TotalRowAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("After adding, number of row showing is ---" + TotalRowAfterAdding);
		if (TotalRowAfterAdding - TotalRowBeforeAdding == 1) {
			log.info("CheckWaterConsumption_SaveNewRecord  ends here with true........");
			return true;
		} else {
			log.info("CheckWaterConsumption_SaveNewRecord  ends here with false........");
			return false;
		}

	}

// This method will add one row with previous year in Data Input - > Waste - > Waste Generation -> Data Tab 

	public boolean CheckWaste_Generation_SaveNewRecord() {
		log.info("CheckWaste_Generation_SaveNewRecord  starts here........");
		// List<WebElement> TableRow =
		// driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int Prev_TableRowCount = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Before adding number of row showing is ---" + Prev_TableRowCount);
		Waste_AddYearButton.click();
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		log.info("Selected Year is ---" + Selected_Year);
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("City", 10, 2));

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Waste Circular Image");
			}
			try {

				waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Waste ScoreTip Message..");
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		int After_TableRowCount = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("After adding number of row showing is ---" + Prev_TableRowCount);
		if (After_TableRowCount - Prev_TableRowCount == 1) {
			log.info("CheckWaste_Generation_SaveNewRecord  ends here with true........");
			return true;
		} else {
			log.info("CheckWaste_Generation_SaveNewRecord  ends here with false........");
			return false;
		}
	}

	// This method will add one row with previous year in Data Input - > Waste - >
	// Waste Diversion -> Data Tab

	public boolean CheckWaste_Diversion_SaveNewRecord() {
		log.info("CheckWaste_Diversion_SaveNewRecord  starts here........");

		int Prev_TableRowCount = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Before adding number of row showing is ---" + Prev_TableRowCount);
		Waste_AddYearButton.click();
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		log.info("Selected Year is ---" + Selected_Year);
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("City", 12, 2));

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Energy Circular Image");
			}
			try {
				waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		int After_TableRowCount = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("After adding number of row showing is ---" + Prev_TableRowCount);
		if (After_TableRowCount - Prev_TableRowCount == 1) {
			log.info("CheckWaste_Diversion_SaveNewRecord  ends here with true........");
			return true;
		} else {
			log.info("CheckWaste_Diversion_SaveNewRecord  ends here with false........");
			return false;
		}

	}
// This method will add one row with Gallans Unit Type and one row with Litres Unit Type Data Input - > Water Consumption - > Data Tab 

	public boolean CheckWaterConsumption_AddRow_UnitTypes() {
		log.info("CheckWaterConsumption_AddRow_UnitTypes  starts here........");
		boolean flag = false;
		ArrayList<String> units = new ArrayList<String>();
		units.add("Gallons");
		units.add("Litres");
		Iterator itr = units.iterator();
		int TotalRowBeforeAdding;
		int TotalRowAfterAdding;
		// TotalRowBeforeAdding =
		// CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		// log.info("Total Number of record showing before adding..." +
		// TotalRowBeforeAdding);
		while (itr.hasNext()) {
			TotalRowBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			String unit = (String) itr.next();
			log.info("Unit Type--" + unit + "   is going to add.....");
			driver.findElement(By.xpath("//span[text()='Next Year']/parent::button")).click();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("City", 6, 2));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/button")).click();
			driver.findElement(
					By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/ul/li/a[text()='" + unit + "']"))
					.click();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/button")).click();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/ul/li/a[text()='"
					+ data.getCellData("City", 8, 2) + "']")).click();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/button")).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Water Circular Image");
			}

			TotalRowAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of record showing after adding..." + TotalRowAfterAdding);
			if (TotalRowAfterAdding - TotalRowBeforeAdding == 1) {
				log.info("Record added with Unit Type --" + unit);
				flag = true;
			} else {
				log.info("Record is not added with Unit Type --" + unit);
				flag = false;
				break;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		log.info("CheckWaterConsumption_AddRow_UnitTypes  ends here with " + flag + " ........");
		if (flag) {
			return true;
		} else
			return false;

	}

// This method will add one row each duration type dropdwon values. Data Input - > Water Consumption - > Data Tab 

	public boolean CheckWaterConsumption_AddRow_DurationTypes() {
		log.info("CheckWaterConsumption_AddRow_DurationTypes  starts here........");
		boolean flag = false;
		ArrayList<String> Durations = new ArrayList<String>();
		Durations.add("Per Year");
		Durations.add("Per Month");
		Durations.add("Per Week");
		Durations.add("Per Day");
		int TotalRowBeforeAdding;
		int TotalRowAfterAdding;
		TotalRowBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
		log.info("Total Number of record showing before adding..." + TotalRowBeforeAdding);
		Iterator itr = Durations.iterator();
		while (itr.hasNext()) {
			TotalRowBeforeAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			String Duration = (String) itr.next();
			log.info("Unit Type--" + Duration + "   is going to add.....");
			driver.findElement(By.xpath("//span[text()='Next Year']/parent::button")).click();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("City", 6, 2));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/button")).click();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/ul/li/a[text()='"
					+ data.getCellData("City", 7, 2) + "']")).click();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/button")).click();
			driver.findElement(
					By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/ul/li/a[text()='" + Duration + "']"))
					.click();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/button")).click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath("(//*[name()='svg' and @class='circular-loader'])[1]")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Unable to locate Water Circular Image");
			}

			TotalRowAfterAdding = CommonMethod.getTotalRowCount("//table[@id='readingsTable']/tbody/tr");
			log.info("Total Number of record showing after adding..." + TotalRowAfterAdding);
			if (TotalRowAfterAdding - TotalRowBeforeAdding == 1) {
				log.info("Record added with Unit Type --" + Duration);
				flag = true;
			} else {
				log.info("Record is not added with Unit Type --" + Duration);
				flag = false;
				break;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (flag) {
				log.info("Record added with Duration Type --" + Duration);
			} else {
				log.info("Record is not added with Duration Type --" + Duration);
				break;
			}
		}

		log.info("CheckWaterConsumption_AddRow_DurationTypes  ends here with " + flag + " ........");
		if (flag) {
			return true;
		} else {
			return false;
		}

	}

	// --> Certifications- > Verify Under Certifications- Shows text- "LEED v4.1
	// Cities Certification".

	public boolean CheckLEEDCitiesCertification() {
		log.info("CheckLEEDCitiesCertification  starts here........");
		String CertificationText = driver.findElement(By.xpath("//span[@class='cert_list_rs ng-binding']")).getText();
		log.info("Text Showing is " + CertificationText);

		if (CertificationText.equals("LEED v4.1 Cities Certification")) {
			log.info("CheckLEEDCitiesCertification  ends here with true........");
			return true;
		} else {
			log.info("CheckLEEDCitiesCertification  ends here with false........");
			return false;
		}

	}

	// --> Certifications- > Verify Under Certifications-button 'Register for LEED
	// Certification' redirects to LEED Online page-
	// "https://leedonline-stg.usgbc.org/"

	public boolean CheckRegisterForLEEDCertification() {
		log.info("CheckRegisterForLEEDCertification  starts here........");
		String title=null;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[contains(text(),'Register for LEED Certification')]")).click();
		Set<String> WindowList = driver.getWindowHandles();
		log.info(WindowList);
		log.info(WindowList.size());
		
		for (String window : WindowList) {
			if (!window.equals(BaseWindow)) {
				driver.switchTo().window(window);
				log.info(JSHelper.getCurrentURL());
				log.info(driver.getTitle());
				title=driver.getTitle();
				break;
			}
		}
		
		if (title.equals("LEED Online")) {
			log.info("CheckRegisterForLEEDCertification  ends here with true........");
			return true;
		} else {
			log.info("CheckRegisterForLEEDCertification  ends here with false........");
			return false;
		}

	}

	// --> Certifications- > Verify Under Certifications-'Recent certifications' at
	// Right hand side shows LEED badge with text "Projects achieved LEED
	// certification since Dec 10, 2021."

	public boolean CheckRecentCertifications() {
		log.info("CheckRecentCertifications  starts here........");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
		LocalDate todaydate = LocalDate.now();
		String strDate = formatter.format(todaydate.minusMonths(1));
		String ActText = driver.findElement(By.xpath("//div[@class='certification_number_text']")).getText();
		// String
		// SecondLine=driver.findElement(By.xpath("//div[@class='certification_number_text']/span")).getText();
		String ExpText = "Projects achieved LEED certification since " + strDate + ".";
		log.info("Actual Text showing is " + ActText);
		log.info("Expected Text should be is " + ExpText);

		if (ExpText.equals(ActText)) {
			log.info("CheckRecentCertifications  ends here with true........");
			return true;
		} else {
			log.info("CheckRecentCertifications  ends here with false........");
			return false;
		}

	}

	// --> Certifications- > Verify Under Certifications-'Recent certifications' -
	// 'Learn More' link redirects to "https://www.usgbc.org/projects"

	public boolean CheckLearnMoreLink() {
		log.info("CheckLearnMoreLink  starts here........");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[contains(text(),'Learn more')]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<String> WindowList = driver.getWindowHandles();
		for (String window : WindowList) {
			if (!window.equals(BaseWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		String currentURL = JSHelper.getCurrentURL();
		// String env=System.getProperty("environment").toLowerCase();
		String url = "https://www.usgbc.org/projects";
		log.info("Current URL is " + currentURL);
		log.info("Expected URL is " + url);
		if (currentURL.equals(url)) {
			log.info("CheckLearnMoreLink  ends here with true........");
			return true;
		} else {
			log.info("CheckLearnMoreLink  ends here with false........");
			return false;
		}

	}
	//Verify Under Certifications-Message is displayed "This project does not meet the requirements of the LEED performance prerequisites. Project must achieve a minimum score of 40 to meet the requirements of LEED performance prerequisites." Followed by individual score given for each performance category.

	public boolean Certifications_VerifyTextMessage() {
		log.info("Certifications_VerifyTextMessage  starts here........");
		String ActText=driver.findElement(By.xpath("//div[@id='certification-div']/descendant::div[@class='col-md-12 pl0 pr0 fs16 line_height_24 pt25 ng-binding']")).getText();
		String ExpText="This project does not meet the requirements of the LEED performance prerequisites. Project must achieve a minimum score of 40 to meet the requirements of LEED performance prerequisites.";
		log.info("Actual Text is   "+ActText);
		log.info("Expected Text is   "+ExpText);
		if (ExpText.equals(ActText)) {
			log.info("Certifications_VerifyTextMessage  ends here with true........");
			return true;
		} else {
			log.info("Certifications_VerifyTextMessage  ends here with false........");
			return false;
		}

	}

	// --> Verify under Manage--Project-- Project Details, Year founded is a
	// dropdown field with year values ranging from 1900 to current year.

	public boolean ManageProject_CheckYearRange() {
		log.info("ManageProject_CheckYearRange  starts here........");
		ArrayList<Integer> year = new ArrayList<Integer>();
		boolean flag = false;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> YearList = driver.findElements(ByAngular.repeater("type in year_constructed"));
		for (WebElement ele : YearList) {
			year.add(Integer.parseInt(ele.getText()));
		}
		int CurrentYear = CommonMethod.getCurrentYear();
		for (int i = 1900; i <= CurrentYear; i++) {
			if (year.contains(i)) {
				log.info(i + " year found");
				flag = true;
			} else {
				log.info(i + " year not found");
				flag = false;
				break;
			}
		}

		if (flag) {
			log.info("ManageProject_CheckYearRange  ends here with true........");
			return true;
		} else {
			log.info("ManageProject_CheckYearRange  ends here with false........");
			return false;
		}

	}

	// --> Verify Managing entity name, address(line 1), address(line 2), entity
	// city are text field and able to add any value in it.

	public boolean ManageProject_CheckEntityFields() {
		log.info("ManageProject_CheckEntityFields  starts here........");
		String MEntityName = data.getCellData("City", 34, 2);
		String MEntityAdd1 = data.getCellData("City", 35, 2);
		String MEntityAdd2 = data.getCellData("City", 36, 2);
		String MEntityCity = data.getCellData("City", 37, 2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ManagingEntityName.sendKeys(MEntityName);
		ManagingEntityAddress1.click();
		CommonMethod.waitUntilLoadElement();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ManagingEntityAddress1.sendKeys(MEntityAdd1);
		ManagingEntityAddress2.click();
		CommonMethod.waitUntilLoadElement();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ManagingEntityAddress2.sendKeys(MEntityAdd2);
		ManagingEntityCity.click();
		CommonMethod.waitUntilLoadElement();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ManagingEntityCity.sendKeys(MEntityCity);
		ManagingEntityAddress2.click();
		CommonMethod.waitUntilLoadElement();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CityPage.ClickonCertifications();

		ProjectSubmenu.click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//span[@class='fw-semi-bold' and text()='Project']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ActMEntityName = ManagingEntityName.getAttribute("value");
		String ActMEntityAddress1 = ManagingEntityAddress1.getAttribute("value");
		String ActMEntityAddress2 = ManagingEntityAddress2.getAttribute("value");
		String ActMEntityCity = ManagingEntityCity.getAttribute("value");

		log.info("Actual ManagingEntityName showing is " + ActMEntityName);
		log.info("Actual ManagingEntityAddress1  showing is " + ActMEntityAddress1);
		log.info("Actual ManagingEntityAddress2  showing is " + ActMEntityAddress2);
		log.info("Actual ManagingEntityCity  showing is " + ActMEntityCity);
		if (ActMEntityName.equals(MEntityName) && ActMEntityAddress1.equals(MEntityAdd1)
				&& ActMEntityAddress2.equals(MEntityAdd2) && ActMEntityCity.equals(MEntityCity)) {
			log.info("ManageProject_CheckEntityFields  ends here with true........");
			return true;
		} else {
			log.info("ManageProject_CheckEntityFields  ends here with false........");
			return false;
		}

	}

	// Verify Managing entity Country/region is drop down field and able to select
	// any country value from it.
	// Verify Managing entity State field is drop down field and the values change
	// as per the country selected in the country field.

	public boolean ManageProject_SelectCountryAndState() {
		log.info("ManageProject_SelectCountryAndState  starts here........");
		boolean IndiaStateflag = false;
		boolean USStateflag = false;
		List<String> USStateList = null;
		String State = data.getCellData("City", 38, 2);
		dropdownhelper.selectUsingVisibleText(driver.findElement(By.xpath("//select[@name='manageEntityCountry']")),
				"India");
		CommonMethod.waitUntilLoadElement();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> IndiaStateList = dropdownhelper
				.getAllDropdownData(driver.findElement(By.xpath("//select[@name='manageEntityState']")));
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int ActIndia_NoOfStates = IndiaStateList.size();
		log.info("Total Number of states listed for India are  " + ActIndia_NoOfStates);
		List<String> ExpIndiaStateList = CommonMethod.getStateList("India");
		int India_NoOfStates = ExpIndiaStateList.size();
		log.info("Total Number of states should be  " + India_NoOfStates);
		if (India_NoOfStates == ActIndia_NoOfStates && IndiaStateList.equals(ExpIndiaStateList)) {
			IndiaStateflag = true;
			log.info("States are showing proper for India...");
		}
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dropdownhelper.selectUsingVisibleText(driver.findElement(By.xpath("//select[@name='manageEntityCountry']")),
				"United States");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		USStateList = dropdownhelper
				.getAllDropdownData(driver.findElement(By.xpath("//select[@name='manageEntityState']")));
		int ActUS_NoOfStates = USStateList.size();
		log.info("Total Number of states listed for India are  " + ActUS_NoOfStates);
		List<String> ExpUSStateList = CommonMethod.getStateList("United States");
		int US_NoOfStates = ExpUSStateList.size();
		log.info("Total Number of states should be  " + US_NoOfStates);
		if (US_NoOfStates == ActUS_NoOfStates && USStateList.equals(ExpUSStateList)) {
			USStateflag = true;
			log.info("States are showing proper for United States...");
		}
		dropdownhelper.selectUsingVisibleText(driver.findElement(By.xpath("//select[@name='manageEntityState']")),
				State);
		CommonMethod.waitUntilLoadElement();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CityPage.ClickonCertifications();

		ProjectSubmenu.click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//span[@class='fw-semi-bold' and text()='Project']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ExpCountry = dropdownhelper
				.getSelectedValue(driver.findElement(By.xpath("//select[@name='manageEntityCountry']")));
		String ExpState = dropdownhelper
				.getSelectedValue(driver.findElement(By.xpath("//select[@name='manageEntityState']")));
		log.info("US State Flag value is " + USStateflag);
		log.info("India State Flag value is " + IndiaStateflag);
		log.info("Selected Country value is " + ExpCountry);
		log.info("Selected State value is " + ExpState);
		if ((USStateflag) && (IndiaStateflag) && (ExpCountry.equals("United States") && (ExpState.equals(State)))) {
			log.info("ManageProject_SelectCountryAndState  ends here with true........");
			return true;
		} else {
			log.info("ManageProject_SelectCountryAndState  ends here with false........");
			return false;
		}

	}

	// Verify Private is a radio button with options Yes And No. Able to select any
	// value from it.
	// Verify 'Intend to precertify?' field has radio button with options- Yes and
	// No.Able to select any value from it.

	public boolean ManageProject_PrivateRadioButton_IntendToPrecertify() {
		log.info("ManageProject_PrivateRadioButton_IntendToPrecertify  starts here........");
		boolean Privateflag = false;
		boolean IntendToPrecertifyflag = false;

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JSHelper.clickElement(driver.findElement(
				By.xpath("//span[text()='Private']/following-sibling::div/descendant::span[contains(text(),'Yes')]")));
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JSHelper.clickElement(driver.findElement(By.xpath(
				"//span[text()='Intend to precertify?']/following-sibling::div/descendant::span[contains(text(),'Yes')]")));

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CityPage.ClickonCertifications();

		ProjectSubmenu.click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//span[@class='fw-semi-bold' and text()='Project']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		log.info("PrivateYes flag is " + driver.findElement(By.xpath(
				"//span[text()='Private']/following-sibling::div/descendant::span[contains(text(),'Yes')]/input"))
				.isSelected());
		log.info("PrivateNo flag is " + driver.findElement(By
				.xpath("//span[text()='Private']/following-sibling::div/descendant::span[contains(text(),'No')]/input"))
				.isSelected());
		log.info("IntendToPrecertifyYes flag " + driver.findElement(By.xpath(
				"//span[text()='Intend to precertify?']/following-sibling::div/descendant::span[contains(text(),'Yes')]/input"))
				.isSelected());
		log.info("IntendToPrecertifyNo flag " + driver.findElement(By.xpath(
				"//span[text()='Intend to precertify?']/following-sibling::div/descendant::span[contains(text(),'No')]/input"))
				.isSelected());

		if (driver.findElement(By.xpath(
				"//span[text()='Private']/following-sibling::div/descendant::span[contains(text(),'Yes')]/input"))
				.isSelected()
				&& driver.findElement(By.xpath(
						"//span[text()='Intend to precertify?']/following-sibling::div/descendant::span[contains(text(),'Yes')]/input"))
						.isSelected()) {
			Privateflag = true;
			IntendToPrecertifyflag = true;
		} else {
			Privateflag = false;
			IntendToPrecertifyflag = false;
		}

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(
				By.xpath("//span[text()='Private']/following-sibling::div/descendant::span[contains(text(),'No')]"))
				.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath(
				"//span[text()='Intend to precertify?']/following-sibling::div/descendant::span[contains(text(),'No')]"))
				.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CityPage.ClickonCertifications();

		ProjectSubmenu.click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//span[@class='fw-semi-bold' and text()='Project']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		log.info("PrivateYes flag is " + driver.findElement(By.xpath(
				"//span[text()='Private']/following-sibling::div/descendant::span[contains(text(),'Yes')]/input"))
				.isSelected());
		log.info("PrivateNo flag is " + driver.findElement(By
				.xpath("//span[text()='Private']/following-sibling::div/descendant::span[contains(text(),'No')]/input"))
				.isSelected());
		log.info("IntendToPrecertifyYes flag " + driver.findElement(By.xpath(
				"//span[text()='Intend to precertify?']/following-sibling::div/descendant::span[contains(text(),'Yes')]/input"))
				.isSelected());
		log.info("IntendToPrecertifyNo flag " + driver.findElement(By.xpath(
				"//span[text()='Intend to precertify?']/following-sibling::div/descendant::span[contains(text(),'No')]/input"))
				.isSelected());

		if (driver.findElement(By
				.xpath("//span[text()='Private']/following-sibling::div/descendant::span[contains(text(),'No')]/input"))
				.isSelected()
				&& driver.findElement(By.xpath(
						"//span[text()='Intend to precertify?']/following-sibling::div/descendant::span[contains(text(),'No')]/input"))
						.isSelected()) {
			Privateflag = true;
			IntendToPrecertifyflag = true;
		} else {
			Privateflag = false;
			IntendToPrecertifyflag = false;
		}

		if ((Privateflag) && (IntendToPrecertifyflag)) {
			log.info("ManageProject_PrivateRadioButton_IntendToPrecertify  ends here with true........");
			return true;
		} else {
			log.info("ManageProject_PrivateRadioButton_IntendToPrecertify  ends here with false........");
			return false;
		}

	}

	// Verify Target certification date opens up a Calendar and able to seelct any
	// date from the calendar.

	public boolean ManageProject_TargetCertificationDate() {
		log.info("ManageProject_TargetCertificationDate  starts here........");
		ngWebDriver.waitForAngularRequestsToFinish();
		ManagingEntityAddress1.click();
		TargetCertificationDate.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		WebElement ele=driver.findElement(By.xpath("(//div[@class='datepicker datepicker-dropdown dropdown-menu']/descendant::table[@class=' table-condensed']/tbody/tr/td[@class='day   active'])[9]"));
		log.info(ele.getSize().height);
		log.info(ele.getSize().width);
		log.info(ele.getSize());
		log.info(ele.getLocation().x);
		log.info(ele.getLocation().y);
		log.info(ele.getLocation().getX());
		log.info(ele.getLocation().getY());
		ele.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		CommonMethod.waitUntilLoadElement();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		CityPage.ClickonCertifications();

		ProjectSubmenu.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		String ActTargetSelected = TargetCertificationDate.getAttribute("value");
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
		Date date = new Date();
		String strDate = formatter.format(date);
		strDate = formatter.format(date);
		log.info("Actual Certification Target Date is " + ActTargetSelected);
		log.info("Expected Certification Target Date is " + strDate);

		if (ActTargetSelected.equals(strDate)) {
			log.info("ManageProject_TargetCertificationDate  ends here with true........");
			return true;
		} else {
			log.info("ManageProject_TargetCertificationDate  ends here with false........");
			return false;
		}

	}

	// Verify ARC Administrator will be created by default when a project is created
	// Verify that project should have minimum one ARC adminsitrator.

	public boolean ManageTeam_CheckDefaultARCAdministrator() {
		log.info("ManageTeam_CheckDefaultARCAdministrator  starts here........");
		boolean flag = false;
		String msg = null;
		boolean deleteFlag = true;
		ngWebDriver.waitForAngularRequestsToFinish();
		String email = prop.getProperty("email");
		flag = CommonMethod.CheckRoleOfEmail(email, "Arc Administrator");
		if (flag) {
			msg = CommonMethod.Team_EditRole(email, "Arc Administrator", "Team Member");
			deleteFlag = CommonMethod.Team_Delete_Member(email);
			flag = CommonMethod.CheckRoleOfEmail(email, "Arc Administrator");
		}
		if (flag == true && msg.equals("Project should have at least one Arc Administrator.") && deleteFlag == false) {
			log.info("ManageTeam_CheckDefaultARCAdministrator  ends here with true........");
			return true;
		} else {
			log.info("ManageTeam_CheckDefaultARCAdministrator  ends here with false........");
			return false;
		}

	}

	// verify under Manage-teams- 'Invite team members' able to add team member
	// successfully.
	// Verify team member can be added who is a registered USGBC.org user. Verify
	// authorization level should be by default as 'Team Member' if added any new
	// team member

	public boolean ManageTeam_CheckAddNewTeamMember() {
		log.info("ManageTeam_CheckAddNewTeamMember  starts here........");
		boolean MemberAddedflag = false;
		boolean flag = false;
		ngWebDriver.waitForAngularRequestsToFinish();
		String username = data.getCellData("City", 0, 2);
		MemberAddedflag = CommonMethod.Team_Add_Member(username);
		if (MemberAddedflag) {
			flag = CommonMethod.CheckRoleOfEmail(username, "Team Member");
		} else {
			log.info("Member not added..");
		}
		if (flag) {
			log.info("ManageTeam_CheckAddNewTeamMember  ends here with true........");
			return true;
		} else {
			log.info("ManageTeam_CheckAddNewTeamMember  ends here with false........");
			return false;
		}

	}

	// Verify if the team member added is unregistered user, throws error message in
	// red "a@aa.com is not a registered USGBC.org user, please have the user
	// register at https://new.usgbc.org/registration/create-user and try again."

	public boolean ManageTeam_CheckAddUnregisteredTeamMember() {
		log.info("ManageTeam_CheckAddNewTeamMember  starts here........");
		boolean flag = false;
		boolean Memberflag = false;
		String Message = null;
		ngWebDriver.waitForAngularRequestsToFinish();
		String UnRegisteredUsername = data.getCellData("City", 39, 2);
		Message = CommonMethod.Team_InviteMember(UnRegisteredUsername);
		String ExpMessage = UnRegisteredUsername
				+ "is not a registered USGBC.org user, please have the user register at https://new.usgbc.org/registration/create-user and try again.";
		if (Message != null) {
			if (Message.equals(ExpMessage)) {
				log.info(Message + " message displaying...");
				flag = true;
			} else {
				log.info(Message + " message displaying...");
				flag = false;
			}
		} else {
			log.info("No Message showing....");
			flag = false;
		}

		if (flag == false) {
			Memberflag = CommonMethod.Team_checkEmailExistOrNot(UnRegisteredUsername);
			if (Memberflag) {
				log.info(UnRegisteredUsername + " added as Team Member..");
			} else {
				log.info(UnRegisteredUsername + " not added as Team Member..");
			}
		}
		if (flag) {
			log.info("ManageTeam_CheckAddUnregisteredTeamMember  ends here with true........");
			return true;
		} else {
			log.info("ManageTeam_CheckAddUnregisteredTeamMember  ends here with false........");
			return false;
		}
	}

	// Adding the same team role for a member again, should give a validation
	// message like 'ashree511@gmail.com already has the same team role'

	public boolean ManageTeam_AddExistingTeamMember() {
		log.info("ManageTeam_AddExistingTeamMember  starts here........");
		boolean flag = false;
		String Message = null;
		ngWebDriver.waitForAngularRequestsToFinish();
		String Username = data.getCellData("City", 0, 2);
		Message = CommonMethod.Team_InviteMember(Username);
		String ExpMessage = "This ID is already added to the team.";
		if (Message != null) {
			if (Message.equals(ExpMessage)) {
				log.info(Message + " message displaying...");
				flag = true;
			} else {
				log.info(Message + " message displaying...");
				flag = false;
			}
		} else {
			log.info("No Message showing....");
			flag = false;
		}

		if (flag) {
			log.info("ManageTeam_AddExistingTeamMember  ends here with true........");
			return true;
		} else {
			log.info("ManageTeam_AddExistingTeamMember  ends here with false........");
			return false;
		}
	}

	// Verify existing ARC administrator can't be edited until another ARC
	// adminstrator is present. If edited, error message will display as 'Project
	// should have atleast one ARC Administrator'.

	public boolean ManageTeam_EditARCAdministratorRole() {
		log.info("ManageTeam_EditARCAdministratorRole  starts here........");
		boolean EditEnabledFlag = false;
		boolean DeleteEnabledFlag = false;
		boolean InviteEnabledFlag = false;
		String ValidationMessage = null;
		String Message = null;
		ngWebDriver.waitForAngularRequestsToFinish();
		String ExistingUser = prop.getProperty("email");
		String AltenateUser = data.getCellData("City", 0, 2);
		ValidationMessage = CommonMethod.Team_EditRole(ExistingUser, "Arc Administrator", "Team Member");// (In case of
																											// Logged in
																											// User and
																											// only one
																											// ARC
																											// Admin)
																											// Project
																											// should
																											// have at
																											// least one
																											// Arc
																											// Administrator.
		String ExpMessage = "Project should have at least one Arc Administrator.";
		log.info("Validation Message showing " + ValidationMessage);
		if (ValidationMessage.equals(ExpMessage)) {
			log.info("Validation Message showing proper..");
			Message = CommonMethod.Team_EditRole(AltenateUser, "Team Member", "Arc Administrator");// Team member
																									// updated
																									// successfully.
			log.info("Alternate email updated with " + Message);
			if (Message.equals("Team member updated successfully.")) {
				log.info("Alternate Email is updated with Arc Administrator");
				Message = CommonMethod.Team_EditRole(ExistingUser, "Arc Administrator", "Team Member");// Team member
																										// updated
																										// successfully.
				log.info("Existing email updated with " + Message);
				if (Message.equals("Team member updated successfully.")) {
					CommonMethod.RefreshPagewaitForPageLoaded(driver);
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					log.info("Existing Email is updated with Team Member");

					List<WebElement> EditBtnList = driver.findElements(By.xpath(
							"//table[@class='table table-striped arc-table mb40 ng-scope']/tbody/tr/td[4]/descendant::button[text()='Edit']"));
					List<WebElement> DeleteBtnList = driver.findElements(By.xpath(
							"//table[@class='table table-striped arc-table mb40 ng-scope']/tbody/tr/td[5]/div[@class='ml10 delete_report tippy_init floatNone']"));
					for (WebElement ele : EditBtnList) {
						try {
							ele.click();
							EditEnabledFlag = false;
							break;
						} catch (ElementClickInterceptedException e) {
							EditEnabledFlag = true;
						}

					}
					for (WebElement ele : DeleteBtnList) {
						try {
							ele.click();
							DeleteEnabledFlag = false;
							break;
						} catch (ElementClickInterceptedException e) {
							DeleteEnabledFlag = true;
						}

					}

					try {
						driver.findElement(By.xpath("//button[@id='invite_team']")).click();
						InviteEnabledFlag = false;
					} catch (ElementClickInterceptedException e) {
						InviteEnabledFlag = true;
					}

				}
			}
		}

		log.info("Edit button flag is " + EditEnabledFlag);
		log.info("Delete button flag is " + DeleteEnabledFlag);
		log.info("Invite button flag is " + InviteEnabledFlag);

		if (EditEnabledFlag == true && InviteEnabledFlag == true && DeleteEnabledFlag == true) {
			log.info("ManageTeam_EditARCAdministratorRole  ends here with true........");
			return true;
		} else {
			log.info("ManageTeam_EditARCAdministratorRole  ends here with false........");
			return false;
		}
	}

	// Verify able to add/update/remove team member.
	// Verify authorization level Member, etc can be changed and vice-versa.

	public boolean ManageTeam_TeamAddEditMember() {
		log.info("ManageTeam_TeamAddEditMember  starts here........");
		ngWebDriver.waitForAngularRequestsToFinish();
		boolean AddFlag = false;
		String Message1 = null;
		String Message2 = null;
		String Message3 = null;
		String ExpMsg = null;
		String AltenateUser = data.getCellData("City", 0, 2);
		AddFlag = CommonMethod.Team_Add_Member(AltenateUser);
		log.info("Add Member flag is " + AddFlag);
		if (AddFlag) {
			Message1 = CommonMethod.Team_EditRole(AltenateUser, "Team Member", "Team Manager");
			Message2 = CommonMethod.Team_EditRole(AltenateUser, "Team Manager", "Read Only");
			Message3 = CommonMethod.Team_EditRole(AltenateUser, "Read Only", "Arc Administrator");
			log.info("Message1 displaying text is " + Message1);
			log.info("Message2 displaying text is " + Message2);
			log.info("Message3 displaying text is " + Message3);
		} else {
			log.info("Team member is not added successfully..");
		}

		ExpMsg = "Team member updated successfully.";
		if (Message1.equals(ExpMsg) && Message2.equals(ExpMsg) && Message3.equals(ExpMsg)) {
			log.info("ManageTeam_TeamAddEditMember  ends here with true........");
			return true;
		} else {
			log.info("ManageTeam_TeamAddEditMember  ends here with false........");
			return false;
		}
	}

	public boolean ManageTeam_TeamAddRemoveMember() {
		log.info("ManageTeam_TeamAddRemoveMember  starts here........");
		ngWebDriver.waitForAngularRequestsToFinish();
		boolean AddFlag = false;
		boolean SearchFlag = false;
		String AltenateUser = data.getCellData("City", 0, 2);
		AddFlag = CommonMethod.Team_Add_Member(AltenateUser);
		log.info("Add Member flag is " + AddFlag);
		if (AddFlag) {
			CommonMethod.Team_Delete_Member(AltenateUser);
			HomePage.checkSignOut();
			HomePage = LoginPage.loginLater(data.getCellData("City", 0, 2), data.getCellData("City", 1, 2));
			ProjectPage = HomePage.clickOnProject();
			SearchFlag = ProjectPage.SearchProject(System.getProperty("CityProject_NonLeed2"));
			HomePage.closeProjectSearchTextBox();
			HomePage.checkSignOut();
			HomePage = LoginPage.loginLater(prop.getProperty("email"), prop.getProperty("password"));
		} else {
			log.info("Team member is not added successfully..");
		}
		log.info("AddFlag is " + AddFlag);
		log.info("SearchFlag is " + SearchFlag);
		if (AddFlag == true && SearchFlag == false) {
			log.info("ManageTeam_TeamAddRemoveMember  ends here with true........");
			return true;
		} else {
			log.info("ManageTeam_TeamAddRemoveMember  ends here with false........");
			return false;
		}
	}

	public boolean ManageTeam_HowTeamRolesWorkTooltip() {
		log.info("ManageTeam_HowTeamRolesWorkTooltip  starts here........");
		ngWebDriver.waitForAngularRequestsToFinish();
		WebElement TeamTooltip = driver
				.findElement(By.xpath("//span[text()='How team roles work']/following-sibling::span"));
		waithelper.WaitForElementClickable(TeamTooltip, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		TeamTooltip.click();
		String ActToolTipP1 = driver.findElement(By.xpath("//div[@class='row p20 fw-400']/p[1]")).getText();
		String ActToolTipP2 = driver.findElement(By.xpath("//div[@class='row p20 fw-400']/p[2]")).getText();
		String ActToolTipP3 = driver.findElement(By.xpath("//div[@class='row p20 fw-400']/p[3]")).getText();
		String ActToolTipP4 = driver.findElement(By.xpath("//div[@class='row p20 fw-400']/p[4]")).getText();
		String ActToolTipP5 = driver.findElement(By.xpath("//div[@class='row p20 fw-400']/p[5]")).getText();
		String ActToolTipP6 = driver.findElement(By.xpath("//div[@class='row p20 fw-400']/p[6]")).getText();
		ngWebDriver.waitForAngularRequestsToFinish();
		log.info("Tooltip is ");
		String ExpToolTipP1 = "Arc Administrator:\n"
				+ "The Arc Administrator has complete access to the project including data entry, submitting for review, and is granted rights to add additional team members. The Arc Administrator will also be the point of contact for automatic notifications, billing information, and review reports.";

		String ExpToolTipP2 = "Note: While multiple “Arc Administrators” can exist on a project team, we strongly recommend that you designate only one person in this role to avoid confusion and so that a single point of contact is receiving notifications about billing and certification.";
		String ExpToolTipP3 = "Team Manager:\n"
				+ "A Team Manager has access to the project including data entry and submitting for review, and can make changes to the project team.";
		String ExpToolTipP4 = "Team Member:\n"
				+ "A Team Member has access to the project including data entry and submitting for review, but cannot make any changes to the project team.";
		String ExpToolTipP5 = "Project Administrator:\n"
				+ "A Project Administrator is the original LEED Project Administrator and will only appear on the project team for LEED projects that were previously or are currently using LEED Online. The Project Administrator has the same rights as the Arc Administrator.";
		String ExpToolTipP6 = "Read Only:\n"
				+ "Read Only members can access the project to view data but cannot make any changes to the project, data entry or the project team.";
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info(ActToolTipP1);
		log.info(ExpToolTipP1);
		log.info("--------------------");
		log.info(ActToolTipP2);
		log.info(ExpToolTipP2);
		log.info("--------------------");
		log.info(ActToolTipP3);
		log.info(ExpToolTipP3);
		log.info("--------------------");
		log.info(ActToolTipP4);
		log.info(ExpToolTipP4);
		log.info("--------------------");
		log.info(ActToolTipP5);
		log.info(ExpToolTipP5);
		log.info("--------------------");
		log.info(ActToolTipP6);
		log.info(ExpToolTipP6);
		log.info("--------------------");

		CommonMethod.RefreshPagewaitForPageLoaded(driver);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info(ExpToolTipP1.equals(ActToolTipP1));
		log.info(ExpToolTipP2.equals(ActToolTipP2));
		log.info(ExpToolTipP3.equals(ActToolTipP3));
		log.info(ExpToolTipP4.equals(ActToolTipP4));
		log.info(ExpToolTipP5.equals(ActToolTipP5));
		log.info(ExpToolTipP6.equals(ActToolTipP6));
		if ((ExpToolTipP1.equals(ActToolTipP1)) && (ExpToolTipP2.equals(ActToolTipP2))
				&& (ExpToolTipP3.equals(ActToolTipP3)) && (ExpToolTipP4.equals(ActToolTipP4))
				&& (ExpToolTipP5.equals(ActToolTipP5)) && (ExpToolTipP6.equals(ActToolTipP6))) {
			log.info("ManageTeam_HowTeamRolesWorkTooltip  ends here with true........");
			return true;
		} else {
			log.info("ManageTeam_HowTeamRolesWorkTooltip  ends here with false........");
			return false;
		}
	}

	public boolean Manage_Agreement_CheckAgreement() {
		log.info("Manage_Agreement_CheckAgreement method starts here ......");
		boolean flag = false;
		String RowPath = "//table[@class='table table-striped arc-table']/tbody/tr";
		List<WebElement> AgreementTable = driver.findElements(By.xpath(RowPath));
		log.info("Size of the Agreement Table is ---" + AgreementTable.size());
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
		Date date = new Date();
		String strDate = formatter.format(date);
		strDate = formatter.format(date);
		log.info(strDate);
		if (AgreementTable.size() > 0) {
			AgreementTable.iterator();
			String OrderTypePath = "";
			String DateSignedPath = "";
			for (int i = 0; i < AgreementTable.size(); i++) {
				int rownum = i + 1;
				OrderTypePath = RowPath + "[" + rownum + "]/td[2]/span";
				String OrderType = driver.findElement(By.xpath(OrderTypePath)).getText();
				log.info(OrderTypePath + "......." + OrderType);
				if (OrderType.equals("Registration")) {
					log.info("Order Type Registration found ..");
					DateSignedPath = RowPath + "[" + rownum + "]/td[1]/span";
					String DateSigned = driver.findElement(By.xpath(DateSignedPath)).getText();
					log.info("Date Signed showing is " + DateSigned);
					if (DateSigned.equals(strDate)) {
						flag = true;
						break;
					}

				}

			}
		}
		if (flag) {
			log.info("Date signes showing proper ...");
		} else {
			log.info("Date signes is not showing proper ...");
		}
		log.info("Manage_Agreement_CheckAgreement method ends here ......");
		return flag;

	}

	public boolean CheckAgreementDownloadedFile(String user) {
		log.info("CheckAgreementDownloadedFile method starts here ......");
		// DownloadFolder=new File(UUID.randomUUID().toString());
		String userid=null;
		SimpleDateFormat Formatter = new SimpleDateFormat("EEE");
		String stringDay = Formatter.format(new Date());
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
		Date date = new Date();
		String strDate = formatter.format(date);
		strDate = formatter.format(date);
		String ExpDate = stringDay + ", " + strDate;
		log.info("Temporary folder name is ---" + DownloadFolder);
		File ListOfFiles[] = DownloadFolder.listFiles();
		boolean flag = false;
		String FilePath = null;
		// make sure the directory is not empty
		log.info("Total file downloaded ...." + ListOfFiles.length);
		if (ListOfFiles.length != 0) {
			for (File file : ListOfFiles) {
				log.info("Size of the file - " + file.getName() + " is  " + file.length());
				if (file.getName().equals("Agreement.pdf")) {
					FilePath = file.getAbsolutePath();
					log.info("File Path is ---" + FilePath);
					flag = true;
					break;
				}

			}

		} else {
			flag = false;
		}
		if (flag) {
			String pdfcontent = CommonMethod.getPDFContent("file:///" + FilePath);
			String ProjectID = "Project ID : " + System.getProperty("CityProject5");
			String RatingSystem = "Rating system : none";
			String UserName = "User Name : " + user;
			String useremail = "User Email : " + prop.getProperty("email");
			if(System.getProperty("environment").equals("QAS"))
			{
				userid ="User ID : 0010640669";
			}
			else if(System.getProperty("environment").equals("STG"))
			{
				userid ="User ID : 0010545793";
			}
			String DateTime = "Date and Time of Acceptance : " + ExpDate;
			String ProjectName = "Name of Project : " + System.getProperty("CityProject5_Name");
			String OwnerEmail = "Owner Email : " + prop.getProperty("email");
			log.info("----------------------------------------");
			log.info("ProjectID is "+ProjectID);
			log.info("RatingSystem is "+RatingSystem);
			log.info("UserName is "+UserName);
			log.info("useremail is "+useremail);
			log.info("userid is "+userid);
			log.info("DateTime is "+DateTime);
			log.info("ProjectName is "+ProjectName);
			log.info("OwnerEmail is "+OwnerEmail);
			log.info(pdfcontent.contains(ProjectID));
			log.info(pdfcontent.contains(RatingSystem));
			log.info(pdfcontent.contains(UserName));
			log.info(pdfcontent.contains(useremail));
			log.info(pdfcontent.contains(userid));
			log.info(pdfcontent.contains(DateTime));
			log.info(pdfcontent.contains(ProjectName));
			log.info(pdfcontent.contains(OwnerEmail));
			if (pdfcontent.contains(ProjectID) && pdfcontent.contains(RatingSystem) && pdfcontent.contains(UserName) && pdfcontent.contains(useremail) && pdfcontent.contains(userid) && pdfcontent.contains(DateTime) && pdfcontent.contains(ProjectName) && pdfcontent.contains(OwnerEmail)) {
				flag=true;
			} else
				flag=false;

		}

		CommonMethod.DeleteAllFiles();
		DownloadFolder.delete();
		log.info("CheckAgreementDownloadedFile method ends here with "+flag+ " ......");
		return flag;
	}

	public boolean CheckSettings_DataResourceLink() {
		log.info("CheckSettings_DataResourceLink method starts here ......");
		String DataGuideURL = null;
		boolean DataGuideURLFlag = false;
		boolean DataReviewCheckListFlag = false;
		ngWebDriver.waitForAngularRequestsToFinish();
		driver.findElement(By.xpath("//div[@class='link'][text()='Data guide for buildings']")).click();
		ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Set<String> WindowList = driver.getWindowHandles();
		if (WindowList.size() > 1) {
			for (String window : WindowList) {
				if (!window.equals(BaseWindow)) {
					driver.switchTo().window(window);
					DataGuideURL = JSHelper.getCurrentURL();
					log.info("Current URL is " + DataGuideURL);
					driver.close();
					driver.switchTo().window(BaseWindow);
				}
			}
		}

		if (DataGuideURL.equals("https://www.usgbc.org/resources/data-management-buildings")) {
			DataGuideURLFlag = true;
		}

		driver.findElement(By.xpath("//div[@class='link'][text()='Data review checklist (pdf)']")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Temporary folder name is ---" + DownloadFolder);
		File ListOfFiles[] = DownloadFolder.listFiles();
		boolean flag = false;
		String FilePath = null;
		// make sure the directory is not empty
		log.info("Total file downloaded ...." + ListOfFiles.length);
		if (ListOfFiles.length != 0) {
			for (File file : ListOfFiles) {
				log.info("Size of the file - " + file.getName() + " is  " + file.length());
				if (file.getName().contains("Data Review Checklist")) {
					DataReviewCheckListFlag = true;
					break;
				}

			}

		}
		log.info("DataGuideURLFlag flag value is "+DataGuideURLFlag);
		log.info("DataReviewCheckListFlag flag value is "+DataReviewCheckListFlag);	
		if(DataGuideURLFlag==true && DataReviewCheckListFlag==true)
		{
			log.info("CheckSettings_DataResourceLink emthod ends with true...");
			return true;
		}
		else
		{
			log.info("CheckSettings_DataResourceLink emthod ends with false...");
			return false;
		}
	}
	
	
	public boolean Settings_ScoreAnimationToggleButton() {
		log.info("Settings_ScoreAnimationToggleButton method starts here ......");
		String DataGuideURL = null;
		boolean DataGuideURLFlag = false;
		boolean DataReviewCheckListFlag = false;
		ngWebDriver.waitForAngularRequestsToFinish();
		
		log.info(driver.findElement(By.xpath("//div[@class='settings_row']/descendant::span/small")).getAttribute("style"));
		log.info("-------------------------");
		driver.findElement(By.xpath("//div[@class='settings_row']/descendant::span")).click();
		ngWebDriver.waitForAngularRequestsToFinish();
		log.info(driver.findElement(By.xpath("//div[@class='settings_row']/descendant::span/small")).getAttribute("style"));
		
		if(DataGuideURLFlag==true && DataReviewCheckListFlag==true)
		{
			log.info("Settings_ScoreAnimationToggleButton emthod ends with true...");
			return true;
		}
		else
		{
			log.info("Settings_ScoreAnimationToggleButton emthod ends with false...");
			return false;
		}
	}
	public boolean CheckScoreVersion() {
		log.info("CheckScoreVersion method starts here ......");
		ngWebDriver.waitForAngularRequestsToFinish();
		String ExpText="Arc score for cities version "+data.getCellData("City", 40, 2);
		String ActText=driver.findElement(By.xpath("//*[@id='content']/descendant::h3")).getText();	
		log.info("Actual Text is "+ActText);
		log.info("Expected Text is "+ExpText);		
		if(ExpText.equals(ActText))
		{
			log.info("CheckScoreVersion emthod ends with true...");
			return true;
		}
		else
		{
			log.info("CheckScoreVersion emthod ends with false...");
			return false;
		}
	}

}
