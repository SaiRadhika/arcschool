package com.arc.commonMethods;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.arc.testBase.BaseClass;

public class ActionsHelper extends BaseClass {

	public ActionsHelper() {
		action = new Actions(driver);

	}

	public void mouseOverElement(WebElement ele) {
		action.moveToElement(ele).build().perform();

	}

	public void mouseOverElementAndClick(WebElement ele) {

		action.moveToElement(ele).click().build().perform();

	}
	
	public void mouseOverElementAndDoubleClick(WebElement ele) {

		action.doubleClick(ele).build().perform();

	}
	public void dragAndDrop(WebElement ele,int x, int y) {

		action.dragAndDropBy(ele, x, y);
		action.build().perform();

	}
	
	public void clickRandomlyOnPage() throws AWTException
	{
		Robot robot = new Robot();

		robot.mouseMove(50,50);

		action.click().build().perform();

		robot.mouseMove(200,70);

		action.click().build().perform();
	}
}
