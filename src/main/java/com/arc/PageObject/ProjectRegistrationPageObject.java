package com.arc.PageObject;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.arc.PageObject.Project.BuildingPageObject;
import com.arc.PageObject.Project.CityPageObject;
import com.arc.PageObject.Project.CommunitiesPageObject;
import com.arc.PageObject.Project.ParkingPageObject;
import com.arc.PageObject.Project.TransitPageObject;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;
import com.arc.commonMethods.CommonMethod;

public class ProjectRegistrationPageObject extends BaseClass {

	private static Logger log = LoggerHelper.getLogger(ProjectRegistrationPageObject.class);

	@FindBy(xpath = "//label[text()='Space Type']/parent::div/select")
	WebElement BuildingSpaceType;

	@FindBy(xpath = "//label[text()='Owner Type']/parent::div/select")
	WebElement BuildingOwnerType;

	@FindBy(xpath = "//label[text()='Owner Country/Region']/parent::div/select")
	WebElement BuildingCountryName;

	@FindBy(xpath = "//label[text()='Owner Email']/parent::div/input")
	WebElement BuildingOwnerEmail;

	@FindBy(xpath = "//input[@id='organization']")
	WebElement BuildingOwnerOrg;

	@FindBy(xpath = "//label[text()='Owner Email']//following-sibling::span")
	WebElement BuildingEmailValidation;

	@FindBy(xpath = "//span[@class='head fs16 lh30']/following-sibling::div[2]")
	WebElement RegisterLEED_ValidationMSG;

	@FindBy(xpath = "//table/tbody/tr[@class='hide900']/descendant::p")
	WebElement AddProject_ValidationMSG;

	@FindBy(xpath = "//div[@class='align-center mt11 width-100-perc']/h4")
	WebElement AddAProjectLabelHeader;

	@FindBy(xpath = "(//*[text()='Enter Project Details']//parent::div/div//div/input)[1]")
	WebElement ProjectNameTextBox;

	@FindBy(xpath = "//*[@class='error ng-binding' and starts-with(text(),'Please enter a valid name. Allowed special characters are')]")
	WebElement ProjectNamevalidationMsg;

	@FindBy(xpath = "//*[@class='error ng-binding' and starts-with(text(),'Please enter valid number of parking space.')]")
	WebElement ParkingSpaceValidationMsg;

	@FindBy(xpath = "//*[@id=\"details-form\"]/div[1]/table/tbody/tr[5]/td/div/span[3]")
	WebElement ParkingLevelValidationMsg;

	@FindBy(xpath = "//div[@class='checkbox test_project pl20 ng-scope']/input")
	WebElement ThisIsTestProjectCheckBox;

	@FindBy(xpath = "//label[text()='This project is private.']//preceding-sibling::input")
	WebElement ProjectIsPrivateCheckBox;

	@FindBy(xpath = "(//table[1]/tbody/tr[3]/td[1]/div[1]/select)[1]")
	WebElement ProjectType;

	@FindBy(xpath = "//input[@id='gross_area']")
	WebElement GrossAreaTextBox;

	@FindBy(xpath = "//span[normalize-space()='Exceeded maximum value']")
	WebElement GrossAreaTextBoxValidationMsg;

	@FindBy(xpath = "//input[@id='year_constructed']")
	WebElement DateCommisioned;

	@FindBy(xpath = "//select[@ng-change=\"verifyField(formdata.unitType, 'unitType')\"]")
	WebElement GrossAreaUnitType;

	@FindBy(xpath = "//*[@class='svg_hover']")
	WebElement CloseProjectbtn;

	@FindBy(xpath = "(//input[@type='radio'])[1]")
	WebElement RegisterLEEDYesRadioBtn;

	@FindBy(xpath = "(//input[@type='radio'])[2]")
	WebElement RegisterLEEDNoRadioBtn;

	@FindBy(xpath = "//button[text()='Register for LEED certification now']")
	WebElement RegisterLEEDCertificationNowPopUpButton;

	@FindBy(xpath = "//table[1]/tbody/tr[7]/td/div/input")
	WebElement PopulationTextBox;

	@FindBy(xpath = "(//span[text()='Enter Project Location']//parent::div/div[2]/table/tbody/tr[1]/td[1]/div/input)[1]")
	WebElement AddressTextBox;

	@FindBy(xpath = "//span[text()='Enter Project Location']//parent::div/div[2]/table/tbody/tr[2]/td[1]/div/input")
	WebElement CityTextBox;

