package com.arc.PageObject;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.arc.PageObject.Project.ProjectPageObjects;
import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class HomePageObjects extends BaseClass {
	private static Logger log = LoggerHelper.getLogger(HomePageObjects.class);

	@FindBy(xpath = "//*[@href='/app/projects/my-projects/?project-type=all' and text()='Projects']")
	WebElement ProjectHeader;

	@FindBy(xpath = "//span[ text()='Insight']")
	WebElement InsightMenu;

	@FindBy(xpath = "//*[@class='insight_login modal fade in']")
	WebElement InsightModelWindow;

	@FindBy(xpath = "//*[@class='insight_login modal fade in']/div/div/div[2]/form/div[3]/div/input")
	WebElement InsightLoginTextBox;

	@FindBy(xpath = "//*[@class='insight_login modal fade in']/div/div/div[2]/form/div[4]/div/input")
	WebElement InsightPassTextBox;

	@FindBy(xpath = "//*[@class='insight_login modal fade in']/div/div/div[2]/form/div[5]/div/button[text()='Login']")
	WebElement InsightLoginButton;

	@FindBy(xpath = "//*[@class='insight_login modal fade in']/div/div/div[2]/form/div[5]/div/button[text()='Close']")
	WebElement InsightCloseButton;

	@FindBy(xpath = "//body/div[@id='app']/nav[1]/div[1]/div[1]/div[1]/div[2]/span[1]")
	WebElement BuildingSubMenu;

	@FindBy(xpath = "(//*[@class='ml10' and text()='Cities'])[1]")
	WebElement CitiesSubMenu;

	@FindBy(xpath = "(//*[@class='ml10' and text()='Communities'])[1]")
	WebElement CommunitiesSubMenu;
	
	@FindBy(xpath = "//table[@class='table table-striped arc-table']//child::tr[1]/td[3]/div/span")
	WebElement BuildingName;

	@FindBy(xpath = "(//*[text()='Home'])[1]")
	WebElement HomeHeader;

	@FindBy(xpath = "//*[@id='content']/main/nav/div/div[1]/h3")
	WebElement HomePageLabel;

	@FindBy(xpath = "//*[@class='user cursor-pointer icon dropdown-toggle ng-scope']")
	WebElement ProfileIcon;

	@FindBy(xpath = "//*[@class='user-dropdown dropdown-menu left']/li[4]")
	WebElement ProfileBillingMenu;

	@FindBy(xpath = "//ul[@class='user-dropdown dropdown-menu left']/li/div")
	WebElement ProfileUserName;

	@FindBy(xpath = "//*[@class='user-dropdown dropdown-menu left']/li[5]")
	WebElement ProfileSignOut;

	@FindBy(xpath = "//*[text()='Billing & Payments']")
	WebElement BillingAndPaymentsTab;

	@FindBy(xpath = "//a[text()='Download']")
	WebElement Downloadbutton;

	@FindBy(xpath = "//*[contains(text(),'Download invoice')]")
	WebElement DownloadInvoice;

	@FindBy(xpath = "//*[contains(text(),'Download receipt')]")
	WebElement DownloadReceipt;

	@FindBy(xpath = "//span[@class='close']")
	WebElement CloseSearchTextboxIcon;

	@FindBy(xpath = "//*[text()='Add a Project']")
	WebElement AddAProjectButton;

	@FindBy(xpath = "(//*[name()='svg']//*[local-name()='circle' ])[2]")
	WebElement CircularLoader;
	
	@FindBy(xpath = "//input[@id='search-input']")
	WebElement SearchProjectTextBox;

	@FindBy(xpath = "(//*[@class='ml10' and text()='Parking'])[1]")
	WebElement ParkingSubMenu;
	
	@FindBy(xpath = "(//*[@class='ml10' and text()='Transit'])[1]")
	WebElement TransitSubMenu;

	
	public boolean CheckHomePageLabel() {
		try {
			return HomePageLabel.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public HomePageObjects() {
		PageFactory.initElements(driver, this);
	}

	public String checkHomePageTitle() {
		return driver.getTitle();
	}

	// This method click on Add a Project from RHS and returns the Project
	// Registration page.

	public ProjectRegistrationPageObject ClickOnAddAProjectButton() {
		try {
			AddAProjectButton.click();
			return new ProjectRegistrationPageObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ProjectPageObjects clickOnProject() {
		ProjectHeader.click();
		// CommonMethod.waitUntilLoadElement();
		return new ProjectPageObjects();
	}

	public InsightPageObject clickOnInsight() {
		log.info("clickOnInsight method started....");
		// CommonMethod.switchToDefaultContent();
		InsightMenu.click();
		CommonMethod.waitUntilLoadElement();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("clickOnInsight method ends here....");
		return new InsightPageObject();
	}

	public InsightPageObject LoginToInsight() {
		log.info("LoginToInsight method started....");
		boolean flag = false;
		CommonMethod.switchToDefaultContent();
		InsightMenu.click();
		waithelper.WaitForElementVisibleWithPollingTime(InsightModelWindow,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InsightLoginTextBox.sendKeys(prop.getProperty("InsightUser"));
		InsightPassTextBox.sendKeys(prop.getProperty("InsightPassword"));
		waithelper.WaitForElementClickable(InsightLoginButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		InsightLoginButton.click();
		CommonMethod.waitUntilLoadElement();
		try {
			waithelper.WaitForElementVisibleWithPollingTime(
					driver.findElement(By.xpath("//h3[@class='fw-500 line_height_32 mt24 mb24']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			Thread.sleep(8000);
			flag = driver.findElement(By.xpath("//h3[@class='fw-500 line_height_32 mt24 mb24']")).isDisplayed();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.info("LoginToInsight method ends here....");
		if (flag)
			return new InsightPageObject();
		else
			return null;

	}

	public void closeInsightModelWindow() {
		try {
			if (InsightModelWindow.isDisplayed()) {
				InsightCloseButton.click();
				log.info("Insight Model Window remains showing.. now closing it");
			}
		} catch (Exception e) {
			log.info("Unable to close Insight Model Window");
			e.printStackTrace();
		}
	}

	public String getCurrentProfileUserName() {
		// CommonMethod.switchToDefaultContent();
		String username = null;
		try {
			ProfileIcon.click();
			Thread.sleep(3000);
			username = ProfileUserName.getText();
			ProfileUserName.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return username;
	}

	public void clickOnBuildingSubMenu() {

		waithelper.WaitForElementClickable(BuildingSubMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		BuildingSubMenu.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clickOnCitiesSubMenu() {
		waithelper.WaitForElementClickable(CitiesSubMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		CitiesSubMenu.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clickOnCommunitiesSubMenu() {
		waithelper.WaitForElementClickable(CommunitiesSubMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		CommunitiesSubMenu.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickOnParkingSubMenu() {
		waithelper.WaitForElementClickable(ParkingSubMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ParkingSubMenu.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setHomePageApplication() {

		//log.info(driver.getWindowHandle());
		//log.info(BaseWindow);
		if(!driver.getWindowHandle().equals(BaseWindow))
		{
			driver.close();
			driver.switchTo().window(BaseWindow);
		}
		try {
			CommonMethod.switchToDefaultContent();
			if (SearchProjectTextBox.isDisplayed())
				closeProjectSearchTextBox();
			HomeHeader.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void SwichToMainWindow()
	{
		log.info(driver.getWindowHandle());
		log.info(BaseWindow);
		if(!driver.getWindowHandle().equals(BaseWindow))
		{
			driver.close();
			driver.switchTo().window(BaseWindow);
		}
	}

	// This method closes the Project Searching text box

	public void closeProjectSearchTextBox() {
		try {
			// CommonMethod.switchToDefaultContent();
			CloseSearchTextboxIcon.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// This project clicks on Profile --> Sign out button and returns the page
	// title.

	public String checkSignOut() {
		waithelper.WaitForElementClickable(ProfileIcon, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ProfileIcon.click();
		waithelper.WaitForElementClickable(ProfileSignOut, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ProfileSignOut.click();
		waithelper.waitForElement(driver.findElement(By.xpath("//*[@id='login-box-trigger-lg']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 1);
		return driver.getTitle();

	}

	public boolean ProfileBillingInvoice() {
		log.info("ProfileBillingInvoice method started--------------");
		waithelper.WaitForElementClickable(ProfileIcon, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ProfileIcon.click();
		waithelper.WaitForElementClickable(ProfileBillingMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ProfileBillingMenu.click();
		CommonMethod.waitUntilLoadElement();
		waithelper.WaitForElementClickable(BillingAndPaymentsTab, Integer.parseInt(prop.getProperty("explicitTime")),
				2);
		BillingAndPaymentsTab.click();
		String MainHandle = driver.getWindowHandle();

		String RowPath = "//table[@class='table table-striped arc-table']/tbody/tr";
		List<WebElement> BillingTable = driver.findElements(By.xpath(RowPath));
		Iterator itr = BillingTable.iterator();
		String OrderTypePath;
		int rownum = 0;
		boolean MonthlyLinkExist = false;
		for (int i = 0; i < BillingTable.size(); i++) {
			rownum = i + 1;
			OrderTypePath = RowPath + "[" + rownum + "]/td[3]";
			String OrderType = driver.findElement(By.xpath(OrderTypePath)).getText();
			log.info(OrderTypePath + "......." + OrderType);
			if (OrderType.equals("Monthly")) {
				MonthlyLinkExist = true;
				log.info("Order Type monthly found--------------");
				break;
			}
		}
		if (MonthlyLinkExist) {
			driver.findElement(By.xpath(RowPath + "[" + rownum + "]/td[5]/a")).click();
			Set<String> Handles = driver.getWindowHandles();
			Iterator itr1 = Handles.iterator();
			while (itr1.hasNext()) {
				String childwindow = itr1.next().toString();
				if (!MainHandle.equals(childwindow)) {
					driver.switchTo().window(childwindow);
					log.info("Switched to another Tab--------------");
					try {
						DownloadInvoice.click();
						log.info("Downloading Invoice--------------");
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					try {
						DownloadReceipt.click();
						log.info("Downloading Receipt--------------");
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					driver.close();
					driver.switchTo().window(MainHandle);
					log.info("Switched to Main Tab--------------");
					break;

				}

			}

		}

		log.info("ProfileBillingInvoice method completed--------------");
		return MonthlyLinkExist;

	}

	public void clickOnTransitSubMenu() {
		waithelper.WaitForElementClickable(TransitSubMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		TransitSubMenu.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
