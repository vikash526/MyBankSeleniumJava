package com.mybank.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {

	Properties properties;
	String path = "C:\\Users\\vikash\\eclipse-workspace\\MyBank\\Configuration\\config.properties";

	public readConfig() {
		properties = new Properties();
		try {
			FileInputStream fileInputStream = new FileInputStream(path);
			properties.load(fileInputStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getBaseUrl() {
		String baseUrl = properties.getProperty("baseUrl");
		if (baseUrl != null) {
			return baseUrl;
		} else {
			System.out.println("url not found");
			return null;
		}
	}

	public String getBrowser() {
		String browser = properties.getProperty("browser");
		if (browser != null) {
			return browser;
		} else {
			System.out.println("url not found");
			return null;
		}
	}
	public String user() {
		return properties.getProperty("user");
	}
	public String password() {
		return properties.getProperty("password");
	}

}
