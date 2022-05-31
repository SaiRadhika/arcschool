package com.arc.PageObject.Project;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class SchoolFinancialModelPageObject extends BaseClass {
	private static Logger log = LoggerHelper.getLogger(SchoolFinancialModelPageObject.class);

	

	@FindBy(xpath = "//h1[@class='page-title ng-scope']/span)")
	WebElement FinancialModelText;	
	
	@FindBy(xpath =  "//li[@ng-click=\"toggleTab('Current Models')\"]")
	WebElement CurrentModelTab;
	
	@FindBy(xpath =  "//li[@ng-click=\"toggleTab('Past Models')\"]")
	WebElement PastModelTab;	
	
	@FindBy(xpath = "//div[@class='autocase_banner col-md-12 mb24']")
	WebElement Autocase;
	
	@FindBy(xpath = "//div[@class='mt15 mb16 fs16 line_height_24 ng-scope']")
	WebElement FreeAutocasePerformanceReport;
	
	@FindBy(xpath = "//main[@role='main']//nav//div//h4")
	WebElement CreateCostBenefitModel;
	
	@FindBy(xpath ="//div[@ng-click='verifyDetails()']//span")
	WebElement ClickModelType;
		
	@FindBy(xpath="//span[@style='position: relative;top: -15px;']")
	WebElement SubscribeToArcperformanceText;
	
	@FindBy(xpath= "//button[@ng-click='puchaseSubs()']")
	WebElement PurchaseSubscription;
	
	@FindBy(xpath ="//(//li[@ng-if='current_status == 'active' || current_status == 'expired' || current_status == 'cancelled_active'\'])[1]")
    WebElement Subscription;

	
	
	
	
	
	
	
	
	
	
	public SchoolFinancialModelPageObject() {
		PageFactory.initElements(driver, this);
	}
	
	public String FinancialModelHeaderShowing() {
		log.info("CheckFinancialModelHeaderShowing method starts here...");
		try {
			waithelper.WaitForElementVisibleWithPollingTime(FinancialModelText,
					Integer.parseInt(prop.getProperty("explicitTime")), 2);

			log.info("FinancialModelText.getText() value is ---- " + FinancialModelText.isDisplayed());
			log.info("CheckFinancialModelHeaderShowing method ends here...");
			return FinancialModelText.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("CheckOverviewHeaderShowing method ends here...");
		return null;

	}

	public boolean FinancialModel_Texts() {
		boolean CurrentModelflag = false;
		boolean PastModelflag = false;
		boolean Subscriptionflag = false;
		boolean Autocaseflag = false;
		boolean FreeAutocasePerformanceReportflag = false;
		boolean SubscribeToArcperformanceflag = false;
		CurrentModelflag = CurrentModelTab.isDisplayed();
		PastModelflag = PastModelTab.isDisplayed();
		Subscriptionflag = Subscription.isDisplayed();
		Autocaseflag = Autocase.isDisplayed();
		FreeAutocasePerformanceReportflag = FreeAutocasePerformanceReport.isDisplayed();
		SubscribeToArcperformanceflag = SubscribeToArcperformanceText.isDisplayed();
		log.info("CurrentModelflag value is :" +CurrentModelflag);
		log.info ("PastModelflag value is : " +PastModelflag);
		log.info ("Subscriptionflag is : " +Subscriptionflag);
		log.info("Autocaseflag value is :"+Autocaseflag);
		log.info("FreeAutocasePerformanceReportflag value is :"+FreeAutocasePerformanceReportflag);
		log.info("SubscribeToArcperformanceflag value is :"+SubscribeToArcperformanceflag);
		if((CurrentModelflag) && (PastModelflag) && (Subscriptionflag) && (Autocaseflag) && (FreeAutocasePerformanceReportflag) && (SubscribeToArcperformanceflag)) {
		return true;
		}
		else {
		return false;
		}
	
	}
	
}

