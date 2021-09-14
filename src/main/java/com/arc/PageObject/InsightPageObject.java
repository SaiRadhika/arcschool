package com.arc.PageObject;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class InsightPageObject extends BaseClass {
	private static Logger log = LoggerHelper.getLogger(InsightPageObject.class);
	
	@FindBy(xpath = "//div[@class='options_header']/div[text()='Markets']")
	WebElement MarketsMenu;
	
	@FindBy(xpath = "//div[@class='options_header']/div[text()='Models']")
	WebElement ModelsMenu;
	
	@FindBy(xpath = "(//span[@class='ml10' and text()='Reductions'])[2]")
	WebElement ReductionsSubMenu;
	
	@FindBy(xpath = "(//span[@class='ml10' and text()='Strategies'])[2]")
	WebElement StrategiesSubMenu;
	
	@FindBy(xpath = "//div[@class='dropdown zipcode']/input")
	WebElement ZipCodeTextBox;
	
	@FindBy(xpath = "//div[@class='dropdown']/button")
	WebElement MileageButton;
	
	@FindBy(xpath = "//*[@id='search_overview']")
	WebElement SearchButton;
	
	@FindBy(xpath = "//h1[@class='fw-500 mt0 fs40 ng-binding']")
	WebElement NumberOfProjects;
	
	
	
	public InsightPageObject() {
		PageFactory.initElements(driver, this);
	}
	public int SearchInsightProject()
	{
		log.info("SearchInsightProject method starts here...");
		waithelper.WaitForElementClickable(ZipCodeTextBox, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		
		 try {
			Thread.sleep(8000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		 
		int ProjectCount=Integer.parseInt(NumberOfProjects.getText());
		log.info("Number of Project before searching is ---"+ProjectCount);
		ZipCodeTextBox.clear();
		ZipCodeTextBox.sendKeys(data.getCellData("Reboot", 16, 2));
		String mileage=data.getCellData("Reboot", 17, 2);
		String path="//div[@class='dropdown open']/ul/li/a[text()='"+mileage+"']";
		
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		MileageButton.click();
		driver.findElement(By.xpath(path)).click();
		waithelper.WaitForElementClickable(SearchButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		SearchButton.click();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ProjectCount=Integer.parseInt(NumberOfProjects.getText());
		log.info("Number of Project after searching is ---"+ProjectCount);	
		log.info("SearchInsightProject method ends here...");
		return ProjectCount;
	}
	
	
	public int SearchReductionsModelsProject()
	{
		log.info("SearchReductionsModelsProject method starts here...");
		List<WebElement> TableRows = driver.findElements(By.xpath("//*[@class='models_list_row']"));
		int totalRows = TableRows.size();
		log.info("Total number of records is ---"+totalRows);
		boolean matched=false;
		String path="";
		int MatchedRow=0;
		for (int i=2;i<=totalRows+1;i++)
		{
			path = "//div[@class='models_list']/div["+i+"]/div[1]/div[1]/span[1]";
			String CurrentModelId = driver.findElement(By.xpath(path)).getText();
			String ExpModelId = data.getCellData("Reboot", 18, 2);
			log.info("CurrentModelId is  ---"+CurrentModelId+"   and Expected Model ID is----"+ExpModelId);
			if(CurrentModelId.equalsIgnoreCase(ExpModelId))
			{
				matched=true;
				MatchedRow=i;
				log.info("ModelID is matched here.. exiting from the loop..");
				break;
			}
		}
		
		if(matched)
		{
			driver.findElement(By.xpath(path)).click();
			driver.findElement(By.xpath("//div[@class='models_list']/div["+MatchedRow+"]/div[2]/div[2]/div[2]")).click();
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h3[text()='Reductions']")), Integer.parseInt(prop.getProperty("explicitTime")), 2);
			waithelper.WaitForElementClickable(ZipCodeTextBox, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			 try {
					Thread.sleep(8000);
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			ZipCodeTextBox.clear();
			ZipCodeTextBox.sendKeys(data.getCellData("Reboot", 16, 2));
			String mileage=data.getCellData("Reboot", 17, 2);
			path="//div[@class='dropdown open']/ul/li/a[text()='"+mileage+"']";
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			MileageButton.click();
			driver.findElement(By.xpath(path)).click();
			waithelper.WaitForElementClickable(SearchButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			SearchButton.click();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String ResultText = driver.findElement(By.xpath("//*[@class='line_height_20 mb15 fs15']/span")).getText();
			log.info("Text shown is --"+ResultText);
			String Result[]=ResultText.split("\\s+");
			log.info("Total number of Projects showing is --"+Result[0]);
			log.info("SearchReductionsModelsProject method ends here...");
			return Integer.parseInt(Result[0]);
		}
		else
		{
			log.info("ModelID is not matching here.. ");
			log.info("SearchReductionsModelsProject method ends here...");
			return 0;
		}
			
		
	}
	
	
	public int SearchStrategiesModelsProject()
	{
		log.info("SearchReductionsModelsProject method starts here...");
		List<WebElement> TableRows = driver.findElements(By.xpath("//*[@class='models_list_row']"));
		int totalRows = TableRows.size();
		log.info("Total number of records is ---"+totalRows);
		boolean matched=false;
		String path="";
		int MatchedRow=0;
		for (int i=2;i<=totalRows+1;i++)
		{
			path = "//div[@class='models_list']/div["+i+"]/div[1]/div[1]/span[1]";
			String CurrentModelId = driver.findElement(By.xpath(path)).getText();
			String ExpModelId = data.getCellData("Reboot", 18, 2);
			log.info("CurrentModelId is  ---"+CurrentModelId+"   and Expected Model ID is----"+ExpModelId);
			if(CurrentModelId.equalsIgnoreCase(ExpModelId))
			{
				matched=true;
				MatchedRow=i;
				log.info("ModelID is matched here.. exiting from the loop..");
				break;
			}
		}
		
		if(matched)
		{
			driver.findElement(By.xpath(path)).click();
			driver.findElement(By.xpath("//div[@class='models_list']/div["+MatchedRow+"]/div[2]/div[2]/div[2]")).click();
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h3[text()='Reductions']")), Integer.parseInt(prop.getProperty("explicitTime")), 2);
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			ClickOnStrategiesSubMenu();
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			waithelper.WaitForElementClickable(ZipCodeTextBox, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			ZipCodeTextBox.clear();
			ZipCodeTextBox.sendKeys(data.getCellData("Reboot", 16, 2));
			String mileage=data.getCellData("Reboot", 17, 2);
			path="//div[@class='dropdown open']/ul/li/a[text()='"+mileage+"']";
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			MileageButton.click();
			driver.findElement(By.xpath(path)).click();
			waithelper.WaitForElementClickable(SearchButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			SearchButton.click();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String ResultText = driver.findElement(By.xpath("//*[@class='line_height_20 mb15 fs15']/span")).getText();
			log.info("Text shown is --"+ResultText);
			String Result[]=ResultText.split("\\s+");
			log.info("Total number of Projects showing is --"+Result[0]);
			log.info("SearchStrategiesModelsProject method ends here...");
			return Integer.parseInt(Result[0]);
		}
		else
		{
			log.info("ModelID is not matching here.. ");
			log.info("SearchStrategiesModelsProject method ends here...");
			return 0;
		}
			
		
	}
	
	public void ClickOnMarketMenu()
	{
		log.info("ClickOnMarketMenu method starts here...");
		waithelper.WaitForElementClickable(MarketsMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		MarketsMenu.click();
		waithelper.WaitForElementVisibleWithPollingTime(ZipCodeTextBox, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		log.info("ClickOnMarketMenu method ends here...");
	}
	
	public void ClickOnModelsMenu()
	{
		log.info("ClickOnModelsMenu method starts here...");
		waithelper.WaitForElementClickable(ModelsMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ModelsMenu.click();
		waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h3[text()='Models']")), Integer.parseInt(prop.getProperty("explicitTime")), 2);
		log.info("ClickOnModelsMenu method ends here...");
	}
	
	public void ClickOnReductionsSubMenu()
	{
		log.info("ClickOnReductionsSubMenu method starts here...");
		waithelper.WaitForElementClickable(ReductionsSubMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ReductionsSubMenu.click();
		waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h3[@class='fw-500 black-color pl15 mb25 pt5' and text()='Reductions']")), Integer.parseInt(prop.getProperty("explicitTime")), 2);
		log.info("ClickOnReductionsSubMenu method ends here...");
	}
	
	public void ClickOnStrategiesSubMenu()
	{
		log.info("ClickOnStrategiesSubMenu method starts here...");
		waithelper.WaitForElementClickable(StrategiesSubMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		StrategiesSubMenu.click();
		waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h3[@class='fw-500 black-color pl15 mb25 pt5' and text()='Strategies']")), Integer.parseInt(prop.getProperty("explicitTime")), 2);
		log.info("ClickOnStrategiesSubMenu method ends here...");
	}
	
}
