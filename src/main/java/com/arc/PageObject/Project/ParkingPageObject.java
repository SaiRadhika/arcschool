package com.arc.PageObject.Project;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class ParkingPageObject extends BaseClass {

	private static Logger log = LoggerHelper.getLogger(ParkingPageObject.class);

	@FindBy(xpath = "(//*[text()='Manage' and @class='ml10'])[1]")
	WebElement ManageMenu;

	@FindBy(xpath = "(//a[text()=' Agreements '])[1]")
	WebElement AgreementSubmenu;

	@FindBy(xpath = "(//a[text()=' Billing '])[1]")
	WebElement BillingSubmenu;

	@FindBy(xpath = "(//a[text()=' Team '])[1]")
	WebElement TeamSubmenu;

	public ParkingPageObject() {
		PageFactory.initElements(driver, this);
	}

	public void ClickonAgreementInManage() {
		log.info("ClickonAgreementInManage method starts here ....");
		waithelper.WaitForElementClickable(ManageMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ManageMenu.click();
		waithelper.WaitForElementClickable(AgreementSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		AgreementSubmenu.click();
		CommonMethod.waitUntilLoadElement();
		log.info("ClickonAgreementInManage method ends here ....");
	}

	public void ClickonBillingInManage() {
		log.info("ClickonBillingInManage method starts here ....");
		waithelper.WaitForElementClickable(ManageMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ManageMenu.click();
		waithelper.WaitForElementClickable(BillingSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		BillingSubmenu.click();
		CommonMethod.waitUntilLoadElement();
		log.info("ClickonBillingInManage method ends here ....");
	}

	public void ClickonTeamInManage() {
		log.info("ClickonTeamInManage method starts here ....");
		waithelper.WaitForElementClickable(ManageMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ManageMenu.click();
		waithelper.WaitForElementClickable(TeamSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		TeamSubmenu.click();
		waithelper.waitForElement(driver.findElement(By.xpath("//span[text()='Team']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		CommonMethod.waitUntilLoadElement();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.info("ClickonTeamInManage method ends here ....");

	}

}
