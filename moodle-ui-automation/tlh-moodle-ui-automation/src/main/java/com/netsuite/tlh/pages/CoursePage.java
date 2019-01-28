package com.netsuite.tlh.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;

public class CoursePage extends MenuBarPage {

	public CoursePage() throws DriverNotInitializedException {
		super();
	}

	@FindBy(xpath = "//button[text()='Manage courses']")
	private WebElement manageCourseButton;

	@FindBy(xpath = "//a[text()='AutomationMoodleCourse']/following-sibling::div[@class='float-right']//a//i[@title='Delete']")
	private WebElement deleteCourseButton;
	
	@FindBy(xpath = "//button[text()='Delete']")
	private WebElement deleteButton;
	
	@FindBy(xpath = "//button[text()='Continue']")
	private WebElement continueButton;
	

	public CoursePage clickManageCourseButton() throws Throwable {
		waitForElementToBeVisibile(manageCourseButton);
		manageCourseButton.click();
		return this;
	}
	
	public CoursePage clickDeleteCourseButton() throws Throwable {
		waitForElementToBeVisibile(deleteCourseButton);
		deleteCourseButton.click();
		return this;
	}

	public CoursePage clickDeleteButton() throws Throwable {
		waitForElementToBeVisibile(deleteButton);
		deleteButton.click();
		return this;
	}
	
	public CoursePage clickContinueButton() throws Throwable {
		waitForElementToBeVisibile(continueButton);
		continueButton.click();
		return this;
	}

	public CoursePage clickOnRespectiveUser() throws Throwable {
		waitForElementToBeVisibile(deleteCourseButton);
		deleteCourseButton.click();
		return this;
	}

}
