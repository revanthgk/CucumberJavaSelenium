package com.ecom.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.utils.WaitUtil;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	private WebElement userName;

	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath = "//*[text()=' Login ']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//*[text()='Invalid credentials']")
	private WebElement invalidCredentials;
	
	public void enterUserName(String username) {
		WaitUtil.waitForVisible(driver, userName).sendKeys(username);
	}
	public void enterPassword(String pwd) {
		WaitUtil.waitForVisible(driver, password).sendKeys(pwd);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public String getInvalidCredentialsText() {
		WaitUtil.waitForVisible(driver, invalidCredentials);
		return invalidCredentials.getText().toString();
	}
}
