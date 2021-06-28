package com.arc.PageObject.Project;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.JavaScriptHelper;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class CityPageObject extends BaseClass {

	private static Logger log = LoggerHelper.getLogger(CityPageObject.class);

	
	
	@FindBy(xpath = "(//*[text()='Manage' and @class='ml10'])[1]")
	WebElement ManageMenu;

	@FindBy(xpath = "(//*[text()='Data Input'])[1]")
	WebElement DataInputSubMenu;

	@FindBy(xpath = "//table[@class='building-settings']/tbody/tr/td[2]/div")
	WebElement ProjectSettingButton;
	
	@FindBy(xpath = "(//table[@class='meterListByType--wrapper']/tbody/tr[2])[1]/td[2]/div")
	WebElement GHGEmission;
	
	@FindBy(xpath = "(//table[@class='meterListByType--wrapper']/tbody/tr[1])[1]/td[3]/div/span/span")
	WebElement EnergyScore;

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

	@FindBy(xpath = "//table[@id='readingsTable']/tbody/tr[1]/td[6]/span")
	WebElement Population_DeleteButton;
	
	
	
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
	
	@FindBy(xpath = "//span[text()='Add Year']/parent::button")
	WebElement GHGEmission_Data_AddYearBtn;
	
	@FindBy(xpath = "//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")
	WebElement GHGEmission_Data_Save_EditBtn;

	@FindBy(xpath = "//table[@class='table arcTbl cityTable']/tbody/tr[1]/td[2]/input")
	WebElement AddYearbutton;

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

	@FindBy(name = "test_project")
	WebElement ThisIsTestProjectCheckBox;

	@FindBy(xpath = "(//table[@class='table-condensed'])[2]/thead/tr/th[2]")
	WebElement DecadeCalenderHeader;

	public CityPageObject() {
		PageFactory.initElements(driver, this);
	}

	public void ClickonAgreementInManage() {
		try {
			ManageMenu.click();
			AgreementSubmenu.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ClickonBillingInManage() {
		try {
			ManageMenu.click();
			BillingSubmenu.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ClickonDataInput() {
		try {
			waithelper.WaitForElementVisibleWithPollingTime(PerformanceHeaderText,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			DataInputSubMenu.click();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void ClickonProjectSetting() {
		try {

			driver.switchTo().frame("datainput-widget");
			waithelper.WaitForElementVisibleWithPollingTime(ProjectSettingButton,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			ProjectSettingButton.click();
			waithelper.WaitForElementVisibleWithPollingTime(PopulationTab,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// This method will click on Energy --> GHG Emissions
	public void ClickonGHGEmiissions() {
		try {

			driver.switchTo().frame("datainput-widget");
			waithelper.WaitForElementVisibleWithPollingTime(GHGEmission,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			GHGEmission.click();
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("(//*[contains(text(),'GHG Emissions')])[4]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to traverse Team Submenu");
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
	
	public int getEnergyScore() {

		log.info("getEnergyScore method starts here........");
		//driver.switchTo().frame("datainput-widget");
		int score=Integer.parseInt(EnergyScore.getText());
		System.out.println("Energy Score is -----"+score);
		log.info("getEnergyScore method ends here........");
		return score;
		

	}

	public boolean checkUnitTypeInProjectAreaUnderDataInput(String UnitType) {

		boolean flag = false;
		try {
			ProjectAreaTab.click();
			String UnitSelected = driver
					.findElement(By.xpath("//*[@class='meter_info_heading']/parent::div/button/span")).getText();

			if (UnitSelected.contains(UnitType))
				flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}

	public boolean checkPopulation_AddRow_Header_Display() {

		boolean flag = false;
		try {
			PopulationTab.click();
			Thread.sleep(2000);
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
	
	// This method will add one row in DI - > Project Setting - > Project Area and checks the Header
	public boolean checkProjectArea_AddRow_Header_Display() {
		log.info("checkProjectArea_AddRow_Header_Display  starts here........");
		boolean flag = false;
		try {
			ProjectAreaTab.click();
			Thread.sleep(2000);
			ProjectSettingAddRowButton.click();

			if (ProjectAreaEffectiveYearHeading.getText().equals("EFFECTIVE YEAR")
					&& ProjectArea_ProjectAreaHeading.getText().contains("PROJECT AREA")
					&& ProjectArea_UpdatedByHeading.getText().equals("UPDATED BY")
					&& ProjectArea_SaveButton.isDisplayed() == true && ProjectArea_DeleteButton.isDisplayed() == true) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
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
		ProjectSettingAddRowButton.click();
		Population_EffectiveYearTextBox.click();
		
		  waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
		  Integer.parseInt(prop.getProperty("explicitTime")), 2);
		 
		  String DecadeCal = DecadeCalenderHeader.getText();
		driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/tbody/tr/td/span[3]")).click();

		
		String[] s1 = DecadeCal.split("-");
		int Start_Year = Integer.parseInt(s1[0]);
		int End_Year = Integer.parseInt(s1[1]);
		if (End_Year - Start_Year == 9) {
			//log.info("Decade Calender for Effective Year is showing proper..........");
			decadeCalenderflag = true;
		} else {
		//	log.info("Decade Calender for Effective Year is not showing proper..........");
			decadeCalenderflag = false;
		}

		Population_populationTextBox.sendKeys(population);
		Population_SaveButton.click();

		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		log.info("checkPopulation_Save_New_Row method ends here .........");
		return decadeCalenderflag;
		

	}
	
	
	public boolean checkUpdatedByUserName(String Username)
	{
		log.info("checkUpdatedByUserName method starts here............");
		driver.switchTo().frame("datainput-widget");
		boolean flag=false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		System.out.println("Total Rows displaying is --"+rows);
		for(int i=0;i<rows.size();i++)
		{
			int rownum=i+1;
			String CurrentUpdatedBy=driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[" +rownum+ "]/td[3]/div")).getText();
			System.out.println(CurrentUpdatedBy+" ----------------- "+Username);
			if(CurrentUpdatedBy.contains(Username))
			{
				
				flag=true;
				break;
			}
			
		}
		
		if(flag)
		{
			log.info("Found Updated By --- "+Username);
		}
		else
		{
			log.info("Not found Updated By --- "+Username);
		}
		log.info("checkUpdatedByUserName method ends here............");
		return flag;
	}
	
	// This method will add new row and save the record
	// It also checks whether decade Calender is opening or not
	
	public boolean checkProjectArea_Save_New_Row(String PArea) {
		log.info("checkProjectArea_Save_New_Row method starts here .........");
		boolean decadeCalenderflag = false;
		
		JSHelper.clickElement(ProjectAreaTab);
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
		ProjectSettingAddRowButton.click();
		ProjectArea_EffectiveYearTextBox.click();
		
		  waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]")),
		  Integer.parseInt(prop.getProperty("explicitTime")), 2);
		 
		  String DecadeCal = DecadeCalenderHeader.getText();
		driver.findElement(By.xpath("(//table[@class='table-condensed'])[2]/tbody/tr/td/span[3]")).click();

		
		String[] s1 = DecadeCal.split("-");
		int Start_Year = Integer.parseInt(s1[0]);
		int End_Year = Integer.parseInt(s1[1]);
		if (End_Year - Start_Year == 9) {
			//log.info("Decade Calender for Effective Year is showing proper..........");
			decadeCalenderflag = true;
		} else {
		//	log.info("Decade Calender for Effective Year is not showing proper..........");
			decadeCalenderflag = false;
		}

		ProjectAreaTextBox.sendKeys(PArea);
		ProjectArea_SaveButton.click();
		//JSHelper.clickElement(ProjectArea_SaveButton);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		log.info("checkProjectArea_Save_New_Row method ends here .........");
		return decadeCalenderflag;
		

	}
	
	// This method will check whether newly added row in Population is saved successfully or not
	
	public boolean verifyAddedProject_Setting_PopulationRow()
	{
		log.info("verifyAddedProject_Setting_Row starts here ................" );
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean AddedRowFlag = false;
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
		System.out.println("Total Row display is ---  "+rows.size());
		if (rows.size() > 0) {
			log.info("Added Row showing proper----");
			AddedRowFlag = true;
		} else {
			log.info("Added Row is not showing proper----");
			AddedRowFlag = false;
		}
		if  (AddedRowFlag) {
			log.info("verifyAddedProject_Setting_Row method ends here .........");
			return true;
		} else {
			log.info("verifyAddedProject_Setting_Row method ends here .........");
			return false;
		}
	}
	
	
	// This method will check whether newly added row in Population is saved successfully or not
	
		public boolean verifyAddedProject_Setting_ProjectAreaRow()
		{
			log.info("verifyAddedProject_Setting_ProjectAreaRow starts here ................" );
			
			JSHelper.clickElement(ProjectAreaTab);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			boolean AddedRowFlag = false;
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
			System.out.println("Total Row display is ---  "+rows.size());
			if (rows.size() > 1) {
				log.info("Added Row showing proper----");
				AddedRowFlag = true;
			} else {
				log.info("Added Row is not showing proper----");
				AddedRowFlag = false;
			}
			if  (AddedRowFlag) {
				log.info("verifyAddedProject_Setting_ProjectAreaRow method ends here .........");
				return true;
			} else {
				log.info("verifyAddedProject_Setting_ProjectAreaRow method ends here .........");
				return false;
			}
		}
		
		
	
	
	// This method will check whether population field contains comma or not
	
	public boolean verifyPopulationField_Contains_Comma()
	{
		log.info("verifyPopulationField_Contains_Comma starts here ................" );		
		PopulationTab.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String PopulationValue=Population_populationTextBox.getAttribute("value");
		System.out.println("Population Value is --"+PopulationValue);
		if(PopulationValue.contains(","))
		{
			log.info("verifyPopulationField_Contains_Comma method ends here .........");
			return true;
		
		} else {
			log.info("verifyPopulationField_Contains_Comma method ends here .........");
			return false;
		}
	}
	
	public boolean verifyProjectAreaField_Contains_Comma()
	{
		log.info("verifyProjectAreaField_Contains_Comma starts here ................" );
		waithelper.WaitForElementClickable(ProjectAreaTab,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		JSHelper.clickElement(ProjectAreaTab);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String ProjectAreaValue=ProjectAreaTextBox.getAttribute("value");
		System.out.println("Project Area Value is --"+ProjectAreaValue);
		if(ProjectAreaValue.contains(","))
		{
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

			System.out.println("PerformanceHeaderText.getText() value is ---- " + PerformanceHeaderText.isDisplayed());
			return PerformanceHeaderText.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	// This method will check whether Data and Details Tab is displaying or not (Data Input - > GHG Emission - > Data/Details Tab 
	
		public boolean CheckGHGEmission_Data_DetailsTab_Display() {
			log.info("CheckGHGEmission_Data_DetailsTab_Display  starts here........");
			boolean DataTabflag = false;
			boolean DetailsTabflag = false;
			DataTabflag=GHGEmission_DataTab.isDisplayed();
			log.info("Data Tab display status is --"+DataTabflag);
			DetailsTabflag=GHGEmission_DetailsTab.isDisplayed();
			log.info("Details Tab display status is --"+DetailsTabflag);
			
			if(DataTabflag && DetailsTabflag)
			{
				log.info("CheckGHGEmission_Data_DetailsTab_Display  ends here........");
				return true;
			}
			else
			{
				log.info("CheckGHGEmission_Data_DetailsTab_Display  ends here........");
				return false;
			}
			

		}

		// This method will check on clicking Add Year button, new row should be listed with previous year  (Data Input - > GHG Emission - > Data/Details Tab 
		
			public boolean CheckGHGEmission_AddYear_NewRow_Display() {
				log.info("CheckGHGEmission_Data_DetailsTab_Display  starts here........");
				boolean flag = false;
				GHGEmission_Data_AddYearBtn.click();
				int CurrentYear=CommonMethod.getCurrentYear();
				int YearValue=Integer.parseInt(driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[1]/input")).getAttribute("value"));
				int PreviousYear=CurrentYear-1;
				if(YearValue== PreviousYear)
				{
					log.info("CheckGHGEmission_AddYear_NewRow_Display  ends here........");
					return true;
				}
				else
				{
					log.info("CheckGHGEmission_AddYear_NewRow_Display  ends here........");
					return false;
				}
				

			}

		
			// This method will add one row with previous year in Data Input - > GHG Emission - > Data Tab 
			
				public boolean CheckGHGEmission_SaveNewRecord() {
					log.info("CheckGHGEmission_SaveNewRecord  starts here........");
					List<WebElement> TableRow = driver.findElements(By.xpath("//table[@id='readingsTable']/tbody/tr"));
					int Prev_TableRowCount=TableRow.size();
					log.info("Before adding number of row showing is ---"+TableRow.size());
					boolean flag = false;
					GHGEmission_Data_AddYearBtn.click();
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).sendKeys(data.getCellData("City", 10, 2));
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
					waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),Integer.parseInt(prop.getProperty("explicitTime")), 2);
					flag=driver.findElement(By.xpath("//div[@id='scoreTip']")).isDisplayed();
					log.info("CheckGHGEmission_SaveNewRecord  ends here........");
					return flag;
					
				}
				
				// This method will Edit Row in Data Input - > GHG Emission - > Data Tab 
				
				public boolean CheckGHGEmission_EditRow() {
					log.info("CheckGHGEmission_EditRow  starts here........");
					boolean flag = false;
					GHGEmission_Data_Save_EditBtn.click();
					System.out.println(data.getCellData("City", 10, 2));
					System.out.println(Integer.parseInt(data.getCellData("City", 10, 2))+5);
					System.out.println(Integer.toString(Integer.parseInt(data.getCellData("City", 10, 2))+5));
					String Tons_Year_Capita=Integer.toString(Integer.parseInt(data.getCellData("City", 10, 2))+5);
					System.out.println(Tons_Year_Capita);
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[2]/input")).sendKeys(Tons_Year_Capita);
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[3]/button")).click();
					waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),Integer.parseInt(prop.getProperty("explicitTime")), 2);
					flag=driver.findElement(By.xpath("//div[@id='scoreTip']")).isDisplayed();
					log.info("CheckGHGEmission_EditRow  ends here........");
					return flag;
					
				}

				
				// This method will Delete Row in Data Input - > GHG Emission - > Data Tab 
				
				public boolean CheckGHGEmission_DeleteRow() {
					log.info("CheckGHGEmission_DeleteRow  starts here........");
					boolean flag = false;
					driver.findElement(By.xpath("//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")).click();					
					
					
					
					waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//div[@id='scoreTip']")),Integer.parseInt(prop.getProperty("explicitTime")), 2);
					flag=driver.findElement(By.xpath("//div[@id='scoreTip']")).isDisplayed();
					log.info("CheckGHGEmission_DeleteRow  ends here........");
					return flag;
					
					/*
					 * waithelper.WaitForElementInvisible(driver.findElement(By.xpath(
					 * "//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")),Integer.parseInt(prop
					 * .getProperty("explicitTime")), 2);
					 * 
					 * 
					 * flag=driver.findElement(By.xpath(
					 * "//table[@id='readingsTable']/tbody/tr[1]/td[4]/span")).isDisplayed();
					 */
					
					/*
					 * if(!flag) return true; else return false;
					 */
					
				}
				
	

}
