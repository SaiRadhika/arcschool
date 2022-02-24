package com.arc.testCases;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test1 {
	File folder;
	WebDriver driver;
	@BeforeMethod
	@SuppressWarnings("deprecation")
	public void setup()
	{
		
		folder=new File(UUID.randomUUID().toString());
	
	
	System.out.println(System.getProperty("user.dir") + "\\DriverFiles\\chromedriver.exe");
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\DriverFiles\\chromedriver.exe");
	ChromeOptions options=new ChromeOptions();
	
	Map<String,Object> Pref=new HashMap<String, Object>(); 
	
	Pref.put("profile.default_content_settings.popus",0);
	Pref.put("download.default_directory",folder.getAbsolutePath());
	
	options.setExperimentalOption("prefs", Pref);
	DesiredCapabilities cap=DesiredCapabilities.chrome();
	cap.setCapability(ChromeOptions.CAPABILITY, options);
	
	driver = new ChromeDriver(cap);
	//driver=new ChromeDriver();
	
	}
	
	
	
	@Test
	public void downloadTest() throws InterruptedException
	{
		driver.get("http://the-internet.herokuapp.com/download");
		driver.findElement(By.xpath("//a[@href='download/logo.png']")).click();
		Thread.sleep(2000);
		File[] ListOfFiles = folder.listFiles();
		// make sure the directory is not empty
		if(ListOfFiles.length !=0)
		{
			for(File file:ListOfFiles)
			{
				//Assert.assertEquals(file.length(), is(not((long)0)));
				Assert.assertTrue(file.length()>0);
			}
		}
	}	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		for(File file:folder.listFiles())
		{
			file.delete();
		}
		folder.delete();
	}

}
