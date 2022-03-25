package com.arc.PageObject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.arc.PageObject.Project.ParkingPageObject;
import com.arc.PageObject.Project.TransitPageObject;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class ProjectPaymentPageObject extends BaseClass {
	
	private static Logger log = LoggerHelper.getLogger(ProjectPaymentPageObject.class);

	@FindBy(xpath = "//input[@name='street']")
	WebElement BillingAddressTextBox;

	@FindBy(xpath = "//span[normalize-space()='This field is required']")
	WebElement AddressValidationMsg;

	@FindBy(xpath = "//input[@name='city']")
	WebElement BillingCityTextBox;

	@FindBy(xpath = "/html/body/div[1]/main/div[1]/main/div/div[1]/div[2]/div/div/table/tbody/tr[6]/td[2]/div/span[3]")
	WebElement CityValidationMsg;

	@FindBy(xpath = "//input[@name='zip_code']")
	WebElement BillingZipCodeTextBox;

	@FindBy(xpath = "//select[@name='country']")
	WebElement BillingCountry;

	@FindBy(xpath = "/html/body/div[1]/main/div[1]/main/div/div[1]/div[2]/div/div/table/tbody/tr[10]/td[2]/div/span[3]")
	WebElement ZipCodeValidationMsg;

	@FindBy(xpath = "//input[@name='CC_number']")
	WebElement CardNumberTextBox;

	@FindBy(xpath = "/html/body/div[1]/main/div[1]/main/div/div[1]/div[3]/div[1]/div/table/tbody/tr[2]/td[2]/div/span[3]")
	WebElement CardValidationMsg;

	@FindBy(xpath = "//input[@name='CC_expiry']")
	WebElement ExpiryDateTextBox;

	@FindBy(xpath = "/html/body/div[1]/main/div[1]/main/div/div[1]/div[3]/div[1]/div/table/tbody/tr[3]/td[2]/div/span[3]")
	WebElement ExpiryValidationMsg;

	@FindBy(xpath = "//input[@name='CC_CVV']")
	WebElement CardCvv;

	@FindBy(xpath = "//*[@id=\"details-form\"]/table/tbody/tr[3]/td[3]/div/span[3]")
	WebElement CvvValidationMsg;

	@FindBy(xpath = "//*[@id=\"details-form\"]/table/tbody/tr[7]/td[3]/div/select")
	WebElement BillingSelectState;

	@FindBy(xpath = "//div[@class='pl20 pr20 btn btn-primary ng-binding']")
	WebElement SubmitButton;

	@FindBy(xpath = "//*[@id=\"details-form\"]/table/tbody/tr[2]/td[2]/div/input")
	WebElement BillingNameTextBox;

	@FindBy(xpath = "//span[contains(text(),\"Please enter a valid name. Allowed special charact\")]")
	WebElement BillingNameValidationMsg;

	@FindBy(xpath = "//input[@name='email']")
	WebElement BillingEmailTextBox;

	@FindBy(xpath = "//span[normalize-space()='Please enter valid email.']")
	WebElement BillingEmailValidationMsg;

	@FindBy(xpath = "//div[@class='pt20']//*[name()='svg']")
	WebElement CancelButton;
	
	@FindBy(xpath = "//select[@name='rating_system']")
	WebElement RatingSystem;
	
	@FindBy(xpath = "//select[@name='manageEntityCountry']")
	WebElement OwnerRegionTextbox;
	
	@FindBy(xpath = "//label[text()='Owner Email']/parent::div/input")
	WebElement OwnerEmailTextbox;
	
	@FindBy(xpath = "//input[@id='organization']")
	WebElement OwnerOrgTextbox;
	
	@FindBy(xpath = "//label[text()='Owner Type']/parent::div/select")
	WebElement OwnerTypeTextbox;
	
	@FindBy(xpath = "//label[text()='Space Type']/parent::div/select")
	WebElement SpaceTypeTextbox;
	
	@FindBy(xpath = "//span[@class='ng-scope' and text()='Save']")
	WebElement SaveButton;

	public ProjectPaymentPageObject() {
		PageFactory.initElements(driver, this);
	}

	public void selectBillingState(String BillingState) {
		BillingSelectState.sendKeys(BillingState);
		BillingSelectState.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//*[@id=\"details-form\"]/table/tbody/tr[7]/td[3]/div/select")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//*[@id=\"details-form\"]/table/tbody/tr[7]/td[3]/div/select/option[54]")).click();
	}

	public void EnterBillingAddress(String Address) {
		BillingAddressTextBox.clear();
		BillingAddressTextBox.sendKeys(Address);
	}

	public void EnterBillingCity(String City) {
		BillingCityTextBox.clear();
		BillingCityTextBox.sendKeys(City);
	}

	public void EnterBillingZipCode(String Zipcode) {
		BillingZipCodeTextBox.clear();
		BillingZipCodeTextBox.sendKeys(Zipcode);
	}

	public void EnterCardNumber(String CardNumber) {
		CardNumberTextBox.clear();
		CardNumberTextBox.sendKeys(CardNumber);
	}

	public void EnterExpiryDate(String ExpiryDate) {
		ExpiryDateTextBox.clear();
		ExpiryDateTextBox.sendKeys(ExpiryDate);
	}

	public void EnterCvv(String Cvv) {
		CardCvv.clear();
		CardCvv.sendKeys(Cvv);
	}

	public void EnterBillingName(String BName) {
		BillingNameTextBox.clear();
		BillingNameTextBox.sendKeys(BName);
	}

	public void enterBillingEmail(String BEmail) {
		BillingEmailTextBox.clear();
		BillingEmailTextBox.sendKeys(BEmail);
	}

	public boolean CheckBillingNameValidationMsg() {
		boolean flag = false;
		try {
			flag = BillingNameValidationMsg.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public boolean CheckEmailValidationMsg() {
		boolean flag = false;
		try {
			flag = BillingEmailValidationMsg.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public void CancelPaymentButton() {
		boolean flag = false;
		try {
			flag = CancelButton.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag)
			CancelButton.click();
	}

	public boolean CheckAddressValidationMsg() {
		boolean flag = false;
	
		try {
			if (AddressValidationMsg.isDisplayed()) {
				if (CityValidationMsg.isDisplayed()) {
					if (ZipCodeValidationMsg.isDisplayed()) {
						flag = true;
					} else {
						log.info("Required field is missing");
					}
				} else {
					log.info("Required field is missing");
				}
			} else {
				log.info("Required field is missing");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public boolean Check_Billing_Country(String Country) {
		BillingCountry.click();
		BillingCountry.sendKeys(Country);

		List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"details-form\"]/table/tbody/tr[7]/td[2]/div/select/option[235]"));

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

		if (BillingCountry.getAttribute("value").equals(data.getCellData("ProjectRegistration", 5, 2))) {
			return true;
		} else
			return false;
	}

	public boolean CheckCardNumberValidationMsg() {
		boolean flag = false;
		
		try {
			flag = CardValidationMsg.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}
	
	
	public boolean CheckExpiryValidationMsg() {
		boolean flag = false;
		
		try {
			flag = ExpiryValidationMsg.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}
	
	public boolean CheckCvvValidationMsg() {
		boolean flag = false;
		
		try {
			flag = CvvValidationMsg.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}
	
	public boolean checkUnregisteredParkingProjectCreation() {
		boolean flag = false;
		
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(
							By.xpath("//*[@id=\"content\"]/div[1]/main/div/div[1]/div[1]")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			if (driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/main/div/div[1]/div[1]"))
					.getText().contains("Purchase")) {
				flag = true;
			}
		return flag;

	}
	
	public void selectSpaceType(String Stype) {
		dropdownhelper.selectUsingVisibleText(SpaceTypeTextbox, Stype);
	}
	
	public void selectOwnerRegion(String Region) {
		dropdownhelper.selectUsingVisibleText(OwnerRegionTextbox, Region);
	}

	public void selectOwnerType(String Otype) {
		dropdownhelper.selectUsingVisibleText(OwnerTypeTextbox, Otype);
	}
	
	public void selectOwnerOrg(String OwnerOrg) {
		OwnerOrgTextbox.sendKeys(OwnerOrg);
		OwnerOrgTextbox.click();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//div[@class='searchDropdownOrganization']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		driver.findElement(By.xpath("//div[@class='searchDropdownOrganization']/div[1]/div/span")).click();

	}
	
	public void enterOwnerEmail(String email) {
		OwnerEmailTextbox.sendKeys(email);
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

		if (OwnerRegionTextbox.getAttribute("value").equals(data.getCellData("Parking", 12, 2))) {
			return true;
		} else
			return false;

	}
	
	public void selectRatingSystem(String RatingSys) {
		dropdownhelper.selectUsingVisibleText(RatingSystem, RatingSys);
	}
	
	public void clickOnSave() {
		SaveButton.click();
	}

	public TransitPageObject ClickonTransitSubmitButton() {
		try {
			SubmitButton.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new TransitPageObject();
	}

	public ParkingPageObject ClickonParkingSubmitButton() {
		try {
			SubmitButton.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ParkingPageObject();
	}
}
