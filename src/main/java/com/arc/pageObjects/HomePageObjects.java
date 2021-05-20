package com.arc.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.arc.pageObjects.building.ProjectPageObjects;
import com.arc.testBase.BaseClass;

public class HomePageObjects extends BaseClass{
	
	@FindBy(xpath = "//*[@href='/app/projects/my-projects/?project-type=all' and text()='Projects']")
	WebElement ProjectHeader;
	
	@FindBy(xpath = "//body/div[@id='app']/nav[1]/div[1]/div[1]/div[1]/div[2]/span[1]")
	WebElement BuildingSubMenu;
	
	@FindBy(xpath="//table[@class='table table-striped arc-table']//child::tr[1]/td[3]/div/span")
	WebElement BuildingName;
	
	
	
	
	
	public HomePageObjects()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String checkHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public ProjectPageObjects clickOnProject()
	{
		ProjectHeader.click();
		return new ProjectPageObjects();
	}
	
	
	public void clickOnBuildingSubMenu()
	{
		BuildingSubMenu.click();
		
	}
	
	public void clickOnBuildingName()
	{
		BuildingName.click();
	}
	
	

}
