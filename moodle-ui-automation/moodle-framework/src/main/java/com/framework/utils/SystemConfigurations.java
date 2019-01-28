package com.framework.utils;

import java.util.Properties;

/**
 * Configuration of API server.
 * 
 * @author amodak
 *
 */
public class SystemConfigurations {

	private static Properties systemProperty = FileUtils.loadProperties("/config.properties");
	private static final String ENVIRONMENT = System.getProperty("environment") == null ? "qa" : System
			.getProperty("environment").toLowerCase();
	private static String homeUrl;

	/**
	 * 
	 * @param configName
	 *            name of the configuration.
	 * @return value of the configuration.
	 */
	public static String getConfiguration(String configName) {
		return systemProperty.get(configName).toString();
	}

	public static String getEnvironment() {
		return ENVIRONMENT;
	}

	public static String getApplicationUrl() {
		return getConfiguration("app.url");
	}

	public static String getBrowserType() {
		return getConfiguration("browser.type");
	}

	public static void setHomeUrl(String url) {
		homeUrl = url;
	}

	public static String getHomeUrl() {
		return homeUrl;
	}

	public static String getTwilioApplicationUrl() {
		return getConfiguration("twilio.app.url");
	}

	public static String getTLHCustomerApplicationUrl() {
		return getConfiguration("cust.app.url");
	}

}
