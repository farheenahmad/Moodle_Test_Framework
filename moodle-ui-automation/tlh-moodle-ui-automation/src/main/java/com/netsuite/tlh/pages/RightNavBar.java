package com.netsuite.tlh.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import com.framework.base.BrowserFactory;
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
	
	@FindBy(css = "i[class='icon fa fa-file-zip-o fa-fw navicon']")
	private WebElement backUpLink;
	
	@FindBy(xpath = "//h1[text()='Backup course: FITNESS-POV']")
	private WebElement backUpCoursePageHeading;
	
	@FindBy(xpath = "//a[text()='Participants']")
	private WebElement participantsLink;
	
	@FindBy(xpath = "//p//a[text()='Courses']")
	private WebElement coursesLink;
	
	@FindBy(xpath = "//a[contains(text(),'Assignments')]")
	private WebElement assignmentsLink;
	
	@FindBy(xpath = "//*[text()='Facilitation Manager Dashboard']")
	private WebElement facilitationManagerDashboardLink;
	
	

	public RightNavBar clickOnFitnessPovCourse() throws Throwable {
		waitForElementToBeVisibile(fitnessPovCourse);
		fitnessPovCourse.click();
		return this;
	}
	public RightNavBar verifyUserIsOnFitnessPovCoursePage() throws Throwable {
		waitForElementToBeVisibile(fitnessPovCourse);
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(isElementDisplayed(fitnessPovCoursePageHeading),
				"fitnessPovCoursePageHeading is NOT displayed");
		softAssert.assertAll();
		return this;
	}
	
	public RightNavBar clickOnBackupLink() throws Throwable {
		waitForElementToBeVisibile(backUpLink);
		backUpLink.click();
		return this;
	}

	public RightNavBar verifyUserIsOnBackupCoursePage() throws Throwable {
		waitForElementToBeVisibile(backUpCoursePageHeading);
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(isElementDisplayed(backUpCoursePageHeading),
				"backUpCoursePageHeading is NOT displayed");
		softAssert.assertAll();
		return this;
	}
	
	public RightNavBar clickOnParticipants() throws Throwable {
		waitForElementToBeVisibile(participantsLink);
		participantsLink.click();
		return this;
	}
	
	public RightNavBar clickOnCourses() throws Throwable {
		BrowserFactory.getDriver().navigate().refresh();
		waitForElementToBeVisibile(coursesLink);
		waitForElementToBeClickable(coursesLink);
		Actions act= new Actions(BrowserFactory.getDriver());
		act.moveToElement(coursesLink).click().build().perform();
		//coursesLink.click();
		return this;
	}

	public RightNavBar clickOnAssignments() throws Throwable {
		
		waitForElementToBeVisibile(assignmentsLink);
		waitForElementToBeClickable(assignmentsLink);
		assignmentsLink.click();
		return this;
	}
	
public RightNavBar clickOnFacilitationManagerDashboardLink() throws Throwable {
		
		waitForElementToBeVisibile(facilitationManagerDashboardLink);
		waitForElementToBeClickable(facilitationManagerDashboardLink);
		facilitationManagerDashboardLink.click();
		return this;
	}
}
