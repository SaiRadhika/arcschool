package com.arc.PageObject.Project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class TransitPageObject extends BaseClass {
	private static Logger log= LoggerHelper.getLogger(TransitPageObject.class);

	@FindBy(xpath = "(//*[text()='Manage' and @class='ml10'])[1]")
	WebElement ManageMenu;

	@FindBy(xpath = "(//a[text()=' Agreements '])[1]")
	WebElement AgreementSubmenu;

	@FindBy(xpath = "(//a[text()=' Billing '])[1]")
	WebElement BillingSubmenu;
	
	@FindBy(xpath = "(//a[text()=' Project '])[1]")
	WebElement ProjectSubmenu;

	@FindBy(xpath = "(//span[text()='Credits/Actions'])[1]")
	WebElement CreditActionSubmenu;

	@FindBy(xpath = "(//a[contains(text(),'All Actions')])[1]")
	WebElement AllActionSubmenu;

	@FindBy(xpath = "(//*[text()='Credit form successfully saved.'])[1]")
	WebElement CreditFormUploadSuccessMsg;
	
	@FindBy(xpath = "(//*[text()='File successfully uploaded.'])[1]")
	WebElement FileUploadSuccessMsg;

	/*
	 * @FindBy(
	 * xpath="//table[@class='table table-striped table-hover']/tbody/tr/td[3]/a/span"
	 * ) List<WebElement> ActionNames;
	 */

	@FindBy(xpath = "//*[@class='viewUpload laptop']")
	WebElement FileUploadButtonUsingComputer;
	
	@FindBy(xpath="//div[@id='uploaded_files']/p/span")
	WebElement FileDeletebutton;
	
	@FindBy(xpath="//span[@class='uploadLoaderSpinner ng-scope']")
	WebElement FileProcessing;
	
	@FindBy(xpath="(//a[text()=' Team '])[1]")
	WebElement TeamSubmenu;
	
	@FindBy(xpath = "//form[@name='Fileform']/p/a")
	WebElement CreditFormDownloadButton;

	@FindBy(xpath = "(//*[text()='Upload'])[1]")
	WebElement CreditFormUploadButton;

	public TransitPageObject() {
		PageFactory.initElements(driver, this);
	}

	public void ClickonAgreementInManage() {
		waithelper.WaitForElementClickable(ManageMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ManageMenu.click();
		waithelper.WaitForElementClickable(AgreementSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		AgreementSubmenu.click();

	}

	public void ClickonBillingInManage() {
		waithelper.WaitForElementClickable(ManageMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ManageMenu.click();
		waithelper.WaitForElementClickable(BillingSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		BillingSubmenu.click();

	}

	

	public void AllActionSubMenu() {
		waithelper.WaitForElementClickable(CreditActionSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		CreditActionSubmenu.click();
		waithelper.WaitForElementClickable(AllActionSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		AllActionSubmenu.click();
	}

	
	public void ClickonProjectInManage()
	{
		
			waithelper.WaitForElementClickable(ManageMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			ManageMenu.click();
			waithelper.WaitForElementClickable(ProjectSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			ProjectSubmenu.click();
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//span[@class='fw-semi-bold' and text()='Project']")), Integer.parseInt(prop.getProperty("explicitTime")), 2);
		
	}
	
	public void ClickonTeamInManage()
	{
		try {
			waithelper.WaitForElementClickable(ManageMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			ManageMenu.click();
			waithelper.WaitForElementClickable(TeamSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			TeamSubmenu.click();
		
			waithelper.waitForElement(driver.findElement(By.xpath("//span[text()='Team']")), Integer.parseInt(prop.getProperty("explicitTime")), 2);
			Thread.sleep(3000);
		}
		catch (Exception e) {
			e.printStackTrace();
			log.info("Unable to traverse Team Submenu");
		}
	}
	public boolean ClickonActionName(String Action) {
		boolean flag = false;
		List<WebElement> ActionNames = driver
				.findElements(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr/td[3]/a/span"));
		// ArrayList<String> AllNames=new ArrayList<String>();
		for (int i = 0; i < ActionNames.size(); i++) {
			int row = i + 1;
			if (ActionNames.get(i).getText().equals(Action)) {
				driver.findElement(By
						.xpath("//table[@class='table table-striped table-hover']/tbody/tr[" + row + "]/td[3]/a/span"))
						.click();
				flag = true;
				break;
			}
		}
		
		return flag;

	}

	public void ClickonCreditFormDownLoadButton() {

		try {

			JSHelper.clickElement(CreditFormDownloadButton);		
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ClickonCreditFormUpLoadButton() {

		try {

			CreditFormUploadButton.click();

			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ClickonFileUpLoadUsingComputerButton() {

		try {

			waithelper.WaitForElementClickable(FileUploadButtonUsingComputer, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			FileUploadButtonUsingComputer.click();
			JSHelper.clickElement(FileUploadButtonUsingComputer);
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean ClickonFileDeleButton(String fname) {
		log.info("ClickonFileDeleButton method starts here ...");
		boolean flag=false;
		
		WebElement ele=driver.findElement(By.xpath("//*[text()='"+fname+"']"));
		if(ele.isDisplayed())
			{
			FileDeletebutton.click();
			
			
			try {
				waithelper.WaitForElementInvisible(ele, 30, 2);
				flag=ele.isDisplayed();
				log.info(flag+"This is ele.isDisplayed() value;");
				
			}
			catch(StaleElementReferenceException e)
			{
				flag=false;
				log.info("=====================StaleElementReferenceException=====================");
				e.printStackTrace();
				
			}
			catch(NoSuchElementException e)
			{
				log.info("=====================NoSuchElementException=====================");
				flag=false;
			}
			log.info("ClickonFileDeleButton method starts here ...");
			if(flag==true)
			{
				return false;
			}
			else
				return true;
			}
		return false;
			
		
	}

	public boolean CreditFormuploadStatus() {
		waithelper.WaitForElementVisibleWithPollingTime(CreditFormUploadSuccessMsg,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			boolean flag = CreditFormUploadSuccessMsg.isDisplayed();
			return flag;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}
	
	public boolean CheckCreditFormupload(String filePath) {
		
		try {
			log.info("Credit Form file path is --"+filePath);
			waithelper.WaitForElementClickable(CreditFormUploadButton,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			
			driver.findElement(By.xpath("(//input[@type='file'])[2]")).sendKeys(filePath);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		waithelper.WaitForElementVisibleWithPollingTime(CreditFormUploadSuccessMsg,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			boolean flag = CreditFormUploadSuccessMsg.isDisplayed();
			return flag;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}
	
	
public boolean CheckFileUploadUsingComputer(String filePath) {
		
		try {
			log.info("File uploading using computer path is --"+filePath);
			waithelper.WaitForElementClickable(FileUploadButtonUsingComputer,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			
			driver.findElement(By.xpath("(//input[@type='file'])[1]")).sendKeys(filePath);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		waithelper.WaitForElementVisibleWithPollingTime(FileUploadSuccessMsg,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			boolean flag = FileUploadSuccessMsg.isDisplayed();
			Thread.sleep(3000);
			return flag;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}
	
	
	public boolean FileuploadStatus() {
		waithelper.WaitForElementVisibleWithPollingTime(FileUploadSuccessMsg,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			boolean flag = FileUploadSuccessMsg.isDisplayed();
			return flag;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}
	
	

}
