package com.netsuite.tlh.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;

public class HomePage extends MenuBarPage {

	public HomePage() throws DriverNotInitializedException {
		super();
	}

	@FindBy(xpath = "//h1[text()='Advancement Courses']")
	private WebElement CourseLabel;

	@FindBy(xpath = "//span[@class='media-body font-weight-bold']")
	private WebElement HomeIcon;

	public boolean isHomeLabelDisplayed() throws Throwable {
		waitForElementToBeVisibile(CourseLabel);
		return isElementDisplayed(CourseLabel);
	}

	public boolean isHomeIconDisplayed() throws Throwable {
		waitForElementToBeVisibile(HomeIcon);
		return isElementDisplayed(HomeIcon);
	}

	

}