	@FindBy(xpath = "//span[text()='Enter Project Location']//parent::div/div[2]/table/tbody/tr[3]/td[1]/div/select")
	WebElement CountryDropDown;

	@FindBy(xpath = "//span[text()='Enter Project Location']//parent::div/div[2]/table/tbody/tr[3]/td[2]/div/select")
	WebElement StateDropDown;

	@FindBy(xpath = "//span[text()='Enter Project Location']//parent::div/div[2]/table/tbody/tr[4]/td/div/input")
	WebElement ZipTextBox;

	@FindBy(xpath = "//div[@class='geolocation-picker']/div/div[1]/input")
	WebElement LatitudeTextbox;

	@FindBy(xpath = "//div[@class='geolocation-picker']/div/div[2]/input")
	WebElement LongitudeTextbox;

	@FindBy(xpath = "(//span[@class='agreement_tag reg' and text()='service agreement'])[1]")
	WebElement ServiceAgreementLink;

	@FindBy(xpath = "(//*[@class='checkbox pl20']/input)[2]")
	WebElement ServiceAgreementCheckBox;

	@FindBy(xpath = "(//*[text()='Add project'])[1]/parent::div")
	WebElement AddProjectButton;

	@FindBy(xpath = "//button[text()='Not now']")
	WebElement NotNowPopUpButton;

	@FindBy(xpath = "//*[@id=\"details-form\"]/div[1]/table/tbody/tr[4]/td/div/input")
	WebElement ParkingSpacesTextBox;

	@FindBy(xpath = "//input[@ng-init='enableFdatePicker()']")
	WebElement ParkingLevelTextBox;

	@FindBy(xpath = "//*[@id=\"details-form\"]/div[1]/table/tbody/tr[11]/td/div/input")
	WebElement OwnerEmailTextbox;

	@FindBy(xpath = "//*[@id=\"details-form\"]/div[1]/table/tbody/tr[11]/td/div/span[3]")
	WebElement EmailValidationMsg;

	@FindBy(xpath = "//*[@id=\"details-form\"]/div[1]/table/tbody/tr[9]/td/div/select")
	WebElement OwnerTypeTextbox;

	@FindBy(xpath = "//*[@id=\"details-form\"]/div[1]/table/tbody/tr[12]/td/div/select")
	WebElement OwnerRegionTextbox;

	@FindBy(xpath = "//*[@id=\"organization\"]")
	WebElement OrgTextbox;

	@FindBy(xpath = "/html/body/div[24]/div[1]")
	WebElement CalenderPopUp;
	
	@FindBy(xpath = "//label[normalize-space()='This is a test project']")
	WebElement TestProjectCheckBox;
	
	@FindBy(xpath = "//*[@id=\"details-form\"]/div[1]/table/tbody/tr[6]/td/div/input")
	WebElement AnnualRidershipTextbox;
	
	@FindBy(xpath = "//*[@id=\"details-form\"]/div[1]/table/tbody/tr[7]/td/div/input")
	WebElement WeeklyHrsTextbox;
	
	@FindBy(xpath = "//*[@id=\"details-form\"]/div[1]/table/tbody/tr[8]/td/div/input")
	WebElement FulltimeStaffTextbox;
	
	@FindBy(xpath = "//*[@id=\"details-form\"]/div[1]/table/tbody/tr[9]/td/div/input")
	WebElement AvgTimeSpentTextbox;
	
	@FindBy(xpath = "//span[normalize-space()='Please enter valid annual ridership.']")
	WebElement AnnualRiderValidationMsg;
	
	@FindBy(xpath = "//span[normalize-space()='Please enter valid hours.']")
	WebElement AvgTimeSpentValidationMsg;
	
	@FindBy(xpath= "//span[normalize-space()='Please enter valid number of hours']")
	WebElement WeeklyHrsValidationMsg;
	
	@FindBy(xpath = "//span[normalize-space()='Please enter valid full time staff.']")
	WebElement FulltimeStaffValidationMsg;
	
	@FindBy(xpath = "//select[@ng-change=\"verifyField(formdata.station_type, 'station_type')\"]")
	WebElement TransitStationType;
	
	@FindBy(xpath = "//span[normalize-space()='Preview Access']")
	WebElement PreviewAccessButton;
	
	@FindBy(xpath = "//span[normalize-space()='Pay Now']")
	WebElement PayNowButton;
	
	@FindBy(xpath = "//input[@ng-model='formdata.occupancy']")
	WebElement WeightedOccupancyTextbox;
	
	@FindBy(xpath = "//label[normalize-space()='This is a test project']")
	WebElement TestProjectCheckBox;

