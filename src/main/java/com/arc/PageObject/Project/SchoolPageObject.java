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

public class SchoolPageObject extends BaseClass{
	private static Logger log= LoggerHelper.getLogger(SchoolPageObject.class);
	
	@FindBy(xpath="(//*[text()='Manage' and @class='ml10'])[1]")
	WebElement ManageMenu;
	
	@FindBy(xpath="(//a[text()=' Agreements '])[1]")
	WebElement AgreementSubmenu;
	
	@FindBy(xpath="//table[@class='table table-striped arc-table']/tbody/tr/td[3]/button")
	WebElement AgreementDownloadLink;
	
	@FindBy(xpath="(//a[text()=' Billing '])[1]")
	WebElement BillingSubmenu;
	
	@FindBy(xpath="//*[contains(text(),' Download invoice')]")
	WebElement DownLoadInvoicelink;
	
	
	@FindBy(xpath="//*[contains(text(),' Download receipt')]")
	WebElement DownLoadReceiptlink;
	
	@FindBy(xpath="(//a[text()=' Team '])[1]")
	WebElement TeamSubmenu;
	
	@FindBy(xpath="//input[@name='input']")
	WebElement TeamEmailTextBox;
	
	@FindBy(xpath="(//button[@id='invite_team'])[1]")
	WebElement TeamInviteButton;
	
	public SchoolPageObject()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void ClickonAgreementInManage()
	{
		try {
		
		ManageMenu.click();
		AgreementSubmenu.click();
		waithelper.waitForElement(driver.findElement(By.xpath("//span[text()='Agreements']")), Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Thread.sleep(3000);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to traverse Agreement Submenu");
		}
	}
	
	public void ClickonBillingInManage()
	{
		try {
		ManageMenu.click();
		BillingSubmenu.click();
		waithelper.waitForElement(driver.findElement(By.xpath("//span[text()='Billing']")), Integer.parseInt(prop.getProperty("explicitTime")), 2);
		Thread.sleep(3000);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to traverse Billing Submenu");
		}
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
