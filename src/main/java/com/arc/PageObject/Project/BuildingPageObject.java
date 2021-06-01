package com.arc.PageObject.Project;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.arc.testBase.BaseClass;

public class BuildingPageObject extends BaseClass{

	
	@FindBy(xpath="//*[@class='page-controls navbar_info navbar-default']//child::h4")
	WebElement ProjectNameLabel;
	
	@FindBy(xpath="(//*[text()='Manage' and @class='ml10'])[1]")
	WebElement ManageMenu;
	
	@FindBy(xpath="(//a[text()=' Agreements '])[1]")
	WebElement AgreementSubmenu;
	
	@FindBy(xpath="//table[@class='table table-striped arc-table']/tbody/tr/td[3]/button")
	WebElement AgreementDownloadLink;
	
	@FindBy(xpath="//table[@class='table table-striped arc-table']/tbody/tr[1]/td[6]/button")
	WebElement BillingDownloadLink;
	
	@FindBy(xpath="//*[contains(text(),' Download invoice')]")
	WebElement DownLoadInvoicelink;
	
	
	@FindBy(xpath="//*[contains(text(),' Download receipt')]")
	WebElement DownLoadReceiptlink;
	
	
	@FindBy(xpath="(//a[text()=' Billing '])[1]")
	WebElement BillingSubmenu;
	
	public BuildingPageObject()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String getProjectLabelText()
	{
		return ProjectNameLabel.getText();
	}
	
	public void ClickonAgreementInManage()
	{
		ManageMenu.click();
		AgreementSubmenu.click();
		
	}
	
	public void ClickonBillingInManage()
	{
		ManageMenu.click();
		BillingSubmenu.click();
		
	}
	
	
}
