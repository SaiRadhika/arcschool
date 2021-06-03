package com.arc.PageObject;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.arc.PageObject.Project.ProjectPageObjects;
import com.arc.testBase.BaseClass;

public class HomePageObjects extends BaseClass {

	@FindBy(xpath = "//*[@href='/app/projects/my-projects/?project-type=all' and text()='Projects']")
	WebElement ProjectHeader;

	@FindBy(xpath = "//body/div[@id='app']/nav[1]/div[1]/div[1]/div[1]/div[2]/span[1]")
	WebElement BuildingSubMenu;

	@FindBy(xpath = "//table[@class='table table-striped arc-table']//child::tr[1]/td[3]/div/span")
	WebElement BuildingName;

	@FindBy(xpath = "(//*[text()='Home'])[1]")
	WebElement HomeHeader;

	@FindBy(xpath = "//*[@id=\"content\"]/main/nav/div/div[1]/h3")
	WebElement HomePageLabel;

	@FindBy(xpath = "//*[@class='user cursor-pointer icon dropdown-toggle ng-scope']")
	WebElement ProfileIcon;

	@FindBy(xpath = "//*[@class='user-dropdown dropdown-menu left']/li[4]")
	WebElement ProfileBillingMenu;
	
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
	
	

	public boolean CheckHomePageLabel() {
		return HomePageLabel.isDisplayed();
	}

	public HomePageObjects() {
		PageFactory.initElements(driver, this);
	}

	public String checkHomePageTitle() {
		return driver.getTitle();
	}

	public ProjectPageObjects clickOnProject() {
		ProjectHeader.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ProjectPageObjects();
	}

	public void clickOnBuildingSubMenu() {
		BuildingSubMenu.click();

	}

	public void clickOnBuildingName() {
		BuildingName.click();
	}

	public void setHomePageApplication() {
		HomeHeader.click();
	}

	public void closeProjectSearchTextBox() {
		
		CloseSearchTextboxIcon.click();
	}
	
	public String checkSignOut() {
		ProfileIcon.click();
		ProfileSignOut.click();
		waithelper.waitForElement(driver.findElement(By.xpath("//*[@id='login-box-trigger-lg']")), Integer.parseInt(prop.getProperty("explicitTime")), 1);
		return driver.getTitle();
	}

	public boolean ProfileBillingInvoice() {
		ProfileIcon.click();
		ProfileBillingMenu.click();
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
			System.out.println(OrderTypePath + "......." + OrderType);
			if (OrderType.equals("Monthly")) {
				MonthlyLinkExist = true;
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

					try {
						DownloadInvoice.click();
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					try {
						DownloadReceipt.click();
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					driver.close();
					driver.switchTo().window(MainHandle);
					break;

				}

			}

		}

		return MonthlyLinkExist;

	}

}
