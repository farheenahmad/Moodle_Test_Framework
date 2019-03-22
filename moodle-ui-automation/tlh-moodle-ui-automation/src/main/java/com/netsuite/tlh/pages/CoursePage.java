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
	
	@FindBy(xpath = "//span[contains(text(),'Required: Participation Acknowledgement')]")
	private WebElement participationAcknowledgementLink;
	
	@FindBy(xpath = "//button[contains(text(),'Attempt quiz now')]")
	private WebElement attemptQuizNowButton;
	
	@FindBy(css = "input[type='radio'][value='0']")
	private WebElement quizAnswerOption;
	
	@FindBy(css = "input[value='Finish attempt ...']")
	private WebElement finishAttemptButton;
	
	@FindBy(xpath = "//button[contains(text(),'Submit all and finish')]")
	private WebElement submitAllAndFinishButton;
	
	@FindBy(css = "input[value='Submit all and finish']")
	private WebElement submitAllAndFinishpopup;
	
	@FindBy(xpath = "//a[contains(text(),'Finish review')]")
	private WebElement finishReviewLink;
	
	@FindBy(css = "img[title='Completed: Module 2 Project Checkpoint']")
	private WebElement module2CheckPoint;
	
	@FindBy(css = "img[title='Completed: Module 3 Project Checkpoint']")
	private WebElement module3CheckPoint;
	
	@FindBy(css = "img[title='Completed: Final Project Submission']")
	private WebElement finalProjectCheckPoint;
	
	@FindBy(css = "img[title='Completed: Required: Participation Acknowledgement']")
	private WebElement participationAcknowledgementCheckPoint;
	
	@FindBy(xpath = "//span[text()='Module 2 Project Checkpoint']")
	private WebElement Module2ProjectCheckpointLink;
	
	@FindBy(xpath = "//button[text()='Edit submission']")
	private WebElement EditSubmissionButton;
	
	@FindBy(css = "a[title='Add...']")
	private WebElement AddButton;
	
	@FindBy(css = "//span[text()='Upload a file']")
	private WebElement uploadAFileLink;
	
	@FindBy(css = "input[name='repo_upload_file']")
	private WebElement chooseFileOption;
	
	@FindBy(css = "button[class='fp-upload-btn btn-primary btn']")
	private WebElement uploadThisFileButton;
	
	
	public CoursePage uploadAFile() throws Throwable {
		waitForElementToBeVisibile(uploadAFileLink);
		uploadAFileLink.click();
		waitForElementToBeVisibile(chooseFileOption);
		chooseFileOption.sendKeys(System.getProperty("user.dir")+"/src/test/resources/testdata/TLH2.txt");
		waitForElementToBeVisibile(uploadThisFileButton);
		uploadThisFileButton.click();
		clickSaveChangesButton();
		return this;
	}
	
	public CoursePage clickAddButton() throws Throwable {
		waitForElementToBeVisibile(AddButton);
		AddButton.click();
		return this;
	}
	
	public CoursePage clickEditSubmissionButton() throws Throwable {
		waitForElementToBeVisibile(EditSubmissionButton);
		EditSubmissionButton.click();
		return this;
	}
	
	
	public CoursePage clickModule2ProjectCheckpointLink() throws Throwable {
		waitForElementToBeVisibile(Module2ProjectCheckpointLink);
		Module2ProjectCheckpointLink.click();
		return this;
	}
	
	public CoursePage clickfinishReviewLink() throws Throwable {
		waitForElementToBeVisibile(finishReviewLink);
		finishReviewLink.click();
		return this;
	}
	
	public CoursePage clicksubmitAllAndFinishButton() throws Throwable {
		waitForElementToBeVisibile(submitAllAndFinishButton);
		submitAllAndFinishButton.click();
		waitForElementToBeVisibile(submitAllAndFinishpopup);
		submitAllAndFinishpopup.click();
		return this;
	}
	
	public CoursePage clickfinishAttemptButton() throws Throwable {
		waitForElementToBeVisibile(finishAttemptButton);
		finishAttemptButton.click();
		return this;
	}
	
	public CoursePage clickQuizAnswerOption() throws Throwable {
		waitForElementToBeVisibile(quizAnswerOption);
		quizAnswerOption.click();
		return this;
	}
	
	public CoursePage clickattemptQuizNowButton() throws Throwable {
		waitForElementToBeVisibile(attemptQuizNowButton);
		attemptQuizNowButton.click();
		return this;
	}
	
	public CoursePage clickparticipationAcknowledgementLink() throws Throwable {
		waitForElementToBeVisibile(participationAcknowledgementLink);
		participationAcknowledgementLink.click();
		return this;
	}
	
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
	
	public CoursePage verifyCheckPoints() throws Throwable {
		waitForElementToBeVisibile(module2CheckPoint);
		waitForElementToBeVisibile(module3CheckPoint);
		waitForElementToBeVisibile(finalProjectCheckPoint);
		waitForElementToBeVisibile(participationAcknowledgementCheckPoint);
		
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
