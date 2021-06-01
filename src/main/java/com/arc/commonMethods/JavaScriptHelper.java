package com.arc.commonMethods;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.arc.testBase.BaseClass;

public class JavaScriptHelper extends BaseClass {
	
	private Logger log= LoggerHelper.getLogger(JavaScriptHelper.class);
	
	public Object executeScript(String script, Object...args)
	{	JSHelper=new JavaScriptHelper();
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script,args);
	}
	
	public void scrollToElement(WebElement element)
	{
		log.info("Scroll to WebElement .."+element);
		executeScript("window.scrollTo(arguments[0],arguments[1])",element.getLocation().x,element.getLocation().y);
	}
	
	public void scrollToElementAndClick(WebElement element)
	{
		scrollToElement(element);
		element.click();
		log.info("Element is clicked  "+element.toString());
		
	}
	
	public void scrollIntoView(WebElement element)
	{
		executeScript("arguments[0].scrollIntoView()",element);
		log.info("Scroll till WebElement");
	}
	
	public void scrollIntoViewAndClick(WebElement element)
	{
		scrollIntoView(element);
		element.click();
		log.info("Scroll till WebElement and clicked");
	}
	
	public void scrollDownVertically()
	{
		executeScript("window.scrollTo(0,document.body.scrollHeight)");
		log.info("Scroll down vertically");
	}
	
	public void scrollUpVertically()
	{
		executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		log.info("Scroll up vertically");
	}
	
	/**
	 * This method will scroll down by pixel
	 * @param pixel
	 */
	public void scrollDownByPixel(int pixel)
	{
		executeScript("window.scrollBy(0,"+pixel+")");
		log.info("Scroll down by  "+pixel);
	}
	
	/**
	 * This method will scroll up by pixel
	 * @param pixel
	 */
	public void scrollUpByPixel(int pixel)
	{
		executeScript("window.scrollBy(0,-"+pixel+")");
		log.info("Scroll down by  "+pixel);
	}
	
	/**
	 * This method will zoom by 100 percent
	 */
	public void zoomInBy100Percent()
	{
		executeScript("document.body.style.zoom='100%'");
	}
	
	/**
	 * This method will zoom by 60 percent
	 */
	public void zoomInBy60Percent()
	{
		executeScript("document.body.style.zoom='60%'");
	}
	
	public void clickElement(WebElement element)
	{
		executeScript("arguments[0].click();",element);
	}

}
