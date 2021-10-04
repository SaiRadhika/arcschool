package com.arc.testCases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class InsightPageTest extends BaseClass{

	private static Logger log = LoggerHelper.getLogger(InsightPageTest.class);
	
	
	
	@Test(dependsOnGroups = "LoginMethodTCGroup",groups={"Reboot"},dependsOnMethods = "com.arc.testCases.HomePageTest.Login_To_Insight", priority = 41,enabled = true, description = "Markets-->Check the project count showing after searching")
	public void Insight_Market_ProjectSearch() {
		log.info("Insight_Market_ProjectSearch method started here ... ");
		HomePage.setHomePageApplication();
		InsightPage=HomePage.clickOnInsight();
		InsightPage.ClickOnMarketMenu();
		int TotalProject=InsightPage.SearchInsightProject();
		if(TotalProject>10)
		{
			log.info("Insight_Market_ProjectSearch method ends here ");
			Assert.assertTrue(true);
		}
		else
		{
			log.info("Insight_Market_ProjectSearch method ends here ");
			Assert.assertTrue(false);
		}
		
		
	}
	
	@Test(dependsOnGroups = "LoginMethodTCGroup",groups={"Reboot"},dependsOnMethods = "com.arc.testCases.HomePageTest.Login_To_Insight", priority = 42, description = "Markets--> Validate by clicking on the Export button generates export")
	public void Insight_Markets_ProjectExport() {
		log.info("Insight_Markets_ProjectExport method started here ... ");
		HomePage.setHomePageApplication();
		InsightPage=HomePage.clickOnInsight();
		InsightPage.ClickOnMarketMenu();
		InsightPage.MarketsSearchProjectAndExport();
		long FileLength = CommonMethod.CheckDownloadedFile();
		if (FileLength > 0) {
			CommonMethod.DeleteAllFiles();
			DownloadFolder.delete();
			log.info("Insight_Markets_ProjectExport method completed ");
			Assert.assertTrue(FileLength > 0);
		} else {
			CommonMethod.DeleteAllFiles();
			DownloadFolder.delete();
			log.info("Insight_Markets_ProjectExport method completed ");
			Assert.assertTrue(false);
		}
	}
	@Test(dependsOnGroups = "LoginMethodTCGroup",groups={"Reboot"},dependsOnMethods = "com.arc.testCases.HomePageTest.Login_To_Insight", priority = 43, description = "Models--> Reductions --> Check the project count showing after searching")
	public void Insight_Models_Reductions_ProjectSearch() {
		log.info("Insight_Models_Reductions_ProjectSearch method started here ... ");
		HomePage.setHomePageApplication();
		InsightPage=HomePage.clickOnInsight();
		InsightPage.ClickOnModelsMenu();
		int TotalProject=InsightPage.SearchReductionsModelsProject();
		if(TotalProject>10)
		{
			log.info("Insight_Models_Reductions_ProjectSearch method ends here ");
			Assert.assertTrue(true);
		}
		else
		{
			log.info("Insight_Models_Reductions_ProjectSearch method ends here ");
			Assert.assertTrue(false);
		}
		
		
	}
	
	
	@Test(dependsOnGroups = "LoginMethodTCGroup",groups={"Reboot"},dependsOnMethods = "com.arc.testCases.HomePageTest.Login_To_Insight", priority = 44,enabled = true, description = "Models--> Reductions -->Under reductions- Validate zepi Score gets generated")
	public void Insight_Models_Reductions_zEPI_Score() {
		log.info("Insight_Models_Reductions_zEPI_Score method started here ... ");
		HomePage.setHomePageApplication();
		InsightPage=HomePage.clickOnInsight();
		InsightPage.ClickOnModelsMenu();
		Float ZepiScore=InsightPage.getReductions_zEPI_Score();
		if(ZepiScore>0)
		{
			log.info("Insight_Models_Reductions_zEPI_Score method ends here ");
			Assert.assertTrue(true);
		}
		else
		{
			log.info("Insight_Models_Reductions_zEPI_Score method ends here ");
			Assert.assertTrue(false);
		}
		
		
	}
	
	@Test(dependsOnGroups = "LoginMethodTCGroup",groups={"Reboot"},dependsOnMethods = "com.arc.testCases.HomePageTest.Login_To_Insight", priority = 45, description = "Models--> Reductions --> Validate by clicking on the Export button generates export")
	public void Insight_Models_Reductions_ProjectExport() {
		log.info("Insight_Models_Reductions_ProjectExport method started here ... ");
		HomePage.setHomePageApplication();
		InsightPage=HomePage.clickOnInsight();
		InsightPage.ClickOnModelsMenu();
		InsightPage.ExportReductionsModelsProject();
		long FileLength = CommonMethod.CheckDownloadedFile();
		if (FileLength > 0) {
			CommonMethod.DeleteAllFiles();
			DownloadFolder.delete();
			log.info("Insight_Models_Reductions_ProjectExport method completed ");
			Assert.assertTrue(FileLength > 0);
		} else {
			CommonMethod.DeleteAllFiles();
			DownloadFolder.delete();
			log.info("Insight_Models_Reductions_ProjectExport method completed ");
			Assert.assertTrue(false);
		}
		
	}
	
	
	@Test(dependsOnGroups = "LoginMethodTCGroup",groups={"Reboot"},dependsOnMethods = "com.arc.testCases.HomePageTest.Login_To_Insight", priority = 46, description = "Models--> Strategies --> Check the project count showing after searching")
	public void Insight_Models_Strategies_ProjectSearch() {
		log.info("Insight_Models_Strategies_ProjectSearch method started here ... ");
		HomePage.setHomePageApplication();
		InsightPage=HomePage.clickOnInsight();
		InsightPage.ClickOnModelsMenu();
		int TotalProject=InsightPage.SearchStrategiesModelsProject();
		if(TotalProject>10)
		{
			log.info("Insight_Models_Strategies_ProjectSearch method ends here ");
			Assert.assertTrue(true);
		}
		else
		{
			log.info("Insight_Models_Strategies_ProjectSearch method ends here ");
			Assert.assertTrue(false);
		}
		
		
	}
	
	
	
	@Test(dependsOnGroups = "LoginMethodTCGroup",groups={"Reboot"},dependsOnMethods = "com.arc.testCases.HomePageTest.Login_To_Insight", priority = 47, description = "Models--> Strategies --> Validate by clicking on the Export button generates export")
	public void Insight_Models_Strategies_ProjectExport() {
		log.info("Insight_Models_Strategies_ProjectExport method started here ... ");
		HomePage.setHomePageApplication();
		InsightPage=HomePage.clickOnInsight();
		InsightPage.ClickOnModelsMenu();
		InsightPage.ExportStrategiesModelsProject();
		long FileLength = CommonMethod.CheckDownloadedFile();
		if (FileLength > 0) {
			CommonMethod.DeleteAllFiles();
			DownloadFolder.delete();
			log.info("Insight_Models_Strategies_ProjectExport method completed ");
			Assert.assertTrue(FileLength > 0);
		} else {
			CommonMethod.DeleteAllFiles();
			DownloadFolder.delete();
			log.info("Insight_Models_Strategies_ProjectExport method completed ");
			Assert.assertTrue(false);
		}
		
	}
}
