package com.arc.PageObject.Project;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.arc.testBase.BaseClass;

public class CityPageObject extends BaseClass{
	@FindBy(xpath="(//*[text()='Manage' and @class='ml10'])[1]")
	WebElement ManageMenu;
	
	@FindBy(xpath="(//a[text()=' Agreements '])[1]")
	WebElement AgreementSubmenu;
	
	@FindBy(xpath="(//a[text()=' Billing '])[1]")
	WebElement BillingSubmenu;
	
	public CityPageObject()
	{
		PageFactory.initElements(driver,this);
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
