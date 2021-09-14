package com.arc.PageObject.Project;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arc.commonMethods.ActionsHelper;
import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;


public class ProjectPageObjects extends BaseClass {
	private static Logger log= LoggerHelper.getLogger(ProjectPageObjects.class);
	
	@FindBy(xpath="//table[@class='table table-striped arc-table']//child::tr")
	WebElement ProjectRows;
	
	@FindBy(xpath="//*[@id=\"myproject_body\"]/nav/div/div[1]/h3")
	WebElement ProjectLabel;
	
	@FindBy(xpath="(//*[@href='/app/projects/my-projects/?project-type=building']/span[1])[1]")	
	WebElement BuildingMenu;
	
	@FindBy(xpath="(//*[@href='/app/projects/my-projects/?project-type=school']/span[1])[1]")
	WebElement SchoolMenu;
	
	@FindBy(xpath = "//table[@class='table table-striped arc-table']//child::tbody/tr[1]/td[3]/div/span")
	WebElement FirstProject;
	
	@FindBy(xpath = "//table[@class='table table-striped arc-table']/tbody/tr[1]/td[2]/span")
	WebElement FirstSchoolProject;
	
	//@FindBy(xpath = "//*[@class='search_bar ng-scope']")
	@FindBy(xpath = "//*[@class='search_bar ng-scope']/*[@onclick='searchToggle();']/*[@fill]")
	WebElement SearchIcon;
	
	@FindBy(xpath = "//input[@id='search-input']")
	WebElement SearchProjectTextBox;
	
	
	@FindBy(xpath = "//table[@class='table table-striped table-hover table-project-lists'][1]/tbody/tr/td[2]")
	WebElement SearchedProject;
	
	
	
	public boolean CheckProjectLabel()
	{
		return ProjectLabel.isDisplayed();
	}
	
	public ProjectPageObjects()
	{
		PageFactory.initElements(driver,this);
	}
	
	public int CheckNumberOfProjects()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> AllProjects= driver.findElements((By.xpath("//table[@class='table table-striped arc-table']//child::tr")));
		return AllProjects.size();
	}
	
	public BuildingPageObject clickOnFirstProject()
	{
		waithelper.WaitForElementClickable(BuildingMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		BuildingMenu.click();
		waithelper.WaitForElementClickable(FirstProject, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		FirstProject.click();
		return new BuildingPageObject();
	}
	
	public SchoolPageObject clickOnFirstSchool()
	{
		waithelper.WaitForElementClickable(SchoolMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		SchoolMenu.click();
		FirstSchoolProject.click();
		return new SchoolPageObject();
	}
	
	public BuildingPageObject SearchAndClickOnProject(String ProjectID)
	{
		log.info("SearchAndClickOnProject method started for Building Project---- "+ProjectID+"  .........");
		CommonMethod.switchToDefaultContent();
		if(!SearchProjectTextBox.isDisplayed())
			actionhelper.mouseOverElementAndClick(SearchIcon);
		SearchProjectTextBox.clear();
		SearchProjectTextBox.sendKeys(ProjectID);
		waithelper.waitForElement(SearchedProject, Integer.parseInt(prop.getProperty("explicitTime")), 1);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(SearchedProject, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		SearchedProject.click();
		log.info("SearchAndClickOnProject method ends for Building Project---- "+ProjectID+"  .........");
		return new BuildingPageObject();
	}
	
	public SchoolPageObject SearchAndClickOnSchoolProject(String ProjectID)
	{
		log.info("SearchAndClickOnProject method started for School Project---- "+ProjectID+"  .........");
		CommonMethod.switchToDefaultContent();
		if(!SearchProjectTextBox.isDisplayed())
			actionhelper.mouseOverElementAndClick(SearchIcon);
		//actionhelper.mouseOverElementAndClick(SearchIcon);
		SearchProjectTextBox.clear();
		SearchProjectTextBox.sendKeys(ProjectID);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(SearchedProject, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		SearchedProject.click();
		log.info("SearchAndClickOnProject method ends for School Project---- "+ProjectID+"  .........");
		return new SchoolPageObject();
	}
	
	public CityPageObject SearchAndClickOnCityProject(String ProjectID)
	{
		log.info("SearchAndClickOnProject method started for City Project---- "+ProjectID+"  .........");
		CommonMethod.switchToDefaultContent();
		if(!SearchProjectTextBox.isDisplayed())
			actionhelper.mouseOverElementAndClick(SearchIcon);
		//actionhelper.mouseOverElementAndClick(SearchIcon);
		SearchProjectTextBox.clear();
		SearchProjectTextBox.sendKeys(ProjectID);
		waithelper.waitForElement(SearchedProject, Integer.parseInt(prop.getProperty("explicitTime")), 1);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(SearchedProject, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		SearchedProject.click();
		log.info("SearchAndClickOnProject method ends for City Project---- "+ProjectID+"  .........");
		return new CityPageObject();
	}
	
	public TransitPageObject SearchAndClickOnTransitProject(String ProjectID)
	{
		log.info("SearchAndClickOnProject method started for Transit Project---- "+ProjectID+"  .........");
		CommonMethod.switchToDefaultContent();
		if(!SearchProjectTextBox.isDisplayed())
			actionhelper.mouseOverElementAndClick(SearchIcon);
		//actionhelper.mouseOverElementAndClick(SearchIcon);
		SearchProjectTextBox.clear();
		SearchProjectTextBox.sendKeys(ProjectID);
		waithelper.waitForElement(SearchedProject, (Integer.parseInt(prop.getProperty("explicitTime"))));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(SearchedProject, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		SearchedProject.click();
		log.info("SearchAndClickOnProject method ends for Transit Project---- "+ProjectID+"  .........");
		return new TransitPageObject();
	}
	
	public CommunitiesPageObject SearchAndClickOnCommunitiesProject(String ProjectID)
	{
		log.info("SearchAndClickOnProject method started for Communities Project---- "+ProjectID+"  .........");
		CommonMethod.switchToDefaultContent();
		if(!SearchProjectTextBox.isDisplayed())
			actionhelper.mouseOverElementAndClick(SearchIcon);
		//actionhelper.mouseOverElementAndClick(SearchIcon);
		SearchProjectTextBox.clear();
		SearchProjectTextBox.sendKeys(ProjectID);
		waithelper.waitForElement(SearchedProject, (Integer.parseInt(prop.getProperty("explicitTime"))));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(SearchedProject, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		SearchedProject.click();
		log.info("SearchAndClickOnProject method ends for Communities Project---- "+ProjectID+"  .........");
		return new CommunitiesPageObject();
	}
	
	public ParkingPageObject SearchAndClickOnParkingProject(String ProjectID)
	{
		log.info("SearchAndClickOnProject method started for Parking Project---- "+ProjectID+"  .........");
		CommonMethod.switchToDefaultContent();
		if(!SearchProjectTextBox.isDisplayed())
			actionhelper.mouseOverElementAndClick(SearchIcon);
		//actionhelper.mouseOverElementAndClick(SearchIcon);
		SearchProjectTextBox.clear();
		SearchProjectTextBox.sendKeys(ProjectID);
		waithelper.waitForElement(SearchedProject, (Integer.parseInt(prop.getProperty("explicitTime"))));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waithelper.WaitForElementClickable(SearchedProject, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		SearchedProject.click();
		log.info("SearchAndClickOnProject method ends for Parking Project---- "+ProjectID+"  .........");
		return new ParkingPageObject();
	}

}
