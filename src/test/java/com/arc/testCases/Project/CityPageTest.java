package com.arc.testCases.Project;

import java.io.File;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.arc.commonMethods.CommonMethod;
import com.arc.commonMethods.LoggerHelper;
import com.arc.testBase.BaseClass;

public class CityPageTest extends BaseClass{

	
private static Logger log= LoggerHelper.getLogger(CityPageTest.class);
	
@Test(dependsOnGroups = "LoginMethodTCGroup", enabled = true, priority = 6)
public void City_Agreement_Display() {
		log.info("City_Agreement_Display method started ");
		HomePage.setHomePageApplication();
	    ProjectPage = HomePage.clickOnProject();
	    //BuildingPage=ProjectPage.clickOnFirstProject();
	    //System.out.println(data.getCellData("Reboot", 6, 2));
	    CityPage=ProjectPage.SearchAndClickOnCityProject(data.getCellData("Reboot", 6, 2));			
	    CityPage.ClickonAgreementInManage();
		HomePage.closeProjectSearchTextBox();
		boolean flag = CommonMethod.CheckAgreementDisplay();
		
		if(flag)
		{
			log.info("City_Agreement_Display method completed ");
			Assert.assertTrue(true);
		}
		else
		{
			log.info("City_Agreement_Display method completed ");
			Assert.assertTrue(false);
		}
}


@Test(dependsOnGroups = "LoginMethodTCGroup",dependsOnMethods = "City_Agreement_Display", enabled = true, priority = 6)
public void City_Agreement_Download() {
		log.info("City_Agreement_Download method started ");
		HomePage.setHomePageApplication();
	    ProjectPage = HomePage.clickOnProject();
	    //BuildingPage=ProjectPage.clickOnFirstProject();
	    //System.out.println(data.getCellData("Reboot", 0, 2));
	    CityPage=ProjectPage.SearchAndClickOnCityProject(data.getCellData("Reboot", 6, 2));			
	    CityPage.ClickonAgreementInManage();
		HomePage.closeProjectSearchTextBox();
		CommonMethod.ClikOnAgreementRegistrationDownloadLink();
		//BuildingPage.ClikOnAgreementDownloadLink();
		long FileLength = CommonMethod.CheckDownloadedFile();
		if(FileLength>0)
		{
			for(File file:DownloadFolder.listFiles())
			{
				file.delete();
			}
			DownloadFolder.delete();
			log.info("City_Agreement_Download method completed ");
			Assert.assertTrue(FileLength>0);
		}
		else
		{
			log.info("City_Agreement_Download method completed ");
			Assert.assertTrue(false);
		}
			
}


}
