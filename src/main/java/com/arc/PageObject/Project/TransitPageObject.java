package com.arc.PageObject.Project;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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
	WebElement UploadSuccessMsg;

	/*
	 * @FindBy(
	 * xpath="//table[@class='table table-striped table-hover']/tbody/tr/td[3]/a/span"
	 * ) List<WebElement> ActionNames;
	 */

	@FindBy(xpath = "//form[@name='Fileform']/p/a")
	WebElement DownloadButton;

	@FindBy(xpath = "(//*[text()='Upload'])[1]")
	WebElement UploadButton;

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

	public void ClickonDownLoadButton() {

		try {

			JSHelper.clickElement(DownloadButton);		
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ClickonUpLoadButton() {

		try {

			UploadButton.click();

			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean uploadStatus() {
		waithelper.WaitForElementVisibleWithPollingTime(UploadSuccessMsg,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			boolean flag = UploadSuccessMsg.isDisplayed();
			return flag;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}
}
