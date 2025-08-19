 package com.ecom.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	private static Properties props;

	static {
		try {
			props = new Properties();
			FileInputStream fis = new FileInputStream("./src/test/resources/config/config.properties");
			props.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static BrowserType getBrowser() {
		return BrowserType.valueOf(props.getProperty("browser").toUpperCase());
	}
	public static RunEnviroment getRunEnviroment() {
		return RunEnviroment.valueOf(props.getProperty("runenvironment").toUpperCase());
	}
	
	public static String getUrl() {
		return props.getProperty("URL");
	}
}
