package com.framework.base;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.framework.exceptions.DriverNotInitializedException;

public class BrowserFactory {
	public static Logger log = Logger.getLogger(BrowserFactory.class);
	private static WebDriver Driver;

	private BrowserFactory() {
	}

	// To initialize the Driver
	public static void initializeBrowser(Browser browser, String appUrl) {
		if (Driver == null) {
			switch (browser) {
			case firefox:
				
				WebDriverManager.firefoxdriver().setup();
				
				Driver = new FirefoxDriver();
				break;
			case chrome:
				// System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")
				// + "/src/test/resources/chromedriver.exe");

				WebDriverManager.chromedriver().setup();
				
				Map<String, Object> prefs = new HashMap<String, Object>();
				String download_folder = "src/test/resources/testdata/downloads";
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				prefs.put("profile.default_content_settings.popups", 0);
				prefs.put("download.default_directory", System.getProperty("user.dir") + "/" + download_folder);

				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("disable-infobars");
				Driver = new ChromeDriver(options);
				break;
			}

			Driver.manage().window().maximize();
			Driver.get(appUrl);
			log.info("Browser Initialized...");
		}
	}

	public static WebDriver getDriver() throws DriverNotInitializedException {
		if (Driver != null) {
			return Driver;
		} else {
			throw new DriverNotInitializedException("WebDriver not initialized");
		}
	}

	public static void closeBrowser() {
		if (Driver != null) {
			Driver.close();
			log.info("Browser closed...");
		}
	}

	public static void quitDriver() {
		//if (Driver != null) {
			//Driver.quit();
			log.info("Driver shut down.. All Browsers closed...");
		//}
	}
}