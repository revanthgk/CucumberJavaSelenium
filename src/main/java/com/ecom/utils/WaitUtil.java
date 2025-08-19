package com.ecom.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ecom.factory.DriverFactory;

public class WaitUtil {
	private static final int Default_Wait_Time =10;
	
	public static WebElement waitForVisible(WebDriver driver, WebElement webElement) {
		return new WebDriverWait(driver, Duration.ofSeconds(Default_Wait_Time))
        .until(ExpectedConditions.visibilityOf(webElement));
	}

}
