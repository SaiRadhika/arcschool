package com.arc.PageObject;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.arc.PageObject.Project.CityPageObject;
import com.arc.PageObject.Project.CommunitiesPageObject;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class ProjectRegistrationPageObject extends BaseClass {

	private static Logger log = LoggerHelper.getLogger(ProjectRegistrationPageObject.class);

	@FindBy(xpath = "//div[@class='align-center mt11 width-100-perc']/h4")
	WebElement AddAProjectLabelHeader;

	@FindBy(xpath = "(//*[text()='Enter Project Details']//parent::div/div//div/input)[1]")
	WebElement ProjectNameTextBox;

	@FindBy(xpath = "//*[@class='error ng-binding' and starts-with(text(),'Please enter a valid name. Allowed special characters are')]")
	WebElement ProjectNamevalidationMsg;

	@FindBy(xpath = "//div[@class='checkbox test_project pl20 ng-scope']/input")
	WebElement ThisIsTestProjectCheckBox;
	
	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	WebElement ProjectIsPrivateCheckBox;

	@FindBy(xpath = "(//table[1]/tbody/tr[3]/td[1]/div[1]/select)[1]")
	WebElement ProjectType;

	@FindBy(xpath = "//input[@id='gross_area']")
	WebElement GrossAreaTextBox;

	@FindBy(xpath = "//*[text()='Gross Area']//following-sibling::span[text()=\"Exceeded maximum value\"]")
	WebElement GrossAreaTextBoxValidationMsg;

	@FindBy(xpath = "//table[1]/tbody/tr[5]/td[2]/div/select")
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

	public boolean CheckRegisterforLEEDPopupButtonsExists() {
		boolean flag = false;
		try {
			waithelper.waitForElement(RegisterLEEDCertificationNowPopUpButton, Integer.parseInt(prop.getProperty("explicitTime")));
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String checkLEEDOnLinePortal() {
		String handle = driver.getWindowHandle();
		try {
			RegisterLEEDCertificationNowPopUpButton.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Set<String> handles = driver.getWindowHandles();
		if (handles.size() == 2) {
			for (String window : handles) {
				if (!handle.equals(window)) {
					driver.switchTo().window(window);
					try {
						waithelper.waitForElement(driver.findElement(By.xpath("//ul[@class='breadcrumb' ]/li[2][text()='City Registration']")), Integer.parseInt(prop.getProperty("explicitTime")));
						String title = driver.findElement(By.xpath("//ul[@class='breadcrumb' ]/li[2]")).getText();
						System.out.println(title);
						driver.close();
						driver.switchTo().window(handle);
						return title;
					}
					catch(Exception e)
					{
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
				
				waithelper.WaitForElementInvisible(RegisterLEEDCertificationNowPopUpButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
				if (!(RegisterLEEDCertificationNowPopUpButton.isDisplayed() && NotNowPopUpButton.isDisplayed())) {
					if (RegisterLEEDNoRadioBtn.isSelected()) {
						System.out.println(driver.findElement(By.xpath(
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

	public boolean SelectCityProjectType() {
		boolean flag = false;

		try {
			//System.out.println(dropdownhelper.getSelectedValue(ProjectType).equals("Cities"));
			if(dropdownhelper.getSelectedValue(ProjectType).equals("Cities"))
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean SelectCommunitiesProjectType() {
		boolean flag = false;

		try {
			//System.out.println(dropdownhelper.getSelectedValue(ProjectType).equals("Cities"));
			if(dropdownhelper.getSelectedValue(ProjectType).equals("Communities"))
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
			System.out.println(list.get(i).getText());
			if (list.get(i).getText()
					.equals("2101 L St NW - 2101 L St NW, Washington, DC 20037, USA")) {
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

		log.info("Actual Address Value is --"+AddressTextBox.getAttribute("value"));
		log.info("Expected Address Value is --"+data.getCellData("ProjectRegistration", 3, 2));
		log.info("Actual City Value is --"+CityTextBox.getAttribute("value"));
		log.info("Expected City Value is --"+data.getCellData("ProjectRegistration", 4, 2));
		log.info("Actual Country Value is --"+dropdownhelper.getSelectedValue(CountryDropDown));
		log.info("Expected Country Value is --"+data.getCellData("ProjectRegistration", 5, 2));
		log.info("Actual State Value is --"+dropdownhelper.getSelectedValue(StateDropDown));
		log.info("Expected State Value is --"+data.getCellData("ProjectRegistration", 6, 2));
		log.info("Actual Zip Value is --"+ZipTextBox.getAttribute("value"));
		log.info("Expected Zip Value is --"+data.getCellData("ProjectRegistration", 7, 2));
		if (AddressTextBox.getAttribute("value").equals(data.getCellData("ProjectRegistration", 3, 2))
				&& CityTextBox.getAttribute("value").equals(data.getCellData("ProjectRegistration", 4, 2))
				&& dropdownhelper.getSelectedValue(CountryDropDown).equals(data.getCellData("ProjectRegistration", 5, 2))
				&& dropdownhelper.getSelectedValue(StateDropDown).equals(data.getCellData("ProjectRegistration", 6, 2))
				&& ZipTextBox.getAttribute("value").equals(data.getCellData("ProjectRegistration", 7, 2))) {
			log.info("Address matched--------------");
			log.info("CheckAddress_City_Country_State_ZipCode starts ends with true..................");
			return true;
		} else
		{
			log.info("Address not maching--------------");
			log.info("CheckAddress_City_Country_State_ZipCode ends with false..................");
			return false;	
		}

	}

	public boolean CheckGeoLocation() {
		try{
			
			Thread.sleep(3000);
		if (!(LongitudeTextbox.getAttribute("value").isBlank() && LatitudeTextbox.getAttribute("value").isBlank())) {
			return true;
		} else
			return false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
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
	
	

	public boolean DownLoadServiceAgreement() {
		log.info("DownLoadServiceAgreement  method starts here -----");
		String handle = driver.getWindowHandle();
		
		waithelper.WaitForElementClickable(ServiceAgreementLink, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ServiceAgreementLink.click();
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
					if (url.contains("registration_agreement.pdf")) {
						driver.close();
						driver.switchTo().window(handle);
						log.info("DownLoadServiceAgreement  method ends with true here -----");
						return true;
					} else
						log.info("DownLoadServiceAgreement  method ends with false here -----");
						return false;

				}
			}

		}
		log.info("DownLoadServiceAgreement  method ends with false here -----");
		return false;
	}

	public boolean CheckServiceAgreementCheckbox() {
		boolean flag = false;
		ServiceAgreementCheckBox.click();
		try {
			Thread.sleep(2000);
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
			//Thread.sleep(2000);
			waithelper.WaitForElementInvisible(driver.findElement(By.xpath("(//*[text()='Validating info...'])[1]/parent::div")),Integer.parseInt(prop.getProperty("explicitTime")), 2);
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new CityPageObject();

	}
	
	
	public CommunitiesPageObject ClickonCommunitiesAddProjectButton() {

		try {
			AddProjectButton.click();
			//Thread.sleep(2000);
			waithelper.WaitForElementInvisible(driver.findElement(By.xpath("(//*[text()='Validating info...'])[1]/parent::div")),Integer.parseInt(prop.getProperty("explicitTime")), 2);
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

	

	

}
