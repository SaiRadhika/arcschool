package com.arc.PageObject.Project;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class CommunitiesPageObject extends BaseClass {

	private static Logger log = LoggerHelper.getLogger(CommunitiesPageObject.class);

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

	@FindBy(xpath = "(//table[@class='meterListByType--wrapper']/tbody)[3]/tr[1]/td[3]/div/span/span")
	WebElement WasteScore;

	@FindBy(xpath = "//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span/span")
	WebElement QualityScore;
	
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

	// ************************************************************************

	@FindBy(xpath = "(//*[text()='Manage' and @class='ml10'])[1]")
	WebElement ManageMenu;

	@FindBy(xpath = "(//*[text()='Data Input'])[1]")
	WebElement DataInputSubMenu;

	public CommunitiesPageObject() {
		PageFactory.initElements(driver, this);
	}

	public void ClickonAgreementInManage() {
		waithelper.WaitForElementClickable(ManageMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ManageMenu.click();
		waithelper.WaitForElementClickable(AgreementSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		AgreementSubmenu.click();

	}

	public void ClickonBillingInManage() {
		waithelper.WaitForElementClickable(ManageMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ManageMenu.click();
		waithelper.WaitForElementClickable(BillingSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		BillingSubmenu.click();

	}

	public boolean checkCommunitiesProjectCreation(String PName) {

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

	public void ClickonDataInput() {

		log.info("ClickonDataInput method started here. ...");
		waithelper.WaitForElementVisibleWithPollingTime(PerformanceHeaderText,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		DataInputSubMenu.click();

		log.info("ClickonDataInput method ends here. ...");
	}

	public void ClickonProjectSetting() {

		log.info("ClickonProjectSetting method started here. ...");
		// driver.switchTo().frame("datainput-widget");
		waithelper.WaitForElementVisibleWithPollingTime(ProjectSettingButton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ProjectSettingButton.click();
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

//This method will click on Energy --> GHG Emissions
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
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//*[contains(text(),'GHG Emissions')])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
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
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath(
						"(//*[contains(text(),'Vehicle miles traveled on individual vehicles daily (VMT)')])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
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
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(
						By.xpath("(//*[contains(text(),'Health & Safety: Median air quality index (AQI)')])[3]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
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
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath(
						"(//*[contains(text(),\"Education: Population with (at least) Bachelor's degree\")])[3]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
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
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath(
						"(//*[contains(text(),\"Equitability: Gini coefficient (for income distribution)\")])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
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
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath(
						"(//*[contains(text(),\"Education: Population with (at least) High School degree (%)\")])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		log.info("ClickonEducation_HighSchoolPopulation method ends here.....");

	}

//This method will click on Quality of Life --> Prosperity: Median household income (US Dollars/Year)
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
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By
						.xpath("(//*[contains(text(),\"Prosperity: Median household income (US Dollars/Year)\")])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
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
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath(
						"(//*[contains(text(),\"Equitability: Median gross rent as (%) of household income\")])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
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
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//*[contains(text(),\"Prosperity: Unemployment rate (%)\")])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
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
		waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath(
				"(//*[contains(text(),\"Health & Safety: Air quality days unhealthy for sensitive groups (Days/yr)\")])[3]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
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
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By
						.xpath("(//*[contains(text(),\"Health & Safety: Violent Crime (per year per capita)\")])[3]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		log.info("ClickonHealthAndSafetyVoilentCrime method ends here.....");

	}

	// This method will click on Water --> Water Consumption
	public void ClickonWaterConsumption() {
		log.info("ClickonWaterConsumption method started .............");

		// driver.switchTo().frame("datainput-widget");
		waithelper.WaitForElementVisibleWithPollingTime(WaterConsumption,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		WaterConsumption.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//*[contains(text(),'Water consumption')])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(4000);
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
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//*[contains(text(),'Municipal solid waste generation intensity')])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(4000);
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
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(
						By.xpath("(//*[contains(text(),'Municipal solid waste diversion rate from landfill')])[4]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickonMunicipalSolidWasteDiversion method ends .............");
	}

	public void getCityProjectID() {
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

	public void ClickonTeamInManage() {
		try {
			ManageMenu.click();
			TeamSubmenu.click();
			waithelper.waitForElement(driver.findElement(By.xpath("//span[text()='Team']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to traverse Team Submenu");
		}

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
		log.info("Energy Score is -----" + score);
		log.info("getEnergyScore method ends here........");
		return score;

	}

	// This method will return the Transportation score

	public int getTransportScore() {

		log.info("getTransportScore method starts here........");

		int score = Integer.parseInt(TransportScore.getText());
		log.info("Transport Score is -----" + score);
		log.info("Transport Score is -----" + score);
		log.info("getTransportScore method ends here........");
		return score;

	}
	// This method will return the Waste score

	public int getWasteScore() {

		log.info("getWasteScore method starts here........");

		int score = Integer.parseInt(WasteScore.getText());
		log.info("Waste Score is -----" + score);
		log.info("Waste Score is -----" + score);
		log.info("getWasteScore method ends here........");
		return score;

	}

	// This method will return the Water score

	public int getWaterScore() {

		log.info("getWaterScore method starts here........");
		int score = Integer.parseInt(WaterScore.getText());
		log.info("Water Score is -----" + score);
		log.info("Water Score is -----" + score);
		log.info("getWaterScore method ends here........");
		return score;

	}

	// This method will return the Quality Of Life score
		public int getQualityOfLifeScore() {

			log.info("getQualityOfLifeScore method starts here........");
			int score = Integer.parseInt(QualityScore.getText());
			log.info("Quality Of Life Score is -----" + score);
			log.info("Quality Of Life Score -----" + score);
			log.info("getQualityOfLifeScore method ends here........");
			return score;

		}
	public boolean checkUnitTypeInProjectAreaUnderDataInput(String UnitType) {

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
		boolean Activityflag = false;
		waithelper.WaitForElementClickable(Population_CommentTextBox,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Population_CommentTextBox.sendKeys(comment);
		waithelper.WaitForElementClickable(Population_PostButton, Integer.parseInt(prop.getProperty("explicitTime")),
				2);
		JSHelper.clickElement(Population_PostButton);
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
		boolean Activityflag = false;
		JSHelper.clickElement(GHGEmission_DetailsTab);

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
		boolean Activityflag = false;
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
		boolean Activityflag = false;
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
		boolean Activityflag = false;
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
		boolean Activityflag = false;
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

	// This method will add comment and check in activity section DI - >Quality Of
	// Life--> Health And Safety
	// - Details Tab and check it in Activity
	public boolean checkHealthAndSafetyCommentAndActivity(String comment, String uname) {
		log.info("checkHealthAndSafetyCommentAndActivity  starts here........");
		boolean Commentflag = false;
		boolean Activityflag = false;
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
		boolean Activityflag = false;
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
		boolean Activityflag = false;
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
		boolean Activityflag = false;
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
		boolean Activityflag = false;
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

		/*
		 * waithelper.WaitForElementClickable(PopulationTab,
		 * Integer.parseInt(prop.getProperty("explicitTime")), 2);
		 * 
		 * PopulationTab.click();
		 */
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			// log.info("Decade Calender for Effective Year is showing proper..........");
			decadeCalenderflag = true;
		} else {
			// log.info("Decade Calender for Effective Year is not showing
			// proper..........");
			decadeCalenderflag = false;
		}

		Population_populationTextBox.sendKeys(population);
		Population_SaveButton.click();

		// ithelper.WaitForElementInvisible(
		// driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/button/span[text()='Save']")),Integer.parseInt(prop.getProperty("explicitTime")),
		// 2);

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(
						By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/*[@class='fade-out saved_symbol']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("(//table[@class='meterListByType--wrapper']/tbody)[2]/tr[1]/td[3]/div/span/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		log.info("checkPopulation_Save_New_Row method ends here .........");
		return decadeCalenderflag;

	}

	public boolean checkPopulationUpdatedByUserName(String Username) {
		log.info("checkPopulationUpdatedByUserName method starts here............");
		driver.switchTo().frame("datainput-widget");
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
		driver.switchTo().frame("datainput-widget");
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

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/span")),Integer.parseInt(prop.getProperty("explicitTime")),
		// 2);
		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("(//table[@class='meterListByType--wrapper']/tbody)[2]/tr[1]/td[3]/div/span/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		// waithelper.WaitForElementInvisible(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/button/span[text()='Save']")),
		// Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		log.info("checkProjectArea_Save_New_Row method ends here .........");
		return decadeCalenderflag;

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
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		log.info("Total Row display is ---  " + rows.size());

		log.info("Total Row display is ---  " + rows.size());
		if (rows.size() > 0) {
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

	// Project Setting -- > Population --> This method will add records and check
	// whether filter is working or not

	public boolean CheckPopulationFilter() {
		log.info("CheckPopulationFilter starts here ................");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean flag = false;
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 5;
		int prev_year = CurrentYear - 1;
		int population = 100;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;
		log.info("Population-->Going to add record from --" + StartYear + "  to " + prev_year);
		for (int i = StartYear; i < CurrentYear; i++) {
			log.info("Population-->Going to add record for year--" + i + "  with " + population);
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
				Thread.sleep(1000);
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
					.sendKeys(Integer.toString(population));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/button")).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"(//table[@class='meterListByType--wrapper']/tbody)[2]/tr[1]/td[3]/div/span/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				log.info(e.getMessage());
				e.printStackTrace();
			}
			population = population + 100;
		}
		log.info("Total Row display is ---  " + rows.size());

		log.info("Total Row display is ---  " + rows.size());
		int beforeFilter = rows.size();

		waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		YearFilterButton.click();

		YearStartDateTextBox.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String Startxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterStartYear + "']";
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

		// YearStartDateTextBox.sendKeys(Integer.toString(filterStartYear));
		// YearEndDateTextBox.sendKeys(Integer.toString(filterEndYear));

		waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		YearUpdateBtn.click();
		int j = 1;
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

		log.info(" Value of J is --" + j);
		boolean boundaryflag = false;
		try {
			boundaryflag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
					.isDisplayed();
			log.info("boundaryflag value is ---" + boundaryflag);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception Block boundaryflag value is ---" + boundaryflag);
		}
		log.info("CheckPopulationFilter ends here ................");
		if (flag == true && boundaryflag == false)
			return true;
		else
			return false;

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
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 5;
		int prev_year = CurrentYear - 1;
		int PArea = 100;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;
		log.info("Project Area-->Going to add record from " + StartYear + "to " + prev_year);
		for (int i = StartYear; i < CurrentYear; i++) {
			log.info("Project Area-->Going to add record for year--" + i + "  with " + PArea);
			waithelper.WaitForElementClickable(ProjectSettingAddRowButton,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			ProjectSettingAddRowButton.click();
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

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"(//table[@class='meterListByType--wrapper']/tbody)[2]/tr[1]/td[3]/div/span/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info(e.getMessage());
			}
			PArea = PArea + 100;
		}
		log.info("Total Row display is ---  " + rows.size());

		log.info("Total Row display is ---  " + rows.size());
		int beforeFilter = rows.size();

		waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		YearFilterButton.click();

		YearStartDateTextBox.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String Startxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterStartYear + "']";
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

		// YearStartDateTextBox.sendKeys(Integer.toString(filterStartYear));
		// YearEndDateTextBox.sendKeys(Integer.toString(filterEndYear));
		waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		YearUpdateBtn.click();
		int j = 1;
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

		log.info(" Value of J is --" + j);
		boolean boundaryflag = false;
		try {
			boundaryflag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
					.isDisplayed();
			log.info("boundaryflag value is ---" + boundaryflag);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception Block boundaryflag value is ---" + boundaryflag);
		}
		log.info("CheckProjectAreaFilter ends here ................");
		if (flag == true && boundaryflag == false)
			return true;
		else
			return false;
	}

	// GHG Emissions -- > Energy --> This method will add records and check whether
	// filter is working or not

	public boolean CheckEnergyFilter() {
		log.info("CheckEnergyFilter starts here ................");
		GHGEmission_Data_AddYearBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean flag = false;
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 6;
		int prev_year = CurrentYear - 1;
		int tons = 100;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;

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

		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("(//table[@class='meterListByType--wrapper']/tbody)[1]/tr[1]/td[3]/div/span/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		StartYear++;
		tons = tons + 10;

		for (int i = StartYear; i < CurrentYear; i++) {

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
					.sendKeys(Integer.toString(tons));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody)[1]/tr[1]/td[3]/div/span/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			tons = tons + 2;
		}
		log.info("Total Row display is ---  " + rows.size());

		log.info("Total Row display is ---  " + rows.size());
		int beforeFilter = rows.size();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);

		YearFilterButton.click();

		/*
		 * waithelper.WaitForElementClickable(YearStartDateTextBox,Integer.parseInt(prop
		 * .getProperty("explicitTime")), 2);
		 * JSHelper.clickElement(YearStartDateTextBox); //YearStartDateTextBox.click();
		 * waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath(
		 * "(//table[@class='table-condensed'])[2]")),
		 * Integer.parseInt(prop.getProperty("explicitTime")), 2); String Startxpath =
		 * "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='"+
		 * filterStartYear+"']"; try { driver.findElement(By.xpath(Startxpath)).click();
		 * } catch(NoSuchElementException e) { driver.findElement(By.xpath(
		 * "(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
		 * driver.findElement(By.xpath(Startxpath)).click(); } catch(Exception e) {
		 * e.printStackTrace();
		 * 
		 * } JSHelper.clickElement(YearEndDateTextBox); //YearEndDateTextBox.click();
		 * waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath(
		 * "(//table[@class='table-condensed'])[2]")),
		 * Integer.parseInt(prop.getProperty("explicitTime")), 2); String Endxpath =
		 * "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='"+
		 * filterEndYear+"']"; try { driver.findElement(By.xpath(Endxpath)).click(); }
		 * catch(NoSuchElementException e) { driver.findElement(By.xpath(
		 * "(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
		 * driver.findElement(By.xpath(Endxpath)).click(); } catch(Exception e) {
		 * e.printStackTrace();
		 * 
		 * }
		 */

		YearStartDateTextBox.sendKeys(Integer.toString(filterStartYear));
		YearEndDateTextBox.sendKeys(Integer.toString(filterEndYear));
		waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		YearUpdateBtn.click();
		int j = 1;
		log.info("FilterEndYears is --" + filterEndYear + "    Filter start year is  " + filterStartYear);
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

		log.info(" Value of J is --" + j);
		boolean boundaryflag = false;
		try {
			boundaryflag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
					.isDisplayed();
			log.info("boundaryflag value is ---" + boundaryflag);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception Block boundaryflag value is ---" + boundaryflag);
		}
		log.info("CheckEnergyFilter ends here ................");
		if (flag == true && boundaryflag == false)
			return true;
		else
			return false;
	}

	// Transportation -- > VMT --> This method will add records and check whether
	// filter is working or not

	public boolean CheckTransportationFilter() {
		log.info("CheckTransportationFilter starts here ................");
		VMT_Data_AddYearBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean flag = false;
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 6;
		int prev_year = CurrentYear - 1;
		int Miles = 10;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;

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

		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("//table[@class='meterListByType--wrapper']/tbody[4]/tr[1]/td[3]/div/span[1]/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		StartYear++;
		Miles = Miles + 2;

		for (int i = StartYear; i < CurrentYear; i++) {

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

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[4]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			Miles = Miles + 2;
		}
		log.info("Total Row display is ---  " + rows.size());

		log.info("Total Row display is ---  " + rows.size());
		int beforeFilter = rows.size();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);

		YearFilterButton.click();

		YearStartDateTextBox.sendKeys(Integer.toString(filterStartYear));
		YearEndDateTextBox.sendKeys(Integer.toString(filterEndYear));
		waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		YearUpdateBtn.click();
		int j = 1;
		log.info("FilterEndYears is --" + filterEndYear + "    Filter start year is  " + filterStartYear);
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

		log.info(" Value of J is --" + j);
		boolean boundaryflag = false;
		try {
			boundaryflag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
					.isDisplayed();
			log.info("boundaryflag value is ---" + boundaryflag);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception Block boundaryflag value is ---" + boundaryflag);
		}
		log.info("CheckTransportationFilter ends here ................");
		if (flag == true && boundaryflag == false)
			return true;
		else
			return false;
	}

	// Quality Of Life--> Health And Safety --> This method will add records and
	// check whether filter is working or not

	public boolean CheckHealthAndSafetyFilter() {
		log.info("CheckHealthAndSafetyFilter starts here ................");

		waithelper.WaitForElementClickable(HealthAndSafety_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		HealthAndSafety_Data_AddYearBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean flag = false;
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 6;
		int prev_year = CurrentYear - 1;
		int Miles = 10;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;

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

		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		StartYear++;
		Miles = Miles + 2;

		for (int i = StartYear; i < CurrentYear; i++) {
			waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);

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

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			Miles = Miles + 2;
		}
		log.info("Total Row display is ---  " + rows.size());

		log.info("Total Row display is ---  " + rows.size());
		int beforeFilter = rows.size();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);

		YearFilterButton.click();

		YearStartDateTextBox.sendKeys(Integer.toString(filterStartYear));
		YearEndDateTextBox.sendKeys(Integer.toString(filterEndYear));
		waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		YearUpdateBtn.click();
		int j = 1;
		log.info("FilterEndYears is --" + filterEndYear + "    Filter start year is  " + filterStartYear);
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

		log.info(" Value of J is --" + j);
		boolean boundaryflag = false;
		try {
			boundaryflag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
					.isDisplayed();
			log.info("boundaryflag value is ---" + boundaryflag);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception Block boundaryflag value is ---" + boundaryflag);
		}
		log.info("CheckHealthAndSafetyFilter ends here ................");
		if (flag == true && boundaryflag == false)
			return true;
		else
			return false;
	}

	// Quality Of Life--> Education: Population with (at least) Bachelor's degree
	// (%) --> This method will add records and check whether filter is working or
	// not

	public boolean CheckEducation_Bachelor_Population_Filter() {
		log.info("CheckEducation_Bachelor_Population_Filter starts here ................");
		waithelper.WaitForElementClickable(Education_BachelorPopulation_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Education_BachelorPopulation_Data_AddYearBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean flag = false;
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 6;
		int prev_year = CurrentYear - 1;
		int Percent = 50;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;

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

		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		StartYear++;
		Percent = Percent + 2;

		for (int i = StartYear; i < CurrentYear; i++) {

			waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);

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

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			Percent = Percent + 2;
		}
		log.info("Total Row display is ---  " + rows.size());

		log.info("Total Row display is ---  " + rows.size());
		int beforeFilter = rows.size();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);

		YearFilterButton.click();
		YearStartDateTextBox.sendKeys(Integer.toString(filterStartYear));
		YearEndDateTextBox.sendKeys(Integer.toString(filterEndYear));
		waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		YearUpdateBtn.click();
		int j = 1;
		log.info("FilterEndYears is --" + filterEndYear + "    Filter start year is  " + filterStartYear);
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

		log.info(" Value of J is --" + j);
		boolean boundaryflag = false;
		try {
			boundaryflag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
					.isDisplayed();
			log.info("boundaryflag value is ---" + boundaryflag);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception Block boundaryflag value is ---" + boundaryflag);
		}
		log.info("CheckEducation_Bachelor_Population_Filter ends here ................");
		if (flag == true && boundaryflag == false)
			return true;
		else
			return false;
	}

	// Quality Of Life--> Equitability: Gini coefficient (for income distribution)
	// --> This method will add records and check whether filter is working or not

	public boolean CheckEquitability_Gini_Coefficient_Filter() {
		log.info("CheckEquitability_Gini_Coefficient_Filter starts here ................");

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
		boolean flag = false;
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 6;
		int prev_year = CurrentYear - 1;
		int value = 1;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;

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

		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		StartYear++;
		// Percent=Percent+2;

		for (int i = StartYear; i < CurrentYear; i++) {
			waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);

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

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			// Percent=Percent+2;
		}
		log.info("Total Row display is ---  " + rows.size());

		log.info("Total Row display is ---  " + rows.size());
		int beforeFilter = rows.size();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);

		YearFilterButton.click();
		YearStartDateTextBox.sendKeys(Integer.toString(filterStartYear));
		YearEndDateTextBox.sendKeys(Integer.toString(filterEndYear));
		waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		YearUpdateBtn.click();
		int j = 1;
		log.info("FilterEndYears is --" + filterEndYear + "    Filter start year is  " + filterStartYear);
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

		log.info(" Value of J is --" + j);
		boolean boundaryflag = false;
		try {
			boundaryflag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
					.isDisplayed();
			log.info("boundaryflag value is ---" + boundaryflag);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception Block boundaryflag value is ---" + boundaryflag);
		}
		log.info("CheckEquitability_Gini_Coefficient_Filter ends here ................");
		if (flag == true && boundaryflag == false)
			return true;
		else
			return false;
	}

	// Quality Of Life--> Education: Population with (at least) High School degree
	// (%) --> This method will add records and check whether filter is working or
	// not

	public boolean CheckEducation_HighSchoolPopulation_Filter() {
		log.info("CheckEducation_HighSchoolPopulation_Filter starts here ................");
		// JSHelper.clickElement(Education_HighSchoolPopulation_Data_AddYearBtn);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(Education_HighSchoolPopulation_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Education_HighSchoolPopulation_Data_AddYearBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean flag = false;
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 6;
		int prev_year = CurrentYear - 1;
		int value = 65;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;

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

		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		StartYear++;
		value = value + 2;

		for (int i = StartYear; i < CurrentYear; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);

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

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			value = value + 2;
		}
		log.info("Total Row display is ---  " + rows.size());

		log.info("Total Row display is ---  " + rows.size());
		int beforeFilter = rows.size();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);

		YearFilterButton.click();
		YearStartDateTextBox.sendKeys(Integer.toString(filterStartYear));
		YearEndDateTextBox.sendKeys(Integer.toString(filterEndYear));
		waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		YearUpdateBtn.click();
		int j = 1;
		log.info("FilterEndYears is --" + filterEndYear + "    Filter start year is  " + filterStartYear);
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

		log.info(" Value of J is --" + j);
		boolean boundaryflag = false;
		try {
			boundaryflag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
					.isDisplayed();
			log.info("boundaryflag value is ---" + boundaryflag);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception Block boundaryflag value is ---" + boundaryflag);
		}
		log.info("CheckEducation_HighSchoolPopulation_Filter ends here ................");
		if (flag == true && boundaryflag == false)
			return true;
		else
			return false;
	}

	// Quality Of Life--> Prosperity: Median household income (US Dollars/Year) -->
	// This method will add records and check whether filter is working or not

	public boolean CheckProsperityMedianIncome_Filter() {
		log.info("CheckProsperityMedianIncome_Filter starts here ................");
		// JSHelper.clickElement(Education_HighSchoolPopulation_Data_AddYearBtn);
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
		boolean flag = false;
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 6;
		int prev_year = CurrentYear - 1;
		int value = 1000;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;

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

		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		StartYear++;
		value = value + 10;

		for (int i = StartYear; i < CurrentYear; i++) {
			waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
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

			// driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).sendKeys(Integer.toString(i));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			value = value + 10;
		}
		log.info("Total Row display is ---  " + rows.size());

		log.info("Total Row display is ---  " + rows.size());
		int beforeFilter = rows.size();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);

		YearFilterButton.click();
		YearStartDateTextBox.sendKeys(Integer.toString(filterStartYear));
		YearEndDateTextBox.sendKeys(Integer.toString(filterEndYear));
		waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		YearUpdateBtn.click();
		int j = 1;
		log.info("FilterEndYears is --" + filterEndYear + "    Filter start year is  " + filterStartYear);
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

		log.info(" Value of J is --" + j);
		boolean boundaryflag = false;
		try {
			boundaryflag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
					.isDisplayed();
			log.info("boundaryflag value is ---" + boundaryflag);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception Block boundaryflag value is ---" + boundaryflag);
		}
		log.info("CheckProsperityMedianIncome_Filter ends here ................");
		if (flag == true && boundaryflag == false)
			return true;
		else
			return false;
	}

	// Quality Of Life--> Equitability: Median gross rent as (%) of household income
	// --> This method will add records and check whether filter is working or not

	public boolean CheckEquitability_MedianGrossIncome_Filter() {
		log.info("CheckProsperityMedianIncome_Filter starts here ................");
		// JSHelper.clickElement(Education_HighSchoolPopulation_Data_AddYearBtn);
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
		boolean flag = false;
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 6;
		int prev_year = CurrentYear - 1;
		int value = 50;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;

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

		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		StartYear++;
		value = value + 5;

		for (int i = StartYear; i < CurrentYear; i++) {
			waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
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

			// driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).sendKeys(Integer.toString(i));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			value = value + 10;
		}
		log.info("Total Row display is ---  " + rows.size());

		log.info("Total Row display is ---  " + rows.size());
		int beforeFilter = rows.size();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);

		YearFilterButton.click();
		YearStartDateTextBox.sendKeys(Integer.toString(filterStartYear));
		YearEndDateTextBox.sendKeys(Integer.toString(filterEndYear));
		waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		YearUpdateBtn.click();
		int j = 1;
		log.info("FilterEndYears is --" + filterEndYear + "    Filter start year is  " + filterStartYear);
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

		log.info(" Value of J is --" + j);
		boolean boundaryflag = false;
		try {
			boundaryflag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
					.isDisplayed();
			log.info("boundaryflag value is ---" + boundaryflag);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception Block boundaryflag value is ---" + boundaryflag);
		}
		log.info("CheckEquitability_MedianGrossIncome_Filter ends here ................");
		if (flag == true && boundaryflag == false)
			return true;
		else
			return false;
	}

	// Quality Of Life--> Prosperity: Unemployment rate (%) --> This method will add
	// records and check whether filter is working or not

	public boolean CheckProsperityUnemployementRate_Filter() {
		log.info("CheckProsperityUnemployementRate_Filter starts here ................");
		// JSHelper.clickElement(Education_HighSchoolPopulation_Data_AddYearBtn);
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
		boolean flag = false;
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 6;
		int prev_year = CurrentYear - 1;
		int value = 50;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;

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

		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		StartYear++;
		value = value + 5;

		for (int i = StartYear; i < CurrentYear; i++) {
			waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
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

			// driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).sendKeys(Integer.toString(i));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			value = value + 5;
		}
		log.info("Total Row display is ---  " + rows.size());

		log.info("Total Row display is ---  " + rows.size());
		int beforeFilter = rows.size();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);

		YearFilterButton.click();
		YearStartDateTextBox.sendKeys(Integer.toString(filterStartYear));
		YearEndDateTextBox.sendKeys(Integer.toString(filterEndYear));
		waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		YearUpdateBtn.click();
		int j = 1;
		log.info("FilterEndYears is --" + filterEndYear + "    Filter start year is  " + filterStartYear);
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

		log.info(" Value of J is --" + j);
		boolean boundaryflag = false;
		try {
			boundaryflag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
					.isDisplayed();
			log.info("boundaryflag value is ---" + boundaryflag);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception Block boundaryflag value is ---" + boundaryflag);
		}
		log.info("CheckProsperityUnemployementRate_Filter ends here ................");
		if (flag == true && boundaryflag == false)
			return true;
		else
			return false;
	}

	// Quality Of Life--> Health & Safety: Air quality days unhealthy for sensitive
	// groups (Days/yr) --> This method will add records and check whether filter is
	// working or not

	public boolean CheckHealthAndSafetySensitiveGroup_Filter() {
		log.info("CheckHealthAndSafetySensitiveGroup_Filter starts here ................");
		// JSHelper.clickElement(Education_HighSchoolPopulation_Data_AddYearBtn);

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
		boolean flag = false;
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 6;
		int prev_year = CurrentYear - 1;
		int value = 250;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;

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

		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		StartYear++;
		value = value + 5;

		for (int i = StartYear; i < CurrentYear; i++) {
			waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
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

			// driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).sendKeys(Integer.toString(i));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			value = value + 5;
		}
		log.info("Total Row display is ---  " + rows.size());

		log.info("Total Row display is ---  " + rows.size());
		int beforeFilter = rows.size();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);

		YearFilterButton.click();
		YearStartDateTextBox.sendKeys(Integer.toString(filterStartYear));
		YearEndDateTextBox.sendKeys(Integer.toString(filterEndYear));
		waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		YearUpdateBtn.click();
		int j = 1;
		log.info("FilterEndYears is --" + filterEndYear + "    Filter start year is  " + filterStartYear);
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

		log.info(" Value of J is --" + j);
		boolean boundaryflag = false;
		try {
			boundaryflag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
					.isDisplayed();
			log.info("boundaryflag value is ---" + boundaryflag);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception Block boundaryflag value is ---" + boundaryflag);
		}
		log.info("CheckHealthAndSafetySensitiveGroup_Filter ends here ................");
		if (flag == true && boundaryflag == false)
			return true;
		else
			return false;
	}

	// Quality Of Life--> Health & Safety: Violent Crime (per year per capita) -->
	// This method will add records and check whether filter is working or not

	public boolean CheckHealthAndSafetyVoilentCrime_Filter() {
		log.info("CheckHealthAndSafetyVoilentCrime_Filter starts here ................");
		// JSHelper.clickElement(Education_HighSchoolPopulation_Data_AddYearBtn);
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
		boolean flag = false;
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 6;
		int prev_year = CurrentYear - 1;
		int value = 250;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;

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

		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		StartYear++;
		value = value + 5;

		for (int i = StartYear; i < CurrentYear; i++) {
			waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
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

			// driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).sendKeys(Integer.toString(i));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			value = value + 5;
		}
		log.info("Total Row display is ---  " + rows.size());

		log.info("Total Row display is ---  " + rows.size());
		int beforeFilter = rows.size();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);

		YearFilterButton.click();
		YearStartDateTextBox.sendKeys(Integer.toString(filterStartYear));
		YearEndDateTextBox.sendKeys(Integer.toString(filterEndYear));
		waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		YearUpdateBtn.click();
		int j = 1;
		log.info("FilterEndYears is --" + filterEndYear + "    Filter start year is  " + filterStartYear);
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

		log.info(" Value of J is --" + j);
		boolean boundaryflag = false;
		try {
			boundaryflag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
					.isDisplayed();
			log.info("boundaryflag value is ---" + boundaryflag);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception Block boundaryflag value is ---" + boundaryflag);
		}
		log.info("CheckHealthAndSafetyVoilentCrime_Filter ends here ................");
		if (flag == true && boundaryflag == false)
			return true;
		else
			return false;
	}
	// Waste -- > Waste Generation --> This method will add records and check
	// whether filter is working or not

	public boolean CheckWaste_GenerationFilter() {
		log.info("CheckWaste_GenerationFilter starts here ................");
		// Waste_AddYearButton.click();
		waithelper.WaitForElementClickable(Waste_AddYearButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(Waste_AddYearButton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean flag = false;
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 6;
		int prev_year = CurrentYear - 1;
		int tons = 100;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;

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
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody)[3]/tr[1]/td[3]/div/span/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
		StartYear++;
		tons = tons + 10;

		for (int i = StartYear; i < CurrentYear; i++) {
			waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
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
					.sendKeys(Integer.toString(tons));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"(//table[@class='meterListByType--wrapper']/tbody)[3]/tr[1]/td[3]/div/span/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (Exception e) {
				e.printStackTrace();
				log.info(e.getMessage());
			}
			tons = tons + 2;
		}
		log.info("Total Row display is ---  " + rows.size());

		log.info("Total Row display is ---  " + rows.size());
		int beforeFilter = rows.size();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		YearFilterButton.click();

		YearStartDateTextBox.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String Startxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterStartYear + "']";
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

		// YearStartDateTextBox.sendKeys(Integer.toString(filterStartYear));
		// YearEndDateTextBox.sendKeys(Integer.toString(filterEndYear));
		waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		YearUpdateBtn.click();

		int j = 1;
		log.info("FilterEndYears is --" + filterEndYear + "    Filter start year is  " + filterStartYear);
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

		log.info(" Value of J is --" + j);
		boolean boundaryflag = false;
		try {
			boundaryflag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
					.isDisplayed();
			log.info("boundaryflag value is ---" + boundaryflag);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception Block boundaryflag value is ---" + boundaryflag);
		}
		log.info("CheckWaste_GenerationFilter ends here ................");
		if (flag == true && boundaryflag == false)
			return true;
		else
			return false;
	}

	// Waste -- > Waste Generation --> This method will add records and check
	// whether filter is working or not

	public boolean CheckWaste_DiversionFilter() {
		log.info("CheckWaste_DiversionFilter starts here ................");
		// Waste_AddYearButton.click();
		JSHelper.clickElement(Waste_AddYearButton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean flag = false;
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 6;
		int prev_year = CurrentYear - 1;
		int percent = 10;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;

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

		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("(//table[@class='meterListByType--wrapper']/tbody)[3]/tr[1]/td[3]/div/span/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		StartYear++;
		percent = percent + 3;

		for (int i = StartYear; i < CurrentYear; i++) {

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
					.sendKeys(Integer.toString(percent));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody)[3]/tr[1]/td[3]/div/span/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			percent = percent + 2;
		}
		log.info("Total Row display is ---  " + rows.size());

		log.info("Total Row display is ---  " + rows.size());
		int beforeFilter = rows.size();

		waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		YearFilterButton.click();

		waithelper.WaitForElementClickable(YearStartDateTextBox, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		YearStartDateTextBox.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String Startxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterStartYear + "']";
		try {
			driver.findElement(By.xpath(Startxpath)).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/thead/tr/th[1]")).click();
			driver.findElement(By.xpath(Startxpath)).click();
		} catch (Exception e) {
			e.printStackTrace();

		}

		waithelper.WaitForElementClickable(YearEndDateTextBox, Integer.parseInt(prop.getProperty("explicitTime")), 2);
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

		// YearStartDateTextBox.sendKeys(Integer.toString(filterStartYear));
		// YearEndDateTextBox.sendKeys(Integer.toString(filterEndYear));
		waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		YearUpdateBtn.click();

		int j = 1;
		log.info("FilterEndYears is --" + filterEndYear + "    Filter start year is  " + filterStartYear);
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

		log.info(" Value of J is --" + j);
		boolean boundaryflag = false;
		try {
			boundaryflag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
					.isDisplayed();
			log.info("boundaryflag value is ---" + boundaryflag);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception Block boundaryflag value is ---" + boundaryflag);
		}
		log.info("CheckWaste_GenerationFilter ends here ................");
		if (flag == true && boundaryflag == false)
			return true;
		else
			return false;
	}

	// Water Consumption -- > This method will add records and check whether filter
	// is working or not

	public boolean CheckWaterFilter() {
		log.info("CheckWaterFilter starts here ................");
		WaterConsum_Data_AddYearBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean flag = false;
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int CurrentYear = CommonMethod.getCurrentYear();
		int StartYear = CurrentYear - 6;
		int prev_year = CurrentYear - 1;
		int value = 100;
		int filterStartYear = StartYear + 2;
		int filterEndYear = StartYear + 4;

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

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("(//table[@class='meterListByType--wrapper']/tbody)[2]/tr[1]/td[3]/div/span/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		StartYear++;
		value = value + 10;

		for (int i = StartYear; i < CurrentYear; i++) {

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
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/button")).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody)[2]/tr[1]/td[3]/div/span/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			value = value + 2;
		}
		log.info("Total Row display is ---  " + rows.size());

		log.info("Total Row display is ---  " + rows.size());
		int beforeFilter = rows.size();

		waithelper.WaitForElementClickable(YearFilterButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		YearFilterButton.click();

		YearStartDateTextBox.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		String Startxpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span[text()='" + filterStartYear + "']";
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

		// YearStartDateTextBox.sendKeys(Integer.toString(filterStartYear));
		// YearEndDateTextBox.sendKeys(Integer.toString(filterEndYear));
		waithelper.WaitForElementClickable(YearUpdateBtn, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		YearUpdateBtn.click();
		int j = 1;
		log.info("FilterEndYears is --" + filterEndYear + "    Filter start year is  " + filterStartYear);
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

		log.info(" Value of J is --" + j);
		boolean boundaryflag = false;
		try {
			boundaryflag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" + j + "]/td[1]/input"))
					.isDisplayed();
			log.info("boundaryflag value is ---" + boundaryflag);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception Block boundaryflag value is ---" + boundaryflag);
		}
		log.info("CheckWaterFilter ends here ................");
		if (flag == true && boundaryflag == false)
			return true;
		else
			return false;
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
		boolean flag = false;
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
		boolean flag = false;
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
		boolean flag = false;
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

	// This method will check on clicking Add Year button, new row should be listed
	// with previous year (Data Input - > Quality of Life -- > Education: Population
	// with (at least) Bachelor's degree (%)--> Data/Details Tab

	public boolean CheckEducation_Bachelor_Population_AddYear_NewRow_Display() {
		log.info("CheckEducation_Bachelor_Population_AddYear_NewRow_Display  starts here........");
		boolean flag = false;
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
	// This method will check on clicking Add Year button, new row should be listed
	// with previous year (Data Input - > Quality of Life -- > Equitability: Gini
	// coefficient (for income distribution)--> Data/Details Tab

	public boolean CheckEquitability_Gini_Coefficient_AddYear_NewRow_Display() {
		log.info("CheckEquitability_Gini_Coefficient_AddYear_NewRow_Display  starts here........");
		boolean flag = false;
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
	// This method will check on clicking Add Year button, new row should be listed
	// with previous year (Data Input - > Quality of Life -- > Education: Population
	// with (at least) High School degree (%)--> Data/Details Tab

	public boolean CheckEducation_HighSchoolPopulation_AddYear_NewRow_Display() {
		log.info("CheckEducation_HighSchoolPopulation_AddYear_NewRow_Display  starts here........");
		boolean flag = false;
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

	// This method will check on clicking Add Year button, new row should be listed
	// with previous year (Data Input - > Quality of Life -- > Prosperity: Median
	// household income (US Dollars/Year)--> Data/Details Tab

	public boolean CheckProsperityMedianIncome_AddYear_NewRow_Display() {
		log.info("CheckProsperityMedianIncome_AddYear_NewRow_Display  starts here........");
		boolean flag = false;
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
		boolean flag = false;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(Equitability_MedianGrossIncome_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
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

	// This method will check on clicking Add Year button, new row should be listed
	// with previous year (Data Input - > Quality of Life -- > Prosperity:
	// Unemployment rate (%)--> Data/Details Tab

	public boolean CheckProsperityUnemployementRate_AddYear_NewRow_Display() {
		log.info("CheckProsperityUnemployementRate_AddYear_NewRow_Display  starts here........");
		boolean flag = false;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(ProsperityUnemployementRate_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
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
	// This method will check on clicking Add Year button, new row should be listed
	// with previous year (Data Input - > Quality of Life -- > Health & Safety:
	// Violent Crime (per year per capita)--> Data/Details Tab

	public boolean CheckHealthAndSafetyVoilentCrime_AddYear_NewRow_Display() {
		log.info("CheckHealthAndSafetyVoilentCrime_AddYear_NewRow_Display  starts here........");
		boolean flag = false;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(HealthAndSafetyVoilentCrime_Data_AddYearBtn,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
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

	// This method will check on clicking Add Year button, new row should be listed
	// with previous year (Data Input - > Quality of Life -- > Health & Safety: Air
	// quality days unhealthy for sensitive groups (Days/yr)--> Data/Details Tab

	public boolean CheckHealthAndSafetySensitiveGroup_AddYear_NewRow_Display() {
		log.info("CheckHealthAndSafetySensitiveGroup_AddYear_NewRow_Display  starts here........");
		boolean flag = false;
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
		boolean flag = false;
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
		boolean flag = false;
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
		boolean flag = false;
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

	// This method will add one row with previous year in Data Input - > GHG
	// Emission - > Data Tab

	public boolean CheckGHGEmission_SaveNewRecord() {
		log.info("CheckGHGEmission_SaveNewRecord  starts here........");
		List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int Prev_TableRowCount = TableRow.size();
		log.info("Before adding number of row showing is ---" + TableRow.size());
		boolean flag = false;
		GHGEmission_Data_AddYearBtn.click();
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		log.info("Selected Year is ---" + Selected_Year);
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("Communities", 4, 2));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			flag = driver.findElement(By.xpath("//div[@id='scoreTip']")).isDisplayed();
		}
		log.info("CheckGHGEmission_SaveNewRecord  ends here........");
		return flag;

	}

	// This method will add one row with previous year in Data Input - >
	// Transportation - > Data Tab

	public boolean CheckTransportation_SaveNewRecord() {
		log.info("CheckTransportation_SaveNewRecord  starts here........");
		List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int Prev_TableRowCount = TableRow.size();
		log.info("Before adding number of row showing is ---" + TableRow.size());
		boolean flag = false;
		VMT_Data_AddYearBtn.click();
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		log.info("Selected Year is ---" + Selected_Year);
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("Communities", 14, 2));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody/tr[1])[4]/td[3]/div/span/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			flag = driver
					.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
					.isDisplayed();
		}
		log.info("CheckTransportation_SaveNewRecord  ends here........");
		return flag;

	}

	// This method will add one row with previous year in Data Input - > Quality Of
	// Life - > Health And Safety) --> Data Tab

	public boolean CheckHealthAndSafety_SaveNewRecord() {
		log.info("CheckHealthAndSafety_SaveNewRecord  starts here........");
		List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int Prev_TableRowCount = TableRow.size();
		log.info("Before adding number of row showing is ---" + TableRow.size());
		boolean flag = false;
		// HealthAndSafety_Data_AddYearBtn.click();

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
		log.info("Selected Year is ---" + Selected_Year);
		log.info(data.getCellData("Communities", 26, 2));
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("Communities", 16, 2));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody/tr[1])[5]/td[3]/div/span/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			flag = driver
					.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
					.isDisplayed();
		}
		log.info("CheckHealthAndSafety_SaveNewRecord  ends here........");
		return flag;

	}

	// This method will add one row with previous year in Data Input - > Quality Of
	// Life - > Education: Population with (at least) Bachelor's degree (%) --> Data
	// Tab

	public boolean CheckEductaion_Bachelor_Population_SaveNewRecord() {
		log.info("CheckEductaion_Bachelor_Population_SaveNewRecord  starts here........");
		List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int Prev_TableRowCount = TableRow.size();
		log.info("Before adding number of row showing is ---" + TableRow.size());
		boolean flag = false;

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
		log.info("Selected Year is ---" + Selected_Year);
		log.info(data.getCellData("Communities", 18, 2));
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("Communities", 28, 2));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody/tr[1])[5]/td[3]/div/span/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			flag = driver
					.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
					.isDisplayed();
		}
		log.info("CheckEductaion_Bachelor_Population_SaveNewRecord  ends here........");
		return flag;

	}

	// This method will add one row with previous year in Data Input - > Quality Of
	// Life - > Equitability: Gini coefficient (for income distribution) --> Data
	// Tab

	public boolean CheckEquitability_Gini_Coefficient_SaveNewRecord() {
		log.info("CheckEquitability_Gini_Coefficient_SaveNewRecord  starts here........");
		List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int Prev_TableRowCount = TableRow.size();
		log.info("Before adding number of row showing is ---" + TableRow.size());
		boolean flag = false;
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
		log.info("Selected Year is ---" + Selected_Year);
		log.info(data.getCellData("Communities", 20, 2));
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("Communities", 20, 2));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody/tr[1])[5]/td[3]/div/span/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			flag = driver
					.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
					.isDisplayed();
		}
		log.info("CheckEquitability_Gini_Coefficient_SaveNewRecord  ends here........");
		return flag;

	}

	// This method will add one row with previous year in Data Input - > Quality Of
	// Life - > Education: Population with (at least) High School degree (%) -->
	// Data Tab

	public boolean CheckEducation_HighSchoolPopulation_SaveNewRecord() {
		log.info("CheckEducation_HighSchoolPopulation_SaveNewRecord  starts here........");
		List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int Prev_TableRowCount = TableRow.size();
		log.info("Before adding number of row showing is ---" + TableRow.size());
		boolean flag = false;
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
		log.info("Selected Year is ---" + Selected_Year);
		log.info(data.getCellData("Communities", 22, 2));
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("Communities", 22, 2));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody/tr[1])[5]/td[3]/div/span/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			flag = driver
					.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
					.isDisplayed();
		}
		log.info("CheckEducation_HighSchoolPopulation_SaveNewRecord  ends here........");
		return flag;

	}
	// This method will add one row with previous year in Data Input - > Quality Of
	// Life - > Prosperity: Median household income (US Dollars/Year) --> Data Tab

	public boolean CheckProsperityMedianIncome_SaveNewRecord() {
		log.info("CheckProsperityMedianIncome_SaveNewRecord  starts here........");
		List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int Prev_TableRowCount = TableRow.size();
		log.info("Before adding number of row showing is ---" + TableRow.size());
		boolean flag = false;
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
		log.info("Selected Year is ---" + Selected_Year);
		log.info(data.getCellData("Communities", 24, 2));
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("Communities", 24, 2));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody/tr[1])[5]/td[3]/div/span/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			flag = driver
					.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
					.isDisplayed();
		}
		log.info("CheckProsperityMedianIncome_SaveNewRecord  ends here........");
		return flag;

	}

	// This method will add one row with previous year in Data Input - > Quality Of
	// Life - > Equitability: Median gross rent as (%) of household income --> Data
	// Tab

	public boolean CheckEquitability_MedianGrossIncome_SaveNewRecord() {
		log.info("CheckEquitability_MedianGrossIncome_SaveNewRecord  starts here........");
		List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int Prev_TableRowCount = TableRow.size();
		log.info("Before adding number of row showing is ---" + TableRow.size());
		boolean flag = false;
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
		log.info("Selected Year is ---" + Selected_Year);
		log.info(data.getCellData("Communities", 26, 2));
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("Communities", 26, 2));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody/tr[1])[5]/td[3]/div/span/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			flag = driver
					.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
					.isDisplayed();
		}
		log.info("CheckEquitability_MedianGrossIncome_SaveNewRecord  ends here........");
		return flag;

	}

	// This method will add one row with previous year in Data Input - > Quality Of
	// Life - > Prosperity: Unemployment rate (%) --> Data Tab

	public boolean CheckProsperityUnemployementRate_SaveNewRecord() {
		log.info("CheckProsperityUnemployementRate_SaveNewRecord  starts here........");
		List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int Prev_TableRowCount = TableRow.size();
		log.info("Before adding number of row showing is ---" + TableRow.size());
		boolean flag = false;
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
		log.info("Selected Year is ---" + Selected_Year);
		log.info(data.getCellData("Communities", 28, 2));
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("Communities", 28, 2));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody/tr[1])[5]/td[3]/div/span/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			flag = driver
					.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
					.isDisplayed();
		}
		log.info("CheckProsperityUnemployementRate_SaveNewRecord  ends here........");
		return flag;

	}

	// This method will add one row with previous year in Data Input - > Quality Of
	// Life - > Health & Safety: Air quality days unhealthy for sensitive groups
	// (Days/yr) --> Data Tab

	public boolean CheckHealthAndSafetySensitiveGroup_SaveNewRecord() {
		log.info("CheckHealthAndSafetySensitiveGroup_SaveNewRecord  starts here........");
		List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int Prev_TableRowCount = TableRow.size();
		log.info("Before adding number of row showing is ---" + TableRow.size());
		boolean flag = false;
		// JSHelper.clickElement(ProsperityMedianIncome_Data_AddYearBtn);

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
		log.info("Selected Year is ---" + Selected_Year);
		log.info(data.getCellData("Communities", 30, 2));
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("Communities", 30, 2));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody/tr[1])[5]/td[3]/div/span/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			flag = driver
					.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
					.isDisplayed();
		}
		log.info("CheckHealthAndSafetySensitiveGroup_SaveNewRecord  ends here........");
		return flag;

	}

	// This method will add one row with previous year in Data Input - > Quality Of
	// Life - > Health & Safety: Violent Crime (per year per capita) --> Data Tab

	public boolean CheckHealthAndSafetyVoilentCrime_SaveNewRecord() {
		log.info("CheckHealthAndSafetySensitiveGroup_SaveNewRecord  starts here........");
		List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int Prev_TableRowCount = TableRow.size();
		log.info("Before adding number of row showing is ---" + TableRow.size());
		boolean flag = false;
		// JSHelper.clickElement(ProsperityMedianIncome_Data_AddYearBtn);

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
		log.info("Selected Year is ---" + Selected_Year);
		log.info(data.getCellData("Communities", 32, 2));
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("Communities", 32, 2));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody/tr[1])[5]/td[3]/div/span/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			flag = driver
					.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
					.isDisplayed();
		}
		log.info("CheckHealthAndSafetyVoilentCrime_SaveNewRecord  ends here........");
		return flag;

	}
	// This method will Edit Record in Data Input - > Transportation - > Data Tab

	public boolean CheckTransportation_EditRecord() {
		log.info("CheckTransportation_EditRecord  starts here........");
		boolean flag = false;
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
		log.info(Miles_Days_CapitaNew);
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(Miles_Days_CapitaNew));
		VMT_Data_Save_EditBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("//table[@class='meterListByType--wrapper']/tbody[4]/tr[1]/td[3]/div/span[1]/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		flag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
				.isDisplayed();
		log.info("CheckTransportation_EditRecord  ends here........");
		return flag;

	}

	// This method will Edit Record in Data Input - > Quality Of Life--> Health And
	// Safety - > Data Tab

	public boolean CheckHealthAndSafety_EditRecord() {
		log.info("CheckHealthAndSafety_EditRecord  starts here........");
		boolean flag = false;
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
		log.info(value);
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));
		HealthAndSafety_Data_Save_EditBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		flag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
				.isDisplayed();
		log.info("CheckHealthAndSafety_EditRecord  ends here........");
		return flag;

	}

	// This method will Edit Record in Data Input - > Quality Of Life--> Education:
	// Population with (at least) Bachelor's degree (%) - > Data Tab

	public boolean CheckEducation_Bachelor_population_EditRecord() {
		log.info("CheckEducation_Bachelor_population_EditRecord  starts here........");
		boolean flag = false;
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
		log.info(value);
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));
		Education_BachelorPopulation_Data_Save_EditBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		flag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
				.isDisplayed();
		log.info("CheckEducation_Bachelor_population_EditRecord  ends here........");
		return flag;

	}

	// This method will Edit Record in Data Input - > Quality Of Life-->
	// Equitability: Gini coefficient (for income distribution) - > Data Tab

	public boolean CheckEquitability_Gini_Coefficient_EditRecord() {
		log.info("CheckEquitability_Gini_Coefficient_EditRecord  starts here........");
		boolean flag = false;
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
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		flag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
				.isDisplayed();
		log.info("CheckEquitability_Gini_Coefficient_EditRecord  ends here........");
		return flag;

	}

	// This method will Edit Record in Data Input - > Quality Of Life--> Education:
	// Population with (at least) High School degree (%) - > Data Tab

	public boolean CheckEducation_HighSchoolPopulation_EditRecord() {
		log.info("CheckEducation_HighSchoolPopulation_EditRecord  starts here........");
		boolean flag = false;
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
		log.info(value);
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));
		Education_HighSchoolPopulation_Data_Save_EditBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		flag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
				.isDisplayed();
		log.info("CheckEducation_HighSchoolPopulation_EditRecord  ends here........");
		return flag;

	}
	// This method will Edit Record in Data Input - > Quality Of Life--> Prosperity:
	// Median household income (US Dollars/Year) - > Data Tab

	public boolean CheckProsperityMedianIncome_EditRecord() {
		log.info("CheckProsperityMedianIncome_EditRecord  starts here........");
		boolean flag = false;
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
		log.info(value);
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));
		ProsperityMedianIncome_Data_Save_EditBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		flag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
				.isDisplayed();
		log.info("CheckProsperityMedianIncome_EditRecord  ends here........");
		return flag;

	}
	// This method will Edit Record in Data Input - > Quality Of Life-->
	// Equitability: Median gross rent as (%) of household income - > Data Tab

	public boolean CheckEquitability_MedianGrossIncome_EditRecord() {
		log.info("CheckEquitability_MedianGrossIncome_EditRecord  starts here........");
		boolean flag = false;
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
		log.info(value);
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));
		ProsperityMedianIncome_Data_Save_EditBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		flag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
				.isDisplayed();
		log.info("CheckEquitability_MedianGrossIncome_EditRecord  ends here........");
		return flag;

	}

	// This method will Edit Record in Data Input - > Quality Of Life--> Prosperity:
	// Unemployment rate (%) - > Data Tab

	public boolean CheckProsperityUnemployementRate_EditRecord() {
		log.info("CheckProsperityUnemployementRate_EditRecord  starts here........");
		boolean flag = false;
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
		log.info(value);
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));
		ProsperityMedianIncome_Data_Save_EditBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		flag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
				.isDisplayed();
		log.info("CheckProsperityUnemployementRate_EditRecord  ends here........");
		return flag;

	}

	// This method will Edit Record in Data Input - > Quality Of Life--> Health &
	// Safety: Air quality days unhealthy for sensitive groups (Days/yr) - > Data
	// Tab

	public boolean CheckHealthAndSafetySensitiveGroup_EditRecord() {
		log.info("CheckHealthAndSafetySensitiveGroup_EditRecord  starts here........");
		boolean flag = false;
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
		log.info(value);
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));
		HealthAndSafetySensitiveGroup_Data_Save_EditBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		flag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
				.isDisplayed();
		log.info("CheckHealthAndSafetySensitiveGroup_EditRecord  ends here........");
		return flag;

	}

	// This method will Edit Record in Data Input - > Quality Of Life--> Health &
	// Safety: Violent Crime (per year per capita) - > Data Tab

	public boolean CheckHealthAndSafetyVoilentCrime_EditRecord() {
		log.info("CheckHealthAndSafetyVoilentCrime_EditRecord  starts here........");
		boolean flag = false;
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
		log.info(value);
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));
		HealthAndSafetyVoilentCrime_Data_Save_EditBtn.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		flag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
				.isDisplayed();
		log.info("CheckHealthAndSafetyVoilentCrime_EditRecord  ends here........");
		return flag;

	}

	// This method will Edit Row in Data Input - > GHG Emission - > Data Tab

	public boolean CheckGHGEmission_EditRow() {
		log.info("CheckGHGEmission_EditRow  starts here........");
		boolean flag = false;
		GHGEmission_Data_Save_EditBtn.click();
		log.info(data.getCellData("Communities", 4, 2));
		log.info(Integer.parseInt(data.getCellData("Communities", 4, 2)) + 5);
		log.info(Integer.toString(Integer.parseInt(data.getCellData("Communities", 4, 2)) + 5));
		String Tons_Year_Capita = Integer.toString(Integer.parseInt(data.getCellData("Communities", 4, 2)) + 5);
		log.info(Tons_Year_Capita);
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).sendKeys(Tons_Year_Capita);
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
		// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
		// Integer.parseInt(prop.getProperty("explicitTime")), 2);
		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("(//table[@class='meterListByType--wrapper']/tbody/tr[1])[1]/td[3]/div/span/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		flag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
				.isDisplayed();
		log.info("CheckGHGEmission_EditRow  ends here........");
		return flag;

	}

	// This method will Edit Row in Data Input - > Waste - > Municipal solid waste
	// generation intensity

	public boolean CheckWasteGeneration_EditRow() {
		log.info("CheckWasteGeneration_EditRow  starts here........");
		boolean flag = false;
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
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));

		FirstRow_Waste_Gen_Data_Save_EditBtn.click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		waithelper.WaitForElementInvisible(
				driver.findElement(By
						.xpath("(//table[@class='meterListByType--wrapper']/tbody)[3]/tr[1]/td[3]/div/span[1]/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),Integer.parseInt(prop.getProperty("explicitTime")),
		// 2);
		flag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).isEnabled();
		log.info("Enabled flag is ---" + flag);
		log.info("CheckWasteGeneration_EditRow  ends here........");
		return flag;

	}

	// This method will Edit Row in Data Input - > Waste - > Municipal solid waste
	// diversion rate from landfill

	public boolean CheckWasteDiversion_EditRow() {
		log.info("CheckWasteDiversion_EditRow  starts here........");
		boolean flag = false;

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
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
				.sendKeys(Integer.toString(value));

		FirstRow_Waste_Div_Data_Save_EditBtn.click();

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		waithelper.WaitForElementInvisible(
				driver.findElement(By
						.xpath("(//table[@class='meterListByType--wrapper']/tbody)[3]/tr[1]/td[3]/div/span[1]/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),Integer.parseInt(prop.getProperty("explicitTime")),
		// 2);
		flag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).isEnabled();
		log.info("Enabled flag is ---" + flag);
		log.info("CheckWasteDiversion_EditRow  ends here........");
		return flag;

	}

//This method will Edit Row in Data Input - > Water Consumption - > Data Tab 

	public boolean CheckWaterConsum_EditRow() {
		log.info("CheckWaterConsum_EditRow  starts here........");
		boolean flag = false;

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
		waithelper.WaitForElementInvisible(
				driver.findElement(
						By.xpath("(//table[@class='meterListByType--wrapper']/tbody)[2]/tr[1]/td[3]/div/span/span/*")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		flag = driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/button/span[text()='Edit']"))
				.isDisplayed();
		log.info("CheckWaterConsum_EditRow  ends here........");
		return flag;

	}

	// This method will Delete Row in Data Input - > GHG Emission - > Data Tab

	public boolean CheckGHGEmission_DeleteRow() {
		log.info("CheckGHGEmission_DeleteRow  starts here........");
		boolean flag = false;
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")).click();

		waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		flag = driver.findElement(By.xpath("//div[@id='scoreTip']")).isDisplayed();
		log.info("CheckGHGEmission_DeleteRow  ends here........");
		return flag;

	}

//This method will Delete Row in Data Input - > Waste - > Municipal solid waste generation intensity 

	public boolean CheckWasteGeneration_DeleteRow() {
		log.info("CheckWasteGeneration_DeleteRow  starts here........");
		boolean flag = false;
		int RowCountBefore = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr")).size();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")).click();
		log.info("Total Row showing is --" + RowCountBefore);
		if (RowCountBefore > 1) {
			try {
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

				waithelper.WaitForElementInvisible(driver.findElement(By
						.xpath("(//table[@class='meterListByType--wrapper']/tbody)[3]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

			} catch (StaleElementReferenceException e) {
				log.info("Stale Element Reference exception occurred");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else {

			try {
				waithelper.waitForElementToBeStale(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")));
				waithelper.WaitForElementInvisible(driver.findElement(By
						.xpath("(//table[@class='meterListByType--wrapper']/tbody)[3]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (StaleElementReferenceException e) {
				log.info("Stale Element Reference exception occurred");
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		int RowCountAfter = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr")).size();

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
		waithelper.WaitForElementVisibleWithPollingTime(PreviousYearbutton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		int RowCountBefore = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr")).size();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")).click();

		log.info("Total Row showing is --" + RowCountBefore);
		if (RowCountBefore > 1) {
			try {
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

				waithelper.WaitForElementInvisible(driver.findElement(By
						.xpath("(//table[@class='meterListByType--wrapper']/tbody)[3]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

			} catch (StaleElementReferenceException e) {
				log.info("Stale Element Reference exception occurred");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else {

			try {
				waithelper.waitForElementToBeStale(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")));
				waithelper.WaitForElementInvisible(driver.findElement(By
						.xpath("(//table[@class='meterListByType--wrapper']/tbody)[3]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (StaleElementReferenceException e) {
				log.info("Stale Element Reference exception occurred");
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		int RowCountAfter = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr")).size();

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
		waithelper.WaitForElementVisibleWithPollingTime(PreviousYearbutton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		int RowCountBefore = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr")).size();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")).click();

		log.info("Total Row showing is --" + RowCountBefore);
		if (RowCountBefore > 1) {
			try {
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[4]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

			} catch (StaleElementReferenceException e) {
				log.info("Stale Element Reference exception occurred");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else {

			try {
				waithelper.waitForElementToBeStale(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")));
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[4]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (StaleElementReferenceException e) {
				log.info("Stale Element Reference exception occurred");
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		int RowCountAfter = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr")).size();

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
		int RowCountBefore = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr")).size();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")).click();

		log.info("Total Row showing is --" + RowCountBefore);
		if (RowCountBefore > 1) {
			try {
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

			} catch (StaleElementReferenceException e) {
				log.info("Stale Element Reference exception occurred");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else {

			try {
				waithelper.waitForElementToBeStale(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")));
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (StaleElementReferenceException e) {
				log.info("Stale Element Reference exception occurred");
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		int RowCountAfter = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr")).size();

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
		int RowCountBefore = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr")).size();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")).click();

		log.info("Total Row showing is --" + RowCountBefore);
		if (RowCountBefore > 1) {
			try {
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

			} catch (StaleElementReferenceException e) {
				log.info("Stale Element Reference exception occurred");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else {

			try {
				waithelper.waitForElementToBeStale(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")));
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (StaleElementReferenceException e) {
				log.info("Stale Element Reference exception occurred");
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		int RowCountAfter = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr")).size();

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
		int RowCountBefore = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr")).size();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")).click();

		log.info("Total Row showing is --" + RowCountBefore);
		if (RowCountBefore > 1) {
			try {
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

			} catch (StaleElementReferenceException e) {
				log.info("Stale Element Reference exception occurred");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else {

			try {
				waithelper.waitForElementToBeStale(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")));
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (StaleElementReferenceException e) {
				log.info("Stale Element Reference exception occurred");
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		int RowCountAfter = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr")).size();

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
		int RowCountBefore = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr")).size();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")).click();

		log.info("Total Row showing is --" + RowCountBefore);
		if (RowCountBefore > 1) {
			try {
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

			} catch (StaleElementReferenceException e) {
				log.info("Stale Element Reference exception occurred");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else {

			try {
				waithelper.waitForElementToBeStale(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")));
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (StaleElementReferenceException e) {
				log.info("Stale Element Reference exception occurred");
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		int RowCountAfter = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr")).size();

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
		int RowCountBefore = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr")).size();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")).click();

		log.info("Total Row showing is --" + RowCountBefore);
		if (RowCountBefore > 1) {
			try {
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

			} catch (StaleElementReferenceException e) {
				log.info("Stale Element Reference exception occurred");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else {

			try {
				waithelper.waitForElementToBeStale(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")));
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (StaleElementReferenceException e) {
				log.info("Stale Element Reference exception occurred");
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		int RowCountAfter = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr")).size();

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
		int RowCountBefore = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr")).size();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")).click();

		log.info("Total Row showing is --" + RowCountBefore);
		if (RowCountBefore > 1) {
			try {
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

			} catch (StaleElementReferenceException e) {
				log.info("Stale Element Reference exception occurred");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else {

			try {
				waithelper.waitForElementToBeStale(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")));
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (StaleElementReferenceException e) {
				log.info("Stale Element Reference exception occurred");
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		int RowCountAfter = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr")).size();

		log.info("Row count after deleting is ---" + RowCountAfter);
		if (RowCountBefore - RowCountAfter == 1)
			flag = true;
		log.info("Equitability_MedianGrossIncome_DeleteRow  ends here........");
		return flag;

	}

	// This method will Delete Row in Data Input - > Quality Of Life--> Prosperity:
	// Unemployment rate (%)

	public boolean ProsperityUnemployementRate_DeleteRow() {
		log.info("ProsperityUnemployementRate_DeleteRow  starts here........");
		boolean flag = false;
		waithelper.WaitForElementVisibleWithPollingTime(PreviousYearbutton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		int RowCountBefore = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr")).size();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")).click();

		log.info("Total Row showing is --" + RowCountBefore);
		if (RowCountBefore > 1) {
			try {
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

			} catch (StaleElementReferenceException e) {
				log.info("Stale Element Reference exception occurred");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else {

			try {
				waithelper.waitForElementToBeStale(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")));
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (StaleElementReferenceException e) {
				log.info("Stale Element Reference exception occurred");
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		int RowCountAfter = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr")).size();

		log.info("Row count after deleting is ---" + RowCountAfter);
		if (RowCountBefore - RowCountAfter == 1)
			flag = true;
		log.info("ProsperityUnemployementRate_DeleteRow  ends here........");
		return flag;

	}

	// This method will Delete Row in Data Input - > Quality Of Life--> Health &
	// Safety: Air quality days unhealthy for sensitive groups (Days/yr)

	public boolean HealthAndSafetySensitiveGroup_DeleteRow() {
		log.info("HealthAndSafetySensitiveGroup_DeleteRow  starts here........");
		boolean flag = false;
		waithelper.WaitForElementVisibleWithPollingTime(PreviousYearbutton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		int RowCountBefore = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr")).size();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")).click();

		log.info("Total Row showing is --" + RowCountBefore);
		if (RowCountBefore > 1) {
			try {
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

			} catch (StaleElementReferenceException e) {
				log.info("Stale Element Reference exception occurred");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else {

			try {
				waithelper.waitForElementToBeStale(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")));
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (StaleElementReferenceException e) {
				log.info("Stale Element Reference exception occurred");
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		int RowCountAfter = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr")).size();

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
		int RowCountBefore = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr")).size();
		driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")).click();

		log.info("Total Row showing is --" + RowCountBefore);
		if (RowCountBefore > 1) {
			try {
				waithelper.WaitForElementVisibleWithPollingTime(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);

			} catch (StaleElementReferenceException e) {
				log.info("Stale Element Reference exception occurred");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else {

			try {
				waithelper.waitForElementToBeStale(
						driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
						Integer.parseInt(prop.getProperty("explicitTime")));
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (StaleElementReferenceException e) {
				log.info("Stale Element Reference exception occurred");
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		int RowCountAfter = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr")).size();

		log.info("Row count after deleting is ---" + RowCountAfter);
		if (RowCountBefore - RowCountAfter == 1)
			flag = true;
		log.info("HealthAndSafetyVoilentCrime_DeleteRow  ends here........");
		return flag;

	}

//This method will Delete Row in Data Input - > Water Consumption - > Data Tab 

	public boolean CheckWaterConsum_DeleteRow() {
		log.info("CheckWaterConsum_DeleteRow  starts here........");
		boolean flag = false;
		int RowCountBefore = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr")).size();
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

		int RowCountAfter = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr")).size();

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

		PreviousYearbutton.click();
		boolean prev_flag = false;
		boolean Next_flag = false;
		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() - selected_year == 2) {
			String Tons_Year_Capita = Integer.toString(Integer.parseInt(data.getCellData("Communities", 4, 2)) + 10);
			log.info("Tons_Year_Capita value is ---" + Tons_Year_Capita);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input"))
					.sendKeys(Tons_Year_Capita);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button")).click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(
							By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button/span[text()='Edit']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			prev_flag = true;
		}

		NextYearbutton.click();
		selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() == selected_year) {
			String Tons_Year_Capita = Integer.toString(Integer.parseInt(data.getCellData("Communities", 4, 2)) + 20);
			log.info("Tons_Year_Capita value is ---" + Tons_Year_Capita);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Tons_Year_Capita);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(
							By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			Next_flag = true;
		}

		if (prev_flag && Next_flag) {
			List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			int TableRowCount = TableRow.size();
			log.info("Total rows showing is ----" + TableRowCount);
			if (TableRowCount == 3) {
				log.info("CheckGHGEmission_SavePreviousAndNextYearRecord  ends here........");
				return true;
			} else {
				log.info("CheckGHGEmission_SavePreviousAndNextYearRecord  ends here........");
				return false;
			}
		}
		{
			log.info("Previous Year and Next Year row are not added successfully");
			log.info("CheckGHGEmission_SavePreviousAndNextYearRecord  ends here........");
		}
		return false;

	}

//This method will add one row with previous year and One row with Next Year in Data Input - > GHG Emission - > Data Tab 

	public boolean CheckWaste_Generation_SavePreviousAndNextYearRecord() {
		log.info("CheckWaste_Generation_SavePreviousAndNextYearRecord  starts here........");
		int WasteTons;
		PreviousYearbutton.click();
		boolean prev_flag = false;
		boolean Next_flag = false;
		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() - selected_year == 2) {
			WasteTons = Integer.parseInt(data.getCellData("Communities", 10, 2));
			WasteTons = WasteTons - 5;
			log.info("Previous Year TONs Value is ---" + WasteTons);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input"))
					.sendKeys(Integer.toString(WasteTons));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button")).click();
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button/span[text()='Edit']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody)[3]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			prev_flag = true;
		}

		NextYearbutton.click();
		selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() == selected_year) {
			WasteTons = Integer.parseInt(data.getCellData("Communities", 10, 2));
			WasteTons = WasteTons + 5;
			log.info("Next Year TONs Value is ---" + WasteTons);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(WasteTons));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody)[3]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			Next_flag = true;
		}

		if (prev_flag && Next_flag) {
			List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			int TableRowCount = TableRow.size();
			log.info("Total rows showing is ----" + TableRowCount);
			if (TableRowCount == 3) {
				log.info("CheckWaste_Generation_SavePreviousAndNextYearRecord  ends here........");
				return true;
			} else {
				log.info("CheckWaste_Generation_SavePreviousAndNextYearRecord  ends here........");
				return false;
			}
		}
		{
			log.info("Previous Year and Next Year row are not added successfully");
			log.info("CheckWaste_Generation_SavePreviousAndNextYearRecord  ends here........");
		}
		return false;

	}

	// This method will add one row with previous year and One row with Next Year in
	// Data Input - > GHG Emission - > Data Tab

	public boolean CheckWaste_Diversion_SavePreviousAndNextYearRecord() {
		log.info("CheckWaste_Generation_SavePreviousAndNextYearRecord  starts here........");
		int WastePercent;
		PreviousYearbutton.click();
		boolean prev_flag = false;
		boolean Next_flag = false;
		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() - selected_year == 2) {
			WastePercent = Integer.parseInt(data.getCellData("Communities", 12, 2));
			WastePercent = WastePercent - 5;
			log.info("Previous Year TONs Value is ---" + WastePercent);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input"))
					.sendKeys(Integer.toString(WastePercent));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button")).click();
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button/span[text()='Edit']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody)[3]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			prev_flag = true;
		}

		NextYearbutton.click();
		selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() == selected_year) {
			WastePercent = Integer.parseInt(data.getCellData("Communities", 12, 2));
			WastePercent = WastePercent + 5;
			log.info("Next Year TONs Value is ---" + WastePercent);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(WastePercent));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody)[3]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			Next_flag = true;
		}

		if (prev_flag && Next_flag) {
			List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			int TableRowCount = TableRow.size();
			log.info("Total rows showing is ----" + TableRowCount);
			if (TableRowCount == 3) {
				log.info("CheckWaste_Generation_SavePreviousAndNextYearRecord  ends here........");
				return true;
			} else {
				log.info("CheckWaste_Generation_SavePreviousAndNextYearRecord  ends here........");
				return false;
			}
		}
		{
			log.info("Previous Year and Next Year row are not added successfully");
			log.info("CheckWaste_Generation_SavePreviousAndNextYearRecord  ends here........");
		}
		return false;

	}

	// This method will add one row with previous year and One row with Next Year in
	// Data Input - > Transportation - > Data Tab

	public boolean Transportation_VMT_SavePreviousAndNextYearRecord() {
		log.info("Transportation_VMT_SavePreviousAndNextYearRecord  starts here........");
		int TransportMiles;
		PreviousYearbutton.click();
		boolean prev_flag = false;
		boolean Next_flag = false;
		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() - selected_year == 2) {
			TransportMiles = Integer.parseInt(data.getCellData("Communities", 14, 2));
			TransportMiles = TransportMiles - 5;
			log.info("Previous Year TONs Value is ---" + TransportMiles);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input"))
					.sendKeys(Integer.toString(TransportMiles));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button")).click();
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button/span[text()='Edit']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[4]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			prev_flag = true;
		}

		NextYearbutton.click();
		selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() == selected_year) {
			TransportMiles = Integer.parseInt(data.getCellData("Communities", 14, 2));
			TransportMiles = TransportMiles + 5;
			log.info("Next Year TONs Value is ---" + TransportMiles);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(TransportMiles));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[4]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			Next_flag = true;
		}

		if (prev_flag && Next_flag) {
			List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			int TableRowCount = TableRow.size();
			log.info("Total rows showing is ----" + TableRowCount);
			log.info("Total rows showing is ----" + TableRowCount);
			if (TableRowCount == 3) {
				log.info("Previous Year and Next Year row are added successfully");
				log.info("Transportation_VMT_SavePreviousAndNextYearRecord  ends here........");
				return true;
			} else {
				log.info("Transportation_VMT_SavePreviousAndNextYearRecord  ends here........");
				return false;
			}
		}
		{
			log.info("Previous Year and Next Year row are not added successfully");
			log.info("Transportation_VMT_SavePreviousAndNextYearRecord  ends here........");
		}
		return false;

	}

	// This method will add one row with previous year and One row with Next Year in
	// Data Input - >Quality Of Life--> Health And Safety - > Data Tab

	public boolean HealthAndSafety_SavePreviousAndNextYearRecord() {
		log.info("HealthAndSafety_SavePreviousAndNextYearRecord  starts here........");
		int value;
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
		boolean prev_flag = false;
		boolean Next_flag = false;
		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() - selected_year == 2) {
			value = Integer.parseInt(data.getCellData("Communities", 16, 2));
			value = value - 10;
			log.info("Previous Year Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button")).click();
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button/span[text()='Edit']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			prev_flag = true;
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
			value = Integer.parseInt(data.getCellData("Communities", 16, 2));
			value = value + 5;
			log.info("Next Year TONs Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			Next_flag = true;
		}

		if (prev_flag && Next_flag) {
			List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			int TableRowCount = TableRow.size();
			log.info("Total rows showing is ----" + TableRowCount);
			log.info("Total rows showing is ----" + TableRowCount);
			if (TableRowCount == 3) {
				log.info("Previous Year and Next Year row are added successfully");
				log.info("HealthAndSafety_SavePreviousAndNextYearRecord  ends here........");
				return true;
			} else {
				log.info("HealthAndSafety_SavePreviousAndNextYearRecord  ends here........");
				return false;
			}
		}
		{
			log.info("Previous Year and Next Year row are not added successfully");
			log.info("HealthAndSafety_SavePreviousAndNextYearRecord  ends here........");
		}
		return false;

	}

	// This method will add one row with previous year and One row with Next Year in
	// Data Input - >Quality Of Life--> Education: Population with (at least)
	// Bachelor's degree (%) - > Data Tab

	public boolean Education_Bachelor_Population_SavePreviousAndNextYearRecord() {
		log.info("Education_Bachelor_Population_SavePreviousAndNextYearRecord  starts here........");
		int value;

		waithelper.WaitForElementClickable(PreviousYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		PreviousYearbutton.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// PreviousYearbutton.click();
		boolean prev_flag = false;
		boolean Next_flag = false;
		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() - selected_year == 2) {
			value = Integer.parseInt(data.getCellData("Communities", 18, 2));
			value = value - 5;
			log.info("Previous Year Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button")).click();
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button/span[text()='Edit']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			prev_flag = true;
		}

		waithelper.WaitForElementClickable(NextYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		NextYearbutton.click();
		selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() == selected_year) {
			value = Integer.parseInt(data.getCellData("Communities", 18, 2));
			value = value + 5;
			log.info("Next Year TONs Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			Next_flag = true;
		}

		if (prev_flag && Next_flag) {
			List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			int TableRowCount = TableRow.size();
			log.info("Total rows showing is ----" + TableRowCount);
			log.info("Total rows showing is ----" + TableRowCount);
			if (TableRowCount == 3) {
				log.info("Previous Year and Next Year row are added successfully");
				log.info("Education_Bachelor_Population_SavePreviousAndNextYearRecord  ends here........");
				return true;
			} else {
				log.info("Education_Bachelor_Population_SavePreviousAndNextYearRecord  ends here........");
				return false;
			}
		}
		{
			log.info("Previous Year and Next Year row are not added successfully");
			log.info("Education_Bachelor_Population_SavePreviousAndNextYearRecord  ends here........");
		}
		return false;

	}
	// This method will add one row with previous year and One row with Next Year in
	// Data Input - >Quality Of Life--> Equitability: Gini coefficient (for income
	// distribution) - > Data Tab

	public boolean Equitability_Gini_Coefficient_SavePreviousAndNextYearRecord() {
		log.info("Equitability_Gini_Coefficient_SavePreviousAndNextYearRecord  starts here........");
		int value;
		waithelper.WaitForElementClickable(PreviousYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		PreviousYearbutton.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// PreviousYearbutton.click();
		boolean prev_flag = false;
		boolean Next_flag = false;
		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() - selected_year == 2) {
			value = Integer.parseInt(data.getCellData("Communities", 20, 2));
			value = value - 1;
			log.info("Previous Year Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button")).click();
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button/span[text()='Edit']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			prev_flag = true;
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
		// NextYearbutton.click();
		selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() == selected_year) {
			value = Integer.parseInt(data.getCellData("Communities", 20, 2));
			value = value + 0;
			log.info("Next Year TONs Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			Next_flag = true;
		}

		if (prev_flag && Next_flag) {
			List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			int TableRowCount = TableRow.size();
			log.info("Total rows showing is ----" + TableRowCount);
			log.info("Total rows showing is ----" + TableRowCount);
			if (TableRowCount == 3) {
				log.info("Previous Year and Next Year row are added successfully");
				log.info("Equitability_Gini_Coefficient_SavePreviousAndNextYearRecord  ends here........");
				return true;
			} else {
				log.info("Equitability_Gini_Coefficient_SavePreviousAndNextYearRecord  ends here........");
				return false;
			}
		}
		{
			log.info("Previous Year and Next Year row are not added successfully");
			log.info("Equitability_Gini_Coefficient_SavePreviousAndNextYearRecord  ends here........");
		}
		return false;

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
		waithelper.WaitForElementClickable(PreviousYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(PreviousYearbutton);
		// PreviousYearbutton.click();
		boolean prev_flag = false;
		boolean Next_flag = false;
		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() - selected_year == 2) {
			value = Integer.parseInt(data.getCellData("Communities", 22, 2));
			value = value - 5;
			log.info("Previous Year Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button")).click();
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button/span[text()='Edit']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			prev_flag = true;
		}

		try {
			Thread.sleep(1000);
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
			value = Integer.parseInt(data.getCellData("Communities", 22, 2));
			value = value + 5;
			log.info("Next Year TONs Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			Next_flag = true;
		}

		if (prev_flag && Next_flag) {
			List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			int TableRowCount = TableRow.size();
			log.info("Total rows showing is ----" + TableRowCount);
			log.info("Total rows showing is ----" + TableRowCount);
			if (TableRowCount == 3) {
				log.info("Previous Year and Next Year row are added successfully");
				log.info("Education_HighSchoolPopulation_SavePreviousAndNextYearRecord  ends here........");
				return true;
			} else {
				log.info("Education_HighSchoolPopulation_SavePreviousAndNextYearRecord  ends here........");
				return false;
			}
		}
		{
			log.info("Previous Year and Next Year row are not added successfully");
			log.info("Education_HighSchoolPopulation_SavePreviousAndNextYearRecord  ends here........");
		}
		return false;

	}
	// This method will add one row with previous year and One row with Next Year in
	// Data Input - >Quality Of Life--> Education: Population with (at least) High
	// School degree (%) - > Data Tab

	public boolean ProsperityMedianIncome_SavePreviousAndNextYearRecord() {
		log.info("ProsperityMedianIncome_SavePreviousAndNextYearRecord  starts here........");
		int value;
		waithelper.WaitForElementClickable(PreviousYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(PreviousYearbutton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// PreviousYearbutton.click();
		boolean prev_flag = false;
		boolean Next_flag = false;
		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() - selected_year == 2) {
			value = Integer.parseInt(data.getCellData("Communities", 24, 2));
			value = value - 10;
			log.info("Previous Year Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button")).click();
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button/span[text()='Edit']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			prev_flag = true;
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
			value = Integer.parseInt(data.getCellData("Communities", 24, 2));
			value = value + 10;
			log.info("Next Year TONs Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			Next_flag = true;
		}

		if (prev_flag && Next_flag) {
			List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			int TableRowCount = TableRow.size();
			log.info("Total rows showing is ----" + TableRowCount);
			log.info("Total rows showing is ----" + TableRowCount);
			if (TableRowCount == 3) {
				log.info("Previous Year and Next Year row are added successfully");
				log.info("ProsperityMedianIncome_SavePreviousAndNextYearRecord  ends here........");
				return true;
			} else {
				log.info("ProsperityMedianIncome_SavePreviousAndNextYearRecord  ends here........");
				return false;
			}
		}
		{
			log.info("Previous Year and Next Year row are not added successfully");
			log.info("Education_HighSchoolPopulation_SavePreviousAndNextYearRecord  ends here........");
		}
		return false;

	}
	// This method will add one row with previous year and One row with Next Year in
	// Data Input - >Quality Of Life--> Equitability: Median gross rent as (%) of
	// household income - > Data Tab

	public boolean Equitability_MedianGrossIncome_SavePreviousAndNextYearRecord() {
		log.info("Equitability_MedianGrossIncome_SavePreviousAndNextYearRecord  starts here........");
		int value;
		waithelper.WaitForElementClickable(PreviousYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(PreviousYearbutton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// PreviousYearbutton.click();
		boolean prev_flag = false;
		boolean Next_flag = false;
		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() - selected_year == 2) {
			value = Integer.parseInt(data.getCellData("Communities", 26, 2));
			value = value - 10;
			log.info("Previous Year Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button")).click();
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button/span[text()='Edit']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			prev_flag = true;
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
			value = Integer.parseInt(data.getCellData("Communities", 26, 2));
			value = value + 10;
			log.info("Next Year TONs Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			Next_flag = true;
		}

		if (prev_flag && Next_flag) {
			List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			int TableRowCount = TableRow.size();
			log.info("Total rows showing is ----" + TableRowCount);
			log.info("Total rows showing is ----" + TableRowCount);
			if (TableRowCount == 3) {
				log.info("Previous Year and Next Year row are added successfully");
				log.info("Equitability_MedianGrossIncome_SavePreviousAndNextYearRecord  ends here........");
				return true;
			} else {
				log.info("Equitability_MedianGrossIncome_SavePreviousAndNextYearRecord  ends here........");
				return false;
			}
		}
		{
			log.info("Previous Year and Next Year row are not added successfully");
			log.info("Equitability_MedianGrossIncome_SavePreviousAndNextYearRecord  ends here........");
		}
		return false;

	}

	// This method will add one row with previous year and One row with Next Year in
	// Data Input - >Quality Of Life--> Prosperity: Unemployment rate (%) - > Data
	// Tab

	public boolean ProsperityUnemployementRate_SavePreviousAndNextYearRecord() {
		log.info("ProsperityUnemployementRate_SavePreviousAndNextYearRecord  starts here........");
		int value;
		waithelper.WaitForElementClickable(PreviousYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(PreviousYearbutton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// PreviousYearbutton.click();
		boolean prev_flag = false;
		boolean Next_flag = false;
		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() - selected_year == 2) {
			value = Integer.parseInt(data.getCellData("Communities", 28, 2));
			value = value - 10;
			log.info("Previous Year Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button")).click();
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button/span[text()='Edit']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			prev_flag = true;
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
			value = Integer.parseInt(data.getCellData("Communities", 28, 2));
			value = value + 10;
			log.info("Next Year TONs Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			Next_flag = true;
		}

		if (prev_flag && Next_flag) {
			List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			int TableRowCount = TableRow.size();
			log.info("Total rows showing is ----" + TableRowCount);
			log.info("Total rows showing is ----" + TableRowCount);
			if (TableRowCount == 3) {
				log.info("Previous Year and Next Year row are added successfully");
				log.info("ProsperityUnemployementRate_SavePreviousAndNextYearRecord  ends here........");
				return true;
			} else {
				log.info("ProsperityUnemployementRate_SavePreviousAndNextYearRecord  ends here........");
				return false;
			}
		}
		{
			log.info("Previous Year and Next Year row are not added successfully");
			log.info("ProsperityUnemployementRate_SavePreviousAndNextYearRecord  ends here........");
		}
		return false;

	}

	// This method will add one row with previous year and One row with Next Year in
	// Data Input - >Quality Of Life--> Prosperity: Unemployment rate (%) - > Data
	// Tab

	public boolean HealthAndSafetySensitiveGroup_SavePreviousAndNextYearRecord() {
		log.info("HealthAndSafetySensitiveGroup_SavePreviousAndNextYearRecord  starts here........");
		int value;
		waithelper.WaitForElementClickable(PreviousYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(PreviousYearbutton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// PreviousYearbutton.click();
		boolean prev_flag = false;
		boolean Next_flag = false;
		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() - selected_year == 2) {
			value = Integer.parseInt(data.getCellData("Communities", 30, 2));
			value = value - 10;
			log.info("Previous Year Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button")).click();
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button/span[text()='Edit']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			prev_flag = true;
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
			value = Integer.parseInt(data.getCellData("Communities", 30, 2));
			value = value + 10;
			log.info("Next Year TONs Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			Next_flag = true;
		}

		if (prev_flag && Next_flag) {
			List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			int TableRowCount = TableRow.size();
			log.info("Total rows showing is ----" + TableRowCount);
			log.info("Total rows showing is ----" + TableRowCount);
			if (TableRowCount == 3) {
				log.info("Previous Year and Next Year row are added successfully");
				log.info("HealthAndSafetySensitiveGroup_SavePreviousAndNextYearRecord  ends here........");
				return true;
			} else {
				log.info("HealthAndSafetySensitiveGroup_SavePreviousAndNextYearRecord  ends here........");
				return false;
			}
		}
		{
			log.info("Previous Year and Next Year row are not added successfully");
			log.info("HealthAndSafetySensitiveGroup_SavePreviousAndNextYearRecord  ends here........");
		}
		return false;

	}

	// This method will add one row with previous year and One row with Next Year in
	// Data Input - >Quality Of Life-->Health & Safety: Violent Crime (per year per
	// capita) - > Data Tab

	public boolean HealthAndSafetyVoilentCrime_SavePreviousAndNextYearRecord() {
		log.info("HealthAndSafetyVoilentCrime_SavePreviousAndNextYearRecord  starts here........");
		int value;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(PreviousYearbutton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(PreviousYearbutton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// PreviousYearbutton.click();
		boolean prev_flag = false;
		boolean Next_flag = false;
		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() - selected_year == 2) {
			value = Integer.parseInt(data.getCellData("Communities", 32, 2));
			value = value - 10;
			log.info("Previous Year Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button")).click();
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/button/span[text()='Edit']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			prev_flag = true;
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
			value = Integer.parseInt(data.getCellData("Communities", 32, 2));
			value = value + 10;
			log.info("Next Year TONs Value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).clear();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(Integer.toString(value));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"//table[@class='meterListByType--wrapper']/tbody[5]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			Next_flag = true;
		}

		if (prev_flag && Next_flag) {
			List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			int TableRowCount = TableRow.size();
			log.info("Total rows showing is ----" + TableRowCount);
			log.info("Total rows showing is ----" + TableRowCount);
			if (TableRowCount == 3) {
				log.info("Previous Year and Next Year row are added successfully");
				log.info("HealthAndSafetyVoilentCrime_SavePreviousAndNextYearRecord  ends here........");
				return true;
			} else {
				log.info("HealthAndSafetyVoilentCrime_SavePreviousAndNextYearRecord  ends here........");
				return false;
			}
		}
		{
			log.info("Previous Year and Next Year row are not added successfully");
			log.info("HealthAndSafetyVoilentCrime_SavePreviousAndNextYearRecord  ends here........");
		}
		return false;

	}
//This method will add one row with previous year and One row with Next Year in Data Input - > GHG Emission - > Data Tab 

	public boolean CheckWaterConsum_SavePreviousAndNextYearRecord() {
		log.info("CheckWaterConsum_SavePreviousAndNextYearRecord  starts here........");

		PreviousYearbutton.click();
		boolean prev_flag = false;
		boolean Next_flag = false;
		int selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() - selected_year == 2) {
			String value = Integer.toString(Integer.parseInt(data.getCellData("Communities", 6, 2)) + 10);
			log.info("Previous Water value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[2]/input")).sendKeys(value);

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/div/button")).click();

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[3]/div/ul/li/a[text()='"
					+ data.getCellData("Communities", 7, 2) + "']")).click();

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/div/button")).click();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[4]/div/ul/li/a[text()='"
					+ data.getCellData("Communities", 8, 2) + "']")).click();

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[5]/button")).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[6]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody)[2]/tr[1]/td[3]/div/span/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[2]/td[5]/button/span[text()='Edit']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			prev_flag = true;
		}

		NextYearbutton.click();
		selected_year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		if (CommonMethod.getCurrentYear() == selected_year) {
			String value = Integer.toString(Integer.parseInt(data.getCellData("Communities", 6, 2)) + 20);
			log.info("Next Water value is ---" + value);
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).sendKeys(value);

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/button")).click();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/ul/li/a[text()='"
					+ data.getCellData("Communities", 7, 2) + "']")).click();

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/button")).click();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/ul/li/a[text()='"
					+ data.getCellData("Communities", 8, 2) + "']")).click();

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/button")).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody)[2]/tr[1]/td[3]/div/span/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/button/span[text()='Edit']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			Next_flag = true;
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (prev_flag && Next_flag) {
			List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			int TableRowCount = TableRow.size();
			log.info("Total rows showing is ----" + TableRowCount);
			if (TableRowCount == 3) {
				log.info("CheckWaterConsum_SavePreviousAndNextYearRecord  ends here........");
				return true;
			} else {
				log.info("CheckWaterConsum_SavePreviousAndNextYearRecord  ends here........");
				return false;
			}
		}
		{
			log.info("Previous Year and Next Year row are not added successfully");
			log.info("CheckWaterConsum_SavePreviousAndNextYearRecord  ends here........");
		}
		return false;

	}

	// This method will add one row with previous year in Data Input - > Water
	// Consumption - > Data Tab

	public boolean CheckWaterConsumption_SaveNewRecord() {
		log.info("CheckWaterConsumption_SaveNewRecord  starts here........");
		List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int Prev_TableRowCount = TableRow.size();
		log.info("Before adding number of row showing is ---" + TableRow.size());
		boolean flag = false;
		WaterConsum_Data_AddYearBtn.click();
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		log.info("Selected Year is ---" + Selected_Year);
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("Communities", 6, 2));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/button")).click();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/ul/li/a[text()='"
					+ data.getCellData("Communities", 7, 2) + "']")).click();

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/button")).click();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/ul/li/a[text()='"
					+ data.getCellData("Communities", 8, 2) + "']")).click();

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/button")).click();

			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			flag = driver.findElement(By.xpath("//div[@id='scoreTip']")).isDisplayed();
		}
		log.info("CheckWaterConsumption_SaveNewRecord  ends here........");
		return flag;

	}

//This method will add one row with previous year in Data Input - > Waste - > Waste Generation -> Data Tab 

	public boolean CheckWaste_Generation_SaveNewRecord() {
		log.info("CheckWaste_Generation_SaveNewRecord  starts here........");
		List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int Prev_TableRowCount = TableRow.size();
		log.info("Before adding number of row showing is ---" + TableRow.size());
		boolean flag = false;
		Waste_AddYearButton.click();
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		log.info("Selected Year is ---" + Selected_Year);
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("Communities", 10, 2));

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody)[3]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//span[text()='All
			// changes saved']")),Integer.parseInt(prop.getProperty("explicitTime")), 2);

			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			flag = driver
					.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
					.isDisplayed();
		}
		log.info("CheckWaste_Generation_SaveNewRecord  ends here........");
		return flag;

	}

	// This method will add one row with previous year in Data Input - > Waste - >
	// Waste Diversion -> Data Tab

	public boolean CheckWaste_Diversion_SaveNewRecord() {
		log.info("CheckWaste_Diversion_SaveNewRecord  starts here........");
		List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		int Prev_TableRowCount = TableRow.size();
		log.info("Before adding number of row showing is ---" + TableRow.size());
		boolean flag = false;
		Waste_AddYearButton.click();
		int Selected_Year = Integer.parseInt(driver
				.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
		log.info("Selected Year is ---" + Selected_Year);
		if (CommonMethod.getCurrentYear() - Selected_Year == 1) {
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("Communities", 12, 2));

			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody)[3]/tr[1]/td[3]/div/span[1]/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//span[text()='All
			// changes saved']")),Integer.parseInt(prop.getProperty("explicitTime")), 2);

			try {
				waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			flag = driver
					.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button/span[text()='Edit']"))
					.isDisplayed();
		}
		log.info("CheckWaste_Diversion_SaveNewRecord  ends here........");
		return flag;

	}

//This method will add one row with Gallans Unit Type and one row with Litres Unit Type Data Input - > Water Consumption - > Data Tab 

	public boolean CheckWaterConsumption_AddRow_UnitTypes() {
		log.info("CheckWaterConsumption_AddRow_UnitTypes  starts here........");
		boolean flag = false;
		ArrayList<String> units = new ArrayList<String>();
		units.add("Gallons");
		units.add("Litres");
		Iterator itr = units.iterator();
		while (itr.hasNext()) {
			String unit = (String) itr.next();
			log.info("Unit Type--" + unit + "   is going to add.....");
			log.info("Unit Type--" + unit + "   is going to add.....");
			driver.findElement(By.xpath("//span[text()='Next Year']/parent::button")).click();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("Communities", 6, 2));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/button")).click();
			driver.findElement(
					By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/ul/li/a[text()='" + unit + "']"))
					.click();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/button")).click();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/ul/li/a[text()='"
					+ data.getCellData("Communities", 8, 2) + "']")).click();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/button")).click();

			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			try {
				waithelper.WaitForElementInvisible(
						driver.findElement(By.xpath(
								"(//table[@class='meterListByType--wrapper']/tbody)[2]/tr[1]/td[3]/div/span/span/*")),
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
			} catch (StaleElementReferenceException e1) {
				log.info("Stale element Reference exception occurred");
				e1.printStackTrace();
			}

			catch (Exception e1) {

				e1.printStackTrace();
			}
			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/button/span[text()='Edit']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			flag = driver
					.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/button/span[text()='Edit']"))
					.isDisplayed();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (flag) {
				log.info("Record added with Unit Type --" + unit);
			} else {
				log.info("Record is not added with Unit Type --" + unit);
				break;
			}
		}
		List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		log.info("Total number of row showing is ---" + TableRow.size());
		log.info("CheckWaterConsumption_AddRow_UnitTypes  ends here........");
		return flag;

	}

//This method will add one row each duration type dropdwon values. Data Input - > Water Consumption - > Data Tab 

	public boolean CheckWaterConsumption_AddRow_DurationTypes() {
		log.info("CheckWaterConsumption_AddRow_DurationTypes  starts here........");
		boolean flag = false;
		ArrayList<String> Durations = new ArrayList<String>();
		Durations.add("Per Year");
		Durations.add("Per Month");
		Durations.add("Per Week");
		Durations.add("Per Day");
		Iterator itr = Durations.iterator();
		while (itr.hasNext()) {
			String Duration = (String) itr.next();
			log.info("Unit Type--" + Duration + "   is going to add.....");
			driver.findElement(By.xpath("//span[text()='Next Year']/parent::button")).click();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input"))
					.sendKeys(data.getCellData("Communities", 6, 2));
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/button")).click();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/div/ul/li/a[text()='"
					+ data.getCellData("Communities", 7, 2) + "']")).click();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/button")).click();
			driver.findElement(
					By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/div/ul/li/a[text()='" + Duration + "']"))
					.click();
			driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/button")).click();
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[6]/span")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath(
							"(//table[@class='meterListByType--wrapper']/tbody)[2]/tr[1]/td[3]/div/span/span/*")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			// waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/button/span[text()='Edit']")),Integer.parseInt(prop.getProperty("explicitTime")),
			// 2);
			flag = driver
					.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[5]/button/span[text()='Edit']"))
					.isDisplayed();
			try {
				Thread.sleep(4000);
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
		List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		log.info("Total number of row showing is ---" + TableRow.size());
		log.info("CheckWaterConsumption_AddRow_DurationTypes  ends here........");
		return flag;

	}
}