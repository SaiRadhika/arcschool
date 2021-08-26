package com.arc.PageObject.Project;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class BuildingPageObject extends BaseClass {

	private static Logger log = LoggerHelper.getLogger(BuildingPageObject.class);

	@FindBy(xpath = "//*[@class='page-controls navbar_info navbar-default']//child::h4")
	WebElement ProjectNameLabel;

	@FindBy(xpath = "(//*[text()='Manage' and @class='ml10'])[1]")
	WebElement ManageMenu;

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

	public BuildingPageObject() {
		PageFactory.initElements(driver, this);
	}

	public String getProjectLabelText() {
		return ProjectNameLabel.getText();
	}

	public void ClickonAgreementInManage() {
		waithelper.WaitForElementClickable(ManageMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ManageMenu.click();
		waithelper.WaitForElementClickable(AgreementSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		AgreementSubmenu.click();
		waithelper.waitForElement(driver.findElement(By.xpath("//span[text()='Agreements']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ClickonBillingInManage() {
		waithelper.WaitForElementClickable(ManageMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ManageMenu.click();
		waithelper.WaitForElementClickable(BillingSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		BillingSubmenu.click();
		waithelper.waitForElement(driver.findElement(By.xpath("//span[text()='Billing']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ClickonTeamInManage() {
		waithelper.WaitForElementClickable(ManageMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ManageMenu.click();
		waithelper.WaitForElementClickable(TeamSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		TeamSubmenu.click();
		waithelper.waitForElement(driver.findElement(By.xpath("//span[text()='Team']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
}
