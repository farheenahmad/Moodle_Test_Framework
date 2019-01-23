package com.netsuite.tlh.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import com.framework.exceptions.DriverNotInitializedException;
import com.framework.utils.SystemConfigurations;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;


public class RightNavBar extends BasePage {

	public RightNavBar() throws DriverNotInitializedException {
		super();
	}

	@FindBy(css = "a[title='Health, Wellness, and Fitness: A New Look']")
	private WebElement fitnessPovCourse;
	
	@FindBy(xpath = "//h1[text()='Health, Wellness, and Fitness: A New Look']")
	private WebElement fitnessPovCoursePageHeading;

	public RightNavBar clickOnFitnessPovCourse() throws Throwable {
		waitForElementToBeVisibile(fitnessPovCourse);
		fitnessPovCourse.click();
		return this;
	}
	public RightNavBar verifyUserIsOnOnFitnessPovCoursePage() throws Throwable {
		waitForElementToBeVisibile(fitnessPovCourse);
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(isElementDisplayed(fitnessPovCoursePageHeading),
				"fitnessPovCoursePageHeading is NOT displayed");
		
		softAssert.assertAll();
		fitnessPovCourse.click();
		return this;
	}
	

	

}
