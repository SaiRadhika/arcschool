package com.arc.PageObject.Project;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.arc.testBase.BaseClass;

public class TransitPageObject extends BaseClass {

	@FindBy(xpath = "(//*[text()='Manage' and @class='ml10'])[1]")
	WebElement ManageMenu;

	@FindBy(xpath = "(//a[text()=' Agreements '])[1]")
	WebElement AgreementSubmenu;

	@FindBy(xpath = "(//a[text()=' Billing '])[1]")
	WebElement BillingSubmenu;

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
	
	
	@FindBy(xpath = "//form[@name='Fileform']/p/a")
	WebElement CreditFormDownloadButton;

	@FindBy(xpath = "(//*[text()='Upload'])[1]")
	WebElement CreditFormUploadButton;

	public TransitPageObject() {
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

	

	public void AllActionSubMenu() {
		CreditActionSubmenu.click();
		AllActionSubmenu.click();
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

		boolean flag=false;
		
		WebElement ele=driver.findElement(By.xpath("//*[text()='"+fname+"']"));
		if(ele.isDisplayed())
			{
			FileDeletebutton.click();
			
			
			try {
				waithelper.WaitForElementInvisible(ele, 30, 2);
				flag=ele.isDisplayed();
				System.out.println(flag+"This is ele.isDisplayed() value;");
				System.out.println();
			}
			catch(StaleElementReferenceException e)
			{
				flag=false;
				System.out.println("=====================StaleElementReferenceException=====================");
				e.printStackTrace();
				
			}
			catch(NoSuchElementException e)
			{
				System.out.println("=====================NoSuchElementException=====================");
				flag=false;
			}
			if(flag==true)
			{
				return false;
			}
			else
				return true;
			}
		return false;
			
			/*try {
			if(FileDeletebutton.isDisplayed())
			return true;
			else
				return false;
			}
		
		catch(NoSuchElementException e)
		{
			
		}
		else
			return false;*/
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
