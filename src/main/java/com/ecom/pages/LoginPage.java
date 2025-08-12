package com.ecom.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	public void enterUserName(String username) {
		new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.visibilityOf(userName));
		userName.sendKeys(username);
	}
	public void enterPassword(String pwd) {
		new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(pwd);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
}
