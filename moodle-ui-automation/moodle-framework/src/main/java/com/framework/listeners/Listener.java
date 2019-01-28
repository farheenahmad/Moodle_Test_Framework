package com.framework.listeners;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.framework.base.BrowserFactory;
import com.framework.exceptions.DriverNotInitializedException;

public class Listener implements ITestListener {
	public static Logger log = Logger.getLogger(Listener.class);

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			captureScreenShot(result);
		} catch (WebDriverException | DriverNotInitializedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult result) {
		log.info("Starting : " + result.getMethod().getRealClass().getSimpleName() + "-" + result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("Completed successfully : " + result.getMethod().getRealClass().getSimpleName() + "-"
				+ result.getMethod().getMethodName());
	}

	public void captureScreenShot(ITestResult result) throws WebDriverException, DriverNotInitializedException {
		String destDir = System.getProperty("user.dir") + "/" + "test-output/Screenshots";
		String failMethod = result.getMethod().getRealClass().getSimpleName() + "_" + result.getMethod().getMethodName();
		// To capture screenshot
		File scrFile = ((TakesScreenshot) BrowserFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ss");

		// To create folder to store screenshots
		new File(destDir).mkdirs();
		String destFile = failMethod + "_" + dateFormat.format(new Date()) + ".png";

		try {
			// Store file at destination folder location
			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
