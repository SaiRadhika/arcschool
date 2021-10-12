package com.arc.commonMethods;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.arc.testBase.BaseClass;

public class DropDownHelper extends BaseClass {

	private static Logger log = LoggerHelper.getLogger(WaitHelper.class);

	public void selectUsingValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
		log.info("Dropdown value selected by Value.. " + value);
	}

	public String getSelectedValue(WebElement element) {
		Select select = new Select(element);
		String selectedvalue = select.getFirstSelectedOption().getText();
		log.info("Dropdown value selected is.. " + selectedvalue);
		return selectedvalue;
	}

	public void selectUsingIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
		log.info("Dropdown value selected by index.. " + index);
	}

	public void selectUsingVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
		log.info("Dropdown value selected by Visible Text.. " + text);
	}

	public void deselectUsingValue(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
		log.info("Dropdown value deselected by Value.. " + value);
	}

	public void deselectUsingIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
		log.info("Dropdown value deselected by index.. " + index);
	}

	public void deselectUsingVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
		log.info("Dropdown value deselected by Visible Text.. " + text);
	}

	public List<String> getAllDropdownData(WebElement element) {
		Select select = new Select(element);
		List<WebElement> elementList = select.getOptions();
		List<String> valueList = new LinkedList<String>();
		for (WebElement ele : elementList) {
			valueList.add(ele.getText());
			log.info(ele.getText());
		}
		log.info("All elements added to Linked List");
		return valueList;
	}

}
