package com.netsuite.tlh.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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
	
	@FindBy(xpath = "//p//a[contains(text(),'Turn editing off')]")
	private WebElement turnEditingOffLink;
	
	@FindBy(css = "a[aria-controls='id_activitycompletionheader']")
	private WebElement activityCompletionHeader;
	
	@FindBy(css = "a[aria-controls='id_activitiescompleted']")
	private WebElement activityCompletionHeader2;
	
	@FindBy(id = "id_completion")
	private WebElement completionTrackingDropdown;
	
	@FindBy(id = "id_overall_aggregation")
	private WebElement completionRequirementsDropdown;
	
	@FindBy(css = "input[value='Save changes']")
	private WebElement saveChangesButton;
	
	@FindBy(name = "completionusegrade")
	private WebElement completeGradeCheckBox;
	
	@FindBy(id = "id_completionsubmit")
	private WebElement submitActivityCheckBox;
	
	@FindBy(css = "input[value='Save and return to course']")
	private WebElement saveAndReturnCourseButton;
	
	@FindBy(xpath = "//a[contains(text(),'Select all/none')]")
	private WebElement selectAllLink;
	
	public CoursePage clicksaveAndReturnCourseButton() throws Throwable {
		waitForElementToBeVisibile(saveAndReturnCourseButton);
		saveAndReturnCourseButton.click();
		return this;
	}
	
	public CoursePage clickSaveChangesButton() throws Throwable {
		waitForElementToBeVisibile(saveChangesButton);
		saveChangesButton.click();
		return this;
	}
	
	
	public CoursePage clickcompleteGradeCheckBox() throws Throwable {
		waitForElementToBeVisibile(completeGradeCheckBox);
		completeGradeCheckBox.click();
		return this;
	}
	
	public CoursePage clicksubmitActivityCheckBox() throws Throwable {
		waitForElementToBeVisibile(submitActivityCheckBox);
		submitActivityCheckBox.click();
		return this;
	}
	
	

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
	
	public CoursePage clickturnEditingOffLink() throws Throwable {
		waitForElementToBeVisibile(turnEditingOffLink);
		turnEditingOffLink.click();
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
				("//span[text()='" + courseName + "']/ancestor::div[@class='mod-indent-outer']//div//span[@class='actions']//div//div//div//a"));
		waitForElementToBeClickable(By.xpath
				("//span[text()='" + courseName + "']/ancestor::div[@class='mod-indent-outer']//div//span[@class='actions']//div//div//div//a"));
		BrowserFactory.getDriver().findElement(By.xpath(
				"//span[text()='" + courseName + "']/ancestor::div[@class='mod-indent-outer']//div//span[@class='actions']//div//div//div//a")).click();
		return this;
	}
	
	public CoursePage clickOnEditSettings(String courseName) throws Throwable {
		waitForElementToBePresent(By.xpath
				("//span[text()='" + courseName + "']/ancestor::div[@class='mod-indent-outer']//div//span[@class='actions']//div//div//div//div//a"));
		waitForElementToBeClickable(By.xpath
				("//span[text()='" + courseName + "']/ancestor::div[@class='mod-indent-outer']//div//span[@class='actions']//div//div//div//div//a"));
		BrowserFactory.getDriver().findElement(By.xpath(
				"//span[text()='" + courseName + "']/ancestor::div[@class='mod-indent-outer']//div//span[@class='actions']//div//div//div//div//a")).click();
		return this;
	}
	
	public CoursePage clickActivityCompletionHeader() throws Throwable {
		waitForElementToBeVisibile(activityCompletionHeader);
		waitForElementToBeClickable(activityCompletionHeader);
		activityCompletionHeader.click();
		return this;
	}
	
	public CoursePage clickActivityCompletionHeader2() throws Throwable {
		waitForElementToBeVisibile(activityCompletionHeader2);
		waitForElementToBeClickable(activityCompletionHeader2);
		activityCompletionHeader2.click();
		return this;
	}
	
	public CoursePage clickSelectAll() throws Throwable {
		waitForElementToBeVisibile(selectAllLink);
		waitForElementToBeClickable(selectAllLink);
		selectAllLink.click();
		return this;
	}
	
	public CoursePage selectCompletionTracking(String ActivityDetails) throws Throwable {
		waitForElementToBeVisibile(completionTrackingDropdown);
		waitForElementToBeClickable(completionTrackingDropdown);
		Select sel= new Select(completionTrackingDropdown);
		sel.selectByVisibleText(ActivityDetails);		
		return this;
	}
	
	public CoursePage selectCompletionRequirements(String CompletionRequirement ) throws Throwable {
		waitForElementToBeVisibile(completionRequirementsDropdown);
		waitForElementToBeClickable(completionRequirementsDropdown);
		Select sel= new Select(completionRequirementsDropdown);
		sel.selectByVisibleText(CompletionRequirement);		
		return this;
	}
	

}
