package com.arc.PageObject.Project;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class SchoolPageObject extends BaseClass {
	private static Logger log = LoggerHelper.getLogger(SchoolPageObject.class);

	@FindBy(xpath = "(//*[text()='Manage' and @class='ml10'])[1]")
	WebElement ManageMenu;
	
	@FindBy(xpath = "//*[@class='page-controls navbar_info navbar-default']//child::h4")
	WebElement ProjectNameLabel;


	@FindBy(xpath = "(//a[text()=' Agreements '])[1]")
	WebElement AgreementSubmenu;

	@FindBy(xpath = "//table[@class='table table-striped arc-table']/tbody/tr/td[3]/button")
	WebElement AgreementDownloadLink;

	@FindBy(xpath = "(//a[text()=' Billing '])[1]")
	WebElement BillingSubmenu;

	@FindBy(xpath = "//*[contains(text(),' Download invoice')]")
	WebElement DownLoadInvoicelink;

	@FindBy(xpath = "//*[contains(text(),' Download receipt')]")
	WebElement DownLoadReceiptlink;

	@FindBy(xpath = "(//a[text()=' Team '])[1]")
	WebElement TeamSubmenu;

	@FindBy(xpath = "//input[@name='input']")
	WebElement TeamEmailTextBox;

	@FindBy(xpath = "(//button[@id='invite_team'])[1]")
	WebElement TeamInviteButton;

	@FindBy(xpath = "//h3[@class='fw-500 black-color pl15 mb25 pt5']")
	WebElement OverviewText;
	
	@FindBy(xpath = "(//a[text()=' Project '])[1]")
	WebElement ProjectSubmenu;

	@FindBy(xpath = "(//span[text()='Overview'])[1]")
	WebElement OverviewMenu;

	@FindBy(xpath = ("//body[1]/div[1]/nav[1]/div[1]/div[1]/div[1]/div[1]/div[10]"))
	WebElement FinancialModelMenu;
	
	
	
			
	 
	//////////////////////////////////////////////////////////////////////// Regression /////////////////////////////////////
	
	
	
	public SchoolPageObject() {
		PageFactory.initElements(driver, this);
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


   public boolean checkSchoolsProjectCreation(String PName) {

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
	public SchoolFinancialModelPageObject ClickOnFinancialModelMenu() {
		FinancialModelMenu.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//span[@class='fw-semi-bold']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		return new SchoolFinancialModelPageObject();
	}
	
	
}