	public ProjectRegistrationPageObject() {
		PageFactory.initElements(driver, this);
	}

	public boolean checkAddAProjectLabel() {
		boolean flag = false;

		try {
			flag = AddAProjectLabelHeader.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public void clickYesLEEDRegistration() {
		RegisterLEEDYesRadioBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickNoLEEDRegistration() {
		RegisterLEEDNoRadioBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean Validate_LEEDRegistrationPopupMessage() {
		String Para1, Para2, Para3;
		boolean flag = true;
		for (int i = 1; i < 4; i++) {
			if (i == 1) {
				Para1 = driver.findElement(By.xpath("(//div[@class='modal-content p30 modal_radius'])[1]/p[" + i + "]"))
						.getText();
				if (!Para1.equals(
						"If you're interested in registering this project for LEED certification, please select the \"Register for LEED certification now\" button below and you’ll be routed to LEED Online.")) {
					flag = false;
					break;
				}
			}

			else if (i == 2) {
				Para2 = driver.findElement(By.xpath("(//div[@class='modal-content p30 modal_radius'])[1]/p[" + i + "]"))
						.getText();
				if (!Para2.equals(
						"Otherwise, you can get started now with Arc for free. Just select the \"Not now\" button below.")) {
					flag = false;
					break;
				}
			}

			else if (i == 3) {
				Para3 = driver.findElement(By.xpath("(//div[@class='modal-content p30 modal_radius'])[1]/p[" + i + "]"))
						.getText();
				if (!Para3.equals(
						"You can enter your performance data in Arc and choose to register for LEED later. Your performance data will get you most of the way, but you'll need to complete the LEED prerequisites, and possibly other requirements before submitting for certification.")) {
					flag = false;
					break;
				}

			}
		}
		try {
			NotNowPopUpButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public boolean CheckRegisterforLEEDValidationMessage() {
		if (AddProject_ValidationMSG.isDisplayed() && RegisterLEED_ValidationMSG.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean CheckRegisterforLEEDPopupButtonsExists() {
		boolean flag = false;
		try {
			waithelper.waitForElement(RegisterLEEDCertificationNowPopUpButton,
					Integer.parseInt(prop.getProperty("explicitTime")));
			if (RegisterLEEDCertificationNowPopUpButton.isDisplayed() && NotNowPopUpButton.isDisplayed())
				flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			NotNowPopUpButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public void clickOnRegisterLEEDCertificationNowPopUpButton() {
		try {
			RegisterLEEDCertificationNowPopUpButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnNotNowPopUpButton() {
		try {
			NotNowPopUpButton.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String checkCityLEEDOnLinePortal() {
		String handle = driver.getWindowHandle();
		try {
			RegisterLEEDCertificationNowPopUpButton.click();
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Set<String> handles = driver.getWindowHandles();
		if (handles.size() == 2) {
			for (String window : handles) {
				if (!handle.equals(window)) {
					driver.switchTo().window(window);
					try {
						waithelper.waitForElement(
								driver.findElement(
										By.xpath("//ul[@class='breadcrumb' ]/li[2][text()='City Registration']")),
								Integer.parseInt(prop.getProperty("explicitTime")));
						String title = driver.findElement(By.xpath("//ul[@class='breadcrumb' ]/li[2]")).getText();
						log.info(title);
						driver.close();
						driver.switchTo().window(handle);
						return title;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}

		return null;
	}

	public String checkCommunityLEEDOnLinePortal() {
		String handle = driver.getWindowHandle();
		try {
			RegisterLEEDCertificationNowPopUpButton.click();
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Set<String> handles = driver.getWindowHandles();
		if (handles.size() == 2) {
			for (String window : handles) {
				if (!handle.equals(window)) {
					driver.switchTo().window(window);
					try {
						waithelper.waitForElement(
								driver.findElement(
										By.xpath("//ul[@class='breadcrumb' ]/li[2][text()='Community Registration']")),
								Integer.parseInt(prop.getProperty("explicitTime")));
						String title = driver.findElement(By.xpath("//ul[@class='breadcrumb' ]/li[2]")).getText();
						log.info(title);
						driver.close();
						driver.switchTo().window(handle);
						return title;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}

		return null;
	}

	public boolean checkAfterClickOnNotNowPopupButton() {
		String handle = driver.getWindowHandle();
		boolean flag = false;
		Set<String> handles = driver.getWindowHandles();
		if (handles.size() == 1) {
			try {

				waithelper.WaitForElementInvisible(RegisterLEEDCertificationNowPopUpButton,
						Integer.parseInt(prop.getProperty("explicitTime")), 2);
				if (!(RegisterLEEDCertificationNowPopUpButton.isDisplayed() && NotNowPopUpButton.isDisplayed())) {
					if (RegisterLEEDNoRadioBtn.isSelected()) {
						log.info(driver.findElement(By.xpath(
								"//div[text()='This project has to register for LEED Certification later by going to the certifications page in Arc.']"))
								.isDisplayed());
						flag = driver.findElement(By.xpath(
								"//div[text()='This project has to register for LEED Certification later by going to the certifications page in Arc.']"))
								.isDisplayed();
						log.info(
								"This project has to register for LEED Certification later by going to the certifications page in Arc. is displaying");

					} else {
						log.info("No Radio button is not selected");
					}
				} else {
					log.info("Registration for LEED Certification and Not Now button are not showing");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return flag;
	}

	public boolean CheckCityProjectType() {
		boolean flag = false;

		try {
			// log.info(dropdownhelper.getSelectedValue(ProjectType).equals("Cities"));
			if (dropdownhelper.getSelectedValue(ProjectType).equals("Cities"))
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean SelectCommunitiesProjectType() {
		boolean flag = false;

		try {

			if (dropdownhelper.getSelectedValue(ProjectType).equals("Communities"))
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean SelectBuildingProjectType() {
		boolean flag = false;

		try {

			if (dropdownhelper.getSelectedValue(ProjectType).equals("Buildings"))
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean SelectParkingProjectType() {
		boolean flag = false;

		try {

			if (dropdownhelper.getSelectedValue(ProjectType).equals("Buildings - Parking (Parksmart)"))
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public void enterProjectName(String PName) {
		ProjectNameTextBox.clear();
		ProjectNameTextBox.sendKeys(PName);
	}

	public void selectSpaceType(String Stype) {
		dropdownhelper.selectUsingVisibleText(BuildingSpaceType, Stype);
	}

	public void selectOwnerType(String Otype) {
		dropdownhelper.selectUsingVisibleText(BuildingOwnerType, Otype);
	}

	public void selectOwnerOrg(String OwnerOrg) {
		BuildingOwnerOrg.sendKeys(OwnerOrg);
		BuildingOwnerOrg.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//div[@class='searchDropdownOrganization']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//div[@class='searchDropdownOrganization']/div[1]/div/span")).click();

	}

	public int CheckOwnerOrgAutoSuggetion(String OwnerOrg) {
		BuildingOwnerOrg.sendKeys(OwnerOrg);
		BuildingOwnerOrg.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//div[@class='searchDropdownOrganization']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		int totalSuggestions = driver.findElements(By.xpath("//div[@class='searchDropdownOrganization']/div/div/span"))
				.size();
		return totalSuggestions;
	}

	public boolean CheckInvalidEmail() {
		boolean flag = false;
		String mail[] = { "amit.gmail.com", "amit@gmail.c3" };
		for (String s1 : mail) {
			BuildingOwnerEmail.clear();
			BuildingOwnerEmail.sendKeys(s1);
			if (BuildingEmailValidation.getText().equals("Please enter valid email.")) {
				flag = true;
				log.info("Validation message displayed is --- " + BuildingEmailValidation.getText());
			} else {
				flag = false;
				log.info("Validation message not displayed---");
				break;
			}
		}
		return flag;
	}

	public int CheckLocationAutoPopulate(String address) {
		log.info("CheckLocationAutoPopulate method starts here....");
		boolean flag = false;

		AddressTextBox.clear();
		AddressTextBox.sendKeys(address);

		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(
						By.xpath("//ul[@class='dropdown-menu address normal dropdown-menu-fixed address_dropdown']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);

		List<WebElement> list = driver.findElements(
				By.xpath("//ul[@class='dropdown-menu address normal dropdown-menu-fixed address_dropdown']/li"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.info("CheckLocationAutoPopulate method ends here....");
		return list.size();

	}

	public void selectCountry(String CName) {
		dropdownhelper.selectUsingVisibleText(BuildingCountryName, CName);
	}

	public void enterOwnerEmail(String email) {
		BuildingOwnerEmail.sendKeys(email);
	}

	public void enterGrossArea(String Area) {
		GrossAreaTextBox.clear();
		GrossAreaTextBox.sendKeys(Area);

	}

	public void enterPopulation(String pupulation) {
		PopulationTextBox.clear();
		PopulationTextBox.sendKeys(pupulation);

	}

	public boolean CheckProjectNameValidationMsg() {
		boolean flag = false;
		try {
			flag = ProjectNamevalidationMsg.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public boolean CheckGrossAreaValidationMsg() {
		boolean flag = false;
		try {
			flag = GrossAreaTextBoxValidationMsg.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public void closeProjectButton() {
		boolean flag = false;
		try {
			flag = CloseProjectbtn.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag)
			CloseProjectbtn.click();

	}

	public boolean CheckAddress_City_Country_State_ZipCode(String Address) {
		log.info("CheckAddress_City_Country_State_ZipCode starts here..................");
		AddressTextBox.clear();
		AddressTextBox.sendKeys(Address);
		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By
							.xpath("//ul[@class='dropdown-menu address normal dropdown-menu-fixed address_dropdown']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<WebElement> list = driver.findElements(
				By.xpath("//ul[@class='dropdown-menu address normal dropdown-menu-fixed address_dropdown']/li"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < list.size(); i++) {
			log.info(list.get(i).getText());
			if (list.get(i).getText().equals("2101 L St NW - 2101 L St NW, Washington, DC 20037, USA")) {
				list.get(i).click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}

		log.info("Actual Address Value is --" + AddressTextBox.getAttribute("value"));
		log.info("Expected Address Value is --" + data.getCellData("ProjectRegistration", 3, 2));
		log.info("Actual City Value is --" + CityTextBox.getAttribute("value"));
		log.info("Expected City Value is --" + data.getCellData("ProjectRegistration", 4, 2));
		log.info("Actual Country Value is --" + dropdownhelper.getSelectedValue(CountryDropDown));
		log.info("Expected Country Value is --" + data.getCellData("ProjectRegistration", 5, 2));
		log.info("Actual State Value is --" + dropdownhelper.getSelectedValue(StateDropDown));
		log.info("Expected State Value is --" + data.getCellData("ProjectRegistration", 6, 2));
		log.info("Actual Zip Value is --" + ZipTextBox.getAttribute("value"));
		log.info("Expected Zip Value is --" + data.getCellData("ProjectRegistration", 7, 2));
		if (AddressTextBox.getAttribute("value").equals(data.getCellData("ProjectRegistration", 3, 2))
				&& CityTextBox.getAttribute("value").equals(data.getCellData("ProjectRegistration", 4, 2))
				&& dropdownhelper.getSelectedValue(CountryDropDown)
						.equals(data.getCellData("ProjectRegistration", 5, 2))
				&& dropdownhelper.getSelectedValue(StateDropDown).equals(data.getCellData("ProjectRegistration", 6, 2))
				&& ZipTextBox.getAttribute("value").equals(data.getCellData("ProjectRegistration", 7, 2))) {
			log.info("Address matched--------------");
			log.info("CheckAddress_City_Country_State_ZipCode starts ends with true..................");
			return true;
		} else {
			log.info("Address not maching--------------");
			log.info("CheckAddress_City_Country_State_ZipCode ends with false..................");
			return false;
		}

	}

	public boolean CheckGeoLocation() {
		try {

			Thread.sleep(3000);

			if (!(LongitudeTextbox.getAttribute("value") == "" && LatitudeTextbox.getAttribute("value") == "")) {
				return true;
			} else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean CheckAddButtonEnabled() {

		boolean flag = AddProjectButton.getAttribute("class").equals("pl20 pr20 btn btn-primary");
		log.info("Add button enabled flag is --" + flag);

		return flag;
	}

	public void SelectThisIsTestProjectCheckBox() {

		try {
			ThisIsTestProjectCheckBox.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void SelectProjectIsPrivateCheckBox() {

		try {
			ProjectIsPrivateCheckBox.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean ParkSmartDownLoadServiceAgreement() {
		log.info("ParkSmartDownLoadServiceAgreement  method starts here -----");
		String pdfcontent = null;
		waithelper.WaitForElementClickable(ServiceAgreementLink, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		ServiceAgreementLink.click();
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
				String Agreementurl = "https://" + (System.getProperty("environment")).toLowerCase()
						+ ".app.arconline.io/assets/pdf/parksmart_registration_agreement.pdf";
				log.info("Agreement URL is " + Agreementurl);
				pdfcontent = CommonMethod.getPDFContent(Agreementurl);
				if (pdfcontent.contains("Green Business Certification Inc.™")) {
					driver.close();
					driver.switchTo().window(BaseWindow);
					log.info("ParkSmartDownLoadServiceAgreement  method ends with true here -----");
					return true;
				} else
					log.info("ParkSmartDownLoadServiceAgreement  method ends with false here -----");
				return false;

			}
		}

		log.info("ParksmartDownLoadServiceAgreement  method ends with false here -----");
		return false;
	}

	public boolean DownLoadServiceAgreement() {
		log.info("DownLoadServiceAgreement  method starts here -----");
		String pdfcontent = null;
		waithelper.WaitForElementClickable(ServiceAgreementLink, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		ServiceAgreementLink.click();
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
				String Agreementurl = "https://" + (System.getProperty("environment")).toLowerCase()
						+ ".app.arconline.io/assets/pdf/registration_agreement.pdf";
				log.info("Agreement URL is " + Agreementurl);
				pdfcontent = CommonMethod.getPDFContent(Agreementurl);
				if (pdfcontent.contains("ARC FOR ALL SERVICES AGREEMENT")) {
					driver.close();
					driver.switchTo().window(BaseWindow);
					log.info("DownLoadServiceAgreement  method ends with true here -----");
					return true;
				} else
					log.info("DownLoadServiceAgreement  method ends with false here -----");
				return false;

			}
		}

		log.info("DownLoadServiceAgreement  method ends with false here -----");
		return false;
	}


	public boolean CheckServiceAgreementCheckbox() {
		boolean flag = false;
		ServiceAgreementCheckBox.click();
		try {
			Thread.sleep(3000);
			if (AddProjectButton.getAttribute("class").equals("pl20 pr20 btn btn-primary"))
				flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}
	
	

	public CityPageObject ClickonCityAddProjectButton() {

		try {
			AddProjectButton.click();
			// Thread.sleep(2000);
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[text()='Validating info...'])[1]/parent::div")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new CityPageObject();

	}

	public BuildingPageObject ClickonBuildingsAddProjectButton() {

		try {
			AddProjectButton.click();
			// Thread.sleep(2000);
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[text()='Validating info...'])[1]/parent::div")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new BuildingPageObject();

	}

	public CommunitiesPageObject ClickonCommunitiesAddProjectButton() {

		try {
			AddProjectButton.click();
			// Thread.sleep(2000);
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[text()='Validating info...'])[1]/parent::div")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new CommunitiesPageObject();

	}

	public void SelectUnitType(String unit) {

		try {
			dropdownhelper.selectUsingVisibleText(GrossAreaUnitType, unit);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean DateCommisonedOpensCalendar() {
		log.info("DateCommisonedOpensCalendar method starts here........");
		boolean flag = true;
		DateCommisioned.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		WebElement ele = driver.findElement(By.xpath("//div[@class='datepicker datepicker-dropdown dropdown-menu'][2]"));
		if (ele.isDisplayed()) {
			flag = true;
			log.info("DateCommisonedOpensCalendar method ends here........");
		}
		return flag;
		
	}

	public boolean Check_Owner_Region(String Region) {
		OwnerRegionTextbox.click();
		OwnerRegionTextbox.sendKeys(Region);
		/*
		 * try { waithelper.WaitForElementVisibleWithPollingTime( driver.findElement(By
		 * .xpath("//ul[@class='dropdown-menu address normal dropdown-menu-fixed address_dropdown']"
		 * )), Integer.parseInt(prop.getProperty("explicitTime")), 2); } catch
		 * (Exception e) { e.printStackTrace(); }
		 */
		List<WebElement> list = driver.findElements(
				By.xpath("//*[@id=\"details-form\"]/div[1]/table/tbody/tr[12]/td/div/select/option[235]"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().equals("United States")) {
				list.get(i).click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}

		if (OwnerRegionTextbox.getAttribute("value").equals(data.getCellData("ProjectRegistration", 23, 2))) {
			return true;
		} else
			return false;

	}

	public boolean Check_Owner_Type(String Type) {
		OwnerTypeTextbox.click();
		OwnerTypeTextbox.sendKeys(Type);
		/*
		 * try { waithelper.WaitForElementVisibleWithPollingTime( driver.findElement(By
		 * .xpath("//ul[@class='dropdown-menu address normal dropdown-menu-fixed address_dropdown']"
		 * )), Integer.parseInt(prop.getProperty("explicitTime")), 2); } catch
		 * (Exception e) { e.printStackTrace(); }
		 */
		List<WebElement> list = driver
				.findElements(By.xpath("//*[@id=\"details-form\"]/div[1]/table/tbody/tr[9]/td/div/select/option[1]"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().equals("Business Improvement District")) {
				list.get(i).click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}

		if (OwnerTypeTextbox.getAttribute("value").equals(data.getCellData("ProjectRegistration", 20, 2))) {
			return true;
		} else
			return false;

	}

	public ProjectPaymentPageObject ClickonParkingAddProjectButton() {

		try {
			AddProjectButton.click();
			// Thread.sleep(2000);
			waithelper.WaitForElementInvisible(
					driver.findElement(By.xpath("(//*[text()='Validating info...'])[1]/parent::div")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ProjectPaymentPageObject();

	}

	public void ClickOnParkingSpace() {
		try {
			ParkingSpacesTextBox.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ClickOnParkingLevels() {
		try {
			ParkingLevelTextBox.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ClickOwnerEmail() {
		try {
			OwnerEmailTextbox.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean CheckParkingSpaceValidationMsg() {
		boolean flag = false;
		try {
			flag = ParkingSpaceValidationMsg.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public boolean CheckParkingLevelValidationMsg() {
		boolean flag = false;
		try {
			flag = ParkingLevelValidationMsg.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public boolean CheckEmailValidationMsg() {
		boolean flag = false;
		try {
			flag = EmailValidationMsg.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public void enterParkingSpace(String ParkingSpace) {
		ParkingSpacesTextBox.clear();
		ParkingSpacesTextBox.sendKeys(ParkingSpace);

	}

	public void enterParkingLevel(String ParkingLevel) {
		ParkingLevelTextBox.clear();
		ParkingLevelTextBox.sendKeys(ParkingLevel);
	}
	
	
	public boolean SelectTransitProjectType() {
		boolean flag = true;

		try {
	
			if (dropdownhelper.getSelectedValue(ProjectType).equals("Buildings - Transit"))
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public void enterAnnualRidership(String AnnualRider) {
		AnnualRidershipTextbox.clear();
		AnnualRidershipTextbox.sendKeys(AnnualRider);

	}
	
	public void enterWeeklyOperatingHrs(String WeeklyHrs) {
		WeeklyHrsTextbox.clear();
		WeeklyHrsTextbox.sendKeys(WeeklyHrs);

	}
	
	public void enterFulltimeStaff(String FulltimeStaff) {
		FulltimeStaffTextbox.clear();
		FulltimeStaffTextbox.sendKeys(FulltimeStaff);

	}
	
	public void enterAvgTimeSpent(String AvgTime) {
		AvgTimeSpentTextbox.clear();
		AvgTimeSpentTextbox.sendKeys(AvgTime);

	}
	
	public boolean CheckAnnualRidershipValidationMsg() {
		boolean flag = false;
		try {
			flag = AnnualRiderValidationMsg.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}
	
	public boolean CheckAvgTimeSpentValidationMsg() {
		boolean flag = false;
		try {
			flag = AvgTimeSpentValidationMsg.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}
	
	public boolean CheckWeeklyHrsValidationMsg() {
		boolean flag = false;
		try {
			flag = WeeklyHrsValidationMsg.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}
	
	
	public boolean CheckFulltimeStaffValidationMsg() {
		boolean flag = false;
		try {
			flag = FulltimeStaffValidationMsg.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}
	
	
	
	public void SelectStationType(String Station) {

		try {
			dropdownhelper.selectUsingVisibleText(TransitStationType, Station);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public void ClickonTransitAddProjectButton() {

		AddProjectButton.click();
		waithelper.WaitForElementInvisible(
				driver.findElement(By.xpath("(//*[text()='Validating info...'])[1]/parent::div")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

	public TransitPageObject ClickOnPreviewAccess() {

		PreviewAccessButton.click();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new TransitPageObject();

	}
	
	public ProjectPaymentPageObject ClickOnPayNow() {

		PayNowButton.click();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ProjectPaymentPageObject();

	}
	
	public boolean TransitDownLoadServiceAgreement() {
		log.info("TransitDownLoadServiceAgreement  method starts here -----");
		String pdfcontent = null;
		waithelper.WaitForElementClickable(ServiceAgreementLink, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		ServiceAgreementLink.click();
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
				String Agreementurl = "https://" + (System.getProperty("environment")).toLowerCase()
						+ ".app.arconline.io/assets/pdf/addendum_agreement.pdf";
				log.info("Agreement URL is " + Agreementurl);
				pdfcontent = CommonMethod.getPDFContent(Agreementurl);
				if (pdfcontent.contains("Green Business Certification Inc.™")) {
					driver.close();
					driver.switchTo().window(BaseWindow);
					log.info("TransitDownLoadServiceAgreement  method ends with true here -----");
					return true;
				} else
					log.info("TransitDownLoadServiceAgreement  method ends with false here -----");
				return false;

			}
		}

		log.info("TransitDownLoadServiceAgreement  method ends with false here -----");
		return false;
	}

	public boolean Validate_WeightedDailyOccupancy() {
		log.info("Validate_WeightedDailyOccupancy method starts here..........");
		
		double RiderShip = Double.parseDouble(System.getProperty("Annual_Ridership"));
		double WeeklyHours = Double.parseDouble(System.getProperty("Weekly_Hours"));
		double FulltimeStaff =  Double.parseDouble(System.getProperty("Fulltime_Staff"));
		double AverageTime =  Double.parseDouble(System.getProperty("Average_Time"));
		
		log.info("-----------------------");
		log.info("Annual Ridership ---->" + RiderShip);
		log.info("Weekly Operating Hours ---->" + WeeklyHours);
		log.info("Full Time Staff ---->" + FulltimeStaff);
		log.info("Average Time Spent ---->" + AverageTime);
		ngWebDriver.waitForAngularRequestsToFinish();
		String ActWeightedDailyOccupancy = WeightedOccupancyTextbox.getAttribute("value");
		log.info("Actual Weighted Daily Occupancy is ---->" + ActWeightedDailyOccupancy);
		
		int WeightedDailyOccupancy = (int) (FulltimeStaff + (Math.round((RiderShip/365) * ((AverageTime/60)/(WeeklyHours/7)))));
		String ExpWeightedDailyOccupancy = Integer.toString(WeightedDailyOccupancy);
		log.info("Expected Weighted Daily Occupancy is ---->" + ExpWeightedDailyOccupancy);
		
		if(ActWeightedDailyOccupancy.equals(ExpWeightedDailyOccupancy)) {
			log.info("Validate_WeightedDailyOccupancy method ends with true here..........");
			return true;
		}else
			log.info("Validate_WeightedDailyOccupancy method ends with false here..........");
			return false;
	}
	
	public boolean CheckTransit_Address_City_Country_State_ZipCode(String Address) {
		log.info("CheckAddress_City_Country_State_ZipCode starts here..................");
		AddressTextBox.clear();
		AddressTextBox.sendKeys(Address);
		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By
							.xpath("//ul[@class='dropdown-menu address normal dropdown-menu-fixed address_dropdown']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<WebElement> list = driver.findElements(
				By.xpath("//ul[@class='dropdown-menu address normal dropdown-menu-fixed address_dropdown']/li"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < list.size(); i++) {
			log.info(list.get(i).getText());
			if (list.get(i).getText().equals("2101 L St NW - 2101 L St NW, Washington, DC 20037, USA")) {
				list.get(i).click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}

		log.info("Actual Address Value is --" + AddressTextBox.getAttribute("value"));
		log.info("Expected Address Value is --" + data.getCellData("TransitRegistration", 3, 2));
		log.info("Actual City Value is --" + CityTextBox.getAttribute("value"));
		log.info("Expected City Value is --" + data.getCellData("TransitRegistration", 4, 2));
		log.info("Actual Country Value is --" + dropdownhelper.getSelectedValue(CountryDropDown));
		log.info("Expected Country Value is --" + data.getCellData("TransitRegistration", 5, 2));
		log.info("Actual State Value is --" + dropdownhelper.getSelectedValue(StateDropDown));
		log.info("Expected State Value is --" + data.getCellData("TransitRegistration", 6, 2));
		log.info("Actual Zip Value is --" + ZipTextBox.getAttribute("value"));
		log.info("Expected Zip Value is --" + data.getCellData("TransitRegistration", 7, 2));
		if (AddressTextBox.getAttribute("value").equals(data.getCellData("TransitRegistration", 3, 2))
				&& CityTextBox.getAttribute("value").equals(data.getCellData("TransitRegistration", 4, 2))
				&& dropdownhelper.getSelectedValue(CountryDropDown)
						.equals(data.getCellData("TransitRegistration", 5, 2))
				&& dropdownhelper.getSelectedValue(StateDropDown).equals(data.getCellData("TransitRegistration", 6, 2))
				&& ZipTextBox.getAttribute("value").equals(data.getCellData("TransitRegistration", 7, 2))) {
			log.info("Address matched--------------");
			log.info("CheckAddress_City_Country_State_ZipCode starts ends with true..................");
			return true;
		} else {
			log.info("Address not maching--------------");
			log.info("CheckAddress_City_Country_State_ZipCode ends with false..................");
			return false;
		}

	}
	
	
	
	
}