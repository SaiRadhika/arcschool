package com.arc.commonMethods;

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
}
