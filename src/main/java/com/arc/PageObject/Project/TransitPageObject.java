package com.arc.PageObject.Project;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
	private static Logger log = LoggerHelper.getLogger(TransitPageObject.class);

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

	@FindBy(xpath = "//*[@class='viewUpload laptop']")
	WebElement FileUploadButtonUsingComputer;

	@FindBy(xpath = "//div[@id='uploaded_files']/p/span")
	WebElement FileDeletebutton;

	@FindBy(xpath = "//span[@class='uploadLoaderSpinner ng-scope']")
	WebElement FileProcessing;

	@FindBy(xpath = "(//a[text()=' Team '])[1]")
	WebElement TeamSubmenu;

	@FindBy(xpath = "//form[@name='Fileform']/p/a")
	WebElement CreditFormDownloadButton;

	@FindBy(xpath = "(//*[text()='Upload'])[1]")
	WebElement CreditFormUploadButton;
	
	@FindBy(xpath = "//button[contains(text(),'CLOSE')][1]")
	WebElement TrailCloseButton;
	
	@FindBy(xpath = "//span[text()='Private']//following-sibling::div//span[contains(text(),'Yes')]/input")
	WebElement PrivateYesRadioButton;
	
	@FindBy(xpath = "(//a[contains(text(),'Prerequisites')])[1]")
	WebElement PrerequisitesSubmenu;
	
	@FindBy(xpath = "(//a[contains(text(),'Base Points')])[1]")
	WebElement BasePointSubmenu;
	
	@FindBy(xpath = "//a[normalize-space()='Credit Library']")
	WebElement CreditLibraryButton;
	
	@FindBy(xpath = "//a[normalize-space()='Resources']")
	WebElement ResourcesButton;
	
	@FindBy(xpath = "//div[@class='left-right-align ng-binding']")
	WebElement BuildingSetting;
	
	@FindBy(xpath = "//div[@class='meterList--wrapper']/div[1]/div[1]/span")
	WebElement MeterAndSurveyMiddleSection;
	
	public TransitPageObject() {
		PageFactory.initElements(driver, this);
	}

	public void ClickonAgreementInManage() {
		log.info("ClickonAgreementInManage method starts here ....");
		waithelper.WaitForElementClickable(ManageMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ManageMenu.click();
		waithelper.WaitForElementClickable(AgreementSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		AgreementSubmenu.click();
		CommonMethod.waitUntilLoadElement();
		log.info("ClickonAgreementInManage method ends here ....");

	}

	public void ClickonBillingInManage() {
		log.info("ClickonBillingInManage method starts here ....");
		waithelper.WaitForElementClickable(ManageMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ManageMenu.click();
		waithelper.WaitForElementClickable(BillingSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		BillingSubmenu.click();
		CommonMethod.waitUntilLoadElement();
		log.info("ClickonBillingInManage method ends here ....");
	}

	public void AllActionSubMenu() {
		log.info("AllActionSubMenu method starts here ....");
		waithelper.WaitForElementClickable(CreditActionSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		CreditActionSubmenu.click();
		waithelper.WaitForElementClickable(AllActionSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		AllActionSubmenu.click();
		log.info("AllActionSubMenu method ends here ....");
	}

	public void ClickonProjectInManage() {
		log.info("ClickonProjectInManage method starts here ....");
		waithelper.WaitForElementClickable(ManageMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ManageMenu.click();
		waithelper.WaitForElementClickable(ProjectSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ProjectSubmenu.click();
		CommonMethod.waitUntilLoadElement();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//span[@class='fw-semi-bold' and text()='Project']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		log.info("ClickonProjectInManage method ends here ....");
	}

	public void ClickonTeamInManage() {
		log.info("ClickonTeamInManage method starts here ....");
		waithelper.WaitForElementClickable(ManageMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ManageMenu.click();
		waithelper.WaitForElementClickable(TeamSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		TeamSubmenu.click();
		CommonMethod.waitUntilLoadElement();
		waithelper.waitForElement(driver.findElement(By.xpath("//span[text()='Team']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ClickonTeamInManage method starts here ....");

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

			waithelper.WaitForElementClickable(FileUploadButtonUsingComputer,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
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
		boolean flag = false;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement ele = driver.findElement(By.xpath("//*[text()='" + fname + "']"));
		if (ele.isDisplayed()) {
			FileDeletebutton.click();

			try {
				waithelper.WaitForElementInvisible(ele, 30, 2);
				flag = ele.isDisplayed();
				log.info(flag + "This is ele.isDisplayed() value;");

			} catch (StaleElementReferenceException e) {
				flag = false;
				log.info("=====================StaleElementReferenceException=====================");
				e.printStackTrace();

			} catch (NoSuchElementException e) {
				log.info("=====================NoSuchElementException=====================");
				flag = false;
			}
			log.info("ClickonFileDeleButton method ends here ...");
			if (flag == true) {
				return false;
			} else
				return true;
		}
		return false;

	}

	public boolean CheckFileUploadedStatus(String fname) {
		log.info("CheckFileUploadedStatus method starts here ...");
		try {
		WebElement ele = driver.findElement(By.xpath("//*[text()='" + fname + "']"));
		if (ele.isDisplayed()) 
		{
			log.info(" File is displaying ...");
			log.info("CheckFileUploadedStatus method ends with here true  ...");
			return true;
		}
			else 
				{
				log.info(" File is not displaying ...");
				log.info("CheckFileUploadedStatus method ends with here false  ...");
				return false;
				}
		}
		catch(NoSuchElementException e)
		{
			log.info("Unable to locate uploaded file...");
			log.info(e.getMessage());
			e.printStackTrace();
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
			log.info("Credit Form file path is --" + filePath);
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
			log.info("File uploading using computer path is --" + filePath);
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

	public void ClickonTrailCloseButton() {
		
		waithelper.WaitForElementVisibleWithPollingTime(TrailCloseButton,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		
		TrailCloseButton.click();
				
	}
	
	public String getProjectID(String PName) {

		try {
			return driver
					.findElement(
							By.xpath("//*[@class='page-controls navbar_info navbar-default']/div/div/div//div[1]/span"))
					.getText();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public boolean checkTransitProjectCreation(String PName) {

		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(
							By.xpath("//*[@class='page-controls navbar_info navbar-default']/div/div/div/h4")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			if (driver.findElement(By.xpath("//*[@class='page-controls navbar_info navbar-default']/div/div/div/h4"))
					.getText().contains(PName)) {
				System.out.println("Project Name showing---------" + driver
						.findElement(By.xpath("//*[@class='page-controls navbar_info navbar-default']/div/div/div/h4"))
						.getText());
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;

	}
	
	public boolean CheckProjectIsPrivateFlagUnderManage(String ProjectID) {
		
		try {
			String path = "(//*[text()='" + ProjectID + "'])[2]";
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath(path)),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			System.out
					.println("PrivateYesRadioButton.isSelected() value is ---- " + PrivateYesRadioButton.isSelected());
			return PrivateYesRadioButton.isSelected();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public void ClickOnCreditsTab() {
		CreditActionSubmenu.click();
	}
	
	public void PrerequistitesSubMenu() {
		log.info("PrerequistitesSubMenu method starts here ....");
		waithelper.WaitForElementClickable(CreditActionSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		CreditActionSubmenu.click();
		waithelper.WaitForElementClickable(PrerequisitesSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		PrerequisitesSubmenu.click();
		log.info("AllActionSubMenu method ends here ....");
	}
	
	public void BasePointSubMenu() {
		log.info("BasePointSubMenu method starts here ....");
		waithelper.WaitForElementClickable(CreditActionSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		CreditActionSubmenu.click();
		waithelper.WaitForElementClickable(BasePointSubmenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		BasePointSubmenu.click();
		log.info("BasePointSubMenu method ends here ....");
	}

	public boolean CheckCreditTabMenu() {
		log.info("CheckCreditTabMenu method starts here...........");

		String className = null;
		boolean flag = false;
		List<WebElement> allElement = driver
				.findElements(By.xpath("//div[@class='ng-scope']//div[@class='ng-scope']//ul[@id='sidebar-actions']"));
		for (WebElement element : allElement) {
			className = element.getText();
			System.out.println(className);
		}

		if (className.equals("All Actions\r\n" + "Prerequisites\r\n" + "Base Points\r\n"
				+ "My Actions\r\n")) {

			flag = true;
			
		}
		if (flag)
			log.info("CheckCreditTabMenu method ends here..........");
		else
			log.info("CheckCreditTabMenu method ends here..........");

		return flag;
	}

	public boolean CheckPrerequisitesCredits() {
		log.info("CheckPrerequisitesCredits method starts here...........");
		boolean flag = false;

		int expCredits = 10 ;
		WebElement table = driver.findElement(By.xpath("//table[@class='table table-striped table-hover']/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int Credits = rows.size();
		for(WebElement row : table.findElements(By.tagName("tr"))) {
		String CreditNames = row.getText();
		log.info("Credit Name -> "+CreditNames);
		}
		log.info("No. of credits are...... " + rows.size());
		if (Credits == expCredits) {
			flag = true;
		}
		if (flag) {
			log.info("Number of Prerequisites Credits equals to 10 ");
		} else {
			log.info("Number of Prerequisites Credits not equals to 10");
		}

		log.info("CheckPrerequisitesCredits method ends here...........");
		return flag;
	}
	
	public boolean CheckBasePointCredits() {
		log.info("CheckBasePointCredits method starts here...........");
		boolean flag = false;
		
		int expCredits = 23 ;
		WebElement table = driver.findElement(By.xpath("//table[@class='table table-striped table-hover']/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int Credits = rows.size();
		for(WebElement row : table.findElements(By.tagName("tr"))) {
		String CreditNames = row.getText();
		log.info("Credit Name -> "+CreditNames);
		}
		log.info("No. of credits are...... " + rows.size());
		if (Credits == expCredits) {
			flag = true;
		}
		if (flag) {
			log.info("Number of BasePoint Credits equals to 23 ");
		} else {
			log.info("Number of BasePoint Credits not equals to 10");
		}

		log.info("CheckBasePointCredits method ends here...........");
		return flag;
	}
	
	public boolean CheckAllActionsCredits() {
		log.info("CheckAllActionsCredits method starts here...........");
		boolean flag = false;
		
		int expCredits = 38 ;
		WebElement table = driver.findElement(By.xpath("//table[@class='table table-striped table-hover']/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int Credits = rows.size();
		for(WebElement row : table.findElements(By.tagName("tr"))) {
		String CreditNames = row.getText();
		log.info("Credit Name -> "+CreditNames);
		}
		log.info("No. of credits are...... " + rows.size());
		if (Credits == expCredits) {
			flag = true;
		}
		if (flag) {
			log.info("Number of All actions Credits equals to 23 ");
		} else {
			log.info("Number of All actions Credits not equals to 10");
		}

		log.info("CheckAllActionsCredits method ends here...........");
		return flag;
	}
	
	public boolean CheckCreditLibraryButton() {
		log.info("CheckCreditLibraryButton method starts here.........");
		String handle = driver.getWindowHandle();
		CreditLibraryButton.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		Set<String> handles = driver.getWindowHandles();
		if (handles.size() == 2) {
			for (String window : handles) {
				if (!handle.equals(window)) {
					driver.switchTo().window(window);
					String url = JSHelper.getCurrentURL();
					System.out.println("Second URL is ---------------" + url);
					if (url.contains("https://www.usgbc.org/credits/existing-buildings-retail-existing-buildings-schools-existing-buildings-hospitality-2?return=/credits")) {
						driver.close();
						driver.switchTo().window(handle);
						return true;
					} else
						return false;

				}
			}

		}
		return false;

	}
	
	public boolean CheckResourcesButton() {
		log.info("CheckResourcesButton method starts here........");
		String handle = driver.getWindowHandle();
		ResourcesButton.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		Set<String> handles = driver.getWindowHandles();
		if (handles.size() == 2) {
			for (String window : handles) {
				if (!handle.equals(window)) {
					driver.switchTo().window(window);
					String url = JSHelper.getCurrentURL();
					System.out.println("Second URL is ---------------" + url);
					if (url.contains("https://arcskoru.com/resources")) {
						driver.close();
						driver.switchTo().window(handle);
						return true;
					} else
						return false;

				}
			}

		}
		return false;
	}
	
	public boolean ClickOnBuildingSetting() {
		log.info("ClickOnBuildingSetting  method starts here.........");
		boolean BuldingSettingTab = false;
		ngWebDriver.waitForAngularRequestsToFinish();
		BuildingSetting.click();
		//ngWebDriver.waitForAngularRequestsToFinish();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonMethod.switchToDefaultContent();
		CommonMethod.switchToDataInputFrame();
		boolean MetersAndSurveyTab = MeterAndSurveyMiddleSection.isDisplayed();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By
						.xpath("//div[@class='meterNameInfo--wrapper pt5']/div[contains(text(),'Building Settings')]")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		BuldingSettingTab = driver
				.findElement(By
						.xpath("//div[@class='meterNameInfo--wrapper pt5']/div[contains(text(),'Building Settings')]"))
				.isDisplayed();
		log.info("MetersAndSurveyTab flag is --" + MetersAndSurveyTab);
		log.info("BuldingSettingTab flag is --" + BuldingSettingTab);
		if (BuldingSettingTab == true && MetersAndSurveyTab == true) {
			log.info("ClickOnBuildingSetting  method ends here with true .........");
			return true;
		} else {
			log.info("ClickOnBuildingSetting  method ends here with false.........");
			return false;
		}
	}
	
	
	
}
