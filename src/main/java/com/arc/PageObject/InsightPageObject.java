package com.arc.PageObject;

import java.text.DecimalFormat;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.arc.commonMethods.CommonMethod;
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

	@FindBy(xpath = "(//*[@id='search_overview'])[1]")
	WebElement SearchButton;

	@FindBy(xpath = "(//*[@id='search_overview'])[2]")
	WebElement ExportButton;

	@FindBy(xpath = "//h1[@class='fw-500 mt0 fs40 ng-binding']")
	WebElement NumberOfProjects;

	@FindBy(xpath = "(//*[text()='Manage' and @class='ml10'])[1]")
	WebElement ManageMenu;

	@FindBy(xpath = "(//a[@class='pl50' and contains(text(),'Model')])[2]")
	WebElement ModelSubMenu;

	@FindBy(xpath = "//*[@class='widget pl0']/div/ul/li[3]/span")
	WebElement ReductionView;

	@FindBy(xpath = "(//*[@class='pull-left mr10'])[1]/span[contains(@style,'rgb(223, 223, 223)')]")
	WebElement NetZeroToggleUnchecked;

	@FindBy(xpath = "(//*[@class='pull-left mr10'])[1]/span[contains(@style,'rgb(149, 195, 249)')]")
	WebElement NetZeroTogglechecked;

	public InsightPageObject() {
		PageFactory.initElements(driver, this);
	}

	public int SearchInsightProject() {
		log.info("SearchInsightProject method starts here...");
		waithelper.WaitForElementClickable(ZipCodeTextBox, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		CommonMethod.waitUntilLoadElement();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		int ProjectCount = Integer.parseInt(NumberOfProjects.getText());
		log.info("Number of Project before searching is ---" + ProjectCount);
		ZipCodeTextBox.clear();
		ZipCodeTextBox.sendKeys(data.getCellData("Reboot", 16, 2));
		String mileage = data.getCellData("Reboot", 17, 2);
		String path = "//div[@class='dropdown open']/ul/li/a[text()='" + mileage + "']";

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
		CommonMethod.waitUntilLoadElement();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ProjectCount = Integer.parseInt(NumberOfProjects.getText());
		log.info("Number of Project after searching is ---" + ProjectCount);
		log.info("SearchInsightProject method ends here...");
		return ProjectCount;
	}

	public int SearchReductionsModelsProject() {
		log.info("SearchReductionsModelsProject method starts here...");
		List<WebElement> TableRows = driver.findElements(By.xpath("//*[@class='models_list_row']"));
		int totalRows = TableRows.size();
		log.info("Total number of records is ---" + totalRows);
		boolean matched = false;
		String path = "";
		int MatchedRow = 0;
		for (int i = 2; i <= totalRows + 1; i++) {
			path = "//div[@class='models_list']/div[" + i + "]/div[1]/div[1]/span[1]";
			String CurrentModelId = driver.findElement(By.xpath(path)).getText();
			String ExpModelId = data.getCellData("Reboot", 18, 2);
			log.info("CurrentModelId is  ---" + CurrentModelId + "   and Expected Model ID is----" + ExpModelId);
			if (CurrentModelId.equalsIgnoreCase(ExpModelId)) {
				matched = true;
				MatchedRow = i;
				log.info("ModelID is matched here.. exiting from the loop..");
				break;
			}
		}

		if (matched) {
			driver.findElement(By.xpath(path)).click();
			driver.findElement(By.xpath("//div[@class='models_list']/div[" + MatchedRow + "]/div[2]/div[2]/div[2]"))
					.click();
			CommonMethod.waitUntilLoadElement();
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h3[text()='Reductions']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			waithelper.WaitForElementClickable(ZipCodeTextBox, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			ZipCodeTextBox.clear();
			ZipCodeTextBox.sendKeys(data.getCellData("Reboot", 16, 2));
			String mileage = data.getCellData("Reboot", 17, 2);
			path = "//div[@class='dropdown open']/ul/li/a[text()='" + mileage + "']";
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
			CommonMethod.waitUntilLoadElement();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String ResultText = driver.findElement(By.xpath("(//*[@class='line_height_20 mb15 fs15']/span)[1]"))
					.getText();
			log.info("Text shown is --" + ResultText);
			String Result[] = ResultText.split("\\s+");
			log.info("Total number of Projects showing is --" + Result[0]);
			log.info("SearchReductionsModelsProject method ends here...");
			return Integer.parseInt(Result[0]);
		} else {
			log.info("ModelID is not matching here.. ");
			log.info("SearchReductionsModelsProject method ends here...");
			return 0;
		}

	}

	public void ClickonModelInManage() {
		log.info("ClickonModelInManage method starts here.....");
		ModelSubMenu.click();
		CommonMethod.waitUntilLoadElement();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//h3[@class='fw-500 black-color pl32 mb15 pt5']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		log.info("ClickonModelInManage method ends here.....");
	}

	public boolean CheckNetZeroEnergyFlag() {
		log.info("CheckNetZeroEnergyFlag method starts here...");
		boolean flag = false;
		ReductionView.click();
		CommonMethod.waitUntilLoadElement();
		try {
			flag = NetZeroToggleUnchecked.isDisplayed();
			log.info("Net Zero flag is already unchecked..");
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (flag == false) {
			log.info("Net Zero flag is Checked..");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			NetZeroTogglechecked.click();
			CommonMethod.waitUntilLoadElement();

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			flag = NetZeroToggleUnchecked.isDisplayed();
			log.info("Now Net Zero flag is unchecked..");
		}
		log.info("CheckNetZeroEnergyFlag method ends here...");
		return flag;
	}

	public Float getReductions_zEPI_Score() {
		log.info("getReductions_zEPI_Score method starts here...");

		List<WebElement> TableRows = driver.findElements(By.xpath("//*[@class='models_list_row']"));
		int totalRows = TableRows.size();
		log.info("Total number of records is ---" + totalRows);
		boolean matched = false;
		String path = "";
		int MatchedRow = 0;
		for (int i = 2; i <= totalRows + 1; i++) {
			path = "//div[@class='models_list']/div[" + i + "]/div[1]/div[1]/span[1]";
			String CurrentModelId = driver.findElement(By.xpath(path)).getText();
			String ExpModelId = data.getCellData("Reboot", 18, 2);
			log.info("CurrentModelId is  ---" + CurrentModelId + "   and Expected Model ID is----" + ExpModelId);
			if (CurrentModelId.equalsIgnoreCase(ExpModelId)) {
				matched = true;
				MatchedRow = i;
				log.info("ModelID is matched here.. exiting from the loop..");
				break;
			}
		}

		if (matched) {
			driver.findElement(By.xpath(path)).click();
			driver.findElement(By.xpath("//div[@class='models_list']/div[" + MatchedRow + "]/div[2]/div[2]/div[2]"))
					.click();
			CommonMethod.waitUntilLoadElement();
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h3[text()='Reductions']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			waithelper.WaitForElementClickable(ZipCodeTextBox, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			ClickonModelInManage();
			CheckNetZeroEnergyFlag();
			ClickOnReductionsSubMenu();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			ZipCodeTextBox.clear();
			ZipCodeTextBox.sendKeys(data.getCellData("Reboot", 16, 2));
			String mileage = data.getCellData("Reboot", 17, 2);
			path = "//div[@class='dropdown open']/ul/li/a[text()='" + mileage + "']";
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
			CommonMethod.waitUntilLoadElement();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String ResultText = driver
					.findElement(
							By.xpath("//div[@class='reduction_category zepi_score_category p80_0px']/div[1]/div[2]"))
					.getText();
			log.info("Text shown is --" + ResultText);

			Float zepi = Float.parseFloat(ResultText);

			DecimalFormat df = new DecimalFormat("0.00");
			df.setMaximumFractionDigits(2);

			zepi = Float.parseFloat(df.format(zepi));
			return zepi;

		}
		return (float) 0.00;
	}

	public void ExportReductionsModelsProject() {
		log.info("ExportReductionsModelsProject method starts here...");
		List<WebElement> TableRows = driver.findElements(By.xpath("//*[@class='models_list_row']"));
		int totalRows = TableRows.size();
		log.info("Total number of records is ---" + totalRows);
		boolean matched = false;
		String path = "";
		int MatchedRow = 0;
		for (int i = 2; i <= totalRows + 1; i++) {
			path = "//div[@class='models_list']/div[" + i + "]/div[1]/div[1]/span[1]";
			String CurrentModelId = driver.findElement(By.xpath(path)).getText();
			String ExpModelId = data.getCellData("Reboot", 18, 2);
			log.info("CurrentModelId is  ---" + CurrentModelId + "   and Expected Model ID is----" + ExpModelId);
			if (CurrentModelId.equalsIgnoreCase(ExpModelId)) {
				matched = true;
				MatchedRow = i;
				log.info("ModelID is matched here.. exiting from the loop..");
				break;
			}
		}

		if (matched) {
			driver.findElement(By.xpath(path)).click();
			driver.findElement(By.xpath("//div[@class='models_list']/div[" + MatchedRow + "]/div[2]/div[2]/div[2]"))
					.click();
			CommonMethod.waitUntilLoadElement();
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h3[text()='Reductions']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
			waithelper.WaitForElementClickable(ZipCodeTextBox, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			ZipCodeTextBox.clear();
			ZipCodeTextBox.sendKeys(data.getCellData("Reboot", 16, 2));
			String mileage = data.getCellData("Reboot", 17, 2);
			path = "//div[@class='dropdown open']/ul/li/a[text()='" + mileage + "']";
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			MileageButton.click();
			driver.findElement(By.xpath(path)).click();
			waithelper.WaitForElementClickable(SearchButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			ExportButton.click();
			CommonMethod.waitUntilLoadElement();
			try {
				Thread.sleep(25000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			log.info("ExportReductionsModelsProject method ends here...");

		}

	}

	public void MarketsSearchProjectAndExport() {
		log.info("MarketsSearchProjectAndExport method starts here...");
		try {
			Thread.sleep(12000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		int ProjectCount = Integer.parseInt(NumberOfProjects.getText());
		log.info("Number of Project before searching is ---" + ProjectCount);
		ZipCodeTextBox.clear();
		ZipCodeTextBox.sendKeys(data.getCellData("Reboot", 16, 2));
		String mileage = data.getCellData("Reboot", 17, 2);
		String path = "//div[@class='dropdown open']/ul/li/a[text()='" + mileage + "']";

		try {
			Thread.sleep(8000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		MileageButton.click();
		driver.findElement(By.xpath(path)).click();
		waithelper.WaitForElementClickable(SearchButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ExportButton.click();
		CommonMethod.waitUntilLoadElement();
		try {
			Thread.sleep(25000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int SearchStrategiesModelsProject() {
		log.info("SearchReductionsModelsProject method starts here...");
		List<WebElement> TableRows = driver.findElements(By.xpath("//*[@class='models_list_row']"));
		int totalRows = TableRows.size();
		log.info("Total number of records is ---" + totalRows);
		boolean matched = false;
		String path = "";
		int MatchedRow = 0;
		for (int i = 2; i <= totalRows + 1; i++) {
			path = "//div[@class='models_list']/div[" + i + "]/div[1]/div[1]/span[1]";
			String CurrentModelId = driver.findElement(By.xpath(path)).getText();
			String ExpModelId = data.getCellData("Reboot", 18, 2);
			log.info("CurrentModelId is  ---" + CurrentModelId + "   and Expected Model ID is----" + ExpModelId);
			if (CurrentModelId.equalsIgnoreCase(ExpModelId)) {
				matched = true;
				MatchedRow = i;
				log.info("ModelID is matched here.. exiting from the loop..");
				break;
			}
		}

		if (matched) {
			driver.findElement(By.xpath(path)).click();
			driver.findElement(By.xpath("//div[@class='models_list']/div[" + MatchedRow + "]/div[2]/div[2]/div[2]"))
					.click();
			CommonMethod.waitUntilLoadElement();
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h3[text()='Reductions']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
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
			String mileage = data.getCellData("Reboot", 17, 2);
			path = "//div[@class='dropdown open']/ul/li/a[text()='" + mileage + "']";
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
			CommonMethod.waitUntilLoadElement();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String ResultText = driver.findElement(By.xpath("(//*[@class='line_height_20 mb15 fs15']/span)[1]"))
					.getText();
			log.info("Text shown is --" + ResultText);
			String Result[] = ResultText.split("\\s+");
			log.info("Total number of Projects showing is --" + Result[0]);
			log.info("SearchStrategiesModelsProject method ends here...");
			return Integer.parseInt(Result[0]);
		} else {
			log.info("ModelID is not matching here.. ");
			log.info("SearchStrategiesModelsProject method ends here...");
			return 0;
		}

	}

	public void ExportStrategiesModelsProject() {
		log.info("ExportStrategiesModelsProject method starts here...");
		List<WebElement> TableRows = driver.findElements(By.xpath("//*[@class='models_list_row']"));
		int totalRows = TableRows.size();
		log.info("Total number of records is ---" + totalRows);
		boolean matched = false;
		String path = "";
		int MatchedRow = 0;
		for (int i = 2; i <= totalRows + 1; i++) {
			path = "//div[@class='models_list']/div[" + i + "]/div[1]/div[1]/span[1]";
			String CurrentModelId = driver.findElement(By.xpath(path)).getText();
			String ExpModelId = data.getCellData("Reboot", 18, 2);
			log.info("CurrentModelId is  ---" + CurrentModelId + "   and Expected Model ID is----" + ExpModelId);
			if (CurrentModelId.equalsIgnoreCase(ExpModelId)) {
				matched = true;
				MatchedRow = i;
				log.info("ModelID is matched here.. exiting from the loop..");
				break;
			}
		}

		if (matched) {
			driver.findElement(By.xpath(path)).click();
			driver.findElement(By.xpath("//div[@class='models_list']/div[" + MatchedRow + "]/div[2]/div[2]/div[2]"))
					.click();
			CommonMethod.waitUntilLoadElement();
			waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h3[text()='Reductions']")),
					Integer.parseInt(prop.getProperty("explicitTime")), 2);
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
			String mileage = data.getCellData("Reboot", 17, 2);
			path = "//div[@class='dropdown open']/ul/li/a[text()='" + mileage + "']";
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			MileageButton.click();
			driver.findElement(By.xpath(path)).click();
			waithelper.WaitForElementClickable(SearchButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
			ExportButton.click();
			CommonMethod.waitUntilLoadElement();
			try {
				Thread.sleep(25000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		log.info("ExportStrategiesModelsProject method ends here...");
	}

	public void ClickOnMarketMenu() {
		log.info("ClickOnMarketMenu method starts here...");
		waithelper.WaitForElementClickable(MarketsMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		MarketsMenu.click();
		CommonMethod.waitUntilLoadElement();
		waithelper.WaitForElementVisibleWithPollingTime(ZipCodeTextBox,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		log.info("ClickOnMarketMenu method ends here...");
	}

	public void ClickOnModelsMenu() {
		log.info("ClickOnModelsMenu method starts here...");
		waithelper.WaitForElementClickable(ModelsMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ModelsMenu.click();
		CommonMethod.waitUntilLoadElement();
		waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//h3[text()='Models']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		log.info("ClickOnModelsMenu method ends here...");
	}

	public void ClickOnReductionsSubMenu() {
		log.info("ClickOnReductionsSubMenu method starts here...");
		waithelper.WaitForElementClickable(ReductionsSubMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		ReductionsSubMenu.click();
		CommonMethod.waitUntilLoadElement();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//h3[@class='fw-500 black-color pl15 mb25 pt5' and text()='Reductions']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		log.info("ClickOnReductionsSubMenu method ends here...");
	}

	public void ClickOnStrategiesSubMenu() {
		log.info("ClickOnStrategiesSubMenu method starts here...");
		waithelper.WaitForElementClickable(StrategiesSubMenu, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		StrategiesSubMenu.click();
		CommonMethod.waitUntilLoadElement();
		waithelper.WaitForElementVisibleWithPollingTime(
				driver.findElement(By.xpath("//h3[@class='fw-500 black-color pl15 mb25 pt5' and text()='Strategies']")),
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		log.info("ClickOnStrategiesSubMenu method ends here...");
	}

}
