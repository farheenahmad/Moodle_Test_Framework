package com.netsuite.tlh.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.base.BrowserFactory;
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
	
	@FindBy(xpath = "//p//a[contains(text(),'Turn editing on')]")
	private WebElement turnEditingOnLink;
	
	@FindBy(xpath = "a[aria-controls='id_activitycompletionheader']")
	private WebElement activityCompletionHeader;
	

	public CoursePage clickManageCourseButton() throws Throwable {
		waitForElementToBeVisibile(manageCourseButton);
		manageCourseButton.click();
		return this;
	}
	
	public CoursePage clickturnEditingOnLink() throws Throwable {
		waitForElementToBeVisibile(turnEditingOnLink);
		turnEditingOnLink.click();
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
	
	public CoursePage clickOnEditLinkforCourse(String courseName) throws Throwable {
		waitForElementToBePresent(By.xpath
				("//span[starts-with(@data-value,'" + courseName + "')]/ancestor::div[@class='mod-indent-outer']//div//span[@class='actions']"));
		waitForElementToBeClickable(By.xpath
				("//span[starts-with(@data-value,'" + courseName + "')]/ancestor::div[@class='mod-indent-outer']//div//span[@class='actions']"));
		BrowserFactory.getDriver().findElement(By.xpath(
				"//span[starts-with(@data-value,'" + courseName + "')]/ancestor::div[@class='mod-indent-outer']//div//span[@class='actions']")).click();
		return this;
	}
	
	public CoursePage clickOnEditSettings(String courseName) throws Throwable {
		waitForElementToBePresent(By.xpath
				("//span[starts-with(@data-value,'" + courseName + "')]/ancestor::div[@class='mod-indent-outer']//div//span[@class='actions']//div//div//div//div//a//*[contains(text(),'Edit settings')]"));
		waitForElementToBeClickable(By.xpath
				("//span[starts-with(@data-value,'" + courseName + "')]/ancestor::div[@class='mod-indent-outer']//div//span[@class='actions']//div//div//div//div//a//*[contains(text(),'Edit settings')]"));
		BrowserFactory.getDriver().findElement(By.xpath(
				"//span[starts-with(@data-value,'" + courseName + "')]/ancestor::div[@class='mod-indent-outer']//div//span[@class='actions']//div//div//div//div//a//*[contains(text(),'Edit settings')]")).click();
		return this;
	}
	
	public CoursePage clickActivityCompletionHeader() throws Throwable {
		waitForElementToBeVisibile(activityCompletionHeader);
		waitForElementToBeClickable(activityCompletionHeader);
		activityCompletionHeader.click();
		return this;
	}

}
