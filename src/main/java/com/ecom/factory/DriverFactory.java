package com.ecom.factory;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import com.ecom.utils.BrowserType;
import com.ecom.utils.ConfigReader;
import com.ecom.utils.RunEnviroment;

public class DriverFactory {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private static ThreadLocal<String> scenarioName = new ThreadLocal<>();

    public static void setScenarioName(String name) {
        scenarioName.set(name);
    }
	public WebDriver initBroswer() {
		BrowserType browser = ConfigReader.getBrowser();
		RunEnviroment env = ConfigReader.getRunEnviroment();
		if(env == RunEnviroment.LOCAL) {
			if (browser == BrowserType.CHROME) {
				driver.set(new ChromeDriver());
			} else if (browser == BrowserType.FIREFOX) {
				driver.set(new FirefoxDriver());
			} else if (browser == BrowserType.SAFARI) {
				driver.set(new SafariDriver());
			} else {
				throw new IllegalArgumentException("Unsupported browser: " + browser);
			}
		} else if(env == RunEnviroment.SAUCELABS ) {
			try {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("browserName", browser.name().toLowerCase());
				capabilities.setCapability("browserVersion", "latest");
				
				Map<String, Object> sauceOptions = new HashMap<>();
	            sauceOptions.put("platformName", "Windows 11");
	            sauceOptions.put("build", "BDD Suite Build");
	            sauceOptions.put("name", scenarioName.get());
	            sauceOptions.put("tunnelIdentifier", "my-sauce-tunnel");

	            capabilities.setCapability("sauce:options", sauceOptions);

	            String sauceUrl = "https://" + System.getenv("SAUCE_USERNAME") + ":" +
	                    System.getenv("SAUCE_ACCESS_KEY") + "@ondemand.saucelabs.com/wd/hub";

	            driver.set(new RemoteWebDriver(new URL(sauceUrl), capabilities));
	            
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		return driver.get();
	}
}
