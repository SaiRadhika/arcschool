package com.arc.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.arc.testBase.BaseClass;

public class LoginPageObjects extends BaseClass {
	@FindBy(xpath = "//button[@class='agree-button']")
	WebElement acceptAndClose;

	@FindBy(xpath = "//*[@id='login-box-trigger-lg']")
	WebElement loginLink;

	@FindBy(xpath = "//*[@class='form-control login-input-box only_login ng-pristine ng-untouched ng-empty ng-valid-email ng-invalid ng-invalid-required']")
	WebElement emailAddress;

	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/form[1]/div[7]/input[1]")
	WebElement password;

	@FindBy(xpath = "//button[@class='btn accept_and_close_btn']")
	WebElement acceptAndCloseonLoginPage;

	@FindBy(xpath = "//button[@type='submit'][text()='Log In']")
	WebElement loginButton;

	public LoginPageObjects() {
		PageFactory.initElements(driver, this);
	}

	// Login into Application

	public String checkLoginPageTitle() {
		return driver.getTitle();
	}

	public HomePageObjects login(String email, String pass) {
		waithelper.WaitForElementClickable(acceptAndClose, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		acceptAndClose.click();
		waithelper.WaitForElementClickable(loginLink, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		loginLink.click();
		waithelper.WaitForElementClickable(acceptAndCloseonLoginPage,
				Integer.parseInt(prop.getProperty("explicitTime")), 2);
		acceptAndCloseonLoginPage.click();

		emailAddress.sendKeys(email);
		password.sendKeys(pass);
		waithelper.WaitForElementClickable(loginButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		loginButton.click();

		return new HomePageObjects();
	}

	// This method will login into application in between the test suites

	public HomePageObjects loginLater(String email, String pass) {
		waithelper.WaitForElementClickable(loginLink, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		loginLink.click();
		emailAddress.sendKeys(email);
		password.sendKeys(pass);
		waithelper.WaitForElementClickable(loginButton, Integer.parseInt(prop.getProperty("explicitTime")), 2);
		loginButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HomePageObjects();
	}

}
