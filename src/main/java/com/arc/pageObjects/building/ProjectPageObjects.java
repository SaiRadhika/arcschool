package com.arc.pageObjects.building;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.arc.testBase.BaseClass;

public class ProjectPageObjects extends BaseClass {
	
	@FindBy(xpath="//table[@class='table table-striped arc-table']//child::tr")
	WebElement ProjectRows;
	
	@FindBy(xpath="//*[@id=\"myproject_body\"]/nav/div/div[1]/h3")
	WebElement ProjectLabel;
	
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

}
