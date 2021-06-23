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

public class ParkingPageObject extends BaseClass{
	
	private static Logger log= LoggerHelper.getLogger(ParkingPageObject.class);
	
	@FindBy(xpath = "(//*[text()='Manage' and @class='ml10'])[1]")
	WebElement ManageMenu;

	@FindBy(xpath = "(//a[text()=' Agreements '])[1]")
	WebElement AgreementSubmenu;
	
	@FindBy(xpath = "(//a[text()=' Billing '])[1]")
	WebElement BillingSubmenu;

	@FindBy(xpath="(//a[text()=' Team '])[1]")
	WebElement TeamSubmenu;
	
	public ParkingPageObject() {
		PageFactory.initElements(driver, this);
	}
	

	public void ClickonAgreementInManage() {
		ManageMenu.click();
		AgreementSubmenu.click();

	}

	public void ClickonBillingInManage() {
		ManageMenu.click();
		BillingSubmenu.click();

	}
	

	
	
	public void ClickonTeamInManage()
	{
		try {
		ManageMenu.click();
		TeamSubmenu.click();
		waithelper.waitForElement(driver.findElement(By.xpath("//span[text()='Team']")), Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Thread.sleep(3000);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to traverse Team Submenu");
		}
		
	}
	
	
}
